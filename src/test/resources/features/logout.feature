Feature: As a user, I should be able to log out.
AC1- User can log out and ends up in login page.
AC2- The user can not go to the home page again by clicking the step back button after successfully logged out.

Background: The user should be on the homepage after login to be able to log out.
Given User is on the homepage after login with valid credentials.


Scenario: US-002 | TC-001 | Verify that user can be able to log out
When the user clicks on the username in the upper right corner
And click on log out
Then User should log out and land on login page and should see title is Authorization | Login


Scenario: US-002 | TC-002 | Verify that the user can not go to the home page
again by clicking the step back button after successfully logged out.
When the user clicks on the username in the upper right corner
And click on log out
And User should log out and land on login page and should see title is Authorization | Login for startups
And User clicks step back button
Then The user cannot return to the homepage and should see Your CRM24 session expired. Please refresh the current web page. messageFeature:As a user, I should be able to log out.


