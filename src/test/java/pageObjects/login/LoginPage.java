package pageObjects.login;

import org.openqa.selenium.WebElement;
import utility.TestBase;
import org.openqa.selenium.By;

public class LoginPage extends TestBase {
    public LoginPage() {
    }
    public static WebElement username() {
        return $(By.xpath("//*[@id='txt-username']"));
    }
    public static WebElement password() { return $(By.xpath("//*[@id='txt-password']"));
    }
    public static WebElement loginButton() { return $(By.xpath("//*[@id='btn-login']"));
    }
    public static WebElement errorMessage() {
        return $(By.xpath("//*[@class='lead text-danger']"));
    }
}

