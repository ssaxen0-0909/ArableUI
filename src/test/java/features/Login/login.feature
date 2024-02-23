Feature: Login

  Scenario Outline: Login | verify login with Invalid credentials
    Given assign testcase "<tcId>" to log data to TestRail
    Then entered invalid email & password and click on Login button

    @sanity @Login @orgAdmin @Scenario1
    Examples:
      | tcId  |
      | 58971 |


  Scenario Outline: Login | verify 90 days checkbox is checked
    Given assign testcase "<tcId>" to log data to TestRail
    Then on login page verify ninety days checkbox is checked

    @sanity @Login @orgAdmin @Scenario2
    Examples:
      | tcId  |
      | 58973 |


  Scenario Outline: Login | verify all titles on login page
    Given assign testcase "<tcId>" to log data to TestRail
    Then on login page verify all titles on login page

    @sanity @Login @orgAdmin @Scenario3
    Examples:
      | tcId  |
      | 58970 |


  Scenario Outline: Login | verify login with valid credentials with multiple "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with valid credential for different "<role>" user

    @sanity @Login @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 58972 |
    @sanity @Login @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 58972 |
    @sanity @Login @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 58972 |
    @sanity @Login @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 58972 |
    @sanity @Login @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 58972 |
