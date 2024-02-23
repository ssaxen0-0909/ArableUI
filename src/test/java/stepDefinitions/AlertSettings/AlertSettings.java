package stepDefinitions.AlertSettings;

import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.alertSettings;

public class AlertSettings {
    @When("navigate to page {string} and verify alert settings is displayed for {string} user")
    public void navigateToPageAndVerifyAlertSettingsIsDisplayedForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
    }

//    @Then("update Excel columns for {string} user")
//    public void updateExcelColumnsForUser(String role) throws IOException, InterruptedException {
//        alertSettings.captureAlertSettingsPageLoadTime(role);
//    }

    @When("navigate to page {string},click on Add setting button for {string} user")
    public void navigateToPageClickOnAddSettingButtonForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.addSettingsToSpecificSitesView(role);
    }

    @When("navigate to page {string},click on Add setting button and click on confirm button and verify error msg for {string} user")
    public void navigateToPageClickOnAddSettingButtonAndClickOnConfirmButtonAndVerifyErrorMsgForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.addSettingsForSpecificSite(role);
    }

    @When("navigate to page {string},click on Default and verify modal info for Default Sites for {string} user")
    public void navigateToPageClickOnDefaultAndVerifyModalInfoForDefaultSitesForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyDefaultSiteModalInfo(role);
    }

    @When("navigate to page {string},click on Specific and verify modal info for Specific Sites for {string} user")
    public void navigateToPageClickOnSpecificAndVerifyModalInfoForSpecificSitesForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifySpecificSiteModalInfo(role);
    }

    @When("navigate to page {string},click on Crop Health and verify modal info for {string} user")
    public void navigateToPageClickOnCropHealthAndVerifyModalInfoForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyCropHealthModalInfo(role);
    }

    @When("navigate to page {string},click on Weather and verify modal info for {string} user")
    public void navigateToPageClickOnWeatherAndVerifyModalInfoForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyWeatherModalInfo(role);
    }

    @When("navigate to page {string},click on Device and verify modal info for Device for {string} user")
    public void navigateToPageClickOnDeviceAndVerifyModalInfoForDeviceForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyDeviceModalInfo(role);
    }

    @When("navigate to page {string},click on Mobile and verify modal info for Mobile for {string} user")
    public void navigateToPageClickOnMobileAndVerifyModalInfoForMobileForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyMobileModalInfo(role);
    }


    @When("navigate to page {string},click on SMS and verify modal info for SMS for {string} user")
    public void navigateToPageClickOnSMSAndVerifyModalInfoForSMSForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifySMSModalInfo(role);

    }

    @When("navigate to page {string},click on Voice and verify modal info for Voice for {string} user")
    public void navigateToPageClickOnVoiceAndVerifyModalInfoForVoiceForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyVoiceModalInfo(role);
    }

    @When("navigate to page {string},click on Default Notifications Settings and verify modal info for {string} user")
    public void navigateToPageClickOnDefaultNotificationsSettingsAndVerifyModalInfoForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyDefaultNotificationsSettingsModalInfo(role);
    }

    @When("navigate to page {string},click on Heat Spikes and verify modal info for {string} user")
    public void navigateToPageClickOnHeatSpikesAndVerifyModalInfoForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyHeatSpikesModalInfo(role);
    }

    @When("navigate to page {string},click on Frost Events and verify modal info for {string} user")
    public void navigateToPageClickOnFrostEventsAndVerifyModalInfoForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyFrostModalInfo(role);
    }

    @When("navigate to page {string},click on Rainfall Events and verify modal info for {string} user")
    public void navigateToPageClickOnRainfallEventsAndVerifyModalInfoForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyRainfallModalInfo(role);
    }

    @When("navigate to page {string},click on GDD & Growth Stages and verify modal info for {string} user")
    public void navigateToPageClickOnGDDGrowthStagesAndVerifyModalInfoForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyGDDModalInfo(role);
    }

    @When("navigate to page {string},click on Inactive and New Sites and verify modal info for {string} user")
    public void navigateToPageClickOnInactiveAndNewSitesAndVerifyModalInfoForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyInactiveNewSitesModalInfo(role);
    }

    @When("navigate to page {string},click on Device Tilts and verify modal info for {string} user")
    public void navigateToPageClickOnDeviceTiltsAndVerifyModalInfoForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyDeviceTiltsModalInfo(role);
    }

    @When("navigate to page {string},click on menu button and verify send test alerts for {string} user")
    public void navigateToPageClickOnMenuButtonAndVerifySendTestAlertsForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifySendTestAlertsOption(role);
    }

    @When("navigate to page {string},click on menu button and verify channels option and disabled send button for {string} user")
    public void navigateToPageClickOnMenuButtonAndVerifyChannelsOptionAndDisabledSendButtonForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifySendTestAlertChannels(role);
    }

    @When("navigate to page {string},click on menu button and verify sending test alert through sms channel for {string} user")
    public void navigateToPageClickOnMenuButtonAndVerifySendingTestAlertThroughSmsChannelForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifySendingTestAlertForSMS(role);
    }

    @When("navigate to page {string},click on menu button and verify sending test alert through mobile channel for {string} user")
    public void navigateToPageClickOnMenuButtonAndVerifySendingTestAlertThroughMobileChannelForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifySendingTestAlertForMobile(role);

    }

    @When("navigate to page {string},click on menu button and verify sending test alert through phone channel for {string} user")
    public void navigateToPageClickOnMenuButtonAndVerifySendingTestAlertThroughPhoneChannelForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifySendingTestAlertForPhone(role);
    }

    @When("navigate to page {string},click on menu button and verify closing send alert modal for {string} user")
    public void navigateToPageClickOnMenuButtonAndVerifyClosingSendAlertModalForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyClosingTheSendingTestAlertModal(role);
    }

    @When("navigate to page {string},subscribe to sms alert for Heat spike for {string} user")
    public void navigateToPageSubscribeToSmsAlertForHeatSpikeForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifySubscribingHeatSpikeSMSAlert(role);
    }

    @When("navigate to page {string} and verify banners for {string} user")
    public void navigateToPageAndVerifyBannersForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyBanners(role);
    }

    @When("navigate to page {string} and verify sites banner contents for {string} user")
    public void navigateToPageAndVerifySitesBannerContentsForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifySitesBannerContents(role);
    }

    @When("navigate to page {string} and verify global org selector is displayed on page contents for {string} user")
    public void navigateToPageAndVerifyGlobalOrgSelectorIsDisplayedOnPageContentsForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyGlobalOrgDropdown(role);
    }

    @When("navigate to page {string} and verify banner count is updating on switching org for {string} user")
    public void navigateToPageAndVerifyBannerCountIsUpdatingOnSwitchingOrgForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyNotificationCountInBannerOnOrgSwitch(role);
    }

    @When("navigate to page {string} and verify banner count is updating on switching team for {string} user")
    public void navigateToPageAndVerifyBannerCountIsUpdatingOnSwitchingTeamForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyNotificationCountInBannerOnTeamSwitch(role);
    }

    @When("navigate to page {string} and verify unsubscribing sms alert for {string} user")
    public void navigateToPageAndVerifyUnsubscribingSmsAlertForUser(String page, String role) throws IOException, InterruptedException {
        alertSettings.navigateToPage(page);
        alertSettings.verifyUnsubscribingHeatSpikeSMSAlert(role);
    }
}