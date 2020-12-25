package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class AppointmentConfirmPage extends TestBase {
    private static WebElement element = null;

    public static WebElement Home() {

        return $(By.xpath("//*[@class='btn btn-default']"));
    }

    public static List<WebElement> facilitys() {
        element = $(By.xpath("//*[@id='facility']"));
        return $$(By.xpath("//*[@id='facility']"));
    }
    public static List<WebElement> actions() {
        element = $(By.xpath("//*[@id='hospital_readmission']"));
        return $$(By.xpath("//*[@id='hospital_readmission']"));
    }
    public static List<WebElement> HealthcarePrograms() {
        element = $(By.xpath("//*[@id='program']"));
        return $$(By.xpath("//*[@id='program']"));
    }
    public static List<WebElement> dates() {
        element = $(By.xpath("//*[@id='visit_date']"));
        return $$(By.xpath("//*[@id='visit_date']"));
    }
    public static List<WebElement> comments() {
        element = $(By.xpath("//*[@id='comment']"));
        return $$(By.xpath("//*[@id='comment']"));
    }


}
