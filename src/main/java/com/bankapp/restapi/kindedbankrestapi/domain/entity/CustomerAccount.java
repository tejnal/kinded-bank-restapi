package com.bankapp.restapi.kindedbankrestapi.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-16
 */
@Entity
@Table(name="customer_accounts")
@Getter
@Setter
@ToString
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long id;

    @NotBlank
    private String name;

    @Column(name = "balance", nullable = false)
    private Double balance;

    public CustomerAccount() {
    }

    public CustomerAccount(@NotBlank String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }
}
