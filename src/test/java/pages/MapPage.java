package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.Constants;
import support.ExcelReader;
import support.PropertiesReader;

import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;

import static support.World.*;
import static support.World.mapApiHelper;

public class MapPage {

    private static final Logger log = LogManager.getLogger(MapPage.class);

    private static Boolean window;
    private final WebDriver driver;
    public String loadInSeconds = null;
    public long start;
    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//input[@type='search']")
    List<WebElement> globalOrgDropdownSearch;
    @FindBy(xpath = "(//arable-site-summary-card/div)[1]")
    WebElement firstSiteIdF;
    @FindBy(xpath = "//arable-dropdown-selector[@class='meassure-selector']//div[@class='column']")
    WebElement measurementSelected_MapPage;
    @FindAll(@FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='grid grid-center option']"))
    List<WebElement> measurements_MapPage;
    @FindBy(xpath = "//img[@src='/img/animations/loading.gif']")
    WebElement loadingIconMapPage;
    private WebDriverWait wait;
    private String siteTempValue;
    private String sitePrepValue;
    private String siteSolarValue;
    @FindBy(xpath = "(//div[@class='column'])[2]/p")
    private WebElement orgDropdownF;
    @FindAll({@FindBy(xpath = "//div[@class='scrollable-content']/arable-site-summary-card")})
    private List<WebElement> siteListF;
    @FindBy(xpath = "(//arable-site-summary-card/div)[1]/div/h3")
    private WebElement firstSiteNameF;
    @FindBy(xpath = "(//arable-site-summary-card/div/div[2]/div/div)[1]/h2")
    private WebElement firstSiteTempF;
    @FindBy(xpath = "(//arable-site-summary-card/div/div[2]/div/div)[1]/h2/span")
    private WebElement firstSiteTempUnitF;
    @FindBy(xpath = "(//arable-site-summary-card/div/div[2]/div/div)[2]/h2")
    private WebElement firstSitePrepF;
    @FindBy(xpath = "(//arable-site-summary-card/div/div[2]/div/div)[2]/h2/span")
    private WebElement firstSitePrepUnitF;
    @FindBy(xpath = "(//arable-site-summary-card/div/div[2]/div/div)[3]/h2")
    private WebElement firstSiteSolarF;
    @FindBy(xpath = "//div[@class='info-modal welcome']/div/h1")
    private WebElement welcomeToSiteF;
    @FindBy(xpath = "//div[@class='info-modal welcome']/div[3]/button")
    private WebElement welcomeCloseButtonF;
    @FindBy(xpath = "//p[normalize-space()='Map']")
    private WebElement mapPage;
    //    @FindBy(xpath = "//p[@class='selected 1']")
//    private WebElement globalOrgSelected_MapPage;
//    @FindBy(xpath = "//span[@class='caret 1']")
//    private WebElement globalOrgDropdownBtn_MapPage;
//    @FindBy(xpath = "//div[@class='dropdown-selector 1 open']//input[@type='search']")
//    private WebElement globalOrgDropdownSearch_MapPage;
//    @FindBy(xpath = "//p[normalize-space()='arable-team']")
//    private WebElement globalOrgSearchSuggestion_MapPage;
//    @FindAll(@FindBy(xpath = "//div[@class='dropdown-selector 1 open']//div[@class='options']//p"))
//    private List<WebElement> orgDropdown_orgList;
//    -----------------bnew xpath after angular merge
    @FindAll(@FindBy(xpath = "//div[@class='1 dropdown-selector open']//div[@class='options']//p"))
    private List<WebElement> orgDropdown_orgList;
//    @FindBy(xpath = "//p[@class='1 selected']")
    @FindBy(xpath = "//p[contains(@class,'1 selected')]")
    private WebElement globalOrgSelected_MapPage;
    @FindBy(xpath = "//div[@class='1 grid grid-center headers disabled'])[1]")
    private WebElement globalOrgSelectedDisabled;
    @FindBy(xpath = "//span[@class='1 caret']")
    private WebElement globalOrgDropdownBtn_MapPage;
    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//input[@type='search']")
    private WebElement globalOrgDropdownSearch_MapPage;
    //    @FindBy(xpath = "//p[normalize-space()='arable-team']")
//    private WebElement globalOrgSearchSuggestion_MapPage;
    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//div[@class='options']//p")
    private WebElement globalOrgSearchSuggestion_MapPage;
    @FindBy(xpath = "(//span[@class='0 caret'])[1]")
    private WebElement measurementDropdownOpenBtn_MapPage;
    @FindBy(xpath = "//div[@class='column-auto measure text-center']")
    private WebElement measurement_gradientBar_MapPage;
    @FindBy(xpath = "//a[normalize-space()='Unassigned Devices']")
    private WebElement unassignedDevicesTab_MapPage;
    @FindBy(xpath = "//p[@class='new-bold fancy-link']")
    private WebElement unassignedDevicesText_MapPage;
    @FindBy(xpath = "//p[contains(text(),'For a new deployment, it will be labeled \"Device I')]")
    private WebElement unassignedDevices_ModalText_MapPage;
    @FindBy(xpath = "(//img[@alt='icon_close'])[3]")
    private WebElement unassignedDevices_Modal_CloseBtn;
    @FindBy(xpath = "//div[@class='column-auto site-primary-list']//div[2]//ul[1]")
    private WebElement CurrentAndUnassignedTabsRow;
    @FindBy(xpath = "//div[@id='site-list']")
    private WebElement siteList_mapPage;
    @FindBy(xpath = "//button[@class='e-inside toggle-menu']")
    private WebElement legend_ellipsis_mapPage;
    @FindBy(xpath = "//span[normalize-space()='Minimize']")
    private WebElement legend_ellipsis_Minimize;
    @FindBy(xpath = "//span[normalize-space()='More info']")
    private WebElement legend_ellipsis_MoreInfo;
    @FindBy(xpath = "//span[normalize-space()='Expand']")
    private WebElement legend_ellipsis_Expand;
    @FindBy(xpath = "//p[@id='site-sync-delay-info']")
    private WebElement legend_MoreInfo_ModalText;
    @FindBy(xpath = "//div[@class='modal-container']//img[@alt='icon_close']")
    private WebElement legend_MoreInfo_Modal_CloseBtn;
    @FindBy(xpath = "//div[@class='content grid grid-center']")
    private WebElement legend_mapPage;
    @FindBy(xpath = "(//div[@class='column-33 column-flex grid-center'])[1]")
    private WebElement firstSiteName_mapPage;
    @FindBy(xpath = "(//a[@class='border-right today-forecast new-bold'])[1]")
    private WebElement tomorowForecastTab_mapPage;
    @FindBy(xpath = "//div[@id='site-titles']")
    private WebElement siteTitles_mapPage;
    @FindBy(xpath = "//div[@id='site-titles']")
    private WebElement siteTitles_Rain;
    @FindBy(xpath = "//button[normalize-space()='Map']")
    private WebElement mapToggleBtn;
    @FindBy(xpath = "//button[normalize-space()='Satellite']")
    private WebElement satelliteToggleBtn;
    @FindBy(xpath = "//li[@title='Show imagery with street names']")
    private WebElement satelliteLabelsView;
    @FindBy(xpath = "//li[@title='Show street map with terrain']")
    private WebElement mapTerrainView;
    @FindBy(xpath = "//li[@aria-checked='false']")
    private WebElement CheckboxUnchecked;
    @FindBy(xpath = "//li[@aria-checked='true']")
    private WebElement CheckboxChecked;
    @FindBy(xpath = "//img[@alt='Sites']")
    private WebElement sitesPageIcon;
    @FindBy(xpath = "//div[@class='go-to-site']")
    private WebElement viewSites;
    @FindBy(xpath = "//p[normalize-space()='Map']")
    private WebElement mapPageIcon;
    @FindBy(xpath = "//a[normalize-space()='Unassigned Devices']")
    private WebElement unassignedTab;
    @FindBy(xpath = "//button[contains(text(),'Create New Site')]")
    private WebElement createNewSiteBtn;
    @FindBy(xpath = "//div[@class='container-box']")
    private WebElement warningText;
    @FindBy(xpath = "//button[normalize-space()='Clear Boundary']")
    private WebElement clearBoundaryBtn;
    @FindBy(xpath = "//arable-request-button//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//h3[normalize-space()='Error Saving']")
    private WebElement errorToastMsg;
    @FindBy(xpath = "//div[@class='1 grid grid-center headers disabled']")
    private WebElement disabledElement;
    @FindBy(xpath = "//div[@class='1 grid grid-center headers']")
    private WebElement enabledElement;
    @FindBy(xpath = "//arable-dropdown-selector[@class='meassure-selector']//div[@class='column-auto']//span")
    private WebElement measurementDropDownTag;
    @FindBy(xpath = "//arable-dropdown-selector[@class='meassure-selector']//p[contains(@class,'iconEnabled')]")
    List<WebElement> measurementDropDownList;
    @FindBy(xpath = "//div[@class='column-auto measure text-center']//h2")
    private WebElement measurementText;
    @FindBy(xpath = "//p[normalize-space()='Temperature']")
    private WebElement tempTag;
    @FindBy(xpath = "//div[@class='column-33 column-flex grid-center']/h3")
    private List<WebElement> sitesInMapPage;
    @FindBy(xpath = "//div[@class='column column-flex grid-center'][1]/h2")
    private List<WebElement> sitesTempList;
    @FindBy(xpath = "//div[@class='column column-flex grid-center'][2]/h2")
    private List<WebElement> sitesRainList;
    @FindBy(xpath = "//div[@class='column column-flex grid-center'][3]/h2")
    private List<WebElement> sitesSunList;
    @FindBy(xpath = "//virtual-scroller[@id='sites-list']")
    private WebElement sitesModal;
    public List<String> sitesListInMapPage = new ArrayList<>();

    public MapPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    private MapAPIHelper mapAPIHelper = new MapAPIHelper();

    //---new code from login page for test
    boolean isElementDisplayedWithRetries(WebElement element, int maxRetries, int retryInterval) {
        int retryCount = 0;
        while (retryCount < maxRetries) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
            }
            retryCount++;
            try {
                Thread.sleep(retryInterval);
            } catch (InterruptedException e) {

            }
        }
        return false;
    }

    public void verifyOrgSelected(String role) throws IOException, InterruptedException {
        if (isOrgSelected()) {
            System.out.println("Organization is already selected. No need to switch.");
            try {
                webDriverHelper.waitUntilVisible(firstSiteIdF, 30, 2);
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException: " + e.getMessage());
            }
        } else {
            System.out.println("Organization switch needed. Proceeding with switchOrg.");
            long pauseStart = System.currentTimeMillis();
            switchOrg();
            start += System.currentTimeMillis() - pauseStart;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            try {
                wait.until(ExpectedConditions.invisibilityOf(disabledElement));
                wait.until(ExpectedConditions.visibilityOf(enabledElement));
                try {
                    webDriverHelper.waitUntilVisible(firstSiteIdF, 30, 2);
                } catch (StaleElementReferenceException e) {
                    System.out.println("StaleElementReferenceException: " + e.getMessage());
                }
            } catch (TimeoutException e) {
                System.out.println("TimeoutException: " + e.getMessage());
            }
        }
    }

    public void captureLoadTime(String role) throws IOException, InterruptedException {
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Maps page - Load", loadInSeconds, role);
    }

    private boolean isOrgSelected() {
        return globalOrgSelected_MapPage.getText().contains(PropertiesReader.orgTargeted);
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
        start = System.currentTimeMillis();
        try {
            webDriverHelper.waitUntilVisible(loginPage.mapZoomOutBtnF, 300, 2);
            webDriverHelper.waitUntilVisible(loginPage.CloseBtn, 30, 2);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException occurred while waiting for mapZoomOutBtnF.");
        }
//        webDriverHelper.waitUntilVisible(loginPage.mapZoomOutBtnF, 300, 2);
        webDriverHelper.waitUntilVisible(loginPage.CloseBtn, 30, 2);
        Assert.assertTrue(loginPage.CloseBtn.isDisplayed(), "Modal Close button is not displayed on the dashboard page");
        loginPage.CloseBtn.click();
        verifyOrgSelected(role);
    }

    public void verifyGDDResponseTime() throws InterruptedException {
        webDriverHelper.waitUntilVisible(firstSiteName_mapPage, 30, 1);
        Thread.sleep(1000);
        measurementDropdownOpenBtn_MapPage.click();
    }

    public void verifyDefaultView(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 60, 1);
        String fontWeight = satelliteToggleBtn.getCssValue("font-weight");
        Assert.assertEquals(fontWeight, "500");
    }

    public void verifyWarningText(String role) throws InterruptedException {
        verifyUnassignedAssignedPage(role);
        if (createNewSiteBtn.isDisplayed()) {
            createNewSiteBtn.click();
            webDriverHelper.waitUntilVisible(warningText, 90, 1);
            String warningTextMsg = warningText.getText();
            Assert.assertEquals(warningTextMsg, Constants.warningMsg);
        }
    }

    public void verifyClearBoundaryBtn(String role) throws InterruptedException {
        verifyWarningText(role);
        webDriverHelper.waitUntilVisible(clearBoundaryBtn, 90, 1);
        String clearBoundaryBtnText = clearBoundaryBtn.getText();
        System.out.println("clearBoundaryBtnText:- " + clearBoundaryBtnText);
        Assert.assertEquals(clearBoundaryBtnText, Constants.clearBoundaryBtnText);
    }

    public void verifySavingSiteWithoutBoundary(String role) throws InterruptedException {
        verifyClearBoundaryBtn(role);
        clearBoundaryBtn.click();
        confirmBtn.click();
        webDriverHelper.waitUntilVisible(errorToastMsg, 90, 1);
        String errorText = errorToastMsg.getText();
        Assert.assertEquals(errorText, Constants.errorText);
    }

    public void verifyToggleButtons(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 60, 1);
        String mapToggleBtnText = mapToggleBtn.getText();
        String satToggleBtnText = satelliteToggleBtn.getText();
        Assert.assertEquals(mapToggleBtnText, "Map");
        Assert.assertEquals(satToggleBtnText, "Satellite");
    }

    public void verifySwitchingSatelliteToMapView(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 60, 1);
        int satFontWeight = Integer.parseInt(satelliteToggleBtn.getCssValue("font-weight"));
        int mapFontWeight = Integer.parseInt(mapToggleBtn.getCssValue("font-weight"));
        if (satFontWeight > mapFontWeight) {
            mapToggleBtn.click();
            String mapFontWeightNew = mapToggleBtn.getCssValue("font-weight");
            Assert.assertEquals(mapFontWeightNew, "500");
        }
    }

    public void verifyTerrainViewCheckbox(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 60, 1);
        mapToggleBtn.click();
        webDriverHelper.waitUntilVisible(mapTerrainView, 30, 1);
        String subToggleBtnText = mapTerrainView.getText();
//        Assert.assertEquals(subToggleBtnText, "Labels");
        if (CheckboxUnchecked.isDisplayed()) {
            mapTerrainView.click();
//            Assert.assertTrue(CheckboxChecked.isDisplayed(), "Checkbox is checked");
        }
    }

    public void verifyLabelViewCheckbox(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 60, 1);
        satelliteToggleBtn.click();
        webDriverHelper.waitUntilVisible(satelliteLabelsView, 30, 1);
        String subToggleBtnText = satelliteLabelsView.getText();
        Assert.assertEquals(subToggleBtnText, "Labels");
        if (CheckboxUnchecked.isDisplayed()) {
            satelliteLabelsView.click();
            Assert.assertTrue(CheckboxChecked.isDisplayed(), "Checkbox is checked");
        } else {
            Assert.assertTrue(CheckboxChecked.isDisplayed(), "Checkbox is already checked");
        }
    }

    public void verifyViewOnSwitchingPages(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(mapToggleBtn, 60, 1);
        mapToggleBtn.click();
        String mapFontWeight = mapToggleBtn.getCssValue("font-weight");
        Assert.assertEquals(mapFontWeight, "500");
        sitesPageIcon.click();
        webDriverHelper.waitUntilVisible(viewSites, 30, 1);
        mapPageIcon.click();
        webDriverHelper.waitUntilVisible(mapToggleBtn, 30, 1);
        String mapFontWeightNew = mapToggleBtn.getCssValue("font-weight");
        Assert.assertEquals(mapFontWeight, mapFontWeightNew);
    }

    public void verifyTerrainViewOnSwitchingPages(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 60, 1);
        mapToggleBtn.click();
        webDriverHelper.waitUntilVisible(mapTerrainView, 60, 1);
        mapTerrainView.click();
        String mapFontWeight = mapToggleBtn.getCssValue("font-weight");
        Assert.assertEquals(mapFontWeight, "500");
        sitesPageIcon.click();
        webDriverHelper.waitUntilVisible(viewSites, 30, 1);
        mapPageIcon.click();
        webDriverHelper.waitUntilVisible(mapToggleBtn, 30, 1);
        mapToggleBtn.click();
        Assert.assertTrue(CheckboxChecked.isDisplayed(), "checkbox is checked");
    }

    public void verifyLabelsViewOnSwitchingPages(String role) throws InterruptedException {
        verifyLabelViewCheckbox(role);
        sitesPageIcon.click();
        webDriverHelper.waitUntilVisible(viewSites, 30, 1);
        mapPageIcon.click();
        webDriverHelper.waitUntilVisible(satelliteToggleBtn, 30, 1);
        satelliteToggleBtn.click();
        webDriverHelper.waitUntilVisible(satelliteLabelsView, 30, 1);
        Assert.assertTrue(CheckboxChecked.isDisplayed(), "checkbox is checked");
    }

    public void verifyForecastTab(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 30, 1);
        String siteTitleText = siteTitles_mapPage.getText();
        tomorowForecastTab_mapPage.click();
        webDriverHelper.waitUntilVisible(siteTitles_Rain, 30, 1);
        String siteTitleForecastText = siteTitles_mapPage.getText();
        Assert.assertNotEquals(siteTitleForecastText, siteTitleText);
    }


    public void verifyMinimizeAndMoreInfo(String role) throws InterruptedException {
        verifyMoreInfoModal();
        verifyMinimizeAndExpandInLegend();
    }

    public void verifyUnassignedAssignedPage(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 30, 1);
        System.out.println("siteList_mapPage:-  " + siteList_mapPage.getText().contains("Unassigned Devices"));
        if (unassignedDevicesTab_MapPage.isDisplayed()) {
            unassignedDevicesTab_MapPage.click();
            webDriverHelper.waitUntilVisible(unassignedDevicesText_MapPage, 30, 1);
            unassignedDevicesText_MapPage.click();
            webDriverHelper.waitUntilVisible(unassignedDevices_ModalText_MapPage, 30, 1);
            Assert.assertTrue(unassignedDevices_ModalText_MapPage.isDisplayed());
            unassignedDevices_Modal_CloseBtn.click();
        } else if (!(siteList_mapPage.getText().contains("Unassigned Devices"))) {
            Assert.assertFalse(siteList_mapPage.getText().contains("Unassigned Devices"));
        }
    }

    public void verifySwitchingMeasurement(String role) throws InterruptedException, IOException {
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 30, 1);
        measurementSelected_MapPage.click();
        webDriverHelper.waitUntilVisibilityOfAllElements(measurements_MapPage, 30, 1);
        for (WebElement tempEle : measurements_MapPage) {
            String option = tempEle.getText();
            String gradientBar = measurement_gradientBar_MapPage.getText();
            tempEle.click();
            Thread.sleep(1000);
            String titleName = measurementSelected_MapPage.getText();
//            StringHelper.devToolCapture(role);
            if (titleName.contains("Growing Degree Days") && option.contains("Growing Degree Days (Current Season)")) {
                long start = System.currentTimeMillis();
                webDriverHelper.waitUntilVisible(loginPage.mapZoomOutBtnF, 300, 2);
                loadInSeconds = stringHelper.stopTime(start, driver);
                ExcelReader.setValueForColumn("Map- GDD", loadInSeconds, role);
                Assert.assertTrue(titleName.contains("Growing Degree Days"));
            } else {
                Assert.assertEquals(titleName, option);
            }
            String Updated_GradientBar = measurement_gradientBar_MapPage.getText();
            Thread.sleep(500);
            if (titleName.contains("Precipitation (Last 10 Days)") || titleName.contains("ET (Last 10 Days)")) {
                Assert.assertEquals(gradientBar, Updated_GradientBar);
            } else {
                Assert.assertNotEquals(gradientBar, Updated_GradientBar);
            }
            if (titleName.contains("Soil Moisture")) {
                Assert.assertTrue(Updated_GradientBar.contains(Constants.soilMoistureUnit));
            }
            measurementDropdownOpenBtn_MapPage.click();
            Thread.sleep(1000);
            webDriverHelper.waitUntilVisibilityOfAllElements(measurements_MapPage, 30, 1);
        }
    }

    public void verifyMoreInfoModal() throws InterruptedException {
        webDriverHelper.waitUntilVisible(firstSiteName_mapPage, 30, 1);
        Thread.sleep(1000);
        legend_ellipsis_mapPage.click();
        Thread.sleep(1000);
        webDriverHelper.waitUntilVisible(legend_ellipsis_MoreInfo, 30, 1);
        legend_ellipsis_MoreInfo.click();
        webDriverHelper.waitUntilVisible(legend_MoreInfo_ModalText, 30, 1);
        Assert.assertTrue(legend_MoreInfo_ModalText.isDisplayed());
        legend_MoreInfo_Modal_CloseBtn.click();
        webDriverHelper.waitUntilVisible(legend_MoreInfo_ModalText, 30, 1);
        webDriverHelper.waitUntilVisible(legend_ellipsis_mapPage, 30, 1);
    }

    public void verifyMinimizeAndExpandInLegend() throws InterruptedException {
        verifyMoreInfoModal();
        String legendText = legend_mapPage.getText();
        legend_ellipsis_mapPage.click();
        webDriverHelper.waitUntilVisible(legend_ellipsis_Minimize, 30, 1);
        legend_ellipsis_Minimize.click();
        Thread.sleep(1000);
        String legendTextUpdated = legend_mapPage.getText();
        Assert.assertNotEquals(legendTextUpdated, legendText);
        webDriverHelper.waitUntilVisible(legend_ellipsis_mapPage, 30, 1);
        legend_ellipsis_mapPage.click();
        webDriverHelper.waitUntilVisible(legend_ellipsis_Expand, 30, 1);
        legend_ellipsis_Expand.click();
        Thread.sleep(1000);
        String legendTextExpanded = legend_mapPage.getText();
        Assert.assertNotEquals(legendTextExpanded, legendTextUpdated);
    }

    public void waitForElementToBeVisible(WebElement element, int maxWaitInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitInSeconds));
        wait.pollingEvery(Duration.ofSeconds(1)); // Check every 1 second
        wait.ignoring(StaleElementReferenceException.class); // Ignore stale element exception

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            // Handle the timeout exception or log an error message
            System.out.println("Element not visible after " + maxWaitInSeconds + " seconds");
        }
    }

    public void switchOrg() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(globalOrgSelected_MapPage));
        Thread.sleep(5000);

        if (!(globalOrgSelected_MapPage.getText().contains(PropertiesReader.orgTargeted))) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", globalOrgDropdownBtn_MapPage);

            waitForElementToBeVisible(globalOrgDropdownSearch_MapPage, 30);
            wait.until(ExpectedConditions.elementToBeClickable(globalOrgDropdownSearch_MapPage));

            if (!globalOrgDropdownSearch_MapPage.isEnabled() || !globalOrgDropdownSearch_MapPage.isDisplayed()) {
                globalOrgDropdownBtn_MapPage.click();
                wait.until(ExpectedConditions.visibilityOf(globalOrgDropdownSearch_MapPage));
                wait.until(ExpectedConditions.elementToBeClickable(globalOrgDropdownSearch_MapPage));
            }

            globalOrgDropdownSearch_MapPage.sendKeys(PropertiesReader.orgTargeted);

            List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='options'])[1]//p")));
            WebElement exactSuggestion = null;
            for (WebElement suggestion : suggestions) {
                if (suggestion.getText().equals(PropertiesReader.orgTargeted)) {
                    exactSuggestion = suggestion;
                    break;
                }
            }

            if (exactSuggestion != null) {

                exactSuggestion.click();
//                Thread.sleep(3000);

                executor.executeScript("arguments[0].scrollIntoView(true);", exactSuggestion);

                try {
                    webDriverHelper.waitUntilVisible(exactSuggestion, 30, 2);
                } catch (TimeoutException e) {
                    System.out.println("Timeout exception: " + e.getMessage());
                }
            } else {
                throw new NoSuchElementException("Exact suggestion not found in the dropdown");
            }
        } else {
            Assert.assertTrue(globalOrgSelected_MapPage.getText().contains(PropertiesReader.orgTargeted), "org name is not arable team");
        }
    }

    public void verifyOrgDropdown() {
        webDriverHelper.waitUntilVisible(orgDropdownF, 30, 1);
        webDriverHelper.waitUntilVisibilityOfAllElements(siteListF, 30, 1);
        if (welcomeToSiteF.isDisplayed()) {
            welcomeCloseButtonF.click();
        }
        Assert.assertTrue(orgDropdownF.isDisplayed(), "org drown is not displayed");
        Assert.assertTrue(orgDropdownF.isEnabled(), "org drown is not displayed");
        orgName = orgDropdownF.getText();
    }

    public void getSiteDetails() {
        webDriverHelper.waitUntilVisibilityOfAllElements(siteListF, 30, 1);
        siteID = firstSiteIdF.getAttribute("id");
        siteName = firstSiteNameF.getAttribute("title");
        siteTempValue = firstSiteTempF.getText();
        sitePrepValue = firstSitePrepF.getText();
        siteSolarValue = firstSiteSolarF.getText();
    }

    public void verifySiteValues() {
        Assert.assertTrue(siteTempValue.contains(tAir), "Site display incorrect temperature value");
        Assert.assertTrue(sitePrepValue.contains(precipitation), "Site display incorrect rain value");
        Assert.assertTrue(siteSolarValue.contains(sun), "Site display incorrect solar value");
    }

    public void verifySiteUnits() {
        Assert.assertTrue(siteTempValue.contains(tempUnit), "Site display incorrect temperature unit");
        System.out.println("sitePrepValue.contains(sizeUnit)" + sitePrepValue);
        System.out.println("sizeUnit)" + sizeUnit);
        Assert.assertTrue(sitePrepValue.contains(sizeUnit), "Site display incorrect rain unit");
    }

    public void clickOnSite() {
        webDriverHelper.waitUntilVisibilityOfAllElements(siteListF, 30, 1);
        firstSiteIdF.click();
    }

    public void changingTheTemperatureDropdownToWind() {
        try {
            navigateToMapPage();
            measurementDropDownTag.click();
            webDriverHelper.waitUntilVisible(tempTag, 60, 1);
            for (WebElement measurementName : measurementDropDownList) {
                String measurement = measurementName.getText();
                if (measurement.equalsIgnoreCase("Wind")) {
                    measurementName.click();
                    break;
                }
            }
            String measurementTexts = measurementText.getText();
            Assert.assertTrue(measurementTexts.contains(speedUnit), "the map page speed unit is not matching expected :" + speedUnit + " actual :" + measurementTexts + "");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("changingTheTemperatureDropdownToWind.jpg");
            Assert.fail("The exception in the changingTheTemperatureDropdownToWind" + exc);
        }
    }

    public void changingTheTemperatureDropdownToDailyETc() throws InterruptedException {
        try {
            navigateToMapPage();
            measurementDropDownTag.click();
            Thread.sleep(3000);
            webDriverHelper.waitUntilVisible(tempTag, 60, 1);
            for (WebElement measurementName : measurementDropDownList) {
                String measurement = measurementName.getText().trim();
                if (measurement.contains("Daily ETc")) {
                    measurementName.click();
                    break;
                }
            }
            String measurementTextWeatherPage = measurementText.getText();
            Assert.assertTrue(measurementTextWeatherPage.contains(sizeUnit), "the size unit is not matching on the weather page");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("changingTheTemperatureDropdownToDailyETc.jpg");
            Assert.fail("The exception in the changingTheTemperatureDropdownToDailyETc" + exc);
        }
    }

    public void navigateToMapPage() {
        try {
            driver.findElement(By.xpath("//p[text()='Map']")).click();
            webDriverHelper.waitUntilVisible(measurementDropDownTag, 60, 1);
            Thread.sleep(1000);
            if (!(globalOrgSelected_MapPage.getText().contains("arable-team"))) {
                globalOrgDropdownBtn_MapPage.click();
                webDriverHelper.waitUntilVisible(globalOrgDropdownSearch_MapPage, 30, 1);
                globalOrgDropdownSearch_MapPage.sendKeys("arable-team");
                wait.until(ExpectedConditions.elementToBeClickable(globalOrgSearchSuggestion_MapPage));
                globalOrgSearchSuggestion_MapPage.click();
                webDriverHelper.waitUntilVisible(firstSiteIdF, 150, 1);
            } else {
                Assert.assertTrue(globalOrgSelected_MapPage.getText().contains("arable-team"), "org name is not arable team");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("navigateToMapPage.jpg");
            Assert.fail("The exception in the navigateToMapPage" + exc);
        }
    }

    public void verifyTheUnitInTemp() {
        try {
            navigateToMapPage();
            webDriverHelper.waitUntilVisible(tempTag, 60, 1);
            String tempUnitInMapPage = measurementText.getText();
            log.info("tempUnitInMapPage " + tempUnitInMapPage);
            Assert.assertTrue(tempUnitInMapPage.contains(tempUnit), "the temp unit is not matching on the map page");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheUnitInTemp.jpg");
            Assert.fail("The exception in the verifyTheUnitInTemp" + exc);
        }
    }

    public void verifyTheMeasurementDataInBothUIAndAPI() {
        try {
            Map<String, String[]> siteToValuesMapInUI = new HashMap<>();
            for (int i = 0; i < sitesInMapPage.size(); i++) {
                String site = sitesInMapPage.get(i).getText();
                if (i < sitesTempList.size() && i < sitesRainList.size() && i < sitesSunList.size()) {
                    String tempValues = sitesTempList.get(i).getText();
                    String[] part = tempValues.split("°");
                    String temp = part[0].trim();
                    String rainText = sitesRainList.get(i).getText();
                    String radiantValue = sitesSunList.get(i).getText();
                    String[] columnValues = {
                            temp,
                            webDriverHelper.extractDigits(rainText),
                            radiantValue
                    };
                    siteToValuesMapInUI.put(site, columnValues);
                }
            }

            log.info("siteToValuesMapInUI size: " + siteToValuesMapInUI.size());
            mapApiHelper.getSitesMeasuresFromAPI();
            for (Map.Entry<String, String[]> entry : siteToValuesMapInUI.entrySet()) {
                String site = entry.getKey();
                String[] uiValues = entry.getValue();
                if (siteToValuesMapInApi.containsKey(site)) {
                    String[] apiValues = siteToValuesMapInApi.get(site);
                    if (!Arrays.equals(uiValues, apiValues)) {
                        Assert.fail("UI values for site " + site + " do not match API values.\nUI Values: " + Arrays.toString(uiValues) + "\nAPI Values: " + Arrays.toString(apiValues));
                    }
                } else {
                    Assert.fail("Site in UI not found in API: " + site);
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheMeasurementDataInBothUIAndAPI.jpg");
            Assert.fail("Failed in verifyTheMeasurementDataInBothUIAndAPI method due to exception: " + exc.getMessage());
        }
    }

    public void verifyTheSitesAreInSequenceInBothAPIAndUI() {
        try {
            while (!webDriverHelper.isModalAtBottom(sitesModal)) {
                for (WebElement element : sitesInMapPage) {
                    String site = element.getText();
                    if (!sitesListInMapPage.contains(site)) {
                        sitesListInMapPage.add(site);
                    }
                }
                webDriverHelper.scrollModal(sitesModal);
                Thread.sleep(1000);
            }
            List<String> uiSiteList = new ArrayList<>(sitesListInMapPage);
            List<String> apiSiteList = new ArrayList<>(sitesListInAPI);
            String[] uiArray = uiSiteList.toArray(new String[0]);
            String[] apiArray = apiSiteList.toArray(new String[0]);
            int maxAllowedMismatches = 10; // Change this value according to your requirement
            int mismatchCount = 0;
            int mismatchIndex = -1;
            for (int i = 0; i < Math.min(uiArray.length, apiArray.length); i++) {
                if (!uiArray[i].equals(apiArray[i])) {
                    mismatchCount++;
                    if (mismatchIndex == -1) {
                        mismatchIndex = i;
                    }
                }
            }
            if (mismatchCount > maxAllowedMismatches) {
                log.info("Maximum number of mismatches sites: " + mismatchCount);
                log.info("First mismatch found at index " + mismatchIndex);
                log.info("Expected site in UI: " + uiArray[mismatchIndex]);
                log.info("Expected site in API: " + apiArray[mismatchIndex]);
                Assert.fail("Site names in both UI and API are not in same sequence (The site names are getting mismatch).");
            } else {
                log.info("Site names in both UI and API are in same sequence.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheSitesAreInSequenceInBothAPIAndUI.jpg");
            Assert.fail("Failed in verifyTheSitesAreInSequenceInBothAPIAndUI method due to exception :- " + exc);
        }
    }

}