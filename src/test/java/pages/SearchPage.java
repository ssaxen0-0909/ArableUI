package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.Constants;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static support.World.map;
import static support.World.webDriverHelper;


public class SearchPage {

    private static WebDriver driver = null;
    public String siteName;
    //    public long start;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchBar;
    @FindBy(xpath = "//p[normalize-space()='Search']")
    WebElement dashboardMenu_Search;
    @FindBy(xpath = "//div[@class='site-result']")
    WebElement siteResult_siteCard;
    @FindBy(xpath = "//div[@class='grid name']")
    WebElement site_result_Name;
    @FindBy(xpath = "//img[@alt='search']")
    WebElement searchIconImg;
    @FindBy(xpath = "//p[@class='bold']")
    WebElement tags;
    @FindBy(xpath = "//p[normalize-space()='Region']")
    private WebElement siteResult_bottomText;
    @FindBy(xpath = "//div[@class='device-result']//div[@class='column text-center']")
    private WebElement device_result_Name;
    @FindBy(xpath = "//p[normalize-space()='Address']")
    private WebElement deviceResult_bottomText;
    @FindBy(xpath = "//span[@class='icon-device']")
    private WebElement deviceCard;
    @FindBy(xpath = "//div[@class='grid body-list marked']")
    private WebElement devicePageMarkedColumn;
    @FindBy(xpath = "//p[normalize-space()='C004527']")
    private WebElement devicePage_DeviceName;
    @FindBy(xpath = "//div[@class='site-name']")
    private WebElement sitePage_siteName;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='Current Conditions']")
    private WebElement sitePage_CurrentConditionF;
    @FindBy(xpath = "//h3[@class='highlight site-name truncate new-bold']")
    private WebElement siteNameF;
    @FindBy(xpath = "(//div[@class='site-summary-card grid clickable'])[1]")
    private WebElement firstSiteName;
    private long start;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(dashboardMenu_Search, 30, 1);
        map.navigateToPage(role);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Search).click().build().perform();
    }

//    public void captureSearchPageLoadTime(String role) throws IOException, InterruptedException {
//        start = System.currentTimeMillis();
//        String loadInSeconds = null;
////        StringHelper.devToolCapture(role);
//        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("orgAdmin"))) {
//            webDriverHelper.waitUntilVisible(searchIconImg, 30, 1);
//            if (searchBar.isDisplayed() && searchIconImg.isDisplayed()) {
//                loadInSeconds = stringHelper.stopTime(start, driver);
//                Assert.assertTrue(searchBar.isDisplayed(), "Search bar and icon are displayed");
//            }
//        } else {
//            webDriverHelper.waitUntilVisible(tags, 60, 1);
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(tags.isDisplayed(), "Tags are displayed");
//        }
//        ExcelReader.setValueForColumn("Search", loadInSeconds, role);
//        HTMLReport.addPageName("Search");
////        HTMLReport.generateReport("Search", loadInSeconds, responseTimeInSeconds, role);
//        HTMLReport.writeReportToFile();
//    }

    public void SiteCard(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("member") || role.equalsIgnoreCase("teamAdmin"))) {
            verifySiteCard();
        } else {
            webDriverHelper.waitUntilVisible(searchBar, 30, 1);
            searchBar.click();
            searchBar.sendKeys(siteName);
            Thread.sleep(2000);
            searchBar.sendKeys(Keys.ENTER);
            webDriverHelper.waitUntilVisible(siteResult_siteCard, 30, 1);
            if (siteResult_siteCard.isDisplayed()) {
                webDriverHelper.waitUntilVisible(site_result_Name, 30, 1);
                String SiteName = site_result_Name.getText();
                String locationDetails = siteResult_bottomText.getText();
                assertEquals(SiteName, siteName);
                Assert.assertTrue(locationDetails.contains("Region"));
            }
        }
    }

    public void DevicesCard(String role) throws IOException, InterruptedException {
        verifyDevicesCard();
    }

    public void verifyDevicesCardNavigation(String role) throws IOException, InterruptedException {
        verifyDevicesCard();
        String deviceName = device_result_Name.getText();
        device_result_Name.click();
        webDriverHelper.waitUntilVisible(devicePageMarkedColumn, 30, 1);
        webDriverHelper.waitUntilVisible(devicePage_DeviceName, 30, 1);
        String deviceName_DevicePage = devicePage_DeviceName.getText();
        String markedDevicePageColumn = devicePageMarkedColumn.getText();
        assertEquals(deviceName_DevicePage, deviceName);
        assertTrue(markedDevicePageColumn.contains(deviceName));
    }

    public void verifySiteCardNavigation(String page) throws IOException, InterruptedException {
        verifySiteCard();
        String result_Name_site = site_result_Name.getText();
        site_result_Name.click();
        webDriverHelper.waitUntilVisible(sitePage_siteName, 30, 1);
        webDriverHelper.waitUntilVisible(sitePage_CurrentConditionF, 120, 1);
        String siteName = sitePage_siteName.getText();
        assertEquals(siteName, result_Name_site);
        assertTrue(sitePage_CurrentConditionF.isDisplayed());
    }

    public void verifySiteCard() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(searchBar, 30, 1);
        searchBar.click();
//        searchBar.sendKeys(siteName);
        searchBar.sendKeys(Constants.visionSiteName);
        Thread.sleep(2000);
        searchBar.sendKeys(Keys.ENTER);
        webDriverHelper.waitUntilVisible(siteResult_siteCard, 30, 1);
        if (siteResult_siteCard.isDisplayed()) {
            System.out.println("if pass");
            webDriverHelper.waitUntilVisible(site_result_Name, 30, 1);
            String SiteName = site_result_Name.getText();
            String locationDetails = siteResult_bottomText.getText();
            Assert.assertTrue(locationDetails.contains("Region"));
        }
    }

    public void verifyDevicesCard() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(searchBar, 30, 1);
        searchBar.click();
        searchBar.sendKeys("C004527");
        Thread.sleep(2000);
        searchBar.sendKeys(Keys.ENTER);
        webDriverHelper.waitUntilVisible(deviceCard, 30, 1);
        if (deviceCard.isDisplayed()) {
            webDriverHelper.waitUntilVisible(deviceResult_bottomText, 30, 1);
            String deviceCard_location = deviceResult_bottomText.getText();
            String locationDetails = siteResult_bottomText.getText();
            String deviceCard_Details = device_result_Name.getText();
            assertEquals(deviceCard_Details, "C004527");
            Assert.assertTrue(deviceCard_location.contains("Address"));
        }
    }
}




