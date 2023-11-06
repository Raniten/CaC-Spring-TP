package com.cac.g6.tpfinal.services;

import com.cac.g6.tpfinal.entities.Account;
import com.cac.g6.tpfinal.entities.User;
import com.cac.g6.tpfinal.repositories.UserRepository;
import com.cac.g6.tpfinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository repository;

    @Autowired
    private final AccountService accountService;

    @Autowired
    private final AccountRepository accountRepository;

    public UserService (UserRepository repository) {

        this.repository = repository;
        accountService = null;
        accountRepository = null;
    }


    public List<User> getUsers() {

        return repository.findAll();
    }

    public User getUserById(Long id) {

        return repository.findById(id).get();

    }

    public User addUser (User user) {


        // Verifica si la cuenta existe
        //Account account = accountRepository.findById(user.getAccount().getIdAccount()).orElse(null);

        // Si la cuenta no existe, crea una nueva cuenta
        //if (account == null) {
        //    account = accountService.createAccount(user);
        //}

        Account account = accountService.createAccount(user);

        // Asocia la cuenta al usuario
        account.setUser(user);
        user.setAccount(account);

        // Guarda el usuario
        repository.save(user);

        // Guarda la cuenta
        //accountRepository.save(account);

        return user;
    }

    public void deleteUserById (Long id) {

        repository.deleteById(id);
    }
}
