Feature: Cart

  Scenario: Products are added to Cart
    Given User opens URL "https://automationexercise.com/"
    When clicks on Products link
    Then Page Title should be "Automation Exercise - All Products"
    When User hovers over Product having the name "Sleeveless Dress"
    And clicks on Add to cart button having Product as "Sleeveless Dress"
    And clicks on Continue Shopping
    Then modal window should disappear
    When User hovers over to the next Product having the name "Blue Top"
    And clicks on Add to cart button having Product as "Blue Top"
    And clicks on View Cart link
    Then product "Sleeveless Dress" with Price 1000 , Quantity 1 and Total price 1000 is added to the Cart
    And product "Blue Top" with Price 500 , Quantity 1 and Total price 500 is added to the Cart

  Scenario: Product Quantity is added to the Cart
    Given User opens URL "https://automationexercise.com/"
    Then Page Title should be "Automation Exercise"
    When User clicks View Product having Product as "Blue Top"
    Then Page Title should be "Automation Exercise - Product Details"
    When User increases the Quantity of the product to 4
    And clicks on Add to cart
    And clicks on View Cart link
    Then product "Blue Top" with Quantity 4 is added to the Cart

