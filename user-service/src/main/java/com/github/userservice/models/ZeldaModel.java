package com.github.userservice.models;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Data
@Entity
@Table(name = "zelda")
public class ZeldaModel {
    @Id
    private String id;
    private String name;
    private String description;
    private String developer;
    private String publisher;
    @Column(name = "launch")
    private Date dateLaunch;
}
