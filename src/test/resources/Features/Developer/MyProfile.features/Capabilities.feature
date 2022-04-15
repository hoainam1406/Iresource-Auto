Feature: My profile functionalities
  I want to update my capabilities into IResource website

  @Dev @MyProfileFunc @Capabilities @Popup @IR-331 @111
  Scenario Outline: IR-331 Verify that the popup is shown when clicking on 'Edit' icon
    Given I want to open My Profile page
    When I click on Edit button
    Then The popup shows with "<title>"
    Examples:
      | title        |
      | Capabilities |

  @Dev @MyProfileFunc @Capabilities @Popup @IR-341
  Scenario Outline: IR-341 Verify that the popup is shown when clicking on 'Add more' button
    Given I want to open My Profile page
    When I click on Add more button
    Then The popup shows with "<title>"
    Examples:
      | title        |
      | Capabilities |

  @Dev @MyProfileFunc @Capabilities @SearchField @IR-344
  Scenario Outline: IR-344 Verify that user can find capabilities when entering valid data in Search field
    Given I want to open My Profile page
    When I click on Edit button
    And Enter "<value>" into Search field
    Then The hashtag with "<value>" show correctly
    Examples:
      | value             |
      | Automation Tester |

  @Dev @MyProfileFunc @Capabilities @Hashtag @IR-348
  Scenario: IR-348 Verify that user can choose capabilities when clicking on hashtag
    Given I want to open My Profile page
    When I click on Edit button
    And I click on hashtag of capability
    Then The hashtag is selected correctly

  @Dev @MyProfileFunc @Capabilities @SeeMore @IR-351
  Scenario: IR-351 Verify that all hashtags is shown when clicking on 'See more' button
    Given I want to open My Profile page
    When I click on Edit button
    And I click on 'See more' button
    Then All capabilities show correctly

#  @Dev @MyProfileFunc @Capabilities @+/-icon @IR-352
#  Scenario: IR-352 Verify that user can up and down for each capabilities when clicking on '+/-' icon
#    Given I want to open My Profile page
#    When I click on Edit button
#    And I click on hashtag of capability
#    And I click on '+' icon
#    Then The level of capabilities is up correctly

#  @Dev @MyProfileFunc @Capabilities @SearchField @IR-347
#  Scenario Outline: IR-347 Verify that user cannot find capabilities when entering space characters in Search field
#    Given I want to open My Profile page
#    When I click on Edit button
#    And Enter "<value>" into Search field
#    Then The hashtag with "<value>" show correctly
#    Examples:
#      | value             |
#      | Automation Tester |