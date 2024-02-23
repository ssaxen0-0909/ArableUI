package stepDefinitions.Accounts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.accountPage;

public class Account_Steps {

    @When("navigate to Settings and then to {string} page")
    public void navigateToSettingsAndThenToPage(String page) throws IOException, InterruptedException {
        accountPage.navigateToPage(page);
    }

//    @Then("verify generating,copying & refreshing for {string} user")
//    public void verifyGeneratingCopyingRefreshingForUser(String role) throws InterruptedException, IOException {
//        accountPage.verifyGenerateKey(role);
//    }


    @Then("verify changing size unit for {string} user")
    public void verifyChangingSizeUnitForUser(String role) throws InterruptedException, IOException {
        accountPage.verifySizeUnitChange(role);
    }

    @Then("verify changing pressure unit for {string} user")
    public void verifyChangingPressureUnitForUser(String role) throws InterruptedException, IOException {
        accountPage.verifyVaporPressureUnitAfterUnitChange(role);
    }

    @Then("verify Pt language option for {string} user")
    public void verifyPtLanguageOptionForUser(String role) {
        accountPage.verifyPtLanguageOption(role);
    }

    @Then("click on Pt language option and verify any translated text for {string} user")
    public void clickOnPtLanguageOptionAndVerifyAnyTranslatedTextForUser(String role) throws InterruptedException {
        accountPage.verifyPtTranslation(role);
    }

    @Then("verify Sp language option for {string} user")
    public void verifySpLanguageOptionForUser(String role) {
        accountPage.verifySpLanguageOption(role);
    }

    @Then("click on Sp language option and verify any translated text for {string} user")
    public void clickOnSpLanguageOptionAndVerifyAnyTranslatedTextForUser(String role) throws InterruptedException {
        accountPage.verifySPTranslation(role);
    }


    @Then("verify by entering  the numbers and special character in firstname & lastname field for {string} user")
    public void verifyFirstNameAndLastNameIsNotAcceptingNumbersAndSpecialCharacter(String role) throws InterruptedException {
        accountPage.verifyFirstNameAndLastNameIsNotAcceptingNumbersAndSpecialCharacter(role);
    }

    @Then("verify any error by changing number and flag  for {string} user")
    public void verifyAnyErrorByChangingNumberAndFlagForUser(String role) throws InterruptedException {
        accountPage.verifyErrorOnSavingByChangingFlagAndNumber(role);
    }

    @And("change the unit for Wind Speed in Account page")
    public void changeTheUnitForWindSpeedInAccountPage() {
        accountPage.changeTheUnitForWindSpeed();
    }

    @And("click on Save button")
    public void clickOnSaveButton() {
        accountPage.clickOnSaveButton();
    }

    @And("change the unit for Size in Account page")
    public void changeTheUnitForSizeInAccountPage() {
        accountPage.changeTheUnitForSize();
    }

    @And("change the unit for Temperature in Account page")
    public void changeTheUnitForTemperatureInAccountPage() {
        accountPage.changeTheUnitForTemperature();
    }

    @And("change the unit for Pressure in Account page")
    public void changeTheUnitForPressureInAccountPage() {
        accountPage.changeTheUnitForPressure();
    }

    @And("change the unit for volume in Account page")
    public void changeTheUnitForVolumeInAccountPage() {
        accountPage.changeTheUnitForVolume();
    }

    @And("verify that the unit for {string} with the API response")
    public void verifyThatTheUnitForSpeedWithTheAPIResponse(String units) {
        accountPage.verifyTheUnitInTheAPI(units);
    }

    @And("verify if language options are multiple and visible")
    public void verifyIfLanguageOptionsAreMultipleAndVisible() {
        accountPage.verifyTheLanguageTagIsVisible();
    }
}

