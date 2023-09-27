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
import xyz.kiradev.aria.adapter.AriaAdapter;

public class AriaListener implements Listener {

    private final Aria aria;

    public AriaListener(Aria aria) {
        this.aria = aria;

        aria.getPlugin().getServer().getPluginManager().registerEvents(this, aria.getPlugin());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        AriaAdapter adapter = Aria.getInstance().getAdapter();
        Aria.getInstance().getHandler().setNameTag(player, player, Aria.getInstance().getAdapter().getPrefix(player), Aria.getInstance().getAdapter().getSuffix(player));

        Aria.getInstance().getPlugin().getServer().getScheduler().runTaskLater(Aria.getInstance().getPlugin(), () -> {
            if(adapter.getViewer(player) == null) {
                for (Player online : Aria.getInstance().getPlugin().getServer().getOnlinePlayers()) {
                    if (player.equals(online)) continue;
                    Aria.getInstance().getHandler().setNameTag(player,
                            online,
                            adapter.getPrefix(player),
                            adapter.getSuffix(player));
                    Aria.getInstance().getHandler().setNameTag(online,
                            player,
                            adapter.getPrefix(player),
                            adapter.getSuffix(player));
                }
            } else {
                Aria.getInstance().getHandler().setNameTag(player,
                        adapter.getViewer(player),
                        adapter.getPrefix(player),
                        adapter.getSuffix(player));
                Aria.getInstance().getHandler().setNameTag(adapter.getViewer(player),
                        player,
                        adapter.getPrefix(player),
                        adapter.getSuffix(player));
            }
        }, 10L);
    }
}
