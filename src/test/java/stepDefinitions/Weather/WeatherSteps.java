//package stepDefinitions.Weather;
//
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//import java.io.IOException;
//
//import static support.World.*;
//
//public class WeatherSteps {
//
//    @When("navigate to {string} and get the user measurement units")
//    public void navigate_to_and_get_the_user_measurement_units(String page) throws IOException, InterruptedException {
//        accountPage.navigateToPage(page);
//        accountPage.getSizeUnit();
//        accountPage.getTemperatureUnit();
//        accountPage.getPressureUnit();
//        accountPage.getVolumeUnit();
//        accountPage.getSpeedUnit();
//    }
//
//    @When("navigate to {string} page and verify site details")
//    public void navigate_to_page_and_verify_site_details(String page) throws IOException, InterruptedException {
//        map.navigateToPage(page);
//        map.verifyOrgDropdown();
//        map.getSiteDetails();
//    }
//
//    @When("call the summary end point and get the current readings then click on site")
//    public void call_the_summary_end_point_and_get_the_current_readings_then_click_on_site() {
//        sitesApiHelper.getAuthToken();
//        sitesApiHelper.getSummaryRequest();
//        map.verifySiteValues();
//        map.verifySiteUnits();
//        map.clickOnSite();
//    }
//
//    @Then("user is on site weather tab and verify the current conditions table")
//    public void user_is_on_site_weather_tab_and_verify_the_current_conditions_table() {
//        weatherPage.verifyLoadingMessage();
//        weatherPage.verifySiteName();
//        weatherPage.verifyCurrentConditionsText();
//        weatherPage.verifyCurrentConditionsTempValue();
//        weatherPage.verifyCurrentConditionsHumidityValue();
//        weatherPage.verifyCurrentConditionsPressureValue();
//        weatherPage.verifyCurrentConditionsSolarValue();
//    }
//}