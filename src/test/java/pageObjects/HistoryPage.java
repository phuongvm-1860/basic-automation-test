package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class HistoryPage extends TestBase {

    public HistoryPage() {
    }

    public static List<WebElement> date() {
        return $$(By.xpath("//*[@class='panel-heading']"));
    }

    public static List<WebElement> facility() {
        return $$(By.xpath("//*[@id='facility']"));
    }

    public static List<WebElement> readmission() {
        return $$(By.xpath("//*[@id='hospital_readmission']"));
    }

    public static List<WebElement> program() {
        return $$(By.xpath("//*[@id='program']"));
    }

    public static List<WebElement> comment() {
        return $$(By.xpath("//*[@id='comment']"));
    }
}
