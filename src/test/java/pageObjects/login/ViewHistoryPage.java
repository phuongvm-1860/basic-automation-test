package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class ViewHistoryPage extends TestBase {
    private static WebElement element = null;

    public static WebElement sidebar() {
        return $(By.xpath(("//*[@id='menu-toggle']")));
    }

    public static WebElement historyMenu() {
        return $(By.xpath("//*[contains(text(),'History')]"));
    }
    public static List<WebElement> dateInfo() {
        return $$(By.xpath("//*[@class='panel-heading']"));
    }
    public static List<WebElement> facilityInfo() {
        return $$(By.xpath("//*[@id='facility']"));
    }
    public static List<WebElement> applyInfor() {
        return $$(By.xpath("//*[@id='hospital_readmission']"));
    }
    public static List<WebElement> HealthcareProgramInfo() {
        return $$(By.xpath("//p[@id='program']"));
    }

    public static List<WebElement> commentInfo() {
        return $$(By.xpath("//p[@id='comment']"));
    }

    public static WebElement homePageBtn() {return $(By.xpath("//a[@class='btn btn-default']")); }

}
