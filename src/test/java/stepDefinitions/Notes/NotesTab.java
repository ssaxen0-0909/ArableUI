package stepDefinitions.Notes;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.notesTab;


public class NotesTab {

    @When("on Map page click on site name and navigate to {string} page")
    public void onMapPageClickOnSiteNameAndNavigateToPage(String page) throws InterruptedException, IOException {
        notesTab.navigateToNotesPage(page);
    }

    @Then("click on notes tab and create a note for a {string} user.")
    public void clickOnNotesTabAndCreateANoteForAUser(String role) throws InterruptedException {
        notesTab.createNotes(role);
    }


    @Then("click on notes tab and delete a note for {string} user.")
    public void clickOnNotesTabAndDeleteANoteForUser(String role) throws InterruptedException {
        notesTab.deleteNote(role);
    }

    @Then("click on notes tab and create a note with past date for {string} user.")
    public void clickOnNotesTabAndCreateANoteWithPastDateForUser(String role) throws InterruptedException {
        notesTab.createNoteWithPastDate(role);
    }


    @Then("click on notes tab and click on view note for {string} user.")
    public void clickOnNotesTabAndClickOnViewNoteForUser(String role) throws InterruptedException {
        notesTab.viewNoteModal(role);
    }

    @Then("click on notes tab and click on view note and share for {string} user.")
    public void clickOnNotesTabAndClickOnViewNoteAndShareForUser(String role) throws InterruptedException {
        notesTab.shareNote(role);
    }

    @Then("click on notes tab and click on view note and share for multiple emails {string} user.")
    public void clickOnNotesTabAndClickOnViewNoteAndShareForMultipleEmailsUser(String role) throws InterruptedException {
        notesTab.shareNoteMultipleEmails(role);
    }

    @Then("click on notes tab and click on view note and share for invalid emailId {string} user.")
    public void clickOnNotesTabAndClickOnViewNoteAndShareForInvalidEmailIdUser(String role) throws InterruptedException {
        notesTab.invalidEmailInRecipient(role);
    }

    @Then("click on notes tab and click on view note and share for incomplete email id {string} user.")
    public void clickOnNotesTabAndClickOnViewNoteAndShareForIncompleteEmailIdUser(String role) throws InterruptedException {
        notesTab.incompleteEmailInRecipient(role);
    }

    @Then("click on notes tab and click on view note and click on cancel in share modal for {string} user.")
    public void clickOnNotesTabAndClickOnViewNoteAndClickOnCancelInShareModalForUser(String role) throws InterruptedException {
        notesTab.cancelBtnFunctionalityOnShareModal(role);
    }

    @Then("click on notes tab and click on view note and measurement units have decimal values for {string} user.")
    public void clickOnNotesTabAndClickOnViewNoteAndMeasurementUnitsHaveDecimalValuesForUser(String role) throws InterruptedException, IOException {
        notesTab.verifyTempValueDecimalPlace(role);
    }

    @Then("click on notes tab and click on view note and check for all measurements param for {string} user.")
    public void clickOnNotesTabAndClickOnViewNoteAndCheckForAllMeasurementsParamForUser(String role) throws InterruptedException, IOException {
        notesTab.verifyDataParamsInNoteViewModal(role);
    }
}