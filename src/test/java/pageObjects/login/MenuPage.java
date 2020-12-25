package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utility.TestBase.$;

public class MenuPage {

    public MenuPage(){
    }
    public static WebElement menuBarBtn() { return $(By.xpath("//*[@id='menu-toggle']"));
    }
}
