package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscriberFieldPage extends ParentPage{
    public SubscriberFieldPage(WebDriver webDriver) {
        super(webDriver, "/ru/subscriber/field/list");
    }

    @FindBy(id = "btnAddField")
    private WebElement addFieldButton;
    @FindBy(id = "subscriber_field_label")
    private WebElement subscriberFieldName;
    @FindBy(id = "subscriber_field_substitution")
    private WebElement subscriberFieldTag;
    @FindBy(id = "saveFieldDetails")
    private WebElement saveFieldButton;
    @FindBy(xpath = "//i[@class='icon-remove plink silver']")
    private WebElement deleteNewFieldButton;
    @FindBy(id = "btnRemoveFieldYes")
    private WebElement confirmDeletionButton;
    @FindBy(xpath = "//*[normalize-space(.)='zxcv']")
    private WebElement tagNameInGrid;
    @FindBy(xpath = "//*[normalize-space(text()) and normalize-space(.)='UniSender']")
    private WebElement closeUselessWindowButton;

    public void clickCreateNewFeildButton() {
        elementsActions.clickOnElement(addFieldButton, "addFieldButton");
    }

    public void inputFieldName(String fieldName) {
        elementsActions.enterTextToElement(subscriberFieldName, fieldName, "subscriberFieldName");
    }

    public void inputFieldTag(String fieldTag) {
        elementsActions.enterTextToElement(subscriberFieldTag, fieldTag, "subscriberFieldTag");
    }

    public void clickSubmitCreateFieldButton(){
        elementsActions.clickOnElement(saveFieldButton, "saveFieldButton");
    }

    public boolean isNewAddedFieldVisible(String tagName) {
        return elementsActions.isElementDisplayed(tagName, "newAddedField");
    }

    public void deleteAddedField() {
        elementsActions.refreshPage();
        elementsActions.moveCursorToElement(tagNameInGrid, "tagNameInGrid");
        elementsActions.clickOnElement(deleteNewFieldButton, "deleteNewFieldButton");
        elementsActions.clickOnElement(confirmDeletionButton, "confirmDeletionButton");
    }
}

