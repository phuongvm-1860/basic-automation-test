package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class AppointmentPage extends TestBase {
    private static WebElement element = null;

    public AppointmentPage() {
    }

    public static WebElement facilityBox() {
        return $(By.xpath("//*[@id='combo_facility']"));
    }

    public static WebElement readmission() {
        return $(By.xpath("//*[@id='chk_hospotal_readmission']"));
    }

    public static WebElement healthProgram() {
        return $(By.xpath("//*[@id='radio_program_medicare']"));
    }

    public static WebElement healthProgram2() {
        return $(By.xpath("//*[@id='radio_program_medicaid']"));
    }

    public static WebElement healthProgram3() {
        return $(By.xpath("//*[@id='radio_program_none']"));
    }

    public static WebElement visitDateTextbox() {
        return $(By.xpath("//*[@id='txt_visit_date']"));
    }

    public static WebElement visitDateButton() {
        return $(By.xpath("//*[@id='input-group-addon']"));
    }

    public static WebElement commentBox() {
        return $(By.xpath("//*[@id='txt_comment']"));
    }

    public static WebElement BookButton() {
        return $(By.xpath("//*[@id='btn-book-appointment']"));
    }

}
