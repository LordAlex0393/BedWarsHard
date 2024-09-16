package org.lordalex.bedwarshard.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class TrackerGPS implements Listener {
    @EventHandler
    public void onEvent(PlayerInteractEvent e) {
        if(e == null) return;
        Player p = e.getPlayer();
        Player anotherPlayer = getNearestPlayerDistance(p);
        p.setCompassTarget(anotherPlayer.getLocation());
    }
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if(e.getItem() == null) return;
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (!(e.getItem().getType() == Material.COMPASS)) return;
        Player p = e.getPlayer();
        Player anotherPlayer = getNearestPlayerDistance(p);
        if(anotherPlayer.equals(p)){
            p.sendMessage("Нет других игроков");
        }
        else{
            int distance = (int) anotherPlayer.getLocation().distance(p.getLocation());
            p.sendMessage("Расстояние до игрока " + anotherPlayer.getName() + " " + distance + " блоков");
        }
    }
    private static Player getNearestPlayerDistance(Player p){
        double minDistance = Double.MAX_VALUE;
        Player target = p;
        for(Player anotherPlayer : Bukkit.getOnlinePlayers()){
            if(!p.getName().equals(anotherPlayer.getName())) {
                if (p.getLocation().distance(anotherPlayer.getLocation()) < minDistance) {
                    minDistance = p.getLocation().distance(anotherPlayer.getLocation());
                    target = anotherPlayer;
                }
            }
        }
        return target;
    }
}
