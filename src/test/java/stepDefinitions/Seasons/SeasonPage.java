package stepDefinitions.Seasons;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.World;

import java.io.IOException;
import java.text.ParseException;

import static support.World.seasonsPage;

public class SeasonPage {
    @Given("assign testcase {string} to log data to TestRail")
    public void assignTestcaseToLogDataToTestRail(String testCaseID) {
        World.TestCaseID = testCaseID;
    }

    @When("navigate to {string} and verify season table is displayed for {string} user")
    public void navigateToAndVerifySeasonTableIsDisplayedForUser(String page, String role) throws IOException, InterruptedException {
        seasonsPage.navigateToPage(page);
    }

    @When("navigate to {string} and verify create new season button is displayed for {string} user")
    public void navigate_to_and_verify_create_new_season_button_is_displayed_for_user(String page, String role) throws IOException, InterruptedException {
        seasonsPage.navigateToPage(page);
        seasonsPage.verifyCreateNewSeasonButton(role);
    }

    @Then("create a new season for {string} user and verify the new season is created")
    public void create_a_new_season_for_user_and_verify_the_new_season_is_created(String role) throws InterruptedException, IOException {
        seasonsPage.createNewSeason(role);
    }

    @When("navigate to {string} and verify show settings button is displayed for {string} user")
    public void navigateToAndVerifyShowSettingsButtonIsDisplayedForUser(String role, String page) throws IOException, InterruptedException {
        seasonsPage.navigateToPage(page);
        seasonsPage.verifyShowSettingsButton(role);
    }

    @Then("click on it and verify copy season button for different {string} user")
    public void clickOnItAndVerifyCopySeasonButtonForDifferentUser(String role) {
        seasonsPage.verifyCopySeasonButton(role);
    }

    @Then("click on it and verify copy season functionality for different {string} user")
    public void clickOnItAndVerifyCopySeasonFunctionalityForDifferentUser(String role) throws InterruptedException {
        seasonsPage.verifyCopySeasonButtonFeature(role);
    }

    @Then("click on it and verify copy season modal contents for different {string} user")
    public void clickOnItAndVerifyCopySeasonModalContentsForDifferentUser(String role) {
        seasonsPage.verifyCopySeasonModalContents(role);
    }

    @Then("click on it and verify the add and delete growth stages options are present under menu for {string} user")
    public void clickOnItAndVerifyTheAddAndDeleteGrowthStagesOptionsArePresentUnderMenuForUser(String role) throws IOException, InterruptedException {
        seasonsPage.verifyAddDeleteGrowthStageButton(role);
    }

    @Then("create a new season in days mode for {string} user and verify the new season is created")
    public void createANewSeasonInDaysModeForUserAndVerifyTheNewSeasonIsCreated(String role) throws IOException, InterruptedException {
        seasonsPage.createNewSeasonDaysMode(role);
    }

    @When("navigate to {string} and verify new season is created successfully for {string} user")
    public void navigateToAndVerifyNewSeasonIsCreatedSuccessfullyForUser(String page, String role) throws IOException, InterruptedException {
        seasonsPage.navigateToPage(page);
        seasonsPage.verifySeasonCreatedToAddNewGrowthStage(role);
    }

    @Then("click on Growth stages to verify add new growth stages functionality for different {string} user and save the season")
    public void clickOnGrowthStagesToVerifyAddNewGrowthStagesFunctionalityForDifferentUserAndSaveTheSeason(String role) throws InterruptedException {
        seasonsPage.verifyNewGsStageAdded(role);
    }

    @When("navigate to {string} and verify new season is created successfully to edit and delete growth stage for {string} user")
    public void navigateToAndVerifyNewSeasonIsCreatedSuccessfullyToEditAndDeleteGrowthStageForUser(String page, String role) throws IOException, InterruptedException {
        seasonsPage.navigateToPage(page);
        seasonsPage.verifySeasonCreatedToEditDeleteGrowthStage(role);
    }

    @Then("click on Growth stages to verify edit and delete functionality for different {string} user and save the season")
    public void clickOnGrowthStagesToVerifyEditAndDeleteFunctionalityForDifferentUserAndSaveTheSeason(String role) throws InterruptedException, IOException {
        seasonsPage.verifyEditDeleteGs(role);
    }

    @When("navigate to seasons page")
    public void navigateToSeasonsPage() {
        seasonsPage.navigateToSeasonsPage();
    }

    @Then("expand days mode season and check gdd value from api for different {string} user")
    public void expandDaysModeSeasonAndCheckGddValueFromApiForDifferentUser(String role) throws IOException, InterruptedException, ParseException {
        seasonsPage.getGDDForecastValue(role);
    }
}