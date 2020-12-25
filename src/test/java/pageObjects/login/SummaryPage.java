package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.TestBase;

public class SummaryPage extends TestBase {
    private static WebElement element = null;
    public SummaryPage(){}
    public static WebElement facilityBox(){
        element = $(By.xpath("//*[@id=\"facility\"]"));
        return element;
    }
    public static WebElement apply(){
        element = $(By.xpath("//*[@id=\"hospital_readmission\"]"));
        return element;
    }
    public static WebElement program(){
        element = $(By.xpath("//*[@id=\"program\"]"));
        return element;
    }
    public static WebElement date(){
        element = $(By.xpath("//*[@id=\"visit_date\"]"));
        return element;
    }
    public static WebElement comment(){
        element = $(By.xpath("//*[@id=\"comment\"]"));
        return element;
    }
    public static WebElement homepageButton(){
        element = $(By.xpath("//*[@class=\"btn btn-default\"]"));
        return element;
    }
}
