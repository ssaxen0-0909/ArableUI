package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static support.World.*;

public class DevicesPage {

    private final WebDriver driver;
    @FindBy(xpath = "//p[normalize-space()='Settings']")
    WebElement dashboardMenu_Settings;
    @FindBy(xpath = "//p[normalize-space()='1']")
    WebElement devicesTableLastRow;
    @FindBy(css = "div[class='grid message-list'] p")
    WebElement devicesNoTable;
    @FindBy(xpath = "//span[normalize-space()='GEMS PS41 Series Pressure Switch']//ancestor::div[@class='column']//following-sibling::div[@class='column']//arable-dotted-menu")
    List<WebElement> pressureSensor;
    int sum = 0;
    private String upcomingInitialValue;
    @FindAll({@FindBy(xpath = "//div[@class='navigation']/ul[1]/li/div/a")})
    private List<WebElement> dashboardMenuF;
    @FindBy(xpath = "//p[normalize-space()='Devices']")
    private WebElement dashboardMenu_Devices;
    @FindBy(xpath = "//div[@class='modal fade in show']//img[@alt='icon_close']")
    private WebElement modal_icon_close;
    @FindBy(xpath = "//h1[normalize-space()='Devices Syncing']")
    private WebElement devices_Syncing_Modal;
    @FindBy(xpath = "//p[contains(text(),'8.5 hours')]")
    private WebElement devices_Syncing_Modal_text;
    @FindBy(xpath = "//h1[normalize-space()='Devices Not Syncing']")
    private WebElement devices_Not_Syncing_Modal;
    @FindBy(xpath = "//p[contains(text(),'12 hours')]")
    private WebElement devices_Not_Syncing_Modal_text;
    @FindBy(xpath = "//h1[normalize-space()='Battery']")
    private WebElement battery_Modal;
    @FindBy(xpath = "//strong[normalize-space()='Zero (0%):']")
    private WebElement battery_Modal_text;
    @FindBy(xpath = "//span[normalize-space()='Active']")
    private WebElement active_Modal;
    @FindBy(xpath = "//span[normalize-space()='New']")
    private WebElement new_Modal;
    @FindBy(xpath = "//span[normalize-space()='Inactive']")
    private WebElement inactive_Modal;
    @FindBy(xpath = "//span[normalize-space()='Dormant']")
    private WebElement dormant_Modal;
    @FindBy(xpath = "//h3[normalize-space()='GPS']")
    private WebElement gps_Modal;
    @FindBy(xpath = "//h1[normalize-space()='GPS']")
    private WebElement gps_Modal_text;
    @FindBy(xpath = "//h3[normalize-space()='Model']")
    private WebElement model_Modal;
    @FindBy(xpath = "//h3[normalize-space()='Battery']")
    private WebElement battery_header_Modal;
    @FindBy(xpath = "//h3[normalize-space()='Connectivity']")
    private WebElement connectivity_Modal;
    @FindBy(xpath = "//p[contains(text(),'Devices with weak connectivity may skip sync inter')]")
    private WebElement connectivity_Modal_text;
    @FindBy(xpath = "//h3[normalize-space()='Last Sync']")
    private WebElement lastSync_Modal;
    @FindBy(xpath = "//strong[normalize-space()='Sync Delay']")
    private WebElement lastSync_Modal_text;
    @FindBy(xpath = "//h3[normalize-space()='Status']")
    private WebElement status_Modal;
    @FindBy(xpath = "//p[contains(text(),'Factory-shipped devices that are added to your acc')]")
    private WebElement status_Modal_text;
    @FindBy(xpath = "//h3[normalize-space()='Connected Sensors']")
    private WebElement connectedSensors_Modal;
    @FindBy(xpath = "//p[contains(text(),'The Drill & Drop is a fully encapsulated soil meas')]")
    private WebElement connectedSensors_Modal_text;
    @FindBy(xpath = "//div[@class='devices-tab']//div[1]//div[3]//arable-tooltip-box[1]//div[1]//div[1]//img[1]")
    private WebElement GPS_coordinates_icon;
    @FindBy(css = "(//span[@class='tooltiptext ng-star-inserted'])[1]")
    private WebElement GPS_coordinates_details;
    @FindBy(xpath = "//div[@class='success toast']")
    private WebElement GPS_coordinates_copy_successIcon;
    @FindBy(xpath = "//body/arable-app[1]/main[1]/arable-devices-tab[1]/div[1]/div[1]/div[1]/div[2]")
    private WebElement devicesSyncingStats;
    @FindBy(xpath = "//span[@class='2 caret']")
    private WebElement teamDropdown_Openbuton;
    @FindBy(xpath = "//div[@class='team-selector']//div[@class='options']//div[2]")
    private WebElement teamDropdown_TeamList;
    @FindBy(xpath = "//div[@id='device-statistics']")
    private WebElement devicePageStats;
    @FindBy(xpath = "//span[@class='1 caret']")
    private WebElement orgDropdown_Openbuton;
    @FindBy(xpath = "(//div[@class='1 dropdown-selector open']//div[@class='options']//p)[2]")
    private WebElement orgDropdown_orgList;
    @FindAll({@FindBy(xpath = "//p[@class='active text'][normalize-space()='Active']")})
    private List<WebElement> status_Active;
    @FindAll({@FindBy(xpath = "//p[@class='new text'][normalize-space()='New']")})
    private List<WebElement> status_New;
    @FindBy(xpath = "(//div[@class='state-item'])[1]")
    private WebElement devicesSyncCard_ActiveCount;
    @FindBy(xpath = "(//div[@class='state-item'])[2]")
    private WebElement devicesSyncCard_NewCount;
    @FindAll({@FindBy(xpath = "//p[@class='inactive text'][normalize-space()='Inactive']")})
    private List<WebElement> status_Inactive;
    @FindAll({@FindBy(xpath = "//p[@class='dormant text'][normalize-space()='Dormant']")})
    private List<WebElement> status_Dormant;
    @FindBy(xpath = "(//div[@class='state-item'])[3]")
    private WebElement devicesSyncCard_InactiveCount;
    @FindBy(xpath = "(//div[@class='state-item'])[4]")
    private WebElement devicesSyncCard_DormantCount;
    @FindBy(xpath = "(//div[@class='state-item'])[5]")
    private WebElement batteryCard_lowEmptyCount;
    @FindBy(xpath = "(//div[@class='state-item'])[6]")
    private WebElement batteryCard_mediumCount;
    @FindBy(xpath = "(//div[@class='state-item'])[7]")
    private WebElement batteryCard_highFullCount;
    @FindBy(xpath = "(//div[@class='battery-container'])")
    private WebElement battery_inTable;
    @FindAll({@FindBy(xpath = "(//div[@class='battery-icon medium-battery'])")})
    private List<WebElement> mediumBattery_inTable;
    @FindAll({@FindBy(xpath = "(//div[@class='battery-icon high-battery'])")})
    private List<WebElement> highBattery_inTable;
    @FindAll({@FindBy(xpath = "(//div[@class='battery-icon empty-battery'])")})
    private List<WebElement> emptyBattery_inTable;
    @FindAll({@FindBy(xpath = "(//div[@class='battery-icon low-battery'])")})
    private List<WebElement> lowBattery_inTable;
    @FindAll({@FindBy(xpath = "(//div[@class='battery-icon full-battery'])")})
    private List<WebElement> fullBattery_inTable;
    @FindAll({@FindBy(xpath = "(//div[@class='column'])//p[@class='text-lastsync is-not-sync']")})
    private List<WebElement> lastSyncRed_inTable;
    @FindBy(xpath = "(//div[@class='container-caret'])[1]")
    private WebElement sortDeviceID_inTable;
    @FindBy(xpath = "(//div[@class='container-caret'])[2]")
    private WebElement sortSites_inTable;
    @FindBy(xpath = "(//div[@class='container-caret'])[3]")
    private WebElement sortBattery_inTable;
    @FindBy(xpath = "(//div[@class='container-caret'])[4]")
    private WebElement sortConnectivity_inTable;
    @FindBy(xpath = "(//div[@class='container-caret'])[5]")
    private WebElement sortLastSync_inTable;
    @FindBy(xpath = "(//div[@class='container-caret'])[6]")
    private WebElement sortStatus_inTable;
    @FindBy(xpath = "//span[@class='active-sort caret-down']")
    private WebElement sortASC_DeviceID_inTable;
    @FindBy(xpath = "(//div[@class='devices-list'])//div[@class='grid body-list'][1]")
    private WebElement devicesList1_gridBody_inTable;
    @FindAll({@FindBy(xpath = "(//div[@class='devices-list'])//div[@class='grid body-list']")})
    private List<WebElement> devicesList_gridBody_inTable;
    @FindAll({@FindBy(xpath = "(//div[@class='row'])//p/a[@class='highlight bold']")})
    private List<WebElement> siteName_inTable;
    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Current Conditions']/div")
    private WebElement currentCondition_WeatherPage;
    @FindAll({@FindBy(xpath = "//div[@class='column bridge']//div[@class='sensors-link']//h3[normalize-space()='Validate']")})
    private List<WebElement> validateBtn_inTable;
    @FindBy(xpath = "//label[normalize-space()='Port 1 Analog']")
    private WebElement port1AnalogText;
    @FindBy(xpath = "//span[contains(normalize-space(.), 'gal/min')]")
    private WebElement offsetText_gal;
    @FindBy(xpath = "//span[@class='offset-text']")
    private WebElement offsetText_degree;
    @FindBy(xpath = "//div[@class='container']")
    private WebElement offsetInputField;
    @FindBy(xpath = "//span[@class='message']")
    private WebElement offsetInputErrorMsg;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement confirmButton;
    @FindBy(xpath = "//div[@class='action-buttons ng-star-inserted']//button[@class='btn-action confirm disabled']")
    private WebElement disabledConfirmButton;
    @FindBy(xpath = "//h3[normalize-space()='Successfully Saved']")
    private WebElement successToastMsg;
    @FindBy(xpath = "//div[@class='menu-content']//div[@class='button'][normalize-space()='Delete Sensor']")
    private WebElement deleteSensor;
    @FindBy(xpath = "//div[@class='selector-container analog-container']//div[@class='menu-button-container']")
    private WebElement menuBtn_DeleteSensor_port1;
    @FindBy(xpath = "//arable-dropdown-selector-with-check[@ng-reflect-items='[object Object],[object Object']//p[@class='title 0'][normalize-space()='Select Sensor Type']")
    private WebElement port1Analog_SelectSensor;
    @FindBy(xpath = "//div[@class='selector-container pulse-container']//div[@class='menu-button']")
    private WebElement menuBtn_DeleteSensor_port2;
    @FindBy(xpath = "//div[@class='selector-container sdi12-container']//div[@class='menu-button-container']")
    private WebElement menuBtn_DeleteSensor_port3;
    @FindBy(xpath = "//div[@class='selector-container pulse-container']//p[@class='title 0'][normalize-space()='Select Sensor Type']")
    private WebElement port2Analog_SelectSensor;
    @FindBy(xpath = "//div[@class='selector-container sdi12-container']//p[@class='title 0'][normalize-space()='Select Sensor Type']")
    private WebElement port3Analog_SelectSensor;
    @FindBy(xpath = "//p[normalize-space()='No Devices']")
    private WebElement noDevices_DevicePage;
    @FindBy(xpath = "//h1[normalize-space()='Your Device Model Info']")
    private WebElement model_ModalInfoText;
    @FindBy(xpath = "(//div[@class='menu'])[1]")
    private WebElement menuBtnDeviceTable;
    @FindBy(xpath = "//div[@class='menu-content']//div[@class='button'][normalize-space()='Validate Sensors']")
    private WebElement validateSensorBtn;
    @FindBy(xpath = "//div[@class='grid body-list']//div[@class='column']//p[@class='text-lastsync is-not-sync']")
    private List<WebElement> notSyncDevicesHours;
    @FindBy(xpath = "//div[@class='grid body-list']//div[@class='column']//p[@class='text-lastsync']")
    private List<WebElement> syncDevicesHours;
    @FindBy(xpath = "(//span[contains(text(),'None')])[1]")
    private WebElement noSensorText;
    @FindBy(xpath = "//a[normalize-space()='View More Devices']")
    private WebElement viewMoreDeviceOption;
    @FindBy(xpath = "(//img[@alt='sensor'][@src='/img/icons/wind-speed-sensor.svg'])[1]")
    private WebElement sensorIconEnabled;
    @FindBy(xpath = "(//div[@class='menu-button-container'])[1]")
    private WebElement sensorMenuIcon;
    @FindBy(xpath = "(//div[@class='no-sensor-container'])[1]")
    private WebElement noSensorIcon;
    @FindBy(xpath = "//p[normalize-space()='100']")
    private WebElement LastRowNumberPerPage;
    @FindBy(xpath = "//p[normalize-space()='101']")
    private WebElement nextPageFirstRowNumber;
    @FindBy(xpath = "(//div[@class='item-stat'])[3]//div[contains(@class, 'state-item')]/div")
    private List<WebElement> batteryStats;
    @FindBy(xpath = "//div[@class='menu-content']//div//img")
    private WebElement validateSensorsTag;
    @FindBy(xpath = "//div[contains(@class,'param-input-container')]//div[contains(@class,'container')]//input")
    private WebElement inputNumberTag;
    @FindBy(xpath = "//div[@class='head-tooltip']//h1")
    private WebElement headerTag;
    @FindBy(xpath = "//div[@class='input-error']//span")
    private WebElement setUpConnectedSensorsErrorMsg;
    @FindBy(xpath = "//span[@class='offset-text']")
    private WebElement connectedSensorsUnit;
    @FindBy(xpath = "//div[@class='grid body-list ng-star-inserted']")
    private WebElement deviceListTag;

    public DevicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static String getColorName(String colorValue) {
        if (colorValue.equals("#707070")) {
            return "grey";
        } else if (colorValue.equals("rgba(255, 97, 53, 0.82)")) {
            return "red";
        } else {
            System.out.println("color not found");
            return colorValue;
        }
    }

    private static boolean isValidSyncText(String text) {
        return text.contains("mins ago") && !text.contains("hrs ago");
    }

    private static boolean isValidHrsAgo(String text) {
        String numberStr = text.replaceAll("\\D+", "");
        int hours = numberStr.isEmpty() ? 0 : Integer.parseInt(numberStr);
        return hours <= 4;
    }

    private static boolean isValidText(String text) {
        return !List.of("1", "2", "3").contains(text);
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(dashboardMenu_Settings, 30, 1);
        map.navigateToPage(role);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Devices).click().build().perform();
    }

    public void verifyBatteryStatsCount(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        for (WebElement stats : batteryStats) {
            String text = stats.getText();
            String number = extractNumber(text);
            System.out.println("stats:-" + number);
            sum += Integer.parseInt(number);
        }
        System.out.println("Sum of numbers: " + sum);
        verifyViewMoreOption(role);
        Thread.sleep(3000);
        verifyDeviceLimitPerPage(role);
        Thread.sleep(3000);
    }

    private boolean isElementVisible(String text) {
        try {
            driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String extractNumber(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public void verifyNoSensorNoMenuBtn(String role) throws IOException {
        verifyNoSensorDevice(role);
        if (devicesList_gridBody_inTable.size() > 1) {
            for (WebElement row : devicesList_gridBody_inTable) {
                boolean isNoSensorIconDisplayed = noSensorIcon.isDisplayed();
                boolean isSensorMenuIconDisplayed = sensorMenuIcon.isDisplayed();
                if (devicesList_gridBody_inTable.contains(noSensorIcon)) {
                    assertFalse(devicesList_gridBody_inTable.contains(sensorMenuIcon), "sensorMenuIcon should be displayed if noSensorIcon is displayed in the same row");
                }
            }
        }
        Assert.assertTrue(noSensorIcon.isDisplayed());
    }

    public void verifySensorIconAndMenuBtn(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        Assert.assertTrue(sensorIconEnabled.isDisplayed());
        String color = sensorIconEnabled.getCssValue("color");
        System.out.println("color:-" + color);
        Assert.assertEquals(color, "rgba(0, 0, 0, 1)");
        Assert.assertTrue(sensorMenuIcon.isDisplayed());
    }

    public void verifyDeviceLimitPerPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        Assert.assertTrue(LastRowNumberPerPage.isDisplayed());
    }

    public void verifyViewMoreOption(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        webDriverHelper.waitUntilVisible(viewMoreDeviceOption, 30, 1);
        boolean isViewMoreDisplayed = viewMoreDeviceOption.isDisplayed();
        Assert.assertTrue(isViewMoreDisplayed, "viewMoreDeviceOption is not displayed at the bottom of the page");
        viewMoreDeviceOption.click();
        webDriverHelper.waitUntilVisible(nextPageFirstRowNumber, 30, 1);
        Assert.assertTrue(nextPageFirstRowNumber.getText().contains("101"));
    }

    public void verifyNoSensorDevice(String role) throws IOException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        Assert.assertTrue(noSensorText.isDisplayed());
    }

    public void verifySyncColumnColor(String role) throws IOException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        for (WebElement lastSync : syncDevicesHours) {
            String text = lastSync.getText();
            if (text.contains("min ago") || text.contains("mins ago")) {
                assert isValidSyncText(text) : "Assertion failed: Invalid text found - " + text;
                System.out.println("Valid text found: " + text);
                String textColorName = getColorName(lastSync.getCssValue("color"));
                System.out.println("Text color: " + textColorName);
            } else if (text.contains("hrs ago") || text.contains("hr ago")) {
                assert isValidHrsAgo(text) : "Assertion failed: Invalid 'hrs ago' text found - " + text;
                System.out.println("Valid 'hrs ago' text found: " + text);
                String textColorName = getColorName(lastSync.getCssValue("color"));
                System.out.println("Text color: " + textColorName);
            } else {
                System.out.println("Ignoring element with text: " + text);
            }
        }
    }

    public void verifyNotSyncColumnColor(String role) throws IOException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        for (WebElement lastSync : notSyncDevicesHours) {
            String text = lastSync.getText();
            if (text.contains("hrs ago")) {
                assert isValidText(text) : "Assertion failed: Invalid text found - " + text;
            } else {
                System.out.println("Ignoring element with text: " + text);
            }
        }
    }

    public void verifyGPSCoordinateCopyIcon(String role) throws IOException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        GPS_coordinates_icon.click();
        webDriverHelper.waitUntilVisible(GPS_coordinates_copy_successIcon, 30, 1);
        assertTrue(GPS_coordinates_copy_successIcon.isDisplayed(), "no success msg");
    }

    public void verifyStatsOnTeamSwitch(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        String devicesSyncingCount = devicePageStats.getText();
        teamDropdown_Openbuton.click();
        Thread.sleep(200);
        if (teamDropdown_TeamList.isDisplayed()) {
            webDriverHelper.waitUntilVisible(teamDropdown_TeamList, 30, 1);
            teamDropdown_TeamList.click();
            Thread.sleep(6000);
            String newDevicesSyncingStats = devicePageStats.getText();
            Assert.assertNotEquals(newDevicesSyncingStats, devicesSyncingCount);
        } else {
            Assert.assertTrue(noDevices_DevicePage.isDisplayed(), "No devices is no shown");
        }
    }

    public void verifyStatsOnOrgSwitch(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(GPS_coordinates_icon, 30, 1);
        String statsCount = devicePageStats.getText();
        orgDropdown_Openbuton.click();
        Thread.sleep(200);
        webDriverHelper.waitUntilVisible(orgDropdown_orgList, 30, 1);
        orgDropdown_orgList.click();
        Thread.sleep(8000);
        if (devicesTableLastRow.isDisplayed()) {
            webDriverHelper.waitUntilVisible(devicePageStats, 30, 2);
            String newStats = devicePageStats.getText();
            Assert.assertNotEquals(newStats, statsCount);
        } else {
            Assert.assertTrue(noDevices_DevicePage.isDisplayed(), "No devices is no shown");
        }
    }

    public void verifyDevicesSyncingCardStats(String role) throws IOException, InterruptedException {
        verifyActiveDevicesStats();
        verifyNewStats();
    }

    public void verifyDevicesNotSyncingCardStats(String role) throws IOException, InterruptedException {
        verifyInactiveDevicesStats();
        verifyDormantDevicesStats();
    }

    public void verifyBatteryStats(String role) throws IOException, InterruptedException {
        verifyEmptyLowBatteryStats();
        verifyMediumBatteryStats();
    }

    public void verifyLastSync(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        for (WebElement element : lastSyncRed_inTable) {
            if (element.isDisplayed()) {
                String redColor = element.getCssValue("color");
                Assert.assertEquals(redColor, "rgba(255, 97, 53, 0.82)");
            }
        }
    }

    public void verifySensors_Port1Analog(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 200, 1);
        if (!validateBtn_inTable.isEmpty()) {
            validateBtn_inTable.get(1).click();
            System.out.println("validateBtn_inTable.get(1):- " + validateBtn_inTable.get(1));
            webDriverHelper.waitUntilVisible(port1AnalogText, 300, 1);
            Thread.sleep(5000);
            webDriverHelper.waitUntilVisible(offsetText_degree, 300, 1);
            Assert.assertTrue(offsetText_degree.isDisplayed(), "offsetText_degree is not displayed");
        } else {
//            Assert.assertFalse(offsetText_degree.isDisplayed(), "offsetText_degree is not displayed");
            System.out.println("No validate button is present");
        }
    }

    public void verifyDeleteSensor_AlLPort(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 200, 1);
        webDriverHelper.waitUntilVisible(menuBtnDeviceTable, 300, 1);
        menuBtnDeviceTable.click();
        webDriverHelper.waitUntilVisible(validateSensorBtn, 300, 1);
    }

    public void verifyDevice_ID_Sorting(String role) throws IOException, InterruptedException {
        Device_ID_Column_Sorting();
    }

    public void verifySites_Sorting(String role) throws IOException, InterruptedException {
        sitesColumn_Sorting();
    }

    public void verifyBattery_Sorting(String role) throws IOException, InterruptedException {
        batteryColumn_Sorting();
    }

    public void verifyConnectivity_Sorting(String role) throws IOException, InterruptedException {
        connectivityColumn_Sorting();
    }

    public void verifyLastSync_Sorting(String role) throws IOException, InterruptedException {
        lastSyncColumn_Sorting();
    }

    public void verifyStatus_Sorting(String role) throws IOException, InterruptedException {
        statusColumn_Sorting();
    }

    public void verifySitesRedirection(String role) throws IOException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        if (siteName_inTable.size() > 0) {
            siteName_inTable.get(1).click();
            webDriverHelper.waitUntilVisible(currentCondition_WeatherPage, 30, 1);
            assertTrue(currentCondition_WeatherPage.isDisplayed(), "redirection to weather page not happening");
        } else {
            System.out.println("No site name present");
            driver.close();
        }
    }

    public void Device_ID_Column_Sorting() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        String tableContents = devicesList1_gridBody_inTable.getText();
        if (devicesList_gridBody_inTable.size() > 1) {
            sortDeviceID_inTable.click();
            Thread.sleep(5000);
            String TableContent_afterSort = devicesList1_gridBody_inTable.getText();
            if (tableContents != TableContent_afterSort) {
                Assert.assertNotEquals(TableContent_afterSort, tableContents);
            } else {
                Thread.sleep(5000);
                String TableContent_afterSortAndWait = devicesList1_gridBody_inTable.getText();
                Assert.assertNotEquals(TableContent_afterSortAndWait, tableContents);
            }
            sortDeviceID_inTable.click();
            Thread.sleep(5000);
            String TableContent_afterAscSort = devicesList1_gridBody_inTable.getText();
            Assert.assertNotEquals(TableContent_afterAscSort, TableContent_afterSort);
        } else {
            driver.close();
        }
    }

    public void sitesColumn_Sorting() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        String tableContents = devicesList1_gridBody_inTable.getText();
        if (devicesList_gridBody_inTable.size() > 1) {
            sortSites_inTable.click();
            String TableContent_afterSort = devicesList1_gridBody_inTable.getText();
            if (tableContents != TableContent_afterSort) {
                Assert.assertNotEquals(TableContent_afterSort, tableContents);
            } else {
                String TableContent_afterSortAndWait = devicesList1_gridBody_inTable.getText();
                Assert.assertNotEquals(TableContent_afterSortAndWait, tableContents);
            }
            sortSites_inTable.click();
            String TableContent_afterAscSort = devicesList1_gridBody_inTable.getText();
            Assert.assertNotEquals(TableContent_afterAscSort, TableContent_afterSort);
        } else {
            driver.close();
        }
    }

    public void batteryColumn_Sorting() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        String tableContents = devicesList1_gridBody_inTable.getText();
        if (devicesList_gridBody_inTable.size() > 1) {
            sortBattery_inTable.click();
            Thread.sleep(5000);
            String TableContent_afterSort = devicesList1_gridBody_inTable.getText();
            if (tableContents != TableContent_afterSort) {
                Assert.assertNotEquals(TableContent_afterSort, tableContents);
            } else {
                Thread.sleep(5000);
                String TableContent_afterSortAndWait = devicesList1_gridBody_inTable.getText();
                Assert.assertNotEquals(TableContent_afterSortAndWait, tableContents);
            }
            sortBattery_inTable.click();
            Thread.sleep(5000);
            String TableContent_afterAscSort = devicesList1_gridBody_inTable.getText();
            Assert.assertNotEquals(TableContent_afterAscSort, TableContent_afterSort);
        } else {
            driver.close();
        }
    }

    public void connectivityColumn_Sorting() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        String tableContents = devicesList1_gridBody_inTable.getText();
        if (devicesList_gridBody_inTable.size() > 1) {
            sortConnectivity_inTable.click();
            Thread.sleep(5000);
            String TableContent_afterSort = devicesList1_gridBody_inTable.getText();
            if (tableContents != TableContent_afterSort) {
                Assert.assertNotEquals(TableContent_afterSort, tableContents);
            } else {
                Thread.sleep(5000);
                String TableContent_afterSortAndWait = devicesList1_gridBody_inTable.getText();
                Assert.assertNotEquals(TableContent_afterSortAndWait, tableContents);
            }
            sortConnectivity_inTable.click();
            Thread.sleep(5000);
            String TableContent_afterAscSort = devicesList1_gridBody_inTable.getText();
            Assert.assertNotEquals(TableContent_afterAscSort, TableContent_afterSort);
        } else {
            driver.close();
        }
    }

    public void lastSyncColumn_Sorting() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        String tableContents = devicesList1_gridBody_inTable.getText();
        if (devicesList_gridBody_inTable.size() > 1) {
            sortLastSync_inTable.click();
            Thread.sleep(5000);
            String TableContent_afterSort = devicesList1_gridBody_inTable.getText();
            if (tableContents != TableContent_afterSort) {
                Assert.assertNotEquals(TableContent_afterSort, tableContents);
            } else {
                Thread.sleep(5000);
                String TableContent_afterSortAndWait = devicesList1_gridBody_inTable.getText();
                Assert.assertNotEquals(TableContent_afterSortAndWait, tableContents);
            }
            sortLastSync_inTable.click();
            Thread.sleep(5000);
            String TableContent_afterAscSort = devicesList1_gridBody_inTable.getText();
            Assert.assertNotEquals(TableContent_afterAscSort, TableContent_afterSort);
        } else {
            driver.close();
        }
    }

    public void statusColumn_Sorting() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        String tableContents = devicesList1_gridBody_inTable.getText();
        if (devicesList_gridBody_inTable.size() > 1) {
            sortStatus_inTable.click();
            Thread.sleep(5000);
            String TableContent_afterSort = devicesList1_gridBody_inTable.getText();
            if (tableContents != TableContent_afterSort) {
                Assert.assertNotEquals(TableContent_afterSort, tableContents);
            } else {
                Thread.sleep(5000);
                String TableContent_afterSortAndWait = devicesList1_gridBody_inTable.getText();
                Assert.assertNotEquals(TableContent_afterSortAndWait, tableContents);
            }
            sortStatus_inTable.click();
            Thread.sleep(3000);
            String TableContent_afterAscSort = devicesList1_gridBody_inTable.getText();
            Assert.assertNotEquals(TableContent_afterAscSort, TableContent_afterSort);
        } else {
            driver.close();
        }
    }


    public void verifyEmptyLowBatteryStats() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        int lowBatteryCount = lowBattery_inTable.size();
        int emptyBatteryCount = emptyBattery_inTable.size();
        int totalLowEmptyCount = lowBatteryCount + emptyBatteryCount;
        String countLE = String.valueOf(totalLowEmptyCount);
        String lowEmptyCountInCard = batteryCard_lowEmptyCount.getText().substring(0, 2);
//        assertTrue(lowEmptyCountInCard.contains(countLE));
    }

    public void verifyMediumBatteryStats() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        int mediumBatteryCount = mediumBattery_inTable.size();
        String countM = String.valueOf(mediumBatteryCount);
        String mediumCountInCard = batteryCard_mediumCount.getText().substring(0, 2);
//        assertTrue(mediumCountInCard.contains(countM));
    }

    public void verifyActiveDevicesStats() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        int ActiveStatusCount = status_Active.size();
        String count = String.valueOf(ActiveStatusCount);
        String ActiveCountInCard = devicesSyncCard_ActiveCount.getText().substring(0, 2);
        assertTrue(ActiveCountInCard.contains(count));
    }

    public void verifyNewStats() throws IOException, InterruptedException {
        int NewStatusCount = status_New.size();
        String newCount = String.valueOf(NewStatusCount);
        String NewCountInCard = devicesSyncCard_NewCount.getText().substring(0, 2);
        assertTrue(NewCountInCard.contains(newCount));
    }

    public void verifyInactiveDevicesStats() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        int InactiveStatusCount = status_Inactive.size();
        String count = String.valueOf(InactiveStatusCount);
        String InactiveCountInCard = devicesSyncCard_InactiveCount.getText().substring(0, 2);
        System.out.println("count :-" + count + "& incard:-" + InactiveCountInCard);
//        assertTrue(InactiveCountInCard.contains(count));
    }

    public void verifyDormantDevicesStats() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(devicesTableLastRow, 30, 1);
        Thread.sleep(2000);
        int DormantStatusCount = status_Dormant.size();
        String count = String.valueOf(DormantStatusCount);
        String DormantCountInCard = devicesSyncCard_DormantCount.getText().substring(0, 2);
        assertTrue(DormantCountInCard.contains(count));
    }


    public void verifyDevicesSyncModalInfo(String role) {
        webDriverHelper.waitUntilVisible(devices_Syncing_Modal, 30, 1);
        devices_Syncing_Modal.click();
        webDriverHelper.waitUntilVisible(devices_Syncing_Modal_text, 30, 1);
        assertTrue(devices_Syncing_Modal_text.isDisplayed(), "devices syncing modal does not contain 8.5 hrs text");
        modal_icon_close.click();
    }

    public void verifyDevicesNotSyncModalInfo(String role) {
        webDriverHelper.waitUntilVisible(devices_Not_Syncing_Modal, 30, 1);
        devices_Not_Syncing_Modal.click();
        webDriverHelper.waitUntilVisible(devices_Not_Syncing_Modal_text, 30, 1);
        assertTrue(devices_Not_Syncing_Modal_text.isDisplayed(), "devices not syncing modal does not contain 12 hrs text");
        modal_icon_close.click();
    }

    public void verifyBatteryModalInfo(String role) {
        webDriverHelper.waitUntilVisible(battery_Modal, 30, 1);
        battery_Modal.click();
        webDriverHelper.waitUntilVisible(battery_Modal_text, 30, 1);
        assertTrue(battery_Modal_text.isDisplayed(), "battery modal does not contain zero text");
        modal_icon_close.click();
    }

    public void verifyActiveModalInfo(String role) {
        webDriverHelper.waitUntilVisible(active_Modal, 120, 1);
        active_Modal.click();
        webDriverHelper.waitUntilVisible(devices_Syncing_Modal_text, 30, 1);
        assertTrue(devices_Syncing_Modal_text.isDisplayed(), "battery modal does not contain zero text");
        modal_icon_close.click();
    }

    public void verifyNewModalInfo(String role) {
        webDriverHelper.waitUntilVisible(new_Modal, 30, 1);
        new_Modal.click();
        webDriverHelper.waitUntilVisible(devices_Syncing_Modal_text, 30, 1);
        assertTrue(devices_Syncing_Modal_text.isDisplayed(), "battery modal does not contain zero text");
        modal_icon_close.click();
    }

    public void verifyInactiveModalInfo(String role) {
        webDriverHelper.waitUntilVisible(inactive_Modal, 30, 1);
        inactive_Modal.click();
        webDriverHelper.waitUntilVisible(devices_Not_Syncing_Modal_text, 30, 1);
        assertTrue(devices_Not_Syncing_Modal_text.isDisplayed(), "devices not syncing modal does not contain 12 hrs text");
        modal_icon_close.click();
    }

    public void verifyDormantModalInfo(String role) {
        webDriverHelper.waitUntilVisible(dormant_Modal, 30, 1);
        dormant_Modal.click();
        webDriverHelper.waitUntilVisible(devices_Not_Syncing_Modal_text, 30, 1);
        assertTrue(devices_Not_Syncing_Modal_text.isDisplayed(), "devices not syncing modal does not contain 12 hrs text");
        modal_icon_close.click();
    }

    public void verifyGpsModalInfo(String role) {
        webDriverHelper.waitUntilVisible(gps_Modal, 30, 1);
        gps_Modal.click();
        webDriverHelper.waitUntilVisible(gps_Modal_text, 30, 1);
        assertTrue(gps_Modal_text.isDisplayed(), "gps modal does not contain text");
        modal_icon_close.click();
    }

    public void verifyModelModalInfo(String role) {
        webDriverHelper.waitUntilVisible(model_Modal, 30, 1);
        model_Modal.click();
        webDriverHelper.waitUntilVisible(model_ModalInfoText, 30, 1);
        assertTrue(model_ModalInfoText.isDisplayed(), "model modal does not contain mark text");
        modal_icon_close.click();
    }

    public void verifyBatteryHeaderModalInfo(String role) {
        webDriverHelper.waitUntilVisible(battery_header_Modal, 30, 1);
        battery_header_Modal.click();
        webDriverHelper.waitUntilVisible(battery_Modal_text, 30, 1);
        assertTrue(battery_Modal_text.isDisplayed(), "battery modal does not contain 12 hrs text");
        modal_icon_close.click();
    }

    public void verifyConnectivityModalInfo(String role) {
        webDriverHelper.waitUntilVisible(connectivity_Modal, 30, 1);
        connectivity_Modal.click();
        webDriverHelper.waitUntilVisible(connectivity_Modal_text, 30, 1);
        assertTrue(connectivity_Modal_text.isDisplayed(), "battery modal does not contain 12 hrs text");
        modal_icon_close.click();
    }

    public void verifyLastSyncModalInfo(String role) {
        webDriverHelper.waitUntilVisible(lastSync_Modal, 30, 1);
        lastSync_Modal.click();
        webDriverHelper.waitUntilVisible(lastSync_Modal_text, 30, 1);
        assertTrue(lastSync_Modal_text.isDisplayed(), "last sync modal does not contain text");
        modal_icon_close.click();
    }

    public void verifyStatusModalInfo(String role) {
        webDriverHelper.waitUntilVisible(status_Modal, 30, 1);
        status_Modal.click();
        webDriverHelper.waitUntilVisible(status_Modal_text, 30, 1);
        assertTrue(status_Modal_text.isDisplayed(), "status modal does not contain text");
        modal_icon_close.click();
    }

    public void verifyConnectedSensorsModalInfo(String role) {
        webDriverHelper.waitUntilVisible(connectedSensors_Modal, 30, 1);
        connectedSensors_Modal.click();
        webDriverHelper.waitUntilVisible(connectedSensors_Modal_text, 30, 1);
        assertTrue(connectedSensors_Modal_text.isDisplayed(), "connected Sensors modal does not contain text");
        modal_icon_close.click();
    }

    public void verifyTheUnitForVolume() throws InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(dashboardMenu_Settings, 30, 1);
            Actions action = new Actions(driver);
            action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Devices).click().build().perform();
            webDriverHelper.waitUntilVisible(deviceListTag, 120, 1);
            Thread.sleep(10000);
            int i = 0;
            Assert.assertFalse(pressureSensor.isEmpty(), "There was no 'GEMS PS41 Series Pressure Switch' sensor presented on the device page.");
            for (WebElement pressureName : pressureSensor) {
                i++;
                int numbPressurePresentedInPage = pressureSensor.size();
                webDriverHelper.waitUntilVisible(pressureName, 90, 1);
                webDriverHelper.scrollToWebElement(pressureName);
                pressureName.click();
                Thread.sleep(1000);
                webDriverHelper.waitUntilVisible(validateSensorsTag, 90, 1);
                validateSensorsTag.click();
                webDriverHelper.waitUntilVisible(headerTag, 90, 1);
                webDriverHelper.scrollToWebElement(inputNumberTag);
                webDriverHelper.waitUntilVisible(inputNumberTag, 90, 1);
                inputNumberTag.clear();
                inputNumberTag.sendKeys("0");
                String headerName = headerTag.getText();
                if (headerName.trim().contains("Set Up Connected Sensors")) {
                    String errorMessage = setUpConnectedSensorsErrorMsg.getText();
                    Assert.assertTrue(errorMessage.contains(volumeUnit), "the unit is not matching in the Set Up Connected Sensors popup page");
                } else {
                    String connectedSensorUnits = connectedSensorsUnit.getText();
                    Assert.assertTrue(connectedSensorUnits.contains(volumeUnit), "the unit is not matching in the Set Up Connected Sensors popup page");
                }
                if (numbPressurePresentedInPage != i) {
                    action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Devices).click().build().perform();
                    webDriverHelper.waitUntilVisible(deviceListTag, 120, 1);
                } else {
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheUnitForVolume.jpg");
            Assert.fail("The exception in the verifyTheUnitForVolume" + exc);
        }
    }

    public void navigateToDevicesOptionPageFromSettings() {
        webDriverHelper.waitUntilVisible(dashboardMenu_Settings, 30, 1);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Devices).click().build().perform();
    }

}
