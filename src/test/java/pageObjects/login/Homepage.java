package pageObjects.login;

import utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homepage extends TestBase {
    private static WebElement element = null;
    public static WebElement makeApointmentbtn() {
        return $(By.xpath("//*[@id='btn-make-appointment']"));
    }
}
