package pageObjectPatternTests;

import applicationPages.DeezerMainPage;
import applicationPages.SignInPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class SignInFormTest extends  FunctionalTest {

    @Test
    public void signIn() {

        driver.get("https://www.deezer.com/login");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterMail("nazar.stukalo@yahoo.com");
        signInPage.enterPassword("password!@#");
        DeezerMainPage deezerMainPage = signInPage.submit();
        assertTrue(deezerMainPage.confiramtion());

    }

    @Test
    public void signInNegative() {
        driver.get("https://www.deezer.com/login");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterMail("nazar.stukalo@yahoo.com");
        signInPage.enterPassword("password123");
        signInPage.submit();
        assertTrue(signInPage.errorConfirm());
    }
}
