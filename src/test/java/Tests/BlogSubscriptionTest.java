package Tests;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.BlogPage;

public class BlogSubscriptionTest extends BaseTest {

    private BlogPage blogPage;

    @BeforeClass
    public void initPage() {
        blogPage = new BlogPage(driver, wait);
        blogPage.goToBlog();
        blogPage.acceptCookiesIfPresent();
    }

    @Test(priority = 1)
    public void testFullNamePlaceholder() {
        String placeholder = blogPage.getFullNamePlaceholder();
        Assert.assertEquals(placeholder, "Type your name", "Full Name placeholder mismatch");
    }

    @Test(priority = 2)
    public void testEmailPlaceholder() {
        String placeholder = blogPage.getEmailPlaceholder();
        Assert.assertEquals(placeholder, "Your email...", "Email placeholder mismatch");
    }

    @Test(priority = 3)
    public void testMissingNameError() {
        blogPage.fillForm("", "test@example.com");
        blogPage.submitForm();
        Assert.assertTrue(blogPage.isRequiredFieldErrorShown(), "Missing name error not shown");
    }

    @Test(priority = 4)
    public void testMissingEmailError() {
        blogPage.fillForm("Muhammad", "");
        blogPage.submitForm();
        Assert.assertTrue(blogPage.isRequiredFieldErrorShown(), "Missing email error not shown");
    }

    @Test(priority = 5)
    public void testInvalidEmailError() {
        blogPage.fillForm("Muhammad", "invalid-email");
        blogPage.submitForm();
        Assert.assertTrue(blogPage.isInvalidEmailErrorShown(), "Invalid email error not shown");
    }

    @Test(priority = 6)
    public void testValidSubmissionThankYouMessage() {
        blogPage.fillForm("Muhammad Salah", "test2@gmail.com");
        blogPage.submitForm();
        String thankYou = blogPage.getThankYouMessage();
        Assert.assertEquals(thankYou, "Thanks for signing up! Check your inbox for your Welcome package!",
                "Thank you message mismatch");
    }
}