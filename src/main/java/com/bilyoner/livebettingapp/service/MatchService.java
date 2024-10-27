package com.bilyoner.livebettingapp.service;

import com.bilyoner.livebettingapp.model.entity.Match;
import com.bilyoner.livebettingapp.model.exception.BusinessException;
import com.bilyoner.livebettingapp.model.request.MatchCreateRequest;
import com.bilyoner.livebettingapp.model.response.MatchResponse;
import com.bilyoner.livebettingapp.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<MatchResponse> getMatches() {
        List<Match> matches = matchRepository.findAll();

        return matches
                .stream()
                .map(MatchResponse::createFrom)
                .collect(Collectors.toList());
    }

    public MatchResponse getMatch(Long id) {
        return matchRepository.findById(id)
                .map(MatchResponse::createFrom)
                .orElseThrow(() -> new BusinessException("Match not found"));
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Match not found"));
    }

    public void save(MatchCreateRequest request) {
        matchRepository.save(request.toMatch());
    }
}
