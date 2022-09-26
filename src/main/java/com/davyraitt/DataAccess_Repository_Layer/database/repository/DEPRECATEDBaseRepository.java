//package com.davyraitt.DataAccess_Repository_Layer.database.repository;
//
//import com.davyraitt.DataAccess_Repository_Layer.database.entitys.BankAccount;
//import com.davyraitt.DataAccess_Repository_Layer.database.entitys.AccountHolder;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//
//@Repository
//public class BaseRepository {
//
//    protected static ArrayList<BankAccount> bankAccountsList = new ArrayList<>();
//    protected static ArrayList<AccountHolder> accountHoldersList = new ArrayList<>();
//
//
//    // get repository of account holders
//    public static ArrayList<AccountHolder> getAccountHoldersList() {
//        return accountHoldersList;
//    }
//
//    // get repository of bank accounts
//    public ArrayList<BankAccount> getBankAccountsList() {
//        return bankAccountsList;
//    }
//
//
//    // add to account holders
//    public void addToAccountHolderList(AccountHolder tempAccountHolder)
//    {
//        System.out.println("Added: " + tempAccountHolder.toString());
//        this.accountHoldersList.add(tempAccountHolder);
//    }
//
//
//    //add to bank accounts
//    public void addToBankAccountsList(BankAccount tempBankAccount)
//    {
//        System.out.println("adding: " + tempBankAccount);
//
//        this.bankAccountsList.add(tempBankAccount);
//
//        //System.out.println("Added: " + tempBankAccount.toString());
//    }
//
//
//
//
//}


