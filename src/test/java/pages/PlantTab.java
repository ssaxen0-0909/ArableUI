package pages;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.Constants;
import support.PlantAPIHelper;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static support.World.*;

public class PlantTab {

    private final WebDriver driver;

    public long start;
    public String loadInSeconds = null;
    @FindBy(xpath = "//p[normalize-space()='Plant']")
    WebElement plantPageTab;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='Precipitation']")
    WebElement precipitation;
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
    @FindBy(xpath = "//div[@class='single-irrigation-report']")
    private WebElement irrigationTable;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='Canopy Evapotranspiration']")
    private WebElement canopyEvapotranspiration;
    @FindBy(xpath = "//div[@class='modal fade in show']//img[@alt='icon_close']")
    private WebElement closeModal;
    @FindBy(xpath = "//h1[@class='fancy-link'][contains(text(),'GDD')]")
    private WebElement gDD;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='Chlorophyll Index']")
    private WebElement chlorophyllIndex;
    @FindBy(xpath = "//h1[@class='fancy-link'][normalize-space()='NDVI']")
    private WebElement NDVI;
    @FindBy(xpath = "//p[contains(text(),'NDVI, or Normalized Differential Vegetation Index,')]")
    private WebElement ndvi_modalText;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='text-modal']")
    private WebElement cI_ModalInfoText;
    @FindBy(xpath = "//p[contains(text(),'s current growing season start date.')]")
    private WebElement gdd_ModalInfoText;
    @FindBy(xpath = "//div[@class='text-modal']//p[contains(text(),'Evapotranspiration is the amount of water a plant loses in a day')]")
    private WebElement canopy_ModalInfoText;
    @FindBy(xpath = "//div[@class='text-modal']//p[contains(text(),'forecast. Forecasted values are applied from the c')]")
    private WebElement precip_ModalInfoText;
    @FindBy(xpath = "//div[@class='column date-type-value title-value header-trip-class']//button[@class='fancy-link']")
    private WebElement currentDayText;
    @FindBy(xpath = "//h1[normalize-space()='Today']")
    private WebElement todayModalInfo;
    @FindBy(xpath = "//div[@class='site-name']")
    private WebElement siteNameW;
    @FindBy(xpath = "//span[normalize-space()='Export']")
    private WebElement export;
    @FindBy(xpath = "//span[normalize-space()='Graph']")
    private WebElement graph;
    @FindBy(xpath = "//div[@class='grid grid-center option item checkbox-right']")
    private WebElement site_exportPage;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='grid grid-center option item checkbox-right']")
    private WebElement site_graphPage;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Canopy Evapotranspiration']//div[@class='column-full column-flex content']//div[1]//p[1]")
    private WebElement canopy_Last7days;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Canopy Evapotranspiration']//div[@class='card-body']//div[2]//p[1]")
    private WebElement canopy_Next7days;
    @FindBy(xpath = "(//div[@id='total-etc'])[1]")
    private WebElement etc_Last7daysValueFromTable;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Precipitation']//div[@class='column-full column-flex content']//div[1]//p[1]")
    private WebElement precip_Last7days;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Precipitation']//div[@class='card-body']//div[2]//p[1]")
    private WebElement precip_Next7days;
    @FindBy(xpath = "//div[@id='total-precip']")
    private WebElement precip_Last7daysValueFromTable;
    @FindBy(xpath = "//span[@class='next-data-arrow']")
    private WebElement nextDayArrowButton;
    @FindBy(xpath = "//span[@class='previous-data-arrow']")
    private WebElement prevDayArrowButton;
    @FindAll(@FindBy(xpath = "//div[@class='grid gridbody']//div//div[2]//p[1]"))
    private List<WebElement> etc_defaultValuesForWeek;
    @FindBy(xpath = "(//div[@id='total-etc'])[1]")
    private WebElement etc_WeeklyInsightValue;
    @FindBy(xpath = "//div[@class='site-card']")
    private List<WebElement> siteCard;
    @FindBy(xpath = "//a[contains(text(),'View Site Data >')]")
    private WebElement viewSiteData;
    @FindBy(xpath = "(//img[@alt='info'])[1]")
    private WebElement overviewInfoIcon;
    @FindBy(xpath = "//div[@class='tooltip']//div[@class= 'tooltiptext left-style']//div[@class='tooltip-heading']")
    private WebElement overviewInfoIconText;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='GDD<span></span> / Growth stag']")
    private WebElement gddGraphSection;
    @FindBy(xpath = "//*[name()='g' and contains(@class,'raphael-gr')]//*[name()='g' and contains(@class,'raphael-gr')]//*[name()='g' and contains(@class,'raphael-gr')]//*[name()='rect' and contains(@y,'0')]")
    private WebElement gddGraphBar;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Chlorophyll Index']//div[@class='column-full column-flex content']//div[1]")
    private WebElement clSectionWithValue;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='NDVI']//div[@class='column-full column-flex content']//div[1]")
    private WebElement ndviSectionWithValue;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='NDVI']")
    private WebElement ndviTile;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Chlorophyll Index']//div[@class='column-full column-flex content']//div[2]")
    private WebElement clPercentageChange;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='NDVI']//div[@class='column-full column-flex content']//div[2]")
    private WebElement ndviPercentageChange;
    @FindBy(xpath = "(//div[@class='etc-values-section']//span)[19]")
    private WebElement etcSectionWithValue;
    @FindBy(xpath = " (//div[@class='line-chart-overlay'])[1]")
    private WebElement etcBarWithValue;

    public double yesterdayClValue;
    public double yesterdayNdviValue;
    String forecastCanopyValue;
    String forecastPrecipitationValue;
    String pastPrecipitationValue;

    public PlantTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyCurrentNDVIValue(String siteId) throws InterruptedException {
        webDriverHelper.waitUntilVisible(precip_Last7daysValueFromTable, 90, 1);
        String ndviValueInUI = ndviSectionWithValue.getText();
        System.out.println("NDVI value from UI: " + ndviValueInUI);
        String regex = "-?\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ndviValueInUI);
        String numericalValueStr = "";
        if (!matcher.find()) {
            System.out.println("Integer NDVI value not found: ");
        }
        else {
            numericalValueStr = matcher.group();
            double numericalValue = Double.parseDouble(numericalValueStr);
            if (numericalValueStr == null) {
                numericalValue = 0;
            }
            System.out.println("numericalValue: " + numericalValue);
            teamsApiHelper.getAuthToken();
            PlantAPIHelper plantAPIHelper = new PlantAPIHelper();
            double ndviValue = plantAPIHelper.plantAPIResponseNDVI(siteId);
            System.out.println("ndviValue received from plantAPIResponse: " + ndviValue);
            yesterdayNdviValue = ndviValue;
            Assert.assertEquals(numericalValue, ndviValue);
        }
    }

    public void verifyPastNDVIValue(String siteId) throws InterruptedException {
        webDriverHelper.waitUntilVisible(ndviTile, 90, 1);
        String ndviPercengateInUI = ndviPercentageChange.getText();
        System.out.println("NDVI % from UI: " + ndviPercengateInUI);
        String regex = "-?\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ndviPercengateInUI);
        String numericalValueStr = "";
        if (!matcher.find()) {
            System.out.println("Integer not found for % change in UI");
            teamsApiHelper.getAuthToken();
            PlantAPIHelper plantAPIHelper = new PlantAPIHelper();
            double PastNDVIValue = plantAPIHelper.getPastDateClValueplantAPIResponse(siteId);
            if (PastNDVIValue == 0.0) {
                System.out.println("No past records found for NDVI ");
                Assert.assertEquals(PastNDVIValue, 0.0);
                Assert.assertEquals(numericalValueStr, "");
            }
        } else {
            numericalValueStr = matcher.group();
            double numericalValue = Double.parseDouble(numericalValueStr);
            System.out.println("past value for calculation " + yesterdayNdviValue);
            teamsApiHelper.getAuthToken();
            PlantAPIHelper plantAPIHelper = new PlantAPIHelper();
            double PastNdviValue = plantAPIHelper.getPastDateNDVIValueplantAPIResponse(siteId);
            System.out.println("past numericalValue: " + yesterdayNdviValue + " " + PastNdviValue);
            double ndviPercentageChange = ((yesterdayNdviValue - PastNdviValue) / PastNdviValue) * 100;
            double roundedNdviPercentage;
            double decimalPartPercentage = ndviPercentageChange - Math.floor(ndviPercentageChange);
            if (decimalPartPercentage >= 0.5) {
                roundedNdviPercentage = Math.ceil(ndviPercentageChange);
            } else {
                roundedNdviPercentage = Math.floor(ndviPercentageChange);
            }
            Assert.assertEquals(numericalValue, roundedNdviPercentage);
        }
    }

    public void verifyCurrentETcValue (String siteId) throws InterruptedException {
        webDriverHelper.waitUntilVisible(precip_Last7daysValueFromTable, 90, 1);
        String ETcValueInUI = etcSectionWithValue.getText();
        System.out.println("ETc value from UI: " + ETcValueInUI);
        String regex = "-?\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ETcValueInUI);
        String numericalValueStr = "";
        while (matcher.find()) {
            numericalValueStr = matcher.group();
        }
        double numericalValue = Double.parseDouble(numericalValueStr);
        System.out.println("numericalValue: " + numericalValue);
        teamsApiHelper.getAuthToken();
        PlantAPIHelper plantAPIHelper = new PlantAPIHelper();
        double ETcValue = plantAPIHelper.plantAPIResponseETc(siteId);
        System.out.println("ETc Value received from plantAPIResponse: " + ETcValue);
        Assert.assertEquals(numericalValue, ETcValue);
    }

    public void verifyCurrentCLValue(String siteId) throws InterruptedException {
        webDriverHelper.waitUntilVisible(precip_Last7daysValueFromTable, 90, 1);
        String clValueInUI = clSectionWithValue.getText();
        System.out.println("CL value from UI: " + clValueInUI);
        String regex = "-?\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(clValueInUI);
        String numericalValueStr = "";
        if (!matcher.find()) {
            System.out.println("Integer Cl value not found: ");
        }
        else {
            numericalValueStr = matcher.group();
            double numericalValue = Double.parseDouble(numericalValueStr);
            if (numericalValueStr == null) {
                numericalValue = 0;
            }
            System.out.println("numericalValue: " + numericalValue);
            teamsApiHelper.getAuthToken();
            PlantAPIHelper plantAPIHelper = new PlantAPIHelper();
            double clValue = plantAPIHelper.plantAPIResponse(siteId);
            System.out.println("clValue received from plantAPIResponse: " + clValue);
            yesterdayClValue = clValue;
            Assert.assertEquals(numericalValue, clValue);
        }
    }

    public void verifyPastCLValue(String siteId) throws InterruptedException {
        webDriverHelper.waitUntilVisible(precip_Last7daysValueFromTable, 90, 1);
        String clPercengateInUI=clPercentageChange.getText();
        System.out.println("CL % from UI: " + clPercengateInUI);
        String regex = "-?\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(clPercengateInUI);
        String numericalValueStr = "";
        if (!matcher.find()) {
            System.out.println("Integer not found for % change in UI");
            teamsApiHelper.getAuthToken();
            PlantAPIHelper plantAPIHelper = new PlantAPIHelper();
            double PastClValue = plantAPIHelper.getPastDateClValueplantAPIResponse(siteId);
            if(PastClValue == 0.0){
                System.out.println("No past records found for Cl ");
                Assert.assertEquals(PastClValue, 0.0);
                Assert.assertEquals(numericalValueStr, "");
            }
        }
        else {
            numericalValueStr = matcher.group();
            double numericalValue = Double.parseDouble(numericalValueStr);
            teamsApiHelper.getAuthToken();
            PlantAPIHelper plantAPIHelper = new PlantAPIHelper();
            double PastClValue = plantAPIHelper.getPastDateClValueplantAPIResponse(siteId);
            double clPercentageChange = ((yesterdayClValue - PastClValue) / PastClValue) * 100;
            double roundedClPercentage;
            double decimalPartPercentage = clPercentageChange - Math.floor(clPercentageChange);
            if (decimalPartPercentage >= 0.5) {
                roundedClPercentage = Math.ceil(clPercentageChange);
            } else {
                roundedClPercentage = Math.floor(clPercentageChange);
            }
            Assert.assertEquals(numericalValue, roundedClPercentage);
        }
    }

    public void verifyInfoIconText(String siteId) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(overviewInfoIcon).build().perform();
        System.out.println("Done Mouse hover on infoIcon");
        Thread.sleep(1000);
        String text = overviewInfoIconText.getText();
        System.out.println("text:-" + text);
        Assert.assertEquals(text, Constants.infoIconTooltipTextInIrrigationOverview);
    }

    public void verifyGDDGraph(String role) {
        webDriverHelper.waitUntilVisible(precip_Last7daysValueFromTable, 90, 1);
        if (gddGraphSection.isDisplayed()) {
            System.out.println("gddGraphSection.getText().contains(\"No current season\"):- " + gddGraphSection.getText().contains("No current season"));
            Assert.assertTrue(gddGraphSection.getText().contains("No current season"));
        } else {
            System.out.println("gddGraphBar.isDisplayed():-" + gddGraphBar.isDisplayed());
            Assert.assertTrue(gddGraphBar.isDisplayed());
        }
    }

    public void verifyAllValuesForETcValue(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(precip_Last7daysValueFromTable, 90, 1);
        List<String> responseText = new ArrayList<>();
        for (int i = 0; i < etc_defaultValuesForWeek.size() - 1; i++) {
            responseText.add(etc_defaultValuesForWeek.get(i).getText());
            System.out.println("responseText:-  " + responseText);
        }
        List<Double> list = responseText.stream().map(NumberUtils::toDouble).collect(Collectors.toList());
        System.out.println("intList:-  " + list);
        Double total = list.stream().mapToDouble(i -> i).sum();
        System.out.println("total value:-  " + total);
        String sumUpValue = Double.toString(total);
        String totalValue = etc_WeeklyInsightValue.getText();
        if (sumUpValue.contains("0.0")) {
            Assert.assertFalse(Boolean.parseBoolean(sumUpValue), totalValue);
        } else {
            Assert.assertTrue(totalValue.contains(sumUpValue));
        }
    }

    public void verifyNext7daysPrecipValue(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(precip_Next7days, 90, 1);
        String precipNextSevenDaysValue = precip_Next7days.getText();
        for (int i = 0; i <= 3; i++) {
            nextDayArrowButton.click();
        }
        Thread.sleep(500);
        String precip_NextSevenDaysValue = precip_Last7daysValueFromTable.getText();
        if (precipNextSevenDaysValue.contains("0.00") & precip_NextSevenDaysValue.contains("0")) {
            Assert.assertFalse(precip_NextSevenDaysValue.contains(precipNextSevenDaysValue));
        } else {
            Assert.assertTrue(precip_NextSevenDaysValue.contains(precipNextSevenDaysValue));
        }
    }

    public void verifyNext7daysCanopyValueFromAPI(String siteID) {
        double forecastApiValue = plantApiHelper.getForecastCanopyValuePlantAPIResponse(siteID);
//        DecimalFormat df = new DecimalFormat("0.00");
//        String roundvalue = df.format(forecastApiValue);

        double numericalValue = 0;
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(forecastCanopyValue);
        while (matcher.find()) {
            try {
                String d = matcher.group();
                numericalValue = Double.parseDouble(d);
            } catch (NumberFormatException e) {
                // Skip if it's not a valid double
            }
        }
        Assert.assertEquals(numericalValue, forecastApiValue);
    }

    public void verifyNext7daysCanopyValue(String siteID) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(canopy_Next7days, 90, 1);
        String canopyNextSevenDaysValue = canopy_Next7days.getText();
        Thread.sleep(500);
        for (int i = 0; i <= 3; i++) {
            nextDayArrowButton.click();
        }
        Thread.sleep(500);
        String etc_NextSevenDaysValue = etc_Last7daysValueFromTable.getText();
        forecastCanopyValue = etc_NextSevenDaysValue;
        if (canopyNextSevenDaysValue.contains("0.00") & etc_NextSevenDaysValue.contains("0")) {
            Assert.assertFalse(etc_NextSevenDaysValue.contains(canopyNextSevenDaysValue));
        } else {
            Assert.assertTrue(etc_NextSevenDaysValue.contains(canopyNextSevenDaysValue));
        }
    }

    public void verifyNext7daysPrecipitationValue(String siteID) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(precip_Next7days, 90, 1);
        String precipitationNextSevenDaysValue = precip_Next7days.getText();
        System.out.println("Precipitation Next Seven Days Value "+precipitationNextSevenDaysValue);
        Thread.sleep(500);
        for (int i = 0; i <= 3; i++) {
            nextDayArrowButton.click();
        }
        Thread.sleep(500);
        String precip_NextSevenDaysValue = precip_Next7days.getText();
        forecastPrecipitationValue = precip_NextSevenDaysValue;
        if (precipitationNextSevenDaysValue.contains("0.00") & precip_NextSevenDaysValue.contains("0")) {
            Assert.assertTrue(precip_NextSevenDaysValue.contains(precipitationNextSevenDaysValue));
        } else {
            Assert.assertTrue(precip_NextSevenDaysValue.contains(precipitationNextSevenDaysValue));
        }
    }

    public void verifyPast7daysPrecipitationValue(String siteID) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(precip_Next7days, 90, 1);
        String precipitationPastSevenDaysValue = precip_Last7days.getText();
        System.out.println("Precipitation Next Seven Days Value "+precipitationPastSevenDaysValue);
        Thread.sleep(500);
        for (int i = 0; i <= 3; i++) {
            nextDayArrowButton.click();
        }
        Thread.sleep(500);
        String precip_PastSevenDaysValue = precip_Last7days.getText();
        System.out.println("testing precip_PastSevenDaysValue "+precip_PastSevenDaysValue);
        pastPrecipitationValue = precip_PastSevenDaysValue;
        if (precipitationPastSevenDaysValue.contains("0.00") & precip_PastSevenDaysValue.contains("0")) {
            Assert.assertTrue(precip_PastSevenDaysValue.contains(precipitationPastSevenDaysValue));
        } else {
            Assert.assertTrue(precip_PastSevenDaysValue.contains(precipitationPastSevenDaysValue));
        }
    }

    public void verifyNext7daysCanopyAPIValue(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(canopy_Next7days, 90, 1);
        String canopyNextSevenDaysValue = canopy_Next7days.getText();
        System.out.println("testing canopyNextSevenDaysValue "+canopyNextSevenDaysValue);
        Thread.sleep(5000);
        for (int i = 0; i <= 3; i++) {
            nextDayArrowButton.click();
        }
        Thread.sleep(500);
        String etc_NextSevenDaysValue = etc_Last7daysValueFromTable.getText();
        if (canopyNextSevenDaysValue.contains("0.00") & etc_NextSevenDaysValue.contains("0")) {
            Assert.assertFalse(etc_NextSevenDaysValue.contains(canopyNextSevenDaysValue));
        } else {
            Assert.assertTrue(etc_NextSevenDaysValue.contains(canopyNextSevenDaysValue));
        }
    }

    public void verifyLast7daysPrecipValue(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(precip_Last7days, 90, 1);
        String precipLastWeekValue = precip_Last7days.getText();
        for (int i = 0; i <= 3; i++) {
            prevDayArrowButton.click();
            Thread.sleep(1000);
        }
        String precip_LastWeekValue = precip_Last7daysValueFromTable.getText();
        forecastPrecipitationValue = precip_LastWeekValue;
        if (precipLastWeekValue.contains("0.00") & precip_LastWeekValue.contains("0")) {
            Assert.assertFalse(precip_LastWeekValue.contains(precipLastWeekValue));
        } else {
            Assert.assertTrue(precip_LastWeekValue.contains(precipLastWeekValue));
        }
    }

    public void verifyLast7daysCanopyValue(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(canopy_Last7days, 90, 1);
        String canopyLastWeekValue = canopy_Last7days.getText();
        Thread.sleep(5000);
        System.out.println("canopyLastWeekValue :- " + canopyLastWeekValue);
        for (int i = 0; i <= 3; i++) {
            prevDayArrowButton.click();
            Thread.sleep(1000);
        }
        String etc_LastWeekValue = etc_Last7daysValueFromTable.getText();
        System.out.println("etc_LastWeekValue :- " + etc_LastWeekValue);
        if (canopyLastWeekValue.contains("0.0") & etc_LastWeekValue.contains("0")) {
            Assert.assertFalse(etc_LastWeekValue.contains(canopyLastWeekValue));
        } else {
            Assert.assertTrue(etc_LastWeekValue.contains(canopyLastWeekValue));
        }
    }

    public void verifyNext7daysPrecipitationValueFromAPI(String siteID) {
        double forecastApiValue = plantApiHelper.getForecastPrecipitationValuePlantAPIResponse(siteID);
        double numericalValue = 0;
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(forecastPrecipitationValue);
        while (matcher.find()) {
            try {
                String d = matcher.group();
                numericalValue = Double.parseDouble(d);
            } catch (NumberFormatException e) {
                // Skip if it's not a valid double
            }
        }
        Assert.assertEquals(numericalValue, forecastApiValue);
    }

    public void verifyPast7daysPrecipitationValueFromAPI(String siteID) {
        double pastApiValue = plantApiHelper.getPastPrecipitationValuePlantAPIResponse(siteID);

        double numericalValue = 0;
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(pastPrecipitationValue);
        while (matcher.find()) {
            try {
                String d = matcher.group();
                numericalValue = Double.parseDouble(d);
            } catch (NumberFormatException e) {
                // Skip if it's not a valid double
            }
        }
        Assert.assertEquals(numericalValue, pastApiValue);
    }

    public void verifyCurrentDayModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(currentDayText, 90, 1);
        currentDayText.click();
        webDriverHelper.waitUntilVisible(todayModalInfo, 90, 1);
        Assert.assertTrue(todayModalInfo.isDisplayed(), "modal text is displayed");
        closeModal.click();
    }

    public void verifyNDVIModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(NDVI, 90, 1);
        NDVI.click();
        webDriverHelper.waitUntilVisible(ndvi_modalText, 90, 1);
        Assert.assertTrue(ndvi_modalText.isDisplayed(), "modal text is displayed");
        closeModal.click();
    }

    public void verifyCIModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(chlorophyllIndex, 90, 1);
        chlorophyllIndex.click();
        webDriverHelper.waitUntilVisible(cI_ModalInfoText, 90, 1);
        String modalText = cI_ModalInfoText.getText();
        System.out.println("modalText:- " + modalText);
        System.out.println("Constants.ciModalText:- " + Constants.ciModalText);
        Assert.assertEquals(modalText, Constants.ciModalText);
        closeModal.click();
    }

    public void verifyGDDModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(gDD, 90, 1);
        gDD.click();
        webDriverHelper.waitUntilVisible(gdd_ModalInfoText, 90, 1);
        Assert.assertTrue(gdd_ModalInfoText.isDisplayed(), "modal text is displayed");
        closeModal.click();
    }

    public void verifyPrecipModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(precipitation, 90, 1);
        precipitation.click();
        webDriverHelper.waitUntilVisible(precip_ModalInfoText, 90, 1);
        Assert.assertTrue(precip_ModalInfoText.isDisplayed(), "modal text is displayed");
        closeModal.click();
    }

    public void verifyCanopyModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(canopyEvapotranspiration, 90, 1);
        canopyEvapotranspiration.click();
        webDriverHelper.waitUntilVisible(canopy_ModalInfoText, 90, 1);
        Assert.assertTrue(canopy_ModalInfoText.isDisplayed(), "modal text is displayed");
        closeModal.click();
    }

    public void navigationToPlantTab(String role) throws IOException, InterruptedException {
        map.navigateToPage(role);
        webDriverHelper.waitUntilVisible(map.firstSiteIdF, 300, 2);
        map.firstSiteIdF.click();
        webDriverHelper.waitUntilVisible(currentConditionTableF, 200, 1);
        webDriverHelper.waitUntilVisible(plantPageTab, 30, 1);
        loadInSeconds = null;
        plantPageTab.click();
//        StringHelper.devToolCapture(role);
    }

    public void verifyGraphPageNavigation(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(gDD, 90, 1);
        String site = siteNameW.getText();
        graph.click();
        webDriverHelper.waitUntilVisible(site_graphPage, 200, 1);
        String site_graph = site_graphPage.getText();
        Assert.assertEquals(site_graph, site);
    }

    public void verifyExportPageNavigation(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(gDD, 90, 1);
        String site = siteNameW.getText();
        export.click();
        webDriverHelper.waitUntilVisible(site_exportPage, 20, 1);
        String site_export = site_exportPage.getText();
        Assert.assertEquals(site_export, site);
    }
}
