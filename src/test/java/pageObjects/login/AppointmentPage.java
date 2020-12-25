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
    public static WebElement checkBox() {
        element = $(By.xpath("//*[@class = 'checkbox-inline']"));
        return element;
    }
    public static WebElement MedicareRadioButton() {
        element = $(By.xpath("//*[@id='radio_program_medicare']"));
        return element;
    }
    public static WebElement MedicaidRadioButton() {
        element = $(By.xpath("//*[@id='radio_program_medicaid']"));
        return element;
    }
    public static WebElement NoneRadioButton() {
        element = $(By.xpath("//*[@id='radio_program_none']"));
        return element;
    }
    public static WebElement visitDate() {
        element = $(By.xpath("//*[@id='txt_visit_date']"));
        return element;
    }
    public static WebElement comment() {
        element = $(By.xpath("//*[@id='txt_comment']"));
        return element;
    }
    public static WebElement bookAppointmentBtn() {
        element = $(By.xpath("//*[@id='btn-book-appointment']"));
        return element;
    }
}
