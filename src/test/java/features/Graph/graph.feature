Feature: Graph Page

#  Scenario Outline: Graph | Capture page load time for graph page with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Graph" and verify site names are displayed for "<role>" user
#    Then update page load time in Excel sheet for "<role>" user
#
#    @sanity @Performance @Graph @member @Scenario1
#    Examples:
#      | role   | tcId  |
#      | member | 60940 |
#    @sanity @Performance @Graph @orgAdmin @Scenario1
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60940 |
#    @sanity @Performance @Graph @orgReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60940 |
#    @sanity @Performance @Graph @sysReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60940 |
#    @sanity @Performance @Graph @teamAdmin @Scenario1
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60940 |
#
#
#  Scenario Outline: Graph | Capture page load time for graph-daily with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Graph" and verify site names are displayed for "<role>" user
#    Then select details and click on Graph Button and verify it with different "<role>".
#
#    @sanity @Performance @Graph @member @Scenario2
#    Examples:
#      | role   | tcId  |
#      | member | 60938 |
#    @sanity @Performance @Graph @orgAdmin @Scenario2
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60938 |
#    @sanity @Performance @Graph @orgReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60938 |
#    @sanity @Performance @Graph @sysReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60938 |
#    @sanity @Performance @Graph @teamAdmin @Scenario2
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60938 |
#
#
#  Scenario Outline: Graph | Capture page load time for graph-hourly with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to "Graph" page select details and click on Graph Button
#    Then switch to hourly and verify it with different "<role>".
#
#    @sanity @Performance @Graph @member @Scenario3
#    Examples:
#      | role   | tcId  |
#      | member | 60939 |
#    @sanity @Performance @Graph @orgAdmin @Scenario3
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60939 |
#    @sanity @Performance @Graph @orgReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60939 |
#    @sanity @Performance @Graph @sysReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60939 |
#    @sanity @Performance @Graph @teamAdmin @Scenario3
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60939 |


  Scenario Outline: Graph | verify graph-daily csv and pdf download with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select details and click on Graph Button and then download csv and pdf for different "<role>".

    @sanity @Graph @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 60934 |
    @sanity @Graph @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 60934 |
    @sanity @Graph @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 60934 |
    @sanity @Graph @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 60934 |
    @sanity @Graph @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 60934 |


  Scenario Outline: Graph | verify graph-hourly csv and pdf download with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Graph" page select details and click on Graph Button
    Then switch to hourly and download csv and pdf for different "<role>".

    @sanity @Graph @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 60935 |
    @sanity @Graph @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 60935 |
    @sanity @Graph @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 60935 |
    @sanity @Graph @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 60935 |
    @sanity @Graph @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 60935 |


  Scenario Outline: Graph | verify graph-daily csv and pdf download for all timestamp with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select details and click on Graph Button and then download csv and pdf for all timestamp for different "<role>".

    @sanity @Graph @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 60936 |
    @sanity @Graph @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 60936 |
    @sanity @Graph @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 60936 |
    @sanity @Graph @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 60936 |
    @sanity @Graph @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 60936 |


  Scenario Outline: Graph | verify graph-hourly csv and pdf download for all timestamp with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Graph" page select details and click on Graph Button
    Then switch to hourly and download csv and pdf for all timestamp for different "<role>".

    @sanity @Graph @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 60937 |
    @sanity @Graph @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 60937 |
    @sanity @Graph @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 60937 |
    @sanity @Graph @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 60937 |
    @sanity @Graph @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 60937 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68197
  Scenario Outline: Graph |(C68197) Verify if graph is loading for the measurements minimum and maximum temperature combination for single site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site for "<role>" user
    And select measurement as max & min temp
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "1" sites with selected measurement, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for max & min temp measurement
    Then verify the values in the API response should match with respect to the integer value in table for multiple columns, for the "1" site selected
    @sanity @Graph @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 68197 |
    @sanity @Graph @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 68197 |
    @sanity @Graph @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 68197 |
    @sanity @Graph @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 68197 |
    @sanity @Graph @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 68197 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68198
  Scenario Outline: Graph |(C68198) Verify if graph is loading for the measurement "Chlorophyll Index" for single site for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site for "<role>" user
    And select measurement as "Chlorophyll Index"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "1" sites with selected measurement, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for chloroIndex measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "1" sites selected
    @sanity @Graph @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 68198 |
    @sanity @Graph @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 68198 |
    @sanity @Graph @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 68198 |
    @sanity @Graph @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 68198 |
    @sanity @Graph @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 68198 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68199
  Scenario Outline: Graph |(C68199) Verify if graph is loading for the measurement "ETc" for single site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site for "<role>" user
    And select measurement as "Daily ETc"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "Daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "1" sites with selected measurement, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for daily etc measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "1" sites selected
    @sanity @Graph @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 68199 |
    @sanity @Graph @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 68199 |
    @sanity @Graph @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 68199 |
    @sanity @Graph @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 68199 |
    @sanity @Graph @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 68199 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68200
  Scenario Outline: Graph |(C68200) Verify if graph is loading for the measurement "Leaf Wetness" for single site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site for "<role>" user
    And select measurement as "Leaf Wetness"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "Daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "1" sites with selected measurement, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for leaf wetness measurement
    Then verify the values in the API response should match with respect to the integer value in table, for the "1" sites selected
    @sanity @Graph @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 68200 |
    @sanity @Graph @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 68200 |
    @sanity @Graph @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 68200 |
    @sanity @Graph @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 68200 |
    @sanity @Graph @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 68200 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68201
  Scenario Outline: Graph |(C68201) Verify if graph is loading for the measurement "NDVI" for single site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site for "<role>" user
    And select measurement as "NDVI"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "1" sites with selected measurement, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for ndvi measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "1" sites selected
    @sanity @Graph @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 68201 |
    @sanity @Graph @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 68201 |
    @sanity @Graph @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 68201 |
    @sanity @Graph @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 68201 |
    @sanity @Graph @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 68201 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68240
  Scenario Outline: Graph |(C68240)Verify if graph is loading for the measurement "Solar Radiation" for multiple sites in Hourly view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Solar Radiation", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the the hours is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for hourly
    Then verifying the api count for swdw with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 68240 |
    @sanity @Graph @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 68240 |
    @sanity @Graph @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 68240 |
    @sanity @Graph @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 68240 |
    @sanity @Graph @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 68240 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68241
  Scenario Outline: Graph |(C68241) Verify if the Daily view graph data can be downloaded in PDF and CSV format for single site for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And navigate to "Graph" page select details and click on Graph Button
    Then switch to daily and verify it with "1" sites
    And verify the toast message on downloading the graph for csv and pdf format
    @sanity @Graph @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 68241 |
    @sanity @Graph @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 68241 |
    @sanity @Graph @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 68241 |
    @sanity @Graph @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 68241 |
    @sanity @Graph @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 68241 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68242
  Scenario Outline: Graph |(C68242) Verify if the Daily view graph data can be downloaded in PDF and CSV format for multiple sites for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And navigate to "Graph" page select details and click on Graph Button
    Then switch to daily and verify it with "2" sites
    And verify the toast message on downloading the graph for csv and pdf format
    @sanity @Graph @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 68242 |
    @sanity @Graph @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 68242 |
    @sanity @Graph @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 68242 |
    @sanity @Graph @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 68242 |
    @sanity @Graph @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 68242 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68243
  Scenario Outline: Graph |(C68243) Verify if the Hourly view graph data can be downloaded in PDF and CSV format for single site for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And navigate to "Graph" page select details and click on Graph Button
    Then switch to hourly and verify it with "1" sites
    And verify the toast message on downloading the graph for csv and pdf format
    @sanity @Graph @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 68243 |
    @sanity @Graph @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 68243 |
    @sanity @Graph @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 68243 |
    @sanity @Graph @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 68243 |
    @sanity @Graph @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 68243 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68244
  Scenario Outline: Graph |(C68244) Verify if the Hourly view graph data can be downloaded in PDF and CSV format for multiple sites for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And navigate to "Graph" page select details and click on Graph Button
    Then switch to hourly and verify it with "2" sites
    And verify the toast message on downloading the graph for csv and pdf format
    @sanity @Graph @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 68244 |
    @sanity @Graph @teamAdmin @Scenario17
    Examples:
      | role      | tcId  |
      | teamAdmin | 68244 |
    @sanity @Graph @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 68244 |
    @sanity @Graph @sysReader @Scenario17
    Examples:
      | role      | tcId  |
      | sysReader | 68244 |
    @sanity @Graph @orgReader @Scenario17
    Examples:
      | role      | tcId  |
      | orgReader | 68244 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68202
  Scenario Outline: Graph |(C68202) Verify if graph is loading for the measurement "Precipitation" for single site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site for "<role>" user
    And select measurement as "Precipitation"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "Daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "1" sites with selected measurement, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for precipitation measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "1" sites selected
    @sanity @Graph @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 68202 |
    @sanity @Graph @member @Scenario18
    Examples:
      | role   | tcId  |
      | member | 68202 |
    @sanity @Graph @teamAdmin @Scenario18
    Examples:
      | role      | tcId  |
      | teamAdmin | 68202 |
    @sanity @Graph @orgReader @Scenario18
    Examples:
      | role      | tcId  |
      | orgReader | 68202 |
    @sanity @Graph @sysReader @Scenario18
    Examples:
      | role      | tcId  |
      | sysReader | 68202 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68203
  Scenario Outline: Graph |(C68203) Verify if graph is loading for the measurement "Relative Humidity" for single site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site for "<role>" user
    And select measurement as "Relative Humidity"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "Daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "1" sites with selected measurement, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for relative humidity measurement
    Then verify the values in the API response should match with respect to the integer value in table, for the "1" sites selected
    @sanity @Graph @orgAdmin @Scenario19
    Examples:
      | role     | tcId  |
      | orgAdmin | 68203 |
    @sanity @Graph @member @Scenario19
    Examples:
      | role   | tcId  |
      | member | 68203 |
    @sanity @Graph @teamAdmin @Scenario19
    Examples:
      | role      | tcId  |
      | teamAdmin | 68203 |
    @sanity @Graph @orgReader @Scenario19
    Examples:
      | role      | tcId  |
      | orgReader | 68203 |
    @sanity @Graph @sysReader @Scenario19
    Examples:
      | role      | tcId  |
      | sysReader | 68203 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68204
  Scenario Outline: Graph |(C68204) Verify if graph is loading for the measurement "Vapor Pressure Deficit" for single site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site for "<role>" user
    And select measurement as "Vapor Pressure Deficit"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "Daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "1" sites with selected measurement, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for vapor pressure deficit measurement
    Then verify the values in the API response should match with respect to the integer & double value in table, for the "1" sites selected
    @sanity @Graph @orgAdmin @Scenario20
    Examples:
      | role     | tcId  |
      | orgAdmin | 68204 |
    @sanity @Graph @member @Scenario20
    Examples:
      | role   | tcId  |
      | member | 68204 |
    @sanity @Graph @teamAdmin @Scenario20
    Examples:
      | role      | tcId  |
      | teamAdmin | 68204 |
    @sanity @Graph @orgReader @Scenario20
    Examples:
      | role      | tcId  |
      | orgReader | 68204 |
    @sanity @Graph @sysReader @Scenario20
    Examples:
      | role      | tcId  |
      | sysReader | 68204 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68205
  Scenario Outline: Graph |(C68205) Verify if graph is loading for the measurement "Wind" for single site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site for "<role>" user
    And select measurement as "Wind"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "Daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "1" sites with selected measurement, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for wind measurement
    Then verify the values in the API response should match with respect to the integer value in table for multiple columns, for the "1" site selected
    @sanity @Graph @orgAdmin @Scenario21
    Examples:
      | role     | tcId  |
      | orgAdmin | 68205 |
    @sanity @Graph @member @Scenario21
    Examples:
      | role   | tcId  |
      | member | 68205 |
    @sanity @Graph @teamAdmin @Scenario21
    Examples:
      | role      | tcId  |
      | teamAdmin | 68205 |
    @sanity @Graph @orgReader @Scenario21
    Examples:
      | role      | tcId  |
      | orgReader | 68205 |
    @sanity @Graph @sysReader @Scenario21
    Examples:
      | role      | tcId  |
      | sysReader | 68205 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68207
  Scenario Outline: Graph |(C68207) Verify if graph is loading for the measurements minimum and maximum temperature combination for multiple sites in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site for "<role>" user
    And select measurement as max & min temp
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for "2" sites & measurements selected with units and the load more option at the end for max & min temp measurement
    Then verify the values in the API response should match with respect to the integer value in table for multiple sites & measurements selected
    @sanity @Graph @orgAdmin @Scenario22
    Examples:
      | role     | tcId  |
      | orgAdmin | 68207 |
    @sanity @Graph @member @Scenario22
    Examples:
      | role   | tcId  |
      | member | 68207 |
    @sanity @Graph @teamAdmin @Scenario22
    Examples:
      | role      | tcId  |
      | teamAdmin | 68207 |
    @sanity @Graph @orgReader @Scenario22
    Examples:
      | role      | tcId  |
      | orgReader | 68207 |
    @sanity @Graph @sysReader @Scenario22
    Examples:
      | role      | tcId  |
      | sysReader | 68207 |

     #  https://arabletestrail.testrail.io/index.php?/cases/view/68192
  Scenario Outline: Graph |(C68192) verify whether the error message is displayed if we select more than 10 sites for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then verify whether the errorMessage displayed if we selecting more than 10 sites for "<role>"
    @sanity @Graph @orgAdmin @Scenario23
    Examples:
      | role     | tcId  |
      | orgAdmin | 68192 |
    @sanity @Graph @member @Scenario23
    Examples:
      | role   | tcId  |
      | member | 68192 |
    @sanity @Graph @teamAdmin @Scenario23
    Examples:
      | role      | tcId  |
      | teamAdmin | 68192 |
    @sanity @Graph @orgReader @Scenario23
    Examples:
      | role      | tcId  |
      | orgReader | 68192 |
    @sanity @Graph @sysReader @Scenario23
    Examples:
      | role      | tcId  |
      | sysReader | 68192 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68192
  Scenario Outline: Graph |(C68192) verify whether the error message is displayed if we select more than 2 measurements for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then verify whether the errorMessage displayed after selecting more than 2 measurements
    @sanity @Graph @orgAdmin @Scenario24
    Examples:
      | role     | tcId  |
      | orgAdmin | 68192 |
    @sanity @Graph @member @Scenario24
    Examples:
      | role   | tcId  |
      | member | 68192 |
    @sanity @Graph @teamAdmin @Scenario24
    Examples:
      | role      | tcId  |
      | teamAdmin | 68192 |
    @sanity @Graph @orgReader @Scenario24
    Examples:
      | role      | tcId  |
      | orgReader | 68192 |
    @sanity @Graph @sysReader @Scenario24
    Examples:
      | role      | tcId  |
      | sysReader | 68192 |


    #  https://arabletestrail.testrail.io/index.php?/cases/view/68192
  Scenario Outline: Graph |(C68192) If the user selects multiple sites and with two measurement and with "ALL" timeline, the graph should show the correct values for each day in the graph for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    And select 5 sites and verify the selected sites tags are displayed on graph page
    And select 2 measurements maxTemp & minTemp and verify the selected measurements is displayed on the menu
    Then verify that the "Graph" button should not highlight before selecting the preferred date from calendar
    And select predefined Date in timeline and click on Graph button
    Then verify whether the Daily and Historical API calls are displayed on the network tab
    @sanity @Graph @orgAdmin @Scenario25
    Examples:
      | role     | tcId  |
      | orgAdmin | 68192 |
    @sanity @Graph @member @Scenario25
    Examples:
      | role   | tcId  |
      | member | 68192 |
    @sanity @Graph @teamAdmin @Scenario25
    Examples:
      | role      | tcId  |
      | teamAdmin | 68192 |
    @sanity @Graph @orgReader @Scenario25
    Examples:
      | role      | tcId  |
      | orgReader | 68192 |
    @sanity @Graph @sysReader @Scenario25
    Examples:
      | role      | tcId  |
      | sysReader | 68192 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68206
  Scenario Outline: Graph |(C68206) Verify if graph is loading for the measurement "Soil Moisture" for single site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "1" site and measurement as soil moisture
    And select predefined Date in timeline and click on Graph button & verify chart graph is displayed or not
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over for soil moisture measure
    Then verify whether the table is displayed for "1" sites and measurement as soil moisture, site names, Generated date and number of records
    And verify whether the table have columns of selected measurement with units and the load more option at the end for soil moisture measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "1" sites selected
    @sanity @Graph @orgAdmin @Scenario26
    Examples:
      | role     | tcId  |
      | orgAdmin | 68206 |
    @sanity @Graph @member @Scenario26
    Examples:
      | role   | tcId  |
      | member | 68206 |
    @sanity @Graph @teamAdmin @Scenario26
    Examples:
      | role      | tcId  |
      | teamAdmin | 68206 |
    @sanity @Graph @orgReader @Scenario26
    Examples:
      | role      | tcId  |
      | orgReader | 68206 |
    @sanity @Graph @sysReader @Scenario26
    Examples:
      | role      | tcId  |
      | sysReader | 68206 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68208
  Scenario Outline: Graph |(C68208) Verify if graph is loading for the measurement "Chlorophyll Index" for multiple sites in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site for "<role>" user
    And select measurement as "Chlorophyll Index"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for selected "2" sites as measurement with units "chlorophyll" and the load more option at the end for "Chlorophyll Index" measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "2" sites selected
    @sanity @Graph @orgAdmin @Scenario27
    Examples:
      | role     | tcId  |
      | orgAdmin | 68208 |
    @sanity @Graph @member @Scenario27
    Examples:
      | role   | tcId  |
      | member | 68208 |
    @sanity @Graph @teamAdmin @Scenario27
    Examples:
      | role      | tcId  |
      | teamAdmin | 68208 |
    @sanity @Graph @orgReader @Scenario27
    Examples:
      | role      | tcId  |
      | orgReader | 68208 |
    @sanity @Graph @sysReader @Scenario27
    Examples:
      | role      | tcId  |
      | sysReader | 68208 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68209
  Scenario Outline: Graph |(C68209) Verify if graph is loading for the measurement "ETc" for multiple sites in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site for "<role>" user
    And select measurement as "Daily ETc"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for selected "2" sites as measurement with units & the load more option at the end for "Daily ETc" measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "2" sites selected
    @sanity @Graph @orgAdmin @Scenario28
    Examples:
      | role     | tcId  |
      | orgAdmin | 68209 |
    @sanity @Graph @member @Scenario28
    Examples:
      | role   | tcId  |
      | member | 68209 |
    @sanity @Graph @teamAdmin @Scenario28
    Examples:
      | role      | tcId  |
      | teamAdmin | 68209 |
    @sanity @Graph @orgReader @Scenario28
    Examples:
      | role      | tcId  |
      | orgReader | 68209 |
    @sanity @Graph @sysReader @Scenario28
    Examples:
      | role      | tcId  |
      | sysReader | 68209 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68210
  Scenario Outline: Graph |(C68210) Verify if graph is loading for the measurement "Leaf Wetness" for multiple sites in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site for "<role>" user
    And select measurement as "Leaf Wetness"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for selected "2" sites as measurement with units "hours since midnight" and the load more option at the end for "Leaf Wetness" measurement
    Then verify the values in the API response should match with respect to the integer value in table, for the "2" sites selected
    @sanity @Graph @orgAdmin @Scenario29
    Examples:
      | role     | tcId  |
      | orgAdmin | 68210 |
    @sanity @Graph @member @Scenario29
    Examples:
      | role   | tcId  |
      | member | 68210 |
    @sanity @Graph @teamAdmin @Scenario29
    Examples:
      | role      | tcId  |
      | teamAdmin | 68210 |
    @sanity @Graph @orgReader @Scenario29
    Examples:
      | role      | tcId  |
      | orgReader | 68210 |
    @sanity @Graph @sysReader @Scenario29
    Examples:
      | role      | tcId  |
      | sysReader | 68210 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68211
  Scenario Outline: Graph |(C68211) Verify if graph is loading for the measurement "NDVI" for multiple sites in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site for "<role>" user
    And select measurement as "NDVI"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for selected "2" sites as measurement with units "ndvi" and the load more option at the end for "NDVI" measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "2" sites selected
    @sanity @Graph @orgAdmin @Scenario30
    Examples:
      | role     | tcId  |
      | orgAdmin | 68211 |
    @sanity @Graph @member @Scenario30
    Examples:
      | role   | tcId  |
      | member | 68211 |
    @sanity @Graph @teamAdmin @Scenario30
    Examples:
      | role      | tcId  |
      | teamAdmin | 68211 |
    @sanity @Graph @orgReader @Scenario30
    Examples:
      | role      | tcId  |
      | orgReader | 68211 |
    @sanity @Graph @sysReader @Scenario30
    Examples:
      | role      | tcId  |
      | sysReader | 68211 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68212
  Scenario Outline: Graph |(C68212) Verify if graph is loading for the measurement "Precipitation" for multiple sites in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site for "<role>" user
    And select measurement as "Precipitation"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for selected "2" sites as measurement with units & the load more option at the end for "Precipitation" measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "2" sites selected
    @sanity @Graph @orgAdmin @Scenario31
    Examples:
      | role     | tcId  |
      | orgAdmin | 68212 |
    @sanity @Graph @member @Scenario31
    Examples:
      | role   | tcId  |
      | member | 68212 |
    @sanity @Graph @teamAdmin @Scenario31
    Examples:
      | role      | tcId  |
      | teamAdmin | 68212 |
    @sanity @Graph @orgReader @Scenario31
    Examples:
      | role      | tcId  |
      | orgReader | 68212 |
    @sanity @Graph @sysReader @Scenario31
    Examples:
      | role      | tcId  |
      | sysReader | 68212 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68213
  Scenario Outline: Graph |(C68213) Verify if graph is loading for the measurement "Relative Humidity" for multiple sites in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site for "<role>" user
    And select measurement as "Relative Humidity"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for selected "2" sites as measurement with units "%" and the load more option at the end for "Relative Humidity" measurement
    Then verify the values in the API response should match with respect to the integer value in table, for the "2" sites selected
    @sanity @Graph @orgAdmin @Scenario32
    Examples:
      | role     | tcId  |
      | orgAdmin | 68213 |
    @sanity @Graph @member @Scenario32
    Examples:
      | role   | tcId  |
      | member | 68213 |
    @sanity @Graph @teamAdmin @Scenario32
    Examples:
      | role      | tcId  |
      | teamAdmin | 68213 |
    @sanity @Graph @orgReader @Scenario32
    Examples:
      | role      | tcId  |
      | orgReader | 68213 |
    @sanity @Graph @sysReader @Scenario32
    Examples:
      | role      | tcId  |
      | sysReader | 68213 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68214
  Scenario Outline: Graph |(C68214) Verify if graph is loading for the measurement "Vapor Pressure Deficit" for multiple sites in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site for "<role>" user
    And select measurement as "Vapor Pressure Deficit"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for selected "2" sites as measurement with units and the load more option at the end for "Vapor Pressure Deficit" measurement
    Then verify the values in the API response should match with respect to the integer & double value in table, for the "2" sites selected
    @sanity @Graph @orgAdmin @Scenario33
    Examples:
      | role     | tcId  |
      | orgAdmin | 68214 |
    @sanity @Graph @member @Scenario33
    Examples:
      | role   | tcId  |
      | member | 68214 |
    @sanity @Graph @teamAdmin @Scenario33
    Examples:
      | role      | tcId  |
      | teamAdmin | 68214 |
    @sanity @Graph @orgReader @Scenario33
    Examples:
      | role      | tcId  |
      | orgReader | 68214 |
    @sanity @Graph @sysReader @Scenario33
    Examples:
      | role      | tcId  |
      | sysReader | 68214 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68215
  Scenario Outline: Graph |(C68215) Verify if graph is loading for the measurement "Wind" for multiple sites in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site for "<role>" user
    And select measurement as "Wind"
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for selected "2" sites as measurements with units and the load more option at the end for "Wind" measurement
    Then verify the values in the API response should match with respect to the integer value in table, for the sites selected
    @sanity @Graph @orgAdmin @Scenario34
    Examples:
      | role     | tcId  |
      | orgAdmin | 68215 |
    @sanity @Graph @member @Scenario34
    Examples:
      | role   | tcId  |
      | member | 68215 |
    @sanity @Graph @teamAdmin @Scenario34
    Examples:
      | role      | tcId  |
      | teamAdmin | 68215 |
    @sanity @Graph @orgReader @Scenario34
    Examples:
      | role      | tcId  |
      | orgReader | 68215 |
    @sanity @Graph @sysReader @Scenario34
    Examples:
      | role      | tcId  |
      | sysReader | 68215 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68216
  Scenario Outline: Graph |(C68216) Verify if graph is loading for the measurement "Soil Moisture" for multiple site in Daily view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And get token, userID, units for "<role>" user and then get orgID
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select a "2" site and measurement as soil moisture
    And select predefined Date in timeline and click on Graph button
    Then verify the selected pre-defined days is highlighted in the graph page
    And by default "daily" timeline button will be selected
    And the timeline series will have the selected dates displayed when hovered over
    Then verify whether the table is displayed for "2" sites with selected measurement, site names, Generated date and number of records
    And verify the table for selected "2" sites as measurement with units "VWC %" and the load more option at the end for "Soil Moisture" measurement
    Then verify the values in the API response should match with respect to the double value in table, for the "2" sites selected
    @sanity @Graph @orgAdmin @Scenario35
    Examples:
      | role     | tcId  |
      | orgAdmin | 68216 |
    @sanity @Graph @member @Scenario35
    Examples:
      | role   | tcId  |
      | member | 68216 |
    @sanity @Graph @teamAdmin @Scenario35
    Examples:
      | role      | tcId  |
      | teamAdmin | 68216 |
    @sanity @Graph @orgReader @Scenario35
    Examples:
      | role      | tcId  |
      | orgReader | 68216 |
    @sanity @Graph @sysReader @Scenario35
    Examples:
      | role      | tcId  |
      | sysReader | 68216 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68221
  Scenario Outline: Graph |(C68221)Verify if graph is loading for the measurement "Relative Humidity" for single site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Relative Humidity", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify the units displayed in the account page are the same in the table for Relative Humidity and load more option is displayed
    Then verifying the api count for Relative Humidity with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario36
    Examples:
      | role     | tcId  |
      | orgAdmin | 68221 |
    @sanity @Graph @teamAdmin @Scenario36
    Examples:
      | role      | tcId  |
      | teamAdmin | 68221 |
    @sanity @Graph @member @Scenario36
    Examples:
      | role   | tcId  |
      | member | 68221 |
    @sanity @Graph @sysReader @Scenario36
    Examples:
      | role      | tcId  |
      | sysReader | 68221 |
    @sanity @Graph @orgReader @Scenario36
    Examples:
      | role      | tcId  |
      | orgReader | 68221 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68222
  Scenario Outline: Graph |(C68222)Verify if graph is loading for the measurement "Vapor Pressure Deficit" for single site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Vapor Pressure Deficit", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify the units displayed in the account page are the same in the table for Vapor Pressure Deficit and load more option is displayed
    Then verifying the api count for Vapor Pressure Deficit with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario37
    Examples:
      | role     | tcId  |
      | orgAdmin | 68222 |
    @sanity @Graph @teamAdmin @Scenario37
    Examples:
      | role      | tcId  |
      | teamAdmin | 68222 |
    @sanity @Graph @member @Scenario37
    Examples:
      | role   | tcId  |
      | member | 68222 |
    @sanity @Graph @sysReader @Scenario37
    Examples:
      | role      | tcId  |
      | sysReader | 68222 |
    @sanity @Graph @orgReader @Scenario37
    Examples:
      | role      | tcId  |
      | orgReader | 68222 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68229
  Scenario Outline: Graph |(C68229)Verify if graph is loading for the measurement "Relative Humidity" for multiple sites in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Relative Humidity", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify the units displayed in the account page are the same in the table for Relative Humidity and load more option is displayed
    Then verifying the api count for Relative Humidity with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario38
    Examples:
      | role     | tcId  |
      | orgAdmin | 68229 |
    @sanity @Graph @teamAdmin @Scenario38
    Examples:
      | role      | tcId  |
      | teamAdmin | 68229 |
    @sanity @Graph @member @Scenario38
    Examples:
      | role   | tcId  |
      | member | 68229 |
    @sanity @Graph @sysReader @Scenario38
    Examples:
      | role      | tcId  |
      | sysReader | 68229 |
    @sanity @Graph @orgReader @Scenario38
    Examples:
      | role      | tcId  |
      | orgReader | 68229 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68230
  Scenario Outline: Graph |(C68230)Verify if graph is loading for the measurement "Vapor Pressure Deficit" for multiple sites in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Vapor Pressure Deficit", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly for Vapor Pressure Deficit
    And verify the units displayed in the account page are the same in the table for Vapor Pressure Deficit and load more option is displayed
    Then verifying the api count for Vapor Pressure Deficit with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario39
    Examples:
      | role     | tcId  |
      | orgAdmin | 68230 |
    @sanity @Graph @teamAdmin @Scenario39
    Examples:
      | role      | tcId  |
      | teamAdmin | 68230 |
    @sanity @Graph @member @Scenario39
    Examples:
      | role   | tcId  |
      | member | 68230 |
    @sanity @Graph @sysReader @Scenario39
    Examples:
      | role      | tcId  |
      | sysReader | 68230 |
    @sanity @Graph @orgReader @Scenario39
    Examples:
      | role      | tcId  |
      | orgReader | 68230 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68224
  Scenario Outline:Graph |(C68224)Verify if graph is loading for the measurement "Soil Moisture" for single site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Soil Moisture", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "Hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for Soil Moisture measurement
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for Soil Moisture
    Then verifying the api count for soil Moisture value with UI average for Hourly
    @sanity @Graph @orgAdmin @Scenario40
    Examples:
      | role     | tcId  |
      | orgAdmin | 68224 |
    @sanity @Graph @teamAdmin @Scenario40
    Examples:
      | role      | tcId  |
      | teamAdmin | 68224 |
    @sanity @Graph @member @Scenario40
    Examples:
      | role   | tcId  |
      | member | 68224 |
    @sanity @Graph @sysReader @Scenario40
    Examples:
      | role      | tcId  |
      | sysReader | 68224 |
    @sanity @Graph @orgReader @Scenario40
    Examples:
      | role      | tcId  |
      | orgReader | 68224 |
   # https://arabletestrail.testrail.io/index.php?/cases/view/68232
  Scenario Outline:Graph |(C68232)Verify if graph is loading for the measurement "Soil Moisture" for multiple sites in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Soil Moisture", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "Hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for Soil Moisture measurement
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for Soil Moisture
    Then verifying the api count for soil Moisture value with UI average for Hourly
    @sanity @Graph @orgAdmin @Scenario41
    Examples:
      | role     | tcId  |
      | orgAdmin | 68232 |
    @sanity @Graph @teamAdmin @Scenario41
    Examples:
      | role      | tcId  |
      | teamAdmin | 68232 |
    @sanity @Graph @member @Scenario41
    Examples:
      | role   | tcId  |
      | member | 68232 |
    @sanity @Graph @sysReader @Scenario41
    Examples:
      | role      | tcId  |
      | sysReader | 68232 |
    @sanity @Graph @orgReader @Scenario41
    Examples:
      | role      | tcId  |
      | orgReader | 68232 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68233
  Scenario Outline: Graph |(C68233)Verify if graph is loading for the measurement "Soil Temperature" for single site in Daily view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Soil Temperature", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the the daily is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for Soil Temperature measurement
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for Soil Temperature
    Then verifying the api count for soil temperature value with UI average
    @sanity @Graph @orgAdmin @Scenario42
    Examples:
      | role     | tcId  |
      | orgAdmin | 68233 |
    @sanity @Graph @teamAdmin @Scenario42
    Examples:
      | role      | tcId  |
      | teamAdmin | 68233 |
    @sanity @Graph @member @Scenario42
    Examples:
      | role   | tcId  |
      | member | 68233 |
    @sanity @Graph @sysReader @Scenario42
    Examples:
      | role      | tcId  |
      | sysReader | 68233 |
    @sanity @Graph @orgReader @Scenario42
    Examples:
      | role      | tcId  |
      | orgReader | 68233 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68234
  Scenario Outline:Graph |(C68234)Verify if graph is loading for the measurement "Soil Temperature" for multiple sites in Daily view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Soil Temperature", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the the daily is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for Soil Temperature measurement
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for Soil Temperature
    Then verifying the api count for soil temperature value with UI average
    @sanity @Graph @orgAdmin @Scenario43
    Examples:
      | role     | tcId  |
      | orgAdmin | 68234 |
    @sanity @Graph @teamAdmin @Scenario43
    Examples:
      | role      | tcId  |
      | teamAdmin | 68234 |
    @sanity @Graph @member @Scenario43
    Examples:
      | role   | tcId  |
      | member | 68234 |
    @sanity @Graph @sysReader @Scenario43
    Examples:
      | role      | tcId  |
      | sysReader | 68234 |
    @sanity @Graph @orgReader @Scenario43
    Examples:
      | role      | tcId  |
      | orgReader | 68234 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68235
  Scenario Outline:Graph |(C68235)Verify if graph is loading for the measurement "Soil Temperature" for single sites in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Soil Temperature", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "Hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for Soil Temperature measurement
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for Soil Temperature
    Then verifying the api count for soil temperature value with UI average for Hourly
    @sanity @Graph @orgAdmin @Scenario44
    Examples:
      | role     | tcId  |
      | orgAdmin | 68235 |
    @sanity @Graph @teamAdmin @Scenario44
    Examples:
      | role      | tcId  |
      | teamAdmin | 68235 |
    @sanity @Graph @member @Scenario44
    Examples:
      | role   | tcId  |
      | member | 68235 |
    @sanity @Graph @sysReader @Scenario44
    Examples:
      | role      | tcId  |
      | sysReader | 68235 |
    @sanity @Graph @orgReader @Scenario44
    Examples:
      | role      | tcId  |
      | orgReader | 68235 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68236
  Scenario Outline:Graph |(C68236)Verify if graph is loading for the measurement "Soil Temperature" for multiple sites in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Soil Temperature", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "Hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for Soil Temperature measurement
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for Soil Temperature
    Then verifying the api count for soil temperature value with UI average for Hourly
    @sanity @Graph @orgAdmin @Scenario45
    Examples:
      | role     | tcId  |
      | orgAdmin | 68236 |
    @sanity @Graph @teamAdmin @Scenario45
    Examples:
      | role      | tcId  |
      | teamAdmin | 68236 |
    @sanity @Graph @member @Scenario45
    Examples:
      | role   | tcId  |
      | member | 68236 |
    @sanity @Graph @sysReader @Scenario45
    Examples:
      | role      | tcId  |
      | sysReader | 68236 |
    @sanity @Graph @orgReader @Scenario45
    Examples:
      | role      | tcId  |
      | orgReader | 68236 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68237
  Scenario Outline: Graph |(C68237)Verify if graph is loading for the measurement "Solar Radiation" for single site in Daily view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Solar Radiation", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the the daily is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for daily
    Then verifying the api count for swdw with UI
    @sanity @Graph @orgAdmin @Scenario46
    Examples:
      | role     | tcId  |
      | orgAdmin | 68237 |
    @sanity @Graph @teamAdmin @Scenario46
    Examples:
      | role      | tcId  |
      | teamAdmin | 68237 |
    @sanity @Graph @member @Scenario46
    Examples:
      | role   | tcId  |
      | member | 68237 |
    @sanity @Graph @sysReader @Scenario46
    Examples:
      | role      | tcId  |
      | sysReader | 68237 |
    @sanity @Graph @orgReader @Scenario46
    Examples:
      | role      | tcId  |
      | orgReader | 68237 |

  #https://arabletestrail.testrail.io/index.php?/cases/view/68238
  Scenario Outline: Graph |(C68238)Verify if graph is loading for the measurement "Solar Radiation" for single site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Solar Radiation", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly for Solar Radiation
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for hourly
    Then verifying the api count for swdw with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario47
    Examples:
      | role     | tcId  |
      | orgAdmin | 68238 |
    @sanity @Graph @teamAdmin @Scenario47
    Examples:
      | role      | tcId  |
      | teamAdmin | 68238 |
    @sanity @Graph @member @Scenario47
    Examples:
      | role   | tcId  |
      | member | 68238 |
    @sanity @Graph @sysReader @Scenario47
    Examples:
      | role      | tcId  |
      | sysReader | 68238 |
    @sanity @Graph @orgReader @Scenario47
    Examples:
      | role      | tcId  |
      | orgReader | 68238 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68239
  Scenario Outline: Graph |(C68239)Verify if graph is loading for the measurement "Solar Radiation" for multiple sites in Daily view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Solar Radiation", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the the daily is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table and load more option is displayed for daily
    Then verifying the api count for swdw with UI
    @sanity @Graph @orgAdmin @Scenario48
    Examples:
      | role     | tcId  |
      | orgAdmin | 68239 |
    @sanity @Graph @teamAdmin @Scenario48
    Examples:
      | role      | tcId  |
      | teamAdmin | 68239 |
    @sanity @Graph @member @Scenario48
    Examples:
      | role   | tcId  |
      | member | 68239 |
    @sanity @Graph @sysReader @Scenario48
    Examples:
      | role      | tcId  |
      | sysReader | 68239 |
    @sanity @Graph @orgReader @Scenario48
    Examples:
      | role      | tcId  |
      | orgReader | 68239 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68217
  Scenario Outline: Graph |(C68217)Verify if graph is loading for the measurements minimum and maximum temperature combination for single site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Maximum Temperature" and "Minimum Temperature" and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify the units displayed in the account page are the same in the table for Maximum Temperature,Minimum Temperature and load more option is displayed
    Then verifying the api count for Maximum Temperature and Minimum Temperature with UI in hourly view for single sites
    @sanity @Graph @orgAdmin @Scenario49
    Examples:
      | role     | tcId  |
      | orgAdmin | 68217 |
    @sanity @Graph @teamAdmin @Scenario49
    Examples:
      | role      | tcId  |
      | teamAdmin | 68217 |
    @sanity @Graph @member @Scenario49
    Examples:
      | role   | tcId  |
      | member | 68217 |
    @sanity @Graph @sysReader @Scenario49
    Examples:
      | role      | tcId  |
      | sysReader | 68217 |
    @sanity @Graph @orgReader @Scenario49
    Examples:
      | role      | tcId  |
      | orgReader | 68217 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68218
  Scenario Outline: Graph |(C68218)Verify if graph is loading for the measurement "ETc" for single site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Daily ETc", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table for ETc and load more option is displayed
    Then verifying the api count for ETc with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario50
    Examples:
      | role     | tcId  |
      | orgAdmin | 68218 |
    @sanity @Graph @teamAdmin @Scenario50
    Examples:
      | role      | tcId  |
      | teamAdmin | 68218 |
    @sanity @Graph @member @Scenario50
    Examples:
      | role   | tcId  |
      | member | 68218 |
    @sanity @Graph @sysReader @Scenario50
    Examples:
      | role      | tcId  |
      | sysReader | 68218 |
    @sanity @Graph @orgReader @Scenario50
    Examples:
      | role      | tcId  |
      | orgReader | 68218 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68219
  Scenario Outline: Graph |(C68219)Verify if graph is loading for the measurement Leaf Wetness for single site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Leaf Wetness", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table for Leaf Wetness and load more option is displayed
    Then verifying the api count for Leaf Wetness with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario51
    Examples:
      | role     | tcId  |
      | orgAdmin | 68219 |
    @sanity @Graph @teamAdmin @Scenario51
    Examples:
      | role      | tcId  |
      | teamAdmin | 68219 |
    @sanity @Graph @member @Scenario51
    Examples:
      | role   | tcId  |
      | member | 68219 |
    @sanity @Graph @sysReader @Scenario51
    Examples:
      | role      | tcId  |
      | sysReader | 68219 |
    @sanity @Graph @orgReader @Scenario51
    Examples:
      | role      | tcId  |
      | orgReader | 68219 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68220
  Scenario Outline: Graph |(C68220)Verify if graph is loading for the measurement "Precipitation" for single site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Precipitation", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table for Precipitation and load more option is displayed
    Then verifying the api count for Precipitation with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario52
    Examples:
      | role     | tcId  |
      | orgAdmin | 68220 |
    @sanity @Graph @teamAdmin @Scenario52
    Examples:
      | role      | tcId  |
      | teamAdmin | 68220 |
    @sanity @Graph @member @Scenario52
    Examples:
      | role   | tcId  |
      | member | 68220 |
    @sanity @Graph @sysReader @Scenario52
    Examples:
      | role      | tcId  |
      | sysReader | 68220 |
    @sanity @Graph @orgReader @Scenario52
    Examples:
      | role      | tcId  |
      | orgReader | 68220 |

# https://arabletestrail.testrail.io/index.php?/cases/view/68223
  Scenario Outline: Graph |(C68223)Verify if graph is loading for the measurement "Wind" for single site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "1" site, measurement as "Wind", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify the units displayed in the account page are the same in the table for wind Deficit and load more option is displayed
    Then verify the values in the hourly API response should match with respect to the integer value in table, for the sites selected if wind
    @sanity @Graph @orgAdmin @Scenario53
    Examples:
      | role     | tcId  |
      | orgAdmin | 68223 |
    @sanity @Graph @teamAdmin @Scenario53
    Examples:
      | role      | tcId  |
      | teamAdmin | 68223 |
    @sanity @Graph @member @Scenario53
    Examples:
      | role   | tcId  |
      | member | 68223 |
    @sanity @Graph @sysReader @Scenario53
    Examples:
      | role      | tcId  |
      | sysReader | 68223 |
    @sanity @Graph @orgReader @Scenario53
    Examples:
      | role      | tcId  |
      | orgReader | 68223 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68225
  Scenario Outline: Graph |(C68225)Verify if graph is loading for the measurements minimum and maximum temperature combination for multiple sites in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Maximum Temperature" and "Minimum Temperature" and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify the units displayed in the account page are the same in the table for Maximum Temperature,Minimum Temperature and load more option is displayed
    Then verifying the api count for Maximum Temperature and Minimum Temperature with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario54
    Examples:
      | role     | tcId  |
      | orgAdmin | 68225 |
    @sanity @Graph @teamAdmin @Scenario54
    Examples:
      | role      | tcId  |
      | teamAdmin | 68225 |
    @sanity @Graph @member @Scenario54
    Examples:
      | role   | tcId  |
      | member | 68225 |
    @sanity @Graph @sysReader @Scenario54
    Examples:
      | role      | tcId  |
      | sysReader | 68225 |
    @sanity @Graph @orgReader @Scenario54
    Examples:
      | role      | tcId  |
      | orgReader | 68225 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68226
  Scenario Outline: Graph |(68226)Verify if graph is loading for the measurement "ETc" for multiple sites in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Daily ETc", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table for ETc and load more option is displayed
    Then verifying the api count for ETc with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario55
    Examples:
      | role     | tcId  |
      | orgAdmin | 68226 |
    @sanity @Graph @teamAdmin @Scenario55
    Examples:
      | role      | tcId  |
      | teamAdmin | 68226 |
    @sanity @Graph @member @Scenario55
    Examples:
      | role   | tcId  |
      | member | 68226 |
    @sanity @Graph @sysReader @Scenario55
    Examples:
      | role      | tcId  |
      | sysReader | 68226 |
    @sanity @Graph @orgReader @Scenario55
    Examples:
      | role      | tcId  |
      | orgReader | 68226 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68227
  Scenario Outline: Graph |(68227)Verify if graph is loading for the measurement "Leaf Wetness" for multiple sites in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Leaf Wetness", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table for Leaf Wetness and load more option is displayed
    Then verifying the api count for Leaf Wetness with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario56
    Examples:
      | role     | tcId  |
      | orgAdmin | 68227 |
    @sanity @Graph @teamAdmin @Scenario56
    Examples:
      | role      | tcId  |
      | teamAdmin | 68227 |
    @sanity @Graph @member @Scenario56
    Examples:
      | role   | tcId  |
      | member | 68227 |
    @sanity @Graph @sysReader @Scenario56
    Examples:
      | role      | tcId  |
      | sysReader | 68227 |
    @sanity @Graph @orgReader @Scenario56
    Examples:
      | role      | tcId  |
      | orgReader | 68227 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68228
  Scenario Outline: Graph |(C68228)Verify if graph is loading for the measurement "Precipitation" for multiple site in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Precipitation", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify that the table will be displayed with the selected measurement, site, generated date, and number of records
    And verify the units displayed in the account page are the same in the table for Precipitation and load more option is displayed
    Then verifying the api count for Precipitation with UI in hourly view
    @sanity @Graph @orgAdmin @Scenario57
    Examples:
      | role     | tcId  |
      | orgAdmin | 68228 |
    @sanity @Graph @teamAdmin @Scenario57
    Examples:
      | role      | tcId  |
      | teamAdmin | 68228 |
    @sanity @Graph @member @Scenario57
    Examples:
      | role   | tcId  |
      | member | 68228 |
    @sanity @Graph @sysReader @Scenario57
    Examples:
      | role      | tcId  |
      | sysReader | 68228 |
    @sanity @Graph @orgReader @Scenario57
    Examples:
      | role      | tcId  |
      | orgReader | 68228 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68231
  Scenario Outline: Graph |(C68231)Verify if graph is loading for the measurement "Wind" for multiple sites in Hourly view for the role "<role>"
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then verify and enter the details on the page. Select the "2" site, measurement as "Wind", and date as "All" for the role "<role>"
    And verify that the graph will be displayed for the pre-defined days and select date as "ALL"
    And verify once the "hourly" is selected then verify the selected pre-defined days is highlighted in the graph page
    And the timeline series will have the selected dates displayed when hovered over for hourly
    And verify the units displayed in the account page are the same in the table for wind Deficit and load more option is displayed
    Then verify the values in the hourly API response should match with respect to the integer value in table, for the sites selected
    @sanity @Graph @orgAdmin @Scenario58
    Examples:
      | role     | tcId  |
      | orgAdmin | 68231 |
    @sanity @Graph @teamAdmin @Scenario58
    Examples:
      | role      | tcId  |
      | teamAdmin | 68231 |
    @sanity @Graph @member @Scenario58
    Examples:
      | role   | tcId  |
      | member | 68231 |
    @sanity @Graph @sysReader @Scenario58
    Examples:
      | role      | tcId  |
      | sysReader | 68231 |
    @sanity @Graph @orgReader @Scenario58
    Examples:
      | role      | tcId  |
      | orgReader | 68231 |


#    This was getting fail due to the dates selected in UI is not matching with the daily API endpoint header dates
  # https://arabletestrail.testrail.io/index.php?/cases/view/68193
  Scenario Outline: Graph |(C68193) Verify if start date & end date in historical daily api call is matching with the start & end date selected in timeline for the "<role>" user.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then select a "1" site for "<role>" user
    And select measurement as "Wind"
    And select predefined Date in timeline and click on Graph button
    Then verify whether the start date & end date in historical daily & hourly api call is matching with the start & end date selected in timeline.
    @sanity @Graph @orgAdmin @Scenario59
    Examples:
      | role     | tcId  |
      | orgAdmin | 68193 |
    @sanity @Graph @member @Scenario59
    Examples:
      | role   | tcId  |
      | member | 68193 |
    @sanity @Graph @teamAdmin @Scenario59
    Examples:
      | role      | tcId  |
      | teamAdmin | 68193 |
    @sanity @Graph @orgReader @Scenario59
    Examples:
      | role      | tcId  |
      | orgReader | 68193 |
    @sanity @Graph @sysReader @Scenario59
    Examples:
      | role      | tcId  |
      | sysReader | 68193 |

#    This was getting fail due to the dates selected in UI is not matching with the historical (hourly) API endpoint header dates
  # https://arabletestrail.testrail.io/index.php?/cases/view/68194
  Scenario Outline: Graph |(C68194) Verify if start date & end date in historical hourly api call is matching with the start & end date selected in timeline for the "<role>" user.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Given get token, userID, units for "<role>" user and then get orgID
    When navigate to "Graph" page select details and click on Graph Button
    Then select a "1" site for "<role>" user
    And select measurement as "Wind"
    And select predefined Date in timeline and click on Graph button
    And click on hourly button and verify the graph
    Then verify whether the start date & end date in historical daily & hourly api call is matching with the start & end date selected in timeline.
    @sanity @Graph @orgAdmin @Scenario60
    Examples:
      | role     | tcId  |
      | orgAdmin | 68194 |
    @sanity @Graph @member @Scenario60
    Examples:
      | role   | tcId  |
      | member | 68194 |
    @sanity @Graph @teamAdmin @Scenario60
    Examples:
      | role      | tcId  |
      | teamAdmin | 68194 |
    @sanity @Graph @orgReader @Scenario60
    Examples:
      | role      | tcId  |
      | orgReader | 68194 |
    @sanity @Graph @sysReader @Scenario60
    Examples:
      | role      | tcId  |
      | sysReader | 68194 |

#    pre-requisite :-
#    If the wind sensor device has only one single site then only it works
  # https://arabletestrail.testrail.io/index.php?/cases/view/68195
  Scenario Outline: Graph |(C68195) If any site has active device sensors, local data should be retrieved from the "Daily API' and graph table should show local data for the "<role>" user.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify devices table is displayed for "<role>" user
    Then identify a device with wind sensor present which is related to a single site
    When once device is picked, navigate to "Graph" page
    Then select a site which is already picked from devices page and select wind as measurement
    And select predefined Date in timeline and click on Graph button
    Then once graph is loaded scroll down to the table & verify the first column name and data shown in the table
    @sanity @Graph @orgAdmin @Scenario61
    Examples:
      | role     | tcId  |
      | orgAdmin | 68195 |
    @sanity @Graph @member @Scenario61
    Examples:
      | role   | tcId  |
      | member | 68195 |
    @sanity @Graph @teamAdmin @Scenario61
    Examples:
      | role      | tcId  |
      | teamAdmin | 68195 |
    @sanity @Graph @orgReader @Scenario61
    Examples:
      | role      | tcId  |
      | orgReader | 68195 |
    @sanity @Graph @sysReader @Scenario61
    Examples:
      | role      | tcId  |
      | sysReader | 68195 |

#    pre-requisite :-
#    If the no sensor device has only one single site then only it works
  # https://arabletestrail.testrail.io/index.php?/cases/view/68196
  Scenario Outline: Graph |(C68196)If any site has no device sensors, remote data should be retrieved from the "Daily API' and graph table should show remote data for the "<role>" user.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify devices table is displayed for "<role>" user
    Then identify a device with no sensor present which is related to a single site
    When once device is picked, navigate to "Graph" page
    Then select a site which is already picked from devices page and select wind as measurement
    And select predefined Date in timeline and click on Graph button
    Then once graph is loaded scroll down to the table & verify the first column name and data shown in the table
    @sanity @Graph @orgAdmin @Scenario62
    Examples:
      | role     | tcId  |
      | orgAdmin | 68196 |
    @sanity @Graph @member @Scenario62
    Examples:
      | role   | tcId  |
      | member | 68196 |
    @sanity @Graph @teamAdmin @Scenario62
    Examples:
      | role      | tcId  |
      | teamAdmin | 68196 |
    @sanity @Graph @orgReader @Scenario62
    Examples:
      | role      | tcId  |
      | orgReader | 68196 |
    @sanity @Graph @sysReader @Scenario62
    Examples:
      | role      | tcId  |
      | sysReader | 68196 |
