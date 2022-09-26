package com.davyraitt.Cucumber;

import com.davyraitt.DataAccess_Repository_Layer.database.entitys.BankAccount;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;


@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class BankAccountHttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String THINGS_ENDPOINT = "/bankaccounts";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private String thingsEndpoint() {
        return SERVER_URL + ":" + port + THINGS_ENDPOINT;
    }

    public int put(final String something) {
        return restTemplate.postForEntity(thingsEndpoint(), something, Void.class).getStatusCodeValue();
    }

    public String getContents() {
        return restTemplate.getForEntity(thingsEndpoint(), String.class).getBody();
    }

    public void clean() {
        restTemplate.delete(thingsEndpoint());
    }
}