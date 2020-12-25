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

    //*[@class='btn btn-default']


    public static WebElement applyCheckbox() {
        element = $(By.xpath("//*[@for='chk_hospotal_readmission']"));
        return element;
    }

    public static WebElement MedicareRadiobtn() {
        element = $(By.xpath("//*[@id='radio_program_medicare']"));
        return element;
    }



    public static WebElement MedicaidRadiobtn() {
        element = $(By.xpath("//*[@id='radio_program_medicaid']"));
        return element;
    }

    public static WebElement NoneRadiobtn() {
        element = $(By.xpath("//*[@id='radio_program_none']"));
        return element;
    }

    public static WebElement dateBox() {
        element = $(By.xpath("//*[@id='txt_visit_date']"));
        return element;
    }

    public static WebElement commentBox() {
        element = $(By.xpath("//*[@id='txt_comment']"));
        return element;
    }

    public static WebElement BookAppointmentbtn() {
        element = $(By.xpath("//*[@id='btn-book-appointment']"));
        return element;
    }
}