package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class ConfirmationPage extends TestBase {
    private static WebElement element = null;

    public static WebElement confirmFacility() {
        element = $(By.xpath("//*[@id='facility']"));
        return element;
    }
    public static WebElement confirmApply() {
        element = $(By.xpath("//*[@id='hospital_readmission']"));
        return element;
    }
    public static WebElement confirmHealthcareProgram() {
        element = $(By.xpath("//*[@id='program']"));
        return element;
    }
    public static WebElement confirmVisitDate() {
        element = $(By.xpath("//*[@id='visit_date']"));
        return element;
    }
    public static WebElement confirmComment() {
        element = $(By.xpath("//*[@id='comment']"));
        return element;
    }
    public static WebElement goToButton() {
        element = $(By.xpath("//*[@class='btn btn-default']"));
        return element;
    }
}
