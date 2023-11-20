package com.cac.g6.tpfinal.services;

import com.cac.g6.tpfinal.entities.Account;
import com.cac.g6.tpfinal.entities.User;
import com.cac.g6.tpfinal.entities.dto.AccountDto;
import com.cac.g6.tpfinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final RandomCodeGeneratorService randomCode;

    public AccountService (AccountRepository repository, RandomCodeGeneratorService randomCode) {
        this.accountRepository = repository;
        this.randomCode = randomCode;
    }


    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(AccountDto requestAccount) {
        Account account = null;
        User user = new User();
        user.setIdUser(requestAccount.getUser());

        //Generamos un alias random hasta que no exista en la BBDD
        do {
            account.setAlias(randomCode.generateRandomAlias());
        } while (accountRepository.existsByAlias(account.getAlias()));

        //Generamos un número de cuenta random de 10 dígitos hasta que no exista en la BBDD
        do {
            account.setAccountNumber(randomCode.generateRandomDigits(10));
        } while (accountRepository.existsByAccountNumber(account.getAccountNumber()));

        account.setCbu("23650" + account.getAccountNumber() + randomCode.generateRandomDigits(16));

        account.setBalance(10000.0f);
        account.getUser().getAccounts().add(account);

        return accountRepository.save(account);

    }

    public void deleteAccountById (Long id) {
        accountRepository.deleteById(id);
    }

    public String generateRandomAlias() {
        String[] words = {"manzana", "gato", "sol", "casa", "rojo", "agua", "luz", "tierra", "mar", "hoja",
                "perro", "azul", "noche", "flor", "nieve", "nube", "viento", "planta", "libro", "cielo",
                "guitarra", "café", "montaña", "ciudad", "pájaro", "diente", "fruta", "delfín", "luna", "puente",
                "río", "ojo", "estrella", "naranja", "piedra", "camino", "ventana", "música", "cuerpo", "playa",
                "árbol", "corazón", "caracol", "tren", "elefante", "nube", "lápiz", "pintura", "camisa", "silla"};
        Random random = new Random();

        // Elegir tres palabras aleatorias
        String alias;
        do {
            alias = words[random.nextInt(words.length)] + "." +
                    words[random.nextInt(words.length)] + "." +
                    words[random.nextInt(words.length)];
        } while (accountRepository.existsByAccountNumber(alias));

        return alias;
    }

    public String generateAccountNumber() {
        String accountNumber;
        do {
            accountNumber = this.generateRandomDigits(10);
        } while (accountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
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
