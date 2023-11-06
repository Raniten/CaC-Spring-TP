package com.cac.g6.tpfinal.controllers;

import com.cac.g6.tpfinal.entities.User;
import com.cac.g6.tpfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private final UserService service;

    public UserController(UserService service) {

        this.service = service;
    }

    //OBTENER la lista de TODOS los usuarios (GET)
    @GetMapping(value="/users")
    public List<User> getUsers() {
        return service.getUsers();

    }

    //OBTENER UN SOLO usuario por su ID (GET)
    @GetMapping(value="/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }


    /*//CREAR UN SOLO usario (POST)
    @PostMapping(value = "/users")
    public UserDTO createUser(@RequestBody UserDTO newUser) {

        return service.addUser(newUser);

    }*/

    //CREAR UN SOLO usario (POST)
    @PostMapping(value = "/users")
    public User createUser(@RequestBody User newUser) {

        return service.addUser(newUser);

    }


    //Modificar TOTALMENTE UN SOLO usuario (PUT)
    public String updateFullUser(Long id) {

        return "";
    }

    //Modificar PARCIALMENTE UN SOLO usuario (PATCH)
    public String updatePartialUser(Long id){

        return "";
    }

    // ELIMINAR UN SOLO usuario (DELETE)
    @DeleteMapping (value="/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
