package com.cac.g6.tpfinal.controllers;

import com.cac.g6.tpfinal.entities.Currency;
import com.cac.g6.tpfinal.entities.dto.CurrencyDto;
import com.cac.g6.tpfinal.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currencies")

public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<List<Currency>> getCurrencies(){
        return ResponseEntity.status(HttpStatus.OK).body(currencyService.getCurrencies());
    }

    // Obtener la info de un solo CURRENCY


    @GetMapping(value = "/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(currencyService.getCurrencyById(id));
    }

    // Crear/Registrar un CURRENCY

    @PostMapping
    public ResponseEntity<CurrencyDto> createCurrency(@RequestBody CurrencyDto currencyDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyService.createCurrency(currencyDto));
    }



}
