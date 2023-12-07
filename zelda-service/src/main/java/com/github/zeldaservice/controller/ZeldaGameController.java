package com.github.zeldaservice.controller;

import com.github.zeldaservice.model.ZeldaGameResponse;
import com.github.zeldaservice.service.ZeldaGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class ZeldaGameController {

    private final ZeldaGameService zeldaGameService;

    @GetMapping
    public Mono<ZeldaGameResponse> getAllGames() {
        return zeldaGameService.getAllGames();
    }
}
