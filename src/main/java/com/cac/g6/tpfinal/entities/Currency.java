package com.cac.g6.tpfinal.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurrency;

    private String name;
    private String code;
}
