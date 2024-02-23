package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.Constants;
import support.PropertiesReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static support.Constants.userRoleM;
import static support.PropertiesReader.orgTargeted;
import static support.World.*;


public class TeamsPage {

    private static final Logger log = LogManager.getLogger(TeamsPage.class);
    public static String namePostEdit = "";
    public static String newTeamName1 = "";
    public static String newTeamName2 = "";
    public static String newTeamName3 = "";
    public static String emailAddress = "";
    public static String emailAddress1 = "";
    public static String emailAddress2 = "";
    public static String selectMember = "";
    public static String member1 = "Bharathh@ Stag";
    public static String member2 = "chidambar stag";
    public static String teamAdminName = "vishal Teamadmin";
    public static String stagFirstName = "StagTeam";
    public static String stagLastName = "Testing";
    public static String stagEmailId1 = "StagTeam1@stagtestingmail.com";
    public static String stagEmailId2 = "StagTeam2@stagtestingmail.com";
    public static String editedTeamName;
    static List<String> copyAddMembers;
    static List<String> copyAddSites;
    static List<String> copyAddDevices;
    static List<String> removedMemberName;
    static List<String> removedSitesName;
    static List<String> devicesRemovedInEditingTeam;
    static List<String> listToCheckTheSites;
    static List<String> listStoredName;
    static List<String> listOfSelectedTeams;
    private final WebDriver driver;
    public String teamName = "1Automation";
    public String firstName = "testAutomation";
    public String lastName = "Web";
    public String newEmail = "testAutomation@arable.com";
//    public String currentEmail = "pramitha.lobo@arable.com";
//    Not in use anywhere, use the mail -  vishal.gupta@arable.com if needed in the above's place
    public int unassignedDeviceCountBeforAssigning;
    public int assignedDeviceCountBeforAssigning;
    public String titleName;
    public int deviceSize;
    public String firstDeviceDropdownText;
    public int unassignedDeviceCountAfterAssigning;
    public int assignedDeviceCountAfterAssigning;
    public String orgNameAfterSwitching;
    public String teamNameSelectedInDropdown;
    public int organizationCount;
    public String teamNameStored;
    public int indexOfSites;
    public int teamSitesL;
    public int nameViewTeamCopy;

    public String teamName2 = "1Automation";
    public String member1NotInAnyTeam = "chiranjib stagg";
    public String member2NotInAnyTeam = "chidambar stag";
    public String addMemberName;
    public String teamNameInEditRole;
    List<String> bannerCountsBeforeSwitching = new ArrayList<>();
    List<String> teamsDropDownList = new ArrayList<>();
    Set<String> deviceNameSet = new HashSet<>();
    @FindBy(xpath = "//p[normalize-space()='Administrators']")
    WebElement teamsFirstRow_orgReader;
    @FindBy(xpath = "(//div[@class='grid body-list team-row non-expanded'])[1]")
    WebElement teams_AdministratorsRow;
    @FindBy(xpath = "//span[normalize-space()='Create New Team']")
    WebElement createNewTeamBtnF;
    @FindBy(xpath = "//div[@class='tooltip-team']//div[@class='content-modal']//div[@class='input-check']//input")
    WebElement teamNameTextF;
    //    @FindBy(xpath = "//arable-dropdown-selector[@ng-reflect-show-error='false']//span[@class='caret 0']")
//    private WebElement selectRoleDropdownOpen_EditMemberF;
//    @FindBy(xpath = "//div[@class='dropdown-selector 0 open']//p[contains(text(),'Member')]")
//    private WebElement selectRoleMember_EditMemberF;
    @FindBy(xpath = "//div[@class='column name']//p[contains(text(),'1Automation')]")
    WebElement teamNameF;
    @FindBy(xpath = "//div[@class='column edit-member']//img[@alt='edit']")
    WebElement editMemberF;
    @FindBy(xpath = "//label[text()='Select Role']//..//p[@class='iconEnabled']")
    List<WebElement> roleDropDownMember;
    @FindBy(xpath = "//label[text()='Select Role']//..//div[@class='0 dropdown-selector open']//div//p[@class='iconEnabled']")
    List<WebElement> roleDropDownCurrent;
    @FindBy(xpath = "(//div[@class='row'])[4]//div[@class='options']//label[contains(@class,'item-text')]")
    List<WebElement> teamDropDownMember;
    @FindBy(xpath = "//div[@class='content-list']//div[@class='column col-email']")
    List<WebElement> pendingInvitesEmail;
    @FindBy(xpath = "//div[@class='container-teams']//label[contains(@class,'item-text')]")
    List<WebElement> teamDropDownMemberForCurrent;
    @FindBy(xpath = "//div[@class='column col-delete']")
    List<WebElement> deleteOption;
    @FindBy(xpath = "//div[@class='content-list']//div//div[@class='column col-name']")
    List<WebElement> listOfNameInPendingInvites;
    @FindBy(xpath = "//label[@class='item-text checked']")
    List<WebElement> editMemberSelectTeam;
    @FindBy(css = "//div[@class='grid body-list team-row non-expanded'][1]")
    private WebElement teamsFirstRow;
    @FindBy(xpath = "(//div[@class='clickable'][normalize-space()='View Team'])[1]")
    private WebElement viewTeam_Administrators;
    @FindBy(xpath = "//div[@class='container-detail']")
    private WebElement viewTeamDetails_Administrators;
    @FindBy(xpath = "(//div[@class='clickable'][normalize-space()='View Team'])[2]")
    private WebElement teamsSecondRow_orgAdmin;
    @FindBy(xpath = "//div[contains(text(),'Edit Team')]")
    private WebElement editTeam;
    @FindBy(xpath = "(//h2[normalize-space()='Team Members Information']")
    private WebElement teamMembersInformation;
    @FindBy(xpath = "//div[@class='tooltip-team']//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement confirmBtn;
    //    @FindBy(xpath = "//div[@class='success toast']")
//    private WebElement successMsg;
    @FindBy(xpath = "//p[normalize-space()='Settings']")
    private WebElement dashboardMenu_Settings;
    @FindBy(xpath = "//p[normalize-space()='Teams']")
    private WebElement dashboardMenu_Teams;
    @FindAll(@FindBy(xpath = "(//div[@class='grid body-list team-row non-expanded'])"))
    private List<WebElement> teams_Row;
    //    @FindBy(xpath = "//arable-dropdown-selector[@ng-reflect-title='Select Team Members']//span[@class='caret 0']")
//    private WebElement addRemoveMembersDropdownOpenB;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='0 grid grid-center headers']")
    private WebElement dropdownCloseB;
    @FindBy(xpath = "(//div[@class='grid grid-center option item checkbox-right'])[1]")
    private WebElement addMembersCheckbox;
    @FindBy(xpath = "//p[normalize-space()='Select Team Members']")
    private WebElement selectMemberTitle;
    @FindBy(xpath = "//arable-dropdown-selector[@ng-reflect-title='Select Sites']//span[@class='0 caret']")
    private WebElement addSitesDropdownOpenB;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[1]//label[1]")
    private WebElement addSitesCheckbox;
    @FindBy(xpath = "//arable-dropdown-selector[@ng-reflect-title='Select Device or Locations']//span[@class='0 caret']")
    private WebElement addDeviceDropdownOpenB;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[1]//label[1]")
    private WebElement addDeviceCheckbox;
    @FindBy(xpath = "//div[@class='tooltip-team']//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement confirmBtb_createTeam;
    @FindBy(xpath = "//div[@class='success toast']")
    private WebElement createTeam_successToast;
    //    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[2]//label")
//    private WebElement createTeam_addMemberList;
    @FindBy(xpath = "//img[@alt='success']")
    private WebElement createTeam_teamNameSuccess;
    //    @FindBy(xpath = "//p[@class='selected 1']")
//    private WebElement globalOrgSelected_MapPage;
    @FindBy(xpath = "//span[@class='1 caret']")
    private WebElement globalOrgDropdownBtn_MapPage;
    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//input[@type='search']")
    private WebElement globalOrgDropdownSearch_MapPage;
    @FindBy(xpath = "//p[normalize-space()='arable-team']")
    private WebElement globalOrgSearchSuggestion_MapPage;
    @FindBy(xpath = "(//div[@class='site-summary-card grid clickable'])[1]")
    private WebElement MapPage_SiteF;
    @FindBy(xpath = "//div[@class='action remove']")
    private WebElement deleteTeamF;
    @FindBy(xpath = "//div[@class='modal fade in show']//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement confirmBtnF;
    @FindBy(xpath = "//button[normalize-space()='Yes, delete team']")
    private WebElement yesDeleteTeamButtonF;
    @FindBy(xpath = "//button[normalize-space()='Yes, remove member']")
    private WebElement yesDeleteMemberButtonF;
    @FindBy(xpath = "//h3[normalize-space()='Success']")
    private WebElement successTeamDeleteToastF;
    @FindBy(xpath = "//img[@src='/img/icons/delete.svg']")
    private WebElement deleteMemberF;
    @FindBy(xpath = "//div[@class='body']")
    private WebElement successToast_DeleteMemberF;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='content-info']")
    private WebElement editMemberModalF;
    @FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown teams']//div[@class='0 grid grid-center headers']//span[@class='0 caret']")
    private WebElement selectTeamDropdownOpen_EditMemberF;
    @FindBy(xpath = "(//div[@class='grid grid-center option item'])[1]")
    private WebElement selectTeamList_EditMemberF;
    @FindBy(xpath = "//button[@class='btn-action confirm add']")
    private WebElement addButton_EditMemberF;
    @FindBy(xpath = "//arable-box-tag[2]//div[1]")
    private WebElement addedDetailsTag_EditMemberF;
    @FindBy(xpath = "//span[normalize-space()='Invite Member']")
    private WebElement inviteMemberF;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='tooltip-info']")
    private WebElement inviteMemberModalF;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement inviteMemberFirstNameF;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement inviteMemberLastNameF;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement inviteMemberEmailF;
    @FindBy(xpath = "//arable-dropdown-selector[@title='Select Role']//span[@class='0 caret']")
    private WebElement inviteMemberRoleDropdownOpenF;
    @FindBy(xpath = "//div[@class='column teams']//div[@class='options']//div[2]//label[2]")
    private WebElement inviteMember_SelectTeamF;
    @FindBy(xpath = "//div[@class='box-items']")
    private WebElement inviteMember_TagF;
    @FindBy(xpath = "//div[@class='actions']//button[contains(text(),'No, I’m done')]")
    private WebElement inviteAnotherMember_NoOptionF;
    @FindBy(xpath = "//div[@class='pending-invites-button']")
    private WebElement inviteMember_PendingInviteButtonF;
    @FindBy(xpath = "//div[@class='teams-table']/div[@class='teams-list']/div[2]/div[1]")
    private WebElement secondRow_TeamName_TeamPageF;
    @FindBy(xpath = "//div[@class='content-list']")
    private WebElement pendingInvite_modalF;
    @FindBy(xpath = "//img[@alt='delete']")
    private WebElement pendingInvite_deleteF;
    @FindBy(xpath = "//body//arable-app//arable-toast//h3[1]")
    private WebElement pendingInvite_successfullyDeletedF;
    @FindBy(xpath = "//div[@class='msg-data']")
    private WebElement noPendingInviteTextF;
    @FindBy(xpath = "//div[@class='tooltip-pending-invites']//button[@class='btn-action close'][normalize-space()='Cancel']")
    private WebElement PendingInviteModal_CancelBtnF;
    @FindBy(xpath = "//div[@class='teams-org-selector']")
    private WebElement TeamsCreateAndInviteOptionsF;
    @FindBy(xpath = "//div[contains(text(),'Current')]")
    private WebElement inviteMember_CurrentTabF;
    @FindBy(xpath = "//arable-dropdown-selector[@title='Select Member']//span[@class='0 caret']")
    private WebElement inviteMember_CurrentTab_MemberDropdownF;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//p")
    private WebElement inviteMember_CurrentTab_MemberListF;
    @FindBy(xpath = "//p[normalize-space()='akijdsoiasdjo aoijjidjsaof']")
    private WebElement inviteMember_CurrentTab_MemberF;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']/div[@class='options']/div[1]")
    private WebElement inviteMember_CurrentTab_TeamF;
    @FindBy(xpath = "//arable-dropdown-selector[@ng-reflect-checked-items='[object Object],[object Object']//span[@class='0 caret']")
    private WebElement editTeam_addMemberDropdownOpenF;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']/div[@class='options']/div[1]")
    private WebElement editTeam_addMemberListF;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//span[@class='0 caret']")
    private WebElement editTeam_addMemberDropDownCloseF;
    @FindBy(xpath = "//arable-box-tag[3]//div[1]//button[1]")
    private WebElement editTeam_removeMemberCrossBtnF;
    @FindBy(xpath = "//div[@class='selected-team-member-list box-container']/arable-box-tag[3]/div[1]")
    private WebElement editTeam_removeLastMember_NameF;
    @FindBy(xpath = "//div[@class='selected-team-member-list box-container']")
    private WebElement editTeam_addedMemberListBoxF;
    @FindBy(xpath = "//div[@class='grid body-list team-row']")
    private WebElement secondTeamRowF;
    @FindBy(xpath = "//div[@class='teams-header']")
    private WebElement teamStatsF;
    //    @FindBy(xpath = "//div[@class='dropdown-selector 1 open']//div[@class='grid grid-center option']")
//    private WebElement orgDropdown_orgList;
    @FindAll(@FindBy(xpath = "//div[@class='teams-table']/div[@class='teams-list']/div"))
    private List<WebElement> teamTableRowsF;
    @FindBy(xpath = "(//div[@class='state-item'])[1]//span[@class='stat-number']")
    private WebElement teamsAssignedStatsCount;
    @FindBy(xpath = "(//div[@class='state-item'])[2]//span[@class='stat-number']")
    private WebElement teamsUnassignedStatsCount;
    //-----------------new xpath after angular merge
    @FindBy(xpath = "//p[@class='1 selected']")
    private WebElement globalOrgSelected_MapPage;
    @FindBy(xpath = "//arable-dropdown-selector[@ng-reflect-title='Select Team Members']//span[@class='0 caret']")
    private WebElement addRemoveMembersDropdownOpenB;
    //    @FindBy(xpath = "(//div[@class='grid grid-center option item checkbox-right'])[1]")
//    private WebElement createTeam_addMemberList;
    @FindBy(xpath = "//arable-dropdown-selector[@ng-reflect-title='Select role from dropdown']//span[@class='0 caret']")
    private WebElement selectRoleDropdownOpen_EditMemberF;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//p[contains(text(),'Member')]")
    private WebElement selectRoleMember_EditMemberF;
    @FindBy(xpath = "(//div[@class='1 dropdown-selector open']//div[@class='options']//p)[2]")
    private WebElement orgDropdown_orgList;
    @FindBy(xpath = "(//span[contains(text(),'Unassigned')])[3]")
    private WebElement unassignedSitesTitle;
    @FindBy(xpath = "(//span[@class='stat-number'])[6]")
    private WebElement unassignedSitesCount;
    @FindBy(xpath = "(//span[@class='stat-number'])[5]")
    private WebElement assignedSitesCount;
    @FindBy(xpath = "(//div[@class='form-section'])[1]")
    private WebElement unassignedSitesModalDropdown;
    @FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']//div[1]//h3[1]")
    private WebElement unassignedSitesModal1stSite;
    @FindBy(xpath = "(//div[@class='options'])[3]")
    private List<WebElement> dropdownSiteOptions;
    @FindBy(xpath = "//h3[normalize-space()='An error has ocurred assigning devices']")
    private WebElement unassignedSitesError;
    @FindBy(xpath = "//div[@class='success toast']")
    private WebElement unassignedSitesSuccess;
    @FindBy(xpath = "(//div[@class='action-buttons'])[1]//button[@class='btn-action confirm disabled'][normalize-space()='Confirm']")
    private WebElement disabledConfirmBtn;
    @FindBy(xpath = "//div[@class='tooltip-unassigned-devices']//div[@class='head-tooltip']")
    private WebElement unassignedSitesModalTitle;
    @FindBy(xpath = "(//span[contains(text(),'Assigned')])[1]")
    private WebElement assignedTeamsModal;
    @FindBy(xpath = "(//span[contains(text(),'Unassigned')])[1]")
    private WebElement unassignedTeamsModal;
    @FindBy(xpath = "(//span[contains(text(),'Assigned')])[2]")
    private WebElement assignedMembersModal;
    @FindBy(xpath = "(//span[contains(text(),'Unassigned')])[2]")
    private WebElement unassignedMembersModal;
    @FindBy(xpath = "(//span[contains(text(),'Assigned')])[3]")
    private WebElement assignedSitesModal;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='head-tooltip']")
    private WebElement modalHeader;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='action-buttons']")
    private WebElement modalsActionButtons;
    @FindBy(xpath = "//div[@class='dict-empty']")
    private WebElement modalNoDataMsg;
    @FindBy(xpath = "//button[@class='btn-action confirm disabled'][normalize-space()='Save as PDF']")
    private WebElement disableSavePdfBtn;
    @FindBy(xpath = "(//span[@class='stat-number'])[1]")
    private WebElement assignedTeamsCount;
    @FindBy(xpath = "(//span[@class='stat-number'])[2]")
    private WebElement unassignedTeamsCount;
    @FindBy(xpath = "(//span[@class='stat-number'])[3]")
    private WebElement assignedMembersCount;
    @FindBy(xpath = "(//span[@class='stat-number'])[4]")
    private WebElement unassignedMembersCount;
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    private WebElement modalCloseBtn;
    @FindBy(xpath = "//div[@class='teams-modal-dictionary']//div[@class='text-info']")
    private WebElement ModalDescription;
    @FindBy(xpath = "//div[@class='column name']//div[@class='container-text']")
    private WebElement teamsColumn;
    @FindBy(xpath = "//div[@class='info-modal']//div[@class='text-info']")
    private WebElement columnInfoModalDescription;
    @FindBy(xpath = "//div[@class='column clickable members members-when-sites']//div[@class='container-text']")
    private WebElement membersColumn;
    @FindBy(xpath = "//div[@class='column clickable sites']//div[@class='container-text']")
    private WebElement sitesColumn;
    @FindBy(xpath = "//div[@class='selected-device-list']//div/p")
    private List<WebElement> deviceSelectedForTeam;
    @FindBy(xpath = "//div[@class='tooltip-unassigned-devices']//button[@class='btn-action close']")
    private WebElement cancelBtnInUnassignedDeviceModal;
    @FindBy(xpath = "//div[@class='selected-device-list']//div//button[@class='btn-delete']")
    private List<WebElement> devicesCancelBtnForTeam;
    @FindBy(xpath = "//button[text()=' Confirm ']")
    private WebElement confirmButton;
    @FindBy(xpath = "//div[@class='devices-list']//div[@class='grid body-list']//div[@class='column']")
    private WebElement deviceNameInUnassignedList;
    @FindBy(xpath = "(//div[@class='modal-content tooltip-content'])[3]")
    private WebElement unassignedDeviceModal;
    @FindBy(xpath = "(//div[@class='column-auto']//span)[3]")
    private WebElement unassignedFirstDevicesDropDown;
    @FindBy(xpath = "//arable-toast//div[@class='toast-container']//div[@class='success toast']//div[@class='body']/h3")
    private WebElement unassignedDevicesSuccess;
    @FindBy(xpath = "(//div[@class='tooltip-unassigned-devices']//div[@class='content-modal']//div[@class='device-section']/h3)[1]")
    private WebElement firstDeviceText;
    @FindBy(xpath = "(//div[@class='column-auto']//span)[1]")
    private WebElement organizationDropdown;
    @FindBy(xpath = "(//div[text()='Organization']//..//following-sibling::div//following-sibling::div)[2]//following-sibling::p")
    private List<WebElement> organizationDropdownList;
    @FindBy(xpath = "(//div[@class='tooltip-info']//button[@class='btn-action confirm'])[1]")
    private WebElement confirmBtnInEditMember;
    @FindBy(xpath = "//div[@class='teams-list']/div[@class='grid body-list team-row non-expanded']/div[@class='column name']/p")
    private List<WebElement> teamsNameInPages;
    @FindBy(xpath = "//div[@class='column member-name']//p")
    private List<WebElement> teamMembersList;
    @FindBy(xpath = "//div[@class='column edit-member']//div[@class='clickable']")
    private List<WebElement> editMemberList;
    @FindBy(xpath = "(//div[@class='tooltip-info']/div/h1)[2]")
    private WebElement editMemberTitle;
    @FindBy(xpath = "//div[text()='View Team']")
    private List<WebElement> view;
    @FindBy(xpath = "(//div[@class='action-buttons']/button[text()='Confirm'])[5]")
    private WebElement confirmBtnInEditTeam;
    @FindBy(xpath = "(//div[@class='column-auto']//span)[2]")
    private WebElement teamsDropdown;
    @FindBy(xpath = "(//div[@class='column']/p)[1]")
    private WebElement selectedOrgName;
    @FindBy(xpath = "//div[@class='team-selector']//following-sibling::div[@class='options']//following-sibling::div[@class='grid grid-center option']//div//following-sibling::p")
    private List<WebElement> teamsDropdownList;
    @FindBy(xpath = "//div/arable-teams-table/div[@class='teams-table']/div[@class='teams-list']/div[@class='grid body-list team-row non-expanded']/div[@class='column name']//p")
    private List<WebElement> teamsNames;
    @FindBy(xpath = "//div[text()='Hide Team']")
    private WebElement hideTeam;
    @FindBy(xpath = "(//span[text()='Unassigned'])[3]")
    private WebElement unassignedBanner;
    @FindBy(xpath = "//div[@class='tooltip-unassigned-devices']")
    private WebElement unassignedDeviceMOdal;
    @FindBy(xpath = "//div[@class='device-section']//div[@class='container-dropdown-teams']//div//span")
    private List<WebElement> unassignedDeviceDropdownIcon;
    @FindBy(xpath = "(//div[@class='device-section']//div[@class='form-section'])[1]//div[@class='options']//div//p")
    private List<WebElement> teamsList;
    @FindBy(xpath = "(//span[@class='stat-number'])[6]")
    private WebElement unassignedDevicesCount;
    @FindBy(xpath = "(//span[@class='stat-number'])[7]")
    private WebElement assignedSiteCount;
    @FindBy(xpath = "(//span[@class='stat-number'])[8]")
    private WebElement unassignedSiteCount;
    @FindBy(xpath = "(//span[@class='stat-number'])[5]")
    private WebElement assignedDevicesCount;
    @FindBy(xpath = "(//span[@class='fancy-link text-assigned'])[3]")
    private WebElement assignedBanner;
    @FindBy(xpath = "(//h1[text()='Assigned Devices'])[1]")
    private WebElement assignedModalHeader;
    @FindBy(xpath = "(//div[@class='text-info']//p)[1]")
    private WebElement assignedModalDescription;
    @FindBy(xpath = "//div[@class='device-section']/h3")
    private List<WebElement> unassignedDevicesInModal;
    @FindBy(xpath = "(//span[contains(text(),'Assigned')])[3]")
    private WebElement assignedDevicesModal;
    @FindBy(xpath = "(//button[@class='btn-close']//img)[2]")
    private WebElement assignedCloseBtn;
    @FindBy(xpath = "(//span[contains(text(),'Unassigned')])[3]")
    private WebElement unassignedDevicesTitle;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='content-info']")
    private WebElement assignedDevicesDescription;
    @FindBy(xpath = "//div[@class='org-actions']//div/span[text()='Invite Member']")
    private WebElement inviteMemberBtn;
    @FindBy(xpath = "//div[@class='body']/h3")
    private WebElement toastMessage;
    @FindBy(xpath = "(//button[@class='btn-action close'])[8]")
    private WebElement cancelButton;
    @FindBy(xpath = "//div[@class='container-actions']/div//div[text()='View Team']")
    private List<WebElement> viewTeams;
    @FindBy(xpath = "//div[@class='content-list']//div//div[@class='column col-name']")
    private List<WebElement> pendingInviteNames;
    @FindBy(xpath = "(//div[@class='column col-delete'])[1]")
    private WebElement clickCrossIcon;
    @FindBy(xpath = "(//div[@class='tooltip-remove-confirm']//button[@class='btn-action confirm'])[3]")
    private WebElement confirmButton1;
    @FindBy(xpath = "//div[@class='body']/h3")
    private WebElement toastMsgAfterConfirm;
    @FindBy(xpath = "(//div[@class='content-modal'])[8]")
    private WebElement editTeamModal;
    @FindBy(xpath = "//cdk-virtual-scroll-viewport[@class='cdk-virtual-scroll-viewport devices-viewport cdk-virtual-scrollable cdk-virtual-scroll-orientation-vertical']")
    private WebElement modalElementNeedToScroll;
    @FindBy(xpath = "(//div[@class='device-section']/h3)[1]")
    private WebElement firstDeviceName;
    @FindBy(xpath = "(//div[contains(@class,'3 grid')])[2]")
    private WebElement addOrRemoveDevice;
    @FindBy(xpath = "//div[@class='toast-container']//div//h3")
    private WebElement toastMessageCreateTeam;
    @FindBy(xpath = "//div[@class='grid header-titles']")
    private WebElement headerTitles;
    @FindBy(xpath = "//h3[text()=' Members ']")
    private WebElement memberTag;
    @FindBy(xpath = "//h1[normalize-space()='Create New Team']")
    private WebElement createNewTeamTag;
    @FindBy(xpath = "//img[@alt='success']")
    private WebElement teamNameTagForSuccess;
    @FindBy(xpath = "//div[@class='form-section team-member-section member-section']//div[@class='1 grid grid-center headers']//p[@class='1 title']")
    private WebElement addRemoveMembersDropdown;
    @FindBy(xpath = "//h3[text()='Add or Remove Members']")
    private WebElement addOrRemoveMembersTag;
    @FindBy(xpath = "//div[@class='icon hidden']/following-sibling::label")
    private List<WebElement> addMembersDropdown;
    @FindBy(xpath = "(//div[@class='selected-team-member-list box-container'])[1]//p")
    private List<WebElement> addMemberBelowDropDown;
    @FindBy(xpath = "//h3[text()='Add or Remove Sites']")
    private WebElement addOrRemoveSitesTag;
    @FindBy(xpath = "(//div[@class='2 grid grid-center headers'])[3]")
    private WebElement addOrRemoveSites;
    @FindBy(xpath = "(//div[contains(@class,'2 grid')]//p[@class='2 title'])[2]")
    private WebElement addOrRemoveSites1;
    @FindBy(xpath = "//div[contains(@class,'3 grid')]//p[@class='3 title']")
    private WebElement addOrRemoveDevicesDropDownBox;
    @FindBy(xpath = "//h3[text()='Add or Remove Sites']/..//following-sibling::div[@class='options']//following-sibling::label[contains(@class,'item-text')]")
    private List<WebElement> addSites;
    @FindBy(xpath = "//h3[text()='Add or Remove Sites']/./following-sibling::div//following-sibling::div//p[@class='tag-item with-close']")
    private List<WebElement> removeSitesName;
    @FindBy(xpath = "//h3[text()='Add or Remove Devices']/..//following-sibling::div[@class='options']//following-sibling::label[contains(@class,'item-text')]")
    private List<WebElement> addDevice;
    @FindBy(xpath = "//h3[text()='Add or Remove Devices']")
    private WebElement addOrRemoveDeviceTag;
    @FindBy(xpath = "//div[@class='device-location-list-sect']//p[@class='tag-item with-close']")
    private List<WebElement> addDeviceBelowDropDown;
    @FindBy(xpath = "//div[@class='column name']//p")
    private List<WebElement> teamsNameList;
    @FindBy(xpath = "//h3[text()='Name']")
    private WebElement nameTag;
    @FindBy(xpath = "//div[@class='column member-name']//p")
    private List<WebElement> membersNameColumn;
    @FindBy(xpath = "//div[@class='devices-list']//div//div[@class='column current-site']")
    private List<WebElement> sitesViewTeam;
    @FindBy(xpath = "//div[@class='grid body-list']//div[@class='column']")
    private WebElement devicesInTeamView;
    @FindBy(xpath = "//div[text()=' Edit Team ']")
    private WebElement editTeamTag;
    @FindBy(xpath = "//div[text()=' Edit Team ']")
    private WebElement editTeamName;
    @FindBy(xpath = "//div[@class='input-check']//input[1]")
    private WebElement enterTeamName;
    @FindBy(xpath = "//div[@class='form-section team-member-section member-section']//following-sibling::div[@class='selected-team-member-list box-container']//p")
    private List<WebElement> addedMembersBelowDropDown;
    @FindBy(xpath = "//div[@class='form-section team-member-section member-section']//following-sibling::div[@class='selected-team-member-list box-container']//button")
    private List<WebElement> removeMemberButton;
    @FindBy(xpath = "//div[contains(@class,'form-section team-member-section member-section')]//div[@class='1 grid grid-center headers']//p[@class='1 title']")
    private WebElement addRemoveMembersDropdown1;
    //    @FindBy(xpath = "//h3[text()='Add or Remove Sites']/./following-sibling::div//following-sibling::button//div//img")
    @FindBy(xpath = "//h3[text()='Add or Remove Sites']/./following-sibling::div//following-sibling::button")
    private List<WebElement> removeSitesButton;
    @FindBy(xpath = "//h3[text()='Add or Remove Devices']/./following-sibling::div//following-sibling::div//p[@class='tag-item with-close']")
    private List<WebElement> removableDeviceBelowDropDown;
    @FindBy(xpath = "//h3[text()='Add or Remove Devices']/./following-sibling::div//following-sibling::button")
    private List<WebElement> removeDeviceButton;
    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//label[@class='item-text checked']")
    private List<WebElement> checkedMemberNames;
    @FindBy(xpath = "//h3[text()='Add or Remove Sites']//..//following-sibling::div[@class='options']//following-sibling::label[@class='item-text checked']")
    private List<WebElement> checkedSites;
    @FindBy(xpath = "//h3[text()='Add or Remove Devices']//..//following-sibling::div[@class='options']//following-sibling::label[@class='item-text checked']")
    private List<WebElement> checkedDevicesInsideDropDown;
    @FindBy(xpath = "(//button[text()='Confirm'])[5]")
    private WebElement editConfirmButton;
    @FindBy(xpath = "//div[@class='toast-container']//h3")
    private WebElement editTeamConfirmationToastMessage;
    @FindBy(xpath = "//h2[text()='Team Members Information']")
    private WebElement teamMemberDisplayed;
    @FindBy(xpath = "(//div[@class='grid body-list team-row']//div[@class='column members members-when-sites']//p//span)[1]")
    private WebElement teamAdminNumber;
    @FindBy(xpath = "(//div[@class='grid body-list team-row']//div[@class='column members members-when-sites']//p//span)[2]")
    private WebElement membersNumber;
    @FindBy(xpath = "(//div[@class='grid body-list team-row']//div[@class='column sites']//p//span)[1]")
    private WebElement sitesNumber;
    @FindBy(xpath = "(//div[@class='grid body-list team-row']//div[@class='column sites']//p//span)[2]")
    private WebElement deviceNumber;
    @FindBy(xpath = "//div[@class='grid body-list']//div//following-sibling::div[contains(text(),'Team Admin')]")
    private List<WebElement> totalTeamAdminInList;
    @FindBy(xpath = "//div[@class='grid body-list']//div//following-sibling::div[contains(text(),'Member')]")
    private List<WebElement> totalMemberInList;
    @FindBy(xpath = "//div[text()='Hide Team']")
    private WebElement hideElement;
    @FindBy(xpath = "//div[@class='column members members-when-sites']//p//span")
    private List<WebElement> totalTeamMember;
    @FindBy(xpath = "//div[@class='column sites']//p//span")
    private List<WebElement> totalTeamSites;
    @FindBy(xpath = "//span[text()='Invite Member']")
    private WebElement inviteTeamMemberButton;
    @FindBy(xpath = "//h1[text()='Invite Member to Organization']//..//div//div")
    private List<WebElement> newAndCurrentTab;
    @FindBy(xpath = "//button[contains(@class,'btn-action confirm add')]")
    private WebElement addButton;
    @FindBy(xpath = "//button[@class='btn-action confirm add']")
    private WebElement addButton1;
    @FindBy(id = "name")
    private WebElement memberFirstName;
    @FindBy(id = "last-name")
    private WebElement memberLastName;
    @FindBy(id = "email")
    private WebElement memberEmailId;
    @FindBy(xpath = "//p[text()='Select Role']//..//..//div[@class='column-auto']//span")
    private WebElement selectRoleMember;
    @FindBy(xpath = "//label[text()='Email Address']")
    private WebElement mailIdTag;
    @FindBy(xpath = "//label[text()='Select Role']")
    private WebElement roleTag;
    @FindBy(xpath = "//label[text()='Select Team(s)']")
    private WebElement teamsTag;
    @FindBy(xpath = "//p[text()='Select Team(s)']//..//..//div[@class='column-auto']//span")
    private WebElement selectTeamMember;
    @FindBy(xpath = "//div[@class='container-teams']//div//span")
    private WebElement selectTeamCurrent;
    @FindBy(xpath = "(//button[@class='btn-action confirm'])[1]")
    private WebElement conFirmButtonSelectTeams;
    @FindBy(xpath = "//div[@class='toast-container']//p")
    private WebElement errorToastMessageInNewInvitation;
    @FindBy(xpath = "//h1[text()='Invitation Sent']")
    private WebElement invitationSendTag;
    @FindBy(xpath = "//button[text()='Yes, Invite another member']")
    private WebElement yesInviteAnotherMember;
    @FindBy(xpath = "//button[text()='No, I’m done']")
    private WebElement noDone;
    @FindBy(xpath = "(//button[@class='btn-action close'])[4]")
    private WebElement closeButton;
    @FindBy(xpath = "//div[text()=' Pending Invites ']")
    private WebElement pendingInvites;
    @FindBy(xpath = "//div[@class='tooltip-pending-invites']//button[@class='btn-action close']")
    private WebElement cancelButtonInPendingInvites;
    @FindBy(xpath = "//div[@class='invite-tabs']//div[text()=' Current ']")
    private WebElement currentTab;
    @FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown members']//span")
    private WebElement selectMemberInCurrentTab;
    @FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown members']//p[@class='iconEnabled']")
    private List<WebElement> memberListInCurrentTab;
    @FindBy(xpath = "//button[@class='btn-action confirm add']")
    private WebElement addButtonCurrentPage;
    @FindBy(xpath = "//p[@class='tag-item with-close']")
    private List<WebElement> teamsAndRoleInCurrentTab;
    @FindBy(xpath = "(//div[@class='action-buttons']//button[@class='btn-action confirm'])[last()]")
    private WebElement confirmButtonInCurrent;
    @FindBy(xpath = "//h1[text()='Pending Invites']")
    private WebElement pendingInviteTag;
    @FindBy(xpath = "//div[text()='Name']")
    private WebElement name;
    @FindBy(xpath = "//div[text()='Email']")
    private WebElement email;
    @FindBy(xpath = "//h1[text()='Delete Invitation']//..//..//following-sibling::div//button[@class='btn-action confirm']")
    private WebElement deleteInviteConfirmButton;
    @FindBy(xpath = "//div[@class='members-list']//div[@class='column member-name']//following-sibling::div[@class='column role']")
    private List<WebElement> roleListOfTeamMember;
    @FindBy(xpath = "//div[@class='members-list']//div[@class='column member-name']")
    private List<WebElement> addMemberInformation;
    @FindBy(xpath = "//div[@class='column edit-member']//div[@class='clickable']")
    private List<WebElement> editMember;
    @FindBy(xpath = "//div[@class='roles-section']//div[@class='0 grid grid-center headers']//span[@class='0 caret']")
    private WebElement roleDropDown;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div//p[@class='iconEnabled']")
    private List<WebElement> listOfRole;
    @FindBy(xpath = "//div[@class='teams-section']//div[@class='0 column-auto']//p")
    private WebElement selectTeamDropDown;
    @FindBy(xpath = "//div[@class='teams-section']//div[@class='options']//div//label[contains(@class,'item-text')]")
    private List<WebElement> listOfSelectTeams;
    @FindBy(xpath = "//div[@class='error toast']//div//h3")
    private WebElement errorToastMessage;
    @FindBy(xpath = "//button[@class='btn-delete']")
    private List<WebElement> deleteButton;
    @FindBy(xpath = "//div[@class='toast-container']//p")
    private WebElement toastMessageEditMember;
    @FindBy(xpath = "//div[@class='column col-send']//div")
    private WebElement sendAgain;
    @FindBy(xpath = "//button[text()='Send All Again']")
    private WebElement sendAgainAll;
    @FindBy(xpath = "//div[@class='body']")
    private WebElement sendAgainToastMessage;
    @FindBy(xpath = "//p[@class='tag-item with-close']")
    private List<WebElement> teamsSelectedWithCrossSection;
    @FindBy(xpath = "//p[@class='tag-item']")
    private List<WebElement> teamsSelectedWithOutCrossButton;
    @FindBy(xpath = "//div[@class='grid body-list']//following-sibling::div[@class='column role']")
    private WebElement roleDisplayedTag;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']")
    private WebElement roleDropDownOpenTag;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='options']")
    private WebElement selectTeamsDropDownTag;
    @FindBy(xpath = "//label[contains(@class,'item-text')]")
    private WebElement firstTeamNameTag;


    public TeamsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTeamsColumnModalInfo(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        teamsColumn.click();
        webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
        Assert.assertTrue(modalHeader.getText().contains(Constants.firstColumnName));
        Assert.assertTrue(columnInfoModalDescription.getText().contains(Constants.teamsColumnModalDesc));
    }

    public void verifyMembersColumnModalInfo(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        membersColumn.click();
        webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
        Assert.assertTrue(modalHeader.getText().contains(Constants.secondColumnName));
        Assert.assertTrue(columnInfoModalDescription.getText().contains(Constants.membersColumnModalDesc));
    }

    public void verifySitesColumnModalInfo(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        sitesColumn.click();
        webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
        Assert.assertTrue(modalHeader.getText().contains(Constants.thirdColumnName));
        Assert.assertTrue(columnInfoModalDescription.getText().contains(Constants.sitesColumnModalDesc));
    }

    public void verifyUnassignedTeamsModal(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        int unassignedTeamCount = Integer.parseInt(unassignedTeamsCount.getText());
        if (unassignedTeamCount > 0) {
            unassignedTeamsModal.click();
            webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
            Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedTeamModalHeader));
            Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedTeamModalSubHeader));
        } else {
            Assert.assertTrue(unassignedTeamsModal.isDisplayed());
            unassignedTeamsModal.click();
            webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
            Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedTeamModalHeader));
            Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedTeamModalSubHeader));
            Assert.assertTrue(modalNoDataMsg.getText().contains(Constants.ModalDescNoData));
            Assert.assertTrue(disableSavePdfBtn.isDisplayed());
        }
        modalCloseBtn.click();
    }

    public void verifyUnassignedMembersModal(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        int unassignedTeamCount = Integer.parseInt(unassignedMembersCount.getText());
        if (unassignedTeamCount > 0) {
            unassignedMembersModal.click();
            webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
            Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedMemberModalHeader));
            Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedMemberModalSubHeader));
        } else {
            Assert.assertTrue(unassignedMembersModal.isDisplayed());
            unassignedMembersModal.click();
            webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
            Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedMemberModalHeader));
            Assert.assertTrue(ModalDescription.getText().contains(Constants.unassignedMemberNoDataModalDesc));
        }
    }

    public void verifyAssignedTeamsModal(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        int assignedTeamCount = Integer.parseInt(assignedTeamsCount.getText());
        if (assignedTeamCount > 0) {
            assignedTeamsModal.click();
            webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
            Assert.assertTrue(modalHeader.getText().contains(Constants.assignedTeamModalHeader));
            Assert.assertTrue(modalHeader.getText().contains(Constants.assignedTeamModalSubHeader));
        } else {
            Assert.assertTrue(assignedTeamsModal.isDisplayed());
            assignedTeamsModal.click();
            webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
            Assert.assertTrue(modalHeader.getText().contains(Constants.assignedTeamModalHeader));
            Assert.assertTrue(modalHeader.getText().contains(Constants.assignedTeamModalSubHeader));
            Assert.assertTrue(modalNoDataMsg.getText().contains(Constants.ModalDescNoData));
            Assert.assertTrue(disableSavePdfBtn.isDisplayed());
        }
        modalCloseBtn.click();
    }

    public void verifyAssignedMembersModal(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        int assignedMemberCount = Integer.parseInt(assignedMembersCount.getText());
        if (assignedMemberCount > 0) {
            assignedMembersModal.click();
            webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
            Assert.assertTrue(modalHeader.getText().contains(Constants.assignedMemberModalHeader));
            Assert.assertTrue(modalHeader.getText().contains(Constants.assignedMemberModalSubHeader));
        } else {
            Assert.assertTrue(assignedMembersModal.isDisplayed());
            assignedMembersModal.click();
            webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
            Assert.assertTrue(modalHeader.getText().contains(Constants.assignedMemberModalHeader));
            Assert.assertTrue(modalHeader.getText().contains(Constants.assignedMemberModalSubHeader));
            Assert.assertTrue(modalNoDataMsg.getText().contains(Constants.ModalDescNoData));
            Assert.assertTrue(disableSavePdfBtn.isDisplayed());
        }
        modalCloseBtn.click();
    }

    public void verifyAssignedSitesModal(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        assignedSitesModal.click();
        webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
//        Assert.assertTrue(modalHeader.getText().contains(Constants.assignedSitesModalHeader));
//        Assert.assertTrue(ModalDescription.getText().contains(Constants.assignedSitesModalDesc));
    }

    public void verifyUnassignedSitesModal(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        int unassignedSiteCount = Integer.parseInt(unassignedSitesCount.getText());
        if (unassignedSiteCount > 0) {
            unassignedSitesTitle.click();
            webDriverHelper.waitUntilVisible(unassignedSitesModalDropdown, 90, 1);
//            Assert.assertTrue(unassignedSitesModalTitle.getText().contains(Constants.unassignedSitesModalTitle));
//            Assert.assertTrue(unassignedSitesModalTitle.getText().contains(Constants.unassignedSitesModalSubTitle));
        } else {
            Assert.assertTrue(unassignedSitesTitle.isDisplayed());
        }
    }

    public void verifyConfirmBtnState(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        int unassignedSiteCount = Integer.parseInt(unassignedSitesCount.getText());
        if (unassignedSiteCount > 0) {
            unassignedSitesTitle.click();
            webDriverHelper.waitUntilVisible(unassignedSitesModalDropdown, 90, 1);
            Assert.assertTrue(disabledConfirmBtn.isDisplayed());
        } else {
            Assert.assertTrue(unassignedSitesTitle.isDisplayed());
        }
    }

    public void verifyUnassignedSitesFunctionality(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
        int unassignedSiteCount = Integer.parseInt(unassignedSitesCount.getText());
        if (unassignedSiteCount > 0) {
            int assignedSiteCount = Integer.parseInt(assignedSitesCount.getText());
            unassignedSitesTitle.click();
            webDriverHelper.waitUntilVisible(unassignedSitesModalDropdown, 30, 1);
            unassignedSitesModalDropdown.click();
            for (WebElement e : dropdownSiteOptions) {
                System.out.println("e.getText()" + e.getText());
                e.getText();
                e.click();
            }
            confirmBtnF.click();
            webDriverHelper.waitUntilVisible(unassignedSitesSuccess, 30, 1);
            String successMsg = unassignedSitesSuccess.getText();
//            Assert.assertEquals(successMsg, Constants.unassignedSitesSuccess);
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            int unassignedSiteCountUpdated = Integer.parseInt(unassignedSitesCount.getText());
            int assignedSiteCountUpdated = Integer.parseInt(assignedSitesCount.getText());
            if (unassignedSiteCountUpdated == unassignedSiteCount - 1) {
                Assert.assertNotEquals(unassignedSiteCountUpdated, unassignedSiteCount);
            }
            Assert.assertNotEquals(assignedSiteCountUpdated, assignedSiteCount);
        } else {
            Assert.assertTrue(unassignedSiteCount == 0, "No Sites to Assigned");
        }
    }

    public void verifyTeamStats(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 200, 1);
        int teamRowCount = (teamTableRowsF.size()) - 1;
        int assignedStats = Integer.parseInt(teamsAssignedStatsCount.getText());
        int unassignedStats = Integer.parseInt(teamsUnassignedStatsCount.getText());
        int totalTeamsCount = assignedStats + unassignedStats;
        Assert.assertEquals(totalTeamsCount, teamRowCount);
    }

    public void verifyStatsOnOrgSwitch(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 200, 1);
        String currentStats = teamStatsF.getText();
        globalOrgDropdownBtn_MapPage.click();
        Thread.sleep(200);
        if (!(role.equalsIgnoreCase("teamAdmin"))) {
            webDriverHelper.waitUntilVisible(orgDropdown_orgList, 200, 1);
            orgDropdown_orgList.click();
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 200, 2);
            String newStats = teamStatsF.getText();
            Assert.assertNotEquals(newStats, currentStats);
        }
    }

    public void verifyEditTeamsAddAndRemoveMember(String role) throws IOException {
        verifyAdministratorRow();
        if (!((role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader")
                || role.equalsIgnoreCase("member")))) {
            verifyEditTeamsAddMember();
            verifyEditTeamsRemoveMember();

        } else {
            webDriverHelper.waitUntilVisible(teamsSecondRow_orgAdmin, 200, 1);
            teamsSecondRow_orgAdmin.click();
            webDriverHelper.waitUntilVisible(viewTeamDetails_Administrators, 30, 1);
            String teamRowContents = secondTeamRowF.getText();
            Assert.assertTrue((!(teamRowContents).contains("Edit Team")), "edit team button displayed for other roles except orgAdmin");
        }
    }

    public void verifyCreateEditDeleteNewTeam(String role) throws IOException, InterruptedException {
        verifyAdministratorRow();
        if (!((role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader")
                || role.equalsIgnoreCase("member") || role.equalsIgnoreCase("teamAdmin")))) {
            verifyCreateNewTeam();
//            verifyEditNewTeam();
            verifyDeleteNewTeam();
        } else {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 30, 1);
            Assert.assertTrue((!(TeamsCreateAndInviteOptionsF.getText()).contains("Create New Team")), "create team button displayed for other roles except orgAdmin");
        }
    }

    public void verifyInviteNewMember(String role) throws IOException, InterruptedException {
        verifyAdministratorRow();
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader")
                || role.equalsIgnoreCase("member") || role.equalsIgnoreCase("teamAdmin"))) {
            verifyInviteNewMember();
            verifyPendingInvites();
        } else if (role.equalsIgnoreCase("teamAdmin")) {
            verifyInviteNewMember();
            webDriverHelper.waitUntilVisible(viewTeamDetails_Administrators, 30, 1);
            if ((viewTeamDetails_Administrators).isDisplayed() && (!(viewTeamDetails_Administrators.getText()).contains("Pending Invites"))) {
                Assert.assertTrue((!(viewTeamDetails_Administrators.getText()).contains("Pending Invites")), "failed team admin");
            }
        }
    }

    public void verifyInviteCurrentMember(String role) throws IOException, InterruptedException {
        verifyAdministratorRow();
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader")
                || role.equalsIgnoreCase("member") || role.equalsIgnoreCase("teamAdmin"))) {
            verifyInviteCurrentMember();
            verifyPendingInvites_CurrentMember();
        } else if (role.equalsIgnoreCase("teamAdmin")) {
            verifyInviteCurrentMember();
            webDriverHelper.waitUntilVisible(viewTeamDetails_Administrators, 30, 1);
            if ((viewTeamDetails_Administrators).isDisplayed() && (!(viewTeamDetails_Administrators.getText()).contains("Pending Invites"))) {
                Assert.assertTrue((!(viewTeamDetails_Administrators.getText()).contains("Pending Invites")), "failed team admin");
            }
        }
    }

    public void verifyEditNewTeam() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teamNameF, 30, 1);
        teamNameF.click();
        webDriverHelper.waitUntilVisible(editMemberF, 30, 1);
        editMemberF.click();
        webDriverHelper.waitUntilVisible(editMemberModalF, 30, 1);
        selectRoleDropdownOpen_EditMemberF.click();
        webDriverHelper.waitUntilVisible(selectRoleMember_EditMemberF, 30, 1);
        selectRoleMember_EditMemberF.click();

        webDriverHelper.waitUntilVisible(selectRoleDropdownOpen_EditMemberF, 30, 1);
        selectTeamDropdownOpen_EditMemberF.click();
        webDriverHelper.waitUntilVisible(selectTeamList_EditMemberF, 30, 1);
        selectTeamList_EditMemberF.click();
        webDriverHelper.waitUntilVisible(selectRoleDropdownOpen_EditMemberF, 30, 1);
        addButton_EditMemberF.click();
        webDriverHelper.waitUntilVisible(addedDetailsTag_EditMemberF, 30, 1);
        confirmBtnF.click();
        webDriverHelper.waitUntilVisible(createTeam_successToast, 30, 1);
        Assert.assertTrue(createTeam_successToast.isDisplayed(), "edit member team failed");
    }

    public void verifyCreateNewTeam() throws IOException, InterruptedException {
        createNewTeamBtnF.click();
        webDriverHelper.waitUntilVisible(teamNameTextF, 30, 1);
        teamNameTextF.sendKeys(teamName);

//        addRemoveMembersDropdownOpenB.click();
        webDriverHelper.waitUntilVisible(createTeam_teamNameSuccess, 30, 1);
////        webDriverHelper.waitUntilVisible(createTeam_addMemberList, 30, 1);
//        webDriverHelper.waitUntilVisible(addMembersCheckbox, 30, 1);
//        addMembersCheckbox.click();
//        Thread.sleep(3000);
//        dropdownCloseB.click();
//        Thread.sleep(1000);
//
//        addSitesDropdownOpenB.click();
////        webDriverHelper.waitUntilVisible(createTeam_addMemberList, 30, 1);
//        webDriverHelper.waitUntilVisible(addSitesCheckbox, 30, 1);
//        addSitesCheckbox.click();
//        dropdownCloseB.click();
//        Thread.sleep(5000);
//
//        addDeviceDropdownOpenB.click();
////        webDriverHelper.waitUntilVisible(createTeam_addMemberList, 30, 1);
//        webDriverHelper.waitUntilVisible(addDeviceCheckbox, 30, 1);
//        addDeviceCheckbox.click();
//        dropdownCloseB.click();
        Thread.sleep(1000);

        confirmBtb_createTeam.click();
        webDriverHelper.waitUntilVisible(createTeam_successToast, 30, 1);
        Assert.assertTrue(createTeam_successToast.isDisplayed(), "create team failed");
    }

    public void verifyDeleteNewTeam() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(teamNameF, 30, 1);
        teamNameF.click();
        webDriverHelper.waitUntilVisible(deleteTeamF, 30, 1);
        deleteMemberF.click();
        webDriverHelper.waitUntilVisible(confirmBtnF, 30, 1);
        confirmBtnF.click();
        webDriverHelper.waitUntilVisible(yesDeleteMemberButtonF, 30, 1);
        yesDeleteMemberButtonF.click();
        webDriverHelper.waitUntilVisible(successToast_DeleteMemberF, 30, 1);
        Assert.assertTrue(successToast_DeleteMemberF.isDisplayed(), "delete member failed");
        deleteTeamF.click();
        webDriverHelper.waitUntilVisible(confirmBtnF, 30, 1);
        confirmBtnF.click();
        webDriverHelper.waitUntilVisible(yesDeleteTeamButtonF, 30, 1);
        yesDeleteTeamButtonF.click();
        webDriverHelper.waitUntilVisible(successTeamDeleteToastF, 30, 1);
        Assert.assertTrue(successTeamDeleteToastF.isDisplayed(), "delete team failed");
    }

    public void verifyInviteNewMember() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(inviteMemberF, 30, 1);
        inviteMemberF.click();
        webDriverHelper.waitUntilVisible(inviteMemberModalF, 30, 1);
        inviteMemberFirstNameF.sendKeys(firstName);
        inviteMemberLastNameF.sendKeys(lastName);
        inviteMemberEmailF.sendKeys(newEmail);
        fillDetailsForInviteNewMember();
    }

//    public void verifyInviteCurrentMember() throws IOException, InterruptedException {
//        webDriverHelper.waitUntilVisible(inviteMemberF, 30, 1);
//        inviteMemberF.click();
//        webDriverHelper.waitUntilVisible(inviteMember_CurrentTabF, 30, 1);
//        inviteMember_CurrentTabF.click();
//        webDriverHelper.waitUntilVisible(inviteMemberModalF, 30, 1);
//        webDriverHelper.waitUntilVisible(inviteMember_CurrentTab_MemberDropdownF, 30, 1);
//        inviteMember_CurrentTab_MemberDropdownF.click();
//        webDriverHelper.waitUntilVisible(inviteMember_CurrentTab_MemberDropdownF, 30, 1);
//        fillDetailsForInviteNewMember();
//    }

    public void fillDetailsForInviteNewMember() throws IOException, InterruptedException {
        inviteMemberRoleDropdownOpenF.click();
        webDriverHelper.waitUntilVisible(selectRoleMember_EditMemberF, 30, 1);
        Thread.sleep(5000);
        selectRoleMember_EditMemberF.click();
        webDriverHelper.waitUntilVisible(inviteMemberRoleDropdownOpenF, 30, 1);
        selectTeamDropdownOpen_EditMemberF.click();
        webDriverHelper.waitUntilVisible(inviteMember_SelectTeamF, 30, 1);
        Thread.sleep(5000);
        inviteMember_SelectTeamF.click();
        webDriverHelper.waitUntilVisible(addButton_EditMemberF, 30, 1);
        addButton_EditMemberF.click();
        webDriverHelper.waitUntilVisible(inviteMember_TagF, 30, 1);
        confirmBtnF.click();
        webDriverHelper.waitUntilVisible(inviteAnotherMember_NoOptionF, 30, 1);
        inviteAnotherMember_NoOptionF.click();

        try {
            driver.navigate().refresh();
            verifyAdministratorRow();
        } catch (StaleElementReferenceException e) {
            verifyAdministratorRow();
        }
        map.switchOrg();
        secondRow_TeamName_TeamPageF.click();
    }


    public void verifyPendingInvites() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(deleteTeamF, 30, 1);
        webDriverHelper.waitUntilVisible(inviteMember_PendingInviteButtonF, 30, 1);
        String pendingInviteText = inviteMember_PendingInviteButtonF.getText();
        if (inviteMember_PendingInviteButtonF.isDisplayed()) {
            inviteMember_PendingInviteButtonF.click();
            webDriverHelper.waitUntilVisible(pendingInvite_modalF, 30, 1);
            if (pendingInvite_modalF.getText().contains("testautomation@arable.com")) {
                webDriverHelper.waitUntilVisible(pendingInvite_deleteF, 30, 1);
                Assert.assertTrue(pendingInvite_modalF.getText().contains("testautomation@arable.com"), "pending invite does not contain email");
                pendingInvite_deleteF.click();
                webDriverHelper.waitUntilVisible(confirmBtnF, 30, 1);
                confirmBtnF.click();
                webDriverHelper.waitUntilVisible(pendingInvite_successfullyDeletedF, 30, 1);
                webDriverHelper.waitUntilVisible(noPendingInviteTextF, 30, 1);
                PendingInviteModal_CancelBtnF.click();
                webDriverHelper.waitUntilVisible(secondRow_TeamName_TeamPageF, 30, 1);
            }
        } else {
            Assert.assertTrue(viewTeamDetails_Administrators.getText().contains(pendingInviteText), "pending invite does not contain email");
        }
    }

    public void verifyPendingInvites_CurrentMember() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(deleteTeamF, 30, 1);
        webDriverHelper.waitUntilVisible(inviteMember_PendingInviteButtonF, 30, 1);

        String pendingInviteText = inviteMember_PendingInviteButtonF.getText();

        if (inviteMember_PendingInviteButtonF.isDisplayed()) {
            inviteMember_PendingInviteButtonF.click();
            webDriverHelper.waitUntilVisible(pendingInvite_modalF, 30, 1);

            if (pendingInvite_modalF.isDisplayed()) {
                webDriverHelper.waitUntilVisible(pendingInvite_deleteF, 30, 1);
                pendingInvite_deleteF.click();
                webDriverHelper.waitUntilVisible(confirmBtnF, 30, 1);
                confirmBtnF.click();
                webDriverHelper.waitUntilVisible(pendingInvite_successfullyDeletedF, 30, 1);
                webDriverHelper.waitUntilVisible(noPendingInviteTextF, 30, 1);
                PendingInviteModal_CancelBtnF.click();
                webDriverHelper.waitUntilVisible(secondRow_TeamName_TeamPageF, 30, 1);
            }
        } else {
            Assert.assertTrue(viewTeamDetails_Administrators.getText().contains(pendingInviteText), "pending invite does not contain email");
        }
    }

    public void verifyNoEditOptionInAdministratorRow(String role) throws IOException {
        verifyAdministratorRow();
        String adminRowText = teams_AdministratorsRow.getText();
        viewTeam_Administrators.click();
        webDriverHelper.waitUntilVisible(viewTeamDetails_Administrators, 30, 1);
        if (!(adminRowText.contains("Edit Team"))) {
            Assert.assertTrue(!(adminRowText.contains("Edit Team")), "edit teams in Administrators Row displayed");
        } else {
            Assert.assertTrue(editTeam.isDisplayed(), "edit teams in Administrators Row not displayed");
        }
    }

    public void verifyAdministratorRow(String role) throws IOException {
        verifyAdministratorRow();
    }

    public void verifyAdministratorRow() throws IOException {
        webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 30, 1);
        Assert.assertTrue(teams_AdministratorsRow.isDisplayed(), "teams Administrators Row displayed");
    }

    public void navigateToPage(String role) throws InterruptedException, IOException {
        webDriverHelper.waitUntilVisible(dashboardMenu_Settings, 30, 1);
        map.navigateToPage(role);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Teams).click().build().perform();
    }

//    public void captureTeamsPageLoadTime(String role) throws IOException, InterruptedException {
//        String loadInSeconds = null;
//        long start = System.currentTimeMillis();
//        StringHelper.devToolCapture(role);
//        webDriverHelper.waitUntilVisible(teamsFirstRow_orgReader, 30, 1);
//        Assert.assertTrue(teamsFirstRow_orgReader.isDisplayed(), "Tags are displayed");
//        loadInSeconds = stringHelper.stopTime(start, driver);
//        ExcelReader.setValueForColumn("Teams", loadInSeconds, role);
//        // HTML report generator
//        HTMLReport.addPageName("Teams");
////        HTMLReport.generateReport("Teams", loadInSeconds, role);
//        HTMLReport.writeReportToFile();
//    }


    public void switchOrgToArableTeam() throws InterruptedException, IOException {
        if (!(globalOrgSelected_MapPage.getText().contains("arable-team"))) {
            globalOrgDropdownBtn_MapPage.click();
            webDriverHelper.waitUntilVisible(globalOrgDropdownSearch_MapPage, 30, 1);
            globalOrgDropdownSearch_MapPage.sendKeys("arable-team");
            globalOrgSearchSuggestion_MapPage.click();
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 150, 1);
        }
    }

    public void verifyInviteCurrentMember() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(inviteMemberF, 30, 1);
        inviteMemberF.click();
        webDriverHelper.waitUntilVisible(inviteMember_CurrentTabF, 30, 1);
        inviteMember_CurrentTabF.click();
        webDriverHelper.waitUntilVisible(inviteMemberModalF, 30, 1);
        webDriverHelper.waitUntilVisible(inviteMember_CurrentTab_MemberDropdownF, 30, 1);
        inviteMember_CurrentTab_MemberDropdownF.click();
        webDriverHelper.waitUntilVisible(inviteMember_CurrentTab_MemberListF, 30, 1);
        System.out.println(" inviteMember_CurrentTab_MemberListF.get(1)" + inviteMember_CurrentTab_MemberListF.getText());
        inviteMember_CurrentTab_MemberF.click();
        inviteMemberRoleDropdownOpenF.click();
        webDriverHelper.waitUntilVisible(selectRoleMember_EditMemberF, 30, 1);
        Thread.sleep(5000);
        selectRoleMember_EditMemberF.click();
        webDriverHelper.waitUntilVisible(inviteMemberRoleDropdownOpenF, 30, 1);
        selectTeamDropdownOpen_EditMemberF.click();
        webDriverHelper.waitUntilVisible(inviteMember_CurrentTab_TeamF, 30, 1);
        Thread.sleep(5000);
        inviteMember_CurrentTab_TeamF.click();
        webDriverHelper.waitUntilVisible(addButton_EditMemberF, 30, 1);
        addButton_EditMemberF.click();
        webDriverHelper.waitUntilVisible(inviteMember_TagF, 30, 1);
        confirmBtnF.click();
        webDriverHelper.waitUntilVisible(inviteAnotherMember_NoOptionF, 30, 1);
        inviteAnotherMember_NoOptionF.click();

        try {
            driver.navigate().refresh();
            verifyAdministratorRow();
        } catch (StaleElementReferenceException e) {
            verifyAdministratorRow();
        }
//        switchOrgToArableTeam();
        map.switchOrg();
        secondRow_TeamName_TeamPageF.click();
    }

    public void verifyEditTeamsRemoveMember() throws IOException {
        editTeam.click();
        System.out.println("after edit team clicked");
        webDriverHelper.waitUntilVisible(editTeam_addMemberDropdownOpenF, 30, 1);
        editTeam_addMemberDropdownOpenF.click();
        webDriverHelper.waitUntilVisible(editTeam_addMemberListF, 30, 1);
        String memberName = editTeam_addMemberListF.getText();
        System.out.println("memberName:- " + memberName);
        editTeam_addMemberListF.click();
        editTeam_addMemberDropDownCloseF.click();
        webDriverHelper.waitUntilVisible(editTeam_addedMemberListBoxF, 30, 1);
        String addedMemberListBox = editTeam_addedMemberListBoxF.getText();
        System.out.println("addedMemberListBox:- " + addedMemberListBox);
        if (!(addedMemberListBox.contains(memberName))) {
            confirmBtn.click();
        }
//        webDriverHelper.waitUntilVisible(successMsg, 30, 1);
        webDriverHelper.waitUntilVisible(createTeam_successToast, 30, 1);
        webDriverHelper.waitUntilVisible(teamsSecondRow_orgAdmin, 200, 1);
        teamsSecondRow_orgAdmin.click();
        webDriverHelper.waitUntilVisible(viewTeamDetails_Administrators, 30, 1);
        String teamDetails = viewTeamDetails_Administrators.getText();
        System.out.println("teamDetails:- " + teamDetails);
        Assert.assertFalse(teamDetails.contains(memberName), "Added Member name is present in team details");
    }

    public void verifyEditTeamsAddMember() throws IOException {
        webDriverHelper.waitUntilVisible(teamsSecondRow_orgAdmin, 200, 1);
        teamsSecondRow_orgAdmin.click();
        webDriverHelper.waitUntilVisible(editTeam, 30, 1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", editTeam);
        webDriverHelper.waitUntilVisible(editTeam_addMemberDropdownOpenF, 30, 1);
        editTeam_addMemberDropdownOpenF.click();
        webDriverHelper.waitUntilVisible(editTeam_addMemberListF, 30, 1);
        String memberName = editTeam_addMemberListF.getText();
        System.out.println("memberName:- " + memberName);
        editTeam_addMemberListF.click();
        editTeam_addMemberDropDownCloseF.click();
        webDriverHelper.waitUntilVisible(editTeam_addedMemberListBoxF, 30, 1);
        String addedMemberListBox = editTeam_addedMemberListBoxF.getText();
        System.out.println("addedMemberListBox:- " + addedMemberListBox);
        if (addedMemberListBox.contains(memberName)) {
            confirmBtn.click();
        }
        webDriverHelper.waitUntilVisible(createTeam_successToast, 30, 1);
        webDriverHelper.waitUntilVisible(teamsSecondRow_orgAdmin, 200, 1);
        teamsSecondRow_orgAdmin.click();
        webDriverHelper.waitUntilVisible(viewTeamDetails_Administrators, 30, 1);
        String teamDetails = viewTeamDetails_Administrators.getText();
        System.out.println("teamDetails:- " + teamDetails);
        Assert.assertTrue(teamDetails.contains(memberName), "Added Member name is not present in team details");
    }

    public void verifyAssignedDevicesModal() {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            assignedDevicesModal.click();
            webDriverHelper.waitUntilVisible(modalHeader, 60, 1);
            Assert.assertTrue(modalHeader.getText().contains(Constants.assignedDevicesModalHeader));
            Assert.assertTrue(assignedDevicesDescription.getText().contains(Constants.assignedDevicesModalDescription));
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTitleAndDescription");
            Assert.fail("Failed to verify the title and description in assigned device modal due to exception:- " + exc);
        }
    }

    public void verifyScrollAndStoreTheDevices() {
        try {
            webDriverHelper.waitUntilVisible(unassignedDeviceModal, 120, 1);
            unassignedDeviceModal.click();
            while (unassignedDeviceCountBeforAssigning != deviceNameSet.size()) {
                List<String> deviceNamesBeforeScroll = webDriverHelper.returnListOfWebElements("//div[@class='cdk-virtual-scroll-content-wrapper']//h3");
                for (String deviceName : deviceNamesBeforeScroll) {
                    if (deviceNameSet.contains(deviceName)) {
                        continue;
                    } else {
                        deviceNameSet.add(deviceName);
                    }
                }
                Thread.sleep(3000);
                webDriverHelper.scrollDownInsideModal(modalElementNeedToScroll, 200);
            }
            deviceSize = deviceNameSet.size();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnassignedScroll.jpg");
            Assert.fail("Failed to scroll and store the devices in the list due to exception:" + exc);
        }
    }

    public void verifyUnassignedDevicesFunctionality(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
//            Thread.sleep(5000);
            unassignedDeviceCountBeforAssigning = Integer.parseInt(unassignedDevicesCount.getText());
            if (unassignedDeviceCountBeforAssigning > 0 && (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                assignedDeviceCountBeforAssigning = Integer.parseInt(assignedDevicesCount.getText());
                unassignedDevicesTitle.click();
                webDriverHelper.waitUntilVisible(modalHeader, 60, 1);
                Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedDevicesModalHeader));
                Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedDevicesModalDescription));
                teamsPage.verifyScrollAndStoreTheDevices();
                if (unassignedDeviceCountBeforAssigning == deviceSize) {
                    webDriverHelper.scrollSlowlyToTopInsideModal(modalElementNeedToScroll);
                    webDriverHelper.waitUntilVisible(firstDeviceText, 120, 1);
                    firstDeviceDropdownText = firstDeviceText.getText();
                    webDriverHelper.waitUntilVisible(unassignedFirstDevicesDropDown, 60, 1);
                    unassignedFirstDevicesDropDown.click();
                    for (WebElement teams : teamsList) {
                        String teamNameList = teams.getText();
                        teamsDropDownList.add(teamNameList);
                    }
                    for (WebElement e : teamsList) {
//                        System.out.println("e.getText()" + e.getText());
                        teamNameSelectedInDropdown = e.getText();
                        e.click();
                        break;
                    }
                    confirmButton.click();
                    webDriverHelper.waitUntilVisible(unassignedDevicesSuccess, 30, 1);
                    String successMsg = unassignedDevicesSuccess.getText();
                    Assert.assertEquals(successMsg, Constants.unassignedDevicesSuccess);
                }
            } else {
                Assert.assertTrue(unassignedDevicesTitle.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnassignedModal.jpg");
            Assert.fail("Failed to verify the title, device count and other functionality due to exception:- " + exc);
        }
    }

    public void verifyWhetherTheDropdownOpensForAnyOfTheDevices(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            int unassignedDeviceCount = Integer.parseInt(unassignedDevicesCount.getText());
            if (unassignedDeviceCount > 0 && (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                webDriverHelper.waitUntilVisibilityOfAllElements(unassignedDeviceDropdownIcon, 90, 1);
                for (int i = 0; i < 3; i++) {
                    unassignedDeviceDropdownIcon.get(i).click();
                    int j = i + 1;
                    List<WebElement> teamsListInDropdown = driver.findElements(By.xpath("(//div[@class='device-section'])[" + j + "]//following-sibling::div[@class='options']//p"));
                    if (teamsListInDropdown.size() == 0) {
                        Assert.fail("The teams are not present in the list when we click on the teams dropdown.");
                    } else {
                        unassignedDeviceDropdownIcon.get(i).click();
                    }
                }
            } else {
                Assert.assertTrue(unassignedDevicesTitle.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyDeviceDropdownInUnassignedModal.jpg");
            Assert.fail("Failed to open the dropdown for any of the device in the unassigned device modal due to exception:- " + exc);
        }
    }

    public void verifyUnassignedDevicesModal(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            int unassignedDeviceCount = Integer.parseInt(unassignedDevicesCount.getText());
            if (unassignedDeviceCount > 0 && (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                unassignedDevicesTitle.click();
                webDriverHelper.waitUntilVisible(modalHeader, 90, 1);
                Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedDevicesModalHeader));
                Assert.assertTrue(modalHeader.getText().contains(Constants.unassignedDevicesModalDescription));
            } else {
                Assert.assertTrue(unassignedDevicesTitle.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUnassignedTitleAndDescription");
            Assert.fail("Failed to verify the title and description for the unassigned device modals due to exception:- " + exc);
        }
    }

    public void verifyApiCountInBannerBeforeSwitching() {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            String assignedTeam = assignedTeamsCount.getText();
            String unassignedTeam = unassignedTeamsCount.getText();
            String assignedMember = assignedMembersCount.getText();
            String unassignedMember = unassignedMembersCount.getText();
            String assignedDevice = assignedDevicesCount.getText();
            String unassignedDevice = unassignedDevicesCount.getText();
            String assignedSite = assignedSiteCount.getText();
            String unassignedSite = unassignedSiteCount.getText();

            teamsApiHelper.getAuthToken();
            teamsApiHelper.getOrgId(orgTargeted);
            teamsApiHelper.getSummaryRequest();
            if (assignedTeam.equals(assignedTeamsCounts)) {
                bannerCountsBeforeSwitching.add(assignedTeam);
            }
            if (unassignedTeam.equals(unassignedTeamsCounts)) {
                bannerCountsBeforeSwitching.add(unassignedTeam);
            }
            if (assignedMember.equals(assignedMembersCounts)) {
                bannerCountsBeforeSwitching.add(assignedMember);
            }
            if (unassignedMember.equals(unassignedMembersCounts)) {
                bannerCountsBeforeSwitching.add(unassignedMember);
            }
            if (assignedDevice.equals(assignedDevicesCounts)) {
                bannerCountsBeforeSwitching.add(assignedDevice);
            }
            if (unassignedDevice.equals(unassignedDevicesCounts)) {
                bannerCountsBeforeSwitching.add(unassignedDevice);
            }
            if (assignedSite.equals(assignedSitesCounts)) {
                bannerCountsBeforeSwitching.add(assignedSite);
            }
            if (unassignedSite.equals(unassignedSitesCounts)) {
                bannerCountsBeforeSwitching.add(unassignedSite);
            }
            Assert.assertTrue(assignedTeam.equals(assignedTeamsCounts), "The Assigned Team count " + assignedTeam + " is not matching with the stats Api count " + assignedTeamsCounts + " ");
            Assert.assertTrue(unassignedTeam.equals(unassignedTeamsCounts), "The Unassigned Team count " + unassignedTeam + " is not matching with the stats Api count " + unassignedTeamsCounts + " ");
            Assert.assertTrue(assignedMember.equals(assignedMembersCounts), "The Assigned Member count " + assignedMember + " is not matching with the stats Api count " + assignedMembersCounts + " ");
            Assert.assertTrue(unassignedMember.equals(unassignedMembersCounts), "The Unassigned Member count " + unassignedMember + " is not matching with the stats Api count " + unassignedMembersCounts + " ");
            Assert.assertTrue(assignedDevice.equals(assignedDevicesCounts), "The Assigned Device count " + assignedDevice + "is not matching with the stats Api count " + assignedDevicesCounts + " ");
            Assert.assertTrue(unassignedDevice.equals(unassignedDevicesCounts), "The Unassigned Device count " + unassignedDevice + " is not matching with the stats Api count " + unassignedDevicesCounts + " ");
            Assert.assertTrue(assignedSite.equals(assignedSitesCounts), "The Assigned Site count " + assignedSite + " is not matching with the stats Api count " + assignedSitesCounts + " ");
            Assert.assertTrue(unassignedSite.equals(unassignedSitesCounts), "The Unassigned Site count " + unassignedSite + " is not matching with the stats Api count " + unassignedSitesCounts + " ");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_BannerStatsApiCount.jpg");
            Assert.fail("Failed to verify the Stats count and banners count in the Api due to exception:- " + exc);
        }
    }

    public void verifyApiCountInBannerAfterSwitching() {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            String assignedTeam = assignedTeamsCount.getText();
            String unassignedTeam = unassignedTeamsCount.getText();
            String assignedMember = assignedMembersCount.getText();
            String unassignedMember = unassignedMembersCount.getText();
            String assignedDevice = assignedDevicesCount.getText();
            String unassignedDevice = unassignedDevicesCount.getText();
            String assignedSite = assignedSiteCount.getText();
            String unassignedSite = unassignedSiteCount.getText();
            List<String> bannerCountsAfterSwitching = new ArrayList<>();

            teamsApiHelper.getAuthToken();
            teamsApiHelper.getOrgId(orgNameAfterSwitching);
            teamsApiHelper.getSummaryRequest();
            if (assignedTeam.equals(assignedTeamsCounts)) {
                bannerCountsAfterSwitching.add(assignedTeam);
            }
            if (unassignedTeam.equals(unassignedTeamsCounts)) {
                bannerCountsAfterSwitching.add(unassignedTeam);
            }
            if (assignedMember.equals(assignedMembersCounts)) {
                bannerCountsAfterSwitching.add(assignedMember);
            }
            if (unassignedMember.equals(unassignedMembersCounts)) {
                bannerCountsAfterSwitching.add(unassignedMember);
            }
            if (assignedDevice.equals(assignedDevicesCounts)) {
                bannerCountsAfterSwitching.add(assignedDevice);
            }
            if (unassignedDevice.equals(unassignedDevicesCounts)) {
                bannerCountsAfterSwitching.add(unassignedDevice);
            }
            if (assignedSite.equals(assignedSitesCounts)) {
                bannerCountsAfterSwitching.add(assignedSite);
            }
            if (unassignedSite.equals(unassignedSitesCounts)) {
                bannerCountsAfterSwitching.add(unassignedSite);
            }
            Assert.assertTrue(assignedTeam.equals(assignedTeamsCounts), "The Assigned Team count " + assignedTeam + " is not matching with the stats Api count " + assignedTeamsCounts + " ");
            Assert.assertTrue(unassignedTeam.equals(unassignedTeamsCounts), "The Unassigned Team count " + unassignedTeam + " is not matching with the stats Api count " + unassignedTeamsCounts + " ");
            Assert.assertTrue(assignedMember.equals(assignedMembersCounts), "The Assigned Member count " + assignedMember + " is not matching with the stats Api count " + assignedMembersCounts + " ");
            Assert.assertTrue(unassignedMember.equals(unassignedMembersCounts), "The Unassigned Member count " + unassignedMember + " is not matching with the stats Api count " + unassignedMembersCounts + " ");
            Assert.assertTrue(assignedDevice.equals(assignedDevicesCounts), "The Assigned Device count " + assignedDevice + "is not matching with the stats Api count " + assignedDevicesCounts + " ");
            Assert.assertTrue(unassignedDevice.equals(unassignedDevicesCounts), "The Unassigned Device count " + unassignedDevice + " is not matching with the stats Api count " + unassignedDevicesCounts + " ");
            Assert.assertTrue(assignedSite.equals(assignedSitesCounts), "The Assigned Site count " + assignedSite + " is not matching with the stats Api count " + assignedSitesCounts + " ");
            Assert.assertTrue(unassignedSite.equals(unassignedSitesCounts), "The Unassigned Site count " + unassignedSite + " is not matching with the stats Api count " + unassignedSitesCounts + " ");

            Assert.assertNotEquals(bannerCountsBeforeSwitching, bannerCountsAfterSwitching, "The banner counts- " + bannerCountsBeforeSwitching + " ,are not changing after switching org/team- " + bannerCountsAfterSwitching + "!");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_BannerStatsApiCount.jpg");
            Assert.fail("Failed to verify the Stats count and banners count in the Api due to exception:- " + exc);
        }
    }

    public void verifyApiCountAfterSwitchingOrganization() {
        try {
            if (organizationCount > 1) {
                teamsPage.verifyApiCountInBannerAfterSwitching();
            } else {
                Assert.assertTrue(assignedTeamsCount.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_statsApiCountAfterSwitchingOrg.jpg");
            Assert.fail("Failed to verify the Stats count and banners count After switch the Organization in the Api due to exception:- " + exc);
        }
    }

    public void verifyTeamsListInTeamsPage() {
        try {
            String teamsDropdownNames = "";
            webDriverHelper.waitUntilVisible(teamsDropdown, 60, 1);
            teamsDropdown.click();
            for (WebElement teamDropdown : teamsDropdownList) {
                teamsDropdownNames = teamDropdown.getText();
            }
            teamsDropdown.click();
            String teamsListName = "";
            webDriverHelper.waitUntilVisibilityOfAllElements(teamsNames, 90, 1);
            for (int i = 1; i < teamsNames.size(); i++) {
                teamsListName = teamsNames.get(i).getText();
            }
            if (!(teamsDropdownNames.equals(teamsListName))) {
                Assert.fail("Teams name " + teamsDropdownNames + " in list is not matching with the name " + teamsListName + " in drop down ");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_VerifyTeamsList.jpg");
            Assert.fail("Failed to verify the teams names in list and drop down due to exception:- " + exc);
        }
    }

    public void verifyViewTeamInTeamPage(String userRole) {
        try {
            if (!((userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                webDriverHelper.waitUntilVisibilityOfAllElements(teamsNameInPages, 90, 1);
                for (int i = 1; i < teamsNameInPages.size(); i++) {
                    view.get(i).click();
                    break;
                }
            } else {
                webDriverHelper.waitUntilVisible(teamsSecondRow_orgAdmin, 90, 1);
                teamsSecondRow_orgAdmin.click();
                webDriverHelper.waitUntilVisible(viewTeamDetails_Administrators, 30, 1);
                String teamRowContents = secondTeamRowF.getText();
                Assert.assertTrue((!(teamRowContents).contains("Edit Team")), "Edit team button displayed for other roles except orgAdmin ");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_VerifyViewTeams");
            Assert.fail("Failed to click on view team in teams page due to exception:- " + exc);
        }
    }

    public void verifyEditTeamAndObserve(String userRole) {
        try {
            if (!((userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                webDriverHelper.waitUntilVisible(viewTeamDetails_Administrators, 30, 1);
                webDriverHelper.waitUntilVisible(editTeam, 60, 1);
                editTeam.click();
            } else {
                Assert.assertTrue(teams_AdministratorsRow.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_VerifyEditTeam");
            Assert.fail("Failed to click on edit team and observe the result due to exception:- " + exc);
        }
    }

    public void verifyApiInNetworkTab(String orgName, int expectedCallCount) {
        try {
            teamsApiHelper.getAuthToken();
            teamsApiHelper.getOrgId(orgName);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = "return performance.getEntriesByType('resource')" +
                    ".filter(entry => entry.name.includes('" + PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/orgs/" + orgId + "/users?page=1&limit=10000')).length";
            Long apiCallCount = (Long) js.executeScript(script);
            if (!(apiCallCount.equals((long) expectedCallCount))) {
                Assert.fail("Failed because the API is not present in the network tab (or) Api was calling more than 1 time in the network tab-" + apiCallCount);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyResponseInNetworkTab.jpg");
            Assert.fail("Failed to verify API in the network tab due to exception:- " + exc);
        }
    }

    public void verifyEditMemberInViewTeamPage(String userRole) {
        try {
            if (!((userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                webDriverHelper.waitUntilVisibilityOfAllElements(teamMembersList, 90, 1);
                for (int i = 0; i < teamMembersList.size(); i++) {
                    WebElement teamNameElement = teamMembersList.get(i);
                    String teamsName = teamNameElement.getText();
                    editMemberList.get(i).click();
                    webDriverHelper.waitUntilVisible(editMemberTitle, 90, 1);
                    String titleName = editMemberTitle.getText();
                    Assert.assertTrue(titleName.equals("Edit Member " + teamsName + ""), "Failed to verify the title for the edit member modal");
                    break;
                }
            } else {
                Assert.assertTrue(teams_AdministratorsRow.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_VerifyEditMember");
            Assert.fail("Failed to click on edit member and observe the result due to exception:- " + exc);
        }
    }

    public void clickOnConfirmBtnOnEditMemberModalAndObserve(String userRole) {
        try {
            if (!((userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                webDriverHelper.waitUntilVisible(confirmBtnInEditMember, 60, 1);
                confirmBtnInEditMember.click();
                teamsPage.verifyApiInNetworkTab(orgTargeted, 2);
            } else {
                Assert.assertTrue(teams_AdministratorsRow.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_VerifyConfirmBtnAndObserve");
            Assert.fail("Failed to click on confirm btn on edit member modal and observe the result due to exception:- " + exc);
        }
    }

    public void clickOnConfirmBtnOnEditTeamModalAndObserve(String userRole) {
        try {
            if (!((userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                webDriverHelper.waitUntilVisible(confirmBtnInEditTeam, 30, 1);
                confirmBtnInEditTeam.click();
                webDriverHelper.waitUntilVisible(toastMsgAfterConfirm, 30, 1);
                teamsPage.verifyApiInNetworkTab(orgTargeted, 2);
            } else {
                Assert.assertTrue(teams_AdministratorsRow.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_VerifyConfirmBtnAndObserve");
            Assert.fail("Failed to click on confirm btn on edit team modal and observe the result due to exception:- " + exc);
        }
    }

    public void verifyOrganizationDropdown() {
        try {
            webDriverHelper.waitUntilVisible(organizationDropdown, 90, 1);
            organizationDropdown.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(organizationDropdownList, 60, 1);
            organizationCount = organizationDropdownList.size();
            for (int i = 0; i < organizationDropdownList.size(); i++) {
                String orgName = organizationDropdownList.get(i).getText();
                if (!(orgName.equalsIgnoreCase(orgTargeted)) && !(orgName.equalsIgnoreCase("Moonrocks"))) {
                    orgNameAfterSwitching = organizationDropdownList.get(i).getText();
                    organizationDropdownList.get(i).click();
                    break;
                } else {
                    Assert.assertTrue(unassignedTeamsCount.isDisplayed());
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_OrganizationDropdown.jpg");
            Assert.fail("Failed to click on the organization dropdown and select any organization due to exception:- " + exc);
        }
    }

    public void verifyTeamsDropdown() {
        try {
            webDriverHelper.waitUntilVisible(selectedOrgName, 90, 1);
            orgNameAfterSwitching = selectedOrgName.getText();
            webDriverHelper.waitUntilVisible(teamsDropdown, 60, 1);
            teamsDropdown.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(teamsDropdownList, 200, 1);
            for (int i = 0; i < teamsDropdownList.size(); i++) {
                if (teamsDropdownList.size() != 0) {
                    teamsDropdownList.get(i).click();
                    break;
                }
                if (teamsDropdownList.size() == 0) {
                    Assert.fail("There is no any other organization to switch ");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_TeamsDropdown.jpg");
            Assert.fail("Failed to switch to other team in the teams dropdown due to exception:- " + exc);
        }
    }

    public void verifyTeamsInBothDropDownAndList(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            int unassignedDeviceCount = Integer.parseInt(unassignedDevicesCount.getText());
            if (unassignedDeviceCount > 0 && (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                webDriverHelper.waitUntilVisibilityOfAllElements(teamsNameInPages, 90, 1);
                for (int i = 1; i < teamsNameInPages.size(); i++) {
                    String teamNames = teamsNameInPages.get(i).getText();
                    if (i - 1 < teamsDropDownList.size()) {
                        String dropdownNames = teamsDropDownList.get(i - 1);
                        if (!teamNames.contains(dropdownNames)) {
                            Assert.fail("The devices displayed do not match with the team names in teamsPage");
                        }
                    } else {
                        Assert.fail("No corresponding element found in teamsDropDownList for teamNames[" + i + "]");
                    }
                }
            } else {
                Assert.assertTrue(unassignedDevicesTitle.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_VerifyTeamsList.jpg");
            Assert.fail("The teams displayed in the dropdown is not matching with the teams in list due to exception:- " + exc);
        }
    }

    public void verifyDeviceInTeam(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            int unassignedDeviceCount = Integer.parseInt(unassignedDevicesCount.getText());
            if (unassignedDeviceCount > 0 && (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                webDriverHelper.waitUntilVisibilityOfAllElements(teamsNameInPages, 90, 1);
                for (int i = 0; i < teamsNameInPages.size(); i++) {
                    WebElement teamNameElement = teamsNameInPages.get(i);
                    String teamsName = teamNameElement.getText();
                    if (teamsName.equals(teamNameSelectedInDropdown)) {
                        webDriverHelper.waitUntilVisibilityOfAllElements(view, 90, 1);
                        view.get(i).click();
                        webDriverHelper.waitUntilVisible(deviceNameInUnassignedList, 90, 1);
                        String assignedDevicesName = deviceNameInUnassignedList.getText();
                        if (!(assignedDevicesName.contains(firstDeviceDropdownText))) {
                            Assert.fail("Device is not unassigned for the team that you are selected ");
                        } else {
                            webDriverHelper.waitUntilVisible(hideTeam, 90, 1);
                            hideTeam.click();
                        }
                    }
                }
            } else {
                Assert.assertTrue(unassignedDevicesTitle.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_VerifyDeviceInTeam.jpg");
            Assert.fail("Failed to verify the device in the team due to exception:- " + exc);
        }
    }

    public void verifyDeviceCountInBanner(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            int unassignedDeviceCount = Integer.parseInt(unassignedDevicesCount.getText());
            if (unassignedDeviceCount > 0 && (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                unassignedDeviceCountAfterAssigning = Integer.parseInt(unassignedDevicesCount.getText());
                assignedDeviceCountAfterAssigning = Integer.parseInt(assignedDevicesCount.getText());
                if (!((unassignedDeviceCountBeforAssigning != unassignedDeviceCountAfterAssigning) && (assignedDeviceCountBeforAssigning != assignedDeviceCountAfterAssigning))) {
                    Assert.fail("Failed because the device count is matching with assigned and unassigned after change");
                }
            } else {
                Assert.assertTrue(unassignedDevicesTitle.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_DeviceBannerCountAfterAssigning.jpg");
            Assert.fail("Failed to verify the device count when the unassigned device was assigned to any team due to exception:- " + exc);
        }
    }

    public void verifyApiCountInDeviceBanner(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            int unassignedDeviceCount = Integer.parseInt(unassignedDevicesCount.getText());
            if (unassignedDeviceCount > 0 && (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                webDriverHelper.waitUntilVisible(assignedDevicesCount, 90, 1);
                String assignedDevice = assignedDevicesCount.getText();
                String unassignedDevice = unassignedDevicesCount.getText();
                System.out.println("assignedDevice:-" + assignedDevice);
                System.out.println("unassignedDevice:-" + unassignedDevice);
                teamsApiHelper.getAuthToken();
                teamsApiHelper.getOrgId(orgTargeted);
                teamsApiHelper.getSummaryRequest();
                Assert.assertTrue(assignedDevice.contains(assignedDevicesCounts), "The Assigned Device count is not matching with the stats Api count");
                Assert.assertTrue(unassignedDevice.contains(unassignedDevicesCounts), "The Unassigned Device count is not matching with the stats Api count");
                System.out.println("assignedDevice.contains(assignedDevicesCounts):-" + assignedDevice.contains(assignedDevicesCounts));
                System.out.println("unassignedDevice.contains(unassignedDevicesCounts):-" + unassignedDevice.contains(unassignedDevicesCounts));
            } else {
                Assert.assertTrue(unassignedDevicesTitle.isDisplayed());
                System.out.println("unassignedDevicesTitle.isDisplayed():-" + unassignedDevicesTitle.isDisplayed());

            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_DeviceApiCount.jpg");
            Assert.fail("Failed to verify the Stats count in device banners through Api due to exception:- " + exc);
        }
    }

    public void verifyRemovedDeviceInUnassignedModal(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            int unassignedDeviceCount = Integer.parseInt(unassignedDevicesCount.getText());
            if (unassignedDeviceCount > 0 && (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                boolean outerLoopBreak = false;
                for (int i = 0; i < teamsNameInPages.size(); i++) {
                    WebElement teamNameElement = teamsNameInPages.get(i);
                    String teamsName = teamNameElement.getText();
                    if (teamsName.equals(teamNameSelectedInDropdown)) {
                        webDriverHelper.waitUntilVisibilityOfAllElements(view, 90, 1);
                        view.get(i).click();
//                        Thread.sleep(5000); // To wait for Edit option modal popup load
                        webDriverHelper.waitUntilVisible(viewTeamDetails_Administrators, 30, 1);
                        webDriverHelper.waitUntilVisible(editTeam, 120, 1);
                        editTeam.click();
                        webDriverHelper.waitUntilVisibilityOfAllElements(deviceSelectedForTeam, 120, 1);
                        for (int j = 0; j < deviceSelectedForTeam.size(); j++) {
                            WebElement devicesNameInTeam = deviceSelectedForTeam.get(j);
                            String deviceName = devicesNameInTeam.getText();
                            if (deviceName.equals(firstDeviceDropdownText)) {
                                devicesCancelBtnForTeam.get(j).click();
                                webDriverHelper.waitUntilVisible(confirmBtnInEditTeam, 60, 1);
                                confirmBtnInEditTeam.click();
                                webDriverHelper.waitUntilVisible(toastMsgAfterConfirm, 60, 1);
                                outerLoopBreak = true;
                                break;
                            }
                        }
                        if (outerLoopBreak) {
                            break;
                        }
                    }
                }
                webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
                unassignedDeviceCountBeforAssigning = Integer.parseInt(unassignedDevicesCount.getText());
                assignedDeviceCountBeforAssigning = Integer.parseInt(assignedDevicesCount.getText());
                webDriverHelper.waitUntilVisible(unassignedDevicesTitle, 90, 1);
                unassignedDevicesTitle.click();
                webDriverHelper.waitUntilVisible(firstDeviceName, 90, 1);
                String firstDeviceText = firstDeviceName.getText();
                Assert.assertEquals(firstDeviceText, firstDeviceDropdownText, "The device " + firstDeviceDropdownText + " is not present in the unassigned modal after removing from the teams ");
                webDriverHelper.waitUntilVisible(cancelBtnInUnassignedDeviceModal, 90, 1);
                cancelBtnInUnassignedDeviceModal.click();
            } else {
                Assert.assertTrue(unassignedDevicesTitle.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_DevicePresentAfterRemovingForTeam.jpg");
            Assert.fail("Failed to verify because the removed device is not displayed in unassigned devices modal under the " + teamName + " due to exception:- " + exc);
        }
    }

    public void verifyBannerCountAfterRemovingDeviceFromTeam(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
            int unassignedDeviceCount = Integer.parseInt(unassignedDevicesCount.getText());
            if (unassignedDeviceCount > 0 && (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")))) {
                int unassignedDeviceCountAfterRemoving = Integer.parseInt(unassignedDevicesCount.getText());
                int assignedDeviceCountAfterRemoving = Integer.parseInt(assignedDevicesCount.getText());
                if ((unassignedDeviceCountAfterRemoving == unassignedDeviceCountAfterAssigning) && (assignedDeviceCountAfterRemoving == assignedDeviceCountAfterAssigning)) {
                    Assert.fail("Failed because the device count is matching with assigned and unassigned after removing from team ");
                }
            } else {
                Assert.assertTrue(unassignedDevicesTitle.isDisplayed());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_DeviceBannerCountAfterRemoving.jpg");
            Assert.fail("Failed to verify the device count when the unassigned device was assigned to any team due to exception:- " + exc);
        }
    }

    //new
    public void verifyingApiInNetworkTab() {
        try {
            webDriverHelper.waitUntilVisible(teamStatsF, 90, 1);
            teamsApiHelper.getAuthToken();
            Thread.sleep(2000); // for loading the resources
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String apiUrl = PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion;
            Long statsApi = (Long) js.executeScript("var apiUrl = arguments[0];" +
                    "return performance.getEntriesByType('resource').filter(entry => entry.name.includes('" + apiUrl + "/orgs/5f6cb124b5f7d5049590bff1/teams/stats')).length", apiUrl);
            Long teamsApi = (Long) js.executeScript("var apiUrl = arguments[0];" +
                    "return performance.getEntriesByType('resource').filter(entry => entry.name.includes('" + apiUrl + "/users/" + userId + "/orgs/5f6cb124b5f7d5049590bff1/teams')).length", apiUrl);
            Long usersApi = (Long) js.executeScript("var apiUrl = arguments[0];" +
                    "return performance.getEntriesByType('resource').filter(entry => entry.name.includes('" + apiUrl + "/orgs/5f6cb124b5f7d5049590bff1/users?page=1&limit=10000')).length", apiUrl);
            if (statsApi == null || statsApi == 0) {
                Assert.fail("The resource is not being loaded for statsApi");
            }
            if (teamsApi == null || teamsApi == 0) {
                Assert.fail("The resource is not being loaded for teamsApi");
            }
            if (usersApi == null || usersApi == 0) {
                Assert.fail("The resource is not being loaded for usersApi");
            }
        } catch (Exception exc) {
            Assert.fail("the exception " + exc);
        }
    }

    public void clickOnCreateNewBtn(String userRole) {
        try {
            Thread.sleep(3000);
            if (userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member")) {
                try {
                    if (createNewTeamBtnF.isDisplayed()) {
                        Assert.fail("The 'Create New Team' button should not displayed in the teams page for the " + userRole + " user");
                    }
                } catch (Exception exc) {
                    return;
                }
            }
            webDriverHelper.waitUntilVisible(createNewTeamBtnF, 90, 1);
            createNewTeamBtnF.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("clickOnCreateNewBtn.jpg");
            Assert.fail("the error in create new button " + exc);
        }
    }

    public void newTeamCreation(String teamNumber, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                String teamName = Constants.newTeamName + teamNumber + "@";
                webDriverHelper.waitUntilVisible(createNewTeamTag, 60, 1);
                String createNewTeamTagD = createNewTeamTag.getText();
                if (!createNewTeamTagD.contains("Create New Team")) {
                    Assert.fail("the create new team tag is not present");
                }
                webDriverHelper.waitUntilVisible(teamNameTextF, 60, 1);
                // Step to enter the team name with the random number
                if (teamName.contains("1")) {
                    teamName = teamName + String.valueOf(stringHelper.randomNumberGenerator());
                    newTeamName1 = teamName;
                } else if (teamName.contains("2")) {
                    teamName = teamName + String.valueOf(stringHelper.randomNumberGenerator());
                    newTeamName2 = teamName;
                } else {
                    teamName = teamName + String.valueOf(stringHelper.randomNumberGenerator());
                    newTeamName3 = teamName;
                }
                teamNameTextF.sendKeys(teamName);
                teamNameStored = teamName;
                // just to verify the team name is already present in the list or not
                webDriverHelper.waitUntilVisible(addRemoveMembersDropdown, 90, 1);
                addRemoveMembersDropdown.click();
                webDriverHelper.waitUntilVisible(teamNameTagForSuccess, 90, 1);
                if (!teamNameTagForSuccess.isDisplayed()) {
                    Assert.fail("the team name " + teamNameStored + " is already present ");
                }
                addRemoveMembersDropdown.click();
                // Add or Remove Members
                webDriverHelper.waitUntilVisible(addOrRemoveMembersTag, 60, 1);
                if (!addOrRemoveMembersTag.isDisplayed()) {
                    Assert.fail("the 'Add or Remove Members' tag are not displayed in the Create New Team page");
                }
                webDriverHelper.waitUntilVisible(addRemoveMembersDropdown, 90, 1);
                addRemoveMembersDropdown.click();
                copyAddMembers = new ArrayList<>();
                // if we are selecting particular name
                boolean nameFound = false;
                for (WebElement dropDownTeam : addMembersDropdown) {
                    String dropDownTeamName = dropDownTeam.getText();
                    if (dropDownTeamName.equalsIgnoreCase(member1)) {
                        copyAddMembers.add(dropDownTeamName);
                        dropDownTeam.click();
                        nameFound = true;
                        break;
                    }
                }
                if (!nameFound) {
                    Assert.fail("the name " + member1 + " is not present in the  member list");
                }
                nameFound = false;
                for (WebElement dropDownTeam : addMembersDropdown) {
                    String dropDownTeamName = dropDownTeam.getText();
                    if (dropDownTeamName.equalsIgnoreCase(member2)) {
                        copyAddMembers.add(dropDownTeamName);
                        dropDownTeam.click();
                        nameFound = true;
                        break;
                    }
                }
                if (!nameFound) {
                    Assert.fail("the name " + member2 + " is not present in the  member list");
                }
                // if we are selecting particular name for the team admin
                nameFound = false;
                for (WebElement dropDownTeam : addMembersDropdown) {
                    String dropDownTeamName = dropDownTeam.getText();
                    if (dropDownTeamName.equalsIgnoreCase(teamAdminName)) {
                        copyAddMembers.add(dropDownTeamName);
                        dropDownTeam.click();
                        nameFound = true;
                        break;
                    }
                }
                if (!nameFound) {
                    Assert.fail("the name " + teamAdminName + " is not present in the  member list");
                }
                addRemoveMembersDropdown.click();
                for (WebElement memberCheckAfterAdding : addMemberBelowDropDown) {
                    String MemberList = memberCheckAfterAdding.getText();
                    boolean found = false;
                    for (String membersName : copyAddMembers) {
                        if (membersName.equals(MemberList)) {
                            found = true;
                        }
                    }
                    if (!found) {
                        Assert.fail("the Member in the UI is not matching with the Member name selected in the drop down");
                    }
                }
                // Add or Remove Sites
                webDriverHelper.waitUntilVisible(addOrRemoveSitesTag, 60, 1);
                if (!addOrRemoveSitesTag.isDisplayed()) {
                    Assert.fail("the 'Add or Remove Sites' Tag are not displayed in the Create New Team page");
                }
                webDriverHelper.waitUntilVisible(addOrRemoveSites, 90, 1);
                addOrRemoveSites.click();
                copyAddSites = new ArrayList<>();
                webDriverHelper.waitUntilVisible(addOrRemoveSites, 30, 1);
                for (int i = 0; i < addSites.size() - 1 && i < 3; i++) {
                    WebElement addSite = addSites.get(i);
                    String text = addSite.getText();
                    copyAddSites.add(text);
                    addSite.click();
                }
                addOrRemoveSites.click();
                Thread.sleep(3000);
                for (WebElement siteCheckAfterAdding : removeSitesName) {
                    String siteName = siteCheckAfterAdding.getText();
                    boolean found = false;
                    for (String siteNames : copyAddSites) {
                        if (siteNames.equals(siteName)) {
                            found = true;
                        }
                    }
                    if (!found) {
                        Assert.fail("the site name in the UI is not matching with the site name selected in the drop down");
                    }
                }
                // Add or Remove Devices
                webDriverHelper.waitUntilVisible(addOrRemoveDeviceTag, 90, 1);
                if (!addOrRemoveDeviceTag.isDisplayed()) {
                    Assert.fail("the 'Add or Remove Device' Tag are not displayed in the Create New Team page");
                }
                addOrRemoveDevice.click();
                Thread.sleep(3000);
                copyAddDevices = new ArrayList<>();
                for (int i = 0; i < addDevice.size() - 1 && i < 2; i++) {
                    WebElement addDeviceElement = addDevice.get(i);
                    String text = addDeviceElement.getText();
                    copyAddDevices.add(text);
                    addDeviceElement.click();
                    Thread.sleep(3000);
                    for (WebElement DeviceCheckAfterAdding : addDeviceBelowDropDown) {
                        String DeviceList = DeviceCheckAfterAdding.getText();
                        boolean found = false;
                        for (String DeviceName : copyAddDevices) {
                            if (DeviceName.equals(DeviceList)) {
                                found = true;
                            }
                        }
                        if (!found) {
                            Assert.fail("the Device in the UI is not matching with the Device name selected in the drop down");
                        }
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("newTeamCreation.jpg");
            Assert.fail("An exception occurred in new team creation: " + exc);
        }
    }

    public void verifyingNewTeamHasCreated(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                addOrRemoveDevice.click();
                webDriverHelper.waitUntilVisible(confirmBtnF, 30, 1);
                confirmBtnF.click();
                // popup verification after clicking on confirm button
                webDriverHelper.waitUntilVisible(toastMessageCreateTeam, 60, 1);
                String toastMessageActual = toastMessageCreateTeam.getText();
                String toastMessageExpected = teamNameStored + " has been created";
                Assert.assertEquals(toastMessageActual, toastMessageExpected, "The toast messages do not match in the create new team popup page");
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyingNewTeamHasCreated.jpg");
            Assert.fail("Failure in verifying the popup message for Team creation after clicking on confirm button " + exc);
        }
    }

    public void apiVerificationTeamsPage(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                //UI
                webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
                String assignedTeam = assignedTeamsCount.getText();
                String unassignedTeam = unassignedTeamsCount.getText();
                String assignedMember = assignedMembersCount.getText();
                String unassignedMember = unassignedMembersCount.getText();
                String assignedDevice = assignedDevicesCount.getText();
                String unassignedDevice = unassignedDevicesCount.getText();
                String assignedSite = assignedSiteCount.getText();
                String unassignedSite = unassignedSiteCount.getText();
                // api
                teamsApiHelper.getAuthToken();
                teamsApiHelper.getOrgId(orgTargeted);
                teamsApiHelper.getSummaryRequest();
                Assert.assertTrue(assignedTeam.contains(assignedTeamsCounts), "The assignedTeam Team count is not matching with the stats Api count");
                Assert.assertTrue(unassignedTeam.contains(unassignedTeamsCounts), "The Unassigned Team count is not matching with the stats Api count");
                Assert.assertTrue(assignedMember.contains(assignedMembersCounts), "The Assigned Member count is not matching with the stats Api count");
                Assert.assertTrue(unassignedMember.contains(unassignedMembersCounts), "The Unassigned Member count is not matching with the stats Api count");
                Assert.assertTrue(assignedDevice.contains(assignedDevicesCounts), "The Assigned Device count is not matching with the stats Api count");
                Assert.assertTrue(unassignedDevice.contains(unassignedDevicesCounts), "The Unassigned Device count is not matching with the stats Api count");
                Assert.assertTrue(assignedSite.contains(assignedSitesCounts), "The Assigned Site count is not matching with the stats Api count");
                Assert.assertTrue(unassignedSite.contains(unassignedSitesCounts), "The Unassigned Site count is not matching with the stats Api count");
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("apiVerificationTeamsPage.jpg");
            Assert.fail("The exception in apiVerificationTeamsPage " + exc);
        }
    }

    public void verifyTeamInTheTeamListForEditRole(String teamNumber, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                String teamName = Constants.newTeamName + teamNumber + "@";
                if (teamName.contains("1")) {
                    teamName = newTeamName1;
                } else if (teamName.contains("2")) {
                    teamName = newTeamName2;
                } else if (teamName.contains("3")) {
                    teamName = newTeamName3;
                } else {
                    teamName = namePostEdit;
                }
                webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
                for (int i = 0; i < teamsNameList.size(); i++) {
                    String teamsName = teamsNameList.get(i).getText();
                    webDriverHelper.scrollToWebElement(teamsNameList.get(i));
                    if (teamsName.equalsIgnoreCase(teamName)) {
                        webDriverHelper.scrollToWebElement(view.get(i));
                        view.get(i).click();
                        break;
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTeamInTheTeamList.jpg");
            Assert.fail("An error occurred while verifying the new created team: " + exc);
        }
    }

    public void verifyDataInNewCreatedTeam(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(nameTag, 60, 1);
                for (WebElement usernameElement : membersNameColumn) {
                    String username = usernameElement.getText();
                    boolean found = false;
                    for (String copyName : copyAddMembers) {
                        if (username.contains(copyName)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        Assert.fail("The name '" + username + "' is not present in copyAddMembers.");
                    }
                }
                for (WebElement userSiteElement : sitesViewTeam) {
                    String siteName = userSiteElement.getText();
                    boolean found = false;
                    for (String siteTOCopy : copyAddSites) {
                        if (siteName.contains(siteTOCopy)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        Assert.fail("The name '" + siteName + "' is not present in copyAddSites.");
                    }
                }
                String deviceName = devicesInTeamView.getText();
                boolean found = false;
                for (String deviceTOCopy : copyAddDevices) {
                    if (deviceName.contains(deviceTOCopy)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Assert.fail("The name '" + deviceName + "' is not present in copyAddDevice.");
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyDataInNewCreatedTeam.jpg");
            Assert.fail("Error in verifyDataInNewCreatedTeam: " + exc);
        }
    }

    public void editTeamName(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(editTeamTag, 90, 1);
                {
                    if (!editTeamTag.isDisplayed()) {
                        Assert.fail("the 'The Edit Team' tag is not present");
                    }
                }
                webDriverHelper.waitUntilVisible(editTeamName, 90, 1);
                editTeamName.click();
                webDriverHelper.waitUntilVisible(enterTeamName, 90, 1);
                enterTeamName.clear();
                editedTeamName = Constants.namePostEdit + stringHelper.randomNumberGenerator();
                enterTeamName.sendKeys(editedTeamName);
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyEditOptionInTheEditTeamPage.jpg");
            Assert.fail("The Exception in verifyEditTeam  " + exc);
        }
    }

    public void verifyEditOptionInTheEditTeamPage(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                removedMemberName = new ArrayList<>();
                for (int i = 0; i < addedMembersBelowDropDown.size(); i++) {
                    String memberNameRemoved = addedMembersBelowDropDown.get(i).getText();
                    removeMemberButton.get(i).click();
                    webDriverHelper.waitUntilVisible(addRemoveMembersDropdown1, 90, 1);
                    addRemoveMembersDropdown1.click();
                    for (WebElement checkedName : checkedMemberNames) {
//                        Thread.sleep(3000);
                        String namePresentInList = checkedName.getText();
                        if (namePresentInList.contains(memberNameRemoved)) {
                            Assert.fail("The removed name=" + memberNameRemoved + ", is present in the member name dropdown list=" + namePresentInList);
                        }
                    }
                    removedMemberName.add(memberNameRemoved);
                    break;
                }
                webDriverHelper.waitUntilVisible(addRemoveMembersDropdown1, 90, 1);
                addRemoveMembersDropdown1.click();
                removedSitesName = new ArrayList<>();
                for (int i = 0; i < removeSitesButton.size(); i++) {
                    String removedSiteName = removeSitesName.get(i).getText();
                    removeSitesButton.get(i).click();
                    webDriverHelper.waitUntilVisible(addOrRemoveSites1, 90, 1);
                    addOrRemoveSites1.click();
                    for (WebElement checkedSite : checkedSites) {
                        String remainingSite = checkedSite.getText();
//                        System.out.println("Checked site in the dropdown=" + remainingSite + " and removed site name=" + removedSiteName);
                        if (remainingSite.contains(removedSiteName)) {
                            Assert.fail("The removed site is still present in the checked site list in dropdown.");
                        }
                    }
                    removedSitesName.add(removedSiteName);
                    break;
                }
//                System.out.println("Removed site -" + removedSitesName);
                Thread.sleep(10000); // Required as the sites don't get removed if script quickly confirms on the popup modal.

                webDriverHelper.waitUntilVisible(addOrRemoveSites1, 90, 1);
                addOrRemoveSites1.click();
                devicesRemovedInEditingTeam = new ArrayList<>();
                // the devices below the dropdown vanish, click on the dropdown and wait tends to fix this, and it starts showing again
                try {
                    if (!(removeDeviceButton.size() > 0)) {
                        addOrRemoveDevicesDropDownBox.click();
                        Thread.sleep(2000);
                        addOrRemoveDevicesDropDownBox.click();
                        Thread.sleep(5000);
//                        System.out.println("The removable device option size was not more than zero, after click in dropdown size=" + removeDeviceButton.size());
                    }
                } catch (StaleElementReferenceException se) {
//                    System.out.println("Exception-" + se);
                    addOrRemoveDevicesDropDownBox.click();
                    Thread.sleep(3000);
                    addOrRemoveDevicesDropDownBox.click();
                }
                for (int i = 0; i < removeDeviceButton.size(); i++) {
                    String deviceNameRemoved = removableDeviceBelowDropDown.get(i).getText();
                    removeDeviceButton.get(i).click();
                    webDriverHelper.waitUntilVisible(addOrRemoveDevicesDropDownBox, 90, 1);
                    addOrRemoveDevicesDropDownBox.click();
                    for (WebElement checkedDevice : checkedDevicesInsideDropDown) {
                        String checkedDeviceName = checkedDevice.getText();
                        devicesRemovedInEditingTeam.add(deviceNameRemoved);
                        if (checkedDeviceName.contains(deviceNameRemoved)) {
                            Assert.fail("The removed device=" + deviceNameRemoved + " is still selected in the dropdown list=" + checkedDeviceName);
                        }
                    }
                    addOrRemoveDevicesDropDownBox.click(); // close the device dropdown
                    break;
                }
                Thread.sleep(5000);
                webDriverHelper.waitUntilVisible(editConfirmButton, 90, 1);
                Thread.sleep(5000);
                editConfirmButton.click();
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyEditOptionInTheEditTeamPage.jpg");
            Assert.fail("The exception in verifyEditOptionInTheEditTeamPage " + exc);
        }
    }

    public void verifyConfirmationToastMessageForTeamNameUpdate(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(editTeamConfirmationToastMessage, 60, 1);
                String toastMessageActual = editTeamConfirmationToastMessage.getText();
                String toastMessageExpected = editedTeamName + " has been updated";
                Assert.assertEquals(toastMessageActual, toastMessageExpected, "The toast messages do not match after editing the team.");
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyConfirmToastMessageTeam.jpg");
            Assert.fail("Exception in verify toast message after Editing created Team..." + exc);
        }
    }

    public void verifyOldTeamNameNotPresent(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                for (int i = 0; i < teamsNameList.size(); i++) {
                    String teamsName = teamsNameList.get(i).getText();
                    webDriverHelper.scrollToWebElement(teamsNameList.get(i));
                    if (teamsName.trim().equalsIgnoreCase(newTeamName3)) {
                        Assert.fail("The team name " + newTeamName3 + " is still present in the list");
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                if (memberTag.isDisplayed()) {
                    Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyAfterModifyingTeamNameStillPresent.jpg");
            Assert.fail("An error occurred verifyAfterModifyingTeamNameStillPresent: " + exc);
        }
    }

    public void verifyEditedTeamName(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                for (int i = 0; i < teamsNameList.size(); i++) {
                    String teamsName = teamsNameList.get(i).getText();
                    indexOfSites = i;
                    webDriverHelper.scrollToWebElement(teamsNameList.get(i));
                    if (teamsName.equals(editedTeamName)) {
                        Thread.sleep(5000);
                        view.get(i).click();
                        break;
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyEditedTeamList.jpg");
            Assert.fail("An error occurred verify NewCreated Team: " + exc);
        }
    }

    public void verifyTheModifiedData(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(teamMemberDisplayed, 30, 1);
                if (!teamMemberDisplayed.isDisplayed()) {
                    Assert.fail("'Team Members Information' tag is not displayed");
                }
//                Thread.sleep(3000);
                for (WebElement sitesPresent : sitesViewTeam) {
                    String siteNamePresent = sitesPresent.getText();
//                    System.out.println("UI site-"+siteNamePresent);
//                    Thread.sleep(3000);
                    for (String removedName : removedSitesName) {
//                        System.out.println("Removed site name-"+removedName);
                        if (siteNamePresent.contains(removedName)) {
                            webDriverHelper.scrollToWebElement(sitesPresent);
//                            System.out.println("The UI site name="+siteNamePresent+", Matches the deleted site name="+removedName);
//                            Assert.fail("The UI site name="+siteNamePresent+", Matches the deleted site name="+removedName);
                        }
                    }
                }
//                Thread.sleep(3000);
                String deviceNamesUnderTeam = devicesInTeamView.getText();
                for (String removedDevice : devicesRemovedInEditingTeam) {
                    if (deviceNamesUnderTeam.contains(removedDevice)) {
//                        System.out.println("Removed device is still present-"+removedDevice);
                        Assert.fail("The UI device names=" + deviceNamesUnderTeam + ", contain the deleted device name too=" + removedDevice);
                    }
                }
                for (WebElement teamMembersName : membersNameColumn) {
                    Thread.sleep(1000);
                    nameViewTeamCopy = membersNameColumn.size();
                    String presentMemberName = teamMembersName.getText();
                    for (String removedName : removedMemberName) {
                        if (presentMemberName.contains(removedName)) {
                            Assert.fail("The removed member name=" + removedName + ", is found in the Edited team view=" + presentMemberName);
                        }
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheModifySteps.jpg");
            Assert.fail("the exception in verifyTheModifySteps " + exc);
        }
    }

    public void verifyCount(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                // team admin
                {
                    String input = teamAdminNumber.getText();
                    String cleanedInput = input.replaceAll("[^\\d]", "");
                    int teamAdminD = Integer.parseInt(cleanedInput);
                    if (totalTeamAdminInList != null) {
                        int teamAdminl = totalTeamAdminInList.size();
                        Assert.assertEquals(teamAdminD, teamAdminl, "The values do not match in teamAdmin: teamAdminD = " + teamAdminD + "teamAdminl= " + teamAdminl);
                    } else {
                        int teamAdminl = 0;
                        Assert.assertEquals(teamAdminD, teamAdminl, "The values do not match in teamAdmin: teamAdminD = " + teamAdminD + "teamAdminl= " + teamAdminl);
                    }
                }
                // Member
                {
                    String MemberDisplayed = membersNumber.getText();
                    String cleanedInputs = MemberDisplayed.replaceAll("[^\\d]", "");
                    int teamMemberD = Integer.parseInt(cleanedInputs);
                    if (totalMemberInList != null) {
                        int teamMemberl = totalMemberInList.size();
                        Assert.assertEquals(teamMemberD, teamMemberl, "The values do not match in member: teamMemberD = " + teamMemberD + "teamMemberl= " + teamMemberl);
                    } else {
                        int totalMemberInList = 0;
                        Assert.assertEquals(teamMemberD, totalMemberInList, "The values do not match in member: teamMemberD = " + teamMemberD + "totalMemberInList= " + totalMemberInList);
                    }
                }
                //sites
                {
                    String siteDisplayed = sitesNumber.getText();
                    String cleanedInputSites = siteDisplayed.replaceAll("[^\\d]", "");
                    int teamSitesD = Integer.parseInt(cleanedInputSites);
                    if (sitesViewTeam != null) {
                        teamSitesL = sitesViewTeam.size();
                        Assert.assertEquals(teamSitesD, teamSitesL, "The values do not match in sites: teamSitesD = " + teamSitesD + "teamSitesL= " + teamSitesL);
                    } else {
                        int sitesViewTeam = 0;
                        Assert.assertEquals(teamSitesD, sitesViewTeam, "The values do not match in sites: teamSitesD = " + teamSitesD + "sitesViewTeam= " + sitesViewTeam);
                    }
                }
                //device
                {
                    String deviceDisplayed = deviceNumber.getText();
                    String cleanedInputDevice = deviceDisplayed.replaceAll("[^\\d]", "");
                    int teamDeviceD = Integer.parseInt(cleanedInputDevice);
                    String text = devicesInTeamView.getText();
                    String[] elements = text.split(",");
                    int valueLength = elements.length;
                    if (elements != null) {
                        Assert.assertEquals(teamDeviceD, valueLength, "The values do not match in device: teamDeviceD = " + teamDeviceD + "valueLength= " + valueLength);
                    } else {
                        int sitesViewTeam = 0;
                        Assert.assertEquals(sitesViewTeam, valueLength, "The values do not match in device: sitesViewTeam = " + sitesViewTeam + "valueLength= " + valueLength);
                    }
                }
                //click on hide button
                {
                    webDriverHelper.waitUntilVisible(hideElement, 120, 1);
                    webDriverHelper.scrollToWebElement(hideElement);
                    hideElement.click();
                    Thread.sleep(3000);
                }
                //verifying total member
                {
                    String totalMembers = totalTeamMember.get(indexOfSites).getText();
                    String cleanedTotalMember = totalMembers.replaceAll("[^\\d]", "");
                    int TotalMemberD = Integer.parseInt(cleanedTotalMember);
                    if (nameViewTeamCopy != 0) {
                        Assert.assertEquals(nameViewTeamCopy, TotalMemberD, "The values do not match in totalMember: nameViewTeamCopy = " + nameViewTeamCopy + "TotalMemberD= " + TotalMemberD);
                    } else {
                        int teamMemberl = 0;
                        Assert.assertEquals(nameViewTeamCopy, teamMemberl, "The values do not match in totalMember: nameViewTeamCopy = " + nameViewTeamCopy + "teamMemberl= " + teamMemberl);
                    }
                }
                //total sites
                {
                    String totalSites = totalTeamSites.get(indexOfSites - 1).getText();
                    String cleanedTotalSites = totalSites.replaceAll("[^\\d]", "");
                    int TotalSitesD = Integer.parseInt(cleanedTotalSites);
                    if (teamSitesL != 0) {
                        Assert.assertEquals(TotalSitesD, teamSitesL, "The values do not match in totalSites: TotalSitesD =   " + TotalSitesD + "teamSitesL= " + teamSitesL);
                    } else {
                        int sitesDisplayed = 0;
                        Assert.assertEquals(sitesDisplayed, TotalSitesD, "The values do not match in totalSites: sitesDisplayed = " + sitesDisplayed + "TotalSitesD= " + TotalSitesD);
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyCountVerification.jpg");
            Assert.fail("the exception in verifyCountVerification " + exc);
        }
    }

    public void inviteTeamMember(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("teamAdmin")
                    || userRole.equalsIgnoreCase("member"))) {
                Thread.sleep(5000);
                inviteTeamMemberButton.click();
                Thread.sleep(5000);
                boolean isFirstElementPresent = false;
                boolean isSecondElementPresent = false;
                boolean isNewElementEnabled = false;
                for (WebElement tabName : newAndCurrentTab) {
                    String tabNamePresent = tabName.getText();
                    if (tabNamePresent.contains("New")) {
                        isFirstElementPresent = true;
                        if (tabName.isDisplayed()) {
                            isNewElementEnabled = true;
                        }
                    }
                    if (tabNamePresent.contains("Current")) {
                        isSecondElementPresent = true;
                    }
                }
                if (!isFirstElementPresent || !isSecondElementPresent) {
                    Assert.fail("New and Current tabs are not present");
                }
                if (!isNewElementEnabled) {
                    Assert.fail("New tab is not enabled");
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("inviteTeamMember.jpg");
            Assert.fail("inviteTeamMember" + exc);
        }
    }

    public void fillAllFieldInInviteMember(String emailNumber, String team1, String team2, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("teamAdmin")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(addButton, 90, 1);
                // Check if addButton is enabled
                {
                    try {
                        if (addButton1.isEnabled()) {
                            Assert.fail("the add button is enabled");
                        }
                    } catch (NoSuchElementException e) {
                    }
                }
                webDriverHelper.waitUntilVisible(memberFirstName, 90, 1);
                memberFirstName.sendKeys(stagFirstName);
                webDriverHelper.waitUntilVisible(memberLastName, 90, 1);
                memberLastName.sendKeys(stagLastName);
                webDriverHelper.waitUntilVisible(memberEmailId, 90, 1);
                if (emailNumber.contains("1")) {
                    emailAddress = String.valueOf(stringHelper.randomNumberGenerator()) + stagEmailId1;
                    emailAddress1 = emailAddress;
                } else if (emailNumber.contains("2")) {
                    emailAddress = String.valueOf(stringHelper.randomNumberGenerator()) + stagEmailId2;
                    emailAddress2 = emailAddress;
                }
                memberEmailId.sendKeys(emailAddress);
                Thread.sleep(3000);
                webDriverHelper.waitUntilVisible(selectRoleMember, 90, 1);
                mailIdTag.isDisplayed();
                roleTag.isDisplayed();
                teamsTag.isDisplayed();
                // select role
                selectRoleMember.click();
                for (WebElement dropDownRole : roleDropDownMember) {
                    String dropDownName = dropDownRole.getText();
                    if (dropDownName.equals(userRoleM)) {
                        dropDownRole.click();
                        break;
                    }
                }
                webDriverHelper.waitUntilVisible(selectTeamMember, 90, 1);
                selectTeamMember.click();
                Thread.sleep(1000);
                if (team1.contains("1")) {
                    teamName = newTeamName1;
                } else if (team1.contains("2")) {
                    teamName = newTeamName2;
                }
                boolean found = false;
                for (WebElement dropDownteam : teamDropDownMember) {
                    String dropDownTeamName = dropDownteam.getText();
                    if (dropDownTeamName.contains(teamName)) {
                        dropDownteam.click();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Assert.fail("The team name '" + teamName + "' not present in the team list");
                }
                if (team2.contains("1")) {
                    teamName = newTeamName1;
                } else if (team2.contains("2")) {
                    teamName = newTeamName2;
                }
                Thread.sleep(1000);
                found = false;
                for (WebElement dropDownteam : teamDropDownMember) {
                    String dropDownTeamName = dropDownteam.getText();
                    if (dropDownTeamName.contains(teamName)) {
                        dropDownteam.click();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Assert.fail("The team name '" + teamName + "' not present in the team list");
                }
                webDriverHelper.waitUntilVisible(addButton, 90, 1);
                addButton.click();
                webDriverHelper.waitUntilVisible(conFirmButtonSelectTeams, 90, 1);
                conFirmButtonSelectTeams.click();
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("inviteTeamMember.jpg");
            Assert.fail("the error in fillAllFieldInInviteNumber: " + exc);
        }
    }


    public void verifyInvitationsSentToTheUserOrNot(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("teamAdmin")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(errorToastMessageInNewInvitation, 30, 1);
                String errorMessage = errorToastMessageInNewInvitation.getText();
                if (errorToastMessageInNewInvitation.isDisplayed()) {
                    System.out.println("The error in sending invite to the member");
                    Assert.fail("The error message in UI displayed: " + errorMessage);
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (TimeoutException | NoSuchElementException e) {
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyInvitationsSendToTheUserOrNot.jpg");
            Assert.fail("verifyInvitationsSendToTheUserOrNot " + exc);
        }
    }

    public void checkSendModal(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("teamAdmin")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(invitationSendTag, 90, 1);
                boolean isInvitationSendTagPresent = invitationSendTag.isDisplayed();
                boolean isNoDonePresent = noDone.isDisplayed();
                boolean isYesInviteAnotherMemberPresent = yesInviteAnotherMember.isDisplayed();
                if (isInvitationSendTagPresent && isNoDonePresent && isYesInviteAnotherMemberPresent) {
                } else {
                    Assert.fail("One or more of the elements are not present on the page.");
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            Assert.fail("Exception in sendModal: " + exc);
            webDriverHelper.takeAScreenShot("sendModal.jpg");
        }
    }

    public void verifyingInviteOptions(String option, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("teamAdmin")
                    || userRole.equalsIgnoreCase("member"))) {
                if (option.equalsIgnoreCase("invite another")) {
                    webDriverHelper.waitUntilVisible(yesInviteAnotherMember, 90, 1);
                    String inviteAnotherText = yesInviteAnotherMember.getText();
                    Assert.assertEquals(Constants.inviteAnother, inviteAnotherText, "Invite another Text is not Matching.");
                    yesInviteAnotherMember.click();
                    Thread.sleep(1000);
                    boolean isFirstElementPresent = false;
                    boolean isSecondElementPresent = false;
                    boolean isNewElementEnabled = false;
                    for (WebElement tabName : newAndCurrentTab) {
                        String tabNamePresent = tabName.getText();
                        if (tabNamePresent.contains("New")) {
                            isFirstElementPresent = true;
                            if (tabName.isDisplayed()) {
                                isNewElementEnabled = true;
                            }
                        }
                        if (tabNamePresent.contains("Current")) {
                            isSecondElementPresent = true;
                        }
                    }
                    if (!isFirstElementPresent || !isSecondElementPresent) {
                        Assert.fail("New and Current tab is not present");
                    }
                    if (!isNewElementEnabled) {
                        Assert.fail("New tab is not enabled");
                    }
                    closeButton.click();

                } else if ("No".equalsIgnoreCase(option)) {
                    webDriverHelper.waitUntilVisible(noDone, 90, 1);
                    String noInviteText = noDone.getText();
                    Assert.assertEquals(Constants.noInvite, noInviteText, "No invitation Text is not Matching.");
                    noDone.click();
                } else {
                    Assert.fail("there are no element present expected");
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyingAfterCreation.jpg");
            Assert.fail("The exception in verifying After Creation" + exc);
        }
    }

    public void verifyTeamInTheTeamList(String teamNumber, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                String teamName = Constants.newTeamName + teamNumber + "@";
                if (teamName.contains("1")) {
                    teamName = newTeamName1;
                } else if (teamName.contains("2")) {
                    teamName = newTeamName2;
                } else if (teamName.contains("3")) {
                    teamName = newTeamName3;
                } else {
                    teamName = namePostEdit;
                }
                webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
                for (int i = 0; i < teamsNameList.size(); i++) {
                    String teamsName = teamsNameList.get(i).getText();
                    if (teamsName.equalsIgnoreCase(teamName)) {
                        view.get(i).click();
                        break;
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTeamInTheTeamList.jpg");
            Assert.fail("An error occurred while verifying the new created team: " + exc);
        }
    }

    public void verifyThePendingInvites(String emailNumber, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("member"))) {
                try {
                    webDriverHelper.waitUntilVisible(pendingInvites, 30, 1);
                    pendingInvites.isDisplayed();
                    // color verification
                    String expectedColor = "#ff683e";
                    String color = pendingInvites.getCssValue("color");
                    String actualColor = Color.fromString(color).asHex();
                    if (!actualColor.equalsIgnoreCase(expectedColor)) {
                        Assert.fail("The color is not matching");
                    }
                    webDriverHelper.waitUntilVisible(pendingInvites, 30, 1);
                    pendingInvites.click();
                    Thread.sleep(1000);
                    for (WebElement mailId : pendingInvitesEmail) {
                        String mail = mailId.getText();
                        String mailUsed;
                        if (emailNumber.contains("1")) {
                            mailUsed = emailAddress1;
                        } else {
                            mailUsed = emailAddress2;
                        }
                        if (mail.equalsIgnoreCase(mailUsed)) {
                            Assert.fail("The new user mail id is present in the list");
                        }
                    }
                    webDriverHelper.waitUntilVisible(cancelButtonInPendingInvites, 60, 1);
                    cancelButtonInPendingInvites.click();
                    webDriverHelper.waitUntilVisible(hideElement, 60, 1);
                    hideElement.click();
                    Thread.sleep(3000);
                } catch (NoSuchElementException | TimeoutException exc) {
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyThePendingInvites.jpg");
            Assert.fail("An exception occurred in verifyThePendingInvites: " + exc);
        }
    }

    public void verifyingCurrentTab(String memberNumber, String team1, String team2, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("teamAdmin")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(currentTab, 120, 1);
                currentTab.click();
                webDriverHelper.waitUntilVisible(selectMemberInCurrentTab, 120, 1);
                selectMemberInCurrentTab.click();
                if (memberNumber.contains("1")) {
                    selectMember = member1NotInAnyTeam;
                } else {
                    selectMember = member2NotInAnyTeam;
                }
                for (WebElement nameList : memberListInCurrentTab) {
                    String nameListStored = nameList.getText();
                    if (nameListStored.equalsIgnoreCase(selectMember)) {
                        webDriverHelper.waitUntilVisible(nameList, 120, 1);
                        nameList.click();
                        break;
                    }
                }
                Thread.sleep(10000);//Hard sleep as the role selection dropdown is slow loading and wait doesnot work
                selectRoleMember.click();
                for (WebElement dropDownRole : roleDropDownCurrent) {
                    String dropDownName = dropDownRole.getText();
                    if (dropDownName.equals(userRoleM)) {
                        dropDownRole.click();
                        break;
                    }
                }
                webDriverHelper.waitUntilVisible(selectTeamCurrent, 90, 1);
                selectTeamCurrent.click();
                if (team1.contains("1")) {
                    teamName = newTeamName1;
                } else if (team1.contains("2")) {
                    teamName = newTeamName2;
                } else {
                    teamName = newTeamName3;
                }
                boolean found = false;
                Thread.sleep(3000);
                for (WebElement dropDownTeam : teamDropDownMemberForCurrent) {
                    String dropDownTeamName = dropDownTeam.getText();
                    if (dropDownTeamName.contains(teamName)) {
                        dropDownTeam.click();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Assert.fail("The team name '" + teamName + "' not present in the team list");
                }
                if (team2.contains("1")) {
                    teamName2 = newTeamName1;
                } else if (team2.contains("2")) {
                    teamName2 = newTeamName2;
                } else {
                    teamName2 = newTeamName3;
                }
                found = false;
                for (WebElement dropDownteam : teamDropDownMemberForCurrent) {
                    String dropDownTeamName = dropDownteam.getText();
                    if (dropDownTeamName.contains(teamName2)) {
                        dropDownteam.click();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Assert.fail("The team name '" + teamName2 + "' not present in the team list");
                }
                webDriverHelper.waitUntilVisible(addButtonCurrentPage, 90, 1);
                addButtonCurrentPage.click();
                // verifying the teams after selecting from the dropdown
                found = false;
                for (WebElement teams : teamsAndRoleInCurrentTab) {
                    String dropDownTeamName = teams.getText();
                    String[] part = dropDownTeamName.split("\\|");
                    String value = part[1].trim();
                    if (value.contains(teamName)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Assert.fail("The team name '" + teamName + "' not present in the team list");
                }
                found = false;
                for (WebElement teams : teamsAndRoleInCurrentTab) {
                    String dropDownTeamName = teams.getText();
                    String[] part = dropDownTeamName.split("\\|");
                    String value = part[1].trim();
                    if (value.contains(teamName2)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Assert.fail("The team name '" + teamName2 + "' not present in the team list");
                }
                webDriverHelper.waitUntilVisible(confirmButtonInCurrent, 90, 1);
                confirmButtonInCurrent.click();
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyingCurrentTab.jpg");
            Assert.fail("the exception in verifyingCurrentTab " + exc);
        }
    }

    public void verifyTheCurrentPendingInvites(String userRole) {
        boolean found = false;
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("teamAdmin")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(pendingInvites, 90, 1);
                pendingInvites.isDisplayed();
                //color verification
                String expectedColor = "#ff683e";
                String color = pendingInvites.getCssValue("color");
                String actualColor = Color.fromString(color).asHex();
                if (!actualColor.equalsIgnoreCase(expectedColor)) {
                    Assert.fail("the color is not matching");
                }
                webDriverHelper.waitUntilVisible(pendingInvites, 90, 1);
                pendingInvites.click();
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (NoSuchElementException noSuchElementException) {
        } catch (Exception exc) {
            System.out.println("An exception occurred in verifyThePendingInvites: " + exc);
            found = true;
        }
    }

    public void verifyTheTag(String memberSelected, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("teamAdmin")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(pendingInviteTag, 90, 1);
                pendingInviteTag.isDisplayed();
                webDriverHelper.waitUntilVisible(name, 90, 1);
                name.isDisplayed();
                if (memberSelected.contains("1")) {
                    selectMember = member1NotInAnyTeam;
                } else {
                    selectMember = member2NotInAnyTeam;
                }
                int indexFound = -1;
                for (int i = 0; i < listOfNameInPendingInvites.size(); i++) {
                    WebElement nameInPendingInvites = listOfNameInPendingInvites.get(i);
                    String name = nameInPendingInvites.getText();
                    if (name.equalsIgnoreCase(selectMember)) {
                        indexFound = i;
                        break;
                    }
                }
                if (indexFound == -1) {
                    Assert.fail("the " + selectMember + " is not displayed in the pending invites name list");
                }
                webDriverHelper.waitUntilVisible(email, 90, 1);
                email.isDisplayed();
                Thread.sleep(3000);
//                deleteOption.get(indexFound).click();
//                webDriverHelper.waitUntilVisible(deleteInviteConfirmButton, 90, 1);
//                deleteInviteConfirmButton.click();
                webDriverHelper.waitUntilVisible(cancelButtonInPendingInvites, 90, 1);
                cancelButtonInPendingInvites.click();
                webDriverHelper.waitUntilVisible(hideElement, 90, 1);
                hideElement.click();
                Thread.sleep(3000);
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            Assert.fail("the exception in the verifying tags " + exc);
        }
    }

    public void verifyTheTagAndDeletedTheMember(String memberSelected, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("teamAdmin")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(pendingInviteTag, 90, 1);
                pendingInviteTag.isDisplayed();
                webDriverHelper.waitUntilVisible(name, 90, 1);
                name.isDisplayed();
                if (memberSelected.contains("1")) {
                    selectMember = member1NotInAnyTeam;
                } else {
                    selectMember = member2NotInAnyTeam;
                }
                int indexFound = -1;
                for (int i = 0; i < listOfNameInPendingInvites.size(); i++) {
                    WebElement nameInPendingInvites = listOfNameInPendingInvites.get(i);
                    String name = nameInPendingInvites.getText();
                    if (name.equalsIgnoreCase(selectMember)) {
                        indexFound = i;
                        break;
                    }
                }
                if (indexFound == -1) {
                    Assert.fail("the " + selectMember + " is not displayed in the pending invites name list");
                }
                webDriverHelper.waitUntilVisible(email, 90, 1);
                email.isDisplayed();
                Thread.sleep(3000);
                deleteOption.get(indexFound).click();
                webDriverHelper.waitUntilVisible(deleteInviteConfirmButton, 90, 1);
                deleteInviteConfirmButton.click();
                webDriverHelper.waitUntilVisible(cancelButtonInPendingInvites, 90, 1);
                cancelButtonInPendingInvites.click();
                webDriverHelper.waitUntilVisible(hideElement, 90, 1);
                hideElement.click();
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            Assert.fail("the exception in the verifying tags " + exc);
        }
    }

    public void editMemberRole(String userRole) {
        try {
            boolean found = false;
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(teamMemberDisplayed, 120, 1);
                webDriverHelper.waitUntilVisible(roleDisplayedTag, 30, 1);
                if (userRole.equalsIgnoreCase("orgAdmin")) {
                    for (int j = 0; j < teamMembersList.size(); j++) {
                        String nameList = teamMembersList.get(j).getText();
                        if (nameList.contains(teamAdminName)) {
                            addMemberName = teamAdminName;
                            editMember.get(j).click();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        Assert.fail("The team admin is not present in the drop down " + teamAdminName);
                    }
                } else {
                    webDriverHelper.waitUntilVisible(roleDisplayedTag, 30, 1);
                    for (int i = 0; i < roleListOfTeamMember.size(); i++) {
                        String roleList = roleListOfTeamMember.get(i).getText();
                        if (!roleList.contains("Team Admin")) {
                            addMemberName = addMemberInformation.get(i).getText();
                            editMember.get(i).click();
                            found = true;
                            break;
                        }
                        if (!found) {
                            Assert.fail("The team admin tag is not present ");
                        }
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyCountVerification.jpg");
            Assert.fail("The exception in edit Member" + exc);
        }
    }

    public void selectMultipleTeams(String teamNumber, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                //Click on the "roleDropDown" and select "Team Admin"
                webDriverHelper.waitUntilVisible(roleDropDown, 120, 1);
                roleDropDown.click();
                Thread.sleep(2000);
//                webDriverHelper.waitUntilVisible(roleDropDownOpenTag, 30, 1);
                for (WebElement dropDown : listOfRole) {
                    String dropDownName = dropDown.getText();
                    if (dropDownName.equals("Team Admin")) {
                        dropDown.click();
                        break;
                    }
                }
                //select "Team Admin" in drop down
                webDriverHelper.waitUntilVisible(selectTeamDropDown, 60, 1);
                selectTeamDropDown.click();
                if (teamName.contains("1")) {
                    teamName = newTeamName1;
                } else if (teamName.contains("2")) {
                    teamName = newTeamName2;
                } else {
                    teamName = newTeamName3;
                }
                listOfSelectedTeams = new ArrayList<>();
                listOfSelectedTeams.add(teamName);
                teamNameInEditRole = teamName;
                webDriverHelper.waitUntilVisible(selectTeamsDropDownTag, 30, 1);
                webDriverHelper.waitUntilVisible(firstTeamNameTag, 60, 1);
                for (WebElement team : listOfSelectTeams) {
                    String teamNames = team.getText();
                    if (teamNames.contains(teamName)) {
                        team.click();
                        break;
                    }
                }
                {
                    int count = 0;
                    for (WebElement team : listOfSelectTeams) {
                        if (count < 4) {
                            String teamsName = team.getText();
                            listOfSelectedTeams.add(teamsName);
                        }
                        count++;
                        team.click();
                        if (count == 5) {
                            webDriverHelper.waitUntilVisible(errorToastMessage, 120, 1);
                            String message = errorToastMessage.getText();
                            String expectedMessage = "You can not select more than 5 teams";
                            Assert.assertTrue(message.equalsIgnoreCase(expectedMessage), "the toast message is not matching expected message : " + expectedMessage + " but Actual message is " + message);
                            break;
                        }
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("selectMultipleTeams.jpg");
            Assert.fail("The exception in selectMultipleTeams: " + exc);
        }
    }

    public void checkAddTeamsOption(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(addButton, 60, 1);
                addButton.click();
                boolean found = false;
                for (String storedTeamName : listOfSelectedTeams) {
                    for (int j = 0; j < teamsSelectedWithCrossSection.size(); j++) {
                        String storedTeams = teamsSelectedWithCrossSection.get(j).getText();
                        String[] elements = storedTeams.split("\\|");
                        String firstElement = elements[0].trim();
                        if (storedTeamName.contains(firstElement)) {
                            deleteButton.get(j).isDisplayed();
                            if (!(storedTeamName.equalsIgnoreCase(teamNameInEditRole))) {
                                deleteButton.get(j).click();
                            }
                            found = true;
                        }
                    }
                    if (userRole.equalsIgnoreCase("teamAdmin")) {
                        if (!found) {
                            for (WebElement teamsName : teamsSelectedWithOutCrossButton) {
                                String storedTeams = teamsName.getText();
                                String[] elements = storedTeams.split("\\|");
                                String firstElement = elements[0].trim();
                                if ((storedTeamName.equalsIgnoreCase(firstElement))) {
                                    found = true;
                                }
                            }
                        }
                    }
                    if (!found) {
                        Assert.fail("The element is not present: " + storedTeamName);
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("addTeamsAreDisplayed.jpg");
            Assert.fail("the exception in  add page" + exc);
        }
    }

    public void verifyConfirmationToastMessageAfterMemberModification(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(conFirmButtonSelectTeams, 90, 1);
                conFirmButtonSelectTeams.click();
                webDriverHelper.waitUntilVisible(toastMessageEditMember, 90, 1);
                String toastMessage = toastMessageEditMember.getText();
                String expectedToastMessage = addMemberName + " has been modified";
                Assert.assertEquals(toastMessage, expectedToastMessage, "The toast message is not matching expected message : " + expectedToastMessage + " but Actual message is " + toastMessage);
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("inviteTeamMember.jpg");
            Assert.fail("the exception in verify Confirm Toast Message Member Modification " + exc);
        }
    }

    public void verifyTeamNameInTheTeamListAfterEditRole(String teamNumber, String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader") || userRole.equalsIgnoreCase("member"))) {
                String teamName = Constants.newTeamName + teamNumber + "@";
                if (teamName.contains("1")) {
                    teamName = newTeamName1;
                } else if (teamName.contains("2")) {
                    teamName = newTeamName2;
                } else if (teamName.contains("3")) {
                    teamName = newTeamName3;
                } else {
                    teamName = namePostEdit;
                }
                webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
                for (int i = 0; i < teamsNameList.size(); i++) {
                    String teamsName = teamsNameList.get(i).getText();
                    webDriverHelper.scrollToWebElement(teamsNameList.get(i));
                    if (teamsName.equalsIgnoreCase(teamName)) {
                        view.get(i).click();
                        break;
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTeamInTheTeamList.jpg");
            Assert.fail("An error occurred while verifying the new created team: " + exc);
        }
    }

    public void newRoleReflected(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(teamMemberDisplayed, 120, 1);
                for (int i = 0; i < addMemberInformation.size(); i++) {
                    String memberList = addMemberInformation.get(i).getText();
                    if (memberList.contains(addMemberName)) {
                        String addMemberName = roleListOfTeamMember.get(i).getText();
                        if (!addMemberName.contains("Team Admin")) {
                            Assert.fail("The team admin is not present in the " + addMemberName + " name");
                        }
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("newRoleReflected.jpg");
            Assert.fail("The Exception in the newRoleReflected" + exc);
        }
    }

    public void verifyPendingInvitesSelection(String userRole) {
        try {
            if (!(userRole.equalsIgnoreCase("orgReader") || userRole.equalsIgnoreCase("teamAdmin") || userRole.equalsIgnoreCase("sysReader")
                    || userRole.equalsIgnoreCase("member"))) {
                webDriverHelper.waitUntilVisible(teams_AdministratorsRow, 90, 1);
                for (int i = 1; i < view.size(); i++) {
                    view.get(i).click();
                    webDriverHelper.waitUntilVisible(nameTag, 60, 1);
                    Thread.sleep(1000);
                    try {
                        webDriverHelper.waitUntilVisible(inviteMember_PendingInviteButtonF, 10, 1);
                        if (inviteMember_PendingInviteButtonF.isDisplayed()) {
                            inviteMember_PendingInviteButtonF.click();
                            for (int j = 0; j < pendingInviteNames.size(); j++) {
                                sendAgain.click();
                                webDriverHelper.waitUntilVisible(sendAgainToastMessage, 90, 1);
                                String toastMessageForSend = sendAgainToastMessage.getText();
                                Assert.assertTrue(toastMessageForSend.contains(Constants.sendAgainMessageInPendingInvites), "The toast message is not matching after clicking on send button for sendAgain");
                            }
                            Thread.sleep(3000);
                            webDriverHelper.waitUntilVisible(sendAgainAll, 30, 1);
                            sendAgainAll.click();
                            webDriverHelper.waitUntilVisible(sendAgainToastMessage, 60, 1);
                            String toastMessageForSendAll = sendAgainToastMessage.getText();
                            Assert.assertTrue(toastMessageForSendAll.contains(Constants.sendAgainAllMessageInPendingInvites), "The toast message is not matching after clicking on send button for sendAgainAll");
                            break;
                        }
                    } catch (TimeoutException e) {
                        hideElement.click();
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(headerTitles, 90, 1);
                Assert.assertTrue(memberTag.getText().equalsIgnoreCase("Members"));
            }
        } catch (Exception exc) {
            Assert.fail("the exception in verifyPendingInvitesSelection " + exc);
        }
    }

}



