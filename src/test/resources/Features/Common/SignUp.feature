Feature: Sign Up Test cases
  I want to Sign Up an account on IResource website

  @SignUp @SignUpFunctionality @SignUpButton @IR29 @IR293 @Dev
  Scenario: IR-29, IR-293: Verify that user is able to sign up when filling all the mandatory fields
    Given I want to open sign up page
    When I want to enter all fields
    And I click Sign Up button
    Then The verify email page should show

  @SignUp @SignUpFunctionality @IR223 @Dev
  Scenario Outline: IR-223: Verify that user cannot sign up when leaving all fields blank
    Given I want to open sign up page
    When I leave all fields blank
    And I click Sign Up button
    Then The error messages should show "<Message>"
    Examples:
    |Message  |
    |Required!|

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR151 @Dev
  Scenario:IR-151: Verify that the information is added normally when entering the name fields contain blank space
    Given I want to open sign up page
    When I enter firstname and lastname contain blank space
    And I click Sign Up button
    Then That name fields's data should be added normally

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR149 @Dev
  Scenario:IR-149: Verify that the error message is shown when entering Firstname and Lastname less than 2 characters
    Given I want to open sign up page
    When I want to enter less than 2 characters into Firstname and Lastname fields
    And I click Sign Up button
    Then That name fields's data should be added normally

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR32 @Dev
  Scenario Outline:IR-32: Verify that the error message is shown when entering Firstname and Lastname contain special characters, numbers
    Given I want to open sign up page
    When I want to enter Firstname and Lastname contain special characters, numbers
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
    |message                |field|
    |Please enter valid name|Name |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR269 @Dev
  Scenario Outline:IR-269: Verify that the error message is shown when entering Firstname and Lastname with space characters
    Given I want to open sign up page
    When I want to enter Firstname and Lastname with space characters
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message                        |field|
      |Cannot contain only blankspaces|Name |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR270 @Dev
  Scenario Outline:IR-270: Verify that the error message is shown when leaving Firstname and Lastname fields blank
    Given I want to open sign up page
    When I want to leave Firstname and Lastname fields blank
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message                |field|
      |Required!              |Name |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR271 @Dev
  Scenario:IR-271: Verify that user sign up successfully when entering Firstname and Lastname with 15 characters
    Given I want to open sign up page
    When I want to enter Firstname and Lastname with 15 characters
    And I click Sign Up button
    Then That name fields's data should be added normally

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR272 @Dev
  Scenario Outline:IR-272: Verify that the error message is shown when entering Firstname and Lastname with more than 15 characters
    Given I want to open sign up page
    When I want to enter Firstname and Lastname with more than 15 characters
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message                |field|
      |Maximum 15 characters  |Name |

  @SignUp @SignUpFunctionality @Email @IR35 @Dev
  Scenario Outline:IR-35: Verify that the error message is shown when entering email contains blank space
    Given I want to open sign up page
    When I want to enter an example email
    And I click Sign Up button
    When I want to enter email contains blank space
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |
      |Invalid email format   |

  @SignUp @SignUpFunctionality @Email @IR35 @Dev
  Scenario Outline:IR-34: Verify that the error message is shown when entering already registered email id
    Given I want to open sign up page
    When I want to enter an example email
    When I want to enter email contains blank space
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |
      |Invalid email format   |

  @SignUp @SignUpFunctionality @Email @IR33 @Dev
  Scenario Outline:IR-33: Verify that the error message is shown when entering the email without @
    Given I want to open sign up page
    When I want to enter an example email
    And I want to enter email without @ sign
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |
      |Invalid email format   |

  @SignUp @SignUpFunctionality @Email @IR154 @Dev
  Scenario: IR-154: Verify that user can sign up successfully with the correct email contains multiple dots
    Given I want to open sign up page
    When I want to enter a correct email with contains multiple dots
    And I click Sign Up button
    Then The error message should be shown

  @SignUp @SignUpFunctionality @Email @IR153 @Dev
  Scenario Outline: IR-153: Verify that the error message is shown when entering email contains two @ sign
    Given I want to open sign up page
    When I want to enter an example email
    And I want to enter an email contains two @ sign
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |
      |Invalid email format   |

  @SignUp @SignUpFunctionality @Email @IR277 @Dev
  Scenario Outline: IR-277: Verify that the error message is shown when only entering space characters in Email field
    Given I want to open sign up page
    When I want to enter an example email
    And I want to enter space charactes in Email field
    Then The error message "<message>" should be shown below field
    Examples:
      |message       |
      |Required!     |

  @SignUp @SignUpFunctionality @Email @IR277 @Dev
  Scenario Outline: IR-278: Verify that the error message is shown when leaving Email field blank
    Given I want to open sign up page
    When I want to leave the email field blank
    And I click Sign Up button
    Then The error message "<message>" should be shown below field
    Examples:
      |message       |
      |Required!     |

  @SignUp @SignUpFunctionality @Password @IR37 @Dev
  Scenario Outline: IR-37: Verify that the data in the password field is shown when clicking 'eye icon'
    Given I want to open sign up page
    When I want to enter password data "<data>"
    And I click 'Eye' icon to show password
    Then The data of the password field should be showed
    Examples:
    |data        |
    |password    |

  @SignUp @SignUpFunctionality @Password @IR36 @Dev
  Scenario Outline: IR-36: Verify that the data in password field is either visible as asterisk or bullet signs
    Given I want to open sign up page
    When I want to enter password data "<data>"
    Then The data in password field is either visible as asterisk or bullet signs by default
    Examples:
      |data        |
      |password    |

  @SignUp @SignUpFunctionality @Password @IR279 @Dev
  Scenario Outline: IR-279: Verify that user is unable to sign up when entering password less than 5 characters
    Given I want to open sign up page
    When I want to enter password data "<data>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |data        |message             |field   |index|
      |Pa1@        |Minimum 5 characters|Password|3    |

  @SignUp @SignUpFunctionality @Password @IR281 @Dev
  Scenario Outline: IR-281: Verify that user is unable to sign up when leaving Password field blank
    Given I want to open sign up page
    When I want to enter all fields except password field
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |message       |field   |index|
      |Required!     |Password|0    |

  @SignUp @SignUpFunctionality @Password @IR284 @Dev
  Scenario Outline: IR-284: Verify that user the error message will show when entering password missing 1 of 3 characters uppercase, number, special
    Given I want to open sign up page
    When I want to enter password missing 1 of 3 characters uppercase, number, special "<data>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |data         |message                                                          |field    |index |
      |Password123  |At least one uppercase, one number and one special case character|Password | 3    |
      |password123@ |At least one uppercase, one number and one special case character|Password | 3    |
      |Password@    |At least one uppercase, one number and one special case character|Password | 3    |


  @SignUp @SignUpFunctionality @ConfirmPassword @IR457 @Dev
  Scenario Outline: IR-457: Verify user is able to sign up when entering the confirm password field with the same password
    Given I want to open sign up page
    When I want to enter password "<password>" and confirm password "<confirmpassword>"
    And I click Sign Up button
#    Then No error message is shown below the Confirm password
    Examples:
      |password      |confirmpassword  |
      |Validpass123@ |Validpass123@    |

  @SignUp @SignUpFunctionality @ConfirmPassword @IR458 @Dev
  Scenario Outline: IR-458:  Verify user is able to sign up when entering the confirm password field with the different password
    Given I want to open sign up page
    When I want to enter password "<password>" and confirm password "<confirmpassword>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |password      |confirmpassword  |message               |field               |index|
      |Validpass123@ |Validpass123     |Password doesn’t match|Confirm Password    | 3   |

  @SignUp @SignUpFunctionality @ConfirmPassword @IR459 @Dev
  Scenario Outline: IR-459: Verify that the data in the Confirm password field is shown when clicking 'eye icon'
    Given I want to open sign up page
    When I want to enter confirm password "<confirmpassword>"
    And I click 'Eye' icon of confirm password field
    Then The data of the confirm password field should be showed
    Examples:
      |confirmpassword  |
      |Validpass123@    |

  @SignUp @SignUpFunctionality @ConfirmPassword @IR460 @Dev
  Scenario Outline: IR-460: Verify that the data in the Confirm password field is either visible as asterisk or bullet signs
    Given I want to open sign up page
    When I want to enter confirm password "<confirmpassword>"
    Then The data in password field is either visible as asterisk or bullet signs by default
    Examples:
      |confirmpassword  |
      |Validpass123@    |

  @SignUp @SignUpFunctionality @LoginHereHyperLink @IR40 @Dev
  Scenario Outline: IR-40: Verify that the system is able to navigate when clicking 'Log in Here' button
    Given I want to open sign up page
    When I click 'Log In Here' hyperlink
    Then The user should be navigate to page "<page>" with url "<url>"
    Examples:
      |page  |url                                |
      |Login |https://iresource.smartdev.vn/login|

  @SignUp @SignUpFunctionality @SignUp @IR293 @Dev
  Scenario Outline: IR-293: Verify that user navigates to Verify email page when click on 'Sign up' button
    Given I want to open sign up page
    When I click 'Log In Here' hyperlink
    Then The user should be navigate to page "<page>" with url "<url>"
    Examples:
      |page  |url                                |
      |Login |https://iresource.smartdev.vn/login|




















