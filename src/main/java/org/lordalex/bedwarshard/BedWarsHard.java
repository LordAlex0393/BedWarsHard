package org.lordalex.bedwarshard;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.lordalex.bedwarshard.config.BedMap;
import org.lordalex.bedwarshard.config.YmlParser;

import java.io.File;

public final class BedWarsHard extends JavaPlugin {
    private static Plugin instance;
    public static BedMap bedMap;

    @Override
    public void onEnable() {
        instance = this;
        File file = new File("mapConfig.yml");
        bedMap = YmlParser.parseMap(file);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Plugin getInstance(){
        return instance;
    }
}
