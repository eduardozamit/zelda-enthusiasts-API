package com.github.zeldaservice.service;

import com.github.zeldaservice.model.ZeldaGame;
import com.github.zeldaservice.model.ZeldaGameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZeldaGameService {

    private final WebClient webClient;

    public Mono<ZeldaGameResponse<List<ZeldaGame>>> getAllGames() {
        return webClient.get()
                .uri("https://zelda.fanapis.com/api/games")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ZeldaGameResponse<List<ZeldaGame>>>() {});
    }

    public Mono<ZeldaGameResponse<ZeldaGame>> getGameById(String gameId) {
        return webClient.get()
                .uri("https://zelda.fanapis.com/api/games/{gameId}", gameId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ZeldaGameResponse<ZeldaGame>>() {});
    }
}