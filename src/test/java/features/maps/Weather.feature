Feature:Map


  Scenario Outline: Weather | Verify current conditions table and its values for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Account" and get the user measurement units
    And navigate to "Map" page and verify site details
    And call the summary end point and get the current readings then click on site
    Then user is on site weather tab and verify the current conditions table

    @sanity @Map @member @Scenario1
    Examples:
      | role   | tcId  |
      | member | 63718 |
    @sanity @Map @orgAdmin @Scenario1
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 63728 |
#    @sanity @Map @orgReader @Scenario1
    Examples:
      | role      | tcId  |
      | orgReader | 63708 |
    @sanity @Map @sysReader @Scenario1
    Examples:
      | role      | tcId  |
      | sysReader | 63708 |
    @sanity @Map @teamAdmin @Scenario1
    Examples:
      | role      | tcId  |
      | teamAdmin | 63708 |


#  Scenario Outline: Map | Capture page load time for map page with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to "map" page
#    Then verify site name is displayed and update Excel with tme taken sheet for "<role>" user
#
#    @sanity @Performance @Map @member @Scenario2
#    Examples:
#      | role   | tcId  |
#      | member | 63708 |
#    @sanity @Performance @Map @orgAdmin @Scenario2
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 63708 |
#    @sanity @Performance @Map @orgReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | orgReader | 63708 |
#    @sanity @Performance @Map @sysReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | sysReader | 63708 |
#    @sanity @Performance @Map @teamAdmin @Scenario2
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 63708 |


  Scenario Outline: Map | verify switching measurements in map page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify site name is displayed and also verify switching measurements is working for "<role>" user

    @sanity @Map @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 63704 |
    @sanity @Map @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 63704 |
    @sanity @Map @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 63704 |
    @sanity @Map @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 63704 |
    @sanity @Map @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 63704 |


  Scenario Outline: Map | verify unassigned devices in map page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify site name is displayed and also verify unassigned devices for "<role>" user

    @sanity @Map @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 63706 |
    @sanity @Map @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 63706 |
    @sanity @Map @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 63706 |
    @sanity @Map @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 63706 |
#      | teamAdmin | need to fix it


  Scenario Outline: Map | verify minimize and more info in legend of map multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify site name is displayed and also verify minimize and more info in legend of map is working for "<role>" user

    @sanity @Map @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 63707 |
    @sanity @Map @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 63707 |
    @sanity @Map @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 63707 |
    @sanity @Map @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 63707 |
    @sanity @Map @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 63707 |


  Scenario Outline: Map | verify tomorrow forecast tab details for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify site name is displayed and also verify tomorrow forecast tab details for "<role>" user

    @sanity @Map @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 63705 |
    @sanity @Map @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 63705 |
    @sanity @Map @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 63705 |
    @sanity @Map @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 63705 |
    @sanity @Map @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 63705 |


  Scenario Outline: Map | verify map page default view for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify default Satellite view for "<role>" user

    @sanity @Map @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 65020 |
    @sanity @Map @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 65020 |
    @sanity @Map @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 65020 |
    @sanity @Map @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 65020 |
    @sanity @Map @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 65020 |


  Scenario Outline: Map | verify map page default view for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify toggle buttons for different view on map for "<role>" user

    @sanity @Map @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 64264 |
    @sanity @Map @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 64264 |
    @sanity @Map @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 64264 |
    @sanity @Map @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 64264 |
    @sanity @Map @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 64264 |


  Scenario Outline: Map | verify switching between Default to Map view for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify switching toggle button from default to Map view for "<role>" user

    @sanity @Map @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 65021 |
    @sanity @Map @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 65021 |
    @sanity @Map @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 65021 |
    @sanity @Map @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 65021 |
    @sanity @Map @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 65021 |


  Scenario Outline: Map | verify Map Terrain view checkbox for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify switching to Map view and check terrain view for "<role>" user

    @sanity @Map @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 65024 |
    @sanity @Map @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 65024 |
    @sanity @Map @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 65024 |
    @sanity @Map @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 65024 |
    @sanity @Map @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 65024 |


  Scenario Outline: Map | verify Satellite Labels view checkbox for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify Satellite Labels view for "<role>" user

    @sanity @Map @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 65025 |
    @sanity @Map @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 65025 |
    @sanity @Map @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 65025 |
    @sanity @Map @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 65025 |
    @sanity @Map @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 65025 |


  Scenario Outline: Map | verify view on switching pages for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then switch to Map view and verify it after switching pages  for "<role>" user

    @sanity @Map @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 65026 |
    @sanity @Map @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 65026 |
    @sanity @Map @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 65026 |
    @sanity @Map @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 65026 |
    @sanity @Map @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 65026 |


  Scenario Outline: Map | verify terrain view on switching pages for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then switch to Map view and select terrain and verify it again after switching pages  for "<role>" user

    @sanity @Map @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 65027 |
    @sanity @Map @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 65027 |
    @sanity @Map @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 65027 |
    @sanity @Map @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 65027 |
    @sanity @Map @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 65027 |


  Scenario Outline: Map | verify labels view on switching pages for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then select terrain and verify it again after switching pages  for "<role>" user

    @sanity @Map @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 65030 |
    @sanity @Map @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 65030 |
    @sanity @Map @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 65030 |
    @sanity @Map @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 65030 |
    @sanity @Map @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 65030 |


  Scenario Outline: Map | verify warning text in Unassigned devices create new site modal for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then click on Unassigned devices and verify warning text in create site modal for "<role>" user

    @sanity @Map @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 65171 |
    @sanity @Map @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 65171 |


  Scenario Outline: Map | verify Clear Boundary button in Unassigned devices create new site modal for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then click on Unassigned devices and verify Clear Boundary button in create site modal for "<role>" user

    @sanity @Map @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 65172 |
    @sanity @Map @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 65172 |


  Scenario Outline: Map | verify saving site without boundary for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then click on Unassigned devices and click on Clear Boundary button and verify saving site for "<role>" user

    @sanity @Map @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 65173 |
    @sanity @Map @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 65173 |


 # https://arabletestrail.testrail.io/index.php?/cases/view/70078
  Scenario Outline: Map |(C70078) Capture the data shown for sites on the map page and validate it with summary api response for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    And verify the measurement data for tair, sun & precip should match with the data shown on UI for each sites for Temperature, rain & Sun
    Then verify the sites name also in sequence as per the api response
    @sanity @Map @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 70078 |
    @sanity @Map @member @Scenario18
    Examples:
      | role   | tcId  |
      | member | 70078 |
    @sanity @Map @teamAdmin @Scenario18
    Examples:
      | role      | tcId  |
      | teamAdmin | 70078 |
    @sanity @Map @orgReader @Scenario18
    Examples:
      | role      | tcId  |
      | orgReader | 70078 |
    @sanity @Map @sysReader @Scenario18
    Examples:
      | role      | tcId  |
      | sysReader | 70078 |
