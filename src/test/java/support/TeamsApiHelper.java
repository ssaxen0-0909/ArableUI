package support;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static support.World.*;

public class TeamsApiHelper {
    public RestAssuredHelper restAssuredHelper = new RestAssuredHelper();
    private String email = emailId;
    private String password = PropertiesReader.applicationPassword;
    private Response response;

    public TeamsApiHelper withPassword(String password) {
        this.password = password;
        return this;
    }

    public JSONObject buildAuthRequest() {
        return new JSONObject()
                .put("email", email)
                .put("password", password);
    }

    public String getAuthToken() {
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setContentType("application/json");
        String authPayload = new TeamsApiHelper()
                .withPassword(password)
                .buildAuthRequest()
                .toString();
        restAssuredHelper.setRequestBody(authPayload);
        response = restAssuredHelper.postRequest(PropertiesReader.apiVersion + "/auth/token");
        token = response.path("token");
        userId = response.path("user_id");
        return token;
    }

    public String getOrgId(String orgName) {
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        restAssuredHelper.setContentType("application/json");
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/orgs");
        JsonPath jsMap = new JsonPath(response.asString());
        List<String> ordIdList = jsMap.getList("id");
        List<String> OrgNameList = jsMap.getList("name");
        Map<String, String> keyValueMap = new HashMap<>();
        for (int i = 0; i < ordIdList.size(); i++) {
            String id = ordIdList.get(i);
            String name = OrgNameList.get(i);
            keyValueMap.put(name, id);
        }
        Set<Map.Entry<String, String>> keyValueSet = keyValueMap.entrySet();
        orgId = keyValueMap.get(orgName);
        if (orgId != null) {
            System.out.println("Value for key " + orgName + ": " + orgId);
        } else {
            Assert.fail("Key not found.");
        }
        return orgId;
    }

    public void getSummaryRequest() {
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        restAssuredHelper.setContentType("application/json");
        Response summaryResponse = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/orgs/" + orgId + "/teams/stats");
        assignedTeamsCounts = summaryResponse.path("teams_assigned.count").toString();
        unassignedTeamsCounts = summaryResponse.path("teams_unassigned.count").toString();
        assignedMembersCounts = summaryResponse.path("members_assigned.count").toString();
        unassignedMembersCounts = summaryResponse.path("members_unassigned.count").toString();
        assignedDevicesCounts = summaryResponse.path("devices_assigned.count").toString();
        unassignedDevicesCounts = summaryResponse.path("devices_unassigned.count").toString();
        assignedSitesCounts = summaryResponse.path("sites_assigned").toString();
        unassignedSitesCounts = summaryResponse.path("sites_unassigned.count").toString();
    }

}
