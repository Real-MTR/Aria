package xyz.kiradev.aria.example;

/*
 *
 * Aria is a property of Kira-Development-Team
 * It was created @ 22/09/2023
 * Coded by the founders of Kira-Development-Team
 * EmpireMTR & Vifez
 *
 */

import org.bukkit.plugin.java.JavaPlugin;
import xyz.kiradev.aria.Aria;

public class Plugin extends JavaPlugin {

    private Aria aria;

    @Override
    public void onEnable() {
        this.aria = new Aria(this, new Adapter(), this.getServer().getScoreboardManager().getNewScoreboard());
    }
}
