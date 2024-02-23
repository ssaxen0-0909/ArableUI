Feature: Devices Page

  Scenario Outline: Devices | verify Devices Sync modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Devices Sync modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | 58944 |
    @sanity @Devices @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 58944 |
    @sanity @Devices @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | 58944 |
    @sanity @Devices @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | 58944 |
    @sanity @Devices @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | 58944 |


  Scenario Outline: Devices | verify Devices Not Sync modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Devices Not Sync modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 58946 |
    @sanity @Devices @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 58946 |
    @sanity @Devices @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 58946 |
    @sanity @Devices @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 58946 |
    @sanity @Devices @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 58946 |


  Scenario Outline: Devices | verify Battery modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Battery modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 58948 |
    @sanity @Devices @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 58948 |
    @sanity @Devices @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 58948 |
    @sanity @Devices @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 58948 |
    @sanity @Devices @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 58948 |


  Scenario Outline: Devices | verify Active modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Active modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 58949 |
    @sanity @Devices @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 58949 |
    @sanity @Devices @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 58949 |
    @sanity @Devices @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 58949 |
    @sanity @Devices @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 58949 |


  Scenario Outline: Devices | verify New modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify New modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 58950 |
    @sanity @Devices @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 58950 |
    @sanity @Devices @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 58950 |
    @sanity @Devices @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 58950 |
    @sanity @Devices @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 58950 |


  Scenario Outline: Devices | verify Inactive modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Inactive modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 58951 |
    @sanity @Devices @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 58951 |
    @sanity @Devices @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 58951 |
    @sanity @Devices @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 58951 |
    @sanity @Devices @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 58951 |


  Scenario Outline: Devices | verify Dormant modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Dormant modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 58952 |
    @sanity @Devices @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 58952 |
    @sanity @Devices @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 58952 |
    @sanity @Devices @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 58952 |
    @sanity @Devices @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 58952 |


  Scenario Outline: Devices | verify Gps modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Gps modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 59159 |
    @sanity @Devices @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 59159 |
    @sanity @Devices @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 59159 |
    @sanity @Devices @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 59159 |
    @sanity @Devices @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 59159 |


  Scenario Outline: Devices | verify Battery Header modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Battery Header modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 58963 |
    @sanity @Devices @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 58963 |
    @sanity @Devices @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 58963 |
    @sanity @Devices @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 58963 |
    @sanity @Devices @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 58963 |


  Scenario Outline: Devices | verify Model modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Model modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 58967 |
    @sanity @Devices @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 58967 |
    @sanity @Devices @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 58967 |
    @sanity @Devices @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 58967 |
    @sanity @Devices @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 58967 |


  Scenario Outline: Devices | verify Last Sync modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Last Sync modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 58965 |
    @sanity @Devices @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 58965 |
    @sanity @Devices @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 58965 |
    @sanity @Devices @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 58965 |
    @sanity @Devices @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 58965 |


  Scenario Outline: Devices | verify Connectivity modals info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Connectivity modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 58964 |
    @sanity @Devices @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 58964 |
    @sanity @Devices @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 58964 |
    @sanity @Devices @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 58964 |
    @sanity @Devices @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 58964 |


  Scenario Outline: Devices | verify Status modal info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Status modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 58966 |
    @sanity @Devices @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 58966 |
    @sanity @Devices @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 58966 |
    @sanity @Devices @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 58966 |
    @sanity @Devices @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 58966 |


  Scenario Outline: Devices | verify Connected Sensors modal info for devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify Connected Sensors modal info is displayed for "<role>" user

    @sanity @Devices @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 58968 |
    @sanity @Devices @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 58968 |
    @sanity @Devices @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 58968 |
    @sanity @Devices @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 58968 |
    @sanity @Devices @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 58968 |


  Scenario Outline: Devices | verify gps coordinates copy feature in devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if gps coordinates are getting copied successfully for "<role>" user

    @sanity @Devices @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 58961 |
    @sanity @Devices @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 58961 |
    @sanity @Devices @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 58961 |
    @sanity @Devices @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 58961 |
    @sanity @Devices @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 58961 |

  Scenario Outline: Devices | verify updating of stats on changing Teams in devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if devices syncing stats are getting updated on changing Teams  for "<role>" user

    @sanity @Devices @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 58942 |
    @sanity @Devices @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 58942 |
    @sanity @Devices @orgReader @Scenario17
    Examples:
      | role      | tcId  |
      | orgReader | 58942 |
    @sanity @Devices @sysReader @Scenario17
    Examples:
      | role      | tcId  |
      | sysReader | 58942 |
    @sanity @Devices @teamAdmin @Scenario17
    Examples:
      | role      | tcId  |
      | teamAdmin | 58942 |


  Scenario Outline: Devices | verify updating of stats on changing org in devices page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if stats are getting updated on changing orgs  for "<role>" user

    @sanity @Devices @member @Scenario18
    Examples:
      | role   | tcId  |
      | member | 58941 |
    @sanity @Devices @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 58941 |
    @sanity @Devices @orgReader @Scenario18
    Examples:
      | role | tcId |
#      | orgReader | 58941 | issues in angular merge
    @sanity @Devices @sysReader @Scenario18
    Examples:
      | role      | tcId  |
      | sysReader | 58941 |


  Scenario Outline: Devices | verify Devices Syncing stats for Active & New devices from table  with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if active & new stats are matching with the count in table for "<role>" user

    @sanity @Devices @member @Scenario19
    Examples:
      | role   | tcId  |
      | member | 58943 |
    @sanity @Devices @orgAdmin @Scenario19
    Examples:
      | role     | tcId  |
      | orgAdmin | 58943 |
    @sanity @Devices @orgReader @Scenario19
    Examples:
      | role      | tcId  |
      | orgReader | 58943 |
    @sanity @Devices @sysReader @Scenario19
    Examples:
      | role      | tcId  |
      | sysReader | 58943 |
    @sanity @Devices @teamAdmin @Scenario19
    Examples:
      | role      | tcId  |
      | teamAdmin | 58943 |


  Scenario Outline: Devices | verify Devices Not Syncing stats for Inactive & Dormant devices from table  with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if inactive & dormant stats are matching with the count in table for "<role>" user

    @sanity @Devices @member @Scenario20
    Examples:
      | role   | tcId  |
      | member | 58945 |
    @sanity @Devices @orgAdmin @Scenario20
    Examples:
      | role     | tcId  |
      | orgAdmin | 58945 |
    @sanity @Devices @orgReader @Scenario20
    Examples:
      | role      | tcId  |
      | orgReader | 58945 |
    @sanity @Devices @sysReader @Scenario20
    Examples:
      | role      | tcId  |
      | sysReader | 58945 |
    @sanity @Devices @teamAdmin @Scenario20
    Examples:
      | role      | tcId  |
      | teamAdmin | 58945 |


  Scenario Outline: Devices | verify battery stats for all battery percentage from table with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if battery stats for all battery percentage from table are matching for "<role>" user

    @sanity @Devices @member @Scenario21
    Examples:
      | role   | tcId  |
      | member | 58947 |
    @sanity @Devices @orgAdmin @Scenario21
    Examples:
      | role     | tcId  |
      | orgAdmin | 58947 |
    @sanity @Devices @orgReader @Scenario21
    Examples:
      | role      | tcId  |
      | orgReader | 58947 |
    @sanity @Devices @sysReader @Scenario21
    Examples:
      | role      | tcId  |
      | sysReader | 58947 |
    @sanity @Devices @teamAdmin @Scenario21
    Examples:
      | role      | tcId  |
      | teamAdmin | 58947 |


  Scenario Outline: Devices | verify last sync for all devices in table with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if last sync equal to or higher than four hrs is shown in red color in table are matching for "<role>" user

    @sanity @Devices @member @Scenario22
    Examples:
      | role   | tcId  |
      | member | 58959 |
    @sanity @Devices @orgAdmin @Scenario22
    Examples:
      | role     | tcId  |
      | orgAdmin | 58959 |
    @sanity @Devices @orgReader @Scenario22
    Examples:
      | role      | tcId  |
      | orgReader | 58959 |
    @sanity @Devices @sysReader @Scenario22
    Examples:
      | role      | tcId  |
      | sysReader | 58959 |
    @sanity @Devices @teamAdmin @Scenario22
    Examples:
      | role      | tcId  |
      | teamAdmin | 58959 |


  Scenario Outline: Devices | verify sorting in device id column with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if sorting in device id column is working for "<role>" user

    @sanity @Devices @member @Scenario23
    Examples:
      | role   | tcId  |
      | member | 58955 |
    @sanity @Devices @orgAdmin @Scenario23
    Examples:
      | role     | tcId  |
      | orgAdmin | 58955 |
    @sanity @Devices @orgReader @Scenario23
    Examples:
      | role      | tcId  |
      | orgReader | 58955 |
    @sanity @Devices @sysReader @Scenario23
    Examples:
      | role      | tcId  |
      | sysReader | 58955 |
    @sanity @Devices @teamAdmin @Scenario23
    Examples:
      | role      | tcId  |
      | teamAdmin | 58955 |


  Scenario Outline: Devices | verify sorting in sites column with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if sorting in sites column is working for "<role>" user

    @sanity @Devices @member @Scenario24
    Examples:
      | role   | tcId  |
      | member | 58954 |
    @sanity @Devices @orgAdmin @Scenario24
    Examples:
      | role     | tcId  |
      | orgAdmin | 58954 |
    @sanity @Devices @orgReader @Scenario24
    Examples:
      | role      | tcId  |
      | orgReader | 58954 |
    @sanity @Devices @sysReader @Scenario24
    Examples:
      | role      | tcId  |
      | sysReader | 58954 |
    @sanity @Devices @teamAdmin @Scenario24
    Examples:
      | role | tcId |
#      | teamAdmin | 58954 | fix required


  Scenario Outline: Devices | verify sorting in battery column with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if sorting in battery column is working for "<role>" user

    @sanity @Devices @member @Scenario25
    Examples:
      | role   | tcId  |
      | member | 58956 |
    @sanity @Devices @orgAdmin @Scenario25
    Examples:
      | role     | tcId  |
      | orgAdmin | 58956 |
    @sanity @Devices @orgReader @Scenario25
    Examples:
      | role      | tcId  |
      | orgReader | 58956 |
    @sanity @Devices @sysReader @Scenario25
    Examples:
      | role      | tcId  |
      | sysReader | 58956 |
    @sanity @Devices @teamAdmin @Scenario25
    Examples:
      | role      | tcId  |
      | teamAdmin | 58956 |


  Scenario Outline: Devices | verify sorting in connectivity column with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if sorting in connectivity column is working for "<role>" user

    @sanity @Devices @member @Scenario26
    Examples:
      | role | tcId |
#      | member    | 58953 | fix required
    @sanity @Devices @orgAdmin @Scenario26
    Examples:
      | role     | tcId  |
      | orgAdmin | 58953 |
    @sanity @Devices @orgReader @Scenario26
    Examples:
      | role      | tcId  |
      | orgReader | 58953 |
    @sanity @Devices @sysReader @Scenario26
    Examples:
      | role      | tcId  |
      | sysReader | 58953 |
    @sanity @Devices @teamAdmin @Scenario26
    Examples:
      | role | tcId |
#      | teamAdmin | 58953 |fix required


  Scenario Outline: Devices | verify sorting in last sync column with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if sorting in last sync column is working for "<role>" user

    @sanity @Devices @member @Scenario27
    Examples:
      | role   | tcId  |
      | member | 58957 |
    @sanity @Devices @orgAdmin @Scenario27
    Examples:
      | role     | tcId  |
      | orgAdmin | 58957 |
    @sanity @Devices @orgReader @Scenario27
    Examples:
      | role      | tcId  |
      | orgReader | 58957 |
    @sanity @Devices @sysReader @Scenario27
    Examples:
      | role      | tcId  |
      | sysReader | 58957 |
    @sanity @Devices @teamAdmin @Scenario27
    Examples:
      | role      | tcId  |
      | teamAdmin | 58957 |


  Scenario Outline: Devices | verify sorting in status column with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify if sorting in status column is working for "<role>" user

    @sanity @Devices @member @Scenario28
    Examples:
      | role | tcId |
#      | member    | 58958 |fix required
    @sanity @Devices @orgAdmin @Scenario28
    Examples:
      | role     | tcId  |
      | orgAdmin | 58958 |
    @sanity @Devices @orgReader @Scenario28
    Examples:
      | role      | tcId  |
      | orgReader | 58958 |
    @sanity @Devices @sysReader @Scenario28
    Examples:
      | role      | tcId  |
      | sysReader | 58958 |
    @sanity @Devices @teamAdmin @Scenario28
    Examples:
      | role | tcId |
#      | teamAdmin | 58958 |fix required


  Scenario Outline: Devices | verify clicking on site name is navigating to weather page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and click on site name and verify if navigation is working for "<role>" user

    @sanity @Devices @member @Scenario29
    Examples:
      | role   | tcId  |
      | member | 58960 |
    @sanity @Devices @orgAdmin @Scenario29
    Examples:
      | role     | tcId  |
      | orgAdmin | 58960 |
    @sanity @Devices @orgReader @Scenario29
    Examples:
      | role      | tcId  |
      | orgReader | 58960 |
    @sanity @Devices @sysReader @Scenario29
    Examples:
      | role      | tcId  |
      | sysReader | 58960 |
    @sanity @Devices @teamAdmin @Scenario29
    Examples:
      | role      | tcId  |
      | teamAdmin | 58960 |


  Scenario Outline: Devices | verify validate sensor with offset values with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and click on validate button and verify offset values and errors for "<role>" user

    @sanity @Devices @member @Scenario30
    Examples:
      | role   | tcId  |
      | member | 58962 |
    @sanity @Devices @orgAdmin @Scenario30
    Examples:
      | role     | tcId  |
      | orgAdmin | 58962 |
    @sanity @Devices @orgReader @Scenario30
    Examples:
      | role      | tcId  |
      | orgReader | 58962 |
    @sanity @Devices @sysReader @Scenario30
    Examples:
      | role      | tcId  |
      | sysReader | 58962 |
    @sanity @Devices @teamAdmin @Scenario30
    Examples:
      | role      | tcId  |
      | teamAdmin | 58962 |


  Scenario Outline: Devices | verify delete sensor with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and click on validate button and verify deleting sensors for "<role>" user

    @sanity @Devices @member @Scenario31
    Examples:
      | role   | tcId  |
      | member | 58969 |
    @sanity @Devices @orgAdmin @Scenario31
    Examples:
      | role     | tcId  |
      | orgAdmin | 58969 |
    @sanity @Devices @orgReader @Scenario31
    Examples:
      | role      | tcId  |
      | orgReader | 58969 |
    @sanity @Devices @sysReader @Scenario31
    Examples:
      | role      | tcId  |
      | sysReader | 58969 |
    @sanity @Devices @teamAdmin @Scenario31
    Examples:
      | role      | tcId  |
      | teamAdmin | 58969 |

  Scenario Outline: If the Last Sync is more than 4 hours in the Last Sync column should show the time in red color "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify the color for not synced devices for "<role>" user

    @sanity @Devices @member @Scenario32
    Examples:
      | role   | tcId  |
      | member | 69662 |
    @sanity @Devices @orgAdmin @Scenario32
    Examples:
      | role     | tcId  |
      | orgAdmin | 69662 |
    @sanity @Devices @orgReader @Scenario32
    Examples:
      | role      | tcId  |
      | orgReader | 69662 |
    @sanity @Devices @sysReader @Scenario32
    Examples:
      | role      | tcId  |
      | sysReader | 69662 |
    @sanity @Devices @teamAdmin @Scenario32
    Examples:
      | role      | tcId  |
      | teamAdmin | 69662 |

  Scenario Outline:If the Last Sync is less than 4 hours in the Last Sync column should show the time in gray color "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify the color for synced devices for "<role>" user

    @sanity @Devices @member @Scenario33
    Examples:
      | role   | tcId  |
      | member | 54197 |
    @sanity @Devices @orgAdmin @Scenario33
    Examples:
      | role     | tcId  |
      | orgAdmin | 54197 |
    @sanity @Devices @orgReader @Scenario33
    Examples:
      | role      | tcId  |
      | orgReader | 54197 |
    @sanity @Devices @sysReader @Scenario33
    Examples:
      | role      | tcId  |
      | sysReader | 54197 |
    @sanity @Devices @teamAdmin @Scenario33
    Examples:
      | role      | tcId  |
      | teamAdmin | 54197 |

  Scenario Outline:If the devices doesn't have reals sensor to configure should show the label "None Found" "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify the no sensor devices for "<role>" user

    @sanity @Devices @member @Scenario34
    Examples:
      | role   | tcId  |
      | member | 54234 |
    @sanity @Devices @orgAdmin @Scenario34
    Examples:
      | role     | tcId  |
      | orgAdmin | 54234 |
    @sanity @Devices @orgReader @Scenario34
    Examples:
      | role      | tcId  |
      | orgReader | 54234 |
    @sanity @Devices @sysReader @Scenario34
    Examples:
      | role      | tcId  |
      | sysReader | 54234 |
    @sanity @Devices @teamAdmin @Scenario34
    Examples:
      | role      | tcId  |
      | teamAdmin | 54234 |

  Scenario Outline:    Device limit should be max 100 per page for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and scroll to bottom and verify options for "<role>" user

    @sanity @Devices @member @Scenario35
    Examples:
      | role   | tcId  |
      | member | 58610 |
    @sanity @Devices @orgAdmin @Scenario35
    Examples:
      | role     | tcId  |
      | orgAdmin | 58610 |
    @sanity @Devices @orgReader @Scenario35
    Examples:
      | role      | tcId  |
      | orgReader | 58610 |
    @sanity @Devices @sysReader @Scenario35
    Examples:
      | role      | tcId  |
      | sysReader | 58610 |
    @sanity @Devices @teamAdmin @Scenario35
    Examples:
      | role      | tcId  |
      | teamAdmin | 58610 |

  Scenario Outline: If a site has device sensors configured, the sensors icon in the connected sensor column should be blue/enabled with a three-dot menu for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and scroll down and verify sensor icon and menu button for "<role>" user

    @sanity @Devices @member @Scenario36
    Examples:
      | role   | tcId  |
      | member | 66053 |
    @sanity @Devices @orgAdmin @Scenario36
    Examples:
      | role     | tcId  |
      | orgAdmin | 66053 |
    @sanity @Devices @orgReader @Scenario36
    Examples:
      | role      | tcId  |
      | orgReader | 66053 |
    @sanity @Devices @sysReader @Scenario36
    Examples:
      | role      | tcId  |
      | sysReader | 66053 |
    @sanity @Devices @teamAdmin @Scenario36
    Examples:
      | role      | tcId  |
      | teamAdmin | 66053 |

  Scenario Outline: If the site has no device sensors configured, the 3 dots option to validate the sensor should not be displayed on the device page for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and scroll down and verify no sensor icon and menu button for "<role>" user

    @sanity @Devices @member @Scenario37
    Examples:
      | role   | tcId  |
      | member | 66054 |
    @sanity @Devices @orgAdmin @Scenario37
    Examples:
      | role     | tcId  |
      | orgAdmin | 66054 |
    @sanity @Devices @orgReader @Scenario37
    Examples:
      | role      | tcId  |
      | orgReader | 66054 |
    @sanity @Devices @sysReader @Scenario37
    Examples:
      | role      | tcId  |
      | sysReader | 66054 |
    @sanity @Devices @teamAdmin @Scenario37
    Examples:
      | role      | tcId  |
      | teamAdmin | 66054 |

  Scenario Outline:    If devices count > 100, then "View More" button should be displayed to load another batch for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and scroll to bottom and verify view more options for "<role>" user

    @sanity @Devices @member @Scenario38
    Examples:
      | role   | tcId  |
      | member | 58611 |
    @sanity @Devices @orgAdmin @Scenario38
    Examples:
      | role     | tcId  |
      | orgAdmin | 58611 |
    @sanity @Devices @orgReader @Scenario38
    Examples:
      | role      | tcId  |
      | orgReader | 58611 |
    @sanity @Devices @sysReader @Scenario38
    Examples:
      | role      | tcId  |
      | sysReader | 58611 |
    @sanity @Devices @teamAdmin @Scenario38
    Examples:
      | role      | tcId  |
      | teamAdmin | 58611 |

  Scenario Outline:    Verify if count in stats is matching with the count of devices in table for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "devices" and verify total devices count in list with battery stats count for "<role>" user

    @sanity @Devices @member @Scenario39
    Examples:
      | role   | tcId  |
      | member | 58611 |
    @sanity @Devices @orgAdmin @Scenario39
    Examples:
      | role     | tcId  |
      | orgAdmin | 58611 |
    @sanity @Devices @orgReader @Scenario39
    Examples:
      | role      | tcId  |
      | orgReader | 58611 |
    @sanity @Devices @sysReader @Scenario39
    Examples:
      | role      | tcId  |
      | sysReader | 58611 |
    @sanity @Devices @teamAdmin @Scenario39
    Examples:
      | role      | tcId  |
      | teamAdmin | 58611 |
