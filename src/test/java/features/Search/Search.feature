Feature: Search Page


#  Scenario Outline: Search | Capture page load time for search module with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    Then navigate to page "Search"
#    And verify search bar is displayed for "<role>" user
#
#    @sanity @Performance @Search @member @Scenario1
#    Examples:
#      | role   | tcId  |
#      | member | 59149 |
#    @sanity @Performance @Search @orgAdmin @Scenario1
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 59149 |
#    @sanity @Performance @Search @orgReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | orgReader | 59149 |
#    @sanity @Performance @Search @sysReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | sysReader | 59149 |
#    @sanity @Performance @Search @teamAdmin @Scenario1
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 59149 |


  Scenario Outline: Search | Verify if site card is displayed on search with site name with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Search" and verify if site card is displayed on searching with site name for "<role>" user

    @sanity @Search @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | 59150 |
    @sanity @Search @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 59150 |
    @sanity @Search @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | 59150 |
    @sanity @Search @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | 59150 |
    @sanity @Search @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | 59150 |


  Scenario Outline: Search | Verify if device card is displayed on search with device name with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Search" and verify if device card is displayed on searching with device name for "<role>" user

    @sanity @Search @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 59152 |
    @sanity @Search @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 59152 |
    @sanity @Search @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 59152 |
    @sanity @Search @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 59152 |
    @sanity @Search @teamAdmin @Scenario3
    Examples:
      | role | tcId |
#      | teamAdmin | 59152 |fix required


  Scenario Outline: Search | Verify if device card is navigating to searched device on device page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Search" and verify if device card is navigating to searched device on device page for "<role>" user

    @sanity @Search @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 59153 |
    @sanity @Search @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 59153 |
    @sanity @Search @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 59153 |
    @sanity @Search @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 59153 |
    @sanity @Search @teamAdmin @Scenario4
    Examples:
      | role | tcId |
#      | teamAdmin | 59153 |fix required


  Scenario Outline: Search | Verify if site card is navigating to searched site weather tab with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Search" and verify if site card is navigating to searched site weather tab for "<role>" user

    @sanity @Search @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 59151 |
    @sanity @Search @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 59151 |
    @sanity @Search @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 59151 |
    @sanity @Search @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 59151 |
    @sanity @Search @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 59151 |
