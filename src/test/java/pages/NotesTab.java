package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.Constants;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static support.World.*;

public class NotesTab {
    private final WebDriver driver;
    String notesText = "Automation Sanity";

    @FindBy(xpath = "//div[@class='column-full column-flex container']")
    WebElement notesBox;

    @FindBy(xpath = "//p[normalize-space()='Search']")
    private WebElement dashboardMenu_Search;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchBar;

    @FindBy(xpath = "//div[@class='site-result']")
    private WebElement search_SiteResult;

    @FindBy(xpath = "//arable-card[@ng-reflect-card-title='Current Conditions']/div")
    private WebElement currentConditionTableF;

    @FindBy(xpath = "//p[normalize-space()='Notes']")
    private WebElement notesTab;

    @FindBy(xpath = "//p[@class='1 selected']")
    private WebElement globalOrgSelected_MapPage;

    @FindBy(xpath = "//span[@class='1 caret']")
    private WebElement globalOrgDropdownBtn_MapPage;

    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//input[@type='search']")
    private WebElement globalOrgDropdownSearch_MapPage;

    @FindBy(xpath = "//p[normalize-space()='arable-team']")
    private WebElement globalOrgSearchSuggestion_MapPage;

    @FindBy(xpath = "(//div[@class='site-summary-card grid clickable'])[1]")
    private WebElement MapPage_SiteF;

    @FindBy(xpath = "//div[@class='empty-list']")
    private WebElement MapPage_EmptySiteDetails;

    @FindBy(xpath = "//textarea[@placeholder='What do you want to add, remind, share?']")
    private WebElement noteCreateBox;

    @FindBy(xpath = "//button[@class='save']")
    private WebElement saveNote;

    @FindBy(xpath = "//h3[normalize-space()='Successfully Saved']")
    private WebElement successToastMsg;

    @FindBy(xpath = "(//div[@class='column-full text'])[1]")
    private WebElement notesTextMsg;

    @FindAll(@FindBy(xpath = "//div[@class='moments-container']"))
    private List<WebElement> allNotesContainer;

    @FindBy(xpath = "(//p[@class='more-text'])[1]")
    private WebElement moreOption;

    @FindBy(xpath = "//div[@class='more-delete']//p[contains(text(),'Delete')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//h3[normalize-space()='Successfully Deleted']")
    private WebElement deleteSuccessToastMsg;

    @FindBy(xpath = "//div[@class='column-auto today']//p")
    private WebElement todayCalendar;

    @FindBy(xpath = "//button[normalize-space()='<']")
    private WebElement pastCalendarButton;

    @FindBy(xpath = "(//button[@type='button'])[28]")
    private WebElement pastCalendarDate;
    @FindBy(xpath = "((//div[@class='grid'])//p[@class='label'][normalize-space()='View'])")
    private WebElement notesViewBtn;

    @FindBy(xpath = "//h1[normalize-space()='Arable Note']")
    private WebElement notesViewModal;
    @FindBy(xpath = "//div[@class='column-auto go-email']")
    private WebElement notesEmailOption;
    @FindBy(xpath = "//input[@placeholder='Recipients']")
    private WebElement mailRecipients;
    @FindBy(xpath = "//textarea[@placeholder='Add a Note...']")
    private WebElement mailNotesMessage;
    @FindBy(xpath = "//div[@class='grid actions']//button")
    private WebElement shareNotesButtons;
    @FindBy(xpath = "//div[@class='grid actions']//div[@class='column send']//button")
    private WebElement mailNotesSendBtn;
    @FindBy(xpath = "//div[@class='grid actions']//div[@class='column back']//button")
    private WebElement shareNotesCancelBtn;
    @FindBy(xpath = "//div[@class='grid message']")
    private WebElement mailNotesSendConfirmationModal;
    @FindBy(xpath = "//button[normalize-space()='Back to Notes']")
    private WebElement backToNotesBtn;
    @FindBy(xpath = "//div[@class='highlight email-list display-inline']")
    private WebElement emailIdNotesSent;
    @FindBy(xpath = "//h2[normalize-space()='Share Note']")
    private WebElement shareNoteModalTitle;
    @FindBy(xpath = "//div[@class='grid body']//p")
    private WebElement shareNoteModalHeaders;
    @FindBy(xpath = "//div[@class='moments-container']")
    private List<WebElement> addedNotes;
    @FindBy(xpath = "(//div[@class='moments-container']//div[@class='date-info'])[1]//p")
    private WebElement addedNotesDate;

    @FindBy(xpath = "//div[@class='column-auto today']//p")
    private WebElement createdNotesPastDateSelected;

    @FindBy(xpath = "//div[@class='column-auto column-flex share-and-view']")
    private WebElement createdNotesViewShareBtn;

    @FindBy(xpath = "//div[@class='column time']//p//span")
    private WebElement localSiteTime;
    @FindBy(xpath = "(//div[@class='column-auto time']//p)[1]")
    private WebElement notesCreatedTime;

    @FindBy(xpath = "//div[@class='site-detail']//div[5]")
    private WebElement notesCreatedForCurrentTimeText;
    @FindBy(xpath = "//div[@class='column-auto column-flex share-and-view']//p[@class='label'][normalize-space()='Share']")
    private WebElement shareBtnOnNotes;
    @FindBy(xpath = "(//h3[contains(text(),'Error Sharing Moment')])[2]")
    private WebElement invalidEmailToastMsg;
    @FindBy(xpath = "//div[@class='input-error']")
    private WebElement errorMsgForEmailRecipient;

    @FindBy(xpath = "(//div[@class='column-full column-flex item'])[1]")
    private WebElement tempUnitViewNote;

    @FindBy(xpath = "(//div[@class='column-auto']/p[@class='value'])[1]")
    private WebElement tempUnitValue;
    @FindBy(xpath = "(//div[@class='column-auto']/p[@class='value'])[5]")
    private WebElement precipUnitValue;

    @FindBy(xpath = "//arable-button-list[@name='temperature']//arable-radio-button[input[@type='radio']]")
    private List<WebElement> tempMeasurementAccountPage;

    @FindBy(xpath = "//input[@type='radio' and starts-with(@id, 'pressure_')]/following-sibling::label")
    private List<WebElement> pressureMeasurementAccountPage;
    @FindBy(xpath = "//arable-radio-button[@id='millibars']")
    private WebElement pressureMeasurementBtnAccountPage;
    @FindBy(xpath = "//arable-radio-button[@name='distance']")
    private List<WebElement> sizeMeasurementAccountPage;
    @FindBy(xpath = "//div[@class='column data-area']")
    private List<WebElement> dataInNotesViewModal;

    public NotesTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static void assertNoDecimalValues(WebElement element, String pattern) {
        String elementText = element.getText();
        if (elementText.matches(pattern + "\\.\\d+")) {
            throw new AssertionError("Element text contains decimal values: " + elementText);
        } else {
            System.out.println("Element text does not contain decimal values: " + elementText);
        }
    }

    public void verifyDataParamsInNoteViewModal(String role) throws InterruptedException, IOException {
        viewNoteModal(role);
        Thread.sleep(5000);
        for (WebElement element : dataInNotesViewModal) {
            String text = element.getText();
            System.out.println("text:- " + "\n" + text);
            text = text.replaceAll("[0-9]+(\\.[0-9]+)?[^a-zA-Z]*|(?:\\A|--)(?m)^", "");
            String[] lines = text.split("\n");
            for (String line : lines) {
                System.out.println("line: " + line);
            }
            assert containsAllValues(text, Constants.VIEW_MEASUREMENT_PARAMS.split("\n")) :
                    "Assertion failed: The text does not contain the expected values.";
        }
    }

    private boolean containsAllValues(String text, String[] values) {
        for (String value : values) {
            if (value.equals("--")) {
                continue;
            }
            if (!text.contains(value)) {
                System.out.println("Expected value not found: " + value);
                return false;
            }
        }
        return true;
    }

    public void verifyTempValueDecimalPlace(String role) throws InterruptedException, IOException {
        viewNoteModal(role);
        verifyDecimalForTempValue();
        verifyDecimalForPrecipitationValue();
        navigateToSettingsAndChangeUnits();
        teamsApiHelper.getAuthToken();
        notesApiHelper.getUsersAPIRequest();
        stringHelper.scrollDownBy(400);
        changeTemperatureUnits();
        changePressureUnits();
        notesApiHelper.getUsersAPIRequestForSize();
        changeSizeUnits();
        webDriverHelper.waitUntilVisible(accountPage.account_SaveBtn, 30, 1);
        accountPage.account_SaveBtn.click();
        webDriverHelper.waitUntilVisible(accountPage.account_SuccessToast_UnitsChange, 30, 1);
        stringHelper.navigateBackTwice();
        verifyDecimalForTempValue();
        verifyDecimalForPrecipitationValue();
    }

    public void viewNoteModal(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(notesViewBtn, 30, 1);
        notesViewBtn.click();
        webDriverHelper.waitUntilVisible(notesViewModal, 30, 1);
        Assert.assertTrue(notesEmailOption.isDisplayed());
        Assert.assertTrue(notesEmailOption.getText().contains("Email note to your team."));
        Thread.sleep(7000);
    }

    public void invalidEmailInRecipient(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(notesViewBtn, 30, 1);
        shareBtnOnNotes.click();
        webDriverHelper.waitUntilVisible(mailRecipients, 30, 1);
        mailRecipients.sendKeys(Constants.shareNoteInvalidEmailId);
        mailNotesMessage.sendKeys(Constants.GlobalTeamName);
        Thread.sleep(3000);
        mailNotesSendBtn.click();
        webDriverHelper.waitUntilVisible(invalidEmailToastMsg, 30, 1);
        Assert.assertTrue(invalidEmailToastMsg.getText().contains(Constants.invalidEmailToastMsgShown));
    }

    public void cancelBtnFunctionalityOnShareModal(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(notesViewBtn, 30, 1);
        shareBtnOnNotes.click();
        webDriverHelper.waitUntilVisible(mailRecipients, 30, 1);
        shareNotesCancelBtn.click();
        webDriverHelper.waitUntilVisible(noteCreateBox, 30, 1);
        Assert.assertTrue(moreOption.isDisplayed());
    }

    public void incompleteEmailInRecipient(String role) throws InterruptedException {
        webDriverHelper.waitUntilVisible(notesViewBtn, 30, 1);
        shareBtnOnNotes.click();
        webDriverHelper.waitUntilVisible(mailRecipients, 30, 1);
        mailRecipients.sendKeys(Constants.shareNoteIncompleteEmailId);
        mailNotesMessage.sendKeys(Constants.GlobalTeamName);
        Thread.sleep(3000);
        mailNotesSendBtn.click();
        webDriverHelper.waitUntilVisible(errorMsgForEmailRecipient, 30, 1);
        Assert.assertTrue(errorMsgForEmailRecipient.getText().contains(Constants.recipientEmailErrorMsg));
    }

    public void shareNote(String role) throws InterruptedException {
        viewNoteModal(role);
        notesEmailOption.click();
        webDriverHelper.waitUntilVisible(mailRecipients, 30, 1);
        Assert.assertTrue(shareNoteModalTitle.getText().contains(Constants.shareNoteModalTitle));
        Assert.assertTrue(shareNoteModalHeaders.getText().contains(Constants.shareNoteModalHeader));
        mailRecipients.sendKeys(Constants.shareNoteEmailId);
        mailNotesMessage.sendKeys(Constants.GlobalTeamName);
        Thread.sleep(3000);
        Assert.assertTrue(shareNotesButtons.getText().contains(Constants.shareNoteModalBackBtn));
        mailNotesSendBtn.click();
        webDriverHelper.waitUntilVisible(mailNotesSendConfirmationModal, 30, 1);
        Assert.assertTrue(mailNotesSendConfirmationModal.getText().contains(Constants.shareNoteSentModalDescription));
        Assert.assertTrue(emailIdNotesSent.getText().contains(Constants.shareNoteEmailId));
        teamsApiHelper.getAuthToken();
        notesApiHelper.postAnnotationsShareRequest(siteID);
        backToNotesBtn.click();
    }

    public void shareNoteMultipleEmails(String role) throws InterruptedException {
        viewNoteModal(role);
        notesEmailOption.click();
        webDriverHelper.waitUntilVisible(mailRecipients, 30, 1);
        mailRecipients.sendKeys(Constants.shareNoteMultipleEmailId);
        mailNotesMessage.sendKeys(Constants.GlobalTeamName);
        Thread.sleep(3000);
        Assert.assertTrue(shareNotesButtons.getText().contains("Back"));
        mailNotesSendBtn.click();
        webDriverHelper.waitUntilVisible(mailNotesSendConfirmationModal, 30, 1);
        Assert.assertTrue(mailNotesSendConfirmationModal.getText().contains("An email has been sent to"));
        System.out.println("emailIdNotesSent.getText():-" + emailIdNotesSent.getText());
        Assert.assertTrue(emailIdNotesSent.getText().contains(Constants.shareNoteMultipleEmailId.replace(",", ", ") + "."));
        teamsApiHelper.getAuthToken();
        notesApiHelper.postAnnotationsShareRequest(siteID);
        backToNotesBtn.click();
    }

    public void createNoteWithPastDate(String page) throws InterruptedException {
        createNote();
        todayCalendar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(pastCalendarButton));
        pastCalendarButton.click();
        wait.until(ExpectedConditions.visibilityOf(pastCalendarDate));
        pastCalendarDate.click();
        String dateSelected = createdNotesPastDateSelected.getText();
        saveNote.click();
        wait.until(ExpectedConditions.visibilityOf(successToastMsg));
        Assert.assertTrue(successToastMsg.isDisplayed());

        teamsApiHelper.getAuthToken();
        notesApiHelper.getAnnotationsRequest(siteID);
        List<String> apiNoteValues = notesApiHelper.getApiNoteValues();
        Assert.assertTrue(apiNoteValues.contains(notesText));

        Assert.assertTrue(addedNotes.get(addedNotes.size() - 1).getText().contains(dateSelected));
        Assert.assertTrue(addedNotes.get(addedNotes.size() - 1).getText().contains(Constants.momentBoxViewBtnText));
    }

    public void navigateToNotesPage(String role) throws IOException, InterruptedException {
        map.navigateToPage(role);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.elementToBeClickable(MapPage_SiteF));
        try {
            MapPage_SiteF.click();
        } catch (StaleElementReferenceException e) {
            MapPage_SiteF.click();
        }
        wait.until(ExpectedConditions.visibilityOf(notesTab));
        notesTab.click();
        wait.until(ExpectedConditions.visibilityOf(notesBox));
    }

    public void navigateToPage() {
        if (!(globalOrgSelected_MapPage.getText().contains("arable-team"))) {
            globalOrgDropdownBtn_MapPage.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(globalOrgDropdownSearch_MapPage));
            globalOrgDropdownSearch_MapPage.sendKeys("arable-team");
            wait.until(ExpectedConditions.elementToBeClickable(globalOrgSearchSuggestion_MapPage));
            globalOrgSearchSuggestion_MapPage.click();
        }
    }

    public void createNotes(String role) {
        try {
            createNote();
            saveNote.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(successToastMsg));
            Assert.assertTrue(successToastMsg.isDisplayed());
            for (WebElement filterName : allNotesContainer) {
                WebElement firstElement = allNotesContainer.get(0);
                String text = filterName.getText();
                Assert.assertTrue(text.contains(notesText), "Notes text is not displayed");
                Assert.assertTrue(firstElement.getText().contains(notesText));
                Assert.assertTrue(notesCreatedForCurrentTimeText.getText().contains(Constants.momentBoxCurrentDateCreatedText));
                Assert.assertTrue(notesCreatedTime.getText().toLowerCase().contains(localSiteTime.getText().toLowerCase()));
            }
            teamsApiHelper.getAuthToken();
            notesApiHelper.getAnnotationsRequest(siteID);
            List<String> apiNoteValues = notesApiHelper.getApiNoteValues();
            Assert.assertTrue(apiNoteValues.contains(notesText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createNote() throws InterruptedException {
        noteCreateBox.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(noteCreateBox));
        Thread.sleep(3000);
        noteCreateBox.sendKeys(notesText);
    }

    public void deleteNote(String role) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(moreOption));
        moreOption.click();
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
        wait.until(ExpectedConditions.visibilityOf(deleteSuccessToastMsg));
        Assert.assertTrue(deleteSuccessToastMsg.isDisplayed());
        teamsApiHelper.getAuthToken();
        notesApiHelper.getDeleteNotesResponse(siteID);
        Assert.assertTrue(notesApiHelper.getApiResponseBody().contains("does not exist"));
    }

    private void verifyDecimalForTempValue() throws InterruptedException {
        webDriverHelper.waitUntilVisible(tempUnitValue, 30, 1);
        System.out.println("temp Unit Value:-" + tempUnitValue.getText());
        assertNoDecimalValues(tempUnitValue, "\\.\\d+");
    }

    private void verifyDecimalForPrecipitationValue() throws InterruptedException {
        webDriverHelper.waitUntilVisible(precipUnitValue, 30, 1);
        System.out.println("precip Unit Value:-" + precipUnitValue.getText());
        assertNoDecimalValues(precipUnitValue, "\\.\\d+");
    }

    private void navigateToSettingsAndChangeUnits() {
        Actions action = new Actions(driver);
        action.moveToElement(accountPage.dashboardMenu_Settings).moveToElement(accountPage.dashboardMenu_Account).click().build().perform();
        webDriverHelper.waitUntilVisible(accountPage.account_GenerateKey, 30, 1);
    }

    private void changeTemperatureUnits() {
        for (WebElement radioButton : tempMeasurementAccountPage) {
            String ngReflectId = radioButton.getAttribute("ng-reflect-model");
            System.out.println("ng-reflect-model: " + ngReflectId);

            if (notesApiHelper.temperatureUnit.equalsIgnoreCase("F")) {
                stringHelper.scrollIntoViewAndClick(accountPage.accountPage_temp_Units_C);
            } else if (notesApiHelper.temperatureUnit.equalsIgnoreCase("C")) {
                stringHelper.scrollIntoViewAndClick(accountPage.accountPage_temp_Units_F);
            }
        }
    }

    private void changePressureUnits() {
        String ngReflectId = pressureMeasurementBtnAccountPage.getAttribute("ng-reflect-model");
        System.out.println("ng-reflect-model: " + ngReflectId);
        if (ngReflectId.contains("millibars")) {
            stringHelper.scrollIntoViewAndClick(accountPage.accountPage_pressure_Units_kp);
            Assert.assertTrue(pressureMeasurementBtnAccountPage.getAttribute("ng-reflect-model").contains("kilo_pascals"));
        } else if (ngReflectId.contains("kilo_pascals")) {
            stringHelper.scrollIntoViewAndClick(accountPage.accountPage_pressure_Units_mb);
            Assert.assertTrue(pressureMeasurementBtnAccountPage.getAttribute("ng-reflect-model").contains("millibars"));
        }
    }

    private void changeSizeUnits() throws InterruptedException {
        for (WebElement radioButton : sizeMeasurementAccountPage) {
            String ngReflectId = radioButton.getAttribute("ng-reflect-model");
            if (notesApiHelper.distanceUnit.equalsIgnoreCase("mm")) {
                stringHelper.scrollIntoViewAndClick(accountPage.accountPage_size_Units_Inch);
            } else if (notesApiHelper.temperatureUnit.equalsIgnoreCase("in")) {
                stringHelper.scrollIntoViewAndClick(accountPage.accountPage_size_Units_MM);
            }
        }
    }
}