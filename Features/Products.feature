Feature: Products

  Scenario: All products detail page components are present
    Given User Launches browser
    When User opens URL "https://automationexercise.com/"
    And clicks on Products link
    Then Page Title should be "Automation Exercise - All Products"
    And Products list is visible
    When User clicks View Product having Product as "Blue Top"
    Then Page Title should be "Automation Exercise - Product Details"
    And all components from Detail page for Product as "Blue Top" are visible