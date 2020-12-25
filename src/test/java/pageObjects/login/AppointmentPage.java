package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class AppointmentPage extends TestBase {
    private static WebElement element = null;

    public AppointmentPage() {
    }

    public static WebElement facilityBox() {
        element = $(By.xpath("//*[@id='combo_facility']"));
        return element;
    }
    public static WebElement apply() {
        element = $(By.xpath("//*[@id=\"chk_hospotal_readmission\"]"));
        return element;
    }
    public static WebElement medicare() {
        element = $(By.xpath("//*[@id=\"radio_program_medicare\"]"));
        return element;
    }
    public static WebElement medicaid() {
        element = $(By.xpath("//*[@id=\"radio_program_medicaid\"]"));
        return element;
    }
    public static WebElement none() {
        element = $(By.xpath("//*[@id=\"radio_program_none\"]"));
        return element;
    }
    public static WebElement date() {
        element = $(By.xpath("//*[@id=\"txt_visit_date\"]"));
        return element;
    }
    public static WebElement comment() {
        element = $(By.xpath("//*[@id=\"txt_comment\"]"));
        return element;
    }
    public static WebElement bookingButton() {
        element = $(By.xpath("//*[@id=\"btn-book-appointment\"]"));
        return element;
    }
}
