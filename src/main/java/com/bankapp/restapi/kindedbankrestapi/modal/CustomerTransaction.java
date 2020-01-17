package com.bankapp.restapi.kindedbankrestapi.modal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-17
 */
@Setter
@Getter
@ToString
public class CustomerTransaction {

    private double amount;

    public CustomerTransaction(double amount) {
        this.amount = amount;
    }
}
