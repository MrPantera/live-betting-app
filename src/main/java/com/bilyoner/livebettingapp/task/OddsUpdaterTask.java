package com.bilyoner.livebettingapp.task;

import com.bilyoner.livebettingapp.model.response.MatchCreateResponse;
import com.bilyoner.livebettingapp.repository.MatchHistoryRepository;
import com.bilyoner.livebettingapp.repository.MatchRepository;
import com.bilyoner.livebettingapp.service.MatchService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Component
public class OddsUpdaterTask {

    @Autowired
    private MatchService matchService;

    @Scheduled(initialDelay = 10, fixedDelay = 1, timeUnit = TimeUnit.SECONDS)
    @Transactional
    public void run() {

        List<MatchCreateResponse> matches = matchService.getMatches();

        matches.forEach(m -> matchService.updateOdds(m));
        log.info("run - Current time is :: " + LocalDateTime.now());
    }
}