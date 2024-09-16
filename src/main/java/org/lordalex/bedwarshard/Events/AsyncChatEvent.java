package org.lordalex.bedwarshard.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.PlayerInfo;

public class AsyncChatEvent implements Listener {
    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String msg = e.getMessage();
        e.setCancelled(true);
        PlayerInfo pi = BedWarsHard.getGame().getPlayer(p);
        if(pi != null){
            if (msg.length() > 0 && msg.charAt(0) == '!'){
                for(Player all : Bukkit.getOnlinePlayers()){
                    all.sendMessage(ColorUtil.getMessage("&7(Всем) " + "&" + pi.getTeam().getColor() + p.getName() + "&7: &f" + msg.substring(1)));
                }
            }
            else{
                for(Player teamPlayer : pi.getTeam().getPlayerSet()){
                    teamPlayer.sendMessage(ColorUtil.getMessage("&" + pi.getTeam().getColor() + "(Команда) " + p.getName() + "&7: &f" + msg));
                }
            }
        }
        else{
            for(Player all : Bukkit.getOnlinePlayers()){
                all.sendMessage(ColorUtil.getMessage("&7" + p.getName() + ": &f" + msg));
            }
        }
    }
}
