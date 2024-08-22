package org.lordalex.bedwarshard.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.Utils.GameUtil;
import org.lordalex.bedwarshard.Utils.ResourceUtil;

import java.util.List;

public class BedWarsCommands implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args == null || args.length < 1) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                printBWCommandInfo(p);
            }
        } else if (args[0].equalsIgnoreCase("clear")) {
            ResourceUtil.clearAllEntities();
        }
        return true;
    }

    private static void printBWCommandInfo(Player player) {
        String COMMAND_LIST = ColorUtil.getMessage("&e---------- &dУправление игрой&f (&e/bw&f)&e ----------\n" +
                "&e/bw &7clear&f: очистить карту BedWars\n" +
                "&e/bw &7trader&f: заспавнить торговца\n" +
                "&e/bw &7kit&f: получить тестовый набор");
        player.sendMessage(COMMAND_LIST);
    }
}