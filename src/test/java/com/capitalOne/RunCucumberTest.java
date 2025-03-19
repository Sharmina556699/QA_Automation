package com.capitalOne;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"classpath:facebookFeature"},
        glue = {"steps/facebookSteps"},
        plugin = {"pretty","html:target/cucumber-reports/cucumber.html","json:target/cucumber-report/cucumber.json"},
        tags = "@facebookLogin"
)
public class RunCucumberTest {
}
