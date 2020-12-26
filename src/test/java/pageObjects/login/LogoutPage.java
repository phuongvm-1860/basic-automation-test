package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

    public class LogoutPage extends TestBase {

        public LogoutPage() {
        }

        public static WebElement menuIcon() {
            return $(By.xpath("//*[@id='menu-toggle']"));
        }
        public static WebElement logoutButton() {
            return $(By.xpath("//*[text()='Logout']"));
        }
        public static WebElement loginButton() {
            return $(By.xpath("//*[text()='Login']"));
        }

}
