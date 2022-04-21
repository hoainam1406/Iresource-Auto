Feature: Sign Up Test cases
  I want to Sign Up an account on IResource website

  @SignUp @SignUpFunctionality @AllFields @SignUpButton @IR29 @IR76 @Dev @PM
  Scenario: IR-29, IR-76: Verify that user is able to sign up when filling all the mandatory fields
    Given I want to open sign up page
    When I want to enter all fields
    And I click Sign Up button
    Then The verify email page should show

  @SignUp @SignUpFunctionality @AllFields @IR30 @IR77 @Dev @PM
  Scenario Outline: IR-30, IR-77: Verify that user is unable to sign up when not filling any data into mandatory fields
    Given I want to open sign up page
    When I leave all fields blank
    And I click Sign Up button
    Then The error messages should show "<Message>"
    Examples:
    |Message  |
    |Required!|

  @SignUp @SignUpFunctionality @AllFields @IR157 @Dev @IR166 @PM
  Scenario Outline: IR-157, IR-166: Verify that the backspace or delete keys is working normally when removing the information
    Given I want to open sign up page
    When I enter all data "<data>" into all fields
    And I press backspace or delete keys in password and email fields
    Then The data should be removed normally "<new data>"
    Examples:
      |data    |new data |
      |testdata|testdat  |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR151 @Dev @IR159 @PM
  Scenario:IR-151, IR-159: Verify that the information is added normally when entering the name fields contain blank space
    Given I want to open sign up page
    When I enter firstname and lastname contain blank space
    And I click Sign Up button
    Then That name fields's data should be added normally

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR149 @Dev @IR158 @PM
  Scenario:IR-149, IR-158: Verify that the error message is shown when entering Firstname and Lastname less than 2 characters
    Given I want to open sign up page
    When I want to enter less than 2 characters into Firstname and Lastname fields
    And I click Sign Up button
    Then That name fields's data should be added normally

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR32 @Dev @IR79 @PM
  Scenario Outline:IR-32, IR-79: Verify that the error message is shown when entering Firstname and Lastname contain special characters, numbers
    Given I want to open sign up page
    When I want to enter Firstname and Lastname contain special characters, numbers
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
    |message                |field|
    |Please enter valid name|Name |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR269 @Dev @IR275 @PM
  Scenario Outline:IR-269, IR-274: Verify that the error message is shown when entering Firstname and Lastname with space characters
    Given I want to open sign up page
    When I want to enter Firstname and Lastname with space characters
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message                        |field|
      |Cannot contain only blankspaces|Name |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR270 @Dev @IR160 @PM
  Scenario Outline:IR-270, IR-160: Verify that the error message is shown when leaving Firstname and Lastname fields blank
    Given I want to open sign up page
    When I want to leave Firstname and Lastname fields blank
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message                |field|
      |Required!              |Name |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR271 @Dev @IR273 @PM
  Scenario:IR-271, IR-273: Verify that user sign up successfully when entering Firstname and Lastname with 15 characters
    Given I want to open sign up page
    When I want to enter Firstname and Lastname with 15 characters
    And I click Sign Up button
    Then That name fields's data should be added normally

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR272 @Dev @IR276 @PM
  Scenario Outline:IR-272, IR-276: Verify that the error message is shown when entering Firstname and Lastname with more than 15 characters
    Given I want to open sign up page
    When I want to enter Firstname and Lastname with more than 15 characters
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message                |field|
      |Maximum 15 characters  |Name |

  @SignUp @SignUpFunctionality @Email @IR35 @Dev @IR82 @PM
  Scenario Outline:IR-35, IR-82: Verify that the error message is shown when entering email contains blank space
    Given I want to open sign up page
    When I want to enter an example email
    And I click Sign Up button
    When I want to enter email contains blank space
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |
      |Invalid email format   |

  @SignUp @SignUpFunctionality @Email @IR35 @Dev @IR81 @PM
  Scenario Outline:IR-34, IR-81: Verify that the error message is shown when entering already registered email id
    Given I want to open sign up page
    When I want to enter an example email
    When I want to enter email contains blank space
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |
      |Invalid email format   |

  @SignUp @SignUpFunctionality @Email @IR33 @Dev @IR80 @PM
  Scenario Outline:IR-33, IR-80: Verify that the error message is shown when entering the email without @
    Given I want to open sign up page
    When I want to enter an example email
    And I want to enter email without @ sign
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |
      |Invalid email format   |

  @SignUp @SignUpFunctionality @Email @IR154 @Dev @IR163 @PM
  Scenario: IR-154, IR-163: Verify that user can sign up successfully with the correct email contains multiple dots
    Given I want to open sign up page
    When I want to enter a correct email with contains multiple dots
    And I click Sign Up button
    Then The error message should be shown

  @SignUp @SignUpFunctionality @Email @IR153 @Dev @IR162 @PM
  Scenario Outline: IR-153, IR-162: Verify that the error message is shown when entering email contains two @ sign
    Given I want to open sign up page
    When I want to enter an example email
    And I want to enter an email contains two @ sign
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |
      |Invalid email format   |

  @SignUp @SignUpFunctionality @Email @IR277 @Dev @IR280 @PM
  Scenario Outline: IR-277, IR-280: Verify that the error message is shown when only entering space characters in Email field
    Given I want to open sign up page
    When I want to enter an example email
    And I want to enter space charactes in Email field
    Then The error message "<message>" should be shown below field
    Examples:
      |message       |
      |Required!     |

  @SignUp @SignUpFunctionality @Email @IR277 @Dev @IR161 @PM
  Scenario Outline: IR-278, IR-161: Verify that the error message is shown when leaving Email field blank
    Given I want to open sign up page
    When I want to leave the email field blank
    And I click Sign Up button
    Then The error message "<message>" should be shown below field
    Examples:
      |message       |
      |Required!     |

  @SignUp @SignUpFunctionality @Email @IR461 @Dev @IR282 @PM
  Scenario Outline: IR-461, IR282: Verify that the error message is shown when entering the email contains consecutive dots
    Given I want to open sign up page
    When I want to enter an email contains consecutive dots
    And I click Sign Up button
    Then The error message "<message>" should be shown below field
    Examples:
      |message             |
      |Invalid email format|

  @SignUp @SignUpFunctionality @Password @IR37 @Dev @IR84 @PM
  Scenario Outline: IR-37, IR-84: Verify that the data in the password field is shown when clicking 'eye icon'
    Given I want to open sign up page
    When I want to enter password data "<data>"
    And I click 'Eye' icon to show password
    Then The data of the password field should be showed
    Examples:
    |data        |
    |password    |

  @SignUp @SignUpFunctionality @Password @IR36 @Dev @IR83 @PM
  Scenario Outline: IR-36, IR-83: Verify that the data in password field is either visible as asterisk or bullet signs
    Given I want to open sign up page
    When I want to enter password data "<data>"
    Then The data in password field is either visible as asterisk or bullet signs by default
    Examples:
      |data        |
      |password    |

  @SignUp @SignUpFunctionality @Password @IR279 @Dev @IR165 @PM
  Scenario Outline: IR-279, IR-165: Verify that user is unable to sign up when entering password less than 5 characters
    Given I want to open sign up page
    When I want to enter password data "<data>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |data        |message             |field   |index|
      |Pa1@        |Minimum 5 characters|Password|3    |

  @SignUp @SignUpFunctionality @Password @IR281 @Dev @IR462 @PM
  Scenario Outline: IR-281, IR-462: Verify that user is unable to sign up when leaving Password field blank
    Given I want to open sign up page
    When I want to enter all fields except password field
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |message       |field   |index|
      |Required!     |Password|0    |

  @SignUp @SignUpFunctionality @Password @IR284 @Dev @IR289 @IR290 @IR291 @PM
  Scenario Outline: IR-284, IR-289, IR-290, IR-291: Verify that user the error message will show when entering password missing 1 of 3 characters uppercase, number, special
    Given I want to open sign up page
    When I want to enter password missing 1 of 3 characters uppercase, number, special "<data>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |data         |message                                                          |field    |index |
      |Password123  |At least one uppercase, one number and one special case character|Password | 3    |
      |password123@ |At least one uppercase, one number and one special case character|Password | 3    |
      |Password@    |At least one uppercase, one number and one special case character|Password | 3    |


  @SignUp @SignUpFunctionality @ConfirmPassword @IR457 @Dev @IR85 @PM
  Scenario Outline: IR-457, IR-85: Verify user is able to sign up when entering the confirm password field with the same password
    Given I want to open sign up page
    When I want to enter password "<password>" and confirm password "<confirmpassword>"
    And I click Sign Up button
#    Then No error message is shown below the Confirm password
    Examples:
      |password      |confirmpassword  |
      |Validpass123@ |Validpass123@    |

  @SignUp @SignUpFunctionality @ConfirmPassword @IR458 @Dev @IR86 @PM
  Scenario Outline: IR-458, IR-86:  Verify user is able to sign up when entering the confirm password field with the different password
    Given I want to open sign up page
    When I want to enter password "<password>" and confirm password "<confirmpassword>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |password      |confirmpassword  |message               |field               |index|
      |Validpass123@ |Validpass123     |Password doesn’t match|Confirm Password    | 3   |

  @SignUp @SignUpFunctionality @ConfirmPassword @IR459 @Dev @IR294 @PM
  Scenario Outline: IR-459, IR-294: Verify that the data in the Confirm password field is shown when clicking 'eye icon'
    Given I want to open sign up page
    When I want to enter confirm password "<confirmpassword>"
    And I click 'Eye' icon of confirm password field
    Then The data of the confirm password field should be showed
    Examples:
      |confirmpassword  |
      |Validpass123@    |

  @SignUp @SignUpFunctionality @ConfirmPassword @IR460 @Dev @IR295 @PM
  Scenario Outline: IR-460, IR-295: Verify that the data in the Confirm password field is either visible as asterisk or bullet signs
    Given I want to open sign up page
    When I want to enter confirm password "<confirmpassword>"
    Then The data in password field is either visible as asterisk or bullet signs by default
    Examples:
      |confirmpassword  |
      |Validpass123@    |

  @SignUp @SignUpFunctionality @LoginHereHyperLink @IR40 @Dev @IR87 @PM
  Scenario Outline: IR-40, IR-87: Verify that the system is able to navigate when clicking 'Log in Here' button
    Given I want to open sign up page
    When I click 'Log In Here' hyperlink
    Then The user should be navigate to page "<page>" with url "<url>"
    Examples:
      |page  |url                                |
      |Login |https://iresource.smartdev.vn/login|

  @SignUp @SignUpFunctionality @SignUp @IR293 @Dev @IR
  Scenario Outline: IR-293: Verify that user navigates to Verify email page when click on 'Sign up' button
    Given I want to open sign up page
    When I click 'Log In Here' hyperlink
    Then The user should be navigate to page "<page>" with url "<url>"
    Examples:
      |page  |url                                |
      |Login |https://iresource.smartdev.vn/login|




















