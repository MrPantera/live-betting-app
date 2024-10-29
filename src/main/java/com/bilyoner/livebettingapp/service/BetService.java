package com.bilyoner.livebettingapp.service;

import com.bilyoner.livebettingapp.model.entity.Bet;
import com.bilyoner.livebettingapp.model.entity.MatchHistory;
import com.bilyoner.livebettingapp.model.exception.BusinessException;
import com.bilyoner.livebettingapp.model.request.BetCreateRequest;
import com.bilyoner.livebettingapp.model.response.BetCreateResponse;
import com.bilyoner.livebettingapp.repository.BetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BetService {

    private final BetRepository betRepository;
    private final MatchService matchService;

    public BetService(BetRepository betRepository, MatchService matchService) {
        this.betRepository = betRepository;
        this.matchService = matchService;
    }

    public List<BetCreateResponse> getBets() {
        List<Bet> matches = betRepository.findAll();

        return matches
                .stream()
                .map(BetCreateResponse::createFrom)
                .collect(Collectors.toList());
    }

    public BetCreateResponse getBet(Long id) {
        return betRepository.findById(id)
                .map(BetCreateResponse::createFrom)
                .orElseThrow(() -> new BusinessException("Bet not found"));
    }

    public Bet getBetById(Long id) {
        return betRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Bet not found"));
    }

    public Bet save(BetCreateRequest request) {
        MatchHistory matchHistory = matchService.getMatchHistoryById(request.getMatchHistoryId());

        final var odds = switch (request.getPrediction()) {
            case "HOME" -> matchHistory.getHomeOdds();
            case "DRAW" -> matchHistory.getDrawOdds();
            case "AWAY" -> matchHistory.getAwayOdds();
            default -> throw new IllegalStateException("Unexpected value: " + request.getPrediction());
        };

        return betRepository.save(request.toBet(matchHistory, odds));
    }
}
