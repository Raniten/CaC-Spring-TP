package com.cac.g6.tpfinal.entities.dto;

import com.cac.g6.tpfinal.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private Long idUser;
    private String userName;
    private String email;
    private String password;
    private String dni;
    private LocalDate birthDate;
    private String address;
    private List<AccountDto> accounts;
}
