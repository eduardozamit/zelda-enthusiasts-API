package com.github.zeldaservice.controller;

import com.github.zeldaservice.model.ZeldaGame;
import com.github.zeldaservice.model.ZeldaGameResponse;
import com.github.zeldaservice.service.ZeldaGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class ZeldaGameController {

    private final ZeldaGameService zeldaGameService;

    // Endpoint para obter todos os jogos
    @GetMapping
    public Mono<ZeldaGameResponse<List<ZeldaGame>>> getAllGames() {
        return zeldaGameService.getAllGames();
    }

    // Endpoint para obter um jogo por ID
    @GetMapping("/{id}")
    public Mono<ZeldaGameResponse<ZeldaGame>> getGameById(@PathVariable String id) {
        return zeldaGameService.getGameById(id);
    }
}