package com.cac.g6.tpfinal.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Entity
@Table(name="accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;

    @Column(name = "account_number",unique = true)
    private String accountNumber;

    private float balance;
    private String cbu;
    private String alias;
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public static String generateRandomAlias() {
        String[] words = {"manzana", "gato", "sol", "casa", "rojo", "agua", "luz", "tierra", "mar", "hoja",
                "perro", "azul", "noche", "flor", "nieve", "nube", "viento", "planta", "libro", "cielo",
                "guitarra", "café", "montaña", "ciudad", "pájaro", "diente", "fruta", "delfín", "luna", "puente",
                "río", "ojo", "estrella", "naranja", "piedra", "camino", "ventana", "música", "cuerpo", "playa",
                "árbol", "corazón", "caracol", "tren", "elefante", "nube", "lápiz", "pintura", "camisa", "silla"};
        Random random = new Random();

        // Elegir tres palabras aleatorias
        String randomAlias = words[random.nextInt(words.length)] + "." +
                words[random.nextInt(words.length)] + "." +
                words[random.nextInt(words.length)];

        return randomAlias;
    }


}
