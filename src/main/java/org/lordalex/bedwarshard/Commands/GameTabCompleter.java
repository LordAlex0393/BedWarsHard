package org.lordalex.bedwarshard.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if (args[0].equalsIgnoreCase("flag") && args.length < 3) {
            list.add("kick-on-lose");
            list.add("protected-world");
            list.add("bronze-rate");
            list.add("iron-rate");
            list.add("gold-rate");
            list.add("final-dm");
            list.add("edit-shop");
            list.add("limit-players");
            list.add("game-length");
            list.add("starting-delay");
            list.add("bed-drop");
        } else if(args.length < 2){
            list.add("start");
            list.add("stop");
            list.add("kick");
            list.add("list");
            list.add("flag");
        }
        return list;
    }
}
