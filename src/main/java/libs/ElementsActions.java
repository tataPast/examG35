package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsActions {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;
    Actions actions;

    public ElementsActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait20 = new WebDriverWait(webDriver, 20);
        actions = new Actions(webDriver);
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element " + e);
        Assert.fail("Cannot work with element" + e);
    }

    public void enterTextToElement(WebElement webElement, String text, String elementsName) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into " + elementsName);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement webElement, String elementsName) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info( elementsName + " is displayed");
            return state;
        } catch (Exception e) {
            logger.info(elementsName + " isn't displayed");
            return false;
        }
    }

    public boolean isElementDisplayed(String listName, String elementsName) {
        try {
            boolean state = webDriver.findElement(By.xpath("//*[contains(text(),'" + listName + "')]")).isDisplayed();
            logger.info( elementsName + " is displayed");
            return state;
        } catch (Exception e) {
            logger.info(elementsName + " isn't displayed");
            return false;
        }
    }

    public void clickOnElement(WebElement webElement, String elementsName) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info(elementsName + " was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDD(WebElement dropDownElement, String value) {
        try {
            Select select = new Select(dropDownElement);
            select.selectByValue(value);
            logger.info(value + " was selected in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void moveCursorToElement(WebElement webElement, String elementsName){
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            actions.moveToElement(webElement).build().perform();
            logger.info("Cursor was moved to " + elementsName);
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void refreshPage(){
        webDriver.navigate().refresh();
    }
}