Feature: Make Appointment

  An a user
  I want to make an appointment
  So I can use the app

  Scenario Outline: User create appointment successfully
    Given User login with account "John Doe" and password as "ThisIsNotAPassword"
    When User input facility as "<Facility>"
    And User input readmission "<Apply for hospital readmission>"
    And User input healthcare program as "<Healthcare Program>"
    And User input visit date as "<Visit Date>"
    And User input comment as "<Comment>" as below and submit the form
    And User submit the form
    Then User can see facility as "<Facility>"
    And User can see readmission "<Apply for hospital readmission>"
    And User can see healthcare program as "<Healthcare Program>"
    And User can see visit date as "<Visit Date>"
    And User can see comment as "<Comment>" as below and submit the form
    Examples:
      | Facility                     | Apply for hospital readmission | Healthcare Program | Visit Date | Comment |
      | Tokyo CURA Healthcare Center | Yes                            | Medicare           | 01/12/2020 | 123     |