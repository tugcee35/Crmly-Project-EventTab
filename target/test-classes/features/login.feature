Feature: CRM24 Login Functionality
  User Story: As a user, I should be able to log in so that I can land on homepage.
  AC1-Users can log in with valid credentials
  AC2-"Wrong login/password" should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials
  AC3-"Please fill out this field" message should be displayed if the password or username is empty
  AC4-User land on the ‘Forgot Your Password’ page after clicking on the "Forgot Your Password" link

  Background: The user should be on the login page to be able to use the features on the feature page.
    Given User is on the login page

  Scenario Outline: US-001 | TC-001 | Verify that Users can log in with valid credentials
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks the login button
    Then The user should be logged in to the page and see the CRM24 title


    Examples: These are the credentials to be entered in the login functionality

      | username                      | password |
      | helpdesk1@cybertekschool.com  | UserUser |
      | helpdesk2@cybertekschool.com  | UserUser |
      | helpdesk3@cybertekschool.com  | UserUser |
      | helpdesk4@cybertekschool.com  | UserUser |
      | helpdesk5@cybertekschool.com  | UserUser |
      | helpdesk6@cybertekschool.com  | UserUser |
      | helpdesk7@cybertekschool.com  | UserUser |
      | helpdesk8@cybertekschool.com  | UserUser |
      | helpdesk9@cybertekschool.com  | UserUser |
      | helpdesk10@cybertekschool.com | UserUser |


  Scenario Outline: US-001 | TC-002 | Verify that "Wrong login/password" should be displayed for invalid credentials
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks the login button
    Then The user should see the Wrong login password alert on the page

    Examples: These are the invalid credentials to be entered in the login functionality
      | username                | password     |
      | helpdesk.com            | userruserrr2 |
      | helpdeskcyber@info.com  | salesuseruse |
      | cybertekscho@info.com   | userrrrr     |

  Scenario Outline: US-001 | TC-003 | Verify that "Please fill out this field" message should be displayed if the username is empty
    When User enters password "<password>"
    And User clicks the login button
    Then User should see Please fill out this field. message on username input

    Examples:Password list
      | password     |
      | kdsfjkdfjf   |
      | useruserus   |
      | cybertekslfd |

  Scenario Outline: US-001 | TC-004 | Verify that "Please fill out this field" message should be displayed if the password is empty
    When User enters username "<username>"
    And User clicks the login button
    Then User should see Please fill out this field. message on password input

    Examples:Username List
      | username                |
      | cybertek@helpdesk.com   |
      | helpdesk@@cybertek.comm |
      | aabbccdd@info           |

  Scenario: US-001 | TC-005 | Verify that User land on the ‘Forgot Your Password’ page after clicking on the "Forgot Your Password" link
    When User clicks forgot your password link
    Then User should land forgot your password page and should see Forgot Your Password text