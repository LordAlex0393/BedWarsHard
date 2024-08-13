package org.lordalex.bedwarshard.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;

import java.awt.*;
import java.text.DecimalFormat;

public class GameCommands implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args == null || args.length < 1) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                printCommandInfo(p);
                return true;
            }
        }
        else if (args[0].equalsIgnoreCase("flag")) {
            if (args.length > 1) {
                if(args[1].equalsIgnoreCase("kick-on-lose")){
                    if(args[2].equalsIgnoreCase("on")){
                        BedWarsHard.getGame().setKickOnLose(true);
                    }
                    else if(args[2].equalsIgnoreCase("off")){
                        BedWarsHard.getGame().setKickOnLose(true);
                    }

                }





            }
            else if (sender instanceof Player) {
                Player p = (Player) sender;
                printFlagInfo(p);
            }
        }


        return true;
    }




    private static void printCommandInfo(Player p) {
        p.sendMessage(ColorUtil.getMessage("&e---------- &dУправление игрой&f (&e/game&f)&e ---------------"));
        p.sendMessage(ColorUtil.getMessage("&e/game&7 start&f: запустить игру"));
        p.sendMessage(ColorUtil.getMessage("&e/game&7 stop&f: остановить игру"));
        p.sendMessage(ColorUtil.getMessage("&e/game&7 kick <ник игрока>&f: выкинуть игрока в лобби"));
        p.sendMessage(ColorUtil.getMessage("&e/game&7 list&f: список игроков на сервере"));
        p.sendMessage(ColorUtil.getMessage("&e/game&7 flag&f: управление настройками сервера"));
    }

    private static void printFlagInfo(Player p){
        String yes = "&aвключено";
        String no = "&cвыключено";
        String kickOnLose = "&dkick-on-lose&f (&7Кикать с сервера после поражения&f): ";
        kickOnLose += BedWarsHard.getGame().isKickOnLose()? yes : no;



        String protectedWorld = "&dprotected-world&f (&7Защита мира от ломания&f): ";
        protectedWorld += BedWarsHard.getGame().isProtectedWorld()? yes : no;

        String editShop = "&dedit-shop&f (&7Позволяет редактировать магазин /bw editshop&f): ";
        editShop += BedWarsHard.getGame().isEditShop()? yes : no;

        String limitPlayers = "&dlimit-players&f (&7Отключить лимит игроков в команде&f): ";
        limitPlayers += BedWarsHard.getGame().isLimitPlayers()? yes : no;

        DecimalFormat decimalFormat = new DecimalFormat( "#.#" );

        p.sendMessage(ColorUtil.getMessage("&e---------- &dНастройки сервера&f (&e/game flag&f)&e ---------------"));
        p.sendMessage(ColorUtil.getMessage(kickOnLose));
        p.sendMessage(ColorUtil.getMessage(protectedWorld));
        p.sendMessage(ColorUtil.getMessage("&dbronze-rate&f (&7Скорость генерации бронзы&f): " + decimalFormat.format(BedWarsHard.getGame().getBronzeRate())));
        p.sendMessage(ColorUtil.getMessage("&diron-rate&f (&7Скорость генерации железа&f): " + decimalFormat.format(BedWarsHard.getGame().getIronRate())));
        p.sendMessage(ColorUtil.getMessage("&dgold-rate&f (&7Скорость генерации золота&f): " + decimalFormat.format(BedWarsHard.getGame().getGoldRate())));
        p.sendMessage(ColorUtil.getMessage("&dfinal-dm&f (&7Финальный дезматч в минутах, если живы все кровати&f): " + BedWarsHard.getGame().getFinalDM()));
        p.sendMessage(ColorUtil.getMessage(editShop));
        p.sendMessage(ColorUtil.getMessage(limitPlayers));
        p.sendMessage(ColorUtil.getMessage("&dgame-length&f (&7Установить длительность игры (минуты)&f): " + BedWarsHard.getGame().getGameLength()));
    }
}
