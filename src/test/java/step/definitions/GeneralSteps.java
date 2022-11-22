package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GeneralSteps extends BaseClass {
    public GeneralSteps(TestContext context) {
        this.driver = context.driver;
    }

    @After
    public void close_browser() {
        super.close_browser();
    }

    @Given("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @Then("Title should be {string}")
    public void title_should_be(String message) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue((driver.getPageSource().contains(message)));
    }
}
