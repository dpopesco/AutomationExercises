Feature: Register

  Scenario: Successful Register with Valid Data
    Given User Launches browser
    When User opens URL "https://automationexercise.com/login"
    And User enters generated Name and generated Email
    And Click on Signup
    Then Page Title should be "Automation Exercise - Signup"
    When User enter account info
    And click on Create Account button
    Then User can view confirmation message "ACCOUNT CREATED!"

  Scenario Outline: Register Invalid Data
    Given User Launches browser
    When User opens URL "https://automationexercise.com/login"
    And User enters Name as "<name>" and Email as "<email>"
    And Click on Signup
    Then Page Title should be "Automation Exercise - Signup / Login"

    Examples:
      | name  | email          |
      | Daria | ddd@sample.com |