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

    // Método para construir una SavingsAccount

    public SavingsAccount buildSavingsAccount() {
        return new SavingsAccount(id, accountNumber, balance, cbu, alias, user, currency, maxTransferAmount);
    }

    // Método para construir una CurrentAccount

    public CurrentAccount buildCurrentAccount() {
        return new CurrentAccount(id, accountNumber, balance, cbu, alias, user, currency, overdraftLimit);
    }
}