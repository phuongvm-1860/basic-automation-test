package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class ConfirmationPage extends TestBase {
    private static WebElement element = null;

    public ConfirmationPage() {
    }

    public static WebElement readmission() {
        return $(By.xpath("//*[@id='hospital_readmission']"));
    }

    public static WebElement facility(){
        return $(By.xpath("//*[@id='facility']"));
    }

    public static WebElement program(){
        return $(By.xpath("//*[@id='program']"));
    }

    public static WebElement visitDate(){
        return $(By.xpath("//*[@id='visit_date']"));
    }

    public static WebElement comment(){
        return $(By.xpath("//*[@id='comment']"));
    }

    public static WebElement goToHomepage(){
        return $(By.xpath("//*[@class='btn btn-default']"));
    }
}
