package com.cac.g6.tpfinal.services;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RandomCodeGeneratorService {

    public String generateRandomAlias() {
        String[] words = {"manzana", "gato", "sol", "casa", "rojo", "agua", "luz", "tierra", "mar", "hoja",
                "perro", "azul", "noche", "flor", "nieve", "nube", "viento", "planta", "libro", "cielo",
                "guitarra", "café", "montaña", "ciudad", "pájaro", "diente", "fruta", "delfín", "luna", "puente",
                "río", "ojo", "estrella", "naranja", "piedra", "camino", "ventana", "música", "cuerpo", "playa",
                "árbol", "corazón", "caracol", "tren", "elefante", "nube", "lápiz", "pintura", "camisa", "silla"};
        Random random = new Random();

        // Elegir tres palabras aleatorias

        return words[random.nextInt(words.length)] + "." +
                words[random.nextInt(words.length)] + "." +
                words[random.nextInt(words.length)];
    }

    public String generateRandomDigits(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("La longitud debe ser mayor que cero.");
        }

        Random random = new Random();
        // Generar una secuencia de dígitos aleatorios y convertirla en un String
        String randomDigits = random.ints(length, 0, 10) // Dígitos del 0 al 9
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());

        return randomDigits;
    }
}
