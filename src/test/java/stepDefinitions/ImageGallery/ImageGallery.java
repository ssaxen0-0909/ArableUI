package stepDefinitions.ImageGallery;

import TestRail.APIException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.imgGallery;
import static support.World.map;

public class ImageGallery {

    @When("navigate to site details page and click on Vision tab")
    public void navigateToPage(String page) throws IOException, InterruptedException, APIException {
        map.navigateToPage(page);
    }

    @Then("navigate to {string} tab")
    public void navigateToTab(String page) throws InterruptedException, IOException {
        imgGallery.navigatingToVisionTab(page);
    }

    @Then("click on thumbnail and verify scrolling to the last image in gallery view for {string} user.")
    public void clickOnThumbnailAndVerifyScrollingToTheLastImageInGalleryViewForUser(String page) throws InterruptedException {
        imgGallery.verifyScrollingTillLastImgInGalleryView(page);
    }

    @Then("verify default filter selected for {string} user.")
    public void verifyDefaultFilterSelectedForUser(String page) throws InterruptedException {
        imgGallery.verifyDefaultFilterSelected(page);
    }

    @Then("verify filter options in filter dropdown for {string} user.")
    public void verifyFilterOptionsInFilterDropdownForUser(String page) throws InterruptedException {
        imgGallery.verifyFilterOptions(page);
    }

    @And("verify page loading text for {string} user.")
    public void verifyPageLoadingTextForUser(String page) throws InterruptedException {
        imgGallery.verifyPageLoadingText(page);
    }

    @Then("verify default deployment selected in dropdown for {string} user.")
    public void verifyDefaultDeploymentSelectedInDropdownForUser(String page) throws InterruptedException {
        imgGallery.verifyDeploymentDropdownOptions(page);
    }

    @Then("verify historical deployments if present,are shown in dropdown for {string} user.")
    public void verifyHistoricalDeploymentsIfPresentAreShownInDropdownForUser(String page) throws InterruptedException {
        imgGallery.verifyHistoricalDeployments(page);
    }

    @Then("verify archiving of single image for {string} user.")
    public void verifyArchivingOfSingleImageForUser(String page) throws InterruptedException {
        imgGallery.verifySingleImgArchive(page);
    }

    @Then("verify archiving all Images for {string} user.")
    public void verifyArchivingAllImagesForUser(String page) throws InterruptedException {
        imgGallery.verifyAllImgArchived(page);
    }

    @Then("verify restoring all Images from Archived page for {string} user.")
    public void verifyRestoringAllImagesFromArchivedPageForUser(String page) throws InterruptedException {
        imgGallery.verifyAllImgRestored(page);
    }

    @Then("verify download icon displaying below thumbnails for {string} user.")
    public void verifyDownloadIconDisplayingBelowThumbnailsForUser(String page) throws InterruptedException {
        imgGallery.verifyThumbnailDownloadIcon(page);
    }

    @Then("verify restoring a single image from Archived page for {string} user.")
    public void verifyRestoringASingleImageFromArchivedPageForUser(String page) throws InterruptedException {
        imgGallery.verifyAnImgRestored(page);
    }

    @Then("verify backward scrolling in gallery view for {string} user.")
    public void verifyBackwardScrollingInGalleryViewForUser(String page) throws InterruptedException {
        imgGallery.verifyBackwardScrollingInGalleryView(page);
    }

    @Then("verify archiving single image in gallery view for {string} user.")
    public void verifyArchivingSingleImageInGalleryViewForUser(String page) throws InterruptedException {
        imgGallery.verifyGalleryViewArchive(page);
    }

    @Then("verify cancelling the archiving of single image in thumbnail view for {string} user.")
    public void verifyCancellingTheArchivingOfSingleImageInThumbnailViewForUser(String page) throws InterruptedException {
        imgGallery.verifyClickOnCancelInThumbnailImgArchive(page);
    }

    @Then("verify archive and download icon in gallery view for {string} user.")
    public void verifyArchiveAndDownloadIconInGalleryViewForUser(String page) throws InterruptedException {
        imgGallery.verifyArchiveDownloadBtnInGalleryView(page);
    }

    @Then("verify clicking on cancel button in gallery view for {string} user.")
    public void verifyClickingOnCancelButtonInGalleryViewForUser(String page) throws InterruptedException {
        imgGallery.verifyCancelArchiveInGalleryView(page);
    }

    @And("verify if navigation is happening to Vision tab for all {string} user")
    public void verifyIfNavigationIsHappeningToVisionTabForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.navigatingToVisionTab(page);
    }

    @And("verify scrolling of images in Vision tab for all {string} user")
    public void verifyScrollingOfImagesInVisionTabForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyImageScrollingTillEnd(page);
    }

    @And("verify download of multiple images in Vision tab for all {string} user")
    public void verifyDownloadOfMultipleImagesInVisionTabForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyMultipleImageDownload(page);
    }

    @And("verify data for deployment lists in Vision tab for all {string} user")
    public void verifyDataForDeploymentListsInVisionTabForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyDataForDifferentDeploymentLists(page);
    }

    @And("verify data for different filter dropdown in Vision tab for all {string} user")
    public void verifyDataForDifferentFilterDropdownInVisionTabForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyDataForDifferentFilterDropdowns(page);
    }

    @And("verify cancelling single selected image in Vision tab for all {string} user")
    public void verifyCancellingSingleSelectedImageInVisionTabForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyCancellingSelectedThumbnail(page);
    }

    @And("verify name format for a image in Vision tab for all {string} user")
    public void verifyNameFormatForAImageInVisionTabForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyImageNameFormat(page);
    }

    @And("verify latest image positioning in Vision tab for all {string} user")
    public void verifyLatestImagePositioningInVisionTabForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyLatestImagePosition(page);
    }

    @And("verify scrolling in gallery view using keyboard keys for all {string} user")
    public void verifyScrollingInGalleryViewUsingKeyboardKeysForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyScrollingInGalleryViewViaKeyboard(page);
    }

    @And("verify image restoring from gallery view for all {string} user")
    public void verifyImageRestoringFromGalleryViewForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyImageRestoreFromGalleryView(page);
    }

    @And("verify cancelling an image restore for all {string} user")
    public void verifyCancellingAnImageRestoreForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyCancellingAnImgRestore(page);
    }

    @And("verify cancelling multiple selected images for all {string} user")
    public void verifyCancellingMultipleSelectedImagesForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyCancellingMultipleSelectedImage(page);
    }

    @And("verify image download in Last thirty days view for all {string} user")
    public void verifyImageDownloadInLastThirtyDaysViewForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyImageDownloadInLast30DaysView(page);
    }

    @And("verify image download in Last ten days view for all {string} user")
    public void verifyImageDownloadInLastTenDaysViewForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyImageDownloadInLast10DaysView(page);
    }

    @And("verify image download in Archived view for all {string} user")
    public void verifyImageDownloadInArchivedViewForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.verifyImageDownloadInArchivedView(page);
    }

    @And("verify download of image in gallery view of Vision tab for all {string} user")
    public void verifyDownloadOfImageInGalleryViewOfVisionTabForAllUser(String page) throws InterruptedException, IOException {
        imgGallery.downloadImageInGalleryView(page);
    }
}
