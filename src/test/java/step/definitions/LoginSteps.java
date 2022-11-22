package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.LoginPage;

import java.time.Duration;

public class LoginSteps extends BaseClass {
    public LoginPage lp;

    public LoginSteps(TestContext context) {
        this.driver = context.driver;
        lp = new LoginPage(driver);
    }

    /*@After
    public void close_browser() {
        super.close_browser();
    }*/

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp.setEmail(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() {
        lp.clickLogout();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-qa='login-email']")));
    }
}
