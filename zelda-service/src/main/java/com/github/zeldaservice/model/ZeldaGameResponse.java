package com.github.zeldaservice.model;

import lombok.Data;

@Data
public class ZeldaGameResponse<T> {
    private boolean success;
    private int count;
    private T data;
}
