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
@Table(name= "deposits")
@Getter
@Setter
@ToString
public class Deposits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deposit_id")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_account_id", nullable = false)
//    @JsonManagedReference
    private CustomerAccount customerAccount;

    //it is attribute for enum mapping in hibernate
    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @Column(name = "deposit_sum", nullable = false)
    private Double depositSum;

    @Temporal(TemporalType.TIMESTAMP)
    Date creationDateTime;

    public Deposits() {

    }

    public Deposits(CustomerAccount customerAccount, Currency currency, Double depositSum, Date creationDateTime) {
        this.customerAccount = customerAccount;
        this.currency = currency;
        this.depositSum = depositSum;
        this.creationDateTime = creationDateTime;
    }
}
