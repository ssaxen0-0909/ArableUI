Feature: Alert Settings Page load time

#  Scenario Outline: Alert Settings | Capture page load for alert settings page with multiple "<role>" user
#    Given log into application with a "<role>" user
#    When navigate to page "Alert Settings" and verify alert settings is displayed for "<role>" user
#    Then update Excel columns for "<role>" user
#
#    @sanity @Performance @AlertSettings @member @Scenario1
#    Examples:
#      | role   |
#      | member |
#    @sanity @Performance @AlertSettings @orgAdmin @Scenario1
#    Examples:
#      | role     |
#      | orgAdmin |
#    @sanity @Performance @AlertSettings @orgReader @Scenario1
#    Examples:
#      | role      |
#      | orgReader |
#    @sanity @Performance @AlertSettings @sysReader @Scenario1
#    Examples:
#      | role      |
#      | sysReader |
#    @sanity @Performance @AlertSettings @teamAdmin @Scenario1
#    Examples:
#      | role      |
#      | teamAdmin |


  Scenario Outline: Alert Settings | verify sites in alert settings with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Add setting button for "<role>" user

    @sanity @AlertSettings @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | 59135 |
    @sanity @AlertSettings @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 59135 |
    @sanity @AlertSettings @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | 59135 |
    @sanity @AlertSettings @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | 59135 |
    @sanity @AlertSettings @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | 59135 |


  Scenario Outline: Alert Settings | verify if error is shown on clicking on confirm without selecting any site for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Add setting button and click on confirm button and verify error msg for "<role>" user

    @sanity @AlertSettings @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 59136 |
    @sanity @AlertSettings @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 59136 |
    @sanity @AlertSettings @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 59136 |
    @sanity @AlertSettings @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 59136 |
    @sanity @AlertSettings @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 59136 |


  Scenario Outline: Alert Settings | verify modal info for Default Sites for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Default and verify modal info for Default Sites for "<role>" user

    @sanity @AlertSettings @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 59111 |
    @sanity @AlertSettings @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 59111 |
    @sanity @AlertSettings @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 59111 |
    @sanity @AlertSettings @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 59111 |
    @sanity @AlertSettings @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 59111 |


  Scenario Outline: Alert Settings | verify modal info for Specific Sites for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Specific and verify modal info for Specific Sites for "<role>" user

    @sanity @AlertSettings @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 59112 |
    @sanity @AlertSettings @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 59112 |
    @sanity @AlertSettings @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 59112 |
    @sanity @AlertSettings @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 59112 |
    @sanity @AlertSettings @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 59112 |


  Scenario Outline: Alert Settings | verify modal info for Weather for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Weather and verify modal info for "<role>" user

    @sanity @AlertSettings @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 59137 |
    @sanity @AlertSettings @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 59137 |
    @sanity @AlertSettings @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 59137 |
    @sanity @AlertSettings @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 59137 |
    @sanity @AlertSettings @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 59137 |


  Scenario Outline: Alert Settings | verify modal info for Crop Health for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Crop Health and verify modal info for "<role>" user

    @sanity @AlertSettings @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 59138 |
    @sanity @AlertSettings @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 59138 |
    @sanity @AlertSettings @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 59138 |
    @sanity @AlertSettings @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 59138 |
    @sanity @AlertSettings @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 59138 |


  Scenario Outline: Alert Settings | verify modal info for Device for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Device and verify modal info for Device for "<role>" user

    @sanity @AlertSettings @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 59139 |
    @sanity @AlertSettings @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 59139 |
    @sanity @AlertSettings @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 59139 |
    @sanity @AlertSettings @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 59139 |
    @sanity @AlertSettings @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 59139 |


  Scenario Outline: Alert Settings | verify modal info for Mobile for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Mobile and verify modal info for Mobile for "<role>" user

    @sanity @AlertSettings @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 59140 |
    @sanity @AlertSettings @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 59140 |
    @sanity @AlertSettings @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 59140 |
    @sanity @AlertSettings @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 59140 |
    @sanity @AlertSettings @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 59140 |


  Scenario Outline: Alert Settings | verify modal info for SMS for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on SMS and verify modal info for SMS for "<role>" user

    @sanity @AlertSettings @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 59141 |
    @sanity @AlertSettings @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 59141 |
    @sanity @AlertSettings @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 59141 |
    @sanity @AlertSettings @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 59141 |
    @sanity @AlertSettings @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 59141 |


  Scenario Outline: Alert Settings | verify modal info for Voice for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Voice and verify modal info for Voice for "<role>" user

    @sanity @AlertSettings @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 59142 |
    @sanity @AlertSettings @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 59142 |
    @sanity @AlertSettings @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 59142 |
    @sanity @AlertSettings @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 59142 |
    @sanity @AlertSettings @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 59142 |


  Scenario Outline: Alert Settings | verify modal info for Default Notifications Settings for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Default Notifications Settings and verify modal info for "<role>" user

    @sanity @AlertSettings @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 59116 |
    @sanity @AlertSettings @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 59116 |
    @sanity @AlertSettings @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 59116 |
    @sanity @AlertSettings @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 59116 |
    @sanity @AlertSettings @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 59116 |


  Scenario Outline: Alert Settings | verify modal info for Heat Spikes for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Heat Spikes and verify modal info for "<role>" user

    @sanity @AlertSettings @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 59129 |
    @sanity @AlertSettings @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 59129 |
    @sanity @AlertSettings @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 59129 |
    @sanity @AlertSettings @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 59129 |
    @sanity @AlertSettings @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 59129 |


  Scenario Outline: Alert Settings | verify modal info for Frost Events for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Frost Events and verify modal info for "<role>" user

    @sanity @AlertSettings @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 59130 |
    @sanity @AlertSettings @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 59130 |
    @sanity @AlertSettings @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 59130 |
    @sanity @AlertSettings @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 59130 |
    @sanity @AlertSettings @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 59130 |


  Scenario Outline: Alert Settings | verify modal info for Rainfall Events for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Rainfall Events and verify modal info for "<role>" user

    @sanity @AlertSettings @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 59131 |
    @sanity @AlertSettings @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 59131 |
    @sanity @AlertSettings @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 59131 |
    @sanity @AlertSettings @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 59131 |
    @sanity @AlertSettings @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 59131 |


  Scenario Outline: Alert Settings | verify modal info for GDD & Growth Stages for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on GDD & Growth Stages and verify modal info for "<role>" user

    @sanity @AlertSettings @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 59132 |
    @sanity @AlertSettings @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 59132 |
    @sanity @AlertSettings @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 59132 |
    @sanity @AlertSettings @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 59132 |
    @sanity @AlertSettings @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 59132 |


  Scenario Outline: Alert Settings | verify modal info for Inactive and New Sites for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Inactive and New Sites and verify modal info for "<role>" user

    @sanity @AlertSettings @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 59133 |
    @sanity @AlertSettings @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 59133 |
    @sanity @AlertSettings @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 59133 |
    @sanity @AlertSettings @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 59133 |
    @sanity @AlertSettings @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 59133 |


  Scenario Outline: Alert Settings | verify modal info for Device Tilts for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on Device Tilts and verify modal info for "<role>" user

    @sanity @AlertSettings @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 59134 |
    @sanity @AlertSettings @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 59134 |
    @sanity @AlertSettings @orgReader @Scenario17
    Examples:
      | role      | tcId  |
      | orgReader | 59134 |
    @sanity @AlertSettings @sysReader @Scenario17
    Examples:
      | role      | tcId  |
      | sysReader | 59134 |
    @sanity @AlertSettings @teamAdmin @Scenario17
    Examples:
      | role      | tcId  |
      | teamAdmin | 59134 |


  Scenario Outline: Alert Settings | verify send test alerts option for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on menu button and verify send test alerts for "<role>" user

    @sanity @AlertSettings @member @Scenario18
    Examples:
      | role   | tcId  |
      | member | 59122 |
    @sanity @AlertSettings @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 59122 |
    @sanity @AlertSettings @orgReader @Scenario18
    Examples:
      | role      | tcId  |
      | orgReader | 59122 |
    @sanity @AlertSettings @sysReader @Scenario18
    Examples:
      | role      | tcId  |
      | sysReader | 59122 |
    @sanity @AlertSettings @teamAdmin @Scenario18
    Examples:
      | role      | tcId  |
      | teamAdmin | 59122 |


  Scenario Outline: Alert Settings | verify channels option and disabled send button for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on menu button and verify channels option and disabled send button for "<role>" user

    @sanity @AlertSettings @member @Scenario19
    Examples:
      | role   | tcId  |
      | member | 59124 |
    @sanity @AlertSettings @orgAdmin @Scenario19
    Examples:
      | role     | tcId  |
      | orgAdmin | 59124 |
    @sanity @AlertSettings @orgReader @Scenario19
    Examples:
      | role      | tcId  |
      | orgReader | 59124 |
    @sanity @AlertSettings @sysReader @Scenario19
    Examples:
      | role      | tcId  |
      | sysReader | 59124 |
    @sanity @AlertSettings @teamAdmin @Scenario19
    Examples:
      | role      | tcId  |
      | teamAdmin | 59124 |


  Scenario Outline: Alert Settings | verify sending test alert through sms channel for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on menu button and verify sending test alert through sms channel for "<role>" user

    @sanity @AlertSettings @member @Scenario20
    Examples:
      | role   | tcId  |
      | member | 59125 |
    @sanity @AlertSettings @orgAdmin @Scenario20
    Examples:
      | role     | tcId  |
      | orgAdmin | 59125 |
    @sanity @AlertSettings @orgReader @Scenario20
    Examples:
      | role      | tcId  |
      | orgReader | 59125 |
    @sanity @AlertSettings @sysReader @Scenario20
    Examples:
      | role      | tcId  |
      | sysReader | 59125 |
    @sanity @AlertSettings @teamAdmin @Scenario20
    Examples:
      | role      | tcId  |
      | teamAdmin | 59125 |


  Scenario Outline: Alert Settings | verify sending test alert through mobile channel for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on menu button and verify sending test alert through mobile channel for "<role>" user

    @sanity @AlertSettings @member @Scenario21
    Examples:
      | role   | tcId  |
      | member | 59127 |
    @sanity @AlertSettings @orgAdmin @Scenario21
    Examples:
      | role     | tcId  |
      | orgAdmin | 59127 |
    @sanity @AlertSettings @orgReader @Scenario21
    Examples:
      | role      | tcId  |
      | orgReader | 59127 |
    @sanity @AlertSettings @sysReader @Scenario21
    Examples:
      | role      | tcId  |
      | sysReader | 59127 |
    @sanity @AlertSettings @teamAdmin @Scenario21
    Examples:
      | role      | tcId  |
      | teamAdmin | 59127 |


  Scenario Outline: Alert Settings | verify sending test alert through phone channel for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on menu button and verify sending test alert through phone channel for "<role>" user

    @sanity @AlertSettings @member @Scenario22
    Examples:
      | role   | tcId  |
      | member | 59128 |
    @sanity @AlertSettings @orgAdmin @Scenario22
    Examples:
      | role     | tcId  |
      | orgAdmin | 59128 |
    @sanity @AlertSettings @orgReader @Scenario22
    Examples:
      | role      | tcId  |
      | orgReader | 59128 |
    @sanity @AlertSettings @sysReader @Scenario22
    Examples:
      | role      | tcId  |
      | sysReader | 59128 |
    @sanity @AlertSettings @teamAdmin @Scenario22
    Examples:
      | role      | tcId  |
      | teamAdmin | 59128 |


  Scenario Outline: Alert Settings | verify closing send alert modal for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",click on menu button and verify closing send alert modal for "<role>" user

    @sanity @AlertSettings @member @Scenario23
    Examples:
      | role   | tcId  |
      | member | 59126 |
    @sanity @AlertSettings @orgAdmin @Scenario23
    Examples:
      | role     | tcId  |
      | orgAdmin | 59126 |
    @sanity @AlertSettings @orgReader @Scenario23
    Examples:
      | role      | tcId  |
      | orgReader | 59126 |
    @sanity @AlertSettings @sysReader @Scenario23
    Examples:
      | role      | tcId  |
      | sysReader | 59126 |
    @sanity @AlertSettings @teamAdmin @Scenario23
    Examples:
      | role      | tcId  |
      | teamAdmin | 59126 |


  Scenario Outline: Alert Settings | verify subscribing sms alert for Heat spike for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings",subscribe to sms alert for Heat spike for "<role>" user

    @sanity @AlertSettings @member @Scenario24
    Examples:
      | role   | tcId  |
      | member | 59117 |
    @sanity @AlertSettings @orgAdmin @Scenario24
    Examples:
      | role     | tcId  |
      | orgAdmin | 59117 |
    @sanity @AlertSettings @orgReader @Scenario24
    Examples:
      | role      | tcId  |
      | orgReader | 59117 |
    @sanity @AlertSettings @sysReader @Scenario24
    Examples:
      | role      | tcId  |
      | sysReader | 59117 |
    @sanity @AlertSettings @teamAdmin @Scenario24
    Examples:
      | role      | tcId  |
      | teamAdmin | 59117 |


  Scenario Outline: Alert Settings | verify banners for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings" and verify banners for "<role>" user

    @sanity @AlertSettings @member @Scenario25
    Examples:
      | role   | tcId  |
      | member | 59109 |
    @sanity @AlertSettings @orgAdmin @Scenario25
    Examples:
      | role     | tcId  |
      | orgAdmin | 59109 |
    @sanity @AlertSettings @orgReader @Scenario25
    Examples:
      | role      | tcId  |
      | orgReader | 59109 |
    @sanity @AlertSettings @sysReader @Scenario25
    Examples:
      | role      | tcId  |
      | sysReader | 59109 |
    @sanity @AlertSettings @teamAdmin @Scenario25
    Examples:
      | role      | tcId  |
      | teamAdmin | 59109 |


  Scenario Outline: Alert Settings | verify sites banner contents for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings" and verify sites banner contents for "<role>" user

    @sanity @AlertSettings @member @Scenario26
    Examples:
      | role   | tcId  |
      | member | 59110 |
    @sanity @AlertSettings @orgAdmin @Scenario26
    Examples:
      | role     | tcId  |
      | orgAdmin | 59110 |
    @sanity @AlertSettings @orgReader @Scenario26
    Examples:
      | role      | tcId  |
      | orgReader | 59110 |
    @sanity @AlertSettings @sysReader @Scenario26
    Examples:
      | role      | tcId  |
      | sysReader | 59110 |
    @sanity @AlertSettings @teamAdmin @Scenario26
    Examples:
      | role      | tcId  |
      | teamAdmin | 59110 |


  Scenario Outline: Alert Settings | verify global org selector is displayed on page for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings" and verify global org selector is displayed on page contents for "<role>" user

    @sanity @AlertSettings @member @Scenario27
    Examples:
      | role   | tcId  |
      | member | 59105 |
    @sanity @AlertSettings @orgAdmin @Scenario27
    Examples:
      | role     | tcId  |
      | orgAdmin | 59105 |
    @sanity @AlertSettings @orgReader @Scenario27
    Examples:
      | role      | tcId  |
      | orgReader | 59105 |
    @sanity @AlertSettings @sysReader @Scenario27
    Examples:
      | role      | tcId  |
      | sysReader | 59105 |
    @sanity @AlertSettings @teamAdmin @Scenario27
    Examples:
      | role      | tcId  |
      | teamAdmin | 59105 |


  Scenario Outline: Alert Settings | verify banner count is updating on switching org for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings" and verify banner count is updating on switching org for "<role>" user

    @sanity @AlertSettings @member @Scenario28
    Examples:
      | role   | tcId  |
      | member | 59107 |
    @sanity @AlertSettings @orgAdmin @Scenario28
    Examples:
      | role     | tcId  |
      | orgAdmin | 59107 |
    @sanity @AlertSettings @orgReader @Scenario28
    Examples:
      | role      | tcId  |
      | orgReader | 59107 |
    @sanity @AlertSettings @sysReader @Scenario28
    Examples:
      | role      | tcId  |
      | sysReader | 59107 |
    @sanity @AlertSettings @teamAdmin @Scenario28
    Examples:
      | role      | tcId  |
      | teamAdmin | 59107 |


  Scenario Outline: Alert Settings | verify banner count is updating on switching team for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings" and verify banner count is updating on switching team for "<role>" user

    @sanity @AlertSettings @member @Scenario29
    Examples:
      | role   | tcId  |
      | member | 59108 |
    @sanity @AlertSettings @orgAdmin @Scenario29
    Examples:
      | role     | tcId  |
      | orgAdmin | 59108 |
    @sanity @AlertSettings @orgReader @Scenario29
    Examples:
      | role      | tcId  |
      | orgReader | 59108 |
    @sanity @AlertSettings @sysReader @Scenario29
    Examples:
      | role      | tcId  |
      | sysReader | 59108 |
    @sanity @AlertSettings @teamAdmin @Scenario29
    Examples:
      | role      | tcId  |
      | teamAdmin | 59108 |


  Scenario Outline: Alert Settings | verify unsubscribing sms alert for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to page "Alert Settings" and verify unsubscribing sms alert for "<role>" user

    @sanity @AlertSettings @member @Scenario30
    Examples:
      | role   | tcId  |
      | member | 59118 |
    @sanity @AlertSettings @orgAdmin @Scenario30
    Examples:
      | role     | tcId  |
      | orgAdmin | 59118 |
    @sanity @AlertSettings @orgReader @Scenario30
    Examples:
      | role      | tcId  |
      | orgReader | 59118 |
    @sanity @AlertSettings @sysReader @Scenario30
    Examples:
      | role      | tcId  |
      | sysReader | 59118 |
    @sanity @AlertSettings @teamAdmin @Scenario30
    Examples:
      | role      | tcId  |
      | teamAdmin | 59118 |

