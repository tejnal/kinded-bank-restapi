package com.bankapp.restapi.kindedbankrestapi.controllers;

import com.bankapp.restapi.kindedbankrestapi.common.CurrencyUtils;
import com.bankapp.restapi.kindedbankrestapi.domain.entity.CustomerAccount;
import com.bankapp.restapi.kindedbankrestapi.domain.entity.Deposits;
import com.bankapp.restapi.kindedbankrestapi.enums.Currency;
import com.bankapp.restapi.kindedbankrestapi.exception.ResourceNotFoundException;
import com.bankapp.restapi.kindedbankrestapi.repository.CustomerAccountRepository;
import com.bankapp.restapi.kindedbankrestapi.repository.DepositRepository;
import com.bankapp.restapi.kindedbankrestapi.resource.DepositForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-17
 */
@RestController
public class DepositController {

    private static final Logger logger = LoggerFactory.getLogger(DepositController.class);

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private CustomerAccountRepository customerAccountRepository;


    @GetMapping("/accounts/{id}/deposits")
    public List<Deposits> listDepositsForCustomerId(@PathVariable("id") Long id ) {
        return depositRepository.findTransactionsByCustomerAccountId(id);
    }


    @PostMapping("/accounts/{id}/deposit")
    public List<Deposits> createDeposit (@PathVariable("id") Long accountId, @RequestBody DepositForm depositForm) {

        Currency currency = CurrencyUtils.convertStringToCurrency(depositForm.getCurrency());
        var amount = depositForm.getAmount();

        CustomerAccount customerAccount =  customerAccountRepository.findById(accountId)
                 .orElseThrow(() -> new ResourceNotFoundException("CustomerAccount", "id", accountId));

        if(customerAccount !=null && customerAccount.getBalance() > 0) {

            Deposits deposits = new Deposits(customerAccount, currency, amount, new Date());
            customerAccount.setBalance(customerAccount.getBalance() + amount);
            customerAccountRepository.save(customerAccount);
            depositRepository.save(deposits);
        } else {
            logger.info("Error post a deposit");
        }
        return depositRepository.findTransactionsByCustomerAccountId(accountId);

    }
}
