package support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static support.World.*;

public class GraphApiHelper {

    private static final Logger log = LogManager.getLogger(GraphApiHelper.class);
    public static int soilMoistureSize;
    public List<String> dateInApi = new ArrayList<>();
    public List<Double> swdwValues = new ArrayList<>();
    public List<Double> maxTempValues = new ArrayList<>();
    public List<Double> minTempValues = new ArrayList<>();
    public List<Double> clValues = new ArrayList<>();
    public List<Double> etcValues = new ArrayList<>();
    public List<Double> lfwValues = new ArrayList<>();
    public List<Double> ndviValues = new ArrayList<>();
    public List<Double> rhValues = new ArrayList<>();
    public List<Double> vpdValues = new ArrayList<>();
    public List<Double> windSpeedValues = new ArrayList<>();
    public List<Double> windSpeedMaxValues = new ArrayList<>();
    public List<Double> precipValues = new ArrayList<>();
    public List<Double> moistureMean10cm = new ArrayList<>();
    public List<Double> moistureMean20cm = new ArrayList<>();
    public List<Double> moistureMean30cm = new ArrayList<>();
    public List<Double> moistureMean40cm = new ArrayList<>();
    public List<Double> moistureMean50cm = new ArrayList<>();
    public List<Double> moistureMean60cm = new ArrayList<>();
    public List<Double> moistureMean70cm = new ArrayList<>();
    public List<Double> moistureMean80cm = new ArrayList<>();
    public List<Double> moistureMean90cm = new ArrayList<>();
    public List<Double> moistureMean100cm = new ArrayList<>();
    public List<Double> moistureMean110cm = new ArrayList<>();
    public List<Double> moistureMean120cm = new ArrayList<>();
    public List<Double> moistureMean130cm = new ArrayList<>();
    public List<Double> moistureMean140cm = new ArrayList<>();
    public List<Double> moistureMean150cm = new ArrayList<>();
    List<String> dateApi = new ArrayList<>();
    List<String> listLocalTime = new ArrayList<>();
    List<Double> etcApiValue = new ArrayList<>();
    List<Double> lfwValue = new ArrayList<>();
    List<Double> precipValue = new ArrayList<>();
    List<Double> vpdValue = new ArrayList<>();
    List<Double> maxtValue = new ArrayList<>();
    List<Double> mintValue = new ArrayList<>();
    List<Double> relativeHumidityValue = new ArrayList<>();
    List<String> yourAverageList;
    List<Integer> averageLength = new ArrayList<>();
    List<Double> averageLengthMoisture = new ArrayList<>();
    List<Double> wind_speedValue = new ArrayList<>();
    List<Double> wind_speed_maxValue = new ArrayList<>();
    List<String> listLocalTimeHistorical = new ArrayList<>();
    List<Double> wind_speedValueHistorical = new ArrayList<>();
    private Response response;

    public void getSiteId(String siteName) {
        try {
            String summaryUrl = "org_id=" + orgId + "&page=1&include_locations=true&limit=10000";
            restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
            restAssuredHelper.setAuthToken(token);
            response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites?" + summaryUrl);
            String responseBody = response.getBody().asString();

            JsonPath jsMap = new JsonPath(responseBody);
            List<Map<String, String>> items = jsMap.getList("items");
            Map<String, String> keyValueMap = new HashMap<>();
            for (Map<String, String> item : items) {
                String id = item.get("id");
                String name = item.get("name");
                keyValueMap.put(name, id);
            }
            siteId = keyValueMap.get(siteName);
            if (siteId != null) {
                System.out.println("Value for key " + siteName + ": " + siteId);
            } else {
                System.out.println("Key not found.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_getSiteId.jpg");
            Assert.fail("Failed in getSiteId method due to exception:- " + exc);
        }
    }

    public void getSummaryRequestForGraphFromSentekDailyApi() throws JsonProcessingException, ParseException {
        String summaryUrl = "sentek_daily?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&site_id=" + siteId + "&limit=1000" + "&start_time=" + selectedStartDateStrText + "&local_time=" + siteZone;
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/data/" + summaryUrl);
        log.info("Response from Sentek daily=" + response.asString());
        if (response != null && response.getStatusCode() == 200) {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            for (JsonNode node : rootNode) {
                String time = node.get("local_time").asText();
                double mean10cm = node.get("moisture_0_mean").asDouble();
                double mean20cm = node.get("moisture_1_mean").asDouble();
                double mean30cm = node.get("moisture_2_mean").asDouble();
                double mean40cm = node.get("moisture_3_mean").asDouble();
                double mean50cm = node.get("moisture_4_mean").asDouble();
                double mean60cm = node.get("moisture_5_mean").asDouble();
                double mean70cm = node.get("moisture_6_mean").asDouble();
                double mean80cm = node.get("moisture_7_mean").asDouble();
                double mean90cm = node.get("moisture_8_mean").asDouble();
                double mean100cm = node.get("moisture_9_mean").asDouble();
                double mean110cm = node.get("moisture_10_mean").asDouble();
                double mean120cm = node.get("moisture_11_mean").asDouble();
                double mean130cm = node.get("moisture_12_mean").asDouble();
                double mean140cm = node.get("moisture_13_mean").asDouble();
                double mean150cm = node.get("moisture_14_mean").asDouble();
                dateInApi.add(time);
                moistureMean10cm.add(mean10cm);
                moistureMean20cm.add(mean20cm);
                moistureMean30cm.add(mean30cm);
                moistureMean40cm.add(mean40cm);
                moistureMean50cm.add(mean50cm);
                moistureMean60cm.add(mean60cm);
                moistureMean70cm.add(mean70cm);
                moistureMean80cm.add(mean80cm);
                moistureMean90cm.add(mean90cm);
                moistureMean100cm.add(mean100cm);
                moistureMean110cm.add(mean110cm);
                moistureMean120cm.add(mean120cm);
                moistureMean130cm.add(mean130cm);
                moistureMean140cm.add(mean140cm);
                moistureMean150cm.add(mean150cm);
            }
        }
    }

    public void getSummaryRequestForGraphFromDailyApi() throws JsonProcessingException, ParseException {
        String summaryUrl = "daily?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&site_id=" + siteId + "&limit=1000" + "&start_time=" + selectedStartDateStrText + "&local_time=" + siteZone;
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/data/" + summaryUrl);
        log.info("Response from daily api=" + response.asString());
        if (response != null && response.getStatusCode() == 200) {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);

            for (JsonNode node : rootNode) {
                String time = node.get("time").asText();
                double swdw = node.get("swdw").asDouble();
                double maxt = node.get("maxt").asDouble();
                double mint = node.get("mint").asDouble();
                double cl = node.get("cl").asDouble();
                double etc = node.get("etc").asDouble();
                double lfw = node.get("lfw").asDouble();
                double ndvi = node.get("ndvi").asDouble();
                double rh = node.get("rh").asDouble();
                double vpd = node.get("vpd").asDouble();
                double windSpeed = node.get("wind_speed").asDouble();
                double windSpeedMax = node.get("wind_speed_max").asDouble();
                double precip = node.get("precip").asDouble();

                dateInApi.add(time);
                swdwValues.add(swdw);
                maxTempValues.add(maxt);
                minTempValues.add(mint);
                clValues.add(cl);
                etcValues.add(etc);
                lfwValues.add(lfw);
                ndviValues.add(ndvi);
                rhValues.add(rh);
                vpdValues.add(vpd);
                windSpeedValues.add(windSpeed);
                windSpeedMaxValues.add(windSpeedMax);
                precipValues.add(precip);
            }
        }
    }

    public void getSiteZone() {
        restAssuredHelper.setBaseURI((PropertiesReader.apiSeverUrl));
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/" + siteId);
        siteZone = response.path("tz_name");
        System.out.println("site geo location is -> " + siteZone);
    }

    public void getSummaryRequestForGraphFromHistoricalApi() throws JsonProcessingException, ParseException {
        String summaryUrl = "/sites/" + siteId + "/historical?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&start_date=" + selectedStartDateStrText + "&end_date=" + selectedEndDateStrText + "&resolution=daily&params=wind_speed,wind_direction";
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + summaryUrl);
        try {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            JsonNode dailyArray = rootNode.get("daily");
            if (dailyArray != null && dailyArray.isArray()) {
                for (JsonNode dailyNode : dailyArray) {
                    String time = dailyNode.get("time").asText();
                    double windSpeed = dailyNode.get("wind_speed").asDouble();
                    double windSpeedMax = dailyNode.get("wind_speed_max").asDouble();
                    dateInApi.add(time);
                    windSpeedValues.add(windSpeed);
                    windSpeedMaxValues.add(windSpeedMax);
                }
            } else {
                System.out.println("No 'daily' array found in the JSON.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDateAndWindSpeed() {
        try {
            List<String> dateStoredList = formatDateList(dateInApi);
            List<Integer> windSpeedValuesStored = new ArrayList<>();
            for (Double measureValues : windSpeedValues) {
                if (measureValues == null) {
                    windSpeedValuesStored.add(0);
                } else {
                    int roundedApiValue = (int) Math.round(measureValues);
                    windSpeedValuesStored.add(roundedApiValue);
                }
            }
            combinedIntegerListInApi = buildCombinedIntegerList(dateStoredList, windSpeedValuesStored);
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getDateWindSpeedAndMaxWindSpeed() throws ParseException {
        try {
            List<String> dateStoredList = formatDateList(dateInApi);
            List<Integer> windSpeedValuesStored = new ArrayList<>();
            List<Integer> maxWindSpeedValuesStored = new ArrayList<>();
            for (Double measureValues : windSpeedValues) {
                if (measureValues == null) {
                    windSpeedValuesStored.add(0);
                } else {
                    int roundedApiValue = (int) Math.round(measureValues);
                    windSpeedValuesStored.add(roundedApiValue);
                }
            }
            for (Double measureValues : windSpeedMaxValues) {
                if (measureValues == null) {
                    maxWindSpeedValuesStored.add(0);
                } else {
                    int roundedApiValue = (int) Math.round(measureValues);
                    maxWindSpeedValuesStored.add(roundedApiValue);
                }
            }
            List<Map.Entry<String, Integer>> combinedMaxWindSpeedList = buildCombinedIntegerList(dateStoredList, maxWindSpeedValuesStored);
            List<Map.Entry<String, Integer>> combinedWindSpeedTempList = buildCombinedIntegerList(dateStoredList, windSpeedValuesStored);
            combinedIntegerListInApi = new ArrayList<>(combinedMaxWindSpeedList);
            combinedIntegerListInApi.addAll(combinedWindSpeedTempList);
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getDateAndMaxTemp() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Integer> maxTempValuesStored = new ArrayList<>();
        for (Double measureValues : maxTempValues) {
            if (measureValues == null) {
                maxTempValuesStored.add(0);
            } else {
                BigDecimal roundedApiValue = BigDecimal.valueOf(measureValues).setScale(0, BigDecimal.ROUND_HALF_UP);
                maxTempValuesStored.add(roundedApiValue.intValue());
            }
        }
        combinedIntegerListInApi = buildCombinedIntegerList(dateStoredList, maxTempValuesStored);
    }

    public void getDateAndMinTemp() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Integer> minTempValuesStored = new ArrayList<>();
        for (Double measureValues : minTempValues) {
            if (measureValues == null) {
                minTempValuesStored.add(0);
            } else {
                BigDecimal roundedApiValue = BigDecimal.valueOf(measureValues).setScale(0, BigDecimal.ROUND_HALF_UP);
                minTempValuesStored.add(roundedApiValue.intValue());
            }
        }
        combinedIntegerListInApi = buildCombinedIntegerList(dateStoredList, minTempValuesStored);
    }

    public void getDateMinAndMaxTemp() throws ParseException {
        try {
            List<String> dateStoredList = formatDateList(dateInApi);
            List<Integer> minTempValuesStored = new ArrayList<>();
            List<Integer> maxtempValuesStored = new ArrayList<>();
            for (Double measureValues : maxTempValues) {
                if (measureValues == null) {
                    maxtempValuesStored.add(0);
                } else {
                    BigDecimal roundedValue = BigDecimal.valueOf(measureValues).setScale(0, BigDecimal.ROUND_HALF_UP);
                    maxtempValuesStored.add(roundedValue.intValue());
                }
            }
            for (Double measureValues : minTempValues) {
                if (measureValues == null) {
                    minTempValuesStored.add(0);
                } else {
                    BigDecimal roundedValue = BigDecimal.valueOf(measureValues).setScale(0, BigDecimal.ROUND_HALF_UP);
                    minTempValuesStored.add(roundedValue.intValue());
                }
            }
            List<Map.Entry<String, Integer>> combinedMaxTempList = buildCombinedIntegerList(dateStoredList, maxtempValuesStored);
            List<Map.Entry<String, Integer>> combinedMinTempList = buildCombinedIntegerList(dateStoredList, minTempValuesStored);
            combinedIntegerListInApi = new ArrayList<>(combinedMaxTempList);
            combinedIntegerListInApi.addAll(combinedMinTempList);
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getDateAndChloroValues() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Double> chloroValuesStored = new ArrayList<>();
        for (Double measureValues : clValues) {
            if (measureValues == null) {
                chloroValuesStored.add(0.0);
            } else {
                chloroValuesStored.add(measureValues);
            }
        }
        combinedDoubleListInApi = buildCombinedDoubleList(dateStoredList, chloroValuesStored);
    }

    public void getDateAndEtcValues() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Double> etcValuesStored = new ArrayList<>();
        for (Double measureValues : etcValues) {
            if (measureValues == null) {
                etcValuesStored.add(0.0);
            } else {
                etcValuesStored.add(measureValues);
            }
        }
        combinedDoubleListInApi = buildCombinedDoubleList(dateStoredList, etcValuesStored);
    }

    public void getDateAndLfwValues() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Integer> lfwValuesStored = new ArrayList<>();
        for (Double measureValues : lfwValues) {
            if (measureValues == null) {
                lfwValuesStored.add(0);
            } else {
                int roundedApiValue = (int) Math.round(measureValues);
                lfwValuesStored.add(roundedApiValue);
            }
        }
        combinedIntegerListInApi = buildCombinedIntegerList(dateStoredList, lfwValuesStored);
    }

    public void getDateAndVpdForPressureUnitMb() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Integer> vpdValuesStored = new ArrayList<>();
        for (Double measureValues : vpdValues) {
            if (measureValues == null) {
                vpdValuesStored.add(0);
            } else {
                int roundedApiValue = (int) Math.round(measureValues);
                vpdValuesStored.add(roundedApiValue);
            }
        }
        combinedIntegerListInApi = buildCombinedIntegerList(dateStoredList, vpdValuesStored);
    }

    public void getDateAndVpdForPressureUnitKp() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Double> vpdValuesStored = new ArrayList<>();
        for (Double measureValues : vpdValues) {
            if (measureValues == null) {
                vpdValuesStored.add(0.0);
            } else {
                vpdValuesStored.add(measureValues);
            }
        }
        combinedDoubleListInApi = buildCombinedDoubleList(dateStoredList, vpdValuesStored);
    }

    public void getDateAndNdviValues() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Double> ndviValuesStored = new ArrayList<>();
        for (Double measureValues : ndviValues) {
            if (measureValues == null) {
                ndviValuesStored.add(0.0);
            } else {
                ndviValuesStored.add(measureValues);
            }
        }
        combinedDoubleListInApi = buildCombinedDoubleList(dateStoredList, ndviValuesStored);
    }

    public void getDateAndPrecipValues() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Double> precipValuesStored = new ArrayList<>();
        for (Double measureValues : precipValues) {
            if (measureValues == null) {
                precipValuesStored.add(0.0);
            } else {
                precipValuesStored.add(measureValues);
            }
        }
        combinedDoubleListInApi = buildCombinedDoubleList(dateStoredList, precipValuesStored);
    }

    public void getDateAndRhValues() throws ParseException {
        List<String> dateStoredList = formatDateList(dateInApi);
        List<Integer> rhValuesStored = new ArrayList<>();
        for (Double measureValues : rhValues) {
            if (measureValues == null) {
                rhValuesStored.add(0);
            } else {
                int roundedApiValue = (int) Math.round(measureValues * 100);
                rhValuesStored.add(roundedApiValue);
            }
        }
        combinedIntegerListInApi = buildCombinedIntegerList(dateStoredList, rhValuesStored);
    }

    public void getDateAndSoilMoistureAvg() {
        try {
            List<String> dateStoredList = formatDateList(dateInApi);
            List<List<Double>> moistureMeanLists = formatMoistureMeanLists(Arrays.asList(
                    moistureMean10cm, moistureMean20cm, moistureMean30cm, moistureMean40cm,
                    moistureMean50cm, moistureMean60cm, moistureMean70cm, moistureMean80cm,
                    moistureMean90cm, moistureMean100cm, moistureMean110cm, moistureMean120cm));
            List<Double> moistureMeanAvgValueStored = calculateAverageValues(moistureMeanLists);
            combinedDoubleListInApi = buildCombinedDoubleList(dateStoredList, moistureMeanAvgValueStored);
        } catch (Exception exc) {
            exc.printStackTrace();
            Assert.fail("Failed to add the values into the list due to exception: " + exc.getMessage());
        }
    }

    private List<List<Double>> formatMoistureMeanLists(List<List<Double>> moistureMeanLists) {
        List<List<Double>> roundedMeanLists = new ArrayList<>();
        for (List<Double> meanList : moistureMeanLists) {
            List<Double> roundedList = new ArrayList<>();
            for (Double meanValue : meanList) {
                if (meanValue != null) {
                    double value = Math.round(meanValue * 10.0) / 10.0;
                    roundedList.add(value);
                }
            }
            roundedMeanLists.add(roundedList);
        }
        return roundedMeanLists;
    }

    private List<Double> calculateAverageValues(List<List<Double>> moistureMeanLists) {
        List<Double> moistureMeanAvgValueStored = new ArrayList<>();
        for (int i = 0; i < moistureMeanLists.get(0).size(); i++) {
            List<Double> indexValues = getIndexValues(moistureMeanLists, i);
            double sum = indexValues.stream()
                    .filter(value -> value != 0.0)
                    .mapToDouble(Double::doubleValue)
                    .sum();
            int nonZeroCount = (int) indexValues.stream().filter(value -> value != 0.0).count();
            double sumAverage = Math.round((sum / nonZeroCount) * 10.0) / 10.0;
            moistureMeanAvgValueStored.add(sumAverage);
        }
        return moistureMeanAvgValueStored;
    }

    private List<Double> getIndexValues(List<List<Double>> moistureMeanLists, int index) {
        List<Double> indexValues = new ArrayList<>();
        for (List<Double> moistureMeanList : moistureMeanLists) {
            if (index < moistureMeanList.size()) {
                indexValues.add(moistureMeanList.get(index));
            }
        }
        return indexValues;
    }

    private List<String> formatDateList(List<String> dateList) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        List<String> formattedDates = new ArrayList<>();
        for (String formattedDate : dateList) {
            Date date = inputFormat.parse(formattedDate);
            formattedDates.add(outputFormat.format(date));
        }
        return formattedDates;
    }

    private List<Map.Entry<String, Double>> buildCombinedDoubleList(List<String> dates, List<Double> values) {
        List<Map.Entry<String, Double>> combinedList = new ArrayList<>();
        int size = Math.min(dates.size(), values.size());
        for (int i = 0; i < size; i++) {
            String dateElement = dates.get(i);
            Double valueElement = values.get(i);
            Map.Entry<String, Double> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedList.add(elementPair);
        }
        return combinedList;
    }

    private List<Map.Entry<String, Integer>> buildCombinedIntegerList(List<String> dates, List<Integer> values) {
        List<Map.Entry<String, Integer>> combinedList = new ArrayList<>();
        int size = Math.min(dates.size(), values.size());
        for (int i = 0; i < size; i++) {
            String dateElement = dates.get(i);
            Integer valueElement = values.get(i);
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedList.add(elementPair);
        }
        return combinedList;
    }

    public void getSummaryRequestForGraph() throws JsonProcessingException, InterruptedException {
        String summaryUrl = TimelineText + "?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&site_id=" + siteId + "&limit=10000" + "&start_time=" + selectedStartDateStrText + "&";
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/data/" + summaryUrl);
        Thread.sleep(10000);
        if (response != null && response.getStatusCode() == 200) {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            for (JsonNode node : rootNode) {
                String Date = node.get("time").asText();
                Double swdw = node.get("swdw").asDouble();
                dateApi.add(Date);
                swdwValues.add(swdw);
            }
        }
    }

    public void getSummaryRequestForGraphForHourly() throws JsonProcessingException, InterruptedException {
        String summaryUrl = TimelineText + "?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&site_id=" + siteId + "&limit=10000" + "&start_time=" + startTimeFormatted + "&end_time=" + endTimeFormatted + "&local_time=" + siteZone;
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/data/" + summaryUrl);
        if (response != null && response.getStatusCode() == 200) {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            log.info("Graph hourly summary Api response data to check=" + rootNode.toString());
            for (JsonNode node : rootNode) {
                String time = node.get("local_time").asText();
                Double swdw = node.get("swdw").asDouble();
                Double etc = node.get("etc").asDouble();
                Double lfw = node.get("lfw").asDouble();
                Double precip = node.get("precip").asDouble();
                Double rh = node.get("rh").asDouble();
                Double vpd = node.get("vpd").asDouble();
                Double maxt = node.get("maxt").asDouble();
                Double mint = node.get("mint").asDouble();
                Double wind = node.get("wind_speed").asDouble();
                wind_speedValue.add(wind);
                listLocalTime.add(time);
                swdwValues.add(swdw);
                etcApiValue.add(etc);
                lfwValue.add(lfw);
                precipValue.add(precip);
                relativeHumidityValue.add(rh);
                vpdValue.add(vpd);
                maxtValue.add(maxt);
                mintValue.add(mint);
            }
        }
    }

    public void getDateSwdw() throws ParseException {
        List<String> dateStoredList = new ArrayList<>();
        List<Integer> swdwValuesStored = new ArrayList<>();
        for (String formattedDate : dateApi) {
            SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            SimpleDateFormat outputFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date date1 = inputFormat1.parse(formattedDate);
            String formattedDate1 = outputFormat1.format(date1);
            dateStoredList.add(formattedDate1);
        }
        for (Double swdwValuesValue : swdwValues) {
            int gddApiValueRounded = (int) Math.round(swdwValuesValue);
            swdwValuesStored.add(gddApiValueRounded);
        }
        combinedListInApi = new ArrayList<Map.Entry<String, Integer>>();
        int size = Math.min(dateStoredList.size(), swdwValuesStored.size());
        for (int i = 0; i < size; i++) {
            String dateElement = dateStoredList.get(i);
            int valueElement = swdwValuesStored.get(i);
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedListInApi.add(elementPair);
        }
    }

    public void getDateETcForHourly() {
        List<String> timeStoredList = new ArrayList<>();
        List<Integer> etcValuesStored = new ArrayList<>();
        for (String formattedDate : listLocalTime) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
            ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
            String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
            timeStoredList.add(formattedDate1.toUpperCase());
        }
        for (Double swdwValuesValue : etcApiValue) {
            int gddApiValueRounded = (int) Math.round(swdwValuesValue);
            etcValuesStored.add(gddApiValueRounded);
        }
        combinedListInApiHourly = new ArrayList<Map.Entry<String, Integer>>();
        int size = Math.min(timeStoredList.size(), etcValuesStored.size());
        for (int i = 0; i < size; i++) {
            String dateElement = timeStoredList.get(i);
            int valueElement = etcValuesStored.get(i);
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedListInApiHourly.add(elementPair);
        }
    }

    public void getDateLeafWetnessForHourly() {
        List<String> timeStoredList = new ArrayList<>();
        List<Integer> ifwValuesStored = new ArrayList<>();
        for (String formattedDate : listLocalTime) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
            ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
            String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
            timeStoredList.add(formattedDate1);
        }
        for (Double lfwValuesValue : lfwValue) {
            int ifwApiValueRounded = (int) Math.round(lfwValuesValue);
            ifwValuesStored.add(ifwApiValueRounded);
        }
        combinedListInApiHourly = new ArrayList<Map.Entry<String, Integer>>();
        int size = Math.min(timeStoredList.size(), ifwValuesStored.size());
        for (int i = 0; i < size; i++) {
            String dateElement = timeStoredList.get(i);
            int valueElement = ifwValuesStored.get(i);
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedListInApiHourly.add(elementPair);
        }
    }

    public void getDatePrecipitationForHourly() {
        List<String> timeStoredList = new ArrayList<>();
        List<Integer> precipValuesStored = new ArrayList<>();
        for (String formattedDate : listLocalTime) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
            ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
            String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
            timeStoredList.add(formattedDate1);
        }
        for (Double precipValuesValue : precipValue) {
            int precipApiValueRounded = (int) Math.round(precipValuesValue);
            precipValuesStored.add(precipApiValueRounded);
        }
        combinedListInApiHourly = new ArrayList<Map.Entry<String, Integer>>();
        int size = Math.min(timeStoredList.size(), precipValuesStored.size());
        for (int i = 0; i < size; i++) {
            String dateElement = timeStoredList.get(i);
            int valueElement = precipValuesStored.get(i);
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedListInApiHourly.add(elementPair);
        }
    }

    public void getDateSolarRadiationForHourly() {
        List<String> timeStoredList = new ArrayList<>();
        List<Integer> swdwValuesStored = new ArrayList<>();
        for (String formattedDate : listLocalTime) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
            ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
            String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
            timeStoredList.add(formattedDate1);
        }
        for (Double swdwValuesValue : swdwValues) {
            int swdwApiValueRounded = (int) Math.round(swdwValuesValue);
            swdwValuesStored.add(swdwApiValueRounded);
        }
        combinedListInApiHourly = new ArrayList<Map.Entry<String, Integer>>();
        int size = Math.min(timeStoredList.size(), swdwValuesStored.size());
        for (int i = 0; i < size; i++) {
            String dateElement = timeStoredList.get(i);
            int valueElement = swdwValuesStored.get(i);
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedListInApiHourly.add(elementPair);
        }
    }

    public void fetchSitesZone() {
        restAssuredHelper.setBaseURI((PropertiesReader.apiSeverUrl));
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/" + siteId);
        siteZone = response.path("tz_name");
    }

    public void getDateRelativeHumidityForHourly() {
        List<String> timeStoredList = new ArrayList<>();
        List<Integer> rhValuesStored = new ArrayList<>();
        for (String formattedDate : listLocalTime) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
            ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
            String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
            timeStoredList.add(formattedDate1);
        }
        for (Double rhValuesValue : relativeHumidityValue) {
            int rhPercentage = (int) Math.round(rhValuesValue * 100);
            rhValuesStored.add(rhPercentage);
        }
        combinedListInApiHourly = new ArrayList<Map.Entry<String, Integer>>();
        int size = Math.min(timeStoredList.size(), rhValuesStored.size());
        for (int i = 0; i < size; i++) {
            String dateElement = timeStoredList.get(i);
            int valueElement = rhValuesStored.get(i);
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedListInApiHourly.add(elementPair);
        }
    }

    public void getDateVaporPressureForHourly() {
        List<String> timeStoredList = new ArrayList<>();
        List<Double> vpdValuesStored = new ArrayList<>();
        for (String formattedDate : listLocalTime) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
            ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
            String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
            timeStoredList.add(formattedDate1);
        }
        for (Double vpdValuesValue : vpdValue) {
            vpdValuesStored.add(vpdValuesValue);
        }
        combinedListInDoubleApiHourly = new ArrayList<Map.Entry<String, Double>>();
        int size = Math.min(timeStoredList.size(), vpdValuesStored.size());
        for (int i = 0; i < size; i++) {
            String dateElement = timeStoredList.get(i);
            Double valueElement = vpdValuesStored.get(i);
            Map.Entry<String, Double> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedListInDoubleApiHourly.add(elementPair);
        }
    }

    public void getAverageValueSoilTemp() throws InterruptedException, JsonProcessingException {
        String summaryUrl = "sentek_" + TimelineText + "?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&site_id=" + siteId + "&limit=10000" + "&start_time=" + selectedStartDateStrText + "&";
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/data/" + summaryUrl);
        Thread.sleep(3000);
        if (response != null && response.getStatusCode() == 200) {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            Float numb = (float) 0;
            int count = 0;
            log.info("SOIL Api response data to be verified=" + rootNode.toString());
            for (JsonNode node : rootNode) {
                String Date = node.get("time").asText();
                String value0 = node.get("temp_0_mean").asText();
                String value1 = node.get("temp_1_mean").asText();
                String value2 = node.get("temp_2_mean").asText();
                String value3 = node.get("temp_3_mean").asText();
                String value4 = node.get("temp_4_mean").asText();
                String value5 = node.get("temp_5_mean").asText();
                String value6 = node.get("temp_6_mean").asText();
                String value7 = node.get("temp_7_mean").asText();
                String value8 = node.get("temp_8_mean").asText();
                String value9 = node.get("temp_9_mean").asText();
                String value10 = node.get("temp_10_mean").asText();
                String value11 = node.get("temp_11_mean").asText();
                String value12 = node.get("temp_12_mean").asText();
                String value13 = node.get("temp_13_mean").asText();
                String value14 = node.get("temp_14_mean").asText();
                List<String> elements = new ArrayList<>(Arrays.asList(value0, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14));
                for (int i = 0; i < elements.size(); i++) {
                    if (!"null".equals(elements.get(i))) {
                        int average = Math.round(Float.parseFloat(elements.get(i)));
                        numb += average;
                        count++;
                    }
                }
                int average = Math.round(numb / count);
                averageLength.add(average);
                numb = 0.0f;
                count = 0;
                dateApi.add(Date);
            }
        }
    }

    public void getSoilTemperatureDaily() throws ParseException {
        try {
            List<String> dateStoredList = new ArrayList<>();
            for (String formattedDate : dateApi) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
                ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH).withZone(parsedDateTime.getZone());
                dateStoredList.add(parsedDateTime.format(outputFormatter));
            }
            List<Integer> soilTempValuesStored = new ArrayList<>(averageLength);
            int size = Math.min(dateStoredList.size(), soilTempValuesStored.size());
            for (int i = 0; i < size; i++) {
                String dateElement = dateStoredList.get(i);
                Integer valueElement = soilTempValuesStored.get(i);
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
                combinedListInApiDaily.add(elementPair);
            }
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getSummaryRequestForGraphForHourlyy() throws JsonProcessingException, InterruptedException {
        String summaryUrl = "sentek_" + TimelineText + "?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&site_id=" + siteId + "&limit=1000" + "&start_time=" + startTimeFormatted + "&end_time=" + endTimeFormatted + "&local_time=" + siteZone;
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/data/" + summaryUrl);
        Thread.sleep(3000);
        if (response != null && response.getStatusCode() == 200) {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            Float numb = (float) 0;
            int count = 0;
            for (JsonNode node : rootNode) {
                String Date = node.get("time").asText();
                String value0 = node.get("temp_0_mean").asText();
                String value1 = node.get("temp_1_mean").asText();
                String value2 = node.get("temp_2_mean").asText();
                String value3 = node.get("temp_3_mean").asText();
                String value4 = node.get("temp_4_mean").asText();
                String value5 = node.get("temp_5_mean").asText();
                String value6 = node.get("temp_6_mean").asText();
                String value7 = node.get("temp_7_mean").asText();
                String value8 = node.get("temp_8_mean").asText();
                String value9 = node.get("temp_9_mean").asText();
                String value10 = node.get("temp_10_mean").asText();
                String value11 = node.get("temp_11_mean").asText();
                String value12 = node.get("temp_12_mean").asText();
                String value13 = node.get("temp_13_mean").asText();
                String value14 = node.get("temp_14_mean").asText();
                List<String> elements = new ArrayList<>(Arrays.asList(value0, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14));
                for (int i = 0; i < elements.size(); i++) {
                    if (!"null".equals(elements.get(i))) {
                        int average = Math.round(Float.parseFloat(elements.get(i)));
                        numb += average;
                        count++;
                    }
                }
                int average = Math.round(numb / count);
                averageLength.add(average);
                numb = 0.0f;
                count = 0;
                dateApi.add(Date);
            }
        }
    }

    public void getSoilTemperatureHourly() throws ParseException {
        try {
            List<String> dateStoredList = new ArrayList<>();
            for (String formattedDate : dateApi) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
                ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
                String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
                dateStoredList.add(formattedDate1);
            }
            List<Integer> soilTempValuesStored = new ArrayList<>(averageLength);
            combinedListInApiHourly = new ArrayList<>();
            int size = Math.min(dateStoredList.size(), soilTempValuesStored.size());
            for (int i = 0; i < size; i++) {
                String dateElement = dateStoredList.get(i);
                Integer valueElement = soilTempValuesStored.get(i);
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
                combinedListInApiHourly.add(elementPair);
            }
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getSummaryRequestForGraphForHourlyFromApi() throws JsonProcessingException, InterruptedException {
        String summaryUrl = TimelineText + "?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&site_id=" + siteId + "&limit=1000" + "&start_time=" + startTimeFormatted + "&end_time=" + endTimeFormatted + "&local_time=" + siteZone;
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/data/" + summaryUrl);
        Thread.sleep(3000);
        if (response != null && response.getStatusCode() == 200) {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            log.info("Graph hourly summary Api response data to be verified=" + rootNode.toString());
            double numbmoisture = (float) 0;
            double numb = 0.0;
            int count = 0;
            int countM = 0;
            for (JsonNode node : rootNode) {
                String Date = node.get("local_time").asText();
                String value0 = node.get("temp_0_mean").asText();
                String value1 = node.get("temp_1_mean").asText();
                String value2 = node.get("temp_2_mean").asText();
                String value3 = node.get("temp_3_mean").asText();
                String value4 = node.get("temp_4_mean").asText();
                String value5 = node.get("temp_5_mean").asText();
                String value6 = node.get("temp_6_mean").asText();
                String value7 = node.get("temp_7_mean").asText();
                String value8 = node.get("temp_8_mean").asText();
                String value9 = node.get("temp_9_mean").asText();
                String value10 = node.get("temp_10_mean").asText();
                String value11 = node.get("temp_11_mean").asText();
                String value12 = node.get("temp_12_mean").asText();
                String value13 = node.get("temp_13_mean").asText();
                String value14 = node.get("temp_14_mean").asText();
                String moistureValue0 = node.get("moisture_0_mean").asText();
                String moistureValue1 = node.get("moisture_1_mean").asText();
                String moistureValue2 = node.get("moisture_2_mean").asText();
                String moistureValue3 = node.get("moisture_3_mean").asText();
                String moistureValue4 = node.get("moisture_4_mean").asText();
                String moistureValue5 = node.get("moisture_5_mean").asText();
                String moistureValue6 = node.get("moisture_6_mean").asText();
                String moistureValue7 = node.get("moisture_7_mean").asText();
                String moistureValue8 = node.get("moisture_8_mean").asText();
                String moistureValue9 = node.get("moisture_9_mean").asText();
                String moistureValue10 = node.get("moisture_10_mean").asText();
                String moistureValue11 = node.get("moisture_11_mean").asText();
                String moistureValue12 = node.get("moisture_12_mean").asText();
                String moistureValue13 = node.get("moisture_13_mean").asText();
                String moistureValue14 = node.get("moisture_14_mean").asText();
                List<String> elements = new ArrayList<>(Arrays.asList(value0, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14));
                for (int i = 0; i < elements.size(); i++) {
                    if (!"null".equals(elements.get(i))) {
                        int doubleValue = Math.round(Float.parseFloat(elements.get(i)));
                        numb += doubleValue;
                        count++;
                    }
                }
                int average = (int) Math.round(numb / count);
                averageLength.add(average);
                List<String> moisture = new ArrayList<>(Arrays.asList(moistureValue0, moistureValue1, moistureValue2, moistureValue3, moistureValue4, moistureValue5, moistureValue6, moistureValue7, moistureValue8, moistureValue9, moistureValue10, moistureValue11, moistureValue12, moistureValue13, moistureValue14));
                for (int i = 0; i < moisture.size(); i++) {
                    if (!"null".equals(moisture.get(i))) {
                        double averageMoisture = Double.parseDouble((moisture.get(i)));
                        numbmoisture += averageMoisture;
                        countM++;
                    }
                }
                DecimalFormat df = new DecimalFormat("#.#");
                df.setGroupingUsed(false);
                double moistureDouble = Double.parseDouble(df.format(numbmoisture / countM));
                averageLengthMoisture.add(moistureDouble);
                numb = 0;
                numbmoisture = 0.0;
                count = 0;
                countM = 0;
                dateApi.add(Date);
            }
        }
    }

    public void getSoilMoistureHourly() {
        try {
            List<String> dateStoredList = new ArrayList<>();
            for (String formattedDate : dateApi) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
                ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
                String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
                dateStoredList.add(formattedDate1);
            }
            List<Double> soilTempValuesStored = new ArrayList<>(averageLengthMoisture);
            int size = Math.min(dateStoredList.size(), soilTempValuesStored.size());
            for (int i = 0; i < size; i++) {
                String dateElement = dateStoredList.get(i);
                Double valueElement = soilTempValuesStored.get(i);
                Map.Entry<String, Double> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
                combinedListInDoubleApiHourly.add(elementPair);
            }
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getSoilTemperatureHourlyForSingleSites() {
        try {
            List<String> dateStoredList = new ArrayList<>();
            for (String formattedDate : dateApi) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
                ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-h:mma").withZone(parsedDateTime.getZone());
                String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
                dateStoredList.add(formattedDate1);
            }
            List<Integer> soilTempValuesStored = new ArrayList<>(averageLength);
            int size = Math.min(dateStoredList.size(), soilTempValuesStored.size());
            for (int i = 0; i < size; i++) {
                String dateElement = dateStoredList.get(i);
                Integer valueElement = soilTempValuesStored.get(i);
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
                combinedListInApiHourly.add(elementPair);
            }
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getSoilTemperatureHourlyForTwoSites() {
        try {
            List<String> dateStoredList = new ArrayList<>();
            for (String formattedDate : dateApi) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
                ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
                String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
                dateStoredList.add(formattedDate1);
            }
            List<Integer> soilTempValuesStored = new ArrayList<>(averageLength);
            int size = Math.min(dateStoredList.size(), soilTempValuesStored.size());
            for (int i = 0; i < size; i++) {
                String dateElement = dateStoredList.get(i);
                Integer valueElement = soilTempValuesStored.get(i);
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
                combinedListInApiHourly.add(elementPair);
            }
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getSoilMoistureHourlyForSingleSite() {
        try {
            List<String> dateStoredList = new ArrayList<>();
            for (String formattedDate : dateApi) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
                ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-h:mma").withZone(parsedDateTime.getZone());
                String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
                dateStoredList.add(formattedDate1);
            }
            List<Double> soilTempValuesStored = new ArrayList<>(averageLengthMoisture);
            int size = Math.min(dateStoredList.size(), soilTempValuesStored.size());
            for (int i = 0; i < size; i++) {
                String dateElement = dateStoredList.get(i);
                Double valueElement = soilTempValuesStored.get(i);
                Map.Entry<String, Double> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
                combinedListInDoubleApiHourly.add(elementPair);
            }
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getSummaryRequestForHistoricalHourly() throws JsonProcessingException, InterruptedException {
        String summaryUrl = siteId + "/historical?temp=" + tempUnit + "&pres=" + presUnit + "&size=" + sizeUnit + "&speed=" + speedUnit + "&start_date=" + startTimeFormatted + "&end_date=" + endTimeFormatted + "&resolution=hourly&params=wind_speed,wind_direction";
        restAssuredHelper.setBaseURI(PropertiesReader.apiSeverUrl);
        restAssuredHelper.setAuthToken(token);
        response = restAssuredHelper.getRequest(PropertiesReader.apiVersion + "/sites/" + summaryUrl);
        Thread.sleep(3000);
        if (response != null && response.getStatusCode() == 200) {
            String jason = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jason);
            JsonNode hourlyArray = rootNode.get("hourly");
            if (hourlyArray != null && hourlyArray.isArray()) {
                for (JsonNode dailyNode : hourlyArray) {
                    String time = dailyNode.has("time") ? dailyNode.get("time").asText() : null;
                    Double windSpeed = dailyNode.has("wind_speed") ? dailyNode.get("wind_speed").asDouble() : null;
                    Double windSpeedMax = dailyNode.has("wind_speed_max") ? dailyNode.get("wind_speed_max").asDouble() : null;
                    listLocalTimeHistorical.add(time);
                    wind_speedValueHistorical.add(windSpeed);
                    wind_speed_maxValue.add(windSpeedMax);
                }
            }
        }
    }

    public void getDateMinAndMaxTempForHourly() throws ParseException {
        try {
            List<String> dateStoredList = new ArrayList<>();
            List<Integer> minTempValuesStored = new ArrayList<>();
            List<Integer> maxtempValuesStored = new ArrayList<>();
            for (String formattedDate : listLocalTime) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
                ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
                String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM").toUpperCase();
                dateStoredList.add(formattedDate1);
            }
            for (Double measureValues : maxtValue) {
                if (measureValues == null) {
                    maxtempValuesStored.add(0);
                } else {
                    BigDecimal roundedValue = BigDecimal.valueOf(measureValues).setScale(0, BigDecimal.ROUND_HALF_UP);
                    maxtempValuesStored.add(roundedValue.intValue());
                }
            }
            for (Double measureValues : mintValue) {
                if (measureValues == null) {
                    minTempValuesStored.add(0);
                } else {
                    BigDecimal roundedValue = BigDecimal.valueOf(measureValues).setScale(0, BigDecimal.ROUND_HALF_UP);
                    minTempValuesStored.add(roundedValue.intValue());
                }
            }
            combinedListInApiHourly = new ArrayList<>();
            int size = Math.min(dateStoredList.size(), maxtempValuesStored.size());
            for (int i = 0; i < size; i++) {
                String dateElement = dateStoredList.get(i);
                Integer valueElement = maxtempValuesStored.get(i);
                Integer valueOfThirdElement = minTempValuesStored.get(i);
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
                combinedListInApiHourly.add(elementPair);
                combinedListInApiHourly.add(new AbstractMap.SimpleEntry<>(dateElement, valueOfThirdElement));
            }
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getDateAndMaxTempForHourly() throws ParseException {
        List<String> dateStoredList = new ArrayList<>();
        List<Integer> maxTempValuesStored = new ArrayList<>();
        for (String formattedDate : listLocalTime) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
            ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
            String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
            dateStoredList.add(formattedDate1);
        }
        for (Double measureValues : maxtValue) {
            if (measureValues == null) {
                maxTempValuesStored.add(0);
            } else {
                BigDecimal roundedValue = BigDecimal.valueOf(measureValues).setScale(0, BigDecimal.ROUND_HALF_UP);
                maxTempValuesStored.add(roundedValue.intValue());
            }
        }
        int size = Math.min(dateStoredList.size(), maxTempValuesStored.size());
        for (int i = 0; i < size; i++) {
            String dateElement = dateStoredList.get(i);
            Integer valueElement = maxTempValuesStored.get(i);
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedListInApiHourly.add(elementPair);
        }
    }

    public void getDateAndMinTempForHourly() throws ParseException {
        List<String> dateStoredList = new ArrayList<>();
        List<Integer> minTempValuesStored = new ArrayList<>();
        for (String formattedDate : listLocalTime) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
            ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
            String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
            dateStoredList.add(formattedDate1);
        }
        for (Double measureValues : mintValue) {
            if (measureValues == null) {
                minTempValuesStored.add(0);
            } else {
                BigDecimal roundedValue = BigDecimal.valueOf(measureValues).setScale(0, BigDecimal.ROUND_HALF_UP);
                minTempValuesStored.add(roundedValue.intValue());
            }
        }
        combinedListInApiHourly = new ArrayList<>();
        int size = Math.min(dateStoredList.size(), minTempValuesStored.size());
        for (int i = 0; i < size; i++) {
            String dateElement = dateStoredList.get(i);
            Integer valueElement = minTempValuesStored.get(i);
            Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
            combinedListInApiHourly.add(elementPair);
        }
    }

    public void getDateAndWindSpeedForHourly() {
        try {
            List<String> dateStoredList = new ArrayList<>();
            for (String formattedDate : listLocalTime) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
                ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:mm a").withZone(parsedDateTime.getZone());
                String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
                dateStoredList.add(formattedDate1);
            }
            List<Integer> windSpeedValuesStored = new ArrayList<>();
            for (Double measureValues : wind_speedValue) {
                if (measureValues == null) {
                    windSpeedValuesStored.add(0);
                } else {
                    int roundedApiValue = (int) Math.round(measureValues);
                    windSpeedValuesStored.add(roundedApiValue);
                }
            }
            int size = Math.min(dateStoredList.size(), windSpeedValuesStored.size());
            for (int i = 0; i < size; i++) {
                String dateElement = dateStoredList.get(i);
                Integer valueElement = windSpeedValuesStored.get(i);
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
                combinedListInApiHourly.add(elementPair);
            }
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

    public void getDateAndWindSpeedForHourlyForHistorical() {
        try {
            List<String> dateStoredList = new ArrayList<>();
            for (String formattedDate : listLocalTimeHistorical) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
                ZonedDateTime parsedDateTime = ZonedDateTime.parse(formattedDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-hh:00 a").withZone(parsedDateTime.getZone());
                String formattedDate1 = parsedDateTime.format(outputFormatter).replace("am", "AM").replace("pm", "PM");
                dateStoredList.add(formattedDate1);
            }
            List<Integer> windSpeedValuesStored = new ArrayList<>();
            for (Double measureValues : wind_speedValueHistorical) {
                if (measureValues == null) {
                    windSpeedValuesStored.add(0);
                } else {
                    int roundedApiValue = (int) Math.round(measureValues);
                    windSpeedValuesStored.add(roundedApiValue);
                }
            }
            int size = Math.min(dateStoredList.size(), windSpeedValuesStored.size());
            for (int i = 0; i < size; i++) {
                String dateElement = dateStoredList.get(i);
                Integer valueElement = windSpeedValuesStored.get(i);
                Map.Entry<String, Integer> elementPair = new AbstractMap.SimpleEntry<>(dateElement, valueElement);
                combinedListInApiHourly.add(elementPair);
            }
        } catch (Exception exc) {
            Assert.fail("Failed to add the values into the list due to exception:- " + exc);
        }
    }

}

