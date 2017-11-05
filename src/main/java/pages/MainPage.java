package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Logger;

import static Utils.WebElementUtils.findElementInListByText;
import static java.lang.System.getProperty;
import static java.util.logging.Logger.getLogger;
import static junit.framework.TestCase.fail;
import static org.openqa.selenium.support.PageFactory.initElements;

public class MainPage {
    private static final Logger logger = getLogger(MainPage.class.getName());
    private WebDriver driver;

    @FindBy(id = "searchInput")
    private WebElement searchInput;
    @FindBy(className = "pure-button")
    private WebElement searchButton;
    @FindBy(className = "suggestion-title")
    private List<WebElement> suggestions;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public static MainPage openMainPage(WebDriver driver) {
        driver.get(getProperty("url", "http://wikipedia.org"));
        return new MainPage(driver);
    }

    public ResultPage simpleSearch(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
        return new ResultPage(driver);
    }

    public ResultPage smartSearch(String text) {
        searchInput.sendKeys(text);

        WebElement searchSuggestionElement = findElementInListByText(suggestions, text);
        if (searchSuggestionElement != null) {
            searchSuggestionElement.click();
        } else {
            fail("Smart search hasn't provided expected article");
        }
        return new ResultPage(driver);
    }
}
