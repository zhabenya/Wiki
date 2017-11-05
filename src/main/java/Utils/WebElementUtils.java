package Utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementUtils {
    public static WebElement findElementInListByText(List<WebElement> list, String text) {
        return list.stream().filter(s -> s.getText().equalsIgnoreCase(text)).findFirst().orElse(null);
    }
}
