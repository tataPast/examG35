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
    @FindBy(xpath = "//a[contains(text(),'qwerty')]")
    private WebElement newListInGrig;
    @FindBy(xpath = "//*[@id='contactListsContainer']/tr[1]/td[1]/span[1]")
    private WebElement newListInGrigID;

    public void goToSubscriberFieldPage() {
        elementsActions.clickOnElement(addFieldButton, "addFieldButton");
    }

    public void openCreateNewListPopUp(){
        elementsActions.clickOnElement(createNewListButton, "createNewListButton");
    }

    public void inputListName(String listname){
        elementsActions.enterTextToElement(listNameInput, listname, "listNameInput");
    }

    public void submitNewListCreation() {
        elementsActions.clickOnElement(saveNewListButoon, "saveNewListButoon");
    }

    public boolean isNewListInGrid(){
        elementsActions.refreshPage();
        return elementsActions.isElementDisplayed(newListInGrig, "newListInGrid");
    }

    public void goToNewListPage(){
        elementsActions.clickOnElement(newListInGrig, "newListInGrig");
    }

    public String getId(){
        return newListInGrigID.getText();
    }
}