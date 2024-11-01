package com.bilyoner.livebettingapp.controller.utility;


import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Hidden
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public RedirectView redirectToSwaggerUI() {
        return new RedirectView("/swagger-ui/index.html");
    }
}