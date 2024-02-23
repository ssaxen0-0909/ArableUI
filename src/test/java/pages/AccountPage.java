package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.Constants;
import support.PropertiesReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static support.World.*;

public class AccountPage {

    private final WebDriver driver;
    public String accountSizeUnit;
    public String sizesUnit = "";
    public String rainUnits;
    public String temperatureUnit = "";
    public String gradientBarTemp;
    public String loadInSeconds = null;
    public long start;
    public String unitsForSpeed;
    public String apiUnitsForSpeed;
    public String unitsForSize;
    public String apiUnitsForSize;
    public String unitsForTemp;
    public String apiUnitsForTemp;
    public String apiUnitsForPressure;
    String currentWindUnit = "";
    @FindBy(xpath = "//div[@class='column-auto measure text-center']")
    WebElement measurement_gradientBar_MapPage;
    @FindBy(xpath = "(//span[@class='measure'])[2]")
    WebElement mapPage_Rain_Units;
    @FindBy(xpath = "//div[@id='user-api-key']//input")
    WebElement account_GenerateKey;
    @FindBy(xpath = "//img[@src='/img/icons/copy.svg']")
    WebElement account_GenerateKey_CopyBtn;
    //    @FindBy(xpath = "//div[@class='refresh-api-key ng-tns-c133-0 ng-star-inserted']")
//    private WebElement account_GenerateKey_RefreshBtn;
    //    @FindBy(xpath = "//div[@class='api-key ng-tns-c133-0 ng-trigger ng-trigger-toggleApikey']")
//    private WebElement account_GeneratedAPIKey;
    @FindBy(xpath = "//img[@src='/img/icons/refresh.svg']")
    WebElement account_GenerateKey_RefreshBtn;
    @FindBy(xpath = "//img[@src='/img/icons/copy.svg']")
    WebElement account_GeneratedAPIKey;
    @FindBy(xpath = "//h3[normalize-space()='Apikey has been copied.']")
    WebElement account_successToast_CopyAPIKey;
    @FindBy(xpath = "//label[@for='distance_millimeters']")
    WebElement account_sizeUnits_mm;
    @FindBy(xpath = "//p[normalize-space()='Settings']")
    WebElement dashboardMenu_Settings;
    @FindBy(xpath = "//p[normalize-space()='Account']")
    WebElement dashboardMenu_Account;
    @FindBy(xpath = "//button[contains(@class, 'button-save')]")
    WebElement account_SaveBtn;
    @FindBy(xpath = "(//h3[normalize-space()='Successfully Saved'])[1]")
    WebElement account_SuccessToast_UnitsChange;
    @FindBy(xpath = "//label[@for='distance_inches']")
    WebElement accountPage_size_Units_Inch;
    @FindBy(xpath = "//label[@for='distance_millimeters']")
    WebElement accountPage_size_Units_MM;
    @FindBy(xpath = "//label[@for='temperature_fahrenheit']")
    WebElement accountPage_temp_Units_F;
    @FindBy(xpath = "//label[@for='temperature_celsius']")
    WebElement accountPage_temp_Units_C;
    @FindBy(xpath = "//label[@for='pressure_millibars']")
    WebElement accountPage_pressure_Units_mb;
    @FindBy(xpath = "//label[@for='pressure_kilo_pascals']")
    WebElement accountPage_pressure_Units_kp;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailF;
    @FindBy(xpath = "(//div[@class='column']/arable-radio-button)[1]")
    private WebElement unitInfoF;
    //    @FindBy(xpath = "(//div[@class='column']/arable-radio-button)[1]")
//    private WebElement sizeUnitF;
//    @FindBy(xpath = "(//div[@class='column ng-tns-c133-0']/arable-radio-button)[1]")
//    private WebElement sizeUnitF;
    @FindBy(xpath = "(//div[@class='grid ng-tns-c96-0'])[1]")
    private WebElement sizeUnitF;
    @FindBy(xpath = "(//div[@class='grid ng-tns-c96-0'])[3]")
    private WebElement pressureUnitF;
    //    @FindBy(xpath = "(//div[@class='column ng-tns-c133-0']/arable-radio-button)[2]")
//    private WebElement pressureUnitF;
    @FindBy(xpath = "(//div[@class='column']/arable-radio-button)[3]")
    private WebElement volumeUnitF;
    //    @FindBy(xpath = "(//div[@class='column']/arable-radio-button)[4]")
//    private WebElement speedUnitF;
    //    @FindBy(xpath = "//div[@class='column-auto']/arable-button-list")
//    private WebElement temperatureUnitF;
    @FindBy(xpath = "(//div[@class='column ng-tns-c133-0']/arable-radio-button)[4]")
    private WebElement speedUnitF;
    @FindBy(xpath = "//arable-button-list[@name='temperature']")
    private WebElement temperatureUnitF;
    @FindBy(xpath = "//label[@for='distance_inches']")
    private WebElement account_sizeUnits_Inches;
    @FindBy(xpath = "//arable-dropdown-selector[@class='meassure-selector']//div[@class='column']")
    private WebElement measurementSelected_MapPage;
    @FindAll(@FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='grid grid-center option ng-star-inserted']"))
    private List<WebElement> measurements_MapPage;
    @FindBy(xpath = "(//span[@class='0 caret'])[1]")
    private WebElement measurementDropdownOpenBtn_MapPage;
    @FindBy(xpath = "//p[@class='1 selected']")
    private WebElement globalOrgSelected_MapPage;
    @FindBy(xpath = "//span[@class='1 caret']")
    private WebElement globalOrgDropdownBtn_MapPage;
    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//input[@type='search']")
    private WebElement globalOrgDropdownSearch_MapPage;
    @FindBy(xpath = "//p[normalize-space()='arable-team']")
    private WebElement globalOrgSearchSuggestion_MapPage;
    @FindBy(xpath = "(//arable-site-summary-card/div)[1]")
    private WebElement firstSiteIdF;
    @FindBy(xpath = "//p[normalize-space()='Map']")
    private WebElement mapPage;
    @FindBy(xpath = "//h2[normalize-space()='mm']")
    private WebElement mapPage_mm_Units;
    @FindBy(xpath = "//label[@for='speed_Meters_per_second']")
    private WebElement accountPage_speed_Units_mps;
    @FindBy(xpath = "//label[@for='speed_Kilometers_per_hour']")
    private WebElement accountPage_speed_Units_kph;
    @FindBy(xpath = "//label[@for='speed_Miles_per_hour']")
    private WebElement accountPage_speed_Units_mph;
    @FindBy(xpath = "//div[contains(@class, 'flex-colum languages-container ng-tns')]")
    private List<WebElement> languageSection;
    @FindBy(xpath = "(//div[contains(@class, 'flex-colum languages-container ng-tns')]//div)[2]")
    private WebElement languagePt;
    @FindBy(xpath = "//div[@class='success toast ng-star-inserted']")
    private WebElement languageToastContainer;
    @FindBy(xpath = "(//div[contains(@class, 'flex-colum languages-container ng-tns')]//div)[3]")
    private WebElement languageSp;
    @FindBy(xpath = "//div[contains(@class, 'grid language')]")
    private WebElement languageSelectionSection;
    @FindBy(xpath = "//div[contains(@class, 'languages-container')]//span")
    private WebElement languageSelectionEnglish;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='last']")
    private WebElement lastName;
    @FindBy(xpath = "//span[normalize-space()='Invalid first name.']")
    private WebElement firstNameErrorMessage;
    @FindBy(xpath = "//span[normalize-space()='Invalid last name.']")
    private WebElement lastNameErrorMessage;
    @FindBy(xpath = "//div[@class='top-selectors']")
    private WebElement accountTextBlockContainer;
//    @FindBy(xpath = "//div[@class='iti__selected-flag dropdown-toggle']")
    @FindBy(xpath = "//div[@class='iti__selected-flag']")
    private WebElement flagSelector;
    @FindBy(xpath = "//ul[@class='iti__country-list']")
    private WebElement flagList;
    @FindBy(xpath = "//ul[@class='iti__country-list']/li[@id='iti-0__item-in']")
    private WebElement selectedFlag;
    @FindBy(xpath = "//div[@class='iti__selected-flag dropdown-toggle']/div[@class='iti__flag iti__in']")
    private WebElement flagDisplayed;
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement searchPhoneBox;
//    @FindBy(xpath = "//div[text()=' Invalid phone number. ']")
    @FindBy(xpath = "//span[normalize-space()='Invalid phone number.']")
    private WebElement invalidPhoneNumber;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;
    @FindBy(xpath = "//arable-radio-button[@name='distance']")
    private WebElement unitForSize;
    @FindBy(xpath = "//arable-radio-button[@name='distance']//label")
    private List<WebElement> listUnitForSize;
    @FindBy(xpath = "//arable-radio-button[@ng-reflect-name='temperature']")
    private WebElement unitForTemp;
    @FindBy(xpath = "//arable-radio-button[@ng-reflect-name='temperature']//label")
    private List<WebElement> listUnitForTemp;
    @FindBy(xpath = "//arable-radio-button[@name='pressure']")
    private WebElement unitForPressure;
    @FindBy(xpath = "//arable-radio-button[@name='pressure']//label")
    private List<WebElement> listUnitForPressure;
    @FindBy(xpath = "//arable-radio-button[@name='volume']")
    private WebElement unitForVolume;
    @FindBy(xpath = "//arable-radio-button[@name='volume']//label")
    private List<WebElement> listUnitForVolume;
    @FindBy(xpath = "//arable-radio-button[@name='speed']")
    private WebElement unitForSpeed;
    @FindBy(xpath = "//arable-radio-button[@name='speed']//label")
    private List<WebElement> listUnitForSpeed;
    @FindBy(xpath = "//div[@class='success toast ng-star-inserted']")
    private WebElement successToastMessage;
    @FindBy(xpath = "//label[normalize-space()='Units']")
    private WebElement accountPageUnitTag;
    @FindBy(xpath = "//span[normalize-space()='Português']")
    private WebElement PortuguesLanguageTag;
    @FindBy(xpath = "//span[normalize-space()='English']")
    private WebElement englishLanguageTag;
    @FindBy(xpath = "//span[normalize-space()='Español']")
    private WebElement espanolLanguageTag;
    private String unitsForPressure;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyPtLanguageOption(String role) {
        StringBuilder optionsText = new StringBuilder();
        for (WebElement element : languageSection) {
            optionsText.append(element.getText()).append(" ");
        }
        System.out.println("Options: " + optionsText.toString().trim());
        webDriverHelper.waitUntilVisible(languagePt, 30, 1);
        Assert.assertTrue(optionsText.toString().contains(Constants.languagePt));
        Assert.assertTrue(optionsText.toString().contains(Constants.languageEng));
    }

    public void verifyPtTranslation(String role) throws InterruptedException {
        verifyPtLanguageOption(role);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);
        languageSection.get(0).click();
        webDriverHelper.waitUntilVisible(account_SaveBtn, 60, 1);
        account_SaveBtn.click();
        Thread.sleep(3000);
        Assert.assertTrue(languageSelectionSection.getText().contains(Constants.languageTranslatedText));
        switchBackToEnglish();
        Assert.assertTrue(languageSelectionSection.getText().contains("Language"));
    }

    public void switchBackToEnglish() throws InterruptedException {
        webDriverHelper.scrollToWebElement(languageSelectionEnglish);
        languageSelectionEnglish.click();
        webDriverHelper.waitUntilVisible(account_SaveBtn, 60, 1);
        account_SaveBtn.click();
        Thread.sleep(3000);
    }

    public void verifyVaporPressureUnitAfterUnitChange(String role) throws InterruptedException, IOException {
//        navigateToMapPage();
//        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 30, 1);
        System.out.println("accountPressureUnit :-   " + accountPressureUnit);
        System.out.println("accountPressureUnit :-   " + accountPressureUnit);
        System.out.println("a pressureUnitF :-   " + pressureUnitF.getText());
        System.out.println("Before  pressureUnitF.getAttribute(\"ng-reflect-model\") :-   " + pressureUnitF.getAttribute("ng-reflect-model"));
        Thread.sleep(8000);
        pressureUnitF.click();
        System.out.println(" pressureUnitF.getAttribute(\"ng-reflect-model\") :-   " + pressureUnitF.getAttribute("ng-reflect-model"));

    }

    public void verifySizeUnitChange(String role) throws InterruptedException, IOException {
        switchSizeUnit();
        verifyMapPageMeasurementAfterUnitChange();
        verifyRainUnitChange();
    }

    public void verifyRainUnitChange() {
        measurementDropdownOpenBtn_MapPage.click();
        String changedRainUnit = mapPage_Rain_Units.getText();
        Assert.assertNotEquals(changedRainUnit, rainUnits);
    }

    public void verifyMapPageMeasurementAfterTempUnitChange() throws InterruptedException, IOException {
        String changed_GradientBarTemp = measurement_gradientBar_MapPage.getText();
        if (measurementSelected_MapPage.getText().contains("Temperature")) {
            Assert.assertNotEquals(changed_GradientBarTemp, gradientBarTemp);
        }
    }

    public void verifyMapPageMeasurementAfterUnitChange() throws InterruptedException, IOException {
        navigateToMapPage();
        webDriverHelper.waitUntilVisible(measurementSelected_MapPage, 30, 1);
//        ------------code for switch temp units-----
        verifyMapPageMeasurementAfterTempUnitChange();
//        ----end of code-----
        Thread.sleep(1000);
        measurementSelected_MapPage.click();
        webDriverHelper.waitUntilVisibilityOfAllElements(measurements_MapPage, 30, 1);
        for (WebElement tempEle : measurements_MapPage) {
            tempEle.click();
            Thread.sleep(1000);
            String titleName = measurementSelected_MapPage.getText();
            String gradientBar = measurement_gradientBar_MapPage.getText();
            if (titleName.contains("Daily ETc") || titleName.contains("Precipitation (Since 12AM)")
                    || titleName.contains("Precipitation (Last 10 Days)") || titleName.contains("ET (Last 10 Days)")) {
                if (sizesUnit.equalsIgnoreCase("inches")) {
                    Assert.assertTrue(gradientBar.contains("in"));
                } else {
                    Assert.assertTrue(gradientBar.contains(mapPage_mm_Units.getText()));
                }
            }
            if (titleName.contains("Wind")) {
                if (currentWindUnit.contains("Miles_per_hour")) {
                    Assert.assertTrue(gradientBar.contains("mph"));
                } else if (currentWindUnit.contains("Meters_per_second")) {
                    Assert.assertTrue(gradientBar.contains("mps"));
                } else if (currentWindUnit.contains("Kilometer_per_hour")) {
                    Assert.assertTrue(gradientBar.contains("kph"));
                }
            }
            measurementDropdownOpenBtn_MapPage.click();
            Thread.sleep(1000);
            webDriverHelper.waitUntilVisibilityOfAllElements(measurements_MapPage, 30, 1);
        }
    }

    public void switchWindUnit() throws InterruptedException {
        getSpeedUnit();
        if (accountSpeedUnit.equalsIgnoreCase("Miles_per_hour")) {
            accountPage_speed_Units_kph.click();
        } else if (accountSpeedUnit.equalsIgnoreCase("Meters_per_second")) {
            Thread.sleep(2000);
            accountPage_speed_Units_mph.click();
        } else if (accountSpeedUnit.equalsIgnoreCase("Kilometers_per_hour")) {
            accountPage_speed_Units_mps.click();
        }
        currentWindUnit = speedUnitF.getAttribute("ng-reflect-model");
    }

    public void switchSizeUnit() throws InterruptedException {
        webDriverHelper.waitUntilVisible(account_GenerateKey, 100, 1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);
        getSizeUnit();
        if (accountSizeUnit.equalsIgnoreCase("inches")) {
            account_sizeUnits_mm.click();
        } else if (accountSizeUnit.equalsIgnoreCase("millimeters")) {
            account_sizeUnits_Inches.click();
        }
        sizesUnit = sizeUnitF.getAttribute("ng-reflect-model");
        webDriverHelper.waitUntilVisible(account_SaveBtn, 100, 1);
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(3000);
        switchTempUnit();
        Thread.sleep(3000);
        switchWindUnit();
        Thread.sleep(3000);
        account_SaveBtn.click();
        webDriverHelper.waitUntilVisible(account_SuccessToast_UnitsChange, 400, 1);
    }

    public void switchTempUnit() throws InterruptedException {
        if (gradientBarTemp.equalsIgnoreCase("°F")) {
            accountPage_temp_Units_C.click();
        } else if (gradientBarTemp.equalsIgnoreCase("°C")) {
            accountPage_temp_Units_F.click();
        }
    }

//    public void verifyGenerateKey(String role) throws InterruptedException, IOException {
////        StringHelper.devToolCapture(role);
//        webDriverHelper.waitUntilVisible(account_sizeUnits_mm, 100, 1);
//        if (account_GenerateKey.isDisplayed()) {
//            account_GenerateKey.click();
//            webDriverHelper.waitUntilVisible(account_GenerateKey_CopyBtn, 30, 1);
//        } else {
//            account_GenerateKey_CopyBtn.isDisplayed();
//        }
//        loadInSeconds = stringHelper.stopTime(start, driver);
//        ExcelReader.setValueForColumn("Account", loadInSeconds, role);
//// HTML report generator
//        HTMLReport.addPageName("Account");
////        HTMLReport.generateReport("Account", loadInSeconds, role);
//        HTMLReport.writeReportToFile();
//
//        stringHelper.benchmarkComparison(loadInSeconds);
//        account_GenerateKey.click();
//        Thread.sleep(200);
//        webDriverHelper.waitUntilVisible(account_GenerateKey_CopyBtn, 30, 1);
//        Assert.assertTrue(account_GeneratedAPIKey.isDisplayed());
//        account_GenerateKey_CopyBtn.click();
//        webDriverHelper.waitUntilVisible(account_successToast_CopyAPIKey, 30, 1);
//        Assert.assertTrue(account_successToast_CopyAPIKey.isDisplayed());
//        Assert.assertTrue(account_GenerateKey_RefreshBtn.isDisplayed());
//        String apiKey = account_GeneratedAPIKey.getText();
//        account_GenerateKey_RefreshBtn.click();
//        Thread.sleep(200);
//        webDriverHelper.waitUntilVisible(account_GeneratedAPIKey, 30, 1);
//        String NewApiKey = account_GeneratedAPIKey.getText();
//        Assert.assertEquals(NewApiKey, apiKey);
//    }

    //        public void navigateToPage(String role) throws IOException, InterruptedException {
//        webDriverHelper.waitUntilVisible(dashboardMenu_Settings, 30, 1);
////        map.navigateToPage(role);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='1 grid grid-center headers disabled']")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='1 grid grid-center headers']")));
//        webDriverHelper.waitUntilVisible(mapPage_Rain_Units, 30, 1);
//        rainUnits = mapPage_Rain_Units.getText();
//        gradientBarTemp = measurement_gradientBar_MapPage.getText();
//        Actions action = new Actions(driver);
//        action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Account).click().build().perform();
////        loadInSeconds = null;
////        start = System.currentTimeMillis();
//    }
    public void navigateToPage(String page) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(dashboardMenu_Settings, 30, 1);
//        switchOrgToArableTeam();
//        webDriverHelper.waitUntilVisible(mapPage_Rain_Units, 30, 1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='1 grid grid-center headers disabled']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='1 grid grid-center headers']")));
        webDriverHelper.waitUntilVisible(mapPage_Rain_Units, 30, 1);

        rainUnits = mapPage_Rain_Units.getText();
        gradientBarTemp = measurement_gradientBar_MapPage.getText();
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Account).click().build().perform();
        loadInSeconds = null;
        start = System.currentTimeMillis();
    }

    public void navigateToMapPage() throws IOException, InterruptedException {
        mapPage.click();
        webDriverHelper.waitUntilVisible(mapPage, 30, 1);
    }

    public void getSizeUnit() {
        webDriverHelper.waitAttributeNotEmpty(sizeUnitF, "ng-reflect-model", 60, 1);
        accountSizeUnit = sizeUnitF.getAttribute("ng-reflect-model");
    }

    public void getTemperatureUnit() {
        webDriverHelper.waitAttributeNotEmpty(temperatureUnitF, "ng-reflect-model", 30, 1);
        accountTemperatureUnit = temperatureUnitF.getAttribute("ng-reflect-model");
    }

    public void getPressureUnit() {
        webDriverHelper.waitAttributeNotEmpty(pressureUnitF, "ng-reflect-model", 30, 1);
        accountPressureUnit = pressureUnitF.getAttribute("ng-reflect-model");
    }

    public void getVolumeUnit() {
        webDriverHelper.waitAttributeNotEmpty(volumeUnitF, "ng-reflect-model", 30, 1);
        accountVolumeUnit = volumeUnitF.getAttribute("ng-reflect-model");
    }

    public void getSpeedUnit() {
        webDriverHelper.waitAttributeNotEmpty(speedUnitF, "ng-reflect-model", 60, 1);
        accountSpeedUnit = speedUnitF.getAttribute("ng-reflect-model");
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

    public void verifySpLanguageOption(String role) {
        StringBuilder optText = new StringBuilder();
        for (WebElement SpEle : languageSection) {
            optText.append(SpEle.getText()).append(" ");
        }
        System.out.println("options:" + optText.toString().trim());
        webDriverHelper.scrollToWebElement(languageSp);
        webDriverHelper.waitUntilVisible(languageSp, 30, 1);
        Assert.assertTrue(optText.toString().contains(Constants.languageSp));
        Assert.assertTrue(optText.toString().contains(Constants.languageEng));
    }

    public void verifySPTranslation(String role) throws InterruptedException {
        try {
            verifySpLanguageOption(role);
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
            Thread.sleep(1000);
            languageSp.click();
            webDriverHelper.waitUntilVisible(account_SaveBtn, 60, 1);
            account_SaveBtn.click();
            Thread.sleep(3000);
            Assert.assertTrue(languageSelectionSection.getText().contains(Constants.languageTranslatedText));
            switchBackToEnglish();
            Assert.assertTrue(languageSelectionSection.getText().contains("Language"));
        } catch (Exception exc) {
            System.out.println("Failed in verifySPTranslation:" + exc);
            switchBackToEnglish();
        }
    }

    public void verifyFirstNameAndLastNameIsNotAcceptingNumbersAndSpecialCharacter(String role) throws InterruptedException {
        firstName.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", firstName);
        webDriverHelper.waitUntilVisible(firstName, 60, 1);
        firstName.sendKeys(Constants.firstNameText);
        lastName.click();
        js.executeScript("arguments[0].value = '';", lastName);
        webDriverHelper.waitUntilVisible(firstName, 60, 1);
        lastName.sendKeys(Constants.lastNameText);
        String actualError = firstName.getAttribute("ng-reflect-error-message");
        String exceptedError = "Invalid first name.";
        Assert.assertEquals(actualError, exceptedError);
        String actualErr = lastName.getAttribute("ng-reflect-error-message");
        String exceptedErr = "Invalid last name.";
        Assert.assertEquals(actualErr, exceptedErr);

    }

    public void verifyErrorOnSavingByChangingFlagAndNumber(String role) throws InterruptedException {
        flagSelector.click();
        webDriverHelper.waitUntilVisible(flagList, 60, 1);
        selectedFlag.click();
        searchPhoneBox.click();
        searchPhoneBox.sendKeys(Constants.phoneBoxText);
        webDriverHelper.waitUntilVisible(invalidPhoneNumber, 30, 1);
        Assert.assertTrue(invalidPhoneNumber.getText().contains("Invalid phone number."));
    }

    public void changeTheUnitForWindSpeed() {
        try {
            Thread.sleep(3000);
            webDriverHelper.waitUntilVisible(unitForSpeed, 60, 1);
            unitsForSpeed = unitForSpeed.getAttribute("ng-reflect-model");
            if (Objects.equals(unitsForSpeed, "Miles_per_hour")) {
                listUnitForSpeed.get(1).click();
                speedUnit = "kph";
            } else if (Objects.equals(unitsForSpeed, "Kilometers_per_hour")) {
                listUnitForSpeed.get(2).click();
                speedUnit = "mps";
            } else {
                listUnitForSpeed.get(0).click();
                speedUnit = "mph";
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("changeTheUnitForWindSpeed.jpg");
            Assert.fail("The exception in the changeTheUnitForWindSpeed" + exc);
        }
    }

    public void clickOnSaveButton() {
        try {
            webDriverHelper.scrollToBottomOfPage();
            webDriverHelper.waitUntilVisible(saveBtn, 60, 1);
            saveBtn.click();
            webDriverHelper.waitUntilVisible(successToastMessage, 120, 1);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("clickOnSaveButton.jpg");
            Assert.fail("The exception in the clickOnSaveButton" + exc);
        }
    }

    public void verifyTheUnitInTheAPI(String units) {
        try {
            String response = PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/locations/summary/measurements?temp=";
            verifyThePageOnceClickOnSubmitBtn(response);
            if (units.contains("speed")) {
                Assert.assertTrue(apiUnitsForSpeed.toUpperCase().contains(speedUnit.toUpperCase()), "the api and the ui is not matching for the speed unit");
            } else if (units.contains("size")) {
                Assert.assertTrue(apiUnitsForSize.toUpperCase().contains(sizesUnit.toUpperCase()), "the api and the ui is not matching for the size unit");
            } else if (units.contains("temp")) {
                Assert.assertTrue(apiUnitsForTemp.toUpperCase().contains(tempUnit.toUpperCase()), "the api and the ui is not matching for the temp unit");
            } else {
                Assert.assertTrue(presUnit.toUpperCase().contains(apiUnitsForPressure.toUpperCase()), "the api and the ui is not matching for the pres unit");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheUnitInTheAPI.jpg");
            Assert.fail("The exception in the verifyTheUnitInTheAPI" + exc);
        }
    }

    public void verifyThePageOnceClickOnSubmitBtn(String response) throws MalformedURLException {
        List<String> apiEndpoints = webDriverHelper.captureNetworkRequests();
        String fullHistoricalApi = findMatchingEndpoint(response, apiEndpoints);
        if (fullHistoricalApi == null) {
            Assert.fail("No Match Found for Partial Endpoints: " + response);
        }
        Map<String, String> queryParams = webDriverHelper.getQueryParameters(new URL(fullHistoricalApi));
        apiUnitsForTemp = queryParams.get("temp");
        apiUnitsForPressure = queryParams.get("pres");
        apiUnitsForSize = queryParams.get("size");
        apiUnitsForSpeed = queryParams.get("speed");
        queryParams.clear();
    }

    private String findMatchingEndpoint(String response, List<String> apiEndpoints) {
        for (String storedEndpoint : apiEndpoints) {
            if (storedEndpoint.trim().contains(response.trim())) {
                return storedEndpoint;
            }
        }
        return null;
    }

    public void changeTheUnitForSize() {
        try {
            Thread.sleep(3000);
            webDriverHelper.waitUntilVisible(unitForSize, 60, 1);
            unitsForSize = unitForSize.getAttribute("ng-reflect-model");
            System.out.println("Before clicking unit " + unitsForSize);
            if (Objects.equals(unitsForSize, "inches")) {
                listUnitForSize.get(1).click();
                sizeUnit = "mm";

            } else {
                listUnitForSize.get(0).click();
                sizeUnit = "in";
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("changeTheUnitForSize.jpg");
            Assert.fail("The exception in the changeTheUnitForSize" + exc);
        }
    }

    public void changeTheUnitForTemperature() {
        try {
            Thread.sleep(3000);
            webDriverHelper.waitUntilVisible(accountPageUnitTag, 60, 1);
            webDriverHelper.waitUntilVisible(unitForTemp, 60, 1);
            unitsForTemp = unitForTemp.getAttribute("ng-reflect-model");
            if (Objects.equals(unitsForTemp, "fahrenheit")) {
                listUnitForTemp.get(1).click();
                tempUnit = "C";
            } else {
                listUnitForTemp.get(0).click();
                tempUnit = "F";
            }
            System.out.println("tempUnit after clicking" + tempUnit);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("changeTheUnitForTemperature.jpg");
            Assert.fail("The exception in the changeTheUnitForTemperature" + exc);
        }
    }

    public void changeTheUnitForPressure() {
        try {
            Thread.sleep(3000);
            webDriverHelper.waitUntilVisible(unitForPressure, 60, 1);
            unitsForPressure = unitForPressure.getAttribute("ng-reflect-model");
            if (Objects.equals(unitsForPressure, "millibars")) {
                listUnitForPressure.get(1).click();
                presUnit = "kPa";

            } else {
                listUnitForPressure.get(0).click();
                presUnit = "mb";
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("changeTheUnitForPressure.jpg");
            Assert.fail("The exception in the changeTheUnitForPressure" + exc);
        }
    }

    public void changeTheUnitForVolume() {
        try {
            Thread.sleep(3000);
            webDriverHelper.waitUntilVisible(unitForVolume, 60, 1);
            String unitsForVolumeName = unitForVolume.getAttribute("ng-reflect-model");
            if (Objects.equals(unitsForVolumeName, "gallons")) {
                listUnitForVolume.get(1).click();
                volumeUnit = "ltr";
            } else {
                listUnitForVolume.get(0).click();
                volumeUnit = "gal";
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("changeTheUnitForVolume.jpg");
            Assert.fail("The exception in the changeTheUnitForVolume" + exc);
        }
    }

    public void verifyTheLanguageTagIsVisible() {
        try {
            webDriverHelper.waitUntilVisible(PortuguesLanguageTag, 60, 1);
            Assert.assertTrue(PortuguesLanguageTag.isDisplayed(), "Portugues Language Tag is not present in the account page");
            Assert.assertTrue(englishLanguageTag.isDisplayed(), "English Language Tag is not present in the account page");
            Assert.assertTrue(espanolLanguageTag.isDisplayed(), "espanol Language Tag is not present in the account page");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheLanguageTagIsVisible.jpg");
            Assert.fail("The exception in the verifyTheLanguageTagIsVisible" + exc);
        }
    }

}