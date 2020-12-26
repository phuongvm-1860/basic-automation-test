package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class ConfirmPage extends TestBase {

    public void ConfirmPage() {
    }

    public static WebElement facilityContent() {
        return $(By.xpath("//*[@id='facility']"));
    }
    public static WebElement checkValue() {
        return $(By.xpath("//*[@id='hospital_readmission']"));
    }
    public static WebElement radio() {
        return $(By.xpath("//*[@id='program']"));
    }
    public static WebElement date() {
        return $(By.xpath("//*[@id='visit_date']"));
    }
    public static WebElement comment() {
        return $(By.xpath("//*[@id='comment']"));
    }
}