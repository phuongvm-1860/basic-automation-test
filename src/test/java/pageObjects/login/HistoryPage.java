package pageObjects.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class HistoryPage extends TestBase {
    private static WebElement element = null;

    public HistoryPage() {
    }
    public static WebElement hamburgerMenu(){
        element = $(By.xpath("//*[@id=\"menu-toggle\"]"));
        return element;
    }
    public static WebElement history() {
        element = $(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a"));
        return element;
    }
    public static WebElement noAppointment() {
        element = $(By.xpath("//*[text()=\"No appointment.\"]"));
        return element;
    }
    public static List<WebElement> appointmentDate() {
        return $$(By.xpath("//*[@class='panel-heading']"));
    }
    public static List<WebElement> facility() {
        return $$(By.xpath("//*[@id='facility']"));
    }
    public static List<WebElement> apply() {
        return $$(By.xpath("//*[@id='hospital_readmission']"));
    }
    public static List<WebElement> program() {
        return $$(By.xpath("//p[@id='program']"));
    }
    public static List<WebElement> comment() {
        return $$(By.xpath("//p[@id='comment']"));
    }
}
