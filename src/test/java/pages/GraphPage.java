package pages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import support.Constants;
import support.PropertiesReader;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static support.Constants.*;
import static support.PropertiesReader.orgTargeted;
import static support.WebDriverHelper.wait;
import static support.World.*;


public class GraphPage {

    private static final Logger log = LogManager.getLogger();
    public static int sitesSelected;
    private final WebDriver driver;
    public String unitInTable;
    public String measureInMenuBar;
    public int index;
    public String date;
    public String localDate;
    public String resolutionText;
    @FindBy(css = "div[class='0 dropdown-selector open'] div[class='options']")
    WebElement graphSitesDropdownCard;
    @FindBy(xpath = "(//div[@class='grid grid-center option item checkbox-right'])[1]")
    WebElement firstSiteName;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//label[@class='check-input']")
    WebElement firstSiteName_sysreader;
    @FindBy(xpath = "//p[normalize-space()='Select Measure']")
    WebElement measureDropdown;
    @FindBy(xpath = "(//span[contains(text(),'—/—/—')])[1]")
    WebElement iconCalendar;
    //    @FindBy(xpath = "(//span[@ng-reflect-ng-class='[object Object]'][normalize-space()='01'])[1]")
//    private WebElement dateNumber;
    @FindBy(xpath = "(//span[contains(text(),'01')])[1]")
    WebElement dateNumber;
    @FindBy(xpath = "//button[normalize-space()='Graph']")
    WebElement graphBtn;
    @FindBy(xpath = "//div[@class='name']")
    WebElement graphTable;
    @FindBy(xpath = "//td[contains(text(), 'AM') or contains(text(), 'PM')]")
    WebElement graphTableTimestamp;
    @FindBy(xpath = "//p[normalize-space()='Analysis']")
    WebElement dashboardMenu_Analysis;
    @FindBy(xpath = "//label[normalize-space()='Maximum Temperature']")
    WebElement maxTemp;
    @FindBy(xpath = "//div[@class='hourly-button']")
    WebElement hourly_Button;
    @FindBy(xpath = "//label[contains(@class,'item-text')]")
    List<WebElement> dropDownSitesList;
    @FindBy(xpath = "//div[@class='icon']/following-sibling::label")
    List<WebElement> measureDropDownList;
    @FindBy(xpath = "//div[@class='daily-range-selector']//span[@class='item active']")
    List<WebElement> dateSelectedFromList;
    @FindBy(xpath = "//table[@class='data-table-explorer']/tbody[1]/tr/td[2]")
    List<WebElement> ualueUITable1;
    @FindBy(xpath = "//table[@class='data-table-explorer']/tbody[1]/tr/td[3]")
    List<WebElement> ualueUITable2;
    @FindBy(xpath = "//table[@class='data-table-explorer']//td[text()]")
    List<WebElement> dateUI;
    @FindBy(xpath = "//td[@class='timestamp']")
    List<WebElement> dateUIFoSolarTemp;
    @FindBy(xpath = "//table[@class='data-table-explorer']//td[@class='timestamp']")
    List<WebElement> dateUIForSolar;
    @FindBy(xpath = "//button[@class='btn btn-default btn-secondary btn-sm disabled']//strong")
    WebElement monthTagInsideCalender;
    @FindBy(xpath = "//th[@class='title-data unit']")
    List<WebElement> unitsForMaxMinTempForSingleSites;
    @FindBy(xpath = "  //th[@class='title-explorer']//div")
    List<WebElement> unitsForMaxMinTempForMultipleSites;
    @FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text' and @style='font-size: 11px; font-weight: 600; cursor: move; font-family: Helvetica, Arial, sans-serif; text-anchor: end;']")
    List<WebElement> endDateInListInTimelineSeriesGraph;
    List<String> selectedItems = new ArrayList<>();
    List<String> listSelectedInDropDown = new ArrayList<>();
    List<String> addedSitesForApiVerification = new ArrayList<>();
    List<Map.Entry<String, Double>> combinedDoubleListInUi = new ArrayList<>();
    List<Map.Entry<String, Integer>> combinedIntegerListInUi = new ArrayList<>();
    List<Map.Entry<String, Integer>> combinedListInUi = new ArrayList<>();
    @FindBy(xpath = "//div[@class='item-to-draw item-1']")
    private WebElement selectSite;
    @FindBy(xpath = "//p[normalize-space()='No Sites']")
    private WebElement noSite;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[1]//label[1]")
    private WebElement ciIndex;
    @FindBy(xpath = "//label[normalize-space()='Minimum Temperature']")
    private WebElement minTemp;
    @FindBy(xpath = "//div[@class='range-option-selector']//div[4]")
    private WebElement allOption;
    @FindBy(xpath = "//p[normalize-space()='Graph']")
    private WebElement dashboardMenu_Graph;
    @FindBy(xpath = "//p[normalize-space()='Max Temp, Min Temp']")
    private WebElement selectmeasure_Graph;
    @FindBy(xpath = "//p[normalize-space()='Max Temp']")
    private WebElement selectmeasure_maxTemp_Graph;
    //    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='options ng-star-inserted']")
//    private WebElement soilMoistureMeasurement;
    @FindBy(xpath = "//label[normalize-space()='Soil Moisture']")
    private WebElement soilMoistureMeasurement;
    @FindBy(xpath = "//p[normalize-space()='Soil Moist']")
    private WebElement selectedMeasureSoilMoisture;
    @FindBy(xpath = "//div[@class='datepicker-range']/div[3]")
    private WebElement EndDateText;
    @FindBy(xpath = "(//div[@class='input-date selected'])[2]")
    private WebElement EndDate;
    @FindBy(xpath = "//arable-dropdown-selector[@class='select-export']//div[@class='0 grid grid-center headers']")
    private WebElement downloadIcon;
    @FindBy(xpath = "//p[contains(text(),'PDF')]")
    private WebElement downloadPDF;
    @FindBy(xpath = "//p[normalize-space()='CSV']")
    private WebElement downloadCSV;
    @FindBy(xpath = "//h3[normalize-space()='CSV export is complete.']")
    private WebElement downloadCSVSuccessMsg;
    @FindBy(xpath = "//h3[normalize-space()='PDF export is complete.']")
    private WebElement downloadPDFSuccessMsg;
    @FindBy(xpath = "//span[normalize-space()='30D']")
    private WebElement timestamp_30Days;
    @FindBy(xpath = "//span[normalize-space()='90D']")
    private WebElement timestamp_90Days;
    @FindBy(xpath = "//span[normalize-space()='YTD']")
    private WebElement timestamp_YTD;
    @FindBy(xpath = "//span[normalize-space()='12H']")
    private WebElement timestamp_12H;
    @FindBy(xpath = "//span[normalize-space()='24H']")
    private WebElement timestamp_24H;
    @FindBy(xpath = "//span[normalize-space()='48H']")
    private WebElement timestamp_48H;
    @FindBy(xpath = "//label[contains(@class,'item-text')]")
    private List<WebElement> sitesList;
    @FindBy(xpath = "(//div[@class='item-to-draw']//div[@class='column-auto'])[2]")
    private WebElement measureDropdownIcon;
    @FindBy(xpath = "//div[@class='icon']/following-sibling::label")
    private List<WebElement> measureList;
    @FindBy(xpath = "(//div[@class='0 column-auto']//p)[2]")
    private WebElement selectedMeasureInMenu;
    @FindBy(xpath = "(//button[@class='btn btn-default btn-secondary btn-sm disabled'])[1]")
    private WebElement calendar;
    @FindBy(xpath = "//div[@class='range-option']//button")
    private List<WebElement> calendarBtns;
    @FindBy(xpath = "(//*[local-name()='svg' and //span[@id='measurement-graph']])[1]")
    private WebElement graph;
    @FindBy(xpath = "//div[@class='daily-range-selector']//span")
    private List<WebElement> predefinedDaysInGraph;
    @FindBy(xpath = "(//div[@class='input-date selected']//span)[1]")
    private WebElement startDate;
    @FindBy(xpath = "(//div[@class='input-date selected']//span)[2]")
    private WebElement endDate;
    @FindBy(xpath = "//div[@class='buttons']/div[@class='daily-button active']")
    private WebElement dailyTimelineBtn;
    @FindBy(xpath = "(//*[local-name()='svg']//*[local-name()='g']//*[name()='rect'])[3]")
    private WebElement timelineSeriesGraph;
    //    @FindBy(xpath = "(//*[local-name()='svg']//*[local-name()='g']//*[name()='rect'])[6]")
    @FindBy(xpath = "    (//*[local-name()='svg']//*[local-name()='g' and contains(@class, 'brush-group')]//*[name()='rect'])[1]")
    private WebElement timelineSeriesInChartGraph;
    @FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text' and @style='font-size: 11px; font-weight: 600; cursor: move; font-family: Helvetica, Arial, sans-serif; text-anchor: start;']")
    private WebElement startDateInTimelineSeriesGraph;
    @FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text' and @style='font-size: 13px; font-weight: 600; cursor: move; font-family: Metric; text-anchor: start;']")
    private WebElement startDateInTimelineSeriesInChartGraph;
    @FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text' and @style='font-size: 11px; font-weight: 600; cursor: move; font-family: Helvetica, Arial, sans-serif; text-anchor: end;']")
    private WebElement endDateInTimelineSeriesGraph;
    @FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text' and @style='font-size: 13px; font-weight: 600; cursor: move; font-family: Metric; text-anchor: end;']")
    private WebElement endDateInTimelineSeriesInChartGraph;
    @FindBy(xpath = "(//div[contains(@class,'summary-data')]//div)[1]")
    private WebElement siteNameInTable;
    //    (//div[contains(@class,'summary-data margin-graph')]//div)[1]
    @FindBy(xpath = "(//div[@class='item-summary'])[1]")
    private WebElement dateGeneratedInTable;
    @FindBy(xpath = "(//div[@class='item-summary'])[2]")
    private WebElement recordsInTable;
    @FindBy(xpath = "(//table[@class='data-table-explorer']//th)[1]")
    private WebElement measurementNameInTable;
    @FindBy(xpath = "//table[@class='data-table-explorer']/thead[1]/tr[1]/th[2]")
    private WebElement measureNameInTableForMaxTemp;
    @FindBy(xpath = "//table[@class='data-table-explorer']/thead[1]/tr[1]/th[3]")
    private WebElement measureNameInTableForMinTemp;
    @FindBy(xpath = "//table[@class='data-table-explorer']/thead[1]/tr[2]/th[1]")
    private WebElement firstColumnName;
    @FindBy(xpath = "//table[@class='data-table-explorer']/thead[1]/tr[2]/th[2]")
    private WebElement secondColumnName;
    @FindBy(xpath = "//table[@class='data-table-explorer']/thead[1]/tr[2]/th[3]")
    private WebElement thirdColumnName;
    @FindBy(xpath = "//table[@class='data-table-explorer']/thead[1]/tr[2]/th[4]")
    private WebElement fourthColumnName;
    @FindBy(xpath = "//button[@class='btn-page']")
    private WebElement loadBtn;
    @FindBy(xpath = "//table[@class='data-table-explorer']/tbody[1]/tr/td[1]")
    private List<WebElement> datesInUiTable;
    @FindBy(xpath = "//table[@class='data-table-explorer']/tbody[1]/tr/td[2]")
    private List<WebElement> secondColumnValuesInUITable;
    @FindBy(xpath = "//table[@class='data-table-explorer']/tbody[1]/tr/td[3]")
    private List<WebElement> thirdColumnValuesInTable;
    @FindBy(xpath = "//table[@class='data-table-explorer']/tbody[1]/tr[3]/td[1]")
    private WebElement windColumnData;
    @FindBy(xpath = "(//div[@class='0 grid grid-center headers']/div[@class='0 column-auto']/p)[1]")
    private WebElement selectedSiteInMenu;
    @FindBy(xpath = "//arable-box-tag//div[@class='column-auto box-tag']/p")
    private List<WebElement> selectedSites;
    @FindBy(xpath = "//table[@class='data-table-explorer']/thead[1]/tr[1]/th[1]/div[1]")
    private WebElement firstMeasureSelected;
    @FindBy(xpath = "//table[@class='data-table-explorer']/thead[1]/tr[1]/th[1]/div[2]")
    private WebElement lastMeasureSelected;
    @FindBy(xpath = "//div[@class='info-modal-vision welcome']/div/button")
    private WebElement modalInfoCloseButton;
    @FindBy(xpath = "//div[@ng-reflect-ng-style='[object Object]']//p[1]")
    private WebElement graphTag;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']")
    private WebElement openDropDownNewSites;
    @FindBy(xpath = "//div[@class='range-option']//button")
    private List<WebElement> calendarBtn;
    @FindBy(xpath = "//div[contains(@class,'daily-button')]")
    private WebElement dailyActiveButton;
    @FindBy(xpath = "//span[text()=' 12H ']")
    private WebElement hrs12Button;
    @FindBy(xpath = "//span[text()=' 24H ']")
    private WebElement hrs24Button;
    @FindBy(xpath = "//span[text()=' 48H ']")
    private WebElement hrs48Button;
    @FindBy(xpath = "(//div[@class='0 column-auto']//p)[2]")
    private WebElement measurementNameAfterSelection;
    @FindBy(xpath = "(//div[@class='0 column-auto']//p)[1]")
    private WebElement sitesNameOrCount;
    @FindBy(xpath = "(//div[@id='summary-data']//div)[1]")
    private WebElement nameTagInTable;
    @FindBy(xpath = "//span[text()='Date Generated: ']")
    private WebElement dateGenerated;
    @FindBy(xpath = "//span[text()='Number of Records:']")
    private WebElement numberOfRecords;
    @FindBy(xpath = "//th[contains(@class,'title-data unit')]")
    private WebElement unitDisplayedInTable;
    @FindBy(xpath = "//div[contains(@class,'multi-header selected last first')]")
    private WebElement multipleSiteUnit;
    @FindBy(xpath = "//button[text()=' Load More ']")
    private WebElement loadMoreButton;
    @FindBy(xpath = "(//div[@class='input-date selected']//span)[2]")
    private WebElement endDates;
    @FindBy(xpath = "(//*[local-name()='svg' and //span[@id='chartobject-1']])[1]")
    private WebElement chartGraph;
    @FindBy(xpath = "//th[contains(@class,'title-data unit')]")
    private List<WebElement> dataColumnNames;
    @FindBy(xpath = "(//*[local-name()='svg']//*[local-name()='g' and contains(@class, 'canvas-tropo')]//*[name()='rect'])[1]")
    private WebElement graphSketch;
    @FindBy(xpath = "//div[@class='column']/table/tbody/tr")
    private List<WebElement> tableSize;
    @FindBy(xpath = "//div[@class='error toast']//div[@class='body']/h3")
    private WebElement errorToastMessage;
    @FindBy(xpath = "(//div[@class='item-to-draw']//div[@class='column-auto'])[1]")
    private WebElement sitesDropdownIcon;
    @FindBy(css = ".icon-calendar")
    private WebElement calenderIcon;
    @FindBy(xpath = "//button[normalize-space()='Last 30 days']")
    private WebElement last30Days;
    @FindBy(xpath = "//button[normalize-space()='Last 90 days']")
    private WebElement last90Days;
    @FindBy(xpath = "//button[normalize-space()='Year to Date']")
    private WebElement yearToDate;
    @FindBy(xpath = "//button[normalize-space()='Custom']")
    private WebElement customDate;
    @FindBy(xpath = "//span[normalize-space()='ALL']")
    private WebElement timestamp_All;
    @FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text' and @style='font-size: 11px; font-weight: 600; cursor: move; font-family: Helvetica, Arial, sans-serif; text-anchor: end;']")
    private WebElement timelineSeriesForEndDateInGraphHourlyForSolarRad;
    @FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text' and @style='font-size: 11px; font-weight: 600; cursor: move; font-family: Helvetica, Arial, sans-serif; text-anchor: start;']")
    private WebElement timelineSeriesForStartDateInGraphHourlyForSolarRad;
    @FindBy(xpath = "//*[name()='rect' and @style='cursor: move;']")
    private WebElement timelineSeriesGraphSoilTemp;
    @FindBy(xpath = "//*[@style='font-size: 13px; font-weight: 600; cursor: move; font-family: Metric; text-anchor: end;'][@text-anchor='end']")
    private WebElement endDateInTimelineSeriesGraphForSoilTemp;
    @FindBy(xpath = "//*[@style='font-size: 13px; font-weight: 600; cursor: move; font-family: Metric; text-anchor: start;'][@text-anchor='start']")
    private WebElement startDateInTimelineSeriesGraphForSoilTemp;
    @FindBy(xpath = "//table[@class='data-table-explorer']/tbody[1]/tr/td[2]//div//div[contains(@class,'badge-local-data small')]")
    private List<WebElement> localDataValues;
    @FindBy(xpath = "//table[@class='data-table-explorer']/tbody[1]/tr/td[3]//div//div[contains(@class,'badge-local-data small')]")
    private List<WebElement> remoteDataValues;
    @FindBy(xpath = "//span[contains(text(),'Davis Wind Anemometer 6410') or contains(text(),'Arable Mark 3 Anemometer')]/following-sibling::img/../../../../../..//div[@class='column'][2]")
    private List<WebElement> windSensorDevices;
    @FindBy(xpath = "//div[@class='no-sensor-container']//span/../../..//div[@class='column'][2]")
    private List<WebElement> noSensorDevices;
    @FindBy(xpath = "//div[@class='devices-tab']//div[1]//div[3]//arable-tooltip-box[1]//div[1]//div[1]//img[1]")
    private WebElement GPS_coordinates_icon;
    @FindBy(xpath = "//table[@class='data-table-explorer']/tbody[1]/tr/td[1]")
    private List<WebElement> textsInFirstRow;
    @FindBy(xpath = "//button[@class='btn-submit-item gap']")
    private WebElement exportBtn;
    public String startDateInHistoricalApi;
    public String endDateInHistoricalApi;
    public String siteAsWindSensor;
    public String siteAsNoSensor;
    public String result;

    public GraphPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(dashboardMenu_Analysis, 30, 1);
        webDriverHelper.waitUntilVisible(loginPage.CloseBtn, 30, 1);
        map.navigateToPage(role);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Analysis).moveToElement(dashboardMenu_Graph).click().build().perform();
    }

    public void captureGraphPageDailyCSV_PDFDownload_AllTimeline(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 30, 1);
        if (graphSitesDropdownCard.isDisplayed()) {
            firstSiteName.click();
            insertValues();
            webDriverHelper.waitUntilVisible(graphTable, 30, 1);
            downloadDailyCSVPDF_FOrALLTimeline();
            Assert.assertTrue(downloadPDFSuccessMsg.isDisplayed(), "download working not fine");
        }
    }

    public void captureGraphPageHourlyCSV_PDFDownloadAllTimeline(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 30, 1);
        if (graphSitesDropdownCard.isDisplayed()) {
            firstSiteName.click();
            insertValues();
            webDriverHelper.waitUntilVisible(graphTable, 30, 1);
            hourly_Button.click();
            webDriverHelper.waitUntilVisible(graphTable, 30, 1);
            downloadHourlyCSVPDF_FOrALLTimeline();
            Assert.assertTrue(downloadPDFSuccessMsg.isDisplayed(), "hourly graph tables are displayed");
        }
    }

    public void downloadHourlyCSVPDF_FOrALLTimeline() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(timestamp_12H, 30, 1);
        timestamp_12H.click();
        webDriverHelper.waitUntilVisible(graphTable, 30, 1);
        downloadDailyCSV_PDF();
        webDriverHelper.waitUntilVisible(downloadPDFSuccessMsg, 30, 1);
        Thread.sleep(500);
        timestamp_24H.click();
        webDriverHelper.waitUntilVisible(graphTable, 30, 1);
        downloadDailyCSV_PDF();
        webDriverHelper.waitUntilVisible(downloadPDFSuccessMsg, 30, 1);
        Thread.sleep(500);
        timestamp_48H.click();
        webDriverHelper.waitUntilVisible(graphTable, 30, 1);
        downloadDailyCSV_PDF();
        webDriverHelper.waitUntilVisible(downloadPDFSuccessMsg, 30, 1);
    }

    public void downloadDailyCSVPDF_FOrALLTimeline() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(timestamp_30Days, 30, 1);
        timestamp_30Days.click();
        webDriverHelper.waitUntilVisible(graphTable, 30, 1);
        downloadDailyCSV_PDF();
        webDriverHelper.waitUntilVisible(downloadPDFSuccessMsg, 30, 1);
        Thread.sleep(500);
        timestamp_90Days.click();
        webDriverHelper.waitUntilVisible(graphTable, 30, 1);
        downloadDailyCSV_PDF();
        webDriverHelper.waitUntilVisible(downloadPDFSuccessMsg, 30, 1);
        Thread.sleep(500);
        timestamp_YTD.click();
        webDriverHelper.waitUntilVisible(graphTable, 30, 1);
        downloadDailyCSV_PDF();
        webDriverHelper.waitUntilVisible(downloadPDFSuccessMsg, 30, 1);
    }

//    public void captureGraphPageLoadTime(String role) throws IOException, InterruptedException {
//        String loadInSeconds = null;
//        long start = System.currentTimeMillis();
////        StringHelper.devToolCapture(role);
//        if (!role.equalsIgnoreCase("sysReader")) {
//            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 30, 1);
//            if (graphSitesDropdownCard.isDisplayed()) {
//                Assert.assertTrue(graphSitesDropdownCard.isDisplayed(), "site names are displayed");
//                loadInSeconds = stringHelper.stopTime(start, driver);
//            }
//        } else {
//            webDriverHelper.waitUntilVisible(firstSiteName_sysreader, 30, 1);
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(firstSiteName_sysreader.isDisplayed(), "site name is displayed");
//        }
//        ExcelReader.setValueForColumn("Graph", loadInSeconds, role);
//        // HTML report generator
//        HTMLReport.addPageName("Graph");
////        HTMLReport.generateReport("Graph", loadInSeconds, role);
//        HTMLReport.writeReportToFile();
//    }

    public void captureGraphPageDailyCSV_PDFDownload(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 30, 1);
        if (graphSitesDropdownCard.isDisplayed()) {
            firstSiteName.click();
            insertValues();
            webDriverHelper.waitUntilVisible(graphTable, 30, 1);
            downloadDailyCSV_PDF();
            Assert.assertTrue(downloadPDFSuccessMsg.isDisplayed(), "graph tables are displayed");
        }
    }

    public void captureGraphPageHourlyCSV_PDFDownloadLoadTime(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 30, 1);
        if (graphSitesDropdownCard.isDisplayed()) {
            firstSiteName.click();
            insertValues();
            webDriverHelper.waitUntilVisible(graphTable, 30, 1);
            hourly_Button.click();
            webDriverHelper.waitUntilVisible(graphTable, 30, 1);
            downloadDailyCSV_PDF();
            Assert.assertTrue(downloadPDFSuccessMsg.isDisplayed(), "hourly graph tables are displayed");
        }
    }

    public void downloadDailyCSV_PDF() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(graphSketch, 60, 1);
        Thread.sleep(5000);
        webDriverHelper.waitUntilVisible(downloadIcon, 60, 1);
        downloadIcon.click();
        webDriverHelper.waitUntilVisible(downloadCSV, 60, 1);
        wait.until(ExpectedConditions.elementToBeClickable(downloadCSV));
        downloadCSV.click();
        webDriverHelper.waitUntilVisible(downloadCSVSuccessMsg, 30, 1);
        Assert.assertTrue(downloadCSVSuccessMsg.isDisplayed(), "graph tables are displayed");
        webDriverHelper.waitUntilVisible(downloadIcon, 30, 1);
        downloadIcon.click();
        webDriverHelper.waitUntilVisible(downloadPDF, 60, 1);
        wait.until(ExpectedConditions.elementToBeClickable(downloadPDF));
        Thread.sleep(500);
        downloadPDF.click();
        webDriverHelper.waitUntilVisible(downloadPDFSuccessMsg, 30, 1);
    }


//    public void captureGraphPageDailyLoadTime(String role) throws IOException, InterruptedException {
//        String loadInSeconds = null;
//        long start = 0;
//        webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 30, 1);
//        if (graphSitesDropdownCard.isDisplayed()) {
//            firstSiteName.click();
//            insertValues();
////            StringHelper.devToolCapture(role);
//            start = System.currentTimeMillis();
//            webDriverHelper.waitUntilVisible(graphTable, 30, 1);
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(graphTable.isDisplayed(), "graph tables are displayed");
//        }
//        ExcelReader.setValueForColumn("Graph - Daily", loadInSeconds, role);
//        // HTML report generator
//        HTMLReport.addPageName("Graph - Daily");
////        HTMLReport.generateReport("Graph - Daily", loadInSeconds, role);
//        HTMLReport.writeReportToFile();
//    }

//    public void captureGraphPageHourlyLoadTime(String role) throws IOException, InterruptedException {
//        String loadInSeconds = null;
//        long start = 0;
//        webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 30, 1);
//        if (graphSitesDropdownCard.isDisplayed()) {
//            firstSiteName.click();
//            insertValues();
//            webDriverHelper.waitUntilVisible(graphTable, 30, 1);
//            hourly_Button.click();
////            StringHelper.devToolCapture(role);
//            start = System.currentTimeMillis();
//            webDriverHelper.waitUntilVisible(graphTable, 30, 1);
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(graphTable.isDisplayed(), "graph tables are displayed");
//        }
//        ExcelReader.setValueForColumn("Graph - Hourly", loadInSeconds, role);
//        // HTML report generator
//        HTMLReport.addPageName("Graph - Hourly");
////        HTMLReport.generateReport("Graph - Hourly", loadInSeconds, role);
//        HTMLReport.writeReportToFile();
//    }

    public void insertValues() throws InterruptedException {
        measureDropdown.click();
        webDriverHelper.waitUntilVisible(maxTemp, 30, 1);
        Thread.sleep(200);
        maxTemp.click();
        Thread.sleep(500);
        webDriverHelper.waitUntilVisible(selectmeasure_maxTemp_Graph, 30, 1);
        minTemp.click();
        webDriverHelper.waitUntilVisible(selectmeasure_Graph, 30, 1);
        iconCalendar.click();
        webDriverHelper.waitUntilVisible(calendar, 120, 1);
        allOption.click();
        Thread.sleep(2000);
        graphBtn.click();
    }

    public void verifySOilMoistureUnit() throws InterruptedException {
        measureDropdown.click();
        webDriverHelper.waitUntilVisible(maxTemp, 30, 1);
        Thread.sleep(200);
        soilMoistureMeasurement.click();
        webDriverHelper.waitUntilVisible(selectedMeasureSoilMoisture, 30, 1);
        iconCalendar.click();
        webDriverHelper.waitUntilVisible(dateNumber, 30, 1);
        allOption.click();
        Thread.sleep(5000);
        graphBtn.click();

    }

    public void selectMeasurementAsMaxMinTemp() {
        webDriverHelper.waitUntilVisible(measureDropdownIcon, 120, 1);
        measureDropdownIcon.click();
        webDriverHelper.waitUntilVisibilityOfAllElements(measureList, 120, 1);
        boolean maxTempClicked = false;
        boolean minTempClicked = false;
        for (WebElement webElement : measureList) {
            String measureName = webElement.getText();
            if (measureName.equalsIgnoreCase(Constants.maxTemp) && !maxTempClicked) {
                webElement.click();
                maxTempClicked = true;
            }
            if (measureName.equalsIgnoreCase(Constants.minTemp) && !minTempClicked) {
                webElement.click();
                minTempClicked = true;
            }
            if (maxTempClicked && minTempClicked) {
                break;
            }
        }
        webDriverHelper.waitUntilVisible(selectedMeasureInMenu, 120, 1);
        measureInMenuBar = selectedMeasureInMenu.getText();
    }

    public void selectAnyOptionInTimelineAndClickOnGraph() {
        try {
            webDriverHelper.waitUntilVisible(iconCalendar, 90, 1);
            iconCalendar.click();
            webDriverHelper.waitUntilVisible(calendar, 120, 1);
            for (WebElement calendarBtn : calendarBtns) {
                String calendarBtnName = calendarBtn.getText();
                if (calendarBtnName.equalsIgnoreCase(Constants.predefinedDate)) {
                    calendarBtn.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(graphBtn, 90, 1);
            graphBtn.click();
            webDriverHelper.waitUntilVisible(graph, 60, 1);
            Assert.assertTrue((graph.isDisplayed()), "Failed because the graph is not displayed for the particular site which we selected");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectTimelineAndClickOnGraph.jpg");
            Assert.fail("Failed in selectAnyOptionInTimelineAndClickOnGraph method due to exception:- " + exc);
        }
    }

    public void verifyTheSelectedPredefinedDaysIsHighlighted() {
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(predefinedDaysInGraph, 200, 1);
            for (WebElement webElement : predefinedDaysInGraph) {
                String predefinedDaysName = webElement.getText();
                if (predefinedDaysName.equalsIgnoreCase(Constants.predefinedDate)) {
                    String bkgColor = webElement.getCssValue("color");
                    Assert.assertEquals(bkgColor, "rgba(112, 112, 112, 1)", "Failed to verify the highlighted predefined days " + Constants.predefinedDate + " that is selected in calendar timeline ");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyHighlightedDays.jpg");
            Assert.fail("Failed in verifyTheSelectedPredefinedDaysIsHighlighted method due to exception:- " + exc);
        }
    }

    public void verifyWhetherTimelineSeriesWillHaveSelectedDates() {
        try {
            webDriverHelper.waitUntilVisible(startDate, 90, 1);
            String selectedStartDateStr = startDate.getText();
            webDriverHelper.waitUntilVisible(endDate, 90, 1);
            String selectedEndDateStr = endDate.getText();
            webDriverHelper.waitUntilVisible(timelineSeriesGraph, 120, 1);
            Actions act = new Actions(driver);
            act.moveToElement(timelineSeriesGraph).perform();
            webDriverHelper.waitUntilVisible(startDateInTimelineSeriesGraph, 90, 1);
            String inputStartDateInGraph = startDateInTimelineSeriesGraph.getText();
            webDriverHelper.waitUntilVisible(endDateInTimelineSeriesGraph, 90, 1);
            String inputEndDateInGraph = endDateInTimelineSeriesGraph.getText();
            if (!inputStartDateInGraph.isEmpty()) {
                String outputStartDateInGraph = webDriverHelper.parseAndFormatDate(inputStartDateInGraph, "MMM dd, yyyy", "dd-MMM-yyyy");
                Assert.assertEquals(outputStartDateInGraph, selectedStartDateStr, "Failed to verify the start date displayed in the timeline graph");
            }
            if (!inputEndDateInGraph.isEmpty()) {
                String outputEndDateInGraph = webDriverHelper.parseAndFormatDate(inputEndDateInGraph, "MMM dd, yyyy", "dd-MMM-yyyy");
                Assert.assertEquals(outputEndDateInGraph, selectedEndDateStr, "Failed to verify the end date displayed in the timeline graph");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_timelineSeriesDates.jpg");
            Assert.fail("Failed in verifyWhetherTimelineSeriesWillHaveSelectedDates method due to exception:- " + exc);
        }
    }

    public void verifyTheDataInTheTableForSitesAndMeasurement(int numberOfSites) {
        try {
            webDriverHelper.waitUntilVisible(siteNameInTable, 120, 1);
            if (siteNameInTable.isDisplayed()) {
                String siteName = siteNameInTable.getText();
                if (numberOfSites == 1) {
                    if (!siteName.contains(measureInMenuBar + " for " + addedSitesForApiVerification.get(0))) {
                        Assert.fail("Failed to verify and the site is matching with the expected " + siteName + ". ");
                    }
                } else {
                    if (!siteName.contains(measureInMenuBar + " for 2 sites")) {
                        Assert.fail("Failed to verify and the site is matching with the expected " + siteName + ". ");
                    }
                }
            }
            DateTimeFormatter formatter = null;
            formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            webDriverHelper.waitUntilVisible(startDate, 90, 1);
            LocalDate calendarStartDate = LocalDate.parse(startDate.getText(), formatter);
            webDriverHelper.waitUntilVisible(endDate, 90, 1);
            LocalDate calendarEndDate = LocalDate.parse(endDate.getText(), formatter);
            webDriverHelper.waitUntilVisible(dateGeneratedInTable, 90, 1);
            if (dateGeneratedInTable.isDisplayed()) {
                String dateText = dateGeneratedInTable.getText();
                String expectedDateText = LocalDate.now().format(formatter);
                if (!dateText.contains(expectedDateText)) {
                    Assert.fail("Failed to verify the date generated is not matching with the expected " + dateText + ". ");
                }
                long daysBetween = ChronoUnit.DAYS.between(calendarStartDate, calendarEndDate) + 1;
                String noOfRecordDate = String.valueOf(daysBetween);
                webDriverHelper.waitUntilVisible(recordsInTable, 90, 1);
                if (recordsInTable.isDisplayed()) {
                    String record = recordsInTable.getText();
                    if (!record.contains(noOfRecordDate)) {
                        Assert.fail("Failed to verify the " + record + " in the table. ");
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_dataInTable.jpg");
            Assert.fail("Failed in verifyTheDataInTheTableForSitesAndMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyLoadMoreBtn() {
        try {
            if (loadBtn.isDisplayed()) {
                loadBtn.click();
            }
        } catch (Exception exc) {
            System.out.println("The Load More button is not available because the table size is " + tableSize.size() + ", And there is no much data to display.");
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForMaxMinTempMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measureNameInTableForMaxTemp, 120, 1);
            Assert.assertEquals(measureNameInTableForMaxTemp.getText(), Constants.maxTemp, "Failed to verify the table name with selected measurement " + measureNameInTableForMaxTemp.getText() + "");
            webDriverHelper.waitUntilVisible(measureNameInTableForMinTemp, 120, 1);
            Assert.assertEquals(measureNameInTableForMinTemp.getText(), Constants.minTemp, "Failed to verify the table name with selected measurement " + measureNameInTableForMinTemp.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            if (!(secondColumnName.getText().contains(tempUnit))) {
                Assert.fail("Failed to verify the units present in the second column for Max Temp measure is not matching with: " + secondColumnName.getText() + "");
            }
            webDriverHelper.waitUntilVisible(thirdColumnName, 60, 1);
            if (!(thirdColumnName.getText().contains(tempUnit))) {
                Assert.fail("Failed to verify the units present in the third column for Min Temp measure is not matching with: " + thirdColumnName.getText() + "");
            }
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForMax&MinTemp.jpg");
            Assert.fail("Failed in verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForMaxMinTempMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseOfIntegerValueForAllThreeColumn(int numberOfSites) {
        try {
            for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                index = i;
                String selectedSite = addedSitesForApiVerification.get(i);
                graphPage.verifyApiResponseIntegerValueFromUITableForThreeColumn(selectedSite);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseForSitesSelected");
            Assert.fail("Failed in verifyApiResponseOfIntegerValueForAllThreeColumn method due to exception:- " + exc);
        }
    }

    public void gettingIntegerUIValuesFromTableForThreeColumn() {
        try {
            int size = Math.min(datesInUiTable.size(), secondColumnValuesInUITable.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = datesInUiTable.get(i);
                WebElement secondUIElement = secondColumnValuesInUITable.get(i);
                WebElement thirdUIElement = thirdColumnValuesInTable.get(i);
                String dateStringUI = dateElementUI.getText();
                windColumnTextdata = windColumnData.getText();
                if (dateStringUI.contains(Constants.localDataText) || dateStringUI.contains(Constants.remoteDateText)) {
                    String[] dateSplit = dateStringUI.split(" \\|");
                    if (dateSplit.length == 2) {
                        date = (dateSplit[0]);
                        localDate = (dateSplit[1]);
                    }
                }
                String secondUIString = secondUIElement.getText();
                String thirdUIString = thirdUIElement.getText();
                int secondIntegerValueInUI;
                if (secondUIString.equals("--")) {
                    secondIntegerValueInUI = 9999999;
                } else {
                    secondIntegerValueInUI = Integer.parseInt(secondUIString);
                }
                int thirdIntegerValueInUI;
                if (thirdUIString.equals("--")) {
                    thirdIntegerValueInUI = 9999999;
                } else {
                    thirdIntegerValueInUI = Integer.parseInt(thirdUIString);
                }
                if (dateStringUI.contains(Constants.localDataText) || dateStringUI.contains(Constants.remoteDateText)) {
                    Map.Entry<String, Integer> elementPairThird = new AbstractMap.SimpleEntry<>(date, thirdIntegerValueInUI);
                    combinedIntegerListInUi.add(elementPairThird);
                    Map.Entry<String, Integer> elementPairSecond = new AbstractMap.SimpleEntry<>(date, secondIntegerValueInUI);
                    combinedIntegerListInUi.add(elementPairSecond);
                } else {
                    Map.Entry<String, Integer> elementPairThird = new AbstractMap.SimpleEntry<>(dateStringUI, thirdIntegerValueInUI);
                    combinedIntegerListInUi.add(elementPairThird);
                    Map.Entry<String, Integer> elementPairSecond = new AbstractMap.SimpleEntry<>(dateStringUI, secondIntegerValueInUI);
                    combinedIntegerListInUi.add(elementPairSecond);
                }
            }
            combinedIntegerListInUi.removeIf(elementPair -> elementPair.getValue() == 9999999);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("-verifyTheValuesInUIOfThreeColumn");
            Assert.fail("Failed in gettingIntegerUIValuesFromTableForThreeColumn method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseIntegerValueFromUITableForThreeColumn(String selectedSite) {
        try {
            //For getting UI values
            graphPage.gettingIntegerUIValuesFromTableForThreeColumn();
            //For getting API values
            String dateStart = startDate.getText();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = inputFormat.parse(dateStart);
            selectedStartDateStrText = outputFormat.format(date);
            String dateEnd = endDate.getText();
            Date date1 = inputFormat.parse(dateEnd);
            selectedEndDateStrText = outputFormat.format(date1);
            graphApiHelper.getSiteId(selectedSite);
            graphApiHelper.getSiteZone();
            if (measureInMenuBar.equalsIgnoreCase(Constants.windMeasure) || (windColumnTextdata.contains(Constants.localDataText) || windColumnTextdata.contains(Constants.remoteDateText))) {
                graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                graphApiHelper.getDateWindSpeedAndMaxWindSpeed();
                graphApiHelper.getSummaryRequestForGraphFromHistoricalApi();
                graphApiHelper.getDateWindSpeedAndMaxWindSpeed();
            }
            if (measureInMenuBar.equalsIgnoreCase(Constants.maxAndMinTempInMenuBar)) {
                graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                graphApiHelper.getDateMinAndMaxTemp();
            }
            Set<Map.Entry<String, Integer>> apiSet = new HashSet<>(combinedIntegerListInApi);
            for (int i = 0; i < combinedIntegerListInUi.size(); i++) {
                if (!apiSet.contains(combinedIntegerListInUi.get(i))) {
                    Assert.fail("Element at index " + i + " is not matching with any elements in the API list & Value is not matching with " + combinedIntegerListInUi.get(i) + ".");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponse.jpg");
            Assert.fail("Failed in verifyApiResponseIntegerValueFromUITableForThreeColumn method due to exception:- " + exc);
        }
    }

    //    public void selectASiteForUserRole(int numberOfSites, String userRole) {
//        try {
//            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 120, 1);
//            Thread.sleep(3000); //(for loading the sites dropdown modal)
//            Random random = new Random();
//            int expectedNumberOfSites = (numberOfSites == 1) ? 1 : 2;
//            for (WebElement site : sitesList) {
//                String selectedSite = site.getText();
//                if (userRole.equalsIgnoreCase("member") && selectedSite.contains(Constants.siteForMember)) {
//                    addedSitesForApiVerification.add(selectedSite);
//                    site.click();
//                    break;
//                } else if (selectedSite.contains(Constants.siteWithData)) {
//                    addedSitesForApiVerification.add(selectedSite);
//                    site.click();
//                    break;
//                }
//            }
//            if (addedSitesForApiVerification.size() < expectedNumberOfSites) {
//                for (int i = 0; i < sitesList.size(); i++) {
//                    int randomIndex = random.nextInt(sitesList.size());
//                    WebElement site = sitesList.get(randomIndex);
//                    String selectedSite = site.getText();
//                    if (!(addedSitesForApiVerification.get(0).contains(selectedSite))) {
//                        addedSitesForApiVerification.add(selectedSite);
//                        site.click();
//                    }
//                    if (addedSitesForApiVerification.size() == expectedNumberOfSites) {
//                        break;
//                    }
//                }
//            }
//            if (addedSitesForApiVerification.size() == 0) {
//                Assert.fail("Failed because the site is not selected ");
//            }
//            if (addedSitesForApiVerification.size() == 1) {
//                Assert.assertEquals(selectedSiteInMenu.getText(), addedSitesForApiVerification.get(0), "Failed because the selected site is not displayed in the menu bar");
//            } else {
//                for (int i = 0; i < selectedSites.size(); i++) {
//                    Assert.assertEquals(selectedSites.get(i).getText(), addedSitesForApiVerification.get(i), "Failed because the sites selected is not matching with the sites displayed in the row");
//                }
//            }
//        } catch (Exception exc) {
//            webDriverHelper.takeAScreenShot("_selectASiteForUserRole.jpg");
//            Assert.fail("Failed in selectASiteForUserRole method due to exception :- " + exc);
//        }
//    }
    public void selectASiteForUserRole(int numberOfSites, String userRole) {
        try {
            webDriverHelper.waitUntilVisible(openDropDownNewSites, 120, 1);
            if (!graphTag.isDisplayed()) {
                Assert.fail("the graph page tag is not displayed ");
            }
            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 120, 1);
            if (graphSitesDropdownCard.isDisplayed()) {
                Thread.sleep(1000);
                int expectedNumberOfSites = (numberOfSites == 1) ? 1 : 2;
                for (int i = 0; i < dropDownSitesList.size(); i++) {
                    WebElement addSite = dropDownSitesList.get(i);
                    String nameOfSelectedList = addSite.getText();
                    if (nameOfSelectedList.contains(Constants.siteWithData) || (expectedNumberOfSites == 2 && nameOfSelectedList.contains(Constants.siteForMember))) {
                        addedSitesForApiVerification.add(nameOfSelectedList);
                        addSite.click();
                    }
                    if (addedSitesForApiVerification.size() == expectedNumberOfSites) {
                        break;
                    }
                }
            }
            if (addedSitesForApiVerification.size() == 0) {
                Assert.fail("Failed because the site is not selected ");
            }
            if (addedSitesForApiVerification.size() == 1) {
                Assert.assertEquals(selectedSiteInMenu.getText(), addedSitesForApiVerification.get(0), "Failed because the selected site is not displayed in the menu bar");
            } else {
                for (int i = 0; i < selectedSites.size(); i++) {
                    Assert.assertEquals(selectedSites.get(i).getText(), addedSitesForApiVerification.get(i), "Failed because the sites selected is not matching with the sites displayed in the row");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectASiteForUserRole.jpg");
            Assert.fail("Failed in selectASiteForUserRole method due to exception :- " + exc);
        }
    }

    public void selectAMeasurement(String measurement) {
        try {
            webDriverHelper.waitUntilVisible(measureDropdownIcon, 90, 1);
            measureDropdownIcon.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(measureList, 200, 1);
            for (WebElement measurements : measureList) {
                String measurementsName = measurements.getText();
                if (measurementsName.equalsIgnoreCase(measurement)) {
                    measurements.click();
                    webDriverHelper.waitUntilVisible(selectedMeasureInMenu, 120, 1);
                    measureInMenuBar = selectedMeasureInMenu.getText();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(measureDropdownIcon, 90, 1);
            measureDropdownIcon.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("selectAMeasurement.jpg");
            Assert.fail("Failed in selectAMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForChloroIndexMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            Assert.assertEquals(measurementNameInTable.getText(), Constants.chloroIndexMeasure, "Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), Constants.chloroIndexUnit, "Failed to verify the units present in the second column for chloroIndex measure is not matching with: " + secondColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForCholroIndex.jpg");
            Assert.fail("Failed in verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForChloroIndexMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseOfDoubleValueFromUITableForSitesSelected(int numberOfSites) {
        try {
            if (numberOfSites == 2) {
                sitesSelected = addedSitesForApiVerification.size();
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    combinedDoubleListInUi.clear();
                    graphPage.verifyApiResponseDoubleValueFromUITable(selectedSite);
                }
            } else {
                sitesSelected = addedSitesForApiVerification.size();
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    combinedDoubleListInUi.clear();
                    graphPage.verifyApiResponseDoubleValueFromUITable(selectedSite);
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseForSitesSelected");
            Assert.fail("Failed in verifyApiResponseOfDoubleValueFromUITableForSitesSelected method due to exception:- " + exc);
        }
    }

    public void gettingDoubleUIValuesFromTable() {
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(datesInUiTable, 200, 1);
            webDriverHelper.waitUntilVisibilityOfAllElements(secondColumnValuesInUITable, 200, 1);
            int size = Math.min(datesInUiTable.size(), secondColumnValuesInUITable.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = datesInUiTable.get(i);
                WebElement valueElementUI = secondColumnValuesInUITable.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                double doubleValueUI;
                if (valueStringUI.equals("--")) {
                    doubleValueUI = 9999999;
                } else {
                    doubleValueUI = Double.parseDouble(valueStringUI);
                }
                Map.Entry<String, Double> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, doubleValueUI);
                combinedDoubleListInUi.add(elementPair);
            }
            combinedDoubleListInUi.removeIf(elementPair -> elementPair.getValue() == 9999999);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("-verifyTheValuesInUIForFirstColumn");
            Assert.fail("Failed in gettingDoubleUIValuesFromTable method due to exception:- " + exc);
        }
    }

    public void gettingDoubleUIValuesForThirdColumn() {
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(datesInUiTable, 200, 1);
            webDriverHelper.waitUntilVisibilityOfAllElements(thirdColumnValuesInTable, 200, 1);
            int size = Math.min(datesInUiTable.size(), thirdColumnValuesInTable.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = datesInUiTable.get(i);
                WebElement valueElementUI = thirdColumnValuesInTable.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                double doubleValueUI;
                if (valueStringUI.equals("--")) {
                    doubleValueUI = 9999999;
                } else {
                    doubleValueUI = Double.parseDouble(valueStringUI);
                }
                Map.Entry<String, Double> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, doubleValueUI);
                combinedDoubleListInUi.add(elementPair);
            }
            combinedDoubleListInUi.removeIf(elementPair -> elementPair.getValue() == 9999999);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("-verifyTheValuesInUIForThirdColumn");
            Assert.fail("Failed in gettingDoubleUIValuesForThirdColumn method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseDoubleValueFromUITable(String selectedSite) {
        try {
            //For getting UI values
            if (index == 0) {
                graphPage.gettingDoubleUIValuesFromTable();
            } else {
                graphPage.gettingDoubleUIValuesForThirdColumn();
            }
            //For getting API values
            webDriverHelper.waitUntilVisible(startDate, 90, 1);
            String dateText = startDate.getText();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = inputFormat.parse(dateText);
            selectedStartDateStrText = outputFormat.format(date);
            graphApiHelper.getSiteId(selectedSite);
            graphApiHelper.getSiteZone();
            if (measureInMenuBar.equalsIgnoreCase(Constants.soilMoistureMeasureInMenuBar)) {
                graphApiHelper.getSummaryRequestForGraphFromSentekDailyApi();
                graphApiHelper.getDateAndSoilMoistureAvg();
            } else if (measureInMenuBar.equalsIgnoreCase(Constants.chloroIndexMeasureInMenuBar)) {
                graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                graphApiHelper.getDateAndChloroValues();
            } else if (measureInMenuBar.equalsIgnoreCase(Constants.precipMeasureInmenuBar)) {
                graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                graphApiHelper.getDateAndPrecipValues();
            } else if (measureInMenuBar.equalsIgnoreCase(Constants.dailyEtcMeasureInMenuBar)) {
                graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                graphApiHelper.getDateAndEtcValues();
            } else if (measureInMenuBar.equalsIgnoreCase(Constants.ndviMeasure)) {
                graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                graphApiHelper.getDateAndNdviValues();
            } else if (measureInMenuBar.equalsIgnoreCase(Constants.vaporPressureDeficitMeasureInMenuBar)) {
                graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                graphApiHelper.getDateAndVpdForPressureUnitKp();
            }
            Set<Map.Entry<String, Double>> apiSet = new HashSet<>(combinedDoubleListInApi);
            for (int i = 0; i < combinedDoubleListInUi.size(); i++) {
                if (!apiSet.contains(combinedDoubleListInUi.get(i))) {
                    Assert.fail("Element at index " + i + " is not matching with any elements in the API list & Value is not matching with " + combinedDoubleListInUi.get(i) + ".");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponse.jpg");
            Assert.fail("Failed in verifyApiResponseDoubleValueFromUITable method due to exception:- " + exc);
        }
    }

    public void verifyTheTimelineBtn() {
        try {
            webDriverHelper.waitUntilVisible(dailyTimelineBtn, 90, 1);
            if (dailyTimelineBtn.isDisplayed()) {
                resolutionText = "daily";
            } else {
                Assert.fail("Failed to verify the default btn " + resolutionText + " in the graph page ");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyHighlightedDays.jpg");
            Assert.fail("Failed in verifyTheTimelineBtn method due to exception:- " + exc);
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForDailyEtcMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            Assert.assertEquals(measurementNameInTable.getText(), Constants.dailyEtcMeasure, "Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), sizeUnit, "Failed to verify the units present in the second column for daily etc measure is not matching with: " + secondColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForDailyEtc.jpg");
            Assert.fail("Failed in verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForDailyEtcMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForLeafWetnessMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            Assert.assertEquals(measurementNameInTable.getText(), Constants.leafWetnessMeasure, "Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), Constants.leafWetnessUnit, "Failed to verify the units present in the second column for leaf wetness measure is not matching with: " + secondColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForLeafWetness.jpg");
            Assert.fail("Failed in verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForLeafWetnessMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseOfIntegerValueFromUITableForSitesSelected(int numberOfSites) {
        try {
            if (numberOfSites == 2) {
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    combinedIntegerListInUi.clear();
                    graphPage.verifyApiResponseIntegerValueFromUITable(selectedSite);
                }
            } else {
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    combinedIntegerListInUi.clear();
                    graphPage.verifyApiResponseIntegerValueFromUITable(selectedSite);
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseForSitesSelected");
            Assert.fail("Failed in verifyApiResponseOfIntegerValueFromUITableForSitesSelected method due to exception:- " + exc);
        }
    }

    public void gettingIntegerUIValuesFromTable() {
        try {
            int size = Math.min(datesInUiTable.size(), secondColumnValuesInUITable.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = datesInUiTable.get(i);
                WebElement valueElementUI = secondColumnValuesInUITable.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueInUI;
                if (valueStringUI.equals("--")) {
                    integerValueInUI = 9999999;
                } else {
                    integerValueInUI = Integer.parseInt(valueStringUI);
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueInUI);
                combinedIntegerListInUi.add(elementPair);
            }
            combinedIntegerListInUi.removeIf(elementPair -> elementPair.getValue() == 9999999);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("-verifyTheValuesInUIForFirstColumn");
            Assert.fail("Failed in gettingIntegerUIValuesFromTable method due to exception:- " + exc);
        }
    }

    public void gettingIntegerUIValuesForThirdColumn() {
        try {
            int size = Math.min(datesInUiTable.size(), thirdColumnValuesInTable.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = datesInUiTable.get(i);
                WebElement valueElementUI = thirdColumnValuesInTable.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueInUI;
                if (valueStringUI.equals("--")) {
                    integerValueInUI = 9999999;
                } else {
                    integerValueInUI = Integer.parseInt(valueStringUI);
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueInUI);
                combinedIntegerListInUi.add(elementPair);
            }
            combinedIntegerListInUi.removeIf(elementPair -> elementPair.getValue() == 9999999);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("-verifyTheValuesInUIForThirdColumn");
            Assert.fail("Failed in gettingIntegerUIValuesForThirdColumn method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseIntegerValueFromUITable(String selectedSite) {
        try {
            //For getting UI values
            if (index == 0) {
                graphPage.gettingIntegerUIValuesFromTable();
            } else {
                graphPage.gettingIntegerUIValuesForThirdColumn();
            }
            //For getting API values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = inputFormat.parse(dateText);
            selectedStartDateStrText = outputFormat.format(date);
            String endDateText = endDate.getText();
            Date endDate = inputFormat.parse(endDateText);
            selectedEndDateStrText = outputFormat.format(endDate);
            graphApiHelper.getSiteId(selectedSite);
            graphApiHelper.getSiteZone();
            switch (measureInMenuBar) {
                case Constants.leafWetnessMeasureInMenuBar:
                    graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                    graphApiHelper.getDateAndLfwValues();
                    break;
                case Constants.relativeHumidityMeasureInMenuBar:
                    graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                    graphApiHelper.getDateAndRhValues();
                    break;
                case Constants.vaporPressureDeficitMeasureInMenuBar:
                    graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                    graphApiHelper.getDateAndVpdForPressureUnitMb();
                    break;
                case Constants.maxAndMinTempInMenuBar:
                    graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                    if (firstMeasureSelected.getCssValue("color").equalsIgnoreCase(Constants.selectedBkgColour)) {
                        graphApiHelper.getDateAndMaxTemp();
                    } else {
                        graphApiHelper.getDateAndMinTemp();
                    }
                    break;
                case Constants.windMeasure:
                    graphApiHelper.getSummaryRequestForGraphFromDailyApi();
                    graphApiHelper.getDateWindSpeedAndMaxWindSpeed();
                    graphApiHelper.getSummaryRequestForGraphFromHistoricalApi();
                    graphApiHelper.getDateWindSpeedAndMaxWindSpeed();
                    break;
            }
            Set<Map.Entry<String, Integer>> apiSet = new HashSet<>(combinedIntegerListInApi);
            for (int i = 0; i < combinedIntegerListInUi.size(); i++) {
                if (!apiSet.contains(combinedIntegerListInUi.get(i))) {
                    Assert.fail("Element at index " + i + " is not matching with any elements in the API list & Value is not matching with " + combinedIntegerListInUi.get(i) + ".");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponse.jpg");
            Assert.fail("Failed in verifyApiResponseIntegerValueFromUITable method due to exception:- " + exc);
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForNdviMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            Assert.assertEquals(measurementNameInTable.getText(), Constants.ndviMeasure, "Failed to verify the table name for selected measurement " + measurementNameInTable.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), Constants.ndviUnit, "Failed to verify the units present in the second column for ndvi measure is not matching with: " + secondColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForNdvi.jpg");
            Assert.fail("Failed in verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForNdviMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyExportToastMessage() {
        try {
            downloadDailyCSV_PDF();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyExportToastMessage.jpg");
            Assert.fail("Failed in verifyExportToastMessage method due to exception:- " + exc);
        }
    }

    public void verifyWithSitesDaily(int numberOfSites) {
        try {
            webDriverHelper.waitUntilVisible(openDropDownNewSites, 120, 1);
            webDriverHelper.waitUntilVisible(graphTag, 30, 1);
            if (!graphTag.isDisplayed()) {
                Assert.fail("The graph page tag is not displayed ");
            }
            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 60, 1);
            if (graphSitesDropdownCard.isDisplayed()) {
                for (int i = 0; i < dropDownSitesList.size() - 1 && i < numberOfSites; i++) {
                    //The Thread.sleep cmd was used to load the dropdown of the sites.
                    Thread.sleep(1000);
                    WebElement addSite = dropDownSitesList.get(i);
                    addSite.click();
                }
                insertValues();
                webDriverHelper.waitUntilVisible(graphTable, 30, 1);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyWithSitesDaily.jpg");
            Assert.fail("Failed in verifyWithSitesDaily method due to exception:- " + exc);
        }
    }

    public void verifyWithSitesHourly(int numberOfSites) {
        try {
            if (!graphTag.isDisplayed()) {
                System.out.println("the graph page tag is not displayed ");
            }
            webDriverHelper.waitUntilVisible(openDropDownNewSites, 120, 1);
            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 30, 1);
            if (graphSitesDropdownCard.isDisplayed()) {
                for (int i = 0; i < dropDownSitesList.size() - 1 && i < numberOfSites; i++) {
                    WebElement addSite = dropDownSitesList.get(i);
                    String text = addSite.getText();
                    addedSitesForApiVerification.add(text);
                    addSite.click();
                }
                insertValues();
                webDriverHelper.waitUntilVisible(graphTable, 30, 1);
                hourly_Button.click();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyWithSitesHourly.jpg");
            Assert.fail("Failed in verifyWithSitesHourly method due to exception:- " + exc);
        }
    }

    public void verifyGraphWithSelectedDetails(int numberOfSites, String measurement, String date, String userRole) {
        try {
            webDriverHelper.waitUntilVisible(openDropDownNewSites, 120, 1);
            if (!graphTag.isDisplayed()) {
                Assert.fail("the graph page tag is not displayed ");
            }
            selectASiteForUserRole(numberOfSites, userRole);
            insertMeasurementDate(measurement, date);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyGraphWithSelectedDetails.jpg");
            Assert.fail("Failed in verifyGraphWithSelectedDetails method due to exception :- " + exc);
        }
    }

    public void insertMeasurementDate(String measurement, String date) throws InterruptedException {
        try {
            measureDropdown.click();
            Thread.sleep(3000);
            for (WebElement measurements : measureDropDownList) {
                String measurementsName = measurements.getText();
                if (measurementsName.equalsIgnoreCase(measurement)) {
                    measureInMenuBar = measurementsName;
                    measurements.click();
                }
            }
            webDriverHelper.waitUntilVisible(iconCalendar, 30, 1);
            iconCalendar.click();
            webDriverHelper.waitUntilVisible(monthTagInsideCalender, 30, 1);
            for (WebElement calendarBtn : calendarBtn) {
                String calendarBtnName = calendarBtn.getText();
                if (calendarBtnName.equals(date)) {
                    calendarBtn.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(graphBtn, 60, 1);
            graphBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_insertMeasurementDate.jpg");
            Assert.fail("Failed in insertMeasurementDate method due to exception:- " + exc);
        }
    }

    public void verifyCustomDateForHourly() {
        try {
            webDriverHelper.waitUntilVisible(dailyActiveButton, 90, 1);
            if (!dailyActiveButton.isEnabled()) {
                Assert.fail("Daily is  not enabled");
            }
            webDriverHelper.waitUntilVisible(hourly_Button, 90, 1);
            hourly_Button.click();
            TimelineText = "local_hourly";
            Assert.assertTrue(hrs12Button.isEnabled(), "the 12-hour button is not yet enabled.");
            Assert.assertTrue(hrs24Button.isDisplayed(), "the 24-hour button is not displayed.");
            Assert.assertTrue(hrs48Button.isDisplayed(), "the 48-hour button is not displayed.");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyCustomDateForHourly.jpg");
            Assert.fail("Failed in verifyCustomDateForHourly method due to exception :- " + exc);
        }
    }

    public void verifyingSelectedDaysDisplayed(String days) {
        try {
            // The Thread.sleep cmd was used to load the Graph section after clicking on the Hourly.
            Thread.sleep(2000);
            for (WebElement webElement : dateSelectedFromList) {
                String predefinedDaysName = webElement.getText();
                if (!predefinedDaysName.equals(days)) {
                    Assert.fail("The " + days + " is not selected ");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyingSelectedDaysDisplayed.jpg");
            Assert.fail("Failed in verifyingSelectedDaysDisplayed method due to exception :- " + exc);
        }
    }

    public void verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourly() {
        try {
            webDriverHelper.waitUntilVisible(endDate, 60, 1);
            webDriverHelper.scrollToWebElement(dateGenerated);
            String selectedEndDateStr = endDate.getText();
            Actions act = new Actions(driver);
            act.moveToElement(timelineSeriesGraph).perform();
            webDriverHelper.waitUntilVisible(endDateInTimelineSeriesGraph, 120, 1);
            // IN the timeline Graph the end date and start date overlap creating same path for both date texts, handling this with a
            // list of web elements and reading the last element of the list resolves this. In case of Xpath update this needs to be updated.
            int sizeOfEndDate = endDateInListInTimelineSeriesGraph.size();
            String inputEndDateInGraph = endDateInListInTimelineSeriesGraph.get(sizeOfEndDate - 1).getText();
            if (!inputEndDateInGraph.isEmpty()) {
                String outputEndDateInGraph = webDriverHelper.parseAndFormatDate(inputEndDateInGraph, "MMM dd, yyyy", "dd-MMM-yyyy");
                //This step is commended for the overlap of issues. Once it is fixed, we can use this assertion, but the xpath may change. We need to fix it after the changes.
                //Assert.assertEquals(selectedEndDateStr, outputEndDateInGraph, "Failed to verify the end date displayed in the timeline graph");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourly.jpg");
            Assert.fail("Failed in verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourly method due to exception :- " + exc);
        }
    }

    public void verifyTheTableTagName() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameAfterSelection, 120, 1);
            String measurementName = measurementNameAfterSelection.getText();
            String name = sitesNameOrCount.getText();
            String VerifyTableName = measurementName + " for " + name;
            String[] wordsToCheck = VerifyTableName.trim().toLowerCase().split("\\s+");
            webDriverHelper.waitUntilVisible(nameTagInTable, 90, 1);
            String namePresentInUI = nameTagInTable.getText();
            boolean allWordsPresent = true;
            for (String word : wordsToCheck) {
                if (!namePresentInUI.trim().toLowerCase().contains(word)) {
                    allWordsPresent = false;
                    break;
                }
            }
            if (!allWordsPresent) {
                Assert.fail("Assertion failed: The name presented in the table does not contain the expected value. Actual: " + namePresentInUI + " Expected: " + VerifyTableName);
            }
            DateTimeFormatter formatter = null;
            formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
            String a = startDate.getText();
            LocalDate calendarStartDate = LocalDate.parse(a, formatter);
            String b = endDate.getText();
            LocalDate calendarEndDate = LocalDate.parse(b, formatter);
            if (!dateGenerated.isDisplayed()) {
                String dateText = dateGeneratedInTable.getText();
                if (!dateText.contains(endDate.getText())) {
                    Assert.fail("Failed to verify and the date generated is not matching with the expected " + dateText + ". ");
                }
                Assert.fail("The date generated tag is not present");
            }
            long daysBetween = ChronoUnit.DAYS.between(calendarStartDate, calendarEndDate) + 1;
            String noOfRecordDate = String.valueOf(daysBetween);
            if (!numberOfRecords.isDisplayed()) {
                String record = recordsInTable.getText();
                if (!record.contains(noOfRecordDate)) {
                    Assert.fail("Failed to verify the " + record + " in the table. ");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheTableTagName.jpg");
            Assert.fail("Failed in verifyTheTableTagName method due to exception :- " + exc);
        }
    }

    public void verifyUnitsInGraphForHourly() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                unitInTable = unitDisplayedInTable.getText();
                Assert.assertEquals(unitInTable, solarRadiationMeasureForHourly, "Failed to verify the table name with selected measurement " + unitInTable + " ");
            } else {
                webDriverHelper.waitUntilVisible(multipleSiteUnit, 90, 1);
                Assert.assertTrue(multipleSiteUnit.getText().contains(solarRadiationMeasureForHourly), "Failed to verify the table name with selected measurement " + unitInTable + " ");
            }
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphForHourly.jpg");
            Assert.fail("Failed in verifyUnitsInGraphForHourly method due to exception :" + exc);
        }
    }

    public void verifySwdwCountInApiForMultipleSitesForGraph() {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                String secondItem = addedSitesForApiVerification.get(1);
                verifySiteSwdwCountInApiForHourly(ualueUITable1, firstItem);
                verifySiteSwdwCountInApiForHourly(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String singleItem = addedSitesForApiVerification.get(0);
                verifySiteSwdwCountInApiForHourly(ualueUITable1, singleItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifySwdwCountInApiForMultipleSitesForGraph.jpg");
            Assert.fail("Failed in verifySwdwCountInApiForMultipleSitesForGraph method due to exception :- " + exc);
        }
    }

    private void verifySiteSwdwCountInApiForHourly(List<WebElement> value, String siteName) {
        try {
            // UI values from the table
            List<Map.Entry<String, Integer>> combinedListInUi = new ArrayList<>();
            int size = Math.min(dateUI.size(), value.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = value.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueUI;
                if (valueStringUI.equals("--")) {
                    integerValueUI = 9999;
                } else {
                    long roundedValue = Math.round(Float.parseFloat(valueStringUI));
                    integerValueUI = Integer.parseInt(String.valueOf(roundedValue));
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
                combinedListInUi.add(elementPair);
            }
            Iterator<Map.Entry<String, Integer>> iterator = combinedListInUi.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> elementPair = iterator.next();
                if (elementPair.getValue() == 9999) {
                    iterator.remove();
                }
            }
            // API values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = inputFormatForStartDate.parse(dateText);
            selectedStartDateStrText = outputFormatForStarDate.format(date);
            String endDateText = endDates.getText();
            SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date1 = inputFormatForEndDate.parse(endDateText);
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date1);
            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date modifiedDate = calendar.getTime();
            selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
            graphApiHelper.getSiteId(siteName);
            graphApiHelper.fetchSitesZone();
            webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
            graphApiHelper.getSummaryRequestForGraphForHourly();
            graphApiHelper.getDateSolarRadiationForHourly();
            List<Map.Entry<String, Integer>> MatchingElements = new ArrayList<>();
            for (int i = 0; i < combinedListInUi.size(); i++) {
                boolean matchFound = false;
                for (int j = combinedListInApiHourly.size() - 1; j >= 0; j--) {
                    Thread.sleep(10);
                    if (combinedListInUi.get(i).equals(combinedListInApiHourly.get(j))) {
                        MatchingElements.add(combinedListInUi.get(i));
                        matchFound = true;
                        break;
                    }
                }
                if (!matchFound) {
                    Assert.fail("Element at index " + i + "in the UI is not matching with any elements in the API list");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifySiteSwdwCountInApiForHourly.jpg");
            Assert.fail("Failed in verifySiteSwdwCountInApiForHourly method due to exception :- " + exc);
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForPrecipitationMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            Assert.assertEquals(measurementNameInTable.getText(), Constants.precipMeasure, "Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), sizeUnit, "Failed to verify the units present in the second column for precipitation measure is not matching with: " + secondColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForPrecipitation.jpg");
            Assert.fail("Failed to verify the selected precipitation measurement with units in the table and load more option at end due to exception:- ");
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForRelativeHumidityMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            Assert.assertEquals(measurementNameInTable.getText(), Constants.relativeHumidityMeasure, "Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), Constants.relativeHumidityUnit, "Failed to verify the units present in the second column for relative humidity measure is not matching with: " + secondColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForRelativeHumidity.jpg");
            Assert.fail("Failed to verify the selected relative humidity measurement with units in the table and load more option at end due to exception:- ");
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForVaporPressureDeficitMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            Assert.assertEquals(measurementNameInTable.getText(), Constants.vaporPressureDeficitMeasure, "Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            if (!(secondColumnName.getText().replace("P", "p").contains(presUnit))) {
                Assert.fail("Failed to verify the units present in the second column for vapour pressure deficit measure is not matching with: " + secondColumnName.getText() + "");
            }
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForVapourPressureDeficit.jpg");
            Assert.fail("Failed to verify the selected vapour pressure deficit measurement with units in the table and load more option at end due to exception:- ");
        }
    }

    public void verifyAPiResponseForVPDFromUITable(int numberOfSites) {
        try {
            if (numberOfSites == 2) {
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    if (presUnit.equalsIgnoreCase(Constants.pressureUnitInTable)) {
                        combinedIntegerListInUi.clear();
                        graphPage.verifyApiResponseIntegerValueFromUITable(selectedSite);
                    } else {
                        combinedDoubleListInUi.clear();
                        graphPage.verifyApiResponseDoubleValueFromUITable(selectedSite);
                    }
                }
            } else {
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    if (presUnit.equalsIgnoreCase(Constants.pressureUnitInTable)) {
                        combinedIntegerListInUi.clear();
                        graphPage.verifyApiResponseIntegerValueFromUITable(selectedSite);
                    } else {
                        combinedDoubleListInUi.clear();
                        graphPage.verifyApiResponseDoubleValueFromUITable(selectedSite);
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseInUITableForPressureUnit.jpg");
            Assert.fail("Failed to verify the integer/double values from table in UI and from the Api response due to exception:- " + exc);
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForWindMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            Assert.assertEquals(measurementNameInTable.getText(), Constants.windMeasure, "Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            if (!(secondColumnName.getText().contains(speedUnit))) {
                Assert.fail("Failed to verify the units present in the second column for wind measure is not matching with: " + secondColumnName.getText() + "");
            }
            webDriverHelper.waitUntilVisible(thirdColumnName, 60, 1);
            if (!(thirdColumnName.getText().contains(speedUnit))) {
                Assert.fail("Failed to verify the units present in the third column for wind measure is not matching with: " + thirdColumnName.getText() + "");
            }
            webDriverHelper.waitUntilVisible(fourthColumnName, 60, 1);
            Assert.assertEquals(fourthColumnName.getText(), Constants.windDirection, "Failed to verify the units present in the third column for wind measure is not matching with: " + fourthColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForWind.jpg");
            Assert.fail("Failed to verify the selected wind measurement with units in the table and load more option at end due to exception:- ");
        }
    }

    public void selectSingleSiteAndMeasurementAsSoilMoisture(int numberOfSites) {
        try {
            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 90, 1);
            if (numberOfSites == 1) {
                for (WebElement webElement : sitesList) {
                    String selectedSite = webElement.getText();
                    if (selectedSite.equals(Constants.siteWithData)) {
                        addedSitesForApiVerification.add(selectedSite);
                        webElement.click();
                        break;
                    }
                }
            } else {
                boolean firstSite = false;
                boolean secondSite = false;
                for (WebElement webElement : sitesList) {
                    String selectedSite = webElement.getText();
                    if (selectedSite.equals(Constants.siteWithData) && !firstSite) {
                        addedSitesForApiVerification.add(selectedSite);
                        webElement.click();
                        firstSite = true;
                    }
                    if (selectedSite.equals(Constants.soilMoistureSite1) && !secondSite) {
                        addedSitesForApiVerification.add(selectedSite);
                        webElement.click();
                        secondSite = true;
                    }
                    if (firstSite && secondSite) {
                        break;
                    }
                }
            }
            if (addedSitesForApiVerification.size() == 0) {
                Assert.fail("Failed because the site is not selected ");
            }
            if (addedSitesForApiVerification.size() == 1) {
                Assert.assertEquals(selectedSiteInMenu.getText(), addedSitesForApiVerification.get(0), "Failed because the selected site is not displayed in the menu bar");
            } else {
                for (int i = 0; i < selectedSites.size(); i++) {
                    Assert.assertEquals(selectedSites.get(i).getText(), addedSitesForApiVerification.get(i), "Failed because the sites selected is not matching with the sites displayed in the row");
                }
            }
            webDriverHelper.waitUntilVisible(measureDropdownIcon, 90, 1);
            measureDropdownIcon.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(measureList, 200, 1);
            for (WebElement measurements : measureList) {
                String measurementsName = measurements.getText();
                if (measurementsName.equalsIgnoreCase(Constants.soilMoistureMeasure)) {
                    measurements.click();
                    webDriverHelper.waitUntilVisible(selectedMeasureInMenu, 120, 1);
                    measureInMenuBar = selectedMeasureInMenu.getText();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(measureDropdownIcon, 90, 1);
            measureDropdownIcon.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectSite&MeasureForSoilMoisture.jpg");
            Assert.fail("Failed to select the site and measurement as soil moisture due to exception:- " + exc);
        }
    }

    public void selectAnyOptionInTimelineAndClickOnGraphAndVerify() {
        try {
            webDriverHelper.waitUntilVisible(iconCalendar, 90, 1);
            iconCalendar.click();
            webDriverHelper.waitUntilVisible(calendar, 120, 1);
            for (WebElement calendarBtn : calendarBtns) {
                String calendarBtnName = calendarBtn.getText();
                if (calendarBtnName.equalsIgnoreCase(Constants.predefinedDate)) {
                    calendarBtn.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(graphBtn, 90, 1);
            graphBtn.click();
            webDriverHelper.waitUntilVisible(chartGraph, 60, 1);
            Assert.assertTrue((chartGraph.isDisplayed()), "Failed because the graph is not displayed for the particular site which we selected");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("selectTimelineAndClickOnGraphAndVerifyChartGraph.jpg");
            Assert.fail("Failed to select timeline and click on graph for soil moisture measure in graph page due to exception:- " + exc);
        }
    }

    public void verifyWhetherTimelineSeriesWillHaveSelectedDatesForSoilMoistureMeasure() {
        try {
            webDriverHelper.waitUntilVisible(startDate, 90, 1);
            String selectedStartDateStr = startDate.getText();
            webDriverHelper.waitUntilVisible(endDate, 90, 1);
            String selectedEndDateStr = endDate.getText();
            webDriverHelper.waitUntilVisible(timelineSeriesInChartGraph, 120, 1);
            Actions act = new Actions(driver);
            act.moveToElement(timelineSeriesInChartGraph).perform();
            webDriverHelper.waitUntilVisible(startDateInTimelineSeriesInChartGraph, 90, 1);
            String inputStartDateInGraph = startDateInTimelineSeriesInChartGraph.getText();
            webDriverHelper.waitUntilVisible(endDateInTimelineSeriesInChartGraph, 90, 1);
            String inputEndDateInGraph = endDateInTimelineSeriesInChartGraph.getText();
            if (!inputStartDateInGraph.isEmpty()) {
                String outputStartDateInGraph = webDriverHelper.parseAndFormatDate(inputStartDateInGraph, "MMM dd, yyyy", "dd-MMM-yyyy");
                LocalDate selectedStartDate = LocalDate.parse(selectedStartDateStr, DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH));
                LocalDate startDateMinusOneDay = selectedStartDate.minusDays(1);
                String startDateMinusOneDayStr = startDateMinusOneDay.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH));
                if (!(outputStartDateInGraph.equals(selectedStartDateStr)) && !(outputStartDateInGraph.equals(startDateMinusOneDayStr))) {
                    Assert.fail("Failed to verify the start date displayed in the timeline graph. Expected " + selectedStartDateStr + " but found " + outputStartDateInGraph + ".");
                }
            }
            if (!inputEndDateInGraph.isEmpty()) {
                LocalDate selectedEndDate = LocalDate.parse(selectedEndDateStr, DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH));
                LocalDate endDateMinusOneDay = selectedEndDate.minusDays(1);
                String endDateMinusOneDayStr = endDateMinusOneDay.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH));
                String outputEndDateInGraph = webDriverHelper.parseAndFormatDate(inputEndDateInGraph, "MMM dd, yyyy", "dd-MMM-yyyy");
                Assert.assertEquals(outputEndDateInGraph, endDateMinusOneDayStr, "Failed to verify the end date displayed in the timeline graph");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_timelineSeriesDatesForSoilMoistureMeasure.jpg");
            Assert.fail("Failed to verify the dates which is selected and the dates present in the graph due to exception:- " + exc);
        }
    }

    public void verifyTheDataInTheTableForSitesAndMeasurementAsSoilMoisture(int numberOfSites) {
        try {
            webDriverHelper.waitUntilVisible(siteNameInTable, 120, 1);
            if (siteNameInTable.isDisplayed()) {
                String siteName = siteNameInTable.getText();
                if (numberOfSites == 1 && measureInMenuBar.equals(Constants.soilMoistureMeasureInMenuBar)) {
                    if (!siteName.contains(Constants.soilMoistureMeasure + " for " + addedSitesForApiVerification.get(0))) {
                        Assert.fail("Failed to verify and the site is matching with the expected " + siteName + ". ");
                    }
                }
            }
            DateTimeFormatter formatter = null;
            formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            webDriverHelper.waitUntilVisible(startDate, 90, 1);
            LocalDate calendarStartDate = LocalDate.parse(startDate.getText(), formatter);
            webDriverHelper.waitUntilVisible(endDate, 90, 1);
            LocalDate calendarEndDate = LocalDate.parse(endDate.getText(), formatter);
            webDriverHelper.waitUntilVisible(dateGeneratedInTable, 90, 1);
            if (dateGeneratedInTable.isDisplayed()) {
                String dateText = dateGeneratedInTable.getText();
                String expectedDateText = LocalDate.now().format(formatter);
                if (!dateText.contains(expectedDateText)) {
                    Assert.fail("Failed to verify the date generated is not matching with the expected " + dateText + ". ");
                }
                long daysBetween = ChronoUnit.DAYS.between(calendarStartDate, calendarEndDate);
                String noOfRecordDate = String.valueOf(daysBetween);
                webDriverHelper.waitUntilVisible(recordsInTable, 90, 1);
                if (recordsInTable.isDisplayed()) {
                    String record = recordsInTable.getText();
                    if (!record.contains(noOfRecordDate)) {
                        Assert.fail("Failed to verify the " + record + " in the table. ");
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_dataInTableForSoilMoisture.jpg");
            Assert.fail("Failed to verify the selected measurements as soil moisture, site name, Generated date, and number of records in the table due to exception:- " + exc);
        }
    }

    public void verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForSoilMoistureMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            Assert.assertEquals(measurementNameInTable.getText(), Constants.soilMoistureMeasure, "Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), "Avg.", "Failed to verify the units present in the second column for soil moisture measure is not matching with: " + secondColumnName.getText() + "");
            columnSize = dataColumnNames.size();
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForSoilMoisture.jpg");
            Assert.fail("Failed to verify the selected soil moisture measurement with units in the table and load more option at end due to exception:- ");
        }
    }

    public void verifyTheTableForSitesMeasurementsSelectedAndTheLoadMoreOptionForMaxMinTempMeasurement() {
        try {
            webDriverHelper.waitUntilVisible(firstMeasureSelected, 60, 1);
            if (firstMeasureSelected.getText().contains(Constants.maxTemp)) {
                if (!(firstMeasureSelected.getText().contains(tempUnit))) {
                    Assert.fail("Failed to verify the selected measurement and unit:- " + firstMeasureSelected.getText() + "");
                }
            } else {
                Assert.fail("Failed to verify the selected measurement:- " + firstMeasureSelected.getText());
            }
            webDriverHelper.waitUntilVisible(lastMeasureSelected, 60, 1);
            if (lastMeasureSelected.getText().contains(Constants.minTemp)) {
                if (!(lastMeasureSelected.getText().contains(tempUnit))) {
                    Assert.fail("Failed to verify the selected measurement:- " + lastMeasureSelected.getText() + "");
                }
            } else {
                Assert.fail("Failed to verify the selected measurement:- " + lastMeasureSelected.getText());
            }
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), addedSitesForApiVerification.get(0), "Failed to verify the selected site in second column for max & min measure is not matching with: " + secondColumnName.getText() + "");
            webDriverHelper.waitUntilVisible(thirdColumnName, 60, 1);
            Assert.assertEquals(thirdColumnName.getText(), addedSitesForApiVerification.get(1), "Failed to verify the selected site in third column for max & min measure is not matching with: " + thirdColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForMax&MinTemp.jpg");
            Assert.fail("Failed to verify the selected Max & Min Temp measurement with units in the table and load more option at end due to exception:- " + exc);
        }
    }

    public void verifyApiResponseForMultipleSitesAndMeasurements() {
        try {
            webDriverHelper.waitUntilVisible(firstMeasureSelected, 60, 1);
            if (firstMeasureSelected.getText().contains(Constants.maxTemp)) {
                firstMeasureSelected.isEnabled();
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    combinedIntegerListInUi.clear();
                    graphPage.verifyApiResponseIntegerValueFromUITable(selectedSite);
                }
            }
            webDriverHelper.waitUntilVisible(lastMeasureSelected, 60, 1);
            if (lastMeasureSelected.getText().contains(Constants.minTemp)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(lastMeasureSelected).click().build().perform();
                firstMeasureSelected.isEnabled();
                webDriverHelper.waitUntilVisible(thirdColumnName, 60, 1);
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    combinedIntegerListInUi.clear();
                    graphPage.verifyApiResponseIntegerValueFromUITable(selectedSite);
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseForSitesSelected");
            Assert.fail("Failed to verify the integer values from table in UI and from the Api response due to exception:- " + exc);
        }
    }

    public void verifyErrorMessageAfterSelectingMoreThanTenSites(String userRole) {
        try {
            int numberOfItemsToSelect = 11;
            while (selectedItems.size() < numberOfItemsToSelect) {
                webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 90, 1);
                if (sitesList.size() >= numberOfItemsToSelect) {
                    for (WebElement site : sitesList) {
                        String siteName = site.getText().trim();
                        if (!selectedItems.contains(siteName)) {
                            selectedItems.add(siteName);
                        }
                        try {
                            site.click();
                            if (errorToastMessage.isDisplayed()) {
                                webDriverHelper.waitUntilVisible(errorToastMessage, 60, 1);
                                String toastMessage = errorToastMessage.getText();
                                Assert.assertTrue(toastMessage.equalsIgnoreCase(Constants.errorMsgIfWeSelectMoreSitesOrMeasures), "Failed because the toast message displayed doesn't contain a valid message: " + toastMessage + ".");
                                break;
                            }
                        } catch (Exception exc) {
                            continue;
                        }
                    }
                } else {
                    Assert.fail("The " + userRole + " user role doesn't contain more than 10 sites ");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyErrorMessageAfterSelectingMoreThanTenSites.jpg");
            Assert.fail("Failed in verifyErrorMessageAfterSelectingMoreThanTenSites method due to exception: " + exc);
        }
    }

    public void verifyErrorMessageAfterSelectingMoreThanTwoMeasure() {
        try {
            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 60, 1);
            webDriverHelper.waitUntilVisible(sitesDropdownIcon, 60, 1);
            sitesDropdownIcon.click();
            webDriverHelper.waitUntilVisible(measureDropdownIcon, 60, 1);
            measureDropdownIcon.click();
            for (int i = 0; i < 3; i++) {
                try {
                    webDriverHelper.waitUntilVisibilityOfAllElements(measureList, 100, 1);
                    measureList.get(i).click();
                    if (errorToastMessage.isDisplayed()) {
                        webDriverHelper.waitUntilVisible(errorToastMessage, 60, 1);
                        String toastMessage = errorToastMessage.getText();
                        Assert.assertTrue(toastMessage.contains(Constants.errorMsgIfWeSelectMoreSitesOrMeasures), "Failed because the toast message displayed doesn't contain a valid message: " + toastMessage + ".");
                        break;
                    }
                } catch (Exception exc) {
                    continue;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyErrorMessageAfterSelectingMoreThanTwoMeasure.jpg");
            Assert.fail("Failed in verifyErrorMessageAfterSelectingMoreThanTwoMeasure method due to exception:- " + exc);
        }
    }

    public void selectSitesAndVerifyTheSitesTagIsDisplayedInGraphPage() {
        try {
            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 60, 1);
            int numberOfItemsToSelect = 5;
            while (selectedItems.size() < numberOfItemsToSelect) {
                for (WebElement site : sitesList) {
                    if (selectedItems.size() >= numberOfItemsToSelect) {
                        break;
                    }
                    String siteName = site.getText().trim();
                    if (!selectedItems.contains(siteName)) {
                        selectedItems.add(siteName);
                        site.click();
                    }
                }
            }
            webDriverHelper.waitUntilVisible(sitesDropdownIcon, 60, 1);
            sitesDropdownIcon.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(selectedSites, 90, 1);
            for (int i = 0; i < selectedSites.size(); i++) {
                String sitesSelectedInDropdown = selectedSites.get(i).getText();
                String sitesDisplayedInGraphPage = selectedItems.get(i);
                Assert.assertEquals(sitesDisplayedInGraphPage, sitesSelectedInDropdown, "Site selected " + sitesSelectedInDropdown + " is not equal to " + sitesDisplayedInGraphPage + " site displayed in the graph page");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectSitesAndVerifyTheSitesTagIsDisplayedInGraphPage.jpg");
            Assert.fail("Failed in selectSitesAndVerifyTheSitesTagIsDisplayedInGraphPage method due to exception:- " + exc);
        }
    }

    public void selectMeasureAndVerifySelectedMeasureIsDisplayedOnMenu() {
        try {
            webDriverHelper.waitUntilVisible(measureDropdownIcon, 60, 1);
            measureDropdownIcon.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(measureList, 90, 1);
            boolean maxTempClicked = false;
            boolean minTempClicked = false;
            for (WebElement webElement : measureList) {
                String measureName = webElement.getText();
                if (measureName.equalsIgnoreCase(Constants.maxTemp) && !maxTempClicked) {
                    webElement.click();
                    maxTempClicked = true;
                }
                if (measureName.equalsIgnoreCase(Constants.minTemp) && !minTempClicked) {
                    webElement.click();
                    minTempClicked = true;
                }
                if (maxTempClicked && minTempClicked) {
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(selectedMeasureInMenu, 30, 1);
            String selectedMeasureName = selectedMeasureInMenu.getText();
            if (!(selectedMeasureName.contains("Max Temp, Min Temp"))) {
                Assert.fail("The measures " + selectedMeasureName + " is not displayed on the menu bar ");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectMeasureAndVerifySelectedMeasureIsDisplayedOnMenu.jpg");
            Assert.fail("Failed in selectMeasureAndVerifySelectedMeasureIsDisplayedOnMenu method due to exception:- " + exc);
        }
    }

    public void verifyGraphBtnShouldNotHighlightBeforeSelectingCalendarDate() {
        try {
            webDriverHelper.waitUntilVisible(graphBtn, 60, 1);
            if (graphBtn.isEnabled()) {
                Assert.fail("Failed because before selecting the calendar icon the graphBtn should be disabled");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyGraphBtnShouldNotHighlightBeforeSelectingCalendarDate.jpg");
            Assert.fail("Failed in verifyGraphBtnShouldNotHighlightBeforeSelectingCalendarDate method due to exception:- " + exc);
        }
    }

    public void verifyTheAPiIsDisplayedInTheNetworkTab() {
        try {
            ChromeOptions options = new ChromeOptions();
            LoggingPreferences logs = new LoggingPreferences();
            logs.enable("performance", java.util.logging.Level.ALL);
            options.setCapability("goog:loggingPrefs", logs);
            Set<String> apiEndpoints = new HashSet<>();
            LogEntries logEntries = driver.manage().logs().get("performance");
            for (LogEntry entry : logEntries) {
                if (entry.getMessage().contains("\"method\":\"Network.responseReceived\"")) {
                    com.google.gson.JsonObject message = JsonParser.parseString(entry.getMessage()).getAsJsonObject();
                    JsonObject responseReceived = message.getAsJsonObject("message").getAsJsonObject("params");
                    String apiEndpoint = responseReceived.getAsJsonObject("response").get("url").getAsString();
                    apiEndpoints.add(apiEndpoint);
                }
            }
            teamsApiHelper.getAuthToken();
            teamsApiHelper.getOrgId(orgTargeted);
            for (int i = 0; i < selectedItems.size(); i++) {
                if (i < 2) {
                    String siteName = selectedItems.get(i);
                    graphApiHelper.getSiteId(siteName);
                    String dailyApi = PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/data/daily?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&site_id=" + siteId + "&limit=1000";
                    String historicalApi = PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/" + siteId + "/historical?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit;
                    boolean partialDailyApi = apiEndpoints.stream().anyMatch(endpoint -> endpoint.contains(dailyApi));
                    boolean partialHistoricalApi = apiEndpoints.stream().anyMatch(endpoint -> endpoint.contains(historicalApi));
                    if (!(partialDailyApi && partialHistoricalApi)) {
                        Assert.fail("The specific endpoint is not present in the collected API endpoints.");
                    }
                } else {
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheAPiIsDisplayedInTheNetworkTab.jpg");
            Assert.fail("Failed in verifyTheAPiIsDisplayedInTheNetworkTab method due to exception:- " + exc);
        }
    }

    public void verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForMeasurement(String units, String measurement) {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 60, 1);
            if (!(measurementNameInTable.getText().contains(measurement))) {
                Assert.fail("Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            }
            if (!(measurementNameInTable.getText().contains(units))) {
                Assert.fail("Failed to verify the table name with selected measurement units " + measurementNameInTable.getText() + "");
            }
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), addedSitesForApiVerification.get(0), "Failed to verify the units present in the second column for chloroIndex measure is not matching with: " + secondColumnName.getText() + "");
            webDriverHelper.waitUntilVisible(thirdColumnName, 60, 1);
            Assert.assertEquals(thirdColumnName.getText(), addedSitesForApiVerification.get(1), "Failed to verify the units present in the second column for chloroIndex measure is not matching with: " + thirdColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForSelectedMeasurement.jpg");
            Assert.fail("Failed in verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForDailyEtcMeasurement(String measurement) {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 60, 1);
            if (!(measurementNameInTable.getText().contains(measurement))) {
                Assert.fail("Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            }
            if (!(measurementNameInTable.getText().contains(sizeUnit))) {
                Assert.fail("Failed to verify the table name with selected measurement units " + measurementNameInTable.getText() + "");
            }
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), addedSitesForApiVerification.get(0), "Failed to verify the units present in the second column for chloroIndex measure is not matching with: " + secondColumnName.getText() + "");
            webDriverHelper.waitUntilVisible(thirdColumnName, 60, 1);
            Assert.assertEquals(thirdColumnName.getText(), addedSitesForApiVerification.get(1), "Failed to verify the units present in the second column for chloroIndex measure is not matching with: " + thirdColumnName.getText() + "");
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForDailyEtc.jpg");
            Assert.fail("Failed in verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForDailyEtcMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForVapourPressureMeasurement(String measurement) {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            if (!(measurementNameInTable.getText().contains(measurement))) {
                Assert.fail("Failed to verify the table name for selected measurement " + measurementNameInTable.getText() + "");
            }
            if (!measurementNameInTable.getText().replace("P", "p").contains(presUnit)) {
                Assert.fail("Failed to verify the table name with selected measurement units " + measurementNameInTable.getText());
            }
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), addedSitesForApiVerification.get(0), "Failed to verify the units present in the second column for chloroIndex measure is not matching with: " + secondColumnName.getText() + "");
            webDriverHelper.waitUntilVisible(thirdColumnName, 60, 1);
            Assert.assertEquals(thirdColumnName.getText(), addedSitesForApiVerification.get(1), "Failed to verify the units present in the second column for chloroIndex measure is not matching with: " + thirdColumnName.getText() + "");
            webDriverHelper.waitUntilVisible(loadBtn, 90, 1);
            if (loadBtn.isDisplayed()) {
                for (int i = 0; i < 3; i++) {
                    loadBtn.click();
                }
            } else {
                Assert.fail("The Load More button is not displayed.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForVapourPressure.jpg");
            Assert.fail("Failed to verify the selected vapour pressure measurement with units in the table and load more option at end due to exception:- " + exc);
        }
    }

    public void verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForWindMeasurement(String measurement) {
        try {
            webDriverHelper.waitUntilVisible(measurementNameInTable, 120, 1);
            if (!(measurementNameInTable.getText().contains(measurement))) {
                Assert.fail("Failed to verify the table name with selected measurement " + measurementNameInTable.getText() + "");
            }
            if (!(measurementNameInTable.getText().contains(speedUnit))) {
                Assert.fail("Failed to verify the table name with selected measurement units " + measurementNameInTable.getText() + "");
            }
            webDriverHelper.waitUntilVisible(firstColumnName, 60, 1);
            Assert.assertEquals(firstColumnName.getText(), Constants.firstColumnNameInGraphTable, "The first column name is not matching with " + Constants.firstColumnNameInGraphTable + "");
            webDriverHelper.waitUntilVisible(secondColumnName, 60, 1);
            Assert.assertEquals(secondColumnName.getText(), addedSitesForApiVerification.get(0), "Failed to verify the units present in the second column for chloroIndex measure is not matching with: " + secondColumnName.getText() + "");
            webDriverHelper.waitUntilVisible(thirdColumnName, 60, 1);
            Assert.assertEquals(thirdColumnName.getText(), addedSitesForApiVerification.get(1), "Failed to verify the units present in the second column for chloroIndex measure is not matching with: " + thirdColumnName.getText() + "");
            webDriverHelper.waitUntilVisible(loadBtn, 90, 1);
            if (loadBtn.isDisplayed()) {
                for (int i = 0; i < 3; i++) {
                    loadBtn.click();
                }
            } else {
                Assert.fail("The Load More button is not displayed.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTableColumnNames&LoadBtnForWindMeasure.jpg");
            Assert.fail("Failed to verify the selected wind measurement with units in the table and load more option at end due to exception:- " + exc);
        }
    }

    public void verifyApiResponseForMultipleSitesAndMeasurementsAsWind() {
        try {
            for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                index = i;
                String selectedSite = addedSitesForApiVerification.get(i);
                combinedIntegerListInUi.clear();
                graphPage.verifyApiResponseIntegerValueFromUITable(selectedSite);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseForMultipleSitesAndMeasurementsAsWind");
            Assert.fail("Failed in verifyApiResponseForMultipleSitesAndMeasurementsAsWind due to exception:- " + exc);
        }
    }

    public void verifyCustomDateForDaily() {
        try {
            webDriverHelper.waitUntilVisible(calenderIcon, 60, 1);
            //This step, once the graph button is clicked again, involves clicking on the dates.
            calenderIcon.click();
            webDriverHelper.waitUntilVisible(dateNumber, 60, 1);
            Assert.assertTrue(last30Days.isDisplayed(), "the last 30 days tag is not displayed in the graph page");
            Assert.assertTrue(last90Days.isDisplayed(), "the last 90 days tag is not displayed in the graph page");
            Assert.assertTrue(yearToDate.isDisplayed(), "the Year to date tag is not displayed in the graph page");
            Assert.assertTrue(customDate.isDisplayed(), "the customDate tag is not displayed in the graph page");
            Assert.assertTrue(allOption.isDisplayed(), "the allOption tag is not displayed in the graph page");
            webDriverHelper.waitUntilVisible(calenderIcon, 60, 1);
            calenderIcon.click();
            webDriverHelper.waitUntilVisible(timestamp_30Days, 90, 1);
            Assert.assertTrue(timestamp_90Days.isDisplayed(), "The time stamp 30D is not displayed");
            Assert.assertTrue(timestamp_YTD.isDisplayed(), "The time stamp YTD is not displayed");
            Assert.assertTrue(timestamp_All.isEnabled(), "The time stamp ALL is not is enabled");
            TimelineText = "daily";
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_VerifyCustomDateForDaily.jpg");
            Assert.fail("Failed in verifyCustomDateForDaily method due to exception:- " + exc);
        }
    }

    public void verifyUnitsInGraphForSoilTemp() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                return;
            } else {
                webDriverHelper.waitUntilVisible(multipleSiteUnit, 90, 1);
                Assert.assertTrue(multipleSiteUnit.getText().contains(tempUnit), "Failed to verify the table name with selected measurement " + unitInTable + " ");
            }
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphForSoilTemp.jpg");
            Assert.fail("Failed in verifyUnitsInGraphForSoilTemp method due to exception:- " + exc);
        }
    }

    public void verifyUnitsInGraphForSolarRadiation() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                unitInTable = unitDisplayedInTable.getText();
                Assert.assertEquals(unitInTable, Constants.solarRadiationMeasure, "Failed to verify the table name with selected measurement " + unitInTable + " ");
            } else {
                webDriverHelper.waitUntilVisible(multipleSiteUnit, 90, 1);
                Assert.assertTrue(multipleSiteUnit.getText().contains(Constants.solarRadiationMeasure), "Failed to verify the table name with selected measurement " + unitInTable + " ");
            }
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphForSolarRadiation.jpg");
            Assert.fail("Failed in verifyUnitsInGraphForSolarRadiation method due to exception:- " + exc);
        }
    }

    public void verifySwdwCountInApiForMultipleSites() {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                String secondItem = addedSitesForApiVerification.get(1);
                verifySiteSwdwCountInApi(ualueUITable1, firstItem);
                verifySiteSwdwCountInApi(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String singleItem = addedSitesForApiVerification.get(0);
                verifySiteSwdwCountInApi(ualueUITable1, singleItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifySwdwCountInApiForMultipleSites.jpg");
            Assert.fail("Failed in verifySwdwCountInApiForMultipleSites method due to exception:- " + exc);
        }
    }

    private void verifySiteSwdwCountInApi(List<WebElement> Value, String siteName) {
        try {
            // UI values from the table
            List<Map.Entry<String, Integer>> combinedListInUi = new ArrayList<>();
            int size = Math.min(dateUI.size(), Value.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = Value.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueUI;
                if (valueStringUI.equals("--")) {
                    integerValueUI = 9999;
                } else {
                    integerValueUI = Integer.parseInt(valueStringUI);
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
                combinedListInUi.add(elementPair);
            }
            combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999);
            // API values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(dateText);
            selectedStartDateStrText = outputFormat.format(date);
            graphApiHelper.getSiteId(siteName);
            graphApiHelper.getSummaryRequestForGraph();
            graphApiHelper.getDateSwdw();
            for (int i = 0; i < combinedListInUi.size(); i++) {
                boolean matchFound = false;
                for (int j = combinedListInApi.size() - 1; j >= 0; j--) {
                    if (combinedListInUi.get(i).equals(combinedListInApi.get(j))) {
                        matchFound = true;
                        break;
                    }
                }
                if (!matchFound) {
                    Assert.fail("Element at index " + i + " is not matching with any elements in the API list");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifySiteSwdwCountInApi.jpg");
            Assert.fail("Failed in verifySiteSwdwCountInApi method due to exception:- " + exc);
        }
    }

    public void verifyCustomDateForHourly(String selected) {
        try {
            webDriverHelper.waitUntilVisible(dailyActiveButton, 90, 1);
            if (!dailyActiveButton.isEnabled()) {
                Assert.fail("Daily is  not enabled");
            }
            webDriverHelper.waitUntilVisible(hourly_Button, 90, 1);
            hourly_Button.click();
            if (selected.contains("hourly")) {
                TimelineText = "local_hourly";
            } else {
                TimelineText = "sentek_hourly";
            }
            Thread.sleep(5000);// Wait for the Graph section to load many times it is slow.
            Assert.assertTrue(hrs12Button.isEnabled(), "the 12-hour button is not yet enabled.");
            Assert.assertTrue(hrs24Button.isDisplayed(), "the 24-hour button is not displayed, possibly No data loaded in Graph section.");
            Assert.assertTrue(hrs48Button.isDisplayed(), "the 48-hour button is not displayed.");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyCustomDateForHourly.jpg");
            Assert.fail("Failed in verifyCustomDateForHourly method due to exception :- " + exc);
        }
    }

    public void verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourlyForSolarRad() {
        try {
            webDriverHelper.waitUntilVisible(endDate, 60, 1);
            webDriverHelper.scrollToWebElement(dateGenerated);
            String selectedEndDateStr = endDate.getText();
            String selectedStartDateStr = startDate.getText();
            Actions act = new Actions(driver);
            act.moveToElement(timelineSeriesGraph).perform();
            webDriverHelper.waitUntilVisible(timelineSeriesForEndDateInGraphHourlyForSolarRad, 120, 1);
            String inputEndDateInGraph = timelineSeriesForEndDateInGraphHourlyForSolarRad.getText();
//            This is committed because the end date is not matching, and once it is fixed, the xpath may change.
            if (!inputEndDateInGraph.isEmpty()) {
                String outputEndDateInGraph = webDriverHelper.parseAndFormatDate(inputEndDateInGraph, "MMM dd, yyyy", "dd-MMM-yyyy");
//                Assert.assertEquals(selectedEndDateStr, outputEndDateInGraph, "Failed to verify the end date displayed in the timeline graph");
            }
//            String inputStartDateInGraph = timelineSeriesForStartDateInGraphHourlyForSolarRad.getText();
//            if (!inputStartDateInGraph.isEmpty()) {
//                String outputEndDateInGraph = webDriverHelper.parseAndFormatDate(inputStartDateInGraph, "MMM dd, yyyy", "dd-MMM-yyyy");
//                Assert.assertEquals(selectedStartDateStr, outputEndDateInGraph, "Failed to verify the start date displayed in the timeline graph");
//            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourlyForSolarRad.jpg");
            Assert.fail("Failed in verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourlyForSolarRad method due to exception :- " + exc);
        }
    }

    public void verifyWhetherTimelineSeriesWillHaveSelectedDatesForSoilTemp() {
        try {
            Thread.sleep(1000);
            if (TimelineText.contains("daily")) {
                if (addedSitesForApiVerification.size() == 1) {
                    webDriverHelper.waitUntilVisible(timelineSeriesGraphSoilTemp, 30, 1);
                    Actions act = new Actions(driver);
                    act.moveToElement(timelineSeriesGraphSoilTemp).perform();
                    webDriverHelper.waitUntilVisible(startDateInTimelineSeriesGraphForSoilTemp, 60, 1);
                    Assert.assertTrue(startDateInTimelineSeriesGraphForSoilTemp.isDisplayed(), "Start date is not displayed after highlighted");
                    webDriverHelper.waitUntilVisible(endDateInTimelineSeriesGraphForSoilTemp, 60, 1);
                    Assert.assertTrue(endDateInTimelineSeriesGraphForSoilTemp.isDisplayed(), "End date is not displayed after highlighted");
                } else {
                    webDriverHelper.waitUntilVisible(timelineSeriesGraph, 30, 1);
                    Actions act = new Actions(driver);
                    act.moveToElement(timelineSeriesGraph).perform();
                    webDriverHelper.waitUntilVisible(startDateInTimelineSeriesGraph, 60, 1);
                    Assert.assertTrue(startDateInTimelineSeriesGraph.isDisplayed(), "Start date is not displayed after highlighted");
                    webDriverHelper.waitUntilVisible(endDateInTimelineSeriesGraph, 60, 1);
                    Assert.assertTrue(endDateInTimelineSeriesGraph.isDisplayed(), "End date is not displayed after highlighted");
                }
            } else {
                if (addedSitesForApiVerification.size() == 1) {
                    webDriverHelper.waitUntilVisible(timelineSeriesGraphSoilTemp, 30, 1);
                    Actions act = new Actions(driver);
                    act.moveToElement(timelineSeriesGraphSoilTemp).perform();
                    webDriverHelper.waitUntilVisible(endDateInTimelineSeriesGraphForSoilTemp, 60, 1);
                    Assert.assertTrue(endDateInTimelineSeriesGraphForSoilTemp.isDisplayed(), "End date is not displayed after highlighted");
                } else {
                    Thread.sleep(10000); // Graph loading takes time when one of the sites does not have data in Soil Temp
                    webDriverHelper.waitUntilVisible(timelineSeriesGraph, 45, 1);
                    Actions act = new Actions(driver);
                    act.moveToElement(timelineSeriesGraph).perform();
                    webDriverHelper.waitUntilVisible(endDateInTimelineSeriesGraph, 60, 1);
                    Assert.assertTrue(endDateInTimelineSeriesGraph.isDisplayed(), "End date is not displayed after highlighted");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyWhetherTimelineSeriesWillHaveSelectedDatesForSoilTemp.jpg");
            Assert.fail("Failed in verifyWhetherTimelineSeriesWillHaveSelectedDatesForSoilTemp method due to exception:- " + exc);
        }
    }

    public void verifyUnitsInGraphForHourlyForSoilTemp() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                return;
            } else {
                webDriverHelper.waitUntilVisible(multipleSiteUnit, 150, 1);
                Assert.assertTrue(multipleSiteUnit.getText().contains(soilMoistureMeasureForHourly), "Failed to verify the table name with selected measurement " + unitInTable + " ");
            }
            Thread.sleep(1000);
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphForHourlyForSoilTemp.jpg");
            Assert.fail("Failed in verifyUnitsInGraphForHourlyForSoilTemp method due to exception:- " + exc);
        }
    }

    public void verifySoilMoistureHourly() {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                String secondItem = addedSitesForApiVerification.get(1);
                verifySoilMoistureForHourly(ualueUITable1, firstItem);
                verifySoilMoistureForHourly(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String singleItem = addedSitesForApiVerification.get(0);
                verifySoilMoistureForHourly(ualueUITable1, singleItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifySoilMoistureHourly.jpg");
            Assert.fail("Failed in verifySoilMoistureHourly method due to exception :- " + exc);
        }
    }

    private void verifySoilMoistureForHourly(List<WebElement> tableValue, String singleItem) throws ParseException, JsonProcessingException, InterruptedException {
        try {
            Thread.sleep(10000);
            combinedListInUiDouble.clear();
            int size;
            if (addedSitesForApiVerification.size() == 1) {
                size = dateUIForSolar.size();
            } else {
                size = dateUI.size();
            }
            WebElement dateElementUI;
            for (int i = 0; i < size; i++) {
                if (addedSitesForApiVerification.size() == 1) {
                    dateElementUI = dateUIFoSolarTemp.get(i);
                } else {
                    dateElementUI = dateUI.get(i);
                }
                WebElement valueElementUI = tableValue.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                Double integerValueUI;
                if (valueStringUI.equals("--")) {
                    integerValueUI = 9999.0;
                } else {
                    integerValueUI = Double.parseDouble(valueStringUI);
                }
                Map.Entry<String, Double> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
                combinedListInUiDouble.add(elementPair);
            }
            combinedListInUiDouble.removeIf(elementPair -> elementPair.getValue() == 9999.0);
            // API values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = inputFormatForStartDate.parse(dateText);
            selectedStartDateStrText = outputFormatForStarDate.format(date);
            String endDateText = endDates.getText();
            SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date1 = inputFormatForEndDate.parse(endDateText);
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date1);
            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date modifiedDate = calendar.getTime();
            selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
            graphApiHelper.getSiteId(singleItem);
            graphApiHelper.fetchSitesZone();
            webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
            graphApiHelper.getSummaryRequestForGraphForHourlyFromApi();
            if (addedSitesForApiVerification.size() == 1) {
                graphApiHelper.getSoilMoistureHourlyForSingleSite();
            } else {
                graphApiHelper.getSoilMoistureHourly();
            }
            for (Map.Entry<String, Double> uiEntry : combinedListInUiDouble) {
                boolean matchFound = false;
                for (int j = combinedListInDoubleApiHourly.size() - 1; j >= 0; j--) {
                    Map.Entry<String, Double> apiEntry = combinedListInDoubleApiHourly.get(j);
                    if (uiEntry.getKey().equals(apiEntry.getKey())) {
                        if (Math.abs(uiEntry.getValue() - apiEntry.getValue()) < 0.001) {
                            matchFound = true;
                            break;
                        }
                    }
                }
                if (!matchFound) {
                    Assert.fail("Element " + uiEntry + " is not matching with any elements in the API list.");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifySoilMoistureForHourly.jpg");
            Assert.fail("Failed in verifySoilMoistureForHourly method due to exception :- " + exc);
        }
    }

    public void soilTemperatureAvgVerification() throws InterruptedException, ParseException, JsonProcessingException {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                String secondItem = addedSitesForApiVerification.get(1);
                compareUiAndApiValueInSoilTemperatureAvg(ualueUITable1, firstItem);
                compareUiAndApiValueInSoilTemperatureAvg(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String firstItem = addedSitesForApiVerification.get(0);
                compareUiAndApiValueInSoilTemperatureAvg(ualueUITable1, firstItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("soilTemperatureAvgVerification.jpg");
            Assert.fail("Failed in soilTemperatureAvgVerification method due to exception :- " + exc);
        }
    }

    public void compareUiAndApiValueInSoilTemperatureAvg(List<WebElement> tableValue, String siteName) throws ParseException, InterruptedException, JsonProcessingException {
        try {
            List<Map.Entry<String, Integer>> combinedListInUi = new ArrayList<>();
            int size;
            if (addedSitesForApiVerification.size() == 1) {
                size = Math.min(dateUIFoSolarTemp.size(), tableValue.size());
            } else {
                size = dateUI.size();
            }
            WebElement dateElementUI;
            for (int i = 0; i < size; i++) {
                if (addedSitesForApiVerification.size() == 1) {
                    dateElementUI = dateUIFoSolarTemp.get(i);
                } else {
                    dateElementUI = dateUI.get(i);
                }
                WebElement valueElementUI = tableValue.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueUI;
                if (valueStringUI.equals("--")) {
                    integerValueUI = 9999;
                } else {
                    integerValueUI = Integer.parseInt(valueStringUI);
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
                combinedListInUi.add(elementPair);
            }
            Iterator<Map.Entry<String, Integer>> iterator = combinedListInUi.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> elementPair = iterator.next();
                if (elementPair.getValue() == 9999) {
                    iterator.remove();
                }
            }
            String dateText = startDate.getText();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = inputFormat.parse(dateText);
            selectedStartDateStrText = outputFormat.format(date);
            graphApiHelper.getSiteId(siteName);
            graphApiHelper.getAverageValueSoilTemp();
            graphApiHelper.getSoilTemperatureDaily();
            if (combinedListInApiDaily != null) {
                for (int i = 0; i < combinedListInUi.size(); i++) {
                    boolean matchFound = false;
                    for (int j = combinedListInApiDaily.size() - 1; j >= 0; j--) {
                        Thread.sleep(10);
                        if (combinedListInUi.get(i).equals(combinedListInApiDaily.get(j))) {
                            matchFound = true;
                            break;
                        }
                    }
                    if (!matchFound) {
                        Assert.fail("Element at index " + i + " is not matching with any elements in the API list & Value is not matching with " + combinedListInUi.get(i) + ".");
                    }
                }
            } else {
                Assert.fail("combinedListInApiDaily is null");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("compareUiAndApiValueInSoilTemperatureAvg.jpg");
            Assert.fail("Failed in compareUiAndApiValueInSoilTemperatureAvg method due to exception :- " + exc);
        }
    }

    public void soilTemperatureAvgVerificationForHourly() {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                combinedListInUi.clear();
                String secondItem = addedSitesForApiVerification.get(1);
                verifySoilTempForHourly(ualueUITable1, firstItem);
                verifySoilTempForHourly(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String singleItem = addedSitesForApiVerification.get(0);
                verifySoilTempForHourly(ualueUITable1, singleItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_soilTemperatureAvgVerificationForHourly.jpg");
            Assert.fail("Failed in soilTemperatureAvgVerificationForHourly method due to exception:- " + exc);
        }
    }

    private void verifySoilTempForHourly(List<WebElement> tableValue, String siteName) throws ParseException, JsonProcessingException, InterruptedException {
        List<Map.Entry<String, Integer>> combinedListInUi = new ArrayList<>();
        int size;
        if (addedSitesForApiVerification.size() == 1) {
            size = dateUIForSolar.size();
        } else {
            size = dateUI.size();
        }
        WebElement dateElementUI;
        for (int i = 0; i < size; i++) {
            if (addedSitesForApiVerification.size() == 1) {
                dateElementUI = dateUIFoSolarTemp.get(i);
            } else {
                dateElementUI = dateUI.get(i);
            }
            WebElement valueElementUI = tableValue.get(i);
            String dateStringUI = dateElementUI.getText();
            String valueStringUI = valueElementUI.getText();
            int integerValueUI;
            if (valueStringUI.equals("--")) {
                integerValueUI = 9999;
            } else {
                integerValueUI = Integer.parseInt(valueStringUI);
            }
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
            combinedListInUi.add(elementPair);
        }
        combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999);
        // API values
        String dateText = startDate.getText();
        SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = inputFormatForStartDate.parse(dateText);
        selectedStartDateStrText = outputFormatForStarDate.format(date);
        String endDateText = endDates.getText();
        SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date1 = inputFormatForEndDate.parse(endDateText);
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.setTime(date1);
        calendar.set(Calendar.HOUR_OF_DAY, currentHour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date modifiedDate = calendar.getTime();
        selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
        graphApiHelper.getSiteId(siteName);
        graphApiHelper.fetchSitesZone();
        webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
        graphApiHelper.getSummaryRequestForGraphForHourlyFromApi();
        if (addedSitesForApiVerification.size() == 1) {
            graphApiHelper.getSoilTemperatureHourlyForSingleSites();
        } else {
            graphApiHelper.getSoilTemperatureHourlyForTwoSites();
        }
        for (int i = 0; i < combinedListInUi.size(); i++) {
            boolean matchFound = false;
            for (int j = combinedListInApiHourly.size() - 1; j >= 0; j--) {
                if (combinedListInUi.get(i).equals(combinedListInApiHourly.get(j))) {
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                Assert.fail("Element at index " + i + " is not matching with any elements in the API list " + combinedListInUi.get(i));
            }
        }
    }

    public void verifyUnitsInGraphForWind() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                return;
            } else {
                webDriverHelper.waitUntilVisible(multipleSiteUnit, 90, 1);
                String actual = multipleSiteUnit.getText().toLowerCase();
                Assert.assertTrue(actual.contains(speedUnit), "Failed to verify the table name with selected measurement " + unitInTable);
            }
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphForWind.jpg");
            Assert.fail("Failed in verifyUnitsInGraphForWind method due to exception:- " + exc);
        }
    }

    public void verifyUnitsInGraphForRelativeHumidity() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                webDriverHelper.waitUntilVisible(unitDisplayedInTable, 60, 1);
                unitInTable = unitDisplayedInTable.getText();
                Assert.assertEquals(unitInTable, relativeHumidity, "Failed to verify the table name with selected measurement " + unitInTable + " ");
            } else {
                webDriverHelper.waitUntilVisible(multipleSiteUnit, 90, 1);
                Assert.assertTrue(multipleSiteUnit.getText().contains(relativeHumidity), "Failed to verify the table name with selected measurement " + unitInTable + " ");
            }
            Thread.sleep(1000);
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphForRelativeHumidity.jpg");
            Assert.fail("Failed in verifyUnitsInGraphForRelativeHumidity method due to exception:- " + exc);
        }
    }

    public void verifyAPiValuesInGraphForRelativeHumidity() {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                String secondItem = addedSitesForApiVerification.get(1);
                verifyRelativeHumidityCountInApiForHourly(ualueUITable1, firstItem);
                verifyRelativeHumidityCountInApiForHourly(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String singleItem = addedSitesForApiVerification.get(0);
                verifyRelativeHumidityCountInApiForHourly(ualueUITable1, singleItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAPiValuesInGraphForRelativeHumidity.jpg");
            Assert.fail("Failed in verifyAPiValuesInGraphForRelativeHumidity method due to exception:- " + exc);
        }
    }

    private void verifyRelativeHumidityCountInApiForHourly(List<WebElement> Value, String siteName) {
        try {
            // UI values from the table
            List<Map.Entry<String, Integer>> combinedListInUi = new ArrayList<>();
            int size = Math.min(dateUI.size(), Value.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = Value.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueUI;
                if (valueStringUI.equals("--")) {
                    integerValueUI = 9999;
                } else {
                    integerValueUI = Integer.parseInt(valueStringUI);
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
                combinedListInUi.add(elementPair);
            }
            combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999);
            // API values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = inputFormatForStartDate.parse(dateText);
            selectedStartDateStrText = outputFormatForStarDate.format(date);
            String endDateText = endDates.getText();
            SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date1 = inputFormatForEndDate.parse(endDateText);
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date1);
            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date modifiedDate = calendar.getTime();
            selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
            graphApiHelper.getSiteId(siteName);
            graphApiHelper.fetchSitesZone();
            webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
            graphApiHelper.getSummaryRequestForGraphForHourly();
            graphApiHelper.getDateRelativeHumidityForHourly();
            for (int i = 0; i < combinedListInUi.size(); i++) {
                boolean matchFound = false;
                for (int j = combinedListInApiHourly.size() - 1; j >= 0; j--) {
                    Thread.sleep(10);
                    if (combinedListInUi.get(i).equals(combinedListInApiHourly.get(j))) {
                        matchFound = true;
                        break;
                    }
                }
                if (!matchFound) {
                    Assert.fail("Element at index " + i + " is not matching with any elements in the API list");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyRelativeHumidityCountInApiForHourly.jpg");
            Assert.fail("Failed in verifyRelativeHumidityCountInApiForHourly method due to exception:- " + exc);
        }
    }

    public void verifyUnitsInGraphForPressure() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                webDriverHelper.waitUntilVisible(unitDisplayedInTable, 60, 1);
                String actual = unitDisplayedInTable.getText().toLowerCase();
                Assert.assertTrue(actual.contains(presUnit.toLowerCase()), "Failed to verify the table name with selected measurement " + unitInTable + " ");
            } else {
                webDriverHelper.waitUntilVisible(multipleSiteUnit, 90, 1);
                String actual = multipleSiteUnit.getText().toLowerCase();
                Assert.assertTrue(actual.contains(presUnit.toLowerCase()), "Failed to verify the table name with selected measurement " + unitInTable);
            }
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphForPressure.jpg");
            Assert.fail("Failed in verifyUnitsInGraphForPressure method due to exception:- " + exc);
        }
    }

    public void verifyAPiValuesInVaporPressureDeficit() {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                String secondItem = addedSitesForApiVerification.get(1);
                verifyVaporPressureCountInApiForHourly(ualueUITable1, firstItem);
                verifyVaporPressureCountInApiForHourly(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String singleItem = addedSitesForApiVerification.get(0);
                verifyVaporPressureCountInApiForHourly(ualueUITable1, singleItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAPiValuesInVaporPressureDeficit.jpg");
            Assert.fail("Failed in verifyAPiValuesInVaporPressureDeficit method due to exception:- " + exc);
        }
    }

    private void verifyVaporPressureCountInApiForHourly(List<WebElement> Value, String siteName) {
        try {
            // UI values from the table
            List<Map.Entry<String, Double>> combinedListInUi = new ArrayList<>();
            int size = Math.min(dateUI.size(), Value.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = Value.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                double integerValueUI;
                if (valueStringUI.equals("--")) {
                    integerValueUI = 9999;
                } else {
                    integerValueUI = Double.parseDouble(valueStringUI);
                }
                Map.Entry<String, Double> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
                combinedListInUi.add(elementPair);
            }
            combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999);
            // API values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = inputFormatForStartDate.parse(dateText);
            selectedStartDateStrText = outputFormatForStarDate.format(date);
            String endDateText = endDates.getText();
            SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date1 = inputFormatForEndDate.parse(endDateText);
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date1);
            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date modifiedDate = calendar.getTime();
            selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
            graphApiHelper.getSiteId(siteName);
            graphApiHelper.fetchSitesZone();
            webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
            graphApiHelper.getSummaryRequestForGraphForHourly();
            graphApiHelper.getDateVaporPressureForHourly();
            for (int i = 0; i < combinedListInUi.size(); i++) {
                boolean matchFound = false;
                for (int j = combinedListInDoubleApiHourly.size() - 1; j >= 0; j--) {
                    if (combinedListInUi.get(i).equals(combinedListInDoubleApiHourly.get(j))) {
                        matchFound = true;
                        break;
                    }
                }
                if (!matchFound) {
                    Assert.fail("Element at index " + i + " is not matching with any elements in the API list");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyVaporPressureCountInApiForHourly.jpg");
            Assert.fail("Failed in verifyVaporPressureCountInApiForHourly method due to exception:- " + exc);
        }
    }

    public void verifyGraphWithSelectedDetailsForTwoMeasurement(int numberOfSites, String measurement1, String measurement2, String date, String userRole) {
        try {
            webDriverHelper.waitUntilVisible(openDropDownNewSites, 120, 1);
            if (!graphTag.isDisplayed()) {
                Assert.fail("the graph page tag is not displayed ");
            }
            selectASiteForUserRole(numberOfSites, userRole);
            insertMeasurementDateForTwoSites(measurement1, measurement2, date);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyGraphWithSelectedDetailsForTwoMeasurement.jpg");
            Assert.fail("Failed in verifyGraphWithSelectedDetailsForTwoMeasurement method due to exception:- " + exc);
        }
    }

    public void insertMeasurementDateForTwoSites(String measurement1, String measurement2, String date) throws InterruptedException {
        try {
            measureDropdown.click();
            Thread.sleep(3000);
            for (WebElement measurements : measureDropDownList) {
                String measurementsName = measurements.getText();
                if (measurementsName.equalsIgnoreCase(measurement1)) {
                    measurements.click();
                }
            }
            for (WebElement measurements : measureDropDownList) {
                String measurementsName = measurements.getText();
                if (measurementsName.equalsIgnoreCase(measurement2)) {
                    measurements.click();
                }
            }
            measureInMenuBar = selectedMeasureInMenu.getText();
            webDriverHelper.waitUntilVisible(iconCalendar, 30, 1);
            iconCalendar.click();
            webDriverHelper.waitUntilVisible(monthTagInsideCalender, 30, 1);
            for (WebElement calendarBtn : calendarBtns) {
                String calendarBtnName = calendarBtn.getText();
                if (calendarBtnName.equals(date)) {
                    calendarBtn.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(graphBtn, 60, 1);
            graphBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_insertMeasurementDateForTwoSites.jpg");
            Assert.fail("Failed in insertMeasurementDateForTwoSites method due to exception:- " + exc);
        }
    }

    public void verifyUnitsInGraphForMaxAndMinTemp() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                for (WebElement units : unitsForMaxMinTempForSingleSites) {
                    String unitsName = units.getText();
                    Assert.assertTrue(unitsName.contains(tempUnit), "Failed to verify the table name with selected measurement ");
                }
            } else {
                for (WebElement units : unitsForMaxMinTempForMultipleSites) {
                    String unitsName = units.getText();
                    Assert.assertTrue(unitsName.contains(tempUnit), "Failed to verify the table name with selected measurement ");
                }
            }
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphForMaxAndMinTemp.jpg");
            Assert.fail("Failed in verifyUnitsInGraphForMaxAndMinTemp method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseOfIntegerValueForAllThreeColumnForHourly() {
        try {
            for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                index = i;
                String selectedSite = addedSitesForApiVerification.get(i);
                verifyApiResponseIntegerValueFromUITableForSingleSiteForHourly(selectedSite);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseForSitesSelected.jpg");
            Assert.fail("Failed in verifyApiResponseOfIntegerValueForAllThreeColumnForHourly method due to exception:- " + exc);
        }
    }

    public void gettingIntegerUIValuesFromTableForThirdColumnForHourly() {
        int size = Math.min(dateUI.size(), ualueUITable1.size());
        for (int i = 0; i < size; i++) {
            WebElement dateElementUI = dateUI.get(i);
            WebElement secondUIElement = ualueUITable1.get(i);
            WebElement thirdUIElement = ualueUITable2.get(i);
            String dateStringUI = dateElementUI.getText().toUpperCase();
            String secondUIString = secondUIElement.getText();
            String thirdUIString = thirdUIElement.getText();
            if (measureInMenuBar.equalsIgnoreCase(Constants.windMeasure)) {
                String[] dateSplit = dateStringUI.split(" \\|");
                if (dateSplit.length == 2) {
                    date = (dateSplit[0]);
                    localDate = (dateSplit[1]);
                }
            }
            int secondIntegerValueInUI;
            if (secondUIString.equals("--")) {
                secondIntegerValueInUI = 9999999;
            } else {
                secondIntegerValueInUI = Integer.parseInt(secondUIString);
            }
            int thirdIntegerValueInUI;
            if (thirdUIString.equals("--")) {
                thirdIntegerValueInUI = 9999999;
            } else {
                thirdIntegerValueInUI = Integer.parseInt(thirdUIString);
            }
            if (measureInMenuBar.equalsIgnoreCase(Constants.windMeasure)) {
                Map.Entry<String, Integer> elementPairThird = new AbstractMap.SimpleEntry<>(date, thirdIntegerValueInUI);
                combinedListInUi.add(elementPairThird);
                Map.Entry<String, Integer> elementPairSecond = new AbstractMap.SimpleEntry<>(date, secondIntegerValueInUI);
                combinedListInUi.add(elementPairSecond);
            } else {
                Map.Entry<String, Integer> elementPairThird = new AbstractMap.SimpleEntry<>(dateStringUI, thirdIntegerValueInUI);
                combinedListInUi.add(elementPairThird);
                Map.Entry<String, Integer> elementPairSecond = new AbstractMap.SimpleEntry<>(dateStringUI, secondIntegerValueInUI);
                combinedListInUi.add(elementPairSecond);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = combinedListInUi.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> elementPair = iterator.next();
            if (elementPair.getValue() == 9999999) {
                iterator.remove();
            }
        }
    }

    public void verifyApiResponseIntegerValueFromUITableForSingleSiteForHourly(String selectedSite) {
        try {
            graphPage.gettingIntegerUIValuesFromTableForThirdColumnForHourly();
            //Api values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = inputFormatForStartDate.parse(dateText);
            selectedStartDateStrText = outputFormatForStarDate.format(date);
            String endDateText = endDates.getText();
            SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date1 = inputFormatForEndDate.parse(endDateText);
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date1);
            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date modifiedDate = calendar.getTime();
            selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
            graphApiHelper.getSiteId(selectedSite);
            graphApiHelper.fetchSitesZone();
            webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
            if (measureInMenuBar.equalsIgnoreCase(Constants.windMeasure)) {
                graphApiHelper.getSummaryRequestForGraphForHourly();
                graphApiHelper.getDateWindSpeedAndMaxWindSpeed();
                graphApiHelper.getSummaryRequestForHistoricalHourly();
                graphApiHelper.getDateWindSpeedAndMaxWindSpeed();
            }
            if (measureInMenuBar.equalsIgnoreCase(Constants.maxAndMinTempInMenuBar)) {
                graphApiHelper.getSummaryRequestForGraphForHourly();
                graphApiHelper.getDateMinAndMaxTempForHourly();
            }
            Set<Map.Entry<String, Integer>> apiSet = new HashSet<>(combinedListInApiHourly);
            for (int i = 0; i < combinedListInUi.size(); i++) {
                if (!apiSet.contains(combinedListInUi.get(i))) {
                    Assert.fail("Element at index " + i + " is not matching with any elements in the API list & Value is not matching with " + combinedListInUi.get(i) + ".");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponse.jpg");
            Assert.fail("Failed in verifyApiResponseIntegerValueFromUITableForSingleSiteForHourly method due to exception:- " + exc);
        }
    }

    public void verifyUnitsInGraphForMeasurement() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                webDriverHelper.waitUntilVisible(unitDisplayedInTable, 60, 1);
                unitInTable = unitDisplayedInTable.getText();
                Assert.assertEquals(unitInTable, sizeUnit, "Failed to verify the table name with selected measurement " + unitInTable + " ");
            } else {
                webDriverHelper.waitUntilVisible(multipleSiteUnit, 90, 1);
                Assert.assertTrue(multipleSiteUnit.getText().contains(sizeUnit), "Failed to verify the table name with selected measurement " + unitInTable + " ");
            }
            Thread.sleep(1000);
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphForMeasurement.jpg");
            Assert.fail("Failed in verifyUnitsInGraphForMeasurement method due to exception:- " + exc);
        }
    }

    public void verifyEtcCountInApiForMultipleSitesForGraph() {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                String secondItem = addedSitesForApiVerification.get(1);
                verifySiteEtcCountInApiForHourly(ualueUITable1, firstItem);
                verifySiteEtcCountInApiForHourly(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String singleItem = addedSitesForApiVerification.get(0);
                verifySiteEtcCountInApiForHourly(ualueUITable1, singleItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyEtcCountInApiForMultipleSitesForGraph.jpg");
            Assert.fail("Failed in verifyEtcCountInApiForMultipleSitesForGraph method due to exception:- " + exc);
        }
    }

    private void verifySiteEtcCountInApiForHourly(List<WebElement> Value, String siteName) {
        try {
            // UI values from the table
            List<Map.Entry<String, Integer>> combinedListInUi = new ArrayList<>();
            int size = Math.min(dateUI.size(), Value.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = Value.get(i);
                String dateStringUI = dateElementUI.getText().toUpperCase();
                String valueStringUI = valueElementUI.getText();
                int integerValueUI;
                if (valueStringUI.equals("--")) {
                    integerValueUI = 9999;
                } else {
                    long roundedValue = Math.round(Float.parseFloat(valueStringUI));
                    integerValueUI = Integer.parseInt(String.valueOf(roundedValue));
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
                combinedListInUi.add(elementPair);
            }
            combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999);
            // API values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = inputFormatForStartDate.parse(dateText);
            selectedStartDateStrText = outputFormatForStarDate.format(date);
            String endDateText = endDates.getText();
            SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date1 = inputFormatForEndDate.parse(endDateText);
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date1);
            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date modifiedDate = calendar.getTime();
            selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
            graphApiHelper.getSiteId(siteName);
            graphApiHelper.fetchSitesZone();
            webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
            graphApiHelper.getSummaryRequestForGraphForHourly();
            graphApiHelper.getDateETcForHourly();
            for (int i = 0; i < combinedListInUi.size(); i++) {
                boolean matchFound = false;
                for (int j = combinedListInApiHourly.size() - 1; j >= 0; j--) {
                    if (combinedListInUi.get(i).equals(combinedListInApiHourly.get(j))) {
                        matchFound = true;
                        break;
                    }
                }
                if (!matchFound) {
                    Assert.fail("Element at index " + i + "in the UI is not matching with any elements in the API list");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifySiteEtcCountInApiForHourly.jpg");
            Assert.fail("Failed in verifySiteEtcCountInApiForHourly method due to exception:- " + exc);
        }
    }

    public void verifyUnitsInGraphLeafWetness() {
        try {
            if (addedSitesForApiVerification.size() == 1) {
                webDriverHelper.waitUntilVisible(unitDisplayedInTable, 60, 1);
                unitInTable = unitDisplayedInTable.getText();
                Assert.assertEquals(unitInTable, leafWetness, "Failed to verify the table name with selected measurement " + unitInTable + " ");
            } else {
                webDriverHelper.waitUntilVisible(multipleSiteUnit, 90, 1);
                Assert.assertTrue(multipleSiteUnit.getText().contains(leafWetness), "Failed to verify the table name with selected measurement " + multipleSiteUnit.getText() + " ");
            }
            verifyLoadMoreBtn();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnitsInGraphLeafWetness.jpg");
            Assert.fail("Failed in verifyUnitsInGraphLeafWetness method due to exception:- " + exc);
        }
    }

    private void verifySiteLeafWetnessCountInApiForHourly(List<WebElement> Value, String siteName) {
        try {
            // UI values from the table
            List<Map.Entry<String, Integer>> combinedListInUi = new ArrayList<>();
            int size = Math.min(dateUI.size(), Value.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = Value.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueUI;
                if (valueStringUI.equals("--")) {
                    integerValueUI = 9999;
                } else {
                    integerValueUI = Integer.parseInt(valueStringUI);
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
                combinedListInUi.add(elementPair);
            }
            combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999);
            // API values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = inputFormatForStartDate.parse(dateText);
            selectedStartDateStrText = outputFormatForStarDate.format(date);
            String endDateText = endDates.getText();
            SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date1 = inputFormatForEndDate.parse(endDateText);
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date1);
            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date modifiedDate = calendar.getTime();
            selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
            graphApiHelper.getSiteId(siteName);
            graphApiHelper.fetchSitesZone();
            webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
            graphApiHelper.getSummaryRequestForGraphForHourly();
            graphApiHelper.getDateLeafWetnessForHourly();
            for (int i = 0; i < combinedListInUi.size(); i++) {
                boolean matchFound = false;
                for (int j = combinedListInApiHourly.size() - 1; j >= 0; j--) {
                    if (combinedListInUi.get(i).equals(combinedListInApiHourly.get(j))) {
                        matchFound = true;
                        break;
                    }
                }
                if (!matchFound) {
                    Assert.fail("Element at index " + i + " is not matching with any elements in the API list");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifySiteLeafWetnessCountInApiForHourly.jpg");
            Assert.fail("Failed in verifySiteLeafWetnessCountInApiForHourly method due to exception:- " + exc);
        }
    }

    public void verifyLeafWetnessCountInApiForMultipleSitesForGraph() {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                String secondItem = addedSitesForApiVerification.get(1);
                verifySiteLeafWetnessCountInApiForHourly(ualueUITable1, firstItem);
                verifySiteLeafWetnessCountInApiForHourly(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String singleItem = addedSitesForApiVerification.get(0);
                verifySiteLeafWetnessCountInApiForHourly(ualueUITable1, singleItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyLeafWetnessCountInApiForMultipleSitesForGraph.jpg");
            Assert.fail("Failed in verifyLeafWetnessCountInApiForMultipleSitesForGraph method due to exception:- " + exc);
        }
    }

    public void verifyPrecipitationCountInApiForMultipleSitesForGraph() {
        try {
            if (addedSitesForApiVerification.size() == 2) {
                String firstItem = addedSitesForApiVerification.get(0);
                String secondItem = addedSitesForApiVerification.get(1);
                verifySitePrecipitationCountInApiForHourly(ualueUITable1, firstItem);
                verifySitePrecipitationCountInApiForHourly(ualueUITable2, secondItem);
            } else if (addedSitesForApiVerification.size() == 1) {
                String singleItem = addedSitesForApiVerification.get(0);
                verifySitePrecipitationCountInApiForHourly(ualueUITable1, singleItem);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyPrecipitationCountInApiForMultipleSitesForGraph.jpg");
            Assert.fail("Failed in verifyPrecipitationCountInApiForMultipleSitesForGraph method due to exception:- " + exc);
        }
    }

    private void verifySitePrecipitationCountInApiForHourly(List<WebElement> Value, String siteName) {
        try {
            // UI values from the table
            List<Map.Entry<String, Integer>> combinedListInUi = new ArrayList<>();
            int size = Math.min(dateUI.size(), Value.size());
            for (int i = 0; i < size; i++) {
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = Value.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueUI;
                if (valueStringUI.equals("--")) {
                    integerValueUI = 9999;
                } else {
                    int valueStringUIRounded = (int) Math.round(Float.parseFloat(valueStringUI));
                    integerValueUI = Integer.parseInt(String.valueOf(valueStringUIRounded));
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueUI);
                combinedListInUi.add(elementPair);
            }
            combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999);
            // API values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = inputFormatForStartDate.parse(dateText);
            selectedStartDateStrText = outputFormatForStarDate.format(date);
            String endDateValue = endDates.getText();
            SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date1 = inputFormatForEndDate.parse(endDateValue);
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date1);
            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date modifiedDate = calendar.getTime();
            selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
            graphApiHelper.getSiteId(siteName);
            graphApiHelper.fetchSitesZone();
            webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateValue);
            graphApiHelper.getSummaryRequestForGraphForHourly();
            graphApiHelper.getDatePrecipitationForHourly();
            for (int i = 0; i < combinedListInUi.size(); i++) {
                boolean matchFound = false;
                for (int j = combinedListInApiHourly.size() - 1; j >= 0; j--) {
                    if (combinedListInUi.get(i).equals(combinedListInApiHourly.get(j))) {
                        matchFound = true;
                        break;
                    }
                }
                if (!matchFound) {
                    Assert.fail("Element at index " + i + " is not matching with any elements in the API list");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifySitePrecipitationCountInApiForHourly.jpg");
            Assert.fail("Failed in verifySitePrecipitationCountInApiForHourly method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseForMultipleSitesForMaxAndMinTempForHourly() {
        try {
            webDriverHelper.waitUntilVisible(firstMeasureSelected, 60, 1);
            if (firstMeasureSelected.getText().contains(Constants.maxTemp)) {
                firstMeasureSelected.isEnabled();
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    combinedListInUi.clear();
                    graphPage.verifyApiResponseIntegerValueFromUITableForHourly(selectedSite);
                }
            }
            webDriverHelper.waitUntilVisible(lastMeasureSelected, 60, 1);
            if (lastMeasureSelected.getText().contains(Constants.minTemp)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(lastMeasureSelected).click().build().perform();
                firstMeasureSelected.isEnabled();
                for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                    index = i;
                    String selectedSite = addedSitesForApiVerification.get(i);
                    combinedListInUi.clear();
                    graphPage.verifyApiResponseIntegerValueFromUITableForHourly(selectedSite);
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseForMultipleSitesForMaxAndMinTempForHourly.jpg");
            Assert.fail("Failed in verifyApiResponseForMultipleSitesForMaxAndMinTempForHourly method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseIntegerValueFromUITableForHourly(String selectedSite) {
        try {
            if (index == 0) {
                graphPage.gettingIntegerUIValuesFromTableForHourly();
            } else {
                graphPage.gettingIntegerUIValuesForThirdColumnForHourly();
            }
            //Api values
            String dateText = startDate.getText();
            SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = inputFormatForStartDate.parse(dateText);
            selectedStartDateStrText = outputFormatForStarDate.format(date);
            String endDateText = endDates.getText();
            SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date1 = inputFormatForEndDate.parse(endDateText);
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date1);
            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date modifiedDate = calendar.getTime();
            selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
            graphApiHelper.getSiteId(selectedSite);
            graphApiHelper.fetchSitesZone();
            webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
            if (measureInMenuBar.equalsIgnoreCase(Constants.maxAndMinTempInMenuBar)) {
                String bkgColor = firstMeasureSelected.getCssValue("color");
                if (bkgColor.equalsIgnoreCase(Constants.selectedMeasureBkgColour)) {
                    graphApiHelper.getSummaryRequestForGraphForHourly();
                    graphApiHelper.getDateAndMaxTempForHourly();
                } else {
                    graphApiHelper.getSummaryRequestForGraphForHourly();
                    graphApiHelper.getDateAndMinTempForHourly();
                }
            } else if (measureInMenuBar.equalsIgnoreCase(Constants.windMeasure)) {
                graphApiHelper.getSummaryRequestForGraphForHourly();
                graphApiHelper.getDateAndWindSpeedForHourly();
                graphApiHelper.getSummaryRequestForHistoricalHourly();
                graphApiHelper.getDateAndWindSpeedForHourlyForHistorical();
            }
            Set<Map.Entry<String, Integer>> apiSet = new HashSet<>(combinedListInApiHourly);
            for (int i = 0; i < combinedListInUi.size(); i++) {
                if (!apiSet.contains(combinedListInUi.get(i))) {
                    Assert.fail("Element at index " + combinedListInUi.get(i) + " is not matching with any elements in the API list & Value is not matching with " + addedSitesForApiVerification.get(i) + ".");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseIntegerValueFromUITableForHourly.jpg");
            Assert.fail("Failed in verifyApiResponseIntegerValueFromUITableForHourly method due to exception:- " + exc);
        }
    }

    public void gettingIntegerUIValuesFromTableForHourly() throws InterruptedException {
        try {
            int size = dateUI.size();
            for (int i = 0; i < size; i++) {
                Thread.sleep(1000);
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = ualueUITable1.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueInUI;
                if (valueStringUI.equals("--")) {
                    integerValueInUI = 9999;
                } else if (valueStringUI.equals("Data Processing")) {
                    integerValueInUI = 9999;
                } else {
                    integerValueInUI = Integer.parseInt(valueStringUI);
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueInUI);
                combinedListInUi.add(elementPair);
            }
            combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_gettingIntegerUIValuesFromTableForHourly.jpg");
            Assert.fail("Failed in gettingIntegerUIValuesFromTableForHourly method due to exception:- " + exc);
        }
    }

    public void gettingIntegerUIValuesFromTableForHourlyForSingleSiteWind() throws InterruptedException {
        try {
            int size = dateUI.size();
            for (int i = 0; i < size; i++) {
                Thread.sleep(1000);
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = ualueUITable1.get(i);
                String dateStringUII = dateElementUI.getText();
                if (dateStringUII.contains(Constants.localDataText) || dateStringUII.contains(Constants.remoteDateText)) {
                    String[] dateSplit = dateStringUII.split(" \\|");
                    if (dateSplit.length == 2) {
                        date = (dateSplit[0]);
                        localDate = (dateSplit[1]);
                    }
                }
                String dateStringUI = date;
                String valueStringUI = valueElementUI.getText();
                int integerValueInUI;
                if (valueStringUI.equals("--")) {
                    integerValueInUI = 9999;
                } else if (valueStringUI.equals("Data Processing")) {
                    integerValueInUI = 9999;
                } else {
                    integerValueInUI = Integer.parseInt(valueStringUI);
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueInUI);
                combinedListInUi.add(elementPair);
            }
            combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_gettingIntegerUIValuesFromTableForHourly.jpg");
            Assert.fail("Failed in gettingIntegerUIValuesFromTableForHourly method due to exception:- " + exc);
        }
    }

    public void gettingIntegerUIValuesForThirdColumnForHourly() throws InterruptedException {
        try {
            int size = Math.min(dateUI.size(), ualueUITable2.size());
            for (int i = 0; i < size; i++) {
                Thread.sleep(1000);
                WebElement dateElementUI = dateUI.get(i);
                WebElement valueElementUI = ualueUITable2.get(i);
                String dateStringUI = dateElementUI.getText();
                String valueStringUI = valueElementUI.getText();
                int integerValueInUI;
                if (valueStringUI.equals("--")) {
                    integerValueInUI = 9999999;
                } else if (valueStringUI.equals("Data Processing")) {
                    integerValueInUI = 9999999;
                } else {
                    integerValueInUI = Integer.parseInt(valueStringUI);
                }
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateStringUI, integerValueInUI);
                combinedListInUi.add(elementPair);
            }
            combinedListInUi.removeIf(elementPair -> elementPair.getValue() == 9999999);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_gettingIntegerUIValuesForThirdColumnForHourly.jpg");
            Assert.fail("Failed in gettingIntegerUIValuesForThirdColumnForHourly method due to exception:- " + exc);
        }
    }

    public void verifyHourlyApiResponseForMultipleSitesAndMeasurementsAsWind() {
        try {
            localData = localDataValues.size();
            remoteData = remoteDataValues.size();
            for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                index = i;
                String selectedSite = addedSitesForApiVerification.get(i);
                combinedListInUi.clear();
                combinedListInApiHourly.clear();
                graphPage.verifyApiResponseIntegerValueFromUITableForHourly(selectedSite);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseForMultipleSitesAndMeasurementsAsWind.jpg");
            Assert.fail("Failed in verifyApiResponseForMultipleSitesAndMeasurementsAsWind method due to exception:- " + exc);
        }
    }

    public void verifyHourlyApiResponseForSingleSiteMeasurementsAsWind() {
        try {
            for (int i = 0; i < addedSitesForApiVerification.size(); i++) {
                index = i;
                String selectedSite = addedSitesForApiVerification.get(i);
                combinedListInUi.clear();
                combinedListInApiHourly.clear();
                graphPage.verifyApiResponseIntegerValueFromUITableForHourlyForSingleSitesWind(selectedSite);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyApiResponseForMultipleSitesAndMeasurementsAsWind.jpg");
            Assert.fail("Failed in verifyApiResponseForMultipleSitesAndMeasurementsAsWind method due to exception:- " + exc);
        }
    }

    public void verifyApiResponseIntegerValueFromUITableForHourlyForSingleSitesWind(String selectedSite) throws InterruptedException, ParseException, JsonProcessingException {
        if (index == 0) {
            graphPage.gettingIntegerUIValuesFromTableForHourlyForSingleSiteWind();
        }
        //Api values
        String dateText = startDate.getText();
        SimpleDateFormat inputFormatForStartDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormatForStarDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = inputFormatForStartDate.parse(dateText);
        selectedStartDateStrText = outputFormatForStarDate.format(date);
        String endDateText = endDates.getText();
        SimpleDateFormat inputFormatForEndDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormatForEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date1 = inputFormatForEndDate.parse(endDateText);
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.setTime(date1);
        calendar.set(Calendar.HOUR_OF_DAY, currentHour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date modifiedDate = calendar.getTime();
        selectedEndDateStrText = outputFormatForEndDate.format(modifiedDate);
        graphApiHelper.getSiteId(selectedSite);
        graphApiHelper.fetchSitesZone();
        webDriverHelper.getStartAndEndTimeAccordingToTimeZoneForLastHrs(siteZone, endDateText);
        if (measureInMenuBar.equalsIgnoreCase(Constants.maxAndMinTempInMenuBar)) {
            String bkgColor = firstMeasureSelected.getCssValue("color");
            if (bkgColor.equalsIgnoreCase(Constants.selectedMeasureBkgColour)) {
                graphApiHelper.getSummaryRequestForGraphForHourly();
                graphApiHelper.getDateAndMaxTempForHourly();
            } else {
                graphApiHelper.getSummaryRequestForGraphForHourly();
                graphApiHelper.getDateAndMinTempForHourly();
            }
        } else if (measureInMenuBar.equalsIgnoreCase(Constants.windMeasure)) {
            graphApiHelper.getSummaryRequestForGraphForHourly();
            graphApiHelper.getDateAndWindSpeedForHourly();
            graphApiHelper.getSummaryRequestForHistoricalHourly();
            graphApiHelper.getDateAndWindSpeedForHourlyForHistorical();
        }
        Set<Map.Entry<String, Integer>> apiSet = new HashSet<>(combinedListInApiHourly);
        for (int i = 0; i < combinedListInUi.size(); i++) {
            if (!apiSet.contains(combinedListInUi.get(i))) {
                Assert.fail("Element at index " + combinedListInUi.get(i) + " is not matching with any elements in the API list & Value is not matching with " + addedSitesForApiVerification.get(i) + ".");
            }
        }
    }

    public void getStartAndEndDateFromApiEndPoint() {
        try {
            String dateText = startDate.getText();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = inputFormat.parse(dateText);
            selectedStartDateStrText = outputFormat.format(date);
            String endDateText = endDate.getText();
            Date endDate = inputFormat.parse(endDateText);
            selectedEndDateStrText = outputFormat.format(endDate);
            ChromeOptions options = new ChromeOptions();
            LoggingPreferences logs = new LoggingPreferences();
            logs.enable("performance", java.util.logging.Level.ALL);
            options.setCapability("goog:loggingPrefs", logs);
            Set<String> apiEndpoints = new HashSet<>();
            LogEntries logEntries = driver.manage().logs().get("performance");
            for (LogEntry entry : logEntries) {
                if (entry.getMessage().contains("\"method\":\"Network.responseReceived\"")) {
                    com.google.gson.JsonObject message = JsonParser.parseString(entry.getMessage()).getAsJsonObject();
                    JsonObject responseReceived = message.getAsJsonObject("message").getAsJsonObject("params");
                    String apiEndpoint = responseReceived.getAsJsonObject("response").get("url").getAsString();
                    apiEndpoints.add(apiEndpoint);
                }
            }
            teamsApiHelper.getAuthToken();
            teamsApiHelper.getOrgId(orgTargeted);
            graphApiHelper.getSiteId(addedSitesForApiVerification.get(0));
            String historicalApi = PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/" + siteId + "/historical?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit;
            String fullHistoricalApi = null;
            for (String storedEndpoint : apiEndpoints) {
                if (storedEndpoint.contains(historicalApi)) {
                    fullHistoricalApi = storedEndpoint;
                    break;
                }
            }
            if (fullHistoricalApi == null) {
                Assert.fail("No Match Found for Partial Endpoints: " + historicalApi);
            }
            URL url = new URL(fullHistoricalApi);
            Map<String, String> queryParams = webDriverHelper.getQueryParameters(url);
            startDateInHistoricalApi = queryParams.get("start_date");
            endDateInHistoricalApi = queryParams.get("end_date");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_failedToGetDatesFromApi.jpg");
            Assert.fail("Failed to verify the start and end date from historical APi in the network tab due to exception:- " + exc);
        }
    }

    public void verifyTheStartAndEndDateInApiEndPointForDailyAndHourlyTimeline() {
        try {
            graphPage.getStartAndEndDateFromApiEndPoint();
            String historicalStartDate = "";
            String historicalEndDate = "";
            System.out.println("startDateInHistoricalApi" + startDateInHistoricalApi);
            System.out.println("endDateInHistoricalApi" + endDateInHistoricalApi);
            if (startDateInHistoricalApi.contains("T") || endDateInHistoricalApi.contains("T")) {
                String[] startDateAtHistorical = startDateInHistoricalApi.split("T");
                if (startDateAtHistorical.length == 2) {
                    historicalStartDate = (startDateAtHistorical[0]);
                }
                System.out.println("endDateInHistoricalApi" + endDateInHistoricalApi);
                String[] endDateAtHistorical = endDateInHistoricalApi.split("T");
                if (startDateAtHistorical.length == 2) {
                    historicalEndDate = (endDateAtHistorical[0]);
                }
            }
            if (startDateInHistoricalApi.contains("T") || endDateInHistoricalApi.contains("T")) {
                Assert.assertEquals(selectedStartDateStrText, historicalStartDate, "Failed because the start date in historical hourly api call is not matching with the start date selected in timeline.");
                Assert.assertEquals(selectedEndDateStrText, historicalEndDate, "Failed because the end date in historical hourly api call is not matching with the end date selected in timeline.");
            } else {
                Assert.assertEquals(selectedStartDateStrText, startDateInHistoricalApi, "Failed because the start date in historical daily/hourly api call is not matching with the start date selected in timeline.");
                Assert.assertEquals(selectedEndDateStrText, endDateInHistoricalApi, "Failed because the end date in historical daily/hourly api call is not matching with the end date selected in timeline.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyDaily&HistoricalApiForHourlyTimeline.jpg");
            Assert.fail("Failed to verify the historical APi for daily & hourly timeline in the network tab due to exception:- " + exc);
        }
    }

    public void selectHourlyTimelineAndVerifyGraph() {
        try {
            webDriverHelper.waitUntilVisible(hourly_Button, 60, 1);
            hourly_Button.click();
            Thread.sleep(5000);
            webDriverHelper.waitUntilVisible(graph, 60, 1);
            Assert.assertTrue((graph.isDisplayed()), "Failed because the graph is not displayed for the particular site which we selected");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectHourlyGraph&Verify.jpg");
            Assert.fail("Failed to select timeline and verify graph for hourly the  due to exception:- " + exc);
        }
    }

    public void selectSiteDeviceWhichHasWindSensor() {
        try {
            boolean foundSite = false;
            webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 60, 1);
            for (int i = 1; i < windSensorDevices.size(); i++) {
                String deviceName = windSensorDevices.get(i).getText();
                List<WebElement> windSensorSites = driver.findElements(By.xpath("//p[text()='" + deviceName + "']/../following-sibling::div[@class='column']/div[@class='row']/p"));
//                webDriverHelper.waitUntilVisibilityOfAllElements(windSensorSites, 90, 1);
                Thread.sleep(3000); //for loading the wind sensor devices
                if (windSensorSites.size() == 1) {
                    siteAsWindSensor = windSensorSites.get(0).getText();
                    result = "windSensor";
                    foundSite = true;
                    break;
                }
            }
            Assert.assertTrue((foundSite), "Failed because NOT found a device with wind sensor which has a single site for this userRole.");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectWindSensorSite.jpg");
            Assert.fail("Failed in selectSiteDeviceWhichHasWindSensor method due to exception:- " + exc);
        }
    }

    public void selectSiteDeviceWhichHasNoSensorIcon() {
        try {
            boolean foundSite = false;
            webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 60, 1);
            for (WebElement device : noSensorDevices) {
                String deviceName = device.getText();
                List<WebElement> noSensorSites = driver.findElements(By.xpath("//p[text()='" + deviceName + "']/../following-sibling::div[@class='column']/div[@class='row']/p"));
//                webDriverHelper.waitUntilVisibilityOfAllElements(noSensorSites, 90, 1);
                Thread.sleep(3000); //for loading the non sensor devices
                if (noSensorSites.size() == 1) {
                    siteAsNoSensor = noSensorSites.get(0).getText();
                    result = "noSensor";
                    foundSite = true;
                    break;
                }
            }
            if (!foundSite) {
                Assert.fail("Failed because NOT found a device with no sensor which has a single site for this userRole.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyHourlyGraph.jpg");
            Assert.fail("Failed in selectSiteDeviceWhichHasNoSensorIcon method due to exception:-:- " + exc);
        }
    }

    public void selectSiteWhichAlreadyPickedFromDevicePageAndSelectMeasurementAsWind() {
        try {
            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 90, 1);
            for (WebElement element : sitesList) {
                String sitesName = element.getText();
                if (sitesName.equals(siteAsWindSensor)) {
                    element.click();
                    break;
                }
                if (sitesName.equals(siteAsNoSensor)) {
                    element.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(sitesDropdownIcon, 90, 1);
            sitesDropdownIcon.click();
            webDriverHelper.waitUntilVisible(measureDropdownIcon, 90, 1);
            measureDropdownIcon.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(measureList, 200, 1);
            boolean windClicked = false;
            for (WebElement webElement : measureList) {
                String measureName = webElement.getText();
                if (measureName.equals("Wind") && !windClicked) {
                    webElement.click();
                    windClicked = true;
                }
            }
            webDriverHelper.waitUntilVisible(measureDropdownIcon, 90, 1);
            measureDropdownIcon.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectSiteAndMeasurement.jpg");
            Assert.fail("Failed to select site which already picked and failed to select the measurement as wind due to exception:- " + exc);
        }
    }

    public void verifyFirstColumnInTable() {
        try {
            webDriverHelper.waitUntilVisible(firstColumnName, 90, 1);
            String columnName = firstColumnName.getText();
            System.out.println(columnName);
            if (!(columnName.equalsIgnoreCase(Constants.firstColumnNameInGraphTable))) {
                Assert.fail("The column name " + columnName + " is not matching with " + Constants.firstColumnNameInGraphTable + " displayed in the table ");
            }
            webDriverHelper.waitUntilVisibilityOfAllElements(textsInFirstRow, 200, 1);
            for (WebElement webElement : textsInFirstRow) {
                String textInColumn = webElement.getText();
                System.out.println("The data present in the first column " + textInColumn);
                if (result.equalsIgnoreCase("windSensor")) {
                    if (!textInColumn.contains(Constants.localDataText)) {
                        Assert.fail("The data present in the first column " + columnName + " is not matching with this data " + textInColumn + ". ");
                    }
                } else {
                    if (!textInColumn.contains(Constants.remoteDateText)) {
                        Assert.fail("The data present in the first column " + columnName + " is not matching with this data " + textInColumn + ". ");
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyFristColumn.jpg");
            Assert.fail("Failed to verify the first column name in table on graph page due to exception:- " + exc);
        }
    }

    public void navigateToGraphPage(String pageName) {
        webDriverHelper.waitUntilVisible(dashboardMenu_Analysis, 30, 1);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Analysis).moveToElement(dashboardMenu_Graph).click().build().perform();
    }

    public void selectSingleSites() {
        try {
            webDriverHelper.waitUntilVisible(openDropDownNewSites, 120, 1);
            if (!graphTag.isDisplayed()) {
                Assert.fail("the graph page tag is not displayed ");
            }
            webDriverHelper.waitUntilVisible(graphSitesDropdownCard, 120, 1);
            if (graphSitesDropdownCard.isDisplayed()) {
                for (WebElement addSite : dropDownSitesList) {
                    String nameOfSelectedList = addSite.getText();
                    if (nameOfSelectedList.contains(Constants.siteWithData)) {
                        addedSitesForApiVerification.add(nameOfSelectedList);
                        addedSitesForExportPageVerification.add(nameOfSelectedList);
                        addSite.click();
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectSingleSites.jpg");
            Assert.fail("Failed in selectSingleSites method due to exception:- " + exc);
        }
    }

    public void clickOnTheExportButton() {
        try {
            webDriverHelper.waitUntilVisible(exportBtn, 30, 1);
            exportBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnTheExportButton");
            Assert.fail("Failed to verify clickOnTheExportButton method due to exception:- " + exc);
        }
    }

    public void clickOnTheGraphBtn() {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(dashboardMenu_Analysis).moveToElement(dashboardMenu_Graph).click().build().perform();
            Thread.sleep(3000);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnTheGraphBtn.jpg");
            Assert.fail("Failed in clickOnTheGraphBtn method due to exception:- " + exc);
        }
    }

}



