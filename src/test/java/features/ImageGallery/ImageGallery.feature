Feature: ImageGallery

  Scenario Outline: Vision | Verify vision page loading text for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify page loading text for "<role>" user.

    @sanity @Vision @member
    Examples:
      | role   | tcId  |
      | member | 67266 |
    @sanity @Vision @orgAdmin @Scenario2
    Examples:
      | role     | tcId  |
      | orgAdmin | 67266 |
    @sanity @Vision @orgReader
    Examples:
      | role      | tcId  |
      | orgReader | 67266 |
    @sanity @Vision @sysReader
    Examples:
      | role      | tcId  |
      | sysReader | 67266 |
    @sanity @Vision @teamAdmin
    Examples:
      | role      | tcId  |
      | teamAdmin | 67266 |

  Scenario Outline: Vision | Verify scrolling to the last image in gallery view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then click on thumbnail and verify scrolling to the last image in gallery view for "<role>" user.

    @sanity @Vision @member @Scenario3
    Examples:
      | role   | tcId  |
      | member | 66192 |
    @sanity  @orgAdmin @Scenario3 @Vision
    Examples:
      | role     | tcId  |
      | orgAdmin | 66192 |
    @sanity @Vision @orgReader @Scenario3
    Examples:
      | role      | tcId  |
      | orgReader | 66192 |
    @sanity @Vision @sysReader @Scenario3
    Examples:
      | role      | tcId  |
      | sysReader | 66192 |
    @sanity @Vision @teamAdmin @Scenario3
    Examples:
      | role      | tcId  |
      | teamAdmin | 66192 |

  Scenario Outline: Vision | Verify default filter selected for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify default filter selected for "<role>" user.

    @sanity @Vision @member @Scenario4
    Examples:
      | role   | tcId  |
      | member | 66227 |
    @sanity @Vision @orgAdmin @Scenario4
    Examples:
      | role     | tcId  |
      | orgAdmin | 66227 |
    @sanity @Vision @orgReader @Scenario4
    Examples:
      | role      | tcId  |
      | orgReader | 66227 |
    @sanity @Vision @sysReader @Scenario4
    Examples:
      | role      | tcId  |
      | sysReader | 66227 |
    @sanity @Vision @teamAdmin @Scenario4
    Examples:
      | role      | tcId  |
      | teamAdmin | 66227 |

  Scenario Outline: Vision | Verify filter options in filter dropdown for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify filter options in filter dropdown for "<role>" user.

    @sanity @Vision @member @Scenario5
    Examples:
      | role   | tcId  |
      | member | 66154 |
    @sanity @Vision @orgAdmin @Scenario5
    Examples:
      | role     | tcId  |
      | orgAdmin | 66154 |
    @sanity @Vision @orgReader @Scenario5
    Examples:
      | role      | tcId  |
      | orgReader | 66154 |
    @sanity @Vision @sysReader @Scenario5
    Examples:
      | role      | tcId  |
      | sysReader | 66154 |
    @sanity @Vision @teamAdmin @Scenario5
    Examples:
      | role      | tcId  |
      | teamAdmin | 66154 |

  Scenario Outline: Vision | Verify default deployment selected in dropdown for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify default deployment selected in dropdown for "<role>" user.

    @sanity @Vision @member @Scenario6
    Examples:
      | role   | tcId  |
      | member | 66151 |
    @sanity @Vision @orgAdmin @Scenario6
    Examples:
      | role     | tcId  |
      | orgAdmin | 66151 |
    @sanity @Vision @orgReader @Scenario6
    Examples:
      | role      | tcId  |
      | orgReader | 66151 |
    @sanity @Vision @sysReader @Scenario6
    Examples:
      | role      | tcId  |
      | sysReader | 66151 |
    @sanity @Vision @teamAdmin @Scenario6
    Examples:
      | role      | tcId  |
      | teamAdmin | 66151 |

  Scenario Outline: Vision | Verify historical deployments if present,are shown in dropdown for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify historical deployments if present,are shown in dropdown for "<role>" user.

    @sanity @Vision @member @Scenario7
    Examples:
      | role   | tcId  |
      | member | 66150 |
    @sanity @Vision @orgAdmin @Scenario7
    Examples:
      | role     | tcId  |
      | orgAdmin | 66150 |
    @sanity @Vision @orgReader @Scenario7
    Examples:
      | role      | tcId  |
      | orgReader | 66150 |
    @sanity @Vision @sysReader @Scenario7
    Examples:
      | role      | tcId  |
      | sysReader | 66150 |
    @sanity @Vision @teamAdmin @Scenario7
    Examples:
      | role      | tcId  |
      | teamAdmin | 66150 |

  Scenario Outline: Vision | Verify single image archiving for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify archiving of single image for "<role>" user.

    @sanity @Vision @member @Scenario8
    Examples:
      | role   | tcId  |
      | member | 66165 |
    @sanity @Vision @orgAdmin @Scenario8
    Examples:
      | role     | tcId  |
      | orgAdmin | 66165 |
    @sanity @Vision @orgReader @Scenario8
    Examples:
      | role      | tcId  |
      | orgReader | 66165 |
    @sanity @Vision @sysReader @Scenario8
    Examples:
      | role      | tcId  |
      | sysReader | 66165 |
    @sanity @Vision @teamAdmin @Scenario8
    Examples:
      | role      | tcId  |
      | teamAdmin | 66165 |

  Scenario Outline: Vision | Verify archiving 10 Images for Last 10 days for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify archiving all Images for "<role>" user.

    @sanity @Vision @member @Scenario9
    Examples:
      | role   | tcId  |
      | member | 66166 |
    @sanity @Vision @orgAdmin @Scenario9
    Examples:
      | role     | tcId  |
      | orgAdmin | 66166 |
    @sanity @Vision @orgReader @Scenario9
    Examples:
      | role      | tcId  |
      | orgReader | 66166 |
    @sanity @Vision @sysReader @Scenario9
    Examples:
      | role      | tcId  |
      | sysReader | 66166 |
    @sanity @Vision @teamAdmin @Scenario9
    Examples:
      | role      | tcId  |
      | teamAdmin | 66166 |

  Scenario Outline: Vision | Verify restoring 10 Images from Archived page for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify restoring all Images from Archived page for "<role>" user.

    @sanity @Vision @member @Scenario10
    Examples:
      | role   | tcId  |
      | member | 66220 |
    @sanity @Vision @orgAdmin11 @Scenario10
    Examples:
      | role     | tcId  |
      | orgAdmin | 66220 |
    @sanity @Vision @orgReader @Scenario10
    Examples:
      | role      | tcId  |
      | orgReader | 66220 |
    @sanity @Vision @sysReader @Scenario10
    Examples:
      | role      | tcId  |
      | sysReader | 66220 |
    @sanity @Vision @teamAdmin @Scenario10
    Examples:
      | role      | tcId  |
      | teamAdmin | 66220 |

  Scenario Outline: Vision | Verify download icon displaying below thumbnails text for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify page loading text for "<role>" user.
    Then verify download icon displaying below thumbnails for "<role>" user.

    @sanity @Vision @member
    Examples:
      | role   | tcId  |
      | member | 66171 |
    @sanity @Vision @orgAdmin @Scenario11
    Examples:
      | role     | tcId  |
      | orgAdmin | 66171 |
    @sanity @Vision @orgReader
    Examples:
      | role      | tcId  |
      | orgReader | 66171 |
    @sanity @Vision @sysReader
    Examples:
      | role      | tcId  |
      | sysReader | 66171 |
    @sanity @Vision @teamAdmin
    Examples:
      | role      | tcId  |
      | teamAdmin | 66171 |

  Scenario Outline: Vision | Verify restoring a single image from Archived page for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify restoring a single image from Archived page for "<role>" user.

    @sanity @Vision @member @Scenario12
    Examples:
      | role   | tcId  |
      | member | 67329 |
    @sanity @Vision @orgAdmin @Scenario12
    Examples:
      | role     | tcId  |
      | orgAdmin | 67329 |
    @sanity @Vision @orgReader @Scenario12
    Examples:
      | role      | tcId  |
      | orgReader | 67329 |
    @sanity @Vision @sysReader @Scenario12
    Examples:
      | role      | tcId  |
      | sysReader | 67329 |
    @sanity @Vision @teamAdmin @Scenario12
    Examples:
      | role      | tcId  |
      | teamAdmin | 67329 |

  Scenario Outline: Vision | Verify backward scrolling in gallery view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify backward scrolling in gallery view for "<role>" user.

    @sanity @Vision @member @Scenario13
    Examples:
      | role   | tcId  |
      | member | 67293 |
    @sanity @Vision @orgAdmin @Scenario13
    Examples:
      | role     | tcId  |
      | orgAdmin | 67293 |
    @sanity @Vision @orgReader @Scenario13
    Examples:
      | role      | tcId  |
      | orgReader | 67293 |
    @sanity @Vision @sysReader @Scenario13
    Examples:
      | role      | tcId  |
      | sysReader | 67293 |
    @sanity @Vision @teamAdmin @Scenario13
    Examples:
      | role      | tcId  |
      | teamAdmin | 67293 |

  Scenario Outline: Vision | Verify archiving single image in gallery view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify archiving single image in gallery view for "<role>" user.

    @sanity @Vision @member @Scenario14
    Examples:
      | role   | tcId  |
      | member | 66196 |
    @sanity @Vision @orgAdmin @Scenario14
    Examples:
      | role     | tcId  |
      | orgAdmin | 66196 |
    @sanity @Vision @orgReader @Scenario14
    Examples:
      | role      | tcId  |
      | orgReader | 66196 |
    @sanity @Vision @sysReader @Scenario14
    Examples:
      | role      | tcId  |
      | sysReader | 66196 |
    @sanity @Vision @teamAdmin @Scenario14
    Examples:
      | role      | tcId  |
      | teamAdmin | 66196 |

  Scenario Outline: Vision | Verify clicking on cancel button in thumbnail image archive for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify cancelling the archiving of single image in thumbnail view for "<role>" user.

    @sanity @Vision @member @Scenario15
    Examples:
      | role   | tcId  |
      | member | 66184 |
    @sanity @Vision @orgAdmin @Scenario15
    Examples:
      | role     | tcId  |
      | orgAdmin | 66184 |
    @sanity @Vision @orgReader @Scenario15
    Examples:
      | role      | tcId  |
      | orgReader | 66184 |
    @sanity @Vision @sysReader @Scenario15
    Examples:
      | role      | tcId  |
      | sysReader | 66184 |
    @sanity @Vision @teamAdmin @Scenario15
    Examples:
      | role      | tcId  |
      | teamAdmin | 66184 |

  Scenario Outline: Vision | Verify archive and download icon in gallery view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify archive and download icon in gallery view for "<role>" user.

    @sanity @Vision @member @Scenario16
    Examples:
      | role   | tcId  |
      | member | 66195 |
    @sanity @Vision @orgAdmin @Scenario16
    Examples:
      | role     | tcId  |
      | orgAdmin | 66195 |
    @sanity @Vision @orgReader @Scenario16
    Examples:
      | role      | tcId  |
      | orgReader | 66195 |
    @sanity @Vision @sysReader @Scenario16
    Examples:
      | role      | tcId  |
      | sysReader | 66195 |
    @sanity @Vision @teamAdmin @Scenario16
    Examples:
      | role      | tcId  |
      | teamAdmin | 66195 |

  Scenario Outline: Vision | Verify clicking on cancel button in gallery view for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    Then verify clicking on cancel button in gallery view for "<role>" user.

    @sanity @Vision @member @Scenario17
    Examples:
      | role   | tcId  |
      | member | 66198 |
    @sanity @Vision @orgAdmin @Scenario17
    Examples:
      | role     | tcId  |
      | orgAdmin | 66198 |
    @sanity @Vision @orgReader @Scenario17
    Examples:
      | role      | tcId  |
      | orgReader | 66198 |
    @sanity @Vision @sysReader @Scenario17
    Examples:
      | role      | tcId  |
      | sysReader | 66198 |
    @sanity @Vision @teamAdmin @Scenario17
    Examples:
      | role      | tcId  |
      | teamAdmin | 66198 |

  Scenario Outline: Vision | Verify navigation from search to Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    And verify if navigation is happening to Vision tab for all "<role>" user

    @sanity @Vision @member @Scenario18
    Examples:
      | role   | tcId  |
      | member | 66119 |
    @sanity @Vision @orgAdmin @Scenario18
    Examples:
      | role     | tcId  |
      | orgAdmin | 66119 |
    @sanity @Vision @orgReader @Scenario18
    Examples:
      | role      | tcId  |
      | orgReader | 66119 |
    @sanity @Vision @sysReader @Scenario18
    Examples:
      | role      | tcId  |
      | sysReader | 66119 |
    @sanity @Vision @teamAdmin @Scenario18
    Examples:
      | role      | tcId  |
      | teamAdmin | 66119 |

  Scenario Outline: Vision | Verify scrolling of images in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify scrolling of images in Vision tab for all "<role>" user

    @sanity @Vision @member @Scenario19
    Examples:
      | role   | tcId  |
      | member | 66179 |
    @sanity @Vision @orgAdmin @Scenario19
    Examples:
      | role     | tcId  |
      | orgAdmin | 66179 |
    @sanity @Vision @orgReader @Scenario19
    Examples:
      | role      | tcId  |
      | orgReader | 66179 |
    @sanity @Vision @sysReader @Scenario19
    Examples:
      | role      | tcId  |
      | sysReader | 66179 |
    @sanity @Vision @teamAdmin @Scenario19
    Examples:
      | role      | tcId  |
      | teamAdmin | 66179 |

  Scenario Outline: Vision | Verify data for deployment lists in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify data for deployment lists in Vision tab for all "<role>" user

    @sanity @Vision @member @Scenario20
    Examples:
      | role   | tcId  |
      | member | 66149 |
    @sanity @Vision @orgAdmin @Scenario20
    Examples:
      | role     | tcId  |
      | orgAdmin | 66149 |
    @sanity @Vision @orgReader @Scenario20
    Examples:
      | role      | tcId  |
      | orgReader | 66149 |
    @sanity @Vision @sysReader @Scenario20
    Examples:
      | role      | tcId  |
      | sysReader | 66149 |
    @sanity @Vision @teamAdmin @Scenario20
    Examples:
      | role      | tcId  |
      | teamAdmin | 66149 |

  Scenario Outline: Vision | Verify data for different filter dropdown in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify data for different filter dropdown in Vision tab for all "<role>" user

    @sanity @Vision @member @Scenario21
    Examples:
      | role   | tcId  |
      | member | 66155 |
    @sanity @Vision @orgAdmin @Scenario21
    Examples:
      | role     | tcId  |
      | orgAdmin | 66155 |
    @sanity @Vision @orgReader @Scenario21
    Examples:
      | role      | tcId  |
      | orgReader | 66155 |
    @sanity @Vision @sysReader @Scenario21
    Examples:
      | role      | tcId  |
      | sysReader | 66155 |
    @sanity @Vision @teamAdmin @Scenario21
    Examples:
      | role      | tcId  |
      | teamAdmin | 66155 |

  Scenario Outline: Vision | Verify cancelling single selected image in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify cancelling single selected image in Vision tab for all "<role>" user

    @sanity @Vision @member @Scenario22
    Examples:
      | role   | tcId  |
      | member | 66167 |
    @sanity @Vision @orgAdmin @Scenario22
    Examples:
      | role     | tcId  |
      | orgAdmin | 66167 |
    @sanity @Vision @orgReader @Scenario22
    Examples:
      | role      | tcId  |
      | orgReader | 66167 |
    @sanity @Vision @sysReader @Scenario22
    Examples:
      | role      | tcId  |
      | sysReader | 66167 |
    @sanity @Vision @teamAdmin @Scenario22
    Examples:
      | role      | tcId  |
      | teamAdmin | 66167 |

  Scenario Outline: Vision | Verify name format for a image in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify name format for a image in Vision tab for all "<role>" user

    @sanity @Vision @member @Scenario23
    Examples:
      | role   | tcId  |
      | member | 66182 |
    @sanity @Vision @orgAdmin @Scenario23
    Examples:
      | role     | tcId  |
      | orgAdmin | 66182 |
    @sanity @Vision @orgReader @Scenario23
    Examples:
      | role      | tcId  |
      | orgReader | 66182 |
    @sanity @Vision @sysReader @Scenario23
    Examples:
      | role      | tcId  |
      | sysReader | 66182 |
    @sanity @Vision @teamAdmin @Scenario23
    Examples:
      | role      | tcId  |
      | teamAdmin | 66182 |

  Scenario Outline: Vision | Verify latest image positioning in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify latest image positioning in Vision tab for all "<role>" user

    @sanity @Vision @member @Scenario24
    Examples:
      | role   | tcId  |
      | member | 66177 |
    @sanity @Vision @orgAdmin @Scenario24
    Examples:
      | role     | tcId  |
      | orgAdmin | 66177 |
    @sanity @Vision @orgReader @Scenario24
    Examples:
      | role      | tcId  |
      | orgReader | 66177 |
    @sanity @Vision @sysReader @Scenario24
    Examples:
      | role      | tcId  |
      | sysReader | 66177 |
    @sanity @Vision @teamAdmin @Scenario24
    Examples:
      | role      | tcId  |
      | teamAdmin | 66177 |

  Scenario Outline: Vision | Verify scrolling in gallery view using keyboard keys in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify scrolling in gallery view using keyboard keys for all "<role>" user

    @sanity @Vision @member @Scenario25
    Examples:
      | role   | tcId  |
      | member | 66194 |
    @sanity @Vision @orgAdmin @Scenario24
    Examples:
      | role     | tcId  |
      | orgAdmin | 66194 |
    @sanity @Vision @orgReader @Scenario24
    Examples:
      | role      | tcId  |
      | orgReader | 66194 |
    @sanity @Vision @sysReader @Scenario24
    Examples:
      | role      | tcId  |
      | sysReader | 66194 |
    @sanity @Vision @teamAdmin @Scenario24
    Examples:
      | role      | tcId  |
      | teamAdmin | 66194 |

  Scenario Outline: Vision | Verify image restoring from gallery view in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify image restoring from gallery view for all "<role>" user

    @sanity @Vision @member @Scenario26
    Examples:
      | role   | tcId  |
      | member | 66216 |
    @sanity @Vision @orgAdmin @Scenario26
    Examples:
      | role     | tcId  |
      | orgAdmin | 66216 |
    @sanity @Vision @orgReader @Scenario26
    Examples:
      | role      | tcId  |
      | orgReader | 66216 |
    @sanity @Vision @sysReader @Scenario26
    Examples:
      | role      | tcId  |
      | sysReader | 66216 |
    @sanity @Vision @teamAdmin @Scenario26
    Examples:
      | role      | tcId  |
      | teamAdmin | 66216 |

  Scenario Outline: Vision | Verify cancelling an image restore in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify cancelling an image restore for all "<role>" user

    @sanity @Vision @member @Scenario27
    Examples:
      | role   | tcId  |
      | member | 66213 |
    @sanity @Vision @orgAdmin @Scenario27
    Examples:
      | role     | tcId  |
      | orgAdmin | 66213 |
    @sanity @Vision @orgReader @Scenario27
    Examples:
      | role      | tcId  |
      | orgReader | 66213 |
    @sanity @Vision @sysReader @Scenario27
    Examples:
      | role      | tcId  |
      | sysReader | 66213 |
    @sanity @Vision @teamAdmin @Scenario27
    Examples:
      | role      | tcId  |
      | teamAdmin | 66213 |

  Scenario Outline: Vision | Verify cancelling multiple selected images in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify cancelling multiple selected images for all "<role>" user

    @sanity @Vision @member @Scenario28
    Examples:
      | role   | tcId  |
      | member | 66168 |
    @sanity @Vision @orgAdmin @Scenario28
    Examples:
      | role     | tcId  |
      | orgAdmin | 66168 |
    @sanity @Vision @orgReader @Scenario28
    Examples:
      | role      | tcId  |
      | orgReader | 66168 |
    @sanity @Vision @sysReader @Scenario28
    Examples:
      | role      | tcId  |
      | sysReader | 66168 |
    @sanity @Vision @teamAdmin @Scenario28
    Examples:
      | role      | tcId  |
      | teamAdmin | 66168 |

  Scenario Outline: Vision | Verify image download in Archived view in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify image download in Archived view for all "<role>" user

    @sanity @Vision @member @Scenario31
    Examples:
      | role   | tcId  |
      | member | 67552 |
    @sanity @Vision @orgAdmin @Scenario31
    Examples:
      | role     | tcId  |
      | orgAdmin | 67552 |
    @sanity @Vision @orgReader @Scenario31
    Examples:
      | role      | tcId  |
      | orgReader | 67552 |
    @sanity @Vision @sysReader @Scenario31
    Examples:
      | role      | tcId  |
      | sysReader | 67552 |
    @sanity @Vision @teamAdmin @Scenario31
    Examples:
      | role      | tcId  |
      | teamAdmin | 67552 |

  Scenario Outline: Vision | Verify download of image in gallery view of Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify download of image in gallery view of Vision tab for all "<role>" user

    @sanity @Vision @member @Scenario32
    Examples:
      | role   | tcId  |
      | member | 66204 |
    @sanity @Vision @orgAdmin @Scenario32
    Examples:
      | role     | tcId  |
      | orgAdmin | 66204 |
    @sanity @Vision @orgReader @Scenario32
    Examples:
      | role      | tcId  |
      | orgReader | 66204 |
    @sanity @Vision @sysReader @Scenario32
    Examples:
      | role      | tcId  |
      | sysReader | 66204 |
    @sanity @Vision @teamAdmin @Scenario32
    Examples:
      | role      | tcId  |
      | teamAdmin | 66204 |

  Scenario Outline: Vision | Verify download of multiple images in Vision tab for "<role>" user
    Given assign testcase "<tcId>" to log data to TestRail
    Given log into application with a "<role>" user
    Then navigate to page "Search"
    Then navigate to "Vision" tab
    And verify download of multiple images in Vision tab for all "<role>" user

    @sanity @Vision @member @Scenario33
    Examples:
      | role   | tcId  |
      | member | 66172 |
    @sanity @Vision @orgAdmin @Scenario33
    Examples:
      | role     | tcId  |
      | orgAdmin | 66172 |
    @sanity @Vision @orgReader @Scenario33
    Examples:
      | role      | tcId  |
      | orgReader | 66172 |
    @sanity @Vision @sysReader @Scenario33
    Examples:
      | role      | tcId  |
      | sysReader | 66172 |
    @sanity @Vision @teamAdmin @Scenario33
    Examples:
      | role      | tcId  |
      | teamAdmin | 66172 |