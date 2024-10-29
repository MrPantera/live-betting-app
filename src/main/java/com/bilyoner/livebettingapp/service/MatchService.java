package com.bilyoner.livebettingapp.service;

import com.bilyoner.livebettingapp.BettingOdds;
import com.bilyoner.livebettingapp.model.entity.Match;
import com.bilyoner.livebettingapp.model.entity.MatchHistory;
import com.bilyoner.livebettingapp.model.exception.BusinessException;
import com.bilyoner.livebettingapp.model.request.MatchCreateRequest;
import com.bilyoner.livebettingapp.model.response.MatchCreateResponse;
import com.bilyoner.livebettingapp.model.response.MatchHistoryCreateResponse;
import com.bilyoner.livebettingapp.repository.MatchHistoryRepository;
import com.bilyoner.livebettingapp.repository.MatchRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.bilyoner.livebettingapp.model.entity.Match.MatchBuilder.aMatch;
import static com.bilyoner.livebettingapp.model.entity.MatchHistory.MatchHistoryBuilder.aMatchHistory;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final MatchHistoryRepository matchHistoryRepository;

    public MatchService(MatchRepository matchRepository, MatchHistoryRepository matchHistoryRepository) {
        this.matchRepository = matchRepository;
        this.matchHistoryRepository = matchHistoryRepository;
    }

    public List<MatchCreateResponse> getMatches() {
        List<Match> matches = matchRepository.findAll();

        return matches
                .stream()
                .map(MatchCreateResponse::createFrom)
                .collect(Collectors.toList());
    }

    public List<MatchHistoryCreateResponse> getMatchHistories() {
        List<MatchHistory> matchHistories = matchHistoryRepository.findAll();

        return matchHistories
                .stream()
                .map(MatchHistoryCreateResponse::createFrom)
                .collect(Collectors.toList());
    }

    public MatchCreateResponse getMatch(Long id) {
        return matchRepository.findById(id)
                .map(MatchCreateResponse::createFrom)
                .orElseThrow(() -> new BusinessException("Match not found"));
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Match not found"));
    }
    public MatchHistory getMatchHistoryById(Long id) {
        return matchHistoryRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Match history not found"));
    }

    public Float getOdds(Long id, String prediction) {
        final var matchHistory = getMatchHistoryById(id);

        return switch (prediction) {
            case "HOME" -> matchHistory.getHomeOdds();
            case "DRAW" -> matchHistory.getDrawOdds();
            case "AWAY" -> matchHistory.getAwayOdds();
            default -> throw new IllegalStateException("Unexpected value: " + prediction);
        };
    }

    public void save(MatchCreateRequest request) {
        matchRepository.save(request.toMatch());

        MatchHistory matchHistory = aMatchHistory()
                .match(request.toMatch())
                .homeOdds(request.getHomeOdds())
                .drawOdds(request.getDrawOdds())
                .awayOdds(request.getAwayOdds())
                .build();

        matchHistoryRepository.save(matchHistory);
    }
    @Transactional
    public void updateOdds(MatchCreateResponse matchCreateResponse) {
        final var matchCreateRequest = getMatchById(matchCreateResponse.getId());

        BettingOdds bettingOdds = new BettingOdds();
        bettingOdds.calculateRandomOdds();

        final var match = aMatch()
                .id(matchCreateRequest.getId())
                .league(matchCreateResponse.getLeague())
                .homeTeam(matchCreateResponse.getHomeTeam())
                .awayTeam(matchCreateResponse.getAwayTeam())
                .homeOdds(bettingOdds.getHomeOdds())
                .drawOdds(bettingOdds.getDrawOdds())
                .awayOdds(bettingOdds.getAwayOdds())
                .matchTime(matchCreateResponse.getMatchTime())
                .build();

        MatchHistory matchHistory = aMatchHistory()
                .match(match)
                .homeOdds(match.getHomeOdds())
                .drawOdds(match.getDrawOdds())
                .awayOdds(match.getAwayOdds())
                .creationDate(new Date())
                .build();

        matchRepository.save(match);
        matchHistoryRepository.save(matchHistory);

    }
}
