package xyz.kiradev.aria.example;

/*
 *
 * Aria is a property of Kira-Development-Team
 * It was created @ 22/09/2023
 * Coded by the founders of Kira-Development-Team
 * EmpireMTR & Vifez
 *
 */

import org.bukkit.entity.Player;
import xyz.kiradev.aria.adapter.AriaAdapter;

public class Adapter implements AriaAdapter {
    @Override
    public String getPrefix(Player player) {
        return "&csupports cc";
    }

    @Override
    public String getSuffix(Player player) {
        return "&csupports cc";
    }
}
