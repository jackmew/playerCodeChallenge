package com.zestlifia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.zestlifia.testdatastructure.DepthChartDataStructure;
import com.zestlifia.testdatastructure.PlayerModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class PlayerCodeApplication {

//    private static void initTestDataStructure() {
//        DepthChartDataStructure depthChart = new DepthChartDataStructure();
//        PlayerModel bob = new PlayerModel(1, "Bob");
//        PlayerModel alice = new PlayerModel(2, "Alice");
//        PlayerModel charlie = new PlayerModel(3, "Charlie");
//
//        depthChart.addPlayerToDepthChart(bob, "NFL", "WR", 0);
//        depthChart.addPlayerToDepthChart(alice, "NFL", "WR", 0);
//        depthChart.addPlayerToDepthChart(charlie, "NFL", "WR", 2);
//        depthChart.addPlayerToDepthChart(bob, "NFL", "KR", null);
//
//        System.out.println("Full NFL Depth Chart:");
//        Map<String, LinkedList<PlayerModel>> nflChart = depthChart.getFullDepthChart("NFL");
//        nflChart.forEach((position, players) -> {
//            System.out.println(position + ": " + players);
//        });
//
//        System.out.println("\nPlayers under Alice in WR position:");
//        List<PlayerModel> playersBelowAlice = depthChart.getPlayersUnderPlayerInDepthChart(alice, "NFL", "WR");
//        playersBelowAlice.forEach(System.out::println);
//
//        System.out.println("\nPlayers at position WR:");
//        LinkedList<PlayerModel> wrPlayers = depthChart.getPlayersByPosition("NFL", "WR");
//        wrPlayers.forEach(System.out::println);
//
//        System.out.println("\nRemove Alice in NFL in WR position:");
//        depthChart.removePlayerFromDepthChart(alice, "NFL", "WR");
//        System.out.println("Full NFL Depth Chart:");
//        Map<String, LinkedList<PlayerModel>> nflChartRemovedAlice = depthChart.getFullDepthChart("NFL");
//        nflChartRemovedAlice.forEach((position, players) -> {
//            System.out.println(position + ": " + players);
//        });
//    }

    public static void main(String[] args) {


//        initTestDataStructure();
        SpringApplication.run(PlayerCodeApplication.class, args);
    }

}
