package com.bankapp.restapi.kindedbankrestapi.domain.entity;

import com.bankapp.restapi.kindedbankrestapi.enums.Currency;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-17
 */
@Entity
@Table(name= "withdrawals")
@ToString
@Getter
@Setter
public class Withdrawals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "withdrawal_id")
    private long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonBackReference
    private CustomerAccount customerAccount;

    @Column(name = "iban", nullable = false )
    private String iban;

    @Column(name = "withdrawal_amount", nullable = false)
    private Double withdrawalAmount;

    @Temporal(TemporalType.TIMESTAMP)
    Date creationDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    public Withdrawals() {

    }

    public Withdrawals(CustomerAccount customerAccount, String iban, Currency currency, Double withdrawalAmount, Date creationDateTime) {
        this.customerAccount = customerAccount;
        this.iban = iban;
        this.currency = currency;
        this.withdrawalAmount = withdrawalAmount;
        this.creationDateTime = creationDateTime;
    }

}
