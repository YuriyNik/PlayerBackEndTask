package com.player.playerbackendtask.service;

import com.player.playerbackendtask.model.Player;
import com.player.playerbackendtask.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.data.domain.Page;
import jakarta.persistence.EntityNotFoundException;


import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {PlayerService.class})
@ExtendWith(SpringExtension.class)
public class PlayerServiceTest {
    @MockBean
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        player1 =  new Player("1111", 1995, 1, 1, "Country", "State", "Moscow", null, null, null,
                null, null, null, "Name", "FamilyName", "test", 75, 185, "R", "R",
                "1905-09-04", "1911-05-05", "Retro1", "Bbref1");
        playerRepository.save(player1);
        player2 = new Player("2222", 1998, 1, 1, "Country", "State", "Moscow", null, null, null,
                null, null, null, "Hey", "Bro", "test", 75, 185, "R", "R",
                "1905-09-04", "1911-05-05", "Retro1", "Bbref1");
        playerRepository.save(player2);
        when(playerRepository.findAll(any(PageRequest.class)))
                .thenReturn(new PageImpl<>(Arrays.asList(player1, player2)));
        when(playerRepository.findById("1111")).thenReturn(Optional.of(player1));
        when(playerRepository.findById("2222")).thenReturn(Optional.of(player1));
        when(playerRepository.findById("3333")).thenReturn(Optional.empty());
    }

    @Test
    void getAllPlayers_ValidParameters_Success() {
        Page<Player> result = playerService.getAllPlayers(0, 2);

        assertNotNull(result);
        assertEquals(2, result.getContent().size());
        assertTrue(result.getContent().contains(player1));
        assertTrue(result.getContent().contains(player2));
        verify(playerRepository).findAll(any(PageRequest.class));
    }

    @Test
    void getPlayer_ValidId_ReturnsPlayer() {
        Page<Player> results = playerService.getAllPlayers(0, 2);
        System.out.println(results);
        Player result = playerService.getPlayer("2222");

        assertNotNull(result);
        assertEquals("Name", result.getNameFirst());
        assertEquals("FamilyName", result.getNameLast());
    }

    @Test
    void getPlayer_InvalidId_ThrowsException() {
        assertThrows(EntityNotFoundException.class, () -> playerService.getPlayer("invalidId"));
    }
}
