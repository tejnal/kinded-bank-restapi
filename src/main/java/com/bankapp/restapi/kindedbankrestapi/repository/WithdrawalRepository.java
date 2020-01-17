package com.bankapp.restapi.kindedbankrestapi.repository;

import com.bankapp.restapi.kindedbankrestapi.domain.entity.Withdrawals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project spring-bank-app
 * @autor tejnal on 2020-01-12
 */
@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawals, Long> {

    List<Withdrawals> findTransactionsByCustomerAccountId(long id);
}
