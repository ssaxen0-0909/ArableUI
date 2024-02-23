package stepDefinitions.Rank;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.rankPage;

public class RankSteps {
    @When("navigate to page {string} and verify table is displayed")
    public void navigateToPageAndVerifyTableIsDisplayed(String page) throws IOException, InterruptedException {
        rankPage.navigateToPage(page);
    }

//    @Then("update page load time in Excel sheet for Rank row for {string} user")
//    public void updatePageLoadTimeInExcelSheetForRankRowForUser(String role) throws IOException, InterruptedException {
//        rankPage.captureRankPageLoadTime(role);
//    }

    @Then("verify sortBy for all options with multiple {string}")
    public void verifySortByForAllOptionsWithMultiple(String role) throws IOException, InterruptedException {
        rankPage.verifySortByOptions(role);
    }

    @Then("verify sortBy for high and low options with multiple {string}")
    public void verifySortByForHighAndLowOptionsWithMultiple(String role) throws IOException, InterruptedException {
        rankPage.verifySortByHighLow(role);
    }

    @Then("verify sortBy column By asc and desc order with multiple {string}")
    public void verifySortByColumnByAscAndDescOrderWithMultiple(String role) throws IOException, InterruptedException {
        rankPage.verifySortColumnByAscDesc(role);
    }

    @Then("verify tables on org switch with multiple {string}")
    public void verifyTablesOnOrgSwitchWithMultiple(String role) throws IOException, InterruptedException {
        rankPage.verifyTableOnOrgSwitch(role);
    }

    @Then("verify clicking on site name and navigation to weather page with multiple {string}")
    public void verifyClickingOnSiteNameAndNavigationToWeatherPageWithMultiple(String role) throws IOException, InterruptedException {
        rankPage.verifyNavigationToWeatherPage(role);
    }
}