package step.definitions;

import io.cucumber.java.en.When;
import page.objects.CheckoutPage;

public class CheckoutSteps extends BaseClass {

    public CheckoutPage ckp;

    public CheckoutSteps(TestContext context) {
        this.driver = context.driver;
        ckp = new CheckoutPage(driver);
    }

    @When("User clicks on Proceed to Checkout button")
    public void user_clicks_on_proceed_to_checkout_button() {
        ckp.clickOnProceedToCheckout();
    }

    @When("clicks on Register Login link")
    public void clicks_on_register_login_link() {
        ckp.clickOnRegisterLogin();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        ckp.clickOnContinueButton();
    }

    @When("User clicks on Place Order button")
    public void user_clicks_on_place_order_button() {
        ckp.clickOnPlaceOrder();
    }

    @When("User enters Payment details")
    public void user_enters_payment_details() {
        ckp.fillPaymentDetails();
    }

    @When("clicks on Pay and Confirm Order")
    public void clicks_on_pay_and_confirm_order() {
        ckp.clickOnPay();
    }
}
