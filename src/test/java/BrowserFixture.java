import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Utils.WebDriverFactory.initDriver;
import static java.lang.System.getProperty;
import static java.util.logging.Logger.getLogger;

public class BrowserFixture {
    private static final Logger logger = getLogger(BrowserFixture.class.getName());
    private static final String wait = getProperty("timeout", "10");
    static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public static void setBrowser() {
        driver = initDriver();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(wait), TimeUnit.SECONDS);
        logger.info("Start test suite");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() throws Exception {
        logger.info("End test");
        driver.quit();
    }
}
