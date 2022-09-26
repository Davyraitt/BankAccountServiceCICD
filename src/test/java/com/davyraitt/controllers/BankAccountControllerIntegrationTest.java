package com.davyraitt.controllers;

import com.davyraitt.Presentatie_Controller_Layer.dto.BankAccountDTO;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BankAccountControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private RestTemplate patchRestTemplate;

    @BeforeEach
    public void setUp() {
        this.patchRestTemplate = restTemplate.getRestTemplate();
        HttpClient httpClient = HttpClientBuilder.create().build();
        this.patchRestTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
    }

//    @Test
//    void insertBankAccount() throws Exception {
//        //ARRANGE: So the arrange section you only have code required to setup that specific test.
//        final var rand = new Random();
//        final var bsn = String.format("%09d", rand.nextInt(1000000000));
//        final var bankAcountUri = "http://localhost:" + port + "/bankaccounts?bsn=" + bsn;
//        final var bankAcountRequest = new BankAccountDTO("NL0007INGB81239213", 500.0, true);
//        HttpEntity<BankAccountDTO> requestBody = new HttpEntity<BankAccountDTO>(bankAcountRequest);
//
//        //ACT: Then there is the Act, which should be the invocation of the method being tested.
//        BankAccountDTO response = this.restTemplate.postForObject(bankAcountUri, requestBody, BankAccountDTO.class);
//        assertThat(response != null).isTrue();
//
//        //ASSERT: And on Assert you would simply check whether the expectations were met.
//        //var holder = this.restTemplate.getForEntity(bankAcountUri, BankAccountDTO.class);
//        assertThat(response.isActive()).isTrue();
//    }

    @Test
    void getBankAccountList() throws JSONException {
    }

    @Test
    void patchBankrekeningActief() {
    }

    @Test
    void removeBankrekening() {
    }

}