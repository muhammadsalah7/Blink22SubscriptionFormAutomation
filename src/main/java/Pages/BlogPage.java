package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BlogPage extends BasePage {

    private WebDriverWait wait;

    private By blogLink = By.xpath("//li[a[@href='/blog/']]");
    private By fullNameField = By.id("fullname");
    private By emailField = By.id("email");
    private By subscribeButton = By.id("_form_5_submit");
    private By cookieAcceptButton = By.id("rcc-confirm-button");
    private By requiredFieldError = By.xpath("//div[@class='_error-inner' and text()='This field is required.']");
    private By invalidEmailError = By.xpath("//div[@class='_error-inner' and text()='Enter a valid email address.']");
    private By thankYouMessage = By.xpath("//div[@class='_form-thank-you' and text()='Thanks for signing up! Check your inbox for your Welcome package!']");

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    public void goToBlog() {
        wait.until(ExpectedConditions.elementToBeClickable(blogLink)).click();
    }

    public void acceptCookiesIfPresent() {
        List<WebElement> buttons = driver.findElements(cookieAcceptButton);
        if (!buttons.isEmpty() && isElementVisible(buttons.get(0))) {
            buttons.get(0).click();
        }
    }

    public String getFullNamePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameField)).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).getAttribute("placeholder");
    }

    public void fillForm(String name, String email) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameField));
        WebElement emailFieldEl = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        nameField.clear();
        emailFieldEl.clear();
        nameField.sendKeys(name);
        emailFieldEl.sendKeys(email);
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
    }

    public boolean isRequiredFieldErrorShown() {
        return !driver.findElements(requiredFieldError).isEmpty();
    }

    public boolean isInvalidEmailErrorShown() {
        return !driver.findElements(invalidEmailError).isEmpty();
    }

    public String getThankYouMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage)).getText();
    }
}