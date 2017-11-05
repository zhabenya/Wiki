package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ResultPage {
    private WebDriver driver;

    @FindBy(id = "firstHeading")
    private WebElement pageHeader;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public boolean checkPageHeader(String expectedHeader) {
        return pageHeader.getText().equalsIgnoreCase(expectedHeader);
    }
}
