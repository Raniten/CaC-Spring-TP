package com.cac.g6.tpfinal.services;

import com.cac.g6.tpfinal.entities.Account;
import com.cac.g6.tpfinal.entities.User;
import com.cac.g6.tpfinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository repository;

    public AccountService (AccountRepository repository) {
        this.repository = repository;
    }


    public List<Account> getAccounts() {
        return repository.findAll();
    }

    public Account getAccountById(Long id) {
        return repository.findById(id).get();

    }

    public Account addAccount (Account newAccount) {
        repository.save(newAccount);
        return newAccount;
    }

//    public Account createAccount(User user) {
//        // Crea una nueva cuenta
//        Account account = new Account();
//        account.setAccountNumber(user.getDni());
//        account.setBalance(10000.0f);
//
//        // Asocia la cuenta al usuario
//        account.setUser(user);
//
//        // Guarda la cuenta
//        //repository.save(account);
//
//        return account;
//    }

    public Account createAccount(User user) {
        Account account = new Account();
        account.setAccountNumber(user.getDni());
        account.setBalance(10000.0f);

        return repository.save(account);
    }

    public void deleteAccountById (Long id) {
        repository.deleteById(id);
    }
}
