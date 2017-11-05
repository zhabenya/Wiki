import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ResultPage;

import java.io.IOException;
import java.util.logging.Logger;

import static Utils.ScreenshotUtil.takeScreenshot;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;
import static pages.MainPage.openMainPage;

public class SearchTest extends BrowserFixture {
    private static final Logger logger = Logger.getLogger(SearchTest.class.getName());
    private static String searchString = "test automation";
    private MainPage mainPage;
    private ResultPage resultPage;

    @BeforeMethod
    public void goToMainPage() {
        mainPage = openMainPage(driver);
    }

    @Test
    public void testWikiSearch() {
        logger.info(format("Enter [%s] in the search field", searchString));
        resultPage = mainPage.simpleSearch(searchString);
        logger.info(format("Check if opened page header corresponds to [%s]", searchString));
        assertTrue(resultPage.checkPageHeader(searchString), "Result page header doesn't contain search string");
    }

    @Test(description = "Test Wikipedia search suggestions")
    public void testWikiSearchSuggestions() {
        logger.info(format("Look for [%s] in the search suggestions", searchString));
        resultPage = mainPage.smartSearch(searchString);
        logger.info(format("Check if opened page header corresponds to [%s]", searchString));
        assertTrue(resultPage.checkPageHeader(searchString), "Result page header doesn't contain search string");
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(driver, testResult);
        }
    }
}
