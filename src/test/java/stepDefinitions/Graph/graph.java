package stepDefinitions.Graph;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.text.ParseException;

import static support.PropertiesReader.orgTargeted;
import static support.World.*;

public class graph {
    @When("navigate to page {string} and verify site names are displayed for {string} user")
    public void navigateToPageAndVerifySiteNamesAreDisplayedForUser(String page, String role) throws IOException, InterruptedException {
        graphPage.navigateToPage(page);
    }

//    @Then("update page load time in Excel sheet for {string} user")
//    public void updatePageLoadTimeInExcelSheetForUser(String role) throws IOException, InterruptedException {
//        graphPage.captureGraphPageLoadTime(role);
//    }
//
//    @Then("select details and click on Graph Button and verify it with different {string}.")
//    public void selectDetailsAndClickOnGraphButtonAndVerifyItWithDifferent(String role) throws InterruptedException, IOException {
//        graphPage.captureGraphPageDailyLoadTime(role);
//    }

    @When("navigate to {string} page select details and click on Graph Button")
    public void navigateToPageSelectDetailsAndClickOnGraphButton(String page) throws IOException, InterruptedException {
        graphPage.navigateToPage(page);
    }

//    @Then("switch to hourly and verify it with different {string}.")
//    public void switchToHourlyAndVerifyItWithDifferent(String role) throws InterruptedException, IOException {
//        graphPage.captureGraphPageHourlyLoadTime(role);
//    }

    @Then("select details and click on Graph Button and then download csv and pdf for different {string}.")
    public void selectDetailsAndClickOnGraphButtonAndThenDownloadCsvAndPdfForDifferent(String role) throws InterruptedException, IOException {
        graphPage.captureGraphPageDailyCSV_PDFDownload(role);
    }

    @Then("switch to hourly and download csv and pdf for different {string}.")
    public void switchToHourlyAndDownloadCsvAndPdfForDifferent(String role) throws InterruptedException, IOException {
        graphPage.captureGraphPageHourlyCSV_PDFDownloadLoadTime(role);
    }

    @Then("select details and click on Graph Button and then download csv and pdf for all timestamp for different {string}.")
    public void selectDetailsAndClickOnGraphButtonAndThenDownloadCsvAndPdfForAllTimestampForDifferent(String role) throws InterruptedException, IOException {
        graphPage.captureGraphPageDailyCSV_PDFDownload_AllTimeline(role);
    }

    @Then("switch to hourly and download csv and pdf for all timestamp for different {string}.")
    public void switchToHourlyAndDownloadCsvAndPdfForAllTimestampForDifferent(String role) throws InterruptedException, IOException {
        graphPage.captureGraphPageHourlyCSV_PDFDownloadAllTimeline(role);
    }

    @And("get token, userID, units for {string} user and then get orgID")
    public void getTokenUserIDUnitsForUserAndThenGetOrgID(String role) {
        teamsApiHelper.getAuthToken();
        sitesApiHelper.getUserMeasurementUnits();
        teamsApiHelper.getOrgId(orgTargeted);
    }

    @And("select measurement as max & min temp")
    public void selectMeasurementAsMaxMinTemp() {
        graphPage.selectMeasurementAsMaxMinTemp();
    }

    @And("select predefined Date in timeline and click on Graph button")
    public void selectPredefinedDateInTimelineAndClickOnGraphButton() {
        graphPage.selectAnyOptionInTimelineAndClickOnGraph();
    }

    @Then("verify the selected pre-defined days is highlighted in the graph page")
    public void verifyTheSelectedPreDefinedDaysIsHighlightedInTheGraphPage() {
        graphPage.verifyTheSelectedPredefinedDaysIsHighlighted();
    }

    @And("the timeline series will have the selected dates displayed when hovered over")
    public void theTimelineSeriesWillHaveTheSelectedDatesDisplayedWhenHoveredOver() {
        graphPage.verifyWhetherTimelineSeriesWillHaveSelectedDates();
    }

    @Then("verify whether the table is displayed for {string} sites with selected measurement, site names, Generated date and number of records")
    public void verifyWhetherTheTableIsDisplayedForSitesWithSelectedMeasurementSiteNameGeneratedDateAndNumberOfRecords(String numberOfSites) {
        graphPage.verifyTheDataInTheTableForSitesAndMeasurement(Integer.parseInt(numberOfSites));
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for max & min temp measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForMaxMinTempMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForMaxMinTempMeasurement();
    }

    @Then("verify the values in the API response should match with respect to the integer value in table for multiple columns, for the {string} site selected")
    public void verifyTheValuesInTheAPIResponseShouldMatchWithRespectToTheIntegerValueInTableForMultipleColumnsForTheSiteSelected(String numberOfSites) {
        graphPage.verifyApiResponseOfIntegerValueForAllThreeColumn(Integer.parseInt(numberOfSites));
    }

    @Then("select a {string} site for {string} user")
    public void selectASiteForUser(String numberOfSites, String userRole) {
        graphPage.selectASiteForUserRole(Integer.parseInt(numberOfSites), userRole);
    }

    @And("select measurement as {string}")
    public void selectMeasurementAs(String measurement) {
        graphPage.selectAMeasurement(measurement);
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for chloroIndex measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForChloroIndexMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForChloroIndexMeasurement();
    }

    @Then("verify the values in the API response should match with respect to the double value in table, for the {string} sites selected")
    public void verifyTheValuesInTheAPIResponseShouldMatchWithRespectToTheDoubleValueInTableForTheSitesSelected(String numberOfSites) {
        graphPage.verifyApiResponseOfDoubleValueFromUITableForSitesSelected(Integer.parseInt(numberOfSites));
    }

    @And("by default {string} timeline button will be selected")
    public void byDefaultTimelineButtonWillBeSelected(String arg0) {
        graphPage.verifyTheTimelineBtn();
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for daily etc measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForDailyEtcMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForDailyEtcMeasurement();
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for leaf wetness measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForLeafWetnessMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForLeafWetnessMeasurement();
    }

    @Then("verify the values in the API response should match with respect to the integer value in table, for the {string} sites selected")
    public void verifyTheValuesInTheAPIResponseShouldMatchWithRespectToTheIntegerValueInTableForTheSitesSelected(String numberOfSites) {
        graphPage.verifyApiResponseOfIntegerValueFromUITableForSitesSelected(Integer.parseInt(numberOfSites));
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for ndvi measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForNdviMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForNdviMeasurement();
    }

    @Then("switch to daily and verify it with {string} sites")
    public void switchToDailyAndVerifyItWithSites(String numberOfSites) {
        graphPage.verifyWithSitesDaily(Integer.parseInt(numberOfSites));
    }

    @Then("switch to hourly and verify it with {string} sites")
    public void switchToHourlyAndVerifyItWithSites(String numberOfSites) {
        graphPage.verifyWithSitesHourly(Integer.parseInt(numberOfSites));
    }

    @And("verify the toast message on downloading the graph for csv and pdf format")
    public void verifyTheToastMessageOnDownloadingTheGraphForCsvAndPdfFormat() {
        graphPage.verifyExportToastMessage();
    }

    @Then("verify and enter the details on the page. Select the {string} site, measurement as {string}, and date as {string} for the role {string}")
    public void verifyAndEnterTheDetailsOnThePageSelectTheSiteMeasurementAsAndDateAsForTheRole(String numberOfSites, String measurement, String date, String userRole) {
        graphPage.verifyGraphWithSelectedDetails(Integer.parseInt(numberOfSites), measurement, date, userRole);
    }

    @And("verify once the the hours is selected then verify the selected pre-defined days is highlighted in the graph page")
    public void verifyOnceTheTheHoursIsSelectedThenVerifyTheSelectedPreDefinedDaysIsHighlightedInTheGraphPage() {
        graphPage.verifyCustomDateForHourly();
    }

    @And("verify that the graph will be displayed for the pre-defined days and select date as {string}")
    public void verifyThatTheGraphWillBeDisplayedForThePreDefinedDaysSelected(String days) {
        graphPage.verifyingSelectedDaysDisplayed(days);
    }

    @And("the timeline series will have the selected dates displayed when hovered over for hourly")
    public void theTimelineSeriesWillHaveTheSelectedDatesDisplayedWhenHoveredOverForHourly() {
        graphPage.verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourly();
    }

    @And("verify that the table will be displayed with the selected measurement, site, generated date, and number of records")
    public void verifyThatTheTableWillBeDisplayedWithTheSelectedMeasurementSiteGeneratedDateAndNumberOfRecords() {
        graphPage.verifyTheTableTagName();
    }

    @And("verify the units displayed in the account page are the same in the table and load more option is displayed for hourly")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableAndLoadMoreOptionIsDisplayedForHourly() {
        graphPage.verifyUnitsInGraphForHourly();
    }

    @And("verifying the api count for swdw with UI in hourly view")
    public void verifyingTheApiCountForSwdwWithUIInHourlyView() {
        graphPage.verifySwdwCountInApiForMultipleSitesForGraph();
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for precipitation measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForPrecipitationMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForPrecipitationMeasurement();
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for relative humidity measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForRelativeHumidityMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForRelativeHumidityMeasurement();
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for vapor pressure deficit measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForVaporPressureDeficitMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForVaporPressureDeficitMeasurement();
    }

    @Then("verify the values in the API response should match with respect to the integer & double value in table, for the {string} sites selected")
    public void verifyTheValuesInTheAPIResponseShouldMatchWithRespectToTheIntegerDoubleValueInTableForTheSitesSelected(String numberOfSites) {
        graphPage.verifyAPiResponseForVPDFromUITable(Integer.parseInt(numberOfSites));
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for wind measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForWindMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForWindMeasurement();
    }

    @Then("select a {string} site and measurement as soil moisture")
    public void selectASiteAndMeasurementAsSoilMoisture(String numberOfSites) {
        graphPage.selectSingleSiteAndMeasurementAsSoilMoisture(Integer.parseInt(numberOfSites));
    }

    @And("select predefined Date in timeline and click on Graph button & verify chart graph is displayed or not")
    public void selectPredefinedDateInTimelineAndClickOnGraphButtonVerifyChartGraphIsDisplayedOrNot() {
        graphPage.selectAnyOptionInTimelineAndClickOnGraphAndVerify();
    }

    @And("the timeline series will have the selected dates displayed when hovered over for soil moisture measure")
    public void theTimelineSeriesWillHaveTheSelectedDatesDisplayedWhenHoveredOverForSoilMoistureMeasure() {
        graphPage.verifyWhetherTimelineSeriesWillHaveSelectedDatesForSoilMoistureMeasure();
    }

    @Then("verify whether the table is displayed for {string} sites and measurement as soil moisture, site names, Generated date and number of records")
    public void verifyWhetherTheTableIsDisplayedForSitesAndMeasurementAsSoilMoistureSiteNamesGeneratedDateAndNumberOfRecords(String numberOfSites) {
        graphPage.verifyTheDataInTheTableForSitesAndMeasurementAsSoilMoisture(Integer.parseInt(numberOfSites));
    }

    @And("verify whether the table have columns of selected measurement with units and the load more option at the end for soil moisture measurement")
    public void verifyWhetherTheTableHaveColumnsOfSelectedMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForSoilMoistureMeasurement() {
        graphPage.verifyWhetherTheColumnAsSelectedMeasurementWithUnitsAndLoadMoreOptionInEndForSoilMoistureMeasurement();
    }

    @And("verify the table for {string} sites & measurements selected with units and the load more option at the end for max & min temp measurement")
    public void verifyTheTableForSitesMeasurementsSelectedWithUnitsAndTheLoadMoreOptionAtTheEndForMaxMinTempMeasurement(String arg0) {
        graphPage.verifyTheTableForSitesMeasurementsSelectedAndTheLoadMoreOptionForMaxMinTempMeasurement();
    }

    @Then("verify the values in the API response should match with respect to the integer value in table for multiple sites & measurements selected")
    public void verifyTheValuesInTheAPIResponseShouldMatchWithRespectToTheIntegerValueInTableForMultipleSitesMeasurementsSelected() {
        graphPage.verifyApiResponseForMultipleSitesAndMeasurements();
    }

    @Then("verify whether the errorMessage displayed if we selecting more than {int} sites for {string}")
    public void verifyWhetherTheErrorMessageDisplayedIfWeSelectingMoreThanSitesFor(int arg1, String userRole) {
        graphPage.verifyErrorMessageAfterSelectingMoreThanTenSites(userRole);
    }

    @Then("verify whether the errorMessage displayed after selecting more than {int} measurements")
    public void verifyWhetherTheErrorMessageDisplayedAfterSelectingMoreThanMeasurements(int arg1) {
        graphPage.verifyErrorMessageAfterSelectingMoreThanTwoMeasure();
    }

    @And("select {int} sites and verify the selected sites tags are displayed on graph page")
    public void selectSitesAndVerifyTheSelectedSitesTagsAreDisplayedOnGraphPage(int arg0) {
        graphPage.selectSitesAndVerifyTheSitesTagIsDisplayedInGraphPage();
    }

    @And("select {int} measurements maxTemp & minTemp and verify the selected measurements is displayed on the menu")
    public void selectMeasurementsMaxTempMinTempAndVerifyTheSelectedMeasurementsIsDisplayedOnTheMenu(int arg0) {
        graphPage.selectMeasureAndVerifySelectedMeasureIsDisplayedOnMenu();
    }

    @Then("verify that the {string} button should not highlight before selecting the preferred date from calendar")
    public void verifyThatTheButtonShouldNotHighlightBeforeSelectingThePreferredDateFromCalendar(String arg0) {
        graphPage.verifyGraphBtnShouldNotHighlightBeforeSelectingCalendarDate();
    }

    @Then("verify whether the Daily and Historical API calls are displayed on the network tab")
    public void verifyWhetherTheDailyAndHistoricalAPICallsAreDisplayedOnTheNetworkTab() {
        graphPage.verifyTheAPiIsDisplayedInTheNetworkTab();
    }

    @And("verify the table for selected {string} sites as measurement with units {string} and the load more option at the end for {string} measurement")
    public void verifyTheTableForSelectedSitesAsMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForMeasurement(String arg0, String units, String measurement) {
        graphPage.verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForMeasurement(units, measurement);
    }

    @And("verify the table for selected {string} sites as measurement with units & the load more option at the end for {string} measurement")
    public void verifyTheTableForSelectedSitesAsMeasurementWithUnitsTheLoadMoreOptionAtTheEndForMeasurement(String arg0, String measurement) {
        graphPage.verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForDailyEtcMeasurement(measurement);
    }

    @And("verify the table for selected {string} sites as measurement with units and the load more option at the end for {string} measurement")
    public void verifyTheTableForSelectedSitesAsMeasurementWithUnitsAndTheLoadMoreOptionAtTheEndForMeasurement(String arg0, String measurement) {
        graphPage.verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForVapourPressureMeasurement(measurement);
    }

    @And("verify the table for selected {string} sites as measurements with units and the load more option at the end for {string} measurement")
    public void verifyTheTableForSelectedSitesAsMeasurementsWithUnitsAndTheLoadMoreOptionAtTheEndForMeasurement(String arg0, String measurement) {
        graphPage.verifyTheTableForSelectedSitesAsMeasuresUnitsAndTheLoadMoreOptionForWindMeasurement(measurement);
    }

    @Then("verify the values in the API response should match with respect to the integer value in table, for the sites selected")
    public void verifyTheValuesInTheAPIResponseShouldMatchWithRespectToTheIntegerValueInTableForTheSitesSelected() {
        graphPage.verifyApiResponseForMultipleSitesAndMeasurementsAsWind();
    }

    @And("verify once the the daily is selected then verify the selected pre-defined days is highlighted in the graph page")
    public void verifyOnceTheTheDailyIsSelectedThenVerifyTheSelectedPreDefinedDaysIsHighlightedInTheGraphPage() {
        graphPage.verifyCustomDateForDaily();
    }

    @And("verify the units displayed in the account page are the same in the table and load more option is displayed for Soil Temperature")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableAndLoadMoreOptionIsDisplayedForSoilTemperature() {
        graphPage.verifyUnitsInGraphForSoilTemp();
    }

    @And("verify the units displayed in the account page are the same in the table and load more option is displayed for daily")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableAndLoadMoreOptionIsDisplayedForDaily() {
        graphPage.verifyUnitsInGraphForSolarRadiation();
    }

    @Then("verifying the api count for swdw with UI")
    public void verifyingTheApiCountForSwdwWithUI() {
        graphPage.verifySwdwCountInApiForMultipleSites();
    }

    @And("verify once the {string} is selected then verify the selected pre-defined days is highlighted in the graph page")
    public void verifyOnceTheTheHoursIsSelectedThenVerifyTheSelectedPreDefinedDaysIsHighlightedInTheGraphPage(String timeLineText) {
        graphPage.verifyCustomDateForHourly(timeLineText);
    }

    @And("the timeline series will have the selected dates displayed when hovered over for hourly for Solar Radiation")
    public void theTimelineSeriesWillHaveTheSelectedDatesDisplayedWhenHoveredOverForHourlyForSolarRadiation() {
        graphPage.verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourlyForSolarRad();
    }

    @And("the timeline series will have the selected dates displayed when hovered over for Soil Moisture measurement")
    public void theTimelineSeriesWillHaveTheSelectedDatesDisplayedWhenHoveredOverForSoilMoistureMeasurement() {
        graphPage.verifyWhetherTimelineSeriesWillHaveSelectedDatesForSoilTemp();
    }

    @And("verify the units displayed in the account page are the same in the table and load more option is displayed for Soil Moisture")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableAndLoadMoreOptionIsDisplayedForSoilMoisture() {
        graphPage.verifyUnitsInGraphForHourlyForSoilTemp();
    }

    @Then("verifying the api count for soil Moisture value with UI average for Hourly")
    public void verifyingTheApiCountForSoilMoistureValueWithUIAverageForHourly() {
        graphPage.verifySoilMoistureHourly();
    }

    @And("the timeline series will have the selected dates displayed when hovered over for Soil Temperature measurement")
    public void theTimelineSeriesWillHaveTheSelectedDatesDisplayedWhenHoveredOverForSoilTemperatureMeasurement() {
        graphPage.verifyWhetherTimelineSeriesWillHaveSelectedDatesForSoilTemp();
    }

    @Then("verifying the api count for soil temperature value with UI average")
    public void verifyingTheApiCountForSoilTemperatureValueWithUIAverage() throws InterruptedException, ParseException, JsonProcessingException {
        graphPage.soilTemperatureAvgVerification();
    }

    @Then("verifying the api count for soil temperature value with UI average for Hourly")
    public void verifyingTheApiCountForSoilTemperatureValueWithUIAverageForHourly() {
        graphPage.soilTemperatureAvgVerificationForHourly();
    }

    @And("the timeline series will have the selected dates displayed when hovered over for hourly in wind")
    public void theTimelineSeriesWillHaveTheSelectedDatesDisplayedWhenHoveredOverForHourlyInWind() {
        graphPage.verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourlyForSolarRad();
    }

    @And("verify the units displayed in the account page are the same in the table for wind Deficit and load more option is displayed")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableForWindDeficitAndLoadMoreOptionIsDisplayed() {
        graphPage.verifyUnitsInGraphForWind();
    }

    @And("verify the units displayed in the account page are the same in the table for Relative Humidity and load more option is displayed")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableForRelativeHumidityAndLoadMoreOptionIsDisplayed() {
        graphPage.verifyUnitsInGraphForRelativeHumidity();
    }

    @Then("verifying the api count for Relative Humidity with UI in hourly view")
    public void verifyingTheApiCountForRelativeHumidityWithUIInHourlyView() {
        graphPage.verifyAPiValuesInGraphForRelativeHumidity();
    }

    @And("the timeline series will have the selected dates displayed when hovered over for hourly for Vapor Pressure Deficit")
    public void theTimelineSeriesWillHaveTheSelectedDatesDisplayedWhenHoveredOverForHourlyForVaporPressureDeficit() {
        graphPage.verifyWhetherTimelineSeriesWillHaveSelectedDatesForHourlyForSolarRad();
    }

    @And("verify the units displayed in the account page are the same in the table for Vapor Pressure Deficit and load more option is displayed")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableForVaporPressureDeficitAndLoadMoreOptionIsDisplayed() {
        graphPage.verifyUnitsInGraphForPressure();
    }

    @Then("verifying the api count for Vapor Pressure Deficit with UI in hourly view")
    public void verifyingTheApiCountForVaporPressureDeficitWithUIInHourlyView() {
        graphPage.verifyAPiValuesInVaporPressureDeficit();
    }

    @Then("verify and enter the details on the page. Select the {string} site, measurement as {string} and {string} and date as {string} for the role {string}")
    public void verifyAndEnterTheDetailsOnThePageSelectTheSiteMeasurementAsAndAndDateAs(String numberOfSites, String measurement1, String measurement2, String date, String userRole) {
        graphPage.verifyGraphWithSelectedDetailsForTwoMeasurement(Integer.parseInt(numberOfSites), measurement1, measurement2, date, userRole);
    }

    @And("verify the units displayed in the account page are the same in the table for Maximum Temperature,Minimum Temperature and load more option is displayed")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableForMaximumTemperatureMinimumTemperatureAndLoadMoreOptionIsDisplayed() {
        graphPage.verifyUnitsInGraphForMaxAndMinTemp();
    }

    @Then("verifying the api count for Maximum Temperature and Minimum Temperature with UI in hourly view for single sites")
    public void verifyingTheApiCountForMaximumTemperatureAndMinimumTemperatureWithUIInHourlyViewForSingleSites() {
        graphPage.verifyApiResponseOfIntegerValueForAllThreeColumnForHourly();
    }

    @And("verify the units displayed in the account page are the same in the table for ETc and load more option is displayed")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableForETcAndLoadMoreOptionIsDisplayed() {
        graphPage.verifyUnitsInGraphForMeasurement();
    }

    @Then("verifying the api count for ETc with UI in hourly view")
    public void verifyingTheApiCountForETcWithUIInHourlyView() {
        graphPage.verifyEtcCountInApiForMultipleSitesForGraph();
    }

    @And("verify the units displayed in the account page are the same in the table for Leaf Wetness and load more option is displayed")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableForLeafWetnessAndLoadMoreOptionIsDisplayed() {
        graphPage.verifyUnitsInGraphLeafWetness();
    }

    @Then("verifying the api count for Leaf Wetness with UI in hourly view")
    public void verifyingTheApiCountForLeafWetnessWithUIInHourlyView() {
        graphPage.verifyLeafWetnessCountInApiForMultipleSitesForGraph();
    }

    @And("verify the units displayed in the account page are the same in the table for Precipitation and load more option is displayed")
    public void verifyTheUnitsDisplayedInTheAccountPageAreTheSameInTheTableForPrecipitationAndLoadMoreOptionIsDisplayed() {
        graphPage.verifyUnitsInGraphForMeasurement();
    }

    @Then("verifying the api count for Precipitation with UI in hourly view")
    public void verifyingTheApiCountForPrecipitationWithUIInHourlyView() {
        graphPage.verifyPrecipitationCountInApiForMultipleSitesForGraph();
    }

    @Then("verifying the api count for Maximum Temperature and Minimum Temperature with UI in hourly view")
    public void verifyingTheApiCountForMaximumTemperatureAndMinimumTemperatureWithUIInHourlyView() {
        graphPage.verifyApiResponseForMultipleSitesForMaxAndMinTempForHourly();
    }

    @Then("verify the values in the hourly API response should match with respect to the integer value in table, for the sites selected")
    public void verifyTheValuesInTheHourlyAPIResponseShouldMatchWithRespectToTheIntegerValueInTableForTheSitesSelected() {
        graphPage.verifyHourlyApiResponseForMultipleSitesAndMeasurementsAsWind();
    }

    @Then("verify the values in the hourly API response should match with respect to the integer value in table, for the sites selected if wind")
    public void verifyTheValuesInTheHourlyAPIResponseShouldMatchWithRespectToTheIntegerValueInTableForTheSitesSelectedIfWind() {
        graphPage.verifyHourlyApiResponseForSingleSiteMeasurementsAsWind();
    }

    @Then("verify whether the start date & end date in historical daily & hourly api call is matching with the start & end date selected in timeline.")
    public void verifyWhetherTheStartDateEndDateInHistoricalDailyHourlyApiCallIsMatchingWithTheStartEndDateSelectedInTimeline() {
        graphPage.verifyTheStartAndEndDateInApiEndPointForDailyAndHourlyTimeline();
    }

    @And("click on hourly button and verify the graph")
    public void clickOnHourlyButtonAndVerifyTheGraph() {
        graphPage.selectHourlyTimelineAndVerifyGraph();
    }

    @Then("identify a device with wind sensor present which is related to a single site")
    public void identifyADeviceWithWindSensorPresentWhichIsRelatedToASingleSite() {
        graphPage.selectSiteDeviceWhichHasWindSensor();
    }

    @Then("identify a device with no sensor present which is related to a single site")
    public void identifyADeviceWithNoSensorPresentWhichIsRelatedToASingleSite() {
        graphPage.selectSiteDeviceWhichHasNoSensorIcon();
    }

    @Then("select a site which is already picked from devices page and select wind as measurement")
    public void selectASiteWhichIsAlreadyPickedFromDevicesPageAndSelectWindAsMeasurement() {
        graphPage.selectSiteWhichAlreadyPickedFromDevicePageAndSelectMeasurementAsWind();
    }

    @Then("once graph is loaded scroll down to the table & verify the first column name and data shown in the table")
    public void onceGraphIsLoadedScrollDownToTheTableVerifyTheFirstColumnNameAndDataShownInTheTable() {
        graphPage.verifyFirstColumnInTable();
    }

    @When("once device is picked, navigate to {string} page")
    public void onceDeviceIsPickedNavigateToPage(String pageName) {
        graphPage.navigateToGraphPage(pageName);
    }

    @Then("select a {string} site and measurement and click on all in the date section for {string} user")
    public void selectASiteAndMeasurementAndClickOnAllInTheDateSectionForUser(String numberOfSites, String userRole) {
//        graphPage.selectASiteForUserRole(Integer.parseInt(numberOfSites), userRole);
        graphPage.selectSingleSites();
        graphPage.selectMeasurementAsMaxMinTemp();
        graphPage.selectAnyOptionInTimelineAndClickOnGraph();
    }
    @And("click on the export btn")
    public void clickOnTheExportBtn() {
        graphPage.clickOnTheExportButton();
    }
    @And("click on the graph button")
    public void clickOnTheGraphButton() {
        graphPage.clickOnTheGraphBtn();
    }

}