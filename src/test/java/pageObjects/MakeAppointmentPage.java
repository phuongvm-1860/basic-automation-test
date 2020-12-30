package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class MakeAppointmentPage extends TestBase {

    public static WebElement facility() { return $(By.xpath("//select")); }

    public static WebElement checkbox() { return $(By.xpath("//input[@name='hospital_readmission']")); }

    public static WebElement comment() {
        return $(By.xpath("//textarea[@id='txt_comment']"));
    }

    public static WebElement bookBtn() {
        return $(By.xpath("//button[@type='submit']"));
    }

    public static WebElement inputDate() {
        return $(By.xpath("//input[@id='txt_visit_date']"));
    }

    public static WebElement radioBtn_medicare() { return $(By.xpath("//input[@id='radio_program_medicare']")); }

    public static WebElement radioBtn_medicaid() { return $(By.xpath("//input[@id='radio_program_medicaid']")); }

    public static WebElement radioBtn_none() { return $(By.xpath("//input[@id='radio_program_none']"));}
}
