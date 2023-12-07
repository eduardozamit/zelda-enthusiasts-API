package com.github.zeldaservice.service;

import com.github.zeldaservice.model.ZeldaGameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ZeldaGameService {

    private final WebClient webClient;

    public Mono<ZeldaGameResponse> getAllGames() {
        return webClient.get()
                .uri("https://zelda.fanapis.com/api/games")
                .retrieve()
                .bodyToMono(ZeldaGameResponse.class);
    }
}
