package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RegisterPage {
    public WebDriver ldriver;

    public RegisterPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    @CacheLookup
    WebElement txtName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    @CacheLookup
    WebElement btnSignUp;

    @FindBy(id = "uniform-id_gender1")
    @CacheLookup
    WebElement gender;
    @FindBy(id = "password")
    @CacheLookup
    WebElement password;
    @FindBy(id = "first_name")
    @CacheLookup
    WebElement firstName;
    @FindBy(id = "last_name")
    @CacheLookup
    WebElement lastName;

    @FindBy(id = "address1")
    @CacheLookup
    WebElement address;
    @FindBy(id = "state")
    @CacheLookup
    WebElement state;
    @FindBy(id = "city")
    @CacheLookup
    WebElement city;
    @FindBy(id = "country")
    @CacheLookup
    WebElement country;
    @FindBy(id = "zipcode")
    @CacheLookup
    WebElement zipcode;
    @FindBy(id = "mobile_number")
    @CacheLookup
    WebElement mobilePhone;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    @CacheLookup
    WebElement btnCreateAccount;


    public void setGeneratedName() {
        List<String> firstNames = Arrays.asList("Ecaterina", "Beatrice", "Ilinca", "Monica");
        int firstNamesSize = firstNames.size();
        int randomIndex = new Random().nextInt(firstNamesSize);
        String randomFirstName = firstNames.get(randomIndex);
        txtName.clear();
        txtName.sendKeys(randomFirstName);
    }

    public void setGeneratedEmail() {
        String generatedUserName = UUID.randomUUID().toString().substring(0, 10);
        String generatedEmail = generatedUserName + "@sample.com";
        txtEmail.clear();
        txtEmail.sendKeys(generatedEmail);
    }

    public void setName(String name){
        txtName.clear();
        txtName.sendKeys(name);
    }
    public void setEmail(String email){
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void clickSignUp() {
        btnSignUp.click();
    }

    public void fillAccountForm() {
        gender.click();
        password.sendKeys("Quatro");
        firstName.sendKeys("Daria");
        lastName.sendKeys("Bing");
        address.sendKeys("Luisville");

        Select drpStates = new Select(country);
        drpStates.selectByVisibleText("United States");

        state.sendKeys("Kentucky");
        city.sendKeys("Luisville");

        Random r = new Random(System.currentTimeMillis());
        String randomZipcode = String.valueOf(20000 + r.nextInt(10000));
        zipcode.sendKeys(randomZipcode);

        String randomMobile = String.valueOf(400000000 + r.nextInt(100000000));
        mobilePhone.sendKeys(randomMobile);
    }

    public void clickCreateAccount() {

        Actions actions = new Actions(ldriver);
        actions.moveToElement(btnCreateAccount);
        actions.perform();
        btnCreateAccount.click();
    }
}
