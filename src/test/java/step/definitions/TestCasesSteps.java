package step.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.TestCasesPage;

public class TestCasesSteps extends BaseClass {

    public TestCasesPage tcp;

    public TestCasesSteps(TestContext context) {
        this.driver = context.driver;
        tcp = new TestCasesPage(driver);
    }

    @When("clicks on Test Cases link")
    public void clicks_on_test_cases_link() {
        tcp.clicksOnTestCases();
    }

    @When("User scroll down to bottom of the page")
    public void user_scroll_down_to_bottom_of_the_page() throws InterruptedException {
        tcp.scrollToTheBottom();
    }
    @Then("Subscription label is visible")
    public void subscription_label_is_visible() {
        tcp.checkSubscriptionLabel();
    }
    @When("User clicks on Arrow button at bottom right side")
    public void user_clicks_on_arrow_button_at_bottom_right_side() throws InterruptedException {
        tcp.clickOnScrollArrow();
    }
    @Then("Navigation bar is visible")
    public void navigation_bar_is_visible() {
        tcp.checkNavbarIsVisible();
    }

}
