Feature: MakeAppointment
  An a user
  I want to sign in
  I want to make appointment and confirmation appointment
  So I can book appointment with the doctor

  Scenario Outline: User can book appointment with valid value
    Given user signed in as "John Doe" and "ThisIsNotAPassword"
    When user select "<facility>"
    And user clicks on "<checkbox>" apply
    And user choose "<healthcareProgram>"
    And user input "<date>"
    And user add "<comment>"
    And user clicks on Book Appointment button
    Then user confirmation appointment page
      | checkBoxConfirmFacility      | checkApply | checkHealthcareProgram | checkDate  | checkComment |
    Examples:
      | facility                        | checkbox  | healthcareProgram | date       | comment | checkBoxConfirmFacility         | checkApply | checkHealthcareProgram | checkDate  | checkComment |
      | Tokyo CURA Healthcare Center    | Click     | Medicare           | 21/12/2020 |         | Tokyo CURA Healthcare Center | Yes        | Medicare               | 21/12/2020 |              |
      | Hongkong CURA Healthcare Center | NOT Click | Medicaid           | aaaa       | Comment | Hongkong CURA Healthcare Center | Yes        | None                   | 21/12/2020 |              |
      | Seoul CURA Healthcare Center    | Click     | None               | 21/12/2020 |         | Seoul CURA Healthcare Center   | Yes        | Medicare               |            |              |
