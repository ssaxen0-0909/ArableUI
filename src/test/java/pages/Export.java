package pages;

import com.opencsv.CSVReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.ExcelReader;
import support.HTMLReport;
import support.PropertiesReader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static support.PropertiesReader.orgTargeted;
import static support.World.*;


public class Export {

    private static final Logger log = LogManager.getLogger(Export.class);

    private final WebDriver driver;
    @FindBy(css = "div[class='0 dropdown-selector open'] div[class='options']")
    WebElement sitesDropdown;
    @FindBy(xpath = "//p[normalize-space()='No Sites']")
    WebElement noSite;
    @FindBy(xpath = "//h3[normalize-space()='Successfully Downloaded']")
    WebElement successToastMessage_csvDownload;
    @FindBy(css = ".form.grid")
    private WebElement exportDropdownFields;
    @FindAll({@FindBy(xpath = "//div[@class='navigation']/ul[1]/li/div/a")})
    private List<WebElement> dashboardMenuF;
    @FindBy(xpath = "//p[normalize-space()='Analysis']")
    private WebElement dashboardMenu_Analysis;
    @FindBy(xpath = "//p[normalize-space()='Export']")
    private WebElement dashboardMenu_Export;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[1]//label[1]")
    private WebElement firstSiteName;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='column-auto']")
    private WebElement sitename_dropdown_close;
    @FindBy(xpath = "//div[@class='icon-calendar']")
    private WebElement calendarIcon;
    @FindBy(xpath = "//button[normalize-space()='All']")
    private WebElement allOption_calendar;
    @FindBy(xpath = "//button[normalize-space()='Export']")
    private WebElement exportButton;
    @FindBy(xpath = "//label[normalize-space()='Daily']")
    private WebElement exportDaily;
    @FindBy(xpath = "(//div[@class='input-date empty'])[2]")
    private WebElement EndDateText;
    @FindBy(xpath = "(//div[@class='input-date selected'])[2]")
    private WebElement EndDate;
    @FindBy(xpath = "//label[normalize-space()='Hourly']")
    private WebElement exportHourly;
    @FindBy(xpath = "//label[normalize-space()='All']")
    private WebElement exportAll;
    @FindBy(xpath = "//div[@class='modal fade in show']//img[@alt='icon_close']")
    private WebElement All_calender_crossBtn;
    //    --new xpath from graph for date
    @FindBy(xpath = "//div[@class='datepicker-range']/div[3]")
    private WebElement EndDateTextF;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='modal-content tooltip-content']")
    private List<WebElement> dataLimitsInfo;
    @FindBy(xpath = " //div[@class='range-option-selector']")
    private List<WebElement> calendarTimeline;
    @FindBy(xpath = "(//div[@class='grid'])[4]//div//input")
    private WebElement unitForDistance;
    @FindBy(xpath = "(//div[@class='grid'])[4]//div//label")
    private List<WebElement> listUnitForDistance;
    @FindBy(xpath = "(//div[@class='grid'])[5]//div//input")
    private WebElement unitForTemperature;
    @FindBy(xpath = "(//div[@class='grid'])[5]//div//label")
    private List<WebElement> listUnitForTemperature;
    @FindBy(xpath = "(//div[@class='grid'])[6]//div//input")
    private WebElement unitForPressure;
    @FindBy(xpath = "(//div[@class='grid'])[6]//div//label")
    private List<WebElement> listUnitForPressure;
    @FindBy(xpath = "(//div[@class='grid'])[7]//div//input")
    private WebElement unitForSpeed;
    @FindBy(xpath = "(//div[@class='grid'])[7]//div//label")
    private List<WebElement> listUnitForSpeed;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']")
    private WebElement dropDown;
    @FindBy(xpath = "//label[contains(@class,'item-text')]")
    private List<WebElement> listOfSites;
    @FindBy(xpath = "//label[@for='granularity_all']")
    private WebElement granularityAll;
    @FindBy(xpath = "//div[@class='icon-calendar']")
    private WebElement datePicker;
    @FindBy(xpath = "//div[@class='range-option']//button[normalize-space()='All']")
    private WebElement dateAsAll;
    @FindBy(xpath = "//button[@class='btn-style-1 close']")
    private WebElement datePickerCloseBtn;
    @FindBy(xpath = "//button[@class='btn-submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[@class='success toast']")
    private WebElement successToastMsg;
    @FindBy(xpath = "//label[normalize-space()='Daily']")
    private WebElement dailyTag;
    List<String> apiEndpoints = new ArrayList<>();
    public String unitsForDistance;
    public String unitsForPressure;
    public String unitsForSpeed;
    public String unitsForTemperature;
    public File fileInsideUnZippedDirectory;

    public Export(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(dashboardMenu_Analysis, 30, 1);
        map.navigateToPage(role);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Analysis).moveToElement(dashboardMenu_Export).click().build().perform();
    }

    public void captureExport_DailyGranularity_CSVDownloadLoadTime() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(sitesDropdown, 30, 1);
        if (sitesDropdown.isDisplayed()) {
            firstSiteName.click();
            sitename_dropdown_close.click();
            Thread.sleep(500);
            exportDaily.click();
//            Thread.sleep(1000);
            calendarIcon.click();
            Thread.sleep(1000);
            webDriverHelper.waitUntilVisible(calendarTimeline.get(0), 200, 2);
            Thread.sleep(5000);
            allOption_calendar.click();
//            Thread.sleep(6000);
            exportButton.click();
        }
    }

//    public void captureExportPageLoadTime(String role) throws IOException, InterruptedException {
//        String loadInSeconds = null;
//        long start = System.currentTimeMillis();
////        StringHelper.devToolCapture(role);
//        webDriverHelper.waitUntilVisible(sitesDropdown, 30, 1);
//        if (sitesDropdown.isDisplayed()) {
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(sitesDropdown.isDisplayed(), "site dropdown is not displayed");
//        } else {
//            webDriverHelper.waitUntilVisible(noSite, 30, 1);
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(noSite.isDisplayed(), "No site is displayed");
//        }
//        ExcelReader.setValueForColumn("Export", loadInSeconds, role);
//        // HTML report generator
//        HTMLReport.addPageName("Export");
////        HTMLReport.generateReport("Export", loadInSeconds, role);
//        HTMLReport.writeReportToFile();
//    }
//
//    public void captureExportDailyCSVLoadTime(String role) throws IOException, InterruptedException {
//        String loadInSeconds = null;
//        captureExport_DailyGranularity_CSVDownloadLoadTime();
////        StringHelper.devToolCapture(role);
//        long start = System.currentTimeMillis();
//        webDriverHelper.waitUntilVisible(successToastMessage_csvDownload, 300, 1);
//        if (successToastMessage_csvDownload.isDisplayed()) {
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(successToastMessage_csvDownload.isDisplayed(), "success message for csv download is not displayed");
//        }
//        ExcelReader.setValueForColumn("Export Daily - Csv Download", loadInSeconds, role);
//        // HTML report generator
//        HTMLReport.addPageName("Export Daily - Csv Download");
////        HTMLReport.generateReport("Export Daily - Csv Download", loadInSeconds, role);
//        HTMLReport.writeReportToFile();
//    }
//
//    public void captureExportHourlyCSVLoadTime(String role) throws IOException, InterruptedException {
//        String loadInSeconds = null;
//        captureExport_HourlyGranularity_CSVDownloadLoadTime();
////        StringHelper.devToolCapture(role);
//        long start = System.currentTimeMillis();
//        webDriverHelper.waitUntilVisible(successToastMessage_csvDownload, 300, 1);
//        if (successToastMessage_csvDownload.isDisplayed()) {
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(successToastMessage_csvDownload.isDisplayed(), "success message for csv download is not displayed");
//        }
//        ExcelReader.setValueForColumn("Export Hourly - Csv Download", loadInSeconds, role);
//        // HTML report generator
//        HTMLReport.addPageName("Export Hourly - Csv Download");
////        HTMLReport.generateReport("Export Hourly - Csv Download", loadInSeconds, role);
//        HTMLReport.writeReportToFile();
//    }

    public void captureExportAllCSVLoadTime(String role) throws IOException, InterruptedException {
        String loadInSeconds = null;
        captureExport_AllGranularity_CSVDownloadLoadTime();
//        StringHelper.devToolCapture(role);
        long start = System.currentTimeMillis();
        webDriverHelper.waitUntilVisible(successToastMessage_csvDownload, 200, 1);
        if (successToastMessage_csvDownload.isDisplayed()) {
            loadInSeconds = stringHelper.stopTime(start, driver);
            Assert.assertTrue(successToastMessage_csvDownload.isDisplayed(), "success message for csv download is not displayed");
        }
        ExcelReader.setValueForColumn("Export All - Csv Download", loadInSeconds, role);
        // HTML report generator
        HTMLReport.addPageName("Export All - Csv Download");
//        HTMLReport.generateReport("Export All - Csv Download", loadInSeconds, role);
        HTMLReport.writeReportToFile();
    }

    public void captureExport_HourlyGranularity_CSVDownloadLoadTime() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(sitesDropdown, 30, 1);
        firstSiteName.click();
        sitename_dropdown_close.click();
        Thread.sleep(500);
        exportHourly.click();
//            Thread.sleep(1000);
        calendarIcon.click();
        webDriverHelper.waitUntilVisible(calendarTimeline.get(0), 90, 2);
        Thread.sleep(6000);
        verifyCalendarInfo();
        Thread.sleep(1000);
        exportButton.click();
    }

    public void captureExport_AllGranularity_CSVDownloadLoadTime() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(sitesDropdown, 30, 1);
        if (sitesDropdown.isDisplayed()) {
            captureExportNoSentekSite();
            sitename_dropdown_close.click();
            Thread.sleep(500);
            exportAll.click();
            calendarIcon.click();
            webDriverHelper.waitUntilVisible(calendarTimeline.get(0), 90, 2);
            Thread.sleep(6000);
            verifyCalendarInfo();
            Thread.sleep(1000);
            exportButton.click();
        }
    }

    public void verifyCalendarInfo() throws IOException, InterruptedException {
        try {
            allOption_calendar.click();
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking allOption_calendar: " + e.getMessage());
        }
        try {
            webDriverHelper.waitUntilVisible(All_calender_crossBtn, 5, 1);
            All_calender_crossBtn.click();
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking All_calender_crossBtn: " + e.getMessage());
        }
    }

    public void captureExport_AllGranularitySentek() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(sitesDropdown, 30, 1);
        if (sitesDropdown.isDisplayed()) {
            captureExportWithSentekSite();
            sitename_dropdown_close.click();
            Thread.sleep(500);
            exportAll.click();
            calendarIcon.click();
            webDriverHelper.waitUntilVisible(calendarTimeline.get(0), 90, 2);
            Thread.sleep(6000);
            verifyCalendarInfo();
            Thread.sleep(1000);
            exportButton.click();
        }
    }

    public void captureExportNoSentekSite() throws IOException, InterruptedException {
        uiPerformance.graphSearchField.click();
        uiPerformance.graphSearchField.sendKeys("Without Sentek");
        webDriverHelper.waitUntilVisible(uiPerformance.graphSearchSuggestion, 90, 2);
        uiPerformance.graphSearchSuggestion.click();
    }

    public void captureExportWithSentekSite() throws IOException, InterruptedException {
        uiPerformance.graphSearchField.click();
        uiPerformance.graphSearchField.sendKeys("Sentek Site");
        Thread.sleep(1000);
        uiPerformance.graphSearchSuggestion.click();
    }

    public void verifyTheUnitsDisplayed() {
        try {
            webDriverHelper.waitUntilVisible(dropDown, 60, 1);
            dropDown.click();
            unitsForDistance = unitForDistance.getAttribute("ng-reflect-model");
            unitsForPressure = unitForPressure.getAttribute("ng-reflect-model");
            unitsForTemperature = unitForTemperature.getAttribute("ng-reflect-model");
            unitsForSpeed = unitForSpeed.getAttribute("ng-reflect-model");
            if (!"inches".equals(unitForDistance.getAttribute("ng-reflect-model")) && !"millimeters".equals(unitForDistance.getAttribute("ng-reflect-model"))) {
                Assert.fail("No unit is selected for distance");
            }
            if (!"millibars".equals(unitForPressure.getAttribute("ng-reflect-model")) && !"kilo_pascals".equals(unitForPressure.getAttribute("ng-reflect-model"))) {
                Assert.fail("No unit is selected for pressure");
            }
            if (!"celsius".equals(unitForTemperature.getAttribute("ng-reflect-model")) && !"fahrenheit".equals(unitForTemperature.getAttribute("ng-reflect-model"))) {
                Assert.fail("No unit is selected for temperature");
            }
            if (!"Miles_per_hour".equals(unitForSpeed.getAttribute("ng-reflect-model")) && !"Kilometers_per_hour".equals(unitForSpeed.getAttribute("ng-reflect-model")) && !"Meters_per_second".equals(unitForSpeed.getAttribute("ng-reflect-model"))) {
                Assert.fail("No unit is selected for distance");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheUnitsDisplayed.jpg");
            Assert.fail("Failed in verifyTheUnitsDisplayed method due to exception: " + exc);
        }
    }

    public void changeTheUnits() {
        try {
            Thread.sleep(3000);
            if (Objects.equals(unitsForDistance, "inches")) {
                listUnitForDistance.get(1).click();
            } else {
                listUnitForDistance.get(0).click();
            }
            if (Objects.equals(unitsForPressure, "millibars")) {
                listUnitForPressure.get(1).click();
            } else {
                listUnitForPressure.get(0).click();
            }
            if (Objects.equals(unitsForTemperature, "fahrenheit")) {
                listUnitForTemperature.get(1).click();
            } else {
                listUnitForTemperature.get(0).click();
            }
            if (Objects.equals(unitsForSpeed, "Miles_per_hour")) {
                listUnitForSpeed.get(1).click();
            } else if (Objects.equals(unitsForSpeed, "Kilometers_per_hour")) {
                listUnitForSpeed.get(2).click();
            } else {
                listUnitForSpeed.get(0).click();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("changeTheUnits.jpg");
            Assert.fail("Failed in changeTheUnits method due to exception: " + exc);
        }
    }

    public void verifyTheUnits() {
        try {
            webDriverHelper.waitUntilVisible(dropDown, 60, 1);
            dropDown.click();
            String unitsForDistance1 = unitForDistance.getAttribute("ng-reflect-model");
            Assert.assertTrue(unitsForDistance.equalsIgnoreCase(unitsForDistance1));
            String unitsForPressure1 = unitForPressure.getAttribute("ng-reflect-model");
            Assert.assertTrue(unitsForPressure.equalsIgnoreCase(unitsForPressure1));
            String unitsForTemperature1 = unitForTemperature.getAttribute("ng-reflect-model");
            Assert.assertTrue(unitsForTemperature.equalsIgnoreCase(unitsForTemperature1));
            String unitsForSpeed1 = unitForSpeed.getAttribute("ng-reflect-model");
            Assert.assertTrue(unitsForSpeed.equalsIgnoreCase(unitsForSpeed1));
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheUnits.jpg");
            Assert.fail("Failed in verifyTheUnits method due to exception: " + exc);
        }
    }

    public void fillInTheDetailsOnTheExportPage() throws InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(dropDown, 60, 1);
            dropDown.click();
            webDriverHelper.waitUntilVisible(granularityAll, 60, 1);
            granularityAll.click();
            webDriverHelper.waitUntilVisible(datePicker, 60, 1);
            datePicker.click();
            // to load the time in calendar
            Thread.sleep(5000);
            webDriverHelper.waitUntilVisible(dateAsAll, 60, 1);
            dateAsAll.click();
            webDriverHelper.waitUntilVisible(datePickerCloseBtn, 60, 1);
            datePickerCloseBtn.click();
            accountSizeUnit = unitForDistance.getAttribute("ng-reflect-model");
            accountPressureUnit = unitForPressure.getAttribute("ng-reflect-model");
            accountTemperatureUnit = unitForTemperature.getAttribute("ng-reflect-model");
            accountSpeedUnit = unitForSpeed.getAttribute("ng-reflect-model");
            tempUnit = sitesApiHelper.temperatureUnitValue();
            presUnit = sitesApiHelper.pressureUnitValue();
            sizeUnit = sitesApiHelper.sizeUnitValue();
            speedUnit = sitesApiHelper.speedUnitValue();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("fillInTheDetailsOnTheExportPage.jpg");
            Assert.fail("Failed in fillInTheDetailsOnTheExportPage method due to exception: " + exc);
        }
    }

    public void verifyThePageOnceClickOnSubmitBtn() {
        try {
            webDriverHelper.waitUntilVisible(submitBtn, 60, 1);
            submitBtn.click();
            webDriverHelper.waitUntilVisible(successToastMsg, 150, 1);
            for (String siteName : addedSitesForExportPageVerification) {
                teamsApiHelper.getAuthToken();
                teamsApiHelper.getOrgId(orgTargeted);
                graphApiHelper.getSiteId(siteName);
                graphApiHelper.getSiteZone();
                String endPointForLocalHourly = PropertiesReader.apiSeverUrl + "/api/v2/sites/data/local_hourly?temp";
                String endPointForDaily = PropertiesReader.apiSeverUrl + "/api/v2/sites/data/daily?temp";
                verifyThePageOnceClickOnSubmitBtn(endPointForLocalHourly);
                verifyThePageOnceClickOnSubmitBtn(endPointForDaily);
            }
            addedSitesForExportPageVerification.clear();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyThePageOnceClickOnSubmitBtn.jpg");
            Assert.fail("Failed in verifyThePageOnceClickOnSubmitBtn method due to exception: " + exc);
        }
    }

    public void verifyThePageOnceClickOnSubmitBtn(String apiEndPoint) {
        try {
            List<String> apiEndpoints = webDriverHelper.captureNetworkRequests();
            String fullHistoricalApi = findMatchingEndpoint(apiEndPoint, apiEndpoints);
            if (fullHistoricalApi == null) {
                Assert.fail("No Match Found for Partial Endpoints: " + apiEndPoint);
            }
            Map<String, String> queryParams = webDriverHelper.getQueryParameters(new URL(fullHistoricalApi));
            String temp = queryParams.get("temp");
            String pres = queryParams.get("pres");
            String size = queryParams.get("size");
            String speed = queryParams.get("speed");
            Assert.assertTrue(sizeUnit.equalsIgnoreCase(size), "size unit is not matching");
            Assert.assertTrue(tempUnit.equalsIgnoreCase(temp), "temp unit is not matching");
            Assert.assertTrue(presUnit.equalsIgnoreCase(pres), "pressure unit is not matching");
//            Assert.assertTrue(speedUnit.equalsIgnoreCase(speed), "speed unit is not matching");
            queryParams.clear();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyThePageOnceClickOnSubmitBtn.jpg");
            Assert.fail("Failed in verifyThePageOnceClickOnSubmitBtn method due to exception: " + exc);
        }
    }

    private String findMatchingEndpoint(String response, List<String> apiEndpoints) {
        for (String storedEndpoint : apiEndpoints) {
            if (storedEndpoint.trim().contains(response.trim())) {
                if (storedEndpoint.trim().contains(siteId)) {
                    return storedEndpoint;
                }
            }
        }
        return null;
    }

    public void verifyTheDateInTheApi(String endPoint) throws MalformedURLException, ParseException {
        try {
            List<String> apiEndpoints = webDriverHelper.captureNetworkRequests();
            String fullHistoricalApi = findMatchingEndpoint(endPoint, apiEndpoints);
            if (fullHistoricalApi == null) {
                Assert.fail("No Match Found for Partial Endpoints: " + endPoint);
            }
            Map<String, String> queryParams = webDriverHelper.getQueryParameters(new URL(fullHistoricalApi));
            String StartDate = driver.findElement(By.xpath("(//div[@class='input-date selected']//span)[1]")).getText();
            String EndDate = driver.findElement(By.xpath("(//div[@class='input-date selected']//span)[2]")).getText();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
            Date date = inputFormat.parse(StartDate);
            SimpleDateFormat outputFormatObj = new SimpleDateFormat("yyyy-MM-dd");
            String startDateOutput = outputFormatObj.format(date);
            Date Enddate = inputFormat.parse(EndDate);
            String endDateOutput = outputFormatObj.format(Enddate);
            String startTime = queryParams.get("start_time");
            String endTime = queryParams.get("end_time");
            Assert.assertTrue(startDateOutput.equalsIgnoreCase(startTime), "start time is not matching");
            Assert.assertTrue(endDateOutput.equalsIgnoreCase(endTime), "end time is not matching");
            queryParams.clear();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheDateInTheApi.jpg");
            Assert.fail("Failed in verifyTheDateInTheApi method due to exception: " + exc);
        }
    }

    public void verifyTheToastMessage() {
        try {
            // the time added to show the submit button in the UI
            Thread.sleep(4000);
            webDriverHelper.waitUntilVisible(submitBtn, 30, 1);
            submitBtn.click();
            webDriverHelper.waitUntilVisible(successToastMsg, 30, 1);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheToastMessage.jpg");
            Assert.fail("Failed in verifyTheToastMessage method due to exception: " + exc);
        }
    }

    public void clickOnDailyBtn() {
        try {
            webDriverHelper.waitUntilVisible(dailyTag, 30, 1);
            dailyTag.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("clickOnDailyBtn.jpg");
            Assert.fail("Failed in clickOnDailyBtn method due to exception: " + exc);
        }
    }

    public void verifyTheDateInTheApiAfterClickingOnTheExportBtn() throws MalformedURLException, ParseException, InterruptedException {
        try {
            teamsApiHelper.getAuthToken();
            teamsApiHelper.getOrgId(orgTargeted);
            graphApiHelper.getSiteId(siteName);
            graphApiHelper.fetchSitesZone();
            String endPoint = "https://application.test.arable.cloud/api/v2/sites/data/daily?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit;
            verifyTheDateInTheApi(endPoint);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheDateInTheApiAfterClickingOnTheExportBtn.jpg");
            Assert.fail("Failed in verifyTheDateInTheApiAfterClickingOnTheExportBtn method due to exception: " + exc);
        }
    }

    public void verifyTheTimeTagMatchInCsvFile() {
        try {
            readingFileFromDirectory();
            String path = fileInsideUnZippedDirectory.getAbsolutePath();
            Reader reader = new FileReader(path);
            CSVReader csvreader = new CSVReader(reader);
            try {
                int targetRow = 14;
                int targetSecondColumn = 2;
                int targetColumn = 1;
                List<String[]> list = csvreader.readAll();
                targetRow--;
                targetColumn--;
                targetSecondColumn--;
                if (targetRow < list.size()) {
                    String[] rowData = list.get(targetRow);
                    if (targetColumn < rowData.length) {
                        String data = rowData[targetColumn];
                        log.info("Data at Row " + (targetRow + 1) + ", Column " + (targetColumn + 1) + ": " + data);
                        Assert.assertTrue(data.contains("local_site_time"), "local_site_time tag is not present in the csv file");
                    }
                }
                if (targetRow < list.size()) {
                    String[] rowData = list.get(targetRow);
                    if (targetSecondColumn < rowData.length) {
                        String data = rowData[targetSecondColumn];
                        log.info("Data at Row " + (targetRow + 1) + ", Column " + (targetSecondColumn + 1) + ": " + data);
                        Assert.assertTrue(data.contains("utc_time"), "utc_time tag is not present in the csv file");
                    }
                }
            } catch (Exception exc) {
                Assert.fail("Exception in verifying data inside CSV file-" + exc);
            } finally {
                csvreader.close();
                /// Delete the files downloaded inside the folder
                File directory = new File(downloadsDirectoryPath);
                filesHelper.purgeDirectory(directory);
            }
        } catch (IOException e) {
            Assert.fail("Exception in reading CSV file-" + e);
        }
    }

    public void readingFileFromDirectory() {
        try {
            Thread.sleep(10000);//wait for the download to complete before unzip
            String directoryPath = downloadsDirectoryPath;
            //Get the downloaded Zip file name
            File zippedFile = filesHelper.getFileTypeFromDirectory(directoryPath, ".zip");
            if (zippedFile == null) {
                Assert.fail("Zipped file not found in the downloads directory." + directoryPath);
            }
            // create folder path to unzip the file
            log.info(" Zip file name=" + zippedFile.getAbsolutePath());
            String unzippedFolder = zippedFile.getName().replace(".zip", "");
            log.info(" UnZipped folder name=" + unzippedFolder);
            /// UnZip utility
            filesHelper.unzipFile(zippedFile.getAbsolutePath(), directoryPath + unzippedFolder);

            // Read the required file
            File unzippedDirectory = new File(directoryPath + unzippedFolder);
            if (unzippedDirectory.exists() && unzippedDirectory.isDirectory()) {
                File[] files = unzippedDirectory.listFiles((dir, name) -> name.contains("hourly") && !name.contains("sentek"));
                if (files != null && files.length > 0) {
                    for (File file : files) {
                        fileInsideUnZippedDirectory = file;
                        log.info("File found =" + fileInsideUnZippedDirectory.getAbsolutePath());
                    }
                } else {
                    Assert.fail("No files containing 'daily' found in the directory.");
                }
            } else {
                Assert.fail("Invalid directory path or directory does not exist.");
            }
        } catch (Exception exc) {
            log.info("Exception from readingFileFromDirectory-" + exc);
        }
    }

}

