package com.cac.g6.tpfinal.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.DiscriminatorValue;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("SAVINGS")

public class SavingsAccount extends Account {
    private float maxTransferAmount;

    public SavingsAccount(Long id, String accountNumber, float balance, String cbu, String alias, User user, Currency currency, float maxTransferAmount) {
        super(id, accountNumber, balance, cbu, alias, AccountType.SAVINGS, user, currency);
        this.maxTransferAmount = maxTransferAmount;
    }
}
