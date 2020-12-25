package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class HistoryPage extends TestBase {

    public HistoryPage() {
    }
    public static WebElement historyBtn() {
        return  $(By.xpath("//*[@href='history.php#history']"));
    }
    public static List <WebElement> viewFacility() {
        return  $$(By.xpath("//*[@id='facility']"));
    }
    public static List <WebElement> viewApply() {
        return  $$(By.xpath("//*[@id='hospital_readmission']"));
    }
    public static List <WebElement> viewHeathCare() {
        return  $$(By.xpath("//*[@id='program']"));
    }
    public static List <WebElement> viewComment() {
        return  $$(By.xpath("//*[@id='comment']"));
    }
    public static List <WebElement> viewDate() { return  $$(By.xpath("//*[@class='panel-heading']"));
    }
}
