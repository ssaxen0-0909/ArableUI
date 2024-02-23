package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.PropertiesReader;

import java.util.List;

import static support.World.webDriverHelper;


//import static base.TestRailManager.updateTestrail;

public class ForgotPassword {

    private final WebDriver driver;
    private final PropertiesReader getPropertyValue = new PropertiesReader();

    @FindBy(xpath = "//arable-login/div/div/h1")
    private WebElement loginHeaderF;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailF;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailIDF;
    @FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
    private WebElement forgotPasswordOption;
    @FindBy(xpath = "//input[@placeholder='Confirm Email Address']")
    private WebElement confirmEmailF;
    @FindBy(xpath = "//input[@value='Reset Password']")
    private WebElement resetPasswordButtonF;
    @FindAll(@FindBy(xpath = "//div[@class='forgot-password']//div"))
    private List<WebElement> checkYourEmailPage;
    @FindBy(xpath = "//button[normalize-space()='Back to Log In']")
    private WebElement backToLoginButtonF;


    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyForgotPasswordOption() {
        driver.get(PropertiesReader.webApplicationUrl);
        webDriverHelper.waitUntilVisible(emailF, 60, 1);
        if (forgotPasswordOption.isDisplayed()) {
            Assert.assertTrue(forgotPasswordOption.isDisplayed(), "forgot password is not displayed");
        }
    }

    public void verifyForgotYourPasswordPage() {
        driver.get(PropertiesReader.webApplicationUrl);
        webDriverHelper.waitUntilVisible(forgotPasswordOption, 30, 1);
        if (forgotPasswordOption.isDisplayed()) {
            forgotPasswordOption.click();
            webDriverHelper.waitUntilVisible(emailIDF, 30, 1);
            if (emailIDF.isDisplayed() && confirmEmailF.isDisplayed() && resetPasswordButtonF.isDisplayed())
                Assert.assertTrue(resetPasswordButtonF.isDisplayed());
            Assert.assertTrue(emailIDF.isDisplayed());
            Assert.assertTrue(confirmEmailF.isDisplayed());
        }
    }

    public void verifyResetPassword() {
        verifyForgotYourPasswordPage();
        emailIDF.sendKeys("vishal.gupta@arable.com");
        confirmEmailF.sendKeys("vishal.gupta@arable.com");
        resetPasswordButtonF.click();
        webDriverHelper.waitUntilVisible(backToLoginButtonF, 30, 1);
        for (WebElement contents : checkYourEmailPage) {
            String contentDetails = contents.getText();
            Assert.assertTrue(contentDetails.contains("Check Your Email"), "Check Your Email is not displayed");
            Assert.assertTrue(backToLoginButtonF.isDisplayed(), "Back to login button is not displayed");
        }
    }

    public void verifyBackToLoginButton() {
        verifyResetPassword();
        backToLoginButtonF.click();
        webDriverHelper.waitUntilVisible(emailF, 30, 1);
        Assert.assertTrue(forgotPasswordOption.isDisplayed(), "forgot password is not displayed");
    }
}
