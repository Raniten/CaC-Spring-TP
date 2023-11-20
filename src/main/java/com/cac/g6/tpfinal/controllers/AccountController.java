package com.cac.g6.tpfinal.controllers;

import com.cac.g6.tpfinal.entities.Account;
import com.cac.g6.tpfinal.entities.dto.AccountDto;
import com.cac.g6.tpfinal.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    //OBTENER la lista de TODAS las cuentas (GET)
    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    //OBTENER UNA SOLA cuenta por su ID (GET)
    @GetMapping(value="/{idAccount}")
    public ResponseEntity<Account> findByID(@PathVariable("idAccount") Long idAccount) {
        Optional<Account> optAccount = service.findById(idAccount);
        if(optAccount.isPresent()){
            return  ResponseEntity.ok(optAccount.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    //CREAR UNA SOLA cuenta (POST)
    @PostMapping
    public Account save(@RequestBody AccountDto newAccount) {
        return service.createAccount(newAccount);
    }

    // ELIMINAR UNA SOLA cuenta (DELETE)
    @DeleteMapping("/{idA}")
    public ResponseEntity<Void> deleteById(@PathVariable("idA") Long idA) {

        service.deleteAccountById(idA);
        return ResponseEntity.noContent().build();
    }

}
