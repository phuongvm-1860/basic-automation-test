package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class MenuPage extends TestBase {

    public MenuPage() {
    }
    public static WebElement menu() {
        return $(By.xpath("//*[@id='menu-toggle']"));
    }
    public static WebElement menu_history() {
        return $(By.xpath("//*[text()='History']"));
    }
    public static WebElement menu_logout() {
        return $(By.xpath("//*[text()='Logout']"));
    }
}
