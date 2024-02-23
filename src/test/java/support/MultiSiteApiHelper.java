package support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static support.World.*;

public class MultiSiteApiHelper {

    private static final Logger log = LogManager.getLogger(MultiSiteApiHelper.class);

    public String last_irrigation_time;
    public String last_irrigation_runtime_hours_hrs_formatted;
    public String irrigation_time_to_replace_et_min_formatted;
    public String irrigation_time_to_replace_et_hrs_formatted;
    public String last_irrigation_runtime_hours_min_formatted;

    private Response response;
    private String apiQueryParams = "&limit=15&order_by=site_name&order=asc&fields=water_metrics&temp=";

    public void getGrowingSeasonsAPIResponse() {
        String summaryUrl = "/growing_seasons?active=true&org_id=" + orgId + "&page=" + pageNoInWaterSite + apiQueryParams + tempUnit + "&size=" + sizeUnit + "&pres=" + presUnit + "&speed=" + speedUnit + "&ratio=dec";
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + summaryUrl);
    }

    public void getSummaryRequestForWaterFromGrowingSeasonApi() throws JsonProcessingException, ParseException {
        getGrowingSeasonsAPIResponse();
        siteToValuesMapInApi = new HashMap<>();
        try {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            JsonNode itemsArray = rootNode.get("items");
            if (itemsArray != null && itemsArray.isArray()) {
                for (JsonNode growingSeasonNode : itemsArray) {
                    String site_name = growingSeasonNode.get("site_name").asText();
                    String site_tz_name = growingSeasonNode.get("site_tz_name").asText();
                    JsonNode water_summary = growingSeasonNode.path("water_summary");
                    JsonNode irrigation_time_to_replace_et = water_summary.path("irrigation_time_to_replace_et");
                    String irrigation_time_to_replace_et_hrs = irrigation_time_to_replace_et.path("hrs").asText();
                    if (!(irrigation_time_to_replace_et_hrs.equals("null"))) {
                        if (irrigation_time_to_replace_et_hrs.length() == 1) {
                            LocalTime localTime = LocalTime.parse(irrigation_time_to_replace_et_hrs, DateTimeFormatter.ofPattern("H"));
                            irrigation_time_to_replace_et_hrs_formatted = localTime.format(DateTimeFormatter.ofPattern("HH"));
                        } else {
                            irrigation_time_to_replace_et_hrs_formatted = irrigation_time_to_replace_et_hrs;
                        }
                    } else {
                        irrigation_time_to_replace_et_hrs_formatted = "null";
                    }

                    String irrigation_time_to_replace_et_min = irrigation_time_to_replace_et.path("min").asText();
                    if (!(irrigation_time_to_replace_et_min.equals("null"))) {
                        if (irrigation_time_to_replace_et_min.length() == 1) {
                            int minuteValue = Integer.parseInt(irrigation_time_to_replace_et_min);
                            irrigation_time_to_replace_et_min_formatted = String.format("%02d", minuteValue);
                        } else {
                            irrigation_time_to_replace_et_min_formatted = irrigation_time_to_replace_et_min;
                        }
                    } else {
                        irrigation_time_to_replace_et_min_formatted = "null";
                    }

                    String irrigationTimeToReplaceEt = irrigation_time_to_replace_et_hrs_formatted + ":" + irrigation_time_to_replace_et_min_formatted + " hrs";
                    if (irrigationTimeToReplaceEt.equals("null:null hrs")) {
                        irrigationTimeToReplaceEt = "--";
                    }

                    if ((water_summary.path("last_irrigation_time").asText()).contains("T")) {
                        DateTimeFormatter inputFormat = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
                        String inputTimeString = water_summary.path("last_irrigation_time").asText();

                        ZonedDateTime inputTime = ZonedDateTime.parse(inputTimeString, inputFormat);
                        ZoneId desiredZone = ZoneId.of(site_tz_name);
                        ZonedDateTime convertedTime = inputTime.withZoneSameInstant(desiredZone);

                        DateTimeFormatter outputFormatWithOffset = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZZZZ");
                        String formattedTimeWithOffset = convertedTime.format(outputFormatWithOffset);

                        OffsetDateTime dateTimeWithOffset = OffsetDateTime.parse(formattedTimeWithOffset, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZZZZ"));
                        last_irrigation_time = dateTimeWithOffset.format(DateTimeFormatter.ofPattern("MM/dd"));
                    } else {
                        last_irrigation_time = "--";
                    }

                    JsonNode last_irrigation_runtime_hours = water_summary.path("last_irrigation_runtime_hours");
                    String last_irrigation_runtime_hours_hrs = last_irrigation_runtime_hours.path("hrs").asText();
                    if (!(last_irrigation_runtime_hours_hrs.equals("null"))) {
                        if (last_irrigation_runtime_hours_hrs.length() == 1) {
                            LocalTime localTime = LocalTime.parse(last_irrigation_runtime_hours_hrs, DateTimeFormatter.ofPattern("H"));
                            last_irrigation_runtime_hours_hrs_formatted = localTime.format(DateTimeFormatter.ofPattern("HH"));
                        } else {
                            last_irrigation_runtime_hours_hrs_formatted = last_irrigation_runtime_hours_hrs;
                        }
                    } else {
                        last_irrigation_runtime_hours_hrs_formatted = "null";
                    }

                    String last_irrigation_runtime_hours_min = last_irrigation_runtime_hours.path("min").asText();
                    if (!(last_irrigation_runtime_hours_min.equals("null"))) {
                        if (last_irrigation_runtime_hours_min.length() == 1) {
                            int minuteValue = Integer.parseInt(last_irrigation_runtime_hours_min);
                            last_irrigation_runtime_hours_min_formatted = String.format("%02d", minuteValue);
                        } else {
                            last_irrigation_runtime_hours_min_formatted = last_irrigation_runtime_hours_min;
                        }
                    } else {
                        last_irrigation_runtime_hours_min_formatted = "null";
                    }

                    String lastIrrigationRuntimeHours = last_irrigation_runtime_hours_hrs_formatted + ":" + last_irrigation_runtime_hours_min_formatted + " hrs";
                    if (lastIrrigationRuntimeHours.equals("null:null hrs")) {
                        lastIrrigationRuntimeHours = "--";
                    }

                    String lastIrrigation = last_irrigation_time + "\n" + lastIrrigationRuntimeHours;
                    if (lastIrrigation.equals("--\n--")) {
                        lastIrrigation = "--";
                    }

                    String refill_threshold = water_summary.path("refill_proximity").asText();
                    if (refill_threshold.equals("null")) {
                        refill_threshold = "--";
                    } else {
                        double refillThreshold = Double.parseDouble(refill_threshold);
                        double roundedValue = Math.round(refillThreshold * 10.0) / 10.0;
                        String refillThresholdValue = String.format("%.1f", roundedValue);
                        refill_threshold = refillThresholdValue + "%";
                        if (!(refill_threshold.contains("-"))) {
                            refill_threshold = "+" + refillThresholdValue + "%";
                        }
                    }

                    String heat_stress_hours = water_summary.path("heat_stress_hours").asText();
                    if (heat_stress_hours.equals("null")) {
                        heat_stress_hours = "--";
                    }

                    String[] columnValues = {
                            irrigationTimeToReplaceEt,
                            lastIrrigation,
                            refill_threshold,
                            heat_stress_hours
                    };
                    siteToValuesMapInApi.put(site_name, columnValues);
                }
            } else {
                Assert.fail("No 'items' array found in the JSON.");
            }
        } catch (Exception exc) {
            Assert.fail("failed to get the data due to exception :- " + exc);
        }
    }

    public void getLastIrrigationTimeValue() {
        String summaryUrl = "/growing_seasons?active=true&org_id=" + orgId + "&page=1&limit=15&order_by=site_name&order=asc&fields=water_metrics&temp=" + tempUnit + "&size=" + sizeUnit + "&pres=" + presUnit + "&speed=" + speedUnit;
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + summaryUrl);
        addingSiteIdAnLastIrrigationRuntimeValuesForApi.clear();
        List<LinkedHashMap<String, Object>> itemsList = response.path("items");
        for (LinkedHashMap<String, Object> itemMap : itemsList) {
            String siteId = (String) itemMap.get("site_id");
            LinkedHashMap<String, Object> waterSummary = (LinkedHashMap<String, Object>) itemMap.get("water_summary");
            String lastIrrigationTime = (String) waterSummary.get("last_irrigation_time");
            if (lastIrrigationTime == null) {
                lastIrrigationTime = "--";
                addingSiteIdAnLastIrrigationRuntimeValuesForApi.put(siteId, lastIrrigationTime);
            }
//            if (!lastIrrigationTime.equals("--")) {
//                webDriverHelper.waterPageUIDateFormation(lastIrrigationTime);
//                lastIrrigationTime = outputDateString;
//            }
//            addingSiteIdAnLastIrrigationRuntimeValuesForApi.put(siteId, lastIrrigationTime);
        }
    }
}
