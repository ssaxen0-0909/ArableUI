Feature: Weather tab

#  Scenario Outline: Weather | Verify current conditions table and its values for "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to "Search" page and search the site and click on the site card
#    Then user is on site weather tab and verify the current conditions table and update excel for "<role>" user.
#
#    @sanity @Performance @Weather @member @Scenario1
#    Examples:
#      | role   | tcId  |
#      | member | 60835 |
#    @sanity @Performance @Weather @orgAdmin @Scenario1
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60835 |
#    @sanity @Performance @Weather @orgReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60835 |
#    @sanity @Performance @Weather @sysReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60835 |
#    @sanity @Performance @Weather @member @Scenario1
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60835 |


  Scenario Outline: Weather | Verify weather page site details for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify weather page site details for "<role>" user.

    @sanity @Weather @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | 60834 |
    @sanity @Weather @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 60834 |
    @sanity @Weather @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | 60834 |
    @sanity @Weather @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | 60834 |
    @sanity @Weather @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | 60834 |


  Scenario Outline: Weather | Verify current condition Modal Info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify current condition Modal Info on weather page for "<role>" user.

    @sanity @Weather @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 60836 |
    @sanity @Weather @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 60836 |
    @sanity @Weather @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 60836 |
    @sanity @Weather @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 60836 |
    @sanity @Weather @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 60836 |


  Scenario Outline: Weather | Verify Daily Forecast Modal Info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Daily Forecast Modal Info on weather page for "<role>" user.

    @sanity @Weather @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 60839 |
    @sanity @Weather @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 60839 |
    @sanity @Weather @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 60839 |
    @sanity @Weather @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 60839 |
    @sanity @Weather @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 60839 |


  Scenario Outline: Weather | Verify Wind Speed Hourly Modal Info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Wind Speed Hourly Modal Info on weather page for "<role>" user.

    @sanity @Weather @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 60841 |
    @sanity @Weather @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 60841 |
    @sanity @Weather @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 60841 |
    @sanity @Weather @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 60841 |
    @sanity @Weather @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 60841 |


  Scenario Outline: Weather | Verify Wind Speed Daily Modal Info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Wind Speed Daily Modal Info on weather page for "<role>" user.

    @sanity @Weather @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 60840 |
    @sanity @Weather @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 60840 |
    @sanity @Weather @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 60840 |
    @sanity @Weather @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 60840 |
    @sanity @Weather @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 60840 |


  Scenario Outline: Weather | Verify Prev And Next Arrow in Hourly Forecast Table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Prev And Next Arrow in Temp Hourly Table for "<role>" user.

    @sanity @Weather @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 60842 |
    @sanity @Weather @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 60842 |
    @sanity @Weather @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 60842 |
    @sanity @Weather @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 60842 |
    @sanity @Weather @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 60842 |


  Scenario Outline: Weather | Verify Prev And Next Arrow in Daily forecast Table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Prev And Next Arrow in Daily forecast Table for "<role>" user.

    @sanity @Weather @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 60843 |
    @sanity @Weather @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 60843 |
    @sanity @Weather @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 60843 |
    @sanity @Weather @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 60843 |
    @sanity @Weather @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 60843 |


  Scenario Outline: Weather | Verify Prev And Next Arrow in Wind hourly Table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Prev And Next Arrow in Wind hourly Table for "<role>" user.

    @sanity @Weather @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 60845 |
    @sanity @Weather @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 60845 |
    @sanity @Weather @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 60845 |
    @sanity @Weather @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 60845 |
    @sanity @Weather @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 60845 |


  Scenario Outline: Weather | Verify Prev And Next Arrow in Wind daily Table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Prev And Next Arrow in Wind daily Table for "<role>" user.

    @sanity @Weather @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 60844 |
    @sanity @Weather @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 60844 |
    @sanity @Weather @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 60844 |
    @sanity @Weather @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 60844 |
    @sanity @Weather @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 60844 |


  Scenario Outline: Weather | Verify Export Page Navigation for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Export Page Navigation for "<role>" user.

    @sanity @Weather @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 60838 |
    @sanity @Weather @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 60838 |
    @sanity @Weather @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 60838 |
    @sanity @Weather @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 60838 |
    @sanity @Weather @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 60838 |


  Scenario Outline: Weather | Verify graph Page Navigation for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify graph Page Navigation for "<role>" user.

    @sanity @Weather @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 60837 |
    @sanity @Weather @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 60837 |
    @sanity @Weather @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 60837 |
    @sanity @Weather @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 60837 |
    @sanity @Weather @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 60837 |


  Scenario Outline: Weather | Verify Edit Device Sensor for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Edit Device Sensor for "<role>" user.

    @sanity @Weather @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 60846 |
    @sanity @Weather @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 60846 |
    @sanity @Weather @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 60846 |
    @sanity @Weather @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 60846 |
    @sanity @Weather @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 60846 |