package support;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static support.BrowserCreation.driver;
import static support.WaterAPIHelper.fetchJSONResponse;
import static support.World.token;

public class SeasonAPIHelper {
    public static long start;
    static DevTools devTools;

    public static void devToolCaptureGrowthStageMetricsValue(String role) throws IOException, InterruptedException {
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));

        Map<String, Double> timingMap = new HashMap<>();
        Map<String, String> requestIdMap = new HashMap<>();

        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent -> {
            org.openqa.selenium.devtools.v116.network.model.RequestId requestId = requestWillBeSent.getRequestId();
            double startTime = requestWillBeSent.getTimestamp().toJson().doubleValue();
            String requestUrl = requestWillBeSent.getRequest().getUrl();
            timingMap.put(requestId.toString(), startTime);
            requestIdMap.put(requestId.toString(), requestUrl);
            if (requestUrl.contains("&fields=gdd_metrics")) {
                SharedData.specificRequestUrl = requestUrl;
                System.out.println("requiredUrlForMetrics in dev function:-" + SharedData.specificRequestUrl);
            }
        });
    }

    public static void devToolCaptureGrowthStageWithValue(String role) throws IOException, InterruptedException {
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));

        Map<String, Double> timingMap = new HashMap<>();
        Map<String, String> requestIdMap = new HashMap<>();

        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent -> {
            org.openqa.selenium.devtools.v116.network.model.RequestId requestId = requestWillBeSent.getRequestId();
            double startTime = requestWillBeSent.getTimestamp().toJson().doubleValue();
            String requestUrl = requestWillBeSent.getRequest().getUrl();
            timingMap.put(requestId.toString(), startTime);
            requestIdMap.put(requestId.toString(), requestUrl);
            if (requestUrl.contains("&fields=last_gdd_metric&active=false&limit=15&page=1&order=desc&order_by=start_date")) {
                SharedData.specificRequestUrl = requestUrl;
            }
        });
    }
    public static String fetchSiteNameWithDaysMode(String token) throws IOException, InterruptedException {
        String siteName = null;

        try {
            String requiredUrl = SharedData.specificRequestUrl;
            System.out.println("requiredUrl:-" + requiredUrl);

            JSONObject jsonObject = null;
            String jsonResponse = fetchJSONResponse(requiredUrl, token);
            jsonObject = new JSONObject(jsonResponse);
            System.out.println("jsonObject:-" + jsonObject);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject item = itemsArray.getJSONObject(i);

                if (item.getString("mode").equals("days")) {
                    siteName = item.getString("site_name");
                    System.out.println("Site Name with mode 'days': " + siteName);
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return siteName;
    }


}