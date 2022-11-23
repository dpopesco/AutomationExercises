package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver ldriver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(xpath = "//a[@href='/login']/u")
    @CacheLookup
    WebElement lnkRegisterLogin;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    @CacheLookup
    WebElement btnContinue;

    @FindBy(css = "a[href='/payment']")
    @CacheLookup
    WebElement btnPlaceOrder;

    @FindBy(name = "name_on_card")
    @CacheLookup
    WebElement txtNameHolder;

    @FindBy(name = "card_number")
    @CacheLookup
    WebElement txtCardNumber;

    @FindBy(name = "cvc")
    @CacheLookup
    WebElement cvc;

    @FindBy(name = "expiry_month")
    @CacheLookup
    WebElement expiryMonth;

    @FindBy(name = "expiry_year")
    @CacheLookup
    WebElement expiryYear;

    @FindBy(id = "submit")
    @CacheLookup
    WebElement btnSubmit;


    public void clickOnProceedToCheckout() {
        WebElement btnProceed = ldriver.findElement(By.xpath("//div[@class='col-sm-6']/a"));
        wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(btnProceed));
        btnProceed.click();
    }

    public void clickOnRegisterLogin() {
        wait.until(ExpectedConditions.visibilityOf(lnkRegisterLogin));
        lnkRegisterLogin.click();
    }

    public void clickOnContinueButton() {
        btnContinue.click();
    }

    public void clickOnPlaceOrder() {
        wait.until(ExpectedConditions.visibilityOf(btnPlaceOrder));
        btnPlaceOrder.click();
    }

    public void fillPaymentDetails() {
        txtNameHolder.clear();
        txtNameHolder.sendKeys("Daria Boris");

        txtCardNumber.clear();
        txtCardNumber.sendKeys("9999999999999999");

        cvc.clear();
        cvc.sendKeys("111");

        expiryMonth.clear();
        expiryMonth.sendKeys("11");

        expiryYear.clear();
        expiryYear.sendKeys("2025");
    }

    public void clickOnPay() {
        btnSubmit.click();
    }

}
