package com.player.playerbackendtask.controller;

import com.player.playerbackendtask.model.Player;
import com.player.playerbackendtask.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/{player_id}")
    public Player getPlayer(@PathVariable("player_id") String playerID) {
        return playerService.getPlayer(playerID);
    }

}
