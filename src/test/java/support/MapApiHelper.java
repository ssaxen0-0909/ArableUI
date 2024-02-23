package support;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static support.PropertiesReader.orgTargeted;
import static support.World.*;


public class MapApiHelper {

    private static final Logger log = LogManager.getLogger(MapApiHelper.class);
    private Response response;
    private String apiQueryParams = "&limit=10000&select=et,etc,et_10d,ndvi,cl,rh,tair,sun,fcst_max,fcst_min,fcst_precip,precip,precip_10d,wind_speed,wind_heading,wind_direction,soil_moisture&is_operational=true&org_id=";

    public void getSitesMeasuresFromAPI() {
        teamsApiHelper.getAuthToken();
        teamsApiHelper.getOrgId(orgTargeted);
        sitesApiHelper.getUserMeasurementUnits();
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        String queryUrl = PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/summary?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + apiQueryParams + orgId;
        response = restAssuredHelper.getRequest(queryUrl);
        log.info("Response from sites summary API="+response.asString());
        siteToValuesMapInApi = new HashMap<>();
        sitesListInAPI = new ArrayList<>();
        try {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            JsonNode itemsArray = rootNode.get("items");
            if (itemsArray != null && itemsArray.isArray()) {
                for (JsonNode growingSeasonNode : itemsArray) {
                    String site_name = growingSeasonNode.get("name").asText();
                    JsonNode summary = growingSeasonNode.path("summary");
                    JsonNode measurements = summary.path("measurements");
                    double tempDouble = measurements.has("tair") ? measurements.get("tair").asDouble() : Double.NaN;
                    String temp;
                    if (Double.isNaN(tempDouble)) {
                        temp = "--";
                    } else {
                        BigDecimal roundedTemp = BigDecimal.valueOf(tempDouble).setScale(0, BigDecimal.ROUND_HALF_UP);
                        temp = String.valueOf(roundedTemp);
                    }
                    String precip = "";
                    precip = measurements.has("precip") ? measurements.get("precip").asText() : "--";
                    if (precip.equals("0.0")) {
                        precip = String.valueOf(Math.round(Float.parseFloat(precip)));
                    }
                    double sunRadiantDouble = measurements.has("sun") ? measurements.get("sun").asDouble() : Double.NaN;
                    String sunRadiant = Double.isNaN(sunRadiantDouble) ? "--" : String.valueOf(Math.round(sunRadiantDouble));
                    String[] columnValues = {
                            temp,
                            precip,
                            sunRadiant
                    };
                    siteToValuesMapInApi.put(site_name, columnValues);
                    sitesListInAPI.add(site_name);
                }
            } else {
                Assert.fail("No 'items' array found in the response JSON.");
            }
        } catch (Exception exc) {
            Assert.fail("failed to get the data due to exception :- " + exc);
        }
    }
}
