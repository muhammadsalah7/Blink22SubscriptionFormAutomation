package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean isElementVisible(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }
}