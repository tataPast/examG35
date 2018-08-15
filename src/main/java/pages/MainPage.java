package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends ParentPage {

    @FindBy(how = How.CSS, using = "menuItem__buttonText")
    private WebElement menuItemUserLogin;
    @FindBy(how = How.CSS, using = "menuItem__buttonSubText")
    private WebElement menuItemUserID;

    public MainPage(WebDriver webDriver) {
        super(webDriver, "/ru/v5");
    }

    public boolean isUsernameDisplayed() {
        return elementsActions.isElementDisplayed(menuItemUserLogin);
    }

    public boolean isUserIdDisplayed() {
        return elementsActions.isElementDisplayed(menuItemUserID);
    }
}
