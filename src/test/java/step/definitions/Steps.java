package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.ContactUsPage;
import page.objects.LoginPage;
import page.objects.ProductsPage;
import page.objects.RegisterPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Steps extends BaseClass {

    @Before
    public void setup() throws IOException {
        //reading properties
        configProperties = new Properties();
        FileInputStream configPropFile = new FileInputStream("config.properties");
        configProperties.load(configPropFile);

        String browser = configProperties.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProperties.getProperty("chromepath"));
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configProperties.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        }
    }

    @After
    public void close_browser() {
        driver.close();
        driver.quit();
        driver = null;
    }

    @Given("User Launches browser")
    public void user_launches_browser() {
        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp.setEmail(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() {
        lp.clickLogout();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-qa='login-email']")));
    }


    //register feature
    @When("User enters generated Name and generated Email")
    public void user_enters_generated_name_and_generated_email() {
        rp = new RegisterPage(driver);
        rp.setGeneratedName();
        rp.setGeneratedEmail();
    }

    @When("User enters Name as {string} and Email as {string}")
    public void user_enters_name_as_and_email_as(String name, String email) {
        rp = new RegisterPage(driver);
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

    //contact us feature
    @When("clicks on Contact us link")
    public void clicks_on_contact_us_link() {
        cp = new ContactUsPage(driver);
        cp.clickContactUs();
    }

    @Then("Title should be {string}")
    public void title_should_be(String message) {
        /*wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));*/
        Assert.assertTrue((driver.getPageSource().contains(message)));
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

    //products feature
    @When("clicks on Products link")
    public void clicks_on_products_link() {
        pp = new ProductsPage(driver);
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

}
