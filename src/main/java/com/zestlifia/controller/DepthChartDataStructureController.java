package com.zestlifia.controller;

import com.zestlifia.enums.NFLPosition;
import com.zestlifia.enums.SoccerPosition;
import com.zestlifia.enums.Sport;
import com.zestlifia.testdatastructure.DepthChartDataStructure;
import com.zestlifia.testdatastructure.PlayerModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/depth-chart-data-structure")
public class DepthChartDataStructureController {
    private final DepthChartDataStructure depthChart;

    public DepthChartDataStructureController(DepthChartDataStructure depthChart) {
        this.depthChart = depthChart;
    }

    @PostMapping("/{sport}/{position}/add")
    public ResponseEntity<String> addPlayerToDepthChart(
            @PathVariable Sport sport,
            @PathVariable String position,
            @RequestParam int playerId,
            @RequestParam String playerName,
            @RequestParam(required = false) Integer depth) {

        PlayerModel player = new PlayerModel(playerId, playerName);
        depthChart.addPlayerToDepthChart(player, sport.name(), position, depth);

        return ResponseEntity.ok("Player added successfully");
    }

    @DeleteMapping("/{sport}/{position}/remove")
    public ResponseEntity<String> removePlayerFromDepthChart(
            @PathVariable String sport,
            @PathVariable String position,
            @RequestParam int playerId) {
        PlayerModel player = new PlayerModel(playerId, ""); // Assuming playerName is not necessary for removal
        depthChart.removePlayerFromDepthChart(player, sport, position);
        return ResponseEntity.ok("Player removed successfully");
    }


    @GetMapping("/{sport}")
    public ResponseEntity<Map<String, LinkedList<PlayerModel>>> getFullDepthChart(@PathVariable String sport) {
        return ResponseEntity.ok(depthChart.getFullDepthChart(sport));
    }

    @GetMapping("/{sport}/{position}/under")
    public ResponseEntity<List<PlayerModel>> getPlayersUnderPlayerInDepthChart(
            @PathVariable String sport,
            @PathVariable String position,
            @RequestParam int playerId) {
        PlayerModel player = depthChart.getPlayer(playerId);
        return ResponseEntity.ok(depthChart.getPlayersUnderPlayerInDepthChart(player, sport, position));
    }

    @GetMapping("/{sport}/{position}")
    public ResponseEntity<LinkedList<PlayerModel>> getPlayersByPosition(
            @PathVariable String sport,
            @PathVariable String position) {
        return ResponseEntity.ok(depthChart.getPlayersByPosition(sport, position));
    }
}
