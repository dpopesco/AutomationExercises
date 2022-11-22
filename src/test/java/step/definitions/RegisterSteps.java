package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.RegisterPage;

import java.time.Duration;

public class RegisterSteps extends BaseClass {
    public RegisterPage rp;

    public RegisterSteps(TestContext context) {
        this.driver = context.driver;
        rp = new RegisterPage(driver);
    }

    /*@After
    public void close_browser() {
        super.close_browser();
    }*/

    @When("User enters generated Name and generated Email")
    public void user_enters_generated_name_and_generated_email() {

        rp.setGeneratedName();
        rp.setGeneratedEmail();
    }

    @When("User enters Name as {string} and Email as {string}")
    public void user_enters_name_as_and_email_as(String name, String email) {
        rp.setName(name);
        rp.setEmail(email);
    }

    @When("Click on Signup")
    public void click_on_signup() {
        rp.clickSignUp();
    }

    @When("User enter account info")
    public void user_enter_account_info() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(),'Enter Account Information')]")));
        WebElement createAccountHeading = driver.findElement(By.xpath("//h2/b[contains(text(),'Account Information')]"));
        Assert.assertEquals(createAccountHeading.getText(), "ENTER ACCOUNT INFORMATION");
        rp.fillAccountForm();
    }

    @When("click on Create Account button")
    public void click_on_create_account_button() {
        rp.clickCreateAccount();
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String message) {
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-created']/b")).getText()
                .contains(message));
    }
}
