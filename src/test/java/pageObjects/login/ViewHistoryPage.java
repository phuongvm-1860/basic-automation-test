package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class ViewHistoryPage extends TestBase {

    public static List<WebElement> lb_facility() {
        return $$(By.xpath("//*[@id='facility']"));
    }

    public static List<WebElement> lb_apply_for_hospital() {
        return $$(By.xpath("//*[@id='hospital_readmission']"));
    }

    public static List<WebElement> lb_health_care() {
        return $$(By.xpath("//*[@id='program']"));
    }

    public static List<WebElement> lb_visit_date() {
        return $$(By.xpath("//*[@class='panel-heading']"));
    }

    public static List<WebElement> lb_comment() {
        return $$(By.xpath("//*[@id='comment']"));
    }
}
