Feature: Login

  An a user
  I want to sign in
  So I can use the app

  Scenario Outline: User can not login with invalid value
    Given login page is opened
    When user inputs user name as "<username>" and password as "<password>"
    And user clicks on login button
    Then user sees error message as "<message>" is displayed
    Examples:
      | username  | password            | message                                                          |
      |           |                     | Login failed! Please ensure the username and password are valid. |
      | John Doe  |                     | Login failed! Please ensure the username and password are valid. |
      |           | ThisIsNotAPassword  | Login failed! Please ensure the username and password are valid. |
      | John Doe1 | ThisIsNotAPassword1 | Login failed! Please ensure the username and password are valid. |

  Scenario: User can sign in with valid value
    Given login page is opened
    When user sets username as "John Doe" and password as "ThisIsNotAPassword"
    And user clicks on login button
    Then user sees appointment page