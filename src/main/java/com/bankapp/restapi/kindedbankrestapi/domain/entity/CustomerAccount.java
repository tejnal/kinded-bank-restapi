package com.bankapp.restapi.kindedbankrestapi.domain.entity;

import com.bankapp.restapi.kindedbankrestapi.enums.Currency;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-16
 */
@Entity
@Table(name="customer_accounts")
@Getter
@Setter
@ToString
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long id;


    @OneToMany(
            mappedBy = "customerAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
//    @Column(nullable = true)
//    @JsonManagedReference
    private List<Withdrawals> withdrawals;

    @OneToMany(
            mappedBy = "customerAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
//    @Column(nullable = true)
//    @JsonManagedReference
    private List<Deposits> deposits;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @NotBlank
    private String name;

    @Column(name = "balance", nullable = false)
    private Double balance;

    public CustomerAccount() {
    }

    public CustomerAccount( @NotBlank String name,Currency currency, Double balance) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }
}
