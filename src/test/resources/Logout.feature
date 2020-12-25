Feature: Logout

  Scenario: Logout
    Given user is in Katalon login page
    When user sets username as "John Doe" and password as "ThisIsNotAPassword"
    And user clicks on login button
    And user sees appointment page
    And user clicks hamburger menu
    And user clicks on logout button
    Then user back to homepage