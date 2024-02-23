package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.RequestId;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static support.BrowserCreation.driver;

public class StringHelper {
    public static long start;
    public static String growingSeasonRequestUrl = null;
    static DevTools devTools;

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
            if (requestUrl.contains("growth_stages?ratio=pct&gdd_unit=celsius-day")) {
                SharedData.specificRequestUrl = requestUrl;
            }
        });
    }

    public static void growingSeasonApi(String role) throws IOException, InterruptedException {
        String specificRequestUrl = growingSeasonRequestUrl;
        if (specificRequestUrl != null) {
            System.out.println("Specific API request containing growing_season: " + specificRequestUrl);
        } else {
            System.out.println("No API request containing growing_season captured.");
        }
    }

    public static void devToolCapture(String role) throws IOException, InterruptedException {
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
            if (requestUrl.contains("?fields=water_metrics&aggregation=daily")) {
                SharedData.specificRequestUrl = requestUrl;
            }
        });
        devTools.addListener(Network.loadingFinished(), loadingFinshed -> {
            RequestId requestId = loadingFinshed.getRequestId();
            double endTime = loadingFinshed.getTimestamp().toJson().doubleValue();

            if (timingMap.get(requestId.toString()) != null) {

                String url = requestIdMap.get(requestId.toString());
                double responseTime = endTime - timingMap.get(requestId.toString());

                System.out.println("Url: " + url + " , response time: " + responseTime + " seconds");
            }
        });
    }

    public void scrollIntoViewAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void navigateBackTwice() {
        driver.navigate().back();
        driver.navigate().back();
    }

    public void scrollDownBy(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ")", "");
    }

    public int randomNumberGenerator() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        return randomNumber;
    }

    public String floatToString(float value) {
        int i = Math.round(value);
        String x = String.valueOf(i);
        return x;
    }

    public String decimalToPercentage(float value) {
        float v = value * 100;
        int i = Math.round(v);
        String x = String.valueOf(i);
        return x;
    }

    public String stopTime(long start, WebDriver driver) {
        while (System.currentTimeMillis() > start) {
            if (String.valueOf(
                            ((JavascriptExecutor) driver)
                                    .executeScript("return document.readyState"))
                    .equals("complete"))
                System.out.println("Dom loaded completely");
            {
                break;
            }
        }
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("UI Response Time-" + (double) totalTime / 1000);
        return String.valueOf((double) totalTime / 1000);

    }

    public void benchmarkComparison(String loadInSeconds) {
        float highestValue = Float.parseFloat(String.valueOf(5.000));
        int Benchmark = Math.round(highestValue);
        float responseTime = Float.parseFloat(loadInSeconds);
        int Actual = Math.round(responseTime);
        Assert.assertTrue(Benchmark > Actual);
    }

}
