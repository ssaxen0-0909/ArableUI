package pages;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.Constants;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static support.PropertiesReader.orgTargeted;
import static support.World.webDriverHelper;

public class Distributor {

    private final WebDriver driver;
    public String firstDeviceText;
    public WebElement firstDeviceElement;
    WebElement searchedDeviceElement;
    String deviceId;
    String value3;
    @FindBy(xpath = "//p[normalize-space()='Settings']")
    private WebElement dashboardMenu_Settings;
    @FindBy(xpath = "//p[normalize-space()='Distributor']")
    private WebElement distributorIcon;
    @FindBy(xpath = "//div[@class='create-org-btn']")
    private WebElement createNewOrgBtn;
    @FindBy(xpath = "//button[@class='btn-action confirm disabled']")
    private WebElement disabledConfirmBtn;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='head-tooltip']")
    private WebElement createOrgHeaderText;
    @FindBy(xpath = "//span[@class='fancy-link text-assigned']")
    private WebElement assignedDevicesModalBtn;
    @FindBy(xpath = "//span[@class='fancy-link text-unassigned']")
    private WebElement unassignedDevicesModalBtn;
    @FindBy(xpath = "//div[@class='tooltip-info']")
    private WebElement devicesModalInfo;
    @FindBy(xpath = "//div[@class='grid header-titles']")
    private WebElement columnHeaders;
    @FindBy(xpath = "//div[@class='view-details shown']")
    private WebElement orgDetails;
    @FindBy(xpath = "//div[@class='action-button icon-minus']")
    private WebElement minusIcon;
    @FindBy(xpath = "(//div[@class='action-button icon-plus'])[1]")
    private WebElement firstOrgPlusIcon;
    @FindBy(xpath = "//div[@class='edit-org-name-btn']")
    private WebElement editOrgNameBtn;
    @FindBy(xpath = "(//div[@class='grid body-list org-row']//div[@class='column name'])[1]")
    private WebElement firstOrgName;
    @FindBy(xpath = "//arable-dropdown-selector[@class='input-dropdown orgs']//div[@class='0 grid grid-center headers']")
    private WebElement sourceDropdown;
    @FindBy(xpath = "//arable-dropdown-selector[@class='destinationDropdown']//div[@class='0 grid grid-center headers']")
    private WebElement destinationDropdown;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='options']")
    private WebElement sourceOrg;
    @FindBy(xpath = "(//div[@class='column']//p[@class='0 selected'])[2]")
    private WebElement sourceOrgSelected;
    @FindBy(xpath = "//div[@class='search-container']")
    private WebElement searchBox;
    @FindBy(xpath = "//input[@id='org-search']")
    private WebElement searchField;
    @FindBy(xpath = "//input[@id='org-search' and @placeholder='Search Devices']")
    private WebElement searchPlaceholder;
    @FindBy(xpath = "//button[@class='search-btn']")
    private WebElement searchBtn;
    @FindBy(xpath = "//img[@alt='search-icon']")
    private WebElement searchIcon;
    @FindBy(xpath = "//div[@class='item']//span")
    private List<WebElement> devicesList;
    @FindBy(xpath = "//div[@class='devices-container']")
    private WebElement devicesContainer;
    @FindBy(xpath = "//div[@class='action icon-tick']")
    private WebElement selectedTick;
    @FindBy(xpath = "//div[@class='item selected-item']")
    private WebElement selectedItem;
    @FindBy(xpath = "//div[@class='content-info']//button[@class='btn-action close'][normalize-space()='Cancel']")
    private WebElement cancelBtn;
    @FindBy(xpath = "//div[@class='org-list']")
    private WebElement orgList;
    @FindBy(xpath = "//div[@class='action-button icon-plus']")
    private WebElement orgExpandIcon;
    @FindBy(xpath = "//div[contains(@class, 'grid') and contains(@class, 'body-list') and contains(@class, 'org-row')]")
    private List<WebElement> orgRows;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//img[@class='input-clear']")
    private WebElement searchClearBtn;
    @FindBy(xpath = "//p[@class='search-error']")
    private WebElement searchErrorMessage;
    @FindBy(xpath = "//p[@class='search-error']")
    private List<WebElement> searchErrorMessages;
    @FindBy(xpath = "//button[@class='search-btn-close']")
    private WebElement searchFieldCrossBtn;
    @FindBy(xpath = "//div[@class='search-section']")
    private WebElement searchSection;
    @FindBy(xpath = "(//div[@class='grid body-list org-row'])")
    private List<WebElement> orgListDetailsRow;
    @FindBy(xpath = "//div[@class='device-list']//div")
    private List<WebElement> devicesListInOrg;
    @FindBy(xpath = "(//div[@class='action-button icon-plus'])")
    private List<WebElement> plusIcon;
    @FindBy(xpath = "//div[@class='devices-container']//div[@class='item']")
    private List<WebElement> devicesListInModal;
    @FindBy(xpath = "//input[@placeholder='Please type the name of your new organization']")
    private WebElement enterOrgNameField;
    @FindBy(xpath = "(//div[@class='column-auto']/span)[1]")
    private WebElement sourceDropdownButton;
    @FindBy(xpath = "//div[@class='grid grid-center option checkbox-right']//p")
    private WebElement sourceOrgName;
    @FindBy(xpath = "//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//div[@class='error toast']")
    private WebElement errorToast;
    @FindBy(xpath = "//span[@class='message']")
    private WebElement errorMsgOrgName;
    @FindBy(xpath = "//div[@class='icon-tick input-icon-tick']")
    private WebElement orgNameRightTick;
    @FindBy(xpath = "(//span[@class='0 caret'])[1]")
    private WebElement sourceDropdownOrgName;
    @FindBy(xpath = "//div[@class='devices-container']//div[@class='item']")
    private WebElement sourceOrgUnassignedDevices;
    @FindBy(xpath = "//h3[normalize-space()='Assign Devices']")
    private WebElement sourceOrgUnassignedDevicesModalTitle;
    @FindBy(xpath = "//div[@class='action icon-tick']")
    private WebElement sourceOrgUnassignedDevicesSelected;
    @FindBy(xpath = "//div[@class='action icon-tick']")
    private List<WebElement> sourceOrgUnassignedDevicesSelectedList;
    @FindBy(xpath = "(//div[@class='action icon-plus'])[1]")
    private WebElement sourceOrgUnassignedDeviceFirstPlusIcon;
    @FindBy(xpath = "//button[@class='btn-action confirm' and @disabled='']")
    private WebElement returnBtnDisabled;
    @FindBy(xpath = "//button[@class='btn-action confirm enabled-button'][normalize-space()='return']")
    private WebElement returnBtnEnabled;
    @FindBy(xpath = "//button[@class='btn-action confirm enabled-button'][normalize-space()='Confirm']")
    private WebElement confirmBtnReturnModal;
    @FindBy(xpath = "//h3[normalize-space()='Success']")
    private WebElement successToast;
    @FindBy(xpath = "//div[@class='devices-container']")
    private List<WebElement> devicesListContainer;
    @FindBy(xpath = "//button[normalize-space()='Assign']")
    private WebElement assignBtn;
    @FindBy(xpath = "(//div[@class='count']//span)[3]")
    private WebElement assignedBannerCount;
    @FindBy(xpath = "//div[@class='action icon-plus']")
    private WebElement sourceOrgUnassignedDevicePlusIcon;
    @FindBy(xpath = "//div[@class='devices-container']//div//span")
    private WebElement sourceOrgDevicesForReturn;

    public Distributor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static boolean isVerticalScrollBarPresent(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isScrollBarPresent = (boolean) js.executeScript(
                "return document.documentElement.scrollHeight > document.documentElement.clientHeight;");
        return isScrollBarPresent;
    }

    public void verifyDevicesCountInBannerVSSourceOrg(String role) throws IOException, InterruptedException {
        Thread.sleep(10000);
        String assignedBannerDeviceCount = assignedBannerCount.getText();
        System.out.println("assignedBannerDeviceCount:-" + assignedBannerDeviceCount);
        verifyAssignedModalContents(role);
        verifySelectingDevicesFromSourceOrg();
        webDriverHelper.waitUntilVisible(sourceOrgUnassignedDevicesSelected, 10, 1);
        sourceOrgUnassignedDevicesSelected.click();
        Thread.sleep(10000);
        String sourceOrgUnassignedDevicePlusIconCount = sourceOrgDevicesForReturn.getText();
        System.out.println("sourceOrgUnassignedDevicePlusIconCount:-" + sourceOrgUnassignedDevicePlusIconCount);
        Assert.assertEquals(assignedBannerDeviceCount, sourceOrgUnassignedDevicePlusIconCount);
    }

    public void verifyReturnOfDevices(String role) throws IOException, InterruptedException {
        verifyAssignedModalContents(role);
        verifySelectingDevicesFromSourceOrg();
        destinationDropdown.click();
        webDriverHelper.waitUntilVisible(sourceOrg, 10, 1);
        sourceOrg.click();
        returnBtnEnabled.click();
        webDriverHelper.waitUntilVisible(confirmBtnReturnModal, 10, 1);
        confirmBtnReturnModal.click();
        webDriverHelper.waitUntilVisible(successToast, 10, 1);

        verifyUnassignedModalContents(role);
        sourceDropdown.click();
        webDriverHelper.waitUntilVisible(sourceOrg, 10, 1);
        Thread.sleep(2000);
        sourceOrg.click();
        webDriverHelper.waitUntilVisible(sourceOrgUnassignedDeviceFirstPlusIcon, 10, 1);

        for (WebElement deviceList : devicesListContainer) {
            Assert.assertTrue(deviceList.getText().contains(deviceId));
        }
    }

    public void verifyAssignOfDevice(String role) throws IOException, InterruptedException {
        verifyUnassignedModalContents(role);

        sourceDropdown.click();
        webDriverHelper.waitUntilVisible(searchClearBtn, 30, 2);
        webDriverHelper.waitUntilVisible(sourceOrg, 30, 2);
        Thread.sleep(2000);
        sourceOrg.click();
        webDriverHelper.waitUntilVisible(sourceOrgUnassignedDeviceFirstPlusIcon, 10, 1);
        List<WebElement> list = Collections.singletonList(sourceOrgUnassignedDevices);
        System.out.println("list:-" + list.get(0).getText());
        deviceId = list.get(0).getText();
        sourceOrgUnassignedDevices.click();
        Assert.assertTrue(sourceOrgUnassignedDevicesSelected.isDisplayed());

        destinationDropdown.click();
        webDriverHelper.waitUntilVisible(sourceOrg, 10, 1);
        sourceOrg.click();
        assignBtn.click();
        webDriverHelper.waitUntilVisible(confirmBtnReturnModal, 10, 1);
        confirmBtnReturnModal.click();
        webDriverHelper.waitUntilVisible(successToast, 10, 1);

        verifyAssignedModalContents(role);
        sourceDropdown.click();
        webDriverHelper.waitUntilVisible(searchClearBtn, 30, 2);
        webDriverHelper.waitUntilVisible(sourceOrg, 30, 2);
        sourceOrg.click();
        webDriverHelper.waitUntilVisible(sourceOrgUnassignedDeviceFirstPlusIcon, 10, 1);

        for (WebElement deviceList : devicesListContainer) {
            Assert.assertTrue(deviceList.getText().contains(deviceId));
        }
    }

    public void verifySelectingDevicesFromSourceOrg() throws IOException, InterruptedException {
        sourceDropdown.click();
        webDriverHelper.waitUntilVisible(searchClearBtn, 30, 2);
        webDriverHelper.waitUntilVisible(sourceOrg, 30, 2);
        Thread.sleep(2000);
        sourceOrg.click();
        webDriverHelper.waitUntilVisible(sourceOrgUnassignedDevices, 10, 1);

        List<WebElement> list = Collections.singletonList(sourceOrgUnassignedDevices);
        deviceId = list.get(0).getText();
        sourceOrgUnassignedDevices.click();
        Assert.assertTrue(sourceOrgUnassignedDevicesSelected.isDisplayed());

    }

    public void verifyButtonsColorAssignedModal(String role) throws IOException, InterruptedException {
        verifyAssignedModalContents(role);
        Actions act = new Actions(driver);
        act.moveToElement(cancelBtn).perform();
        Thread.sleep(2000);
        String rgbFormat = cancelBtn.getCssValue("background-color");
        String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
        Assert.assertEquals(hexcolor, "#1773c6");
    }

    public void verifyButtonsColorUnassignedModal(String role) throws IOException, InterruptedException {
        verifyUnassignedModalContents(role);
        Actions act = new Actions(driver);
        act.moveToElement(cancelBtn).perform();
        Thread.sleep(2000);
        String rgbFormat = cancelBtn.getCssValue("background-color");
        String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
        Assert.assertEquals(hexcolor, "#1773c6");
    }

    public void verifyDeSelectingDevicesInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyUnassignedModalContents(role);
        verifySelectingDevicesFromSourceOrg();
        sourceOrgUnassignedDevicesSelected.click();
        Assert.assertTrue(sourceOrgUnassignedDeviceFirstPlusIcon.isDisplayed());
    }

    public void verifyMultipleDeviceSelectionInAssignedModal(String role) throws IOException, InterruptedException {
        verifyEnablingOfReturnBtnInAssignedModal(role);
        sourceOrgUnassignedDevices.click();
        int count = sourceOrgUnassignedDevicesSelectedList.size();
        Assert.assertTrue(count > 1);
    }

    public void verifyEnablingOfReturnBtnInAssignedModal(String role) throws IOException, InterruptedException {
        verifySearchErrorMessageInAssignedModal(role);
        sourceOrgUnassignedDevices.click();
        Assert.assertTrue(sourceOrgUnassignedDevicesSelected.isDisplayed());
        Assert.assertTrue(returnBtnDisabled.isDisplayed());
        destinationDropdown.click();
        webDriverHelper.waitUntilVisible(sourceOrg, 30, 2);
        sourceOrg.click();
        Assert.assertTrue(returnBtnEnabled.isDisplayed());
    }

    public void verifySortingOfSourceDropdownInAssignedModal(String role) throws IOException, InterruptedException {
        verifyAssignedModalContents(role);
        sourceDropdown.click();
        webDriverHelper.waitUntilVisible(searchClearBtn, 30, 2);
        webDriverHelper.waitUntilVisible(sourceOrg, 30, 2);
        String sourceOrgText = sourceOrg.getText();
        Assert.assertTrue(sourceOrgText.contains("a") || sourceOrgText.contains("A") || sourceOrgText.contains("1"));
        destinationDropdown.click();
        webDriverHelper.waitUntilVisible(sourceOrg, 30, 2);
        Assert.assertTrue(sourceOrgText.contains("a") || sourceOrgText.contains("A") || sourceOrgText.contains("1"));
    }

    public void verifySortingOfSourceDropdownInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyUnassignedModalContents(role);
        sourceDropdown.click();
        webDriverHelper.waitUntilVisible(searchClearBtn, 30, 2);
        webDriverHelper.waitUntilVisible(sourceOrg, 30, 2);
        String sourceOrgText = sourceOrg.getText();
        Assert.assertTrue(sourceOrgText.contains("a") || sourceOrgText.contains("A") || sourceOrgText.contains("1"));
        destinationDropdown.click();
        webDriverHelper.waitUntilVisible(sourceOrg, 30, 2);
        Assert.assertTrue(sourceOrgText.contains("a") || sourceOrgText.contains("A") || sourceOrgText.contains("1"));
    }

    public void verifyCapitalLetterInOrgName(String role) throws IOException, InterruptedException {
        verifyCreateNewOrgModal(role);
        webDriverHelper.waitUntilVisible(enterOrgNameField, 10, 1);
        enterOrgNameField.sendKeys(orgTargeted.toUpperCase());
        webDriverHelper.waitUntilVisible(orgNameRightTick, 10, 1);
        Assert.assertTrue(orgNameRightTick.isDisplayed());
    }

    public void verifySourceOrgList(String role) throws IOException, InterruptedException {
        verifyCreateNewOrgModal(role);
        webDriverHelper.waitUntilVisible(enterOrgNameField, 10, 1);
        enterOrgNameField.sendKeys(orgTargeted);
        Assert.assertTrue(disabledConfirmBtn.isDisplayed());
        sourceDropdownOrgName.click();
        webDriverHelper.waitUntilVisible(sourceOrg, 20, 1);
        Thread.sleep(3000);
        Assert.assertTrue(sourceOrg.getText().contains(orgTargeted));
        sourceOrg.click();
        webDriverHelper.waitUntilVisible(sourceOrgUnassignedDevicesModalTitle, 10, 1);
        Assert.assertTrue(sourceOrgUnassignedDevices.isDisplayed());
        sourceOrgUnassignedDevices.click();
        Assert.assertTrue(sourceOrgUnassignedDevicesSelected.isDisplayed());
        sourceOrgUnassignedDevicesSelected.click();
        Assert.assertTrue(sourceOrgUnassignedDeviceFirstPlusIcon.isDisplayed());
        webDriverHelper.waitUntilInvisibilityOfElementLocated(disabledConfirmBtn, 10, 1);
        Assert.assertTrue(confirmBtn.isDisplayed());
    }

    public void verifyOrgNameInfoMessage(String role) throws IOException, InterruptedException {
        verifyCreateNewOrgModal(role);
        webDriverHelper.waitUntilVisible(enterOrgNameField, 10, 1);
        enterOrgNameField.click();
        enterOrgNameField.sendKeys(orgTargeted);
        while (enterOrgNameField.getAttribute("value").length() > 0) {
            System.out.println(enterOrgNameField.getAttribute("value"));
            enterOrgNameField.sendKeys(Keys.BACK_SPACE);
        }
        webDriverHelper.waitUntilVisible(errorMsgOrgName, 10, 1);
        Assert.assertTrue(errorMsgOrgName.getText().contains("Org name is required"));
    }

    public void duplicateOrgName(String role) throws IOException, InterruptedException {
        verifyCreateNewOrgModal(role);
        webDriverHelper.waitUntilVisible(enterOrgNameField, 10, 1);
        enterOrgNameField.click();
        enterOrgNameField.sendKeys(orgTargeted);
        webDriverHelper.waitUntilVisible(orgNameRightTick, 10, 1);
        sourceDropdownButton.click();
        webDriverHelper.waitUntilVisible(sourceOrgName, 10, 1);
        sourceOrgName.click();
        confirmBtn.click();
        webDriverHelper.waitUntilVisible(errorToast, 10, 1);
        Assert.assertTrue(errorToast.getText().contains("Creating New Org Failed"));
        Assert.assertTrue(errorMsgOrgName.getText().contains("Org name arable-team already exists"));
    }

    public void verifyScrollBarInAssignedModal(String role) throws IOException, InterruptedException {
        verifySearchErrorMessageInAssignedModal(role);
        if (devicesListInModal.size() > 10) {
            System.out.println("Device count is more than 10");
            Assert.assertTrue(isVerticalScrollBarPresent(driver), "Vertical scroll bar is not present.");
            confirmBtn.click();
        }
    }

    public void verifyScrollBarInUnassignedModal(String role) throws IOException, InterruptedException {
        verifySearchErrorMessageInUnassignedModal(role);
        if (devicesListInModal.size() > 10) {
            System.out.println("Device count is more than 10");
            Assert.assertTrue(isVerticalScrollBarPresent(driver), "Vertical scroll bar is not present.");
        }
    }

    public void verifyDevicesListInOrg(String role) throws IOException, InterruptedException {
        verifyLandingOnDistributorPage(role);
        webDriverHelper.waitUntilVisible(firstOrgPlusIcon, 10, 1);

        outerLoop:
        for (WebElement expandOrgBtn : plusIcon) {
            expandOrgBtn.click();
            Thread.sleep(500);
            webDriverHelper.waitUntilVisible(minusIcon, 10, 1);
            System.out.println("devicesListInOrg.size():- " + devicesListInOrg.size());
            Thread.sleep(500);
            if (devicesListInOrg.size() > 10) {

                System.out.println("Device count is more than 10");
                Assert.assertTrue(isVerticalScrollBarPresent(driver), "Vertical scroll bar is not present.");
                break outerLoop;
            }
            minusIcon.click();
        }
    }

    public void verifyOrgDetailsInRows(String role) throws IOException, InterruptedException {
        verifyLandingOnDistributorPage(role);
        webDriverHelper.waitUntilVisibilityOfAllElements(orgListDetailsRow, 10, 1);
        if (orgListDetailsRow.size() == 0) {
            System.out.println("No elements found with the specified XPath");
            return;
        }
        for (WebElement orgDetails : orgListDetailsRow) {
            String orgDetailsText = orgDetails.getText();
            System.out.println(orgDetailsText);
        }
    }

    public void verifyClearingSearchResultInAssignedModal(String role) throws IOException, InterruptedException {
        verifySearchErrorMessageInAssignedModal(role);
        List<String> actualDeviceNames = getActualDeviceNames();
        System.out.println("actualDeviceNames:- " + actualDeviceNames.get(0));
        searchField.sendKeys(actualDeviceNames.get(0));
        searchField.sendKeys(Keys.ENTER);
        webDriverHelper.waitUntilVisible(searchFieldCrossBtn, 30, 1);
        Assert.assertEquals(0, searchErrorMessages.size());
        searchFieldCrossBtn.click();
        Assert.assertTrue(searchErrorMessage.isDisplayed());
    }

    public void verifyClearingSearchResultInUnassignedModal(String role) throws IOException, InterruptedException {
        verifySearchErrorMessageInUnassignedModal(role);
        List<String> actualDeviceNames = getActualDeviceNames();
        System.out.println("actualDeviceNames:- " + actualDeviceNames.get(0));
        searchField.sendKeys(actualDeviceNames.get(0));
        searchField.sendKeys(Keys.ENTER);
        webDriverHelper.waitUntilVisible(searchFieldCrossBtn, 30, 1);
        Assert.assertEquals(0, searchErrorMessages.size());
        searchFieldCrossBtn.click();
        Assert.assertTrue(searchErrorMessage.isDisplayed());
    }

    public void verifySearchErrorMessageInAssignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInAssignedModal(role);
        Assert.assertTrue(searchErrorMessage.getText().contains(Constants.DistributorSearchErrorMsg));
    }

    public void verifySearchErrorMessageInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInUnassignedModal(role);
        System.out.println("searchErrorMessage:- " + searchErrorMessage.getText());
        Assert.assertTrue(searchErrorMessage.getText().contains(Constants.DistributorSearchErrorMsg));
    }

    public void verifyDevicesSearchBoxInAssignedModal(String role) throws IOException, InterruptedException {
        verifyAssignedModalContents(role);
        sourceDropdown.click();
        webDriverHelper.waitUntilVisible(searchClearBtn, 30, 2);
        webDriverHelper.waitUntilVisible(sourceOrg, 60, 2);
        Thread.sleep(2000);
        sourceOrg.click();
        Thread.sleep(2000);
        webDriverHelper.waitUntilVisible(searchBox, 30, 2);
        webDriverHelper.waitUntilVisible(searchIcon, 30, 2);
        Assert.assertTrue(searchBtn.isDisplayed());
        Assert.assertTrue(searchIcon.isDisplayed());
    }

    public void verifyPartialTextSearchInAssignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInAssignedModal(role);
        verifyDevicesSearch(role, true, true);
    }

    public void verifyPartialTextSearchInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInUnassignedModal(role);
        verifyDevicesSearch(role, true, true);
    }

    public void verifyDevicesSearchInAssignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInAssignedModal(role);
        verifyDevicesSearch(role, false, false);
    }

    public void verifyDevicesSearchInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInUnassignedModal(role);
        verifyDevicesSearch(role, false, false);
    }

    public void verifyCaseSensitiveTextSearchInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInUnassignedModal(role);
        verifyDevicesSearch(role, false, true);
    }

    public void verifyCaseSensitiveTextSearchInAssignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInAssignedModal(role);
        verifyDevicesSearch(role, false, true);
    }

    public void verifyInvalidTextSearchInAssignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInAssignedModal(role);
        searchField.click();
        searchField.sendKeys(Constants.invalidText);
        searchBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(devicesContainer));

        Assert.assertTrue(devicesContainer.getText().contains(Constants.NoDevicesMsg));
    }

    public void verifyInvalidTextSearchInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInUnassignedModal(role);
        searchField.click();
        searchField.sendKeys(Constants.invalidText);
        searchBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(devicesContainer));

        Assert.assertTrue(devicesContainer.getText().contains(Constants.NoDevicesMsg));
    }

    public void verifyDevicesCountInAssignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInAssignedModal(role);
        webDriverHelper.waitUntilVisible(devicesList.get(0), 30, 1);
        String orgName = sourceOrgSelected.getText();
        System.out.println("sourceOrgSelected: " + orgName);
        List<String> actualDeviceNames = getActualDeviceNames();
        cancelBtn.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement icon = findIconForOrg(orgName);
        if (icon != null) {
            clickIconAndCompareDevices(icon, actualDeviceNames);
        }
    }

    public void verifyDevicesCountInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInUnassignedModal(role);
        webDriverHelper.waitUntilVisible(devicesList.get(0), 30, 1);
        String orgName = sourceOrgSelected.getText();
        System.out.println("sourceOrgSelected: " + orgName);
        List<String> actualDeviceNames = getActualDeviceNames();
        cancelBtn.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement icon = findIconForOrg(orgName);
        if (icon != null) {
            clickIconAndCompareDevices(icon, actualDeviceNames);
        }
    }

    public void verifyDeviceSelectionRetainedInAssignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInAssignedModal(role);
        webDriverHelper.waitUntilVisible(devicesList.get(0), 30, 1);
        String textToSend = devicesList.get(0).getText();
        System.out.println("textToSend:- " + textToSend);
        devicesList.get(0).click();

        webDriverHelper.waitUntilVisible(selectedTick, 30, 1);
        searchField.click();
        searchField.sendKeys(textToSend);
        searchBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(selectedItem));
        Assert.assertTrue(selectedItem.isDisplayed());
    }


    public void verifyDeviceSelectionRetainedInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyDevicesSearchBoxInUnassignedModal(role);
        webDriverHelper.waitUntilVisible(devicesList.get(0), 30, 1);
        String textToSend = devicesList.get(0).getText();
        System.out.println("textToSend:- " + textToSend);
        devicesList.get(0).click();

        webDriverHelper.waitUntilVisible(selectedTick, 30, 1);
        searchField.click();
        searchField.sendKeys(textToSend);
        searchBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(selectedItem));
        Assert.assertTrue(selectedItem.isDisplayed());
    }

    public void verifyDevicesSearch(String role, boolean useSearchQuery, boolean lowercase) throws IOException, InterruptedException {
        int devicesCount = devicesList.size();
        System.out.println("devicesCount: " + devicesCount);

        sendKeysToFirstDeviceElement(useSearchQuery, lowercase);
        searchBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(devicesList));

        int updatedDevicesCount = devicesList.size();
        System.out.println("Updated device count: " + updatedDevicesCount);

        searchedDeviceElement = devicesList.get(0);
        String searchedDeviceText = searchedDeviceElement.getText();
        System.out.println("searchedDeviceText: " + searchedDeviceText);

        Assert.assertNotEquals(devicesCount, updatedDevicesCount);

        if (lowercase) {
            Assert.assertTrue(searchedDeviceText.toLowerCase().contains(firstDeviceText.toLowerCase()));
        } else {
            Assert.assertTrue(searchedDeviceText.contains(firstDeviceText));
        }
    }

    public void sendKeysToFirstDeviceElement(boolean useSearchQuery, boolean useLowerCase) {
        try {
            if (devicesList != null && !devicesList.isEmpty()) {
                firstDeviceElement = devicesList.get(0);
                firstDeviceText = firstDeviceElement.getText();
                System.out.println("firstDeviceText: " + firstDeviceText);
                if (searchBox != null && searchBox.isDisplayed() && searchBox.isEnabled()) {
                    searchField.click();
                    String textToPass = useSearchQuery ? firstDeviceText.substring(0, 3) : firstDeviceText;
                    if (useLowerCase) {
                        textToPass = Character.toLowerCase(textToPass.charAt(0)) + textToPass.substring(1);
                    }
                    searchField.clear();
                    searchField.sendKeys(textToPass);
                } else {
                    System.out.println("Search box is not available or not clickable.");
                }
            } else {
                System.out.println("No devices found in the list.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void verifyDevicesSearchBoxInUnassignedModal(String role) throws IOException, InterruptedException {
        verifyUnassignedModalContents(role);
        sourceDropdown.click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement sourceOrgElement = wait.until(ExpectedConditions.elementToBeClickable(sourceOrg));
        sourceOrgElement.click();
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        wait.until(ExpectedConditions.visibilityOf(searchPlaceholder));
        try {
            Thread.sleep(2000); // Add a delay of 2 seconds
            Assert.assertTrue(searchBtn.isDisplayed());
            Assert.assertTrue(searchIcon.isDisplayed());
        } catch (InterruptedException e) {
            System.out.println("An error occurred while waiting: " + e.getMessage());
        } catch (AssertionError e) {
            System.out.println("Assertion error: " + e.getMessage());
        }
    }

    public void verifyOrgDetails(String role) throws IOException, InterruptedException {
        verifyLandingOnDistributorPage(role);
        webDriverHelper.waitUntilVisible(firstOrgPlusIcon, 30, 1);
        firstOrgPlusIcon.click();
        webDriverHelper.waitUntilVisible(orgDetails, 30, 1);
        Assert.assertTrue(orgDetails.getText().contains(Constants.OrgDetailsHeader));
        Assert.assertTrue(minusIcon.isDisplayed());
    }

    public void verifyColumnsHeaders(String role) throws IOException, InterruptedException {
        verifyLandingOnDistributorPage(role);
        System.out.println("columnHeaders.getText()" + columnHeaders.getText());
        Assert.assertTrue(columnHeaders.getText().contains(Constants.distributorFirstColumnHeader));
        Assert.assertTrue(columnHeaders.getText().contains(Constants.distributorSecondColumnHeader));
        Assert.assertTrue(columnHeaders.getText().contains(Constants.distributorThirdColumnHeader));
    }

    public void navigateToPage(String role) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardMenu_Settings)).click();
        wait.until(ExpectedConditions.elementToBeClickable(distributorIcon)).click();
        verifyLandingOnDistributorPage(role);
    }

    public void verifyLandingOnDistributorPage(String role) throws IOException, InterruptedException {
        webDriverHelper.waitUntilVisible(createNewOrgBtn, 30, 1);
        Assert.assertTrue(createNewOrgBtn.getText().contains(Constants.createOrgBtn));
    }

    public void verifyCreateNewOrgModal(String role) throws IOException, InterruptedException {
        verifyLandingOnDistributorPage(role);
        createNewOrgBtn.click();
        webDriverHelper.waitUntilVisible(createOrgHeaderText, 30, 1);
        Assert.assertTrue(createOrgHeaderText.getText().contains(Constants.createOrgBtn));
        Assert.assertTrue(disabledConfirmBtn.isDisplayed());
        Assert.assertTrue(disabledConfirmBtn.getText().contains(Constants.confirmBtnText));
    }

    public void verifyAssignedModalContents(String role) throws IOException, InterruptedException {
        verifyLandingOnDistributorPage(role);
        assignedDevicesModalBtn.click();
        webDriverHelper.waitUntilVisible(devicesModalInfo, 30, 1);
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.assignedDevicesModalHeader));
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.assignedDevicesModalDesc));
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.assignedDevicesModalSteps));
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.assignedDevicesModalOrgSource));
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.assignedDevicesModalDesc));
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.assignedDevicesModalActionBtn));
    }

    public void verifyUnassignedModalContents(String role) throws IOException, InterruptedException {
        verifyLandingOnDistributorPage(role);
        unassignedDevicesModalBtn.click();
        webDriverHelper.waitUntilVisible(devicesModalInfo, 30, 1);
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.unassignedDevicesModalHeader));
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.unassignedDevicesModalSteps));
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.unassignedDevicesModalOrgSource));
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.unassignedDevicesModalOrgDest));
        Assert.assertTrue(devicesModalInfo.getText().contains(Constants.unassignedDevicesModalActionBtn));
    }

    public void verifyEditingOrgName(String role) throws IOException, InterruptedException {
        verifyLandingOnDistributorPage(role);
        webDriverHelper.waitUntilVisible(firstOrgPlusIcon, 30, 1);
        firstOrgPlusIcon.click();
        webDriverHelper.waitUntilVisible(orgDetails, 30, 1);
        if (editOrgNameBtn.isDisplayed()) {
            String OrgName = firstOrgName.getText();
            System.out.println("OrgName:- " + OrgName);
            editOrgNameBtn.click();
        }
        Assert.assertFalse(editOrgNameBtn.isDisplayed());
    }

    //re-usable methods used for device list comparison
    private List<String> getActualDeviceNames() {
        List<String> actualDeviceNames = new ArrayList<>();
        for (WebElement device : devicesList) {
            String deviceName = device.getText();
            // Perform any desired actions with the device name
            actualDeviceNames.add(deviceName);
        }
        return actualDeviceNames;
    }

    private WebElement findIconForOrg(String orgName) {
        for (WebElement orgRow : orgRows) {
            List<WebElement> orgRowElements = orgRow.findElements(By.xpath(".//div")); // Fetch all child divs of the row
            for (WebElement element : orgRowElements) {
                if (element.getText().trim().equals(orgName)) {
                    return orgRow.findElement(By.xpath(".//div[contains(@class, 'action-button') and contains(@class, 'icon-plus')]"));
                }
            }
        }
        return null;
    }

    private void clickIconAndCompareDevices(WebElement icon, List<String> actualDeviceNames) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", icon);

        WebDriverWait newDeviceListWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> newDeviceElements = newDeviceListWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='device-list']//span")));

        List<String> newDeviceNames = getNewDeviceNames(newDeviceElements);

        assertDeviceLists(actualDeviceNames, newDeviceNames);
    }

    private List<String> getNewDeviceNames(List<WebElement> newDeviceElements) {
        List<String> newDeviceNames = new ArrayList<>();
        for (WebElement newDevice : newDeviceElements) {
            String newDeviceName = newDevice.getText();
            // Perform any desired actions with the new device name
            newDeviceNames.add(newDeviceName);
        }
        return newDeviceNames;
    }

    private void assertDeviceLists(List<String> actualDeviceNames, List<String> newDeviceNames) {
        List<String> trimmedActualDeviceNames = trimDeviceNames(actualDeviceNames);
        List<String> trimmedNewDeviceNames = trimDeviceNames(newDeviceNames);

        Assert.assertEquals(trimmedActualDeviceNames, trimmedNewDeviceNames);
    }

    private List<String> trimDeviceNames(List<String> deviceNames) {
        List<String> trimmedDeviceNames = new ArrayList<>();
        for (String deviceName : deviceNames) {
            trimmedDeviceNames.add(StringUtils.trim(deviceName));
        }
        return trimmedDeviceNames;
    }
}
