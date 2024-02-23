package stepDefinitions.performance;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.map;
import static support.World.uiPerformance;

public class performance {

    @And("capture load time for {string} user")
    public void captureLoadTimeForUser(String role) throws IOException, InterruptedException {
        map.captureLoadTime(role);
    }

    @Then("verify site name is displayed and also capture load time after switching measurement to gdd for {string} user")
    public void verifySiteNameIsDisplayedAndAlsoCaptureLoadTimeAfterSwitchingMeasurementToGddForUser(String role) throws InterruptedException, IOException {
        uiPerformance.captureLoadTimeOnSwitchingGDDMeasurement(role);
    }

    @Then("verify site name is displayed and also capture load time after switching to specific team for {string} user")
    public void verifySiteNameIsDisplayedAndAlsoCaptureLoadTimeAfterSwitchingToSpecificTeamForUser(String role) throws InterruptedException, IOException {
        uiPerformance.captureLoadTimeOnSwitchingTeam(role);
    }

    @Then("verify site name is displayed and also capture response time on switching to specific team's gdd for {string} user")
    public void verifySiteNameIsDisplayedAndAlsoCaptureResponseTimeOnSwitchingToSpecificTeamSGddForUser(String role) throws InterruptedException, IOException {
        uiPerformance.captureLoadTimeOnSwitchingTeamAndThenGDD(role);
    }

    @Then("verify teams name are displayed and also update page load time in Excel for {string} user")
    public void verifyTeamsNameAreDisplayedAndAlsoUpdatePageLoadTimeInExcelForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureTeamsPageLoadTime(role);
    }

    @Then("click on Create New Team button and capture load time in Excel for {string} user")
    public void clickOnCreateNewTeamButtonAndCaptureLoadTimeInExcelForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureCreateTeamsModalLoadTime(role);
    }

    @Then("scroll down to specific team click on view teams and capture load time in Excel for {string} user")
    public void scrollDownToSpecificTeamClickOnViewTeamsAndCaptureLoadTimeInExcelForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureViewTeamsModalLoadTime(role);
    }

    @Then("verify site card is displayed and update load time in Excel sheet for {string} user")
    public void verifySiteCardIsDisplayedAndUpdateLoadTimeInExcelSheetForUser(String role) throws IOException {
        uiPerformance.captureSitePageLoadTime(role);
    }

    @Then("verify edit site and update load time in Excel sheet for {string} user")
    public void verifyEditSiteAndUpdateLoadTimeInExcelSheetForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureEditSiteLoadTime(role);
    }

    @Then("capture page load time to load specific team and update in Excel sheet for {string} user")
    public void capturePageLoadTimeToLoadSpecificTeamAndUpdateInExcelSheetForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureSpecificTeamLoadTimeInSites(role);
    }

    @Then("switch team and search for a specific site for {string} user")
    public void switchTeamAndSearchForASpecificSiteForUser(String role) throws IOException, InterruptedException {
        uiPerformance.SearchSitesInSitePageWithTeamFilter(role);
    }

    @Then("search for a specific site and capture load time for {string} user")
    public void searchForASpecificSiteAndCaptureLoadTimeForUser(String role) throws IOException, InterruptedException {
        uiPerformance.SearchSitesInSitePageForAllTeams(role);
    }


    @When("navigate to {string} page.")
    public void navigateToPage(String role) throws IOException, InterruptedException {
        uiPerformance.navigateToMultisiteWaterPage(role);
    }


    @Then("capture load time and update Excel sheet for {string} user")
    public void captureLoadTimeAndUpdateExcelSheetForUser(String role) throws IOException, InterruptedException {
        uiPerformance.multiSiteWaterByOrg(role);
    }

    @Then("switch to specific team and capture load time for {string} user")
    public void switchToSpecificTeamAndCaptureLoadTimeForUser(String role) throws IOException, InterruptedException {
        uiPerformance.multiSiteWaterByTeam(role);
    }

    @Then("update page load time in Excel sheet for {string} user")
    public void updatePageLoadTimeInExcelSheetForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureGraphPageLoadTime(role);
    }

    @Then("select details and click on Graph Button and verify it with different {string}.")
    public void selectDetailsAndClickOnGraphButtonAndVerifyItWithDifferent(String role) throws InterruptedException, IOException {
        uiPerformance.captureGraphPageDailyLoadTime(role);
    }

    @Then("switch to hourly and verify it with different {string}.")
    public void switchToHourlyAndVerifyItWithDifferent(String role) throws InterruptedException, IOException {
        uiPerformance.captureGraphPageHourlyLoadTime(role);
    }

    @Then("select details with gdd as measurement and click on Graph Button for different {string}.")
    public void selectDetailsWithGddAsMeasurementAndClickOnGraphButtonForDifferent(String role) throws InterruptedException, IOException {
        uiPerformance.captureGraphPageGDDLoadTime(role);
    }

    @Then("update Excel sheet for {string} user")
    public void updateExcelSheetForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureExportPageLoadTime(role);
    }

    @Then("fill all details and click on export button for {string} user")
    public void fillAllDetailsAndClickOnExportButtonForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureExportDailyCSVLoadTime(role);
    }

    @Then("select Hourly granularity and fill all details and click on export button for {string} user")
    public void selectHourlyGranularityAndFillAllDetailsAndClickOnExportButtonForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureExportHourlyCSVLoadTime(role);
    }

    @Then("select no sentek site for all granularity and click on export button for {string} user")
    public void selectNoSentekSiteForAllGranularityAndClickOnExportButtonForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureExportAllCSVLoadTime(role);
    }

    @Then("select sentek site for all granularity and click on export button for {string} user")
    public void selectSentekSiteForAllGranularityAndClickOnExportButtonForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureExportAllSentekSite(role);
    }

    @Then("verify generating,copying & refreshing for {string} user")
    public void verifyGeneratingCopyingRefreshingForUser(String role) throws InterruptedException, IOException {
        uiPerformance.verifyGenerateKey(role);
    }

    @Then("update Excel sheet for {string} user the time taken to load the page")
    public void updateExcelSheetForUserTheTimeTakenToLoadThePage(String role) throws IOException, InterruptedException {
        uiPerformance.captureAlertsPageLoadTime(role);
    }

    @Then("update Excel columns for {string} user")
    public void updateExcelColumnsForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureAlertSettingsPageLoadTime(role);
    }

    @Then("update Excel for {string} user the time taken to load the page")
    public void updateExcelForUserTheTimeTakenToLoadThePage(String role) throws IOException, InterruptedException {
        uiPerformance.captureDevicesPageLoadTime(role);
    }

    @And("verify page response time for {string} user.")
    public void verifyPageResponseTimeForUser(String role) throws InterruptedException, IOException {
        uiPerformance.verifyVisionPageResponseTime(role);
    }

    @Then("user is on site notes tab and verify the notes box and update excel for {string} user.")
    public void userIsOnSiteNotesTabAndVerifyTheNotesBoxAndUpdateExcelForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureNotesPageLoadTime(role);
    }

    @Then("user is on site plant tab and verify the irrigation table and update excel for {string} user.")
    public void userIsOnSitePlantTabAndVerifyTheIrrigationTableAndUpdateExcelForUser(String role) throws IOException {
        uiPerformance.capturePlantPageLoadTime(role);
    }

    @Then("update page load time in Excel sheet for Rank row for {string} user")
    public void updatePageLoadTimeInExcelSheetForRankRowForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureRankPageLoadTime(role);
    }

    @And("verify search bar is displayed for {string} user")
    public void verifySearchBarIsDisplayedForUser(String page) throws IOException, InterruptedException {
        uiPerformance.captureSearchPageLoadTime(page);
    }

    @Then("write in Excel for {string} user the time taken to load the page")
    public void writeInExcelForUserTheTimeTakenToLoadThePage(String role) throws IOException, InterruptedException {
        uiPerformance.captureSeasonPageLoadTime(role);
    }

    @Then("user is on site water tab and verify the water summary table and update excel for {string} user.")
    public void userIsOnSiteWaterTabAndVerifyTheWaterSummaryTableAndUpdateExcelForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureWaterPageLoadTime(role);
    }

    @Then("verify water summary table, switch water balance to day and update excel for load time of different {string} user.")
    public void verifyWaterSummaryTableSwitchWaterBalanceToDayAndUpdateExcelForLoadTimeOfDifferentUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureWaterBalance_Day_LoadTime(role);
    }

    @Then("verify water summary table, switch water balance to month and update excel for load time of different {string} user.")
    public void verifyWaterSummaryTableSwitchWaterBalanceToMonthAndUpdateExcelForLoadTimeOfDifferentUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureWaterBalance_Month_LoadTime(role);
    }

    @Then("verify water summary table, switch water balance to week and update excel for load time of different {string} user.")
    public void verifyWaterSummaryTableSwitchWaterBalanceToWeekAndUpdateExcelForLoadTimeOfDifferentUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureWaterBalance_Week_LoadTime(role);
    }

    @Then("verify water summary table, switch water balance to gdd and update excel for load time of different {string} user.")
    public void verifyWaterSummaryTableSwitchWaterBalanceToGddAndUpdateExcelForLoadTimeOfDifferentUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureWaterBalance_GDD_LoadTime(role);
    }

    @Then("user is on site weather tab and verify the current conditions table and update excel for {string} user.")
    public void userIsOnSiteWeatherTabAndVerifyTheCurrentConditionsTableAndUpdateExcelForUser(String role) throws IOException, InterruptedException {
        uiPerformance.captureWeatherPageLoadTime(role);
    }
}
