package com.bankapp.restapi.kindedbankrestapi.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-16
 */
@Entity
@Table(name = "transactions")
@Getter
@Setter
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="transaction_id")
    private Long id;

    private int type;

    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Transaction() {

    }

    public Transaction(int type, Double amount, Date date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }
}
