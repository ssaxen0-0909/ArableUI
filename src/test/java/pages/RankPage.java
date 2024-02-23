package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.Constants;

import java.io.IOException;
import java.util.List;

import static support.World.map;
import static support.World.webDriverHelper;


public class RankPage {
    private final WebDriver driver;
    @FindBy(xpath = "//div[@id='stats-container']//div[@class='stats grid']")
    WebElement rank_Table;
    //    @FindBy(xpath = "//arable-dropdown-selector[@class='dropdown']//div[@class='headers grid grid-center 0']")
//    private WebElement dropdown_defaultSelection;
    @FindBy(xpath = "//p[normalize-space()='Analysis']")
    private WebElement dashboardMenu_Analysis;
    @FindBy(xpath = "//p[normalize-space()='Rank']")
    private WebElement dashboardMenu_Rank;
    @FindBy(xpath = "//div[@id='stats-container']")
    private WebElement rankContainer;
    @FindBy(xpath = "//p[@class='no-sites']")
    private WebElement rank_NoSites;
    //    @FindBy(xpath = "//div[@class='dropdown-selector 0 open']//div[@class='grid grid-center option selected']")
//    private WebElement rank_SortByFirstOptions;
    @FindAll(@FindBy(xpath = "//div[@class='grid grid-center option']//p[@class='iconEnabled']"))
    private List<WebElement> rank_SortByOptionsList;
    @FindBy(xpath = "//div[@class='titles']//div[6]")
    private WebElement rank_titleName;
    @FindBy(xpath = "//h3[normalize-space()='GDD (°F)']")
    private WebElement rank_titleGDD;
    //    @FindBy(xpath = "(//div[@class='column'])[13]")
//    private WebElement rankTable_MeasureValue;
//    @FindBy(xpath = "(//div[@class='column'])[12]")
//    private WebElement rankTable_MeasureValue_teamAdmin;
    @FindBy(xpath = "//div[@class='column switch-column']")
    private WebElement rank_HighLowTab;
    @FindBy(xpath = "//p[normalize-space()='High']")
    private WebElement rank_HighTab;
    @FindBy(xpath = "//p[normalize-space()='Low']")
    private WebElement rank_LowTab;
    @FindBy(xpath = "//div[@class='column low active']")
    private WebElement rank_LowTabSelected;
    @FindBy(xpath = "//h3[normalize-space()='Rank']")
    private WebElement rankTable_RankColumn;
    @FindBy(xpath = "(//div[@id='stats-container']//div[@class='stats grid'])[1]")
    private WebElement rankTable_FirstRow;
    //    @FindBy(xpath = "//p[@class='selected 1']")
//    private WebElement globalOrgSelected_MapPage;
//    @FindBy(xpath = "//span[@class='caret 1']")
//    private WebElement globalOrgDropdownBtn_MapPage;
//    @FindBy(xpath = "//div[@class='dropdown-selector 1 open']//input[@type='search']")
//    private WebElement globalOrgDropdownSearch_MapPage;
    @FindBy(xpath = "//p[normalize-space()='arable-team']")
    private WebElement globalOrgSearchSuggestion_MapPage;
    //    @FindAll(@FindBy(xpath = "//div[@class='dropdown-selector 1 open']//div[@class='options']//p"))
//    private List<WebElement> orgDropdown_orgList;
    @FindBy(xpath = "//img[@src='/img/animations/loading.gif']")
    private WebElement loaderIcon;
    @FindBy(xpath = "(//div[@class='column name-column']//a[@class='highlight bold'])[1]")
    private WebElement siteName;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Current Conditions']/div")
    private WebElement currentCondition_WeatherPage;
    @FindBy(xpath = "(//arable-site-summary-card/div)[1]")
    private WebElement firstSiteIdF;

    //--------------new xpath after angular merge
    @FindBy(xpath = "(//div[@class='0 dropdown-selector']//p[normalize-space()='Temperature'])[1]")
    private WebElement dropdown_defaultSelection;
    @FindBy(xpath = "(//div[@class='1 dropdown-selector open']//div[@class='options']//p)[2]")
    private WebElement orgDropdown_orgList;
    @FindBy(xpath = "//span[@class='1 caret']")
    private WebElement globalOrgDropdownBtn_MapPage;
    @FindBy(xpath = "//p[@class='1 selected']")
    private WebElement globalOrgSelected_MapPage;
    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//input[@type='search']")
    private WebElement globalOrgDropdownSearch_MapPage;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='grid grid-center option selected']")
    private WebElement rank_SortByFirstOptions;
    @FindBy(xpath = "(//div[@class='stats grid'])[1]")
    private WebElement rankTable_MeasureValue;
    @FindBy(xpath = "//p[normalize-space()='VWC %']")
    private WebElement rankChartSoilMoistureUnit;
    @FindBy(xpath = "(//div[@class='stats grid']//div[@class='column']//p)[4]")
    private WebElement rankTableSoilMoistureUnit;
    @FindBy(xpath = "//span[@class='0 caret']")
    private WebElement rankMeasurementDropdown;


    public RankPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyNavigationToWeatherPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(rank_Table, 200, 1);
        siteName.click();
        webDriverHelper.waitUntilVisible(currentCondition_WeatherPage, 200, 2);
        Assert.assertTrue(currentCondition_WeatherPage.isDisplayed(), "current condition table is displayed");
    }

    public void verifyTableOnOrgSwitch(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(rank_Table, 30, 1);
        String activity1 = rankTable_FirstRow.getText();
        Thread.sleep(500);
        globalOrgDropdownBtn_MapPage.click();
        Thread.sleep(200);
        if (!(role.equalsIgnoreCase("member") || role.equalsIgnoreCase("teamAdmin"))) {
            webDriverHelper.waitUntilVisible(orgDropdown_orgList, 30, 1);
            orgDropdown_orgList.click();
            webDriverHelper.waitUntilVisible(rankContainer, 30, 2);
            Thread.sleep(6000);
            String newActivity1 = rankContainer.getText();
            Assert.assertTrue(rank_Table.isDisplayed() || rankContainer.getText().contains(Constants.rankNoSites));
            Assert.assertNotEquals(newActivity1, activity1);
        }
    }
/*    public void verifyStatsOnOrgSwitch(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(rank_Table, 200, 1);
        String currentStats = rankTable_FirstRow.getText();
        globalOrgDropdownBtn_MapPage.click();
        Thread.sleep(200);
        webDriverHelper.waitUntilVisible(orgDropdown_orgList.get(1), 90, 1);
        if (orgDropdown_orgList.size() > 0) {
            System.out.println("orgDropdown_orgList.get(1)" + orgDropdown_orgList.get(1).getText());
            orgDropdown_orgList.get(1).click();
            Thread.sleep(3000);
            if (!((role.equalsIgnoreCase("member")) || role.equalsIgnoreCase("orgReader")
                    || role.equalsIgnoreCase("sysReader"))) {
                webDriverHelper.waitUntilVisible(rankTable_FirstRow, 30, 2);
                String newStats = rankTable_FirstRow.getText();
                Assert.assertNotEquals(newStats, currentStats);
            } else {
                webDriverHelper.waitUntilVisible(rank_NoSites, 30, 2);
                Assert.assertTrue(rank_NoSites.isDisplayed(), "no site is displayed");
            }
        }
    }*/

    public void verifySortColumnByAscDesc(String role) throws InterruptedException {
        if (rank_Table.isDisplayed()) {
            webDriverHelper.waitUntilVisible(rank_Table, 30, 1);
            String firstRow = rankTable_FirstRow.getText();
            rankTable_RankColumn.click();
            rankTable_RankColumn.click();
            String firstRowUpdated = rankTable_FirstRow.getText();
            Assert.assertNotEquals(firstRowUpdated, firstRow);
        } else {
            webDriverHelper.waitUntilVisible(rank_NoSites, 30, 1);
            Assert.assertTrue(rank_NoSites.isDisplayed(), "site name is displayed");
        }
    }

    public void verifySortByHighLow(String role) throws InterruptedException {
//        if (rank_Table.isDisplayed()) {
        webDriverHelper.waitUntilVisible(rank_Table, 30, 1);
        Thread.sleep(3000);
        String measurementValue = rankTable_MeasureValue.getText();
        System.out.println("measurementValue:- " + measurementValue);
        if (rank_LowTabSelected.isDisplayed()) {
            rank_HighTab.click();
            Thread.sleep(5000);
            webDriverHelper.waitUntilVisible(rankTable_MeasureValue, 30, 1);
            String measurementValueNew = rankTable_MeasureValue.getText();
            Assert.assertNotEquals(measurementValueNew, measurementValue);
            rank_LowTab.click();
        } else {
            webDriverHelper.waitUntilVisible(rank_NoSites, 30, 1);
            Assert.assertTrue(rank_NoSites.isDisplayed(), "site name is displayed");
        }
//        }
    }

    public void verifySortByOptions(String role) throws InterruptedException {
        if (rank_Table.isDisplayed()) {
            webDriverHelper.waitUntilVisible(rank_Table, 30, 1);
            dropdown_defaultSelection.click();
            webDriverHelper.waitUntilVisible(rank_SortByFirstOptions, 30, 1);
            int elementsCount = rank_SortByOptionsList.size();
            for (WebElement tempEle : rank_SortByOptionsList) {
                String option = tempEle.getText();
                tempEle.click();
                Thread.sleep(1000);
                webDriverHelper.waitUntilVisible(rank_titleName, 30, 1);
                String titleName = rank_titleName.getText();
                if (titleName.contains("GDD") && option.contains("Growing Degree Days")) {
                    Assert.assertTrue(titleName.contains("GDD"));
                } else {
                    Assert.assertEquals(titleName, option);
                }
                if (titleName.contains("Soil Moisture")) {
                    Assert.assertTrue(rankChartSoilMoistureUnit.isDisplayed());
                    Assert.assertTrue(rankTableSoilMoistureUnit.getText().contains(Constants.soilMoistureUnit));
                }
                rankMeasurementDropdown.click();
                Thread.sleep(1000);
                webDriverHelper.waitUntilVisible(rank_titleName, 30, 1);
            }
        } else {
            webDriverHelper.waitUntilVisible(rank_NoSites, 30, 1);
            Assert.assertTrue(rank_NoSites.isDisplayed(), "site name is displayed");
        }
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(dashboardMenu_Analysis, 30, 1);
//        switchOrgToArableTeam();
        map.navigateToPage(role);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Analysis).moveToElement(dashboardMenu_Rank).click().build().perform();
//        webDriverHelper.waitUntilVisible(dropdown_defaultSelection, 30, 1);
        webDriverHelper.waitUntilVisible(rank_Table, 100, 1);
    }

    public void switchOrgToArableTeam() throws InterruptedException, IOException {
        if (!(globalOrgSelected_MapPage.getText().contains("arable-team"))) {
            globalOrgDropdownBtn_MapPage.click();
            webDriverHelper.waitUntilVisible(globalOrgDropdownSearch_MapPage, 30, 1);
            globalOrgDropdownSearch_MapPage.sendKeys("arable-team");
            globalOrgSearchSuggestion_MapPage.click();
            webDriverHelper.waitUntilVisible(firstSiteIdF, 150, 1);
        } else {
            Assert.assertTrue(globalOrgSelected_MapPage.getText().contains("arable-team"), "org name is not arable team");
        }
    }

//    public void captureRankPageLoadTime(String role) throws IOException, InterruptedException {
//        String loadInSeconds = null;
//        long start = System.currentTimeMillis();
////        StringHelper.devToolCapture(role);
//        webDriverHelper.waitUntilVisible(rank_Table, 30, 1);
//        Assert.assertTrue(rank_Table.isDisplayed(), "site names are not displayed");
//        loadInSeconds = stringHelper.stopTime(start, driver);
//        ExcelReader.setValueForColumn("Rank", loadInSeconds, role);
//        // HTML report generator
//        HTMLReport.addPageName("Rank");
////        HTMLReport.generateReport("Rank", loadInSeconds, role);
//        HTMLReport.writeReportToFile();
//    }
}

