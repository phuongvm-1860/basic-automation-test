package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class AppointmentPage extends TestBase {

    public AppointmentPage() {
    }

    public static WebElement facilityBox() { return $(By.xpath("//select")); }

    public static WebElement checkBox() {
        return $(By.xpath("//*[@id='chk_hospotal_readmission']"));
    }
    public static WebElement medicareRadio() {
        return $(By.xpath("//*[@id='radio_program_medicare']"));
    }
    public static WebElement medicaidRadio() {
        return $(By.xpath("//*[@id='radio_program_medicaid']"));
    }
    public static WebElement noneRadio() {
        return $(By.xpath("//*[@id='radio_program_none']"));
    }
    public static WebElement dateBox() {
        return $(By.xpath("//*[@id='txt_visit_date']"));
    }
    public static WebElement commentBox() {
        return $(By.xpath("//*[@id='txt_comment']"));
    }
    public static WebElement bookAppointmentButton() {
        return $(By.xpath("//*[@id='btn-book-appointment']"));
    }
    public static WebElement ConfirmPage() {
        return $(By.xpath("//h2[text()='Appointment Confirmation']"));
    }
    public static WebElement remakeAppointmentButton() {
        return $(By.xpath("//*[@id='btn-make-appointment']"));
    }
}
