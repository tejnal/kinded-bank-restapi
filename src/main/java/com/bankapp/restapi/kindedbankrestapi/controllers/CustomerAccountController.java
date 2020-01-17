package com.bankapp.restapi.kindedbankrestapi.controllers;

import com.bankapp.restapi.kindedbankrestapi.domain.entity.CustomerAccount;
import com.bankapp.restapi.kindedbankrestapi.exception.ResourceNotFoundException;
import com.bankapp.restapi.kindedbankrestapi.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-16
 */
@RestController
@RequestMapping("/")
public class CustomerAccountController {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @GetMapping("accounts/all")
    public List<CustomerAccount> getAllAccounts(){
        return customerAccountRepository.findAll();

    }

    @GetMapping("accounts/{id}")
    public CustomerAccount getCustomerAccountById(@PathVariable(value = "id") long accountId) {
        return customerAccountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("CustomerAccount", "id", accountId));

    }

    @PostMapping("accounts/new")
    public CustomerAccount createAccount(@Valid @RequestBody CustomerAccount customerAccount) {
        return customerAccountRepository.save(customerAccount);
    }

    @PutMapping("accounts/{id}")
    public CustomerAccount updateAmount(@PathVariable(value = "id") long accountId, @RequestParam("amount") double amount) {

        CustomerAccount account = customerAccountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        account.setBalance(account.getBalance() + amount);
        CustomerAccount updatedAccount = customerAccountRepository.save(account);
        return updatedAccount;
    }

    @DeleteMapping("accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") long accountId) {
        CustomerAccount account = customerAccountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        customerAccountRepository.delete(account);
        return ResponseEntity.ok().build();
    }



}
