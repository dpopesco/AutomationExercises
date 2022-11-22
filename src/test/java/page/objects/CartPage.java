package page.objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    WebDriver ldriver;

    public CartPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }


    @FindAll(@FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr"))
    @CacheLookup
    List<WebElement> cartProductList;


    public void checkProductAddedInCart(String productName, Integer price, Integer quantity, Integer totalPrice) {

        WebElement row = getProductRowByName(productName);

        Assert.assertTrue(row.findElement(By.xpath("//td[@class='cart_price']/p")).getText().equals("Rs. " + price.toString()));
        Assert.assertTrue(row.findElement(By.xpath("//td[@class='cart_quantity']/button")).getText().equals(quantity.toString()));
        Assert.assertTrue(row.findElement(By.xpath("//td[@class='cart_total']/p")).getText().equals("Rs. " + totalPrice.toString()));
    }


    public void checkProductQuantityInCart(String product, Integer quantity) {
        WebElement row = getProductRowByName(product);

        Assert.assertTrue(row.findElement(By.xpath("//td[@class='cart_quantity']/button")).getText().equals(quantity.toString()));
    }

    private WebElement getProductRowByName(String productName) {
        WebElement row = null;
        for (WebElement product : cartProductList) {
            WebElement productCartName = product.findElement(By.xpath("//td[@class='cart_description']/h4/a"));
            if (productCartName.getText().equals(productName)) {
                row = product;
                break;
            }
        }
        return row;
    }
}
