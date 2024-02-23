#Feature: Rank Page
#
#  Scenario Outline: Rank | verify sortBy for all options in rank page with multiple "<role>"
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Rank" and verify table is displayed
#    Then verify sortBy for all options with multiple "<role>"
#
#    @sanity @Rank @member @Scenario2
#    Examples:
#      | role   | tcId  |
#      | member | 59148 |
#    @sanity @Rank @orgAdmin @Scenario2
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 59148 |
#    @sanity @Rank @orgReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | orgReader | 59148 |
#    @sanity @Rank @sysReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | sysReader | 59148 |
#    @sanity @Rank @teamAdmin @Scenario2
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 59148 |
#
#  Scenario Outline: Rank | verify sortBy for high and low options in rank page with multiple "<role>"
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Rank" and verify table is displayed
#    Then verify sortBy for high and low options with multiple "<role>"
#
#    @sanity @Rank @member @Scenario3
#    Examples:
#      | role   | tcId  |
#      | member | 59144 |
#    @sanity @Rank @orgAdmin @Scenario3
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 59144 |
#    @sanity @Rank @orgReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | orgReader | 59144 |
#    @sanity @Rank @sysReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | sysReader | 59144 |
#    @sanity @Rank @teamAdmin @Scenario3
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 59144 |
#
#
#  Scenario Outline: Rank | verify sort column By asc and desc order in rank page with multiple "<role>"
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Rank" and verify table is displayed
#    Then verify sortBy column By asc and desc order with multiple "<role>"
#
#    @sanity @Rank @member @Scenario4
#    Examples:
#      | role   | tcId  |
#      | member | 59146 |
#    @sanity @Rank @orgAdmin @Scenario4
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 59146 |
#    @sanity @Rank @orgReader @Scenario4
#    Examples:
#      | role      | tcId  |
#      | orgReader | 59146 |
#    @sanity @Rank @sysReader @Scenario4
#    Examples:
#      | role      | tcId  |
#      | sysReader | 59146 |
#    @sanity @Rank @teamAdmin @Scenario4
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 59146 |
#
#
#  Scenario Outline: Rank | verify tables on org switch in rank page with multiple "<role>"
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Rank" and verify table is displayed
#    Then verify tables on org switch with multiple "<role>"
#
#    @sanity @Rank @member @Scenario5
#    Examples:
#      | role   | tcId  |
#      | member | 59145 |
#    @sanity @Rank @orgAdmin @Scenario5
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 59145 |
#    @sanity @Rank @orgReader @Scenario5
#    Examples:
#      | role | tcId |
##      | orgReader | 59145 |
#    @sanity @Rank @sysReader @Scenario5
#    Examples:
#      | role      | tcId  |
#      | sysReader | 59145 |
#    @sanity @Rank @teamAdmin @Scenario5
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 59145 |
#
#
#  Scenario Outline: Rank | verify weather page navigation from rank page with multiple "<role>"
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Rank" and verify table is displayed
#    Then verify clicking on site name and navigation to weather page with multiple "<role>"
#
#    @sanity @Rank @member @Scenario6
#    Examples:
#      | role   | tcId  |
#      | member | 59147 |
#    @sanity @Rank @orgAdmin @Scenario6
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 59147 |
#    @sanity @Rank @orgReader @Scenario6
#    Examples:
#      | role      | tcId  |
#      | orgReader | 59147 |
#    @sanity @Rank @sysReader @Scenario6
#    Examples:
#      | role      | tcId  |
#      | sysReader | 59147 |
#    @sanity @Rank @teamAdmin @Scenario6
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 59147 |