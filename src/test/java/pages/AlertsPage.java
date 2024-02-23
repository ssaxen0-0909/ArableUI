package pages;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import support.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static support.PropertiesReader.orgTargeted;
import static support.WebDriverHelper.wait;
import static support.World.*;
import static support.World.teamsApiHelper;


public class AlertsPage {

    private static final Logger log = LogManager.getLogger(AlertsPage.class);

    private final WebDriver driver;
    @FindBy(xpath = "//div[@class='activities']//div[1]//div[1]//div[1]//img[1] | //div[@class='activity no-records'] ")
    WebElement alertsTable;
    //    @FindAll({@FindBy(xpath = "//div[@class='navigation']/ul[1]/li/div/a")})
//    private List<WebElement> dashboardMenuF;
    @FindAll({@FindBy(xpath = "//ul[@class='menu-items']")})
    private List<WebElement> dashboardMenuF;
    @FindBy(xpath = "//div[@class='activity no-records']")
    private WebElement alertsRecords;

    @FindBy(css = "div[class='grid message-list'] p")
    private WebElement alertsNoTable;
    @FindBy(xpath = "//p[normalize-space()='Alerts']")
    private WebElement dashboardMenu_Alerts;
    @FindBy(xpath = "//div[@class='badge']")
    private WebElement alerts_Badge;
    @FindBy(xpath = "//a[normalize-space()='View More Activity']")
    private WebElement viewMoreButton;
    @FindAll(@FindBy(xpath = "(//div[@class='activity ng-star-inserted'])"))
    private List<WebElement> activityRow;
    //    @FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown categories']//span[@class='caret 0']")
//    private WebElement filter_DropDown;
    @FindBy(xpath = "//div[@class='column-5']//div[5]")
    private WebElement filter_Unread;
    @FindAll(@FindBy(xpath = "//body/arable-app/main[@class='chrome windows with-headers isSites']/arable-activity-tab/div[@class='activity-tab']/div[@class='titles']/div[@class='grid']/div[@class='column-5']/div[@class='category-filter']/arable-dropdown-selector[@class='input-dropdown categories']/div[@class='dropdown-selector 0 open']/div[@class='options']/div"))
    private List<WebElement> filter_Options;
    @FindBy(xpath = "//span[@class='1 caret']")
    private WebElement orgDropdown_Openbuton;
    //    @FindBy(xpath = "//div[@class='dropdown-selector 1 open']//div[@class='grid grid-center option']")
//    private WebElement orgDropdown_orgList;
    @FindBy(xpath = "(//div[@class='grid summary'])[1]")
    private WebElement alertsActivityRow1;
    @FindBy(xpath = "(//span[@class='icon-plus'])[1]")
    private WebElement alertsActivityPlusIcon;
    @FindBy(xpath = "//div[@class='grid detail']")
    private WebElement alertsActivityDetails;
    @FindBy(xpath = "//div[@class='activity no-records']")
    private WebElement alertsActivityNoRecords;
    //    @FindBy(xpath = "//p[@class='selected 0'][normalize-space()='Date']")
//    private WebElement defaultDateFilter;
    //----------new xpath after angular merge
    @FindBy(xpath = "//span[@class='0 caret']")
    private WebElement filter_DropDown;
    @FindBy(xpath = "(//div[@class='1 dropdown-selector open']//div[@class='options']//p)[2]")
    private WebElement orgDropdown_orgList;
    @FindBy(xpath = "(//div[@class='0 dropdown-selector']//p[normalize-space()='Date'])[1]")
    private WebElement defaultDateFilter;
    @FindBy(xpath = "//p[normalize-space()='Analysis']")
    private WebElement dashboardMenu_Analysis;
    @FindBy(xpath = "//span[@class='icon-plus']")
    private List<WebElement> plusIcon;
    @FindBy(xpath = "//a[text()= 'View More Activity']")
    private WebElement viewMoreActivityButton;
    @FindBy(xpath = "//button[@aria-label='Open live chat']")
    private WebElement openLiveChatBtn;
    @FindBy(xpath = "//div[@class='menu-button']")
    private WebElement menuBtnInAlertsPage;
    @FindBy(xpath = "//div[@class='button' and contains(text(),'Mark all as read')]")
    private WebElement markAllAsReadBtn;
    @FindAll({@FindBy(xpath = "//span[@class='icon-plus']")})
    private List<WebElement> plusIconBtn;
    @FindAll({@FindBy(xpath = "//div[@class='column-5 padding-tex']/img")})
    private List<WebElement> alertBadgeIcon;
    @FindBy(xpath = "//div[@class='success toast']/div[@class='body']/h3")
    private WebElement toastMsg;
    @FindBy(xpath = "(//div[@class='activity'])[1]")
    private WebElement firstAlertActivity;
    @FindBy(xpath = "//div[@class='activity no-records']")
    private WebElement noRecordsText;
    @FindBy(xpath = "(//div[@class='column-auto']//span)[2]")
    private WebElement teamsDropdown;
    @FindBy(xpath = "//div[@class='team-selector']//following-sibling::div[@class='options']//following-sibling::div[@class='grid grid-center option']//div//following-sibling::p")
    private List<WebElement> teamsDropdownList;
    @FindBy(xpath = "(//div[@class='column-auto']//span)[1]")
    private WebElement organizationDropdown;
    @FindAll({@FindBy(xpath = "(//div[text()='Organization']//..//following-sibling::div//following-sibling::div)[2]//following-sibling::p")})
    private List<WebElement> organizationDropdownList;
    @FindBy(xpath = "//div[@class='column-20']/p[@class='highlight']")
    private List<WebElement> alertNames;
    @FindBy(xpath = "//div[@class='badge']")
    private WebElement alertCountBadge;
    @FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown categories']//div[@class='column-auto']/span")
    private WebElement dateDropdown;
    @FindAll({@FindBy(xpath = "//div[@class='category-filter']//div[contains(@class,'grid grid-center option')]/p")})
    private List<WebElement> activitiesInDropdown;

    List<String> alertsActivities = new ArrayList<>();

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
//        webDriverHelper.waitUntilVisibilityOfAllElements(dashboardMenuF, 30, 1);
//        for (WebElement element : dashboardMenuF) {
//            if (element.getAttribute("title").equalsIgnoreCase(page)) {
//                element.click();
//            }
//        }
        map.navigateToPage(role);
        webDriverHelper.waitUntilVisible(dashboardMenu_Alerts, 30, 1);
//        StringHelper.devToolCapture(role);
        dashboardMenu_Alerts.click();
    }

//    public void captureAlertsPageLoadTime(String role) throws IOException, InterruptedException {
////        StringHelper.devToolCapture(role);
//        long start = System.currentTimeMillis();
//        webDriverHelper.waitUntilVisible(alertsTable, 30, 1);
//        if (alertsTable.isDisplayed()) {
//            String loadInSeconds = stringHelper.stopTime(start, driver);
//            ExcelReader.setValueForColumn("Alerts", loadInSeconds, role);
//            Assert.assertTrue(alertsTable.isDisplayed(), "alerts table is displayed");
    // HTML report generator
//            HTMLReport.addPageName("Alerts");
//            HTMLReport.generateReport("Alerts", loadInSeconds, role);
//            HTMLReport.writeReportToFile();
//        } else {
//            webDriverHelper.waitUntilVisible(alertsTable, 30, 1);
//            String loadInSeconds = stringHelper.stopTime(start, driver);
//            ExcelReader.setValueForColumn("Alerts", loadInSeconds, role);
//            Assert.assertTrue(alertsTable.isDisplayed(), "No alerts table is displayed");
//            // HTML report generator
//            HTMLReport.addPageName("Alerts");
////            HTMLReport.generateReport("Alerts", loadInSeconds, role);
//            HTMLReport.writeReportToFile();
//        }
//    }}

    public void verifyDefaultDateFilter(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(alertsTable, 30, 1);
        if (defaultDateFilter.isDisplayed()) {
            Assert.assertTrue(defaultDateFilter.isDisplayed(), "Default filter is date");
        } else {
            Assert.assertTrue(!defaultDateFilter.isDisplayed(), "Default filter is not date");
        }
    }

    public void verifyReadingActivity(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(alertsTable, 30, 1);
        try {
            if (alertsTable.isDisplayed()) {
                alertsActivityPlusIcon.click();
                webDriverHelper.waitUntilVisible(alertsActivityDetails, 30, 1);
                Thread.sleep(3000);
                String activityDetails = alertsActivityDetails.getText();
                Assert.assertTrue(activityDetails.contains("Type"));
            } else {
                Assert.assertTrue(alertsActivityNoRecords.isDisplayed(), "No alerts table is displayed");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("not a number");
        }
    }

    public void verifyAlertsOnOrgSwitch(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(alertsTable, 30, 1);
        String activity1 = alertsActivityRow1.getText();
        Thread.sleep(500);
        orgDropdown_Openbuton.click();
        Thread.sleep(200);
        if (!(role.equalsIgnoreCase("orgAdmin") || role.equalsIgnoreCase("sysReader"))) {
            webDriverHelper.waitUntilVisible(orgDropdown_orgList, 30, 1);
            orgDropdown_orgList.click();
            Thread.sleep(6000);
            webDriverHelper.waitUntilVisible(alertsActivityRow1, 30, 2);
            String newActivity1 = alertsActivityRow1.getText();
            Assert.assertNotEquals(newActivity1, activity1);
        }
    }

    public void verifyViewMoreButton(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(alertsTable, 30, 1);
        try {
            if (alertsTable.isDisplayed()) {
                String alertBadgeCount = alerts_Badge.getText();
                System.out.println("alertBadgeCount" + alertBadgeCount);
                filter_DropDown.click();
                webDriverHelper.waitUntilVisible(filter_Unread, 30, 1);
                Thread.sleep(3000);
                filter_Unread.click();
                Thread.sleep(6000);

                if (alertBadgeCount.contains("+")) {
                    String alertBadgeNumCount = alerts_Badge.getText().substring(0, 2);
                    System.out.println("alertBadgeNumCount" + alertBadgeNumCount);
                    int alertCount = Integer.parseInt(alertBadgeNumCount);
                    System.out.println(alertCount);
                    if (alertCount > 15) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewMoreButton);
                        Assert.assertTrue(viewMoreButton.isDisplayed(), "alerts table is displayed");
                    }
                }
                Assert.assertTrue(alertsTable.isDisplayed(), "alerts table is displayed");
            } else {
                Assert.assertTrue(!alertsTable.isDisplayed(), "No alerts table is displayed");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("not a number");
        }
    }

    public void verifyFilterOptions(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(alertsTable, 30, 1);
        try {
            if (alertsTable.isDisplayed()) {
                filter_DropDown.click();
                webDriverHelper.waitUntilVisible(filter_Unread, 30, 1);
                Thread.sleep(3000);
                for (WebElement filterName : filter_Options) {
                    String options = filterName.getText();
                    System.out.println(options);
                    Assert.assertTrue(filterName.isDisplayed(), "No alerts filter is displayed");
                }
            } else {
                Assert.assertTrue(!alertsTable.isDisplayed(), "No alerts table is displayed");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("not a number");
        }
    }

    public void navigateToAlertsPage(String userRole) {
        try {
            webDriverHelper.waitUntilVisible(dashboardMenu_Analysis, 30, 1);
            Actions action = new Actions(driver);
            action.moveToElement(dashboardMenu_Analysis).moveToElement(dashboardMenu_Alerts).click().build().perform();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("navigateToAlertsPage.jpg");
            Assert.fail("Failed in navigateToAlertsPage method due to exception:- " + exc);
        }
    }

    public void verifyAlertCount() {
        SoftAssert assertion = new SoftAssert();
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(plusIcon, 30, 1);
            int numberOfAlerts = plusIcon.size();
            if (numberOfAlerts > 15 || numberOfAlerts == 15) {
                assertion.assertEquals(numberOfAlerts, 15);
                assertion.assertAll();
            } else {
                log.info("The alerts displayed are less than 15");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyAlertCount.jpg");
            Assert.fail("Failed in verifyAlertCount method due to exception:- " + exc);
        }
    }

    public void scrollDownAndVerifyViewMoreActivityBtnIsPresent() {
        SoftAssert assertion = new SoftAssert();
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(plusIcon, 30, 1);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            int numberOfAlerts = plusIcon.size();
            if (numberOfAlerts > 15 || numberOfAlerts == 15) {
                webDriverHelper.waitUntilVisible(viewMoreActivityButton, 30, 1);
                assertion.assertTrue(viewMoreActivityButton.isDisplayed(), "View More Activity Button is not present in the DOM");
                assertion.assertAll();
            } else {
                log.info("The alerts displayed are less than 15");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("scrollDownAndVerifyViewMoreActivityBtnIsPresent.jpg");
            Assert.fail("Failed in scrollDownAndVerifyViewMoreActivityBtnIsPresent method due to exception:- " + exc);
        }
    }

    public void verifyAlertCountBadge() {
        try {
            Thread.sleep(3000); // for loading the page once clicked
            if (alertCountBadge.isDisplayed()) {
                Assert.fail("Failed because still there some are unread alerts in the 'Alert' page after selecting 'Mark all as read'.");
            }
        } catch (Exception exc) {
            log.info("The alerts have been reduced to 'Zero' after selecting 'Mark all as read'");
        }
    }

    public void clickOnMarkAsReadAndVerifyTheUnreadCount() {
        try {
            webDriverHelper.waitUntilVisible(menuBtnInAlertsPage, 60, 1);
            menuBtnInAlertsPage.click();
            webDriverHelper.waitUntilVisible(markAllAsReadBtn, 60, 1);
            markAllAsReadBtn.click();
            webDriverHelper.waitUntilVisible(toastMsg, 60, 1);
            Assert.assertEquals(toastMsg.getText(), Constants.alertsSuccessMsg, "Failed to verify the toast msg when clicked on 'Mark all as read'");
            verifyAlertCountBadge();
            try {
                webDriverHelper.waitUntilVisible(noRecordsText, 5, 1);
                if (noRecordsText.isDisplayed()) {
                    log.info("There is no result to verify the details");
                }
            } catch (Exception exc) {
                webDriverHelper.waitUntilVisibilityOfAllElements(alertBadgeIcon, 60, 1);
                for (WebElement element : alertBadgeIcon) {
                    String alertBadgeImgAttribute = element.getAttribute("src");
                    if (!alertBadgeImgAttribute.contains("read")) {
                        Assert.fail("Failed to change the alert badge icon color to grey after clicking on 'Mark all as read'.");
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnMarkAsReadAndVerifyTheUnreadCount.jpg");
            Assert.fail("Failed in clickOnMarkAsReadAndVerifyTheUnreadCount method due to exception:- " + exc);
        }
    }

    public void verifyTheEndPointResponseWhenUserClicksOnMarkAllAsRead(String role) {
        try {
            teamsApiHelper.getAuthToken();
            teamsApiHelper.getOrgId(orgTargeted);
            Response apiResult = alertsApiHelper.getResponse();
            if (!apiResult.getBody().asString().contains("200")) {
                Assert.fail("Failed to verify the 200 text response in body from the clear API call");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheEndPointResponseWhenUserClicksOnMarkAllAsRead.jpg");
            Assert.fail("Failed in verifyTheEndPointResponseWhenUserClicksOnMarkAllAsRead method due to exception :- " + exc);
        }
    }

    public void selectASpecificTeamWhichHasUnreadAlerts() {
        try {
            webDriverHelper.waitUntilVisible(menuBtnInAlertsPage, 60, 1);
            webDriverHelper.waitUntilVisible(teamsDropdown, 60, 1);
            teamsDropdown.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(teamsDropdownList, 200, 1);
            for (int i = 0; i < teamsDropdownList.size(); i++) {
                if (teamsDropdownList.size() != 0) {
                    teamsDropdownList.get(i).click();
                    break;
                }
                if (teamsDropdownList.size() == 0) {
                    Assert.fail("There is no any other team to switch ");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectASpecificTeamWhichHasUnreadAlerts.jpg");
            Assert.fail("Failed in selectASpecificTeamWhichHasUnreadAlerts method due to exception :- " + exc);
        }
    }

    public void checkTheAlertsActivityWhenTheUserChangeTheOrganization() {
        try {
            webDriverHelper.waitUntilVisible(firstAlertActivity, 60, 1);
            webDriverHelper.waitUntilVisibilityOfAllElements(alertNames, 60, 1);
            List<String> alertBadgeNames = new ArrayList<>();
            for (WebElement element : alertNames) {
                String alertName = element.getText();
                alertBadgeNames.add(alertName);
            }
            log.info("alertBadgeNames :- " + alertBadgeNames);
            webDriverHelper.waitUntilVisible(organizationDropdown, 60, 1);
            organizationDropdown.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(organizationDropdownList, 100, 1);
            if (organizationDropdownList.size() > 1) {
                for (WebElement webElement : organizationDropdownList) {
                    String orgName = webElement.getText();
                    if (!(orgName.equalsIgnoreCase(orgTargeted) || orgName.equalsIgnoreCase("arable-deprecated"))) {
                        webElement.click();
                        webDriverHelper.waitUntilVisible(menuBtnInAlertsPage, 30, 1);
                        Thread.sleep(5000); // for loading the page
                        try {
                            webDriverHelper.waitUntilVisible(noRecordsText, 10, 1);
                            if (noRecordsText.isDisplayed()) {
                                log.info("There is no records to verify");
                            }
                        } catch (Exception exc) {
                            webDriverHelper.waitUntilVisible(firstAlertActivity, 30, 1);
                            webDriverHelper.waitUntilVisibilityOfAllElements(alertNames, 60, 1);
                            List<String> alertBadgeNamesAfterOrgChange = new ArrayList<>();
                            for (WebElement element : alertNames) {
                                String alertName = element.getText();
                                alertBadgeNamesAfterOrgChange.add(alertName);
                            }
                            log.info("alertBadgeNamesAfterOrgChange :- " + alertBadgeNamesAfterOrgChange);
                            boolean listsAreEqual = alertBadgeNames.equals(alertBadgeNamesAfterOrgChange);
                            if (listsAreEqual) {
                                Assert.fail("Failed because the alerts are not changing according to organization change");
                            }
                        }
                    }
                    break;
                }
            } else {
                log.info("There is no any other organization apart from 'arable-team'");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_checkTheAlertsActivityWhenTheUserChangeTheOrganization.jpg");
            Assert.fail("Failed in checkTheAlertsActivityWhenTheUserChangeTheOrganization method due to exception :-" + exc);
        }
    }

    public void clickOnDateDropdownAndSelect(String dropdownName) {
        try {
            webDriverHelper.waitUntilVisible(firstAlertActivity, 60, 1);
            webDriverHelper.waitUntilVisible(dateDropdown, 60, 1);
            dateDropdown.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(activitiesInDropdown, 60, 1);
            for (WebElement element : activitiesInDropdown) {
                String activityName = element.getText();
                if (activityName.equalsIgnoreCase(dropdownName)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnDateDropdownAndSelect.jpg");
            Assert.fail("Failed in clickOnDateDropdownAndSelect method due to exception :- " + exc);
        }
    }

    public void verifyTheAlertCountInApiAndUI() {
        try {
            webDriverHelper.waitUntilVisible(viewMoreButton, 10, 1);
            if (viewMoreButton.isDisplayed()) {
                for (int i = 0; i < 2; i++) {
                    webDriverHelper.waitUntilVisibilityOfAllElements(alertNames, 60, 1);
                    for (WebElement element : alertNames) {
                        String activityNames = element.getText();
                        alertsActivities.add(activityNames);
                    }
                    int limitCount = 0;
                    limitCount = alertsActivities.size();
                    if (i > 0) {
                        limitCount = alertsActivities.size() - (i * 15);
                        log.info("limitCount " + limitCount);
                    }
                    pageNo = i + 1;
                    alertsApiHelper.getTotalCountInNotificationApi();
                    Assert.assertEquals(alertsLimitPerPage, String.valueOf(limitCount), "Failed to verify the alerts limit count per page in both UI and API");
                    Assert.assertEquals(alertPageNo, String.valueOf(pageNo), "Failed to verify the page no in both UI and API");
                    alertsActivities.clear();
                    webDriverHelper.waitUntilVisible(viewMoreButton, 60, 1);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewMoreButton);
                    viewMoreButton.click();
                    Thread.sleep(5000); //for loading all the activities
                }
            }
        } catch (Exception exc) {
            webDriverHelper.waitUntilVisibilityOfAllElements(alertNames, 60, 1);
            for (WebElement element : alertNames) {
                String activityNames = element.getText();
                alertsActivities.add(activityNames);
            }
            int limitCount = 0;
            limitCount = alertsActivities.size();
            pageNo = 1;
            alertsApiHelper.getTotalCountInNotificationApi();
            Assert.assertEquals(alertsLimitPerPage, String.valueOf(limitCount), "Failed to verify the alerts limit count per page in both UI and API");
            Assert.assertEquals(alertPageNo, String.valueOf(pageNo), "Failed to verify the page no in both UI and API");
        }
    }

    public void verifyTheActivityCountInBothUIAndApi() {
        try {
            teamsApiHelper.getAuthToken();
            teamsApiHelper.getOrgId(orgTargeted);
            try {
                webDriverHelper.waitUntilVisible(noRecordsText, 10, 1);
                if (noRecordsText.isDisplayed()) {
                    log.info("There is no result to verify the alerts count in both API and UI");
                }
            } catch (Exception exc) {
                verifyTheAlertCountInApiAndUI();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheActivityCountInBothUIAndApi.jpg");
            Assert.fail("Failed in verifyTheActivityCountInBothUIAndApi method due to exception: " + exc);
        }
    }

}
