package com.zestlifia.testdatastructure;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DepthChartDataStructure {
    private Map<String, Map<String, LinkedList<PlayerModel>>> chart;
    private Map<Integer, PlayerModel> playerModels;

    public DepthChartDataStructure() {
        this.chart = new HashMap<>();
        this.playerModels = new HashMap<>();
    }

    @PostConstruct
    private void initTestDataStructure() {
        PlayerModel bob = new PlayerModel(1, "Bob");
        PlayerModel alice = new PlayerModel(2, "Alice");
        PlayerModel charlie = new PlayerModel(3, "Charlie");
        playerModels.put(bob.getId(), bob);
        playerModels.put(alice.getId(), bob);
        playerModels.put(charlie.getId(), bob);

        this.addPlayerToDepthChart(bob, "NFL", "WR", 0);
        this.addPlayerToDepthChart(alice, "NFL", "WR", 0);
        this.addPlayerToDepthChart(charlie, "NFL", "WR", 2);
        this.addPlayerToDepthChart(bob, "NFL", "KR", null);
    }

    public void addPlayer(PlayerModel player) {
        playerModels.put(player.getId(), player);
    }

    public PlayerModel getPlayer(int playerId) {
        return playerModels.get(playerId);
    }


    public void addPlayerToDepthChart(PlayerModel player, String sport, String position, Integer depth) {
        this.chart.putIfAbsent(sport, new HashMap<>());
        this.addPlayer(player);
        Map<String, LinkedList<PlayerModel>> sportChart = this.chart.get(sport);
        sportChart.putIfAbsent(position, new LinkedList<>());

        LinkedList<PlayerModel> playersList = sportChart.get(position);
        if (depth == null || depth >= playersList.size()) {
            playersList.addLast(player);
        } else {
            playersList.add(depth, player);
            // Ensuring that only the necessary adjustments are made for players beyond the inserted depth
            for (int i = depth + 1; i < playersList.size(); i++) {
                playersList.set(i, playersList.get(i));
            }
        }
    }

    public void removePlayerFromDepthChart(PlayerModel player, String sport, String position) {
        if (chart.containsKey(sport) && chart.get(sport).containsKey(position)) {
            chart.get(sport).get(position).remove(player);
            this.playerModels.remove(player.getId());
        }
    }

    public Map<String, LinkedList<PlayerModel>> getFullDepthChart(String sport) {
        return chart.getOrDefault(sport, new HashMap<>());
    }

    public List<PlayerModel> getPlayersUnderPlayerInDepthChart(PlayerModel player, String sport, String position) {
        List<PlayerModel> result = new LinkedList<>();
        if (chart.containsKey(sport) && chart.get(sport).containsKey(position)) {
            LinkedList<PlayerModel> playersList = chart.get(sport).get(position);
            int index = playersList.indexOf(player);
            if (index != -1) {
                result.addAll(playersList.subList(index + 1, playersList.size()));
            }
        }
        return result;
    }

    public LinkedList<PlayerModel> getPlayersByPosition(String sport, String position) {
        if (chart.containsKey(sport) && chart.get(sport).containsKey(position)) {
            return new LinkedList<>(chart.get(sport).get(position));
        }
        return new LinkedList<>();
    }
}
