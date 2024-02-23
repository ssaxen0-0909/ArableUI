package stepDefinitions.Weather;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.weatherPage;


public class WeatherPage_LoadTime {

    @When("navigate to {string} page and search the site and click on the site card")
    public void navigateToPageAndSearchTheSiteAndClickOnTheSiteCard(String page) throws InterruptedException, IOException {
        weatherPage.navigateToPage(page);
    }

//    @Then("user is on site weather tab and verify the current conditions table and update excel for {string} user.")
//    public void userIsOnSiteWeatherTabAndVerifyTheCurrentConditionsTableAndUpdateExcelForUser(String role) throws IOException, InterruptedException {
//        weatherPage.captureWeatherPageLoadTime(role);
//    }

    @Then("verify weather page site details for {string} user.")
    public void verifyWeatherPageSiteDetailsForUser(String role) throws IOException {
        weatherPage.verifyContentsOfWeatherPage(role);
    }

    @Then("verify current condition Modal Info on weather page for {string} user.")
    public void verifyCurrentConditionModalInfoOnWeatherPageForUser(String role) throws IOException {
        weatherPage.verifyCurrentConditionModalInfo(role);
    }

    @Then("verify Daily Forecast Modal Info on weather page for {string} user.")
    public void verifyDailyForecastModalInfoOnWeatherPageForUser(String role) throws IOException {
        weatherPage.verifyDailyForecastModalInfo(role);
    }

    @Then("verify Wind Speed Hourly Modal Info on weather page for {string} user.")
    public void verifyWindSpeedHourlyModalInfoOnWeatherPageForUser(String role) throws IOException {
        weatherPage.verifyWindSpeedHourlyModalInfo(role);
    }

    @Then("verify Wind Speed Daily Modal Info on weather page for {string} user.")
    public void verifyWindSpeedDailyModalInfoOnWeatherPageForUser(String role) throws IOException {
        weatherPage.verifyWindSpeedDailyModalInfo(role);
    }

    @Then("verify Prev And Next Arrow in Temp Hourly Table for {string} user.")
    public void verifyPrevAndNextArrowInTempHourlyTableForUser(String role) throws IOException, InterruptedException {
        weatherPage.verifyPrevAndNextArrow_HourlyForecastTable(role);
    }

    @Then("verify Prev And Next Arrow in Daily forecast Table for {string} user.")
    public void verifyPrevAndNextArrowInDailyForecastTableForUser(String role) throws IOException, InterruptedException {
        weatherPage.verifyPrevAndNextArrow_DailyForecastTable(role);
    }

    @Then("verify Prev And Next Arrow in Wind hourly Table for {string} user.")
    public void verifyPrevAndNextArrowInWindHourlyTableForUser(String role) throws IOException, InterruptedException {
        weatherPage.verifyPrevAndNextArrow_WindHourlyTable(role);
    }

    @Then("verify Prev And Next Arrow in Wind daily Table for {string} user.")
    public void verifyPrevAndNextArrowInWindDailyTableForUser(String role) throws IOException, InterruptedException {
        weatherPage.verifyPrevAndNextArrow_WindDailyTable(role);
    }

    @Then("verify Export Page Navigation for {string} user.")
    public void verifyExportPageNavigationForUser(String role) throws IOException, InterruptedException {
        weatherPage.verifyExportPageNavigation(role);
    }

    @Then("verify graph Page Navigation for {string} user.")
    public void verifyGraphPageNavigationForUser(String role) throws IOException, InterruptedException {
        weatherPage.verifyGraphPageNavigation(role);
    }

    @Then("verify Edit Device Sensor for {string} user.")
    public void verifyEditDeviceSensorForUser(String role) throws IOException, InterruptedException {
        weatherPage.verifyEditDeviceSensor(role);
    }

    @Then("verify on Weather page, same unit should reflect in Wind Speed Hourly section")
    public void verifyOnWeatherPageSameUnitShouldReflectInWindSpeedHourlySection() throws InterruptedException {
        weatherPage.verifyTheWindUnitInWeatherPage();
    }

    @Then("verify on Plant page, same unit should reflect in Daily ETc, ETo & Precipitation section")
    public void verifyOnPlantPageSameUnitShouldReflectInDailyETcEToPrecipitationSection() throws InterruptedException {
        weatherPage.verifyTheWindUnitInPlantPage();
    }

    @Then("verify on Weather page, same unit should reflect in Today's Temperature and Current Conditions section")
    public void verifyOnWeatherPageSameUnitShouldReflectInTodaySTemperatureAndCurrentConditionsSection() throws InterruptedException {
        weatherPage.verifyTheTempUnitInWeatherPage();
    }

    @Then("verify on Weather page, same unit should reflect in Current Condition section for pressure")
    public void verifyOnWeatherPageSameUnitShouldReflectInCurrentConditionSectionForPressure() {
        weatherPage.verifyThePressureUnitInWeatherPage();
    }

}
