package stepDefinitions.Export;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import static support.World.accountPage;
import static support.World.exportPage;

public class Export {
    @When("navigate to page {string} and verify export dropdown is displayed for {string} user")
    public void navigateToPageAndVerifyExportDropdownIsDisplayedForUser(String page, String role) throws IOException, InterruptedException {
        exportPage.navigateToPage(page);
    }

//    @Then("update Excel sheet for {string} user")
//    public void updateExcelSheetForUser(String role) throws IOException, InterruptedException {
//        exportPage.captureExportPageLoadTime(role);
//    }
//
//    @Then("fill all details and click on export button for {string} user")
//    public void fillAllDetailsAndClickOnExportButtonForUser(String role) throws IOException, InterruptedException {
//        exportPage.captureExportDailyCSVLoadTime(role);
//    }
//
//    @Then("select Hourly granularity and fill all details and click on export button for {string} user")
//    public void selectHourlyGranularityAndFillAllDetailsAndClickOnExportButtonForUser(String role) throws IOException, InterruptedException {
//        exportPage.captureExportHourlyCSVLoadTime(role);
//    }
//
//    @Then("select all granularity and fill all details and click on export button for {string} user")
//    public void selectAllGranularityAndFillAllDetailsAndClickOnExportButtonForUser(String role) throws IOException, InterruptedException {
//        exportPage.captureExportAllCSVLoadTime(role);
//    }

    @And("verify the units for each params should be selected")
    public void verifyTheUnitsForEachParamsShouldBeSelected() {
        exportPage.verifyTheUnitsDisplayed();
    }

    @And("change the selection in Units section")
    public void changeTheSelectionInUnitsSection() {
        exportPage.changeTheUnits();
    }

    @And("navigate to map page")
    public void navigateToGraphPage() throws IOException, InterruptedException {
        accountPage.navigateToMapPage();
    }

    @Then("navigate back to {string} page & verify the units")
    public void navigateBackToPageVerifyTheUnits(String page) {
        exportPage.verifyTheUnits();
    }

    @And("fill in the details on the Export page")
    public void fillInTheDetailsOnTheExportPage() throws InterruptedException {
        exportPage.fillInTheDetailsOnTheExportPage();
    }

    @And("click on the submit btn")
    public void clickOnTheSubmitBtn() {
        exportPage.verifyThePageOnceClickOnSubmitBtn();
    }

    @And("verify the toast message after clicking on the toast message")
    public void verifyTheToastMessageAfterClickingOnTheToastMessage() {
        exportPage.verifyTheToastMessage();
    }

    @And("click on the daily btn")
    public void clickOnTheDailyBtn() {
        exportPage.clickOnDailyBtn();
    }

    @And("verify the start and end date in the daily Api")
    public void verifyTheStartAndEndDateInTheDailyApi() throws MalformedURLException, ParseException, InterruptedException {
        exportPage.verifyTheDateInTheApiAfterClickingOnTheExportBtn();
    }

    @And("verify the toast message after clicking on download Btn")
    public void verifyTheToastMessageAfterClickingOnDownloadBtn() {
        exportPage.verifyTheToastMessage();
    }

    @And("verify the local_site_time and utc_time column present in the csv file")
    public void verifyTheLocal_site_timeAndUtc_timeColumnPresentInTheCsvFile() throws Exception {
        exportPage.verifyTheTimeTagMatchInCsvFile();
    }

}
