package com.bankapp.restapi.kindedbankrestapi.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-17
 */
@Component
@Getter
@Setter
@Slf4j
public class WithdrawalForm {


    @NotEmpty
    @Length(min = 10, max = 22)
    private String iban;

    @NotEmpty
    @DecimalMin("0.00")
    @DecimalMax("99999999999.00")
    private double customerAccountBalance;

    @NotEmpty
    private long customerAccountId;

    @NotEmpty
    private String currency;


}
