package com.bilyoner.livebettingapp.controller;

import com.bilyoner.livebettingapp.model.request.MatchCreateRequest;
import com.bilyoner.livebettingapp.model.response.MatchCreateResponse;
import com.bilyoner.livebettingapp.model.response.MatchHistoryCreateResponse;
import com.bilyoner.livebettingapp.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value={"/matches"})
@RestController
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping()
    public List<MatchCreateResponse> getMatches() {
        return matchService.getMatches();
    }

    @GetMapping("/{id}")
    public MatchCreateResponse getMatches(@PathVariable Long id) {
        return matchService.getMatch(id);
    }

    @PostMapping()
    public void save(@RequestBody MatchCreateRequest request) {
        matchService.save(request);
    }
}