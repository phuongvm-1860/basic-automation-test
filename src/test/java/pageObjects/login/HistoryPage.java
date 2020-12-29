package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class HistoryPage extends TestBase {
    public static List<WebElement> date() {
        return $$(By.xpath("//div[@class='panel-heading']"));
    }

    public static List<WebElement> facility() { return $$(By.xpath("//p[@id='facility']")); }

    public static List<WebElement> apply() {
        return $$(By.xpath("//p[@id='hospital_readmission']"));
    }

    public static List<WebElement> healthcareInfo() {
        return $$(By.xpath("//p[@id='program']"));
    }

    public static List<WebElement> comment() {
        return $$(By.xpath("//p[@id='comment']"));
    }
}
