package com.anilerc.paymentmicroservice.application.core.domain;

import java.math.BigDecimal;

public class Customer {

    private Integer id;

    private String name;

    private BigDecimal accountBalance;


    public Customer() {
    }

    public Customer(Integer id, String name, BigDecimal accountBalance) {
        this.id = id;
        this.name = name;
        this.accountBalance = accountBalance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void debitBalance(BigDecimal amount) {
        this.accountBalance = this.accountBalance.subtract(amount);
    }
}
