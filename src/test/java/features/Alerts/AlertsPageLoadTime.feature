Feature: Alerts Page

#  Scenario Outline: Alerts | Capture page load for alerts page with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to "Alerts" and verify table is displayed
#    Then update Excel sheet for "<role>" user the time taken to load the page
#
#    @sanity @Performance @Alerts @member @Scenario1
#    Examples:
#      | role   | tcId  |
#      | member | 67612 |
#    @sanity @Performance @Alerts @orgAdmin @Scenario1
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 67612 |
#    @sanity @Performance @Alerts @orgReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | orgReader | 67612 |
#    @sanity @Performance @Alerts @sysReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | sysReader | 67612 |
#    @sanity @Performance @Alerts @teamAdmin @Scenario1
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 67612 |


  Scenario Outline: Alerts | verify count of alerts activity with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Alerts" and verify the count by clicking on view more button for "<role>" user

    @sanity @Alerts @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | 59101 |
    @sanity @Alerts @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 59101 |
    @sanity @Alerts @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | 59101 |
    @sanity @Alerts @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | 59101 |
    @sanity @Alerts @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | 59101 |

  Scenario Outline: Alerts | verify filter options for alerts activity page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Alerts" and verify the filter options by clicking on dropdown button for "<role>" user

    @sanity @Alerts @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 59102 |
    @sanity @Alerts @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 59102 |
    @sanity @Alerts @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 59102 |
    @sanity @Alerts @sysReader @Scenario3
    Examples:
      | role | tcId |
#      | sysReader | 59102 |
    @sanity @Alerts @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 59102 |


  Scenario Outline: Alerts | verify alerts activity is changing on switching orgs page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Alerts" and switch the org and verify activity for "<role>" user

    @sanity @Alerts @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 59100 |
    @sanity @Alerts @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 59100 |
    @sanity @Alerts @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 59100 |
    @sanity @Alerts @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 59100 |


  Scenario Outline: Alerts | verify alerts activity details with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Alerts" and verify activity details are shown for "<role>" user

    @sanity @Alerts @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 59104 |
    @sanity @Alerts @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 59104 |
    @sanity @Alerts @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 59104 |
    @sanity @Alerts @sysReader @Scenario5
    Examples:
      | role | tcId |
#      | sysReader | 59104 |
    @sanity @Alerts @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 59104 |


  Scenario Outline: Alerts | verify default filter is Date with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Alerts" and verify default filter Date is shown for "<role>" user

    @sanity @Alerts @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 59103 |
    @sanity @Alerts @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 59103 |
    @sanity @Alerts @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 59103 |
    @sanity @Alerts @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 59103 |
    @sanity @Alerts @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 59103 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68394
  Scenario Outline: Alerts |(C68394) User should be able to Mark all the Alerts as Read by ORG for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to "Alerts" page for "<role>" user
    And click on three dots on the top right side
    Then open Network calls for user "<role>" & click on "Mark all as read" option & observe
    @sanity @Alerts @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 68394 |
    @sanity @Alerts @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 68394 |
    @sanity @Alerts @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 68394 |
    @sanity @Alerts @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 68394 |
    @sanity @Alerts @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 68394 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68395
  Scenario Outline: Alerts |(C68395) User should be able to Mark all the Alerts as Read by TEAM for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to "Alerts" page for "<role>" user
    Then switch to a specific team which has unread alerts
    And click on three dots on the top right side
    Then open Network calls for user "<role>" & click on "Mark all as read" option & observe
    @sanity @Alerts @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 68395 |
    @sanity @Alerts @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 68395 |
    @sanity @Alerts @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 68395 |
    @sanity @Alerts @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 68395 |
    @sanity @Alerts @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 68395 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68396
  Scenario Outline: Alerts |(C68396) Stag- On changing orgs from global dropdown, the alerts activity should also get changed accordingly for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to "Alerts" page for "<role>" user
    Then change the organization, and check the alerts activity should also get changed accordingly
    @sanity @Alerts @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 68396 |
    @sanity @Alerts @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 68396 |
    @sanity @Alerts @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 68396 |
    @sanity @Alerts @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 68396 |
    @sanity @Alerts @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 68396 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68397
  Scenario Outline: Alerts |(C68397) Stag- Verify If alerts badge count is greater than 15, then View More button should be displayed and the badge should have + in the count for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to "Alerts" page for "<role>" user
    And if Alerts count are more than 15
    Then scroll down to the bottom & verify if View More Activity button should be present.
    @sanity @Alerts @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 68397 |
    @sanity @Alerts @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 68397 |
    @sanity @Alerts @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 68397 |
    @sanity @Alerts @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 68397 |
    @sanity @Alerts @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 68397 |


    # https://arabletestrail.testrail.io/index.php?/cases/view/68398
  Scenario Outline: Alerts |(C68398) Badge count should match with the count of alerts, if Unread filter is selected from dropdown for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    And close the welcome popup for user "<role>" role
    And navigate to "Alerts" page for "<role>" user
    And click on date dropdown & select 'Unread'
    Then once list is shown, match the "total" count in notification api call & in the UI
    @sanity @Alerts @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 68398 |
    @sanity @Alerts @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 68398 |
    @sanity @Alerts @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 68398 |
    @sanity @Alerts @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 68398 |
    @sanity @Alerts @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 68398 |
