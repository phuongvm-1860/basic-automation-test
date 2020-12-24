Feature: Login

  As a user
  I want to sign in
  So I can use the app

  @automated
  Scenario: User can sign in with valid value
    Given user is in Katalon login page
    When user sets username as "John Doe" and password as "ThisIsNotAPassword"
    And user clicks on login button
    Then user sees appointment page

  Scenario Outline: User can not sign in with invalid value
    Given user is in Katalon login page
    When user sets username as "<username>" and password as "<password>"
    And user clicks on login button
    Then user sees "<message>"
    Examples:
      | username | password           | message                                                          |
      | John Doe | huhu               | Login failed! Please ensure the username and password are valid. |
      | hihi     | ThisIsNotAPassword | Login failed! Please ensure the username and password are valid. |
      | huhu     | hihi               | Login failed! Please ensure the username and password are valid. |
      |          |                    | Login failed! Please ensure the username and password are valid. |
      |          |                    | Login failed! Please ensure the username and password are valid. |
