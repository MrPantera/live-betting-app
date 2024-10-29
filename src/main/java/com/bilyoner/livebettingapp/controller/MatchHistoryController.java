package com.bilyoner.livebettingapp.controller;

import com.bilyoner.livebettingapp.model.request.MatchCreateRequest;
import com.bilyoner.livebettingapp.model.response.MatchCreateResponse;
import com.bilyoner.livebettingapp.model.response.MatchHistoryCreateResponse;
import com.bilyoner.livebettingapp.service.MatchHistoryService;
import com.bilyoner.livebettingapp.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value={"/matchHistories"})
@RestController
public class MatchHistoryController {

    private final MatchHistoryService matchHistoryService;

    public MatchHistoryController(MatchHistoryService matchHistoryService) {
        this.matchHistoryService = matchHistoryService;
    }

    @GetMapping()
    public List<MatchHistoryCreateResponse> getMatchHistories() {
        return matchHistoryService.getMatchHistories();
    }

}