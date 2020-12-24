package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class MakeAppointmentPage extends TestBase {
    private static WebElement element = null;

    public static WebElement facility() {
        element = $(By.xpath("//*[@id='combo_facility']"));
        return element;
    }

    public static WebElement checkbox() {
        element = $(By.xpath("//*[@id='chk_hospotal_readmission']"));
        return element;
    }

    public static WebElement optionMedicaid() {
        element = $(By.xpath("//*[@id='radio_program_medicaid']"));
        return element;
    }

    public static WebElement optionNone() {
        element = $(By.xpath("//*[@id='radio_program_none']"));
        return element;
    }

    public static WebElement optionMedicare() {
        element = $(By.xpath("//*[@id='radio_program_medicare']"));
        return element;
    }

    public static WebElement dateInput() {
        element = $(By.xpath("//*[@id='txt_visit_date']"));
        return element;
    }

    public static WebElement commentInput() {
        element = $(By.xpath("//*[@id='txt_comment']"));
        return element;
    }

    public static WebElement btnBookAppointment() {
        element = $(By.xpath("//*[@id='btn-book-appointment']"));
        return element;
    }

    public static WebElement resultFacility() {
        element = $(By.xpath("//*[@id='facility']"));
        return element;
    }

    public static WebElement resultHospitalReadmission() {
        element = $(By.xpath("//*[@id='hospital_readmission']"));
        return element;
    }

    public static WebElement resultHealthcareProgram() {
        element = $(By.xpath("//*[@id='program']"));
        return element;
    }

    public static WebElement resultDate() {
        element = $(By.xpath("//*[@id='visit_date']"));
        return element;
    }

    public static WebElement resultComment() {
        element = $(By.xpath("//*[@id='comment']"));
        return element;
    }
}