package com.github.zeldaservice.model;

import lombok.Data;

@Data
public class ZeldaGame {
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String released_date;
    private String id;
}
