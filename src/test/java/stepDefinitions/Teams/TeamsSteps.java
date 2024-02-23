package stepDefinitions.Teams;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.teamsPage;

public class TeamsSteps {
    @When("navigate to {string}")
    public void navigateTo(String page) throws InterruptedException, IOException {
        teamsPage.navigateToPage(page);
    }

//    @Then("verify teams name are displayed and also update page load time in Excel for {string} user")
//    public void verifyTeamsNameAreDisplayedAndAlsoUpdatePageLoadTimeInExcelForUser(String role) throws IOException, InterruptedException {
//        teamsPage.captureTeamsPageLoadTime(role);
//    }

    @Then("verify if Administrators row is displayed for {string} user")
    public void verifyIfAdministratorsRowIsDisplayedForUser(String role) throws IOException {
        teamsPage.verifyAdministratorRow(role);
    }

    @Then("verify if Administrators row is not displaying Edit options for {string} user")
    public void verifyIfAdministratorsRowIsNotDisplayingEditOptionsForUser(String role) throws IOException {
        teamsPage.verifyNoEditOptionInAdministratorRow(role);
    }

    @Then("verify if new team is getting created,edited and deleted for {string} user")
    public void verifyIfNewTeamIsGettingCreatedEditedAndDeletedForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyCreateEditDeleteNewTeam(role);
    }

    @Then("verify if invite new members for {string} user")
    public void verifyIfInviteNewMembersForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyInviteNewMember(role);
    }

    @Then("verify if invite current members for {string} user")
    public void verifyIfInviteCurrentMembersForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyInviteCurrentMember(role);
    }

    @Then("verify edit team by adding and removing member for {string} user")
    public void verifyEditTeamByAddingAndRemovingMemberForUser(String role) throws IOException {
        teamsPage.verifyEditTeamsAddAndRemoveMember(role);
    }

    @Then("verify stats on switching orgs for {string} user")
    public void verifyStatsOnSwitchingOrgsForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyStatsOnOrgSwitch(role);
    }

    @Then("verify assigned team stats for {string} user")
    public void verifyAssignedTeamStatsForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyTeamStats(role);
    }

    @Then("verify unassigned sites modal feature for {string} user")
    public void verifyUnassignedSitesModalFeatureForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyUnassignedSitesFunctionality(role);
    }

    @Then("click on unassigned sites modal and verify confirm button state for {string} user")
    public void clickOnUnassignedSitesModalAndVerifyConfirmButtonStateForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyConfirmBtnState(role);
    }

    @Then("click on unassigned sites modal and verify title and description for {string} user")
    public void clickOnUnassignedSitesModalAndVerifyTitleAndDescriptionForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyUnassignedSitesModal(role);
    }

    @Then("click on assigned team modal and verify title and description for {string} user")
    public void clickOnAssignedTeamModalAndVerifyTitleAndDescriptionForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyAssignedTeamsModal(role);
    }

    @Then("click on unassigned team modal and verify title and description for {string} user")
    public void clickOnUnassignedTeamModalAndVerifyTitleAndDescriptionForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyUnassignedTeamsModal(role);
    }

    @Then("click on assigned members modal and verify title and description for {string} user")
    public void clickOnAssignedMembersModalAndVerifyTitleAndDescriptionForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyAssignedMembersModal(role);
    }

    @Then("click on unassigned members modal and verify title and description for {string} user")
    public void clickOnUnassignedMembersModalAndVerifyTitleAndDescriptionForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyUnassignedMembersModal(role);
    }

    @Then("click on assigned sites modal and verify title and description for {string} user")
    public void clickOnAssignedSitesModalAndVerifyTitleAndDescriptionForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyAssignedSitesModal(role);
    }

    @Then("click on Teams column and verify modal info for {string} user")
    public void clickOnTeamsColumnAndVerifyModalInfoForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyTeamsColumnModalInfo(role);
    }

    @Then("click on Members column and verify modal info for {string} user")
    public void clickOnMembersColumnAndVerifyModalInfoForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifyMembersColumnModalInfo(role);
    }

    @Then("click on Sites column and verify modal info for {string} user")
    public void clickOnSitesColumnAndVerifyModalInfoForUser(String role) throws IOException, InterruptedException {
        teamsPage.verifySitesColumnModalInfo(role);
    }

    @Then("click on assigned devices modal and verify title and description")
    public void clickOnAssignedDevicesModalAndVerifyTitleAndDescription() {
        teamsPage.verifyAssignedDevicesModal();
    }

    @Then("verify unassigned Devices modal feature opens if the count is not zero for {string}")
    public void verifyUnassignedDevicesModalFeatureOpensIfTheCountIsNotZeroFor(String userRole) {
        teamsPage.verifyUnassignedDevicesFunctionality(userRole);
    }

    @And("verify whether the teams dropdown gets opened for any device in unassigned modal for {string}")
    public void verifyWhetherTheTeamsDropdownGetsOpenedForAnyDeviceInUnassignedModalFor(String userRole) {
        teamsPage.verifyWhetherTheDropdownOpensForAnyOfTheDevices(userRole);
    }

    @Then("verify the stats api & banners count")
    public void verifyTheStatsApiBannersCount() {
        teamsPage.verifyApiCountInBannerBeforeSwitching();
    }

    @And("verify the Teams list shown on Teams page is matching with the Teams list shown in global Teams dropdown")
    public void verifyTheTeamsListShownOnTeamsPageIsMatchingWithTheTeamsListShownInGlobalTeamsDropdown() {
        teamsPage.verifyTeamsListInTeamsPage();
    }

    @And("click on view team shows edit button based on the user {string}")
    public void clickOnViewTeamShowsEditButtonBasedOnTheUser(String userRole) {
        teamsPage.verifyViewTeamInTeamPage(userRole);
    }

    @Then("click on edit team for any team based on {string}")
    public void clickOnEditTeamForAnyTeamBasedOn(String role) {
        teamsPage.verifyEditTeamAndObserve(role);
    }

    @Then("click on a edit member for {string}")
    public void clickOnAEditMemberFor(String role) {
        teamsPage.verifyEditMemberInViewTeamPage(role);
    }

    @Then("click on confirm button for Edit Team in the open modal to verify the number of times API is called for user {string}")
    public void clickOnConfirmButtonForEditTeamInTheOpenModalToVerifyTheNumberOfTimesAPIIsCalledForUser(String role) {
        teamsPage.clickOnConfirmBtnOnEditTeamModalAndObserve(role);
    }

    @Then("click on confirm button for Edit member in the open modal to verify the number of times API is called for user {string}")
    public void clickOnConfirmButtonForInTheOpenModalToVerifyTheNumberOfTimesAPIIsCalledForUser(String role) {
        teamsPage.clickOnConfirmBtnOnEditMemberModalAndObserve(role);
    }

    @Then("verify the stats api & banner counts before switching the organization")
    public void verifyTheStatsApiBannerCountsBeforeSwitchingTheOrganization() {
        teamsPage.verifyApiCountInBannerBeforeSwitching();
    }

    @And("click on org dropdown and Switch to different organization")
    public void clickOnOrgDropdownAndSwitchToDifferentOrganization() {
        teamsPage.verifyOrganizationDropdown();
    }

    @Then("verify the count in Banners & in stats api call with respect to orgName")
    public void verifyTheCountInBannersInStatsApiCallWithRespectToOrgName() {
        teamsPage.verifyApiCountAfterSwitchingOrganization();
    }

    @And("verify the stats api & banner counts before switching the team")
    public void verifyTheStatsApiBannerCountsBeforeSwitchingAndTeam() {
        teamsPage.verifyApiCountInBannerBeforeSwitching();
    }

    @And("click on Teams dropdown and Switch for different team")
    public void clickOnTeamsDropdownAndSwitchToForDifferentTeam() {
        teamsPage.verifyTeamsDropdown();
    }

    @Then("verify the count in Banners & in stats api call with respect to team")
    public void verifyTheCountInBannersInStatsApiCallWithRespectToTeam() {
        teamsPage.verifyApiCountInBannerAfterSwitching();
    }

    @Then("verify teams shown in dropdown is matching with the teams list shown on Teams page for {string}")
    public void verifyTeamsShownInDropdownIsMatchingWithTheTeamsListShownOnTeamsPageFor(String userRole) {
        teamsPage.verifyTeamsInBothDropDownAndList(userRole);
    }

    @And("verify whether the device shown inside the team in which it was added for team for {string}")
    public void verifyWhetherTheDeviceShownInsideTheTeamInWhichItWasAddedForTeamFor(String userRole) {
        teamsPage.verifyDeviceInTeam(userRole);
    }

    @Then("verify the banner count has changed for Assigned & Unassigned after selecting the team for a device for {string}")
    public void verifyTheBannerCountHasChangedForAssignedUnassignedAfterSelectingTheTeamForADeviceFor(String userRole) {
        teamsPage.verifyDeviceCountInBanner(userRole);
    }

    @And("verify the stats api count is matching with the device banner count for {string}")
    public void verifyTheStatsApiCountIsMatchingWithTheDeviceBannerCountFor(String userRole) {
        teamsPage.verifyApiCountInDeviceBanner(userRole);
    }

    @And("verify whether the device is showing under unassigned modal after removing from the team which was selected earlier for {string}")
    public void verifyWhetherTheDeviceIsShowingUnderUnassignedModalAfterRemovingFromTheTeamWhichWasSelectedEarlierFor(String userRole) throws InterruptedException {
        teamsPage.verifyRemovedDeviceInUnassignedModal(userRole);
    }

    @Then("verify the banner count has changed for Assigned & Unassigned after removing the device from the team for {string}")
    public void verifyTheBannerCountHasChangedForAssignedUnassignedAfterRemovingTheDeviceFromTheTeamFor(String userRole) {
        teamsPage.verifyBannerCountAfterRemovingDeviceFromTeam(userRole);
    }

    @And("click on unassigned devices modal and verify title and description for {string}")
    public void clickOnUnassignedDevicesModalAndVerifyTitleAndDescriptionFor(String userRole) {
        teamsPage.verifyUnassignedDevicesModal(userRole);
    }

    //

    @Then("verify that on landing on the Teams page three API calls stats, teams, and users should be called and shown in the network tab")
    public void verifyThatOnLandingOnTheTeamsPageThreeAPICallsStatsTeamsAndUsersShouldBeCalledAndShownInTheNetworkTab() {
        teamsPage.verifyingApiInNetworkTab();
    }

    @And("click on Create New Team button for the role{string}")
    public void clickOnCreateNewTeamButtonForThe(String role) {
        teamsPage.clickOnCreateNewBtn(role);
    }

    @When("enter the details of team {string} in the Create New Team popup page for the role {string}")
    public void enterTheDetailsInTheCreateNewTeamPopupPage(String teamNumber, String userRole) {
        teamsPage.newTeamCreation(teamNumber, userRole);
    }

    @Then("click on the confirm button in the Create New Team page for the role {string}")
    public void clickOnTheConfirmButtonInTheCreateNewTeamPageForTheRole(String userRole) {
        teamsPage.verifyingNewTeamHasCreated(userRole);
    }

    @And("verify the api in teams page for the role {string}")
    public void verifyTheApiInTeamsPageForTheRole(String userRole) {
        teamsPage.apiVerificationTeamsPage(userRole);
    }

    @Then("click on View Teams of newly created team {string} for the role {string}")
    public void clickOnViewTeamsOfNewlyCreatedTeamForTheRole(String teamNumber, String userRole) {
        teamsPage.verifyTeamInTheTeamListForEditRole(teamNumber, userRole);
    }

    @Then("verify the data in the newly created team is correct for the role {string}")
    public void verifyTheDataInTheNewlyCreatedTeamIsCorrectForTheRole(String userRole) {
        teamsPage.verifyDataInNewCreatedTeam(userRole);
    }

    @Then("edit the team name for the role {string}")
    public void editTheTeamNameForTheRole(String userRole) {
        teamsPage.editTeamName(userRole);
    }

    @Then("navigate to the tags shown below the Add members, Add devices, Add sites and click on cross button for one in each options for the role {string}")
    public void navigateToTheTagsShownBelowTheAddMembersAddDevicesAddSitesAndClickOnCrossButtonForOneInEachOptionsForTheRole(String userRole) {
        teamsPage.verifyEditOptionInTheEditTeamPage(userRole);
    }

    @And("verify confirmation toast message for the role {string}")
    public void verifyConfirmationToastMessageForTheRole(String userRole) {
        teamsPage.verifyConfirmationToastMessageForTeamNameUpdate(userRole);
    }

    @And("verify that after clicking on the confirm button the old teamName should not display on the team list for the role {string}")
    public void verifyThatAfterClickingOnTheConfirmButtonTheOldTeamNameShouldNotDisplayOnTheTeamListForTheRole(String userRole) {
        teamsPage.verifyOldTeamNameNotPresent(userRole);
    }

    @When("click on View Teams on the edited Team name for the role {string}")
    public void clickOnViewTeamsOnTheEditedTeamNameForTheRole(String userRole) {
        teamsPage.verifyEditedTeamName(userRole);
    }

    @And("verify the modified data for the role {string}")
    public void verifyTheModifiedDataForTheRole(String userRole) {
        teamsPage.verifyTheModifiedData(userRole);
    }

    @Then("verify the number displayed in the teams page matches the actual count for the role {string}")
    public void verifyTheNumberDisplayedInTheTeamsPageMatchesTheActualCountForTheRole(String userRole) {
        teamsPage.verifyCount(userRole);
    }

    @Then("click on Invite Member button for the {string}")
    public void clickOnInviteMemberButtonForThe(String userRole) {
        teamsPage.inviteTeamMember(userRole);
    }

    @When("the modal is open, fill in the data in all fields, including email ID {string}, and select team {string} and team {string} for the role {string}")
    public void theModalIsOpenFillInTheDataInAllFieldsIncludingEmailIDAndSelectTeamAndTeamForTheRole(String emailNumber, String team1, String team2, String userRole) {
        teamsPage.fillAllFieldInInviteMember(emailNumber, team1, team2, userRole);
    }

    @Then("verify whether the new invitations were sent to the user or not for role {string}")
    public void verifyWhetherTheNewInvitationsWereSentToTheUserOrNotForRole(String userRole) {
        teamsPage.verifyInvitationsSentToTheUserOrNot(userRole);
    }

    @And("verify Sent modal should appear with all the details and also with two options Yes & No for role {string}")
    public void verifySentModalShouldAppearWithAllTheDetailsAndAlsoWithTwoOptionsYesNoForRole(String userRole) {
        teamsPage.checkSendModal(userRole);
    }

    @And("verify {string} invite option for the role {string}")
    public void verifyInviteOptionForTheRole(String option, String userRole) {
        teamsPage.verifyingInviteOptions(option, userRole);
    }

    @And("verify the Pending Invites for new user email ID {string} in the team {string} and team {string} for the role {string}")
    public void verifyThePendingInvitesForNewUserEmailIDInTheTeamAndTeamForTheRole(String emailNumber, String team1, String team2, String userRole) {
        teamsPage.verifyTeamInTheTeamList(team1, userRole);
        teamsPage.verifyThePendingInvites(emailNumber, userRole);
        teamsPage.verifyTeamInTheTeamList(team2, userRole);
        teamsPage.verifyThePendingInvites(emailNumber, userRole);
    }


    @And("switch the tab to Current. Once the modal opens, fill in the details in all the fields, member {string} and select role,team {string} and team {string} for the role {string}")
    public void switchTheTabToCurrentOnceTheModalOpensFillInTheDetailsInAllTheFieldsMemberAndSelectRoleTeamAndTeamForTheRole(String memberNumber, String team1, String team2, String userRole) {
        teamsPage.verifyingCurrentTab(memberNumber, team1, team2, userRole);
    }

    @And("verify the pending invites for the current user for member{string} in the team{string} and team{string} for the role {string}")
    public void verifyThePendingInvitesForTheCurrentUserForMemberInTheTeamAndTeamForTheRole(String memberNumber, String team1Number, String team2Number, String userRole) {
        teamsPage.verifyTeamInTheTeamList(team1Number, userRole);
        teamsPage.verifyTheCurrentPendingInvites(userRole);
        teamsPage.verifyTheTag(memberNumber, userRole);
        teamsPage.verifyTeamInTheTeamList(team2Number, userRole);
        teamsPage.verifyTheCurrentPendingInvites(userRole);
//        teamsPage.verifyTheTag(memberNumber, userRole);
        teamsPage.verifyTheTagAndDeletedTheMember(memberNumber, userRole);
    }

    @Then("verify that the user can click on the Edit Role icon for the role {string}")
    public void verifyThatTheUserCanClickOnTheEditRoleIconForTheRole(String userRole) {
        teamsPage.editMemberRole(userRole);
    }

    @And("verify the pop-up message when user selects more than five teams and also select team {string} for the {string}")
    public void verifyThePopUpMessageWhenUserSelectsMoreThanFiveTeamsAndAlsoSelectTeamForThe(String teamNumber, String userRole) {
        teamsPage.selectMultipleTeams(teamNumber, userRole);
    }

    @Then("verify that the add teams option is displayed or not for the role {string}")
    public void verifyThatTheAddTeamsOptionIsDisplayedOrNotForTheRole(String userRole) {
        teamsPage.checkAddTeamsOption(userRole);
    }

    @And("verify confirmation toast message after modifying member for the role {string}")
    public void verifyConfirmationToastMessageAfterModifyingMemberForTheRole(String userRole) {
        teamsPage.verifyConfirmationToastMessageAfterMemberModification(userRole);
    }

    @When("navigate to the team {string} for the role {string}")
    public void navigateToTheTeamForTheRole(String teamNumber, String userRole) {
        teamsPage.verifyTeamNameInTheTeamListAfterEditRole(teamNumber, userRole);
    }

    @Then("verify the new role should reflect for the user for the role {string}")
    public void verifyTheNewRoleShouldReflectForTheUserForTheRole(String userRole) {
        teamsPage.newRoleReflected(userRole);
    }

    @Then("click on Pending Invites in view team for {string}")
    public void clickOnPendingInvitesInViewTeamFor(String userRole) {
        teamsPage.verifyPendingInvitesSelection(userRole);
    }
}
