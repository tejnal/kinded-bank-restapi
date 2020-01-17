package com.bankapp.restapi.kindedbankrestapi.repository;

import com.bankapp.restapi.kindedbankrestapi.domain.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-16
 */
@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
    CustomerAccount findCustomerAccountById(long id);

}
