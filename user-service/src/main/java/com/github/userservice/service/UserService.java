package com.github.userservice.service;

import com.github.userservice.models.UserModel;
import com.github.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> ListarTodos() {
       return userRepository.findAll();
    }

    public UserModel BuscarId(long id) {
        return userRepository.findById(id);
    }

    public void DeletarUsario(long id) {
         userRepository.deleteById(id);
    }

    public UserModel AtualizarUsario(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserModel CriarUsuario(UserModel userModel) {
        return userRepository.save(userModel);
    }
}
