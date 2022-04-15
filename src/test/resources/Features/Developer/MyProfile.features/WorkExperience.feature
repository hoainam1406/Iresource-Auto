Feature: My profile functionalities
  I want to add and update my work experience into IResource website

  @Dev @MyProfileFunc @WorkExperience @Popup @IR-378
  Scenario Outline: IR-378 : Verify that the popup is shown when clicking on 'Add more' button
    Given I want to open My Profile page
    When I go to Work experience section and click on Add more button
    Then The popup shows "<title>"
    Examples:
      | title            |
      | Work experiences |

  @Dev @MyProfileFunc @WorkExperience @Popup @IR-379
  Scenario Outline: IR-379 Verify that the message is shown when having not added work experience
    Given I want to open My Profile page
    When I go to Work experience section
    Then The "<message>" shows correctly
    Examples:
      | message                   |
      | No work experiences yet ! |

  @Dev @MyProfileFunc @WorkExperience @General @IR-385_388_394_401_404_408
  Scenario Outline: IR-385_IR-388_IR-394_IR-401_IR-404_IR-408 Verify that the error message is shown when leaving all fields blank
    Given I want to open My Profile page
    When I go to Work experience section and click on Add more button
    And I click on 'Finish' button
    Then The error message should show under that fields "<error>"
    Examples:
      | error    |
      | required |

  @Dev @MyProfileFunc @WorkExperience @General @IR-387_402_405_409
  Scenario Outline: IR-387_IR-402_IR-405_IR-409 Verify that the error message is shown when entering employer, business type, position and experience with space characters
    Given I want to open My Profile page
    When I go to Work experience section and click on Add more button
    And I enter space characters in employer, business type, position and experience field
    And I click on 'Finish' button
    Then The error message should show under that fields "<error>"
    Examples:
      | error    |
      | required |

  @Dev @MyProfileFunc @WorkExperience @From-ToDate @IR-389_394
  Scenario Outline: IR-389_IR-394 Verify that the error message is shown when entering From & To date with space characters
    Given I want to open My Profile page
    When I go to Work experience section and click on Add more button
    And I enter in "<employer>" "<business type>" "<position>" "<experience>" fields and space characters with From & To date field
    And I click on 'Finish' button
    Then The error message should show under that fields "<error>"
    Examples:
      | employer | business type  | position | experience     | error    |
      | SmartDev | Software       | QA       | manual testing | required |

  @Dev @MyProfileFunc @WorkExperience @EmployerField @IR-386
  Scenario Outline: IR-386 Verify that user can add new work experience when entering employer with text, number, special characters
    Given I want to open My Profile page
    When I go to Work experience section and click on Add more button
    And I enter in "<employer>" "<from date>" "<to date>" "<business type>" "<position>" "<experience>" fields
    And I click on 'Finish' button
    Then The "<message1>" should show correctly
    Examples:
      | employer     | from date  | to date    | business type | position | experience     | message1                       |
      | SmartDev@123 | 01/12/2021 | 31/03/2022 | Software      | QA       | manual testing | Update Work Experience success |

  @Dev @MyProfileFunc @WorkExperience @BusinessTypeField @IR-403
  Scenario Outline: IR-403 Verify that user can add new work experience when entering business type with text, number, special characters
    Given I want to open My Profile page
    When I go to Work experience section and click on Add more button
    And I enter in "<employer>" "<from date>" "<to date>" "<business type>" "<position>" "<experience>" fields
    And I click on 'Finish' button
    Then The "<message1>" should show correctly
    Examples:
      | employer | from date  | to date    | business type     | position | experience     | message1                       |
      | SmartDev | 01/12/2021 | 31/03/2022 | Software@123      | QA       | manual testing | Update Work Experience success |

  @Dev @MyProfileFunc @WorkExperience @PositionField @IR-403
  Scenario Outline: IR-403 Verify that user can add new work experience when entering business type with text, number, special characters
    Given I want to open My Profile page
    When I go to Work experience section and click on Add more button
    And I enter in "<employer>" "<from date>" "<to date>" "<business type>" "<position>" "<experience>" fields
    And I click on 'Finish' button
    Then The "<message1>" should show correctly
    Examples:
      | employer | from date  | to date    | business type | position | experience     | message1                       |
      | SmartDev | 01/12/2021 | 31/03/2022 | Software      | QA@123   | manual testing | Update Work Experience success |

  @Dev @MyProfileFunc @WorkExperience @ExperienceField @IR-407
  Scenario Outline: IR-407 Verify that user can add new work experience when entering Responsibilities with text, number, special characters
    Given I want to open My Profile page
    When I go to Work experience section and click on Add more button
    And I enter in "<employer>" "<from date>" "<to date>" "<business type>" "<position>" "<experience>" fields
    And I click on 'Finish' button
    Then The "<message1>" should show correctly
    Examples:
      | employer | from date  | to date    | business type | position | experience          | message1                       |
      | SmartDev | 01/12/2021 | 31/03/2022 | Software      | QA       | manualtesting @1234 | Update Work Experience success |

  @Dev @MyProfileFunc @WorkExperience @From-ToDateField @IR-390
  Scenario Outline: IR-390 Verify that The date automatically changed according to the correct format when entering From & To date with text
    Given I want to open My Profile page
    When I go to Work experience section and click on Edit button
    And I edit "<from date>" and "<to date>" with text
    Then The date automatically changed according to the correct format
    Examples:
      | employer | from date  | to date    | business type | position | experience          |
      | SmartDev | HelloWorld | HelloWorld | Software      | QA       | manualtesting @1234 |