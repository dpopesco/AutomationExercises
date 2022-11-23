package page.objects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCasesPage {

    WebDriver ldriver;
    WebDriverWait wait;

    public TestCasesPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(css = "a[href='/test_cases")
    @CacheLookup
    WebElement testCasesLink;

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    @CacheLookup
    WebElement subscriptionLabel;

    @FindBy(id = "scrollUp")
    @CacheLookup
    WebElement scrollArrow;

    @FindBy(className = "col-sm-8")
    @CacheLookup
    WebElement navbar;
    public void clicksOnTestCases() {
        testCasesLink.click();
    }

    public void checkSubscriptionLabel(){
        Assert.assertTrue(subscriptionLabel.isDisplayed());
    }

    public void scrollToTheBottom() throws InterruptedException {
        ((JavascriptExecutor) ldriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
    }

    public void clickOnScrollArrow() throws InterruptedException {
        scrollArrow.click();
        Thread.sleep(3000);
    }

    public void checkNavbarIsVisible(){
        navbar.isDisplayed();
    }

}
