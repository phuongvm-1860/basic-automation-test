package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class HistoryPage extends TestBase {


    public HistoryPage() {
    }
    public static List<WebElement> dateHistory() {
        return $$(By.xpath("//*[@class='panel-heading']"));
    }

    public static WebElement menuHistory() {
        return $(By.xpath("//*[@id='menu-toggle']"));
    }
    public static WebElement buttonHistory() {
        return $(By.xpath("//*[text()='History']"));
    }

    public static List<WebElement> facilityHistory() {
        return $$(By.xpath("//*[@id='facility']"));
    }

    public static List<WebElement> hospitalHistory() {
        return $$(By.xpath("//*[@id='hospital_readmission']"));
    }

    public static List<WebElement> programlHistory() {
        return $$(By.xpath("//*[@id='program']"));
    }

    public static List<WebElement> commentHistory() {
        return $$(By.xpath("//*[@id='comment']"));
    }
}