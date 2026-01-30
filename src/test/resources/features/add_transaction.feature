Feature: Add transaction

  Scenario Outline: Add new transaction successfully
    Given Pepito is logged into the application
      | username   | password   |
      | <username> | <password> |
    When Pepito enters the required information for the new transaction
      | date   | amount   | description   |
      | <date> | <amount> | <description> |
    Then Pepito should see a new transaction in the transaction list with correct details
      | amount   | date   | description   |
      | <amount> | <date> | <description> |

    Examples:
      | username | password | date       | amount | description      |
      | user     | pass     | 30/01/2026 | 2000   | Grocery shopping |
      | user     | pass     | 30/01/2026 | 1000   | Test shopping    |
#
#  Scenario: Missing required fields for transaction addition
#    Given Pepito wants to add a new transaction
#    When Pepito does not send the required information
#    Then Pepito should be told all fields are required