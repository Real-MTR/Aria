package xyz.kiradev.aria.example;

/*
 *
 * Aria is a property of Kira-Development-Team
 * It was created @ 22/09/2023
 * Coded by the founders of Kira-Development-Team
 * EmpireMTR & Vifez
 *
 */

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.kiradev.aria.adapter.AriaAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Adapter implements AriaAdapter {

    private Map<UUID, UUID> playerMap = new HashMap<>();

    @Override
    public String getPrefix(Player player) {
        return "&csupports cc";
    }

    @Override
    public String getSuffix(Player player) {
        return "&csupports cc";
    }

    @Override
    public void setViewer(Player player, Player viewer) {
        playerMap.put(player.getUniqueId(), viewer.getUniqueId());
    }

    @Override
    public Player getViewer(Player player) {
        return Bukkit.getPlayer(playerMap.get(player.getUniqueId()));
    }
}
