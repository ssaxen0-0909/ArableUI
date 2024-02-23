package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.Constants;

import java.io.IOException;
import java.util.List;

import static support.World.map;
import static support.World.webDriverHelper;


public class SitesPage {

    private final WebDriver driver;
    public String siteCardName;
    public String siteCardDetails;
    public String siteName_EditSiteModal;
    @FindBy(xpath = "(//a[contains(text(),'View Site Data >')])[1]")
    WebElement viewSiteBtn_SiteCard;
    @FindBy(xpath = "//p[normalize-space()='Sites']")
    WebElement dashboardMenu_Sites;
    @FindBy(xpath = "//p[contains(text(),'doesn’t have any sites yet.')]")
    WebElement noSitesAvailable;
    @FindBy(xpath = "//button[normalize-space()='Clear Boundary']")
    WebElement clearBoundaryBtn;
    @FindBy(xpath = "//p[contains(text(),'Click')]")
    private WebElement clickHere;
    @FindBy(xpath = "//div[1]/div[2]/arable-site-card[1]/div[1]/div[1]/div[2]/arable-dotted-menu[1]/div[1]/div[1]/div[1]")
    private WebElement menuButtonF;
    @FindBy(xpath = "(//div[@class='button'][normalize-space()='Edit Site'])[1]")
    private WebElement editSiteButtonF;
    @FindBy(xpath = "//button[text()=' Confirm ']")
    private WebElement confirmButtonF;
    @FindBy(xpath = "//h3[normalize-space()='Successfully Saved']")
    private WebElement successToast;
    @FindBy(xpath = "//div[2]/arable-site-card[1]/div[1]")
    private WebElement siteCardF;
    @FindBy(xpath = "//div[2]/arable-site-card[1]/div[1]/div[1]")
    private WebElement siteName_OnCardF;
    @FindBy(xpath = "(//div[@class='button'][normalize-space()='Edit Soil Properties'])[1]")
    private WebElement editSoilPropertiesOption;
    @FindBy(xpath = "(//div[@class='spinner-btn'])[1]")
    private WebElement editSoilProperties_FieldCapacityUpBtn;
    @FindBy(xpath = "(//arable-input-number)[1]")
    private WebElement editSoilProperties_FieldCapacityText;
    @FindBy(xpath = "//div[@class='soil-properties__input-inner-container soil-properties__input-inner-container--wilting-point']//input[@type='text']")
    private WebElement editSoilProperties_PermanentWiltingPointText;
    @FindBy(xpath = "(//div[@class='button up'])[2]")
    private WebElement editSoilProperties_PermanentWiltingPointUpBtn;
    @FindBy(xpath = "//div[@class='modal fade in show']//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement editSoilProperties_ConfirmBtn;
    @FindBy(xpath = "//h3[normalize-space()='Successfully Updated']")
    private WebElement editSoilProperties_successToast;
    @FindBy(xpath = "//div[@class='modal fade in show']//button[@class='btn-action close'][normalize-space()='Do This Later']")
    private WebElement editSoilProperties_DoThisLaterBtn;
    @FindBy(xpath = "(//div[@class='button'][normalize-space()='Manual Irrigation'])[1]")
    private WebElement manualIrrigationOption;
    @FindBy(xpath = "//div[@class='img-container float-right']")
    private WebElement manualIrrigation_AddBtn;
    @FindBy(xpath = "//div[@class='manual-irrigation-input-container']//div[@class='button up']")
    private WebElement manualIrrigation_SetAmountUpBtn;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement manualIrrigation_SaveBtn;
    @FindBy(xpath = "//div[@class='manual-irrigation-data']")
    private WebElement manualIrrigation_EntryTable;
    @FindBy(xpath = "(//div[@class='menu non-relative']//div[@class='menu-button-container'])[1]")
    private WebElement manualIrrigation_AmountEditMenuBtn_EntryTable;
    @FindBy(xpath = "//arable-dotted-menu[@ng-reflect-items='[object Object],[object Object']//div[@class='menu non-relative']//div[@class='menu-button']")
    private WebElement manualIrrigation_DeleteEntryMenuBtn_EntryTable;
    @FindBy(xpath = "//div[@class='button'][normalize-space()='Edit']")
    private WebElement manualIrrigation_AmountEditBtn_EntryTable;
    @FindBy(xpath = "//div[@class='manual-irrigation-input-container']//input[@type='text']")
    private WebElement manualIrrigation_AmountSet_EntryTable;
    @FindBy(xpath = "//div[@class='button'][normalize-space()='Delete Entry']")
    private WebElement manualIrrigation_deleteEntry_EntryTable;
    @FindBy(xpath = "//p[normalize-space()='Successfully Deleted']")
    private WebElement manualIrrigation_deleteEntry_SuccessToast_EntryTable;
    @FindBy(xpath = "//div[@class='grid column-20 manual-irrigation-column amount-column']//div[@class='column']")
    private WebElement manualIrrigation_AmountSaved_EntryTable;
    @FindBy(xpath = "//div[@class='menu-content']//div[@class='button'][normalize-space()='Create Season']")
    private WebElement createSeason_menuButton_SiteCard;
    //    @FindBy(xpath = "//arable-dropdown-selector[@title='Select Crop']//span[@class='0 caret']")
//    private WebElement createSeason_cropTypeModal;
    @FindBy(xpath = "//arable-dropdown-selector[@class='dropdown-selector input-dropdown members']//div[@class='0 grid grid-center headers']//span[@class='0 caret']")
    private WebElement createSeason_cropTypeModal;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='options']")
    private WebElement createSeason_cropTypeOptions;
    @FindBy(xpath = "//p[normalize-space()='Select Varietal']")
    private WebElement createSeason_VarietalModal;
    //    @FindBy(xpath = "//arable-dropdown-selector[@ng-reflect-title='Select Varietal']//span[@class='0 caret']")
//    private WebElement createSeason_SelectVarietal;
    @FindBy(xpath = "(//div[@class='0 dropdown-selector open']//div[@class='options']//p[@class='iconEnabled'])[1]")
    private WebElement createSeason_SelectVarietal;
    @FindAll(@FindBy(xpath = "(//tbody)[2]"))
    private List<WebElement> createSeason_SelectStartDate;
    @FindAll(@FindBy(xpath = "(//tbody)[3]"))
    private List<WebElement> createSeason_SelectEndDate;
    @FindBy(xpath = "(//div[@class='icon-calendar'])[1]")
    private WebElement createSeason_SelectStartDatePicker;
    @FindBy(xpath = "(//div[@class='icon-calendar'])[2]")
    private WebElement createSeason_SelectEndDatePicker;
    @FindBy(xpath = "//div[@class='content']//div[@class='tooltip-info']//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement createSeason_ConfirmBtn;
    @FindBy(xpath = "//strong[normalize-space()='Crop type:']")
    private WebElement createSeason_SuccessMsg;
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='>'])[3]")
    private WebElement createSeason_EndDate_NextBtn;
    @FindBy(xpath = "//p[normalize-space()='Settings']")
    private WebElement dashboardMenu_Settings;
    @FindBy(xpath = "//p[normalize-space()='Seasons']")
    private WebElement dashboardMenu_Seasons;
    @FindBy(xpath = "(//div[@class='menu-button'])[1]")
    private WebElement seasons_menuBtn_FirstSite;
    @FindBy(xpath = "(//div[@class='button'][normalize-space()='Delete Season'])[1]")
    private WebElement seasons_deleteBtn_FirstSite;
    @FindBy(xpath = "(//button[@class='btn-action confirm'][normalize-space()='Confirm'])[3]")
    private WebElement seasons_ConfirmBtn_DeleteSeason;
    @FindBy(xpath = "//p[normalize-space()='Growing season successfully deleted']")
    private WebElement seasons_successToast_DeleteSeason;
    @FindBy(xpath = "(//div[@class='locations-container-list'])[1]")
    private WebElement siteCard_LocationList;
    @FindBy(xpath = "(//a[contains(text(),'View Site Data >')])[1]")
    private WebElement siteCard_ViewSiteDataBtn;
    @FindBy(xpath = "//div[@class='device-table-entries']")
    private WebElement weatherPage_LocationList;
    @FindBy(xpath = "//h4[normalize-space()='Temperature']")
    private WebElement weatherPage_CurrentConditionTempF;
    @FindBy(xpath = "//div[@class='device-table-entry-container grid']//div[@class='column device-table-entry device-name']")
    private WebElement weatherPage_DeviceListF;
    @FindBy(xpath = "//h3[normalize-space()='Error saving season']")
    private WebElement siteCard_errorInCreatingSeason;
    @FindBy(xpath = "(//button[@class='btn-action close'][normalize-space()='Do This Later'])[2]")
    private WebElement siteCard_DoThisLaterBtn;
    @FindBy(xpath = "//span[@class='go-to-text']")
    private WebElement goToText;
    @FindBy(xpath = "//input[@id='goToPage']")
    private WebElement goToInputField;
    @FindBy(xpath = "//button[@aria-disabled='false']//span[normalize-space()='>>']")
    private WebElement goToLastPageBtn;
    @FindBy(xpath = "//button[@aria-disabled='false']//span[normalize-space()='<<']")
    private WebElement goToFirstPageBtn;
    @FindBy(xpath = "//button[@aria-disabled='false']//span[normalize-space()='<']")
    private WebElement goToPrevPageBtn;
    @FindBy(xpath = "//button[@aria-disabled='false']//span[normalize-space()='>']")
    private WebElement goToNextPageBtn;
    @FindBy(xpath = "//a[@class='internal current']")
    private WebElement currentPageNo;
    @FindBy(xpath = "//a[normalize-space()='2']")
    private WebElement secondPageNo;
    @FindBy(xpath = "(//button[@aria-disabled='true'])//span[normalize-space()='>>']")
    private WebElement goToLastPageBtnDisabled;
    @FindBy(xpath = "(//button[@aria-disabled='true'])//span[normalize-space()='<<']")
    private WebElement goToFirstPageBtnDisabled;
    @FindBy(xpath = "(//button[@aria-disabled='true'])//span[normalize-space()='>']")
    private WebElement goToNextPageBtnDisabled;
    @FindBy(xpath = "(//button[@aria-disabled='true'])//span[normalize-space()='<']")
    private WebElement goToPrevPageBtnDisabled;
    @FindBy(xpath = "//div[@class='container-box']")
    private WebElement warningText;
    @FindBy(xpath = "//div[contains(text(),'Create New Site')]")
    private WebElement createNewSiteBtn;
    @FindBy(xpath = "//h3[normalize-space()='Error Saving']")
    private WebElement errorToastMsg;
    @FindBy(xpath = "(//div[@class='site-card'])")
    private List<WebElement> sitesList;
    @FindBy(xpath = "//div[@class='actions']//arable-pagination")
    private WebElement paginationView;

    private String LastPageNo;
    private String LastPageTextType;

    public SitesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyNextPagePaginationView(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(siteCardF, 90, 1);
        if (!paginationView.isDisplayed()) {
            int sitesListCountFirstPage = sitesList.size();
            Assert.assertNotEquals(sitesListCountFirstPage, Constants.siteCardCount);
        } else {
            goToNextPageBtn.click();
            webDriverHelper.waitUntilVisible(siteCardF, 90, 1);
            int sitesListCountSecondPage = sitesList.size();
            System.out.println("sitesListCountSecondPage:- " + sitesListCountSecondPage);
            Assert.assertTrue(secondPageNo.isDisplayed());
            if (sitesListCountSecondPage < Constants.siteCardCount) {
                Assert.assertFalse(paginationView.isDisplayed());
            } else {
                Assert.assertEquals(sitesListCountSecondPage, Constants.siteCardCount);
            }
        }
    }

    public void verifyPaginationView(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(siteCardF, 90, 1);
        int sitesListCount = sitesList.size();
        System.out.println("sitesListCount:- " + sitesListCount);
        if (sitesListCount < 9) {
            Assert.assertFalse(paginationView.isDisplayed());
        } else {
            Assert.assertEquals(sitesListCount, Constants.siteCardCount);
        }
    }

    public void verifyClearBoundaryBtn(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(siteCardF, 90, 1);
        menuButtonF.click();
        webDriverHelper.waitUntilVisible(editSiteButtonF, 90, 1);
        editSiteButtonF.click();
        webDriverHelper.waitUntilVisible(clearBoundaryBtn, 90, 1);
        String clearBoundaryBtnText = clearBoundaryBtn.getText();
        System.out.println("clearBoundaryBtnText:- " + clearBoundaryBtnText);
        Assert.assertEquals(clearBoundaryBtnText, Constants.clearBoundaryBtnText);
    }

    public void verifySavingSiteWithoutBoundary(String role) throws IOException, InterruptedException {
        verifyClearBoundaryBtn(role);
        clearBoundaryBtn.click();
        confirmButtonF.click();
        webDriverHelper.waitUntilVisible(errorToastMsg, 90, 1);
        String errorText = errorToastMsg.getText();
        Assert.assertEquals(errorText, Constants.errorText);
    }

    public void verifyWarningText(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(siteCardF, 200, 1);
        createNewSiteBtn.click();
        webDriverHelper.waitUntilVisible(warningText, 200, 1);
        String warningTextMsg = warningText.getText();
        Assert.assertEquals(warningTextMsg, Constants.warningMsg);
    }

    public void verifyGoToPageButton(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(siteCardF, 200, 1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertTrue(goToText.isDisplayed());
    }

    public void verifyInvalidValueInGoToField(String role) throws IOException, InterruptedException {
        verifyGoToPageButton(role);
        String invalidValue = "-1";
        goToInputField.sendKeys(invalidValue);
        goToText.click();
        String actualValue = goToInputField.getText();
        Assert.assertNotEquals(actualValue, invalidValue);
    }

    public void verifyInputNumberHigherThanLastPage(String role) throws IOException, InterruptedException {
        verifyGoToPageFeature(role);
        goToFirstPageBtn.click();
        webDriverHelper.waitUntilVisible(goToText, 20, 1);
        String highestInputValue = LastPageNo + 1;
        System.out.println("highestInputValue:- " + highestInputValue);
        goToInputField.sendKeys(highestInputValue);
        goToText.click();
        webDriverHelper.waitUntilVisible(goToText, 20, 1);
        Assert.assertTrue(goToLastPageBtnDisabled.isDisplayed());
        Assert.assertTrue(goToNextPageBtnDisabled.isDisplayed());
        Assert.assertTrue(goToFirstPageBtn.isDisplayed());
        Assert.assertTrue(goToPrevPageBtn.isDisplayed());
        String currentPageNumber = currentPageNo.getText();
        Assert.assertEquals(LastPageNo, currentPageNumber);
    }

    public void verifyGoToLastPageBtnDisabled(String role) throws IOException, InterruptedException {
        verifyGoToPageButton(role);
        goToLastPageBtn.click();
        webDriverHelper.waitUntilVisible(goToText, 20, 1);
        LastPageTextType = currentPageNo.getCssValue("font-weight");
        Assert.assertEquals(LastPageTextType, "700");
        Assert.assertTrue(goToLastPageBtnDisabled.isDisplayed());
        Assert.assertTrue(goToNextPageBtnDisabled.isDisplayed());
        Assert.assertTrue(goToFirstPageBtn.isDisplayed());
        Assert.assertTrue(goToPrevPageBtn.isDisplayed());
    }

    public void verifyGoToFirstPageBtnDisabled(String role) throws IOException, InterruptedException {
        verifyGoToPageButton(role);
        String FirstPageTextType = currentPageNo.getCssValue("font-weight");
        System.out.println("FirstPageTextType" + FirstPageTextType);
        Assert.assertEquals(FirstPageTextType, "700");
        Assert.assertTrue(goToLastPageBtn.isDisplayed());
        Assert.assertTrue(goToNextPageBtn.isDisplayed());
        Assert.assertTrue(goToFirstPageBtnDisabled.isDisplayed());
        Assert.assertTrue(goToPrevPageBtnDisabled.isDisplayed());
    }

    public void verifyGoToPageFeature(String role) throws IOException, InterruptedException {
        verifyGoToPageButton(role);
        verifyGoToLastPageBtnDisabled(role);
        LastPageNo = currentPageNo.getText();
        goToInputField.sendKeys(LastPageNo);
        goToText.click();
        webDriverHelper.waitUntilVisible(goToText, 20, 1);
        String CurrentPageNo = currentPageNo.getText();
        Assert.assertEquals(CurrentPageNo, LastPageNo);
    }

    public void verifyLocationListInSiteDetailsPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(siteCardF, 200, 1);
        String DeviceDetails_SiteCard = siteCard_LocationList.getText();
        System.out.println("DeviceDetails_SiteCard:- " + DeviceDetails_SiteCard);
        Thread.sleep(1000);
        siteCard_ViewSiteDataBtn.click();
        webDriverHelper.waitUntilVisible(weatherPage_CurrentConditionTempF, 200, 1);
        String DeviceDetails_WeatherPage = weatherPage_DeviceListF.getText();
        System.out.println("DeviceDetails_WeatherPage :- " + DeviceDetails_WeatherPage);
        Assert.assertTrue(DeviceDetails_SiteCard.contains(DeviceDetails_WeatherPage));
    }

    public void navigateToSeasonPage() {
        webDriverHelper.waitUntilVisible(siteCardF, 30, 1);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Settings).moveToElement(dashboardMenu_Seasons).click().build().perform();
    }

    public void deleteCreatedSeason() {
        webDriverHelper.waitUntilVisible(seasons_menuBtn_FirstSite, 200, 1);
        seasons_menuBtn_FirstSite.click();
        webDriverHelper.waitUntilVisible(seasons_deleteBtn_FirstSite, 30, 1);
        seasons_deleteBtn_FirstSite.click();
        webDriverHelper.waitUntilVisible(seasons_ConfirmBtn_DeleteSeason, 30, 1);
        seasons_ConfirmBtn_DeleteSeason.click();
        webDriverHelper.waitUntilVisible(seasons_successToast_DeleteSeason, 30, 1);
    }


    public void verifyCreateSeason_MenuBtn(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("sysReader") || role.equalsIgnoreCase("orgReader"))) {
            selectCropAndVarietalForSeason();
            selectStartDateForSeason();
            Thread.sleep(2000);
            selectEndDateForSeason();
            Thread.sleep(5000);
            createSeason_ConfirmBtn.click();
            Thread.sleep(3000);
            if (siteCard_errorInCreatingSeason.isDisplayed()) {
                siteCard_DoThisLaterBtn.click();
            } else {
                webDriverHelper.waitUntilVisible(createSeason_SuccessMsg, 30, 1);
                Assert.assertTrue(createSeason_SuccessMsg.isDisplayed());
                navigateToSeasonPage();
                deleteCreatedSeason();
            }
        }
    }

    public void selectCropAndVarietalForSeason() throws InterruptedException {
        webDriverHelper.waitUntilVisible(viewSiteBtn_SiteCard, 30, 1);
        menuButtonF.click();
        webDriverHelper.waitUntilVisible(createSeason_menuButton_SiteCard, 30, 1);
        createSeason_menuButton_SiteCard.click();
        webDriverHelper.waitUntilVisible(createSeason_cropTypeModal, 30, 1);
        createSeason_cropTypeModal.click();
        webDriverHelper.waitUntilVisible(createSeason_cropTypeOptions, 30, 1);
        createSeason_cropTypeOptions.click();
        Thread.sleep(2000);
        createSeason_VarietalModal.click();
        webDriverHelper.waitUntilVisible(createSeason_SelectVarietal, 30, 1);
        createSeason_SelectVarietal.click();
        Thread.sleep(2000);
    }


    public void selectStartDateForSeason() throws InterruptedException {
        createSeason_SelectStartDatePicker.click();
        Thread.sleep(3000);
        createSeason_SelectStartDate.get(0).click();
    }

    public void selectEndDateForSeason() throws InterruptedException {
        createSeason_SelectEndDatePicker.click();
        Thread.sleep(3000);
        createSeason_EndDate_NextBtn.click();
        Thread.sleep(3000);
        createSeason_SelectEndDate.get(0).click();
    }

    public void verifyManualIrrigation(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("sysReader") || role.equalsIgnoreCase("orgReader"))) {
            createEntryForManualIrrigation();
            String AmountSetValue = manualIrrigation_AmountSaved_EntryTable.getText();
//            webDriverHelper.waitUntilVisible(manualIrrigation_AmountEditMenuBtn_EntryTable, 30, 1);
//            manualIrrigation_AmountEditMenuBtn_EntryTable.click();
//            Thread.sleep(1000);
//            manualIrrigation_AmountEditBtn_EntryTable.click();
//            Thread.sleep(1000);
//            webDriverHelper.waitUntilVisible(manualIrrigation_SaveBtn, 30, 1);
//            manualIrrigation_SetAmountUpBtn.click();
//            manualIrrigation_SaveBtn.click();
//            Thread.sleep(1000);
//            webDriverHelper.waitUntilVisible(manualIrrigation_DeleteEntryMenuBtn_EntryTable, 30, 1);
//            String editedAmount = manualIrrigation_AmountSet_EntryTable.getText();
//            Assert.assertNotEquals(editedAmount, AmountSetValue);
//            Thread.sleep(1000);
//            deleteManualIrrigation();
        }
    }

    public void createEntryForManualIrrigation() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(viewSiteBtn_SiteCard, 30, 1);
        menuButtonF.click();
        webDriverHelper.waitUntilVisible(manualIrrigationOption, 30, 1);
        manualIrrigationOption.click();
        webDriverHelper.waitUntilVisible(manualIrrigation_AddBtn, 30, 1);
        manualIrrigation_AddBtn.click();
        webDriverHelper.waitUntilVisible(manualIrrigation_SaveBtn, 30, 1);
        manualIrrigation_SetAmountUpBtn.click();
        manualIrrigation_SaveBtn.click();
        webDriverHelper.waitUntilVisible(successToast, 30, 1);
        webDriverHelper.waitUntilVisible(manualIrrigation_AmountEditMenuBtn_EntryTable, 30, 1);

    }

    public void deleteManualIrrigation() throws IOException, InterruptedException {
        manualIrrigation_DeleteEntryMenuBtn_EntryTable.click();
        webDriverHelper.waitUntilVisible(manualIrrigation_deleteEntry_EntryTable, 30, 1);
        manualIrrigation_deleteEntry_EntryTable.click();
        webDriverHelper.waitUntilVisible(manualIrrigation_deleteEntry_SuccessToast_EntryTable, 30, 1);
        Assert.assertTrue(manualIrrigation_deleteEntry_SuccessToast_EntryTable.isDisplayed());
    }

    public void verifyEditSoilProperties(String role) throws IOException, InterruptedException {
        if (!(role.equalsIgnoreCase("sysReader") || role.equalsIgnoreCase("orgReader"))) {
            webDriverHelper.waitUntilVisible(viewSiteBtn_SiteCard, 30, 1);
            menuButtonF.click();
            webDriverHelper.waitUntilVisible(editSoilPropertiesOption, 30, 1);
            editSoilPropertiesOption.click();
            webDriverHelper.waitUntilVisible(editSoilProperties_FieldCapacityText, 30, 1);
            String fieldCapacityValue = editSoilProperties_FieldCapacityText.getText();
            for (int i = 0; i <= 1; i++) {
                editSoilProperties_FieldCapacityUpBtn.click();
            }
            String newFieldCapacityValue = editSoilProperties_FieldCapacityText.getText();
            Assert.assertEquals(newFieldCapacityValue, fieldCapacityValue);
            String permanentWiltingPointValue = editSoilProperties_PermanentWiltingPointText.getText();
            editSoilProperties_PermanentWiltingPointUpBtn.click();
            String newPermanentWiltingPointValue = editSoilProperties_PermanentWiltingPointText.getText();
            Assert.assertEquals(newPermanentWiltingPointValue, permanentWiltingPointValue);
            Thread.sleep(1000);
            editSoilProperties_ConfirmBtn.click();
//            webDriverHelper.waitUntilVisible(editSoilProperties_successToast, 30, 1);
//            Assert.assertTrue(editSoilProperties_successToast.isDisplayed());
            webDriverHelper.waitUntilVisible(siteName_OnCardF, 30, 1);
            menuButtonF.click();
            webDriverHelper.waitUntilVisible(editSoilPropertiesOption, 30, 1);
            editSoilPropertiesOption.click();
            webDriverHelper.waitUntilVisible(editSoilProperties_FieldCapacityText, 30, 1);
            String fieldCapacityValue_Validation = editSoilProperties_FieldCapacityText.getText();
            Assert.assertEquals(fieldCapacityValue_Validation, newFieldCapacityValue);
            String newPermanentWiltingPointValue_Validation = editSoilProperties_PermanentWiltingPointText.getText();
            Assert.assertEquals(newPermanentWiltingPointValue_Validation, newPermanentWiltingPointValue);
        }
    }


//    public void captureEditSiteLoadTime(String role) throws IOException, InterruptedException {
//        if (!(role.equalsIgnoreCase("sysReader") || role.equalsIgnoreCase("orgReader"))) {
//            String loadInSeconds = null;
//            verifyEditSiteOption();
//            long start = System.currentTimeMillis();
////            StringHelper.devToolCapture(role);
////            verifyEditSiteModal();
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            ExcelReader.setValueForColumn("Edit Sites", loadInSeconds, role);
//            // HTML report generator
//            HTMLReport.addPageName("Edit Sites");
////            HTMLReport.generateReport("Edit Sites", loadInSeconds, role);
//            HTMLReport.writeReportToFile();
//        } else {
//            ExcelReader.setValueForColumn("Edit Sites", "NA", role);
//            // HTML report generator
//            HTMLReport.addPageName("Edit Sites");
////            HTMLReport.generateReport("Edit Sites", "NA", role);
//            HTMLReport.writeReportToFile();
//        }
//    }

    public void verifyEditSiteOption() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(viewSiteBtn_SiteCard, 240, 2);
        siteCardDetails = siteCardF.getText();
        siteCardName = siteName_OnCardF.getText();
        Dimension menuSize = menuButtonF.getSize();
        System.out.println("menuSize:- " + menuSize);
        menuButtonF.click();
        webDriverHelper.waitUntilVisible(editSiteButtonF, 90, 2);
        editSiteButtonF.click();
    }

    public void verifyEditSiteModal() throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(confirmButtonF, 90, 1);
        confirmButtonF.click();
        webDriverHelper.waitUntilVisible(successToast, 30, 1);
        Assert.assertTrue(successToast.isDisplayed());
        webDriverHelper.waitUntilVisible(viewSiteBtn_SiteCard, 30, 1);
        Assert.assertTrue(viewSiteBtn_SiteCard.isDisplayed());
        String afterEdit_siteCardDetails = siteCardF.getText();
        Assert.assertEquals(afterEdit_siteCardDetails, siteCardDetails);
    }

    public void navigateToSitePage(String role) throws IOException, InterruptedException {
//        webDriverHelper.waitUntilVisible(dashboardMenu_Sites, 30, 1);
        map.navigateToPage(role);
        webDriverHelper.waitUntilVisible(dashboardMenu_Sites, 30, 1);
        dashboardMenu_Sites.click();
    }

//    public void captureSitePageLoadTime(String role) throws IOException {
//        String loadInSeconds = null;
//        long start = System.currentTimeMillis();
//        webDriverHelper.waitUntilVisible(viewSiteBtn_SiteCard, 30, 1);
//        if (viewSiteBtn_SiteCard.isDisplayed()) {
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(viewSiteBtn_SiteCard.isDisplayed(), "site cards are displayed");
//        } else {
//            webDriverHelper.waitUntilVisible(noSitesAvailable, 30, 1);
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            Assert.assertTrue(noSitesAvailable.isDisplayed(), "Click here to create new site is displayed");
//        }
//        ExcelReader.setValueForColumn("Sites", loadInSeconds, role);
//    }


}


