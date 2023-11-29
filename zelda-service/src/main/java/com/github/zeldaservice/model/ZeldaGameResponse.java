package com.github.zeldaservice.model;

import lombok.Data;

import java.util.List;

@Data
public class ZeldaGameResponse {
    private boolean success;
    private int count;
    private List<ZeldaGame> data;
}
