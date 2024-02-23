Feature: Teams Page

#  Scenario Outline: Teams | Capture page load time for teams page with multiple "<role>" user
#    Given log into application with a "<role>" user
#    When navigate to "Teams"
#    Then verify teams name are displayed and also update page load time in Excel for "<role>" user
#
#    @sanity @Performance @Teams @member @Scenario1
#    Examples:
#      | role   |
#      | member |
#    @sanity @Performance @Teams @orgAdmin @Scenario1
#    Examples:
#      | role     |
#      | orgAdmin |
#    @sanity @Performance @Teams @orgReader @Scenario1
#    Examples:
#      | role      |
#      | orgReader |
#    @sanity @Performance @Teams @sysReader @Scenario1
#    Examples:
#      | role      |
#      | sysReader |
#    @sanity @Performance @Teams @teamAdmin @Scenario1
#    Examples:
#      | role      |
#      | teamAdmin |


  Scenario Outline: Teams | verify if Administrators row is displayed for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify if Administrators row is displayed for "<role>" user

    @sanity @Teams @member @Scenario2
    Examples:
      | role   | tcId  |
      | member | 59076 |
    @sanity @Teams @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 59052 |
    @sanity @Teams @orgReader @Scenario2
    Examples:
      | role      | tcId  |
      | orgReader | 59068 |
    @sanity @Teams @sysReader @Scenario2
    Examples:
      | role      | tcId  |
      | sysReader | 59084 |
    @sanity @Teams @teamAdmin @Scenario2
    Examples:
      | role      | tcId  |
      | teamAdmin | 59092 |

  Scenario Outline: Teams | verify if Administrators row does not have Edit option for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify if Administrators row is not displaying Edit options for "<role>" user

    @sanity @Teams @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 59053 |
    @sanity @Teams @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 59053 |
    @sanity @Teams @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 59069 |
    @sanity @Teams @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 59085 |
    @sanity @Teams @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 59093 |


  Scenario Outline: Teams | verify create team, edit member role and delete new team for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify if new team is getting created,edited and deleted for "<role>" user

    @sanity @Teams @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 59078 |
#    @sanity @Teams @orgAdmin @Scenario4
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 59054 |
    @sanity @Teams @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 59070 |
    @sanity @Teams @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 59086 |
    @sanity @Teams @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 59094 |


  Scenario Outline: Teams | verify invite new members for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify if invite new members for "<role>" user

    @sanity @Teams @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 59079 |
    @sanity @Teams @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 59055 |
    @sanity @Teams @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 59071 |
    @sanity @Teams @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 59087 |
    @sanity @Teams @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 59095 |


  Scenario Outline: Teams | verify invite current members for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify if invite current members for "<role>" user

    @sanity @Teams @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 59080 |
    @sanity @Teams @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 59056 |
    @sanity @Teams @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 59072 |
    @sanity @Teams @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 59088 |
    @sanity @Teams @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 59096 |


  Scenario Outline: Teams | verify edit team add and remove member for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify edit team by adding and removing member for "<role>" user

    @sanity @Teams @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 59081 |
    @sanity @Teams @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 59057 |
    @sanity @Teams @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 59073 |
    @sanity @Teams @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 59089 |
    @sanity @Teams @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 59097 |


  Scenario Outline: Teams | verify stats on switching orgs for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify stats on switching orgs for "<role>" user

    @sanity @Teams @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 59082 |
    @sanity @Teams @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 59058 |
    @sanity @Teams @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 59074 |
    @sanity @Teams @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 59090 |
    @sanity @Teams @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 59098 |

  Scenario Outline: Teams | verify assigned team stats for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify assigned team stats for "<role>" user

    @sanity @Teams @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 59083 |
    @sanity @Teams @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 59059 |
    @sanity @Teams @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 59075 |
    @sanity @Teams @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 59091 |
    @sanity @Teams @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 59099 |


  Scenario Outline: Teams | verify unassigned sites modal feature for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify unassigned sites modal feature for "<role>" user

    @sanity @Teams @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 64271 |
    @sanity @Teams @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 64267 |
    @sanity @Teams @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 64268 |


  Scenario Outline: Teams | verify confirm button state in unassigned sites modal feature for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on unassigned sites modal and verify confirm button state for "<role>" user

    @sanity @Teams @member @Scenario11
    Examples:
      | role   | tcId  |
      | member | 65286 |
    @sanity @Teams @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 65284 |
    @sanity @Teams @teamAdmin @Scenario11
    Examples:
      | role      | tcId  |
      | teamAdmin | 65285 |


  Scenario Outline: Teams | verify unassigned sites modal title & description feature for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on unassigned sites modal and verify title and description for "<role>" user

    @sanity @Teams @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 65289 |
    @sanity @Teams @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 65287 |
    @sanity @Teams @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 65288 |


  Scenario Outline: Teams | verify assigned team modal with 0 and without 0 count for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on assigned team modal and verify title and description for "<role>" user

    @sanity @Teams @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 65295 |
    @sanity @Teams @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 65290 |
    @sanity @Teams @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 65294 |
    @sanity @Teams @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 65293 |
    @sanity @Teams @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 65292 |


  Scenario Outline: Teams | verify unassigned team modal with 0 and without 0 count for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on unassigned team modal and verify title and description for "<role>" user

    @sanity @Teams @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 65299 |
    @sanity @Teams @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 65291 |
    @sanity @Teams @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 65298 |
    @sanity @Teams @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 65297 |
    @sanity @Teams @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 65296 |


  Scenario Outline: Teams | verify assigned members modal with 0 and without 0 count for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on assigned members modal and verify title and description for "<role>" user

    @sanity @Teams @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 65304 |
    @sanity @Teams @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 65300 |
    @sanity @Teams @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 65303 |
    @sanity @Teams @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 65302 |
    @sanity @Teams @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 65301 |


  Scenario Outline: Teams | verify unassigned members modal with 0 and without 0 count for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on unassigned members modal and verify title and description for "<role>" user

    @sanity @Teams @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 65309 |
    @sanity @Teams @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 65305 |
    @sanity @Teams @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 65308 |
    @sanity @Teams @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 65307 |
    @sanity @Teams @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 65306 |


  Scenario Outline: Teams | verify assigned sites modal title and description for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on assigned sites modal and verify title and description for "<role>" user

    @sanity @Teams @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 65314 |
    @sanity @Teams @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 65310 |
    @sanity @Teams @orgReader @Scenario17
    Examples:
      | role      | tcId  |
      | orgReader | 65313 |
    @sanity @Teams @sysReader @Scenario17
    Examples:
      | role      | tcId  |
      | sysReader | 65312 |
    @sanity @Teams @teamAdmin @Scenario17
    Examples:
      | role      | tcId  |
      | teamAdmin | 65311 |


  Scenario Outline: Teams | verify teams column modal info for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on Teams column and verify modal info for "<role>" user

    @sanity @Teams @member @Scenario18
    Examples:
      | role   | tcId  |
      | member | 65330 |
    @sanity @Teams @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 65318 |
    @sanity @Teams @orgReader @Scenario18
    Examples:
      | role      | tcId  |
      | orgReader | 65327 |
    @sanity @Teams @sysReader @Scenario18
    Examples:
      | role      | tcId  |
      | sysReader | 65324 |
    @sanity @Teams @teamAdmin @Scenario18
    Examples:
      | role      | tcId  |
      | teamAdmin | 65321 |


  Scenario Outline: Teams | verify members column modal info for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on Members column and verify modal info for "<role>" user

    @sanity @Teams @member @Scenario19
    Examples:
      | role   | tcId  |
      | member | 65331 |
    @sanity @Teams @orgAdmin @Scenario19
    Examples:
      | role     | tcId  |
      | orgAdmin | 65319 |
    @sanity @Teams @orgReader @Scenario19
    Examples:
      | role      | tcId  |
      | orgReader | 65328 |
    @sanity @Teams @sysReader @Scenario19
    Examples:
      | role      | tcId  |
      | sysReader | 65325 |
    @sanity @Teams @teamAdmin @Scenario19
    Examples:
      | role      | tcId  |
      | teamAdmin | 65322 |


  Scenario Outline: Teams | verify sites column modal info for multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on Sites column and verify modal info for "<role>" user

    @sanity @Teams @member @Scenario20
    Examples:
      | role   | tcId  |
      | member | 65332 |
    @sanity @Teams @orgAdmin @Scenario20
    Examples:
      | role     | tcId  |
      | orgAdmin | 65320 |
    @sanity @Teams @orgReader @Scenario20
    Examples:
      | role      | tcId  |
      | orgReader | 65329 |
    @sanity @Teams @sysReader @Scenario20
    Examples:
      | role      | tcId  |
      | sysReader | 65326 |
    @sanity @Teams @teamAdmin @Scenario20
    Examples:
      | role      | tcId  |
      | teamAdmin | 65323 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68185
  Scenario Outline: Teams | Verify content of the "Assigned" modal info of Devices banner
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on assigned devices modal and verify title and description
    @sanity @Teams @orgAdmin @Scenario21
    Examples:
      | role     | tcId  |
      | orgAdmin | 68185 |
    @sanity @Teams @member @Scenario21
    Examples:
      | role   | tcId  |
      | member | 68185 |
    @sanity @Teams @teamAdmin @Scenario21
    Examples:
      | role      | tcId  |
      | teamAdmin | 68185 |
    @sanity @Teams @orgReader @Scenario21
    Examples:
      | role      | tcId  |
      | orgReader | 68185 |
    @sanity @Teams @sysReader @Scenario21
    Examples:
      | role      | tcId  |
      | sysReader | 68185 |
#  https://arabletestrail.testrail.io/index.php?/cases/view/68186
  Scenario Outline: Teams | Verify the functionality of Unassigned devices functionality in Teams banner
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify unassigned Devices modal feature opens if the count is not zero for "<role>"
    Then verify teams shown in dropdown is matching with the teams list shown on Teams page for "<role>"
    And verify whether the device shown inside the team in which it was added for team for "<role>"
    Then verify the banner count has changed for Assigned & Unassigned after selecting the team for a device for "<role>"
    And verify the stats api count is matching with the device banner count for "<role>"
    And verify whether the device is showing under unassigned modal after removing from the team which was selected earlier for "<role>"
    Then verify the banner count has changed for Assigned & Unassigned after removing the device from the team for "<role>"
    And verify the stats api count is matching with the device banner count for "<role>"
    @sanity @Teams @orgAdmin @Scenario22
    Examples:
      | role     | tcId  |
      | orgAdmin | 68186 |
    @sanity @Teams @member @Scenario22
    Examples:
      | role   | tcId  |
      | member | 68186 |
    @sanity @Teams @teamAdmin @Scenario22
    Examples:
      | role      | tcId  |
      | teamAdmin | 68186 |
    @sanity @Teams @orgReader @Scenario22
    Examples:
      | role      | tcId  |
      | orgReader | 68186 |
    @sanity @Teams @sysReader @Scenario22
    Examples:
      | role      | tcId  |
      | sysReader | 68186 |


#  https://arabletestrail.testrail.io/index.php?/cases/view/68186
  Scenario Outline: Teams | Verify the functionality of Unassigned devices functionality in Teams banner
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    And click on unassigned devices modal and verify title and description for "<role>"
    Then verify whether the teams dropdown gets opened for any device in unassigned modal for "<role>"
    @sanity @Teams @orgAdmin @Scenario23
    Examples:
      | role     | tcId  |
      | orgAdmin | 68186 |
    @sanity @Teams @member @Scenario23
    Examples:
      | role   | tcId  |
      | member | 68186 |
    @sanity @Teams @teamAdmin @Scenario23
    Examples:
      | role      | tcId  |
      | teamAdmin | 68186 |
    @sanity @Teams @orgReader @Scenario23
    Examples:
      | role      | tcId  |
      | orgReader | 68186 |
    @sanity @Teams @sysReader @Scenario23
    Examples:
      | role      | tcId  |
      | sysReader | 68186 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68187
  Scenario Outline: Teams | Verify if count shown in banners are matching with the count shown in stats api
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify the stats api & banners count
    @sanity @Teams @orgAdmin @Scenario24
    Examples:
      | role     | tcId  |
      | orgAdmin | 68187 |
    @sanity @Teams @member @Scenario24
    Examples:
      | role   | tcId  |
      | member | 68187 |
    @sanity @Teams @teamAdmin @Scenario24
    Examples:
      | role      | tcId  |
      | teamAdmin | 68187 |
    @sanity @Teams @orgReader @Scenario24
    Examples:
      | role      | tcId  |
      | orgReader | 68187 |
    @sanity @Teams @sysReader @Scenario24
    Examples:
      | role      | tcId  |
      | sysReader | 68187 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68188
  Scenario Outline: Teams | verify stats on switching orgs from global org dropdown.
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify the stats api & banner counts before switching the organization
    And click on org dropdown and Switch to different organization
    Then verify the count in Banners & in stats api call with respect to orgName
    @sanity @Teams @orgAdmin @Scenario25
    Examples:
      | role     | tcId  |
      | orgAdmin | 68188 |
    @sanity @Teams @member @Scenario25
    Examples:
      | role   | tcId  |
      | member | 68188 |
    @sanity @Teams @teamAdmin @Scenario25
    Examples:
      | role      | tcId  |
      | teamAdmin | 68188 |
    @sanity @Teams @orgReader @Scenario25
    Examples:
      | role      | tcId  |
      | orgReader | 68188 |
    @sanity @Teams @sysReader @Scenario25
    Examples:
      | role      | tcId  |
      | sysReader | 68188 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68189
  Scenario Outline: Teams | verify stats on switching teams from global teams dropdown
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    And verify the stats api & banner counts before switching the team
    And click on Teams dropdown and Switch for different team
    Then verify the count in Banners & in stats api call with respect to team
    @sanity @Teams @orgAdmin @Scenario26
    Examples:
      | role     | tcId  |
      | orgAdmin | 68189 |
    @sanity @Teams @member @Scenario26
    Examples:
      | role   | tcId  |
      | member | 68189 |
    @sanity @Teams @teamAdmin @Scenario26
    Examples:
      | role      | tcId  |
      | teamAdmin | 68189 |
    @sanity @Teams @orgReader @Scenario26
    Examples:
      | role      | tcId  |
      | orgReader | 68189 |
    @sanity @Teams @sysReader @Scenario26
    Examples:
      | role      | tcId  |
      | sysReader | 68189 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68191
  Scenario Outline: Teams | Verify the Teams list shown on Teams page is matching with the Teams list shown in global Teams dropdown
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    And verify the Teams list shown on Teams page is matching with the Teams list shown in global Teams dropdown
    @sanity @Teams @orgAdmin @Scenario27
    Examples:
      | role     | tcId  |
      | orgAdmin | 68191 |
    @sanity @Teams @member @Scenario27
    Examples:
      | role   | tcId  |
      | member | 68191 |
    @sanity @Teams @teamAdmin @Scenario27
    Examples:
      | role      | tcId  |
      | teamAdmin | 68191 |
    @sanity @Teams @orgReader @Scenario27
    Examples:
      | role      | tcId  |
      | orgReader | 68191 |
    @sanity @Teams @sysReader @Scenario27
    Examples:
      | role      | tcId  |
      | sysReader | 68191 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68190
  Scenario Outline: Teams | Verify that on clicking "Edit Team" Btn the api call is called once's in network tab and after clicking on confirm btn it is calling twice in network tab
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    And click on view team shows edit button based on the user "<role>"
    Then click on edit team for any team based on "<role>"
    Then click on confirm button for Edit Team in the open modal to verify the number of times API is called for user "<role>"
    @sanity @Teams @orgAdmin @Scenario28
    Examples:
      | role     | tcId  |
      | orgAdmin | 68190 |
    @sanity @Teams @member @Scenario28
    Examples:
      | role   | tcId  |
      | member | 68190 |
    @sanity @Teams @teamAdmin @Scenario28
    Examples:
      | role      | tcId  |
      | teamAdmin | 68190 |
    @sanity @Teams @orgReader @Scenario28
    Examples:
      | role      | tcId  |
      | orgReader | 68190 |
    @sanity @Teams @sysReader @Scenario28
    Examples:
      | role      | tcId  |
      | sysReader | 68190 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68190
  Scenario Outline: Teams | Verify that on clicking "Edit Member" Btn the api call is called once's in network tab and after clicking on confirm btn it is calling twice in network tab
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    And click on view team shows edit button based on the user "<role>"
    And click on a edit member for "<role>"
    Then click on confirm button for Edit member in the open modal to verify the number of times API is called for user "<role>"
    @sanity @Teams @orgAdmin @Scenario29
    Examples:
      | role     | tcId  |
      | orgAdmin | 68190 |
    @sanity @Teams @member @Scenario29
    Examples:
      | role   | tcId  |
      | member | 68190 |
    @sanity @Teams @teamAdmin @Scenario29
    Examples:
      | role      | tcId  |
      | teamAdmin | 68190 |
    @sanity @Teams @orgReader @Scenario29
    Examples:
      | role      | tcId  |
      | orgReader | 68190 |
    @sanity @Teams @sysReader @Scenario29
    Examples:
      | role      | tcId  |
      | sysReader | 68190 |


  # https://arabletestrail.testrail.io/index.php?/cases/view/68176
  Scenario Outline: Teams |(C68176)Verify if new team can be created with members,devices & sites
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then verify that on landing on the Teams page three API calls stats, teams, and users should be called and shown in the network tab
    And click on Create New Team button for the role"<role>"
    Then enter the details of team "1" in the Create New Team popup page for the role "<role>"
    And click on the confirm button in the Create New Team page for the role "<role>"
    Then verify the api in teams page for the role "<role>"
    @sanity @Teams @orgAdmin @Scenario30
    Examples:
      | role     | tcId  |
      | orgAdmin | 68176 |
    @sanity @Teams @teamAdmin @Scenario30
    Examples:
      | role      | tcId  |
      | teamAdmin | 68176 |
    @sanity @Teams @member @Scenario30
    Examples:
      | role   | tcId  |
      | member | 68176 |
    @sanity @Teams @orgReader @Scenario30
    Examples:
      | role      | tcId  |
      | orgReader | 68176 |
    @sanity @Teams @sysReader @Scenario30
    Examples:
      | role      | tcId  |
      | sysReader | 68176 |


# https://arabletestrail.testrail.io/index.php?/cases/view/68177
  Scenario Outline: Teams |(C68177) Verify "View Team" data for the newly created team
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    And click on Create New Team button for the role"<role>"
    Then enter the details of team "2" in the Create New Team popup page for the role "<role>"
    And click on the confirm button in the Create New Team page for the role "<role>"
    And click on View Teams of newly created team "2" for the role "<role>"
    Then verify the data in the newly created team is correct for the role "<role>"
    @sanity @Teams @orgAdmin @Scenario31
    Examples:
      | role     | tcId   |
      | orgAdmin | C68177 |
    @sanity @Teams @member @Scenario31
    Examples:
      | role   | tcId  |
      | member | 68177 |
    @sanity @Teams @teamAdmin @Scenario31
    Examples:
      | role      | tcId  |
      | teamAdmin | 68177 |
    @sanity @Teams @orgReader @Scenario31
    Examples:
      | role      | tcId  |
      | orgReader | 68177 |
    @sanity @Teams @sysReader @Scenario31
    Examples:
      | role      | tcId  |
      | sysReader | 68177 |


# https://arabletestrail.testrail.io/index.php?/cases/view/68178
  Scenario Outline: Teams|(C68178)Verify data after Editing Team for the newly created team
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    And click on Create New Team button for the role"<role>"
    Then enter the details of team "3" in the Create New Team popup page for the role "<role>"
    And click on the confirm button in the Create New Team page for the role "<role>"
    And click on View Teams of newly created team "3" for the role "<role>"
    Then edit the team name for the role "<role>"
    Then navigate to the tags shown below the Add members, Add devices, Add sites and click on cross button for one in each options for the role "<role>"
    And verify confirmation toast message for the role "<role>"
    Then verify the api in teams page for the role "<role>"
    And verify that after clicking on the confirm button the old teamName should not display on the team list for the role "<role>"
    When click on View Teams on the edited Team name for the role "<role>"
    And verify the modified data for the role "<role>"
    Then verify the number displayed in the teams page matches the actual count for the role "<role>"
    @sanity @Teams @orgAdmin @Scenario32
    Examples:
      | role     | tcId  |
      | orgAdmin | 68178 |
    @sanity @Teams @member @Scenario32
    Examples:
      | role   | tcId  |
      | member | 68178 |
    @sanity @Teams @teamAdmin @Scenario32
    Examples:
      | role      | tcId  |
      | teamAdmin | 68178 |
    @sanity @Teams @orgReader @Scenario32
    Examples:
      | role      | tcId  |
      | orgReader | 68178 |
    @sanity @Teams @sysReader @Scenario32
    Examples:
      | role      | tcId  |
      | sysReader | 68178 |


#  https://arabletestrail.testrail.io/index.php?/cases/view/68179 this needs to run together with 68176 and with the old user(vishal.gupta+teamadmin@arable.com)
  Scenario Outline: Teams|(C68179) Verify Edit member role functionality
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on View Teams of newly created team "1" for the role "<role>"
    Then verify that the user can click on the Edit Role icon for the role "<role>"
    And verify the pop-up message when user selects more than five teams and also select team "1" for the "<role>"
    Then verify that the add teams option is displayed or not for the role "<role>"
    And  verify confirmation toast message after modifying member for the role "<role>"
    When navigate to the team "1" for the role "<role>"
    Then verify the new role should reflect for the user for the role "<role>"
    @sanity @Teams @orgAdmin @Scenario33
    Examples:
      | role     | tcId  |
      | orgAdmin | 68179 |
    @sanity @Teams @teamAdmin @Scenario33
    Examples:
      | role      | tcId  |
      | teamAdmin | 68179 |
    @sanity @Teams @member @Scenario33
    Examples:
      | role   | tcId  |
      | member | 68179 |
    @sanity @Teams @sysReader @Scenario33
    Examples:
      | role      | tcId  |
      | sysReader | 68179 |
    @sanity @Teams @orgReader @Scenario33
    Examples:
      | role      | tcId  |
      | orgReader | 68179 |


  # https://arabletestrail.testrail.io/index.php?/cases/view/68181  this needs to run together with 68176 and 68177
  Scenario Outline: Teams|(C68181)Verify Inviting New member functionality and verifying it in Pending Invites
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on Invite Member button for the "<role>"
    When the modal is open, fill in the data in all fields, including email ID "1", and select team "1" and team "2" for the role "<role>"
    Then verify whether the new invitations were sent to the user or not for role "<role>"
    And verify Sent modal should appear with all the details and also with two options Yes & No for role "<role>"
    And verify "invite another" invite option for the role "<role>"
    And verify the Pending Invites for new user email ID "1" in the team "1" and team "2" for the role "<role>"
    @sanity @Teams @orgAdmin @Scenario34
    Examples:
      | role     | tcId  |
      | orgAdmin | 68181 |
    @sanity @Teams @teamAdmin @Scenario34
    Examples:
      | role      | tcId  |
      | teamAdmin | 68181 |
    @sanity @Teams @member @Scenario34
    Examples:
      | role   | tcId  |
      | member | 68181 |
    @sanity @Teams @sysReader @Scenario34
    Examples:
      | role      | tcId  |
      | sysReader | 68181 |
    @sanity @Teams @orgReader @Scenario34
    Examples:
      | role      | tcId  |
      | orgReader | 68181 |

  #  https://arabletestrail.testrail.io/index.php?/cases/view/68181  this needs to run together with 68176 and 68177
  Scenario Outline: Teams|(C68181) Verify Inviting New member functionality and verifying it in Pending Invites
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on Invite Member button for the "<role>"
    When the modal is open, fill in the data in all fields, including email ID "1", and select team "1" and team "2" for the role "<role>"
    Then verify whether the new invitations were sent to the user or not for role "<role>"
    And verify Sent modal should appear with all the details and also with two options Yes & No for role "<role>"
    And verify "No" invite option for the role "<role>"
    And verify the Pending Invites for new user email ID "1" in the team "1" and team "2" for the role "<role>"
    @sanity @Teams @orgAdmin @Scenario35
    Examples:
      | role     | tcId  |
      | orgAdmin | 68181 |
    @sanity @Teams @teamAdmin @Scenario35
    Examples:
      | role      | tcId  |
      | teamAdmin | 68181 |
    @sanity @Teams @member @Scenario35
    Examples:
      | role   | tcId  |
      | member | 68181 |
    @sanity @Teams @sysReader @Scenario35
    Examples:
      | role      | tcId  |
      | sysReader | 68181 |
    @sanity @Teams @orgReader @Scenario35
    Examples:
      | role      | tcId  |
      | orgReader | 68181 |


#  https://arabletestrail.testrail.io/index.php?/cases/view/68182  this needs to run together with 68176 and 68177
  Scenario Outline: Teams|(C68182) Verify Inviting Current member functionality and verifying it in Pending Invites
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on Invite Member button for the "<role>"
    And switch the tab to Current. Once the modal opens, fill in the details in all the fields, member "1" and select role,team "1" and team "2" for the role "<role>"
    Then verify whether the new invitations were sent to the user or not for role "<role>"
    And verify Sent modal should appear with all the details and also with two options Yes & No for role "<role>"
    And verify "invite another" invite option for the role "<role>"
    And verify the pending invites for the current user for member"1" in the team"1" and team"2" for the role "<role>"
    @sanity @Teams @orgAdmin @Scenario36
    Examples:
      | role     | tcId  |
      | orgAdmin | 68182 |
    @sanity @Teams @teamAdmin @Scenario36
    Examples:
      | role      | tcId  |
      | teamAdmin | 68182 |
    @sanity @Teams @member @Scenario36
    Examples:
      | role   | tcId  |
      | member | 68182 |
    @sanity @Teams @sysReader @Scenario36
    Examples:
      | role      | tcId  |
      | sysReader | 68182 |
    @sanity @Teams @orgReader @Scenario36
    Examples:
      | role      | tcId  |
      | orgReader | 68182 |

#  https://arabletestrail.testrail.io/index.php?/cases/view/68182 this needs to run together with 68176 and 68177
  Scenario Outline: Teams|(C68182) Verify Inviting Current member functionality and verifying it in Pending Invites
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on Invite Member button for the "<role>"
    And switch the tab to Current. Once the modal opens, fill in the details in all the fields, member "2" and select role,team "1" and team "2" for the role "<role>"
    Then verify whether the new invitations were sent to the user or not for role "<role>"
    And verify Sent modal should appear with all the details and also with two options Yes & No for role "<role>"
    And verify "No" invite option for the role "<role>"
    And verify the pending invites for the current user for member"2" in the team"1" and team"2" for the role "<role>"
    @sanity @Teams @orgAdmin @Scenario37
    Examples:
      | role     | tcId  |
      | orgAdmin | 68182 |
    @sanity @Teams @teamAdmin @Scenario37
    Examples:
      | role      | tcId  |
      | teamAdmin | 68182 |
    @sanity @Teams @member @Scenario37
    Examples:
      | role   | tcId  |
      | member | 68182 |
    @sanity @Teams @sysReader @Scenario37
    Examples:
      | role      | tcId  |
      | sysReader | 68182 |
    @sanity @Teams @orgReader @Scenario37
    Examples:
      | role      | tcId  |
      | orgReader | 68182 |


#  https://arabletestrail.testrail.io/index.php?/cases/view/68183
  Scenario Outline: Teams |(C68183) Verify "Send Again" & "Send All Again" functionality in "Pending Invites" modal
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When navigate to "Teams"
    Then click on Pending Invites in view team for "<role>"
    @sanity @Teams @orgAdmin @Scenario38
    Examples:
      | role     | tcId  |
      | orgAdmin | 68183 |
    @sanity @Teams @teamAdmin @Scenario38
    Examples:
      | role      | tcId  |
      | teamAdmin | 68183 |
    @sanity @Teams @member @Scenario38
    Examples:
      | role   | tcId  |
      | member | 68183 |
    @sanity @Teams @sysReader @Scenario38
    Examples:
      | role      | tcId  |
      | sysReader | 68183 |
    @sanity @Teams @orgReader @Scenario38
    Examples:
      | role      | tcId  |
      | orgReader | 68183 |

