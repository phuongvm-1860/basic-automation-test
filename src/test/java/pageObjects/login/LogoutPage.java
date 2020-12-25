package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class LogoutPage extends TestBase {
    private static WebElement element = null;
    public LogoutPage(){
    }
    public static WebElement logoutButton() {
        element = $(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[5]/a"));
        return element;
    }
}
