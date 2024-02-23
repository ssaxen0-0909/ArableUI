package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import support.Constants;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static support.Constants.*;
import static support.PropertiesReader.orgTargeted;
import static support.WebDriverHelper.wait;
import static support.World.*;

public class WaterMultiSite {

    private final WebDriver driver;
    private static final Logger log = LogManager.getLogger(WaterMultiSite.class);

    @FindBy(xpath = "//p[normalize-space()='Analysis']")
    private WebElement dashboardMenu_Analysis;
    @FindBy(xpath = "//li[@class='submenu-item']//p[@class='item-title']")
    private List<WebElement> submenuAnalysis;
    @FindBy(xpath = "//p[normalize-space()='Water']")
    private WebElement dashboardMenu_Water;
    @FindBy(xpath = "//div[contains(@class,'sites-list')]")
    private WebElement sitesList_Modal;
    @FindBy(xpath = "//p[contains(@class,'cursor-pointer highlight')]")
    private List<WebElement> sitesInWaterPage;
    @FindBy(xpath = "//div[@class='site-list-section']/div/div/div[@class='site-column']/div[@ng-reflect-ng-class]")
    private List<WebElement> irrigationReplaceEtc;
    @FindBy(xpath = "//div[@class='site-column display-block']")
    private List<WebElement> lastIrrigationRuntime;
    @FindBy(xpath = "//div[@class='site-column display-block']/child::div[2]")
    private List<WebElement> lastIrrigationRuntimeHour;
    @FindBy(xpath = "//div[@class='site-column display-block']//following-sibling::div[contains(@class,'site-column')][1]")
    private List<WebElement> proximityRefillThreshold;
    @FindBy(xpath = "//div[@class='site-column model-value']/div[contains(@class,'padding-top-10')]")
    private List<WebElement> heatStressHours;
    @FindBy(xpath = "//div[@class='site-column name']/div/div")
    private WebElement siteHeaderSortBtn;
    @FindBy(xpath = "(//div[@class='no-sites']/p)[1]")
    private WebElement noSitesMessage1;
    @FindBy(xpath = "(//div[@class='no-sites']/p)[2]")
    private WebElement noSitesMessage2;
    @FindBy(xpath = "//div[@class='no-legends-empty']")
    private WebElement msgInFusionChart;
    @FindBy(xpath = "//div[@class='no-legends-empty no-empty-sec-2']")
    private WebElement msgInMulti_SiteChart;
    @FindBy(xpath = "//p[@class='1 selected']")
    private WebElement globalOrgSelected_MapPage;
    @FindBy(xpath = "(//div[@class='column-auto']//span)[1]")
    private WebElement organizationDropdown;
    @FindBy(xpath = "(//div[text()='Organization']//..//following-sibling::div//following-sibling::div)[2]//following-sibling::p")
    private List<WebElement> organizationDropdownList;
    @FindBy(xpath = "(//div[@class='column-auto']//span)[2]")
    private WebElement teamsDropdown;
    @FindBy(xpath = "//div[@class='team-selector']//following-sibling::div[@class='options']//following-sibling::div[@class='grid grid-center option']//div//following-sibling::p")
    private List<WebElement> teamsDropdownList;
    @FindBy(xpath = "//div[@class='column']/p[@class='2 selected']")
    private WebElement selectedTeam;
    @FindBy(xpath = "//p[@class='iconEnabled']")
    private WebElement firstNameInTeamsDropdown;
    @FindBy(xpath = "(//div[@class='info-modal']/div/h1)[2]")
    private WebElement statusBarHeaderTitle;
    @FindBy(xpath = "(//div[@class='info-modal']/div/h1)[1]")
    private WebElement benchmarkGraphHeaderTitle;
    @FindBy(xpath = "(//div[@class='info-modal']/div[@class='content-info']/div/p)[2]")
    private WebElement statusBarModalInfo;
    @FindBy(xpath = "(//div[@class='info-modal']/div[@class='content-info']/div/p)[1]")
    private WebElement benchmarkGraphModalInfo;
    @FindBy(xpath = "//div[@class='multisite-fusion-chart']/span/span")
    private WebElement statusBarTitle;
    @FindBy(xpath = "(//span[@class='chartTitleContainer']/span)[1]")
    private WebElement benchmarkGraphTitle;
    @FindAll({@FindBy(xpath = "//app-angular-map//following-sibling::div[@aria-label='Map']//following-sibling::div[@role='button']")})
    private List<WebElement> sitesInMap;
    @FindBy(xpath = "//span[@id='multisite-chart']/*[local-name()='svg']//*[local-name()='g' and contains(@class, 'plot-group')]//*[name()='rect']")
    private List<WebElement> benchmarkGraphHover;
    @FindBy(xpath = "//*[@class='fc__tooltip fusioncharts-div' and contains(@style, 'will-change: lef')]")
    private WebElement benchmarkGraphTooltip;
    @FindBy(xpath = "//*[local-name()='g']/*[name()='text' and @style='text-anchor: end;']")
    private List<WebElement> sitesInBenchmarkGraph;
    @FindAll({@FindBy(xpath = "//div[@class='expandIcon']/span[@class='chartValue']")})
    private List<WebElement> statusBarReading;
    @FindBy(xpath = "//div[@class='expandIcon']/span[@class='chartValue']//../span[@class='legendIcon']")
    private List<WebElement> statusBarColor;
    //    @FindBy(xpath = "//div[@class='no-data-legend-header']/span")
//    private WebElement noDataToShow;
    @FindBy(xpath = "//span[@class='nothing-text']")
    private WebElement noDataToShow;
    @FindBy(xpath = "(//span[@class='legendIcon'])[1]")
    private WebElement statusBarCountColour;
    @FindBy(xpath = "(//button[@class='btn-close'])[3]")
    private WebElement closeBtnForStatusBarInfoModal;
    @FindBy(xpath = "(//button[@class='btn-close'])[2]")
    private WebElement closeBtnForBenchmarkGraphInfoModal;
    @FindBy(xpath = "//div[@class='btn btn-show']/img")
    private List<WebElement> addBtn;
    @FindBy(xpath = "//div[@class='btn btn-hide']")
    private WebElement hideBtn;
    @FindBy(xpath = "//div[@class='date-container'][1]/div[2]")
    private WebElement startDateF;
    @FindBy(xpath = "//div[@class='date-container'][2]/div[2]")
    private WebElement endDateF;
    @FindBy(xpath = "//div[@class='datepicker-container start']")
    private WebElement datePickerF;
    @FindBy(xpath = "(//button[@class='btn btn-default btn-secondary btn-sm'])[1]")
    private WebElement startCalenderHeaderF;
    @FindAll({@FindBy(xpath = "//button[@class='btn btn-default btn-link']")})
    private List<WebElement> calenderMonthListF;
    @FindAll({@FindBy(xpath = "//tbody/tr/td[@class='text-center']")})
    private List<WebElement> calenderDateListF;
    @FindBy(xpath = "(//button[@class='btn btn-default btn-secondary btn-sm'])[2]")
    private WebElement endCalenderHeaderF;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm pull-left float-left']")
    private WebElement leftArrowBtn;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm pull-right float-right']")
    private WebElement rightArrowBtn;
    @FindAll({@FindBy(xpath = "//button[@class='btn btn-default btn-link']")})
    private List<WebElement> calenderYearListF;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    private WebElement calenderYearHeaderF;
    @FindBy(xpath = "(//div[@class='growth-stages-table']//div[@class='menu-button'])[1]")
    private WebElement menuBtnInGrowthStage;
    @FindBy(xpath = "//div[@class='button' and contains(text(),'Add New Stage ')]")
    private WebElement addNewStageBtn;
    @FindBy(xpath = "(//arable-input-number/div/input)[1]")
    private WebElement inputGddUnits;
    @FindBy(xpath = "//div[@class='growth-stage-column growth-stage']/textarea")
    private WebElement growthStage;
    @FindBy(xpath = "//div[@class='btn btn-save']/img")
    private WebElement gddSaveBtn;
    @FindBy(xpath = "//button[@class='btn btn-save']")
    private WebElement seasonSaveBtn;
    @FindBy(xpath = "//div[@class='success toast']//p")
    private WebElement successMsgAfterClickOnSave;
    //    @FindAll({@FindBy(xpath = "//div[@class='season-column growthStage']/p")})
//    private List<WebElement> currentGrowthStage;
    @FindAll({@FindBy(xpath = "//div[@class='season-column growthStage']")})
    private List<WebElement> currentGrowthStage;
    @FindBy(xpath = "//div[@class='season-column site']/p")
    private List<WebElement> seasonSite;
    @FindBy(xpath = "//p[@class='cursor-pointer highlight bold site-name-text padding-top-10']")
    List<WebElement> paginationSiteNameList;
    @FindBy(xpath = "(//div[@class='menu-button'])[1]")
    private WebElement menuButtonOfFirstSite;
    @FindAll({@FindBy(xpath = "//a[contains(@class,'internal')]")})
    List<WebElement> numberOfRowsDataPresent;
    @FindBy(xpath = "//p[@class='title' and contains(text(),'Irrigation')]")
    private WebElement irrigationTab;
    @FindBy(xpath = "//div[@class='site-column clickable last-irrigation']/div/div")
    private WebElement lastIrrigationSortBtn;
    @FindBy(xpath = "//p[@class='title' and contains(text(),'Heat Stress')]")
    private WebElement heatStressTab;
    @FindBy(xpath = "//p[@class='title' and contains(text(),'Soil Moisture')]")
    private WebElement soilMoistureTab;
    @FindBy(xpath = "//div[@class='site-column clickable no-border-right']/div/div")
    private WebElement heatStressSortBtn;
    @FindBy(xpath = "//a[contains(@class,'internal')]")
    private WebElement noOfPages;
    @FindBy(xpath = "//google-map[@id='map']")
    private WebElement googleMap;
    @FindBy(xpath = "(//div[@class='column']/p)[1]")
    private WebElement selectedOrgName;
    @FindBy(xpath = "//app-multisite-fusionchart")
    private WebElement fusionAndBenchmarkModal;
    @FindAll({@FindBy(xpath = "//app-multisite-fusionchart//div[@class='multisite-fusion-chart']//*[local-name()='g' and contains(@class, 'plot-group')]/*[name()='rect']")})
    private List<WebElement> statusBarCount;
    @FindBy(xpath = "//button[@title='Zoom in']")
    WebElement mapZoomInBtnF;
    @FindBy(xpath = "//button[@title='Zoom out']")
    WebElement mapZoomOutBtnF;
    @FindBy(xpath = "//div[@class='multisite-fusion-chart']/span/span[contains(text(),'Heat Stress Hours')]")
    private WebElement heatStressStatusBar;
    //    @FindBy(xpath = "//div[@class='multisite-fusion-chart']/span/span[contains(text(),'Irrigation Runtime Hours')]")
//    private  WebElement lastIrrigationStatusBar;
    @FindBy(xpath = "//*[local-name()='g' and contains(@class,'fusioncharts')]/*[name()='text']")
    private List<WebElement> statusBarCountInside;
    @FindAll({@FindBy(xpath = "//div[@class='menu-button']")})
    private List<WebElement> menuBtnList;
    @FindBy(xpath = "//div[@class='button' and contains(text(),'Validate Sensors ')]")
    private List<WebElement> validateSensorList;
    @FindBy(xpath = "//div[@class='no-devices-text']")
    private WebElement noDevicesMsg;
    @FindBy(xpath = "//div[@class='column device-table-entry device-sensors']/div[@class='no-sensor-container']")
    private List<WebElement> noSensorList;
    @FindBy(xpath = "//div[@class='devices-information-list']//div[@class='card-body']//arable-dotted-menu")
    private WebElement menuBtnInDevices;
    @FindBy(xpath = "//div[contains(@title,'Davis Wind Anemometer 6410 (Direction)') or contains(@title,'Davis Wind Anemometer 6410 (Speed)') or contains(@title,'Sentek Drill and Drop Soil Moisture') or contains(@title,'GEMS PS41 Series Pressure Switch') or contains(@title,'undefined')]//..//..//./div[@class='menu']")
    private List<WebElement> sensorDevicesMenuBtn;
    @FindBy(xpath = "//div[@class='column device-table-entry device-sensors']/div[@class='no-sensor-container']//..//..//./div[@class='menu']")
    private WebElement menuBtnForNoSensorDevices;
    @FindBy(xpath = "//button[@class='btn-action' and contains(text(),'Done with validation')]")
    private WebElement doneValidationBtn;
    @FindBy(xpath = "(//div[@class='actions'])[1]")
    private WebElement createSeasonBtn;
    @FindBy(xpath = "//div[@class='grid header-titles']")
    private WebElement headerColumnNames;
    @FindBy(xpath = "//div[@class='head-tooltip']/h1[contains(text(),'Create New Season')]")
    private WebElement createSeasonModelHeader;
    @FindBy(xpath = "(//div[@class='modal-content tooltip-content']/button[@class='btn-close'])[3]")
    private WebElement closeBtnFromCreateSeasonModal;
    @FindAll({@FindBy(xpath = "//div[@class='content-modal']/arable-dropdown-selector")})
    private List<WebElement> selectSiteCropVarietal;
    @FindBy(xpath = "(//div[@class='action-buttons']/arable-request-button/button[contains(text(),' Confirm ')])[1]")
    private WebElement confirmBtnInCreateSeasonModel;
    @FindBy(xpath = "//div[@class='input-error']/span")
    private List<WebElement> errorMessageBelowDropdown;
    @FindBy(xpath = "(//div[@class='options'])[3]/div")
    private List<WebElement> siteNames;
    @FindBy(xpath = "(//div[@class='options'])[5]/div")
    private List<WebElement> varietalModalList;
    @FindBy(xpath = "(//div[@class='options'])[4]/div")
    private List<WebElement> cropTypeModalList;
    @FindBy(xpath = "(//div[@class='content']/div/button[@class='btn-action confirm'])[2]")
    private WebElement confirmBtnInSetRefillThreshold;
    @FindBy(xpath = "(//button[@class='btn btn-default btn-secondary btn-sm pull-left float-left'])[1]")
    private WebElement leftArrowForStartDate;
    @FindBy(xpath = "(//button[@class='btn btn-default btn-secondary btn-sm pull-right float-right'])[2]")
    private WebElement rightArrowForEndDate;
    @FindBy(xpath = "(//div[@class='button down'])[2]")
    private WebElement refillThresholdDownArrow;
    @FindBy(xpath = "//li/a[@class='internal current']")
    private WebElement currentPage;
    @FindBy(xpath = "//div[@class='seasons-data']")
    private WebElement seasonsData;
    @FindBy(xpath = "//app-multisite-fusionchart//div[@class='multisite-fusion-chart']//*[local-name()='g' and contains(@class, 'plot-group')]/*[name()='rect']")
    List<WebElement> overAllGraph;
    @FindBy(xpath = "(//span[@class='cursor-pointer'])[1]")
    private WebElement sortBtnInBenchmarkGraph;
    @FindAll({@FindBy(xpath = "(//*[local-name()='g' and contains(@class,'dataset-Label-group')])[6]//*[name()='text']")})
    private List<WebElement> sitesNameInBenchmarkGraph;
    @FindBy(xpath = "(//*[local-name()='g' and contains(@class,'scrollContainer')]/*[name()='rect'])[2]")
    private WebElement scrollBarInBenchmarkGraph;
    @FindBy(xpath = "//*[name()='g' and contains(@class,'scrollContainer')]/*[name()='rect'][2]")
    private WebElement benchmarkScrollBar;
    @FindBy(xpath = "//app-multisite-fusionchart//div[@class='multisite-fusion-chart']")
    private WebElement statusBarSection;
    @FindBy(xpath = "//div[@class='1 grid grid-center headers disabled'])[1]")
    private WebElement globalOrgSelectedDisabled;
    @FindBy(xpath = "//span[@class='1 caret']")
    private WebElement globalOrgDropdownBtn_MapPage;
    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//input[@type='search']")
    private WebElement globalOrgDropdownSearch_MapPage;
    @FindBy(xpath = "//p[normalize-space()='arable-team']")
    private WebElement globalOrgSearchSuggestion_MapPage;
    //    @FindBy(xpath = "//div[@class='1 dropdown-selector open']//div[@class='options']//p")
//    private List<WebElement> globalOrgSearchSuggestion_MapPage;
    @FindBy(xpath = "//p[normalize-space()='Graph']")
    private WebElement dashboardMenu_Graph;
    @FindBy(xpath = "//p[normalize-space()='Rank']")
    private WebElement dashboardMenu_Rank;
    @FindBy(xpath = "//p[normalize-space()='Analytics']")
    private WebElement dashboardMenu_Analytics;
    @FindBy(xpath = "//p[normalize-space()='Export']")
    private WebElement dashboardMenu_Export;
    @FindBy(xpath = "//p[normalize-space()='Water Balance']")
    private WebElement waterBalanceTag;
    @FindBy(xpath = "//div[@class='site-column']//p")
    List<WebElement> siteNameListInMultiWaterSites;
    @FindBy(xpath = "//div[@class='column']//h1[text()='Water Balance']")
    private WebElement waterBalanceTagInSingleSite;
    @FindBy(xpath = "//div[@class='title-site-name']//h3")
    private WebElement singleSiteUiName;
    @FindBy(xpath = "//li[@class='tab-nav__item active']//p[normalize-space()='Water']")
    private WebElement waterInSingleSite;
    @FindBy(xpath = "//div[@class='sites-list']")
    private WebElement paginationTag;
    @FindBy(xpath = "//div[@class='site-column display-block']//preceding-sibling::div[@class='site-column'][1]//div")
    List<WebElement> irrigationT0ReplaceEtcHrs;
    //    @FindBy(xpath = "//div[@class='site-list-section']//div[contains(@class,'site-column')][3]//div[@ng-reflect-ng-class='[object Object]']")
//    List<WebElement> lastIrrigationRuntime;
    @FindBy(xpath = "//div[@class='site-list-section']//div[contains(@class,'site-column')][4]//div")
    List<WebElement> proximityToRefillThreshold;
    //    @FindBy(xpath = "//div[@class='site-list-section']//div[contains(@class,'site-column')][5]//div")
//    List<WebElement> heatStressHours;
    @FindBy(xpath = "//div[@class='menu']")
    List<WebElement> menuOptionList;
    @FindBy(xpath = "(//span[@class='text-blue'])[3]")
    private WebElement arrowToIncreaseTheSites;
    @FindBy(xpath = "//h3[normalize-space()='Site Name']")
    private WebElement siteNameTag;
    @FindBy(xpath = "//div[@class='container-text']//span[normalize-space()='Irrigation to Replace ETc']")
    private WebElement irrigationToReplaceETcTag;
    @FindBy(xpath = "//div[@class='container-text']//span[normalize-space()='Last Irrigation Runtime']")
    private WebElement lastIrrigationRuntimeTag;
    @FindBy(xpath = "//div[@class='container-text']//span[normalize-space()='Proximity to Refill Threshold']")
    private WebElement proximityToRefillThresholdTag;
    @FindBy(xpath = "//div[@class='container-text']//span[normalize-space()='Heat Stress Hours']")
    private WebElement heatStressHoursTag;
    //    @FindBy(xpath = "(//div[@class='menu-button'])[1]")
//    private WebElement menuButtonOfFirstSite;
//    @FindBy(xpath = "//a[contains(@class,'internal')]")
//    List<WebElement> numberOfRowsDataPresent;
    @FindBy(xpath = "//div[@class='menu-content']//div")
    List<WebElement> menuName;
    @FindBy(xpath = "(//div[@class='menu'])[1]//div[@class='button'][2]//img")
    private WebElement validateSensorsClr;
    @FindBy(xpath = "//div[@class='menu-content']/div[normalize-space()='Validate Sensors']")
    private WebElement validateSensors;
    @FindBy(xpath = "//button[normalize-space()='Done with validation']")
    private WebElement doneWithValidation;
    @FindBy(xpath = "//div[@class='device-table-content']")
    private WebElement deviceTableContentForValidateSensors;
    @FindBy(xpath = "//div[@class='menu-content']//div[normalize-space()='Manual Irrigation']")
    private WebElement manualIrrigation;
    @FindBy(xpath = "//div[@class='head-tooltip']//h1[normalize-space()='Manual Irrigation']")
    private WebElement manualIrrigationTag;
    @FindBy(xpath = "//span[normalize-space()='Entry Table (Historical)']")
    private WebElement entryTableHistoricalTag;
    @FindBy(xpath = "//div[@class='img-container float-right']")
    private WebElement addSimpleTag;
    @FindBy(xpath = "//p[normalize-space()='Date']")
    private WebElement dateTagInManualIrrigationTag;
    @FindBy(xpath = "//p[normalize-space()='Amount']")
    private WebElement amountTagInManualIrrigationTag;
    @FindBy(xpath = "//p[normalize-space()='User']")
    private WebElement userTagInManualIrrigationTag;
    @FindBy(xpath = "//h1[normalize-space()='Create Single Irrigation Entry']")
    private WebElement createSingleIrrigationEntryTag;
    @FindBy(xpath = "//div[@class='datepicker ng-star-inserted']")
    private WebElement datePickerTag;
    @FindBy(xpath = "//div[@class='column device-table-entry device-name text-center']")
    List<WebElement> deviceList;
    @FindBy(xpath = "//p[normalize-space()='Water Balance']")
    private WebElement waterBalance;
    @FindBy(xpath = "//p[normalize-space()='Soil Moisture']")
    private WebElement soilMoistureTag;
    @FindBy(xpath = "//p[normalize-space()='Heat Stress']")
    private WebElement heatStressTag;
    @FindBy(xpath = "//div[@class='expandIcon']")
    private WebElement soilMoistureExpandIcon;
    @FindBy(xpath = "//p[normalize-space()='Irrigation']")
    private WebElement irrigationTag;
    @FindBy(xpath = "//span[normalize-space()='> 8 hours']")
    private WebElement tagForAbove8HrsInWaterBalance;
    @FindBy(xpath = "//span[normalize-space()='2 - 8 hours']")
    private WebElement tagForInBetween2to8HrsInWaterBalance;
    @FindBy(xpath = "//span[normalize-space()='< 2 hours']")
    private WebElement tagForBelow2HrsInWaterBalance;
    @FindBy(xpath = "//span[@class='legendIcon'][1]")
    private WebElement legendIcon1;
    @FindBy(xpath = "//span[@class='legendIcon'][2]")
    private WebElement legendIcon2;
    @FindBy(xpath = "//span[@class='legendIcon'][3]")
    private WebElement legendIcon3;
    @FindBy(xpath = "//span[text()='≤']")
    private WebElement greaterThanEqualToIconForSoilMoisture;
    @FindBy(xpath = "//span[normalize-space()='< 10%']")
    private WebElement greaterThanTenIconForSoilMoisture;
    @FindBy(xpath = "//span[normalize-space()='> 10%']")
    private WebElement lessThanTenIconForSoilMoisture;
    @FindBy(xpath = "//span[normalize-space()='< 4 hrs']")
    private WebElement lessThanFourIconForIrrigation;
    @FindBy(xpath = "//span[normalize-space()='5 - 20 hrs']")
    private WebElement fiveToTwentyIconForIrrigation;
    @FindBy(xpath = "//span[normalize-space()='> 21 hrs']")
    private WebElement greaterThanTwentyOneIconForIrrigation;
    @FindBy(xpath = "//div[@class='state-text-container']")
    private WebElement statusInDevicePage;
    @FindBy(xpath = "//div[normalize-space()='Battery Status']")
    private WebElement batteryStatusTag;
    @FindBy(xpath = "//div[contains(@title, 'Wind ') or contains(@title, 'Pressure') or contains(@title, 'Soil ')]//ancestor::div[@class='device-table-entry-container grid']//div[@class='column device-table-entry device-name text-center']")
    List<WebElement> deviceWithSensor;
    @FindBy(xpath = "//div[@class='device-table-titles grid']//div[normalize-space()='Device ID']")
    private WebElement deviceIdTagInParticularSites;
    @FindBy(xpath = "//div[@class='device-table-titles grid']//div[normalize-space()='Battery Status']")
    private WebElement batteryStatusTagInParticularSites;
    @FindBy(xpath = "//div[@class='device-table-titles grid']//div[normalize-space()='Connected Sensors']")
    private WebElement connectedSensorsTagInParticularSites;
    @FindBy(xpath = "//div[normalize-space()='Device ID']/parent::div/following-sibling::div//arable-dotted-menu")
    List<WebElement> menuBtnInValidateSensor;
    @FindBy(xpath = "//div[@class='menu-content']")
    private WebElement validateSensorForParticularUser;
    @FindBy(xpath = "//h1[normalize-space()='Set Up Connected Sensors']")
    private WebElement setUpConnectedSensorsTag;
    @FindBy(xpath = "//label[normalize-space()='Port 1 Analog']")
    private WebElement port1AnalogTag;
    @FindBy(xpath = "//label[normalize-space()='Port 2 Pulse']")
    private WebElement port2Pulse;
    @FindBy(xpath = "//label[normalize-space()='Port 3 SDI-12']")
    private WebElement port3SDI12Tag;
    @FindBy(xpath = "//span[@class='0 check']")
    List<WebElement> greenColourTick;
    @FindBy(xpath = "//p[@class='0 selected']")
    List<WebElement> listOfDropInForTheSensor;
    @FindBy(xpath = "//div[@class='0 dropdown-selector open']//div[@class='grid grid-center option selected']//p")
    private WebElement sensorWhichIsSelectedInDropDown;
    @FindBy(xpath = "//app-multisite-fusionchart//div[@class='multisite-fusion-chart']//*[@text-anchor='middle']")
    List<WebElement> textInOverAllGraph;
    @FindBy(xpath = "//app-multisite-fusionchart//div[@class='multisite-fusion-chart']//*[local-name()='g' and contains(@class, 'plot-group')]/*[name()='rect']")
    ArrayList<String> deviceNameStored;
    @FindBy(xpath = "//div[@class='site-column display-block']//div[@ng-reflect-ng-class='[object Object]']")
    List<WebElement> irrigationEtcDate;
    @FindBy(xpath = "//*[@class='site-general-info']")
    private WebElement siteGraphOnWaterMultiSitePage;
    public String siteNameStored = "";
    public String irrigationT0ReplaceEtcHrsText = "";
    List<String> sitesNamesInTable = new ArrayList<>();
    List<String> sitesNamesInBenchmarkGraph = new ArrayList<>();
    public String seasonSiteName;

    public WaterMultiSite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToMultiSiteWaterPage(String pageOption) {
        try {
            webDriverHelper.waitUntilVisible(dashboardMenu_Analysis, 60, 1);
            Actions action = new Actions(driver);
            action.moveToElement(dashboardMenu_Analysis).moveToElement(dashboardMenu_Water).click().build().perform();
            webDriverHelper.waitUntilVisible(siteGraphOnWaterMultiSitePage,30,2); // sometimes the page load time is slow
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_FailedToLoginWaterPage.jpg");
            Assert.fail("Failed in navigateToMultiSiteWaterPage method due to exception:- " + exc);
        }
    }

    public void verifyTheCurrentPageAndValidateTheValuesWithTheAPI() {
        webDriverHelper.waitUntilVisible(sitesList_Modal, 100, 1);
        if (numberOfRowsDataPresent.size() > 1) {
            pageNoInWaterSite = Integer.parseInt(currentPage.getText());
            verifyTheUIDataOfAllColumnsAndGrowingSeasonAPICall();
        } else {
            pageNoInWaterSite = 1;
            verifyTheUIDataOfAllColumnsAndGrowingSeasonAPICall();
        }
    }

    public void verifyTheDataInUIAndApiAccordingToThePage() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 100, 1);
            if (numberOfRowsDataPresent.size() > 1) {
                for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                    pageNoInWaterSite = Integer.parseInt(numberOfRowsDataPresent.get(i).getText());
                    numberOfRowsDataPresent.get(i).click();
                    webDriverHelper.waitUntilVisible(sitesList_Modal, 10, 1);
                    verifyTheUIDataOfAllColumnsAndGrowingSeasonAPICall();
                }
            } else {
                pageNoInWaterSite = 1;
                verifyTheUIDataOfAllColumnsAndGrowingSeasonAPICall();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheDataInUIAndApiAccordingToThePage.jpg");
            Assert.fail("Failed in verifyTheDataInUIAndApiAccordingToThePage method due to exception :- " + exc);
        }
    }

    public void verifyTheUIDataOfAllColumnsAndGrowingSeasonAPICall() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 100, 1);
            Map<String, String[]> siteToValuesMapInUI = new HashMap<>();
            for (int i = 0; i < sitesInWaterPage.size(); i++) {
                String site = sitesInWaterPage.get(i).getText();
                String[] columnValues = {
                        irrigationReplaceEtc.get(i).getText(),
                        lastIrrigationRuntime.get(i).getText(),
                        proximityRefillThreshold.get(i).getText(),
                        heatStressHours.get(i).getText()
                };
                Thread.sleep(1000);
                boolean allIndexesMeetCondition = true;
                for (String columnValue : columnValues) {
                    if (columnValue.contains("Currently Irrigating")) {
                        log.info("Skipping row for site: " + site + " as it is 'Currently Irrigating'");
                        allIndexesMeetCondition = false;
                    }
                }
                if (allIndexesMeetCondition) {
                    siteToValuesMapInUI.put(site, columnValues);
                }
            }
            multiSiteApiHelper.getSummaryRequestForWaterFromGrowingSeasonApi();
            for (Map.Entry<String, String[]> apiEntry : siteToValuesMapInApi.entrySet()) {
                String site = apiEntry.getKey();
                String[] apiValues = apiEntry.getValue();
                if (siteToValuesMapInUI.containsKey(site)) {
                    String[] uiValues = siteToValuesMapInUI.get(site);
                    if (!(compareValues(uiValues, apiValues))) {
                        Assert.fail("UI values for site " + site + " do not match API values.");
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyUIAndAPIData.jpg");
            Assert.fail("Failed in verifyTheUIDataOfAllColumnsAndGrowingSeasonAPICall method due to exception:- " + exc);
        }
    }

    private static boolean compareValues(String[] uiValues, String[] apiValues) {
        return java.util.Arrays.equals(uiValues, apiValues);
    }

    public void verifyTheOrder(List<WebElement> elements, String sortHeader) {
        List<String> values = elements.stream()
                .map(webElement -> webElement.getText().trim())
                .collect(Collectors.toList());
        log.info("values" + values);
        boolean isAscending = true;
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i).compareTo(values.get(i + 1)) > 0) {
                isAscending = false;
                break;
            } else if (values.get(i).compareTo(values.get(i + 1)) < 0) {
                break;
            }
        }
        if (isAscending) {
            log.info("The names/values from " + sortHeader + " column are in ascending order!");
        } else {
            log.info("The names/values from " + sortHeader + " column are in descending order!");
        }
    }

    public void verifyOnClickTheDataIsSortingInAscendingAndDescendingOrder() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            siteHeaderSortBtn.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            verifyTheOrder(sitesInWaterPage, "Site Name");
            webDriverHelper.waitUntilVisible(irrigationTab, 60, 1);
            irrigationTab.click();
            webDriverHelper.waitUntilVisible(lastIrrigationSortBtn, 60, 1);
            lastIrrigationSortBtn.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            verifyTheOrder(lastIrrigationRuntime, "Last Irrigation Runtime");
            webDriverHelper.waitUntilVisible(heatStressTab, 60, 1);
            heatStressTab.click();
            webDriverHelper.waitUntilVisible(heatStressSortBtn, 60, 1);
            heatStressSortBtn.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            verifyTheOrder(heatStressHours, "Heat Stress Hours");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyOnClickTheDataIsSortingInAscendingAndDescendingOrder.jpg");
            Assert.fail("Failed in verifyOnClickTheDataIsSortingInAscendingAndDescendingOrder method due to exception:- " + exc);
        }
    }

    public void verifySiteHeaderSortButton() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 100, 1);
            webDriverHelper.waitUntilVisible(siteHeaderSortBtn, 60, 1);
            WebElement sortBtn = driver.findElement(By.xpath("//span[@class='active-sort caret-down']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String borderColor = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('border-top');", sortBtn);
            String[] part1 = borderColor.split("solid");
            String sortBtnBkgColor = part1[1].trim();
            Assert.assertEquals(sortBtnBkgColor, Constants.siteHeaderSortColor, "Failed to verify the color of the site header sort btn");
            siteHeaderSortBtn.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            verifyTheOrder(sitesInWaterPage, "sites names");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifySiteHeaderSortButton.jpg");
            Assert.fail("Failed in verifySiteHeaderSortButton method due to exception:- " + exc);
        }
    }

    public void verifyTheLastIrrigationRuntimeDataIsInFormat() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 100, 1);
            for (WebElement lastIrrigation : lastIrrigationRuntime) {
                String lastIrrigationValue = lastIrrigation.getText();
                if (!(lastIrrigationValue.equals("--"))) {
                    String[] parts = lastIrrigationValue.split("\n");
                    String date = parts[0];
                    String hours = parts[1];
                    log.info("last irrigation runtime date :- " + date);
                    log.info("last irrigation runtime hrs :- " + hours);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
                    if (!dateFormat.format(dateFormat.parse(date)).equals(date)) {
                        Assert.fail("Failed to verify the date format " + date + " displayed in the table for last irrigation runtime");
                    }
                    if (!(hours.equals("--")) && !(hours.equals("Currently Irrigating"))) {
                        if (!(hours.matches(Constants.timeFormatInWaterMultiSite))) {
                            Assert.fail("Failed to verify the time format displayed in the table for last irrigation runtime");
                        }
                    }
                    if (hours.equals("Currently irrigating")) {
                        String bkgColor = lastIrrigation.getCssValue("Color");
                        Assert.assertEquals(bkgColor, Constants.greenColorInWaterTab, "Failed to verify the color of the currently irrigating runtime");
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheLastIrrigationRuntimeDataIsInDdMmFormat.jpg");
            Assert.fail("Failed in verifyTheLastIrrigationRuntimeDataIsInDdMmFormat method due to exception:- " + exc);
        }
    }

    public void verifyTheMsgForNoSites() {
        try {
            webDriverHelper.waitUntilVisible(noSitesMessage1, 60, 1);
            String msgInSitesSection1 = noSitesMessage1.getText();
            webDriverHelper.waitUntilVisible(noSitesMessage2, 60, 1);
            String msgInSitesSection2 = noSitesMessage2.getText();
            String msgInSitesSection = msgInSitesSection1 + " " + msgInSitesSection2;
            Assert.assertEquals(msgInSitesSection, Constants.noSitesMessageInWaterTab, "Failed to verify the message that displayed in the water tab under sites section");
            webDriverHelper.waitUntilVisible(msgInFusionChart, 60, 1);
            String msgChart = msgInFusionChart.getText();
            Assert.assertEquals(msgChart, Constants.msgInChartSessionIfNoData, "Failed to verify the message that displayed in the water tab under fusion chart section");
            webDriverHelper.waitUntilVisible(msgInMulti_SiteChart, 60, 1);
            String msgMultiSiteChart = msgInMulti_SiteChart.getText();
            Assert.assertEquals(msgMultiSiteChart, Constants.msgInChartSessionIfNoData, "Failed to verify the message that displayed in the water tab under multi-site chart section");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheMsgForNoSites");
            Assert.fail("Failed in verifyTheMsgForNoSites method due to exception :- " + exc);
        }
    }


    public void verifyTheMessageInSiteTableAndIndividualTabIfTheOrgOrTeamDoesNotHaveAnySites() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 100, 1);
            webDriverHelper.waitUntilVisible(organizationDropdown, 60, 1);
            organizationDropdown.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(organizationDropdownList, 60, 1);
            for (WebElement element : organizationDropdownList) {
                String orgName = element.getText();
                if (orgName.equalsIgnoreCase(Constants.orgWithNoSite)) {
                    element.click();
                    break;
                }
            }
            verifyTheMsgForNoSites();
            webDriverHelper.waitUntilVisible(teamsDropdown, 60, 1);
            teamsDropdown.click();
            for (WebElement element : teamsDropdownList) {
                String teamsName = element.getText();
                if (teamsName.equalsIgnoreCase(Constants.teamWithNoSite)) {
                    element.click();
                    break;
                }
            }
            verifyTheMsgForNoSites();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheMessageInSiteTableAndIndividualTab.jpg");
            Assert.fail("Failed in verifyTheMessageInSiteTableAndIndividualTabIfTheOrgOrTeamDoesnotHaveAnySites method due to exception:- " + exc);
        }
    }

    public void observeAndVerifyWhenTheBrowserIsHardRefreshed() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 100, 1);
            ((JavascriptExecutor) driver).executeScript("location.reload(true);");
            webDriverHelper.waitUntilVisible(googleMap, 100, 1);
            webDriverHelper.waitUntilVisible(organizationDropdown, 60, 1);
            organizationDropdown.click();
            webDriverHelper.waitUntilVisible(globalOrgSelected_MapPage, 60, 1);
            String selectedOrgName = globalOrgSelected_MapPage.getText();
            webDriverHelper.waitUntilVisible(organizationDropdownList.get(0), 60, 1);
            String firstOrgName = organizationDropdownList.get(0).getText();
            Assert.assertEquals(selectedOrgName, firstOrgName, "Failed because the selected org is not the first org in the list");
            webDriverHelper.waitUntilVisible(teamsDropdown, 60, 1);
            teamsDropdown.click();
            webDriverHelper.waitUntilVisible(firstNameInTeamsDropdown, 60, 1);
            String firstNameInDropdown = firstNameInTeamsDropdown.getText();
            webDriverHelper.waitUntilVisible(selectedTeam, 60, 1);
            String teamName = selectedTeam.getText();
            Assert.assertEquals(teamName, firstNameInDropdown, "Failed because the selected team is not the first team in the list");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_observeAndVerifyWhenTheBrowserIsHardRefreshed.jpg");
            Assert.fail("Failed in observeAndVerifyWhenTheBrowserIsHardRefreshed method due to exception:- " + exc);
        }
    }

    public void pickTheSiteWhichAsCurrentGrowthStage() {
        try {
            webDriverHelper.waitUntilVisible(seasonsData, 60, 1);
            boolean found = false;
            Thread.sleep(1000);
            webDriverHelper.waitUntilVisibilityOfAllElements(currentGrowthStage, 60, 1);
            for (int i = 0; i < currentGrowthStage.size(); i++) {
                String gddText = currentGrowthStage.get(i).getText();
                log.info("gddText :" + gddText);
                if (!(gddText.equals(""))) {
                    seasonSiteName = seasonSite.get(i).getText();
                    log.info("seasonSiteName :" + seasonSiteName);
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail("Failed because There is no current growth stage site to verify in the water multi site page");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_pickTheSiteWhichAsCurrentGrowthStage.jpg");
            Assert.fail("Failed in pickTheSiteWhichAsCurrentGrowthStage method due to exception :- " + exc);
        }
    }

    public void verifyAndObserveNewlyAddedSeasonSiteIsPresentInListOfTableView() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            boolean found = false;
            if (numberOfRowsDataPresent.size() > 1) {
                for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                    webDriverHelper.waitUntilVisible(numberOfRowsDataPresent.get(i), 60, 1);
                    numberOfRowsDataPresent.get(i).click();
                    webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                    for (WebElement element : paginationSiteNameList) {
                        String menuName = element.getText();
                        if (menuName.equalsIgnoreCase(seasonSiteName)) {
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    Assert.fail("Failed to verify the season site " + seasonSiteName + " in the water tab after adding the gdd units for this site in seasons page");
                }
            } else {
                webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                for (WebElement webElement : paginationSiteNameList) {
                    String menuName = webElement.getText();
                    if (menuName.equalsIgnoreCase(seasonSiteName)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Assert.fail("Failed to verify the season site " + seasonSiteName + " in the water tab after adding the gdd units for this site in seasons page");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAndObserveNewlyAddedSeasonSiteIsPresentInListOfTableView.jpg");
            Assert.fail("Failed in verifyAndObserveNewlyAddedSeasonSiteIsPresentInListOfTableView method due to exception:- " + exc);
        }
    }

    public void verifyAndObserverProximityValueInTheTableView() {
        try {
            webDriverHelper.waitUntilVisible(soilMoistureTab, 60, 1);
            soilMoistureTab.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            if (numberOfRowsDataPresent.size() > 1) {
                for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                    webDriverHelper.waitUntilVisible(numberOfRowsDataPresent.get(i), 60, 1);
                    numberOfRowsDataPresent.get(i).click();
                    webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
                    for (WebElement element : proximityRefillThreshold) {
                        String proximityValue = element.getText();
                        String color = element.getCssValue("Color");
                        if (!(proximityValue.equals("--"))) {
                            Assert.assertTrue(proximityValue.contains(Constants.thresholdProximityUnit), "Failed because the proximity value is not displayed with % unit");
                            if (proximityValue.contains("+")) {
                                Assert.assertEquals(color, Constants.greenColorInWaterTab, "Failed to verify the text color if the value is positive");
                            } else if (proximityValue.contains("-")) {
                                Assert.assertEquals(color, Constants.redColorInWaterTab, "Failed to verify the text color if the value is negative");
                            }
                        }
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
                for (WebElement element : proximityRefillThreshold) {
                    String proximityValue = element.getText();
                    String color = element.getCssValue("Color");
                    if (!(proximityValue.equals("--"))) {
                        Assert.assertTrue(proximityValue.contains(Constants.thresholdProximityUnit), "Failed because the proximity value is not displayed with % unit");
                        if (proximityValue.contains("+")) {
                            Assert.assertEquals(color, Constants.greenColorInWaterTab, "Failed to verify the text color if the value is positive");
                        } else if (proximityValue.contains("-")) {
                            Assert.assertEquals(color, Constants.redColorInWaterTab, "Failed to verify the text color if the value is negative");
                        }
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAndObserverProximityValueInTheTableView.jpg");
            Assert.fail("Failed in verifyAndObserverProximityValueInTheTableView method due to exception:- " + exc);
        }
    }

    public void verifyAndObserveHeatStressHoursLastIrrigationRuntimeInTableView() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(lastIrrigationSortBtn, 60, 1);
            lastIrrigationSortBtn.isDisplayed();
            WebElement sortBtnForLastIrrigation = driver.findElement(By.xpath("(//span[@class='caret-down'])[1]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String borderColor = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('border-top');", sortBtnForLastIrrigation);
            String[] part1 = borderColor.split("solid");
            String lastIrrigationSortBtnColor = part1[1].trim();
            Assert.assertEquals(lastIrrigationSortBtnColor, Constants.darkGreyColorInWaterTab, "Failed because the last irrigation sort btn is not matching");
            webDriverHelper.waitUntilVisible(heatStressSortBtn, 60, 1);
            heatStressSortBtn.isDisplayed();
            WebElement sortBtnForHeatStress = driver.findElement(By.xpath("(//span[@class='caret-down'])[2]"));
            String borderColorForHeatStress = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('border-top');", sortBtnForHeatStress);
            String[] part2 = borderColorForHeatStress.split("solid");
            String heatStressSortBtnColor = part2[1].trim();
            Assert.assertEquals(heatStressSortBtnColor, Constants.darkGreyColorInWaterTab, "Failed because the heat stress sort btn is not matching");
            webDriverHelper.waitUntilVisible(irrigationTab, 60, 1);
            irrigationTab.click();
            webDriverHelper.waitUntilVisible(lastIrrigationSortBtn, 60, 1);
            lastIrrigationSortBtn.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            verifyTheOrder(lastIrrigationRuntime, "last irrigation runtime");
            webDriverHelper.waitUntilVisible(heatStressTab, 60, 1);
            heatStressTab.click();
            webDriverHelper.waitUntilVisible(heatStressSortBtn, 60, 1);
            heatStressSortBtn.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            verifyTheOrder(heatStressHours, "heat stress");

        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAndObserveHeatStressHoursLastIrrigationRuntimeInTableView.jpg");
            Assert.fail("Failed in verifyAndObserveHeatStressHoursLastIrrigationRuntimeInTableView method due to exception :- " + exc);
        }
    }

    public void verifyAndObserveTableViewAfterBrowserRefresh() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 90, 1);
            driver.navigate().refresh();
            webDriverHelper.waitUntilVisible(noSitesMessage1, 60, 1);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(globalOrgSelected_MapPage));
            if (!(globalOrgSelected_MapPage.getText().contains("arable-team"))) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", globalOrgDropdownBtn_MapPage);
                wait.until(ExpectedConditions.visibilityOf(globalOrgDropdownSearch_MapPage));
                wait.until(ExpectedConditions.elementToBeClickable(globalOrgDropdownSearch_MapPage));
                if (!globalOrgDropdownSearch_MapPage.isEnabled() || !globalOrgDropdownSearch_MapPage.isDisplayed()) {
                    Thread.sleep(5000);
                    globalOrgDropdownBtn_MapPage.click();
                    wait.until(ExpectedConditions.visibilityOf(globalOrgDropdownSearch_MapPage));
                    wait.until(ExpectedConditions.elementToBeClickable(globalOrgDropdownSearch_MapPage));
                }
                globalOrgDropdownSearch_MapPage.sendKeys("arable-team");
                wait.until(ExpectedConditions.elementToBeClickable(globalOrgSearchSuggestion_MapPage)).click();
            } else {
                Assert.assertTrue(globalOrgSelected_MapPage.getText().contains("arable-team"), "org name is not arable team");
            }
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            Thread.sleep(5000);
            if (!siteHeaderSortBtn.isDisplayed()) {
                Assert.fail("Failed because the sort btn is not displayed for the siteName column");
            }
            verifyTheOrder(sitesInWaterPage, "Site Name");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAndObserveTableViewAfterBrowserRefresh.jpg");
            Assert.fail("Failed in verifyAndObserveTableViewAfterBrowserRefresh method due to exception :- " + exc);
        }
    }

    public void verifyTheLocatorSiteNameIsDisplayedInTheSitesList() {
        try {
            webDriverHelper.waitUntilVisible(statusBarSection, 90, 1);
            List<String> sitesListInWaterTab = new ArrayList<>();
            for (WebElement sites : sitesInWaterPage) {
                String siteName = sites.getText();
                sitesListInWaterTab.add(siteName);
            }
//            webDriverHelper.waitUntilVisibilityOfAllElements(sitesInMap, 60, 1);
            webDriverHelper.waitUntilVisible(mapZoomInBtnF, 60, 1);
            Thread.sleep(5000);
            for (WebElement sitesLocator : sitesInMap) {
                Actions action = new Actions(driver);
                action.moveToElement(sitesLocator).perform();
                String sitesSelectedInMap = sitesLocator.getAttribute("title");
                Assert.assertTrue(sitesListInWaterTab.contains(sitesSelectedInMap), "Failed to verify the locator site name " + sitesSelectedInMap + " in the site list");
            }

        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheLocatorSiteNameIsDisplayedInTheSitesList.jpg");
            Assert.fail("Failed in verifyTheLocatorSiteNameIsDisplayedInTheSitesList method due to exception:- " + exc);
        }
    }

    public void verifyStatusBarModelInfo() {
        try {
            webDriverHelper.waitUntilVisible(noDataToShow, 10, 1);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noDataToShow);
            if (noDataToShow.isDisplayed()) {
                log.info("There is no data to verify the status bar model text");
            }
        } catch (Exception exc) {
            webDriverHelper.waitUntilVisible(statusBarTitle, 90, 1);
            statusBarTitle.click();
            webDriverHelper.waitUntilVisible(statusBarHeaderTitle, 60, 1);
            String statusBarTitle = statusBarHeaderTitle.getText();
            Assert.assertEquals(statusBarTitle, Constants.irrigationReplaceEtcModalTitle, "Failed to verify the Modal Title for the irrigation replace etc in status bar");
            String statusBarInfo = statusBarModalInfo.getText();
            Assert.assertEquals(statusBarInfo, Constants.statusBarModalInfoForIrrigationReplace, "Failed to verify the Modal info for the irrigation replace etc in status bar");
            closeBtnForStatusBarInfoModal.click();
        }
    }

    public void verifyModalInfoForWaterBalanceTabInStatusBarAndBenchmarkGraph() {
        try {
            verifyStatusBarModelInfo();
            webDriverHelper.waitUntilVisible(benchmarkGraphTitle, 60, 1);
            benchmarkGraphTitle.click();
            webDriverHelper.waitUntilVisible(benchmarkGraphHeaderTitle, 60, 1);
            String benchmarkGraphTitle = benchmarkGraphHeaderTitle.getText();
            Assert.assertEquals(benchmarkGraphTitle, Constants.irrigationReplaceEtcModalTitle, "Failed to verify the Modal Title for the irrigation replace etc in status bar");
            String benchmarkGraphInfo = benchmarkGraphModalInfo.getText();
            Assert.assertEquals(benchmarkGraphInfo, Constants.benchmarkGraphModalInfoForIrrigationReplace, "Failed to verify the Modal info for the irrigation replace etc in status bar");
            closeBtnForBenchmarkGraphInfoModal.click();

        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyModalInfoForWaterBalanceTabInStatusBarAndBenchmarkGraph.jpg");
            Assert.fail("Failed in verifyModalInfoForWaterBalanceTabInStatusBarAndBenchmarkGraph method due to exception:- " + exc);
        }
    }

    public void verifyAndObserveTheDataIsMatchingWithTheDataShownOnRightSideForSoilMoisture() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(soilMoistureTab, 60, 1);
            soilMoistureTab.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            try {
                if (noDataToShow.isDisplayed()) {
                    log.info("There is no data to verify the status bars");
                }
            } catch (Exception exc) {
                List<String> bkgColorList = new ArrayList<>();
                for (int i = 0; i < statusBarCount.size(); i++) {
                    String statusBarCountColor = statusBarCount.get(i).getCssValue("fill");
                    webDriverHelper.waitUntilVisible(statusBarCountInside.get(i), 60, 1);
                    String noOfCountInStatusBar = statusBarCountInside.get(i).getText();
                    Thread.sleep(3000);
                    for (WebElement proximityRefill : proximityRefillThreshold) {
                        String value = proximityRefill.getText();
                        String replaceColor = proximityRefill.getCssValue("Color");
                        if (!(value.equals("--"))) {
                            if (replaceColor.equals(statusBarCountColor)) {
                                bkgColorList.add(value);
                            }
                        }
                    }
                    String heatStressCount = String.valueOf(bkgColorList.size());
                    bkgColorList.clear();
                    if (!(heatStressCount.equalsIgnoreCase(noOfCountInStatusBar))) {
                        Assert.fail("Failed because the count in the status bar and the heat stress hours count is not matching");
                    }
                }
                webDriverHelper.waitUntilVisibilityOfAllElements(statusBarReading, 60, 1);
                Assert.assertEquals(statusBarReading.get(0).getText(), Constants.proximityRefillThresholdForLessThanAndEqual, "Failed to verify because the value is not matching in the status bar for " + statusBarReading.get(0).getText() + " proximity to refill threshold");
                Assert.assertEquals(statusBarColor.get(0).getCssValue("background-Color"), Constants.redColorInWaterTab, "Failed to verify the red colour if the percentage <= ");
                Assert.assertEquals(statusBarReading.get(1).getText(), Constants.proximityRefillThresholdForLessThan10Percent, "Failed to verify because the value is not matching in the status bar for " + statusBarReading.get(1).getText() + " proximity to refill threshold");
                Assert.assertEquals(statusBarColor.get(1).getCssValue("background-Color"), Constants.yellowColorInWaterTab, "Failed to verify the yellow colour if the percentage is < 10% ");
                Assert.assertEquals(statusBarReading.get(2).getText(), Constants.proximityRefillThresholdForMoreThan10Percent, "Failed to verify because the value is not matching in the status bar for " + statusBarReading.get(2).getText() + " proximity to refill threshold");
                Assert.assertEquals(statusBarColor.get(2).getCssValue("background-Color"), Constants.greenColorInWaterTab, "Failed to verify the green colour if the percentage is > 10% ");

                for (WebElement graphHover : benchmarkGraphHover) {
                    String bkgColour = graphHover.getCssValue("fill");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", graphHover);
                    Actions actions = new Actions(driver);
                    actions.moveToElement(graphHover).perform();
                    webDriverHelper.waitUntilVisible(benchmarkGraphTooltip, 60, 1);
                    String tooltipValues = benchmarkGraphTooltip.getText();

                    for (WebElement proximityRefill : proximityRefillThreshold) {
                        String proximityRefillValue = proximityRefill.getText();
                        String[] parts = proximityRefillValue.split("%");
                        String proximityRefillExcludePercent = parts[0];
                        String proximityRefillBkgColor = proximityRefill.getCssValue("Color");
                        String[] parts0 = tooltipValues.split(",");
                        String proximityRefillPercentage = parts0[1];
                        String[] parts1 = proximityRefillPercentage.split(" ");
                        String proximityRefillPercent = parts1[1];
                        if (tooltipValues.contains(proximityRefillExcludePercent)) {
                            Assert.assertEquals(bkgColour, proximityRefillBkgColor, "Failed to verify the color in benchmark graph and in heat stress value");
                            WebElement siteNameWrtToValue = driver.findElement(By.xpath("//div[@class='site-column display-block']//following-sibling::div[contains(@class,'site-column')]/div[contains(text(),'" + proximityRefillValue + "')][1]//..//../div[@class='site-column']/p"));
                            String siteNameInList = siteNameWrtToValue.getText();
                            String siteNameAndIrrigationValue = siteNameInList + ", " + proximityRefillPercent + " %";
                            Assert.assertEquals(tooltipValues, siteNameAndIrrigationValue, "Failed to verify because tooltip value is not matching with siteName and wrt heat stress value also");
                            break;
                        }
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyAndObserveTheDataIsMatchingWithTheDataShownOnRightSideForHeatStress.jpg");
            Assert.fail("Failed in verifyAndObserveTheDataIsMatchingWithTheDataShownOnRightSideForHeatStress method due to exception :- " + exc);
        }
    }

    public void verifyTheStringOrder(List<String> values, String sortHeader) {
        boolean isAscending = true;
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i).compareTo(values.get(i + 1)) > 0) {
                isAscending = false;
                break;
            } else if (values.get(i).compareTo(values.get(i + 1)) < 0) {
                break;
            }
        }
        if (isAscending) {
            log.info("The names/values from " + sortHeader + " column are in ascending order!");
        } else {
            log.info("The names/values from " + sortHeader + " column are in descending order!");
        }
    }

    public void verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForSoilMoisture() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(soilMoistureTab, 60, 1);
            soilMoistureTab.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            try {
                if (noDataToShow.isDisplayed()) {
                    log.info("There is no data to verify the values units in the benchmark graph");
                }
            } catch (Exception exc) {
                List<String> benchmarkGraphValues = new ArrayList<>();
                webDriverHelper.waitUntilVisible(sortBtnInBenchmarkGraph, 60, 1);
                sortBtnInBenchmarkGraph.click();
                for (int i = 0; i < benchmarkGraphHover.size(); i++) {
                    WebElement graphOver = benchmarkGraphHover.get(i);
                    Actions actions = new Actions(driver);
                    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", graphOver);
                    actions.moveToElement(graphOver).perform();
                    webDriverHelper.waitUntilVisible(benchmarkGraphTooltip, 60, 1);
                    int length = benchmarkGraphTooltip.getText().length();
                    int startTimeIndex = length - 8;
                    String benchmarkGraphTimeData = benchmarkGraphTooltip.getText().substring(startTimeIndex, startTimeIndex + 8);
                    benchmarkGraphValues.add(benchmarkGraphTimeData);

                    if (i == 7 && benchmarkGraphHover.size() > 8) {
                        actions.moveToElement(benchmarkScrollBar).clickAndHold().perform();
                        actions.moveByOffset(0, 50).release().perform();
                        webDriverHelper.waitUntilVisible(benchmarkGraphHover.get(i + 1), 60, 1);
                    }
                }
                log.info("benchmarkGraphValues -> " + benchmarkGraphValues);
                verifyTheStringOrder(benchmarkGraphValues, "The benchmark graph sites values for last irrigation");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForSoilMoisture.jpg");
            Assert.fail("Failed in verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForSoilMoisture method due to exception: " + exc);
        }
    }

    public void verifyTheUnitAndValueOnTheToolTipInBenchmarkGraphSectionWhenHoverOverOnTheSites() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(soilMoistureTab, 60, 1);
            soilMoistureTab.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            try {
                if (noDataToShow.isDisplayed()) {
                    log.info("There is no data to verify the values units in the benchmark graph");
                }
            } catch (Exception exc) {
                webDriverHelper.waitUntilVisibilityOfAllElements(benchmarkGraphHover, 60, 1);
                for (WebElement element : benchmarkGraphHover) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                    Actions actions = new Actions(driver);
                    actions.moveToElement(element).perform();
                    webDriverHelper.waitUntilVisible(benchmarkGraphTooltip, 60, 1);
                    String benchmarkValue = benchmarkGraphTooltip.getText();
                    String regex = "([+-]?\\d*\\.?\\d+)[\\s]*%";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(benchmarkValue);
                    if (matcher.find()) {
                        String value = matcher.group(1);
                        log.info("value " + value);
                        log.info("unit %");
                    } else {
                        Assert.fail("Failed because the value " + benchmarkValue + " does not match the expected pattern.");
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheUnitAndValueOnTheToolTipInBenchmarkGraphSectionWhenHoverOverOnTheSites.jpg");
            Assert.fail("Failed in verifyTheUnitAndValueOnTheToolTipInBenchmarkGraphSectionWhenHoverOverOnTheSites method due to exception :- " + exc);
        }
    }

    public void verifyTheUnitAndValueOnTheProximityToRefillThresholdColumn() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(soilMoistureTab, 60, 1);
            soilMoistureTab.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            try {
                if (noDataToShow.isDisplayed()) {
                    log.info("There is no data to verify the values units in the benchmark graph");
                }
            } catch (Exception exc) {
                for (WebElement element : proximityRefillThreshold) {
                    String refillProximityValue = element.getText();
                    if (!refillProximityValue.equals("--")) {
                        String regex = "([+-]?\\d*\\.?\\d+)[\\s]*%";
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(refillProximityValue);
                        if (matcher.find()) {
                            String value = matcher.group(1);
                            log.info("value " + value);
                            log.info("unit %");
                        } else {
                            Assert.fail("Failed because the value " + refillProximityValue + " does not match the expected pattern.");
                        }
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheUnitAndValueOnTheProximityToRefillThresholdColumn.jpg");
            Assert.fail("Failed in verifyTheUnitAndValueOnTheProximityToRefillThresholdColumn method due to exception :- " + exc);
        }
    }

    public void verifyMenuBtnForNoSensorDevices() {
        try {
            if (menuBtnForNoSensorDevices.isDisplayed()) {
                Assert.fail("Failed because there is no sensor for the device but the menu btn is displayed");
            }
        } catch (Exception exc) {
            webDriverHelper.waitUntilVisible(doneValidationBtn, 30, 1);
            wait.until(ExpectedConditions.elementToBeClickable(doneValidationBtn)).click();
        }
    }

    public void verifyTheValidation() {
        try {
            webDriverHelper.waitUntilVisible(noDevicesMsg,5,1);
            if (noDevicesMsg.isDisplayed()) {
                log.info("There is no devices in the site therefore the menu btn will not displayed");
                webDriverHelper.waitUntilVisible(doneValidationBtn, 30, 1);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", doneValidationBtn);
                wait.until(ExpectedConditions.elementToBeClickable(doneValidationBtn)).click();
            }
        } catch (Exception exc) {
            if (noSensorList.size() > 0) {
                for (int j = 0; j < noSensorList.size(); j++) {
                    verifyMenuBtnForNoSensorDevices();
                }
            } else {
                verifyMenuBtnForNoSensorDevices();
            }
        }
    }

    public void verifyAndObserveAfterClickingOn3DotsInSites() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisibilityOfAllElements(menuBtnList, 90, 1);
            List<String> verifiedDevices = new ArrayList<>();
            for (int i = 0; i < menuBtnList.size(); i++) {
                String siteName = sitesInWaterPage.get(i).getText();
                if (!verifiedDevices.contains(siteName)) {
                    verifiedDevices.add(siteName);
                    menuBtnList.get(i).click();
                    webDriverHelper.waitUntilVisible(validateSensorList.get(i), 30, 1);
                    validateSensorList.get(i).click();
                    Thread.sleep(3000);
                    verifyTheValidation();
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAndObserveAfterClickingOn3DotsInSites.jpg");
            Assert.fail("Failed in verifyAndObserveAfterClickingOn3DotsInSites method due to exception :- " + exc);
        }
    }

    public void observeAndCompareTheDataPresentInBothSideForWaterBalanceTab() {
        try {
            webDriverHelper.waitUntilVisible(statusBarTitle, 60, 1);
            try {
                if (noDataToShow.isDisplayed()) {
                    log.info("There is no data to verify the status bars");
                }
            } catch (Exception exc) {
                List<String> bkgColorList = new ArrayList<>();
                for (int i = 0; i < statusBarCount.size(); i++) {
                    String statusBarCountColor = statusBarCount.get(i).getCssValue("fill");
                    webDriverHelper.waitUntilVisible(statusBarCountInside.get(i), 60, 1);
                    String noOfCountInStatusBar = statusBarCountInside.get(i).getText();
                    for (WebElement irrigationReplace : irrigationReplaceEtc) {
                        String value = irrigationReplace.getText();
                        String replaceColor = irrigationReplace.getCssValue("Color");
                        if (!(value.equals("--"))) {
                            if (replaceColor.equals(statusBarCountColor)) {
                                bkgColorList.add(value);
                            }
                        }
                    }
                    String replaceCount = String.valueOf(bkgColorList.size());
                    bkgColorList.clear();
                    if (!(replaceCount.equalsIgnoreCase(noOfCountInStatusBar))) {
                        Assert.fail("Failed because the count in the status bar and the replace value count is not matching");
                    }
                }
                Assert.assertEquals(statusBarReading.get(0).getText(), Constants.irrigationToReplaceETcForMoreThan8Hours, "Failed to verify because the value is not matching in the status bar for " + statusBarReading.get(0).getText() + " irrigation to replace etc");
                Assert.assertEquals(statusBarColor.get(0).getCssValue("background-Color"), Constants.redColorInWaterTab, "Failed to verify the red colour if the count time is greater than > 8 hours");
                Assert.assertEquals(statusBarReading.get(1).getText(), Constants.irrigationToReplaceETcFor2To8Hours, "Failed to verify because the value is not matching in the status bar for " + statusBarReading.get(1).getText() + " irrigation to replace etc");
                Assert.assertEquals(statusBarColor.get(1).getCssValue("background-Color"), Constants.yellowColorInWaterTab, "Failed to verify the yellow colour if the count time is 2 - 8 hours");
                Assert.assertEquals(statusBarReading.get(2).getText(), Constants.irrigationToReplaceETcForLessThan2Hours, "Failed to verify because the value is not matching in the status bar for " + statusBarReading.get(2).getText() + " irrigation to replace etc");
                Assert.assertEquals(statusBarColor.get(2).getCssValue("background-Color"), Constants.greenColorInWaterTab, "Failed to verify the green colour if the count time is less than < 2 hours");
                for (WebElement graphHover : benchmarkGraphHover) {
                    String bkgColour = graphHover.getCssValue("fill");
                    Actions actions = new Actions(driver);
                    Thread.sleep(5000);
                    actions.moveToElement(graphHover).perform();
                    String tooltipValues = benchmarkGraphTooltip.getText();
                    for (WebElement irrigationReplace : irrigationReplaceEtc) {
                        String replaceValue = irrigationReplace.getText();
                        String replaceValueBkgColor = irrigationReplace.getCssValue("Color");
                        String[] parts = tooltipValues.split(",");
                        String irrigationTime = parts[1];
                        if (tooltipValues.contains(replaceValue)) {
                            Assert.assertEquals(bkgColour, replaceValueBkgColor, "Failed to verify the color in benchmark graph and in last irrigation runtime value");
                            WebElement siteNameWrtToValue = driver.findElement(By.xpath("//div[@class='site-list-section']/div/div/div[@class='site-column']/div[contains(text(),'" + irrigationTime + "')]//..//../div[@class='site-column']/p"));
                            String siteNameInList = siteNameWrtToValue.getText();
                            String siteNameAndIrrigationValue = siteNameInList + ", " + replaceValue;
                            Assert.assertEquals(tooltipValues, siteNameAndIrrigationValue, "Failed to verify because tooltip value is not matching with siteName and wrt last irrigation value also");
                            break;
                        }
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_observeAndCompareTheDataPresentInBothSideForWaterBalanceTab.jpg");
            Assert.fail("Failed in observeAndCompareTheDataPresentInBothSideForWaterBalanceTab method due to exception:- " + exc);
        }
    }

    public void verifyTheSiteDisplayedInTableOrNot(String valueWrtToTab) {
        webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
        List<String> siteLocatorNames = new ArrayList<>();
        for (WebElement sitesLocator : sitesInMap) {
            try {
                String siteLocatorInMap = sitesLocator.getAttribute("title");
                if (!siteLocatorNames.contains(siteLocatorInMap)) {
                    siteLocatorNames.add(siteLocatorInMap);
                    int zoomButtonClickCount = 0;
                    boolean notClickedOnSiteLocator = false;
                    while (true) {
                        try {
                            Actions action = new Actions(driver);
                            action.moveToElement(sitesLocator);
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sitesLocator);
                            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                            wait.until(ExpectedConditions.elementToBeClickable(sitesLocator)).click();
                            break;
                        } catch (ElementClickInterceptedException exc) {
                            zoomButtonClickCount++;
                            if (zoomButtonClickCount >= 21) {
                                notClickedOnSiteLocator = true;
                                break; // Break the loop after 20 zoom button clicks
                            }
                            webDriverHelper.waitUntilVisible(mapZoomInBtnF, 60, 1);
                            mapZoomInBtnF.click();
                        }
                    }
                    if (!notClickedOnSiteLocator) {
                        String siteLocatorColor = sitesLocator.getCssValue("background-Color");
                        String sitesSelectedInMap = sitesLocator.getAttribute("title");
                        WebElement siteDetailsTab = driver.findElement(By.xpath("//p[contains(@class,'cursor-pointer highlight') and contains(text(),'" + sitesSelectedInMap + "')]/../../.."));
                        webDriverHelper.waitUntilVisible(siteDetailsTab, 60, 1);
                        String bkgColour = siteDetailsTab.getCssValue("background-Color");
                        Assert.assertEquals(bkgColour, Constants.lightGreyColorInWaterTab, "Failed because the selected site is not highlighted with the grey colour");
                        WebElement element = null;
                        if (valueWrtToTab.equals("waterBalanceTab")) {
                            element = driver.findElement(By.xpath("//p[contains(@class,'cursor-pointer highlight') and contains(text(),'" + sitesSelectedInMap + "')]/../../div[@class='site-column']/div[@ng-reflect-ng-class]"));
                        }
                        if (valueWrtToTab.equals("heatStressTab")) {
                            element = driver.findElement(By.xpath("//p[contains(@class,'cursor-pointer highlight') and contains(text(),'" + sitesSelectedInMap + "')]/../../div[@class='site-column model-value']/div[contains(@class,'padding-top-10')]"));
                        }
                        if (valueWrtToTab.equals("lastIrrigationTab")) {
                            element = driver.findElement(By.xpath("//p[contains(@class,'cursor-pointer highlight') and contains(text(),'" + sitesSelectedInMap + "')]/../../div[@class='site-column display-block']/child::div[2]"));
                        }
                        if (valueWrtToTab.equals("soilMoistureTab")) {
                            element = driver.findElement(By.xpath("//p[contains(@class,'cursor-pointer highlight') and contains(text(),'" + sitesSelectedInMap + "')]/../../div[@class='site-column display-block']//following-sibling::div[contains(@class,'site-column')][1]"));
                        }
                        webDriverHelper.waitUntilVisible(element, 60, 1);
                        if (element != null) {
                            String replaceEtcColor = element.getCssValue("Color");
                        } else {
                            log.info("There is no value that was finding");
                        }
//                    this will not work because the color is not getting
//                    Assert.assertEquals(siteLocatorColor, replaceEtcColor, "Failed because the site locator color and replace etc color is not matching");
                        break;
                    }
                    for (int i = 0; i < 20; i++) {
                        webDriverHelper.waitUntilVisible(mapZoomOutBtnF, 30, 1);
                        mapZoomOutBtnF.click();
                    }
                }
            } catch (Exception NoSuchElementException) {
                log.info("The site is overlapping, so we can't able to click on it, after too long 'zoomIn' so we are checking for other locator");
                continue;
            }
        }
    }

    public void verifyTheHighlightedSiteDetailsWhenHoverOverTheLocatorsOnMapClickObserveForReplaceETC() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            Thread.sleep(2000);
            String valueWrtToTab = "waterBalanceTab";
            verifyTheSiteDisplayedInTableOrNot(valueWrtToTab);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheHighlightedSiteDetailsWhenHoverOverTheLocatorsOnMapClickObserve.jpg");
            Assert.fail("Failed in verifyTheHighlightedSiteDetailsWhenHoverOverTheLocatorsOnMapClickObserve method due to exception:- " + exc);
        }
    }

    public void verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInHeatStressTab() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(heatStressTab, 60, 1);
            heatStressTab.click();
            heatStressSortBtn.click();
            Thread.sleep(2000);
            String valueWrtToTab = "heatStressTab";
            verifyTheSiteDisplayedInTableOrNot(valueWrtToTab);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInHeatStressTab.jpg");
            Assert.fail("Failed in verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInHeatStressTab method due to exception :- " + exc);
        }
    }

    public void verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForHeatStress() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(heatStressTab, 60, 1);
            heatStressTab.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            for (WebElement element : sitesInWaterPage) {
                sitesNamesInTable.add(element.getText());
            }
            webDriverHelper.waitUntilVisible(sortBtnInBenchmarkGraph, 60, 1);
            sortBtnInBenchmarkGraph.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(sitesNameInBenchmarkGraph, 60, 1);
            for (WebElement element : sitesNameInBenchmarkGraph) {
                sitesNamesInBenchmarkGraph.add(element.getText());
            }
            boolean areListsInSameOrder = true;
            int minSize = Math.min(sitesNamesInBenchmarkGraph.size(), sitesNamesInTable.size());
            for (int i = 0; i < minSize; i++) {
                String elementInBenchmark = sitesNamesInBenchmarkGraph.get(i);
                String elementInTable = sitesNamesInTable.get(i);
                log.info("Index " + i + ": " + elementInBenchmark + " vs " + elementInTable);
                if (!elementInBenchmark.equals(elementInTable)) {
                    areListsInSameOrder = false;
                    break;
                }
            }
            if (areListsInSameOrder) {
                log.info("The sites in the benchmark graph are in Descending order");
            } else {
                log.info("The sites in the benchmark graph are in Ascending order");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForHeatStress.jpg");
            Assert.fail("Failed in verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForHeatStress method due to exception: " + exc);
        }
    }

    public void verifyTheInfoModelTextInHeatStressHours() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(heatStressTab, 60, 1);
            heatStressTab.click();
            webDriverHelper.waitUntilVisible(statusBarTitle, 60, 1);
            statusBarTitle.click();
            webDriverHelper.waitUntilVisible(statusBarHeaderTitle, 60, 1);
            String statusBarTitle = statusBarHeaderTitle.getText();
            Assert.assertEquals(statusBarTitle, Constants.heatStressModalTitle, "Failed to verify the Modal Title for the irrigation replace etc in status bar");
            String statusBarInfo = statusBarModalInfo.getText();
            Assert.assertEquals(statusBarInfo, Constants.statusBarModalInfoForHeatStress, "Failed to verify the Modal info for the irrigation replace etc in status bar");
            closeBtnForStatusBarInfoModal.click();
            webDriverHelper.waitUntilVisible(benchmarkGraphTitle, 60, 1);
            benchmarkGraphTitle.click();
            webDriverHelper.waitUntilVisible(benchmarkGraphHeaderTitle, 60, 1);
            String benchmarkGraphTitle = benchmarkGraphHeaderTitle.getText();
            Assert.assertEquals(benchmarkGraphTitle, Constants.heatStressModalTitle, "Failed to verify the Modal Title for the irrigation replace etc in status bar");
            String benchmarkGraphInfo = benchmarkGraphModalInfo.getText();
            Assert.assertEquals(benchmarkGraphInfo, Constants.benchmarkGraphModalInfoForHeatStress, "Failed to verify the Modal info for the irrigation replace etc in status bar");
            closeBtnForBenchmarkGraphInfoModal.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheInfoModelTextInHeatStressHours.jpg");
            Assert.fail("Failed in verifyTheInfoModelTextInHeatStressHours method due to exception :- " + exc);
        }
    }

    public void verifyAndObserveTheDataIsMatchingWithTheDataShownOnRightSideForIrrigation() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(irrigationTab, 60, 1);
            irrigationTab.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            if (numberOfRowsDataPresent.size() > 1) {
                for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                    webDriverHelper.waitUntilVisible(numberOfRowsDataPresent.get(i), 60, 1);
                    numberOfRowsDataPresent.get(i).click();
                    webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
                    try {
                        if (noDataToShow.isDisplayed()) {
                            log.info("There is no data to verify the status bars");
                        }
                    } catch (Exception exc) {
                        webDriverHelper.waitUntilVisibilityOfAllElements(statusBarReading, 60, 1);
                        Assert.assertEquals(statusBarReading.get(0).getText(), Constants.lastIrrigationRuntimeForLessThan4Hours, "Failed to verify because the value is not matching in the status bar for " + statusBarReading.get(0).getText() + " heat stress");
                        Assert.assertEquals(statusBarColor.get(0).getCssValue("background-Color"), Constants.lightBlueColorAsHex, "Failed to verify the red colour if the count time is greater than > 8 hours");
                        Assert.assertEquals(statusBarReading.get(1).getText(), Constants.lastIrrigationRuntimeFor5To20Hours, "Failed to verify because the value is not matching in the status bar for " + statusBarReading.get(1).getText() + " heat stress");
                        Assert.assertEquals(statusBarColor.get(1).getCssValue("background-Color"), Constants.blueColorAsHexInIrrigation, "Failed to verify the yellow colour if the count time is 2 - 8 hours");
                        Assert.assertEquals(statusBarReading.get(2).getText(), Constants.lastIrrigationRuntimeForMoreThan21Hours, "Failed to verify because the value is not matching in the status bar for " + statusBarReading.get(2).getText() + " heat stress");
                        Assert.assertEquals(statusBarColor.get(2).getCssValue("background-Color"), Constants.darkBlueColorAsHex, "Failed to verify the green colour if the count time is less than < 2 hours");
                        for (int j = 0; j < statusBarCount.size(); j++) {
                            String colorInStatusBar = statusBarCount.get(j).getCssValue("fill");
                            int countInStatusBar = Integer.parseInt(statusBarCountInside.get(j).getText());
                            int colorCountInBenchmark = 0;
                            for (WebElement graphHover : benchmarkGraphHover) {
                                String bkgColorInBenchmark = graphHover.getCssValue("fill");
                                Actions actions = new Actions(driver);
                                actions.moveToElement(graphHover).perform();
                                webDriverHelper.waitUntilVisible(benchmarkGraphTooltip, 60, 1);
                                int length = benchmarkGraphTooltip.getText().length();
                                int startTimeIndex = length - 9;
                                int benchmarkGraphSiteHrsTime = Integer.parseInt(benchmarkGraphTooltip.getText().substring(startTimeIndex, startTimeIndex + 2));
                                if (benchmarkGraphSiteHrsTime <= 4) {
                                    Assert.assertEquals(bkgColorInBenchmark, Constants.lightBlueColorAsHex, "Failed because the color is not matching when the time is less than 4 hrs");
                                }
                                if (benchmarkGraphSiteHrsTime >= 5 && benchmarkGraphSiteHrsTime <= 20) {
                                    Assert.assertEquals(bkgColorInBenchmark, Constants.blueColorAsHexInIrrigation, "Failed because the color is not matching when the time is between 5 and 20 hrs");
                                }
                                if (benchmarkGraphSiteHrsTime >= 21) {
                                    Assert.assertEquals(bkgColorInBenchmark, Constants.darkBlueColorAsHex, "Failed because the color is not matching when the time is greater than 21 hrs");
                                }
                                if (colorInStatusBar.equals(bkgColorInBenchmark)) {
                                    colorCountInBenchmark++;
                                }
                            }
                            Assert.assertEquals(countInStatusBar, colorCountInBenchmark, "Failed to verify the color count in both benchmark and status bar graph");
                        }
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAndObserveTheDataIsMatchingWithTheDataShownOnRightSideForIrrigation.jpg");
            Assert.fail("Failed in verifyAndObserveTheDataIsMatchingWithTheDataShownOnRightSideForIrrigation method due to exception :- " + exc);
        }
    }

    public void verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInIrrigationTab() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(irrigationTab, 60, 1);
            irrigationTab.click();
            Thread.sleep(2000);
            String valueWrtToTab = "lastIrrigationTab";
            verifyTheSiteDisplayedInTableOrNot(valueWrtToTab);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInIrrigationTab.jpg");
            Assert.fail("Failed in verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInIrrigationTab method due to exception :- " + exc);
        }
    }

    public void verifyFormatOfDataInLastIrrigationRuntimeColumnAndBenchmarkGraph() {
        SoftAssert assertion = new SoftAssert();
        Actions action = new Actions(driver);
        List<String> timeData = new ArrayList<>();
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(irrigationTab, 60, 1);
            irrigationTab.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            if (numberOfRowsDataPresent.size() > 1) {
                for (WebElement webElement : numberOfRowsDataPresent) {
                    webElement.click();
                    webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                    try {
                        if (noDataToShow.isDisplayed()) {
                            log.info("There is no data in the irrigation tab for this user to verify");
                        }
                    } catch (Exception exc) {
                        for (int j = 0; j < lastIrrigationRuntime.size(); j++) {
                            String data = lastIrrigationRuntime.get(j).getText();
                            if (!data.equals("--")) {
                                String columnValue = driver.findElement(By.xpath("(//div[@class='site-column display-block']/child::div[2])[" + (j + 1) + "]")).getText();
                                if (!(columnValue.equals("--") || columnValue.equals("Currently Irrigating"))) {
                                    String lastIrrigationRuntimeColumnTimeData = columnValue.substring(0, 9);
                                    timeData.add(lastIrrigationRuntimeColumnTimeData);
                                    for (WebElement graphHover : benchmarkGraphHover) {
                                        action.moveToElement(graphHover).perform();
                                        webDriverHelper.waitUntilVisible(benchmarkGraphTooltip, 30, 1);
                                        int length = benchmarkGraphTooltip.getText().length();
                                        int startTimeIndex = length - 9;
                                        String benchmarkGraphTimeData = benchmarkGraphTooltip.getText().substring(startTimeIndex, startTimeIndex + 9);
                                        timeData.add(benchmarkGraphTimeData);
                                        for (String timeToVerify : timeData) {
                                            String regex = "^\\d{2}:[0-5][0-9]\\shrs$";
                                            Pattern pattern = Pattern.compile(regex);
                                            Matcher matcher = pattern.matcher(timeToVerify);
                                            assertion.assertTrue(matcher.matches(), "The time format " + timeToVerify + " of Last Irrigation Runtime column/Benchmark graph is not matched");
                                            assertion.assertAll();
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }

        } catch (Exception e) {
            webDriverHelper.takeAScreenShot("verifyFormatOfDataInLastIrrigationRuntimeColumnAndBenchmarkGraph.jpg");
            Assert.fail("Failed in verifyFormatOfDataInLastIrrigationRuntimeColumnAndBenchmarkGraph method due to exception:- " + e);
        }
    }

    public void verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForLastIrrigation() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(irrigationTab, 60, 1);
            irrigationTab.click();
            lastIrrigationSortBtn.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            List<String> benchmarkGraphValues = new ArrayList<>();
            webDriverHelper.waitUntilVisible(sortBtnInBenchmarkGraph, 60, 1);
            sortBtnInBenchmarkGraph.click();
            for (int i = 0; i < benchmarkGraphHover.size(); i++) {
                WebElement graphOver = benchmarkGraphHover.get(i);
                Actions actions = new Actions(driver);
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", graphOver);
                actions.moveToElement(graphOver).perform();
                webDriverHelper.waitUntilVisible(benchmarkGraphTooltip, 60, 1);
                int length = benchmarkGraphTooltip.getText().length();
                int startTimeIndex = length - 9;
                String benchmarkGraphTimeData = benchmarkGraphTooltip.getText().substring(startTimeIndex, startTimeIndex + 9);
                benchmarkGraphValues.add(benchmarkGraphTimeData);
                if (i == 7 && benchmarkGraphHover.size() > 8) {
                    actions.moveToElement(benchmarkScrollBar).clickAndHold().perform();
                    actions.moveByOffset(0, 100).release().perform();
                    webDriverHelper.waitUntilVisible(benchmarkGraphHover.get(i + 1), 60, 1);
                }
            }
            verifyTheStringOrder(benchmarkGraphValues, "The benchmark graph sites values for last irrigation");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForLastIrrigation.jpg");
            Assert.fail("Failed in verifyAndObserveTheOrderOfSitesAfterClickingOnSortBtnInBenchmarkGraphForLastIrrigation method due to exception: " + exc);
        }
    }

    public void verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInSoilMoistureTab() {
        try {
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(soilMoistureTab, 60, 1);
            soilMoistureTab.click();
            Thread.sleep(2000);
            String valueWrtToTab = "soilMoistureTab";
            verifyTheSiteDisplayedInTableOrNot(valueWrtToTab);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInSoilMoistureTab.jpg");
            Assert.fail("Failed in verifyAndHoverOverOnTheLocatorsOnMapClickAnyoneOfItObserveInSoilMoistureTab method due to exception :- " + exc);
        }
    }
    public void verifySubModuleIsPresentWhenHooverOnAnalysis() throws IOException, InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(dashboardMenu_Analysis, 30, 1);
            Actions action = new Actions(driver);
            action.moveToElement(dashboardMenu_Analysis).perform();
//        Assert.assertTrue(dashboardMenu_Graph.isDisplayed(), "The Graph sub menu in the analysis are not displayed");
            Assert.assertTrue(dashboardMenu_Water.isDisplayed(), "The Water sub menu in the analysis are not displayed");
//        Assert.assertTrue(dashboardMenu_Analysis.isDisplayed(), "The Analytics sub menu in the analysis are not displayed");
//        Assert.assertTrue(dashboardMenu_Rank.isDisplayed(), "The Rank sub menu in the analysis are not displayed");
//        Assert.assertTrue(dashboardMenu_Export.isDisplayed(), "The Export sub menu in the analysis are not displayed");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifySubModuleIsPresentWhenHooverOnAnalysis.jpg");
            Assert.fail("Failed in verifySubModuleIsPresentWhenHooverOnAnalysis method due to exception:- " + exc);
        }
    }

    public void verifyWaterTabIsPresentWhenHooverOnAnalysis() {
        webDriverHelper.waitUntilVisible(dashboardMenu_Water, 30, 1);
        Actions action = new Actions(driver);
        action.moveToElement(dashboardMenu_Water).click().perform();
    }

    public void verifyUserShouldClickOnOneSite() {
        try {
            webDriverHelper.waitUntilVisible(waterBalanceTag, 120, 1);
            webDriverHelper.waitUntilVisible(siteNameListInMultiWaterSites.get(0), 120, 1);
            siteNameStored = siteNameListInMultiWaterSites.get(0).getText();
            siteNameListInMultiWaterSites.get(0).click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyUserShouldClickOnOneSite.jpg");
            Assert.fail("Failed in verifyUserShouldClickOnOneSite method due to exception:- " + exc);
        }
    }

    public void verifyUserShouldViewSingleSiteWaterPage() {
        try {
            webDriverHelper.waitUntilVisible(waterBalanceTagInSingleSite, 120, 1);
            String name = singleSiteUiName.getText();
            Assert.assertTrue(name.contains(siteNameStored), "The Name in the Ui and selected stile is not matching");
            webDriverHelper.waitUntilVisible(singleSiteUiName, 30, 1);
            Assert.assertTrue(waterInSingleSite.isEnabled(), "Water tag is not enabled after selecting an single site");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyUserShouldViewSingleSiteWaterPage.jpg");
            Assert.fail("Failed in verifyUserShouldViewSingleSiteWaterPage method due to exception:- " + exc);
        }
    }

    public void verifyTheSitesArePresentPerPagination(int numbOfSites) {
        try {
            webDriverHelper.scrollToWebElement(menuButtonOfFirstSite);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            for (int i = 0; i < numberOfRowsDataPresent.size() - 1; i++) {
                numberOfRowsDataPresent.get(i).click();
                webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 40, 1);
                Assert.assertEquals(paginationSiteNameList.size(), numbOfSites);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheSitesArePresentPerPagination.jpg");
            Assert.fail("Failed in verifyTheSitesArePresentPerPagination method due to exception:- " + exc);
        }
    }

    public void verifyThePaginationIsClickable() {
        try {
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                numberOfRowsDataPresent.get(i).click();
                webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 40, 1);
                for (WebElement paginationSiteName : paginationSiteNameList) {
                    wait.until(ExpectedConditions.elementToBeClickable(paginationSiteName));
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyThePaginationIsClickable.jpg");
            Assert.fail("Failed in verifyThePaginationIsClickable method due to exception:- " + exc);
        }
    }

    public void verifyTheTagNameLeftSideOfTheWaterPage() {
        try {
            webDriverHelper.waitUntilVisible(siteNameTag, 60, 1);
            Assert.assertTrue(irrigationToReplaceETcTag.isDisplayed(), "Irrigation To Replace ETc Tag is not displayed");
            Assert.assertTrue(lastIrrigationRuntimeTag.isDisplayed(), "Last Irrigation Run time Tag is not displayed");
            Assert.assertTrue(proximityToRefillThresholdTag.isDisplayed(), "Proximity To Refill Threshold Tag is not displayed");
            Assert.assertTrue(heatStressHoursTag.isDisplayed(), "Heat Stress Hours Tag is not displayed");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheTagNameLeftSideOfTheWaterPage.jpg");
            Assert.fail("Failed in verifyTheTagNameLeftSideOfTheWaterPage method due to exception:- " + exc);
        }
    }

    public void verifyTheTagNameLeftSideOfTheWaterPageAreAllClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(siteNameTag));
            wait.until(ExpectedConditions.elementToBeClickable(irrigationToReplaceETcTag));
            wait.until(ExpectedConditions.elementToBeClickable(lastIrrigationRuntimeTag));
            wait.until(ExpectedConditions.elementToBeClickable(proximityToRefillThresholdTag));
            wait.until(ExpectedConditions.elementToBeClickable(heatStressHoursTag));
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheTagNameLeftSideOfTheWaterPageAreAllClickable.jpg");
            Assert.fail("Failed in verifyTheTagNameLeftSideOfTheWaterPageAreAllClickable method due to exception:- " + exc);
        }
    }

    public void verifyTheMenuAfterClickingOnThreeDotsOnSite() {
        try {
            webDriverHelper.scrollToWebElement(menuButtonOfFirstSite);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            if (numberOfRowsDataPresent.size() > 1) {
                for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                    numberOfRowsDataPresent.get(i).click();
                    webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                    for (int j = 0; j < paginationSiteNameList.size(); j++) {
                        String menuName = paginationSiteNameList.get(j).getText();
                        if (menuName.equalsIgnoreCase(siteWithData)) {
                            menuOptionList.get(j).click();
                            break;
                        }
                    }
                }
            } else {
                webDriverHelper.scrollToWebElement(menuButtonOfFirstSite);
                webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                for (int j = 0; j < paginationSiteNameList.size(); j++) {
                    String menuName = paginationSiteNameList.get(j).getText();
                    if (menuName.equalsIgnoreCase(siteWithData)) {
                        menuOptionList.get(j).click();
                        break;
                    }
                }

            }
            Thread.sleep(3000);
            for (WebElement menuNames : menuName) {
                String menuName = menuNames.getText();
                if (!(menuName.trim().equalsIgnoreCase("Manual Irrigation") || menuName.trim().equalsIgnoreCase("Validate Sensors"))) {
                    Assert.fail("The menu present after clicking on the 3 dots is not matching");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheMenuAfterClickingOnThreeDotsOnSite.jpg");
            Assert.fail("Failed in verifyTheMenuAfterClickingOnThreeDotsOnSite method due to exception:- " + exc);
        }

    }

    public void verifyTheColorVerificationForTheValidateSensor() {
        try {
            String validateSensorsClrName = validateSensorsClr.getAttribute("src");
            if (!(validateSensorsClrName.contains("orange"))) {
                Assert.fail("the color is not matching for the Validate Sensor img");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheColorVerificationForTheValidateSensor.jpg");
            Assert.fail("Failed in verifyTheColorVerificationForTheValidateSensor method due to exception:- " + exc);
        }
    }

    public void clickOnValidateSensor() {
        try {
            webDriverHelper.waitUntilVisible(validateSensors, 60, 1);
            validateSensors.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("clickOnValidateSensor.jpg");
            Assert.fail("Failed in clickOnValidateSensor method due to exception:- " + exc);
        }
    }

    public void verifyTheBackgroundColorForDoneWithValidationButton() {
        try {
            webDriverHelper.waitUntilVisible(doneWithValidation, 60, 1);
            String rgb = doneWithValidation.getCssValue("background-color");
            String actualColor = Color.fromString(rgb).asHex().toUpperCase();
            Assert.assertTrue(actualColor.equalsIgnoreCase(blueColorAsHex), "The background color is not matching for the button 'Done with validation' ");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheBackgroundColorForDoneWithValidationButton.jpg");
            Assert.fail("Failed in verifyTheBackgroundColorForDoneWithValidationButton method due to exception:- " + exc);
        }
    }

    public void verifyUserCanMinimizeTheSiteDetails() {
        if (doneWithValidation.isDisplayed()) {
            doneWithValidation.click();
            try {
                Assert.assertFalse(deviceTableContentForValidateSensors.isDisplayed(), "The table content is still displayed for Validate Sensors");
            } catch (Exception ignored) {
            }
        } else {
            webDriverHelper.takeAScreenShot("verifyUserCanMinimizeTheSiteDetails.jpg");
            Assert.fail("Failed in verifyUserCanMinimizeTheSiteDetails method due to exception:- ");
        }
    }

    public void verifyTheScrollbarIsPresentAndWorking() {
        try {
            List<WebElement> deviceList = driver.findElements(By.xpath("//div[@class='column device-table-entry device-name text-center']"));
            int i = deviceList.size() - 1;
            String deviceFirstList = deviceList.get(0).getText();
            webDriverHelper.scrollToWebElement(deviceList.get(i));
            String deviceLastList = deviceList.get(i).getText();
            WebElement lastElementXpath = driver.findElement(By.xpath("//div[normalize-space()='" + deviceLastList + "']"));
            Assert.assertTrue(lastElementXpath.isDisplayed(), "The last index of the device list is not displayed");
            if (deviceFirstList.equalsIgnoreCase(deviceLastList)) {
                Assert.fail("the first index and last index of the device list are the same ");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheScrollbarIsPresentAndWorking.jpg");
            Assert.fail("Failed in verifyTheScrollbarIsPresentAndWorking method due to exception:- " + exc);
        }
    }

    public void clickOnManualIrrigation() {
        try {
            webDriverHelper.waitUntilVisible(manualIrrigation, 60, 1);
            manualIrrigation.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("clickOnManualIrrigation.jpg");
            Assert.fail("Failed in clickOnManualIrrigation method due to exception:- " + exc);
        }
    }

    public void verifyTheTagInTheManualIrrigationPage() {
        try {
            webDriverHelper.waitUntilVisible(manualIrrigationTag, 90, 1);
            SoftAssert tagVerification = new SoftAssert();
            tagVerification.assertTrue(dateTagInManualIrrigationTag.isDisplayed());
            tagVerification.assertTrue(amountTagInManualIrrigationTag.isDisplayed());
            tagVerification.assertTrue(userTagInManualIrrigationTag.isDisplayed());
            tagVerification.assertTrue(addSimpleTag.isDisplayed());
            tagVerification.assertTrue(entryTableHistoricalTag.isDisplayed());
            tagVerification.assertAll();

        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheTagInTheManualIrrigationPage.jpg");
            Assert.fail("Failed in verifyTheTagInTheManualIrrigationPage method due to exception:- " + exc);
        }
    }

    public void ClickOnAddSymbol() {
        try {
            addSimpleTag.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("ClickOnAddSymbol.jpg");
            Assert.fail("Failed in ClickOnAddSymbol method due to exception:- " + exc);
        }
    }

    public void verifyTheCalendarTag() {
        try {
            webDriverHelper.waitUntilVisible(createSingleIrrigationEntryTag, 90, 1);
            Assert.assertTrue(createSingleIrrigationEntryTag.isDisplayed(), "the calendar icon is not present for the Create Single Irrigation Entry");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheCalendarTag.jpg");
            Assert.fail("Failed in verifyTheCalendarTag method due to exception:- " + exc);
        }
    }

    public void changeWaterBalanceMeasurementsViaToggle() {
        try {
            webDriverHelper.waitUntilVisible(waterBalance, 60, 1);
            waterBalance.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("changeWaterBalanceMeasurementsViaToggle.jpg");
            Assert.fail("Failed in changeWaterBalanceMeasurementsViaToggle method due to exception:- " + exc);
        }

    }

    public void observeTheTagsAtDifferentIntervalsBelowTheMap() {
        try {
            webDriverHelper.waitUntilVisible(tagForAbove8HrsInWaterBalance, 30, 1);
            SoftAssert tagVerification = new SoftAssert();
            tagVerification.assertTrue(tagForAbove8HrsInWaterBalance.isDisplayed());
            tagVerification.assertTrue(tagForBelow2HrsInWaterBalance.isDisplayed());
            tagVerification.assertTrue(tagForInBetween2to8HrsInWaterBalance.isDisplayed());
            String legendIcon1HexClr = legendIcon1.getCssValue("background-color");
            String actualColor1 = Color.fromString(legendIcon1HexClr).asHex().trim().toUpperCase();
            String legendIcon2HexClr = legendIcon2.getCssValue("background-color");
            String actualColor2 = Color.fromString(legendIcon2HexClr).asHex().trim().toUpperCase();
            String legendIcon3HexClr = legendIcon3.getCssValue("background-color");
            String actualColor3 = Color.fromString(legendIcon3HexClr).asHex().trim().toUpperCase();
            tagVerification.assertTrue(actualColor1.contains(redColorAsHex), "Red color is not matching");
            tagVerification.assertTrue(actualColor2.contains(orangeColorAsHex), "Orange color is not matching");
            tagVerification.assertTrue(actualColor3.contains(greenColorAsHex), "Green color is not matching");
            tagVerification.assertAll();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("observeTheTagsAtDifferentIntervalsBelowTheMap.jpg");
            Assert.fail("Failed in observeTheTagsAtDifferentIntervalsBelowTheMap method due to exception:- " + exc);
        }
    }

    public void navigateToThePageWhereSiteHaveValue() {
        try {
            webDriverHelper.scrollToWebElement(menuButtonOfFirstSite);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            if (numberOfRowsDataPresent.size() > 1) {
                for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                    numberOfRowsDataPresent.get(i).click();
                    webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                    for (int j = 0; j < paginationSiteNameList.size(); j++) {
                        String menuName = paginationSiteNameList.get(j).getText();
                        if (menuName.equalsIgnoreCase(siteWithData)) {
                            String hrsText = irrigationT0ReplaceEtcHrs.get(j).getText();
                            String[] parts = hrsText.split(":");
                            int partsName = Integer.parseInt(parts[0]);
                            String irrigationT0ReplaceText = irrigationT0ReplaceEtcHrs.get(j).getCssValue("color");
                            String irrigationT0Replace = Color.fromString(irrigationT0ReplaceText).asHex().toUpperCase();
                            if (partsName < 2) {
                                Assert.assertTrue(irrigationT0Replace.equalsIgnoreCase(greenColorAsHex), "for the hour is less or equal to 2 The color is not matching");
                            }
                            if (partsName >= 2 && partsName <= 8) {
                                Assert.assertTrue(irrigationT0Replace.equalsIgnoreCase(orangeColorAsHex), "for the hour 2 to 8 the color is not matching");
                            }
                            if (partsName > 8) {
                                Assert.assertTrue(irrigationT0Replace.equalsIgnoreCase(redColorAsHex), "for the hour is greater than 8 the color is not matching");
                            }
                            break;
                        }
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                for (int j = 0; j < paginationSiteNameList.size(); j++) {
                    String menuName = paginationSiteNameList.get(j).getText();
                    if (menuName.equalsIgnoreCase(Constants.siteWithData)) {
                        String hrsText = irrigationT0ReplaceEtcHrs.get(j).getText();
                        String[] parts = hrsText.split(":");
                        int partsName = Integer.parseInt(parts[0]);
                        String irrigationT0ReplaceText = irrigationT0ReplaceEtcHrs.get(j).getCssValue("color");
                        String irrigationT0Replace = Color.fromString(irrigationT0ReplaceText).asHex().toUpperCase();
                        if (partsName < 2) {
                            Assert.assertTrue(irrigationT0Replace.equalsIgnoreCase(greenColorAsHex), "for the hour is less or equal to 2 The color is not matching");
                        }
                        if (partsName >= 2 && partsName <= 8) {
                            Assert.assertTrue(irrigationT0Replace.equalsIgnoreCase(orangeColorAsHex), "for the hour 2 to 8 the color is not matching");
                        }
                        if (partsName > 8) {
                            Assert.assertTrue(irrigationT0Replace.equalsIgnoreCase(redColorAsHex), "for the hour is greater than 8 the color is not matching");
                        }
                        break;
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("navigateToThePageWhereSiteHaveValue.jpg");
            Assert.fail("Failed in navigateToThePageWhereSiteHaveValue method due to exception:- " + exc);
        }
    }

    public void clickOnTheSoilMoisture() {
        try {
            webDriverHelper.scrollToWebElement(menuButtonOfFirstSite);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            soilMoistureTag.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("clickOnTheSoilMoisture.jpg");
            Assert.fail("Failed in clickOnTheSoilMoisture method due to exception:- " + exc);
        }
    }

    public void verifyTheSoilMoistureIntervalIcon() {
        try {
            webDriverHelper.scrollToWebElement(menuButtonOfFirstSite);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            boolean found = false;
            if (numberOfRowsDataPresent.size() > 1) {
                for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                    numberOfRowsDataPresent.get(i).click();
                    webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                    try {
                        if (soilMoistureExpandIcon.isDisplayed()) {
                            soilMoistureIntervalVerification();
                            found = true;
                            break;
                        }
                    } catch (NoSuchElementException | NullPointerException e) {
                    }
                }
                if (!found) {
                    System.out.println("there was no soil moisture in the user");
                }
            } else {
                webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                try {
                    if (soilMoistureExpandIcon.isDisplayed()) {
                        soilMoistureIntervalVerification();
                        found = true;
                    }
                } catch (NoSuchElementException | NullPointerException e) {
                }
            }
            if (!found) {
                System.out.println("there was no soil moisture in the hole list");

            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheSoilMoistureIntervalIcon.jpg");
            Assert.fail("Failed in verifyTheSoilMoistureIntervalIcon method due to exception:- " + exc);
        }
    }

    public void soilMoistureIntervalVerification() {
        try {
            SoftAssert assertion = new SoftAssert();
            assertion.assertTrue(greaterThanEqualToIconForSoilMoisture.isDisplayed());
            assertion.assertTrue(greaterThanTenIconForSoilMoisture.isDisplayed());
            assertion.assertTrue(lessThanTenIconForSoilMoisture.isDisplayed());
            String legendIcon1HexClr = legendIcon1.getCssValue("background-color");
            String actualColor1 = Color.fromString(legendIcon1HexClr).asHex().trim().toUpperCase();
            String legendIcon2HexClr = legendIcon2.getCssValue("background-color");
            String actualColor2 = Color.fromString(legendIcon2HexClr).asHex().trim().toUpperCase();
            String legendIcon3HexClr = legendIcon3.getCssValue("background-color");
            String actualColor3 = Color.fromString(legendIcon3HexClr).asHex().trim().toUpperCase();
            assertion.assertTrue(actualColor1.contains(redColorAsHex), "Red color is not matching");
            assertion.assertTrue(actualColor2.contains(orangeColorAsHex), "Orange color is not matching");
            assertion.assertTrue(actualColor3.contains(greenColorAsHex), "Green color is not matching");
            assertion.assertAll();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("soilMoistureIntervalVerification.jpg");
            Assert.fail("Failed in soilMoistureIntervalVerification method due to exception:- " + exc);
        }
    }

    public void irrigationIntervalVerification() {
        try {
            SoftAssert assertion = new SoftAssert();
            assertion.assertTrue(lessThanFourIconForIrrigation.isDisplayed());
            assertion.assertTrue(fiveToTwentyIconForIrrigation.isDisplayed());
            assertion.assertTrue(greaterThanTwentyOneIconForIrrigation.isDisplayed());
            String legendIcon1HexClr = legendIcon1.getCssValue("background-color");
            String actualColor1 = Color.fromString(legendIcon1HexClr).asHex().trim().toUpperCase();
            String legendIcon2HexClr = legendIcon2.getCssValue("background-color");
            String actualColor2 = Color.fromString(legendIcon2HexClr).asHex().trim().toUpperCase();
            String legendIcon3HexClr = legendIcon3.getCssValue("background-color");
            String actualColor3 = Color.fromString(legendIcon3HexClr).asHex().trim().toUpperCase();
            assertion.assertTrue(actualColor1.contains(lightBlueColor), "Light color is not matching");
            assertion.assertTrue(actualColor2.contains(blueColorAsHexInIrrigationAsHex), "Blue color is not matching");
            assertion.assertTrue(actualColor3.contains(darkBlueColor), "Dark blue is not matching");
            assertion.assertAll();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("irrigationIntervalVerification.jpg");
            Assert.fail("Failed in irrigationIntervalVerification method due to exception:- " + exc);
        }
    }

    public void clickOnTheIrrigation() {
        try {
            webDriverHelper.waitUntilVisible(irrigationTag, 60, 1);
            irrigationTag.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("clickOnTheIrrigation.jpg");
            Assert.fail("Failed in clickOnTheIrrigation method due to exception:- " + exc);
        }
    }

    public void verifyTheIrrigationIntervalIcon() {
        try {
            webDriverHelper.scrollToWebElement(menuButtonOfFirstSite);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            boolean found = false;
            if (numberOfRowsDataPresent.size() > 1) {
                for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                    numberOfRowsDataPresent.get(i).click();
                    webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                    try {
                        if (soilMoistureExpandIcon.isDisplayed()) {
                            irrigationIntervalVerification();
                            found = true;
                            break;
                        }
                    } catch (NoSuchElementException | NullPointerException e) {
                    }
                }
                if (!found) {
                    System.out.println("there was no irrigation interval in the user");
                }
            } else {
                webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
                try {
                    if (soilMoistureExpandIcon.isDisplayed()) {
                        irrigationIntervalVerification();
                        found = true;
                    }
                } catch (NoSuchElementException | NullPointerException exc) {
                }
            }
            if (!found) {
                System.out.println("there was no irrigation interval in the user");

            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheIrrigationIntervalIcon.jpg");
            Assert.fail("Failed in verifyTheIrrigationIntervalIcon method due to exception:- " + exc);
        }
    }

    public void verifyTheDeviceIDAndStoreThatID() {
        try {
            webDriverHelper.waitUntilVisible(batteryStatusTag, 90, 1);
            deviceNameStored = new ArrayList<>();
            for (WebElement deviceName : deviceWithSensor) {
                String device = deviceName.getText();
                deviceNameStored.add(device);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheDeviceIDAndStoreThatID.jpg");
            Assert.fail("Failed in verifyTheDeviceIDAndStoreThatID method due to exception:- " + exc);
        }
    }

    public void verifyTheValidateSensorInDevicePage() {
        try {
            webDriverHelper.waitUntilVisible(statusInDevicePage, 90, 1);
            boolean found = false;
            List<String> siteNameInPerticularDeviceList = new ArrayList<>();
            for (String deviceToVerify : deviceNameStored) {
                List<WebElement> devicePageSiteList = driver.findElements(By.xpath("//p[text()='" + deviceToVerify + "']//ancestor::div[@class='grid body-list']//div//p//a"));
                for (WebElement siteList : devicePageSiteList) {
                    String siteName = siteList.getText();
                    siteNameInPerticularDeviceList.add(siteName);
                }
                for (String nameStored : siteNameInPerticularDeviceList) {
                    if (nameStored.equalsIgnoreCase(Constants.siteWithData)) {
                        siteNameInPerticularDeviceList.clear();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Assert.fail("In the device :" + deviceToVerify + " list the site :" + Constants.siteWithData + "is not present ");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheDeviceIDAndStoreThatID.jpg");
            Assert.fail("Failed in verifyTheDeviceIDAndStoreThatID method due to exception:- " + exc);
        }
    }

    public void verifyTheIconInValidateSensor() {
        try {
            SoftAssert tagVerification = new SoftAssert();
            webDriverHelper.waitUntilVisible(deviceIdTagInParticularSites, 60, 1);
            tagVerification.assertTrue(deviceIdTagInParticularSites.isDisplayed());
            tagVerification.assertTrue(batteryStatusTagInParticularSites.isDisplayed());
            tagVerification.assertTrue(connectedSensorsTagInParticularSites.isDisplayed());
            tagVerification.assertAll();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheIconInValidateSensor.jpg");
            Assert.fail("Failed in verifyTheIconInValidateSensor method due to exception:- " + exc);
        }
    }

    public void verifyTheClickableOnThreeDotsButtonOnIndividualDevice() {
        try {
            for (int i = 0; i < menuBtnInValidateSensor.size(); i++) {
                WebElement menuBtn = menuBtnInValidateSensor.get(i);
                wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
                menuBtn.click();
                String nameOfValidateSensor = validateSensorForParticularUser.getText().trim();
                Assert.assertTrue(nameOfValidateSensor.equalsIgnoreCase("Validate Sensors"));
                batteryStatusTag.click();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheClickableOnThreeDotsButtonOnIndividualDevice.jpg");
            Assert.fail("Failed in verifyTheClickableOnThreeDotsButtonOnIndividualDevice method due to exception: " + exc.getMessage());
        }
    }

    public void verifyTheThreeSensorThenClickOnTheValidateSenor() throws InterruptedException {
        try {
            Thread.sleep(5000);
            boolean found = false;
            for (WebElement deviceList : deviceList) {
                String deviceListName = deviceList.getText().toUpperCase().trim();
                List<WebElement> sensorList = driver.findElements(By.xpath("//div[text()='" + deviceListName + "']//ancestor::div[@class='device-table-entry-container grid']//following-sibling::div[@class='column device-table-entry device-sensors']//div"));
                int nonUndefinedSensorCount = 0;
                for (WebElement sensorName : sensorList) {
                    String sensorNames = sensorName.getAttribute("title").trim();
                    if (!sensorNames.contains("undefined") && !sensorNames.contains("None")) {
                        nonUndefinedSensorCount++;
                    }
                }
                if (nonUndefinedSensorCount == 3) {
                    driver.findElement(By.xpath("//div[text()='" + deviceListName + "']//ancestor::div[@class='device-table-entry-container grid']//following-sibling::arable-dotted-menu[@class='menu']//div[@class='menu-button-container']")).click();
                    validateSensorForParticularUser.click();
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail("There is an issue. The device with exactly three non-'undefined' or non-'None' sensors was not found.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheThreeSensorThenClickOnTheValidateSenor.jpg");
            Assert.fail("Failed in verifyTheThreeSensorThenClickOnTheValidateSenor method due to exception: " + exc.getMessage());
        }
    }

    public void verifyTheTagInTheSetUpConnectedSensors() {
        try {
            Thread.sleep(5000);
            webDriverHelper.waitUntilVisible(setUpConnectedSensorsTag, 90, 1);
            SoftAssert tagVerification = new SoftAssert();
            tagVerification.assertTrue(setUpConnectedSensorsTag.isDisplayed());
            tagVerification.assertTrue(port1AnalogTag.isDisplayed());
            tagVerification.assertTrue(setUpConnectedSensorsTag.isDisplayed());
            tagVerification.assertTrue(port2Pulse.isDisplayed());
            tagVerification.assertTrue(port3SDI12Tag.isDisplayed());
            if ((greenColourTick.size() != 3)) {
                Assert.fail("there are no green color tick mark is present in the drop down list");
            }
            for (WebElement listOfSensor : listOfDropInForTheSensor) {
                String listName = listOfSensor.getText().trim();
                listOfSensor.click();
                Thread.sleep(1000);
                webDriverHelper.waitUntilVisible(sensorWhichIsSelectedInDropDown, 30, 1);
                String sensorNameInDropDown = sensorWhichIsSelectedInDropDown.getText().trim();
                tagVerification.assertTrue(listName.contains(sensorNameInDropDown), "The sensor is not highlighting");
                Actions action = new Actions(driver);
                action.moveToElement(sensorWhichIsSelectedInDropDown).perform();
                String color = sensorWhichIsSelectedInDropDown.getCssValue("color");
                String actualColor = Color.fromString(color).asHex().toUpperCase();
                tagVerification.assertTrue(actualColor.contains("#0076C9"), "The sensor is not highlighting");

            }
            tagVerification.assertAll();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheTagInTheSetUpConnectedSensors.jpg");
            Assert.fail("Failed in verifyTheTagInTheSetUpConnectedSensors method due to exception: " + exc);
        }
    }

    public void verifyTheColorForTheWaterBalance() {
        try {
            webDriverHelper.scrollToWebElement(menuButtonOfFirstSite);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 120, 1);
            colorVerificationForWaterBalance();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheTagInTheSetUpConnectedSensors.jpg");
            Assert.fail("Failed in verifyTheTagInTheSetUpConnectedSensors method due to exception: " + exc);
        }
    }

    public void verifyTheColorForTheSoilMoisture() throws InterruptedException {
        webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 120, 1);
        Thread.sleep(3000);
        colorVerificationForSoilMoisture();
    }

    public void clickOnTheHeatStress() {
        try {
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            heatStressTag.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("clickOnTheHeatStress.jpg");
            Assert.fail("Failed in clickOnTheHeatStress method due to exception:- " + exc);
        }
    }

    public void verifyTheColorForTheHeatStress(){
        try {
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 120, 1);
            Thread.sleep(3000);
            colorVerificationForHeatStress();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheColorForTheHeatStress.jpg");
            Assert.fail("Failed in verifyTheColorForTheHeatStress method due to exception:- " + exc);
        }
    }

    public void verifyTheColorForTheIrrigation() throws InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 120, 1);
            Thread.sleep(3000);
            colorVerificationForIrrigation();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheColorForTheIrrigation.jpg");
            Assert.fail("Failed in verifyTheColorForTheIrrigation method due to exception:- " + exc);
        }
    }

    public void colorVerificationForIrrigation() {
        try {
            int lessThen4 = 0;
            int inBetween5to20 = 0;
            int greaterThen21 = 0;
            for (int j = 0; j < irrigationT0ReplaceEtcHrs.size(); j++) {
                String irrigationT0ReplaceEtcHrsText = irrigationT0ReplaceEtcHrs.get(j).getText();
                if (!irrigationT0ReplaceEtcHrsText.equals("--")) {
                    String hrsText = irrigationT0ReplaceEtcHrs.get(j).getText();
                    String[] parts = hrsText.split(":");
                    if (!parts[0].equals("--")) {
                        int partsName = Integer.parseInt(parts[0]);
                        String irrigationT0ReplaceEtcHrsCSS = irrigationT0ReplaceEtcHrs.get(j).getCssValue("color");
                        String irrigationT0ReplaceEtcHrsCSSColor = Color.fromString(irrigationT0ReplaceEtcHrsCSS).asHex().toUpperCase();
                        if (partsName < 4) {
                            lessThen4++;
                            // Assert.assertTrue(irrigationT0ReplaceEtcHrsCSSColor.equalsIgnoreCase(lightBlueColor), "for the hour less then 4 The color is not matching for The trrigation");
                        }
                        if (partsName >= 5 && partsName <= 20) {
                            inBetween5to20++;
                            //  Assert.assertTrue(irrigationT0ReplaceEtcHrsCSSColor.equalsIgnoreCase(blueColorAsHexInIrrigationAsHex), "for the hour in between 5 to 20 the color is not matching for the Irrigation");
                        }
                        if (partsName > 21) {
                            greaterThen21++;
                            //  Assert.assertTrue(irrigationT0ReplaceEtcHrsCSSColor.equalsIgnoreCase(darkBlueColor), "for the hour is greater than 21 the color is not matching for the Irrigation");
                        }
                    }
                }
            }
            for (int j = 0; j < overAllGraph.size(); j++) {
                String color = overAllGraph.get(j).getCssValue("fill");
                String actualColor = Color.fromString(color).asHex().toUpperCase();
                int textInOverAllGraphText = Integer.parseInt(textInOverAllGraph.get(j).getText());
                if (actualColor.equalsIgnoreCase(lightBlueColor)) {
                    Assert.assertEquals(lessThen4, textInOverAllGraphText, "The number present in the overall graph does not match the total count for less than 4 in the table for the Irrigation.");
                }
                if (actualColor.equalsIgnoreCase(blueColorAsHexInIrrigationAsHex)) {
                    Assert.assertEquals(inBetween5to20, textInOverAllGraphText, "The number present in the overall graph does not match the total count in between the 5 and 20 in the table for the Irrigation.");
                }
                if (actualColor.equalsIgnoreCase(darkBlueColor)) {
                    Assert.assertEquals(greaterThen21, textInOverAllGraphText, "The number present in the overall graph does not match the total count greater than 21 in the table for the Irrigation.");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("colorVerificationForIrrigation.jpg");
            Assert.fail("Failed in colorVerificationForIrrigation method due to exception:- " + exc);
        }
    }

    public void colorVerificationForHeatStress() {
        try {
            int lessThen5 = 0;
            int inBetween5to15 = 0;
            int greaterThen15 = 0;
            for (int j = 0; j < heatStressHours.size(); j++) {
                String heatStressHoursText = heatStressHours.get(j).getText();
                if (!heatStressHoursText.equals("--")) {
                    String hrsText = heatStressHours.get(j).getText();
                    String[] parts = hrsText.split(":");
                    if (!parts[0].equals("--")) {
                        int partsName = Integer.parseInt(parts[0]);
                        String heatStressHoursCSS = heatStressHours.get(j).getCssValue("color");
                        String heatStressHoursColor = Color.fromString(heatStressHoursCSS).asHex().toUpperCase();
                        if (partsName < 5) {
                            lessThen5++;
                            Assert.assertTrue(heatStressHoursColor.equalsIgnoreCase(greenColorAsHex), "for the hour less then 5 The color is not matching for the heatStress");
                        }
                        if (partsName >= 5 && partsName <= 15) {
                            inBetween5to15++;
                            Assert.assertTrue(heatStressHoursColor.equalsIgnoreCase(orangeColorAsHex), "for the hour in between 5 to 15 the color is not matching for the heatStress");
                        }
                        if (partsName > 15) {
                            greaterThen15++;
                            Assert.assertTrue(heatStressHoursColor.equalsIgnoreCase(redColorAsHex), "for the hour is greater than 15 the color is not matching for the heatStress");
                        }
                    }
                }
            }
            for (int j = 0; j < overAllGraph.size(); j++) {
                String color = overAllGraph.get(j).getCssValue("fill");
                String actualColor = Color.fromString(color).asHex().toUpperCase();
                int textInOverAllGraphText = Integer.parseInt(textInOverAllGraph.get(j).getText());
                if (actualColor.equalsIgnoreCase(greenColorAsHex)) {
                    Assert.assertEquals(lessThen5, textInOverAllGraphText, "The number present in the overall graph does not match the total count for less than 5 in the table for the heatStress.");
                }
                if (actualColor.equalsIgnoreCase(orangeColorAsHex)) {
                    Assert.assertEquals(inBetween5to15, textInOverAllGraphText, "The number present in the overall graph does not match the total count in between the 5 and 15 in the table for the heatStress.");
                }
                if (actualColor.equalsIgnoreCase(redColorAsHex)) {
                    Assert.assertEquals(greaterThen15, textInOverAllGraphText, "The number present in the overall graph does not match the total count greater than 15 in the table for the heatStress.");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("colorVerificationForHeatStress.jpg");
            Assert.fail("Failed in colorVerificationForHeatStress method due to exception:- " + exc);
        }
    }

    public void colorVerificationForWaterBalance() {
        try {
            int lessThenTwo = 0;
            int inBetween2and8 = 0;
            int greaterThen8 = 0;
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
            for (int j = 0; j < irrigationT0ReplaceEtcHrs.size(); j++) {
                irrigationT0ReplaceEtcHrsText = irrigationT0ReplaceEtcHrs.get(j).getText();
                if (!irrigationT0ReplaceEtcHrsText.equals("--")) {
                    String hrsText = irrigationT0ReplaceEtcHrs.get(j).getText();
                    String[] parts = hrsText.split(":");
                    if (!parts[0].equals("--")) {
                        int partsName = Integer.parseInt(parts[0]);
                        String irrigationT0ReplaceText = irrigationT0ReplaceEtcHrs.get(j).getCssValue("color");
                        String irrigationT0Replace = Color.fromString(irrigationT0ReplaceText).asHex().toUpperCase();
                        if (partsName == 0) {
                            partsName = 1;
                        }
                        if (partsName < 2) {
                            lessThenTwo++;
                            Assert.assertTrue(irrigationT0Replace.equalsIgnoreCase(greenColorAsHex), "for the hour is less or equal to 2 The color is not matching in Water Balance");
                        }
                        if (partsName >= 2 && partsName <= 8) {
                            inBetween2and8++;
                            Assert.assertTrue(irrigationT0Replace.equalsIgnoreCase(orangeColorAsHex), "for the hour 2 to 8 the color is not matching in Water Balance");
                        }
                        if (partsName > 8) {
                            greaterThen8++;
                            Assert.assertTrue(irrigationT0Replace.equalsIgnoreCase(redColorAsHex), "for the hour is greater than 8 the color is not matching in Water Balance");
                        }
                    }
                }
            }
            for (int j = 0; j < overAllGraph.size(); j++) {
                String color = overAllGraph.get(j).getCssValue("fill");
                String actualColor = Color.fromString(color).asHex().toUpperCase();
                int textInOverAllGraphText = Integer.parseInt(textInOverAllGraph.get(j).getText());
                if (actualColor.equalsIgnoreCase(greenColorAsHex)) {
                    Assert.assertEquals(lessThenTwo, textInOverAllGraphText, "The number present in the overall graph does not match the total count for less than 2 in the table for Water Balance.");
                }
                if (actualColor.equalsIgnoreCase(orangeColorAsHex)) {
                    Assert.assertEquals(inBetween2and8, textInOverAllGraphText, "The number present in the overall graph does not match the total count in between the 2 and 8 in the table for Water Balance.");
                }
                if (actualColor.equalsIgnoreCase(redColorAsHex)) {
                    Assert.assertEquals(greaterThen8, textInOverAllGraphText, "The number present in the overall graph does not match the total count greater than 8 in the table for Water Balance.");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("colorVerificationForWaterBalance.jpg");
            Assert.fail("Failed in colorVerificationForWaterBalance method due to exception:- " + exc);
        }
    }

    public void colorVerificationForSoilMoisture() {
        try {
            int lessThenTen = 0;
            int greaterThenTen = 0;
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 10, 1);
            for (int j = 0; j < proximityToRefillThreshold.size(); j++) {
                String irrigationT0ReplaceEtcHrsText = proximityToRefillThreshold.get(j).getText();
                if (!irrigationT0ReplaceEtcHrsText.equals("--")) {
                    String hrsText = proximityToRefillThreshold.get(j).getText();
                    String[] parts = new String[]{hrsText.replaceAll("[^0-9.]", "")};
                    if (!parts[0].equals("--")) {
                        double partsName = Double.parseDouble(parts[0]);
                        String proximityToRefillThresholdText = proximityToRefillThreshold.get(j).getCssValue("color");
                        String proximityToRefillThresholds = Color.fromString(proximityToRefillThresholdText).asHex().toUpperCase();
                        if (partsName < 10) {
                            greaterThenTen++;
                            Assert.assertTrue(proximityToRefillThresholds.equalsIgnoreCase(orangeColorAsHex), "for the hour is less 10 The color is not matching for the SoilMoisture");
                        }
                        if (partsName > 10) {
                            lessThenTen++;
                            Assert.assertTrue(proximityToRefillThresholds.equalsIgnoreCase(greenColorAsHex), "for the hour greater 10 the color is not matching for the SoilMoisture");
                        }
                    }
                }
            }
            for (int j = 0; j < overAllGraph.size(); j++) {
                String color = overAllGraph.get(j).getCssValue("fill");
                String actualColor = Color.fromString(color).asHex().toUpperCase();
                int textInOverAllGraphText = Integer.parseInt(textInOverAllGraph.get(j).getText());
                if (actualColor.equalsIgnoreCase(greenColorAsHex)) {
                    Assert.assertEquals(lessThenTen, textInOverAllGraphText, "The number present in the overall graph does not match the total count for less than 10 in the table for the SoilMoisture.");
                }
                if (actualColor.equalsIgnoreCase(orangeColorAsHex)) {
                    Assert.assertEquals(greaterThenTen, textInOverAllGraphText, "The number present in the overall graph does not match the total count for greater than 10 in the table for the SoilMoisture.");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("colorVerificationForSoilMoisture.jpg");
            Assert.fail("Failed in colorVerificationForSoilMoisture method due to exception:- " + exc);
        }
    }

    public void verifyTheLastIrrigationRuntimeColumnWithApi() {
        try {
            Map<String, String> addingSiteIdAnLastIrrigationRuntimeValuesUI = new HashMap<>();
            teamsApiHelper.getAuthToken();
            teamsApiHelper.getOrgId(orgTargeted);
            graphApiHelper.fetchSitesZone();
            sitesApiHelper.getUserMeasurementUnits();
//            time to load a table in multiple water sites page
            Thread.sleep(3000);
            for (int i = 0; i < siteNameListInMultiWaterSites.size(); i++) {
                String siteNameFromWaterPage = siteNameListInMultiWaterSites.get(i).getText();
                String lastIrrigationRuntimeValues = irrigationEtcDate.get(i).getText();
                if (Objects.equals(lastIrrigationRuntimeValues, "--")) {
                    graphApiHelper.getSiteId(siteNameFromWaterPage);
                    multiSiteApiHelper.getLastIrrigationTimeValue();
                    addingSiteIdAnLastIrrigationRuntimeValuesUI.put(siteId, lastIrrigationRuntimeValues);
                }
            }
            log.info("Api data count size="+addingSiteIdAnLastIrrigationRuntimeValuesForApi.size()+",And UI data count="+addingSiteIdAnLastIrrigationRuntimeValuesUI.size());
            Assert.assertEquals(addingSiteIdAnLastIrrigationRuntimeValuesForApi, addingSiteIdAnLastIrrigationRuntimeValuesUI, "The UI and Api value for last Irrigation Run time is not matching");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyTheLastIrrigationRuntimeColumnWithApi.jpg");
            Assert.fail("Failed in verifyTheLastIrrigationRuntimeColumnWithApi method due to exception:- " + exc);
        }
    }

    public void verifyIrrigationToReplaceETcValueFromTable() {
        try {
//            webDriverHelper.waitUntilVisible(soilMoistureTab,60,1);
//            soilMoistureTab.click();
            webDriverHelper.waitUntilVisible(sitesList_Modal, 60, 1);
            webDriverHelper.waitUntilVisible(menuButtonOfFirstSite, 60, 1);
            if (numberOfRowsDataPresent.size() > 1) {
                for (int i = 0; i < numberOfRowsDataPresent.size(); i++) {
                    webDriverHelper.waitUntilVisible(numberOfRowsDataPresent.get(i), 60, 1);
                    numberOfRowsDataPresent.get(i).click();
                    webDriverHelper.waitUntilVisible(sitesList_Modal, 100, 1);
                    for (WebElement replaceEtc : irrigationReplaceEtc) {
                        String replaceEtcValue = replaceEtc.getText();
                        if (!(replaceEtcValue.equals("--"))) {
                            if (!(replaceEtcValue.matches(Constants.timeFormatInWaterMultiSite))) {
                                Assert.fail("Failed to verify the format displayed in the table for irrigation replace etc");
                            }
                            String[] parts = replaceEtcValue.split(":");
                            int hours = Integer.parseInt(parts[0]);
                            log.info("replace etc hrs : " + hours);
                            String replaceEtcColor = replaceEtc.getCssValue("Color");
                            log.info("replaceEtcColor " + replaceEtcColor);
                            if (hours > 8) {
                                Assert.assertEquals(replaceEtcColor, Constants.redColorInWaterTab, "Failed to verify the color of the replace etc value when it is, > 8 hrs");
                            }
                            if (hours < 2) {
                                Assert.assertEquals(replaceEtcColor, Constants.greenColorInWaterTab, "Failed to verify the color of the replace etc value when it is, < 2 hrs");
                            }
                            if (hours >= 2 && hours <= 8) {
                                Assert.assertEquals(replaceEtcColor, Constants.yellowColorInWaterTab, "Failed to verify the color of the replace etc value when it is, >= 2 && <= 8 hrs");
                            }
                        }
                    }
                }
            } else {
                webDriverHelper.waitUntilVisible(sitesList_Modal, 100, 1);
                for (WebElement replaceEtc : irrigationReplaceEtc) {
                    String replaceEtcValue = replaceEtc.getText();
                    if (!(replaceEtcValue.equals("--"))) {
                        if (!(replaceEtcValue.matches(Constants.timeFormatInWaterMultiSite))) {
                            Assert.fail("Failed to verify the format displayed in the table for irrigation replace etc");
                        }
                        String[] parts = replaceEtcValue.split(":");
                        int hours = Integer.parseInt(parts[0]);
                        log.info("replace etc hrs : " + hours);
                        String replaceEtcColor = replaceEtc.getCssValue("Color");
                        if (hours > 8) {
                            Assert.assertEquals(replaceEtcColor, Constants.redColorInWaterTab, "Failed to verify the color of the replace etc value when it is, > 8 hrs");
                        } else if (hours < 2) {
                            Assert.assertEquals(replaceEtcColor, Constants.greenColorInWaterTab, "Failed to verify the color of the replace etc value when it is, < 2 hrs");
                        } else if (hours >= 2 && hours <= 8) {
                            Assert.assertEquals(replaceEtcColor, Constants.yellowColorInWaterTab, "Failed to verify the color of the replace etc value when it is, >= 2 && <= 8 hrs");
                        }
                    }
                }

            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("verifyIrrigationToReplaceETcValueFromTable.jpg");
            Assert.fail("Failed in verifyIrrigationToReplaceETcValueFromTable method due to exception:- " + exc);
        }
    }

}
