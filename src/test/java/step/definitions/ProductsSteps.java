package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.ProductsPage;

public class ProductsSteps extends BaseClass {
    public ProductsPage pp;

    public ProductsSteps(TestContext context) {
        this.driver = context.driver;
        pp = new ProductsPage(driver);
    }

    /*@After
    public void close_browser() {
        super.close_browser();
    }*/

    @When("clicks on Products link")
    public void clicks_on_products_link() {
        pp.clickProducts();
    }

    @Then("Products list is visible")
    public void products_list_is_visible() {
        pp.checkProductsPresence();
    }

    @When("User clicks View Product having Product as {string}")
    public void user_clicks_view_product_having_product_as(String product) {

        pp.clickViewProduct(product);

    }

    @Then("all components from Detail page for Product as {string} are visible")
    public void all_components_from_detail_page_for_product_as_are_visible(String product) {
        pp.checkProductName(product);
        pp.productComponentsArePresent();
    }

    //product feature - search functionality

    @When("User enters keyword as {string} in Search field")
    public void user_enters_keyword_as_in_search_field(String product) {
        pp.searchProductName(product);
    }

    @When("clicks on Search button")
    public void clicks_on_search_button() {
        pp.clickOnSearch();
    }

    @Then("all products having searched keyword as {string} are visible")
    public void all_products_having_searched_keyword_as_are_visible(String product) {
        pp.searchedProductsAreVisible(product);
    }

    @When("User hovers over Product having the name {string}")
    public void user_hovers_over_product_having_the_name(String product) {
        pp.hoverOverProduct(product);
    }

    @When("clicks on Add to cart button having Product as {string}")
    public void clicks_on_add_to_cart_button_having_product_as(String product) {
        pp.clickOnAddToCartButton(product);
    }

    @When("clicks on Continue Shopping")
    public void clicks_on_continue_shopping() {
        pp.clickOnContinue();
    }

    @Then("modal window should disappear")
    public void modal_window_should_disappear() throws InterruptedException {
        pp.checkModalWindowDisappeared();
    }

    @When("User hovers over to the next Product having the name {string}")
    public void user_hovers_over_to_the_next_product_having_the_name(String product) {
        pp.hoverOverProduct(product);
    }

    @When("clicks on View Cart link")
    public void clicks_on_view_cart_link() {
        pp.clicksOnViewCart();
    }

    @When("User increases the Quantity of the product to {int}")
    public void user_increases_the_quantity_of_the_product_to(Integer quantity) {
        pp.increaseQuantity(quantity);
    }

    @When("clicks on Add to cart")
    public void clicks_on_add_to_cart() {
        pp.clickAddToCart();
    }
}
