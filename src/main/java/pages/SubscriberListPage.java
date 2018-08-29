package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscriberListPage extends Pages {
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
    @FindBy(xpath = "//a[contains(text(),'qwerty')]")
    private WebElement newListInGrig;
    @FindBy(xpath = "//*[@id='contactListsContainer']/tr[1]/td[1]/span[1]")
    private WebElement newListInGrigID;

    public SubscriberListPage goToSubscriberFieldPage() {
        elementsActions.clickOnElement(addFieldButton, "addFieldButton");
        return this;
    }

    public SubscriberListPage openCreateNewListPopUp(){
        elementsActions.clickOnElement(createNewListButton, "createNewListButton");
        return this;
    }

    public SubscriberListPage inputListName(String listname){
        elementsActions.enterTextToElement(listNameInput, listname, "listNameInput");
        return this;
    }

    public SubscriberListPage submitNewListCreation() {
        elementsActions.clickOnElement(saveNewListButoon, "saveNewListButoon");
        return this;
    }

    public boolean isNewListInGrid(){
        elementsActions.refreshPage();
        return elementsActions.isElementDisplayed(newListInGrig, "newListInGrid");
    }

    public NewListPage goToNewListPage(){
        elementsActions.refreshPage();
        elementsActions.clickOnElement(newListInGrig, "newListInGrig");
    return new NewListPage(webDriver);
    }
//
//    public String getId(){
//        return newListInGrigID.getText();
//    }
}