package cucumberTest;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(format= {"pretty"},features="src\\test\\resources\\cucumber\\login.feature")
public class RunCukesTest extends AbstractTestNGCucumberTests {
}