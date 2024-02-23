package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ResponseTimeUtil {
    private static WebDriver driver;

    public ResponseTimeUtil(WebDriver driver) {
        this.driver = driver;
    }

    public static void DataDogAPM() throws IOException {
        // Replace with your DataDog API key
        String apiKey = "7a2f554bda9a40e46513f21b723f7195";
        // Replace with your DataDog Application key
        String applicationKey = "b532beb6c9df66d2410e24ea2b6a70c68d79d700";
        String serviceName = "api-user";

        // DataDog APM API endpoint URL for Service Summary data
        String apiUrl = "https://app.datadoghq.com/api/v2/rum/applications";

        // Set up the API connection
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("DD-API-KEY", apiKey);
        connection.setRequestProperty("DD-APPLICATION-KEY", applicationKey);

        // Fetch the data and parse the JSON response
        try (InputStream inputStream = connection.getInputStream();
             Scanner scanner = new Scanner(inputStream, "UTF-8")) {
            String jsonResponse = scanner.useDelimiter("\\A").next();
            // Parse the JSON response and extract the "Service Summary" data
            // ... Your parsing code here ...

            // Print the captured data in the console logs
            System.out.println("Data Dog:RUM Data:");
            System.out.println(jsonResponse); // Replace with the parsed data
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

    public long captureResponseTime(String pageName, Runnable action) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        long startTime = (long) jsExecutor.executeScript("return performance.timing.navigationStart");
        action.run(); // Perform the desired action on the page
        long endTime = (long) jsExecutor.executeScript("return performance.timing.loadEventEnd");
        return endTime - startTime;
    }
}
