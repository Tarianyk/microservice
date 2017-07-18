Feature: CRUD on users

  Scenario: Create user
    Given the bank creates one user Anton with email anton@gmail.com
    When the client wants to change his old email anton@gmail.com on new_anton@gmail.com
    Then the client with email new_anton@gmail.com wants to check his data