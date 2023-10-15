package com.cac.g6.tpfinal.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<String> getUsers() {
        List<String> users = new ArrayList<String>();

        users.add("Usuario 1");
        users.add("Usuario 2");
        users.add("Usuario 3");
        users.add("Usuario 4");
        users.add("Usuario 5");

        return users;
    }

    public String getUserById(long id) {
        List<String> users = new ArrayList<String>();

        users.add("Usuario 1");
        users.add("Usuario 2");
        users.add("Usuario 3");
        users.add("Usuario 4");
        users.add("Usuario 5");

        if(id <= users.size() && id > 0) {
            return users.get(Integer.parseInt(String.valueOf(id-1)));
        } else {
            return "ID inválida, no existe ese usuario (sólo cargamos 5)";
        }
    }
}
