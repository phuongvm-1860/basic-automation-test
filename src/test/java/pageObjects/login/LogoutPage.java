package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class LogoutPage extends TestBase {
    //*[contains(text(),'Logout')]
    private static WebElement element = null;
    public static WebElement OUt() {
        return $(By.xpath("//*[contains(text(),'Logout')]"));
    }
}
