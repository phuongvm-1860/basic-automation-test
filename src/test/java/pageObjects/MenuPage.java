package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class MenuPage extends TestBase {

    public static WebElement makeAppointmentBtnTopPage() {
        return $(By.xpath("//a[@id='btn-make-appointment']"));
    }

    public static WebElement sideMenu() {
        return $(By.xpath("//*[@id='menu-toggle']"));
    }

    public static WebElement home() {
        return $(By.xpath("//a[contains(.,'Home')]"));
    }

    public static WebElement history() {
        return $(By.xpath("//a[contains(.,'History')]"));
    }

    public static WebElement Profile() {
        return $(By.xpath("//a[contains(.,'Profile')]"));
    }

    public static WebElement logOut() {
        return $(By.xpath("//a[contains(.,'Logout')]"));
    }

    public static WebElement logIn() {
        return $(By.xpath("//a[contains(.,'Login')]"));
    }
}
