package com.player.playerbackendtask.controller;

import com.player.playerbackendtask.model.Player;
import com.player.playerbackendtask.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    @GetMapping
    public Page<Player> getAllPlayers(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "30") int size) {
        return playerService.getAllPlayers(page, size);
    }
    @GetMapping("/{player_id}")
    public Player getPlayer(@PathVariable("player_id") String playerID) {
        return playerService.getPlayer(playerID);
    }
}