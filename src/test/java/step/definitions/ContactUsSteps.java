package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.ContactUsPage;

import java.time.Duration;

public class ContactUsSteps extends BaseClass {
    public ContactUsPage cp;

    public ContactUsSteps(TestContext context) {
        this.driver = context.driver;
        cp = new ContactUsPage(driver);
    }

    @When("clicks on Contact us link")
    public void clicks_on_contact_us_link() {
        cp.clickContactUs();
    }

    @When("User enters contacting details")
    public void user_enters_contacting_details() {
        cp.setName();
        cp.setEmail();
        cp.setMessage();
    }

    @When("clicks on Submit button")
    public void clicks_on_submit_button() {
        cp.clickSubmitButton();
    }

    @When("clicks on OK to proceed")
    public void clicks_on_ok_to_proceed() {
        cp.acceptAlertBox();
    }

    @Then("Message should be {string}")
    public void message_should_be(String msg) {
        String xpath = "//div[@class='contact-form']/div[2]";
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        Assert.assertTrue(driver.findElement(By.xpath(xpath)).getText().contains(msg));
    }
}
