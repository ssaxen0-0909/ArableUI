package stepDefinitions.Login;

import TestRail.APIException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static support.World.loginPage;

public class loginPage {

    @Given("log into application with valid credential for different {string} user")
    public void logIntoApplicationWithValidCredentialForDifferentUser(String role) throws APIException, IOException, InterruptedException {
        loginPage.logInToTheApplication(role);
//        loginPage.verifyLoggedIn();
    }

    @Then("entered invalid email & password and click on Login button")
    public void enteredInvalidEmailPasswordAndClickOnLoginButton() throws InterruptedException {
        loginPage.loginWithInvalidCredential();
    }

    @Then("on login page verify ninety days checkbox is checked")
    public void onLoginPageVerifyNinetyDaysCheckboxIsChecked() {
        loginPage.verifyChecked90daysCheckbox();
    }

    @Then("on login page verify all titles on login page")
    public void onLoginPageVerifyAllTitlesOnLoginPage() {
        loginPage.verifyTitlesOnLoginPage();
    }
}
