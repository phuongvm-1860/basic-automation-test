package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class AppointmentConfirmPage extends TestBase {

    private static WebElement element = null;

    public static WebElement facility_confirm() {
        return $(By.xpath("//*[@id='facility']"));
    }

    public static WebElement apply_confirm() {
        return $(By.xpath("//*[@id='hospital_readmission']"));
    }

    public static WebElement healthcare_confirm() {
        return $(By.xpath("//*[@id='program']"));
    }

    public static WebElement date_confirm() {
        return $(By.xpath("//*[@id='visit_date']"));
    }

    public static WebElement comment_confirm() {
        return $(By.xpath("//*[@id='comment']"));
    }

    public static WebElement goToBtn() {
        return $(By.xpath("//*[@class='btn btn-default']"));
    }
}
