package com.davyraitt.Presentatie_Controller_Layer.dto;

import com.davyraitt.DataAccess_Repository_Layer.database.entitys.AccountHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class BankAccountDTO {

    private String IBAN;
    private double balance;

    private boolean active;

    public BankAccountDTO() {
    }

    public BankAccountDTO(String IBAN, double balance, boolean active) {
        this.IBAN = IBAN;
        this.balance = balance;
        this.active = active;
    }

    @Override
    public String toString() {
        return "BankAccountDTO{" +
                "IBAN='" + IBAN + '\'' +
                ", balance=" + balance +
                ", active=" + active +
                '}';
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
