package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class AppointmentPage extends TestBase {
    private static WebElement element = null;

    public AppointmentPage() { }

    public static WebElement facilityBox() { return $(By.xpath("//*[@id='combo_facility']")); }

    public static WebElement readmission() {
        return $(By.xpath("//*[@id='chk_hospotal_readmission']"));
    }

    public static WebElement program_medicare() {
        return $(By.xpath("//*[@id='radio_program_medicare']"));
    }

    public static WebElement program_medicaid() { return $(By.xpath("//*[@id='radio_program_medicaid']"));    }

    public static WebElement program_none() {
        return $(By.xpath("//*[@id='radio_program_none']"));
    }

    public static WebElement date() {
        return $(By.xpath("//*[@id='txt_visit_date']"));
    }

    public static WebElement comment() {
        return $(By.xpath("//*[@id='txt_comment']"));
    }

    public static WebElement buttonBookAppointment() {
        return $(By.xpath("//*[@id='btn-book-appointment']"));
    }
}
