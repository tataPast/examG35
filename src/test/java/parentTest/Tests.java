package parentTest;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Tests {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected Pages pages;
    protected LoginPage loginpage;
    protected MainPage mainPage;
    protected SubscriberListPage subscriberListPage;
    protected SubscriberFieldPage subscriberFieldPage;
    protected NewListPage newListPage;
    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Before
    public void setUp() {
        File file = new File("/home/uniuser/chromedriver_linux64/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pages = new Pages(webDriver);
        loginpage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        subscriberListPage = new SubscriberListPage(webDriver);
        subscriberFieldPage = new SubscriberFieldPage(webDriver);
        newListPage = new NewListPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkAC(String massage, boolean actual, boolean expexted) {
        if (actual != expexted) {
            logger.error("AC failed: " + massage);
        }
        Assert.assertEquals(massage, expexted, actual);
    }
}