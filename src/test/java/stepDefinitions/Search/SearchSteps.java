package stepDefinitions.Search;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.searchPage;

public class SearchSteps {

    //    @And("verify search bar is displayed for {string} user")
//    public void verifySearchBarIsDisplayedForUser(String page) throws IOException, InterruptedException {
////        searchPage.navigateToPage(page);
//        searchPage.captureSearchPageLoadTime(page);
//    }
    @Then("clicked on search icon and navigate to {string} page")
    public void clickedOnSearchIconAndNavigateToPage(String role) throws IOException, InterruptedException {
        searchPage.navigateToPage(role);
    }

    @When("navigate to page {string} and verify if site card is displayed on searching with site name for {string} user")
    public void navigateToPageAndVerifyIfSiteCardIsDisplayedOnSearchingWithSiteNameForUser(String page, String role) throws IOException, InterruptedException {
        searchPage.navigateToPage(page);
        searchPage.SiteCard(role);
    }

    @When("navigate to page {string} and verify if device card is displayed on searching with device name for {string} user")
    public void navigateToPageAndVerifyIfDeviceCardIsDisplayedOnSearchingWithDeviceNameForUser(String page, String role) throws IOException, InterruptedException {
        searchPage.navigateToPage(page);
        searchPage.DevicesCard(role);
    }

    @When("navigate to page {string} and verify if device card is navigating to searched device on device page for {string} user")
    public void navigateToPageAndVerifyIfDeviceCardIsNavigatingToSearchedDeviceOnDevicePageForUser(String page, String role) throws IOException, InterruptedException {
        searchPage.navigateToPage(page);
        searchPage.verifyDevicesCardNavigation(role);
    }

    @When("navigate to page {string} and verify if site card is navigating to searched site on weather page for {string} user")
    public void navigateToPageAndVerifyIfSiteCardIsNavigatingToSearchedSiteOnWeatherPageForUser(String page) throws IOException, InterruptedException {
        searchPage.navigateToPage(page);
        searchPage.verifySiteCardNavigation(page);
    }

    @When("navigate to page {string} and verify if site card is navigating to searched site weather tab for {string} user")
    public void navigateToPageAndVerifyIfSiteCardIsNavigatingToSearchedSiteWeatherTabForUser(String page, String role) throws IOException, InterruptedException {
        searchPage.navigateToPage(page);
        searchPage.verifySiteCardNavigation(page);
    }
}
