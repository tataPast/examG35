package pages;

import libs.ConfigProperties;
import libs.ElementsActions;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    protected static ConfigProperties configProperties
            = ConfigFactory.create(ConfigProperties.class);
    String expectedUrl;
    String baseUrl;
    String pass;
    String login;
    ElementsActions elementsActions;

    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
        pass = configProperties.password();
        login = configProperties.login();

        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);
        elementsActions = new ElementsActions(webDriver);
    }

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);
        elementsActions = new ElementsActions(webDriver);
    }

    public String getExpectedUrl() {
        return webDriver.getCurrentUrl();
    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("Url is not expected", expectedUrl, getExpectedUrl());
        } catch (Exception e) {
            logger.error("Url is not expected");
            Assert.fail("Url is not expected");
        }
    }

    @FindBy(xpath = "//*[@data-test='menu-contact']")
    private WebElement contactsDropdownButton;
    @FindBy(xpath = "//*[@data-test='menu-contact-field-contact-list']")
    private WebElement contactListButton;


    public void openContactDropDown(){
        elementsActions.clickOnElement(contactsDropdownButton, "contactsDropdownButton");
    }

    public void goToSubscriberListPageButton(){
        elementsActions.clickOnElement(contactListButton, "goToContactListButton");
    }
}