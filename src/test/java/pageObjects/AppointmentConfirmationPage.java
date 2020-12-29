package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class AppointmentConfirmationPage extends TestBase {
    private static WebElement element = null;

    public AppointmentConfirmationPage() { }

    public static WebElement facilityInfo() {
        return $(By.xpath("//*[@id='facility']"));
    }

    public static WebElement readmissionInfo () {
        return $(By.xpath("//*[@id='hospital_readmission']"));
    }

    public static WebElement programInfo() {
        return $(By.xpath("//*[@id='program']"));
    }

    public static WebElement dateInfo() {
        return $(By.xpath("//*[@id='visit_date']"));
    }

    public static WebElement commentInfo() {
        return $(By.xpath("//*[@id='comment']"));
    }

    public static WebElement goToHomePage() { return $(By.xpath("//*[@class='btn btn-default']"));}
}
