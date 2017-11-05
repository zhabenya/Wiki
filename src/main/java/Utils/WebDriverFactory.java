package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.getProperty;
import static org.openqa.selenium.remote.BrowserType.*;

public class WebDriverFactory {
    private static final String browserName = getProperty("browser", CHROME);
    private static WebDriver driverWrapper;

    public WebDriverFactory() {
    }

    public static WebDriver initDriver() {
        switch (browserName) {
            case FIREFOX:
                driverWrapper = new FirefoxDriver();
                break;
            case EDGE:
                driverWrapper = new EdgeDriver();
                break;
            case CHROME:
            default:
                driverWrapper = new ChromeDriver();
        }
        driverWrapper.manage().deleteAllCookies();
        driverWrapper.manage().window().maximize();
        return driverWrapper;
    }
}
