package com.github.userservice.service;

import com.github.userservice.models.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<UserModel> getAllUsers() {
        try {
            List<UserModel> users = userRepository.findAll();
            logger.info("Lista de usuários obtida com sucesso. Total de usuários: {}", users.size());
            return users;
        } catch (Exception e) {
            logger.error("Erro ao obter todos os usuários na camada de serviço", e);
            throw new RuntimeException("Erro ao obter todos os usuários", e);
        }
    }

    public Optional<UserModel> getUserById(Long userId) {
        try {
            Optional<UserModel> user = userRepository.findById(userId);

            if (user.isPresent()) {
                logger.info("Usuário encontrado com sucesso na camada de serviço. ID: {}, Nome: {}, Idade: {}", user.get().getId(), user.get().getName(), user.get().getAge());
            } else {
                logger.info("Nenhum usuário encontrado para o ID: {} na camada de serviço", userId);
            }

            return user;
        } catch (Exception e) {
            logger.error("Erro ao obter usuário por ID na camada de serviço", e);
            throw new RuntimeException("Erro ao obter usuário por ID", e);
        }
    }

    public UserModel createUser(UserModel user) {
        try {
            UserModel createdUser = userRepository.save(user);
            logger.info("Usuário criado com sucesso na camada de serviço. ID: {}, Nome: {}, Idade: {}", createdUser.getId(), createdUser.getName(), createdUser.getAge());
            return createdUser;
        } catch (Exception e) {
            logger.error("Erro ao criar usuário na camada de serviço", e);
            throw new RuntimeException("Erro ao criar usuário", e);
        }
    }

    public UserModel updateUser(Long userId, UserModel updatedUser) {
        try {
            Optional<UserModel> userOptional = userRepository.findById(userId);

            if (userOptional.isPresent()) {
                UserModel user = userOptional.get();
                user.setName(updatedUser.getName());
                user.setAge(updatedUser.getAge());
                userRepository.save(user);
                logger.info("Usuário atualizado com sucesso na camada de serviço. ID: {}, Nome: {}, Idade: {}", user.getId(), user.getName(), user.getAge());
                return user;
            } else {
                logger.info("Nenhum usuário encontrado para atualização na camada de serviço. ID: {}", userId);
                return null;
            }
        } catch (Exception e) {
            logger.error("Erro ao atualizar usuário na camada de serviço", e);
            throw new RuntimeException("Erro ao atualizar usuário", e);
        }
    }

    public void deleteUser(Long userId) {
        try {
            userRepository.deleteById(userId);
            logger.info("Usuário excluído com sucesso na camada de serviço. ID: {}", userId);
        } catch (Exception e) {
            logger.error("Erro ao excluir usuário na camada de serviço", e);
            throw new RuntimeException("Erro ao excluir usuário", e);
        }
    }
}
