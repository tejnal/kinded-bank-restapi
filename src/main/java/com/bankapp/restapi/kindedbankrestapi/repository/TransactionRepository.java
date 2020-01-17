package com.bankapp.restapi.kindedbankrestapi.repository;

import com.bankapp.restapi.kindedbankrestapi.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-16
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>  {
//    List<Transaction> findByDateBetweenAndType(Date StartOfDay, Date endOfDay, int type);
   List<Transaction> findTransactionsByCustomerAccountId(long id);

}
