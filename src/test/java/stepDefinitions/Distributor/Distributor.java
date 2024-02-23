package stepDefinitions.Distributor;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.distributorPage;

public class Distributor {
    @When("clicked on settings icon and navigate to {string} page")
    public void clickedOnSettingsIconAndNavigateToPage(String page) throws IOException, InterruptedException {
        distributorPage.navigateToPage(page);
    }

    @Then("verify create new org button is displayed for {string} user")
    public void verifyCreateNewOrgButtonIsDisplayedForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyLandingOnDistributorPage(role);
    }

    @Then("verify Create new org modal for {string} user")
    public void verifyCreateNewOrgModalForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyCreateNewOrgModal(role);
    }

    @Then("click on assigned and verify modal info for {string} user")
    public void clickOnAssignedAndVerifyModalInfoForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyAssignedModalContents(role);
    }

    @Then("click on unassigned and verify modal info for {string} user")
    public void clickOnUnassignedAndVerifyModalInfoForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyUnassignedModalContents(role);
    }

    @Then("verify table column headers for {string} user")
    public void verifyTableColumnHeadersForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyColumnsHeaders(role);
    }

    @Then("click on plus icon and verify org details for {string} user")
    public void clickOnPlusIconAndVerifyOrgDetailsForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyOrgDetails(role);
    }

    @Then("click on plus icon and verify editing org name for {string} user")
    public void clickOnPlusIconAndVerifyEditingOrgNameForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyEditingOrgName(role);
    }

    @Then("click on assigned modal and verify search field for devices for {string} user")
    public void clickOnAssignedModalAndVerifySearchFieldForDevicesForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDevicesSearchBoxInAssignedModal(role);
    }

    @Then("click on unassigned modal and verify search field for devices for {string} user")
    public void clickOnUnassignedModalAndVerifySearchFieldForDevicesForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDevicesSearchBoxInUnassignedModal(role);
    }

    @Then("click on assigned modal and verify search functionality with three letters for devices for {string} user")
    public void clickOnAssignedModalAndVerifySearchFunctionalityWithThreeLettersForDevicesForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyPartialTextSearchInAssignedModal(role);
    }

    @Then("click on unassigned modal and verify search functionality with three letters for devices for {string} user")
    public void clickOnUnassignedModalAndVerifySearchFunctionalityWithThreeLettersForDevicesForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyPartialTextSearchInUnassignedModal(role);
    }

    @Then("click on assigned modal and verify search functionality for devices for {string} user")
    public void clickOnAssignedModalAndVerifySearchFunctionalityForDevicesForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDevicesSearchInAssignedModal(role);
    }

    @Then("click on unassigned modal and verify search functionality for devices for {string} user")
    public void clickOnUnassignedModalAndVerifySearchFunctionalityForDevicesForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDevicesSearchInUnassignedModal(role);
    }

    @Then("click on assigned modal and verify search functionality for devices is case sensitive for {string} user")
    public void clickOnAssignedModalAndVerifySearchFunctionalityForDevicesIsCaseSensitiveForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyCaseSensitiveTextSearchInAssignedModal(role);
    }

    @Then("click on unassigned modal and verify search functionality for devices is case sensitive for {string} user")
    public void clickOnUnassignedModalAndVerifySearchFunctionalityForDevicesIsCaseSensitiveForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyCaseSensitiveTextSearchInUnassignedModal(role);
    }

    @Then("click on assigned modal and verify searching invalid device id for {string} user")
    public void clickOnAssignedModalAndVerifySearchingInvalidDeviceIdForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyInvalidTextSearchInAssignedModal(role);
    }

    @Then("click on unassigned modal and verify searching invalid device id for {string} user")
    public void clickOnUnassignedModalAndVerifySearchingInvalidDeviceIdForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyInvalidTextSearchInUnassignedModal(role);
    }

    @Then("click on assigned modal and verify selected device is retaining after search for {string} user")
    public void clickOnAssignedModalAndVerifySelectedDeviceIsRetainingAfterSearchForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDeviceSelectionRetainedInAssignedModal(role);
    }

    @Then("click on unassigned modal and verify selected device is retaining after search for {string} user")
    public void clickOnUnassignedModalAndVerifySelectedDeviceIsRetainingAfterSearchForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDeviceSelectionRetainedInUnassignedModal(role);
    }

    @Then("click on assigned modal and verify device list for source org for {string} user")
    public void clickOnAssignedModalAndVerifyDeviceListForSourceOrgForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDevicesCountInAssignedModal(role);
    }

    @Then("click on unassigned modal and verify device list for source org for {string} user")
    public void clickOnUnassignedModalAndVerifyDeviceListForSourceOrgForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDevicesCountInUnassignedModal(role);
    }

    @Then("click on assigned modal and verify search error message for {string} user")
    public void clickOnAssignedModalAndVerifySearchErrorMessageForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifySearchErrorMessageInAssignedModal(role);
    }

    @Then("click on unassigned modal and verify search error message for {string} user")
    public void clickOnUnassignedModalAndVerifySearchErrorMessageForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifySearchErrorMessageInUnassignedModal(role);
    }

    @Then("click on unassigned modal and verify clearing search results for {string} user")
    public void clickOnUnassignedModalAndVerifyClearingSearchResultsForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyClearingSearchResultInUnassignedModal(role);
    }

    @Then("click on assigned modal and verify clearing search results for {string} user")
    public void clickOnAssignedModalAndVerifyClearingSearchResultsForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyClearingSearchResultInAssignedModal(role);
    }

    @Then("verify each org details in table for {string} user")
    public void verifyEachOrgDetailsInTableForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyOrgDetailsInRows(role);
    }

    @Then("click on plus icon and verify device list and scroll bar for {string} user")
    public void clickOnPlusIconAndVerifyDeviceListAndScrollBarForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDevicesListInOrg(role);
    }

    @Then("click on assigned modal and verify the scroll bar in device list for {string} user")
    public void clickOnAssignedModalAndVerifyTheScrollBarInDeviceListForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyScrollBarInAssignedModal(role);
    }

    @Then("click on unassigned modal and verify the scroll bar in device list for {string} user")
    public void clickOnUnassignedModalAndVerifyTheScrollBarInDeviceListForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyScrollBarInUnassignedModal(role);
    }

    @Then("click on create new org button & enter duplicate name and click on confirm button for {string} user")
    public void clickOnCreateNewOrgButtonEnterDuplicateNameAndClickOnConfirmButtonForUser(String role) throws IOException, InterruptedException {
        distributorPage.duplicateOrgName(role);
    }

    @Then("click on create new org button & enter name and clear it for {string} user")
    public void clickOnCreateNewOrgButtonEnterNameAndClearItForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyOrgNameInfoMessage(role);
    }

    @Then("click on create new org button & select the source org for {string} user")
    public void clickOnCreateNewOrgButtonSelectTheSourceOrgForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifySourceOrgList(role);
    }

    @Then("click on create new org button &enter the org name in capitals for {string} user")
    public void clickOnCreateNewOrgButtonEnterTheOrgNameInCapitalsForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyCapitalLetterInOrgName(role);
    }

    @Then("click on assigned modal and check the contents of source and destination for {string} user")
    public void clickOnAssignedModalAndCheckTheContentsOfSourceAndDestinationForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifySortingOfSourceDropdownInAssignedModal(role);
    }

    @Then("click on assigned modal and select source and destination and select device for {string} user")
    public void clickOnAssignedModalAndSelectSourceAndDestinationAndSelectDeviceForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyEnablingOfReturnBtnInAssignedModal(role);
    }

    @Then("click on unassigned modal and check the contents of source and destination for {string} user")
    public void clickOnUnassignedModalAndCheckTheContentsOfSourceAndDestinationForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifySortingOfSourceDropdownInUnassignedModal(role);
    }

    @Then("click on unassigned modal and select multiple devices for {string} user")
    public void clickOnUnassignedModalAndSelectMultipleDevicesForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyMultipleDeviceSelectionInAssignedModal(role);
    }

    @Then("click on unassigned modal and select device & then deselect it for {string} user")
    public void clickOnUnassignedModalAndSelectDeviceThenDeselectItForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDeSelectingDevicesInUnassignedModal(role);
    }

    @Then("click on unassigned modal and hover over Cancel btn for {string} user")
    public void clickOnUnassignedModalAndHoverOverCancelBtnForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyButtonsColorUnassignedModal(role);
    }

    @Then("click on assigned modal and hover over Cancel btn for {string} user")
    public void clickOnAssignedModalAndHoverOverCancelBtnForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyButtonsColorAssignedModal(role);
    }

    @Then("click on assigned modal and select device and click on return for {string} user")
    public void clickOnAssignedModalAndSelectDeviceAndClickOnReturnForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyReturnOfDevices(role);
    }

    @Then("click on unassigned modal and select device and click on assign for {string} user")
    public void clickOnUnassignedModalAndSelectDeviceAndClickOnAssignForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyAssignOfDevice(role);
    }

    @Then("click on assigned modal and select device and verify the devices count for {string} user")
    public void clickOnAssignedModalAndSelectDeviceAndVerifyTheDevicesCountForUser(String role) throws IOException, InterruptedException {
        distributorPage.verifyDevicesCountInBannerVSSourceOrg(role);
    }
}
