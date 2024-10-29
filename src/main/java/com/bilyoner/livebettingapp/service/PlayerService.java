package com.bilyoner.livebettingapp.service;

import com.bilyoner.livebettingapp.model.entity.Player;
import com.bilyoner.livebettingapp.model.exception.BusinessException;
import com.bilyoner.livebettingapp.model.request.PlayerCreateRequest;
import com.bilyoner.livebettingapp.model.response.PlayerCreateResponse;
import com.bilyoner.livebettingapp.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerCreateResponse> getPlayers() {
        List<Player> players = playerRepository.findAll();

        return players
                .stream()
                .map(PlayerCreateResponse::createFrom)
                .collect(Collectors.toList());
    }

    public PlayerCreateResponse getPlayer(Long id) {
        return playerRepository.findById(id)
                .map(PlayerCreateResponse::createFrom)
                .orElseThrow(() -> new BusinessException("Player not found"));
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Player not found"));
    }

    public void save(PlayerCreateRequest request) {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        playerRepository.save(request.toPlayer());
    }
}
