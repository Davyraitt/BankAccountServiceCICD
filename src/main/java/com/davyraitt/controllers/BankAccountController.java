package com.davyraitt.controllers;

import com.davyraitt.Business_Service_Layer.service.BankAccountService;
import com.davyraitt.DataAccess_Repository_Layer.database.entitys.BankAccount;
import com.davyraitt.DataAccess_Repository_Layer.database.mapperinterfaces.BankAccountMapper;
import com.davyraitt.Presentatie_Controller_Layer.dto.BankAccountDTO;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class BankAccountController {

    private BankAccountService bankAccountService;

    BankAccountMapper bankAccountMapper = Mappers.getMapper(BankAccountMapper.class);


    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }


    @PostMapping("/bankaccounts")
    @ResponseBody BankAccountDTO
        // Method
     insertBankAccount(@RequestBody BankAccountDTO bankAccountDTO,@RequestParam String bsn)
    {
        BankAccount bankAccount =  bankAccountService.create(bankAccountMapper.bankAccountDTOToEntity(bankAccountDTO), bsn);

        if (bankAccount != null){
            return bankAccountMapper.bankAccountEntityToDTO(bankAccount);
        }

        else {
            return null;
        }
    }


    @GetMapping("/bankaccounts")
    @ResponseBody
    public List<BankAccountDTO> getBankAccountList()
    {
        return bankAccountMapper.arrayListEntityTODTO(bankAccountService.get());
    }

    //Block bankrekening
    @PatchMapping("/bankaccountsactive")
    ResponseEntity<String> patchBankrekeningActief(
            @RequestParam UUID id,
            @RequestParam Boolean active)
    {
     BankAccount bankAccount = bankAccountService.patch(id, active);

        if (bankAccount != null) {
            return new ResponseEntity<>("Setting bank account active/unactive succeeded!" , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Setting bank account active/unactive did not succeed! No match found for IBAN " + id , HttpStatus.BAD_REQUEST);

        }

    }

    //Delete bankrekening
    @DeleteMapping("/bankaccounts")
    @ResponseBody
    // Method
    ResponseEntity<String> removeBankrekening(@RequestParam UUID UUID)
    {
       BankAccount bankAccount = bankAccountService.delete(UUID);

                if (bankAccount != null)
                {
                    return new ResponseEntity<>("Delete succes!" , HttpStatus.OK);
                }

                else {
                    return new ResponseEntity<>("Delete fail!" , HttpStatus.BAD_REQUEST);
                }
    }




}
