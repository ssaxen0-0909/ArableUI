package stepDefinitions.Water;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.waterTab;
import static support.World.weatherPage;


public class water_LoadTime {

    @When("on {string} page click the site and go to site detail page")
    public void onPageClickTheSiteAndGoToSiteDetailPage(String page) throws InterruptedException, IOException {
        weatherPage.navigateToPage(page);
    }

    @Then("verify water balance modal text different for {string} user.")
    public void verifyWaterBalanceModalTextDifferentForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyWaterBalanceGraphModalInfo(role);
    }


    @Then("verify water balance table modal text different for {string} user.")
    public void verifyWaterBalanceTableModalTextDifferentForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyWaterDetailsTableModalInfo(role);
    }

    @Then("verify water summary modal text different for {string} user.")
    public void verifyWaterSummaryModalTextDifferentForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyWaterSummaryModalInfo(role);
    }

    @Then("verify Soil Moisture modal text different for {string} user.")
    public void verifySoilMoistureModalTextDifferentForUser(String role) throws IOException, InterruptedException {
        waterTab.verifySoilMoistureModalInfo(role);
    }

    @Then("verify GDD modal text different for {string} user.")
    public void verifyGDDModalTextDifferentForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyGDDModalInfo(role);
    }


    @Then("verify water page tables for {string} user.")
    public void verifyWaterPageTablesForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyContentsOfWaterPage(role);
    }

    @Then("verify adding and deleting of entry for {string} user.")
    public void verifyAddingAndDeletingOfEntryForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyAddAndDeleteManualIrrigationEntry(role);
    }

    @Then("verify water balance change value wrt api and UI for {string} user.")
    public void verifyWaterBalanceChangeValueWrtApiAndUIForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyWaterBalanceChangeSummaryValue(role);
    }

    @Then("verify water summary section value wrt api and UI for {string} user.")
    public void verifyWaterSummarySectionValueWrtApiAndUIForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyWaterSummaryValue(role);
    }

    @Then("verify water balance forecast section  value wrt api and UI for {string} user.")
    public void verifyWaterBalanceForecastSectionValueWrtApiAndUIForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyWaterForecastValue(role);
    }

    @Then("verify water soil moisture value in summary & balance section wrt api and UI for {string} user.")
    public void verifyWaterSoilMoistureValueInSummaryBalanceSectionWrtApiAndUIForUser(String role) throws IOException, InterruptedException {
        waterTab.verifySoilMoistureValueInBalanceAndSummarySection(role);
    }

    @Then("verify Water Details\\(Heat Stress) section value in summary & details section wrt api and UI for {string} user.")
    public void verifyWaterDetailsHeatStressSectionValueInSummaryDetailsSectionWrtApiAndUIForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyHeatStressSummaryAndDetailsValue(role);
    }

    @Then("open ETc replacement modal and verify default data wrt api response for {string} user.")
    public void openETcReplacementModalAndVerifyDefaultDataWrtApiResponseForUser(String role) throws IOException, InterruptedException {
        waterTab.verifyETcReplacementEntryAndFormat(role);
    }
}
