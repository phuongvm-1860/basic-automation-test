package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class ConfirmationAppointmentPage extends TestBase {
    public static WebElement facilityInfo() { return $(By.xpath("//p[@id='facility']")); }

    public static WebElement applyInfo() {
        return $(By.xpath("//p[@id='hospital_readmission']"));
    }

    public static WebElement healthcareProgramInfo() {
        return $(By.xpath("//p[@id='program']"));
    }

    public static WebElement dateInfo() {
        return $(By.xpath("//p[@id='visit_date']"));
    }

    public static WebElement commentInfo() {
        return $(By.xpath("//p[@id='comment']"));
    }

    public static WebElement homePageBtn() {return $(By.xpath("//*[@class='btn btn-default']")); }
}
