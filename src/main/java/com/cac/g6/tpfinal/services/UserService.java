package com.cac.g6.tpfinal.services;

import com.cac.g6.tpfinal.entities.User;
import com.cac.g6.tpfinal.entities.dtos.UserDTO;
import com.cac.g6.tpfinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository repository;

    public UserService (UserRepository repository) {
        this.repository = repository;
    }


    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).get();

    }

    public User addUser (User newUser) {
        repository.save(newUser);
        return newUser;

    }
}
