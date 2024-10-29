package com.bilyoner.livebettingapp.controller;

import com.bilyoner.livebettingapp.model.request.PlayerCreateRequest;
import com.bilyoner.livebettingapp.model.response.PlayerCreateResponse;
import com.bilyoner.livebettingapp.service.PlayerService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeoutException;

@RequestMapping("/players")
@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    public List<PlayerCreateResponse> getPlayeres() {
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")
    public PlayerCreateResponse getPlayeres(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @PostMapping()
    public void save(@RequestBody PlayerCreateRequest request) {
        playerService.save(request);
    }
}