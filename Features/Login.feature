Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given User opens URL "https://automationexercise.com/login"
    When User enters Email as "ddd@sample.com" and Password as "Quatro"
    And Click on Login
    Then Page Title should be "Automation Exercise"
    When User click on Log out link
    Then Page Title should be "Automation Exercise - Signup / Login"

  Scenario Outline: Login Data Driven
    Given User opens URL "https://automationexercise.com/login"
    When User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Automation Exercise"
    When User click on Log out link
    Then Page Title should be "Automation Exercise - Signup / Login"

    Examples:
      | email            | password |
      | ddd@sample.com   | Quatro   |
      | wrong@sample.com | admin123 |