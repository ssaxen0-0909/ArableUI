package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {
                "support",
                "stepDefinitions"
        },
        plugin = {
                "de.monochromata.cucumber.report.PrettyReports:reporting/pretty/Performance",
                "html:reporting/CucumberHTMLReports/Performance-html",
                "json:reporting/cucumberOtherreports/Performance.json",
                "json:target/cucumber-report/report.json",
                "junit:reporting/cucumber-reports/Performance.xml",
                "rerun:target/rerun.txt" //Creates a text file with failed scenarios
        },
        publish = true,
        tags = "@Performance"

)

public class Performance {
}
