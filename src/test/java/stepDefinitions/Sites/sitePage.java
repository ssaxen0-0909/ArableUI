package stepDefinitions.Sites;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.sitesPage;

public class sitePage {

    @When("navigate to page {string}")
    public void navigateToPage(String page) throws IOException, InterruptedException {
        sitesPage.navigateToSitePage(page);
    }

//    @Then("verify site card is displayed and update load time in Excel sheet for {string} user")
//    public void verifySiteCardIsDisplayedAndUpdateLoadTimeInExcelSheetForUser(String role) throws IOException {
//        sitesPage.captureSitePageLoadTime(role);
//    }

//    @Then("verify edit site and update load time in Excel sheet for {string} user")
//    public void verifyEditSiteAndUpdateLoadTimeInExcelSheetForUser(String role) throws IOException, InterruptedException {
//        sitesPage.captureEditSiteLoadTime(role);
//    }

    @Then("verify edit soil properties for site card for {string} user")
    public void verifyEditSoilPropertiesForSiteCardForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyEditSoilProperties(role);
    }

    @Then("verify editing manual irrigation for {string} user")
    public void verifyEditingManualIrrigationForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyManualIrrigation(role);
    }

    @Then("verify create season from menu button for {string} user")
    public void verifyCreateSeasonFromMenuButtonForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyCreateSeason_MenuBtn(role);
    }

    @Then("verify location list of card matching with site details page for {string} user")
    public void verifyLocationListOfCardMatchingWithSiteDetailsPageForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyLocationListInSiteDetailsPage(role);
    }

    @Then("verify Go to button on site details page for {string} user")
    public void verifyGoToButtonOnSiteDetailsPageForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyGoToPageButton(role);
    }

    @Then("verify Go to last page on site details page for {string} user")
    public void verifyGoToLastPageOnSiteDetailsPageForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyGoToPageFeature(role);
    }

    @Then("click on last page button and then state of button for {string} user")
    public void clickOnLastPageButtonAndThenStateOfButtonForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyGoToLastPageBtnDisabled(role);
    }

    @Then("verify go to first page and go to Prev page buttons state for {string} user")
    public void verifyGoToFirstPageAndGoToPrevPageButtonsStateForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyGoToFirstPageBtnDisabled(role);
    }

    @Then("verify behaviour on input number higher than last page number for {string} user")
    public void verifyBehaviourOnInputNumberHigherThanLastPageNumberForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyInputNumberHigherThanLastPage(role);
    }

    @Then("verify behaviour on input invalid value in go to field for {string} user")
    public void verifyBehaviourOnInputInvalidValueInGoToFieldForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyInvalidValueInGoToField(role);
    }

    @Then("click on Create New Site and verify warning message for {string} user")
    public void clickOnCreateNewSiteAndVerifyWarningMessageForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyWarningText(role);
    }

    @Then("click on Edit Site of any site and clear boundary button for {string} user")
    public void clickOnEditSiteOfAnySiteAndClearBoundaryButtonForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyClearBoundaryBtn(role);
    }

    @Then("click on Edit Site of any site and click on Clear Boundary button and verify saving site for {string} user")
    public void clickOnEditSiteOfAnySiteAndClickOnClearBoundaryButtonAndVerifySavingSiteForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifySavingSiteWithoutBoundary(role);
    }

    @Then("verify  sites list per page for {string} user")
    public void verifySitesListPerPageForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyPaginationView(role);
    }

    @Then("verify sites list on next page for {string} user")
    public void verifySitesListOnNextPageForUser(String role) throws IOException, InterruptedException {
        sitesPage.verifyNextPagePaginationView(role);
    }
}
