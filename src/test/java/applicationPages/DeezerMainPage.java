package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeezerMainPage extends PageObject {

    @FindBy(id = "dzr-app")
    private WebElement deezerApp;


    public DeezerMainPage(WebDriver driver) {
        super(driver);
    }

    public boolean confiramtion () {
        return deezerApp.isEnabled();
    }
}
