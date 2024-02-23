package pages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.*;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static support.BrowserCreation.driver;
import static support.WaterAPIHelper.fetchJSONResponse;
import static support.World.*;
import static support.World.token;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SeasonsPage {

    String dateString = null;
    double gddCumulative = 0.0;
    private double nextDayGddCumulative;
    private Date nextDayDate;
    String date = null;

    private final WebDriver driver;
    @FindBy(css = "div[class='grid body-list season-row last-row'] div[class='season-column site']")
    WebElement seasonsTableLastRow;
    private String upcomingInitialValue;
    @FindAll({@FindBy(xpath = "//ul[@class='menu-items']/li/a")})
    private List<WebElement> dashboardMenuF;
    @FindBy(xpath = "//p[normalize-space()='Settings']")
    private WebElement dashboardMenu_Settings;
    @FindBy(xpath = "//p[normalize-space()='Seasons']")
    private WebElement dashboardMenu_Seasons;
    @FindBy(xpath = "//div[@class='actions']/div")
    private WebElement createNewSeasonsButtonF;
    @FindAll({@FindBy(xpath = "//div[@class='actions']")})
    private List<WebElement> createNewSeasonsButtonF1;
    @FindBy(xpath = "//div[@class='seasons-table']/div[1]")
    private WebElement seasonsTableHeaderF;
    @FindBy(css = "div[class='grid message-list'] p")
    private WebElement seasonsNoTable;
    @FindBy(xpath = "//div[@class='seasons-header']/div[2]/div[2]/div[3]/div/span")
    private WebElement seasonsHeaderUpcomingF;
    @FindBy(xpath = "//div[@class='seasons-header']/div[2]/div[2]/div[1]/div/span")
    private WebElement seasonsHeaderCurrentF;
    @FindBy(xpath = "//div[@class='modal fade in show']//button[@class='btn-close']")
    private WebElement CreateSeasonPopupCancelF;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='content-modal']/arable-dropdown-selector[1]/div")
    private WebElement siteDropdownF;
    @FindAll({@FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown regions']//div[@class='options']/div")})
    private List<WebElement> siteDropdownListF;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='content-modal']/arable-dropdown-selector[2]/div")
    private WebElement cropTypeDropdownF;
    @FindAll({@FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown crop']//div[@class='options']/div")})
    private List<WebElement> cropTypeDropdownListF;

    /*The xpath is for Growth stage tracking to create a new season in GDD and Days mode */

    @FindBy(xpath = "//arable-dropdown-selector[@id='arableCropGrowthStageTrackingIdDisabled']//div[@class='0 dropdown-selector']//div[@class='0 grid grid-center headers disabled']")
    private WebElement growthStageTrackingDisabled;
    @FindBy(xpath = "//arable-dropdown-selector[@id='arableCropGrowthStageTrackingIdEnabled']//div[@class='0 dropdown-selector']//div[@class='0 grid grid-center headers']")
    private WebElement growthStageTrackingDropdownEnabled;
    @FindAll({@FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='grid grid-center option selected']")})
    private WebElement growthStageTrackingGddMode;
    @FindAll({@FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown growth-stage']/div/div[2]/div[1]/p")})
    private WebElement growthStageTrackingDaysMode;

    /*The xpath is for adding, editing and deleting of the growth stages for a selected season in GDD and Days mode*/

    @FindBy(xpath = "//div[@class='menu borders']//div[@class='menu-button-container']")
    private WebElement growthStageMenuButton;
    @FindBy(xpath = "//div[@class='menu-content']//div[1]")
    private WebElement addNewStage;
    @FindBy(xpath = "(//div[@class='menu-content'])[1]/div/img")
    private WebElement deleteAllStages;
    @FindBy(xpath = "//div[@class='menu-content']")
    private WebElement addNewDeleteAllStage;
    @FindBy(xpath = "//div[@class='container']//input[@placeholder='Add GDDs']")
    private WebElement inputGddValue;
    @FindBy(xpath = "//div[@class='growth-stages-table']/div/div[2]/div/div[2]/textarea")
    private WebElement inputGrowthStage;
    @FindBy(xpath = "//img[@alt='cancel']")
    private WebElement addNewStageCancelButton;
    @FindBy(xpath = "//div[@class='btn btn-save']//img[@alt='save']")
    private WebElement addNewStageSaveButton;
    @FindBy(xpath = "//div[@class='success toast']")
    private WebElement growthStagesSavedSuccessToastMessage;
    @FindBy(xpath = "//div[@class='growth-stages-table']/div/div[2]/div[1]/div[3]")
    private WebElement editDeleteGrowthStageMenuButton;
    @FindBy(xpath = "//div[@class='growth-stages-table']/div/div[2]/div[1]/div[3]/arable-dotted-menu[@class='menu']/div/div[2]/div[1]")
    private WebElement editGrowthStageButton;
    @FindBy(xpath = "//div[@class='growth-stages-table']/div/div[2]/div[1]/div[3]/arable-dotted-menu[@class='menu']/div/div[2]/div[2]")
    private WebElement deleteGrowthStageButton;
    @FindBy(xpath = "//div[@class='tooltip-growth-stage']/div[3]/arable-request-button")
    private WebElement deleteGrowthStageConfirmF;
    @FindBy(xpath = "//arable-growth-stages-table/div/div/div[2]/div/div/p")
    private WebElement emptyGrowthStageTable;

    @FindBy(xpath = "(//div[@class='action-buttons'])[1]/arable-request-button")
    private WebElement confirmButtonF;
    @FindBy(xpath = "//div[@class='modal fade in show']//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement confirmButtonR;
    @FindBy(xpath = "//div[@class='btn btn-hide']")
    private WebElement newSeasonHideSettingsF;
    @FindBy(xpath = "(//div[@class='season-column settings'])[1]/div/img")
    private WebElement hideSettingsButton;
    @FindBy(xpath = "//div[@class='date-container'][1]/div[2]")
    private WebElement startDateF;
    @FindBy(xpath = "//div[@class='date-container'][2]/div[2]")
    private WebElement endDateF;
    @FindBy(xpath = "(//div[@class='actions'])[3]/arable-request-button")
    private WebElement saveSeasonButtonF;
    @FindBy(xpath = "(//div[@class='menu-button-container'])[1]")
    private WebElement menuButtonF;
    @FindBy(xpath = "(//div[@class='button'])[1]")
    private WebElement deleteButtonF;
    @FindBy(xpath = "//div[@class='content']//arable-request-button//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement deleteSeasonConfirmF;
    @FindBy(xpath = "//div[@class='datepicker-container start']")
    private WebElement datePickerF;
    @FindBy(xpath = "(//button[@class='btn btn-default btn-secondary btn-sm'])[1]")
    private WebElement startCalenderHeaderF;
    @FindBy(xpath = "(//button[@class='btn btn-default btn-secondary btn-sm'])")
    private WebElement endCalenderHeaderF;
    @FindBy(xpath = "(//button[@class='btn btn-default btn-sm'])[2]")
    private WebElement calenderYearHeaderF;
    @FindAll({@FindBy(xpath = "//button[@class='btn btn-default btn-link']")})
    private List<WebElement> calenderYearListF;
    @FindAll({@FindBy(xpath = "//button[@class='btn btn-default btn-link']")})
    private List<WebElement> calenderMonthListF;
    @FindBy(xpath = "//div[@class='success toast']")
    private WebElement toastMessageF;
    @FindAll({@FindBy(xpath = "//div[@class='toast success']/div[2]/p")})
    private List<WebElement> toastMessageF1;
    @FindBy(xpath = "(//div[@class='season-column settings'])[1]/div/img")
    private WebElement showSettingsButton;
    @FindBy(xpath = "//img[@alt='copy']")
    private WebElement copySeasonBtn;
    @FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown sites']//p[@class='0 title'][normalize-space()='Select Site']")
    private WebElement selectSiteDropdown;
    @FindBy(xpath = " //div[@class='0 dropdown-selector open']//div[1]//label[1]")
    private WebElement firstCheckbox;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='column-auto']")
    private WebElement closeDropdown;
    @FindBy(xpath = "//h1[normalize-space()='With Errors']")
    private WebElement copySeasonErrorTitle;
    @FindBy(xpath = "//h1[normalize-space()='Created seasons']")
    private WebElement copySeasonSuccessTitle;
    @FindBy(xpath = "//div[normalize-space()='invalid data or dates conflict with an existing season']")
    private WebElement copySeasonErrorMsg;
    @FindBy(xpath = " //div[contains(text(),'Name')]")
    private WebElement copySeasonSummaryModal;
    @FindBy(xpath = "//div[@class='title-info']")
    private WebElement copySeasonSummaryModalTitleInfo;
    @FindBy(xpath = "//button[normalize-space()='Close']")
    private WebElement copySeasonSummaryModalCloseBtn;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='head-tooltip']")
    private WebElement copySeasonModalTitle;

    /* The date picker is not working properly, the issue is raised and will change the xpath once issue is fixed
       Ticket ID : https://sprints.zoho.com/team/arableeng#itemdetails/P45/I596 */
    @FindBy(xpath = "(//span[@ng-reflect-ng-class='[object Object]'][normalize-space()='20'])[1]")
    private WebElement startDate;
    @FindBy(xpath = "(//span[@ng-reflect-ng-class='[object Object]'][normalize-space()='21'])[2]")
    private WebElement endDate;
    @FindBy(xpath = "//div[@class='grid body-list season-row']")
    private List<WebElement> seasonsList;
    @FindBy(xpath = "//div[@class='grid body-list season-row']//div[@class='btn btn-show']")
    private List<WebElement> seasonsListPlusBtn;
    @FindBy(xpath = "//a[normalize-space()='View More Seasons']")
    private WebElement loadMoreBtn;
    @FindBy(xpath = "((//div[@class='season-datepicker']//div[@class='date-container'])[1]//div)[2]")
    private WebElement seasonStartDate;
    @FindBy(xpath = "//div[@class='menu borders']//div[@class='menu-button']")
    private WebElement seasonsAddGrowthStageMenuBtn;
    @FindBy(xpath = "//div[@class='menu-content']//div[1]")
    private WebElement seasonsAddNewStageBtn;
    @FindBy(xpath = "//div[@class='days-from-start-datepicker']//div[@class='icon-calendar']")
    private WebElement seasonsAddNewStageCalendarBtn;
    @FindBy(xpath = "//div[@class='datepicker-container']//table[@role='grid']")
    private WebElement seasonsAddNewStageCalendar;
    @FindBy(xpath = "(//td[contains(@class, 'text-center')]/button[contains(@class, 'btn btn-sm btn-info active btn-default')])[3]")
    private WebElement seasonsAddNewStageCalendarDateSelected;
    @FindBy(xpath = "//p[@class='menu-margin']")
    private WebElement seasonsNewForecastedGDDUnit;

    public SeasonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    JSONObject jsonObject = null;

    public void fetchSiteNameWithDaysMode(String role) throws IOException, InterruptedException {
        SeasonAPIHelper.devToolCaptureGrowthStageWithValue(role);

        String token = teamsApiHelper.getAuthToken();

        String siteName = SeasonAPIHelper.fetchSiteNameWithDaysMode(token);
        System.out.println("Site Name with mode 'days' in method: " + siteName);

        boolean siteNameFound = false;

        while (!siteNameFound) {
            for (int i = 0; i < seasonsList.size(); i++) {
                WebElement season = seasonsList.get(i);
                String seasonName = season.getText();
                if (seasonName.contains(siteName)) {
                    WebElement plusBtn = seasonsListPlusBtn.get(i);
                    SeasonAPIHelper.devToolCaptureGrowthStageMetricsValue(role);
                    plusBtn.click();
                    siteNameFound = true;
                    break;
                }
            }

            if (!siteNameFound) {
                loadMoreBtn.click();
                webDriverHelper.waitUntilVisible(loadMoreBtn, 10, 1);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loadMoreBtn);
                PageFactory.initElements(driver, this);
            }
        }
    }

    public void fetchGDDCumulativeAndDateFromAPI(String role) throws IOException, InterruptedException, ParseException {
        fetchSiteNameWithDaysMode(role);
        String startDate = seasonStartDate.getText();
        System.out.println("startDate:-" + startDate);

        teamsApiHelper.getAuthToken();
        String requiredUrlGrowthStageMetrics = SharedData.specificRequestUrl;
        System.out.println("requiredUrlGrowthStageMetrics:-" + requiredUrlGrowthStageMetrics);
        String jsonResponse = fetchJSONResponse(requiredUrlGrowthStageMetrics, token);
        jsonObject = new JSONObject(jsonResponse);
        System.out.println("jsonObject:-" + jsonObject);
        nextDayMethod(startDate);
    }

    private void nextDayMethod(String startDate) throws ParseException {
        JSONArray metricsArray = jsonObject.getJSONArray("metrics");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date startDateDate = dateFormat.parse(startDate);

        for (int j = 0; j < metricsArray.length(); j++) {
            JSONObject metricObject = metricsArray.getJSONObject(j);
            dateString = metricObject.getString("date");
            System.out.println("dateString: " + dateString);
            gddCumulative = metricObject.getDouble("gdd_cumulative");
            System.out.println("gddCumulative:" + gddCumulative);

            SimpleDateFormat apiDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date metricDate = apiDateFormat.parse(dateString);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDateDate);
            calendar.add(Calendar.DATE, 1);

            if (metricDate.compareTo(calendar.getTime()) == 0) {
                nextDayDate = metricDate;
                System.out.println("Next day's date: " + nextDayDate);
                nextDayGddCumulative = gddCumulative;
                System.out.println("gddCumulative for the next day: " + gddCumulative);
                break;
            }
        }
    }

    public void setGDDForecastDate(String role) throws IOException, ParseException, InterruptedException {
        fetchGDDCumulativeAndDateFromAPI(role);
        seasonsAddGrowthStageMenuBtn.click();
        webDriverHelper.waitUntilVisible(seasonsAddNewStageBtn, 30, 1);
        seasonsAddNewStageBtn.click();
        webDriverHelper.waitUntilVisible(seasonsAddNewStageCalendarBtn, 30, 1);
        seasonsAddNewStageCalendarBtn.click();
        webDriverHelper.waitUntilVisible(seasonsAddNewStageCalendar, 30, 1);
    }

    public void getGDDForecastValue(String role) throws IOException, ParseException, InterruptedException {
        setGDDForecastDate(role);
        String input = String.valueOf(nextDayDate);
        String pattern = "\\b\\d{2}\\b";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);

        if (m.find()) {
            date = m.group(0);
            System.out.println("Extracted date: " + date);
        } else {
            System.out.println("Date not found in the input string.");
        }
        String buttonXPath = "(//div[@class='datepicker-container']//table[@role='grid']//span[@ng-reflect-ng-class='[object Object]'][normalize-space()='" + date + "'])[1]";
        WebElement nextDayButton = driver.findElement(By.xpath(buttonXPath));
        nextDayButton.click();

        webDriverHelper.waitUntilVisible(seasonsNewForecastedGDDUnit, 30, 1);
        String gddUnitFromUI = seasonsNewForecastedGDDUnit.getText();

        long roundedValue = Math.round(nextDayGddCumulative);
        System.out.println("roundedValue:" + roundedValue);

        String roundedValueAsString = String.valueOf(roundedValue);
        System.out.println("roundedValueAsString:" + roundedValueAsString);

        Assert.assertEquals(gddUnitFromUI, roundedValueAsString);
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
        map.navigateToPage(role);
        webDriverHelper.waitUntilVisible(dashboardMenu_Settings, 30, 1);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Seasons).click().build().perform();
        SeasonAPIHelper.devToolCaptureGrowthStageWithValue(role);
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(createNewSeasonsButtonF1, 10, 1);
        } catch (Exception e) {
            Assert.assertTrue(createNewSeasonsButtonF1.size() >= 1, "Not able to see create new seasons button");
        }
    }

    public void verifyCopySeasonModalContents(String role) {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            verifyCopySeasonButton(role);
            copySeasonBtn.click();
            webDriverHelper.waitUntilVisible(selectSiteDropdown, 30, 1);
            Assert.assertTrue(selectSiteDropdown.isDisplayed());
            String modalTitle = copySeasonModalTitle.getText();
            System.out.println("copySeasonModalTitle.getText() :- " + copySeasonModalTitle.getText());
            Assert.assertTrue(modalTitle.contains(Constants.copySeasonTitle));
            Assert.assertTrue(modalTitle.contains(Constants.copySeasonTitleDesc));
            confirmButtonR.click();
        }
    }

    public void verifyShowSettingsButton(String role) {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            webDriverHelper.waitUntilVisible(showSettingsButton, 30, 1);
            showSettingsButton.click();
        }
    }

    public void verifyCopySeasonButton(String role) {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            webDriverHelper.waitUntilVisible(copySeasonBtn, 30, 1);
            String btnText = copySeasonBtn.getText();
            Assert.assertTrue(copySeasonBtn.isDisplayed());
        }
    }

    public void verifyCopySeasonButtonFeature(String role) {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            verifyCopySeasonButton(role);
            copySeasonBtn.click();
            webDriverHelper.waitUntilVisible(selectSiteDropdown, 30, 1);
            selectSiteDropdown.click();
            webDriverHelper.waitUntilVisible(firstCheckbox, 30, 1);
            firstCheckbox.click();
            webDriverHelper.waitUntilVisible(closeDropdown, 30, 1);
            closeDropdown.click();
            confirmButtonR.click();
            webDriverHelper.waitUntilVisible(copySeasonSummaryModal, 30, 1);
            String summaryTitleInfo = copySeasonSummaryModalTitleInfo.getText();
            if (summaryTitleInfo.contains(Constants.summaryTitleMsg)) {
                Assert.assertTrue(copySeasonSuccessTitle.isDisplayed());
                copySeasonSummaryModalCloseBtn.click();
                deleteSeason();
            } else {
                Assert.assertTrue(copySeasonErrorTitle.isDisplayed());
                Assert.assertTrue(copySeasonErrorMsg.isDisplayed());
            }
        }
    }

    public void verifyCreateNewSeasonButton(String role) throws IOException {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            webDriverHelper.waitUntilVisible(createNewSeasonsButtonF, 30, 1);
            Assert.assertTrue(createNewSeasonsButtonF.isDisplayed(), "Create new seasons button is not displayed");
            Assert.assertTrue(createNewSeasonsButtonF.isEnabled(), "Create new seasons button is not enabled");
        } else {
            webDriverHelper.waitUntilVisible(seasonsTableHeaderF, 30, 1);
            Assert.assertTrue(createNewSeasonsButtonF1.size() >= 1, "Not able to see create new seasons button");
        }
    }

    public void clickCreateNewSeasonButton(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(createNewSeasonsButtonF, 30, 1);
        // Added thread.sleep currently for rendering the dom will remove once after finding the solution
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        upcomingInitialValue = seasonsHeaderUpcomingF.getText();
        createNewSeasonsButtonF.click();
    }

    public void selectDetailsOnCreateNewSeasonPageGDD() throws InterruptedException {
        webDriverHelper.waitUntilVisible(siteDropdownF, 30, 1);
        siteDropdownF.click();
        webDriverHelper.waitUntilVisibilityOfAllElements(siteDropdownListF, 30, 1);
        siteDropdownListF.get(0).click();
        cropTypeDropdownF.click();
        webDriverHelper.waitUntilVisibilityOfAllElements(cropTypeDropdownListF, 30, 1);
        cropTypeDropdownListF.get(0).click();
        growthStageTrackingDropdownEnabled.click();
        webDriverHelper.waitUntilVisible(growthStageTrackingGddMode, 30, 1);
        growthStageTrackingGddMode.click();
        confirmButtonF.click();
        webDriverHelper.waitUntilVisible(confirmButtonR, 30, 1);
        confirmButtonR.click();
    }

    public void verifyNewSeasonForm() {
        webDriverHelper.waitUntilAttributeContains(hideSettingsButton, "src", "/img/icons/minus.svg", 30, 1);
        Assert.assertTrue(hideSettingsButton.isDisplayed());
    }

    public void selectStartDateForSeason() throws InterruptedException {
        webDriverHelper.waitUntilVisible(startDateF, 30, 1);
        Thread.sleep(3000);
        startDateF.click();
        webDriverHelper.waitUntilVisible(datePickerF, 30, 1);
        startDate.click();
    }

    public void selectEndDateForSeason() throws InterruptedException {
        endDateF.click();
        webDriverHelper.waitUntilVisible(endDate, 30, 1);
        endDate.click();
    }

    public void clickOnSaveSeasonButton() {
        webDriverHelper.waitUntilVisible(saveSeasonButtonF, 30, 1);
        saveSeasonButtonF.click();
    }

    public void verifyNewSeasonSavedSuccessfully() {
        webDriverHelper.waitUntilVisible(hideSettingsButton, 30, 1);
        webDriverHelper.waitUntilVisible(toastMessageF, 30, 1);
        Assert.assertTrue(toastMessageF.getText().equalsIgnoreCase("Growing Season successfully saved"));
        webDriverHelper.waitUntilInvisibilityOfAllElements(toastMessageF1, 30, 1);
        String upcomingFinalValue = seasonsHeaderUpcomingF.getText();
    }

    public void deleteSeason() {
        menuButtonF.click();
        webDriverHelper.waitUntilVisible(deleteButtonF, 30, 1);
        deleteButtonF.click();
        webDriverHelper.waitUntilVisible(deleteSeasonConfirmF, 30, 1);
        deleteSeasonConfirmF.click();
        webDriverHelper.waitUntilVisible(toastMessageF, 30, 1);
        Assert.assertTrue(toastMessageF.getText().equalsIgnoreCase(Constants.deleteSeasonSuccessMsg));
    }

    public void createNewSeason(String role) throws InterruptedException, IOException {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            clickCreateNewSeasonButton(role);
            selectDetailsOnCreateNewSeasonPageGDD();
            verifyNewSeasonForm();
            selectStartDateForSeason();
            selectEndDateForSeason();
            clickOnSaveSeasonButton();
            verifyNewSeasonSavedSuccessfully();
            deleteSeason();
        }
    }

    /*Performs the validation of Add New Stage and Delete All Stages option is present under Growth Stages*/
    public void selectGrowthStageMenuOption() throws InterruptedException {
        growthStageMenuButton.click();
    }

    public void verifyAddNewDeleteAllStages() {
        webDriverHelper.waitUntilVisible(growthStageMenuButton, 30, 1);
        Assert.assertTrue(addNewDeleteAllStage.isDisplayed());
        String addDelete = addNewDeleteAllStage.getText();
        System.out.println("Add stage and Delete All stages : " + addNewDeleteAllStage.getText());
    }

    public void verifyAddDeleteGrowthStageButton(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            selectGrowthStageMenuOption();
            verifyAddNewDeleteAllStages();
        }
    }


    private void selectDetailsOnCreateNewSeasonPageDaysMode() throws InterruptedException {
        webDriverHelper.waitUntilVisible(siteDropdownF, 30, 1);
        siteDropdownF.click();
        webDriverHelper.waitUntilVisibilityOfAllElements(siteDropdownListF, 30, 1);
        siteDropdownListF.get(0).click();
        cropTypeDropdownF.click();
        webDriverHelper.waitUntilVisibilityOfAllElements(cropTypeDropdownListF, 30, 1);
        cropTypeDropdownListF.get(0).click();
        if (isDropdownEnabled()) {
            System.out.println("Dropdown is enabled and Season is created in Days mode");
            growthStageTrackingDropdownEnabled.click();
            webDriverHelper.waitUntilVisible(growthStageTrackingDaysMode, 30, 1);
            growthStageTrackingDaysMode.click();
        } else {
            System.out.println("Dropdown is disabled and Season is created in GDD  mode");
            Assert.assertTrue(growthStageTrackingDisabled.isDisplayed(), "Drop Down is Disabled");
        }
        confirmButtonF.click();
        webDriverHelper.waitUntilVisible(confirmButtonR, 30, 1);
        confirmButtonR.click();
    }

    public boolean isDropdownEnabled() {
        List<WebElement> listOfElements = driver.findElements(By.id("arableCropGrowthStageTrackingIdEnabled"));
        return listOfElements.size() > 0;
    }

    public void createNewSeasonDaysMode(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            clickCreateNewSeasonButton(role);
            selectDetailsOnCreateNewSeasonPageDaysMode();
            verifyNewSeasonForm();
            selectStartDateForSeason();
            selectEndDateForSeason();
            clickOnSaveSeasonButton();
            verifyNewSeasonSavedSuccessfully();
            deleteSeason();
        }
    }

    public void verifyNewGsStageAdded(String role) {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            for (int i = 0; i < 3; i++) {
                webDriverHelper.waitUntilVisible(growthStageMenuButton, 30, 1);
                growthStageMenuButton.click();
                webDriverHelper.waitUntilVisible(addNewStage, 30, 1);
                addNewStage.click();
                inputGddValue.clear();
                inputGddValue.sendKeys("GDD" + i);
                inputGrowthStage.sendKeys("Stages" + i);
                webDriverHelper.waitUntilVisible(addNewStageSaveButton, 30, 1);
                addNewStageSaveButton.click();
            }
            saveSeasonButtonF.click();
            webDriverHelper.waitUntilVisible(growthStagesSavedSuccessToastMessage, 30, 1);
            Assert.assertTrue(growthStagesSavedSuccessToastMessage.getText().equalsIgnoreCase(Constants.growthStagesUpdatedSuccessMsg));
            deleteSeason();
        }
    }

    public void verifySeasonCreatedToAddNewGrowthStage(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            clickCreateNewSeasonButton(role);
            selectDetailsOnCreateNewSeasonPageGDD();
            verifyNewSeasonForm();
            selectStartDateForSeason();
            selectEndDateForSeason();
            clickOnSaveSeasonButton();
            verifyNewSeasonSavedSuccessfully();
        }
    }

    public void verifyAddOneGrowthStage() throws IOException, InterruptedException {
        growthStageMenuButton.click();
        webDriverHelper.waitUntilVisible(addNewStage, 30, 1);
        addNewStage.click();
        Assert.assertTrue(addNewStageCancelButton.isDisplayed());
        inputGddValue.clear();
        inputGddValue.sendKeys(Constants.gddValue1);
        inputGrowthStage.sendKeys(Constants.growthStage1);
        webDriverHelper.waitUntilVisible(addNewStageSaveButton, 30, 1);
        Assert.assertTrue(addNewStageSaveButton.isDisplayed());
        addNewStageSaveButton.click();
    }

    public void verifyEditOneGrowthStage() {
        editDeleteGrowthStageMenuButton.click();
        editGrowthStageButton.click();
        inputGddValue.clear();
        inputGddValue.sendKeys(Constants.gddValue2);
        inputGrowthStage.clear();
        inputGrowthStage.sendKeys(Constants.growthStage2);
        addNewStageSaveButton.click();
        Assert.assertFalse(emptyGrowthStageTable.getText().equalsIgnoreCase(Constants.emptyGrowthStageMsg));
    }

    public void verifyDeleteOneGrowthStage() {
        editDeleteGrowthStageMenuButton.click();
        deleteGrowthStageButton.click();
        webDriverHelper.waitUntilVisible(deleteGrowthStageConfirmF, 30, 1);
        deleteGrowthStageConfirmF.click();
        Assert.assertTrue(emptyGrowthStageTable.getText().equalsIgnoreCase(Constants.emptyGrowthStageMsg));
    }

    public void verifyEditDeleteGs(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            verifyAddOneGrowthStage();
            verifyEditOneGrowthStage();
            verifyDeleteOneGrowthStage();
            deleteSeason();
        }
    }

    public void verifySeasonCreatedToEditDeleteGrowthStage(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("orgReader") || role.equalsIgnoreCase("sysReader"))) {
            clickCreateNewSeasonButton(role);
            selectDetailsOnCreateNewSeasonPageGDD();
            verifyNewSeasonForm();
            selectStartDateForSeason();
            selectEndDateForSeason();
            clickOnSaveSeasonButton();
            verifyNewSeasonSavedSuccessfully();
        }
    }

    public void navigateToSeasonsPage() {
        try {
            webDriverHelper.waitUntilVisible(dashboardMenu_Settings, 30, 1);
            Actions action = new Actions(driver);
            action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Seasons).click().build().perform();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToSeasonsPage.jpg");
            Assert.fail("Failed in navigateToSeasonsPage method due to exception;- " + exc);
        }
    }

}