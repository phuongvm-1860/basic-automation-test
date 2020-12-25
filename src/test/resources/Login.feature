Feature: Login

  An a user
  I want to sign in
  So I can use the app

  @automated
  Scenario: User can sign in with valid value
    Given user is in Katalon login page
    When user sets username as "John" and password as "ThisIsNotAPassword"
    And user clicks on login button
    Then user sees appointment page

  Scenario Outline: User can not sign in with invalid value
    Given user is in Katalon login page
    When user sets usernames as "<username>" and password as "<password>"
    And user clicks on login button
    Then user sees "<error>"
    Examples:
      | username | password           | error                                                              |
      | abc      | ThisIsNotAPassword | Login failed! Please ensure the username and password are valid.   |
      | John     | abc                | Login failed! Please ensure the username and password are valid.12 |
      |          | ThisIsNotAPassword | Login failed! Please ensure the username and jgj are valid.        |
      | John     |                    | Login failed! Please ensure the username and password are valid.   |
      |          |                    | Login failed! Please ensure the username and password are valid.   |
