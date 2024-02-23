Feature: Export Page


#  Scenario Outline: Export | Capture page load time for export page with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Export" and verify export dropdown is displayed for "<role>" user
#    Then update Excel sheet for "<role>" user
#
#    @sanity @Performance @Export @member @Scenario1
#    Examples:
#      | role   | tcId  |
#      | member | 60869 |
#    @sanity @Performance @Export @orgAdmin @Scenario1
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60869 |
#    @sanity @Performance @Export @orgReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60869 |
#    @sanity @Performance @Export @sysReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60869 |
#    @sanity @Performance @Export @teamAdmin @Scenario1
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60869 |
#
#
#  Scenario Outline: Export | Capture page load time to download Daily granularity csv with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Export" and verify export dropdown is displayed for "<role>" user
#    Then fill all details and click on export button for "<role>" user
#
#    @sanity @Performance @Export @member @Scenario2
#    Examples:
#      | role   | tcId  |
#      | member | 60866 |
#    @sanity @Performance @Export @orgAdmin @Scenario2
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60866 |
#    @sanity @Performance @Export @orgReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60866 |
#    @sanity @Performance @Export @sysReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60866 |
#    @sanity @Performance @Export @teamAdmin @Scenario2
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60866 |
#
#
#  Scenario Outline: Export | Capture page load time to download Hourly granularity csv with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Export" and verify export dropdown is displayed for "<role>" user
#    Then select Hourly granularity and fill all details and click on export button for "<role>" user
#
#    @sanity @Performance @Export @member @Scenario3
#    Examples:
#      | role   | tcId  |
#      | member | 60867 |
#    @sanity @Performance @Export @orgAdmin @Scenario3
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60867 |
#    @sanity @Performance @Export @orgReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60867 |
#    @sanity @Performance @Export @sysReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60867 |
#    @sanity @Performance @Export @teamAdmin @Scenario3
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60867 |
#
#
#  Scenario Outline: Export | Capture page load time to download all granularity csv with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Export" and verify export dropdown is displayed for "<role>" user
#    Then select all granularity and fill all details and click on export button for "<role>" user
#
#    @sanity @Performance @Export @member @Scenario4
#    Examples:
#      | role   | tcId  |
#      | member | 60868 |
#    @sanity @Performance @Export @orgAdmin @Scenario4
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60868 |
#    @sanity @Performance @Export @orgReader @Scenario4
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60868 |
#    @sanity @Performance @Export @sysReader @Scenario4
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60868 |
#    @sanity @Performance @Export @teamAdmin @Scenario4
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60868 |


    #https://arabletestrail.testrail.io/index.php?/cases/view/68245
  Scenario Outline: Export (68245) | The Export page should have the section with the Units Selectors for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Graph" page select details and click on Graph Button
    Then select a "1" site and measurement and click on all in the date section for "<role>" user
    And click on the export btn
    And verify the units for each params should be selected
    @sanity @Export @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 68245 |
    @sanity @Export @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 68245 |
    @sanity @Export @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 68245 |
    @sanity @Export @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 68245 |
    @sanity @Export @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 68245 |

  #https://arabletestrail.testrail.io/index.php?/cases/view/68246
  Scenario Outline: Export (68246) | The Export page should have the section with the Units Selectors for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Graph" page select details and click on Graph Button
    Then select a "1" site and measurement and click on all in the date section for "<role>" user
    And click on the export btn
    And verify the units for each params should be selected
    And change the selection in Units section
    And navigate to map page
    And click on the graph button
    Then select a "1" site and measurement and click on all in the date section for "<role>" user
    And click on the export btn
    Then navigate back to "Export" page & verify the units
    @sanity @Export @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 68246 |
    @sanity @Export @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 68246 |
    @sanity @Export @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 68246 |
    @sanity @Export @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 68246 |
    @sanity @Export @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 68246 |


  #https://arabletestrail.testrail.io/index.php?/cases/view/68248
  Scenario Outline: Export (68248) | Verify for Site having wind sensor,that on changing from KPH to MPH or to MPS, in daily & local_hourly API call ,the converted unit should be displayed for speed param in Header request , in api response & in downloaded csv for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Graph" page select details and click on Graph Button
    Then select a "1" site and measurement and click on all in the date section for "<role>" user
    And click on the export btn
    And fill in the details on the Export page
    #The speed unit assertion is commented. Once the issue is fixed, we can un-comment these steps.
    And click on the submit btn
    @sanity @Export @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 68248 |
    @sanity @Export @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 68248 |
    @sanity @Export @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 68248 |
    @sanity @Export @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 68248 |
    @sanity @Export @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 68248 |


    #https://arabletestrail.testrail.io/index.php?/cases/view/68247
  Scenario Outline: Export (68247) | In the Hourly CSV should appear the column "local_site_time" and "utc_time" for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Graph" page select details and click on Graph Button
    Then select a "1" site and measurement and click on all in the date section for "<role>" user
    And click on the export btn
    And verify the units for each params should be selected
    And verify the toast message after clicking on download Btn
    And verify the local_site_time and utc_time column present in the csv file
    @sanity @Export @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 68247 |
    @sanity @Export @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 68247 |
    @sanity @Export @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 68247 |
    @sanity @Export @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 68247 |
    @sanity @Export @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 68247 |
