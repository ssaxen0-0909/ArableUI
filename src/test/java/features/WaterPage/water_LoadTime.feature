Feature: Water Tab

  Scenario Outline: WaterBalanceGraph | Verify water balance modal text for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water balance modal text different for "<role>" user.

    @sanity @Water @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 63736 |
    @sanity @Water @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 63736 |
    @sanity @Water @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 63736 |
    @sanity @Water @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 63736 |
    @sanity @Water @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 63736 |


  Scenario Outline: WaterBalanceTable | Verify water balance table modal text for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water balance table modal text different for "<role>" user.

    @sanity @Water @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 63733 |
    @sanity @Water @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 63733 |
    @sanity @Water @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 63733 |
    @sanity @Water @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 63733 |
    @sanity @Water @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 63733 |


  Scenario Outline: Water Summary | Verify water summary modal text for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water summary modal text different for "<role>" user.

    @sanity @Water @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 63738 |
    @sanity @Water @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 63738 |
    @sanity @Water @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 63738 |
    @sanity @Water @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 63738 |
    @sanity @Water @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 63738 |


  Scenario Outline: Soil Moisture | Verify Soil Moisture modal text for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Soil Moisture modal text different for "<role>" user.

    @sanity @Water @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 63735 |
    @sanity @Water @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 63735 |
    @sanity @Water @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 63735 |
    @sanity @Water @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 63735 |
    @sanity @Water @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 63735 |


  Scenario Outline: GDD | Verify GDD modal text for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify GDD modal text different for "<role>" user.

    @sanity @Water @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 63734 |
    @sanity @Water @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 63734 |
    @sanity @Water @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 63734 |
    @sanity @Water @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 63734 |
    @sanity @Water @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 63734 |


  Scenario Outline: Page Tables Verification | Verify water page tables for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water page tables for "<role>" user.

    @sanity @Water @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 67779 |
    @sanity @Water @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 67779 |
    @sanity @Water @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 67779 |
    @sanity @Water @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 67779 |
    @sanity @Water @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 67779 |


  Scenario Outline: Manual Irrigation | Verify adding and deleting of entry for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify adding and deleting of entry for "<role>" user.

    @sanity @Water @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 63737 |
    @sanity @Water @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 63737 |
    @sanity @Water @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 63737 |
    @sanity @Water @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 63737 |
    @sanity @Water @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 63737 |

  Scenario Outline: Verify water balance change value wrt api and UI for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water balance change value wrt api and UI for "<role>" user.

    @sanity @Water @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 73050 |
    @sanity @Water @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 73050 |
    @sanity @Water @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 73050 |
    @sanity @Water @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 73050 |
    @sanity @Water @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 73050 |

  Scenario Outline: Verify water summary section value wrt api and UI for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water summary section value wrt api and UI for "<role>" user.

    @sanity @Water @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 73049 |
    @sanity @Water @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 73049 |
    @sanity @Water @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 73049 |
    @sanity @Water @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 73049 |
    @sanity @Water @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 73049 |

  Scenario Outline: Verify water balance forecast section value wrt api and UI for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water balance forecast section  value wrt api and UI for "<role>" user.

    @sanity @Water @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 73051 |
    @sanity @Water @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 73051 |
    @sanity @Water @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 73051 |
    @sanity @Water @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 73051 |
    @sanity @Water @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 73051 |

  Scenario Outline: Verify if Soil Moisture shows "Proximity to Refill Threshold" in Water Summary & soil_moisture value in water balance table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water soil moisture value in summary & balance section wrt api and UI for "<role>" user.

    @sanity @Water @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 73051 |
    @sanity @Water @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 73051 |
    @sanity @Water @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 73051 |
    @sanity @Water @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 73051 |
    @sanity @Water @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 73051 |

  Scenario Outline: Verifying Water Details(Heat Stress) section value wrt api response values for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify Water Details(Heat Stress) section value in summary & details section wrt api and UI for "<role>" user.

    @sanity @Water @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 73051 |
    @sanity @Water @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 73051 |
    @sanity @Water @orgReader @Scenario17
    Examples:
      | role      | tcId  |
      | orgReader | 73051 |
    @sanity @Water @sysReader @Scenario17
    Examples:
      | role      | tcId  |
      | sysReader | 73051 |
    @sanity @Water @teamAdmin @Scenario17
    Examples:
      | role      | tcId  |
      | teamAdmin | 73051 |

  Scenario Outline: Verify if default ETc replacement % is shown in "ETc replacement" modal in Water Balance graph and validate it with api response for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then open ETc replacement modal and verify default data wrt api response for "<role>" user.

    @sanity @Water @member @Scenario18
    Examples:
      | role   | tcId  |
      | member | 73051 |
    @sanity @Water @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 73051 |
    @sanity @Water @orgReader @Scenario18
    Examples:
      | role      | tcId  |
      | orgReader | 73051 |
    @sanity @Water @sysReader @Scenario18
    Examples:
      | role      | tcId  |
      | sysReader | 73051 |
    @sanity @Water @teamAdmin @Scenario18
    Examples:
      | role      | tcId  |
      | teamAdmin | 73051 |