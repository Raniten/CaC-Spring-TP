package com.cac.g6.tpfinal.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("CURRENT")

public class CurrentAccount extends Account {
    private float overdraftLimit;

    public CurrentAccount(Long id, String accountNumber, float balance, String cbu, String alias, User user, Currency currency, float overdraftLimit) {
        super(id, accountNumber, balance, cbu, alias, AccountType.CURRENT, user, currency);
        this.overdraftLimit = overdraftLimit;
    }
}