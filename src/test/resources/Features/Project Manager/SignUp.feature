Feature: Sign Up Test cases
  I want to Sign Up an account on IResource website with Project Manager role
  Background:
    Given I want to open sign up page
    When I click Project Manager button

  @SignUp @SignUpFunctionality @AllFields @SignUpButton @IR76 @PM
  Scenario: IR-76: Verify that user is able to sign up when filling all the mandatory fields
    When I want to enter all fields
    And I click Sign Up button
    Then The verify email page should show

  @SignUp @SignUpFunctionality @AllFields @IR77 @PM
  Scenario Outline: IR-77: Verify that user is unable to sign up when not filling any data into mandatory fields
    When I leave all fields blank
    And I click Sign Up button
    Then The error messages should show "<Message>"
    Examples:
    |Message  |
    |Required!|

  @SignUp @SignUpFunctionality @AllFields  @IR166 @PM
  Scenario Outline: IR-166: Verify that the backspace or delete keys is working normally when removing the information
    When I enter all data "<data>" into all fields
    And I press backspace or delete keys in password and email fields
    Then The data should be removed normally "<new data>"
    Examples:
      |data    |new data |
      |testdata|testdat  |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR159 @PM
  Scenario Outline:IR-159: Verify that the information is added normally when entering the name fields contain blank space
    When I want to enter Firstname "<firstname>" and Lastname "<lastname>"
    And I click Sign Up button
    Then The data should be added normally "<size>"
    Examples:
      |firstname   |lastname        |size|
      |Diana Smart |Adam Smith      |3   |
  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR158 @PM
  Scenario Outline:IR-158: Verify that the error message is shown when entering Firstname and Lastname less than 2 characters
    When I want to enter Firstname "<firstname>" and Lastname "<lastname>"
    And I click Sign Up button
    Then The data should be added normally "<size>"
    Examples:
      |firstname   |lastname        |size|
      |Diana Smart |Adam Smith      |3   |


  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR79 @PM
  Scenario Outline: IR-79: Verify that the error message is shown when entering Firstname and Lastname contain special characters, numbers
    When I want to enter Firstname "<firstname>" and Lastname "<lastname>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message                |field|firstname|lastname|
      |Please enter valid name|Name |123456   |@#^%$#  |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR274 @PM
  Scenario Outline: IR-274: Verify that the error message is shown when entering Firstname and Lastname with space characters
    When I want to enter Firstname " <firstname> " and Lastname " <lastname> "
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message                        |field|firstname|lastname|
      |Cannot contain only blankspaces|Name |         |        |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR275 @PM
  Scenario Outline:IR-275: Verify that user is able to enter the data when entering 2-15 characters in Firstname and Lastname
    When I want to enter Firstname "<firstname>" and Lastname "<lastname>"
    And I click Sign Up button
    Then The data should be added normally "<size>"
    Examples:
      |firstname   |lastname        |size|
      |Ab          |Abcdefghjklmnop |3   |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR160 @PM
  Scenario Outline: IR-160: Verify that the error message is shown when leaving Firstname and Lastname fields blank
    When I want to leave Firstname and Lastname fields blank
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message   |field|
      |Required! |Name |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR273 @PM
  Scenario Outline:IR-273: Verify that user is able to login successfully when entering spaces at the head and last position
    When I want to enter Firstname " <firstname> " and Lastname " <lastname> "
    And I click Sign Up button
    Then The data should be added normally "<size>"
    Examples:
      |firstname     |lastname         |size|
      |Lily          |Collin           | 3  |

  @SignUp @SignUpFunctionality @FirstnameAndLastname @IR276 @PM
  Scenario Outline: IR-276: Verify that the error message is shown when entering Firstname and Lastname with more than 15 characters
    When I want to enter Firstname "<firstname>" and Lastname "<lastname>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field
    Examples:
      |message                |field|firstname       |lastname        |
      |Maximum 15 characters  |Name |Testdataaaaaaaaa|Testdataaaaaaaaa|


  @SignUp @SignUpFunctionality @Email @IR82 @PM
  Scenario Outline: IR-82: Verify that the error message is shown when entering email contains blank space
    When I want to enter an example email
    And I click Sign Up button
    When I want to enter email "<email>" "<text>"
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |email                 |text                |
      |Invalid email format   |john.doe@smart dev.com|contains blank space|
      |Invalid email format   |john.d oe@smartdev.com|contains blank space|
      |Invalid email format   |john.doe@smartdev.co m|contains blank space|

  @SignUp @SignUpFunctionality @Email @IR81 @PM
  Scenario: IR-81: Verify that the error message is shown when entering already registered email id
    When I want to enter all fields with an already registered email
    And I click Sign Up button
    Then The error message should be shown

  @SignUp @SignUpFunctionality @Email @IR80 @PM
  Scenario Outline:IR-80: Verify that the error message is shown when entering the email without @
    When I want to enter an example email
    When I want to enter email "<email>" "<text>"
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |email               |text          |
      |Invalid email format   |lily.phammailsac.com|without @ sign|

  @SignUp @SignUpFunctionality @Email @IR163 @PM
  Scenario: IR-163: Verify that user can sign up successfully with the correct email contains multiple dots
    When I want to enter a correct email with contains multiple dots
    And I click Sign Up button
    Then The error message should be shown

  @SignUp @SignUpFunctionality @Email @IR162 @PM
  Scenario Outline: IR-162: Verify that the error message is shown when entering email contains two @ sign
    When I want to enter an example email
    And I want to enter email "<email>" "<text>"
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |email                 |text               |
      |Invalid email format   |john.doe@smartdev.com@|contains two @ sign|

  @SignUp @SignUpFunctionality @Email @IR280 @PM
  Scenario Outline: IR-280: Verify that the error message is shown when only entering space characters in Email field
    When I want to enter an example email
    And I want to enter email "   <email>" "<text>"
    Then The error message "<message>" should be shown below field
    Examples:
      |message       |email|text               |
      |Required!     |     |contains two @ sign|

  @SignUp @SignUpFunctionality @Email @IR161 @PM
  Scenario Outline: IR-161: Verify that the error message is shown when leaving Email field blank
    When I want to leave the email field blank
    And I click Sign Up button
    Then The error message "<message>" should be shown below field
    Examples:
      |message       |
      |Required!     |

  @SignUp @SignUpFunctionality @Email @IR282 @PM
  Scenario Outline: IR282: Verify that the error message is shown when entering the email contains consecutive dots
    And I want to enter email "<email>" "<text>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below field
    Examples:
      |message                |email                    |text                     |
      |Invalid email format   |lily.co..lins@yopmail.com|contains consecutive dots|

  @SignUp @SignUpFunctionality @Password @IR84 @PM
  Scenario Outline: IR-84: Verify that the data in the password field is shown when clicking 'eye icon'
    When I want to enter password data "<data>"
    And I click 'Eye' icon to show password
    Then The data of the password field should be showed
    Examples:
      |data        |
      |password    |

  @SignUp @SignUpFunctionality @Password @IR83 @PM
  Scenario Outline: IR-83: Verify that the data in password field is either visible as asterisk or bullet signs
    When I want to enter password data "<data>"
    Then The data in password field is either visible as asterisk or bullet signs by default
    Examples:
      |data        |
      |password    |

  @SignUp @SignUpFunctionality @Password @IR165 @PM
  Scenario Outline: IR-165: Verify that user is unable to sign up when entering password less than 5 characters
    When I want to enter password data "<data>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |data        |message             |field   |index|
      |Pa1@        |Minimum 5 characters|Password|3    |

  @SignUp @SignUpFunctionality @Password @IR462 @PM
  Scenario Outline: IR-462: Verify that user is unable to sign up when leaving Password field blank
    When I want to enter all fields except password field
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |message       |field   |index|
      |Required!     |Password|0    |

  @SignUp @SignUpFunctionality @Password @IR289 @IR290 @IR291 @PM
  Scenario Outline: IR-289, IR-290, IR-291: Verify that user the error message will show when entering password missing 1 of 3 characters uppercase, number, special
    When I want to enter password missing 1 of 3 characters uppercase, number, special "<data>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |data         |message                                                          |field    |index |
      |Password123  |At least one uppercase, one number and one special case character|Password | 3    |
      |password123@ |At least one uppercase, one number and one special case character|Password | 3    |
      |Password@    |At least one uppercase, one number and one special case character|Password | 3    |


  @SignUp @SignUpFunctionality @ConfirmPassword @IR85 @PM
  Scenario Outline: IR-85: Verify user is able to sign up when entering the confirm password field with the same password
    When I want to enter password "<password>" and confirm password "<confirmpassword>"
    And I click Sign Up button
    Then The data should be added normally "<size>"
    Examples:
      |password      |confirmpassword  |size|
      |Validpass123@ |Validpass123@    | 3  |

  @SignUp @SignUpFunctionality @ConfirmPassword @IR86 @PM
  Scenario Outline: IR-86:  Verify user is able to sign up when entering the confirm password field with the different password
    When I want to enter password "<password>" and confirm password "<confirmpassword>"
    And I click Sign Up button
    Then The error message "<message>" should be shown below "<field>" field "<index>"
    Examples:
      |password      |confirmpassword  |message               |field               |index|
      |Validpass123@ |Validpass123     |Password doesn’t match|Confirm Password    | 3   |

  @SignUp @SignUpFunctionality @ConfirmPassword @IR294 @PM
  Scenario Outline: IR-294: Verify that the data in the Confirm password field is shown when clicking 'eye icon'
    When I want to enter confirm password "<confirmpassword>"
    And I click 'Eye' icon of confirm password field
    Then The data of the confirm password field should be showed
    Examples:
      |confirmpassword  |
      |Validpass123@    |

  @SignUp @SignUpFunctionality @ConfirmPassword @IR295 @PM
  Scenario Outline: IR-295: Verify that the data in the Confirm password field is either visible as asterisk or bullet signs
    When I want to enter confirm password "<confirmpassword>"
    Then The data in password field is either visible as asterisk or bullet signs by default
    Examples:
      |confirmpassword  |
      |Validpass123@    |

  @SignUp @SignUpFunctionality @LoginHereHyperLink @IR87 @PM
  Scenario Outline: IR-87: Verify that the system is able to navigate when clicking 'Log in Here' button
    When I click 'Log In Here' hyperlink
    Then The user should be navigate to page "<page>" with url "<url>"
    Examples:
      |page  |url                                |
      |Login |https://iresource.smartdev.vn/login|

  @SignUp @SignUpFunctionality @SignUp @IR463 @PM
  Scenario Outline: IR-463: Verify that user navigates to Verify email page when click on 'Sign up' button
    When I click 'Log In Here' hyperlink
    Then The user should be navigate to page "<page>" with url "<url>"
    Examples:
      |page  |url                                |
      |Login |https://iresource.smartdev.vn/login|