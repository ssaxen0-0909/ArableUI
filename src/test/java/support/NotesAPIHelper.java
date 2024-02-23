package support;

import io.restassured.response.Response;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static support.World.*;

public class NotesAPIHelper {

    public String temperatureUnit;
    public String distanceUnit;
    public String pressureUnit;
    public String tairUnit;
    private String apiUrl;
    private List<String> apiNoteValues;
    private Response notesApiResponse;

    public void getAnnotationsRequest(String requestUrl) {
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            String site_id = extractSiteIdFromUrl(currentURL);
            if (site_id != null) {
                apiUrl = constructApiUrlCreateNote(site_id);
                notesApiResponse = makeApiRequest(apiUrl);
                System.out.println("API Endpoint: " + apiUrl);
                apiNoteValues = processApiResponse();
            } else {
                System.out.println("Site ID is null. Cannot construct API URL.");
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    public void getDeleteNotesResponse(String requestUrl) {
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            System.out.println("currentURL: " + currentURL);
            String site_id = extractSiteIdFromUrl(currentURL);
            if (site_id != null) {
                apiUrl = constructApiUrlDeleteNotes(site_id);
                System.out.println("apiUrl: " + apiUrl);
                notesApiResponse = restAssuredHelper.makeDeleteApiRequest(apiUrl);
                System.out.println("notesApiResponse: " + notesApiResponse);
                System.out.println("API Endpoint: " + apiUrl);
                apiNoteValues = processApiResponse();
                System.out.println("apiNoteValues: " + apiNoteValues);
            } else {
                System.out.println("Site ID is null. Cannot construct API URL.");
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    public void postAnnotationsShareRequest(String requestUrl) {
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            String site_id = extractSiteIdFromUrl(currentURL);
            if (site_id != null) {
                apiUrl = constructApiUrlShareNote(site_id);
                notesApiResponse = restAssuredHelper.postRequest(apiUrl);
                System.out.println("API Endpoint: " + apiUrl);
                apiNoteValues = processApiResponseShareAPI();
            } else {
                System.out.println("Site ID is null. Cannot construct API URL.");
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    public void getUsersAPIRequest() {
        try {
            if (userId != null) {
                apiUrl = constructApiUrlUsersAPI();
                notesApiResponse = makeApiRequest(apiUrl);
                System.out.println("API Endpoint: " + apiUrl);
                apiNoteValues = Collections.singletonList(processApiResponseUsersAPITemperature());
            } else {
                System.out.println("userId is null. Cannot construct API URL.");
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    public void getUsersAPIRequestForSize() {
        try {
            if (userId != null) {
                apiUrl = constructApiUrlUsersAPI();
                notesApiResponse = makeApiRequest(apiUrl);
                System.out.println("API Endpoint: " + apiUrl);
                apiNoteValues = Collections.singletonList(processApiResponseUsersAPISize());
            } else {
                System.out.println("userId is null. Cannot construct API URL.");
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    public String extractSiteIdFromUrl(String url) {
        Pattern pattern = Pattern.compile("detail\\/(.+?)(?:\\/|\\()");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            System.out.println("No ID found in the URL");
            return null;
        }
    }

    private String constructApiUrlCreateNote(String siteId) {
        return PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/" + siteId + "/annotations";
    }

    private String constructApiUrlDeleteNotes(String siteId) {
        return PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/" + "annotations" + siteId;
    }

    private String constructApiUrlShareNote(String siteId) {
        return PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/" + "annotations/" + siteId + "/share";
    }

    private String constructApiUrlUsersAPI() {
        return PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/users/" + userId;
    }

    Response makeApiRequest(String apiUrl) {
        try {
            restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
            restAssuredHelper.setAuthToken(token);
            restAssuredHelper.setContentType("application/json");
            return restAssuredHelper.getRequest(apiUrl);
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    public int getApiStatusCode() {
        if (notesApiResponse != null) {
            int statusCode = notesApiResponse.getStatusCode();
            System.out.println("API Status Code: " + statusCode);
            return statusCode;
        } else {
            System.out.println("No API response available. Please check if the API request was successful.");
            return -1;
        }
    }

    public String getApiResponseBody() {
        if (notesApiResponse != null) {
            String responseBody = notesApiResponse.getBody().asString();
            System.out.println("API Response Body: " + responseBody);
            return responseBody;
        } else {
            System.out.println("No API response available. Please check if the API request was successful.");
            return null;
        }
    }

    public List<String> processApiResponse() {
        int statusCode = getApiStatusCode();
        String responseBody = getApiResponseBody();

        if (statusCode == 200) {
            apiNoteValues = notesApiResponse.jsonPath().getList("note");
            System.out.println("API Note Values: " + apiNoteValues);
            return apiNoteValues;
        } else {
            System.out.println("API request failed with status code: " + statusCode);
            return null;
        }
    }

    public List<String> processApiResponseShareAPI() {
        int statusCode = getApiStatusCode();
        String responseBody = getApiResponseBody();

        if (statusCode == 200) {
            apiNoteValues = notesApiResponse.jsonPath().getList("message");
            System.out.println("API Note Values: " + apiNoteValues);
            return apiNoteValues;
        } else {
            System.out.println("API request failed with status code: " + statusCode);
            return null;
        }
    }

    public String processApiResponseUsersAPITemperature() {
        int statusCode = getApiStatusCode();
        String responseBody = getApiResponseBody();
        System.out.println("responseBody:-" + responseBody);
        if (statusCode == 200) {
            temperatureUnit = notesApiResponse.jsonPath().getString("temperature_unit");
            System.out.println("Temperature Unit: " + temperatureUnit);
            return temperatureUnit != null ? Collections.singletonList(temperatureUnit).toString() : null;
        } else {
            System.out.println("API request failed with status code: " + statusCode);
            return null;
        }
    }

    public String processApiResponseUsersAPISize() {
        int statusCode = getApiStatusCode();
        String responseBody = getApiResponseBody();
        System.out.println("responseBody:-" + responseBody);
        if (statusCode == 200) {
            distanceUnit = notesApiResponse.jsonPath().getString("distance_unit");
            System.out.println("distance unit: " + distanceUnit);
            return distanceUnit != null ? Collections.singletonList(distanceUnit).toString() : null;
        } else {
            System.out.println("API request failed with status code: " + statusCode);
            return null;
        }
    }

    public List<String> getApiNoteValues() {
        return apiNoteValues;
    }


    private void handleException(Exception e) {
        e.printStackTrace();
    }
}
