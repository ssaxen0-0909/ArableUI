Feature: Seasons Page

  Scenario Outline: Season | Verify Create new season button for "<role>" user then create a new season in GDD mode
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "seasons" and verify create new season button is displayed for "<role>" user
    Then create a new season for "<role>" user and verify the new season is created

    @sanity @Seasons @member @Scenario1
    Examples:
      | role   | tcId  |
      | member | 63703 |
    @sanity @Seasons @orgAdmin @Scenario1
    Examples:
      | role     | tcId  |
      | orgAdmin | 63703 |
    @sanity @Seasons @orgReader @Scenario1
    Examples:
      | role      | tcId  |
      | orgReader | 63703 |
    @sanity @Seasons @sysReader @Scenario1
    Examples:
      | role      | tcId  |
      | sysReader | 63703 |
    @sanity @Seasons @teamAdmin @Scenario1
    Examples:
      | role      | tcId  |
      | teamAdmin | 63703 |


  Scenario Outline: Season | Verify copy season button for "<role>" user then confirm the copy season button is present in GDD mode
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "seasons" and verify show settings button is displayed for "<role>" user
    Then click on it and verify copy season button for different "<role>" user

    @sanity @Seasons @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | 64272 |
    @sanity @Seasons @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 64272 |
    @sanity @Seasons @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | 64272 |
    @sanity @Seasons @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | 64272 |
    @sanity @Seasons @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | 64272 |


  Scenario Outline: Season | Verify copy season feature for "<role>" user then perform the copy season functionality in GDD mode
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "seasons" and verify show settings button is displayed for "<role>" user
    Then click on it and verify copy season functionality for different "<role>" user

    @sanity @Seasons @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 65282 |
    @sanity @Seasons @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 65282 |
    @sanity @Seasons @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 65282 |
    @sanity @Seasons @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 65282 |
    @sanity @Seasons @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 65282 |


  Scenario Outline: Season | Verify copy season modal contents for "<role>" user then confirm the content is present in GDD mode
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "seasons" and verify show settings button is displayed for "<role>" user
    Then click on it and verify copy season modal contents for different "<role>" user

    @sanity @Seasons @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 65283 |
    @sanity @Seasons @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 65283 |
    @sanity @Seasons @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 65283 |
    @sanity @Seasons @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 65283 |
    @sanity @Seasons @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 65283 |

  Scenario Outline: Season | Verify Add new stage and Delete all stages for "<role>" user then confirm the option is present in GDD mode
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "seasons" and verify show settings button is displayed for "<role>" user
    Then click on it and verify the add and delete growth stages options are present under menu for "<role>" user

    @sanity @Seasons @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 69398 |
    @sanity @Seasons @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 69398 |
    @sanity @Seasons @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 69398 |
    @sanity @Seasons @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 69398 |
    @sanity @Seasons @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 69398 |

  Scenario Outline: Season | Verify Create new season button for "<role>" user then create a new season in Days mode
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "seasons" and verify create new season button is displayed for "<role>" user
    Then create a new season in days mode for "<role>" user and verify the new season is created

    @sanity @Seasons @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 69399 |
    @sanity @Seasons @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 69399 |
    @sanity @Seasons @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 69399 |
    @sanity @Seasons @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 69399 |
    @sanity @Seasons @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 69399 |

  Scenario Outline: Season | Verify add multiple new growth stages for a new season created for "<role>" user in GDD mode
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "seasons" and verify new season is created successfully for "<role>" user
    Then click on Growth stages to verify add new growth stages functionality for different "<role>" user and save the season

    @sanity @Seasons @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 69400 |
    @sanity @Seasons @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 69400 |
    @sanity @Seasons @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 69400 |
    @sanity @Seasons @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 69400 |
    @sanity @Seasons @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 69400 |

  Scenario Outline: Season | Verify edit and delete growth stages for a new season created for "<role>" user in GDD mode
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "seasons" and verify new season is created successfully to edit and delete growth stage for "<role>" user
    Then click on Growth stages to verify edit and delete functionality for different "<role>" user and save the season

    @sanity @Seasons @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 69401 |
    @sanity @Seasons @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 69401 |
    @sanity @Seasons @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 69401 |
    @sanity @Seasons @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 69401 |
    @sanity @Seasons @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 69401 |

  Scenario Outline: Verify if the forecast data from IBM remote sensed is calculated and displayed for the GS for "<role>" user in GDD mode
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "seasons" and verify create new season button is displayed for "<role>" user
    Then expand days mode season and check gdd value from api for different "<role>" user

    @sanity @Seasons @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 69401 |
    @sanity @Seasons @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 69401 |
    @sanity @Seasons @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 69401 |
    @sanity @Seasons @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 69401 |
    @sanity @Seasons @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 69401 |