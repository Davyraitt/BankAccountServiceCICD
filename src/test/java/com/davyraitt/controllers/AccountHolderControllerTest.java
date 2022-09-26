package com.davyraitt.controllers;

import com.davyraitt.Business_Service_Layer.service.AccountHolderService;
import com.davyraitt.DataAccess_Repository_Layer.database.entitys.AccountHolder;
import com.davyraitt.DataAccess_Repository_Layer.database.entitys.BankAccount;
import com.davyraitt.DataAccess_Repository_Layer.database.mapperinterfaces.AccountHolderMapper;
import com.davyraitt.Presentatie_Controller_Layer.dto.AccountHolderDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountHolderControllerTest {

    @Mock
    AccountHolderService accountHolderService;

    @InjectMocks // Class Under Test
    AccountHolderController accountHolderController;

    @Spy
    private AccountHolderMapper accountHolderMapper = Mappers.getMapper(AccountHolderMapper.class);

    @Test
    void shouldGetAccountHolders() {
        //ARRANGE: So the arrange section you only have code required to setup that specific test.
        BankAccount bankAccount = new BankAccount("NL07INGB00010001293", 319.59, true);
        AccountHolder accountHolder = new AccountHolder("Davy Joe Raitt", "9201931");
        accountHolder.addBankAccount(bankAccount);
        List<AccountHolder> list = new ArrayList<>();
        list.add(accountHolder);
        Mockito.when(accountHolderService.get()).thenReturn(list);

        //ACT: Then there is the Act, which should be the invocation of the method being tested.
        List<AccountHolderDTO> holdersResult = accountHolderController.getAccountHolders();

        //ASSERT: And on Assert you would simply check whether the expectations were met.
        assert(holdersResult.get(0).getBsn().equals("9201931"));
        assert(holdersResult.get(0).getName().equals("Davy Joe Raitt"));
    }

//    @Test
//    void ShouldInsertAccountHolder() {
//        //ARRANGE: So the arrange section you only have code required to setup that specific test.
//        // WE WANT TO TEST: accountHolderService.create(accountHolder, IBAN);
//        BankAccount bankAccount = new BankAccount("NL07INGB00010001293", 319.59, true);
//        AccountHolder accountHolder = new AccountHolder("Davy Joe Raitt", "9201931");
//        accountHolder.addBankAccount(bankAccount);
//        AccountHolderDTO accountHolderDTO = accountHolderMapper.accountHolderToDTO(accountHolder);
//        ArgumentCaptor<AccountHolder> capturedAccountHolder1 = ArgumentCaptor.forClass(AccountHolder.class); // enables us to extract Object passed into a method call.
//        ArgumentCaptor<String> capturedIBANString1 = ArgumentCaptor.forClass(String.class);
//
//        //ACT: Then there is the Act, which should be the invocation of the method being tested
//        accountHolderController.insertAccountHolder(accountHolderDTO, "");
//
//        //ASSERT: And on Assert you would simply check whether the expectations were met.
//        verify(accountHolderService).create(capturedAccountHolder1.capture(), capturedIBANString1.capture());
//        AccountHolder endResult = capturedAccountHolder1.getValue();
//
//        assert(endResult.getBsn().equals("9201931"));
//        assert(endResult.getName().equals("Davy Joe Raitt"));
////    }
//
//    @Test
//    void shouldRemoveAccountHolder() {
//        //ARRANGE: So the arrange section you only have code required to setup that specific test.
//        UUID id = UUID.randomUUID();
//        String idString = id.toString();
//        ArgumentCaptor<UUID> capturedUUID = ArgumentCaptor.forClass(UUID.class); // enables us to extract Object passed into a method call.
//
//        //ACT: Then there is the Act, which should be the invocation of the method being tested.
//        accountHolderController.removeAccountHolder(id);
//
//        //ASSERT: And on Assert you would simply check whether the expectations were met.
//        verify(accountHolderService).delete(capturedUUID.capture());
//        UUID endResult = capturedUUID.getValue();
//        assert(endResult.toString().equals(idString));
//        assert(endResult.equals(id));
//    }
//
//    @Test
//    void shouldRetrieveAllBankAccountsFromHolder() {
//        //ARRANGE: So the arrange section you only have code required to setup that specific test.
//        BankAccount bankAccount = new BankAccount("NL07INGB00010001293", 319.59, true);
//        AccountHolder accountHolder = new AccountHolder("Davy Joe Raitt", "9201931");
//        accountHolder.addBankAccount(bankAccount);
//        ArgumentCaptor<String> capturedIBAN = ArgumentCaptor.forClass(String.class); // enables us to extract Object passed into a method call.
//        AccountHolderDTO accountHolderDTO = accountHolderMapper.accountHolderToDTO(accountHolder);
//
//        //ACT: Then there is the Act, which should be the invocation of the method being tested.
//        accountHolderController.findAllHoldersByIban("NL07INGB00010001293");
//
//        //ASSERT: And on Assert you would simply check whether the expectations were met.
////        accountHolderService.getBankAccountsOfThisHolder(IBAN);
//        verify(accountHolderService).getBankAccountsOfThisHolder(capturedIBAN.capture());
//
//        assert(capturedIBAN.getValue().equals(bankAccount.getIBAN()));
//
//    }
}