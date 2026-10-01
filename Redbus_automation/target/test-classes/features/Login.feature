Feature: Login functionality

  Scenario: Login with valid credentials

    Given the user is on the login page
    When the user enters valid login credentials
    Then the user should be logged in successfully