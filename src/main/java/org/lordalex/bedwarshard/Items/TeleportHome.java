package org.lordalex.bedwarshard.Items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.Utils.GameUtil;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.HashMap;
import java.util.UUID;

public class TeleportHome implements Listener {
    private final HashMap<UUID, Long> cooldownsMap;
    private final int COOLDOWN = 5000;
    private final int DELAY = 1000;
    private BukkitTask teleport;

    public TeleportHome() {
        this.cooldownsMap = new HashMap<UUID, Long>();
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getItem() == null) return;
        Player p = e.getPlayer();

        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getItem().getType() != Material.SULPHUR) return;

        PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(p);
        if (playerInfo == null) {
            p.sendMessage(ColorUtil.getMessage("&cИ куда я тебя должен телепортировать?!"));
        } else if (!cooldownsMap.containsKey(p.getUniqueId()) || System.currentTimeMillis() - cooldownsMap.get(p.getUniqueId()) >= COOLDOWN) {
            cooldownsMap.put(p.getUniqueId(), System.currentTimeMillis());
            p.sendMessage("Starting teleportation");
            BukkitTask teleport = new BukkitRunnable() {
                @Override
                public void run() {
                    p.teleport(GameUtil.getRandomSpawnLocation(playerInfo));
                    p.sendMessage("Вы телепортированы домой");
                }
            }.runTaskLater(BedWarsHard.getInstance(), 20 * 5);

        } else {
            //if the cooldown is not over, send the player a message
            p.sendMessage("Reloading: " + (COOLDOWN - (System.currentTimeMillis() - cooldownsMap.get(p.getUniqueId()))) / 1000 + "s");
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (cooldownsMap.containsKey(e.getEntity().getUniqueId())
                && System.currentTimeMillis() - cooldownsMap.get(e.getEntity().getUniqueId()) < DELAY) {
            teleport.cancel();
        }
    }
}
