package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static support.World.map;
import static support.World.webDriverHelper;


public class AlertSettings {

    private final WebDriver driver;
    //    @FindBy(xpath = "//div[@class='box']//div[1]//arable-site-subscription-box[1]//div[1]//div[2]//div[1]")
//    private WebElement defaultNotificationSetting;
    @FindBy(xpath = "//div[1]/arable-site-subscription-box[1]/div[1]/div[2]/div[1]")
    WebElement defaultNotificationSetting;
    @FindBy(xpath = "((//div[@class='row'])[4]")
    private WebElement sitesNotificationSetting;
    @FindAll({@FindBy(xpath = "//div[@class='navigation']/ul[1]/li/div/a")})
    private List<WebElement> dashboardMenuF;
    @FindBy(xpath = "//p[normalize-space()='Settings']")
    private WebElement dashboardMenu_Settings;
    @FindBy(xpath = "//p[normalize-space()='Alert Settings']")
    private WebElement dashboardMenu_AlertSettings;
    @FindBy(xpath = "//div[@class='header']//div[@class='actions']")
    private WebElement addSettingsToSiteButton;
    @FindBy(xpath = "//div[@class='site-box clickable selected with-shadow ng-star-inserted']")
    private WebElement addSettingsForSite;
    @FindBy(xpath = "//div[@class='sites']")
    private WebElement addSettingsToSiteSList;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement addSettingsToSiteConfirmBtn;
    @FindBy(xpath = "//button[@class='btn-action close'][normalize-space()='Close']")
    private WebElement addSettingsToSiteCloseBtn;
    @FindBy(xpath = "(//p[contains(text(),'Please, select a site.')])[2]")
    private WebElement addSettingsToSiteErrorMsg;
    @FindBy(xpath = "//span[normalize-space()='Default']")
    private WebElement defaultModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Default Alerts']")
    private WebElement defaultModalInfoText;
    @FindBy(xpath = "//span[normalize-space()='Specific']")
    private WebElement specificModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Site-Specific Alerts']")
    private WebElement specificModalInfoText;
    @FindBy(xpath = "//span[normalize-space()='Weather']")
    private WebElement weatherModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Weather']")
    private WebElement weatherModalInfoText;
    @FindBy(xpath = "//span[normalize-space()='Crop Health']")
    private WebElement cropHealthModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Crop Health']")
    private WebElement cropHealthModalInfoText;
    @FindBy(xpath = "//span[normalize-space()='Device']")
    private WebElement deviceModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Device']")
    private WebElement deviceModalInfoText;
    @FindBy(xpath = "//span[normalize-space()='Mobile']")
    private WebElement mobileModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Mobile App']")
    private WebElement mobileModalInfoText;
    @FindBy(xpath = "//span[normalize-space()='SMS']")
    private WebElement smsModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='SMS']")
    private WebElement smsModalInfoText;
    @FindBy(xpath = "//span[normalize-space()='Voice']")
    private WebElement voiceModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Voice Call']")
    private WebElement voiceModalInfoText;
    @FindBy(xpath = "//span[normalize-space()='Default Notifications Settings']")
    private WebElement defaultNotificationsSettingsModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Default Notification Settings']")
    private WebElement defaultNotificationsSettingsModalInfoText;
    @FindBy(xpath = "(//span[normalize-space()='Heat Spikes'])[1]")
    private WebElement heatSpikesModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Heat Spikes']")
    private WebElement heatSpikesModalInfoText;
    @FindBy(xpath = "(//span[normalize-space()='Frost Events'])[1]")
    private WebElement frostEventsModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Frost Events']")
    private WebElement frostEventsModalInfoText;
    @FindBy(xpath = "(//span[normalize-space()='Rainfall Events'])[1]")
    private WebElement rainfallEventsModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Rainfall Events']")
    private WebElement rainfallEventsModalInfoText;
    @FindBy(xpath = "(//span[normalize-space()='GDD & Growth Stages'])[1]")
    private WebElement gddModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='GDD and Growth Stages']")
    private WebElement gddModalInfoText;
    @FindBy(xpath = "(//span[normalize-space()='Inactive and New Sites'])[1]")
    private WebElement inactiveAndNewSitesModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Site Alerts']")
    private WebElement inactiveAndNewSitesModalInfoText;
    @FindBy(xpath = "(//span[normalize-space()='Device Tilts'])[1]")
    private WebElement deviceTiltsModalInfo;
    @FindBy(xpath = "//h1[normalize-space()='Device Tilt Alerts']")
    private WebElement deviceTiltsModalInfoText;
    @FindBy(xpath = "(//div[@class='menu-button'])[1]")
    private WebElement defaultSettingsMenuBtn;
    @FindBy(xpath = "//div[contains(text(),'Send Test Alert')]")
    private WebElement sendTestAlertBtn;
    @FindBy(xpath = "//div[@class='container-channels']//div[@class='channels']")
    private WebElement sendAlertChannels;
    @FindBy(xpath = "//button[contains(text(),'Send')][@class='btn-action confirm disabled']")
    private WebElement disabledSendBtn;
    @FindBy(xpath = "//button[contains(text(),'Send')]")
    private WebElement SendBtn;
    @FindBy(xpath = "(//div[@class='btn'])[1]")
    private WebElement smsChannel;
    @FindBy(xpath = "(//h3[contains(text(),'Test Alert Sent.')])[2]")
    private WebElement successToast;
    @FindBy(xpath = "(//div[@class='btn'])[2]")
    private WebElement mobileChannel;
    @FindBy(xpath = "(//div[@class='btn'])[3]")
    private WebElement phoneChannel;
    @FindBy(xpath = "//div[@class='modal fade in show']//img[@alt='icon_close']")
    private WebElement SendAlertCloseBtn;
    @FindBy(xpath = "(//div[@class='channels']//div)[1]")
    private WebElement heatSpikeSMSAlertBtn;
    @FindBy(xpath = "(//h3[contains(text(),'Default Notification Settings Saved.')])[2]")
    private WebElement heatSpikeSMSAlertSuccessToast;
    @FindBy(xpath = "//h1[normalize-space()='Sites']")
    private WebElement sitesBanner;
    @FindBy(xpath = "//h1[normalize-space()='Categories (last 7 days)']")
    private WebElement categoriesBanner;
    @FindBy(xpath = "//h1[normalize-space()='Channels (last 7 days)']")
    private WebElement channelsBanner;
    @FindAll(@FindBy(xpath = "(//div[@class='item-stat'])[1]"))
    private List<WebElement> siteBannerContents;
    @FindBy(xpath = "//div[@class='org-selector']")
    private WebElement globalOrgSelector;
    @FindBy(xpath = "//div[@class='notifications-header']")
    private WebElement notificationHeaderB;
    //    @FindBy(xpath = "//span[@class='caret 1']")
//    private WebElement orgDropdown_OpenButton;
    @FindBy(xpath = "//span[@class='1 caret']")
    private WebElement orgDropdown_OpenButton;
//    @FindBy(xpath = "//div[@class='dropdown-selector 1 open']//div[@class='grid grid-center option']")
//    private WebElement orgDropdown_orgList;

    @FindBy(xpath = "(//div[@class='1 dropdown-selector open']//div[@class='options']//p)[2]")
    private WebElement orgDropdown_orgList;

    //    @FindBy(xpath = "//span[@class='caret 0']")
//    private WebElement teamDropdown_OpenButton;
    @FindBy(xpath = "//span[@class='2 caret']")
    private WebElement teamDropdown_OpenButton;
    //    @FindBy(xpath = "//div[@class='team-selector']//div[@class='options ng-star-inserted']//div[2]")
//    private WebElement teamDropdown_List;
    @FindBy(xpath = "(//div[@class='2 dropdown-selector open']//div[@class='options']//p)[2]")
    private WebElement teamDropdown_List;


    public AlertSettings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
        map.navigateToPage(role);
        webDriverHelper.waitUntilVisible(dashboardMenu_Settings, 30, 1);
//        webDriverHelper.waitUntilVisibilityOfAllElements(dashboardMenuF, 30, 1);
//        for (WebElement element : dashboardMenuF) {
//            if (element.getAttribute("title").equalsIgnoreCase(page)) {
//                element.click();
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_AlertSettings).click().build().perform();
    }

    public void verifyNotificationCountInBannerOnOrgSwitch(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(notificationHeaderB, 30, 1);
        String activity1 = notificationHeaderB.getText();
        Thread.sleep(500);
        orgDropdown_OpenButton.click();
        Thread.sleep(200);
        if (!(role.equalsIgnoreCase("orgAdmin") || role.equalsIgnoreCase("sysReader"))) {
            webDriverHelper.waitUntilVisible(orgDropdown_orgList, 30, 1);
            orgDropdown_orgList.click();
            Thread.sleep(6000);
            webDriverHelper.waitUntilVisible(defaultNotificationsSettingsModalInfo, 30, 1);
            String newActivity1 = notificationHeaderB.getText();
//            Assert.assertNotEquals(newActivity1, activity1);
        }
    }

    public void verifyNotificationCountInBannerOnTeamSwitch(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(defaultNotificationSetting, 90, 1);
        String activity1 = notificationHeaderB.getText();
        Thread.sleep(500);
        teamDropdown_OpenButton.click();
        Thread.sleep(1000);
        if (!(role.equalsIgnoreCase("sysReader"))) {
            webDriverHelper.waitUntilVisible(teamDropdown_List, 30, 1);
            Thread.sleep(1000);
            teamDropdown_List.click();
            Thread.sleep(6000);
            webDriverHelper.waitUntilVisible(defaultNotificationsSettingsModalInfo, 30, 1);
            String newActivity1 = notificationHeaderB.getText();
            Assert.assertNotEquals(newActivity1, activity1);
        }
    }

    public void verifyGlobalOrgDropdown(String role) throws IOException {
        webDriverHelper.waitUntilVisible(globalOrgSelector, 60, 1);
        Assert.assertTrue(globalOrgSelector.isDisplayed(), "global Org Selector is not displayed");
    }

    public void verifySitesBannerContents(String role) throws IOException {
        webDriverHelper.waitUntilVisible(defaultModalInfo, 60, 1);
        for (WebElement element : siteBannerContents) {
            String contents = element.getText();
            System.out.println(contents);
            Assert.assertTrue(contents.contains("Default"), "sites default is not displayed");
            Assert.assertTrue(contents.contains("Specific"), "sites Specific is not displayed");
        }
    }

    public void verifySubscribingHeatSpikeSMSAlert(String role) throws IOException {
        subscribingHeatSpikeSMSAlert();
    }

    public void verifyUnsubscribingHeatSpikeSMSAlert(String role) throws IOException, InterruptedException {
        subscribingHeatSpikeSMSAlert();
        Thread.sleep(200);
        heatSpikeSMSAlertBtn.click();
        webDriverHelper.waitUntilVisible(heatSpikeSMSAlertSuccessToast, 60, 1);
        Assert.assertTrue(heatSpikeSMSAlertSuccessToast.isDisplayed(), "heat Spike SMS Alert unsubscribe SuccessToast is not displayed");

    }

    public void subscribingHeatSpikeSMSAlert() throws IOException {
        try {
            webDriverHelper.waitUntilVisible(defaultSettingsMenuBtn, 60, 1);
        } catch (StaleElementReferenceException e) {
            webDriverHelper.waitUntilVisible(defaultSettingsMenuBtn, 60, 1);
        }
        webDriverHelper.waitUntilVisible(heatSpikeSMSAlertBtn, 60, 1);
        webDriverHelper.waitUntilVisible(heatSpikeSMSAlertBtn, 60, 1);
        heatSpikeSMSAlertBtn.click();
        webDriverHelper.waitUntilVisible(heatSpikeSMSAlertSuccessToast, 60, 1);
        Assert.assertTrue(heatSpikeSMSAlertSuccessToast.isDisplayed(), "heatSpikeSMSAlertSuccessToast is not displayed");
    }

    public void verifyBanners(String role) throws IOException {
        webDriverHelper.waitUntilVisible(sitesBanner, 60, 1);
        Assert.assertTrue(sitesBanner.isDisplayed(), "sitesBanner is not displayed");
        Assert.assertTrue(categoriesBanner.isDisplayed(), "categoriesBanner is not displayed");
        Assert.assertTrue(channelsBanner.isDisplayed(), "channelsBanner is not displayed");
    }

    public void verifySendTestAlertsOption(String role) throws IOException {
        verifySendTestAlertsOption();
    }

    public void verifySendTestAlertChannels(String role) throws IOException {
        verifySendTestAlertChannels();
    }

    public void verifyClosingTheSendingTestAlertModal(String role) throws IOException {
        verifySendTestAlertChannels();
        SendAlertCloseBtn.click();
        webDriverHelper.waitUntilVisible(defaultSettingsMenuBtn, 60, 1);
        Assert.assertTrue(defaultSettingsMenuBtn.isDisplayed(), "defaultSettingsMenuBtn is not displayed");
    }

    public void verifySendingTestAlertForSMS(String role) throws IOException {
        verifySendTestAlertChannels();
        smsChannel.click();
        SendBtn.click();
        webDriverHelper.waitUntilVisible(successToast, 60, 1);
        Assert.assertTrue(successToast.isDisplayed(), "successToast is not displayed");
    }

    public void verifySendingTestAlertForMobile(String role) throws IOException {
        verifySendTestAlertChannels();
        mobileChannel.click();
        SendBtn.click();
        webDriverHelper.waitUntilVisible(successToast, 60, 1);
        Assert.assertTrue(successToast.isDisplayed(), "successToast is not displayed");
    }

    public void verifySendingTestAlertForPhone(String role) throws IOException {
        verifySendTestAlertChannels();
        phoneChannel.click();
        SendBtn.click();
        webDriverHelper.waitUntilVisible(successToast, 60, 1);
        Assert.assertTrue(successToast.isDisplayed(), "successToast is not displayed");
    }


    public void verifySendTestAlertChannels() throws IOException {
        verifySendTestAlertsOption();
        sendTestAlertBtn.click();
        webDriverHelper.waitUntilVisible(sendAlertChannels, 60, 1);
        Assert.assertTrue(disabledSendBtn.isDisplayed(), "disabledSendBtn is not displayed");
        Assert.assertTrue(sendAlertChannels.isDisplayed(), "sendAlertChannels is not displayed");
    }


    public void verifySendTestAlertsOption() throws IOException {
        try {
            webDriverHelper.waitUntilVisible(defaultSettingsMenuBtn, 60, 1);
        } catch (StaleElementReferenceException stale) {
            webDriverHelper.waitUntilVisible(defaultSettingsMenuBtn, 60, 1);
        }
        defaultSettingsMenuBtn.click();
        webDriverHelper.waitUntilVisible(sendTestAlertBtn, 30, 1);
        Assert.assertTrue(sendTestAlertBtn.isDisplayed(), "send Test Alert Btn is not displayed");
    }


    public void verifyWeatherModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(specificModalInfo, 30, 1);
        specificModalInfo.click();
        webDriverHelper.waitUntilVisible(specificModalInfoText, 30, 1);
        Assert.assertTrue(specificModalInfoText.isDisplayed(), "specificModalInfoText is not displayed");
    }

    public void verifyCropHealthModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(cropHealthModalInfo, 30, 1);
        cropHealthModalInfo.click();
        webDriverHelper.waitUntilVisible(cropHealthModalInfoText, 30, 1);
        Assert.assertTrue(cropHealthModalInfoText.isDisplayed(), "cropHealthModalInfoText is not displayed");
    }

    public void verifyDeviceModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(deviceModalInfo, 30, 1);
        deviceModalInfo.click();
        webDriverHelper.waitUntilVisible(deviceModalInfoText, 30, 1);
        Assert.assertTrue(deviceModalInfoText.isDisplayed(), "deviceModalInfoText is not displayed");
    }

    public void verifyMobileModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(mobileModalInfo, 30, 1);
        mobileModalInfo.click();
        webDriverHelper.waitUntilVisible(mobileModalInfoText, 30, 1);
        Assert.assertTrue(mobileModalInfoText.isDisplayed(), "mobileModalInfoText is not displayed");
    }

    public void verifySMSModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(smsModalInfo, 30, 1);
        smsModalInfo.click();
        webDriverHelper.waitUntilVisible(smsModalInfoText, 30, 1);
        Assert.assertTrue(smsModalInfoText.isDisplayed(), "smsModalInfoText is not displayed");
    }

    public void verifyVoiceModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(voiceModalInfo, 30, 1);
        voiceModalInfo.click();
        webDriverHelper.waitUntilVisible(voiceModalInfoText, 30, 1);
        Assert.assertTrue(voiceModalInfoText.isDisplayed(), "voiceModalInfoText is not displayed");
    }

    public void verifyDefaultNotificationsSettingsModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(defaultNotificationsSettingsModalInfo, 30, 1);
        defaultNotificationsSettingsModalInfo.click();
        webDriverHelper.waitUntilVisible(defaultNotificationsSettingsModalInfoText, 30, 1);
        Assert.assertTrue(defaultNotificationsSettingsModalInfoText.isDisplayed(), "defaultNotificationsSettingsModalInfoText is not displayed");
    }

    public void verifyHeatSpikesModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(heatSpikesModalInfo, 30, 1);
        heatSpikesModalInfo.click();
        webDriverHelper.waitUntilVisible(heatSpikesModalInfoText, 30, 1);
        Assert.assertTrue(heatSpikesModalInfoText.isDisplayed(), "heatSpikesModalInfoText is not displayed");
    }

    public void verifyFrostModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(frostEventsModalInfo, 30, 1);
        frostEventsModalInfo.click();
        webDriverHelper.waitUntilVisible(frostEventsModalInfoText, 30, 1);
        Assert.assertTrue(frostEventsModalInfoText.isDisplayed(), "frostEventsModalInfoText is not displayed");
    }

    public void verifyRainfallModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(rainfallEventsModalInfo, 30, 1);
        rainfallEventsModalInfo.click();
        webDriverHelper.waitUntilVisible(rainfallEventsModalInfoText, 30, 1);
        Assert.assertTrue(rainfallEventsModalInfoText.isDisplayed(), "rainfallEventsModalInfoText is not displayed");
    }

    public void verifyGDDModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(gddModalInfo, 30, 1);
        gddModalInfo.click();
        webDriverHelper.waitUntilVisible(gddModalInfoText, 30, 1);
        Assert.assertTrue(gddModalInfoText.isDisplayed(), "gddModalInfoText is not displayed");
    }

    public void verifyInactiveNewSitesModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(inactiveAndNewSitesModalInfo, 30, 1);
        inactiveAndNewSitesModalInfo.click();
        webDriverHelper.waitUntilVisible(inactiveAndNewSitesModalInfoText, 30, 1);
        Assert.assertTrue(inactiveAndNewSitesModalInfoText.isDisplayed(), "inactiveAndNewSitesModalInfoText is not displayed");
    }

    public void verifyDeviceTiltsModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(deviceTiltsModalInfo, 30, 1);
        deviceTiltsModalInfo.click();
        webDriverHelper.waitUntilVisible(deviceTiltsModalInfoText, 30, 1);
        Assert.assertTrue(deviceTiltsModalInfoText.isDisplayed(), "deviceTiltsModalInfoText is not displayed");
    }

    public void verifySpecificSiteModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(specificModalInfo, 30, 1);
        specificModalInfo.click();
        webDriverHelper.waitUntilVisible(specificModalInfoText, 30, 1);
        Assert.assertTrue(specificModalInfoText.isDisplayed(), "default info text is not displayed");
    }

    public void verifyDefaultSiteModalInfo(String role) throws IOException {
        webDriverHelper.waitUntilVisible(defaultModalInfo, 30, 1);
        defaultModalInfo.click();
        webDriverHelper.waitUntilVisible(defaultModalInfoText, 30, 1);
        Assert.assertTrue(defaultModalInfoText.isDisplayed(), "default info text is not displayed");
    }

//    public void captureAlertSettingsPageLoadTime(String role) throws IOException, InterruptedException {
//        long start = System.currentTimeMillis();
////        StringHelper.devToolCapture(role);
//        webDriverHelper.waitUntilVisible(defaultNotificationSetting, 30, 1);
//        if (defaultNotificationSetting.isDisplayed()) {
//            String loadInSeconds = stringHelper.stopTime(start, driver);
//            ExcelReader.setValueForColumn("AlertSettings", loadInSeconds, role);
//            // HTML report generator
//            HTMLReport.addPageName("AlertSettings");
////            HTMLReport.generateReport("AlertSettings", loadInSeconds, role);
//            HTMLReport.writeReportToFile();
//            Assert.assertTrue(defaultNotificationSetting.isDisplayed(), "alerts settings table is displayed");
//        }
//    }

    public void addSettingsToSpecificSitesView(String role) throws IOException {
        addSettingsToSpecificSitesView();
    }

    public void addSettingsForSpecificSite(String role) throws IOException {
        if (!(role.equalsIgnoreCase("sysReader"))) {
            addSettingsToSpecificSitesView();
            addSettingsToSiteConfirmBtn.click();
            webDriverHelper.waitUntilVisible(addSettingsToSiteErrorMsg, 30, 1);
            Assert.assertTrue(addSettingsToSiteErrorMsg.isDisplayed(), "error msg is not displayed");
        }
    }

    public void addSettingsToSpecificSitesView() throws IOException {
        webDriverHelper.waitUntilVisible(defaultNotificationSetting, 30, 1);
        if (addSettingsToSiteButton.isDisplayed()) {
            addSettingsToSiteButton.click();
            webDriverHelper.waitUntilVisible(addSettingsToSiteSList, 30, 1);
            Assert.assertTrue(addSettingsToSiteSList.isDisplayed(), "alerts table is displayed");
        }
    }
}



