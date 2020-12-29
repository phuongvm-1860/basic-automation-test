package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class MenuPage extends TestBase {
    private static WebElement element = null;

    public MenuPage() {
    }

    public static WebElement menuButton() {
        return $(By.xpath("//*[@id='menu-toggle']"));
    }

    public static WebElement historyButton() {
        return $(By.xpath("//*[@href=\"history.php#history\"]"));
    }

    public static WebElement logoutButton() {
        return $(By.xpath("//*[@href=\"authenticate.php?logout\"]"));
    }
}
