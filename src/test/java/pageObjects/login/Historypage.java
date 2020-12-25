package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class Historypage extends TestBase {
    private static WebElement element = null;
    public Historypage() {
    }

    public static WebElement menu() {
        return $(By.xpath("//a[@id='menu-toggle']"));
    }

    public static WebElement historyMenu() {
        return $(By.xpath("//a[contains(.,'History')]"));
    }

    public static List<WebElement> dateI_history() {
        return $$(By.xpath("//div[@class='panel-heading']"));
    }

    public static List<WebElement> facility_history() {
        return $$(By.xpath("//p[@id='facility']"));
    }

    public static List<WebElement> apply_history() {
        return $$(By.xpath("//p[@id='hospital_readmission']"));
    }

    public static List<WebElement> healthcare_history() {
        return $$(By.xpath("//p[@id='program']"));
    }

    public static List<WebElement> comment_history() {
        return $$(By.xpath("//p[@id='comment']"));
    }

    public static List<WebElement> homePageBtn() {
        return $$(By.xpath("//a[@class='btn btn-default']"));
    }
}
