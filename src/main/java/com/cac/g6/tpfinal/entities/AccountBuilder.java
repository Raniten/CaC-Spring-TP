package com.cac.g6.tpfinal.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor

public class AccountBuilder {
    private Long id;
    private String accountNumber;
    private float balance;
    private String cbu;
    private String alias;
    private User user;
    private Currency currency;
    private float maxTransferAmount;  // Atributo específico de SavingsAccount
    private float overdraftLimit;     // Atributo específico de CurrentAccount

    // Métodos para establecer los atributos específicos de SavingsAccount y CurrentAccount

    // Método para construir una SAVINGSACCOUNT

    public SavingsAccount buildSavingsAccount(Long id, String accountNumber, float balance, String cbu, String alias, User user, Currency currency, float maxTransferAmount) {
        return new SavingsAccount(id, accountNumber, balance, cbu, alias, user, currency, maxTransferAmount);
    }

    // Método para construir una CURRENTACCOUNT

    public CurrentAccount buildCurrentAccount(Long id, String accountNumber, float balance, String cbu, String alias, User user, Currency currency, float overdraftLimit) {
        return new CurrentAccount(id, accountNumber, balance, cbu, alias, user, currency, overdraftLimit);
    }



}