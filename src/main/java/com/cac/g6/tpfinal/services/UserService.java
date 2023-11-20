package com.cac.g6.tpfinal.services;

import com.cac.g6.tpfinal.entities.*;
import com.cac.g6.tpfinal.entities.dto.AccountDto;
import com.cac.g6.tpfinal.entities.dto.UserDto;
import com.cac.g6.tpfinal.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AccountService accountService;

    @Autowired
    private final RandomCodeGeneratorService randomCodes;

    @Autowired
    private final CurrencyService currencyService;

    public UserService (UserRepository repository, AccountService accountService, RandomCodeGeneratorService randomCodes) {
        this.userRepository = repository;
        this.accountService = accountService;
        this.randomCodes = randomCodes;
        currencyService = null;
    }


    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public User getUserById(Long id) {

        return userRepository.findById(id).get();

    }

    /*public User addUser (User user) {


        // Verifica si la cuenta existe
        //Account account = accountRepository.findById(user.getAccount().getIdAccount()).orElse(null);

        // Si la cuenta no existe, crea una nueva cuenta
        //if (account == null) {
        //    account = accountService.createAccount(user);
        //}

        Account account = accountService.createAccount(user);

        // Asocia la cuenta al usuario
        account.setUser(user);
        //user.setAccount(account);

        // Guarda el usuario
        repository.save(user);

        // Guarda la cuenta
        //accountRepository.save(account);

        return user;
    }*/
    @Transactional
    public User addUser(UserDto requestUser) {
        User user = new User();

        user.setUserName(requestUser.getUserName());
        user.setEmail(requestUser.getEmail());
        user.setPassword(requestUser.getPassword());
        user.setDni(requestUser.getDni());
        user.setBirthDate(requestUser.getBirthDate());
        user.setAddress(requestUser.getAddress());

        List<Account> accounts = new ArrayList<>();

        Currency currency = new Currency();

        Account account = null;
        for (AccountDto accountRequest : requestUser.getAccounts()) {
            String actNbr = accountService.generateRandomDigits(10);
            String cbu = accountService.generateRandomDigits(15);

            if (accountRequest.getAccountType().equalsIgnoreCase("SAVINGS")) {
                account = new AccountBuilder().buildSavingsAccount(null, actNbr, 0.0F, "23650"+actNbr+cbu, accountService.generateRandomAlias(), user, currencyService.getCurrencyById(accountRequest.getCurrency()), accountRequest.getAmount());

            } else if (accountRequest.getAccountType().equalsIgnoreCase("CURRENT")) {
                account = new AccountBuilder().buildCurrentAccount(null, actNbr, 0.0F, "23650"+actNbr+cbu, accountService.generateRandomAlias(), user, currencyService.getCurrencyById(accountRequest.getCurrency()), accountRequest.getAmount());
            }
            accounts.add(account);
        }

        user.setAccounts(accounts);

        userRepository.save(user);
        return user;
    }

    public void deleteUserById (Long id) {

        userRepository.deleteById(id);
    }
}
