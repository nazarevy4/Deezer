package pageObjectPatternTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    public WebDriver driver;


    @BeforeClass
    public static void setUp(){
//                        System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe"); //windows
        System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver"); //ubuntu

    }

    @Before
    public void setupTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }


}
