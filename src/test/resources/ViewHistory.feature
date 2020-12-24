Feature: View History
  As an user
  I want to view history

  Scenario:
    Given user signed in as "John Doe" and "ThisIsNotAPassword"
    When user makes appointment with info as below
      | Facility                        | Hospital Readmission | Healthcare Program | Date  | Comment    |
      | Tokyo CURA Healthcare Center    | Check                | Medicaid           | valid | Comment    |
      | Hongkong CURA Healthcare Center | NOT Check            | Medicare           | valid | No Comment |
    Then user view history
      | Result Facility                 | Result Hospital Readmission | Result Healthcare Program | Result Date | Result Comment |
      | Tokyo CURA Healthcare Center    | Yes                         | Medicaid                  | 13/03/1997  | huhuhu         |
      | Hongkong CURA Healthcare Center | No                          | Medicare                  | 13/03/1997  |                |