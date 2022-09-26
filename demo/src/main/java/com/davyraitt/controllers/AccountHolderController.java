package com.davyraitt.controllers;

import com.davyraitt.Business_Service_Layer.service.AccountHolderService;
import com.davyraitt.DataAccess_Repository_Layer.database.entitys.AccountHolder;
import com.davyraitt.DataAccess_Repository_Layer.database.entitys.BankAccount;
import com.davyraitt.DataAccess_Repository_Layer.database.mapperinterfaces.AccountHolderMapper;
import com.davyraitt.DataAccess_Repository_Layer.database.mapperinterfaces.BankAccountMapper;
import com.davyraitt.Presentatie_Controller_Layer.dto.AccountHolderDTO;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountHolderController {

    AccountHolderMapper accountHolderMapper = Mappers.getMapper(AccountHolderMapper.class);

    BankAccountMapper bankAccountMapper = Mappers.getMapper(BankAccountMapper.class);

    AccountHolderService accountHolderService;

    public AccountHolderController(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }

    @GetMapping("/accountholders")
    @ResponseBody
    public List<AccountHolderDTO> getAccountHolders()
    {
        List<AccountHolder> listAccountHolders = accountHolderService.get();
        return accountHolderMapper.arrayListAccountHolderToDTO(listAccountHolders);
    }

    @PostMapping("/accountholders")
    @ResponseBody
        // Method
    ResponseEntity<String> insertAccountHolder(@RequestBody AccountHolderDTO accountHolderDTO, @RequestParam String IBAN)
    {
        //Convert DTO to entity
        AccountHolder accountHolder =  accountHolderMapper.dtoToEntity(accountHolderDTO);
        boolean added;
        AccountHolder accHldr = accountHolderService.create(accountHolder, IBAN);

        if (accHldr.equals(null)) {
            return new ResponseEntity<>("Did not insert account holder!  " + accountHolder.getBsn() + " already exists! ", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Inserted account holder!  " + accountHolder.toString(), HttpStatus.OK);
        }

    }

    //Delete rekeninghouder
    @DeleteMapping("/accountholders")
    // Method
    ResponseEntity<String> removeAccountHolder(@RequestParam UUID id)
    {
        AccountHolder accountHolder = accountHolderService.delete(id);

        if (accountHolder != null) {
            return new ResponseEntity<>("Deleted account holder! " + id, HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>("Could not remove account holder. Perhaps it doesn't exist? ", HttpStatus.BAD_REQUEST);
        }
    }

    //Er is dus een veel-op-veel relatie tussen rekeningen en rekeninghouders. Zorg dat alle rekeningen van een bepaalde rekeninghouder opgehaald kunnen worden
    @GetMapping("/retrieveAllBankAccountsFromHolder")
    public @ResponseBody List<AccountHolder> findAllHoldersByIban
    (@RequestParam String IBAN)
    {
        return accountHolderService.getBankAccountsOfThisHolder(IBAN);
    }

    //TODO: GET ALL ACCOUNTHOLDERS

}
