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
public class AccountHolderService {

    private final AccountHolderRepository accountHolderRepository;
    private final BankAccountRepository bankAccountRepository;

    public AccountHolder create(AccountHolder accountToSave, String IBAN) {
        // if there is a bank accout with this IBAN, automatically add the account to it!
       Optional<BankAccount> optionalBankAccount = bankAccountRepository.findByIBAN(IBAN);

       List<AccountHolder> accountList = accountHolderRepository.findAll();
        for (int i = 0; i < accountList.size(); i++) {

            //if BSN already exists we wont add it
            if (accountList.get(i).getBsn() == accountToSave.getBsn())
            {
                return null;
            }
        }

        if (optionalBankAccount.isPresent()) {
            // if there is a bankacount with the IBAN, we add the bank account to the accountholder and save
            accountToSave.addBankAccount(optionalBankAccount.get());
        }
        accountHolderRepository.save(accountToSave);
        return accountToSave;

    }

    public List<AccountHolder> get() {

        //TODO: checking, returning correct result and error etc..
        return accountHolderRepository.findAll();
    }

    public AccountHolder delete(UUID id){
        try {
            Optional<AccountHolder> accountHolder = accountHolderRepository.findById(id);
            if (accountHolder.isPresent()) {
                accountHolderRepository.deleteById(id);
                return accountHolder.get();
            }
            else {
                return null;
            }
        }
        catch (Exception e){
            return null;
        }
    }

    public List<AccountHolder> getBankAccountsOfThisHolder(String IBAN) {
        return accountHolderRepository.findAllByHolderBsn(IBAN);
    }
}
