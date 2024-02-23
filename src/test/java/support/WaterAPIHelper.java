package support;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static support.World.token;

public class WaterAPIHelper {

    private final Double replacement_etc;
    private final Double precipitation;
    private final Double irrigation;
    private final Double water_balance;
    private final int heat_stress_hours_cumulative;
    private final Double refill_proximity;
    private final Double irrigation_runtime_hours;
    private final Double etc;
    private final IrrigationTimeToReplaceET irrigation_time_to_replace_et;
    private final Double soil_moisture;
    private final Double soil_moisture_change;


    public WaterAPIHelper(Double replacement_etc, Double precipitation, Double irrigation, Double water_balance, Integer heat_stress_hours_cumulative, Double refill_proximity, Double irrigation_runtime_hours, Double etc, IrrigationTimeToReplaceET irrigation_time_to_replace_et, Double soil_moisture, Double soil_moisture_change) {
        this.replacement_etc = replacement_etc;
        this.precipitation = precipitation;
        this.irrigation = irrigation;
        this.water_balance = water_balance;
        this.heat_stress_hours_cumulative = heat_stress_hours_cumulative;
        this.refill_proximity = refill_proximity;
        this.irrigation_runtime_hours = irrigation_runtime_hours;
        this.etc = etc;
        this.irrigation_time_to_replace_et = irrigation_time_to_replace_et;
        this.soil_moisture = soil_moisture;
        this.soil_moisture_change = soil_moisture_change;
    }

    public WaterAPIHelper(Double replacement_etc, Double precipitation, Double irrigation, Double water_balance, Double etc, IrrigationTimeToReplaceET irrigationTimeToReplaceEt) {
        this.replacement_etc = replacement_etc;
        this.precipitation = precipitation;
        this.irrigation = irrigation;
        this.water_balance = water_balance;
        this.etc = etc;
        irrigation_time_to_replace_et = irrigationTimeToReplaceEt;
        this.heat_stress_hours_cumulative = 0;
        this.refill_proximity = null;
        this.irrigation_runtime_hours = null;
        this.soil_moisture = null;
        this.soil_moisture_change = null;
    }
    public static List<GrowthStageInfo> extractGrowthStageInfo(String json) {
        List<GrowthStageInfo> growthStageInfos = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(json);

            for (JsonNode node : jsonNode) {
                String name = node.get("name").asText();
                double etcReplacementRatio = node.get("etc_replacement_ratio").asDouble();

                growthStageInfos.add(new GrowthStageInfo(name, etcReplacementRatio));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return growthStageInfos;
    }

public static WaterAPIHelper extractSummaryAPIResponse(String role) throws IOException, InterruptedException {
    String requiredUrl = SharedData.specificRequestUrl;
    System.out.println("requiredUrl:-" + requiredUrl);

    final int maxAttempts = 3;
    int attempt = 0;
    JSONObject jsonObject = null;
    while (attempt < maxAttempts) {
        try {
            String jsonResponse = fetchJSONResponse(requiredUrl, token);
            jsonObject = new JSONObject(jsonResponse);
            System.out.println("jsonObject:-" + jsonObject);
            break;
        } catch (IOException | JSONException e) {
            attempt++;
            System.err.println("Exception occurred during JSON fetch attempt " + attempt + ": " + e.getMessage());
            if (attempt == maxAttempts) {
                throw new IOException("Failed to fetch JSON response after " + maxAttempts + " attempts");
            }
            Thread.sleep(1000);
        }
    }
    if (jsonObject == null) {
        throw new IOException("Failed to fetch JSON response after " + maxAttempts + " attempts");
    }
    System.out.println("entering water metrics:-" + jsonObject);

    JSONObject waterMetrics = jsonObject.getJSONObject("water_metrics");
    System.out.println("waterMetrics:-" + waterMetrics);
    JSONObject summary = waterMetrics.getJSONObject("summary");
    System.out.println("summary:-" + summary);

    IrrigationTimeToReplaceET irrigationTimeToReplaceET = null;

    Double refill_proximity = null;
    Double irrigation_runtime_hours = null;
    double etc = summary.getDouble("etc");
    double precipitation = summary.getDouble("precipitation");
    double water_balance = summary.getDouble("water_balance");
    Double irrigation = summary.isNull("irrigation") ? null : summary.getDouble("irrigation");
    Double replacement_etc = summary.isNull("replacement_etc") ? null : summary.getDouble("replacement_etc");
    Integer heat_stress_hours_cumulative = summary.isNull("heat_stress_hours_cumulative") ? null : summary.getInt("heat_stress_hours_cumulative");
    Double soil_moisture = summary.isNull("soil_moisture") ? null : summary.getDouble("soil_moisture");
    Double soil_moisture_change = summary.isNull("soil_moisture_change") ? null : summary.getDouble("soil_moisture_change");
    return new WaterAPIHelper(replacement_etc, precipitation, irrigation, water_balance, heat_stress_hours_cumulative, refill_proximity, irrigation_runtime_hours, etc, irrigationTimeToReplaceET, soil_moisture, soil_moisture_change);
}

public static WaterAPIHelper extractForecast(String role) throws IOException, InterruptedException {
    String requiredUrl = SharedData.specificRequestUrl;
    System.out.println("requiredUrl:-" + requiredUrl);

    final int maxAttempts = 3;
    int attempt = 0;
    JSONObject jsonObject = null;
    while (attempt < maxAttempts) {
        try {
            String jsonResponse = fetchJSONResponse(requiredUrl, token);
            Thread.sleep(10000);
            jsonObject = new JSONObject(jsonResponse);
            Thread.sleep(6000);
            break;
        } catch (IOException | JSONException e) {
            attempt++;
            Thread.sleep(5000);
        }
    }
    assert jsonObject != null;
    JSONObject waterMetrics = jsonObject.getJSONObject("water_metrics");
    System.out.println("waterMetrics:-" + waterMetrics);
    Thread.sleep(6000);
    JSONObject forecast = waterMetrics.getJSONObject("forecast");
    System.out.println("forecast:-" + forecast);
    Thread.sleep(5000);

    double etc = forecast.getDouble("etc");
    double precipitation = forecast.getDouble("precipitation");
    double waterBalance = forecast.getDouble("water_balance");
    Double irrigation = null;
    if (!forecast.isNull("irrigation")) {
        irrigation = forecast.getDouble("irrigation");
    }
    Double replacement_etc = null;
    if (!forecast.isNull("replacement_etc")) {
        replacement_etc = forecast.getDouble("replacement_etc");
    }
    return new WaterAPIHelper(replacement_etc, precipitation, irrigation, waterBalance, etc, null);
}



private static Double getDoubleOrNull(JSONObject jsonObject, String key) {
    if (jsonObject.isNull(key)) {
        return null;
    }
    return jsonObject.getDouble(key);
}

public Double getReplacementEtc() {
    return replacement_etc;
}

public Double getPrecipitation() {
    return precipitation;
}

public Double getIrrigation() {
    return irrigation;
}

public Double getwaterBalance() {
    return water_balance;
}

public int getHeatStressHoursCumulative() {
    return heat_stress_hours_cumulative;
}

public Double getRefillProximity() {
    return refill_proximity;
}

public Double getIrrigationRuntimeHours() {
    return irrigation_runtime_hours;
}

public Double getSoil_Moisture() {
    return soil_moisture;
}

public Double getSoil_Moisture_Change() {
    return soil_moisture_change;
}

/*public static WaterAPIHelper extractWaterBalance(String role) throws IOException, InterruptedException {
    String requiredUrl = SharedData.specificRequestUrl;
    System.out.println("requiredUrl:-" + requiredUrl);

    final int maxAttempts = 3;
    int attempt = 0;
    JSONObject jsonObject = null;
    while (attempt < maxAttempts) {
        try {
            String jsonResponse = fetchJSONResponse(requiredUrl, token);
            jsonObject = new JSONObject(jsonResponse);
            break;
        } catch (IOException | JSONException e) {
            attempt++;
        }
    }
    JSONObject waterMetrics = jsonObject.getJSONObject("water_metrics");
    JSONArray waterAggregations = waterMetrics.getJSONArray("water_aggregations");
=======
public static WaterAPIHelper extractWaterBalance(String role) throws IOException, InterruptedException {
    String requiredUrl = SharedData.specificRequestUrl;
    System.out.println("requiredUrl:-" + requiredUrl);
    String jsonResponse = fetchJSONResponse(requiredUrl, token);
    Thread.sleep(10000);
    JSONObject jsonObject = new JSONObject(jsonResponse);
    Thread.sleep(6000);
    JSONObject waterMetrics = jsonObject.getJSONObject("water_metrics");
    Thread.sleep(5000);
    JSONArray waterAggregations = waterMetrics.getJSONArray("water_aggregations");
    Thread.sleep(5000);
>>>>>>> main
    LocalDate currentDate = LocalDate.now();
    String currentDateString = currentDate.toString();

    Double replacement_etc = null;
    Double precipitation = null;
    Double irrigation = null;
    Double heat_stress_hours_cumulative= null;
    Double refill_proximity= null;
    Double irrigation_runtime_hours= null;
    Double etc= null;

    boolean dataFound = false;

    for (int i = 0; i < waterAggregations.length(); i++) {
        JSONObject aggregation = waterAggregations.getJSONObject(i);
        String startDate = aggregation.getString("start_date");
        String stopDate = aggregation.getString("stop_date");

        if (startDate.equals(currentDateString) && stopDate.equals(currentDateString)) {
            replacement_etc = getDoubleOrNull(aggregation, "replacement_etc");
            precipitation = getDoubleOrNull(aggregation, "precipitation");
            irrigation = getDoubleOrNull(aggregation, "irrigation");
            heat_stress_hours_cumulative= getDoubleOrNull(aggregation, "heat_stress_hours_cumulative");
            refill_proximity = getDoubleOrNull(aggregation, "refill_proximity");
            irrigation_runtime_hours = getDoubleOrNull(aggregation, "irrigation_runtime_hours");
            dataFound = true;
            break;
        }
    }

    if (!dataFound) {
        LocalDate previousDate = currentDate.minus(1, ChronoUnit.DAYS);
        String previousDateString = previousDate.toString();

        for (int i = 0; i < waterAggregations.length(); i++) {
            JSONObject aggregation = waterAggregations.getJSONObject(i);
            String startDate = aggregation.getString("start_date");
            String stopDate = aggregation.getString("stop_date");
            if (startDate.equals(previousDateString) && stopDate.equals(previousDateString)) {
                replacement_etc = getDoubleOrNull(aggregation, "replacement_etc");
                precipitation = getDoubleOrNull(aggregation, "precipitation");
                irrigation = getDoubleOrNull(aggregation, "irrigation");
                heat_stress_hours_cumulative= getDoubleOrNull(aggregation, "heat_stress_hours_cumulative");
                refill_proximity = getDoubleOrNull(aggregation, "refill_proximity");
                irrigation_runtime_hours = getDoubleOrNull(aggregation, "irrigation_runtime_hours");
                break;
            }
        }
    }

    double waterBalance = 0.0;
    if (replacement_etc != null && precipitation != null && irrigation != null) {
        waterBalance = precipitation + irrigation - replacement_etc;
    }
<<<<<<< HEAD
    return new WaterAPIHelper(etc,replacement_etc, precipitation, irrigation, waterBalance,heat_stress_hours_cumulative,refill_proximity,irrigation_runtime_hours);
}*/

public Double getEtc() {
    return etc;
}

public IrrigationTimeToReplaceET getIrrigationTimeToReplaceET() {
    return irrigation_time_to_replace_et;
}


    public static String fetchJSONResponse(String urlString, String token) throws IOException {
        StringBuilder response = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + token);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        } finally {
            connection.disconnect();
        }
        return response.toString();
    }
}

