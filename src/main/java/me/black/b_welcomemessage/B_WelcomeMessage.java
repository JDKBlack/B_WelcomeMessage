package me.black.b_welcomemessage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class B_WelcomeMessage extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled");

        saveDefaultConfig();

        //REGISTER EVENT
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");

        reloadConfig();
    }

    @EventHandler
    public void PlayerJoin (PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage(getConfig().getString("joinmessage").replace("%player%", p.getName()));

        //TITLE
        p.sendTitle("" + getConfig().getString("titlemessage").replace("%player%", p.getName()),
                "" + getConfig().getString("subtitlemessage").replace("%player%", p.getName()));
    }

    @EventHandler
    public void PlayerQuit (PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(getConfig().getString("quitmessage").replace("%player%", p.getName()));
    }
}
