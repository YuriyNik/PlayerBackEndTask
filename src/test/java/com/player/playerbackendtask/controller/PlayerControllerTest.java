package com.player.playerbackendtask.controller;

import com.player.playerbackendtask.model.Player;
import com.player.playerbackendtask.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.Arrays;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

    @MockBean
    private PlayerService playerService;

    @Autowired
    private MockMvc mockMvc;

    private Player player1;
    private Player player2;

    @BeforeEach
    public void setup(WebApplicationContext webApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        player1 =  new Player("1111", 1995, 1, 1, "Country", "State", "Moscow", null, null, null,
                null, null, null, "Name", "FamilyName", "test", 75, 185, "R", "R",
                "1905-09-04", "1911-05-05", "Retro1", "Bbref1");
        player2 = new Player("2222", 1998, 1, 1, "Country", "State", "Moscow", null, null, null,
                null, null, null, "Hey", "Bro", "test", 75, 185, "R", "R",
                "1905-09-04", "1911-05-05", "Retro1", "Bbref1");

        List<Player> players = Arrays.asList(player1, player2);
        Page<Player> playerPage = new PageImpl<>(players, PageRequest.of(0, 30), players.size());

        given(playerService.getAllPlayers(0, 30)).willReturn(playerPage);
        given(playerService.getPlayer("player1")).willReturn(player1);
    }
    @Test
    public void getAllPlayers_ShouldReturnPlayers() throws Exception {
        mockMvc.perform(get("/v1/api/players")
                        .param("page", "0")
                        .param("size", "30")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].playerID").value("1111"))
                .andExpect(jsonPath("$.content[1].playerID").value("2222"));
    }
    @Test
    public void getPlayer_ShouldReturnPlayer() throws Exception {

        mockMvc.perform(get("/v1/api/players/{player_id}", "2222")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
