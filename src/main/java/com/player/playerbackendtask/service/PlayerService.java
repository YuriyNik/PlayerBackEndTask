package com.player.playerbackendtask.service;

import com.player.playerbackendtask.model.Player;
import com.player.playerbackendtask.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public Player getPlayer(String playerID) {
        return playerRepository.findById(playerID)
                .orElseThrow(() -> new EntityNotFoundException("Player with id " + playerID + " not found"));
    }

}
