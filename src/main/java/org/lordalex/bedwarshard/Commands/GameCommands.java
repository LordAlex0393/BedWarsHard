package org.lordalex.bedwarshard.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.Utils.GameUtil;

import java.text.DecimalFormat;


public class GameCommands implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args == null || args.length < 1) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                printCommandInfo(p);
                return true;
            }
        } else if (args[0].equalsIgnoreCase("start")) {
            GameUtil.start();
        } else if (args[0].equalsIgnoreCase("stop")) {
            GameUtil.stop();
        } else if (args[0].equalsIgnoreCase("kick")) {
            if (args.length > 1 && args[1] != null) {
                Bukkit.getPlayer(args[1]).kickPlayer("Вы были кикнуты управляющим");
            }
        } else if (args[0].equalsIgnoreCase("list") && sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage("Онлайн игроков на сервере: " + Bukkit.getServer().getWorld("world").getPlayers().size());
            for (Player all : Bukkit.getServer().getWorld("world").getPlayers()) {
                p.sendMessage(all.getName());
            }
        } else if (args[0].equalsIgnoreCase("flag")) {
            if (args.length > 1) {
                if (args[1].equalsIgnoreCase("kick-on-lose") && args.length == 3) {
                    if (args[2].equalsIgnoreCase("on")) {
                        BedWarsHard.getGame().setKickOnLose(true);
                    } else if (args[2].equalsIgnoreCase("off")) {
                        BedWarsHard.getGame().setKickOnLose(true);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&fДопустимые значения для флага: &dkick-on-lose&f:&a on&f,&c off"));
                    }
                } else if (args[1].equalsIgnoreCase("protected-world") && args.length == 3) {
                    if (args[2].equalsIgnoreCase("on")) {
                        BedWarsHard.getGame().setProtectedWorld(true);
                    } else if (args[2].equalsIgnoreCase("off")) {
                        BedWarsHard.getGame().setProtectedWorld(true);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&fДопустимые значения для флага: &dprotected-world&f:&a on&f,&c off"));
                    }
                } else if (args[1].equalsIgnoreCase("edit-shop") && args.length == 3) {
                    if (args[2].equalsIgnoreCase("on")) {
                        BedWarsHard.getGame().setEditShop(true);
                    } else if (args[2].equalsIgnoreCase("off")) {
                        BedWarsHard.getGame().setEditShop(true);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&fДопустимые значения для флага: &dedit-shop&f:&a on&f,&c off"));
                    }
                } else if (args[1].equalsIgnoreCase("limit-players") && args.length == 3) {
                    if (args[2].equalsIgnoreCase("on")) {
                        BedWarsHard.getGame().setLimitPlayers(true);
                    } else if (args[2].equalsIgnoreCase("off")) {
                        BedWarsHard.getGame().setLimitPlayers(true);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&fДопустимые значения для флага: &dlimit-players&f:&a on&f,&c off"));
                    }
                } else if (args[1].equalsIgnoreCase("bed-drop") && args.length == 3) {
                    if (args[2].equalsIgnoreCase("on")) {
                        BedWarsHard.getGame().setBedDrop(true);
                    } else if (args[2].equalsIgnoreCase("off")) {
                        BedWarsHard.getGame().setBedDrop(true);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&fДопустимые значения для флага: &dbed-drop&f:&a on&f,&c off"));
                    }
                } else if (args[1].equalsIgnoreCase("bronze-rate") && args.length == 3) {
                    float input = Float.parseFloat(args[2]);
                    if (input > 0.25f && input < 4.0f) {
                        BedWarsHard.getGame().setBronzeRate(input);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&cЗначение флага может быть только в границах от 0.25 до 4.0"));
                    }
                } else if (args[1].equalsIgnoreCase("iron-rate") && args.length == 3) {
                    float input = Float.parseFloat(args[2]);
                    if (input > 0.25f && input < 4.0f) {
                        BedWarsHard.getGame().setIronRate(input);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&cЗначение флага может быть только в границах от 0.25 до 4.0"));
                    }
                } else if (args[1].equalsIgnoreCase("gold-rate") && args.length == 3) {
                    float input = Float.parseFloat(args[2]);
                    if (input > 0.25f && input < 4.0f) {
                        BedWarsHard.getGame().setGoldRate(input);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&cЗначение флага может быть только в границах от 0.25 до 4.0"));
                    }
                } else if (args[1].equalsIgnoreCase("final-dm") && args.length == 3) {
                    int input = Integer.parseInt(args[2]);
                    if (input >= 0 && input <= 30) {
                        BedWarsHard.getGame().setFinalDM(input);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&cЗначение флага может быть только в границах от 0 до 30"));
                    }
                } else if (args[1].equalsIgnoreCase("game-length") && args.length == 3) {
                    int input = Integer.parseInt(args[2]);
                    if (input >= 1 && input <= 90) {
                        BedWarsHard.getGame().setGameLength(input);
                    } else if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ColorUtil.getMessage("&cЗначение флага может быть только в границах от 1 до 90"));
                    }
                }
            } else if (sender instanceof Player) {
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

    private static void printFlagInfo(Player p) {
        String yes = "&aвключено";
        String no = "&cвыключено";
        String kickOnLose = "&dkick-on-lose&f (&7Кикать с сервера после поражения&f): ";
        kickOnLose += BedWarsHard.getGame().isKickOnLose() ? yes : no;

        String protectedWorld = "&dprotected-world&f (&7Защита мира от ломания&f): ";
        protectedWorld += BedWarsHard.getGame().isProtectedWorld() ? yes : no;

        String editShop = "&dedit-shop&f (&7Позволяет редактировать магазин /bw editshop&f): ";
        editShop += BedWarsHard.getGame().isEditShop() ? yes : no;

        String limitPlayers = "&dlimit-players&f (&7Отключить лимит игроков в команде&f): ";
        limitPlayers += BedWarsHard.getGame().isLimitPlayers() ? yes : no;

        String bedDrop = "&dbed-drop&f (&7Выпадение кровати при ломании&f): ";
        bedDrop += BedWarsHard.getGame().isBedDrop() ? yes : no;

        DecimalFormat decimalFormat = new DecimalFormat("#.#");

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
        p.sendMessage(ColorUtil.getMessage(bedDrop));
    }
}
