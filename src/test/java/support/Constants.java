package support;


import org.openqa.selenium.WebDriver;

public class Constants {
    public final static String warningMsg = "This site will NOT be assigned to any team. If you wish to assign it to a specific team please go to the Teams Page first and use the Edit Teams to add the device to the team.";
    public final static String clearBoundaryBtnText = "Clear Boundary";
    public final static String errorText = "Error Saving";
    public final static String languagePt = "Português";
    public final static String languageSp = "Español";
    public final static String languageEng = "English";
    public final static String languageTranslatedText = "Idioma";
    public final static String LanguageTranslatedTextSP = "Guardado con éxito";

    public final static String firstNameErrorMessage = "Invalid first name.";

    public final static String lastNameErrorMessage = "Invalid last name.";

    public final static String firstNameText = "@#$%";

    public final static String lastNameText = "78945";

    public final static String phoneBoxText = "7856";

    public final static int siteCardCount = 9;

    /* Seasons Page Constants */
    public final static String copySeasonText = "Copy Season to New Site(s)";
    public final static String summaryTitleMsg = "Created seasons";
    public final static String deleteSeasonSuccessMsg = "Growing season successfully deleted";
    public final static String emptyGrowthStageMsg = "There are no growth stages that you can access on this season.";
    public final static String gddValue1 = "100";
    public final static String gddValue2 = "200";
    public final static String growthStage1 = "Stage 1";
    public final static String growthStage2 = "Stage Edited";
    public final static String growthStagesUpdatedSuccessMsg = "Growing Season succesfully updated";
    public final static String copySeasonTitle = "Copy Season to New Site(s)";
    public final static String copySeasonTitleDesc = "Please select a site, or sites, to assign them a crop type and varietal.";

    public final static String unassignedSitesSuccess = "Site have been asigned";
    public final static String unassignedSitesModalTitle = "Unassigned Sites";
    public final static String unassignedSitesModalSubTitle = "The followings sites have not been assigned to any teams";
    public final static String assignedTeamModalHeader = "Assigned Teams";
    public final static String assignedTeamModalSubHeader = "Teams in the Organization that has at least one Site associated to it.";
    public final static String unassignedTeamModalHeader = "Unassigned Teams";
    public final static String unassignedTeamModalSubHeader = "Teams that has no Site associated to it.";
    public final static String assignedMemberModalHeader = "Assigned Members";
    public final static String assignedMemberModalSubHeader = "The following are Members in the Organization that has at least one Team associated to it.";
    public final static String unassignedMemberModalHeader = "Unassigned Members";
    public final static String unassignedMemberModalSubHeader = "The following are Members with no teams associated.";
    public final static String unassignedMemberNoDataModalDesc = "The count of Members that has no Team associated to it.";
    public final static String assignedSitesModalHeader = "Assigned Sites";
    public final static String assignedSitesModalDesc = "The count of Sites in the Organization that has at least one Team associated to it.";
    public final static String ModalDescNoData = "There are no information to show";
    public final static String teamsColumnModalDesc = "A Team label groups a set of users with a set of devices for the purpose of managing the fleet efficiently. Only the Org Admins and the Members of the team has permission to see the devices and its deployments.";
    public final static String firstColumnName = "Team Name";
    public final static String secondColumnName = "Members";
    public final static String thirdColumnName = "Sites";
    public final static String sitesColumnModalDesc = "A site is a physical area with a shared set of specific characteristics, e.g., crop type, treatment, soil and/or irrigation practices, etc. In practice, a site corresponds to a field or an irrigation block and is created by drawing its boundaries in the Sites module. There may be one or more Arable Mark devices associated with a site. If there are multiple Mark devices assigned to a site, the system will aggregate the measurements to the site level.";
    public final static String membersColumnModalDesc = "The members of a Team can be divided into Team Admins (has permission to invite other users to the Team) and Team Members (can view other members and the devices of the Team). If you don't see your name and email address as part of a Team that you expected to be in, then contact one of the Org Admins that are listed in the top row as they have visibility of all Devices and Teams in your organization and can invite you to the correct Team using the Invite Member button.";
    public final static String createOrgBtn = "Create New Organization";
    public final static String confirmBtnText = "Confirm";
    public final static String assignedDevicesModalHeader = "Assigned Devices";
    public final static String assignedDevicesModalDesc = "To view the devices associated to a specific organization, please select the organization from the “Source” drop-down menu.";
    public final static String assignedDevicesModalSteps = "If you wish to move any devices from one organization to another, please select the devices you wish to move from the source organization, then select an organization from “Destination” the drop-down, and press Return.";
    public final static String assignedDevicesModalOrgSource = "Source";
    public final static String assignedDevicesModalOrgDest = "Destination";
    public final static String assignedDevicesModalActionBtn = "Return";
    public final static String unassignedDevicesModalHeader = "Unassigned Devices";
    public final static String unassignedDevicesModalSteps = "The devices on this list have not yet been assigned to any Organization. To assign them please select the organization you wish to assign a device from the “Destination” drop-down, select the device(s) you wish to assign from the list, and press Assign.";
    public final static String unassignedDevicesModalOrgSource = "Source";
    public final static String unassignedDevicesModalOrgDest = "Destination";
    public final static String unassignedDevicesModalActionBtn = "Assign";
    public final static String distributorFirstColumnHeader = "Organization Name";
    public final static String distributorSecondColumnHeader = "Members";
    public final static String distributorThirdColumnHeader = "Devices";
    public final static String OrgDetailsHeader = "Devices Assigned to this Organization";
    public final static String ciModalHeader = "Chlorophyll Index";
    //    public final static String filterText = "Last 10 days";
    public final static String filterText = "All Images";
    public final static String loadingText = "Loading Gallery";
    //    public final static String filterOptionsList = "Last 30 days\n" + "All Images\n" + "Archived";
    public final static String filterOptionsList = "All Images\n" + "Archived";
    public final static String ciModalText = "Chlorophyll Index\n" +
            "The chlorophyll index (green band formulation) is a proxy for plant" +
            " productivity as well as the chlorophyll and nitrogen content in the plant" +
            " during peak greenness. The Mark's spectrometer detects reflected light in" +
            " the green and near-infrared regions of the spectrum to calculate a" +
            " chlorophyll index. A higher chlorophyll index is indicative of higher" +
            " chlorophyll and nitrogen levels in the canopy and higher productivity in the" +
            " plant.";
    public final static String assignedDevicesModalDescription = "The count of Devices in the Organization that has at least one Team associated to it.";
    public final static String unassignedDevicesModalDescription = "The followings devices have not been assigned to any teams";
    public final static String successToastMsgAfterDeletingInvite = "Invite deleted for";
    public final static String unassignedDevicesSuccess = "Devices has been assigned";
    public final static String shareNoteEmailId = "vishal.gupta@arable.com";
    public final static String shareNoteInvalidEmailId = "xyz@arae.com";
    public final static String shareNoteIncompleteEmailId = "xyz@arae";
    public final static String shareNoteMultipleEmailId = "vishal.gupta@arable.com,automation+orgAdmin@arable.com,automation+member@arable.com";
    public final static String shareNoteModalTitle = "Share Note";
    public final static String shareNoteModalHeader = "Share this note with your team. Email will include all note information.";
    public final static String shareNoteModalBackBtn = "Back";
    public final static String shareNoteSentModalDescription = "An email has been sent to";
    public final static String momentBoxViewBtnText = "View";
    public final static String invalidEmailToastMsgShown = "Error Sharing Moment";
    public final static String momentBoxCurrentDateCreatedText = "View & share details pending next device sync.";
    public final static String recipientEmailErrorMsg = "Enter valid emails.";
    public final static String VIEW_MEASUREMENT_PARAMS = "Weather" +
            "\nTemperature" +
            "\nHumidity" +
            "\nPressure" +
            "\nSolar Radiation" +
            "\nAccumulated Precipitation" +
            "\nPlant" +
            "\nChlorophyll Index" +
            "\nNDVI";
    public final static String DistributorSearchErrorMsg = "Minimum length of search field is 3 characters";
    public final static String infoIconTooltipTextInIrrigationOverview = "Current date's measurements include both observed and forecasted date.";
    public final static String maxAndMinTempInMenuBar = "Max Temp, Min Temp";
    public final static String leafWetnessMeasureInMenuBar = "Leaf Wet";
    public final static String relativeHumidityMeasureInMenuBar = "RH";
    public final static String vaporPressureDeficitMeasureInMenuBar = "VPD";
    public final static String windMeasure = "Wind";
    public final static String errorMsgIfWeSelectMoreSitesOrMeasures = "Selection not allowed";
    public static String deploymentName = "All Deployments";
    public static String visionTab = "Vision";
    public static String visionGalleryViewHeader = "All Deployments";
    public static String visionNoImageMsg = "The selected deployment does not have any images available yet.\n" + "Please check back again later";
    public static String historicalLocationColor = "rgba(111, 111, 111, 1)";
    public static String archivePopupContents = "Archive Image\n" +
            "Are you sure you want to archive the selected image? \n" + "Cancel\n" + "Confirm";
    public static String toastMsg = "Successfully Archived";
    public static String galleryViewArchiveToastMsg = "Successfully Archived";
    public static String archivePopupSingleImgContent = "selected image";
    public static String noImgInDeployment = "The selected deployment does not have any images available yet.\n" +
            "Please check back again later";
    public static String restorePopupContent = "Restore Image";
    public static String restoreToastMsg = "Successfully Restored";
    public static String galleryViewRestoreToastMsg = "Successfully Restored";
    public static String restoreButtonColor = "rgba(0, 0, 0, 1)";
    //    public static String visionSiteName = "Multiple_Mark3_Mark2";
    public static String visionSiteName = "Sentek Site";
    public static String downloadSuccessMsg = "Image downloaded successfully";
    public static String rankNoSites = "This organization has no sites yet.";
    //    Map Page Constants
    public static String soilMoistureUnit = "VWC %";
    //Distributor Search
    public static String invalidText = "abc";
    public static String NoDevicesMsg = "No devices found";
    public static String GlobalTeamName = "AR- Fontezuela";
    public static String newTeamName = "stagTeam";
    public static String sendAgainMessageInPendingInvites = "Invite Sent Again to";
    public static String sendAgainAllMessageInPendingInvites = "All Invites Sent Again Successfully";
    public static String namePostEdit = "stagTeam";
    public static String userRoleM = "Member";
    public static String inviteAnother = "Yes, Invite another member";
    public static String noInvite = "No, I’m done";
    public static String predefinedDate = "All";
    public static String maxTemp = "Maximum Temperature";
    public static String minTemp = "Minimum Temperature";
    public static String firstColumnNameInGraphTable = "Timestamp";
    public static String localDataText = "LOCAL DATA";
    public static String remoteDateText = "REMOTE DATA";
    public static String chloroIndexMeasure = "Chlorophyll Index";
    public static String chloroIndexMeasureInMenuBar = "Chloro Index";
    public static String chloroIndexUnit = "";
    public static String dailyEtcUnit = "in";
    public static String dailyEtcMeasure = "Daily ETc";
    public static String dailyEtcMeasureInMenuBar = "ETc";
    public static String leafWetnessMeasure = "Leaf Wetness";
    public static String leafWetnessUnit = "hours since midnight";
    public static String ndviMeasure = "NDVI";
    public static String ndviUnit = "";
    public static String precipMeasure = "Precipitation";
    public static String precipMeasureInmenuBar = "Precip";
    public static String precipUnit = "in";
    public static String relativeHumidityMeasure = "Relative Humidity";
    public static String relativeHumidityUnit = "%";
    public static String vaporPressureDeficitMeasure = "Vapor Pressure Deficit";
    public static String pressureUnitInTable = "mb";
    public static String windDirection = "Direction";
    public static String selectedBkgColour = "rgba(255, 255, 255, 1)";
    public static String hourlyTimelineBKgColour = "rgba(2, 32, 70, 1)";
    //    public static String soilMoistureSite = "B301028_Mark3_NoArchiveImages";
    public static String siteWithData = "Z_Active + arable_Sensor_Ext";
    public static String siteForMember = "Water Site Automation";
    //    public static String soilMoistureSite = "Sentek Site";
    //    public static String soilMoistureSite = "Water Site Automation";
    public static String soilMoistureSite1 = "Sentek Site";
    public static String soilMoistureMeasure = "Soil Moisture";
    public static String soilMoistureMeasureInMenuBar = "Soil Moist";
    public static String solarRadiationMeasureForHourly = "W/m²";
    public static String solarRadiationMeasure = "MJ/m²";
    public static String soilMoistureMeasureForHourly = "VWC %";
    public static String selectedMeasureBkgColour = "rgba(255, 255, 255, 1)";
    public static String relativeHumidity = "%";
    public static String leafWetness = "hours since midnight";
    public static String siteHeaderSortColor = "rgb(0, 118, 201)";
    public static String redColorInWaterTab = "rgb(251, 73, 23)";
    public static String timeFormatInWaterMultiSite = "\\d{1,3}:\\d{2} hrs";
    public static String greenColorInWaterTab = "rgb(47, 198, 170)";
    public static String yellowColorInWaterTab = "rgb(247, 158, 14)";
    public static String lightGreyColorInWaterTab = "rgb(228, 225, 225)";
    public static String darkGreyColorInWaterTab = "rgb(79, 79, 80)";
    public static String irrigationToReplaceETcForMoreThan8Hours = "> 8 hours";
    public static String irrigationToReplaceETcFor2To8Hours = "2 - 8 hours";
    public static String irrigationToReplaceETcForLessThan2Hours = "< 2 hours";
    public static String heatStressTimeForMoreThan15Hours = "> 15 hours";
    public static String heatStressTimeFor5To15Hours = "5 - 15 hours";
    public static String heatStressTimeForLessThan5Hours = "< 5 hours";
    public static String lastIrrigationRuntimeForMoreThan21Hours = "> 21 hrs";
    public static String lastIrrigationRuntimeFor5To20Hours = "5 - 20 hrs";
    public static String lastIrrigationRuntimeForLessThan4Hours = "< 4 hrs";
    public static String proximityRefillThresholdForMoreThan10Percent = "> 10%";
    public static String proximityRefillThresholdForLessThanAndEqual = "";
    public static String proximityRefillThresholdForLessThan10Percent = "< 10%";
    public static String noSitesMessageInWaterTab = "This page will not render until your team has one or more sites and seasons associated with it. Please deploy your Mark(s) and click here to create a new site and season.";
    public static String msgInChartSessionIfNoData = "There is no data to populate here. Please deploy your Mark(s) and click here to create a new site and season.";
    public static String irrigationReplaceEtcModalTitle = "Irrigation to Replace ETc";
    public static String heatStressModalTitle = "Heat Stress Hours";
    public static String statusBarModalInfoForIrrigationReplace = "Sites that require more than 8 hours of irrigation to replace ETc are colored red. If they require between 2 to 8 hours they will be colored yellow and if they require less than 2 they are colored green. Sites that do not have pressure switches will not be included in the status bar. Manual entered irrigation events will not display here, on the map, or in the benchmark graph.";
    public static String benchmarkGraphModalInfoForIrrigationReplace = "The irrigation hours needed to meet the defined Replacement ETc. The Replacement ET % is set in the Arable Web Water page, Water Balance visual. It will default to 100% if a Growth Stage is defined for the measurement period and otherwise it will be 0%. This value will only populate if a flow rate for a Gems Pressure Switch has been configured for your site.";

    public static String statusBarModalInfoForHeatStress = "Sites that have received over 15 hours of heat stress will be colored red. Sites with between 5 and 15 hours of heat stress will be colored yellow and sites with less than 5 hours will be colored green.";
    public static String benchmarkGraphModalInfoForHeatStress = "The accumulated number of daylight hours during which the air temperature is above the GDD max temperature threshold for the crop at the site for the period selected. If the GDD max temperature threshold is not defined for the crop in the system, then a default of 96°F is used.";
    //    public static String successMsgAfterAddingGrowingSeason = "Growing season successfully saved";
    public static String successMsgAfterAddingGrowingSeason = "Growing Season succesfully updated";
    public static String thresholdProximityUnit = "%";
    public static String teamWithNoSite = "Team With No Sites";
    public static String orgWithNoSite = "arable-deprecated";
    public static String alertsSuccessMsg = "Marked as read";

    public static String lightBlueColorAsHex = "rgb(143, 152, 218)";
    public static String blueColorAsHexInIrrigation = "rgb(0, 118, 201)";
    public static String darkBlueColorAsHex = "rgb(0, 32, 73)";

    public static String redColorAsHex ="#FB4917";
    public static String orangeColorAsHex ="#F79E0E";
    public static String greenColorAsHex ="#2FC6AA";
    public static String blueColorAsHex ="#1773C6";
    public static String lightBlueColor="#8F98DA";
    public static String blueColorAsHexInIrrigationAsHex ="#0076C9";
    public static String darkBlueColor ="#002049";
    public final static String CanopyEvapotranspirationModalText = "Observed Canopy Evapotranspiration \n" +
            " Evapotranspiration is the amount of water a plant loses in a day. It is the combined loss of water from the processes of evaporation (the movement of water from surfaces or water bodies to the atmosphere) and transpiration (the loss of water vapor through the plant’s stomata to the atmosphere).  ETo is the hypothetical value under a grass reference surface.\n" +
            "Crop evapotranspiration, or ETc, is the total evaporation and transpiration estimated for your specific crop. The value is achieved by multiplying the reference ET (ETo) by a crop coefficient (KcNDVI). The KcNDVI is dynamically derived by measuring the NDVI reflectance's (greenness) of the crop growing in your field and captures the crop development throughout the growing season. The resulting ETc value represents the water losses (evaporation and transpiration) specific to your crop system. ] but found [Chlorophyll Index\n" +
            "The chlorophyll index (green band formulation) is a proxy for plant productivity as well as the chlorophyll and nitrogen content in the plant during peak greenness. The Mark's spectrometer detects reflected light in the green and near-infrared regions of the spectrum to calculate a chlorophyll index. A higher chlorophyll index is indicative of higher chlorophyll and nitrogen levels in the canopy and higher productivity in the plant.";



    private final WebDriver driver;

    public Constants(WebDriver driver) {
        this.driver = driver;
    }

}
