package com.cac.g6.tpfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="currencies")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurrency;

    private String name;
    private String code;
}
