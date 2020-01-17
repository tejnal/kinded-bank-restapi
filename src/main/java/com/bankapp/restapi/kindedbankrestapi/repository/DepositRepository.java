package com.bankapp.restapi.kindedbankrestapi.repository;

import com.bankapp.restapi.kindedbankrestapi.domain.entity.Deposits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project spring-bank-app
 * @autor tejnal on 2020-01-16
 */
@Repository
public interface DepositRepository extends JpaRepository<Deposits, Long> {

    List<Deposits> findTransactionsByCustomerAccountId(long id);
}
