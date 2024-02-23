package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt", //Cucumber picks the failed scenarios from this file
        glue = {
                "support",
                "stepDefinitions"
        },
        plugin = {
                "de.monochromata.cucumber.report.PrettyReports:reporting/pretty/Fails",
                "html:reporting/CucumberHTMLReports/report.htm",
                "json:reporting/cucumberOtherreports/Cucumber.json",
                "junit:reporting/cucumber-reports/Cucumber.xml",
                "rerun:target/rerun.txt" //runs only the tests specific in this txt file
        },
        publish = true,
        tags = "@test"
)

public class CucumberRunnerRerunFails {
}

