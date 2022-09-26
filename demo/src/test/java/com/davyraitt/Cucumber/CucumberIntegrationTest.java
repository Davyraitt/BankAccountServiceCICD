package com.davyraitt.Cucumber;

import com.davyraitt.Main;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features",
        plugin = {"pretty", "json:target/cucumber-report.json"})
//We can see the annotation @CucumberOptions where we're specifying the location of the
//        Gherkin file which is also known as the feature file.
//        At this point, Cucumber recognizes the Gherkin language;

public class CucumberIntegrationTest {

}