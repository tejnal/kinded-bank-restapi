package com.bankapp.restapi.kindedbankrestapi.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-16
 */
@Getter
public enum TransactionTypes {
    DEPOSIT(1), WITHDRAWAL(2);


    private int id;

    TransactionTypes(int id){

        this.id = id;
    }





}
