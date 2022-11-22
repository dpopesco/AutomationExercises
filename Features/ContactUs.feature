Feature: Contact us

  Scenario: Successful submission of Contact us form
    Given User opens URL "https://automationexercise.com/"
    When clicks on Contact us link
    Then Title should be "Get In Touch"
    When User enters contacting details
    And clicks on Submit button
    And clicks on OK to proceed
    Then Message should be "Success! Your details have been submitted successfully."