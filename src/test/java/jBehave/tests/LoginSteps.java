package jBehave.tests;

import applicationPages.DeezerMainPage;
import applicationPages.SignInPage;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends Steps{
    public WebDriver driver;
    DeezerMainPage deezerMainPage;
    SignInPage signInPage;

    @Given("deezer login page is opened")
    public void givenASystemState() {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Nazarii_Stukalo\\Documents\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.deezer.com/login");
    }

    @When("valid creds are passed")
    public void whenIDoSomething() {
        signInPage = new SignInPage(driver);
        signInPage.enterMail("nazar.stukalo@yahoo.com");
        signInPage.enterPassword("password!@#");
        deezerMainPage = signInPage.submit();
    }

    @When("not valid creds are passed")
    public void whenIDoSomethingelse() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterMail("nazar.stukalo@yahoo.com");
        signInPage.enterPassword("passwrd!@#");
        signInPage.submit();


    }

    @Then("user is logged in")
    public void thenSystemIsInADifferentState() {
        Assert.assertTrue(deezerMainPage.confiramtion());
    }

    @Then("user is not logged in")
    public void thenSystemIsInADifferentStatetest() {
        Assert.assertFalse(deezerMainPage.confiramtion());
    }



    @AfterStory
    public void afterStories() {
        driver.close();
    }


}
