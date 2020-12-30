Feature: Login

  An a user
  I want to sign in
  So I can use the app

  Scenario: User can sign in with valid value
    Given user is in Katalon login page
    When user sets username as "John Doe" and password as "ThisIsNotAPassword"
    And user clicks on login button
    Then user sees appointment page

  Scenario Outline: User cannot sign in with invalid value
    Given user is in Katalon login page
    When user sets username as "<username>" and password as "<password>"
    And user clicks on login button
    Then user sees error message as "<errorMessage>"
    Examples:
      | username      | password           | errorMessage                                                     |
      | EnterUsername |                    | Login failed! Please ensure the username and password are valid. |
      |               | ThisIsNotAPassword | Login failed! Please ensure the username and password are valid. |
      | WrongUserName | WrongPassword      | Login failed! Please ensure the username and password are valid. |
      | JohnDoe       | WrongPassword      | Login failed! Please ensure the username and password are valid. |
      | WrongUserName | ThisIsNotAPassword | Login failed! Please ensure the username and password are valid. |
