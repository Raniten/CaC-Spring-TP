package com.cac.g6.tpfinal.controllers;

import com.cac.g6.tpfinal.entities.User;
import com.cac.g6.tpfinal.entities.dto.UserDto;
import com.cac.g6.tpfinal.services.CurrencyService;
import com.cac.g6.tpfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final CurrencyService currencyService;

    public UserController(UserService service, CurrencyService currencyService) {
        this.userService = service;
        this.currencyService = currencyService;
    }

    //OBTENER la lista de TODOS los usuarios (GET)
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();

    }

    //OBTENER UN SOLO usuario por su ID (GET)
    @GetMapping(value="/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    /*//CREAR UN SOLO usario (POST)
    @PostMapping(value = "/users")
    public UserDTO createUser(@RequestBody UserDTO newUser) {

        return service.addUser(newUser);

    }*/

    //CREAR UN SOLO usario (POST)
    @PostMapping
    public User createUser(@RequestBody UserDto newUser) {

        return userService.addUser(currencyService, newUser);
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
    @DeleteMapping (value="/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
