package com.bilyoner.livebettingapp.controller;

import com.bilyoner.livebettingapp.service.InitializeDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/initialize-data")
@RestController
public class InitializeDataController {

    private final InitializeDataService initializeDataService;

    public InitializeDataController(InitializeDataService initializeDataService) {
        this.initializeDataService = initializeDataService;
    }

    @PostMapping(value = "/")
    public void save() {
        initializeDataService.initializeData();
    }
}
