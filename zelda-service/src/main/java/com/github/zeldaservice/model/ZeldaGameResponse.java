package com.github.zeldaservice.model;

import lombok.Data;

// Classe que representa a resposta da API com dados genéricos
@Data
public class ZeldaGameResponse<T> {
    private boolean success;
    private int count;
    private T data; // Dados da resposta (pode ser um jogo único ou uma lista de jogos)
}
