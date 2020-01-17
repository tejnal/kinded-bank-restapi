package com.bankapp.restapi.kindedbankrestapi.controllers;

import com.bankapp.restapi.kindedbankrestapi.domain.entity.CustomerAccount;
import com.bankapp.restapi.kindedbankrestapi.exception.ResourceNotFoundException;
import com.bankapp.restapi.kindedbankrestapi.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-17
 */
@RestController
public class BalanceController {
    @Autowired
    CustomerAccountRepository customerAccountRepository;

    @GetMapping("/accounts/{id}/balance")
    public String getCustomerBalance(@PathVariable("id") Long accountId) {

        CustomerAccount customerAccount =  customerAccountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("CustomerAccount", "id", accountId));;
        return customerAccount.getBalance().toString();


    }
}
