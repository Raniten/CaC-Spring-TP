package com.cac.g6.tpfinal.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="transfers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "id_account_sender")
    private String idAccountSender;

    @Column(name = "id_account_recipient")
    private String idAccountRecipient;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "amount")
    private float amount;

}
