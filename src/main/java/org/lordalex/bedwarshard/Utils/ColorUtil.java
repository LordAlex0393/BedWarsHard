package org.lordalex.bedwarshard.Utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;

public class ColorUtil {
    public static String getMessage(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
    public static Color translateChatColorToColor(String color)
    {
        switch (color.toUpperCase().trim()) {
            case "AQUA":
                return Color.AQUA;
            case "BLACK":
                return Color.BLACK;
            case "BLUE":
                return Color.BLUE;
            case "CYAN":
                return Color.AQUA;
            case "PINK":
                return Color.FUCHSIA;
            case "DARK_GRAY":
                return Color.GRAY;
            case "DARK_GREEN":
                return Color.GREEN;
            case "DARK_PURPLE":
                return Color.PURPLE;
            case "DARK_RED":
                return Color.RED;
            case "ORANGE":
                return Color.ORANGE;
            case "GRAY":
                return Color.GRAY;
            case "GREEN":
                return Color.GREEN;
            case "PURPLE":
                return Color.PURPLE;
            case "RED":
                return Color.RED;
            case "WHITE":
                return Color.WHITE;
            case "YELLOW":
                return Color.YELLOW;
            default:
                break;
        }

        return null;
    }
}