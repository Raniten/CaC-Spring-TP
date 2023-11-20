package com.cac.g6.tpfinal.entities.dto;

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
    private Long user;
    private Long currency;


}
