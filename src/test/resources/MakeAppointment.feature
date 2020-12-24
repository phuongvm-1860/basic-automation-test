Feature: Make Appointment
  As an user
  I want to make an appointment

  Scenario Outline:
    Given user signed in as "John Doe" and "ThisIsNotAPassword"
    When user selects facility "<Facility>"
    And user selects hospital readmission "<Hospital Readmission>"
    And user selects healthcare program"<Healthcare Program>"
    And user inputs date"<Date>"
    And user inputs comment"<Comment>"
    And user clicks button Book Appointment
    Then  user sees Appointment Confirmation
      | <Result Facility> | <Result Hospital Readmission> | <Result Healthcare Program> | <Result Date> | <Result Comment> |
#      | Tokyo CURA Healthcare Center    | Yes                           | Medicaid                    | 13/03/1997    | huhuhu           |
#      | Hongkong CURA Healthcare Center | No                            | Medicare                    | 13/03/1997    |                  |
#      | Seoul CURA Healthcare Center    | Yes                           | None                        | 13/03/1997    | huhuhu           |
    Examples:
      | Facility                        | Hospital Readmission | Healthcare Program | Date  | Comment    | Result Facility                 | Result Hospital Readmission | Result Healthcare Program | Result Date | Result Comment |
      | Tokyo CURA Healthcare Center    | Check                | Medicaid           | valid | Comment    | Tokyo CURA Healthcare Center    | Yes                         | Medicaid                  | 13/03/1997  | huhuhu         |
      | Hongkong CURA Healthcare Center | NOT Check            | Medicare           | valid | No Comment | Hongkong CURA Healthcare Center | No                          | Medicare                  | 13/03/1997  |                |
      | Seoul CURA Healthcare Center    | Check                | None               | valid | Comment    | Seoul CURA Healthcare Center    | Yes                         | None                      | 13/03/1997  | huhuhu         |