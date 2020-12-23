package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class AppointmentPage extends TestBase {

    public AppointmentPage() {
    }

    public static WebElement cb_facility() {
        return $(By.xpath("//*[@id='combo_facility']"));
    }

    public static WebElement cb_apply_for_hospital() {
        return $(By.xpath("//*[@id='chk_hospotal_readmission']"));
    }

    public static WebElement radio_medicare() {
        return $(By.xpath("//*[@id='radio_program_medicare']"));
    }

    public static WebElement radio_medicaid() {
        return $(By.xpath("//*[@id='radio_program_medicaid']"));
    }

    public static WebElement radio_none() {
        return $(By.xpath("//*[@id='radio_program_none']"));
    }

    public static WebElement txt_visit_date() {
        return $(By.xpath("//*[@id='txt_visit_date']"));
    }

    public static WebElement txt_comment() {
        return $(By.xpath("//*[@id='txt_comment']"));
    }

    public static WebElement btn_book_appointment() {
        return $(By.xpath("//*[@id='btn-book-appointment']"));
    }
}

