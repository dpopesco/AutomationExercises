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

public class ProductsPage {

    WebDriver ldriver;

    public ProductsPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(css = "a[href='/products']")
    @CacheLookup
    WebElement productsLink;

    @FindAll(@FindBy(className = "product-image-wrapper"))
    @CacheLookup
    List<WebElement> productsList;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    @CacheLookup
    WebElement productName;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(text(),'Category')]")
    @CacheLookup
    WebElement category;

    @FindBy(xpath = "//div[@class='product-information']/p/b[contains(text(),'Availability')]")
    @CacheLookup
    WebElement availability;

    @FindBy(xpath = "//div[@class='product-information']/p/b[contains(text(),'Condition')]")
    @CacheLookup
    WebElement condition;

    @FindBy(xpath = "//div[@class='product-information']/p/b[contains(text(),'Brand')]")
    @CacheLookup
    WebElement brand;


    public void clickProducts() {
        productsLink.click();
    }

    public void checkProductsPresence() {
        Assert.assertTrue(productsList.size() > 0);
    }

    public void clickViewProduct(String product) {
        WebElement productName = ldriver.findElement(By.xpath("//*[text() = '" + product + "']"));
        WebElement productWrapper = productName.findElement(By.xpath("ancestor::div[@class='product-image-wrapper']"));
        productWrapper.findElement(By.xpath("//div[@class='choose']//a")).click();
    }

    public void checkProductName(String product) {
        Assert.assertEquals(product, productName.getText());
    }

    public void productComponentsArePresent() {
        Assert.assertTrue(category.isDisplayed());
        Assert.assertTrue(availability.isDisplayed());
        Assert.assertTrue(condition.isDisplayed());
        Assert.assertTrue(brand.isDisplayed());
    }
}
