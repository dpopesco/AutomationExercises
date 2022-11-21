package page.objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver ldriver;
    WebDriverWait wait;

    public CartPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        actions = new Actions(ldriver);
    }

    Actions actions;

    @FindBy(xpath = "//button[@data-dismiss='modal']")
    @CacheLookup
    WebElement btnContinue;

    @FindBy(id = "cartModal")
    @CacheLookup
    WebElement modalDialog;

    @FindBy(linkText = "View Cart")
    @CacheLookup
    WebElement viewCart;

    @FindAll(@FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr"))
    @CacheLookup
    List<WebElement> cartProductList;


    public void hoverOverProduct(String product) {
        WebElement productName = ldriver.findElement(By.xpath("//*[text() = '" + product + "']"));
        actions.moveToElement(productName).perform();
    }

    public void clickOnAddToCartButton(String product) {
        WebElement productName = ldriver.findElement(By.xpath("//*[text() = '" + product + "']"));
        WebElement productWrapper = productName.findElement(By.xpath("ancestor::div[@class='product-image-wrapper']"));
        actions.moveToElement(productName).perform();
        WebElement overlayContent = productWrapper.findElement(By.className("overlay-content"));
        WebElement addToCart = overlayContent.findElement(By.tagName("a"));
        addToCart.click();
    }

    public void clickOnContinue() {
        wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(btnContinue));
        btnContinue.click();
    }

    public void checkModalWindowDisappeared() throws InterruptedException {
        Assert.assertFalse(modalDialog.isDisplayed());
        Thread.sleep(1000);
    }

    public void clicksOnViewCart() {
        wait.until(ExpectedConditions.visibilityOf(viewCart));
        viewCart.click();
    }

    public void checkProductAddedInCart(String productName, Integer price, Integer quantity, Integer totalPrice) {
        WebElement row = null;
        for (WebElement product : cartProductList) {
            WebElement productCartName = product.findElement(By.xpath("//td[@class='cart_description']/h4/a"));
            if (productCartName.getText().equals(productName)) {
                row = product;
                break;
            }
        }

        Assert.assertTrue(row.findElement(By.xpath("//td[@class='cart_price']/p")).getText().equals("Rs. " + price.toString()));
        Assert.assertTrue(row.findElement(By.xpath("//td[@class='cart_quantity']/button")).getText().equals(quantity.toString()));
        Assert.assertTrue(row.findElement(By.xpath("//td[@class='cart_total']/p")).getText().equals("Rs. " + totalPrice.toString()));
    }

}
