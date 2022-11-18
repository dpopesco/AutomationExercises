package step.definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.LoginPage;
import page.objects.RegisterPage;

import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage lp;
    public RegisterPage rp;
    public Properties configProperties;
}
