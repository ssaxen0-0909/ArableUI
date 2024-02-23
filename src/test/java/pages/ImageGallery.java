package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import support.Constants;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

import static support.WebDriverHelper.wait;
import static support.World.searchPage;
import static support.World.webDriverHelper;

public class ImageGallery {
    String loadInSeconds = null;
    long start;
    @FindBy(xpath = "//ul[@class='tab-nav']")
    WebElement tabList;
    @FindBy(xpath = "//div[@class='site-detail']//a//div")
    List<WebElement> imgList;
    @FindBy(xpath = "//div[@class='deployment']")
    WebElement deploymentSection;
    @FindBy(xpath = "//div[@class='vision-not-enabled']")
    WebElement noImgInDeploymentModal;
    private WebDriver driver;
    @FindBy(xpath = "//ul[@class='tab-nav']")
    private List<WebElement> tabLists;
    @FindBy(xpath = "//p[normalize-space()='Vision']")
    private WebElement visionTab;
    @FindBy(xpath = "(//div[@class='selectImgHover'])[1]")
    private WebElement firstThumbnail;
    @FindBy(xpath = "//button[@id='lg-custom-tooltip']")
    private WebElement galleryViewHeader;
    @FindBy(xpath = "//div[@id='lg-custom-dummy']//button")
    private List<WebElement> galleryViewThumbnails;
    @FindBy(xpath = "//img[@alt='nextarrow']")
    private WebElement galleryViewRightArrow;
    @FindBy(xpath = "//img[@alt='backarrow']")
    private WebElement galleryViewBackArrow;
    @FindBy(xpath = "//img[@class='lg-object lg-image' and @data-index='0']")
    private WebElement galleryViewFirstImg;
    @FindBy(xpath = "//div[@class='filter']")
    private WebElement defaultFilterSelected;
    @FindBy(xpath = "//div[@class='filter']//div[@class='grid grid-center option']")
    private List<WebElement> filterOptions;
    @FindBy(xpath = "//div[@class='filter']//span")
    private WebElement filterDropdownBtn;
    @FindBy(xpath = "//div[@class='vision-not-enabled']")
    private List<WebElement> visionNotEnabledView;
    @FindBy(xpath = "//span[@class='Arable-Vision-is-not']")
    private WebElement noImageAvailableMsg;
    @FindBy(xpath = "//div[@class='is-loading']")
    private WebElement pageLoading;
    @FindBy(xpath = "//div[@class='deployment']//span")
    private WebElement deploymentDropdownBtn;
    @FindBy(xpath = "//div[@class='deployment']//div[@class='options']//p")
    private List<WebElement> deploymentDropdownOptions;
    @FindBy(xpath = "//div[@class='grid grid-center option selected']//p[contains(text(),'All Deployments')]")
    private WebElement allDeploymentOption;
    @FindBy(xpath = "//div[@class='deployment']//p[@class='iconEnabled']")
    private List<WebElement> historicalDeployments;
    @FindBy(xpath = "//button[normalize-space()='Select']")
    private WebElement selectBtn;
    @FindBy(xpath = "//button[normalize-space()='Select']")
    private List<WebElement> selectBtnForReaders;
    @FindBy(xpath = "//button[@class='select-button']")
    private WebElement selectBtnCancel;
    @FindBy(xpath = "//button[@class='select-button']")
    private List<WebElement> selectBtnNoImage;
    @FindBy(xpath = "//img[@class='select-icon']")
    private WebElement archiveRestoreBtn;
    @FindBy(xpath = "//img[@class='select-icon']")
    private List<WebElement> archiveRestoreBtnList;
    @FindBy(xpath = "//img[@class='select-icon']")
    private List<WebElement> archiveRestoreBtnVisibility;
    @FindBy(xpath = "//div[@class='modal fade in show']//div[@class='modal-dialog']")
    private WebElement popupModal;
    @FindBy(xpath = "//img[@alt='archive']")
    private WebElement archiveIconInPopup;
    @FindBy(xpath = "//div[@class='modal fade in show']//button[@class='btn-action confirm'][normalize-space()='Confirm']")
    private WebElement popupConfirmBtn;
    @FindBy(xpath = "//div[@class='modal fade in show']//button[@class='btn-action close'][normalize-space()='Cancel']")
    private WebElement popupCancelBtn;
    @FindBy(xpath = "//div[@class='archive toast']")
    private WebElement archiveToastMsg;
    @FindBy(xpath = "//div[@class='restore toast']")
    private WebElement restoreToastMsg;
    @FindBy(xpath = "//div[contains(@class, 'restore') and contains(@class, 'toast')]")
    private WebElement galleryViewRestoreToastMsg;
    @FindBy(xpath = "//div[@class='site-detail']//a")
    private List<WebElement> imgThumbnailLists;
    @FindBy(xpath = "//div[@class='vision-not-enabled']")
    private List<WebElement> noImgInDeployment;
    @FindBy(xpath = "//p[@class='0 selected'][normalize-space()='Archived']")
    private WebElement archivedFilter;
    @FindBy(xpath = "//span[@class='caption']//img")
    private List<WebElement> downloadIcon;
    @FindBy(xpath = "(//span[@class='caption']//img)[1]")
    private WebElement firstDownloadIcon;
    @FindBy(xpath = "//span[@class='caption']")
    private List<WebElement> imgNameDownloadIcon;
    @FindBy(xpath = "(//p[@class='caption_size'])[1]")
    private WebElement firstThumbnailName;
    @FindBy(xpath = "(//p[@class='caption_size'])[1]")
    private List<WebElement> thumbnailNames;
    @FindBy(xpath = "//button[@class='lg-close lg-icon']")
    private WebElement galleryViewCrossBtn;
    @FindBy(xpath = "//img[@alt='delete']")
    private WebElement galleryViewArchiveBtn;
    @FindBy(xpath = "//img[@alt='delete']")
    private List<WebElement> galleryViewArchiveBtnList;
    @FindBy(xpath = "//img[@src='/img/icons/restore.svg' and contains(@class, 'restoreImg')]")
    private WebElement galleryViewRestoreBtn;
    @FindBy(xpath = "//img[@src='/img/icons/restore.svg' and contains(@class, 'restoreImg')]")
    private List<WebElement> galleryViewRestoreBtnList;
    @FindBy(xpath = "//img[@class='img-responsive img-opacity']")
    private WebElement selectedImage;
    @FindBy(xpath = "//img[@class='img-responsive img-opacity']")
    private List<WebElement> selectedImageView;
    @FindBy(xpath = "//img[@alt='download']")
    private WebElement galleryViewDownloadBtn;
    @FindBy(xpath = "//div[@class='site-detail']//a[20]")
    private WebElement twentiethThumbnail;
    @FindBy(xpath = "//div[@class='ScrollStyle']//img")
    private List<WebElement> imgListFrame;
    @FindBy(xpath = "//div[@class='error toast']")
    private List<WebElement> errorToastMaxSelect;
    @FindBy(xpath = "//div[@class='site-detail']//a//div//img")
    private List<WebElement> thumbnailRadioBtn;
    @FindBy(xpath = "//div[@class='ScrollStyle']")
    private WebElement scrollContainer;
    @FindBy(xpath = "//div[@class='success toast']")
    private WebElement downloadSuccessToast;
    @FindBy(xpath = "//div[@class='site-detail']//a")
    private WebElement imagesThumbnail;
    @FindBy(xpath = "(//img[@class='img-responsive'])[1]")
    private WebElement firstImageThumbnail;

    public ImageGallery(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyImageNameFormat(String page) throws InterruptedException {
        webDriverHelper.waitUntilVisible(firstThumbnailName, 30, 1);
        for (int i = 0; i < thumbnailNames.size(); i++) {
            WebElement list = thumbnailNames.get(i);
            String pattern = "\\d{2} [A-Za-z]+ \\d{4} @\\d{1,2}(am|pm)";
            String text = list.getText().trim();
            System.out.println("text:- " + text);
            // Check if text is not empty
            boolean isMatch = false;
            if (!text.isEmpty()) {
                isMatch = Pattern.matches(pattern, text);
                assert isMatch : "Element at index " + i + " does not follow the specified format. Text: " + text;
            } else {
                System.out.println("Warning: Element at index " + i + " has empty text.");
            }
        }
    }

    public void verifyScrollingInGalleryViewViaKeyboard(String role) throws InterruptedException {
        try {
            navigatingToGalleryView(role);
            Thread.sleep(1000);
            if (galleryViewThumbnails.size() > 0) {
                String firstName = galleryViewHeader.getText();
                galleryViewThumbnails.get(0).sendKeys(Keys.ARROW_RIGHT);
                Thread.sleep(1000);
                galleryViewThumbnails.get(1).sendKeys(Keys.ARROW_LEFT);
                Thread.sleep(1000);
                String nextName = galleryViewHeader.getText();
                Assert.assertEquals(firstName, nextName);
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Exception");
        }
        galleryViewCrossBtn.click();
    }

    public void verifyLatestImagePosition(String page) throws InterruptedException {
        webDriverHelper.waitUntilVisible(firstThumbnailName, 30, 1);
        String ActualTimestamp = firstThumbnailName.getText();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedCurrentDate = currentDate.format(formatter);
        String elementText = firstThumbnailName.getText();
        System.out.println("latest image:-" + elementText);
        assert elementText.contains(formattedCurrentDate) : "The element does not contain the current date.";
    }

    private void verifyDataForFilterOption() {
        try {
            WebElement thumbnailElement = wait.until(ExpectedConditions.visibilityOf(imagesThumbnail));

            if (thumbnailElement.isDisplayed()) {
                Assert.assertTrue(firstThumbnailName.isDisplayed());
            } else {
                Assert.assertTrue(!noImgInDeployment.isEmpty());
            }
        } catch (TimeoutException e) {
            Assert.fail("Timed out waiting for thumbnails to appear");
        }
    }

    public void verifyDataForDifferentFilterDropdowns(String page) throws InterruptedException {
        webDriverHelper.waitUntilVisible(defaultFilterSelected, 30, 1);
        filterDropdownBtn.click();
        webDriverHelper.waitUntilVisible(filterOptions.get(0), 30, 1);

        if (filterOptions.size() > 1) {
            for (WebElement filterOption : filterOptions) {
                filterOption.click();
                verifyDataForFilterOption();
                filterDropdownBtn.click();
            }
        } else if (filterOptions.size() == 1) {
            filterOptions.get(0).click();
            try {
                WebElement thumbnailElement = wait.until(ExpectedConditions.visibilityOf(imagesThumbnail));
                if (thumbnailElement.isDisplayed()) {
                    Assert.assertTrue(firstThumbnailName.isDisplayed());
                } else {
                    Assert.assertFalse(noImgInDeployment.isEmpty());
                }
            } catch (TimeoutException e) {
                Assert.fail("Timed out waiting for thumbnails to appear");
            }
            filterDropdownBtn.click();
        } else {
            Assert.fail("No filter options found");
        }
    }

    public void verifyDataForDifferentDeploymentLists(String page) throws InterruptedException {
        webDriverHelper.waitUntilVisible(deploymentDropdownBtn, 30, 1);
        deploymentDropdownBtn.click();
        webDriverHelper.waitUntilVisible(deploymentDropdownOptions.get(1), 30, 1);
        if (deploymentDropdownOptions.size() > 1) {
            Assert.assertTrue(deploymentSection.getText().contains((Constants.deploymentName)));
            int i = 0;
            while (i < deploymentDropdownOptions.size()) {
                Thread.sleep(1000);
                deploymentDropdownOptions.get(i).click();
                try {
                    boolean isThumbnailDisplayed = false;

                    try {
                        WebElement thumbnailElement = wait.until(ExpectedConditions.visibilityOf(imagesThumbnail));
                        isThumbnailDisplayed = true;
                        Assert.assertTrue(firstThumbnailName.isDisplayed());
                    } catch (TimeoutException e) {
                        // Thumbnail is not displayed
                    }

                    if (!isThumbnailDisplayed) {
                        Assert.assertTrue(noImgInDeployment.size() > 0);
                        Assert.assertTrue(selectBtnNoImage.isEmpty());
                    }
                } catch (TimeoutException e) {
                    Assert.fail("Timed out waiting for thumbnails or no image elements to appear");
                }
                deploymentDropdownBtn.click();
                i++;
            }
        } else {
            Assert.assertTrue(allDeploymentOption.getText().isEmpty());
        }
    }

    public void verifyMultipleImageDownload(String page) throws InterruptedException {
        try {
            navigatingToAllImagesPage(page);
            int i = 0;
            int maxAttempts = 3;

            while (i < downloadIcon.size() && i < 10) { // Added condition to check i < 10
                int currentAttempt = 1;

                while (currentAttempt <= maxAttempts) {
                    try {
                        Thread.sleep(1000);
                        downloadIcon.get(i).click();
                        Assert.assertTrue(downloadSuccessToast.isDisplayed());
                        break; // Break out of the retry loop if assertion succeeds
                    } catch (StaleElementReferenceException e) {
                        System.out.println("Stale Exception");
                    } catch (AssertionError e) {
                        if (currentAttempt == maxAttempts) {
                            throw e; // Throw the exception if it's the last attempt
                        }
                        // Sleep for a short duration before retrying
                        Thread.sleep(1000);
                        currentAttempt++;
                    }
                }

                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void navigatingToAllImagesPage(String page) throws InterruptedException, IOException {
        try {
            verifyDefaultFilterSelected(page);
            filterDropdownBtn.click();
            Thread.sleep(1000);
            webDriverHelper.waitUntilVisible(filterOptions.get(1), 30, 1);
            filterOptions.get(1).click();
            webDriverHelper.waitUntilVisible(twentiethThumbnail, 30, 1);
        } catch (Exception e) {
            System.out.println("Exception e");
        }
    }

    public void navigatingToLast30daysPage(String page) throws InterruptedException, IOException {
        try {
            verifyDefaultFilterSelected(page);
            filterDropdownBtn.click();
            Thread.sleep(1000);
            webDriverHelper.waitUntilVisible(filterOptions.get(0), 30, 1);
            filterOptions.get(0).click();
            webDriverHelper.waitUntilVisible(firstThumbnailName, 30, 1);
        } catch (Exception e) {
            System.out.println("Exception e");
        }
    }

    public void verifyImageDownloadInLast30DaysView(String page) throws InterruptedException {
        try {
            navigatingToLast30daysPage(page);
            firstDownloadIcon.click();
            webDriverHelper.waitUntilVisible(downloadSuccessToast, 30, 1);
            Assert.assertTrue(downloadSuccessToast.isDisplayed());
            System.out.println("downloadSuccessToast:-" + downloadSuccessToast.getText());
            Assert.assertTrue(downloadSuccessToast.getText().trim().contains(Constants.downloadSuccessMsg));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (StaleElementReferenceException e) {
            {
                System.out.println("Stale Exception");
            }
        }
    }

    public void verifyImageDownloadInLast10DaysView(String page) throws InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(firstImageThumbnail, 30, 1);
            Thread.sleep(2000);
            webDriverHelper.waitUntilVisible(firstDownloadIcon, 30, 1);
            firstDownloadIcon.click();
            webDriverHelper.waitUntilVisible(downloadSuccessToast, 30, 1);
            Assert.assertTrue(downloadSuccessToast.isDisplayed());
            Assert.assertTrue(downloadSuccessToast.getText().contains(Constants.downloadSuccessMsg));
        } catch (StaleElementReferenceException e) {
            {
                System.out.println("Stale Exception");
            }
        }
    }

    public void verifyImageDownloadInArchivedView(String page) throws InterruptedException {
        try {
            navigatingToArchivedPage(page);
            webDriverHelper.waitUntilVisible(firstDownloadIcon, 30, 1);
            firstDownloadIcon.click();
            webDriverHelper.waitUntilVisible(downloadSuccessToast, 30, 1);
            Assert.assertTrue(downloadSuccessToast.getText().contains(Constants.downloadSuccessMsg));
        } catch (StaleElementReferenceException e) {
            {
                System.out.println("Stale Exception");
            }
        }
    }

    public void verifyImageScrollingTillEnd(String page) throws InterruptedException, IOException {
        navigatingToAllImagesPage(page);
        imageScrolling(page);
    }

    public void verifyNavigationToSpecificSite(String page) throws InterruptedException, IOException {
        webDriverHelper.waitUntilVisible(searchPage.dashboardMenu_Search, 30, 1);
        try {
            searchPage.dashboardMenu_Search.click();
            webDriverHelper.waitUntilVisible(searchPage.searchBar, 30, 1);
            searchPage.searchBar.click();
            searchPage.searchBar.sendKeys(Constants.visionSiteName);
            Thread.sleep(2000);
            searchPage.searchBar.sendKeys(Keys.ENTER);
            webDriverHelper.waitUntilVisible(searchPage.siteResult_siteCard, 30, 1);
            searchPage.siteResult_siteCard.click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(searchPage.searchBar));
            searchPage.searchBar.click();
        }
    }

    public void verifyCancelArchiveInGalleryView(String role) throws InterruptedException {
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            navigatingToGalleryView(role);
            String actualName = galleryViewHeader.getText();
            galleryViewArchiveBtn.click();
            webDriverHelper.waitUntilVisible(popupModal, 30, 1);
            popupCancelBtn.click();
            String expectedName = galleryViewHeader.getText();
            Assert.assertEquals(expectedName, actualName);
            galleryViewCrossBtn.click();
        } else {
            Assert.assertEquals(galleryViewArchiveBtnList.size(), 0, "Select button field is not there on vision page");
        }

    }

    public void verifyArchiveDownloadBtnInGalleryView(String role) throws InterruptedException {
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            try {
                navigatingToGalleryView(role);
                Assert.assertTrue(galleryViewArchiveBtn.isDisplayed());
                Assert.assertTrue(galleryViewDownloadBtn.isDisplayed());
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale Exception");
            }
            galleryViewCrossBtn.click();
        } else {
            Assert.assertEquals(galleryViewArchiveBtnList.size(), 0, "Gallery View Archive button field is not there on vision page");
        }

    }

    public void verifyClickOnCancelInThumbnailImgArchive(String role) throws InterruptedException {
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            webDriverHelper.waitUntilVisible(selectBtn, 30, 1);
            selectingSingleImage(role);
            archiveImg(role);
            Assert.assertEquals(popupModal.getText(), (Constants.archivePopupContents));
            Assert.assertTrue(popupModal.getText().contains(Constants.archivePopupSingleImgContent));
            popupCancelBtn.click();
            Assert.assertTrue(selectedImage.isDisplayed());
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifyCancellingSelectedThumbnail(String role) throws InterruptedException {
        verifyClickOnCancelInThumbnailImgArchive(role);
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            selectBtnCancel.click();
            webDriverHelper.waitUntilVisible(selectBtn, 30, 1);
            Assert.assertTrue(selectBtn.isDisplayed());
            Assert.assertTrue(selectedImageView.isEmpty());
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifyThumbnailDownloadIcon(String page) throws InterruptedException {
        verifyDefaultFilterSelected(page);
        int downloadIconCount = downloadIcon.size();
        int thumbnailCount = imgList.size();
        Assert.assertEquals(thumbnailCount, downloadIconCount);
    }

    public void selectingMultipleImages(String role) throws InterruptedException {
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            selectBtn.click();
            webDriverHelper.waitUntilVisible(selectBtnCancel, 30, 1);
            webDriverHelper.waitUntilVisible(thumbnailRadioBtn.get(0), 30, 1);
            for (WebElement imgThumbnailList : imgThumbnailLists) {
                WebElement radioBtn = null;
                try {
                    radioBtn = imgThumbnailList;
//                        Thread.sleep(1000);
                    Thread.sleep(200);
                    wait.until(ExpectedConditions.elementToBeClickable(radioBtn));
                    radioBtn.click();

                    if (!errorToastMaxSelect.isEmpty()) {
                        break;
                    }
//                        Thread.sleep(1000);
                    Thread.sleep(200);
                } catch (StaleElementReferenceException e) {
                    radioBtn.click();
                    System.out.println("Stale element exception on clicking radio button");
                }
            }
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifyingArchiveBtnColor(String role) throws InterruptedException {
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            String colour = archiveRestoreBtn.getCssValue("color");
            Assert.assertTrue(colour.contains(Constants.restoreButtonColor));
        } else {
            Assert.assertEquals(archiveRestoreBtnList.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifyingArchiveBtnColorInPopUp(String role) throws InterruptedException {
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            String colour = archiveIconInPopup.getCssValue("color");
            Assert.assertTrue(colour.contains(Constants.restoreButtonColor));
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifyAllImgArchived(String role) throws InterruptedException {
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            webDriverHelper.waitUntilVisible(selectBtn, 30, 1);
            Thread.sleep(2000);
            selectingMultipleImages(role);
            archiveImg(role);
            popupConfirmBtn.click();
            webDriverHelper.waitUntilVisible(archiveToastMsg, 30, 1);
            Assert.assertTrue(archiveToastMsg.getText().contains(Constants.toastMsg));
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifyCancellingMultipleSelectedImage(String role) throws InterruptedException {
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            webDriverHelper.waitUntilVisible(selectBtn, 30, 1);
            selectingMultipleImages(role);
            archiveImg(role);
            popupCancelBtn.click();
            webDriverHelper.waitUntilVisible(selectBtnCancel, 30, 1);
            selectBtnCancel.click();
            webDriverHelper.waitUntilVisible(selectBtn, 30, 1);
            Assert.assertTrue(selectBtn.isDisplayed());
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifyHistoricalDeployments(String page) throws InterruptedException {
        verifyDeploymentOptions(page);
        if (historicalDeployments.size() > 0) {
            String colour = historicalDeployments.get(0).getCssValue("color");
            Assert.assertTrue(colour.contains(Constants.historicalLocationColor));
        } else {
            System.out.println("No Historical Deployment in deployment list");
        }
        deploymentDropdownBtn.click();
    }

    public void verifyDeploymentDropdownOptions(String page) throws InterruptedException {
        verifyDeploymentOptions(page);
        deploymentDropdownBtn.click();
    }

    public void verifyDeploymentOptions(String page) throws InterruptedException {
        webDriverHelper.waitUntilVisible(deploymentDropdownBtn, 30, 1);
        deploymentDropdownBtn.click();
        webDriverHelper.waitUntilVisible(deploymentDropdownOptions.get(1), 30, 1);
        if (deploymentDropdownOptions.size() > 1) {
            Assert.assertTrue(deploymentSection.getText().contains((Constants.deploymentName)));
        } else {
            Assert.assertTrue(allDeploymentOption.getText().isEmpty());
        }
    }

    public void verifyDefaultDeploymentSelected(String role) throws InterruptedException {
        verifyPageLoadingText(role);
        webDriverHelper.waitUntilVisible(deploymentSection, 30, 1);
        String name = deploymentSection.getText();
        Assert.assertTrue(name.contains(Constants.deploymentName));
    }

    public void verifyVisionNotEnabledScenario(String page) throws InterruptedException {
        webDriverHelper.waitUntilVisible(deploymentDropdownBtn, 30, 1);
        if (visionNotEnabledView.size() > 0) {
            Assert.assertTrue(noImageAvailableMsg.isDisplayed());
        } else {
            System.out.println("Vision is enabled");
        }
    }

    public void verifyFilterOptions(String page) throws InterruptedException {
        verifyDefaultFilterSelected(page);
        filterOptions(page);
        filterDropdownBtn.click();
    }

    public void verifyDefaultFilterSelected(String role) throws InterruptedException {
        verifyPageLoadingText(role);
        webDriverHelper.waitUntilVisible(defaultFilterSelected, 30, 1);
        String filter = defaultFilterSelected.getText();
        Assert.assertTrue(filter.contains(Constants.filterText));
    }

    public void navigatingToGalleryView(String page) throws InterruptedException {
        try {
            verifyDefaultFilterSelected(page);
            verifyVisionNotEnabledScenario(page);
            webDriverHelper.waitUntilVisible(firstThumbnailName, 30, 1);
            Thread.sleep(1000);
            firstThumbnail.click();
            webDriverHelper.waitUntilVisible(galleryViewHeader, 30, 1);
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Exception");
        }
    }

    public void verifyGalleryViewArchive(String role) throws InterruptedException {
        navigatingToGalleryView(role);
        String firstName = galleryViewHeader.getText();
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            verifyingArchiveBtnColorInPopUp(role);
            galleryViewArchiveBtn.click();
            webDriverHelper.waitUntilVisible(popupModal, 30, 1);
            popupConfirmBtn.click();
            webDriverHelper.waitUntilVisible(archiveToastMsg, 30, 1);
            Assert.assertTrue(archiveToastMsg.getText().contains(Constants.galleryViewArchiveToastMsg));
            Thread.sleep(5000);
            String nextName = galleryViewHeader.getText();
            Assert.assertNotEquals(firstName, nextName, "C66203 :The first name should not be equal to the next name");
            galleryViewCrossBtn.click();
        } else {
            Assert.assertEquals(galleryViewArchiveBtnList.size(), 0, "Archive button field is there on vision page");
        }

    }

    public void verifyBackwardScrollingInGalleryView(String role) throws InterruptedException {
        try {
            navigatingToGalleryView(role);
            Thread.sleep(1000);
            if (galleryViewThumbnails.size() > 0) {
                String firstName = galleryViewHeader.getText();
                galleryViewRightArrow.click();
                Thread.sleep(1000);
                galleryViewBackArrow.click();
                Thread.sleep(1000);
                String nextName = galleryViewHeader.getText();
                Assert.assertEquals(firstName, nextName);
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Exception");
        }
        galleryViewCrossBtn.click();
    }

    public void verifyScrollingTillLastImgInGalleryView(String page) throws InterruptedException {
        try {
            navigatingToGalleryView(page);
            int i = 0;
//            while (i < galleryViewThumbnails.size()) {
            while (i < 10) {
                Thread.sleep(1000);
                galleryViewRightArrow.click();
                i++;
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Exception");
        }
    }

    public void navigatingToArchivedPage(String page) throws InterruptedException {
        webDriverHelper.waitUntilVisible(defaultFilterSelected, 30, 1);
        filterOptions(page);
        filterOptions.get(0).click();
        webDriverHelper.waitUntilVisible(archivedFilter, 30, 1);
        Assert.assertTrue(defaultFilterSelected.getText().contains(archivedFilter.getText()));
        webDriverHelper.waitUntilVisible(firstThumbnailName, 30, 1);
    }

    public void verifyAnImgRestored(String role) throws InterruptedException {
        navigatingToArchivedPage(role);
        selectingSingleImage(role);
        verifyingArchiveBtnColor(role);
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            archiveRestoreBtn.click();
            webDriverHelper.waitUntilVisible(popupModal, 30, 1);
            Assert.assertTrue(popupModal.getText().contains(Constants.restorePopupContent));
            popupConfirmBtn.click();
            webDriverHelper.waitUntilVisible(restoreToastMsg, 30, 1);
            Assert.assertTrue(restoreToastMsg.getText().contains(Constants.restoreToastMsg));
        } else {
            Assert.assertEquals(archiveRestoreBtnList.size(), 0, "Restore button field is not there on vision page");
        }
    }

    public void verifyCancellingAnImgRestore(String role) throws InterruptedException {
        navigatingToArchivedPage(role);
        selectingSingleImage(role);
        verifyingArchiveBtnColor(role);
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            archiveRestoreBtn.click();
            webDriverHelper.waitUntilVisible(popupModal, 30, 1);
            Assert.assertTrue(popupModal.getText().contains(Constants.restorePopupContent));
            popupCancelBtn.click();
            Assert.assertTrue(selectBtnCancel.isDisplayed());
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifyImageRestoreFromGalleryView(String role) throws InterruptedException {
        navigatingToArchivedPage(role);
        firstThumbnail.click();
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            webDriverHelper.waitUntilVisible(galleryViewRestoreBtn, 30, 1);
            String firstName = galleryViewHeader.getText();
            galleryViewRestoreBtn.click();
            webDriverHelper.waitUntilVisible(popupModal, 30, 1);
            Assert.assertTrue(popupModal.getText().contains(Constants.restorePopupContent));
            popupConfirmBtn.click();
            webDriverHelper.waitUntilVisible(galleryViewRestoreToastMsg, 30, 1);
            Assert.assertTrue(galleryViewRestoreToastMsg.getText().contains(Constants.galleryViewRestoreToastMsg));
            Thread.sleep(5000);
            String nextName = galleryViewHeader.getText();
            Assert.assertNotEquals(firstName, nextName, "C66219 : The first name should not be equal to the next name");
        } else {
            Assert.assertEquals(galleryViewRestoreBtnList.size(), 0, "Restore button field is there on vision page");
        }
    }


    public void selectingSingleImage(String role) throws InterruptedException {
        Thread.sleep(1000);
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            selectBtn.click();
            webDriverHelper.waitUntilVisible(selectBtnCancel, 30, 1);
            Assert.assertTrue(archiveRestoreBtnVisibility.isEmpty());
            firstThumbnail.click();
            webDriverHelper.waitUntilVisible(archiveRestoreBtn, 30, 1);
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifyAllImgRestored(String role) throws InterruptedException {
        navigatingToArchivedPage(role);
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            selectingMultipleImages(role);
            verifyingArchiveBtnColor(role);
            archiveRestoreBtn.click();
            webDriverHelper.waitUntilVisible(popupModal, 30, 1);
            Assert.assertTrue(popupModal.getText().contains(Constants.restorePopupContent));
            popupConfirmBtn.click();
            webDriverHelper.waitUntilVisible(restoreToastMsg, 30, 1);
            Assert.assertTrue(restoreToastMsg.getText().contains(Constants.restoreToastMsg));
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void verifySingleImgArchive(String role) throws InterruptedException {
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            webDriverHelper.waitUntilVisible(selectBtn, 30, 1);
            selectingSingleImage(role);
            archiveImg(role);
            Assert.assertEquals(popupModal.getText(), (Constants.archivePopupContents));
            verifyingArchiveBtnColorInPopUp(role);
            Assert.assertTrue(popupModal.getText().contains(Constants.archivePopupSingleImgContent));
            popupConfirmBtn.click();
            webDriverHelper.waitUntilVisible(archiveToastMsg, 30, 1);
            Assert.assertTrue(archiveToastMsg.getText().contains(Constants.toastMsg));
            webDriverHelper.waitUntilVisible(archiveToastMsg, 30, 1);
            Assert.assertTrue(archiveToastMsg.getText().contains(Constants.toastMsg));
            Assert.assertTrue(pageLoading.isDisplayed());
            webDriverHelper.waitUntilVisible(firstThumbnailName, 30, 1);
            Assert.assertTrue(selectBtn.isDisplayed());
        } else {
            Assert.assertEquals(selectBtnForReaders.size(), 0, "Select button field is not there on vision page");
        }
    }

    public void navigatingToVisionTab(String role) throws InterruptedException, IOException {
        verifyNavigationToSpecificSite(role);
        webDriverHelper.waitUntilVisible(tabList, 30, 1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("location.reload()");
        webDriverHelper.waitUntilVisible(tabList, 30, 1);
        String list = tabList.getText();
        Assert.assertTrue(list.contains(Constants.visionTab));
//            StringHelper.devToolCapture(role);
        visionTab.click();
//            start = System.currentTimeMillis();
    }

//        public void verifyVisionPageResponseTime(String role) throws IOException, InterruptedException {
////            StringHelper.devToolCapture(role);
//            start = System.currentTimeMillis();
//            webDriverHelper.waitUntilVisible(deploymentSection, 30, 1);
//            if (imgList.size() <= 0) {
//                Assert.assertTrue(noImgInDeploymentModal.isDisplayed());
//            }
//            loadInSeconds = stringHelper.stopTime(start, driver);
//            ExcelReader.setValueForColumn("Vision", loadInSeconds, role);
//            // HTML report generator
//            HTMLReport.addPageName("Vision");
////        HTMLReport.generateReport("Vision", loadInSeconds, role);
//            HTMLReport.writeReportToFile();
////        stringHelper.benchmarkComparison(loadInSeconds);
//        }

    public void verifyPageLoadingText(String role) throws InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(pageLoading, 90, 2);
            Assert.assertTrue(pageLoading.getText().contains(Constants.loadingText));
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Exception");
        }
    }

    public void archiveImg(String role) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        if (!(role.equals("orgReader") || role.equals("sysReader"))) {
            webDriverHelper.waitUntilVisible(archiveRestoreBtn, 30, 1);
            verifyingArchiveBtnColor(role);
            archiveRestoreBtn.click();
            webDriverHelper.waitUntilVisible(popupModal, 30, 1);
            Assert.assertTrue(archiveIconInPopup.isDisplayed());
        } else {
            softAssert.assertTrue(selectBtnForReaders.size() == 0, "Select button field is not there on vision page");
        }
    }

    public void filterOptions(String page) throws InterruptedException {
        filterDropdownBtn.click();
//        webDriverHelper.waitUntilVisible(filterOptions.get(1), 30, 1);
        webDriverHelper.waitUntilVisible(filterOptions.get(0), 30, 1);
        for (WebElement filterOption : filterOptions) {
            Assert.assertTrue((Constants.filterOptionsList).contains(filterOption.getText()));
        }
        Thread.sleep(1000);
    }

    public void downloadImageInGalleryView(String page) throws InterruptedException {
        webDriverHelper.waitUntilVisible(defaultFilterSelected, 30, 1);
        filterDropdownBtn.click();
        webDriverHelper.waitUntilVisible(filterOptions.get(0), 30, 1);
        if (filterOptions.size() > 1) {
            int i = 0;
            while (i < filterOptions.size()) {
                Thread.sleep(1000);
                filterOptions.get(i).click();
                try {
                    WebElement thumbnailElement = wait.until(ExpectedConditions.visibilityOf(imagesThumbnail));
                    if (thumbnailElement.isDisplayed()) {
                        Assert.assertTrue(firstThumbnailName.isDisplayed());
                        firstThumbnail.click();
                        webDriverHelper.waitUntilVisible(galleryViewDownloadBtn, 30, 1);
                        galleryViewDownloadBtn.click();
                        webDriverHelper.waitUntilVisible(downloadSuccessToast, 30, 1);
                        System.out.println("downloadSuccessToast.getText():-" + downloadSuccessToast.getText());
                        Assert.assertTrue(downloadSuccessToast.getText().contains(Constants.downloadSuccessMsg));
                        wait.until(ExpectedConditions.invisibilityOf(downloadSuccessToast));
                        Thread.sleep(1000);
                        galleryViewCrossBtn.click();
                    } else {
                        Assert.assertTrue(noImgInDeployment.size() > 0);
                    }
                } catch (TimeoutException e) {
                    Assert.fail("Timed out waiting for thumbnails to appear");
                }
                filterDropdownBtn.click();
                Thread.sleep(1000);
                i++;
            }
        } else {
            Assert.assertTrue(allDeploymentOption.getText().isEmpty());
        }
    }

    //    public void imageScrolling(String page) throws InterruptedException, IOException {
//        WebElement scrollContainer = driver.findElement(By.xpath("//div[@class='ScrollStyle']" ));
//        List<WebElement> thumbnailImages = scrollContainer.findElements(By.xpath("//div[@class='site-detail']//a" ));
//        int initialCount = thumbnailImages.size();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        while (true) {
//            js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight);", scrollContainer);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            thumbnailImages = scrollContainer.findElements(By.xpath("//div[@class='site-detail']//a" ));
//            if (thumbnailImages.size() > initialCount) {
//                initialCount = thumbnailImages.size();
//            } else {
//                break;
//            }
//        }
//    }
    public void imageScrolling(String page) throws InterruptedException, IOException {
        WebElement scrollContainer = driver.findElement(By.xpath("//div[@class='ScrollStyle']"));
        List<WebElement> thumbnailImages = scrollContainer.findElements(By.xpath("//div[@class='site-detail']//a"));
        int initialCount = thumbnailImages.size();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return arguments[0].scrollHeight;", scrollContainer);
        while (true) {
            js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight);", scrollContainer);
            Thread.sleep(2000);
            long newHeight = (long) js.executeScript("return arguments[0].scrollHeight;", scrollContainer);
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
            thumbnailImages = scrollContainer.findElements(By.xpath("//div[@class='site-detail']//a"));
            if (thumbnailImages.size() > initialCount) {
                initialCount = thumbnailImages.size();
            }
        }
    }
}
