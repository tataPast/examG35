package parentTest;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected ParentPage parentPage;
    protected LoginPage loginpage;
    protected MainPage mainPage;
    protected SubscriberListPage subscriberListPage;
    protected SubscriberFieldPage subscriberFieldPage;
    String browser = System.getProperty("browser");
    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Before
    public void setUp() {
        initDriver(browser);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        parentPage = new ParentPage(webDriver);
        loginpage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        subscriberListPage = new SubscriberListPage(webDriver);
        subscriberFieldPage = new SubscriberFieldPage(webDriver);
    }

    private void initDriver(String browserName) {
        if (browserName == null || browserName.equals("chrome")) {
            logger.info("Chrome will be start");
            File file = new File("/home/uniuser/chromedriver_linux64/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info("Chrome is started");
        } else if ("firefox".equals(browserName)){
            logger.info("Firefox will be start");
            File fileFF = new File("./src/drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0); // Empty start page
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
            webDriver = new FirefoxDriver();
            logger.info("Firefox is started");
        } else if ("ie".equals(browser)){
            logger.info("IE will be started");
            File file1 = new File("./src/drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            webDriver = new InternetExplorerDriver();
            logger.info(" IE is started");
        } else {
            logger.error("Can't init driver");
            Assert.fail("Can't init driver");
        }
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
