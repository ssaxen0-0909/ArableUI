Feature: Site | Plant tab

  Scenario Outline: Plant | Verify canopy modal info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify canopy modal info for "<role>" user.

    @sanity @Plant @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | 63718 |
    @sanity @Plant @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 63718 |
    @sanity @Plant @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | 63718 |
    @sanity @Plant @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | 63718 |
    @sanity @Plant @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | 63718 |

  Scenario Outline: Plant | Verify precipitation modal info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify precipitation modal info for "<role>" user.

    @sanity @Plant @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 63721 |
    @sanity @Plant @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 63721 |
    @sanity @Plant @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 63721 |
    @sanity @Plant @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 63721 |
    @sanity @Plant @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 63721 |


  Scenario Outline: Plant | Verify gdd modal info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify gdd modal info for "<role>" user.

    @sanity @Plant @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 63724 |
    @sanity @Plant @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 63724 |
    @sanity @Plant @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 63724 |
    @sanity @Plant @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 63724 |
    @sanity @Plant @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 63724 |


  Scenario Outline: Plant | Verify ci modal info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify ci modal info for "<role>" user.

    @sanity @Plant @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 63716 |
    @sanity @Plant @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 63716 |
    @sanity @Plant @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 63716 |
    @sanity @Plant @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 63716 |
    @sanity @Plant @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 63716 |


  Scenario Outline: Plant | Verify current day modal info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify current day modal info for "<role>" user.

    @sanity @Plant @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 63727 |
    @sanity @Plant @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 63727 |
    @sanity @Plant @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 63727 |
    @sanity @Plant @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 63727 |
    @sanity @Plant @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 63727 |


  Scenario Outline: Plant | Verify ndvi modal info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify ndvi modal info for "<role>" user.

    @sanity @Plant @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 63717 |
    @sanity @Plant @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 63717 |
    @sanity @Plant @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 63717 |
    @sanity @Plant @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 63717 |
    @sanity @Plant @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 63717 |


  Scenario Outline: Plant | Verify export page navigation modal info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify export page navigation for "<role>" user.

    @sanity @Plant @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 63725 |
    @sanity @Plant @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 63725 |
    @sanity @Plant @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 63725 |
    @sanity @Plant @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 63725 |
    @sanity @Plant @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 63725 |


  Scenario Outline: Plant | Verify graph page navigation modal info for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify graph page navigation for "<role>" user.

    @sanity @Plant @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 63726 |
    @sanity @Plant @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 63726 |
    @sanity @Plant @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 63726 |
    @sanity @Plant @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 63726 |
    @sanity @Plant @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 63726 |


  Scenario Outline: Plant | Verify last seven days Canopy Value for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify last seven days Canopy Value for "<role>" user.

    @sanity @Plant @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 63719 |
    @sanity @Plant @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 63719 |
    @sanity @Plant @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 63719 |
    @sanity @Plant @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 63719 |
    @sanity @Plant @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 63719 |


  Scenario Outline: Plant | Verify last seven days Precip Value for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify last seven days Precip Value for "<role>" user.

    @sanity @Plant @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 63722 |
    @sanity @Plant @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 63722 |
    @sanity @Plant @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 63722 |
    @sanity @Plant @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 63722 |
    @sanity @Plant @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 63722 |


  Scenario Outline: Plant | Verify next seven days canopy Value for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify next seven days canopy Value for "<role>" user.

    @sanity @Plant @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 63720 |
    @sanity @Plant @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 63720 |
    @sanity @Plant @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 63720 |
    @sanity @Plant @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 63720 |
    @sanity @Plant @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 63720 |


  Scenario Outline: Plant | Verify next seven days precip Value for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify next seven days precip Value for "<role>" user.

    @sanity @Plant @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 63723 |
    @sanity @Plant @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 63723 |
    @sanity @Plant @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 63723 |
    @sanity @Plant @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 63723 |
    @sanity @Plant @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 63723 |


  Scenario Outline: Plant | Verify weekly insight value for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify weekly insight value for "<role>" user.

    @sanity @Plant @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 63715 |
    @sanity @Plant @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 63715 |
    @sanity @Plant @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 63715 |
    @sanity @Plant @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 63715 |
    @sanity @Plant @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 63715 |

  Scenario Outline: Plant | Verify GDD graph for No Season for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on plant tab and verify gdd graph for "<siteId>" user.

    @sanity @Plant @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 15109 |
    @sanity @Plant @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 15109 |
    @sanity @Plant @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 15109 |
    @sanity @Plant @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 15109 |
    @sanity @Plant @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 15109 |

  Scenario Outline: Plant | Verify tooltip text in Irrigation Overview table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify tooltip text for "<role>" user.

    @sanity @Plant @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 71998 |
    @sanity @Plant @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 71998 |
    @sanity @Plant @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 71998 |
    @sanity @Plant @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 71998 |
    @sanity @Plant @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 71998 |

  Scenario Outline: Plant | Chlorophyll Index value should match with the api response value for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify cl value shown in UI wrt api response for "<role>" user.

    @sanity @Plant @member @Scenario17
    Examples:
      | role   | tcId |
      | member | 1991 |
    @sanity @Plant @orgAdmin @Scenario17
    Examples:
      | role     | tcId |
      | orgAdmin | 1991 |
    @sanity @Plant @orgReader @Scenario17
    Examples:
      | role      | tcId |
      | orgReader | 1991 |
    @sanity @Plant @sysReader @Scenario17
    Examples:
      | role      | tcId |
      | sysReader | 1991 |
    @sanity @Plant @teamAdmin @Scenario17
    Examples:
      | role      | tcId |
      | teamAdmin | 1991 |

  Scenario Outline: Plant | NDVI value should match with the api response value for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify ndvi value shown in UI wrt api resposne for "<role>" user.

    @sanity @Plant @member @Scenario18
    Examples:
      | role   | tcId |
      | member | 1997 |
    @sanity @Plant @orgAdmin @Scenario18
    Examples:
      | role     | tcId |
      | orgAdmin | 1997 |
    @sanity @Plant @orgReader @Scenario18
    Examples:
      | role      | tcId |
      | orgReader | 1997 |
    @sanity @Plant @sysReader @Scenario18
    Examples:
      | role      | tcId |
      | sysReader | 1997 |
    @sanity @Plant @teamAdmin @Scenario18
    Examples:
      | role      | tcId |
      | teamAdmin | 1997 |

  Scenario Outline: Plant | ETc value should match with the api response value for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify ETc value shown in UI wrt api resposne for "<role>" user.

    @sanity @Plant @member @Scenario19
    Examples:
      | role   | tcId |
      | member | 2262 |
    @sanity @Plant @orgAdmin @Scenario19
    Examples:
      | role     | tcId |
      | orgAdmin | 2262 |
    @sanity @Plant @orgReader @Scenario19
    Examples:
      | role      | tcId |
      | orgReader | 2262 |
    @sanity @Plant @sysReader @Scenario19
    Examples:
      | role      | tcId |
      | sysReader | 2262 |
    @sanity @Plant @teamAdmin @Scenario19
    Examples:
      | role      | tcId |
      | teamAdmin | 2262 |
