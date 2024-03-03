package com.player.playerbackendtask.service;

import com.player.playerbackendtask.model.Player;
import com.player.playerbackendtask.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    public Page<Player> getAllPlayers(int page, int size) {
        if (page < 0) {
            throw new IllegalArgumentException("Please provide proper paging parameter, it should be more than 0");
        }
        if ( size <= 0) {
            throw new IllegalArgumentException("Please provide proper page size parameter, it should be more than 0");
        }
        PageRequest paged = PageRequest.of(page, size);
        Page<Player> result = playerRepository.findAll(paged);
        List<Player> players = result.getContent();
        return new PageImpl<>(players, result.getPageable(), result.getTotalElements());
    }
    public Player getPlayer(String playerID) {
        return playerRepository.findById(playerID)
                .orElseThrow(() -> new EntityNotFoundException("Player with id " + playerID + " not found"));
    }

}
