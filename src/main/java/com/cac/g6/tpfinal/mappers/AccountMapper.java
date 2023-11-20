package com.cac.g6.tpfinal.mappers;

import com.cac.g6.tpfinal.entities.*;
import com.cac.g6.tpfinal.entities.dto.AccountDto;
import com.cac.g6.tpfinal.entities.dto.CurrencyDto;
import com.cac.g6.tpfinal.repositories.UserRepository;
import com.cac.g6.tpfinal.services.CurrencyService;
import com.cac.g6.tpfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public class AccountMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  static CurrencyService currencyService ;

    @Autowired
    private static UserService userService;


    public static Account dtoToAccount(AccountDto dto){
        Account account;
        Currency currency = currencyService.getCurrencyById(dto.getCurrency());

        if (dto.getAccountType().equalsIgnoreCase("SAVINGS")) {
            account = new AccountBuilder().buildSavingsAccount(dto.getIdAccount(), dto.getAccountNumber(), dto.getBalance(), dto.getCbu(), dto.getAlias(), userService.getUserById(dto.getUser()), currency, dto.getAmount());
        } else if (dto.getAccountType().equalsIgnoreCase("CURRENT")) {
            account = new AccountBuilder().buildCurrentAccount(dto.getIdAccount(), dto.getAccountNumber(), dto.getBalance(), dto.getCbu(), dto.getAlias(), userService.getUserById(dto.getUser()), currency, dto.getAmount());
        } else {
            account = new Account();
        }

        return account;
    }

    public static AccountDto accountToDto(Account account){
        CurrencyDto dto = new CurrencyDto();
        AccountDto accountDto;
        float amount;
        Long currency;
        String accountType;

        if (account instanceof SavingsAccount) {
            accountType = "SAVINGS";
            amount = ((SavingsAccount) account).getMaxTransferAmount();
            currency = account.getCurrency().getIdCurrency();
            accountDto = new AccountDto(account.getIdAccount(), account.getAccountNumber(), account.getBalance(), account.getCbu(), account.getAlias(), accountType, amount, account.getUser().getIdUser(), currency);
        } else if (account instanceof CurrentAccount) {
            accountType = "SAVINGS";
            amount = ((CurrentAccount) account).getOverdraftLimit();
            currency = account.getCurrency().getIdCurrency();
            accountDto = new AccountDto(account.getIdAccount(), account.getAccountNumber(), account.getBalance(), account.getCbu(), account.getAlias(), accountType, amount, account.getUser().getIdUser(), currency);

        } else {
            accountDto = new AccountDto();
        }

        return accountDto;
    }
}
