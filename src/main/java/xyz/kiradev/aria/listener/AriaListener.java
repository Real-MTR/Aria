package xyz.kiradev.aria.listener;

/*
 *
 * Aria is a property of Kira-Development-Team
 * It was created @ 22/09/2023
 * Coded by the founders of Kira-Development-Team
 * EmpireMTR & Vifez
 *
 */

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.kiradev.aria.Aria;

public class AriaListener implements Listener {

    private final Aria aria;

    public AriaListener(Aria aria) {
        this.aria = aria;

        aria.getPlugin().getServer().getPluginManager().registerEvents(this, aria.getPlugin());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Aria.getInstance().getHandler().setNameTag(player, player, Aria.getInstance().getAdapter().getPrefix(player), Aria.getInstance().getAdapter().getSuffix(player));

        Aria.getInstance().getPlugin().getServer().getScheduler().runTaskLater(Aria.getInstance().getPlugin(), () -> {
            for (Player online : Aria.getInstance().getPlugin().getServer().getOnlinePlayers()) {
                if(player.equals(online)) continue;

                Aria.getInstance().getHandler().setNameTag(player, online, Aria.getInstance().getAdapter().getPrefix(player), Aria.getInstance().getAdapter().getSuffix(player));
                Aria.getInstance().getHandler().setNameTag(online, player, Aria.getInstance().getAdapter().getPrefix(player), Aria.getInstance().getAdapter().getSuffix(player));
            }
        }, 10L);
    }
}
