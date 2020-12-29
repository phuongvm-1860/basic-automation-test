Feature: Login

  An a user
  I want to sign in
  So I can use the app

  Background:
  Given user is in Katalon login page


  Scenario: User can sign in with valid value
    When user sets username as "John Doe" and password as "ThisIsNotAPassword"
    And user clicks on login button
    Then user sees appointment page

  Scenario Outline: User can not sign in with invalid value
    When user sets username as "<username>" and password as "<password>"
    When user sets "<username>" and "<password>" as below
    And user clicks on login button
    Then user sees error message as "Login failed! Please ensure the username and password are valid."

    Examples:
      | cases                    | username | password |
      | Both of fields are blank |          |          |
      | username is blank        |          | 1234     |
      | password is blank        | John Doe |          |
      | username is invalid      | asf      |          |
      | password is invalid      | John Doe | 1234     |