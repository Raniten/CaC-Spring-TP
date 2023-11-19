package com.cac.g6.tpfinal.entities.dto;

import com.cac.g6.tpfinal.entities.AccountType;
import com.cac.g6.tpfinal.entities.Currency;
import com.cac.g6.tpfinal.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AccountDto {

    private Long idAccount;
    private String accountNumber;
    private float balance;
    private String cbu;
    private String alias;
    private String accountType;
    private float amount;
    private User user;
    private Long currency;


}
