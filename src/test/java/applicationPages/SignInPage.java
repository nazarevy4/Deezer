package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {

    @FindBy(id = "login_mail")
    private WebElement mail;

    @FindBy(id = "login_password")
    private WebElement password;

    @FindBy(id = "login_form_submit")
    private WebElement signInButton;

    @FindBy(id = "login_error")
    private WebElement loginError;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterMail (String mail){
        this.mail.clear();
        this.mail.sendKeys(mail);
    }

    public void enterPassword (String password){
        this.password.clear();
        this.password.sendKeys(password);
    }

    public DeezerMainPage submit(){
        signInButton.click();
        return new DeezerMainPage(driver);
    }

    public boolean errorConfirm () {
        return signInButton.isEnabled();
    }
}
