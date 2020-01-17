package com.bankapp.restapi.kindedbankrestapi.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@Component
@Getter
@Setter
@Slf4j
public class DepositForm {

    @NotEmpty
    @DecimalMin("0.00")
    @DecimalMax("99999999999.00")
    private double amount;

    @NotEmpty
    private String currency;

    @NotEmpty
    private long customerAccountId;

}
