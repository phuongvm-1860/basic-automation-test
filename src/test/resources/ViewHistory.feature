Feature: View History
  An a user
  I want to view history
  So I can ....

  Scenario: User can view history with valid value
    Given the user login with username as "John Doe" and password as "ThisIsNotAPassword"
    When user inputs all items value as below
      | viewFacility                    | viewApply | viewHealthCare | viewVisitDate | viewComment |
      | Tokyo CURA Healthcare Center    | Click     | Medicare       | 21/12/2020    |             |
      | Hongkong CURA Healthcare Center | NOT Click | Medicaid       | 25/12/2020    | Comment     |
      | Seoul CURA Healthcare Center    | Click     | None           | 21/12/2020    |             |
    And user clicks at menu
    And user selects history
    Then user sees appointment as below
      | checkViewFacility               | checkViewApply | checkViewHealthCare | checkViewVisitDate | checkViewComment |
      | Tokyo CURA Healthcare Center    | Yes            | Medicare            | 21/12/2020         |                  |
      | Hongkong CURA Healthcare Center | No             | Medicaid            | 25/12/2020         | Comment          |
      | Seoul CURA Healthcare Center    | Yes            | None                | 21/12/2020         |                  |