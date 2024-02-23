package stepDefinitions.MultiSite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.map;
import static support.World.waterMultiSite;

public class MultiSite_water {
    @When("navigate to multiSite {string} page")
    public void navigateToMultiSitePage(String option) {
        waterMultiSite.navigateToMultiSiteWaterPage(option);
    }

    @Then("verify all the data present in the columns is matching with the growing season API call")
    public void verifyAllTheDataPresentInTheColumnsIsMatchingWithTheGrowingSeasonAPICall() {
        waterMultiSite.verifyTheDataInUIAndApiAccordingToThePage();
    }

    @Then("navigate to particular tab and click on sort option for each column like site name, Last irrigation runtime and heat stress hours")
    public void navigateToParticularTabAndClickOnSortOptionForEachColumnLikeSiteNameLastIrrigationRuntimeAndHeatStressHours() {
        waterMultiSite.verifyOnClickTheDataIsSortingInAscendingAndDescendingOrder();
    }

    @Then("observe site table header sorting button")
    public void observeSiteTableHeaderSortingButton() {
        waterMultiSite.verifySiteHeaderSortButton();
    }

    @Then("verify the Last Irrigation runtime data is in {string} & {string} format")
    public void verifyTheLastIrrigationRuntimeDataIsInFormat(String arg0, String arg1) {
        waterMultiSite.verifyTheLastIrrigationRuntimeDataIsInFormat();
    }

    @Then("verify if an org or team does not have the sites, an information message should appear in the site table chart as well as the individual tab")
    public void verifyIfAnOrgOrTeamDoesNotHaveTheSitesAnInformationMessageShouldAppearInTheSiteTableChartAsWellAsTheIndividualTab() {
        waterMultiSite.verifyTheMessageInSiteTableAndIndividualTabIfTheOrgOrTeamDoesNotHaveAnySites();
    }

    @Then("hard refresh the browser and observe")
    public void hardRefreshTheBrowserAndObserve() {
        waterMultiSite.observeAndVerifyWhenTheBrowserIsHardRefreshed();
    }

    @And("add gdd for a site")
    public void addGddForASite() {
        waterMultiSite.pickTheSiteWhichAsCurrentGrowthStage();
    }

    @Then("observe newly added season or gdd for site is present in the list of table view")
    public void observeNewlyAddedSeasonOrGddForSiteIsPresentInTheListOfTableView() {
        waterMultiSite.verifyAndObserveNewlyAddedSeasonSiteIsPresentInListOfTableView();
    }

    @Then("verify the current page and the data present in the columns is matching with the growing season API call")
    public void verifyTheCurrentPageAndTheDataPresentInTheColumnsIsMatchingWithTheGrowingSeasonAPICall() {
        waterMultiSite.verifyTheCurrentPageAndValidateTheValuesWithTheAPI();
    }

    @Then("observe the proximity value in the table view")
    public void observeTheProximityValueInTheTableView() {
        waterMultiSite.verifyAndObserverProximityValueInTheTableView();
    }

    @Then("observe sorting button for heat stress hours & last irrigation runtime in the table view")
    public void observeSortingButtonForHeatStressHoursLastIrrigationRuntimeInTheTableView() {
        waterMultiSite.verifyAndObserveHeatStressHoursLastIrrigationRuntimeInTableView();
    }

    @Then("refresh the browser and observe the table view")
    public void refreshTheBrowserAndObserveTheTableView() {
        waterMultiSite.verifyAndObserveTableViewAfterBrowserRefresh();
    }

    @Then("on Water balance tab, hover over the locators on map & observe")
    public void onWaterBalanceTabHoverOverTheLocatorsOnMapObserve() {
        waterMultiSite.verifyTheLocatorSiteNameIsDisplayedInTheSitesList();
    }

    @Then("click on the status bar & benchmark graph title & verify modal info & it's text")
    public void clickOnTheStatusBarBenchmarkGraphTitleVerifyModalInfoItSText() {
        waterMultiSite.verifyModalInfoForWaterBalanceTabInStatusBarAndBenchmarkGraph();
    }

    @Then("click on {string} tab, observe & compare the data present on Proximity to Refill Threshold is matching with the data shown on right side on status bar & benchmark graphs")
    public void clickOnTabObserveCompareTheDataPresentOnProximityToRefillThresholdIsMatchingWithTheDataShownOnRightSideOnStatusBarBenchmarkGraphs(String arg0) {
        waterMultiSite.verifyAndObserveTheDataIsMatchingWithTheDataShownOnRightSideForSoilMoisture();
    }

    @Then("click on {string} tab and on the right side on the benchmark graph section, click on sorting icon & observe")
    public void clickOnTabAndOnTheRightSideOnTheBenchmarkGraphSectionClickOnSortingIconObserve(String arg0) {
        waterMultiSite.verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForSoilMoisture();
    }

    @And("click on Soil Moisture tab, on the right side on the benchmark graph section, hover over any bar & observe the tooltip")
    public void clickOnSoilMoistureTabOnTheRightSideOnTheBenchmarkGraphSectionHoverOverAnyBarObserveTheTooltip() {
        waterMultiSite.verifyTheUnitAndValueOnTheToolTipInBenchmarkGraphSectionWhenHoverOverOnTheSites();
    }

    @Then("now, check the unit shown for {string} in Site list table on left")
    public void nowCheckTheUnitShownForInSiteListTableOnLeft(String arg0) {
        waterMultiSite.verifyTheUnitAndValueOnTheProximityToRefillThresholdColumn();
    }

    @Then("click on {int}dots of any sites\\(pick site that don't have device) and observe the site details")
    public void clickOnDotsOfAnySitesPickSiteThatDonTHaveDeviceAndObserveTheSiteDetails(int arg0) {
        waterMultiSite.verifyAndObserveAfterClickingOn3DotsInSites();
    }

    @Then("observe & compare the data present on {string} is matching with the data shown on right side on {string} & {string} of Water Balance tab")
    public void observeCompareTheDataPresentOnIsMatchingWithTheDataShownOnRightSideOnOfWaterBalanceTab(String arg0, String arg1, String arg2) {
        waterMultiSite.observeAndCompareTheDataPresentInBothSideForWaterBalanceTab();
    }

    @Then("verify the highlighted site details when hover over the locators on map & click & observe")
    public void verifyTheHighlightedSiteDetailsWhenHoverOverTheLocatorsOnMapClickObserve() {
        waterMultiSite.verifyTheHighlightedSiteDetailsWhenHoverOverTheLocatorsOnMapClickObserveForReplaceETC();
    }

    @Then("click on {string} tab and hover over on the locators on map & click on anyone of it & observe")
    public void clickOnTabAndHoverOverOnTheLocatorsOnMapClickOnAnyoneOfItObserve(String arg0) {
        waterMultiSite.verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInHeatStressTab();
    }

    @Then("click on {string} tab and on benchmark graph of Heat Stress Hours, click on sorting icon & observe")
    public void clickOnTabAndOnBenchmarkGraphOfHeatStressHoursClickOnSortingIconObserve(String arg0) {
        waterMultiSite.verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForHeatStress();
    }

    @Then("verify the {string} info model texts should match to the specified mockup")
    public void verifyTheHoursOfHeatStressInfoModelTextsShouldMatchToTheSpecifiedMockup(String arg0) {
        waterMultiSite.verifyTheInfoModelTextInHeatStressHours();
    }

    @Then("observe & compare the data present on {string} is matching with the data shown on right side on status bar & benchmark graphs of Irrigation tab")
    public void observeCompareTheDataPresentOnIsMatchingWithTheDataShownOnRightSideOnStatusBarBenchmarkGraphsOfIrrigationTab(String arg0) {
        waterMultiSite.verifyAndObserveTheDataIsMatchingWithTheDataShownOnRightSideForIrrigation();
    }

    @Then("click on Irrigation tab and hover over on the locators on map & click on anyone of it & observe")
    public void clickOnIrrigationTabAndHoverOverOnTheLocatorsOnMapClickOnAnyoneOfItObserve() {
        waterMultiSite.verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInIrrigationTab();
    }

    @Then("Verify the format for data in Last Irrigation Runtime column & in Irrigation Runtime Hours in benchmark graph")
    public void verifyTheFormatForDataInLastIrrigationRuntimeColumnInIrrigationRuntimeHoursInBenchmarkGraph() {
        waterMultiSite.verifyFormatOfDataInLastIrrigationRuntimeColumnAndBenchmarkGraph();
    }

    @Then("click on {string} tab and on benchmark graph of Irrigation Runtime Hours, click on sorting icon & observe")
    public void clickOnTabAndOnBenchmarkGraphOfIrrigationRuntimeHoursClickOnSortingIconObserve(String arg0) {
        waterMultiSite.verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForLastIrrigation();
    }

    @Then("click on soil moisture tab and hover over on the locators on map & click on anyone of it & observe")
    public void clickOnSoilMoistureTabAndHoverOverOnTheLocatorsOnMapClickOnAnyoneOfItObserve() {
        waterMultiSite.verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInSoilMoistureTab();
    }

    @And("verify water tab should be present")
    public void verifyWaterTabShouldBePresent() {
        waterMultiSite.verifyWaterTabIsPresentWhenHooverOnAnalysis();
    }

    @Then("verify sub module is present when Hoover on Analysis")
    public void verifySubModuleIsPresentWhenHooverOnAnalysis() throws IOException, InterruptedException {
        waterMultiSite.verifySubModuleIsPresentWhenHooverOnAnalysis();
    }

    @When("click on any site in the multisite water page")
    public void clickOnAnySiteInTheMultisiteWaterPage() {
        waterMultiSite.verifyUserShouldClickOnOneSite();
    }

    @And("verify User should be able to view single site water page")
    public void verifyUserShouldBeAbleToViewSingleSiteWaterPage() {
        waterMultiSite.verifyUserShouldViewSingleSiteWaterPage();
    }

    @Then("verify weather pagination is clickable or not")
    public void verifyWeatherPaginationIsClickableOrNot() {
        waterMultiSite.verifyThePaginationIsClickable();
    }

    @And("verify the {int} sites are present per pagination")
    public void verifyTheSitesArePresentPerPagination(int numbOfSites) {
        waterMultiSite.verifyTheSitesArePresentPerPagination(numbOfSites);
    }

    @And("verify site name,Irrigation to replace to ETc, Proximity to Refill threshold, Last Irrigation Runtime, Heat Stress Hours' from the left side of the water page")
    public void verifySiteNameIrrigationToReplaceToETcProximityToRefillThresholdLastIrrigationRuntimeHeatStressHoursFromTheLeftSideOfTheWaterPage() {
        waterMultiSite.verifyTheTagNameLeftSideOfTheWaterPage();
    }

    @Then("verify weather all measurements are clickable")
    public void verifyWeatherAllMeasurementsAreClickable() {
        waterMultiSite.verifyTheTagNameLeftSideOfTheWaterPageAreAllClickable();
    }

    @And("verify the presence of Validate Sensor and Manual Irrigation after click on the three dots on any site")
    public void verifyThePresenceOfValidateSensorAndManualIrrigationAfterClickOnTheThreeDotsOnAnySite() {
        waterMultiSite.verifyTheMenuAfterClickingOnThreeDotsOnSite();
    }

    @Then("verify the Validate Sensor symbol color should be in orange")
    public void verifyTheValidateSensorSymbolColorShouldBeInOrange() {
        waterMultiSite.verifyTheColorVerificationForTheValidateSensor();
    }

    @And("click on validate sensor")
    public void clickOnValidateSensor() {
        waterMultiSite.clickOnValidateSensor();
    }

    @And("verify the Done With Validation button in the background color")
    public void verifyTheDoneWithValidationButtonInTheBackgroundColor() {
        waterMultiSite.verifyTheBackgroundColorForDoneWithValidationButton();
    }

    @Then("verify user can minimize the site details by clicking on Done with validation button")
    public void verifyUserCanMinimizeTheSiteDetailsByClickingOnDoneWithValidationButton() {
        waterMultiSite.verifyUserCanMinimizeTheSiteDetails();
    }

    @And("verify the scrollbar is present and working")
    public void verifyTheScrollbarIsPresentAndWorking() {
        waterMultiSite.verifyTheScrollbarIsPresentAndWorking();
    }

    @And("verify that the user should be able to view the device ID and store that ID")
    public void verifyThatTheUserShouldBeAbleToViewTheDeviceIDAndStoreThatID() {
        waterMultiSite.verifyTheDeviceIDAndStoreThatID();

    }

    @And("verify that the validate sensor options for the same device are displayed")
    public void verifyThatTheValidateSensorOptionsForTheSameDeviceAreDisplayed() {
        waterMultiSite.verifyTheValidateSensorInDevicePage();
    }

    @And("Change Water Balance measurements via toggle")
    public void changeWaterBalanceMeasurementsViaToggle() {
        waterMultiSite.changeWaterBalanceMeasurementsViaToggle();
    }
    @And("observe the tags at different intervals below the map")
    public void observeTheTagsAtDifferentIntervalsBelowTheMap() {
        waterMultiSite.observeTheTagsAtDifferentIntervalsBelowTheMap();
    }

    @And("navigate to the page where site have value")
    public void navigateToThePageWhereSiteHaveValue() {
        waterMultiSite.navigateToThePageWhereSiteHaveValue();
    }

    @And("click on the Soil Moisture")
    public void clickOnTheSoilMoisture() {
        waterMultiSite.clickOnTheSoilMoisture();
    }

    @And("navigate to the page where the soilMoisture interval icon is present")
    public void navigateToThePageWhereTheSoilMoistureIntervalIconIsPresent() {
        waterMultiSite.verifyTheSoilMoistureIntervalIcon();
    }

    @And("click on the irrigation")
    public void clickOnTheIrrigation() {
        waterMultiSite.clickOnTheIrrigation();
    }

    @And("navigate to the page where the irrigation interval icon is present")
    public void navigateToThePageWhereTheIrrigationIntervalIconIsPresent() {
        waterMultiSite.verifyTheIrrigationIntervalIcon();
    }

    @And("verify Device Id, Battery Status, Connected sensor column is present")
    public void verifyDeviceIdBatteryStatusConnectedSensorColumnIsPresent() {
        waterMultiSite.verifyTheIconInValidateSensor();
    }

    @And("verify that the user can clickable on three dots button on individual device")
    public void verifyThatTheUserCanClickableOnThreeDotsButtonOnIndividualDevice() {
        waterMultiSite.verifyTheClickableOnThreeDotsButtonOnIndividualDevice();
    }

    @And("verify validate sensor model is appear, when click on the validate senor")
    public void verifyValidateSensorModelIsAppearWhenClickOnTheValidateSenor() throws InterruptedException {
        waterMultiSite.verifyTheThreeSensorThenClickOnTheValidateSenor();
    }

    @And("verify the tag in the Set Up Connected Sensors")
    public void verifyTheTagInTheSetUpConnectedSensors() {
        waterMultiSite.verifyTheTagInTheSetUpConnectedSensors();
    }

    @And("verify that the color for the water balance")
    public void verifyThatTheColorForTheWaterBalance() {
        waterMultiSite.verifyTheColorForTheWaterBalance();
    }

    @And("verify that the color for the soil moisture")
    public void verifyThatTheColorForTheSoilMoisture() throws InterruptedException {
        waterMultiSite.clickOnTheSoilMoisture();
        waterMultiSite.verifyTheColorForTheSoilMoisture();
    }

    @And("verify that the color for the heat stress")
    public void verifyThatTheColorForTheHeatStress() throws InterruptedException {
        waterMultiSite.clickOnTheHeatStress();
        waterMultiSite.verifyTheColorForTheHeatStress();
    }

    @And("verify that the color for the irrigation")
    public void verifyThatTheColorForTheIrrigation() throws InterruptedException {
        waterMultiSite.clickOnTheIrrigation();
        waterMultiSite.verifyTheColorForTheIrrigation();
    }

    @And("verify the last Irrigation runtime column with api")
    public void verifyTheLastIrrigationRuntimeColumnWithApi(){
        waterMultiSite.verifyTheLastIrrigationRuntimeColumnWithApi();
    }

    @And("close the welcome popup for user {string} role")
    public void closeTheWelcomePopupForUserRole(String userRole) throws IOException, InterruptedException {
        map.navigateToPage(userRole);
    }

    @Then("observe {string} from the table view")
    public void observeIrrigationToReplaceETcFromTheTableView(String arg0) {
        waterMultiSite.verifyIrrigationToReplaceETcValueFromTable();
    }

}


