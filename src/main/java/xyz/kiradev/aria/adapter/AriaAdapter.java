package xyz.kiradev.aria.adapter;

/*
 *
 * Aria is a property of Kira-Development-Team
 * It was created @ 22/09/2023
 * Coded by the founders of Kira-Development-Team
 * EmpireMTR & Vifez
 *
 */

import org.bukkit.entity.Player;

public interface AriaAdapter {
    String getPrefix(Player player);
    String getSuffix(Player player);
    default void setViewer(Player player, Player viewer) {}
    default Player getViewer(Player player) {
        return null;
    }
}
