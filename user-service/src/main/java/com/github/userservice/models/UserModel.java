package com.github.userservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    private String name;

    @NotNull(message = "A idade não pode ser nula")
    @Positive(message = "A idade deve ser um número positivo")
    private int age;

    @ManyToMany
    @JoinTable(name = "favoritegame",
            joinColumn = @JoinColumn(name = "user_id",
                    inverseJoinColumn = @JoinColumn(name = "zelda_id")))
    private List<ZeldaModel> favoriteGames;

}


