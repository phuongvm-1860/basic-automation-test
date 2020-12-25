Feature: Login

  An a user
  I want to sign in
  So I can use the app

  @automated
  Scenario: User can sign in with valid value
    Given user is in Katalon login page
    When user sets username as "John Doe" and password as "ThisIsNotAPassword"
    And user clicks on login button
    Then user sees appointment page

    Scenario Outline: User cannot sign in with invalid data
      Given user is in Katalon login page
      When user sets username as "<username>" and password as "<password>"
      And user clicks on login button
      Then user sees "<error>"
      Examples:
        | username | password | error |
        |          |          |Login failed! Please ensure the username and password are valid.  |
        |          |123       | Login failed! Please ensure the username and password are valid. |
        |xyz       |          |Login failed! Please ensure the username and password are valid.  |
        |abc       |xyz       |Login failed! Please ensure the username and password are valid.  |



