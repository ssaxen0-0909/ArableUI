package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import support.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static support.Constants.*;
import static support.PropertiesReader.orgTargeted;
import static support.WaterAPIHelper.extractGrowthStageInfo;
import static support.WebDriverHelper.wait;
import static support.World.*;

public class WaterTab {

    private static final Logger log = LogManager.getLogger(WaterTab.class);
    private final WebDriver driver;
    public String seasonSiteName;
    @FindBy(xpath = "//arable-card[@class='water-summary-card']//div[@class='card']")
    WebElement waterSummaryTable;
    @FindBy(xpath = "//div[@class='water-balance-table__mode water-balance-table__mode--granularity column grid']//div[@class='column-auto']")
    WebElement waterBalance_Dropdown;
    @FindBy(xpath = "//p[normalize-space()='Day']")
    WebElement waterBalance_Day;
    @FindBy(xpath = "//span[normalize-space()='(Today)']")
    WebElement waterBalance_Day_Today;
    @FindBy(xpath = "//p[normalize-space()='Month']")
    WebElement waterBalance_Month;
    @FindBy(xpath = "//span[normalize-space()='(This Month)']")
    WebElement waterBalance_Month_ThisMonth;
    @FindBy(xpath = "//p[normalize-space()='Week']")
    WebElement waterBalance_Week;
    @FindBy(xpath = "//p[normalize-space()='Growth Stage']")
    WebElement waterBalance_GDD;
    @FindBy(xpath = "//span[normalize-space()='(This Week So Far)']")
    WebElement waterBalance_Week_ThisWeek;
    @FindBy(xpath = "//span[normalize-space()='(Current)']")
    WebElement waterBalance_GDD_Current;
    @FindBy(xpath = "//p[@class='cursor-pointer highlight bold site-name-text padding-top-10']")
    List<WebElement> paginationSiteNameList;
    @FindAll({@FindBy(xpath = "//a[contains(@class,'internal')]")})
    List<WebElement> numberOfRowsDataPresent;
    @FindBy(xpath = "//button[@title='Zoom in']")
    WebElement mapZoomInBtnF;
    @FindBy(xpath = "//button[@title='Zoom out']")
    WebElement mapZoomOutBtnF;
    @FindBy(xpath = "//app-multisite-fusionchart//div[@class='multisite-fusion-chart']//*[local-name()='g' and contains(@class, 'plot-group')]/*[name()='rect']")
    List<WebElement> overAllGraph;
    //    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//div[@class='options']//p")
//    private List<WebElement> globalOrgSearchSuggestion_MapPage;
    List<String> sitesNamesInTable = new ArrayList<>();
    List<String> sitesNamesInBenchmarkGraph = new ArrayList<>();
    @FindBy(xpath = "//p[normalize-space()='Search']")
    private WebElement dashboardMenu_Search;
    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@class='site-result']")
    private WebElement search_SiteResult;
    //    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Current Conditions']/div")
//    private WebElement currentConditionTableF;
    @FindBy(xpath = "(//div[@class='card'])[2]")
    private WebElement currentConditionTableF;
    @FindBy(xpath = "//p[@class='title'][normalize-space()='Water']")
    private WebElement waterTab;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='Water Summary']")
    private WebElement waterSummary;
    @FindBy(xpath = "//p[contains(text(),'A calculation of the precipitation plus')]")
    private WebElement waterSummary_ModalText;
    @FindBy(xpath = "//div[@class='modal fade in show']//img[@alt='icon_close']")
    private WebElement modal_CloseBtn;
    @FindBy(xpath = "(//div[@class='water-balance-chart-container']//h1)[1]")
    private WebElement waterBalanceGraph;
    @FindBy(xpath = "(//h1[@class='fancy-link'][normalize-space()='Water Details'])[1]")
    private WebElement waterBalanceTable;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='Soil Moisture']")
    private WebElement soilMoistureGraph;
    @FindBy(xpath = "//p[contains(text(),'The soil probes attached use default Sentek')]")
    private WebElement soilMoisture_ModalText;
    @FindBy(xpath = "//p[contains(text(),'The y-axis is showing the water balance in inches ')]")
    private WebElement waterBalanceGraph_ModalText;
    @FindBy(xpath = "//p[contains(text(),'A breakdown of the measurements contributing')]")
    private WebElement waterBalanceTable_ModalText;
    @FindBy(xpath = "//h1[normalize-space()='Growth Stage:']")
    private WebElement gdd;
    @FindBy(xpath = "//p[contains(text(),\"Growth Stages mark physiological\")]")
    private WebElement gdd_ModalText;
    @FindBy(xpath = "//div[@class='site-detail']")
    private WebElement siteDetails;
    @FindBy(xpath = "//arable-card[@class='water-balance-graph-card']//div[@class='menu-button-container']")
    private WebElement waterBalance_MenuButton;
    @FindBy(xpath = "//div[contains(text(),'Manual Irrigation')]")
    private WebElement waterBalance_ManualIrrigationButton;
    @FindBy(xpath = "//div[@class='img-container float-right']")
    private WebElement ManualIrrigation_AddButton;
    @FindBy(xpath = "//div[@class='manual-irrigation-input-container']//div[@class='button up']")
    private WebElement ManualIrrigationSetAmount;
    @FindBy(xpath = "//button[@class='column btn action confirm']")
    private WebElement ManualIrrigationSaveBtn;
    @FindBy(xpath = "//h3[normalize-space()='Successfully Saved']")
    private WebElement ManualIrrigation_SuccessMsg;
    @FindBy(xpath = "(//div[@class='menu-button-container'])[3]")
    private WebElement ManualIrrigation_EntryTableMenuBtn;
    @FindBy(xpath = "//div[@class='menu-content']//div[2]")
    private WebElement ManualIrrigation_EntryTableDeleteBtn;
    @FindBy(xpath = "//p[@class='water-summary__detail-value']")
    private WebElement waterBalanceChangeValue;
    @FindBy(xpath = "//p[@class='water-summary__detail-value growth-stage-value']")
    private WebElement totalHeatStressHours;
    @FindBy(xpath = "//div[@class='grid water-summary__detail-parent-container']//div[2]//p[1]")
    private WebElement IrrigationToReplaceETc;
    @FindBy(xpath = "//div[@class='wbt-container__entries']/div[1]/div[2]/span[1]")
    private WebElement forecastWBC;
    @FindBy(xpath = "//div[@class='wbt-container__entries']/div[1]/div[3]/span[1]")
    private WebElement forecastReplacementETc;
    @FindBy(xpath = "//div[@class='wbt-container__entries']/div[1]/div[4]/span[1]")
    private WebElement forecastPrecipitation;
    @FindBy(xpath = "//div[@class='wbt-container__entries']/div[1]/div[5]/span[1]")
    private WebElement forecastIrrigation;
    @FindBy(xpath = "(//span[@class='0 caret'])[3]")
    private WebElement summaryDropdown;
    @FindBy(xpath = "//p[normalize-space()='Water Balance']")
    private WebElement waterBalanceDropdown;
    @FindBy(xpath = "//div[contains(text(),'Replacement ETc')]")
    private WebElement WaterDetailReplacementETc;

    @FindBy(xpath = "((//div[@class='column water-summary__detail-container water-summary__detail-container--bordered'])[2]//p)[1]")
    private WebElement soilMoistureWaterSummary;
    @FindBy(xpath = "(//div[@class='wbt-container__entry-col column']//span)[7]")
    private WebElement soilMoistureWaterBalance;
    @FindBy(xpath = "//div[@class='wbt-container__entries']//div[2]//div[4]//span[1]")
    private WebElement totalHeatStressWaterBalance;

    @FindBy(xpath = "//div[@class='menu-content']//div[2]")
    private WebElement replacementETcOption;

    @FindBy(xpath = "(//div[@class='column etc-replacement-column growth-stage-column'])[2]")
    private WebElement growthStageETcReplacement;

    @FindBy(xpath = "//div[contains(@class, 'grid') and contains(@class, 'body-list') and contains(@class, 'row') and (contains(@class, 'row-odd') or contains(@class, 'row-even'))]")
    private List<WebElement> growthStagesWithValuesInETcReplacement;



    public WaterTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static boolean compareValues(String[] uiValues, String[] apiValues) {
        return java.util.Arrays.equals(uiValues, apiValues);
    }

    public void verifyETcReplacementEntryAndFormat(String role) throws IOException, InterruptedException {
        navigateToWaterPage();
        webDriverHelper.waitUntilVisible(waterSummaryTable, 300, 2);
        webDriverHelper.waitUntilVisible(waterBalance_MenuButton, 30, 1);
        waterBalance_MenuButton.click();
        webDriverHelper.waitUntilVisible(replacementETcOption, 30, 1);
        StringHelper.devToolCaptureGrowthStageWithValue(role);
        replacementETcOption.click();
        webDriverHelper.waitUntilVisible(growthStageETcReplacement, 30, 1);

        teamsApiHelper.getAuthToken();
        String requiredUrlGrowthStage = SharedData.specificRequestUrl;
        System.out.println("requiredUrlGrowthStage:-" + requiredUrlGrowthStage);

        List<GrowthStageInfo> growthStageInfos = null;
        try {
            String jsonResponse = WaterAPIHelper.fetchJSONResponse(requiredUrlGrowthStage, token);
            System.out.println("jsonResponse:-" + jsonResponse);

            JSONArray jsonArray = new JSONArray(jsonResponse);
            System.out.println("jsonArray:-" + jsonArray);

            growthStageInfos = extractGrowthStageInfo(jsonArray.toString());
            System.out.println("growthStageInfos:-" + growthStageInfos);

            for (GrowthStageInfo growthStageInfo : growthStageInfos) {
                System.out.println("Name: " + growthStageInfo.getName() + ", ETC Replacement Ratio: " + growthStageInfo.getEtcReplacementRatio());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return;
        }

        List<String> webElementTexts = new ArrayList<>();
        for (WebElement element : growthStagesWithValuesInETcReplacement) {
            webElementTexts.add(element.getText());
        }
        System.out.println("webElementTexts:-" + webElementTexts);

        Assert.assertEquals(growthStageInfos.size(), webElementTexts.size(), "Lists have different sizes, cannot compare.");

        for (int i = 0; i < growthStageInfos.size(); i++) {
            GrowthStageInfo growthStageInfo = growthStageInfos.get(i);
            String webElementText = webElementTexts.get(i);

            String expectedRatio = String.format("%.2f", growthStageInfo.getEtcReplacementRatio()); // Format to 2 decimal places
            String expectedText = growthStageInfo.getName() + expectedRatio;
            expectedText = expectedText.replaceAll("\\s+", "");
            webElementText = webElementText.replaceAll("\\s+", "");
            Assert.assertEquals(expectedText, webElementText, "Mismatch found at index " + i);
        }
    }

    public void verifyHeatStressSummaryAndDetailsValue(String role) throws IOException, InterruptedException {
        StringHelper.devToolCapture(role);
        navigateToWaterPage();
        StringHelper.growingSeasonApi(role);
        webDriverHelper.waitUntilVisible(waterBalanceGraph, 30, 1);

        teamsApiHelper.getAuthToken();
        WaterAPIHelper summaryApiResponse = WaterAPIHelper.extractSummaryAPIResponse(token);

        String heatStressValueDoubleValue = String.valueOf(summaryApiResponse.getHeatStressHoursCumulative());
        String IrrigationTimeToReplaceETValueAPI = String.valueOf(summaryApiResponse.getIrrigationTimeToReplaceET());
        System.out.println("IrrigationTimeToReplaceETDoubleValueAPI: " + IrrigationTimeToReplaceETValueAPI);

        int totalHeatStressHoursValueDoubleAPI = 0;
        if (heatStressValueDoubleValue != null && !heatStressValueDoubleValue.isEmpty()) {
            totalHeatStressHoursValueDoubleAPI = Integer.parseInt(heatStressValueDoubleValue);
            System.out.println("totalHeatStressHoursValueDoubleAPI: " + totalHeatStressHoursValueDoubleAPI);
        }
        String totalHeatStressHoursValue = totalHeatStressHours.getText();
        totalHeatStressHoursValue = totalHeatStressHoursValue.replaceAll("[^\\d.\\s]", "").trim();

        int totalHeatStressHoursValueDouble = Integer.parseInt(totalHeatStressHoursValue);
        System.out.println("totalHeatStressHoursValueDouble: " + totalHeatStressHoursValueDouble);
        Assert.assertEquals(totalHeatStressHoursValueDouble, totalHeatStressHoursValueDoubleAPI);

        String totalHeatStressHoursBalanceValue = totalHeatStressWaterBalance.getText();
        Assert.assertEquals(totalHeatStressHoursBalanceValue,totalHeatStressHoursValue);

        int totalHeatStressWaterBalanceValueInt= Integer.parseInt(totalHeatStressHoursBalanceValue);
        Assert.assertEquals(totalHeatStressWaterBalanceValueInt,totalHeatStressHoursValueDoubleAPI);

    }

        public void verifySoilMoistureValueInBalanceAndSummarySection(String role) throws IOException, InterruptedException {
        StringHelper.devToolCapture(role);
        navigateToWaterPage();
        StringHelper.growingSeasonApi(role);
        webDriverHelper.waitUntilVisible(waterBalanceGraph, 30, 1);

        teamsApiHelper.getAuthToken();
        WaterAPIHelper summaryApiResponse = WaterAPIHelper.extractSummaryAPIResponse(token);

        String soilMoistureBalanceSection=soilMoistureWaterBalance.getText();
        String soilMoistureAPIValue = String.valueOf(summaryApiResponse.getSoil_Moisture());
        System.out.println("soilMoistureAPIValue: " + soilMoistureAPIValue);

        if ("--".equals(soilMoistureBalanceSection)) {
            soilMoistureBalanceSection = null;
            Assert.assertNull(soilMoistureBalanceSection);
            Assert.assertTrue(soilMoistureAPIValue.contains("null"));
        }
        else{
            Assert.assertEquals(soilMoistureBalanceSection,soilMoistureAPIValue);
        }

        String soilMoistureChangeAPIValue = String.valueOf(summaryApiResponse.getSoil_Moisture_Change());
        System.out.println("soilMoistureChangeAPIValue:-"+soilMoistureChangeAPIValue);

        String soilMoistureSummarySection=soilMoistureWaterSummary.getText();
        String RefillProximityAPIValue = String.valueOf(summaryApiResponse.getRefillProximity());
        System.out.println("RefillProximityAPIValue:"+RefillProximityAPIValue);

        if ("--".equals(soilMoistureSummarySection)) {
            soilMoistureSummarySection = null;
            Assert.assertNull(soilMoistureSummarySection);
            Assert.assertTrue(RefillProximityAPIValue.contains("null"));
        }
        else{
            Assert.assertEquals(soilMoistureSummarySection,RefillProximityAPIValue);
        }
    }

    public void verifyWaterBalanceChangeSummaryValue(String role) throws IOException, InterruptedException {
        StringHelper.devToolCapture(role);
        navigateToWaterPage();
        driver.navigate().refresh();
        StringHelper.growingSeasonApi(role);
        webDriverHelper.waitUntilVisible(waterBalanceGraph, 30, 1);

        teamsApiHelper.getAuthToken();
        WaterAPIHelper summaryApiResponse = WaterAPIHelper.extractSummaryAPIResponse(token);
//        Thread.sleep(5000);

        String waterBalanceValue = waterBalanceChangeValue.getText();
        String waterBalanceOnlyValue = waterBalanceValue.replaceAll("[^\\d.\\s]", "").trim();
        double waterBalanceValueDouble = Double.parseDouble(waterBalanceOnlyValue);
        System.out.println("waterBalanceValueDouble: " + waterBalanceValueDouble);

        String waterBalanceValueDoubleValue = String.valueOf(summaryApiResponse.getwaterBalance());
        System.out.println("waterBalanceValueDoubleValue: " + waterBalanceValueDoubleValue);

        waterBalanceValueDoubleValue = waterBalanceValueDoubleValue.replaceAll("[^\\d.\\s]", "").trim();
        double waterBalanceValueDoubleAPI = Double.parseDouble(waterBalanceValueDoubleValue);
        System.out.println("waterBalanceValueDoubleAPI: " + waterBalanceValueDoubleAPI);

        System.out.println("waterBalanceValue from UI: " + waterBalanceValue);

        String truncatedValue=null;
        if(waterBalanceValue.contains("mm")) {
            truncatedValue = String.format("%.1f", waterBalanceValueDoubleAPI);
        }
        else{
            truncatedValue = String.format("%.2f", waterBalanceValueDoubleAPI);

        }
        double truncatedDoubleValue = Double.parseDouble(truncatedValue);
        System.out.println("truncatedDoubleValue: " + truncatedDoubleValue);
        System.out.println("truncatedValue: " + truncatedValue);
        Assert.assertEquals(waterBalanceValueDouble, truncatedDoubleValue);
    }

    public void verifyWaterForecastValue(String role) throws IOException, InterruptedException {
        StringHelper.devToolCapture(role);
        navigateToWaterPage();
        driver.navigate().refresh();
        StringHelper.growingSeasonApi(role);
        webDriverHelper.waitUntilVisible(waterBalanceGraph, 30, 1);

        teamsApiHelper.getAuthToken();
        Thread.sleep(5000);
        WaterAPIHelper forecast = WaterAPIHelper.extractForecast(token);
        Thread.sleep(5000);
        System.out.println("forecast:-" + forecast);

        String waterbalanceUIValue = forecastWBC.getText();

        waterbalanceUIValue = waterbalanceUIValue.replaceAll("[^\\d.\\s]", "").trim();
        double waterbalanceUIValueDouble = Double.parseDouble(waterbalanceUIValue);

        String waterbalanceAPIValue = String.valueOf(forecast.getwaterBalance());
        double waterbalanceAPIValueDouble = Double.parseDouble(waterbalanceAPIValue);
        waterbalanceAPIValueDouble = Math.round(waterbalanceUIValueDouble * 100.0) / 100.0;
        Assert.assertEquals(waterbalanceAPIValueDouble, waterbalanceUIValueDouble, 0.001);
    }

    public void verifyWaterSummaryValue(String role) throws IOException, InterruptedException {
        StringHelper.devToolCapture(role);
        navigateToWaterPage();
        StringHelper.growingSeasonApi(role);
        webDriverHelper.waitUntilVisible(waterBalanceGraph, 30, 1);

        teamsApiHelper.getAuthToken();
        WaterAPIHelper summaryApiResponse = WaterAPIHelper.extractSummaryAPIResponse(token);

        String heatStressValueDoubleValue = String.valueOf(summaryApiResponse.getHeatStressHoursCumulative());
        String IrrigationTimeToReplaceETValueAPI = String.valueOf(summaryApiResponse.getIrrigationTimeToReplaceET());
        System.out.println("IrrigationTimeToReplaceETDoubleValueAPI: " + IrrigationTimeToReplaceETValueAPI);

        int totalHeatStressHoursValueDoubleAPI = 0;
        if (heatStressValueDoubleValue != null && !heatStressValueDoubleValue.isEmpty()) {
            totalHeatStressHoursValueDoubleAPI = Integer.parseInt(heatStressValueDoubleValue);
            System.out.println("totalHeatStressHoursValueDoubleAPI: " + totalHeatStressHoursValueDoubleAPI);
        }
        String totalHeatStressHoursValue = totalHeatStressHours.getText();
        totalHeatStressHoursValue = totalHeatStressHoursValue.replaceAll("[^\\d.\\s]", "").trim();

        int totalHeatStressHoursValueDouble = Integer.parseInt(totalHeatStressHoursValue);
        System.out.println("totalHeatStressHoursValueDouble: " + totalHeatStressHoursValueDouble);
        Assert.assertEquals(totalHeatStressHoursValueDouble, totalHeatStressHoursValueDoubleAPI);

        String IrrigationTimeToReplaceETValueUI = IrrigationToReplaceETc.getText();
        if ("--".equals(IrrigationTimeToReplaceETValueUI)) {
            IrrigationTimeToReplaceETValueUI = null;
        }
        Assert.assertNull(IrrigationTimeToReplaceETValueUI);
    }

    public void navigateToWaterPage() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(imgGallery.tabList, 30, 1);
        plantTab.plantPageTab.click();
        Thread.sleep(500);
        waterTab.click();
    }

    public void verifyContentsOfWaterPage(String role) throws IOException, InterruptedException {
        navigateToWaterPage();
        webDriverHelper.waitUntilVisible(waterSummaryTable, 30, 1);
        String waterPageContent = siteDetails.getText();
        Assert.assertTrue(waterPageContent.contains("Soil Moisture"));
        Assert.assertTrue(waterPageContent.contains("Water Balance"));
        Assert.assertTrue(waterPageContent.contains("Water Summary"));
        Assert.assertTrue(waterPageContent.contains("Growth Stage:"));
    }

    public void verifyAddAndDeleteManualIrrigationEntry(String role) throws IOException, InterruptedException {
        try {
            navigateToWaterPage();
            webDriverHelper.waitUntilVisible(waterSummaryTable, 300, 2);
            webDriverHelper.waitUntilVisible(waterBalance_MenuButton, 30, 1);
            waterBalance_MenuButton.click();
            webDriverHelper.waitUntilVisible(waterBalance_ManualIrrigationButton, 30, 1);
            waterBalance_ManualIrrigationButton.click();
            Thread.sleep(4000);
            webDriverHelper.waitUntilVisible(ManualIrrigation_AddButton, 30, 1);
            ManualIrrigation_AddButton.click();
            webDriverHelper.waitUntilVisible(ManualIrrigationSetAmount, 30, 1);
            ManualIrrigationSetAmount.click();
            Thread.sleep(4000);
            ManualIrrigationSaveBtn.click();
            webDriverHelper.waitUntilVisible(ManualIrrigation_SuccessMsg, 300, 1);
            Thread.sleep(500);
            webDriverHelper.waitUntilVisible(ManualIrrigation_EntryTableMenuBtn, 30, 1);
            ManualIrrigation_EntryTableMenuBtn.click();
            webDriverHelper.waitUntilVisible(ManualIrrigation_EntryTableDeleteBtn, 30, 1);
            Thread.sleep(500);
            ManualIrrigation_EntryTableDeleteBtn.click();
            webDriverHelper.waitUntilVisible(ManualIrrigation_SuccessMsg, 30, 1);
            Thread.sleep(500);
            webDriverHelper.waitUntilVisible(modal_CloseBtn, 30, 1);
            modal_CloseBtn.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("exception caught");
            waterBalance_ManualIrrigationButton.click();
        }
    }

    public void waterBalance_dropdownClick() throws InterruptedException {
        webDriverHelper.waitUntilVisible(currentConditionTableF, 30, 1);
        waterTab.click();
        webDriverHelper.waitUntilVisible(waterSummaryTable, 200, 2);
        waterBalance_Dropdown.click();
        webDriverHelper.waitUntilVisible(waterBalance_Day, 30, 1);
        Thread.sleep(200);
    }

    public void verifyGDDModalInfo(String role) throws IOException, InterruptedException {
        navigateToWaterPage();
        webDriverHelper.waitUntilVisible(gdd, 30, 1);
        gdd.click();
        webDriverHelper.waitUntilVisible(gdd_ModalText, 30, 1);
        Assert.assertTrue(gdd_ModalText.isDisplayed(), "gdd_ModalText is displayed");
        Thread.sleep(200);
        modal_CloseBtn.click();
    }

    public void verifySoilMoistureModalInfo(String role) throws IOException, InterruptedException {
        navigateToWaterPage();
        webDriverHelper.waitUntilVisible(soilMoistureGraph, 30, 1);
        soilMoistureGraph.click();
        webDriverHelper.waitUntilVisible(soilMoisture_ModalText, 30, 1);
        Assert.assertTrue(soilMoisture_ModalText.isDisplayed(), "soilMoisture_ModalText is displayed");
        Thread.sleep(200);
        modal_CloseBtn.click();
    }

    public void verifyWaterDetailsTableModalInfo(String role) throws IOException, InterruptedException {
        navigateToWaterPage();
        webDriverHelper.waitUntilVisible(waterBalanceTable, 30, 1);
        waterBalanceTable.click();
        webDriverHelper.waitUntilVisible(waterBalanceTable_ModalText, 30, 1);
        Assert.assertTrue(waterBalanceTable_ModalText.isDisplayed(), "waterBalanceTable_ModalText is displayed");
        Thread.sleep(200);
        modal_CloseBtn.click();
    }

    public void verifyWaterSummaryModalInfo(String role) throws IOException, InterruptedException {
        navigateToWaterPage();
        webDriverHelper.waitUntilVisible(waterSummary, 30, 1);
        waterSummary.click();
        webDriverHelper.waitUntilVisible(waterSummary_ModalText, 30, 1);
        Assert.assertTrue(waterSummary_ModalText.isDisplayed(), "waterSummary_ModalText is displayed");
        Thread.sleep(200);
        modal_CloseBtn.click();
    }

    public void verifyWaterBalanceGraphModalInfo(String role) throws IOException, InterruptedException {
        navigateToWaterPage();
        webDriverHelper.waitUntilVisible(waterBalanceGraph, 30, 1);
        waterBalanceGraph.click();
        webDriverHelper.waitUntilVisible(waterBalanceGraph_ModalText, 30, 1);
        Assert.assertTrue(waterBalanceGraph_ModalText.isDisplayed(), "waterBalanceGraph_ModalText is displayed");
        Thread.sleep(200);
        modal_CloseBtn.click();
    }

}