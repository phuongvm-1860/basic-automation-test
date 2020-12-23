package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class AppointmentConfirmationPage extends TestBase {
    public static WebElement lb_facility() {
        return driver.findElement(By.xpath("//*[@id='facility']"));
    }

    public static WebElement lb_apply_for_hospital() {
        return driver.findElement(By.xpath("//*[@id='hospital_readmission']"));
    }

    public static WebElement lb_health_care() {
        return driver.findElement(By.xpath("//*[@id='program']"));
    }

    public static WebElement lb_visit_date() {
        return driver.findElement(By.xpath("//*[@id='visit_date']"));
    }

    public static WebElement lb_comment() {
        return driver.findElement(By.xpath("//*[@id='comment']"));
    }

    public static WebElement btn_goto_homepage() {
        return driver.findElement(By.xpath("//*[text()='Go to Homepage']"));
    }
}
