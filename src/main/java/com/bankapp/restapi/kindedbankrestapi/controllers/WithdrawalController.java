package com.bankapp.restapi.kindedbankrestapi.controllers;

import com.bankapp.restapi.kindedbankrestapi.common.CurrencyUtils;
import com.bankapp.restapi.kindedbankrestapi.domain.entity.CustomerAccount;
import com.bankapp.restapi.kindedbankrestapi.domain.entity.Withdrawals;
import com.bankapp.restapi.kindedbankrestapi.enums.Currency;
import com.bankapp.restapi.kindedbankrestapi.exception.ResourceNotFoundException;
import com.bankapp.restapi.kindedbankrestapi.repository.CustomerAccountRepository;
import com.bankapp.restapi.kindedbankrestapi.repository.WithdrawalRepository;
import com.bankapp.restapi.kindedbankrestapi.resource.WithdrawalForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-17
 */
@RestController
public class WithdrawalController {
    private static final Logger logger = LoggerFactory.getLogger(DepositController.class);

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Autowired
    private WithdrawalRepository withdrawalRepository;


    @GetMapping("/accounts/{id}/withdrawals")
    public List<Withdrawals> listWithdrawalForCustomerId(@PathVariable("id") Long id ) {
        return withdrawalRepository.findTransactionsByCustomerAccountId(id);
    }

    @PostMapping("/accounts/{id}/withdrawal")
    public List<Withdrawals> createWithdrawal (@PathVariable("id") Long accountId, @Valid @RequestBody WithdrawalForm withdrawalForm) {

        Currency currency = CurrencyUtils.convertStringToCurrency(withdrawalForm.getCurrency());

        var iban = withdrawalForm.getIban();
        var totalBalanceSum = withdrawalForm.getCustomerAccountBalance();

        CustomerAccount customerAccount =  customerAccountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("CustomerAccount", "id", accountId));

        if(customerAccount !=null && customerAccount.getBalance() >= totalBalanceSum) {

            Withdrawals withdrawals = new Withdrawals(customerAccount, iban, currency, totalBalanceSum, new Date());
            customerAccount.setBalance(customerAccount.getBalance() - totalBalanceSum);
            customerAccountRepository.save(customerAccount);
            withdrawalRepository.save(withdrawals);

        } else {
          logger.info("customer doesn't have sufficient funds");
        }
        return withdrawalRepository.findTransactionsByCustomerAccountId(accountId);

    }
}
