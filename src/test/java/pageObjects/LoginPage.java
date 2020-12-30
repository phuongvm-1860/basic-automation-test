package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class LoginPage extends TestBase {

    public LoginPage() {
    }

    public static WebElement username() { return  $(By.xpath("//*[@id='txt-username']")); }

    public static WebElement password() {
        return $(By.xpath("//*[@id='txt-password']"));
    }

    public static WebElement loginButton() { return $(By.xpath("//*[@id='btn-login']")); }

    public static WebElement errorMessage(){
        return $(By.xpath("//p[@class='lead text-danger']"));
    }
}

