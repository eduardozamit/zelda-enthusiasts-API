package com.github.zeldaservice.service;

import com.github.zeldaservice.model.ZeldaGame;
import com.github.zeldaservice.model.ZeldaGameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZeldaGameService {

    private static final String baseUrl = "https://zelda.fanapis.com/api/games";
    private static final Logger logger = LogManager.getLogger(ZeldaGameService.class);

    private final WebClient webClient;

    // Método para obter todos os jogos da API
    public Mono<ZeldaGameResponse<List<ZeldaGame>>> getAllGames() {
        return webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ZeldaGameResponse<List<ZeldaGame>>>() {})// Converte o corpo da resposta HTTP para uma lista de ZeldaGame.
                .doOnSuccess(response -> logger.info("Chamada bem-sucedida para getAllGames"))
                .doOnError(error -> logger.error("Erro ao chamar getAllGames", error));
    }
    // Método para obter um jogo específico por ID da API
    public Mono<ZeldaGameResponse<ZeldaGame>> getGameById(String gameId) {
        return webClient.get()
                .uri(baseUrl + "/{gameId}", gameId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ZeldaGameResponse<ZeldaGame>>() {})// Converte o corpo da resposta HTTP para um único objeto ZeldaGame.
                .doOnSuccess(response -> logger.info("Chamada bem-sucedida para getGameById com gameId: {}", gameId))
                .doOnError(error -> logger.error("Erro ao chamar getGameById com gameId: {}", gameId, error));
    }
}