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

    @Given("page \"$keyword\" is opened")
    public void openPage(String url) {
        driver.get(url);
    }

    @When("mail \"$keyword\" and  \"$keyword\" password are passed")
    public void passParameters(String mail, String pass) {
        signInPage = new SignInPage(driver);
        signInPage.enterMail(mail);
        signInPage.enterPassword(pass);
        deezerMainPage = signInPage.submit();
    }

    @Then("user is logged in")
    public void deesAppIsOpened() {
        Assert.assertTrue(deezerMainPage.userIsLoggedIn());
    }

    @Then("user is not logged in")
    public void errorMessageAppears() {
        Assert.assertTrue(signInPage.loginErrorIsPresent());
    }


    @BeforeStory
    public void setBrowser () {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nazarii_Stukalo\\Documents\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterStory
    public void closeBrowser() {
        driver.close();
    }


}
