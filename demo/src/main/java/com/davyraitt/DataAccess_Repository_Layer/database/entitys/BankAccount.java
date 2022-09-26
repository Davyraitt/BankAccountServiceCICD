package com.davyraitt.DataAccess_Repository_Layer.database.entitys;

import lombok.Singular;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="BankAccount")
public class BankAccount extends BaseEntity {
	@Column(unique = true)
	private String IBAN;

	@Column(name = "balance")
	private double balance;

	@Singular
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "bankAccountHolders",
	joinColumns = @JoinColumn(name = "holder_id"), // specify the name of the column that stores the foreign key (owning side)
			inverseJoinColumns = @JoinColumn(name = "accountholder_id") // specify the column name of the non-owning side
	)
	private List<AccountHolder> accountHoldersOfThisBankAccount = new ArrayList<AccountHolder>();

	@Column(name = "active")
	private boolean active;

	public BankAccount(String IBAN, double balance, boolean active) {
		this.IBAN = IBAN;
		this.balance = balance;
		this.active = active;
	}

	public BankAccount() {

	}

	@Override
	public String toString() {
		return "BankRekening{" +
				"IBAN='" + IBAN + '\'' +
				", saldo=" + balance +
				", rekeningHouders:"   + accountHoldersOfThisBankAccount +
				", active=" + active +
				'}';
	}

	public void addAccountHolder(AccountHolder accountholder){
		accountHoldersOfThisBankAccount.add(accountholder);
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

	public ArrayList<AccountHolder> getAccountHolders() {
		return (ArrayList<AccountHolder>) accountHoldersOfThisBankAccount;
	}

	//TODO: Add acount holders method

	public void setAccountHolders(ArrayList<AccountHolder> accountHolders) {
		this.accountHoldersOfThisBankAccount = accountHolders;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<AccountHolder> getAccountHoldersOfThisBankAccount() {
		return accountHoldersOfThisBankAccount;
	}

	public void setAccountHoldersOfThisBankAccount(List<AccountHolder> accountHoldersOfThisBankAccount) {
		this.accountHoldersOfThisBankAccount = accountHoldersOfThisBankAccount;
	}
}
