package cucumberTest;

import applicationPages.DeezerMainPage;
import applicationPages.SignInPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class StepDefinition implements En {
    public WebDriver driver;
    DeezerMainPage deezerMainPage;
    SignInPage signInPage;

    public StepDefinition() {
        Before(() -> {
            System.setProperty("webdriver.gecko.driver","C:\\Users\\Nazarii_Stukalo\\Documents\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        });

        After(() -> {
            driver.close();
        });


        Given("^deezer login page is opened$", () -> {
            driver.get("https://www.deezer.com/login");
        });

        When("^user enters login \"([^\"]*)\" and password \"([^\"]*)\"$", (String login, String password) -> {
            signInPage = new SignInPage(driver);
            signInPage.enterMail(login);
            signInPage.enterPassword(password);
            signInPage.submit();
        });


        Then("^user is logged in$", () -> {
            deezerMainPage = new DeezerMainPage(driver);
            Assert.assertTrue(deezerMainPage.userIsLoggedIn());
        });

        Then("^user is not logged in$", () -> {
            Assert.assertTrue(signInPage.loginErrorIsPresent());
        });


    }
}

