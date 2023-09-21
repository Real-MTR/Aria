package xyz.kiradev.aria.handler;

/*
 *
 * Aria is a property of Kira-Development-Team
 * It was created @ 22/09/2023
 * Coded by the founders of Kira-Development-Team
 * EmpireMTR & Vifez
 *
 */

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import xyz.kiradev.aria.Aria;

public class AriaHandler {

    private final Aria aria;

    public AriaHandler(Aria aria) {
        this.aria = aria;
    }

    public void setNameTag(Player player, Player target, String prefix, String suffix) {
        Scoreboard scoreboard = player.getScoreboard();

        if (scoreboard.equals(aria.getScoreboard())) {
            scoreboard = aria.getPlugin().getServer().getScoreboardManager().getNewScoreboard();

            player.setScoreboard(scoreboard);
        }

        Team team = scoreboard.getTeam(getTeamName(target));
        if (team == null) {
            team = scoreboard.registerNewTeam(getTeamName(target));
        }

        team.setPrefix(ChatColor.translateAlternateColorCodes('&', prefix));
        team.setSuffix(ChatColor.translateAlternateColorCodes('&', suffix));

        if (!team.hasEntry(getTeamName(target))) {
            team.addEntry(target.getName());
        }
    }

    private String getTeamName(Player player) {
        String teamName = "nt_" + player.getName();

        if (teamName.length() > 16) teamName = teamName.substring(0, 16);

        return teamName;
    }
}