Feature: Profile Creation test cases
  I want to create my profile

  @PM @ProfileCreation @FinishButton @IR-95
    Scenario Outline: IR-95 - Verify that the Manage Project is shown when user fills all the fields
    Given I want to open Profile Creation page after initial login
    When I enter "<First name>" and "<Last name>" on Profile Creation page
    And I select Position
    And I select Contractual Term
    And I select Division
    And I select Location
    And I click the Finish button on Profile Creation page
    Then The Manage Project page is shown with "<Title>"
    Examples:
    |First name|Last name|Title|
    |Lily      |Colin    |Manage Projects|

  @PM @ProfileCreation @FinishButton @IR-95
  Scenario Outline: IR-95 - Verify that the Manage Project is shown when user fills all the fields
    Given I want to open Profile Creation page after initial login
    When I enter "<First name>" and "<Last name>" on Profile Creation page
    And I select Position
    And I select Contractual Term
    And I select Division
    And I select Location
    And I click the Finish button on Profile Creation page
    Then The Manage Project page is shown with "<Message>"
    Examples:
      |First name|Last name|Message|
      |Lily      |Colin    |Create profile successfully|

  @PM @ProfileCreation  @Firstname @Lastname @IR-184 @IR-323
    Scenario Outline:  IR-184 - IR-323 - Verify that the error message is shown when user leaves the First name and Last name fields blank
      Given I want to open Profile Creation page after initial login
      When I click the Finish button on Profile Creation page
      Then The error "<Message1>" and "<Message2>" are shown below the name fields
      Examples:
      |Message1|Message2|
      |First name is required|Last name is required|

  @PM @ProfileCreation  @Firstname  @Lastname @IR-185
  Scenario Outline: IR-185 - Verify that the information is added normally when entering the name fields contain blank space
    Given I want to open Profile Creation page after initial login
    When I enter "<First name>" and "<Last name>"
    Then No error message is shown
    Examples:
    |First name|Last name|
    |John Smart|Doe Smart|

  @PM @ProfileCreation @Firstname @IR-311
  Scenario: IR-311 - Verify that the error messages are shown when user enters only spaces in the First name field
    Given I want to open Profile Creation page after initial login
    When I enter spaces in Firstname field
    And I click the Finish button on Profile Creation page
    Then The error message is shown below the Firstname field


  @PM @ProfileCreation @FinishButton @IR-94
    Scenario Outline: IR-94 - Verify that the item is displayed when selecting any item in Drop-down list
    Given I want to open Profile Creation page after initial login
    When I enter "<First name>" and "<Last name>" on Profile Creation page
    And I select Position
    And I select Contractual Term
    And I select Division
    And I select Location
    Then The "<Position>", "<Contractual Term>", "<Division>", "<Location>" are displayed correctly in box
    Examples:
    |First name|Last name|Position|Contractual Term|Division|Location|
    |Lily      |Colin    |Product Owner|Fulltime employee|SmartDev Vietnam|Da Nang|

  @PM @ProfileCreation @Position @Reselect @IR-187
    Scenario Outline: IR-187 - Verify that the reselect function is working normally
    Given I want to open Profile Creation page after initial login
    When I enter "<First name>" and "<Last name>" on Profile Creation page
    And I select Product Owner
    And I reselect Scrum Master
    Then The Scrum Master is displayed correctly in the box
    Examples:
    |First name|Last name|
    |Lily      |Colin    |

  @PM @ProfileCreation @Position @Reselect @IR-314
    Scenario Outline: IR-314 - Verify that location is changed according to selected division
    Given I want to open Profile Creation page after initial login
    When I enter "<First name>" and "<Last name>" on Profile Creation page
    And I select SmartDev England division
    And I select London location
    Examples:
    |First name|Last name|
    |Lily      |Colin    |

  @PM @ProfileCreation @Position @Blank @IR-317
    Scenario Outline: IR-317 - Verify that the error message is shown when user leaves Position field blank
    Given I want to open Profile Creation page after initial login
    When I click the Finish button
    Then The error "<Message>" is shown below the Position field
    Examples:
    |Message|
    |Position is required|

  @PM @ProfileCreation @ContractualTerm @Blank @IR-318
    Scenario Outline: IR-318 - Verify that the error message is shown when user leaves Contractual Term field blank
    Given I want to open Profile Creation page after initial login
    When I click the Finish button
    Then The error "<Message>" is shown below the Contractual Term field
    Examples:
      |Message|
      |Contractual Term is required|

  @PM @ProfileCreation @Division @Blank @IR-319
  Scenario Outline: IR-318 - Verify that the error message is shown when user leaves Division field blank
    Given I want to open Profile Creation page after initial login
    When I click the Finish button
    Then The error "<Message>" is shown below the Division field
    Examples:
      |Message|
      |Division is required|

  @PM @ProfileCreation @Location @Blank @IR-320
  Scenario Outline: IR-318 - Verify that the error message is shown when user leaves Location field blank
    Given I want to open Profile Creation page after initial login
    When I click the Finish button
    Then The error "<Message>" is shown below the Location field
    Examples:
      |Message|
      |Location is required|


