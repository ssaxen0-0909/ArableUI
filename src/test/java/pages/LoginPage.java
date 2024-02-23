package pages;

//import base.TestRailManager;

import TestRail.APIException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.PropertiesReader;

import java.io.IOException;
import java.util.List;

import static support.World.emailId;
import static support.World.webDriverHelper;


//import static base.TestRailManager.updateTestrail;

public class LoginPage {

    private final WebDriver driver;
    private final PropertiesReader getPropertyValue = new PropertiesReader();
    //    public String loadInSeconds;
//    public long start;
    @FindBy(xpath = "//p[normalize-space()='No Sites are created yet.']")
    WebElement noSitesCreated;
    @FindBy(xpath = "//button[@title='Zoom out']")
    WebElement mapZoomOutBtnF;
    //      @FindBy(xpath = "(//a[@class='menu-item with-border bottom'])[1]")
//      private WebElement logoutF;
    @FindBy(xpath = "//button[contains(.,'Close')]")
    WebElement CloseBtn;
    @FindBy(xpath = "//img[@src='/img/animations/loading.gif']")
    WebElement loadingIconMapPage;
    @FindBy(xpath = "//img[@alt='Map']")
    WebElement iconMap;
    @FindBy(xpath = "//arable-login/div/div/h1")
    private WebElement loginHeaderF;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailF;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordF;
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement logInF;
    @FindBy(xpath = "//div[@id='61b04fd88fcf7800145a4829']//div[@class='column-33 column-flex grid-center']")
    private WebElement siteDetails;
    @FindBy(xpath = "//label[normalize-space()='Remember me for 90 days']")
    private WebElement ninetyDaysText;
    @FindBy(xpath = "//label[@class='label-checkbox']")
    private WebElement ninetyDaysCheckbox;
    @FindAll(@FindBy(xpath = "//div[@class='credentials-view']"))
    private List<WebElement> titlesOnLoginPage;
    @FindBy(xpath = "(//div[@class='site-summary-card grid clickable'])[1]")
    private WebElement MapPage_SiteF;
    @FindBy(xpath = "(//div[@class='column'])[2]")
    private WebElement teamDropdown_ALLTeams;
    @FindBy(xpath = "(//arable-site-summary-card/div)[1]")
    private WebElement firstSiteIdF;
    @FindBy(xpath = "//p[@class='1 selected']")
    private WebElement globalOrgSelected_MapPage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void verifyLoggedIn() throws APIException, IOException, InterruptedException {
//        try {

//        webDriverHelper.waitUntilVisible(iconMap, 100, 2);
//             Wait for loading icon to disappear (assuming it disappears)
//        wait.until(ExpectedConditions.invisibilityOf(loadingIconMapPage));

//            long start = System.currentTimeMillis();
//            webDriverHelper.waitUntilVisible(mapZoomOutBtnF, 300, 2);
//            Thread.sleep(1000);
//            boolean isCloseBtnDisplayed = isElementDisplayedWithRetries(CloseBtn, 5, 500);
//
//            if (isCloseBtnDisplayed) {
//                Assert.assertTrue(CloseBtn.isDisplayed(), "Modal Close button is not displayed on the dashboard page");
//                CloseBtn.click();
//            } else {
//                System.out.println("CloseBtn is not displayed. Proceeding with the next step...");
//            }
//        } catch (TimeoutException e) {
//            System.out.println("TimeoutException: mapZoomOutBtnF element is not visible within the specified time");
//        }
//    }

//    private boolean isElementDisplayedWithRetries(WebElement element, int maxRetries, int retryInterval) {
//        int retryCount = 0;
//        while (retryCount < maxRetries) {
//            try {
//                if (element.isDisplayed()) {
//                    return true;
//                }
//            } catch (NoSuchElementException | StaleElementReferenceException e) {
//                // Element not found or is stale, retry after the specified interval
//            }
//            retryCount++;
//            try {
//                Thread.sleep(retryInterval);
//            } catch (InterruptedException e) {
//                // Handle interruption if required
//            }
//        }
//        return false;
//    }

//    public void captureMapLoadTime(String role) throws IOException, APIException, InterruptedException {
//        verifyLoggedIn();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.or(
//                ExpectedConditions.visibilityOf(firstSiteIdF),
//                ExpectedConditions.visibilityOf(noSitesCreated)
//        ));
//        Assert.assertTrue(firstSiteIdF.isDisplayed() || noSitesCreated.isDisplayed(), "Map page sites not displayed");
////        webDriverHelper.waitUntilVisible(firstSiteIdF, 200, 1);
////        Assert.assertTrue(firstSiteIdF.isDisplayed(), "map page sites not displayed");
//        loadInSeconds = stringHelper.stopTime(start, driver);
//        ExcelReader.setValueForColumn("Map", loadInSeconds, role);
//    }

    public void verifyTitlesOnLoginPage() {
        driver.get(PropertiesReader.webApplicationUrl);
        webDriverHelper.waitUntilVisible(emailF, 180, 2);
        for (WebElement title : titlesOnLoginPage) {
            String name = title.getText();
            Assert.assertTrue(name.contains("Enter your email & password."), "Enter your email & password text is not displayed");
            Assert.assertTrue(name.contains("Forgot Password?"), "Forgot Password? is not displayed");
            Assert.assertTrue(name.contains("Sign In to Arable"), "Sign In to Arable is not displayed");
        }
    }

    public void verifyChecked90daysCheckbox() {
        driver.get(PropertiesReader.webApplicationUrl);
        webDriverHelper.waitUntilVisible(loginHeaderF, 30, 1);
        webDriverHelper.waitUntilVisible(emailF, 30, 1);
        webDriverHelper.waitUntilVisible(ninetyDaysCheckbox, 30, 1);
        Assert.assertTrue(ninetyDaysText.isDisplayed(), "90 days checkbox not displayed");
    }

    public void loginWithInvalidCredential() throws InterruptedException {
        driver.get(PropertiesReader.webApplicationUrl);
        webDriverHelper.waitUntilVisible(loginHeaderF, 30, 1);
        webDriverHelper.waitUntilVisible(emailF, 30, 1);
        emailF.sendKeys("vishal.guptatest@arable.com");
        passwordF.sendKeys("arable2020");
        Thread.sleep(1000);
        logInF.click();
    }

    public void logInToTheApplication(String userRole) throws APIException, IOException, InterruptedException {
        try {
            driver.get(PropertiesReader.webApplicationUrl);
            webDriverHelper.waitUntilVisible(loginHeaderF, 100, 2);
        } catch (TimeoutException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("location.reload()");
            webDriverHelper.waitUntilVisible(loginHeaderF, 100, 2);
        }
        webDriverHelper.waitUntilVisible(emailF, 100, 2);
        emailId = getPropertyValue.loadProperties(userRole + ".email");
        emailF.sendKeys(emailId);
        passwordF.sendKeys(PropertiesReader.applicationPassword);
        webDriverHelper.waitUntilVisible(logInF, 100, 2);
        logInF.click();
        // Wait for loading icon to disappear (assuming it disappears)
//        wait.until(ExpectedConditions.invisibilityOf(loadingIconMapPage));
//        webDriverHelper.waitUntilVisible(teamDropdown_ALLTeams, 100, 2);
        //---end testing for this page
    }
}
