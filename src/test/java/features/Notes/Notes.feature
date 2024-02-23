#Feature: Site | Notes tab
#
#  Scenario Outline: Notes | Verify creating Notes for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and create a note for a "<role>" user.
#
#    @sanity @Notes @member @Scenario2
#    Examples:
#      | role   | tcId  |
#      | member | 69276 |
#    @sanity @Notes @orgAdmin @Scenario2
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69276 |
#    @sanity @Notes @orgReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69276 |
#    @sanity @Notes @sysReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69276 |
#    @sanity @Notes @teamAdmin @Scenario2
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69276 |
#
#
#  Scenario Outline: Notes | Verify deleting Notes for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and delete a note for "<role>" user.
#
#    @sanity @Notes @member @Scenario3
#    Examples:
#      | role   | tcId  |
#      | member | 69284 |
#    @sanity @Notes @orgAdmin @Scenario3
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69284 |
#    @sanity @Notes @orgReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69284 |
#    @sanity @Notes @sysReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69284 |
#    @sanity @Notes @teamAdmin @Scenario3
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69284 |
#
#
#  Scenario Outline: Notes | Verify creating Notes with past date for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and create a note with past date for "<role>" user.
#
#    @sanity @Notes @member @Scenario4
#    Examples:
#      | role   | tcId  |
#      | member | 69275 |
#    @sanity @Notes @orgAdmin @Scenario4
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69275 |
#    @sanity @Notes @orgReader @Scenario4
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69275 |
#    @sanity @Notes @sysReader @Scenario4
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69275 |
#    @sanity @Notes @teamAdmin @Scenario4
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69275 |
#
#  Scenario Outline: Notes | Verify view Notes modal for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and click on view note for "<role>" user.
#
#    @sanity @Notes @member @Scenario5
#    Examples:
#      | role   | tcId  |
#      | member | 69282 |
#    @sanity @Notes @orgAdmin @Scenario5
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69282 |
#    @sanity @Notes @orgReader @Scenario5
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69282 |
#    @sanity @Notes @sysReader @Scenario5
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69282 |
#    @sanity @Notes @teamAdmin @Scenario5
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69282 |
#
#  Scenario Outline: Notes | Verify share Notes for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and click on view note and share for "<role>" user.
#
#    @sanity @Notes @member @Scenario6
#    Examples:
#      | role   | tcId  |
#      | member | 69280 |
#    @sanity @Notes @orgAdmin @Scenario6
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69280 |
#    @sanity @Notes @orgReader @Scenario6
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69280 |
#    @sanity @Notes @sysReader @Scenario6
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69280 |
#    @sanity @Notes @teamAdmin @Scenario6
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69280 |
#
#  Scenario Outline: Notes | Verify sharing Notes to multiple email id for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and click on view note and share for multiple emails "<role>" user.
#
#    @sanity @Notes @member @Scenario7
#    Examples:
#      | role   | tcId  |
#      | member | 69281 |
#    @sanity @Notes @orgAdmin @Scenario7
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69281 |
#    @sanity @Notes @orgReader @Scenario7
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69281 |
#    @sanity @Notes @sysReader @Scenario7
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69281 |
#    @sanity @Notes @teamAdmin @Scenario7
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69281 |
#
#  Scenario Outline: Notes | Verify sharing Notes to invalid email id for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and click on view note and share for invalid emailId "<role>" user.
#
#    @sanity @Notes @member @Scenario8
#    Examples:
#      | role   | tcId  |
#      | member | 69283 |
#    @sanity @Notes @orgAdmin @Scenario8
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69283 |
#    @sanity @Notes @orgReader @Scenario8
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69283 |
#    @sanity @Notes @sysReader @Scenario8
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69283 |
#    @sanity @Notes @teamAdmin @Scenario8
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69283 |
#
#  Scenario Outline: Notes | Verify error message for recipient incomplete email id for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and click on view note and share for incomplete email id "<role>" user.
#
#    @sanity @Notes @member @Scenario9
#    Examples:
#      | role   | tcId  |
#      | member | 69277 |
#    @sanity @Notes @orgAdmin @Scenario9
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69277 |
#    @sanity @Notes @orgReader @Scenario9
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69277 |
#    @sanity @Notes @sysReader @Scenario9
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69277 |
#    @sanity @Notes @teamAdmin @Scenario9
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69277 |
#
#  Scenario Outline: Notes | Verify cancelling share modal for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and click on view note and click on cancel in share modal for "<role>" user.
#
#    @sanity @Notes @member @Scenario10
#    Examples:
#      | role   | tcId  |
#      | member | 69279 |
#    @sanity @Notes @orgAdmin @Scenario10
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69279 |
#    @sanity @Notes @orgReader @Scenario10
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69279 |
#    @sanity @Notes @sysReader @Scenario10
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69279 |
#    @sanity @Notes @teamAdmin @Scenario10
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69279 |
#
#  Scenario Outline: Notes | Verify if measurement units have decimal values for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and click on view note and measurement units have decimal values for "<role>" user.
#
#    @sanity @Notes @member @Scenario11
#    Examples:
#      | role   | tcId  |
#      | member | 69278 |
#    @sanity @Notes @orgAdmin @Scenario11
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69278 |
#    @sanity @Notes @orgReader @Scenario11
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69278 |
#    @sanity @Notes @sysReader @Scenario11
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69278 |
#    @sanity @Notes @teamAdmin @Scenario11
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69278 |
#
#  Scenario Outline: Notes | Verify if notes view modal has all measurement params for different "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When on Map page click on site name and navigate to "Notes" page
#    Then click on notes tab and click on view note and check for all measurements param for "<role>" user.
#
#    @sanity @Notes @member @Scenario12
#    Examples:
#      | role   | tcId  |
#      | member | 69285 |
#    @sanity @Notes @orgAdmin @Scenario12
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 69285 |
#    @sanity @Notes @orgReader @Scenario12
#    Examples:
#      | role      | tcId  |
#      | orgReader | 69285 |
#    @sanity @Notes @sysReader @Scenario12
#    Examples:
#      | role      | tcId  |
#      | sysReader | 69285 |
#    @sanity @Notes @teamAdmin @Scenario12
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 69285 |