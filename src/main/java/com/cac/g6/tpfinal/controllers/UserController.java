package com.cac.g6.tpfinal.controllers;

import com.cac.g6.tpfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<String> getUsers() {

        return service.getUsers();
        //return List.of("Lista de Usuarios (hardcode)");
    }

    //OBTENER UN SOLO usuario por su ID (GET)
    @GetMapping(value="/users/{id}")
    public String getUserById(@PathVariable long id) {
        /*String nombre;
        if(id==1){
            nombre="usuario1 (hardcode)";
        } else {
            nombre="otro suario que no es el 1 (harcode)";
        }

        return nombre;*/

        return service.getUserById(id);
    }

    //CREAR UN SOLO usario (POST)
    public void createUser() {

    }

    //Modificar TOTALMENTE UN SOLO usuario (PUT)
    public String updateFullUser(long id) {

        return "";
    }

    //Modificar PARCIALMENTE UN SOLO usuario (PATCH)
    public String updatePartialUser(long id){

        return "";
    }

    // ELIMINAR UN SOLO usuario (DELETE)
    public void deleteUserById(long id){


    }
}
