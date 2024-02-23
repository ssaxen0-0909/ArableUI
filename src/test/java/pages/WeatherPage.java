package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static support.World.*;

public class WeatherPage {

    private final WebDriver driver;
    public String site_Details_MapPage;

    @FindBy(xpath = "//p[normalize-space()='Weather']")
    WebElement weatherPageTab;
    @FindBy(xpath = "(//div[@class='card'])[2]")
    WebElement currentConditionTableF;
    @FindBy(xpath = "//span[@class='1 caret']")
    WebElement globalOrgDropdownBtn_MapPage;
    @FindBy(xpath = "//div[@class='etc-value']//span[@class='ng-star-inserted']")
    List<WebElement> sizeUnitValidationInETcEToPrecipitation;
    //    @FindBy(xpath = "//div[@class='site-name']/h3")
//    private WebElement siteNameF;
    @FindBy(xpath = "//arable-is-loading[@class='loading center']")
    private WebElement loadingWeatherInfoF;
    @FindBy(xpath = "//div[@class='site-name ng-star-inserted']//h3")
    private WebElement siteNameF;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Current Conditions']/div/div/div/arable-tooltip")
    private WebElement currentTableToolTipF;
    @FindBy(xpath = "((//div[@class='arable-card-body'])[2]/div/div/div[2]/p)[1]")
    private WebElement currentTempValueF;
    @FindBy(xpath = "((//div[@class='arable-card-body'])[2]/div/div[2]/div[2]/p)[1]")
    private WebElement currentHumidityValueF;
    @FindBy(xpath = "((//div[@class='arable-card-body'])[2]/div/div[3]/div[2]/p)[1]")
    private WebElement currentPressureValueF;
    @FindBy(xpath = "(//p[@class='display-number'])[3]//span[@class='measure']")
    private WebElement currentPressureUnitF;
    @FindBy(xpath = "((//div[@class='arable-card-body'])[2]/div/div[4]/div[2]/p)[1]")
    private WebElement currentSolarValueF;
    @FindBy(xpath = "//p[normalize-space()='Search']")
    private WebElement dashboardMenu_Search;
    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@class='site-result']")
    private WebElement search_SiteResult;
    @FindBy(xpath = "//p[@class='1 selected']")
    private WebElement globalOrgSelected_MapPage;
    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//input[@type='search']")
    private WebElement globalOrgDropdownSearch_MapPage;
    @FindBy(xpath = "//p[normalize-space()='arable-team']")
    private WebElement globalOrgSearchSuggestion_MapPage;
    @FindBy(xpath = "(//div[@class='site-summary-card grid clickable'])[1]")
    private WebElement MapPage_SiteF;
    @FindBy(xpath = "//div[@class='site-detail']")
    private WebElement siteDetails;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='Current Conditions']")
    private WebElement currentConditionsText;
    @FindBy(xpath = "//h1[normalize-space()='Today's Temperature']")
    private WebElement todayTemperatureText;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='Hourly Forecast']")
    private WebElement hourlyForecastText;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='Daily Forecast']")
    private WebElement dailyForecastText;
    @FindBy(xpath = "(//div[@class='column'])[29]")
    private WebElement windSpeedHourlyText;
    @FindBy(xpath = "(//div[@class='column'])[31]")
    private WebElement windSpeedDailyText;
    @FindBy(xpath = "//p[contains(text(),'The most recently observed hourly ambient air temp')]")
    private WebElement currentConditionModalText;
    @FindBy(xpath = "//div[@class='modal fade in show']//img[@alt='icon_close']")
    private WebElement closeModal;
    @FindBy(xpath = "//p[contains(text(),'Measurements observed at the site by the Mark up t')]")
    private WebElement todayTemperatureModalText;
    @FindBy(xpath = "//p[contains(text(),'forecasted data.')]")
    private WebElement forecastedModalText;
    @FindBy(xpath = "//p[contains(text(),'Shown as a floating bar graph with the 5-minute mi')]")
    private WebElement dailyModalText;
    @FindBy(xpath = "//h1[normalize-space()='Wind Speed Hourly']")
    private WebElement windHourlyModalText;
    @FindBy(xpath = "//h1[normalize-space()='Wind Speed Daily']")
    private WebElement windDailyModalText;
    @FindBy(xpath = "(//span[@class='previous-data-arrow'])[1]")
    private WebElement prevArrow_TempHourlyTableF;
    @FindBy(xpath = "(//span[@class='previous-data-arrow'])[3]")
    private WebElement prevArrow_WindHourlyTableF;
    @FindBy(xpath = "(//span[@class='previous-data-arrow'])[2]")
    private WebElement prevArrow_DailyForecastTableF;
    @FindBy(xpath = "(//span[@class='next-data-arrow'])[2]")
    private WebElement nextArrow_DailyForecastTableF;
    @FindBy(xpath = "(//span[@class='next-data-arrow'])[1]")
    private WebElement nextArrow_TempHourlyTableF;
    @FindBy(xpath = "((//div[@class='column graph-header'])[1]//p)[2]")
    private WebElement hourlyForecastTable_TimestampF;
    @FindBy(xpath = "((//div[@class='column graph-header'])[2]//p)[2]")
    private WebElement dailyForecastTable_TimestampF;
    @FindBy(xpath = "(//*[name()='path'])[3]")
    private WebElement tempHourlyForecastTable_Graph;
    @FindBy(xpath = "((//div[@class='column graph-header'])[3]//p)[2]")
    private WebElement windHourlyTable_TimestampF;
    @FindBy(xpath = "((//div[@class='column graph-header'])[4]//p)[2]")
    private WebElement windDailyTable_TimestampF;
    @FindBy(xpath = "(//span[@class='previous-data-arrow'])[4]")
    private WebElement prevArrow_WindDailyTableF;
    @FindBy(xpath = "(//span[@class='next-data-arrow'])[4]")
    private WebElement nextArrow_WindDailyTableF;
    @FindBy(xpath = "(//span[@class='next-data-arrow'])[3]")
    private WebElement nextArrow_WindHourlyTableF;
    @FindBy(xpath = "//div[@class='site-name']")
    private WebElement siteNameW;
    @FindBy(xpath = "//div[@class='export']")
    private WebElement export;
    @FindBy(xpath = "//div[@class='graph']")
    private WebElement graph;
    @FindBy(xpath = "//div[@class='grid grid-center option item checkbox-right']")
    private WebElement site_exportPage;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='grid grid-center option item checkbox-right']")
    private WebElement site_graphPage;
    @FindBy(xpath = "(//div[@class='menu-button-container'])")
    private WebElement menuButton;
    @FindBy(xpath = "(//div[@class='button'][normalize-space()='Edit device sensors'])")
    private WebElement editDeviceSensorBtn;
    @FindBy(xpath = "(//div[@class='0 grid grid-center headers']//p)[2]")
    private WebElement port1SensorName;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='grid grid-center option']")
    private WebElement port1_Sensor2;
    @FindBy(xpath = "//div[@class='tooltip-info']//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//div[@class='success toast']")
    private WebElement successMsg;
    @FindBy(xpath = "//h1[contains(text(),'Wind Speed Hourly (')]")
    private WebElement windSpeedHourly;
    @FindBy(xpath = "//h1[contains(text(),'Wind Speed Daily (')]")
    private WebElement windSpeedDaily;
    @FindBy(xpath = "//div[@class='site-summary-card grid clickable']//h3")
    private WebElement FirstSiteName;
    @FindBy(xpath = "//p[normalize-space()='Plant']")
    private WebElement plantTag;
    @FindBy(xpath = "//div[@class='column graph-header']")
    private WebElement plantHeaderTag;
    @FindBy(xpath = "//h4[normalize-space()='Temperature']//ancestor::div[@class='column-full column-flex content']//span")
    private WebElement currentConditionsUnit;
    @FindBy(xpath = "//p[normalize-space()='Low']/ancestor::div[@class='column text-center']//span")
    private WebElement todayUnitForLow;
    @FindBy(xpath = "//p[normalize-space()='High']/ancestor::div[@class='column text-center']//span")
    private WebElement todayUnitForHigh;
    @FindBy(xpath = "//h4[normalize-space()='Pressure']//ancestor::div[@class='column-full column-flex content']//span")
    private WebElement currentConditionsUnitForPressure;
    @FindBy(xpath = "//arable-tooltip[@ng-reflect-title-tooltip='Current Conditions']//div[@class='column']//h1[text()='Current Conditions']")
    private WebElement currentConditionsTag;

    public WeatherPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyGraphPageNavigation(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(currentConditionTableF, 200, 1);
        String site = siteNameW.getText();
        graph.click();
        webDriverHelper.waitUntilVisible(site_graphPage, 200, 1);
        String site_graph = site_graphPage.getText();
        Assert.assertEquals(site_graph, site);
    }

    public void verifyExportPageNavigation(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(currentConditionTableF, 200, 1);
        String site = siteNameW.getText();
        export.click();
        webDriverHelper.waitUntilVisible(site_exportPage, 200, 1);
        String site_export = site_exportPage.getText();
        Assert.assertEquals(site_export, site);
    }

    public void verifyPrevAndNextArrow_WindDailyTable(String role) throws IOException, InterruptedException {
        Thread.sleep(2000);
        webDriverHelper.waitUntilVisible(windDailyTable_TimestampF, 200, 1);
        String timeline = windDailyTable_TimestampF.getText();
        Thread.sleep(1000);
        prevArrow_WindDailyTableF.click();
        Thread.sleep(1000);
        String timelineNew = windDailyTable_TimestampF.getText();
        Assert.assertNotEquals(timelineNew, timeline);
        Thread.sleep(1000);
        nextArrow_WindDailyTableF.click();
        Thread.sleep(1000);
        String timelineNext = windDailyTable_TimestampF.getText();
        Assert.assertEquals(timelineNext, timeline);
    }

    public void verifyPrevAndNextArrow_WindHourlyTable(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(dailyForecastTable_TimestampF, 200, 1);
        String timeline = windHourlyTable_TimestampF.getText();
        Thread.sleep(500);
        prevArrow_WindHourlyTableF.click();
        Thread.sleep(500);
        String timelineNew = windHourlyTable_TimestampF.getText();
        Assert.assertNotEquals(timelineNew, timeline);
        Thread.sleep(500);
        nextArrow_WindHourlyTableF.click();
        Thread.sleep(500);
        String timelineNext = windHourlyTable_TimestampF.getText();
        Assert.assertEquals(timelineNext, timeline);
    }

    public void verifyPrevAndNextArrow_DailyForecastTable(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(dailyForecastTable_TimestampF, 200, 1);
        String timeline = dailyForecastTable_TimestampF.getText();
        Thread.sleep(500);
        prevArrow_DailyForecastTableF.click();
        Thread.sleep(500);
        String timelineNew = dailyForecastTable_TimestampF.getText();
        Assert.assertNotEquals(timelineNew, timeline);
        Thread.sleep(500);
        nextArrow_DailyForecastTableF.click();
        Thread.sleep(500);
        String timelineNext = dailyForecastTable_TimestampF.getText();
        Assert.assertEquals(timelineNext, timeline);
    }

    public void verifyPrevAndNextArrow_HourlyForecastTable(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(hourlyForecastTable_TimestampF, 200, 1);
        String timeline = hourlyForecastTable_TimestampF.getText();
        prevArrow_TempHourlyTableF.click();
        Thread.sleep(500);
        String timelineNew = hourlyForecastTable_TimestampF.getText();
        Assert.assertNotEquals(timelineNew, timeline);
        Thread.sleep(500);
        nextArrow_TempHourlyTableF.click();
        Thread.sleep(500);
        String timelineNext = hourlyForecastTable_TimestampF.getText();
        Assert.assertEquals(timelineNext, timeline);
    }

    public void verifyWindSpeedDailyModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(windSpeedDailyText, 200, 1);
        windSpeedDailyText.click();
        webDriverHelper.waitUntilVisible(windDailyModalText, 30, 1);
        Assert.assertTrue(windDailyModalText.isDisplayed());
    }

    public void verifyWindSpeedHourlyModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(windSpeedHourlyText, 200, 1);
        windSpeedHourlyText.click();
        webDriverHelper.waitUntilVisible(windHourlyModalText, 30, 1);
        Assert.assertTrue(windHourlyModalText.isDisplayed());
    }

    public void verifyDailyForecastModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(dailyForecastText, 200, 1);
        dailyForecastText.click();
        webDriverHelper.waitUntilVisible(dailyModalText, 30, 1);
        Assert.assertTrue(dailyModalText.isDisplayed());
    }

    public void verifyCurrentConditionModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(currentConditionTableF, 200, 1);
        currentConditionsText.click();
        webDriverHelper.waitUntilVisible(currentConditionsText, 30, 1);
        Assert.assertTrue(currentConditionsText.isDisplayed());
    }

    public void verifyTodayTemperatureModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(todayTemperatureText, 200, 1);
        todayTemperatureText.click();
        webDriverHelper.waitUntilVisible(todayTemperatureModalText, 30, 1);
        Assert.assertTrue(todayTemperatureModalText.isDisplayed());
    }

    public void verifyHourlyForecastModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(hourlyForecastText, 200, 1);
        hourlyForecastText.click();
        webDriverHelper.waitUntilVisible(forecastedModalText, 30, 1);
        Assert.assertTrue(forecastedModalText.isDisplayed());
    }

    public void verifyContentsOfWeatherPage(String role) throws IOException {
        webDriverHelper.waitUntilVisible(currentConditionTableF, 200, 1);
        String weatherPageContent = siteDetails.getText();
        Assert.assertTrue(weatherPageContent.contains("Current Conditions"));
        Assert.assertTrue(weatherPageContent.contains("Today's Temperature"));
        Assert.assertTrue(weatherPageContent.contains("Hourly Forecast"));
        Assert.assertTrue(weatherPageContent.contains("Daily Forecast"));
        Assert.assertTrue(weatherPageContent.contains("Wind Speed Hourly"));
        Assert.assertTrue(weatherPageContent.contains("Wind Speed Daily"));
    }

    public void navigateToPage(String role) throws InterruptedException, IOException {
        map.navigateToPage(role);
        webDriverHelper.waitUntilVisible(map.firstSiteIdF, 300, 2);
        map.firstSiteIdF.click();

////        Thread.sleep(10000);
//        webDriverHelper.waitUntilVisible(globalOrgSelected_MapPage, 120, 1);
////--above 2 new lines added to check jenkins behaviour
//        if (!(globalOrgSelected_MapPage.getText().contains("arable-team"))) {
//            Thread.sleep(2000);
//            globalOrgDropdownBtn_MapPage.click();
//            webDriverHelper.waitUntilVisible(globalOrgDropdownSearch_MapPage, 30, 1);
//            globalOrgDropdownSearch_MapPage.sendKeys("arable-team");
//            globalOrgSearchSuggestion_MapPage.click();
//            Thread.sleep(1000);
//        }
//        webDriverHelper.waitUntilVisible(MapPage_SiteF, 300, 1);
////        Thread.sleep(5000);
//
//        site_Details_MapPage = MapPage_SiteF.getText();
//        System.out.println("site_Details_MapPage" + site_Details_MapPage);
//        MapPage_SiteF.click();
////        webDriverHelper.waitUntilVisible(currentConditionTableF, 1000, 1);
    }

    //    public void captureWeatherPageLoadTime(String role) throws IOException {
//        String loadInSeconds = null;
//        long start = System.currentTimeMillis();
//        webDriverHelper.waitUntilVisible(currentConditionTableF, 200, 1);
//        if (currentConditionTableF.isDisplayed()) {
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(currentConditionTableF.isDisplayed(), "current condition table is displayed");
//        }
//        ExcelReader.setValueForColumn("Weather", loadInSeconds, role);
//        // HTML report generator
//        HTMLReport.addPageName("Weather");
//        HTMLReport.generateReport("Weather", loadInSeconds,role);
//        HTMLReport.writeReportToFile();
//        stringHelper.benchmarkComparison(loadInSeconds);
//    }
//    public void captureWeatherPageLoadTime(String role) throws IOException, InterruptedException {
//        String loadInSeconds = null;
//        long start = System.currentTimeMillis();
////        StringHelper.devToolCapture(role);
////        try {
//        webDriverHelper.waitUntilVisible(currentConditionTableF, 30, 1);
//        if (currentConditionTableF.isDisplayed()) {
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(currentConditionTableF.isDisplayed(), "Current condition table is displayed");
////            }
////        } catch (TimeoutException e) {
////            // Handling timeout by performing additional steps
////            plantTab.plantPageTab.click();
////            Thread.sleep(500);
////            weatherPageTab.click();
////            // Wait again for currentConditionTableF
////            webDriverHelper.waitUntilVisible(currentConditionTableF, 30, 1);
////
////            loadInSeconds = stringHelper.stopTime(start, driver);
////            Assert.assertTrue(currentConditionTableF.isDisplayed(), "Current condition table is displayed");
////        }
//
//            ExcelReader.setValueForColumn("Weather", loadInSeconds, role);
//
//            // HTML report generator
//            HTMLReport.addPageName("Weather");
////        HTMLReport.generateReport("Weather", loadInSeconds, role);
//            HTMLReport.writeReportToFile();
//            stringHelper.benchmarkComparison(loadInSeconds);
//        }
//    }

    public void verifyEditDeviceSensor(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(currentConditionTableF, 200, 1);
        if (menuButton.isDisplayed()) {
            menuButton.click();
            webDriverHelper.waitUntilVisible(editDeviceSensorBtn, 200, 1);
            editDeviceSensorBtn.click();
            webDriverHelper.waitUntilVisible(port1SensorName, 200, 1);
            String defaultSensor = port1SensorName.getText();
            port1SensorName.click();
            webDriverHelper.waitUntilVisible(port1_Sensor2, 200, 1);
            port1_Sensor2.click();
            Thread.sleep(500);
            String newSensor = port1SensorName.getText();
            confirmBtn.click();
            webDriverHelper.waitUntilVisible(successMsg, 200, 1);
            menuButton.click();
            webDriverHelper.waitUntilVisible(editDeviceSensorBtn, 200, 1);
            editDeviceSensorBtn.click();
            webDriverHelper.waitUntilVisible(port1SensorName, 200, 1);
            String updatedSensor = port1SensorName.getText();
            Assert.assertNotEquals(updatedSensor, defaultSensor);
        } else {
            Assert.assertFalse((menuButton).isDisplayed(), "no menu button");
        }
    }

    public void verifyLoadingMessage() {
        webDriverHelper.waitUntilVisible(loadingWeatherInfoF, 200, 1);
        Assert.assertEquals(loadingWeatherInfoF.getAttribute("ng-reflect-label"), "Loading Weather Info...");
    }

    public void verifySiteName() {
        webDriverHelper.waitUntilTextToBePresentInElement(siteNameF, 30, 1, siteName);
        Assert.assertEquals(siteNameF.getText(), siteName);
    }

    public void verifyCurrentConditionsText() {
        webDriverHelper.waitUntilVisible(currentConditionTableF, 200, 1);
        webDriverHelper.waitAttributeNotEmpty(currentTableToolTipF, "ng-reflect-title-tooltip", 30, 1);
        Assert.assertTrue(currentTableToolTipF.getAttribute("ng-reflect-title-tooltip").equalsIgnoreCase("Current Conditions"));
    }

    public void verifyCurrentConditionsTempValue() {
        String value = currentTempValueF.getText();
        System.out.println("currentTempValueF" + value);
        Assert.assertTrue(value.contains(tAir), "Site display incorrect temperature value");
        Assert.assertTrue(value.contains(tempUnit), "Site display incorrect temperature unit");
    }

    public void verifyCurrentConditionsHumidityValue() {
        String value = currentHumidityValueF.getText();
        Assert.assertTrue(value.contains(rh), "Site display incorrect humidity value");
        Assert.assertTrue(value.contains("%"), "Site display incorrect humidity unit");
    }

    public void verifyCurrentConditionsPressureValue() {
        String value = currentPressureValueF.getText();
        Assert.assertTrue(value.contains(slp), "Site display incorrect pressure value");
        String unit = currentPressureUnitF.getText();
        Assert.assertTrue(value.contains(unit), "Site display incorrect pressure unit");
    }

    public void verifyCurrentConditionsSolarValue() {
        String value = currentSolarValueF.getText();
        Assert.assertTrue(value.contains(sun), "Site display incorrect solar value");
        Assert.assertTrue(value.contains("W/m²"), "Site display incorrect solar unit");
    }

    public void verifyTheWindUnitInWeatherPage() throws InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(FirstSiteName, 60, 10);
            Thread.sleep(1000);
            FirstSiteName.click();
            webDriverHelper.waitUntilVisible(windSpeedHourly, 60, 10);
            String windSpeedHourlyName = windSpeedHourly.getText();
            Assert.assertTrue(windSpeedHourlyName.contains(speedUnit), "the speed unit is not matching on the weather page on the windSpeedHourly tag");
            String windSpeedDailyName = windSpeedDaily.getText();
            Assert.assertTrue(windSpeedDailyName.contains(speedUnit), "the speed unit is not matching on the weather page on the windSpeedDailyName tag");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheWindUnitInWeatherPage.jpg");
            Assert.fail("The exception in the verifyTheWindUnitInWeatherPage" + exc);
        }
    }

    public void verifyTheWindUnitInPlantPage() throws InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(FirstSiteName, 60, 10);
            FirstSiteName.click();
            Thread.sleep(10000);
            webDriverHelper.waitUntilVisible(plantTag, 60, 1);
            plantTag.click();
            webDriverHelper.waitUntilVisible(plantHeaderTag, 120, 1);
            if (Objects.equals(sizeUnit, "in")) {
                sizeUnit = String.valueOf('"');
            }
            for (WebElement sizeUnitValidationInETcEToPrecipitations : sizeUnitValidationInETcEToPrecipitation) {
                String sizeUnitValidationInETcEToPrecipitationName = sizeUnitValidationInETcEToPrecipitations.getText();
                Assert.assertTrue(sizeUnitValidationInETcEToPrecipitationName.contains(sizeUnit), "the size unit is not matching in the plant page");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheWindUnitInPlantPage.jpg");
            Assert.fail("The exception in the verifyTheWindUnitInPlantPage" + exc);
        }
    }

    public void verifyTheTempUnitInWeatherPage() throws InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(FirstSiteName, 60, 10);
            Thread.sleep(1000);
            FirstSiteName.click();
            webDriverHelper.waitUntilVisible(currentConditionsUnit, 60, 1);
            String currentConditionsUnits = currentConditionsUnit.getText();
            String todayUnitForLows = todayUnitForLow.getText();
            String todayUnitForHighs = todayUnitForHigh.getText();
            System.out.println("currentConditionsUnits " + currentConditionsUnits);
            System.out.println("tempUnit " + tempUnit);
            Assert.assertTrue(currentConditionsUnits.contains(tempUnit), "the temp unit is not matching on the weather page");
            Assert.assertTrue(todayUnitForLows.contains(tempUnit), "the temp unit for low is not matching on the weather page");
            Assert.assertTrue(todayUnitForHighs.contains(tempUnit), "the temp unit for high is not matching on the weather page");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheTempUnitInWeatherPage.jpg");
            Assert.fail("The exception in the verifyTheTempUnitInWeatherPage" + exc);
        }
    }

    public void verifyThePressureUnitInWeatherPage() {
        try {
            map.navigateToMapPage();
            webDriverHelper.waitUntilVisible(FirstSiteName, 60, 10);
            FirstSiteName.click();
            webDriverHelper.scrollToWebElement(currentConditionsTag);
//            webDriverHelper.waitUntilVisible(currentConditionsTag, 10, 10);
            webDriverHelper.waitUntilVisible(currentConditionsUnitForPressure, 60, 1);
            String currentConditionsUnitForPressureUnit = currentConditionsUnitForPressure.getText();
            Assert.assertTrue(currentConditionsUnitForPressureUnit.contains(presUnit), "the pressure unit is not matching on the weather page");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyThePressureUnitInWeatherPage.jpg");
            Assert.fail("The exception in the verifyThePressureUnitInWeatherPage" + exc);
        }
    }

}