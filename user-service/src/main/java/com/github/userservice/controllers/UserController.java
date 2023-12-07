package com.github.userservice.controllers;

import com.github.userservice.models.UserModel;
import com.github.userservice.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/usuario")
public class UserController {

     private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<UserModel>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/salvar")
    public ResponseEntity<UserModel> salvar(@RequestBody UserModel usuario) {
        return ResponseEntity.ok(repository.save(usuario));
    }
}

