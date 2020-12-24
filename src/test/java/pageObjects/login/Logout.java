package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class Logout extends TestBase {
    private static WebElement element = null;

    public Logout() {

    }

    public static WebElement btnLogout() {
        return $(By.xpath("//*[@href='authenticate.php?logout']"));
    }

    public static WebElement btnLogin() {
        return $(By.xpath("//*[@href='profile.php#login']"));
    }
}