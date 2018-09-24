package cucumberTest;

import applicationPages.DeezerMainPage;
import applicationPages.SignInPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class StepDefinition implements En {
    public WebDriver driver;
    DeezerMainPage deezerMainPage;
    SignInPage signInPage;

    public StepDefinition() {
        Given("^deezer login page is opened$", () -> {
            System.setProperty("webdriver.gecko.driver","C:\\Users\\Nazarii_Stukalo\\Documents\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.deezer.com/login");

        });

        When("^valid creds are passed$", () -> {
            signInPage = new SignInPage(driver);
            signInPage.enterMail("nazar.stukalo@yahoo.com");
            signInPage.enterPassword("password!@#");
            deezerMainPage = signInPage.submit();

        });

        Then("^user is logged in$", () -> {
                Assert.assertTrue(deezerMainPage.confiramtion());

        });

    }
}

