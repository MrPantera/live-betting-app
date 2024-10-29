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

import java.util.List;
import java.util.stream.Collectors;

import static com.bilyoner.livebettingapp.model.entity.MatchHistory.MatchHistoryBuilder.aMatchHistory;

@Service
public class MatchHistoryService {

    private final MatchHistoryRepository matchHistoryRepository;

    public MatchHistoryService(MatchHistoryRepository matchHistoryRepository) {
        this.matchHistoryRepository = matchHistoryRepository;
    }

    public List<MatchHistoryCreateResponse> getMatchHistories() {
        List<MatchHistory> matchHistories = matchHistoryRepository.findAll();

        return matchHistories
                .stream()
                .map(MatchHistoryCreateResponse::createFrom)
                .collect(Collectors.toList());
    }

    public MatchHistoryCreateResponse getMatchHistory(Long id) {
        return matchHistoryRepository.findById(id)
                .map(MatchHistoryCreateResponse::createFrom)
                .orElseThrow(() -> new BusinessException("Match not found"));
    }

    public MatchHistory getMatchHistoryById(Long id) {
        return matchHistoryRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Match history not found"));
    }

}
