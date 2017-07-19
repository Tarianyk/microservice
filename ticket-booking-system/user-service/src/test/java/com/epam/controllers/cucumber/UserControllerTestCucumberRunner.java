package com.epam.controllers.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//TODO: remake to classpath
@CucumberOptions(features = "src/test/resources/user_test.feature")
public class UserControllerTestCucumberRunner {
}