package org.lordalex.bedwarshard;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.lordalex.bedwarshard.Events.OnJoin;
import org.lordalex.bedwarshard.config.MapConfig;
import org.lordalex.bedwarshard.config.Game;
import org.lordalex.bedwarshard.Utils.YmlParser;

import java.io.File;

public final class BedWarsHard extends JavaPlugin {
    private static Plugin instance;
    private static MapConfig mapConfig;
    private static Game game;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
        File file = new File("mapConfig.yml");
        mapConfig = YmlParser.parseMap(file);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static Plugin getInstance(){
        return instance;
    }

    public static void setInstance(Plugin instance) {
        BedWarsHard.instance = instance;
    }

    public static MapConfig getMapConfig() {
        return mapConfig;
    }

    public static void setMapConfig(MapConfig mapConfig) {
        BedWarsHard.mapConfig = mapConfig;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        BedWarsHard.game = game;
    }
}
