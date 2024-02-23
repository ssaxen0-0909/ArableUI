package support;

import TestRail.TestRailManager;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {

    public static MapPage map;
    public static LoginPage loginPage;
    public static SeasonsPage seasonsPage;
    public static WeatherPage weatherPage;
    public static AccountPage accountPage;
    public static Distributor distributorPage;
    public static StringHelper stringHelper;
    public static WebDriverHelper webDriverHelper;
    public static TestRailManager TestrailManager;
    public static SitesApiHelper sitesApiHelper;
    //    public static RestAssuredHelper restAssuredHelper;
    public static String emailId;
    public static String siteID;
    public static String siteName;
    public static String orgName;
    public static String token;
    public static String tAir;
    public static String sun;
    public static String slp;
    public static String rh;
    public static String tempUnit;
    public static String presUnit;
    public static String sizeUnit;
    public static String speedUnit;
    public static String precipitation;
    public static String accountSizeUnit;
    public static String accountTemperatureUnit;
    public static String accountPressureUnit;
    public static String accountVolumeUnit;
    public static String accountSpeedUnit;
    public static DevicesPage devicesPage;
    public static AlertsPage alertsPage;
    public static AlertSettings alertSettings;
    public static Export exportPage;
    public static SearchPage searchPage;
    public static TeamsPage teamsPage;
    public static SitesPage sitesPage;
    public static GraphPage graphPage;
    public static PlantTab plantTab;
    public static WaterTab waterTab;
    public static NotesTab notesTab;
    public static ForgotPassword forgotPassword;
    public static RankPage rankPage;
    public static ImageGallery imgGallery;

    public static performance uiPerformance;

    public static String TestCaseID;

    public static String userId;
    public static String orgId;
    public static String assignedTeamsCounts;
    public static String unassignedTeamsCounts;
    public static String assignedMembersCounts;
    public static String unassignedMembersCounts;
    public static String assignedDevicesCounts;
    public static String unassignedDevicesCounts;
    public static String assignedSitesCounts;
    public static String unassignedSitesCounts;
    public static TeamsApiHelper teamsApiHelper;
    public static NotesAPIHelper notesApiHelper;
    public static RestAssuredHelper restAssuredHelper;
    public static PlantAPIHelper plantApiHelper;
    public static String windColumnTextdata;
    public static String selectedStartDateStrText;
    public static String selectedEndDateStrText;
    public static int localData;
    public static int remoteData;
    public static List<Map.Entry<String, Double>> combinedDoubleListInApi;
    public static List<Map.Entry<String, Integer>> combinedIntegerListInApi;
    public static GraphApiHelper graphApiHelper;
    public static String siteId;
    public static String siteZone;
    public static int sitesSelected;
    public static int columnSize;
    public static String volumeUnit;
    public static String TimelineText;
    public static String endTimeFormatted;
    public static String startTimeFormatted;
    public static List<Map.Entry<String, Integer>> combinedListInApi = new ArrayList<>();
    public static List<Map.Entry<String, Integer>> combinedListInApiHourly = new ArrayList<>();
    public static List<Map.Entry<String, Integer>> combinedListInApiDaily = new ArrayList<>();
    public static List<Map.Entry<String, Double>> combinedListInDoubleApiHourly = new ArrayList<>();
    public static List<Map.Entry<String, Double>> combinedListInUiDouble = new ArrayList<>();
    public static List<String> addedSitesForExportPageVerification = new ArrayList<>();

    public static int pageNoInWaterSite;
    public static MultiSiteApiHelper multiSiteApiHelper;
    public static String pressureUnit;
    public static String alertsLimitPerPage;
    public static String alertPageNo;
    public static int pageNo;
    public static List<String> sitesListInAPI;
    public static Map<String, String[]> siteToValuesMapInApi;
    public static String value;
    public static Map<String, String> addingSiteIdAnLastIrrigationRuntimeValuesForApi = new HashMap<>();
    public static String outputDateString;
    public static WaterMultiSite waterMultiSite;
    public static AlertsApiHelper alertsApiHelper;
    public static MapApiHelper mapApiHelper;
    public static String downloadsDirectoryPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "downloads" + File.separator;
    public static FilesHelper filesHelper;

    final WebDriver driver = new BrowserCreation().getDriver();


    public void driverClass() {
        World.map = new MapPage(driver);
        World.rankPage = new RankPage(driver);
        World.stringHelper = new StringHelper();
        World.loginPage = new LoginPage(driver);
        World.forgotPassword = new ForgotPassword(driver);
        World.seasonsPage = new SeasonsPage(driver);
        World.weatherPage = new WeatherPage(driver);
        World.accountPage = new AccountPage(driver);
        World.webDriverHelper = new WebDriverHelper(driver);
        World.TestrailManager = new TestRailManager();
        World.restAssuredHelper = new RestAssuredHelper();
        World.sitesApiHelper = new SitesApiHelper();
        World.devicesPage = new DevicesPage(driver);
        World.alertsPage = new AlertsPage(driver);
        World.alertSettings = new AlertSettings(driver);
        World.exportPage = new Export(driver);
        World.searchPage = new SearchPage(driver);
        World.teamsPage = new TeamsPage(driver);
        World.sitesPage = new SitesPage(driver);
        World.graphPage = new GraphPage(driver);
        World.plantTab = new PlantTab(driver);
        World.waterTab = new WaterTab(driver);
        World.notesTab = new NotesTab(driver);
        World.distributorPage = new Distributor(driver);
        World.imgGallery = new ImageGallery(driver);
        World.uiPerformance = new performance(driver);
        World.teamsApiHelper = new TeamsApiHelper();
        World.notesApiHelper = new NotesAPIHelper();
        World.plantApiHelper = new PlantAPIHelper();
        World.graphApiHelper = new GraphApiHelper();
        World.multiSiteApiHelper = new MultiSiteApiHelper();
        World.waterMultiSite = new WaterMultiSite(driver);
        World.alertsApiHelper = new AlertsApiHelper();
        World.mapApiHelper = new MapApiHelper();
        World.filesHelper = new FilesHelper();
    }
}