package com.zestlifia.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.zestlifia.entity.Player;
import com.zestlifia.repository.PlayerRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player savePlayer(Player Player) {
        return playerRepository.save(Player);
    }

    public List<Player> listPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayer(Long id) {
        return playerRepository.findById(id);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Player updatePlayer(Player Player) {
        return playerRepository.save(Player);
    }
}

//Use Cases to Implement
//addPlayerToDepthChart(player, sport, position, position_depth)
//Adds a player to a depth chart for a given position (at a specific spot). If no position_depth is provided, then add them to the end of the depth chart for that position. If you are entering two players into the same slot, the last player entered gets priority and bumps the existing player down a depth spot.
//removePlayerFromDepthChart(player, sport, position) Removes a player from the depth chart for a position
//getFullDepthChart()
//Returns all depth chart positions
//Optional sports selection parameter to filter out results
//getPlayersUnderPlayerInDepthChart(player, sport, position)
//For a given player find all players below them on the depth chart
//getPlayersByPosition(sport, position)
//
//
//Example
//var bob = { "player_id": 1, "name": "Bob" }
//var alice = { "player_id": 2, "name": "Alice" } var charlie = { "player_id": 3, "name": "Charlie"}
//addPlayerToDepthChart(bob, "NFL", "WR", 0); addPlayerToDepthChart(alice, "NFL", "WR", 0); addPlayerToDepthChart(charlie, "NFL", "WR", 2); addPlayerToDepthChart(bob, "NFL", "KR"); getFullDepthChart();
//
//Output:
//NFL:
//        - WR: [2, 1, 3]
//        - KR: [1]
//
//getPlayersUnderPlayerInDepthChart(alice, “NFL”, "WR");
//
//Output:
//        [1,3]
//
//Please implement the 4 use cases above for:
//        1. NFL supporting positions (QB, WR, RB, TE, K, P, KR, PR)
//2. Soccer positions (GK, RB, LB, CDM, CAM, RW, LW, SS, ST)
//Keep in mind we potentially might add more sports in the future and we want to make it as easy as possible to add new ones.
