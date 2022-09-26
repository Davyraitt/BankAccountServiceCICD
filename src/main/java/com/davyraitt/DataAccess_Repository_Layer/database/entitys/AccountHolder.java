package com.davyraitt.DataAccess_Repository_Layer.database.entitys;

import lombok.Singular;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="AccountHolder")
public class AccountHolder extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(unique = true)
//    The @GeneratedValue annotation is used to specify how the primary key should be generated.
    private String bsn;

    @ManyToMany(mappedBy="accountHoldersOfThisBankAccount")
    private List<BankAccount> bankAccountsOfThisHolder = new ArrayList<BankAccount>();

    public AccountHolder(String name, String bsn) {
        this.name = name;
        this.bsn = bsn;
    }

    public AccountHolder() {

    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccountsOfThisHolder.add(bankAccount);
    }

    @Override
    public String toString() {
        return "RekeningHouder{" +
                "naam='" + name + '\'' +
                ", bsn=" + bsn +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBsn() {
        return bsn;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public List<BankAccount> getBankAccountsOfThisHolder() {
        return bankAccountsOfThisHolder;
    }

    public void setBankAccountsOfThisHolder(List<BankAccount> bankAccountsOfThisHolder) {
        this.bankAccountsOfThisHolder = bankAccountsOfThisHolder;
    }
}
