Feature: Site | Plant tab

  Scenario Outline: Plant | Cl value % change should match with the api response value change for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify cl value shown in UI wrt api response for "<role>" user.
    And user verify the cl percentage change for last seven days change for "<role>" user.
    @sanity @Plant @member @Scenario1
    Examples:
      | role   | tcId  |
      | member | C73034 |
    @sanity @Plant @orgAdmin @Scenario1
    Examples:
      | role     | tcId  |
      | orgAdmin | C73035 |
    @sanity @Plant @orgReader @Scenario1
    Examples:
      | role      | tcId  |
      | orgReader | C73035 |
    @sanity @Plant @sysReader @Scenario1
    Examples:
      | role      | tcId  |
      | sysReader | C73035 |
    @sanity @Plant @teamAdmin @Scenario1
    Examples:
      | role      | tcId  |
      | teamAdmin | C73035 |



  Scenario Outline: Plant | NDVI value % change should match with the api response value change for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify ndvi value shown in UI wrt api resposne for "<role>" user.
    And user verify the ndvi percentage change for last seven days change for "<role>" user.
    @sanity @Plant @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | C73035 |
    @sanity @Plant @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | C73035 |
    @sanity @Plant @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | C73035 |
    @sanity @Plant @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | C73035 |
    @sanity @Plant @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | C73035 |


  Scenario Outline: Plant | Canopy UI value should match with the api response value for next seven days for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify Canopy Evapotranspiration value shown in UI for "<role>" user.
    Then user is on site plant tab and verify next seven days canopy Value for "<role>" user from UI.
    Then user is on site plant tab and verify next seven days canopy Value for "<role>" user from API.

    @sanity @Plant @member @Scenario3
    Examples:
      | role   | tcId   |
      | member | C73036 |
    @sanity @Plant @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | C73035 |
    @sanity @Plant @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | C73035 |
    @sanity @Plant @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | C73035 |
    @sanity @Plant @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | C73035 |

  Scenario Outline: Plant | Canopy UI value should match with the api response value for past seven days for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify Canopy Evapotranspiration value shown in UI for "<role>" user.
    Then user is on site plant tab and verify past seven days canopy Value for "<role>" user from UI
#    Then user is on site plant tab and verify last seven days Precip Value for "<role>" user..

    Then user is on site plant tab and verify next seven days canopy Value for "<role>" user from UI.
#    Then user is on site plant tab and verify past seven days canopy Value for "<role>" user from API.

    @sanity @Plant @member @Scenario3
    Examples:
      | role   | tcId   |
      | member | C73036 |
    @sanity @Plant @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | C73035 |
    @sanity @Plant @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | C73035 |
    @sanity @Plant @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | C73035 |
    @sanity @Plant @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | C73035 |


  Scenario Outline: Plant | Precipitation value should match with the api response value for next 7 days for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify precipitation value shown in UI for "<role>" user.
    Then user is on site plant tab and verify next seven days precipitation Value for "<role>" user from UI.
    Then user is on site plant tab and verify next seven days precipitation Value for "<role>" user from API.

    @sanity @Plant @member @Scenario4
    Examples:
      | role   | tcId   |
      | member | C73036 |
    @sanity @Plant @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | C73035 |
    @sanity @Plant @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | C73035 |
    @sanity @Plant @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | C73035 |
    @sanity @Plant @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | C73035 |


#  Scenario Outline: Plant | Precipitation value should match with the api response value for past 7 days for "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to "Map" page click on the first site name
#    Then user is on site plant tab and verify last seven days Precip Value for "<role>" user.
#    Then user is on site plant tab and verify past seven days precipitation Value for "<role>" user from API.
#
#    @sanity @Plant @member @Scenario4
#    Examples:
#      | role   | tcId   |
#      | member | C73036 |
#    @sanity @Plant @orgAdmin @Scenario4
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | C73035 |
#    @sanity @Plant @orgReader @Scenario4
#    Examples:
#      | role      | tcId  |
#      | orgReader | C73035 |
#    @sanity @Plant @sysReader @Scenario4
#    Examples:
#      | role      | tcId  |
#      | sysReader | C73035 |
#    @sanity @Plant @teamAdmin @Scenario4
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | C73035 |