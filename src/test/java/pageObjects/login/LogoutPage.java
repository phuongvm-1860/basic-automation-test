package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class LogOutPage extends TestBase {

    public LogOutPage() {
    }
    public static WebElement logOutBtn() {
        return $(By.xpath("//*[@href='authenticate.php?logout']"));
    }
    public static WebElement loginBtn() {
        return $(By.xpath("//*[@href='profile.php#login']"));
    }
}
