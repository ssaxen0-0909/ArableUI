package stepDefinitions.Plant;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.plantTab;


public class Plant_LoadTime {

    @When("navigate to {string} page click on the first site name")
    public void navigateToPageClickOnTheFirstSiteName(String role) throws InterruptedException, IOException {
        plantTab.navigationToPlantTab(role);
    }

    @Then("user is on site plant tab and verify canopy modal info for {string} user.")
    public void userIsOnSitePlantTabAndVerifyCanopyModalInfoForUser(String role) throws IOException {
        plantTab.verifyCanopyModalInfo(role);
    }

    @Then("user is on site plant tab and verify precipitation modal info for {string} user.")
    public void userIsOnSitePlantTabAndVerifyPrecipitationModalInfoForUser(String role) throws IOException {
        plantTab.verifyPrecipModalInfo(role);
    }

    @Then("user is on site plant tab and verify gdd modal info for {string} user.")
    public void userIsOnSitePlantTabAndVerifyGddModalInfoForUser(String role) throws IOException {
        plantTab.verifyGDDModalInfo(role);
    }

    @Then("user is on site plant tab and verify precipitation value shown in UI for {string} user.")
    public void userIsOnSitePlantTabAndVerifyPrecipitationValueShownInUIForUser(String role) throws IOException {
        plantTab.verifyPrecipModalInfo(role);
    }

    @Then("user is on site plant tab and verify ci modal info for {string} user.")
    public void userIsOnSitePlantTabAndVerifyCiModalInfoForUser(String role) throws IOException {
        plantTab.verifyCIModalInfo(role);
    }

    @Then("user is on site plant tab and verify Canopy Evapotranspiration modal info for {string} user.")
    public void userIsOnSitePlantTabAndVerifyCanopyEvapotranspirationModalInfoForUser(String role) throws IOException {
        plantTab.verifyCanopyModalInfo(role);
    }

    @Then("user is on site plant tab and verify Canopy Evapotranspiration value shown in UI for {string} user.")
    public void userIsOnSitePlantTabAndVerifyCanopyEvapotranspirationValueShownInUIForUser(String role) throws IOException {
        plantTab.verifyCanopyModalInfo(role);
    }

    @Then("user is on site plant tab and verify ndvi modal info for {string} user.")
    public void userIsOnSitePlantTabAndVerifyNdviModalInfoForUser(String role) throws IOException {
        plantTab.verifyNDVIModalInfo(role);
    }

    @Then("user is on site plant tab and verify current day modal info for {string} user.")
    public void userIsOnSitePlantTabAndVerifyCurrentDayModalInfoForUser(String role) throws IOException {
        plantTab.verifyCurrentDayModalInfo(role);
    }

    @Then("user is on site plant tab and verify export page navigation for {string} user.")
    public void userIsOnSitePlantTabAndVerifyExportPageNavigationForUser(String role) throws IOException, InterruptedException {
        plantTab.verifyExportPageNavigation(role);
    }

    @Then("user is on site plant tab and verify graph page navigation for {string} user.")
    public void userIsOnSitePlantTabAndVerifyGraphPageNavigationForUser(String role) throws IOException, InterruptedException {
        plantTab.verifyGraphPageNavigation(role);
    }

    @Then("user is on site plant tab and verify last seven days Canopy Value for {string} user.")
    public void userIsOnSitePlantTabAndVerifyLastSevenDaysCanopyValueForUser(String role) throws IOException, InterruptedException {
        plantTab.verifyLast7daysCanopyValue(role);
    }

    @Then("user is on site plant tab and verify last seven days Precip Value for {string} user.")
    public void userIsOnSitePlantTabAndVerifyLastSevenDaysPrecipValueForUser(String role) throws IOException, InterruptedException {
//        plantTab.verifyLast7daysPrecipValue(role);
        plantTab.verifyPast7daysPrecipitationValue(role);
    }

    @Then("user is on site plant tab and verify next seven days precipitation Value for {string} user from UI.")
    public void userIsOnSitePlantTabAndVerifyNextSevenDaysPrecipitationValueForUserfromUI(String role) throws IOException, InterruptedException {
        plantTab.verifyNext7daysPrecipitationValue(role);
    }


    @Then("user is on site plant tab and verify next seven days canopy Value for {string} user from UI.")
    public void userIsOnSitePlantTabAndVerifyNextSevenDaysCanopyValueForUserfromUI(String role) throws IOException, InterruptedException {
        plantTab.verifyNext7daysCanopyValue(role);
    }

    @Then("user is on site plant tab and verify next seven days canopy Value for {string} user from API.")
    public void userIsOnSitePlantTabAndVerifyNextSevenDaysCanopyValueForUserfromAPI(String role) throws IOException, InterruptedException {
        plantTab.verifyNext7daysCanopyValueFromAPI(role);
    }

    @Then("user is on site plant tab and verify next seven days precipitation Value for {string} user from API.")
    public void userIsOnSitePlantTabAndVerifyNextSevenDaysPrecipitationValueForUserfromAPI(String role) throws IOException, InterruptedException {
        plantTab.verifyNext7daysPrecipitationValueFromAPI(role);
    }

    @Then("user is on site plant tab and verify past seven days precipitation Value for {string} user from API.")
    public void userIsOnSitePlantTabAndVerifyPastSevenDaysPrecipitationValueForUserfromAPI(String role) throws IOException, InterruptedException {
        plantTab.verifyPast7daysPrecipitationValueFromAPI(role);
    }

    @Then("user is on site plant tab and verify next seven days precip Value for {string} user.")
    public void userIsOnSitePlantTabAndVerifyNextSevenDaysPrecipValueForUser(String role) throws IOException, InterruptedException {
        plantTab.verifyNext7daysPrecipValue(role);
    }

    @Then("user is on site plant tab and verify weekly insight value for {string} user.")
    public void userIsOnSitePlantTabAndVerifyWeeklyInsightValueForUser(String role) throws IOException, InterruptedException {
        plantTab.verifyAllValuesForETcValue(role);
    }

    @Then("user is on site plant tab and verify tooltip text for {string} user.")
    public void userIsOnSitePlantTabAndVerifyTooltipTextForUser(String siteId) throws IOException, InterruptedException {
        plantTab.verifyInfoIconText(siteId);
    }

    @Then("user is on plant tab and verify gdd graph for {string} user.")
    public void userIsOnPlantTabAndVerifyGddGraphForUser(String role) throws IOException, InterruptedException {
        plantTab.verifyGDDGraph(role);
    }

    @Then("user is on site plant tab and verify cl value shown in UI wrt api response for {string} user.")
    public void userIsOnSitePlantTabAndVerifyClValueShownInUIWrtApiResponseForUser(String role) throws IOException, InterruptedException {
        plantTab.verifyCurrentCLValue(role);
    }

    @Then("user verify the cl percentage change for last seven days change for {string} user.")
    public void userVerifyThePercentageChangeForLastSevenDaysChangeforUser(String role) throws Exception {
        plantTab.verifyPastCLValue(role);
    }

    @Then("user is on site plant tab and verify ndvi value shown in UI wrt api resposne for {string} user.")
    public void userIsOnSitePlantTabAndVerifyNdviValueShownInUIWrtApiResposneForUser(String role) throws IOException, InterruptedException {
        plantTab.verifyCurrentNDVIValue(role);
    }

    @Then("user verify the ndvi percentage change for last seven days change for {string} user.")
    public void userVerifyTheNdviPercentageChangeForLastSevenDaysChangeforUser(String role) throws Exception {
        plantTab.verifyPastNDVIValue(role);
    }

    @Then("user is on site plant tab and verify ETc value shown in UI wrt api resposne for {string} user.")
    public void userIsOnSitePlantTabAndVerifyETcValueShownInUIWrtApiResposneForUser(String role) throws IOException, InterruptedException {
        plantTab.verifyCurrentETcValue(role);
    }
}

