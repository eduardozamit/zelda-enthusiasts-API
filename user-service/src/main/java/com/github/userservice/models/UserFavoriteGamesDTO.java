package com.github.userservice.models;
import lombok.Data;
import java.util.List;
@Data

public class UserFavoriteGamesDTO {
    private String name;
    private List<ZeldaModel> favoriteGames;
}
