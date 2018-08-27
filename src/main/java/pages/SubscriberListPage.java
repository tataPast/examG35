package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscriberListPage extends ParentPage {
    public SubscriberListPage(WebDriver webDriver) {
        super(webDriver, "/ru/subscriber/list");
    }

    @FindBy(xpath = "//*[@id='createNewListButton']")
    private WebElement createNewListButton;
    @FindBy(xpath = "//*[@id='subscriber_list_name']")
    private WebElement listNameInput;
    @FindBy(xpath = "//*[@data-id='btn_list_form_edit_success']")
    private WebElement saveNewListButoon;
    @FindBy(xpath = "//a[contains(text(),'Дополнительные поля')]")
    private WebElement addFieldButton;

    public void addNewList(String listName) {
        elementsActions.clickOnElement(createNewListButton, "createNewListButton");
        elementsActions.enterTextToElement(listNameInput, listName, "listNameInput");
        elementsActions.clickOnElement(saveNewListButoon, "saveNewListButoon");
    }

    public void goToSubscriberFieldPage() {
        elementsActions.clickOnElement(addFieldButton, "addFieldButton");
    }
}