package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewListPage extends Pages {

//    public NewListPage(WebDriver webDriver, String expectedUrl) {
//        super(webDriver, expectedUrl);
//        subscriberListPage = new SubscriberListPage(webDriver);
//    }

    public NewListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "listActionsContainerLnk")
    private WebElement openListActionsDD;
    @FindBy(id = "lnkDeleteList")
    private WebElement deleteListButton;
    @FindBy(id = "btnRemoveListYes")
    private WebElement deleteListConfirmButton;

    public NewListPage deleteList() {
        elementsActions.clickOnElement(openListActionsDD, "openListActionsDD");
        elementsActions.clickOnElement(deleteListButton, "deleteListButton");
        elementsActions.clickOnElement(deleteListConfirmButton, "deleteListConfirmButton");
        elementsActions.refreshPage();
        return this;
    }
}