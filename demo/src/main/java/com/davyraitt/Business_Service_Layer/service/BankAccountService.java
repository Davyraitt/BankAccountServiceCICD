package com.davyraitt.Business_Service_Layer.service;

import com.davyraitt.DataAccess_Repository_Layer.database.entitys.AccountHolder;
import com.davyraitt.DataAccess_Repository_Layer.database.entitys.BankAccount;
import com.davyraitt.DataAccess_Repository_Layer.database.repository.AccountHolderRepository;
import com.davyraitt.DataAccess_Repository_Layer.database.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional
public class BankAccountService {

    private final AccountHolderRepository accountHolderRepository;
    private final BankAccountRepository bankAccountRepository;

    public BankAccount create(BankAccount accountToSave, String bsn) {
        //TODO: checking, returning correct result and error etc..

        //check if BankAccount already exists
        Optional<BankAccount> bankAccount = bankAccountRepository.findByIBAN(accountToSave.getIBAN());
        if (bankAccount.isPresent()) {
            return null;
        }

        //check if there is an accountholder with the provided bsn
        Optional<AccountHolder> accountHolder = accountHolderRepository.findByBsn(bsn);
        if (accountHolder.isPresent()) {
            //IF there is an accountholder with the specified BSN, we add it to the bankaccount
            accountToSave.addAccountHolder(accountHolder.get());
        }
        bankAccountRepository.save(accountToSave);
        return accountToSave;
    }

    public List<BankAccount> get() {
        return bankAccountRepository.findAll();
    }

    public BankAccount delete(UUID id){
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);

        if (bankAccount.isPresent()) {
            bankAccountRepository.deleteById(id);
            return bankAccount.get();
        }
        else {
            return null;
        }
    }

    public BankAccount patch(UUID id, boolean active){
//        The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values.
//        The class was introduced in the java.
//        util package to remove the need for multiple null checks to protect against the dreaded NullPointerExceptions during run-time.
//
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        if (!bankAccount.isPresent()) {
            return null;
        }
            bankAccount.get().setActive(active);
            bankAccountRepository.save(bankAccount.get());
            return bankAccount.get();
    }




}
