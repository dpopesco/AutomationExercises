package page.objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    public WebDriver ldriver;

    public ContactUsPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(css = "a[href='/contact_us'")
    @CacheLookup
    WebElement contactUsLink;

    @FindBy(name = "name")
    @CacheLookup
    WebElement name;

    @FindBy(name = "email")
    @CacheLookup
    WebElement email;

    @FindBy(id = "message")
    @CacheLookup
    WebElement message;

    @FindBy(name = "submit")
    @CacheLookup
    WebElement btnSubmit;

    public void setName() {
        name.clear();
        name.sendKeys("Hellen");
    }

    public void setEmail() {
        email.clear();
        email.sendKeys("ddd@sample.com");
    }

    public void setMessage() {
        message.clear();
        message.sendKeys("Some message");
    }

    public void clickContactUs() {
        contactUsLink.click();
    }

    public void clickSubmitButton() {
        btnSubmit.click();
    }

    public void acceptAlertBox() {
        ldriver.switchTo().alert().accept();
    }


}
