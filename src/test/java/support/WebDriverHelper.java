package support;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.ParseException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static support.World.*;

public class WebDriverHelper {

    public static Wait<WebDriver> wait;
    static String defaultSnapshotLocation = System.getProperty("user.dir") + File.separator + "target" + File.separator + "Arable_Screenshots" + File.separator;
    private final WebDriver driver;
    List<String> apiEndpoints = new ArrayList<>();

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static String[] getCurrentDay() {
        Calendar today = Calendar.getInstance();
        String year = "";
        String month = "";
        String day = "";
        int iyear = today.get(Calendar.YEAR);
        int imonth = today.get(Calendar.MONTH) + 1;
        int iday = today.get(Calendar.DATE);

        if (imonth < 10) {
            month = "0" + imonth;
        } else {
            month = "" + imonth;
        }
        year = "" + iyear;
        if (iday < 10) {
            day = "0" + iday;
        } else {
            day = "" + iday;
        }
        return new String[]{day, month, year};
    }

    public void waitUntilVisible(WebElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitAttributeNotEmpty(WebElement element, String attribute, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    public void waitUntilVisibilityOfAllElements(List<WebElement> element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitUntilInvisibilityOfAllElements(List<WebElement> element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }

    public void waitUntilAttributeContains(WebElement element, String attribute, String value, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public void waitUntilTextToBePresentInElement(WebElement element, Integer timeout, Integer pollingTime, String text) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitUntilInvisibilityOfElementLocated(WebElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilElementToBeClickable(WebElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public List<String> returnListOfWebElements(String elementPath) {
        List<String> elementTextList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.xpath(elementPath));
        for (WebElement ele : elementList) {
            String eleText = ele.getText();
//            System.out.println("Text found=" + eleText);
            elementTextList.add(eleText);
        }
        return elementTextList;
    }

    public void scrollDownInsideModal(WebElement sectionWithScrollBar, long size) {
        WebElement modalElement = sectionWithScrollBar;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollBy(0, " + size + ");", modalElement);
    }

    public void takeAScreenShot(String filename) {
        try {
            if (filename == null || filename.isEmpty()) {
                filename = "screenshot";
            }
            if (filename.indexOf(".") == -1) {
                filename = filename + ".jpg";
            }
            if (!filename.contains("Arable")) {
                String[] today = getCurrentDay();
                if (today != null && today.length == 3) {
                    filename = "T" + today[0] + today[1] + filename;
                }
            }
            File snapLocation = new File(defaultSnapshotLocation);
            if (!snapLocation.exists()) {
                snapLocation.mkdirs();
            }
            //Debugger.println("ScreenShotFile:"+filename);
            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(screenshot, new File(defaultSnapshotLocation + filename));

        } catch (Exception exp) {

        }
    }

    public void scrollSlowlyToTopInsideModal(WebElement modalElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Number currentScrollPosition = (Number) js.executeScript("return arguments[0].scrollTop;", modalElement);
        double targetScrollPosition = 0.0; // Use double
        long duration = 1000;
        int steps = 60;
        double scrollDistance = (targetScrollPosition - currentScrollPosition.doubleValue()) / steps;
        for (int i = 0; i < steps; i++) {
            currentScrollPosition = currentScrollPosition.doubleValue() + scrollDistance;
            js.executeScript("arguments[0].scrollTop = arguments[1];", modalElement, currentScrollPosition);
            try {
                Thread.sleep(duration / steps);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void scrollToWebElement(WebElement element) {
        try {
            if (element == null) {
                return;
            }
            Point location = element.getLocation();
            String script = "scroll(" + location.x + "," + (location.y - 120) + ")";
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript(script);
        } catch (Exception e) {

        }
    }

    public String parseAndFormatDate(String dateString, String inputFormat, String outputFormat) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputFormat);
        inputDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date inputDate = inputDateFormat.parse(dateString);
            SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
            outputDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
            return outputDateFormat.format(inputDate);
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void getStartAndEndTimeAccordingToTimeZoneForLastHrs(String tz_name, String endDateText) throws java.text.ParseException {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        inputDateFormat.setTimeZone(TimeZone.getTimeZone(tz_name));
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        outputDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date endDate = inputDateFormat.parse(endDateText);
        Calendar currentCalendar = Calendar.getInstance(TimeZone.getTimeZone(tz_name));
        currentCalendar.setTime(endDate);
        currentCalendar.add(Calendar.DAY_OF_MONTH, -3);
        startTimeFormatted = outputDateFormat.format(currentCalendar.getTime());
        currentCalendar.setTime(endDate);
        currentCalendar.add(Calendar.DAY_OF_MONTH, 2);
        endTimeFormatted = outputDateFormat.format(currentCalendar.getTime());
    }

    public List<String> captureNetworkRequests() {
        LogEntries logEntries = driver.manage().logs().get("performance");
        for (LogEntry entry : logEntries) {
            if (entry.getMessage().contains("\"method\":\"Network.responseReceived\"")) {
                JsonObject message = JsonParser.parseString(entry.getMessage()).getAsJsonObject();
                JsonObject responseReceived = message.getAsJsonObject("message").getAsJsonObject("params");
                String apiEndpoint = responseReceived.getAsJsonObject("response").get("url").getAsString();
                apiEndpoints.add(0, apiEndpoint);
            }
        }
        return apiEndpoints;
    }

    public Map<String, String> getQueryParameters(URL url) {
        Map<String, String> params = new LinkedHashMap<>();
        String query = url.getQuery();
        if (query != null) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                String key = keyValue[0];
                String value = keyValue.length > 1 ? URLDecoder.decode(keyValue[1]) : null;
                params.put(key, value);
            }
        }
        return params;
    }

    public void scrollToBottomOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public void waterPageUIDateFormation(String inputFormat) {
        OffsetDateTime dateTime = OffsetDateTime.parse(inputFormat, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        outputDateString = dateTime.format(DateTimeFormatter.ofPattern("MM/dd"));
    }

    public String extractDigits(String input) {
        Pattern pattern = Pattern.compile("\\d*\\.?\\d+");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return "--";
    }

    public boolean isModalAtBottom(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Number scrollHeight = (Number) js.executeScript("return arguments[0].scrollHeight;", element);
        long scrollTop = Math.round(((Number) js.executeScript("return arguments[0].scrollTop;", element)).doubleValue());
        long clientHeight = Math.round(((Number) js.executeScript("return arguments[0].clientHeight;", element)).doubleValue());
        return (scrollTop + clientHeight) >= scrollHeight.longValue();
    }

    public void scrollModal(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop += 200;", element);
    }
}

