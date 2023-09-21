package xyz.kiradev.aria;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import xyz.kiradev.aria.adapter.AriaAdapter;
import xyz.kiradev.aria.handler.AriaHandler;
import xyz.kiradev.aria.listener.AriaListener;

@Getter @Setter
public final class Aria {

    private static Aria aria;

    private final JavaPlugin plugin;
    private final AriaAdapter adapter;
    private final AriaHandler handler;
    private final Scoreboard scoreboard;

    public Aria(JavaPlugin plugin, AriaAdapter adapter, Scoreboard scoreboard) {
        aria = this;

        this.plugin = plugin;
        this.adapter = adapter;
        this.handler = new AriaHandler(aria);
        this.scoreboard = scoreboard;

        new AriaListener(aria);
    }

    public static Aria getInstance() {
        if(aria == null) {
            throw new UnsupportedOperationException("Aria instance is null");
        }
        return aria;
    }
}