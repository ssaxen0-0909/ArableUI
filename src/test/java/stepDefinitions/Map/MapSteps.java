package stepDefinitions.Map;

import TestRail.APIException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.map;

public class MapSteps {

    @When("navigate to {string} page")
    public void navigateToPage(String role) throws IOException, InterruptedException, APIException {
        map.navigateToPage(role);
    }

//    @Then("verify site name is displayed and update Excel with tme taken sheet for {string} user")
//    public void verifySiteNameIsDisplayedAndUpdateExcelWithTmeTakenSheetForUser(String role) throws IOException, APIException, InterruptedException {
//        map.captureMapLoadTime(role);
//    }

    @Then("verify site name is displayed and also verify switching measurements is working for {string} user")
    public void verifySiteNameIsDisplayedAndAlsoVerifySwitchingMeasurementsIsWorkingForUser(String role) throws InterruptedException, IOException {
        map.verifySwitchingMeasurement(role);
    }

    @Then("verify site name is displayed and also verify unassigned devices for {string} user")
    public void verifySiteNameIsDisplayedAndAlsoVerifyUnassignedDevicesForUser(String role) throws InterruptedException {
        map.verifyUnassignedAssignedPage(role);
    }

    @Then("verify site name is displayed and also verify minimize and more info in legend of map is working for {string} user")
    public void verifySiteNameIsDisplayedAndAlsoVerifyMinimizeAndMoreInfoInLegendOfMapIsWorkingForUser(String role) throws InterruptedException {
        map.verifyMinimizeAndMoreInfo(role);
    }

    @Then("verify site name is displayed and also verify tomorrow forecast tab details for {string} user")
    public void verifySiteNameIsDisplayedAndAlsoVerifyTomorrowForecastTabDetailsForUser(String role) throws InterruptedException {
        map.verifyForecastTab(role);
    }

    @Then("verify default Satellite view for {string} user")
    public void verifyDefaultSatelliteViewForUser(String role) throws InterruptedException {
        map.verifyDefaultView(role);
    }

    @Then("verify toggle buttons for different view on map for {string} user")
    public void verifyToggleButtonsForDifferentViewOnMapForUser(String role) throws InterruptedException {
        map.verifyToggleButtons(role);
    }

    @Then("verify switching toggle button from default to Map view for {string} user")
    public void verifySwitchingToggleButtonFromDefaultToMapViewForUser(String role) throws InterruptedException {
        map.verifySwitchingSatelliteToMapView(role);
    }

    @Then("verify switching to Map view and check terrain view for {string} user")
    public void verifySwitchingToMapViewAndCheckTerrainViewForUser(String role) throws InterruptedException {
        map.verifyTerrainViewCheckbox(role);
    }

    @Then("verify Satellite Labels view for {string} user")
    public void verifySatelliteLabelsViewForUser(String role) throws InterruptedException {
        map.verifyLabelViewCheckbox(role);
    }

    @Then("switch to Map view and verify it after switching pages  for {string} user")
    public void switchToMapViewAndVerifyItAfterSwitchingPagesForUser(String role) throws InterruptedException {
        map.verifyViewOnSwitchingPages(role);
    }

    @Then("switch to Map view and select terrain and verify it again after switching pages  for {string} user")
    public void switchToMapViewAndSelectTerrainAndVerifyItAgainAfterSwitchingPagesForUser(String role) throws InterruptedException {
        map.verifyTerrainViewOnSwitchingPages(role);
    }

    @Then("select terrain and verify it again after switching pages  for {string} user")
    public void selectTerrainAndVerifyItAgainAfterSwitchingPagesForUser(String role) throws InterruptedException {
        map.verifyLabelsViewOnSwitchingPages(role);
    }

    @Then("click on Unassigned devices and verify warning text in create site modal for {string} user")
    public void clickOnUnassignedDevicesAndVerifyWarningTextInCreateSiteModalForUser(String role) throws InterruptedException {
        map.verifyWarningText(role);
    }

    @Then("click on Unassigned devices and verify Clear Boundary button in create site modal for {string} user")
    public void clickOnUnassignedDevicesAndVerifyClearBoundaryButtonInCreateSiteModalForUser(String role) throws InterruptedException {
        map.verifyClearBoundaryBtn(role);
    }

    @Then("click on Unassigned devices and click on Clear Boundary button and verify saving site for {string} user")
    public void clickOnUnassignedDevicesAndClickOnClearBoundaryButtonAndVerifySavingSiteForUser(String role) throws InterruptedException {
        map.verifySavingSiteWithoutBoundary(role);
    }

    @And("changing the Temperature dropdown to Wind, the same unit should reflect in the legend")
    public void changingTheTemperatureDropdownToWindTheSameUnitShouldReflectInTheLegend() {
        map.changingTheTemperatureDropdownToWind();
    }

    @And("changing the Temperature dropdown to Daily ETc, the same unit should reflect in the legend")
    public void changingTheTemperatureDropdownToDailyETcTheSameUnitShouldReflectInTheLegend() throws InterruptedException {
        map.changingTheTemperatureDropdownToDailyETc();
    }

    @And("verify that on Map page, for Temperature dropdown, the same unit should reflect in the legend")
    public void verifyThatOnMapPageForTemperatureDropdownTheSameUnitShouldReflectInTheLegend() {
        map.verifyTheUnitInTemp();
    }

    @And("verify the measurement data for tair, sun & precip should match with the data shown on UI for each sites for Temperature, rain & Sun")
    public void verifyTheMeasurementDataForTairSunPrecipShouldMatchWithTheDataShownOnUIForEachSitesForTemperatureRainSun() {
        map.verifyTheMeasurementDataInBothUIAndAPI();
    }

    @Then("verify the sites name also in sequence as per the api response")
    public void verifyTheSitesNameAlsoInSequenceAsPerTheApiResponse() {
        map.verifyTheSitesAreInSequenceInBothAPIAndUI();
    }

}
