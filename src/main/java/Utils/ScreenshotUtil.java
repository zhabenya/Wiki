package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private ScreenshotUtil() {
    }

    public static void takeScreenshot(WebDriver driver, ITestResult testResult) throws IOException {
        String folder = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("target/screenshots/" + folder + "/" + testResult.getName() + ".jpg"));
    }
}
