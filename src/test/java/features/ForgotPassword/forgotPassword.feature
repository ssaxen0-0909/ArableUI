Feature: Forgot Password

  @sanity @orgAdmin @ForgotPassword
  Scenario Outline: Forgot Password | verify Forgot Password is displayed on login page
    Given assign testcase "<tcId>" to log data to TestRail
    Then on login page verify Forgot Password is displayed on login page

    Examples:
      | tcId  |
      | 59155 |

  @sanity @orgAdmin @ForgotPassword
  Scenario Outline: Forgot Password | verify Forgot Your Password page contents
    Given assign testcase "<tcId>" to log data to TestRail
    Then on login page click forgot password and verify Forgot Your Password page contents

    Examples:
      | tcId  |
      | 59156 |


  Scenario Outline: Forgot Password | verify resetting password
    Given assign testcase "<tcId>" to log data to TestRail
    When on login page click forgot password and enter the emailId & click on Reset button

    Examples:
      | tcId  |
      | 59157 |

  Scenario Outline: Forgot Password | verify clicking on Back to Login button
    Given assign testcase "<tcId>" to log data to TestRail
    When on forgot password page then enter the emailId & click on Reset button and verify clicking on Back to Login button

    Examples:
      | tcId  |
      | 59158 |
