package org.lordalex.bedwarshard.Items;

import org.bukkit.Effect;
import org.bukkit.Location;
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
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.HashMap;
import java.util.UUID;

public class TeleportHome implements Listener {
    private final HashMap<UUID, Long> cooldownsMap;
    private final int COOLDOWN = 5000;
    private final int DELAY = 1000;
    private BukkitTask teleport;
    private boolean waitingForTP = true;
    private final double range = 0.1;
    private double high = 0;

    public TeleportHome() {
        this.cooldownsMap = new HashMap<UUID, Long>();
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getItem() == null) return;
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getItem().getType() != Material.SULPHUR) return;
        Player p = e.getPlayer();
        PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(p);
        if (playerInfo == null) {
            p.sendMessage(ColorUtil.getMessage("&cИ куда я тебя должен телепортировать?!"));
        } else if (!cooldownsMap.containsKey(p.getUniqueId()) || System.currentTimeMillis() - cooldownsMap.get(p.getUniqueId()) >= COOLDOWN) {
            //cooldownsMap.put(p.getUniqueId(), System.currentTimeMillis());
            p.sendMessage("Начало телепортации");
            waitingForTP = true;
            high=0.012;
            Location standLoc = p.getLocation();


            BukkitTask teleport = new BukkitRunnable() {
                @Override
                public void run() {
                    if (waitingForTP) {
                        p.teleport(GameUtil.getRandomSpawnLocation(playerInfo));
                        p.sendMessage(ColorUtil.getMessage("&aВы телепортированы домой"));
                        waitingForTP = false;
                    } else {
                        cancel();
                    }
                }
            }.runTaskLater(BedWarsHard.getInstance(), 20 * 6);
//            Effect ef = Effect.values()[(int)Math.floor(Math.random() * Effect.values().length)];
//            System.out.println(ef.toString());
//            p.sendMessage(ef.toString());

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (waitingForTP) {
                        Effect ef = Effect.SNOWBALL_BREAK;
                        int up = 1;
                        for(int i = 0; i < BedWarsHard.getGame().getGameLength(); i++){
                            p.getWorld().playEffect(p.getLocation().clone().add(0, high, 0), ef, 0);
                        }
                        high+=0.012;



                        //high+=0.017;
                        if (Math.abs(standLoc.getX() - p.getLocation().getX()) > range || Math.abs(standLoc.getY() - p.getLocation().getY()) > range || Math.abs(standLoc.getZ() - p.getLocation().getZ()) > range) {
                            p.sendMessage(ColorUtil.getMessage("&cТелепортация отменена"));
                            teleport.cancel();
                            waitingForTP = false;
                            cancel();
                        }
                    } else {
                        high=0.014;
                        cancel();
                    }
                }
            }.runTaskTimer(BedWarsHard.getInstance(), 0, 1);

        } else {
            //if the cooldown is not over, send the player a message
            p.sendMessage("Reloading: " + (COOLDOWN - (System.currentTimeMillis() - cooldownsMap.get(p.getUniqueId()))) / 1000 + "s");
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (cooldownsMap.containsKey(e.getEntity().getUniqueId())) {
            teleport.cancel();
        }
    }
}
