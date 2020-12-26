Feature: Logout

  As an user
  I want to logout

  Scenario: User can be logout
    Given user login with username "John Doe" and password "ThisIsNotAPassword"
    When user click on icon menu button
    And user clicks on logout button
    Then user logout successfully and display login button
