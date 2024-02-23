Feature: Water Multi Site


#  https://arabletestrail.testrail.io/index.php?/cases/view/68269
  Scenario Outline: Water |(C68269) Verify all data should be displayed using a growing season/org_id API for data from the present moment minus 7 days for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And get token, userID, units for "<role>" user and then get orgID
    And navigate to multiSite "Water" page
    Then verify all the data present in the columns is matching with the growing season API call
    @sanity @WaterMultiSite @orgAdmin @Scenario1
    Examples:
      | role     | tcId  |
      | orgAdmin | 68269 |
    @sanity @WaterMultiSite @member @Scenario1
    Examples:
      | role   | tcId  |
      | member | 68269 |
    @sanity @WaterMultiSite @teamAdmin @Scenario1
    Examples:
      | role      | tcId  |
      | teamAdmin | 68269 |
    @sanity @WaterMultiSite @orgReader @Scenario1
    Examples:
      | role      | tcId  |
      | orgReader | 68269 |
    @sanity @WaterMultiSite @sysReader @Scenario1
    Examples:
      | role      | tcId  |
      | sysReader | 68269 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68270
  Scenario Outline: Water |(C68270) Verify the user should be able to sort the Site name, Last Irrigation Runtime, Heat Stress Hours' columns in ascending and descending order for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then navigate to particular tab and click on sort option for each column like site name, Last irrigation runtime and heat stress hours
    @sanity @WaterMultiSite @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 68270 |
    @sanity @WaterMultiSite @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | 68270 |
    @sanity @WaterMultiSite @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | 68270 |
    @sanity @WaterMultiSite @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | 68270 |
    @sanity @WaterMultiSite @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | 68270 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68272
  Scenario Outline: Water |(C68272) The sites that are created for each season or gdd should be displayed in the sites list for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to seasons page
    And add gdd for a site
    When navigate to multiSite "Water" page
    Then observe newly added season or gdd for site is present in the list of table view
    Then verify the current page and the data present in the columns is matching with the growing season API call
    @sanity @WaterMultiSite @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 68272 |
    @sanity @WaterMultiSite @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 68272 |
    @sanity @WaterMultiSite @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 68272 |
    @sanity @WaterMultiSite @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 68272 |
    @sanity @WaterMultiSite @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 68272 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68273
  Scenario Outline: Water |(C68273) Verify if "+" symbol for positive values in Proximity to Refill Threshold is shown with "%" symbol for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then observe the proximity value in the table view
    @sanity @WaterMultiSite @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 68273 |
    @sanity @WaterMultiSite @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 68273 |
    @sanity @WaterMultiSite @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 68273 |
    @sanity @WaterMultiSite @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 68273 |
    @sanity @WaterMultiSite @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 68273 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68275
  Scenario Outline: Water |(C68275) The site table header title sorting button color should be Blue when landing on the multi site water page for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then observe site table header sorting button
    @sanity @WaterMultiSite @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 68275 |
    @sanity @WaterMultiSite @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 68275 |
    @sanity @WaterMultiSite @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 68275 |
    @sanity @WaterMultiSite @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 68275 |
    @sanity @WaterMultiSite @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 68275 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68276
  Scenario Outline: Water |(C68276) New - Sorting option should be enable for Heat Stress & Last Irrigation runtime for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then observe sorting button for heat stress hours & last irrigation runtime in the table view
    @sanity @WaterMultiSite @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 68276 |
    @sanity @WaterMultiSite @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 68276 |
    @sanity @WaterMultiSite @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 68276 |
    @sanity @WaterMultiSite @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 68276 |
    @sanity @WaterMultiSite @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 68276 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68277
  Scenario Outline: Water |(C68277) The site table header title sorting button color should be Blue when landing on the multi site water page for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then verify the Last Irrigation runtime data is in "hh:mm hrs" & 'dd-mm' format
    @sanity @WaterMultiSite @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 68277 |
    @sanity @WaterMultiSite @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 68277 |
    @sanity @WaterMultiSite @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 68277 |
    @sanity @WaterMultiSite @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 68277 |
    @sanity @WaterMultiSite @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 68277 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68279
  Scenario Outline: Water |(C68279) TBD- Verify If an org or team does not have the sites, an information message should appear in the site table chart as well as the individual tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then verify if an org or team does not have the sites, an information message should appear in the site table chart as well as the individual tab
    @sanity @WaterMultiSite @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 68279 |
    @sanity @WaterMultiSite @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 68279 |
    @sanity @WaterMultiSite @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 68279 |
    @sanity @WaterMultiSite @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 68279 |
    @sanity @WaterMultiSite @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 68279 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68280
  Scenario Outline: Water |(C68280) New - Verify on refreshing the browser, the tenant and team selection should be consistent wrt other pages like-Map, Sites for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then hard refresh the browser and observe
    @sanity @WaterMultiSite @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 68280 |
    @sanity @WaterMultiSite @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 68280 |
    @sanity @WaterMultiSite @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 68280 |
    @sanity @WaterMultiSite @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 68280 |
    @sanity @WaterMultiSite @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 68280 |


    #g  https://arabletestrail.testrail.io/index.php?/cases/view/68281
  Scenario Outline: Water |(C68281) Verify if the page is refreshed when clicked on the sorting which is present on the header of the table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then refresh the browser and observe the table view
    @sanity @WaterMultiSite @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 68281 |
    @sanity @WaterMultiSite @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 68281 |
    @sanity @WaterMultiSite @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 68281 |
    @sanity @WaterMultiSite @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 68281 |
    @sanity @WaterMultiSite @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 68281 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68365
  Scenario Outline: Water |(C68365) Verify when a user hovers over the location icon, the site name should be displayed in the tooltip for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then on Water balance tab, hover over the locators on map & observe
    @sanity @WaterMultiSite @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 68365 |
    @sanity @WaterMultiSite @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 68365 |
    @sanity @WaterMultiSite @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 68365 |
    @sanity @WaterMultiSite @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 68365 |
    @sanity @WaterMultiSite @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 68365 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68367
  Scenario Outline: Water |(C68367) The status bar & benchmark in the bar graph should show info modal & info texts for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then click on the status bar & benchmark graph title & verify modal info & it's text
    @sanity @WaterMultiSite @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 68367 |
    @sanity @WaterMultiSite @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 68367 |
    @sanity @WaterMultiSite @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 68367 |
    @sanity @WaterMultiSite @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 68367 |
    @sanity @WaterMultiSite @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 68367 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68368
  Scenario Outline: Water |(C68368) Verify the user should be able to sort the metrics of 'Hours of heat stress' in ascending and descending order for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then click on "Soil Moisture" tab, observe & compare the data present on Proximity to Refill Threshold is matching with the data shown on right side on status bar & benchmark graphs
    @sanity @WaterMultiSite @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 68368 |
    @sanity @WaterMultiSite @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 68368 |
    @sanity @WaterMultiSite @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 68368 |
    @sanity @WaterMultiSite @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 68368 |
    @sanity @WaterMultiSite @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 68368 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68370
  Scenario Outline: Water |(C68370) Verify the user should be able to sort the metrics of 'Hours of heat stress' in ascending and descending order for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then click on "Soil Moisture" tab and on the right side on the benchmark graph section, click on sorting icon & observe
    @sanity @WaterMultiSite @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 68370 |
    @sanity @WaterMultiSite @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 68370 |
    @sanity @WaterMultiSite @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 68370 |
    @sanity @WaterMultiSite @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 68370 |
    @sanity @WaterMultiSite @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 68370 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68371
  Scenario Outline: Water |(C68371) Verify the user should be able to sort the metrics of 'Hours of heat stress' in ascending and descending order for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And click on Soil Moisture tab, on the right side on the benchmark graph section, hover over any bar & observe the tooltip
    Then now, check the unit shown for "Proximity to Refill Threshold" in Site list table on left
    @sanity @WaterMultiSite @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 68371 |
    @sanity @WaterMultiSite @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 68371 |
    @sanity @WaterMultiSite @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 68371 |
    @sanity @WaterMultiSite @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 68371 |
    @sanity @WaterMultiSite @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 68371 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68271
  Scenario Outline: Water |(C68271) If no devices is there, then validate sensor button should not show for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then click on 3dots of any sites(pick site that don't have device) and observe the site details
    @sanity @WaterMultiSite @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 68271 |
    @sanity @WaterMultiSite @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 68271 |
    @sanity @WaterMultiSite @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 68271 |
    @sanity @WaterMultiSite @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 68271 |
    @sanity @WaterMultiSite @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 68271 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68364
  Scenario Outline: Water |(C68364) Verify the details in the water balance tab should match the data in the 'Irrigation to replace to ETc' column for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then observe & compare the data present on "Irrigation to Replace ETc" is matching with the data shown on right side on "status bar" & "benchmark graphs" of Water Balance tab
    @sanity @WaterMultiSite @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 68364 |
    @sanity @WaterMultiSite @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 68364 |
    @sanity @WaterMultiSite @teamAdmin @Scenario17
    Examples:
      | role      | tcId  |
      | teamAdmin | 68364 |
    @sanity @WaterMultiSite @orgReader @Scenario17
    Examples:
      | role      | tcId  |
      | orgReader | 68364 |
    @sanity @WaterMultiSite @sysReader @Scenario17
    Examples:
      | role      | tcId  |
      | sysReader | 68364 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68366
  Scenario Outline: Water |(C68366) Verify the actions when a user clicks on the location icon on map for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then verify the highlighted site details when hover over the locators on map & click & observe
    @sanity @WaterMultiSite @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 68366 |
    @sanity @WaterMultiSite @member @Scenario18
    Examples:
      | role   | tcId  |
      | member | 68366 |
    @sanity @WaterMultiSite @teamAdmin @Scenario18
    Examples:
      | role      | tcId  |
      | teamAdmin | 68366 |
    @sanity @WaterMultiSite @orgReader @Scenario18
    Examples:
      | role      | tcId  |
      | orgReader | 68366 |
    @sanity @WaterMultiSite @sysReader @Scenario18
    Examples:
      | role      | tcId  |
      | sysReader | 68366 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68377
  Scenario Outline: Water |(68377) Verify the color gradient of the location icon should match the sites of 'Heat Stress hours' column based on the hourly intervals on Map view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then click on "Heat Stress" tab and hover over on the locators on map & click on anyone of it & observe
    @sanity @WaterMultiSite @orgAdmin @Scenario19
    Examples:
      | role     | tcId  |
      | orgAdmin | 68377 |
    @sanity @WaterMultiSite @member @Scenario19
    Examples:
      | role   | tcId  |
      | member | 68377 |
    @sanity @WaterMultiSite @teamAdmin @Scenario19
    Examples:
      | role      | tcId  |
      | teamAdmin | 68377 |
    @sanity @WaterMultiSite @orgReader @Scenario19
    Examples:
      | role      | tcId  |
      | orgReader | 68377 |
    @sanity @WaterMultiSite @sysReader @Scenario19
    Examples:
      | role      | tcId  |
      | sysReader | 68377 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68378
  Scenario Outline: Water |(68378) Verify the 'Hours of Heat Stress' info model texts should match to the specified mockup for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then verify the 'Hours of Heat Stress' info model texts should match to the specified mockup
    @sanity @WaterMultiSite @orgAdmin @Scenario20
    Examples:
      | role     | tcId  |
      | orgAdmin | 68378 |
    @sanity @WaterMultiSite @member @Scenario20
    Examples:
      | role   | tcId  |
      | member | 68378 |
    @sanity @WaterMultiSite @teamAdmin @Scenario20
    Examples:
      | role      | tcId  |
      | teamAdmin | 68378 |
    @sanity @WaterMultiSite @orgReader @Scenario20
    Examples:
      | role      | tcId  |
      | orgReader | 68378 |
    @sanity @WaterMultiSite @sysReader @Scenario20
    Examples:
      | role      | tcId  |
      | sysReader | 68378 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68379
  Scenario Outline: Water |(68379) Verify the user should be able to sort the metrics of 'Hours of heat stress' in ascending and descending order for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then click on "Heat Stress" tab and on benchmark graph of Heat Stress Hours, click on sorting icon & observe
    @sanity @WaterMultiSite @orgAdmin @Scenario21
    Examples:
      | role     | tcId  |
      | orgAdmin | 68379 |
    @sanity @WaterMultiSite @member @Scenario21
    Examples:
      | role   | tcId  |
      | member | 68379 |
    @sanity @WaterMultiSite @teamAdmin @Scenario21
    Examples:
      | role      | tcId  |
      | teamAdmin | 68379 |
    @sanity @WaterMultiSite @orgReader @Scenario21
    Examples:
      | role      | tcId  |
      | orgReader | 68379 |
    @sanity @WaterMultiSite @sysReader @Scenario21
    Examples:
      | role      | tcId  |
      | sysReader | 68379 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68372
  Scenario Outline: Water |(68372) Verify the details in the 'Irrigation' tab should match the data in the 'Last irrigation runtime' column  for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then observe & compare the data present on "Last Irrigation Runtime" is matching with the data shown on right side on status bar & benchmark graphs of Irrigation tab
    @sanity @WaterMultiSite @orgAdmin @Scenario22
    Examples:
      | role     | tcId  |
      | orgAdmin | 68372 |
    @sanity @WaterMultiSite @member @Scenario22
    Examples:
      | role   | tcId  |
      | member | 68372 |
    @sanity @WaterMultiSite @teamAdmin @Scenario22
    Examples:
      | role      | tcId  |
      | teamAdmin | 68372 |
    @sanity @WaterMultiSite @orgReader @Scenario22
    Examples:
      | role      | tcId  |
      | orgReader | 68372 |
    @sanity @WaterMultiSite @sysReader @Scenario22
    Examples:
      | role      | tcId  |
      | sysReader | 68372 |


  #  https://arabletestrail.testrail.io/index.php?/cases/view/68373
  Scenario Outline: Water |(68373) Verify the color gradient of the location icon should match the sites of 'Heat Stress hours' column based on the hourly intervals on Map view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then click on Irrigation tab and hover over on the locators on map & click on anyone of it & observe
    @sanity @WaterMultiSite @orgAdmin @Scenario23
    Examples:
      | role     | tcId  |
      | orgAdmin | 68373 |
    @sanity @WaterMultiSite @member @Scenario23
    Examples:
      | role   | tcId  |
      | member | 68373 |
    @sanity @WaterMultiSite @teamAdmin @Scenario23
    Examples:
      | role      | tcId  |
      | teamAdmin | 68373 |
    @sanity @WaterMultiSite @orgReader @Scenario23
    Examples:
      | role      | tcId  |
      | orgReader | 68373 |
    @sanity @WaterMultiSite @sysReader @Scenario23
    Examples:
      | role      | tcId  |
      | sysReader | 68373 |


  # https://arabletestrail.testrail.io/index.php?/cases/view/68374
  Scenario Outline: Water |(68374) Verify the site should shows the timestamp of the last irrigation event and hours of runtime when the user hovers over the location icon for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then Verify the format for data in Last Irrigation Runtime column & in Irrigation Runtime Hours in benchmark graph
    @sanity @WaterMultiSite @orgAdmin @Scenario24
    Examples:
      | role     | tcId  |
      | orgAdmin | 68374 |
    @sanity @WaterMultiSite @member @Scenario24
    Examples:
      | role   | tcId  |
      | member | 68374 |
    @sanity @WaterMultiSite @teamAdmin @Scenario24
    Examples:
      | role      | tcId  |
      | teamAdmin | 68374 |
    @sanity @WaterMultiSite @orgReader @Scenario24
    Examples:
      | role      | tcId  |
      | orgReader | 68374 |
    @sanity @WaterMultiSite @sysReader @Scenario24
    Examples:
      | role      | tcId  |
      | sysReader | 68374 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68375
  Scenario Outline: Water |(C68375) Verify the user should be able to sort the metrics of 'Hours of heat stress' in ascending and descending order for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then click on "Irrigation Runtime Hours" tab and on benchmark graph of Irrigation Runtime Hours, click on sorting icon & observe
    @sanity @WaterMultiSite @orgAdmin @Scenario25
    Examples:
      | role     | tcId  |
      | orgAdmin | 68375 |
    @sanity @WaterMultiSite @member @Scenario25
    Examples:
      | role   | tcId  |
      | member | 68375 |
    @sanity @WaterMultiSite @teamAdmin @Scenario25
    Examples:
      | role      | tcId  |
      | teamAdmin | 68375 |
    @sanity @WaterMultiSite @orgReader @Scenario25
    Examples:
      | role      | tcId  |
      | orgReader | 68375 |
    @sanity @WaterMultiSite @sysReader @Scenario25
    Examples:
      | role      | tcId  |
      | sysReader | 68375 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68369
  Scenario Outline: Water |(C68369) Verify the color gradient of the location icon should match the sites of 'Heat Stress hours' column based on the hourly intervals on Map view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    Then click on soil moisture tab and hover over on the locators on map & click on anyone of it & observe
    @sanity @WaterMultiSite @orgAdmin @Scenario26
    Examples:
      | role     | tcId  |
      | orgAdmin | 68369 |
    @sanity @WaterMultiSite @member @Scenario26
    Examples:
      | role   | tcId  |
      | member | 68369 |
    @sanity @WaterMultiSite @teamAdmin @Scenario26
    Examples:
      | role      | tcId  |
      | teamAdmin | 68369 |
    @sanity @WaterMultiSite @orgReader @Scenario26
    Examples:
      | role      | tcId  |
      | orgReader | 68369 |
    @sanity @WaterMultiSite @sysReader @Scenario26
    Examples:
      | role      | tcId  |
      | sysReader | 68369 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68253
  Scenario Outline: (Water-MultiSite)(68253) | Verify the multi-site tab should appear in the analysis submodule for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    Then verify sub module is present when Hoover on Analysis
    And verify water tab should be present
    @sanity @WaterMultiSite @member @Scenario27
    Examples:
      | role   | tcId  |
      | member | 68253 |
    @sanity @WaterMultiSite @orgAdmin @Scenario27
    Examples:
      | role     | tcId  |
      | orgAdmin | 68253 |
    @sanity @WaterMultiSite @orgReader @Scenario27
    Examples:
      | role      | tcId  |
      | orgReader | 68253 |
    @sanity @WaterMultiSite @sysReader @Scenario27
    Examples:
      | role      | tcId  |
      | sysReader | 68253 |
    @sanity @WaterMultiSite @teamAdmin  @Scenario27
    Examples:
      | role      | tcId  |
      | teamAdmin | 68253 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68254
  Scenario Outline: (Water-MultiSite)(68254) | Verify if user clicks on any site, it should navigate to single site view water page for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    When click on any site in the multisite water page
    And verify User should be able to view single site water page
    @sanity @WaterMultiSite @member @Scenario28
    Examples:
      | role   | tcId  |
      | member | 68254 |
    @sanity @WaterMultiSite @orgAdmin @Scenario28
    Examples:
      | role     | tcId  |
      | orgAdmin | 68254 |
    @sanity @WaterMultiSite @orgReader @Scenario28
    Examples:
      | role      | tcId  |
      | orgReader | 68254 |
    @sanity @WaterMultiSite @sysReader @Scenario28
    Examples:
      | role      | tcId  |
      | sysReader | 68254 |
    @sanity @WaterMultiSite @teamAdmin @Scenario28
    Examples:
      | role      | tcId  |
      | teamAdmin | 68254 |


  # https://arabletestrail.testrail.io/index.php?/cases/view/68255
  Scenario Outline: (Water-MultiSite)(68255) | Verify If a user changes the measurement via the toggle, the color gradient on the site table should be updated accordingly for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And verify that the color for the water balance
    # In irrigation, verifying the color assertion is committed. Once the issue is fixed, we can un-commit those steps.
    And verify that the color for the irrigation
    And verify that the color for the soil moisture
    And verify that the color for the heat stress
    @sanity @WaterMultiSite @member @Scenario29
    Examples:
      | role   | tcId  |
      | member | 68255 |
    @sanity @WaterMultiSite @orgAdmin @Scenario29
    Examples:
      | role     | tcId  |
      | orgAdmin | 68255 |
    @sanity @WaterMultiSite @orgReader @Scenario29
    Examples:
      | role      | tcId  |
      | orgReader | 68255 |
    @sanity @WaterMultiSite @sysReader @Scenario29
    Examples:
      | role      | tcId  |
      | sysReader | 68255 |
    @sanity @WaterMultiSite @teamAdmin @Scenario29
    Examples:
      | role      | tcId  |
      | teamAdmin | 68255 |

 # https://arabletestrail.testrail.io/index.php?/cases/view/68256
  Scenario Outline: (Water-MultiSite)(68256) | Verify the user for "<role>" should be able to view up to 15 active sites per team. If the one team has more than 15 sites, the pagination feature should be available
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And verify the 15 sites are present per pagination
    Then verify weather pagination is clickable or not
    @sanity @WaterMultiSite @member @Scenario30
    Examples:
      | role   | tcId  |
      | member | 68256 |
    @sanity @WaterMultiSite @orgAdmin @Scenario30
    Examples:
      | role     | tcId  |
      | orgAdmin | 68256 |
    @sanity @WaterMultiSite @orgReader @Scenario30
    Examples:
      | role      | tcId  |
      | orgReader | 68256 |
    @sanity @WaterMultiSite @sysReader @Scenario30
    Examples:
      | role      | tcId  |
      | sysReader | 68256 |
    @sanity @WaterMultiSite @teamAdmin @Scenario30
    Examples:
      | role      | tcId  |
      | teamAdmin | 68256 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68257
  Scenario Outline: (Water-MultiSite)(68257) | Verify the left-hand side table 'multi-site irrigation' overview should include 'Site name, Irrigation to replace to ETc, Proximity to Refill threshold, Last Irrigation Runtime, Heat Stress Hours' for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And verify site name,Irrigation to replace to ETc, Proximity to Refill threshold, Last Irrigation Runtime, Heat Stress Hours' from the left side of the water page
    Then verify weather all measurements are clickable
    @sanity @WaterMultiSite @member @Scenario31
    Examples:
      | role   | tcId  |
      | member | 68257 |
    @sanity @WaterMultiSite @orgAdmin @Scenario31
    Examples:
      | role     | tcId  |
      | orgAdmin | 68257 |
    @sanity @WaterMultiSite @orgReader @Scenario31
    Examples:
      | role      | tcId  |
      | orgReader | 68257 |
    @sanity @WaterMultiSite @sysReader @Scenario31
    Examples:
      | role      | tcId  |
      | sysReader | 68257 |
    @sanity @WaterMultiSite @teamAdmin @Scenario31
    Examples:
      | role      | tcId  |
      | teamAdmin | 68257 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68258  (red - orange clr)
  Scenario Outline: (Water-MultiSite)(68258) | Verify when a user clicks on the three dots on any site, two options should appear: 'Validate Sensor' and 'Manual Irrigation.' for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And verify the presence of Validate Sensor and Manual Irrigation after click on the three dots on any site
    Then verify the Validate Sensor symbol color should be in orange
    @sanity @WaterMultiSite @member @Scenario32
    Examples:
      | role   | tcId  |
      | member | 68258 |
    @sanity @WaterMultiSite @orgAdmin @Scenario32
    Examples:
      | role     | tcId  |
      | orgAdmin | 68258 |
    @sanity @WaterMultiSite @orgReader @Scenario32
    Examples:
      | role      | tcId  |
      | orgReader | 68258 |
    @sanity @WaterMultiSite @sysReader @Scenario32
    Examples:
      | role      | tcId  |
      | sysReader | 68258 |
    @sanity @WaterMultiSite @teamAdmin @Scenario32
    Examples:
      | role      | tcId  |
      | teamAdmin | 68258 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68259
  Scenario Outline: (Water-MultiSite)(68259) | Verify When you click the validate sensor button, the site row should expand to show the columns Device id, Battery status, and Connected sensors, as well as validate the sensor for each individual device for "<role>" user.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And verify the presence of Validate Sensor and Manual Irrigation after click on the three dots on any site
    And click on validate sensor
    And verify Device Id, Battery Status, Connected sensor column is present
    And verify that the user can clickable on three dots button on individual device
    And verify validate sensor model is appear, when click on the validate senor
    And verify the tag in the Set Up Connected Sensors
    @sanity @WaterMultiSite @member @Scenario33
    Examples:
      | role   | tcId  |
      | member | 68259 |
    @sanity @WaterMultiSite @orgAdmin @Scenario33
    Examples:
      | role     | tcId  |
      | orgAdmin | 68259 |
    @sanity @WaterMultiSite @orgReader @Scenario33
    Examples:
      | role      | tcId  |
      | orgReader | 68259 |
    @sanity @WaterMultiSite @sysReader @Scenario33
    Examples:
      | role      | tcId  |
      | sysReader | 68259 |
    @sanity @WaterMultiSite @teamAdmin @Scenario33
    Examples:
      | role      | tcId  |
      | teamAdmin | 68259 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68260
  Scenario Outline: (Water-MultiSite)(68260) | Verify after validating the sensor, the user can minimize the site details by clicking on the 'Done with validation' button for "<role>" user.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And verify the presence of Validate Sensor and Manual Irrigation after click on the three dots on any site
    And click on validate sensor
    And verify the Done With Validation button in the background color
    Then verify user can minimize the site details by clicking on Done with validation button
    @sanity @WaterMultiSite @member @Scenario34
    Examples:
      | role   | tcId  |
      | member | 68260 |
    @sanity @WaterMultiSite @orgAdmin @Scenario34
    Examples:
      | role     | tcId  |
      | orgAdmin | 68260 |
    @sanity @WaterMultiSite @orgReader @Scenario34
    Examples:
      | role      | tcId  |
      | orgReader | 68260 |
    @sanity @WaterMultiSite @sysReader @Scenario34
    Examples:
      | role      | tcId  |
      | sysReader | 68260 |
    @sanity @WaterMultiSite @teamAdmin @Scenario34
    Examples:
      | role      | tcId  |
      | teamAdmin | 68260 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68261
  Scenario Outline: (Water-MultiSite)(68261) |After validating sensor from water page, navigate to Device page & verify the validate sensor options for the same device & do vice-versa for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And verify the presence of Validate Sensor and Manual Irrigation after click on the three dots on any site
    And click on validate sensor
    And verify the Done With Validation button in the background color
    And verify the scrollbar is present and working
    And verify that the user should be able to view the device ID and store that ID
    And navigate to Devices option page from Settings menu
    Then verify that the validate sensor options for the same device are displayed
    @sanity @WaterMultiSite @member @Scenario35
    Examples:
      | role   | tcId  |
      | member | 68261 |
    @sanity @WaterMultiSite @orgAdmin @Scenario35
    Examples:
      | role     | tcId  |
      | orgAdmin | 68261 |
    @sanity @WaterMultiSite @orgReader @Scenario35
    Examples:
      | role      | tcId  |
      | orgReader | 68261 |
    @sanity @WaterMultiSite @sysReader @Scenario35
    Examples:
      | role      | tcId  |
      | sysReader | 68261 |
    @sanity @WaterMultiSite @teamAdmin @Scenario35
    Examples:
      | role      | tcId  |
      | teamAdmin | 68261 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68264
  Scenario Outline: (Water-MultiSite)(68264) | Verify for Irrigation to Replace ET column, the user should be able to view data at different time intervals like for Green = <2 hours, Yellow = 2-8 hours, Red = <8 hours for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And navigate to the page where site have value
    And Change Water Balance measurements via toggle
    And observe the tags at different intervals below the map
    @sanity @WaterMultiSite @member @Scenario36
    Examples:
      | role   | tcId  |
      | member | 68264 |
    @sanity @WaterMultiSite @orgAdmin @Scenario36
    Examples:
      | role     | tcId  |
      | orgAdmin | 68264 |
    @sanity @WaterMultiSite @orgReader @Scenario36
    Examples:
      | role      | tcId  |
      | orgReader | 68264 |
    @sanity @WaterMultiSite @sysReader @Scenario36
    Examples:
      | role      | tcId  |
      | sysReader | 68264 |
    @sanity @WaterMultiSite @teamAdmin @Scenario36
    Examples:
      | role      | tcId  |
      | teamAdmin | 68264 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68265
  Scenario Outline: (Water-MultiSite)(68265) | Verify for the Proximity to Refill threshold column, the user should be able to view data at different days intervals like for Red color <= and Yellow color <10% and Green color > 10% for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And click on the Soil Moisture
    And navigate to the page where the soilMoisture interval icon is present
    @sanity @WaterMultiSite @member @Scenario37
    Examples:
      | role   | tcId  |
      | member | 68265 |
    @sanity @WaterMultiSite @orgAdmin @Scenario37
    Examples:
      | role     | tcId  |
      | orgAdmin | 68265 |
    @sanity @WaterMultiSite @orgReader @Scenario37
    Examples:
      | role      | tcId  |
      | orgReader | 68265 |
    @sanity @WaterMultiSite @sysReader @Scenario37
    Examples:
      | role      | tcId  |
      | sysReader | 68265 |
    @sanity @WaterMultiSite @teamAdmin @Scenario37
    Examples:
      | role      | tcId  |
      | teamAdmin | 68265 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68266
  Scenario Outline: (Water-MultiSite)(68266) | Verify for the Last Irrigation runtime column, it should show the timestamp of the last irrigation event and hours of runtime like or the last 7 days, Light Blue = <4 hours, Blue = between 5- 20 hours, Dark Blue = > 21 hours for "<role>" user.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And click on the irrigation
    And navigate to the page where the irrigation interval icon is present
    @sanity @WaterMultiSite @member @Scenario38
    Examples:
      | role   | tcId  |
      | member | 68266 |
    @sanity @WaterMultiSite @orgAdmin @Scenario38
    Examples:
      | role     | tcId  |
      | orgAdmin | 68266 |
    @sanity @WaterMultiSite @orgReader @Scenario38
    Examples:
      | role      | tcId  |
      | orgReader | 68266 |
    @sanity @WaterMultiSite @sysReader @Scenario38
    Examples:
      | role      | tcId  |
      | sysReader | 68266 |
    @sanity @WaterMultiSite @teamAdmin @Scenario38
    Examples:
      | role      | tcId  |
      | teamAdmin | 68266 |

 # https://arabletestrail.testrail.io/index.php?/cases/view/68267
  Scenario Outline: (Water-MultiSite)(68267) | Verify If in the 'last Irrigation runtime' column, there was no irrigation event in the last 7 days, the column should show blank with “--” for "<role>" user.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to multiSite "Water" page
    And verify the last Irrigation runtime column with api
    @sanity @WaterMultiSite @member @Scenario39
    Examples:
      | role   | tcId  |
      | member | 68267 |
    @sanity @WaterMultiSite @orgAdmin @Scenario39
    Examples:
      | role     | tcId  |
      | orgAdmin | 68267 |
    @sanity @WaterMultiSite @orgReader @Scenario39
    Examples:
      | role      | tcId  |
      | orgReader | 68267 |
    @sanity @WaterMultiSite @sysReader @Scenario39
    Examples:
      | role      | tcId  |
      | sysReader | 68267 |
    @sanity @WaterMultiSite @teamAdmin @Scenario39
    Examples:
      | role      | tcId  |
      | teamAdmin | 68267 |

    #    This was not working due to application error, colour mismatch between graph and site value in table
    #  https://arabletestrail.testrail.io/index.php?/cases/view/68274
  Scenario Outline: Water |(C68274) Verify "Irrigation to Replace ETc" will shown in "hh:mm hrs" format for e.g. 00:01 hrs for "<role>" user.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    When navigate to multiSite "Water" page
    Then observe 'irrigation to replace ETc' from the table view
    @sanity @WaterMultiSite @orgAdmin @Scenario40
    Examples:
      | role     | tcId  |
      | orgAdmin | 68274 |
    @sanity @WaterMultiSite @member @Scenario40
    Examples:
      | role   | tcId  |
      | member | 68274 |
    @sanity @WaterMultiSite @teamAdmin @Scenario40
    Examples:
      | role      | tcId  |
      | teamAdmin | 68274 |
    @sanity @WaterMultiSite @orgReader @Scenario40
    Examples:
      | role      | tcId  |
      | orgReader | 68274 |
    @sanity @WaterMultiSite @sysReader @Scenario40
    Examples:
      | role      | tcId  |
      | sysReader | 68274 |

