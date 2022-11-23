Feature: Test Cases exercises
  Scenario: Successful navigation to test cases page
    Given User opens URL "https://automationexercise.com"
    Then Page Title should be "Automation Exercise"
    When clicks on Test Cases link
    Then Page Title should be "Automation Practice Website for UI Testing - Test Cases"

  Scenario: Verify Scroll Up using Arrow and Scroll Down functionality
    Given User opens URL "https://automationexercise.com/test_cases"
    Then Page Title should be "Automation Practice Website for UI Testing - Test Cases"
    When User scroll down to bottom of the page
    Then Subscription label is visible
    When User clicks on Arrow button at bottom right side
    Then Navigation bar is visible