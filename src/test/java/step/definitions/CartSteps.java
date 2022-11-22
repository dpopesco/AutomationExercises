package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import page.objects.CartPage;

public class CartSteps extends BaseClass {
    public CartPage ctp;

    public CartSteps(TestContext context) {
        this.driver = context.driver;
        ctp = new CartPage(driver);
    }

    @Then("product {string} with Price {int} , Quantity {int} and Total price {int} is added to the Cart")
    public void product_with_price_quantity_and_total_price_is_added_to_the_cart(String productName, Integer price, Integer quantity, Integer totalPrice) {
        ctp.checkProductAddedInCart(productName, price, quantity, totalPrice);
    }


    @Then("product {string} with Quantity {int} is added to the Cart")
    public void product_with_quantity_is_added_to_the_cart(String productName, Integer quantity) {
        ctp.checkProductQuantityInCart(productName, quantity);
    }
}
