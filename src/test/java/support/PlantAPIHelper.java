package support;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static support.World.token;

public class PlantAPIHelper {
    public double plantAPIResponse(String siteId) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        double clValue = 0;
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            System.out.println("currentURL:-" + currentURL);
            siteId = extractSiteIdFromUrl(currentURL);
            System.out.println("siteId:-" + siteId);
            String apiUrl = constructPlantApiUrl(siteId);
            System.out.println("apiUrl:-" + apiUrl);


            HttpGet httpGet = new HttpGet(apiUrl);
            httpGet.addHeader("accept", "application/json");
            httpGet.addHeader("authorization", "Bearer " + token);
            HttpResponse response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            JSONObject jsonResponse = new JSONObject(responseBody);

            JSONArray dailyData = jsonResponse.getJSONArray("daily");

            OffsetDateTime currentDateTime = OffsetDateTime.now();

            JSONObject currentEntry = null;
            for (int i = 0; i < dailyData.length(); i++) {
                JSONObject entry = dailyData.getJSONObject(i);
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                System.out.println("Testing entryDateTime "+ entryDateTime);
                System.out.println("Testing 7 day before date "+LocalDate.now());
                if (entryDateTime.toLocalDate().equals(LocalDate.now())) {
                    currentEntry = entry;
                    break;
                }
            }
            if (currentEntry != null && !currentEntry.isNull("cl")) {
                clValue = currentEntry.getDouble("cl");
                System.out.println("cl value for today or yesterday: " + clValue);
            } else {
                System.out.println("No data available for today");
                OffsetDateTime yesterday = OffsetDateTime.now().minusDays(1);
                for (int i = 0; i < dailyData.length(); i++) {
                    JSONObject entry = dailyData.getJSONObject(i);
                    String timeString = entry.getString("time");
                    OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                    if (entryDateTime.toLocalDate().equals(yesterday.toLocalDate())) {
                        if (!entry.isNull("cl")) {
                            clValue = entry.getDouble("cl");
                            System.out.println("cl value for yesterday: " + clValue);
                        } else {
                            System.out.println("No valid cl value available for yesterday.");
                        }
                        break;
                    }
                }
                if (clValue == 0) {
                    System.out.println("No valid cl value available for today or yesterday.");
                }
            }

            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clValue;
    }

    public double getPastDateClValueplantAPIResponse(String siteId) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        double clValue = 0;
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            System.out.println("currentURL:-" + currentURL);
            siteId = extractSiteIdFromUrl(currentURL);
            System.out.println("siteId:-" + siteId);
            String apiUrl = constructPlantApiUrl(siteId);
            System.out.println("apiUrl:-" + apiUrl);
            HttpGet httpGet = new HttpGet(apiUrl);
            httpGet.addHeader("accept", "application/json");
            httpGet.addHeader("authorization", "Bearer " + token);
            HttpResponse response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            JSONObject jsonResponse = new JSONObject(responseBody);

            JSONArray dailyData = jsonResponse.getJSONArray("daily");

            OffsetDateTime currentDateTime = OffsetDateTime.now();

            JSONObject currentEntry = null;
            for (int i = 0; i < dailyData.length(); i++) {
                JSONObject entry = dailyData.getJSONObject(i);
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                if (entryDateTime.toLocalDate().equals(LocalDate.now())) {
                    currentEntry = entry;
                    break;
                }
            }
                System.out.println("No data available for today");
                OffsetDateTime yesterday = OffsetDateTime.now().minusDays(1);
                for (int i = 0; i < dailyData.length(); i++) {
                    JSONObject entry = dailyData.getJSONObject(i);
                    String timeString = entry.getString("time");
                    OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                    if (entryDateTime.toLocalDate().equals(yesterday.toLocalDate().minusDays(6))) {
                        if (!entry.isNull("cl")) {
                            clValue = entry.getDouble("cl");
                        } else {
                            System.out.println("No valid cl value available for yesterday.");
                        }
                        break;
                    }
                if (clValue == 0) {
                    System.out.println("No valid cl value available for today or yesterday.");
                }
            }

            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clValue;
    }

    public double plantAPIResponseNDVI(String siteId) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        double ndviValue = 0;
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            System.out.println("currentURL:-" + currentURL);
            siteId = extractSiteIdFromUrl(currentURL);
            System.out.println("siteId:-" + siteId);
            String apiUrl = constructPlantApiUrl(siteId);
            System.out.println("apiUrl:-" + apiUrl);


            HttpGet httpGet = new HttpGet(apiUrl);
            httpGet.addHeader("accept", "application/json");
            httpGet.addHeader("authorization", "Bearer " + token);
            HttpResponse response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            JSONObject jsonResponse = new JSONObject(responseBody);

            JSONArray dailyData = jsonResponse.getJSONArray("daily");

            OffsetDateTime currentDateTime = OffsetDateTime.now();

            JSONObject currentEntry = null;
            for (int i = 0; i < dailyData.length(); i++) {
                JSONObject entry = dailyData.getJSONObject(i);
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                if (entryDateTime.toLocalDate().equals(LocalDate.now())) {
                    currentEntry = entry;
                    break;
                }
            }
            if (currentEntry != null) {
                ndviValue = currentEntry.getDouble("ndvi");
                System.out.println("NDVI value for today or yesterday: " + ndviValue);
            } else {

                System.out.println("No data available for today");
                OffsetDateTime yesterday = OffsetDateTime.now().minusDays(1);
                for (int i = 0; i < dailyData.length(); i++) {
                    JSONObject entry = dailyData.getJSONObject(i);
                    String timeString = entry.getString("time");
                    OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                    if (entryDateTime.toLocalDate().equals(yesterday.toLocalDate())) {
                        if (!entry.isNull("ndvi")) {
                            ndviValue = entry.getDouble("ndvi");
                            System.out.println("ndvi value for yesterday: " + ndviValue);
                        } else {
                            System.out.println("No valid ndvi value available for yesterday.");
                        }
                        break;
                    }
                }
                if (ndviValue == 0) {
                    System.out.println("No valid ndvi value available for today or yesterday.");
                }
            }

            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ndviValue;
    }

    public double getPastDateNDVIValueplantAPIResponse(String siteId) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        double ndviValue = 0;
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            System.out.println("currentURL:-" + currentURL);
            siteId = extractSiteIdFromUrl(currentURL);
            System.out.println("siteId:-" + siteId);
            String apiUrl = constructPlantApiUrl(siteId);
            System.out.println("apiUrl:-" + apiUrl);
            HttpGet httpGet = new HttpGet(apiUrl);
            httpGet.addHeader("accept", "application/json");
            httpGet.addHeader("authorization", "Bearer " + token);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray dailyData = jsonResponse.getJSONArray("daily");
            OffsetDateTime currentDateTime = OffsetDateTime.now();
            JSONObject currentEntry = null;
            for (int i = 0; i < dailyData.length(); i++) {
                JSONObject entry = dailyData.getJSONObject(i);
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                if (entryDateTime.toLocalDate().equals(LocalDate.now())) {
                    currentEntry = entry;
                    break;
                }
            }
                System.out.println("No data available for today");
                OffsetDateTime yesterday = OffsetDateTime.now().minusDays(1);
                for (int i = 0; i < dailyData.length(); i++) {
                    JSONObject entry = dailyData.getJSONObject(i);
                    String timeString = entry.getString("time");
                    OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                    if (entryDateTime.toLocalDate().equals(yesterday.toLocalDate().minusDays(6))) {
                        System.out.println("Checking for date "+yesterday.toLocalDate().minusDays(6));
                        if (!entry.isNull("ndvi")) {
                            ndviValue = entry.getDouble("ndvi");
                        } else {
                            System.out.println("No valid NDVI value available for yesterday.");
                        }
                        break;
                    }
                if (ndviValue == 0) {
                    System.out.println("No valid ndviValue value available for today or yesterday.");
                }
            }

            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ndviValue;
    }

    public double getForecastCanopyValuePlantAPIResponse(String siteId) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        double canopyValue = 0;
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            System.out.println("currentURL:-" + currentURL);
            siteId = extractSiteIdFromUrl(currentURL);
            System.out.println("siteId:-" + siteId);
            String apiUrl = constructForecastApiUrl(siteId);
            System.out.println("apiUrl:-" + apiUrl);
            HttpGet httpGet = new HttpGet(apiUrl);
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhcGkuYXJhYmxlLmNvbSIsImlhdCI6MTcwODU5OTA2OSwianRpIjoiNThjMTQ2MmQ0YTE3NDA0MGIxZDYyY2Q4NjU5NjI4YmIiLCJpc3MiOiJodHRwOi8vYXBpLmFyYWJsZS5jb20iLCJzY29wZSI6IjYxZWU1MDA5YzQwOWMwMDAxMWU4NTk4MSJ9.Fy_pT4mkOjosK7Qm_y8Q5DTz1n8fpFk6OpxGc8RQu-Y";
            httpGet.addHeader("accept", "application/json");
            httpGet.addHeader("authorization", "Bearer " + token);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            System.out.println("response "+responseBody);
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray dailyData = jsonResponse.getJSONArray("daily");
            OffsetDateTime currentDateTime = OffsetDateTime.now();
            JSONObject currentEntry = null;
            for (int i = 0; i < dailyData.length(); i++) {
                JSONObject entry = dailyData.getJSONObject(i);
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                if (entryDateTime.toLocalDate().equals(LocalDate.now())) {
                    currentEntry = entry;
                    break;
                }
            }
            System.out.println("No data available for today");
            OffsetDateTime yesterday = OffsetDateTime.now();
                for (int i=0; i<=7; i++) {
                    JSONObject entry = dailyData.getJSONObject(i);
                    String timeString = entry.getString("time");
                    OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                    if (entryDateTime.toLocalDate().equals(yesterday.toLocalDate().plusDays(7))) {
                        break;
                    } else {
                        double flag = 0.0;
                        System.out.println("Checking for date " + yesterday.toLocalDate().plusDays(i));
                        if (!entry.isNull("etc")) {
                            flag = entry.getDouble("etc");
                        } else {
                            System.out.println("No valid canopy value available for yesterday.");
                        }
                        canopyValue = canopyValue + flag;
                    }
                    if (canopyValue == 0) {
                        System.out.println("No valid canopy value available for today or yesterday.");
                    }
                }


            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return canopyValue;
    }


    public double plantAPIResponseETc(String siteId) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        double ETcValue = 0;
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            System.out.println("currentURL:-" + currentURL);
            siteId = extractSiteIdFromUrl(currentURL);
            System.out.println("siteId:-" + siteId);
            String apiUrl = constructPlantApiUrl(siteId);
            System.out.println("apiUrl:-" + apiUrl);


            HttpGet httpGet = new HttpGet(apiUrl);
            httpGet.addHeader("accept", "application/json");
            httpGet.addHeader("authorization", "Bearer " + token);
            HttpResponse response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            JSONObject jsonResponse = new JSONObject(responseBody);

            JSONArray dailyData = jsonResponse.getJSONArray("daily");

            OffsetDateTime currentDateTime = OffsetDateTime.now();

            JSONObject currentEntry = null;
            for (int i = 0; i < dailyData.length(); i++) {
                JSONObject entry = dailyData.getJSONObject(i);
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                if (entryDateTime.toLocalDate().equals(LocalDate.now())) {
                    currentEntry = entry;
                    break;
                }
            }

            if (currentEntry != null) {
                ETcValue = currentEntry.getDouble("etc");
                System.out.println("ETc value for today or yesterday: " + ETcValue);
            } else {

                System.out.println("No data available for today");
                OffsetDateTime yesterday = OffsetDateTime.now().minusDays(1);
                for (int i = 0; i < dailyData.length(); i++) {
                    JSONObject entry = dailyData.getJSONObject(i);
                    String timeString = entry.getString("time");
                    OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                    if (entryDateTime.toLocalDate().equals(yesterday.toLocalDate())) {
                        if (!entry.isNull("etc")) {
                            ETcValue = entry.getDouble("etc");
                            System.out.println("etc value for yesterday: " + ETcValue);
                        } else {
                            System.out.println("No valid etc value available for yesterday.");
                        }
                        break;
                    }
                }
                if (ETcValue == 0) {
                    System.out.println("No valid etc value available for today or yesterday.");
                }
            }

            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ETcValue;
    }


    public double getForecastPrecipitationValuePlantAPIResponse(String siteId) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        double precipitationValue = 0;
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            System.out.println("currentURL:-" + currentURL);
            siteId = extractSiteIdFromUrl(currentURL);
            System.out.println("siteId:-" + siteId);
            String apiUrl = constructForecastApiUrl(siteId);
            System.out.println("apiUrl:-" + apiUrl);
            HttpGet httpGet = new HttpGet(apiUrl);
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhcGkuYXJhYmxlLmNvbSIsImlhdCI6MTcwODU5OTA2OSwianRpIjoiNThjMTQ2MmQ0YTE3NDA0MGIxZDYyY2Q4NjU5NjI4YmIiLCJpc3MiOiJodHRwOi8vYXBpLmFyYWJsZS5jb20iLCJzY29wZSI6IjYxZWU1MDA5YzQwOWMwMDAxMWU4NTk4MSJ9.Fy_pT4mkOjosK7Qm_y8Q5DTz1n8fpFk6OpxGc8RQu-Y";
            httpGet.addHeader("accept", "application/json");
            httpGet.addHeader("authorization", "Bearer " + token);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            System.out.println("response "+responseBody);
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray dailyData = jsonResponse.getJSONArray("daily");
            OffsetDateTime currentDateTime = OffsetDateTime.now();
            JSONObject currentEntry = null;
            for (int i = 0; i < dailyData.length(); i++) {
                JSONObject entry = dailyData.getJSONObject(i);
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                if (entryDateTime.toLocalDate().equals(LocalDate.now())) {
                    currentEntry = entry;
                    break;
                }
            }
            System.out.println("No data available for today");
            OffsetDateTime yesterday = OffsetDateTime.now();
            for (int i=0; i<=7; i++) {
                JSONObject entry = dailyData.getJSONObject(i);
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                if (entryDateTime.toLocalDate().equals(yesterday.toLocalDate().plusDays(7))) {
                    break;
                } else {
                    double flag = 0.0;
                    System.out.println("Checking for date " + yesterday.toLocalDate().plusDays(i));
                    if (!entry.isNull("precip")) {
                        flag = entry.getDouble("precip");
                    } else {
                        System.out.println("No valid canopy value available for yesterday.");
                    }
                    precipitationValue = precipitationValue + flag;
                }
                if (precipitationValue == 0) {
                    System.out.println("No valid canopy value available for today or yesterday.");
                }
            }


            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return precipitationValue;
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

    public String constructPlantApiUrl(String siteId) {
        return PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/" + siteId +
                "/plant?temp=F&pres=mb&size=mm&speed=mph";
    }

    public String constructPlantApiDimensionUrl(String siteId) {
        return PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/" + siteId +
                "/plant?temp=C&pres=kp&size=in&speed=mps";
    }

    public String constructForecastApiUrl(String siteId) {
        return PropertiesReader.apiSeverUrl + PropertiesReader.apiVersion + "/sites/" + siteId +
                "/forecast?temp=C&pres=kp&size=in&speed=mps";
    }

    public double getPastPrecipitationValuePlantAPIResponse(String siteId) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        double precipitationValue = 0;
        try {
            String currentURL = BrowserCreation.driver.getCurrentUrl();
            System.out.println("currentURL:-" + currentURL);
            siteId = extractSiteIdFromUrl(currentURL);
            System.out.println("siteId:-" + siteId);
            String apiUrl = constructPlantApiDimensionUrl(siteId);
            System.out.println("apiUrl:-" + apiUrl);
            HttpGet httpGet = new HttpGet(apiUrl);
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhcGkuYXJhYmxlLmNvbSIsImlhdCI6MTcwODY4OTg5NiwianRpIjoiMGQ1ODUwMTNlMDhhNDQ2ZmI0MjU4NTZiZjYxNWRmYmMiLCJpc3MiOiJodHRwOi8vYXBpLmFyYWJsZS5jb20iLCJzY29wZSI6IjY0ODgzZDg1MGVhMzRiMDAwYTZiMDdkZCJ9.RAE08uBtWmZA_tgflXpMiqK52qp4_h1419XSArdjf-g";
            httpGet.addHeader("accept", "application/json");
            httpGet.addHeader("authorization", "Bearer " + token);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            System.out.println("response "+responseBody);
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray dailyData = jsonResponse.getJSONArray("daily");
            OffsetDateTime currentDateTime = OffsetDateTime.now();
            JSONObject currentEntry = null;
            for (int i = 0; i < dailyData.length(); i++) {
                JSONObject entry = dailyData.getJSONObject(i);
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                if (entryDateTime.toLocalDate().equals(LocalDate.now())) {
                    currentEntry = entry;
                    break;
                }
            }
            System.out.println("No data available for today");
            OffsetDateTime yesterday = OffsetDateTime.now();
            for (int i=dailyData.length()-2; i>=dailyData.length()-7; i--) {
                JSONObject entry = dailyData.getJSONObject(i);
                System.out.println("** "+entry.toString());
                String timeString = entry.getString("time");
                OffsetDateTime entryDateTime = OffsetDateTime.parse(timeString);
                if (entryDateTime.toLocalDate().equals(yesterday.toLocalDate().minusDays(7))) {
                    break;
                } else {
                    double flag = 0;
//                    System.out.println("Checking for date " + yesterday.toLocalDate().minusDays(i));
                    if (!entry.isNull("precip")) {
                        flag = entry.getDouble("precip");
//                        String timeString1 = entry.getString("time");
//                        System.out.println("timeString1 "+timeString1);
//                        System.out.println("testing flag "+flag);
                    } else {
                        System.out.println("No valid precip value available for yesterday.");
                    }
                    precipitationValue = precipitationValue + flag;
                    System.out.println("testing precipitationValue "+precipitationValue);
                }
                if (precipitationValue == 0) {
                    System.out.println("No valid precip value available for today or yesterday.");
                }
            }


            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return precipitationValue;
    }
}