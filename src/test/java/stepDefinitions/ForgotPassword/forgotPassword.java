package stepDefinitions.ForgotPassword;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static support.World.forgotPassword;

public class forgotPassword {

    @Then("on login page verify Forgot Password is displayed on login page")
    public void onLoginPageVerifyForgotPasswordIsDisplayedOnLoginPage() {
        forgotPassword.verifyForgotPasswordOption();
    }

    @Then("on login page click forgot password and verify Forgot Your Password page contents")
    public void onLoginPageClickForgotPasswordAndVerifyForgotYourPasswordPageContents() {
        forgotPassword.verifyForgotYourPasswordPage();
    }

    @When("on login page click forgot password and enter the emailId & click on Reset button")
    public void onLoginPageClickForgotPasswordAndEnterTheEmailIdClickOnResetButton() {
        forgotPassword.verifyResetPassword();
    }

    @When("on forgot password page then enter the emailId & click on Reset button and verify clicking on Back to Login button")
    public void onForgotPasswordPageThenEnterTheEmailIdClickOnResetButtonAndVerifyClickingOnBackToLoginButton() {
        forgotPassword.verifyBackToLoginButton();
    }
}

