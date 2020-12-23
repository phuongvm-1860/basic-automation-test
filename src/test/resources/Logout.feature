Feature: Logout
  An a user
  I want to logout system
  So I can use function logout

  Scenario: logout system
    Given user login with username as "John Doe" and password as "ThisIsNotAPassword"
    When user clicks at menu
    And user clicks at logout
    Then user sees top page screen is opened
