Feature: Sites Page

#  Scenario Outline: Sites | Capture page load time for sites page with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Sites"
#    Then verify site card is displayed and update load time in Excel sheet for "<role>" user
#
#    @sanity @Performance @Sites @member @Scenario1
#    Examples:
#      | role   | tcId  |
#      | member | 60822 |
#    @sanity @Performance @Sites @orgAdmin @Scenario1
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60822 |
#    @sanity @Performance @Sites @orgReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60822 |
#    @sanity @Performance @Sites @sysReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60822 |
#    @sanity @Performance @Sites @teamAdmin @Scenario1
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60822 |


#  Scenario Outline: Sites | verify and capture page load time for edit site with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to page "Sites"
#    Then verify edit site and update load time in Excel sheet for "<role>" user
#
#    @sanity @Performance @Sites @member @Scenario2
#    Examples:
#      | role   | tcId  |
#      | member | 60823 |
#    @sanity @Performance @Sites @orgAdmin @Scenario2
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 60823 |
#    @sanity @Performance @Sites @orgReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | orgReader | 60823 |
#    @sanity @Performance @Sites @sysReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | sysReader | 60823 |
#    @sanity @Performance @Sites @teamAdmin @Scenario2
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 60823 |


  Scenario Outline: Sites | verify edit soil properties for site card with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify edit soil properties for site card for "<role>" user

    @sanity @Sites @member @Scenario3
    Examples:
      | role | tcId |
#      | member    | 58974 | need to raise a bug for fix
    @sanity @Sites @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 60824 |
    @sanity @Sites @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 60824 |
    @sanity @Sites @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 60824 |
    @sanity @Sites @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 60824 |

  Scenario Outline: Sites | verify editing manual irrigation for site card with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify editing manual irrigation for "<role>" user

    @sanity @Sites @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 60825 |
    @sanity @Sites @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 60825 |
    @sanity @Sites @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 60825 |
    @sanity @Sites @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 60825 |
    @sanity @Sites @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 60825 |


  Scenario Outline: Sites | verify create season from menu button for site card with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify create season from menu button for "<role>" user

    @sanity @Sites @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 60826 |
    @sanity @Sites @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 60826 |
    @sanity @Sites @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 60826 |


  Scenario Outline: Sites | verify location list of card matching with site details page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify location list of card matching with site details page for "<role>" user

    @sanity @Sites @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 60827 |
    @sanity @Sites @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 60827 |
    @sanity @Sites @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 60827 |
    @sanity @Sites @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 60827 |
    @sanity @Sites @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 60827 |

  Scenario Outline: Sites | verify Go to button on site details page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify Go to button on site details page for "<role>" user

    @sanity @Sites @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 65138 |
    @sanity @Sites @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 65138 |
    @sanity @Sites @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 65138 |
    @sanity @Sites @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 65138 |
    @sanity @Sites @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 65138 |


  Scenario Outline: Sites | verify Go to last page on site details page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify Go to last page on site details page for "<role>" user

    @sanity @Sites @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 65139 |
    @sanity @Sites @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 65139 |
    @sanity @Sites @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 65139 |
    @sanity @Sites @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 65139 |
    @sanity @Sites @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 65139 |


  Scenario Outline: Sites | verify Go to last page button disabled state on site details page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then click on last page button and then state of button for "<role>" user

    @sanity @Sites @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 65140 |
    @sanity @Sites @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 65140 |
    @sanity @Sites @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 65140 |
    @sanity @Sites @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 65140 |
    @sanity @Sites @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 65140 |


  Scenario Outline: Sites | verify Go to first page button disabled state on site details page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify go to first page and go to Prev page buttons state for "<role>" user

    @sanity @Sites @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 65166 |
    @sanity @Sites @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 65166 |
    @sanity @Sites @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 65166 |
    @sanity @Sites @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 65166 |
    @sanity @Sites @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 65166 |


  Scenario Outline: Sites | verify go to page behaviour by input number higher value than the last page number with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify behaviour on input number higher than last page number for "<role>" user

    @sanity @Sites @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 65167 |
    @sanity @Sites @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 65167 |
    @sanity @Sites @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 65167 |
    @sanity @Sites @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 65167 |
    @sanity @Sites @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 65167 |


  Scenario Outline: Sites | verify input invalid value in go to field with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify behaviour on input invalid value in go to field for "<role>" user

    @sanity @Sites @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 65168 |
    @sanity @Sites @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 65168 |
    @sanity @Sites @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 65168 |
    @sanity @Sites @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 65168 |
    @sanity @Sites @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 65168 |


  Scenario Outline: Sites | verify warning text in Create New Site modal with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then click on Create New Site and verify warning message for "<role>" user

    @sanity @Sites @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 65169 |
    @sanity @Sites @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 65169 |
    @sanity @Sites @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 65169 |


  Scenario Outline: Sites | verify Clear boundary button in Edit Site modal with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then click on Edit Site of any site and clear boundary button for "<role>" user

    @sanity @Sites @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 65170 |
    @sanity @Sites @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 65170 |
    @sanity @Sites @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 65170 |


  Scenario Outline: Sites | verify saving site without boundary with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then click on Edit Site of any site and click on Clear Boundary button and verify saving site for "<role>" user

    @sanity @Sites @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 65174 |
    @sanity @Sites @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 65174 |
    @sanity @Sites @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 65174 |


  Scenario Outline: Sites | verify sites list per page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify  sites list per page for "<role>" user

    @sanity @Sites @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 64262 |
    @sanity @Sites @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 64262 |
    @sanity @Sites @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 64262 |
    @sanity @Sites @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 64262 |
    @sanity @Sites @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 64262 |


  Scenario Outline: Sites | verify sites list on next page with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Sites"
    Then verify sites list on next page for "<role>" user

    @sanity @Sites @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 65281 |
    @sanity @Sites @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 65281 |
    @sanity @Sites @orgReader @Scenario17
    Examples:
      | role      | tcId  |
      | orgReader | 65281 |
    @sanity @Sites @sysReader @Scenario17
    Examples:
      | role      | tcId  |
      | sysReader | 65281 |
    @sanity @Sites @teamAdmin @Scenario17
    Examples:
      | role      | tcId  |
      | teamAdmin | 65281 |