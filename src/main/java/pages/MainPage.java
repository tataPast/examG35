package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {

    @FindBy(xpath = "//div[@class='cabinetHeader__userMenu']//button/div/div/span[1]")
    private WebElement menuItemUserLogin;
    @FindBy(xpath = "//div[@class='menuItem__buttonSubText']")
    private WebElement menuItemUserID;

    public MainPage(WebDriver webDriver) {
        super(webDriver, "/ru/v5");
    }

    public boolean isUsernameDisplayed() {
        return elementsActions.isElementDisplayed(menuItemUserLogin, "User login item");
    }

    public boolean isUserIdDisplayed() {
        return elementsActions.isElementDisplayed(menuItemUserID, "User ID item");
    }
}