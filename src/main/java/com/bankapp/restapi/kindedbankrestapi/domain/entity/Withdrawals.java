package com.bankapp.restapi.kindedbankrestapi.domain.entity;

import com.bankapp.restapi.kindedbankrestapi.enums.Currency;
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
@Getter
@Setter
@ToString
public class Withdrawals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "withdrawal_id")
    private long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_account_id", nullable = false)
    //@JsonManagedReference
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
