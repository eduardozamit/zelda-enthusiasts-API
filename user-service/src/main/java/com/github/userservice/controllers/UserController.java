package com.github.userservice.controllers;

import com.github.userservice.models.UserModel;
import com.github.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/usuario")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> ListarTodos() {
        return userService.ListarTodos();
    }

    @PostMapping
    public UserModel CriarUsuario(@RequestBody UserModel userModel) {
        return userService.CriarUsuario(userModel);
    }

    @PutMapping(path="/update/{id}")
    public UserModel AtualizarUsario(@RequestBody UserModel userModel) {
        return userService.AtualizarUsario(userModel);
    }

    @DeleteMapping(path="{id}")
    public void DeletarUsario(@PathVariable long id) {
        userService.DeletarUsario(id);
    }
}
