package com.cac.g6.tpfinal.controllers;

import com.cac.g6.tpfinal.entities.Account;
import com.cac.g6.tpfinal.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private final AccountService service;

    public AccountController(AccountService service) {

        this.service = service;
    }

    //OBTENER la lista de TODAS las cuentas (GET)
    @GetMapping(value="/accounts")
    public List<Account> getAccounts() {
        return service.getAccounts();
    }

    //OBTENER UNA SOLA cuenta por su ID (GET)
    @GetMapping(value="/accounts/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return service.getAccountById(id);
    }

    //CREAR UNA SOLA cuenta (POST)
    @PostMapping(value = "/accounts")
    public Account createAccount(@RequestBody Account newAccount) {

        return service.addAccount(newAccount);

    }

    // ELIMINAR UNA SOLA cuenta (DELETE)
    @DeleteMapping(value="/accounts/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable Long id) {

        service.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

}
