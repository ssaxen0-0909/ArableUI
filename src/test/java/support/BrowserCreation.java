package support;

import TestRail.APIClient;
import TestRail.APIException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static TestRail.TestRailManager.testRailApiClient;

public class BrowserCreation {
    public static final int SUCCESS_STATE = 1;
    public static final int FAIL_STATE = 5;
    private static final String SUCCESS_COMMENT = "This test passed with Selenium";
    private static final String FAILED_COMMENT = "This test failed with Selenium";
    public static WebDriver driver;
    public static APIClient client = null;
    public static String TEST_RUN_ID = "2957";
    final PropertiesReader propertiesReader = new PropertiesReader();
    final ChromeOptions options = new ChromeOptions();
    final EdgeOptions EOptions = new EdgeOptions();

    public static void deleteExcel() {
        String userDirector = System.getProperty("user.dir");
        File src = new File(userDirector + "\\data\\excelSheet.xlsx");
        if (src.exists()) {
            src.delete();
        }
    }

    @AfterClass
    public static void tearDown() {
        if (PropertiesReader.browserRequired.equals("true")) {
            driver.quit();
        }
    }

    @BeforeSuite
    public void deleteHTML() throws IOException {
        File reportFile = new File("response_time_report.html");
        if (reportFile.exists()) {
            reportFile.delete();
            System.out.println("Previous HTML report deleted.");
        }
    }

    @Before
    public void setUp(Scenario scenario) throws IOException {
        propertiesReader.loadProperties();
        if (PropertiesReader.browserHeadless.equals("true")) {
            options.addArguments("--window-size=1325x744");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-dev-shm-usage");
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.setExperimentalOption("prefs", frameworkDownloadPathSetup());
            System.out.println("Scenario:"+scenario.getName());
        }
        if (PropertiesReader.browserRequired.equals("true")) {
            if (PropertiesReader.browserType.equals("chrome")) {
                options.addArguments("start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--silent");
                options.addArguments("--log-level=3");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--test-type");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--enable-network-logging");
                options.addArguments("--no-sandbox");
                options.setPageLoadStrategy(PageLoadStrategy.NONE);
                options.setExperimentalOption("prefs", frameworkDownloadPathSetup());
// Code to get only the all performance entries-disable
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                options.setCapability("goog:loggingPrefs", logPrefs);
                driver = new ChromeDriver(options);
                System.out.println("Scenario:"+scenario.getName());
            }

        } else if (PropertiesReader.browserType.equals("firefox")) {
            driver = new FirefoxDriver();
            // need to add script for firefox
        }
        if (PropertiesReader.browserType.equals("edge")) {
            // Configure EdgeOptions
            EdgeOptions options = new EdgeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--silent");
            options.addArguments("--log-level=3");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--test-type");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--enable-network-logging");
            options.addArguments("--no-sandbox");
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.setExperimentalOption("prefs", frameworkDownloadPathSetup());
            // Create EdgeDriver instance with options
            driver = new EdgeDriver(options);
            // Additional configuration if needed...
            System.out.println("Scenario:"+scenario.getName());
        }

        new World().driverClass();
//        deleteExcel();
    }

    // Creates a Downloads folder inside the framework test-output folder
    private HashMap<String, Object> frameworkDownloadPathSetup() throws IOException {
        String fileDownloadPath = System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"downloads"+File.separator;
        File downloadLocation = new File(fileDownloadPath);
        if(!downloadLocation.exists()){
            downloadLocation.mkdirs();
        }
        HashMap<String, Object> pathPrefs = new HashMap<>();
        pathPrefs.put("profile.default_content_settings.popups",0);
        pathPrefs.put("download.default_directory",fileDownloadPath);
        return pathPrefs;
    }

    @After
    public void embedScreenshot(Scenario scenario) throws InterruptedException {
        //If test fails takes a screenshot and embeds it in the Cucumber report
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String testName = scenario.getName();
                scenario.attach(screenshot, "image/png", "Screenshot description");
                scenario.log(testName);
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }


        logResultToTestRail(scenario);
        driver.close();
        driver.quit();
    }

    private void logResultToTestRail(Scenario scenario) {
        String caseId = World.TestCaseID;
        String testName = scenario.getName();
        Integer Line = scenario.getLine();
        String featureFilePath = scenario.getId();

        Map<String, Serializable> data = new HashMap<>();
        if (!scenario.isFailed()) {
            data.put("status_id", SUCCESS_STATE);
            data.put("comment", SUCCESS_COMMENT + "\n Scenario Outline :- "
                    + testName + "\n Feature File Path :- " + featureFilePath);
        } else if (scenario.isFailed()) {
            data.put("status_id", FAIL_STATE);
            data.put("comment", FAILED_COMMENT + "\n Scenario Outline :- "
                    + testName + "\n Failed Line in Feature File :-"
                    + Line + "\n Feature file path :- " + featureFilePath);
        }
        if (!caseId.equals("")) {
            try {
                if (System.getenv("runIdTestRail") != null && System.getenv("runTestRailId").equals("")) {
                    TEST_RUN_ID = System.getenv("runIdTestRail");
                }
                client = testRailApiClient();
                client.sendPost("add_result_for_case/" + TEST_RUN_ID + "/" + caseId, data);
            } catch (IOException | APIException | AssertionError e) {
                e.printStackTrace();
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
