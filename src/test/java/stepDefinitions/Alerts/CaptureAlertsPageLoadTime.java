package stepDefinitions.Alerts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.alertsPage;

public class CaptureAlertsPageLoadTime {

    @When("navigate to {string} and verify table is displayed")
    public void navigateToAndVerifyAlertsTableIsDisplayedForUser(String page) throws InterruptedException, IOException {
        alertsPage.navigateToPage(page);
    }

//    @Then("update Excel sheet for {string} user the time taken to load the page")
//    public void updateExcelSheetForUserTheTimeTakenToLoadThePage(String role) throws IOException, InterruptedException {
//        alertsPage.captureAlertsPageLoadTime(role);
//    }

    @When("navigate to {string} and verify the count by clicking on view more button for {string} user")
    public void navigateToAndVerifyTheCountByClickingOnViewMoreButtonForUser(String page, String role) throws IOException, InterruptedException {
        alertsPage.navigateToPage(page);
        alertsPage.verifyViewMoreButton(role);
    }

    @When("navigate to {string} and verify the filter options by clicking on dropdown button for {string} user")
    public void navigateToAndVerifyTheFilterOptionsByClickingOnDropdownButtonForUser(String page, String role) throws IOException, InterruptedException {
        alertsPage.navigateToPage(page);
        alertsPage.verifyFilterOptions(role);
    }

    @When("navigate to {string} and switch the org and verify activity for {string} user")
    public void navigateToAndSwitchTheOrgAndVerifyActivityForUser(String page, String role) throws IOException, InterruptedException {
        alertsPage.navigateToPage(page);
        alertsPage.verifyAlertsOnOrgSwitch(role);
    }

    @When("navigate to {string} and verify activity details are shown for {string} user")
    public void navigateToAndVerifyActivityDetailsAreShownForUser(String page, String role) throws IOException, InterruptedException {
        alertsPage.navigateToPage(page);
        alertsPage.verifyReadingActivity(role);
    }

    @When("navigate to {string} and verify default filter Date is shown for {string} user")
    public void navigateToAndVerifyDefaultFilterDateIsShownForUser(String page, String role) throws IOException, InterruptedException {
        alertsPage.navigateToPage(page);
        alertsPage.verifyDefaultDateFilter(role);
    }

    @When("navigate to {string} page for {string} user")
    public void navigateToPageForUser(String arg0, String userRole) {
        alertsPage.navigateToAlertsPage(userRole);
    }

    @And("if Alerts count are more than 15")
    public void ifAlertsCountAreMoreThan() {
        alertsPage.verifyAlertCount();
    }

    @Then("scroll down to the bottom & verify if View More Activity button should be present.")
    public void scrollDownToTheBottomVerifyIfViewMoreActivityButtonShouldBePresent() {
        alertsPage.scrollDownAndVerifyViewMoreActivityBtnIsPresent();
    }

    @And("click on three dots on the top right side")
    public void clickOnThreeDotsOnTheTopRightSide() {
        alertsPage.clickOnMarkAsReadAndVerifyTheUnreadCount();
    }

    @Then("open Network calls for user {string} & click on {string} option & observe")
    public void openNetworkCallsForUserClickOnOptionObserve(String role, String arg1) {
        alertsPage.verifyTheEndPointResponseWhenUserClicksOnMarkAllAsRead(role);
    }

    @And("switch to a specific team which has unread alerts")
    public void switchToASpecificTeamWhichHasUnreadAlerts() {
        alertsPage.selectASpecificTeamWhichHasUnreadAlerts();
    }

    @Then("change the organization, and check the alerts activity should also get changed accordingly")
    public void changeTheOrganizationAndCheckTheAlertsActivityShouldAlsoGetChangedAccordingly() {
        alertsPage.checkTheAlertsActivityWhenTheUserChangeTheOrganization();
    }

    @And("click on date dropdown & select {string}")
    public void clickOnDateDropdownSelect(String dropdownName) {
        alertsPage.clickOnDateDropdownAndSelect(dropdownName);
    }

    @Then("once list is shown, match the {string} count in notification api call & in the UI")
    public void onceListIsShownMatchTheCountInNotificationApiCallInTheUI(String arg0) {
        alertsPage.verifyTheActivityCountInBothUIAndApi();
    }

}
