package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "//a[@href='/logout']")
    @CacheLookup
    WebElement btnLogout;

    public void setEmail(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setPassword(String pwd) {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickLogout() {
        btnLogout.click();
    }
}
