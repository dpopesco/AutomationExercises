Feature: Checkout

  Scenario: Successful registration while Checkout
    Given User opens URL "https://automationexercise.com"
    Then Page Title should be "Automation Exercise"
    When User hovers over to the next Product having the name "Blue Top"
    And clicks on Add to cart button having Product as "Blue Top"
    And clicks on View Cart link
    Then product "Blue Top" with Price 500 , Quantity 1 and Total price 500 is added to the Cart
    When User clicks on Proceed to Checkout button
    And clicks on Register Login link
    And User enters generated Name and generated Email
    And Click on Signup
    Then Page Title should be "Automation Exercise - Signup"
    When User enter account info
    And click on Create Account button
    Then User can view confirmation message "ACCOUNT CREATED!"
    When User clicks on Continue button
    Then User is Logged in as specified name
    When User clicks on Cart button
    And User clicks on Proceed to Checkout button
    And User clicks on Place Order button
    Then Page Title should be "Automation Exercise - Payment"
    When User enters Payment details
    And clicks on Pay and Confirm Order
    Then Title should be "Order Placed!"
