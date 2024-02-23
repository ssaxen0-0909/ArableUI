Feature:Performance

  Scenario Outline: Map-Performance | Capture page load time for map page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    And capture load time for "<role>" user
    @Performance @Map @member @Scenario1
    Examples:
      | role   | tcId  |
      | member | 63708 |
    @Performance @Map @orgAdmin @Scenario1
    Examples:
      | role     | tcId  |
      | orgAdmin | 63708 |
    @Performance @Map @orgReader @Scenario1
    Examples:
      | role      | tcId  |
      | orgReader | 63708 |
    @Performance @Map @sysReader @Scenario1
    Examples:
      | role      | tcId  |
      | sysReader | 63708 |
    @Performance @Map @teamAdmin @Scenario1
    Examples:
      | role      | tcId  |
      | teamAdmin | 63708 |

  Scenario Outline: Map-Performance | verify switching measurement to gdd in map page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify site name is displayed and also capture load time after switching measurement to gdd for "<role>" user

    @Map @member @Scenario2 @Performance
    Examples:
      | role   | tcId  |
      | member | 63704 |
    @Performance @orgAdmin @Scenario2 @Map
    Examples:
      | role     | tcId  |
      | orgAdmin | 63704 |
    @Map @orgReader @Scenario2 @Performance
    Examples:
      | role      | tcId  |
      | orgReader | 63704 |
    @Map @sysReader @Scenario2 @Performance
    Examples:
      | role      | tcId  |
      | sysReader | 63704 |
    @Map @teamAdmin @Scenario2 @Performance
    Examples:
      | role      | tcId  |
      | teamAdmin | 63704 |

  Scenario Outline: Map-Performance | capture response time on switching to specific team in map page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify site name is displayed and also capture load time after switching to specific team for "<role>" user

    @Map @member @Scenario3 @Performance
    Examples:
      | role   | tcId  |
      | member | 63704 |
    @Performance @orgAdmin @Scenario3 @Map
    Examples:
      | role     | tcId  |
      | orgAdmin | 63704 |
    @Map @orgReader @Scenario3 @Performance
    Examples:
      | role      | tcId  |
      | orgReader | 63704 |
    @Map @sysReader @Scenario3 @Performance
    Examples:
      | role      | tcId  |
      | sysReader | 63704 |
    @Map @teamAdmin @Scenario3 @Performance
    Examples:
      | role      | tcId  |
      | teamAdmin | 63704 |

  Scenario Outline: Map-Performance | capture response time on switching to specific team's gdd in map page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    Then verify site name is displayed and also capture response time on switching to specific team's gdd for "<role>" user

    @Map @member @Scenario4 @Performance
    Examples:
      | role   | tcId  |
      | member | 63704 |
    @Performance @orgAdmin @Scenario4 @Map
    Examples:
      | role     | tcId  |
      | orgAdmin | 63704 |
    @Map @orgReader @Scenario4 @Performance
    Examples:
      | role      | tcId  |
      | orgReader | 63704 |
    @Map @sysReader @Scenario4 @Performance
    Examples:
      | role      | tcId  |
      | sysReader | 63704 |
    @Map @teamAdmin @Scenario4 @Performance
    Examples:
      | role      | tcId  |
      | teamAdmin | 63704 |

  Scenario Outline: Teams | Capture page load time for teams page with multiple "<role>" user
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify teams name are displayed and also update page load time in Excel for "<role>" user

    @Performance @Teams @member @Scenario5
    Examples:
      | role   |
      | member |
    @Performance @Teams @orgAdmin @Scenario5
    Examples:
      | role     |
      | orgAdmin |
    @Performance @Teams @orgReader @Scenario5
    Examples:
      | role      |
      | orgReader |
    @Performance @Teams @sysReader @Scenario5
    Examples:
      | role      |
      | sysReader |
    @Performance @Teams @teamAdmin @Scenario5
    Examples:
      | role      |
      | teamAdmin |

  Scenario Outline: Teams | Capture page load time for create new teams modal with multiple "<role>" user
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on Create New Team button and capture load time in Excel for "<role>" user

    @Performance @Teams @member @Scenario6
    Examples:
      | role   |
      | member |
    @Performance @Teams @orgAdmin @Scenario6
    Examples:
      | role     |
      | orgAdmin |
    @Performance @Teams @orgReader @Scenario6
    Examples:
      | role      |
      | orgReader |
    @Performance @Teams @sysReader @Scenario6
    Examples:
      | role      |
      | sysReader |
    @Performance @Teams @teamAdmin @Scenario6
    Examples:
      | role      |
      | teamAdmin |

  Scenario Outline: Teams | Capture page load time for view team modal with multiple "<role>" user
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then scroll down to specific team click on view teams and capture load time in Excel for "<role>" user

    @Performance @Teams @member @Scenario7
    Examples:
      | role   |
      | member |
    @Performance @Teams @orgAdmin @Scenario7
    Examples:
      | role     |
      | orgAdmin |
    @Performance @Teams @orgReader @Scenario7
    Examples:
      | role      |
      | orgReader |
    @Performance @Teams @sysReader @Scenario7
    Examples:
      | role      |
      | sysReader |
    @Performance @Teams @teamAdmin @Scenario7
    Examples:
      | role      |
      | teamAdmin |

  Scenario Outline: Sites | Capture page load time for sites page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify site card is displayed and update load time in Excel sheet for "<role>" user

    @Performance @Sites @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 60822 |
    @Performance @Sites @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 60822 |
    @Performance @Sites @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 60822 |
    @Performance @Sites @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 60822 |
    @Performance @Sites @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 60822 |

  Scenario Outline: Sites | verify and capture page load time for edit site with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify edit site and update load time in Excel sheet for "<role>" user

    @Performance @Sites @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 60823 |
    @Performance @Sites @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 60823 |
    @Performance @Sites @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 60823 |
    @Performance @Sites @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 60823 |
    @Performance @Sites @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 60823 |

  Scenario Outline: Sites | verify and capture page load time to load specific team with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then capture page load time to load specific team and update in Excel sheet for "<role>" user

    @Performance @Sites @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 60823 |
    @Performance @Sites @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 60823 |
    @Performance @Sites @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 60823 |
    @Performance @Sites @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 60823 |
    @Performance @Sites @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 60823 |

  Scenario Outline: Sites | verify and capture load time for search Sites with Team filter with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then switch team and search for a specific site for "<role>" user

    @Performance @Sites @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 60823 |
    @Performance @Sites @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 60823 |
    @Performance @Sites @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 60823 |
    @Performance @Sites @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 60823 |
    @Performance @Sites @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 60823 |

  Scenario Outline: Sites | verify and capture load time for search Sites all teams with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then search for a specific site and capture load time for "<role>" user

    @Performance @Sites @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 60823 |
    @Performance @Sites @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 60823 |
    @Performance @Sites @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 60823 |
    @Performance @Sites @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 60823 |
    @Performance @Sites @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 60823 |

  Scenario Outline: Multisite | Capture page load time for multisite water page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Multisite water" page.
    Then capture load time and update Excel sheet for "<role>" user

    @Performance @MultisiteWater @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 60823 |
    @Performance @MultisiteWater @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 60823 |
    @Performance @MultisiteWater @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 60823 |
    @Performance @MultisiteWater @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 60823 |
    @Performance @MultisiteWater @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 60823 |

  Scenario Outline: Multisite Water | verify and capture load time for specific team in  multisite water page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Multisite water" page.
    Then switch to specific team and capture load time for "<role>" user

    @Performance @MultisiteWater @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 60823 |
    @Performance @MultisiteWater @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 60823 |
    @Performance @MultisiteWater @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 60823 |
    @Performance @MultisiteWater @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 60823 |
    @Performance @MultisiteWater @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 60823 |

  Scenario Outline: Graph | Capture page load time for graph page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then update page load time in Excel sheet for "<role>" user

    @Performance @Graph @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 60940 |
    @Performance @Graph @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 60940 |
    @Performance @Graph @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 60940 |
    @Performance @Graph @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 60940 |
    @Performance @Graph @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 60940 |


  Scenario Outline: Graph | Capture page load time for graph-daily with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Graph" and verify site names are displayed for "<role>" user
    Then select details and click on Graph Button and verify it with different "<role>".

    @Performance @Graph @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 60938 |
    @Performance @Graph @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 60938 |
    @Performance @Graph @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 60938 |
    @Performance @Graph @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 60938 |
    @Performance @Graph @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 60938 |


  Scenario Outline: Graph | Capture page load time for graph-hourly with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Graph" page select details and click on Graph Button
    Then switch to hourly and verify it with different "<role>".

    @Performance @Graph @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 60939 |
    @Performance @Graph @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 60939 |
    @Performance @Graph @orgReader @Scenario17
    Examples:
      | role      | tcId  |
      | orgReader | 60939 |
    @Performance @Graph @sysReader @Scenario17
    Examples:
      | role      | tcId  |
      | sysReader | 60939 |
    @Performance @Graph @teamAdmin @Scenario17
    Examples:
      | role      | tcId  |
      | teamAdmin | 60939 |

  Scenario Outline: Graph | Capture graph page load time for gdd measurement with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Graph" page select details and click on Graph Button
    Then select details with gdd as measurement and click on Graph Button for different "<role>".

    @Performance @Graph @member @Scenario18
    Examples:
      | role   | tcId  |
      | member | 60939 |
    @Performance @Graph @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 60939 |
    @Performance @Graph @orgReader @Scenario18
    Examples:
      | role      | tcId  |
      | orgReader | 60939 |
    @Performance @Graph @sysReader @Scenario18
    Examples:
      | role      | tcId  |
      | sysReader | 60939 |
    @Performance @Graph @teamAdmin @Scenario18
    Examples:
      | role      | tcId  |
      | teamAdmin | 60939 |


  Scenario Outline: Export | Capture page load time for export page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Export" and verify export dropdown is displayed for "<role>" user
    Then update Excel sheet for "<role>" user

    @Performance @Export @member @Scenario19
    Examples:
      | role   | tcId  |
      | member | 60869 |
    @Performance @Export @orgAdmin @Scenario19
    Examples:
      | role     | tcId  |
      | orgAdmin | 60869 |
    @Performance @Export @orgReader @Scenario19
    Examples:
      | role      | tcId  |
      | orgReader | 60869 |
    @Performance @Export @sysReader @Scenario19
    Examples:
      | role      | tcId  |
      | sysReader | 60869 |
    @Performance @Export @teamAdmin @Scenario19
    Examples:
      | role      | tcId  |
      | teamAdmin | 60869 |


  Scenario Outline: Export | Capture page load time to download Daily granularity csv with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Export" and verify export dropdown is displayed for "<role>" user
    Then fill all details and click on export button for "<role>" user

    @Performance @Export @member @Scenario20
    Examples:
      | role   | tcId  |
      | member | 60866 |
    @Performance @Export @orgAdmin @Scenario20
    Examples:
      | role     | tcId  |
      | orgAdmin | 60866 |
    @Performance @Export @orgReader @Scenario20
    Examples:
      | role      | tcId  |
      | orgReader | 60866 |
    @Performance @Export @sysReader @Scenario20
    Examples:
      | role      | tcId  |
      | sysReader | 60866 |
    @Performance @Export @teamAdmin @Scenario20
    Examples:
      | role      | tcId  |
      | teamAdmin | 60866 |


  Scenario Outline: Export | Capture page load time to download Hourly granularity csv with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Export" and verify export dropdown is displayed for "<role>" user
    Then select Hourly granularity and fill all details and click on export button for "<role>" user

    @Performance @Export @member @Scenario21
    Examples:
      | role   | tcId  |
      | member | 60867 |
    @Performance @Export @orgAdmin @Scenario21
    Examples:
      | role     | tcId  |
      | orgAdmin | 60867 |
    @Performance @Export @orgReader @Scenario21
    Examples:
      | role      | tcId  |
      | orgReader | 60867 |
    @Performance @Export @sysReader @Scenario21
    Examples:
      | role      | tcId  |
      | sysReader | 60867 |
    @Performance @Export @teamAdmin @Scenario21
    Examples:
      | role      | tcId  |
      | teamAdmin | 60867 |


  Scenario Outline: Export No Sentek | Capture page load time to download all granularity csv with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Export" and verify export dropdown is displayed for "<role>" user
    Then select no sentek site for all granularity and click on export button for "<role>" user

    @Performance @Export @member @Scenario22
    Examples:
      | role   | tcId  |
      | member | 60868 |
    @Performance @Export @orgAdmin @Scenario22
    Examples:
      | role     | tcId  |
      | orgAdmin | 60868 |
    @Performance @Export @orgReader @Scenario22
    Examples:
      | role      | tcId  |
      | orgReader | 60868 |
    @Performance @Export @sysReader @Scenario22
    Examples:
      | role      | tcId  |
      | sysReader | 60868 |
    @Performance @Export @teamAdmin @Scenario22
    Examples:
      | role      | tcId  |
      | teamAdmin | 60868 |

  Scenario Outline: Export Sentek | Capture page load time to download all granularity csv with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Export" and verify export dropdown is displayed for "<role>" user
    Then select sentek site for all granularity and click on export button for "<role>" user

    @Performance @Export @member @Scenario23
    Examples:
      | role   | tcId  |
      | member | 60868 |
    @Performance @Export @orgAdmin @Scenario23
    Examples:
      | role     | tcId  |
      | orgAdmin | 60868 |
    @Performance @Export @orgReader @Scenario23
    Examples:
      | role      | tcId  |
      | orgReader | 60868 |
    @Performance @Export @sysReader @Scenario23
    Examples:
      | role      | tcId  |
      | sysReader | 60868 |
    @Performance @Export @teamAdmin @Scenario23
    Examples:
      | role      | tcId  |
      | teamAdmin | 60868 |

  Scenario Outline: Account | verify generating,copying & refreshing API key with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    When navigate to Settings and then to "Account" page
    Then verify generating,copying & refreshing for "<role>" user

    @Performance @Account @member @Scenario24
    Examples:
      | role   | tcId  |
      | member | 63208 |

    @Performance @Account @orgAdmin @Scenario24
    Examples:
      | role     | tcId  |
      | orgAdmin | 63208 |
    @Performance @Account @orgReader @Scenario24
    Examples:
      | role      | tcId  |
      | orgReader | 63208 |
    @Performance @Account @sysReader @Scenario24
    Examples:
      | role      | tcId  |
      | sysReader | 63208 |
    @Performance @Account @teamAdmin @Scenario24
    Examples:
      | role      | tcId  |
      | teamAdmin | 63208 |

  Scenario Outline: Alerts | Capture page load for alerts page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Alerts" and verify table is displayed
    Then update Excel sheet for "<role>" user the time taken to load the page

    @Performance @Alerts @member @Scenario25
    Examples:
      | role   | tcId  |
      | member | 67612 |
    @Performance @Alerts @orgAdmin @Scenario25
    Examples:
      | role     | tcId  |
      | orgAdmin | 67612 |
    @Performance @Alerts @orgReader @Scenario25
    Examples:
      | role      | tcId  |
      | orgReader | 67612 |
    @Performance @Alerts @sysReader @Scenario25
    Examples:
      | role      | tcId  |
      | sysReader | 67612 |
    @Performance @Alerts @teamAdmin @Scenario25
    Examples:
      | role      | tcId  |
      | teamAdmin | 67612 |

  Scenario Outline: Alert Settings | Capture page load for alert settings page with multiple "<role>" user
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings" and verify alert settings is displayed for "<role>" user
    Then update Excel columns for "<role>" user

    @Performance @AlertSettings @member @Scenario26
    Examples:
      | role   |
      | member |
    @Performance @AlertSettings @orgAdmin @Scenario26
    Examples:
      | role     |
      | orgAdmin |
    @Performance @AlertSettings @orgReader @Scenario26
    Examples:
      | role      |
      | orgReader |
    @Performance @AlertSettings @sysReader @Scenario26
    Examples:
      | role      |
      | sysReader |
    @Performance @AlertSettings @teamAdmin @Scenario26
    Examples:
      | role      |
      | teamAdmin |

  Scenario Outline: Devices | Capture page load for devices page with multiple "<role>" user
    Given log into application with a "<role>" user
    When navigate to "devices" and verify devices table is displayed for "<role>" user
    Then update Excel for "<role>" user the time taken to load the page

    @Performance @Devices @member @Scenario27
    Examples:
      | role   |
      | member |
    @Performance @Devices @orgAdmin @Scenario27
    Examples:
      | role     |
      | orgAdmin |
    @Performance @Devices @orgReader @Scenario27
    Examples:
      | role      |
      | orgReader |
    @Performance @Devices @sysReader @Scenario27
    Examples:
      | role      |
      | sysReader |
    @Performance @Devices @teamAdmin @Scenario27
    Examples:
      | role      |
      | teamAdmin |

  Scenario Outline: Vision | Verify vision page response time for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify page response time for "<role>" user.

    @Performance @ImageGallery @member @Scenario28
    Examples:
      | role   | tcId  |
      | member | 66256 |
    @Performance @ImageGallery @orgAdmin @Scenario28
    Examples:
      | role     | tcId  |
      | orgAdmin | 66256 |
    @Performance @Vision @orgReader @Scenario28
    Examples:
      | role      | tcId  |
      | orgReader | 66256 |
    @Performance @Vision @sysReader @Scenario28
    Examples:
      | role      | tcId  |
      | sysReader | 66256 |
    @Performance @Vision @teamAdmin @Scenario28
    Examples:
      | role      | tcId  |
      | teamAdmin | 66256 |

#  Scenario Outline: Notes | Verify notes tab & box for "<role>" user
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then user is on site notes tab and verify the notes box and update excel for "<role>" user.
#
#    @Performance @Notes @member @Scenario29
#    Examples:
#      | role   |
#      | member |
#    @Performance @Notes @orgAdmin @Scenario29
#    Examples:
#      | role     |
#      | orgAdmin |
#    @Performance @Notes @orgReader @Scenario29
#    Examples:
#      | role      |
#      | orgReader |
#    @Performance @Notes @teamAdmin @Scenario29
#    Examples:
#      | role      |
#      | teamAdmin |
#    @Performance @Notes @sysReader @Scenario29
#    Examples:
#      | role      |
#      | sysReader |

  Scenario Outline: Plant | Verify irrigation overview table and its values for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Map" page click on the first site name
    Then user is on site plant tab and verify the irrigation table and update excel for "<role>" user.

    @Performance @Plant @member @Scenario30
    Examples:
      | role   | tcId  |
      | member | 63714 |
    @Performance @Plant @orgAdmin @Scenario30
    Examples:
      | role     | tcId  |
      | orgAdmin | 63714 |
    @Performance @Plant @orgReader @Scenario30
    Examples:
      | role      | tcId  |
      | orgReader | 63714 |
    @Performance @Plant @sysReader @Scenario30
    Examples:
      | role      | tcId  |
      | sysReader | 63714 |
    @Performance @Plant @teamAdmin @Scenario30
    Examples:
      | role      | tcId  |
      | teamAdmin | 63714 |

#  Scenario Outline: Rank | Capture page load time for rank page with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Rank" and verify table is displayed
#    Then update page load time in Excel sheet for Rank row for "<role>" user
#
#    @Performance @Rank @member @Scenario31
#    Examples:
#      | role   | tcId  |
#      | member | 60815 |
#    @Performance @Rank @orgAdmin @Scenario31
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60815 |
#    @Performance @Rank @orgReader @Scenario31
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60815 |
#    @Performance @Rank @sysReader @Scenario31
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60815 |
#    @Performance @Rank @teamAdmin @Scenario31
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60815 |

  Scenario Outline: Search | Capture page load time for search module with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then clicked on search icon and navigate to "Search" page
    And verify search bar is displayed for "<role>" user

    @Performance @Search @member @Scenario32
    Examples:
      | role   | tcId  |
      | member | 59149 |
    @Performance @Search @orgAdmin @Scenario32
    Examples:
      | role     | tcId  |
      | orgAdmin | 59149 |
    @Performance @Search @orgReader @Scenario32
    Examples:
      | role      | tcId  |
      | orgReader | 59149 |
    @Performance @Search @sysReader @Scenario32
    Examples:
      | role      | tcId  |
      | sysReader | 59149 |
    @Performance @Search @teamAdmin @Scenario32
    Examples:
      | role      | tcId  |
      | teamAdmin | 59149 |

  Scenario Outline: Season | Capture page load for season page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Seasons" and verify season table is displayed for "<role>" user
    Then write in Excel for "<role>" user the time taken to load the page

    @Performance @Seasons @member @Scenario33
    Examples:
      | role   | tcId  |
      | member | 63699 |
    @Performance @Seasons @orgAdmin @Scenario33
    Examples:
      | role     | tcId  |
      | orgAdmin | 63702 |
    @Performance @Seasons @orgReader @Scenario33
    Examples:
      | role      | tcId  |
      | orgReader | 63698 |
    @Performance @Seasons @sysReader @Scenario33
    Examples:
      | role      | tcId  |
      | sysReader | 63698 |
    @Performance @Seasons @member @Scenario33
    Examples:
      | role      | tcId  |
      | teamAdmin | 63700 |

  Scenario Outline: Water | Verify water summary table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then user is on site water tab and verify the water summary table and update excel for "<role>" user.

    @Performance @Water @member @Scenario34
    Examples:
      | role   | tcId  |
      | member | 63728 |
    @Performance @Water @orgAdmin @Scenario34
    Examples:
      | role     | tcId  |
      | orgAdmin | 63728 |
    @Performance @Water @orgReader @Scenario34
    Examples:
      | role      | tcId  |
      | orgReader | 63728 |
    @Performance @Water @sysReader @Scenario34
    Examples:
      | role      | tcId  |
      | sysReader | 63728 |
    @Performance @Water @teamAdmin @Scenario34
    Examples:
      | role      | tcId  |
      | teamAdmin | 63728 |


  Scenario Outline: WaterBalance_Day | Verify water balance day table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water summary table, switch water balance to day and update excel for load time of different "<role>" user.

    @Performance @Water @member @Scenario35
    Examples:
      | role   | tcId  |
      | member | 63729 |
    @Performance @Water @orgAdmin @Scenario35
    Examples:
      | role     | tcId  |
      | orgAdmin | 63729 |
    @Performance @Water @orgReader @Scenario35
    Examples:
      | role      | tcId  |
      | orgReader | 63729 |
    @Performance @Water @sysReader @Scenario35
    Examples:
      | role      | tcId  |
      | sysReader | 63729 |
    @Performance @Water @teamAdmin @Scenario35
    Examples:
      | role      | tcId  |
      | teamAdmin | 63729 |


  Scenario Outline: WaterBalance_Month | Verify water balance month table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water summary table, switch water balance to month and update excel for load time of different "<role>" user.

    @Performance @Water @member @Scenario36
    Examples:
      | role   | tcId  |
      | member | 63731 |
    @Performance @Water @orgAdmin @Scenario36
    Examples:
      | role     | tcId  |
      | orgAdmin | 63731 |
    @Performance @Water @orgReader @Scenario36
    Examples:
      | role      | tcId  |
      | orgReader | 63731 |
    @Performance @Water @sysReader @Scenario36
    Examples:
      | role      | tcId  |
      | sysReader | 63731 |
    @Performance @Water @teamAdmin @Scenario36
    Examples:
      | role      | tcId  |
      | teamAdmin | 63731 |


  Scenario Outline: WaterBalance_Week | Verify water balance week table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water summary table, switch water balance to week and update excel for load time of different "<role>" user.

    @Performance @Water @member @Scenario37
    Examples:
      | role   | tcId  |
      | member | 63730 |
    @Performance @Water @orgAdmin @Scenario37
    Examples:
      | role     | tcId  |
      | orgAdmin | 63730 |
    @Performance @Water @orgReader @Scenario37
    Examples:
      | role      | tcId  |
      | orgReader | 63730 |
    @Performance @Water @sysReader @Scenario37
    Examples:
      | role      | tcId  |
      | sysReader | 63730 |
    @Performance @Water @teamAdmin @Scenario37
    Examples:
      | role      | tcId  |
      | teamAdmin | 63730 |


  Scenario Outline: WaterBalance_GDD | Verify water balance gdd table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When on "map" page click the site and go to site detail page
    Then verify water summary table, switch water balance to gdd and update excel for load time of different "<role>" user.

    @Performance @Water @member @Scenario38
    Examples:
      | role   | tcId  |
      | member | 63732 |
    @Performance @Water @orgAdmin @Scenario38
    Examples:
      | role     | tcId  |
      | orgAdmin | 63732 |
    @Performance @Water @orgReader @Scenario38
    Examples:
      | role      | tcId  |
      | orgReader | 63732 |
    @Performance @Water @sysReader @Scenario38
    Examples:
      | role      | tcId  |
      | sysReader | 63732 |
    @Performance @Water @teamAdmin @Scenario38
    Examples:
      | role      | tcId  |
      | teamAdmin | 63732 |

  Scenario Outline: Weather | Verify current conditions table and its values for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Search" page and search the site and click on the site card
    Then user is on site weather tab and verify the current conditions table and update excel for "<role>" user.

    @Performance @Weather @member @Scenario39
    Examples:
      | role   | tcId  |
      | member | 60835 |
    @Performance @Weather @orgAdmin @Scenario39
    Examples:
      | role     | tcId  |
      | orgAdmin | 60835 |
    @Performance @Weather @orgReader @Scenario39
    Examples:
      | role      | tcId  |
      | orgReader | 60835 |
    @Performance @Weather @sysReader @Scenario39
    Examples:
      | role      | tcId  |
      | sysReader | 60835 |
    @Performance @Weather @member @Scenario39
    Examples:
      | role      | tcId  |
      | teamAdmin | 60835 |