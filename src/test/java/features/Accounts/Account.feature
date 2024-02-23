Feature: Account Page

#  Scenario Outline: Account | verify generating,copying & refreshing API key with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to "map" page
#    When navigate to Settings and then to "Account" page
#    Then verify generating,copying & refreshing for "<role>" user
#
#    @sanity @Performance @Account @member @Scenario1
#    Examples:
#      | role   | tcId  |
#      | member | 63208 |
#
#    @sanity @Performance @Account @orgAdmin @Scenario1
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 63208 |
#    @sanity @Performance @Account @orgReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | orgReader | 63208 |
#    @sanity @Performance @Account @sysReader @Scenario1
#    Examples:
#      | role      | tcId  |
#      | sysReader | 63208 |
#    @sanity @Performance @Account @teamAdmin @Scenario1
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 63208 |


#  Scenario Outline: Account | verify changing size unit with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to Settings and then to "Account" page
#    Then verify changing size unit for "<role>" user

#    @sanity @Account @member @Scenario2
#    Examples:
#      | role   | tcId  |
#      | member | 63206 |
#    @sanity @Account @orgAdmin @Scenario2
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 63206 |
#    @sanity @Account @orgReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | orgReader | 63206 |
#    @sanity @Account @sysReader @Scenario2
#    Examples:
#      | role      | tcId  |
#      | sysReader | 63206 |
#    @sanity @Account @teamAdmin @Scenario2
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 63206 |


#  Scenario Outline: Account | verify changing pressure unit with multiple "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When navigate to Settings and then to "Account" page
#    Then verify changing pressure unit for "<role>" user

#    @sanity @Account @member @Scenario3
#    Examples:
#      | role   | tcId  |
#      | member | 63207 |
#    @sanity @Account @orgAdmin @Scenario3
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 63207 |
#    @sanity @Account @orgReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | orgReader | 63207 |
#    @sanity @Account @sysReader @Scenario3
#    Examples:
#      | role      | tcId  |
#      | sysReader | 63207 |
#    @sanity @Account @teamAdmin @Scenario3
#    Examples:
#      | role      | tcId  |
#      | teamAdmin | 63207 |


  Scenario Outline: Account | verify Pt language option for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    When navigate to Settings and then to "Account" page
    Then verify Pt language option for "<role>" user

    @sanity @Account @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 65279 |
    @sanity @Account @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 65279 |
    @sanity @Account @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 65279 |
    @sanity @Account @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 65279 |
    @sanity @Account @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 65279 |


  Scenario Outline: Account | verify clicking on Pt language option for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    When navigate to Settings and then to "Account" page
    Then click on Pt language option and verify any translated text for "<role>" user

    @sanity @Account @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 65280 |
    @sanity @Account @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 65280 |
    @sanity @Account @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 65280 |
    @sanity @Account @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 65280 |
    @sanity @Account @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 65280 |

  Scenario Outline: Account | verify Sp language option for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    When navigate to Settings and then to "Account" page
    Then verify Sp language option for "<role>" user

    @sanity @Account @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 69310 |
    @sanity @Account @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 69310 |
    @sanity @Account @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 69310 |
    @sanity @Account @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 69310 |
    @sanity @Account @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 69310 |


  Scenario Outline: Account | verify clicking on Sp language option for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    When navigate to Settings and then to "Account" page
    Then click on Sp language option and verify any translated text for "<role>" user

    @sanity @Account @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 69295 |
    @sanity @Account @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 69295 |
    @sanity @Account @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 69295 |
    @sanity @Account @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 69295 |
    @sanity @Account @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 69295 |


  Scenario Outline: Account | Verify firstname & last Name field should not accept Numbers and special character

    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    When navigate to Settings and then to "Account" page
    Then verify by entering  the numbers and special character in firstname & lastname field for "<role>" user

    @sanity @Account @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 69380 |
    @sanity @Account @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 69380 |
    @sanity @Account @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 69380 |
    @sanity @Account @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 69380 |
    @sanity @Account @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 69380 |

  Scenario Outline: Account | Verify if there are any error on saving the details by changing the number and flag

    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "map" page
    When navigate to Settings and then to "Account" page
    Then verify any error by changing number and flag  for "<role>" user

    @sanity @Account @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 69396 |
    @sanity @Account @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 69396 |
    @sanity @Account @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 69396 |
    @sanity @Account @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 69396 |
    @sanity @Account @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 69396 |

 #https://arabletestrail.testrail.io/index.php?/cases/view/68359
  Scenario Outline: Account (68359) | Stag - Changing wind speed unit in the Accounts page should update accordingly the Units in all modules where the measurement is used for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    When navigate to "map" page
    Then navigate to Settings and then to "Account" page
    And change the unit for Wind Speed in Account page
    And click on Save button
    And verify that the unit for "speed" with the API response
    And changing the Temperature dropdown to Wind, the same unit should reflect in the legend
    Then verify on Weather page, same unit should reflect in Wind Speed Hourly section
    @sanity @Account @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 68359 |
    @sanity @Account @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 68359 |
    @sanity @Account @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 68359 |
    @sanity @Account @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 68359 |
    @sanity @Account @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 68359 |

  #https://arabletestrail.testrail.io/index.php?/cases/view/68360
  Scenario Outline: Account (68360) | Stag - Changing size unit in the Accounts page should update accordingly the Units in all modules where the measurement is used for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    When navigate to "map" page
    Then navigate to Settings and then to "Account" page
    And change the unit for Size in Account page
    And click on Save button
    And verify that the unit for "size" with the API response
    And changing the Temperature dropdown to Daily ETc, the same unit should reflect in the legend
    Then verify on Plant page, same unit should reflect in Daily ETc, ETo & Precipitation section
    @sanity @Account @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 68360 |
    @sanity @Account @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 68360 |
    @sanity @Account @orgReader @Scenario11
    Examples:
      | role      | tcId  |
      | orgReader | 68360 |
    @sanity @Account @sysReader @Scenario11
    Examples:
      | role      | tcId  |
      | sysReader | 68360 |
    @sanity @Account @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 68360 |

  #https://arabletestrail.testrail.io/index.php?/cases/view/68361
  Scenario Outline: Account (68361) | Stag - Changing Temperature unit in the Accounts page should update accordingly the Units in all modules where the measurement is used for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    When navigate to "map" page
    Then navigate to Settings and then to "Account" page
    And change the unit for Temperature in Account page
    And click on Save button
    And verify that the unit for "temp" with the API response
    And verify that on Map page, for Temperature dropdown, the same unit should reflect in the legend
    Then verify on Weather page, same unit should reflect in Today's Temperature and Current Conditions section
    @sanity @Account @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 68361 |
    @sanity @Account @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 68361 |
    @sanity @Account @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 68361 |
    @sanity @Account @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 68361 |
    @sanity @Account @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 68361 |

  #https://arabletestrail.testrail.io/index.php?/cases/view/68362
  Scenario Outline: Account (68362) | Stag - Changing Pressure unit in the Accounts page should update accordingly the Units in all modules where the measurement is used for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    When navigate to "map" page
    Then navigate to Settings and then to "Account" page
    And change the unit for Pressure in Account page
    And click on Save button
    And verify that the unit for "press" with the API response
    Then verify on Weather page, same unit should reflect in Current Condition section for pressure
    @sanity @Account @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 68362 |
    @sanity @Account @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 68362 |
    @sanity @Account @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 68362 |
    @sanity @Account @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 68362 |
    @sanity @Account @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 68362 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/68363
  Scenario Outline: Account (68363) | Stag - Changing Volume unit in the Accounts page should update accordingly the Units in all modules where the measurement is used for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    When navigate to "map" page
    Then navigate to Settings and then to "Account" page
    And change the unit for volume in Account page
    And click on Save button
    Then verify that the unit is the same in the device page
    @sanity @Account @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 68363 |
    @sanity @Account @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 68363 |
    @sanity @Account @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 68363 |
    @sanity @Account @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 68363 |
    @sanity @Account @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 68363 |

  # https://arabletestrail.testrail.io/index.php?/cases/view/69308
  Scenario Outline: Account (69308) | Stag - Verify if language options i.e English ,Português & Español are visible for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    When log into application with a "<role>" user
    When navigate to "map" page
    Then navigate to Settings and then to "Account" page
    And verify if language options are multiple and visible
    @sanity @Account @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 69308 |
    @sanity @Account @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 69308 |
    @sanity @Account @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 69308 |
    @sanity @Account @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 69308 |
    @sanity @Account @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 69308 |

