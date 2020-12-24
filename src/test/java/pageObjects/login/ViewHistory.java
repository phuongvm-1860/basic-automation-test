package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

import java.util.List;

public class ViewHistory extends TestBase {
    private static WebElement element = null;

    public ViewHistory() {

    }

    public static WebElement menu() {
        return $(By.xpath("//*[@class='fa fa-bars']"));
    }

    public static WebElement btnViewHistory() {
        return $(By.xpath("//*[@href='history.php#history']"));
    }

    public static WebElement btnHomePage() {
        return $(By.xpath("//*[@href='https://katalon-demo-cura.herokuapp.com/']"));
    }

    public static WebElement btnMakeAppointment() {
        return $(By.xpath("//*[@id='btn-make-appointment']"));
    }

    public static List<WebElement> historyDate() {
        return $$(By.xpath("//*[@class='panel-heading']"));
    }

    public static List<WebElement> historyFacility() {
        return $$(By.xpath("//*[@id='facility']"));
    }

    public static List<WebElement> historyHealthcareProgram() {
        return $$(By.xpath("//*[@id='program']"));
    }

    public static List<WebElement> historyHospitalReadmission() {
        return $$(By.xpath("//*[@id='hospital_readmission']"));
    }

    public static List<WebElement> historyComment() {
        return $$(By.xpath("//*[@id='comment']"));
    }
}