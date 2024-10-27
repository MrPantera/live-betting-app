package com.bilyoner.livebettingapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "${spring.application.name}"))
public class LiveBettingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiveBettingAppApplication.class, args);
    }

}
 