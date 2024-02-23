Feature: Distributor Page Functionality

  Scenario Outline: Distributor | navigate to page with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then verify create new org button is displayed for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario1
    Examples:
      | role     | tcId  |
      | orgAdmin | 65336 |

  Scenario Outline: Distributor | verify Create new org modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then verify Create new org modal for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 65335 |

  Scenario Outline: Distributor | verify assigned devices modal info with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned and verify modal info for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario3
    Examples:
      | role     | tcId  |
      | orgAdmin | 64275 |


  Scenario Outline: Distributor | verify unassigned devices modal info with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned and verify modal info for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 64274 |


  Scenario Outline: Distributor | verify table column headers info with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then verify table column headers for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 65334 |


  Scenario Outline: Distributor | verify org details info with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on plus icon and verify org details for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 65333 |

  Scenario Outline: Distributor | verify search devices option under Assigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify search field for devices for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 68579 |

  Scenario Outline: Distributor | verify search devices option under Unassigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify search field for devices for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 68591 |

  Scenario Outline: Distributor | verify search devices functionality with three letters under Assigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify search functionality with three letters for devices for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 68580 |

  Scenario Outline: Distributor | verify search devices functionality with three letters under Unassigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify search functionality with three letters for devices for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 68592 |

  Scenario Outline: Distributor | verify search devices functionality under Assigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify search functionality for devices for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 68584 |

  Scenario Outline: Distributor | verify search devices functionality under Unassigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify search functionality for devices for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 68596 |

  Scenario Outline: Distributor | verify if search devices functionality is case sensitive under Assigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify search functionality for devices is case sensitive for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 68583 |

  Scenario Outline: Distributor | verify search devices functionality is case sensitive under Unassigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify search functionality for devices is case sensitive for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 68595 |

  Scenario Outline: Distributor | verify searching invalid device id under Assigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify searching invalid device id for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 68582 |

  Scenario Outline: Distributor | verify searching invalid device id under Unassigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify searching invalid device id for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 68594 |

  Scenario Outline: Distributor | verify selected device is retaining after search in assigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify selected device is retaining after search for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 68590 |

  Scenario Outline: Distributor | verify selected device is retaining after search in unassigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify selected device is retaining after search for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 68602 |

  Scenario Outline: Distributor | verify device list for source org in assigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify device list for source org for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario19
    Examples:
      | role     | tcId  |
      | orgAdmin | 68588 |

  Scenario Outline: Distributor | verify device list for source org in unassigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify device list for source org for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario20
    Examples:
      | role     | tcId  |
      | orgAdmin | 68600 |

  Scenario Outline: Distributor | verify search error message in assigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify search error message for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario21
    Examples:
      | role     | tcId  |
      | orgAdmin | 69381 |

  Scenario Outline: Distributor | verify search error message in unassigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify search error message for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario22
    Examples:
      | role     | tcId  |
      | orgAdmin | 69382 |

  Scenario Outline: Distributor | verify clearing search results in assigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify clearing search results for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario23
    Examples:
      | role     | tcId  |
      | orgAdmin | 69383 |

  Scenario Outline: Distributor | verify clearing search results in unassigned modal with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify clearing search results for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario24
    Examples:
      | role     | tcId  |
      | orgAdmin | 69384 |

  Scenario Outline: Distributor |Each org contains the total number of devices and members assigned to that org with "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then verify each org details in table for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario25
    Examples:
      | role     | tcId  |
      | orgAdmin | 69385 |

  Scenario Outline: Distributor | When a user clicks on a + sign, the list of assigned devices should appear "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on plus icon and verify device list and scroll bar for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario26
    Examples:
      | role     | tcId  |
      | orgAdmin | 69386 |

  Scenario Outline: If the source drop down list on the assigned device page, contains more than 10 names, the list should have a scroll bar for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and verify the scroll bar in device list for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario27
    Examples:
      | role     | tcId  |
      | orgAdmin | 60460 |

  Scenario Outline: If the source drop down list on the unassigned device page, contains more than 10 names, the list should have a scroll bar for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and verify the scroll bar in device list for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario28
    Examples:
      | role     | tcId  |
      | orgAdmin | 60482 |

  Scenario Outline: We can not enter the duplicate name on the organization field, if enter error message should be appear for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on create new org button & enter duplicate name and click on confirm button for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario29
    Examples:
      | role     | tcId  |
      | orgAdmin | 60433 |

  Scenario Outline: If the user clicks on the org name text field, an information message for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on create new org button & enter name and clear it for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario30
    Examples:
      | role     | tcId  |
      | orgAdmin | 60813 |

  Scenario Outline: When selected source drop-down, the list of unassigned devices should be displayed for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on create new org button & select the source org for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario31 @TBD
    Examples:
      | role     | tcId  |
      | orgAdmin | 60580 |

  Scenario Outline: Org text field should accept capital letter for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on create new org button &enter the org name in capitals for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario32
    Examples:
      | role     | tcId  |
      | orgAdmin | 60589 |

  Scenario Outline: The source and destination drop down lists on the assigned device page should be open in alphabetical order for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and check the contents of source and destination for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario33
    Examples:
      | role     | tcId  |
      | orgAdmin | 60462 |

  Scenario Outline: When the user selects all of the required fields, than only Return button should be enabled for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and select source and destination and select device for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario34
    Examples:
      | role     | tcId  |
      | orgAdmin | 60477 |

  Scenario Outline: The source and destination drop down lists on the unassigned device page should be open in alphabetical order for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and check the contents of source and destination for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario35
    Examples:
      | role     | tcId  |
      | orgAdmin | 60461 |

  Scenario Outline: We can select a n number of devices at once for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and select multiple devices for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario36
    Examples:
      | role     | tcId  |
      | orgAdmin | 60543 |

  Scenario Outline: When a user clicks on any of the selected devices in the unassigned device model, the device name button should be deselected for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and select device & then deselect it for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario37
    Examples:
      | role     | tcId  |
      | orgAdmin | 60471 |

  Scenario Outline: Outer line should be blue when hovering over the 'Assign' and 'Cancel' buttons in the Unassigned device model for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and hover over Cancel btn for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario38
    Examples:
      | role     | tcId  |
      | orgAdmin | 60428 |

  Scenario Outline: Outer line should be blue when hovering over the 'Assign' and 'Cancel' buttons in the assigned device model for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and hover over Cancel btn for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario39
    Examples:
      | role     | tcId  |
      | orgAdmin | 60429 |

  Scenario Outline: Returning devices from the assigned device model for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and select device and click on return for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario40
    Examples:
      | role     | tcId  |
      | orgAdmin | 60814 |

  Scenario Outline: Assigning devices from the unassigned device model for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on unassigned modal and select device and click on assign for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario41
    Examples:
      | role     | tcId  |
      | orgAdmin | 60468 |

  Scenario Outline:In the assigned device page, users can view the devices associated to the specific organization for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    When clicked on settings icon and navigate to "Distributor" page
    Then click on assigned modal and select device and verify the devices count for "<role>" user

    @sanity @Distributor @orgAdmin @Scenario42
    Examples:
      | role     | tcId  |
      | orgAdmin | 69654 |

#  @Distributor
#    @sanity
#  Scenario Outline: Distributor | verify editing org name with "<role>" user
#    Given assign testcase "<tcId>" to log data to TestRail
#    Given log into application with a "<role>" user
#    When clicked on settings icon and navigate to "Distributor" page
#    Then click on plus icon and verify editing org name for "<role>" user
#
#    Examples:
#      | role     | tcId  |
#      | orgAdmin | 64273 |