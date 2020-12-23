package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class MenuPage extends TestBase {
    public static WebElement click_menu() {
        return $(By.xpath("//*[@id='menu-toggle']"));
    }
    public static WebElement click_history() {
        return $(By.xpath("//*[text()='History']"));
    }
    public static WebElement click_logout(){
        return driver.findElement(By.xpath("//*[text()='Logout']"));
    }
    public static WebElement click_profile(){
        return driver.findElement(By.xpath("//*[text()='Profile']"));
    }
}
