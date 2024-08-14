package org.lordalex.bedwarshard.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.material.Bed;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.config.BedTeam;
import org.lordalex.bedwarshard.config.GameState;

import java.util.ArrayList;

public class CustomScoreboard {
    public static Scoreboard createScoreboard(ArrayList<String> scores) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective(ColorUtil.getMessage("&b&lBedWars"), "Test");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        int i = scores.size();
        for(String str : scores){
            objective.getScore(str).setScore(i);
            i--;
        }
        //objective.getScore(" ").setScore(2);
        objective.getScore(ColorUtil.getMessage("&a&lVimeWorld.ru")).setScore(i);

        return scoreboard;
    }

    public static void setWaitingScoreboard(Player p, int online){
        int mapSize = BedWarsHard.getMapConfig().getTeamPlayers() * BedWarsHard.getMapConfig().getTeams().size();
        ArrayList<String> scores = new ArrayList<>();
        scores.add(ColorUtil.getMessage("Карта: &f&l" + BedWarsHard.getMapConfig().getName()));
        scores.add(" ");
        for(String key : BedWarsHard.getMapConfig().getTeams().keySet()){
            BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
            String info = team.getBedStatus() ? "✔" : "✘";
            String teamStr = "&" + team.getColor() + info + team.getNames().split(",")[2] + "&7 (" + team.getAlivePlayersInfo().size() + "/" + BedWarsHard.getMapConfig().getTeamPlayers() + ")";
            if(team.getPlayerSet().contains(p)){
                teamStr += "&7 ⇐ Вы";
            }
            scores.add(ColorUtil.getMessage(teamStr));
        }
        scores.add("  ");
        scores.add(ColorUtil.getMessage("Игроков: &e" + online + "/" + mapSize));
        scores.add("   ");

        Scoreboard scoreboard = CustomScoreboard.createScoreboard(scores);
        p.setScoreboard(scoreboard);
    }
    public static void updateScoreboard(Player p){
        if(BedWarsHard.getGame().getGameState() == GameState.WAITING){
            for (Player all : Bukkit.getOnlinePlayers()) {
                CustomScoreboard.setWaitingScoreboard(all, Bukkit.getOnlinePlayers().size());
            }
        }
        else{
            for (Player all : Bukkit.getOnlinePlayers()) {
                CustomScoreboard.setGamingScoreboard(all);
            }
        }
    }

    public static void setGamingScoreboard(Player p){
        int mapSize = BedWarsHard.getMapConfig().getTeamPlayers() * BedWarsHard.getMapConfig().getTeams().size();
        ArrayList<String> scores = new ArrayList<>();
        scores.add(ColorUtil.getMessage("Карта: &f&l" + BedWarsHard.getMapConfig().getName()));
        scores.add(" ");
        for(String key : BedWarsHard.getMapConfig().getTeams().keySet()){
            BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
            String info = team.getBedStatus() ? "✔" : "✘";
            String teamStr = "&" + team.getColor() + info + team.getNames().split(",")[2] + "&7 (" + team.getAlivePlayersInfo().size() + "/" + BedWarsHard.getMapConfig().getTeamPlayers() + ")";
            if(team.getPlayerSet().contains(p)){
                teamStr += "&7 ⇐ Вы";
            }
            scores.add(ColorUtil.getMessage(teamStr));
        }
        scores.add("  ");
        Scoreboard scoreboard = CustomScoreboard.createScoreboard(scores);
        p.setScoreboard(scoreboard);
    }
}
