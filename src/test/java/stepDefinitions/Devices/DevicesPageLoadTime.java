package stepDefinitions.Devices;

import TestRail.APIException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.devicesPage;
import static support.World.loginPage;

public class DevicesPageLoadTime {
    @Given("log into application with a {string} user")
    public void LogIntoApplicationWithAUser(String role) throws APIException, IOException, InterruptedException {
        loginPage.logInToTheApplication(role);
//        loginPage.verifyLoggedIn();
    }

    @When("navigate to {string} and verify devices table is displayed for {string} user")
    public void navigateToAndVerifyDevicesTableIsDisplayedForUser(String page, String role) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
    }

//    @Then("update Excel for {string} user the time taken to load the page")
//    public void updateExcelForUserTheTimeTakenToLoadThePage(String role) throws IOException, InterruptedException {
//        devicesPage.captureDevicesPageLoadTime(role);
//    }

    @When("navigate to {string} and verify if gps coordinates are getting copied successfully for {string} user")
    public void navigateToAndVerifyIfGpsCoordinatesAreGettingCopiedSuccessfullyForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyGPSCoordinateCopyIcon(role);
    }

    @When("navigate to {string} and verify if devices syncing stats are getting updated on changing Teams  for {string} user")
    public void navigateToAndVerifyIfDevicesSyncingStatsAreGettingUpdatedOnChangingTeamsForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyStatsOnTeamSwitch(role);
    }

    @When("navigate to {string} and verify if stats are getting updated on changing orgs  for {string} user")
    public void navigateToAndVerifyIfStatsAreGettingUpdatedOnChangingOrgsForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyStatsOnOrgSwitch(role);
    }

    @When("navigate to {string} and verify if active & new stats are matching with the count in table for {string} user")
    public void navigateToAndVerifyIfActiveNewStatsAreMatchingWithTheCountInTableForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyDevicesSyncingCardStats(role);
    }

    @When("navigate to {string} and verify if inactive & dormant stats are matching with the count in table for {string} user")
    public void navigateToAndVerifyIfInactiveDormantStatsAreMatchingWithTheCountInTableForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyDevicesNotSyncingCardStats(role);
    }

    @When("navigate to {string} and verify if battery stats for all battery percentage from table are matching for {string} user")
    public void navigateToAndVerifyIfBatteryStatsForAllBatteryPercentageFromTableAreMatchingForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyBatteryStats(role);
    }

    @When("navigate to {string} and verify if last sync equal to or higher than four hrs is shown in red color in table are matching for {string} user")
    public void navigateToAndVerifyIfLastSyncEqualToOrHigherThanFourHrsIsShownInRedColorInTableAreMatchingForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyLastSync(role);
    }

    @When("navigate to {string} and verify if sorting in device id column is working for {string} user")
    public void navigateToAndVerifyIfSortingInDeviceIdColumnIsWorkingForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyDevice_ID_Sorting(role);
    }

    @When("navigate to {string} and verify if sorting in sites column is working for {string} user")
    public void navigateToAndVerifyIfSortingInSitesColumnIsWorkingForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifySites_Sorting(role);
    }

    @When("navigate to {string} and verify if sorting in battery column is working for {string} user")
    public void navigateToAndVerifyIfSortingInBatteryColumnIsWorkingForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyBattery_Sorting(role);
    }

    @When("navigate to {string} and verify if sorting in connectivity column is working for {string} user")
    public void navigateToAndVerifyIfSortingInConnectivityColumnIsWorkingForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyConnectivity_Sorting(role);
    }

    @When("navigate to {string} and verify if sorting in last sync column is working for {string} user")
    public void navigateToAndVerifyIfSortingInLastSyncColumnIsWorkingForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyLastSync_Sorting(role);
    }

    @When("navigate to {string} and verify if sorting in status column is working for {string} user")
    public void navigateToAndVerifyIfSortingInStatusColumnIsWorkingForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyStatus_Sorting(role);
    }

    @When("navigate to {string} and click on site name and verify if navigation is working for {string} user")
    public void navigateToAndClickOnSiteNameAndVerifyIfNavigationIsWorkingForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifySitesRedirection(role);
    }

    @When("navigate to {string} and click on validate button and verify offset values and errors for {string} user")
    public void navigateToAndClickOnValidateButtonAndVerifyOffsetValuesAndErrorsForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifySensors_Port1Analog(role);
    }

    @When("navigate to {string} and click on validate button and verify deleting sensors for {string} user")
    public void navigateToAndClickOnValidateButtonAndVerifyDeletingSensorsForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyDeleteSensor_AlLPort(role);
    }

    @When("navigate to {string} and verify Devices Sync modal info is displayed for {string} user")
    public void navigateToAndVerifyDevicesSyncModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyDevicesSyncModalInfo(role);
    }

    @When("navigate to {string} and verify Devices Not Sync modal info is displayed for {string} user")
    public void navigateToAndVerifyDevicesNotSyncModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyDevicesNotSyncModalInfo(role);
    }

    @When("navigate to {string} and verify Battery modal info is displayed for {string} user")
    public void navigateToAndVerifyBatteryModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyBatteryModalInfo(role);
    }

    @When("navigate to {string} and verify Active modal info is displayed for {string} user")
    public void navigateToAndVerifyActiveModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyActiveModalInfo(role);
    }

    @When("navigate to {string} and verify New modal info is displayed for {string} user")
    public void navigateToAndVerifyNewModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyNewModalInfo(role);
    }

    @When("navigate to {string} and verify Inactive modal info is displayed for {string} user")
    public void navigateToAndVerifyInactiveModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyInactiveModalInfo(role);
    }

    @When("navigate to {string} and verify Dormant modal info is displayed for {string} user")
    public void navigateToAndVerifyDormantModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyDormantModalInfo(role);
    }

    @When("navigate to {string} and verify Gps modal info is displayed for {string} user")
    public void navigateToAndVerifyGpsModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyGpsModalInfo(role);
    }

    @When("navigate to {string} and verify Battery Header modal info is displayed for {string} user")
    public void navigateToAndVerifyBatteryHeaderModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyBatteryHeaderModalInfo(role);
    }

    @When("navigate to {string} and verify Model modal info is displayed for {string} user")
    public void navigateToAndVerifyModelModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyModelModalInfo(role);
    }

    @When("navigate to {string} and verify Last Sync modal info is displayed for {string} user")
    public void navigateToAndVerifyLastSyncModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyLastSyncModalInfo(role);
    }

    @When("navigate to {string} and verify Connectivity modal info is displayed for {string} user")
    public void navigateToAndVerifyConnectivityModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyConnectivityModalInfo(role);
    }

    @When("navigate to {string} and verify Status modal info is displayed for {string} user")
    public void navigateToAndVerifyStatusModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyStatusModalInfo(role);
    }

    @When("navigate to {string} and verify Connected Sensors modal info is displayed for {string} user")
    public void navigateToAndVerifyConnectedSensorsModalInfoIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyConnectedSensorsModalInfo(role);
    }

    @When("navigate to {string} and verify the color for not synced devices for {string} user")
    public void navigateToAndVerifyTheColorForNotSyncedDevicesForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyNotSyncColumnColor(role);
    }

    @When("navigate to {string} and verify the color for synced devices for {string} user")
    public void navigateToAndVerifyTheColorForSyncedDevicesForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifySyncColumnColor(role);
    }

    @When("navigate to {string} and verify the no sensor devices for {string} user")
    public void navigateToAndVerifyTheNoSensorDevicesForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyNoSensorDevice(role);
    }

    @When("navigate to {string} and scroll to bottom and verify options for {string} user")
    public void navigateToAndScrollToBottomAndVerifyOptionsForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyDeviceLimitPerPage(role);
    }

    @When("navigate to {string} and scroll down and verify sensor icon and menu button for {string} user")
    public void navigateToAndScrollDownAndVerifySensorIconAndMenuButtonForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifySensorIconAndMenuBtn(role);
    }

    @When("navigate to {string} and scroll down and verify no sensor icon and menu button for {string} user")
    public void navigateToAndScrollDownAndVerifyNoSensorIconAndMenuButtonForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyNoSensorNoMenuBtn(role);
    }

    @When("navigate to {string} and scroll to bottom and verify view more options for {string} user")
    public void navigateToAndScrollToBottomAndVerifyViewMoreOptionsForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyViewMoreOption(role);
    }

    @When("navigate to {string} and verify total devices count in list with battery stats count for {string} user")
    public void navigateToAndVerifyTotalDevicesCountInListWithBatteryStatsCountForUser(String role, String page) throws IOException, InterruptedException {
        devicesPage.navigateToPage(page);
        devicesPage.verifyBatteryStatsCount(role);
    }

    @Then("verify that the unit is the same in the device page")
    public void verifyThatTheUnitIsTheSameInTheDevicePage() throws IOException, InterruptedException {
        devicesPage.verifyTheUnitForVolume();
    }

    @And("navigate to Devices option page from Settings menu")
    public void navigateToDevicesOptionPageFromSettingsMenu() {
        devicesPage.navigateToDevicesOptionPageFromSettings();
    }
}
