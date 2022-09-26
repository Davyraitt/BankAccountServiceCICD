package com.davyraitt.Cucumber;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
public class Steps {

    @Autowired
    private BankAccountHttpClient bankAccountHttpClient;

    private final Logger log = LoggerFactory.getLogger(Steps.class);

    // ********************************************************************************************************
//    Feature: Bankaccount feature
//      Scenario: Client makes a call to localhost:8080/bankaccounts GET
//              When the client calls get localhost:8080/bankaccounts and requests all the bankaccounts
//              Then the client receives status code of 200
//              And the client receives a list of bankaccounts
    @When("^the client calls get localhost:8080/bankaccounts and requests all the bankaccounts$")
    public void whenTheClientCallsGetBankAccounts(){
        // With this code we can call a running rest api
//        TestRestTemplate testRestTemplate = new TestRestTemplate();
//        ResponseEntity<String> response = testRestTemplate.
//                getForEntity("http://dummy.restapiexample.com/", String.class);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@" + response);
//        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        System.out.println("@@@@@@@@@@@@@@@@@@" + bankAccountHttpClient.getContents());

    }

    @Then("^Then the client receives status code of 200$")
    public void thenTheClientReceivesCode200(){
    }

    @And("^And the client receives a list of bankaccounts$")
    public void andTheClientReceivesBankAccounts(){
    }
    // ****************************************************************************************************




}
