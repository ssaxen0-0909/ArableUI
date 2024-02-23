package TestRail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static support.BrowserCreation.TEST_RUN_ID;
import static support.BrowserCreation.client;
import static support.PropertiesReader.*;


public class TestRailManager {

    public static void addResultForTestCase(String testCaseId, int status,
                                            String error) throws IOException, APIException {
        String testRunId = TEST_RUN_ID;
        Map data = new HashMap();
        data.put("status_id", status);
        data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
        client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
    }

    public static APIClient testRailApiClient() {
        String baseUrl = testRailUrl;
        String usernameTestRail = TestRail_username;
        String passwordTestRail = TestRail_password;
        APIClient client = new APIClient(baseUrl);
        client.setUser(usernameTestRail);
        client.setPassword(passwordTestRail);
        return client;
    }
}
