Feature: Logout

  An a user
  I want to Log out
  So I can use the app

  Scenario: User can log out
    Given User login with account as "John Doe" and password as "ThisIsNotAPassword"
    When User click Menu button
    And User click Logout button
    Then User is in Home page with link "https://katalon-demo-cura.herokuapp.com/"