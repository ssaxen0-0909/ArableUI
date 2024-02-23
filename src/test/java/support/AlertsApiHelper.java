package support;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static support.World.*;

public class AlertsApiHelper {
    private Response response;
    private static final Logger log = LogManager.getLogger(AlertsApiHelper.class);

    public Response getResponse() {
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        String queryUrl = PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/notifications/clear_unread?org_id=" + orgId;
        response = restAssuredHelper.getRequest(queryUrl);
        return response;
    }

    public void getTotalCountInNotificationApi() {
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        String queryUrl = PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/notifications?org_id=" + orgId + "&limit=15&page=" + pageNo;
        log.info("Endpoint for Notification count API=" + queryUrl);
        response = restAssuredHelper.getRequest(queryUrl);
        alertsLimitPerPage = response.path("limit").toString();
        alertPageNo = response.path("page").toString();
    }
}
