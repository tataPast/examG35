package pages;

import libs.ElementsActions;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    ElementsActions elementsActions;
    final String baseUrl = "https://cp.unisender.com";

    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);
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


}
