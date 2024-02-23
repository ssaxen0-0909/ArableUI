package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.Constants;
import support.ExcelReader;
import support.HTMLReport;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static support.World.*;

public class performance {
    private final WebDriver driver;

    String loadInSeconds = null;
    long start;
    @FindBy(xpath = "//div[@class='column name']//p")
    WebElement teamName;
    @FindBy(xpath = "//h2[normalize-space()='Site Information']")
    WebElement viewTeamContent;
    @FindBy(xpath = "//input[@id='site-search']")
    WebElement sitesSearchField;
    @FindBy(xpath = "//p[normalize-space()='Analysis']")
    WebElement dashboardMenuAnalysis;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='search-input-container']//input[@type='search']")
    WebElement graphSearchField;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='search-input-container']//img[@class='input-clear']")
    WebElement graphSearchClearBtn;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='grid grid-center option item checkbox-right']")
    WebElement graphSearchSuggestion;
    @FindBy(xpath = "//label[normalize-space()='Growing Degree Days']")
    WebElement gdd;
    @FindBy(xpath = "(//arable-site-summary-card/div)[1]")
    private WebElement firstSiteIdF;
    @FindBy(xpath = "//span[@class='2 caret']")
    private WebElement teamsDropdownOpenBtn;
    @FindBy(xpath = "(//input[@type='search'])[2]")
    private WebElement teamsDropdownSearch;
    @FindBy(xpath = "(//div[@class='options'])[2]//p")
    private WebElement teamsSearchOption;
    @FindBy(xpath = "//div[@class='column-auto measure text-center']")
    private WebElement legendGDD;
    @FindBy(xpath = "//img[@src='/img/animations/loading.gif']")
    private WebElement siteLoadingIcon;
    @FindBy(xpath = "//p[@class='1 selected']")
    private WebElement globalOrgSelected_MapPage;
    @FindBy(xpath = " //div[@class='tooltip-team']//div[@class='head-tooltip']")
    private WebElement createTeamModalTitle;
    @FindBy(xpath = "//div[@class='teams-header-fixed']//div[2]")
    private WebElement createTeamBtn;
    @FindBy(xpath = "//p[normalize-space()='Water']")
    private WebElement dashboardMenuWater;
    @FindBy(xpath = "//button[@title='Zoom in']")
    private WebElement zoomInBtn;
    @FindBy(xpath = "//div[@class='site-list-section']//p | //div[@class='no-sites']")
    private WebElement siteList;
    @FindBy(xpath = " //div[@class='calender']")
    private WebElement last7daysCalendar;
    @FindBy(xpath = "//p[normalize-space()='GDD']")
    private WebElement selectedMeasureGDD;
    @FindBy(xpath = "//div[@class='season-box even']//p")
    private WebElement seasonCalendar;
    @FindBy(xpath = "(//span[contains(text(),'—/—/—')])[1]")
    private WebElement emptyStartDate;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='NDVI']")
    private WebElement NDVI;

    public performance(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void captureLoadTimeOnSwitchingGDDMeasurement(String role) throws InterruptedException, IOException {
        selectGDDMeasurement(); // Calling the method to select GDD
        Thread.sleep(1000);
        String titleName = map.measurementSelected_MapPage.getText();
//            StringHelper.devToolCapture(role);
        start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(loginPage.mapZoomOutBtnF, 300, 2);
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Maps - Select Growing Degree days", loadInSeconds, role);
        Assert.assertTrue(titleName.contains("Growing Degree Days"));
    }


    public void captureLoadTimeOnSwitchingTeam(String role) throws InterruptedException, IOException {
        switchingSpecificTeam(role);
//            StringHelper.devToolCapture(role);
        start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(firstSiteIdF, 300, 2);
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Maps page - Select Team", loadInSeconds, role);
        Assert.assertTrue(firstSiteIdF.isDisplayed());

    }

    public void captureLoadTimeOnSwitchingTeamAndThenGDD(String role) throws InterruptedException, IOException {
        switchingSpecificTeam(role);
        selectGDDMeasurement();
//            StringHelper.devToolCapture(role);
        start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(loginPage.mapZoomOutBtnF, 200, 2);
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Maps page - Select Team and Growing Degree Days", loadInSeconds, role);
        Assert.assertTrue(legendGDD.getText().contains("GDD"));
    }

    public void switchingSpecificTeam(String role) throws InterruptedException, IOException {
        try {
            teamsDropdownOpenBtn.click();
            webDriverHelper.waitUntilVisible(teamsDropdownSearch, 90, 1);
            teamsDropdownSearch.click();
            teamsDropdownSearch.sendKeys(Constants.GlobalTeamName);
            webDriverHelper.waitUntilVisible(teamsSearchOption, 30, 1);
            Assert.assertTrue(teamsSearchOption.getText().contains(Constants.GlobalTeamName));
            teamsSearchOption.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Exception:-" + e);
        }
    }

    public void selectGDDMeasurement() {
//        webDriverHelper.waitUntilVisible(map.measurementSelected_MapPage, 30, 1);
        map.measurementSelected_MapPage.click();
        webDriverHelper.waitUntilVisibilityOfAllElements(map.measurements_MapPage, 30, 1);
        boolean foundGrowingDegreeDays = false; // Flag to track if "Growing Degree Days" is found
        for (WebElement tempEle : map.measurements_MapPage) {
            String option = tempEle.getText();
            if (option.contains("Growing Degree Days")) {
                tempEle.click();
                break; // Exit the loop after clicking on "Growing Degree Days"
            }
        }
    }

    //-------Teams---
    public void captureTeamsPageLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        long start = System.currentTimeMillis();
//            StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(teamsPage.teamsFirstRow_orgReader, 30, 1);
        Assert.assertTrue(teamsPage.teamsFirstRow_orgReader.isDisplayed(), "Tags are displayed");
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Teams page Load", loadInSeconds, role);
    }

    public void captureCreateTeamsModalLoadTime(String role) throws InterruptedException {
        if (!isValidRole(role)) {
            webDriverHelper.waitUntilVisible(teamsPage.teams_AdministratorsRow, 90, 1);
            createTeamBtn.click();
            start = System.currentTimeMillis();
            webDriverHelper.waitUntilVisible(teamsPage.teamNameTextF, 30, 1);
            Assert.assertTrue(createTeamModalTitle.getText().contains("Create New Team"), "Title is displayed");
            loadInSeconds = (stringHelper.stopTime(start, driver));
            ExcelReader.setValueForColumn("Open Create Team View", loadInSeconds, role);
        } else {
            checkCreateNewTeamBtnVisibility(role);
            ExcelReader.setValueForColumn("Open Create Team View", "NA", role);
        }
    }

    private boolean isValidRole(String role) {
        String[] validRoles = {"orgReader", "sysReader", "member", "teamAdmin"};
        for (String validRole : validRoles) {
            if (role.equalsIgnoreCase(validRole)) {
                return true;
            }
        }
        return false;
    }

    private void checkCreateNewTeamBtnVisibility(String role) {
        try {
            boolean isCreateNewTeamBtnDisplayed = teamsPage.createNewTeamBtnF.isDisplayed();
            Assert.assertFalse(isCreateNewTeamBtnDisplayed, "createNewTeamBtn should not be displayed");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("createNewTeamBtnF is not present on the page for role: " + role);
        }
    }

    public void captureViewTeamsModalLoadTime(String role) throws InterruptedException, IOException {
        webDriverHelper.waitUntilVisible(teamsPage.teamsFirstRow_orgReader, 30, 1);
        switchingSpecificTeam(role);
        System.out.println("teamsPage.teamsFirstRow_orgReader:- " + teamName.getText());
        webDriverHelper.waitUntilVisible(teamName, 30, 1);
        if (teamName.getText().contains(Constants.GlobalTeamName))
            teamName.click();
        start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(viewTeamContent, 30, 1);
        Assert.assertTrue(viewTeamContent.getText().contains("Site Information"));
        loadInSeconds = (stringHelper.stopTime(start, driver));
        ExcelReader.setValueForColumn("Teams- View Team Details", loadInSeconds, role);
    }

    public void captureSitePageLoadTime(String role) throws IOException {
        String loadInSeconds = null;
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(sitesPage.viewSiteBtn_SiteCard, 120, 2);
        if (sitesPage.viewSiteBtn_SiteCard.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(sitesPage.viewSiteBtn_SiteCard.isDisplayed(), "site cards are displayed");
        } else {
            webDriverHelper.waitUntilVisible(sitesPage.noSitesAvailable, 90, 2);
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(sitesPage.noSitesAvailable.isDisplayed(), "Click here to create new site is displayed");
        }
        ExcelReader.setValueForColumn("Sites Page Load", loadInSeconds, role);
    }

    public void captureEditSiteLoadTime(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("sysReader") || role.equalsIgnoreCase("orgReader"))) {
            String loadInSeconds = null;
            sitesPage.verifyEditSiteOption();
            long start = System.currentTimeMillis();
//            StringHelper.devToolCapture(role);
            webDriverHelper.waitUntilVisible(sitesPage.clearBoundaryBtn, 90, 1);
            loadInSeconds = stringHelper.stopTime(start, driver);
            ExcelReader.setValueForColumn("Open Edit Sites modal", loadInSeconds, role);
        } else {
            ExcelReader.setValueForColumn("Open Edit Sites modal", "NA", role);
        }
    }

    public void captureSpecificTeamLoadTimeInSites(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(sitesPage.viewSiteBtn_SiteCard, 120, 2);
        switchingSpecificTeam(role);
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(sitesPage.viewSiteBtn_SiteCard, 120, 2);
        Assert.assertTrue(sitesPage.viewSiteBtn_SiteCard.isDisplayed());
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Sites Page Load for team", loadInSeconds, role);
    }

    public void SearchSitesInSitePageWithTeamFilter(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(sitesPage.viewSiteBtn_SiteCard, 120, 2);
        switchingSpecificTeam(role);
        searchSitesInSitePage();
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(sitesPage.viewSiteBtn_SiteCard, 120, 2);
        Assert.assertTrue(sitesPage.viewSiteBtn_SiteCard.isDisplayed());
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Search Sites in Site Page with Team filter", loadInSeconds, role);
    }

    public void SearchSitesInSitePageForAllTeams(String role) throws IOException, InterruptedException {
        searchSitesInSitePage();
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(sitesPage.viewSiteBtn_SiteCard, 120, 2);
        Assert.assertTrue(sitesPage.viewSiteBtn_SiteCard.isDisplayed());
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Search Sites in Site Page all Teams", loadInSeconds, role);
    }

    public void searchSitesInSitePage() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(sitesPage.viewSiteBtn_SiteCard, 120, 2);
        sitesSearchField.click();
        sitesSearchField.sendKeys("Act");
        sitesSearchField.sendKeys(Keys.ENTER);
    }

    public void multiSiteWaterByOrg(String role) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(siteList, 120, 1);
        Assert.assertTrue(last7daysCalendar.isDisplayed());
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("MultiSite_Water by org", loadInSeconds, role);
    }

    public void multiSiteWaterByTeam(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(siteList, 120, 1);
        switchingSpecificTeam(role);
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(siteList, 30, 1);
        Assert.assertTrue(last7daysCalendar.isDisplayed());
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("MultiSite_Water by team - org", loadInSeconds, role);
    }

    public void navigateToMultisiteWaterPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(dashboardMenuAnalysis, 30, 1);
        map.navigateToPage(role);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenuAnalysis).moveToElement(dashboardMenuWater).click().build().perform();
    }

    public void captureGraphPageLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        if (!role.equalsIgnoreCase("sysReader")) {
            webDriverHelper.waitUntilVisible(graphPage.graphSitesDropdownCard, 30, 1);
            if (graphPage.graphSitesDropdownCard.isDisplayed()) {
                Assert.assertTrue(graphPage.graphSitesDropdownCard.isDisplayed(), "site names are displayed");
                loadInSeconds = stringHelper.stopTime(start, driver);
            }
        } else {
            webDriverHelper.waitUntilVisible(graphPage.firstSiteName_sysreader, 30, 1);
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(graphPage.firstSiteName_sysreader.isDisplayed(), "site name is displayed");
        }
        ExcelReader.setValueForColumn("Graph Page Load", loadInSeconds, role);
        HTMLReport.writeReportToFile();
    }

    public void captureGraphPageDailyLoadTime(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(graphPage.graphSitesDropdownCard, 30, 1);
        if (graphPage.graphSitesDropdownCard.isDisplayed()) {
            graphPage.firstSiteName.click();
            graphPage.insertValues();
//            StringHelper.devToolCapture(role);
            start = System.currentTimeMillis();
            webDriverHelper.waitUntilVisible(graphPage.graphTable, 30, 1);
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(graphPage.graphTable.isDisplayed(), "graph tables are displayed");
        }
        ExcelReader.setValueForColumn("Graph Page - Load Calendar single site Daily data", loadInSeconds, role);
        // HTML report generator
        HTMLReport.addPageName("Graph - Daily");
//        HTMLReport.generateReport("Graph - Daily", loadInSeconds, role);
        HTMLReport.writeReportToFile();
    }

    public void captureGraphPageHourlyLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(graphPage.graphSitesDropdownCard, 30, 1);
        if (graphPage.graphSitesDropdownCard.isDisplayed()) {
            graphPage.firstSiteName.click();
            graphPage.insertValues();
            webDriverHelper.waitUntilVisible(graphPage.graphTable, 30, 1);
            graphPage.hourly_Button.click();
//            StringHelper.devToolCapture(role);
            start = System.currentTimeMillis();
            webDriverHelper.waitUntilVisible(graphPage.graphTableTimestamp, 30, 1);
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(graphPage.graphTable.isDisplayed(), "graph tables are displayed");
        }
        ExcelReader.setValueForColumn("Graph Page - Load Calendar single site Hourly Data", loadInSeconds, role);
    }

    public void captureGraphPageGDDLoadTime(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(graphPage.graphSitesDropdownCard, 30, 1);
        if (graphPage.graphSitesDropdownCard.isDisplayed()) {
            graphSearchField.click();
            graphSearchField.sendKeys("Sentek Site");
            graphSearchSuggestion.click();
            selectingParamsForGDD();
            graphPage.graphBtn.click();

//            StringHelper.devToolCapture(role);
            start = System.currentTimeMillis();
            webDriverHelper.waitUntilVisible(graphPage.graphTable, 30, 1);
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(graphPage.graphTable.isDisplayed(), "graph tables are displayed");
        }
        System.out.println("Graph Page - Calendar single site Seasons");
        ExcelReader.setValueForColumn("Graph Page - Load Calendar single site Seasons", loadInSeconds, role);
    }

    public void selectingParamsForGDD() throws IOException, InterruptedException {
        graphPage.measureDropdown.click();
        webDriverHelper.waitUntilVisible(graphPage.maxTemp, 30, 1);
        Thread.sleep(200);
        gdd.click();
        webDriverHelper.waitUntilVisible(selectedMeasureGDD, 30, 1);
        graphPage.iconCalendar.click();
        webDriverHelper.waitUntilVisible(seasonCalendar, 30, 1);
        seasonCalendar.click();
        Thread.sleep(200);
        if (emptyStartDate.isDisplayed()) {
            graphPage.iconCalendar.click();
            webDriverHelper.waitUntilVisible(seasonCalendar, 30, 1);
            seasonCalendar.click();
        }
    }

    public void captureExportPageLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(exportPage.sitesDropdown, 30, 1);
        if (exportPage.sitesDropdown.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(exportPage.sitesDropdown.isDisplayed(), "site dropdown is not displayed");
        } else {
            webDriverHelper.waitUntilVisible(exportPage.noSite, 30, 1);
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(exportPage.noSite.isDisplayed(), "No site is displayed");
        }
        ExcelReader.setValueForColumn("Export Page Load", loadInSeconds, role);
    }

    public void captureExportDailyCSVLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        exportPage.captureExport_DailyGranularity_CSVDownloadLoadTime();
//        StringHelper.devToolCapture(role);
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(exportPage.successToastMessage_csvDownload, 300, 1);
        if (exportPage.successToastMessage_csvDownload.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(exportPage.successToastMessage_csvDownload.isDisplayed(), "success message for csv download is not displayed");
        }
        ExcelReader.setValueForColumn("Export Daily - Csv Download", loadInSeconds, role);
    }

    public void captureExportHourlyCSVLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        exportPage.captureExport_HourlyGranularity_CSVDownloadLoadTime();
//        StringHelper.devToolCapture(role);
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(exportPage.successToastMessage_csvDownload, 300, 1);
        if (exportPage.successToastMessage_csvDownload.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(exportPage.successToastMessage_csvDownload.isDisplayed(), "success message for csv download is not displayed");
        }
        ExcelReader.setValueForColumn("Export Hourly - Csv Download", loadInSeconds, role);
    }

    public void captureExportAllCSVLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        exportPage.captureExport_AllGranularity_CSVDownloadLoadTime();
//        StringHelper.devToolCapture(role);
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(exportPage.successToastMessage_csvDownload, 200, 1);
        if (exportPage.successToastMessage_csvDownload.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(exportPage.successToastMessage_csvDownload.isDisplayed(), "success message for csv download is not displayed");
        }
        ExcelReader.setValueForColumn("Export page - export data no sentek", loadInSeconds, role);
    }

    public void captureExportAllSentekSite(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        exportPage.captureExport_AllGranularitySentek();
//        StringHelper.devToolCapture(role);
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(exportPage.successToastMessage_csvDownload, 200, 1);
        if (exportPage.successToastMessage_csvDownload.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(exportPage.successToastMessage_csvDownload.isDisplayed(), "success message for csv download is not displayed");
        }
        ExcelReader.setValueForColumn("Export page - export data with Sentek", loadInSeconds, role);
    }

    public void verifyGenerateKey(String role) throws InterruptedException, IOException {
        loadInSeconds = null;
        start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(accountPage.account_sizeUnits_mm, 100, 1);
        if (accountPage.account_GenerateKey.isDisplayed()) {
            accountPage.account_GenerateKey.click();
            webDriverHelper.waitUntilVisible(accountPage.account_GenerateKey_CopyBtn, 30, 1);
        } else {
            accountPage.account_GenerateKey_CopyBtn.isDisplayed();
        }
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Account Page Load", loadInSeconds, role);
        stringHelper.benchmarkComparison(loadInSeconds);

        Assert.assertTrue(accountPage.account_GeneratedAPIKey.isDisplayed());
        accountPage.account_GenerateKey_CopyBtn.click();
        webDriverHelper.waitUntilVisible(accountPage.account_successToast_CopyAPIKey, 30, 1);
        Assert.assertTrue(accountPage.account_successToast_CopyAPIKey.isDisplayed());
        Assert.assertTrue(accountPage.account_GenerateKey_RefreshBtn.isDisplayed());
        String apiKey = accountPage.account_GeneratedAPIKey.getText();
        accountPage.account_GenerateKey_RefreshBtn.click();
        webDriverHelper.waitUntilVisible(accountPage.account_GeneratedAPIKey, 30, 1);
        String newApiKey = accountPage.account_GeneratedAPIKey.getText();
        Assert.assertEquals(newApiKey, apiKey);
    }

    public void captureAlertsPageLoadTime(String role) throws IOException, InterruptedException {
//        StringHelper.devToolCapture(role);
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(alertsPage.alertsTable, 30, 1);
        if (alertsPage.alertsTable.isDisplayed()) {
            String loadInSeconds = stringHelper.stopTime(start, driver);
            ExcelReader.setValueForColumn("Alerts page Load", loadInSeconds, role);
            Assert.assertTrue(alertsPage.alertsTable.isDisplayed(), "alerts table is displayed");
        }
    }

    public void captureAlertSettingsPageLoadTime(String role) throws IOException, InterruptedException {
//        StringHelper.devToolCapture(role);
        start = System.currentTimeMillis();

        webDriverHelper.waitUntilVisible(alertSettings.defaultNotificationSetting, 30, 1);
        String loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Alerts Settings Load", loadInSeconds, role);
        Assert.assertTrue(alertSettings.defaultNotificationSetting.isDisplayed(), "alerts settings table is displayed");
    }

    public void captureDevicesPageLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(devicesPage.devicesTableLastRow, 30, 1);
        if (devicesPage.devicesTableLastRow.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            assertTrue(devicesPage.devicesTableLastRow.isDisplayed(), "devices table is displayed");
        } else {
            webDriverHelper.waitUntilVisible(devicesPage.devicesNoTable, 30, 1);
            loadInSeconds = stringHelper.stopTime(start, driver);
            System.out.println("load in seconds" + loadInSeconds);
            assertTrue(devicesPage.devicesNoTable.isDisplayed(), "No devices table is displayed");
        }
        ExcelReader.setValueForColumn("Devices Page Load", loadInSeconds, role);
        System.out.println("Device page written in excel");
    }

    public void verifyVisionPageResponseTime(String role) throws IOException, InterruptedException {
//            StringHelper.devToolCapture(role);
        start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(imgGallery.deploymentSection, 30, 1);
        if (imgGallery.imgList.size() <= 0) {
            Assert.assertTrue(imgGallery.noImgInDeploymentModal.isDisplayed());
        }
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Vision", loadInSeconds, role);
//        stringHelper.benchmarkComparison(loadInSeconds);
    }

    public void captureNotesPageLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
//        webDriverHelper.waitUntilVisible(notesTab, 30, 1);
//        notesTab.click();
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(notesTab.notesBox, 30, 1);
        if (notesTab.notesBox.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(notesTab.notesBox.isDisplayed(), "notes tab is displayed");
        }
        ExcelReader.setValueForColumn("Notes", loadInSeconds, role);
    }

    public void capturePlantPageLoadTime(String role) throws IOException {
        start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(plantTab.precipitation, 90, 1);
        webDriverHelper.waitUntilVisible(NDVI, 90, 1);
        if (NDVI.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(NDVI.isDisplayed(), "current condition table is displayed");
        }
        ExcelReader.setValueForColumn("Plant", loadInSeconds, role);
    }

    public void captureRankPageLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(rankPage.rank_Table, 30, 1);
        Assert.assertTrue(rankPage.rank_Table.isDisplayed(), "site names are not displayed");
        loadInSeconds = stringHelper.stopTime(start, driver);
        ExcelReader.setValueForColumn("Rank Page Load", loadInSeconds, role);
    }

    public void captureSearchPageLoadTime(String role) throws IOException, InterruptedException {
        start = System.currentTimeMillis();
        String loadInSeconds = null;
//        StringHelper.devToolCapture(role);
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("orgAdmin"))) {
            webDriverHelper.waitUntilVisible(searchPage.searchIconImg, 30, 1);
            if (searchPage.searchBar.isDisplayed() && searchPage.searchIconImg.isDisplayed()) {
                loadInSeconds = stringHelper.stopTime(start, driver);
                Assert.assertTrue(searchPage.searchBar.isDisplayed(), "Search bar and icon are displayed");
            }
        } else {
            webDriverHelper.waitUntilVisible(searchPage.tags, 60, 1);
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(searchPage.tags.isDisplayed(), "Tags are displayed");
        }
        ExcelReader.setValueForColumn("Search", loadInSeconds, role);
    }

    public void captureSeasonPageLoadTime(String role) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        if (!(role.equalsIgnoreCase("sysReader"))) {
            webDriverHelper.waitUntilVisible(seasonsPage.seasonsTableLastRow, 30, 1);
            String loadInSeconds = stringHelper.stopTime(start, driver);
            ExcelReader.setValueForColumn("Seasons Page Load", loadInSeconds, role);
            Assert.assertTrue(seasonsPage.seasonsTableLastRow.isDisplayed(), "seasons table is displayed");
        } else {
            webDriverHelper.waitUntilVisible(seasonsPage.seasonsTableLastRow, 30, 1);
            String loadInSeconds = stringHelper.stopTime(start, driver);
            ExcelReader.setValueForColumn("Seasons Page Load", loadInSeconds, role);
            Assert.assertTrue(seasonsPage.seasonsTableLastRow.isDisplayed(), "No seasons table is displayed");
        }
    }

    public void captureWaterPageLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        waterTab.navigateToWaterPage();
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(waterTab.waterSummaryTable, 90, 1);
        if (waterTab.waterSummaryTable.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(waterTab.waterSummaryTable.isDisplayed(), "current condition table is displayed");
        }
        ExcelReader.setValueForColumn("Single_Site_Water Load", loadInSeconds, role);
        stringHelper.benchmarkComparison(loadInSeconds);
    }

    public void captureWaterBalance_Day_LoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        waterTab.waterBalance_dropdownClick();
        waterTab.waterBalance_Month.click();
        webDriverHelper.waitUntilVisible(waterTab.waterBalance_Month_ThisMonth, 130, 1);
        waterTab.waterBalance_Dropdown.click();
        ;
        webDriverHelper.waitUntilVisible(waterTab.waterBalance_Day, 30, 1);
        waterTab.waterBalance_Day.click();
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(waterTab.waterBalance_Day_Today, 300, 1);
        if (waterTab.waterBalance_Day_Today.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(waterTab.waterBalance_Day_Today.isDisplayed(), "current condition table is displayed");
        }
        ExcelReader.setValueForColumn("Single_Site_Water Load_Day", loadInSeconds, role);
        stringHelper.benchmarkComparison(loadInSeconds);
    }

    public void captureWaterBalance_Month_LoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        waterTab.waterBalance_dropdownClick();
        waterTab.waterBalance_Month.click();
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(waterTab.waterBalance_Month_ThisMonth, 130, 1);
        if (waterTab.waterBalance_Month_ThisMonth.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(waterTab.waterBalance_Month_ThisMonth.isDisplayed(), "current condition table is displayed");
        }
        ExcelReader.setValueForColumn("Single_Site_Water Load_Monthly", loadInSeconds, role);
        stringHelper.benchmarkComparison(loadInSeconds);
    }

    public void captureWaterBalance_Week_LoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        waterTab.waterBalance_dropdownClick();
        waterTab.waterBalance_Day.click();
        webDriverHelper.waitUntilVisible(waterTab.waterBalance_Day_Today, 300, 1);
        waterTab.waterBalance_Dropdown.click();
        Thread.sleep(200);
        waterTab.waterBalance_Week.click();
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(waterTab.waterBalance_Week_ThisWeek, 300, 1);
        if (waterTab.waterBalance_Week_ThisWeek.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(waterTab.waterBalance_Week_ThisWeek.isDisplayed(), "current condition table is displayed");
        }
        ExcelReader.setValueForColumn("Single_Site_Water Load_weekly", loadInSeconds, role);
        stringHelper.benchmarkComparison(loadInSeconds);
    }

    public void captureWaterBalance_GDD_LoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        waterTab.waterBalance_dropdownClick();
        webDriverHelper.waitUntilVisible(waterTab.waterBalance_GDD, 300, 1);
        waterTab.waterBalance_GDD.click();
        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
        webDriverHelper.waitUntilVisible(waterTab.waterBalance_GDD_Current, 300, 1);
        if (waterTab.waterBalance_GDD_Current.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(waterTab.waterBalance_GDD_Current.isDisplayed(), "current condition table is displayed");
        }
        ExcelReader.setValueForColumn("Single_Site_Water Load_Growth stage", loadInSeconds, role);
        stringHelper.benchmarkComparison(loadInSeconds);
    }

    public void captureWeatherPageLoadTime(String role) throws IOException, InterruptedException {
//        StringHelper.devToolCapture(role);
        String loadInSeconds = null;
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(weatherPage.currentConditionTableF, 200, 1);
        if (weatherPage.currentConditionTableF.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(weatherPage.currentConditionTableF.isDisplayed(), "Current condition table is displayed");
            ExcelReader.setValueForColumn("Weather", loadInSeconds, role);
            stringHelper.benchmarkComparison(loadInSeconds);
        }
    }
}