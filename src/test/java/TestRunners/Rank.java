//package TestRunners;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/java/features",
//        glue = {
//                "support",
//                "stepDefinitions"
//        },
//        plugin = {
//                "de.monochromata.cucumber.report.PrettyReports:reporting/pretty/Rank",
//                "json:reporting/cucumberOtherreports/Rank.json",
//                "json:target/cucumber-report/report.json",
//                "junit:reporting/cucumber-reports/Rank.xml",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//        },
//        monochrome = true,
//        publish = true,
//        tags = "@Rank and @orgAdmin"
//)
//
//public class Rank {
//    private static ExtentReports extent;
//
//    @BeforeClass
//    public static void setup() {
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/extent-report/Spark.html");
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//    }
//
//    @AfterClass
//    public static void teardown() {
//        extent.flush();
//    }
//}