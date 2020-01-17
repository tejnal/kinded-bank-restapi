package com.bankapp.restapi.kindedbankrestapi.controllers;

import com.bankapp.restapi.kindedbankrestapi.common.CustomerAccountUtils;
import com.bankapp.restapi.kindedbankrestapi.domain.entity.CustomerAccount;
import com.bankapp.restapi.kindedbankrestapi.domain.entity.Transaction;
import com.bankapp.restapi.kindedbankrestapi.enums.TransactionTypes;
import com.bankapp.restapi.kindedbankrestapi.modal.CustomerTransaction;
import com.bankapp.restapi.kindedbankrestapi.repository.CustomerAccountRepository;
import com.bankapp.restapi.kindedbankrestapi.repository.TransactionRepository;
import com.bankapp.restapi.kindedbankrestapi.response.ErrorHandling;
import com.bankapp.restapi.kindedbankrestapi.response.ErrorHandlingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-16
 */
@RestController
public class TransactionController {


    private static final double MAX_DEPOSIT_LIMIT_PER_TRANSACTION = 5000;
    private static final double MAX_DEPOSIT_LIMIT_PER_DAY = 15000;
    private static final int MAX_DEPOSIT_TRANSACTIONS_PER_DAY = 10;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @GetMapping("/accounts/{id}/deposits")
    public List<Transaction> retrieveCoursesForStudent(@PathVariable long accountId) {
        return transactionRepository.findTransactionsByCustomerAccountId(accountId);
    }

//    @PostMapping("/accounts/{id}/deposit")
//    public @ResponseBody ErrorHandling depositRequest(@PathVariable long accountId, @RequestBody CustomerTransaction customerTransaction) {
//
//        ErrorHandling errorHandling = new ErrorHandlingImpl();
//
//        try {
//
//            double total = 0;
//            List<Transaction> deposits  = transactionRepository.findByDateBetweenAndType(CustomerAccountUtils.getStartOfDay(new Date()),
//                    CustomerAccountUtils.getEndOfDay(new Date()), TransactionTypes.DEPOSIT.getId());
//
//            if (deposits.size() > 0) {
//                for (Transaction accountTransaction: deposits) {
//                    total+= accountTransaction.getAmount();
//                }
//                if (total  + customerTransaction.getAmount()  > MAX_DEPOSIT_LIMIT_PER_DAY) {
//                    errorHandling.setSuccess(false, "Error", "Deposit for the day should not be more than $150K");
//                    jsonResponse.setHttpResponseCode(HttpStatus.SC_NOT_ACCEPTABLE);
//                    return jsonResponse;
//                }
//            }
//
//    }


}
