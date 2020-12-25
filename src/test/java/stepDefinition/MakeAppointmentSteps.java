package stepDefinition;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.AppointmentPage;
import pageObjects.login.SummaryPage;
import utility.GetPropertiesValue;
import utility.ScenarioContext;
import utility.TestBase;

public class MakeAppointmentSteps extends TestBase {

    @When("^user select facility as \"([^\"]*)\"$")
    public void userSelectFacilityAs(String facilityBox) {
        Select facilities = new Select(AppointmentPage.facilityBox());
        facilities.selectByVisibleText(facilityBox);
    }

    @And("^user \"([^\"]*)\" apply$")
    public void userApply(String action) {
        if (action.equals("tick"))
            AppointmentPage.apply().click();
    }

    @And("^user chooses \"([^\"]*)\"$")
    public void userChooses(String program) {
        if (program.equals("Medicare"))
            AppointmentPage.medicare().click();
        else if (program.equals("Medicaid"))
            AppointmentPage.medicaid().click();
        else AppointmentPage.none().click();
    }

    @And("^user decides \"([^\"]*)\"$")
    public void userDecides(String date) {
        AppointmentPage.date().sendKeys(date);
    }

    @And("^user adds \"([^\"]*)\"$")
    public void userAdds(String comment) {
        AppointmentPage.comment().sendKeys(comment);
    }

    @And("^user clicks on Book appointment button$")
    public void userClicksOnBookAppointmentButton() {
        AppointmentPage.bookingButton().click();
    }

    @Then("^user created appointment successfully$")
    public void userCreatedAppointmentSuccessfully() {driver.getCurrentUrl();
        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary",driver.getCurrentUrl());
    }

    @And("^user sees \"([^\"]*)\" as input$")
    public void userSeesAsInput(String facility) {
        Assert.assertEquals(facility,SummaryPage.facilityBox().getText());
    }

    @And("^user observes \"([^\"]*)\" as input$")
    public void userObservesAsInput(String action) {
        if (action.equals("tick"))
            Assert.assertEquals("Yes",SummaryPage.apply().getText());
        else Assert.assertEquals("No",SummaryPage.apply().getText());
    }

    @And("^user can see \"([^\"]*)\" as input$")
    public void userCanSeeAsInput(String program) {
        Assert.assertEquals(program,SummaryPage.program().getText());
    }

    @And("^user can observe \"([^\"]*)\" as input$")
    public void userCanObserveAsInput(String date){
        Assert.assertEquals(date,SummaryPage.date().getText());
    }

    @And("^user notices \"([^\"]*)\" as input$")
    public void userNoticesAsInput(String comment) {
        Assert.assertEquals(comment,SummaryPage.comment().getText());
    }

    @Then("^user clicks homepage button$")
    public void userClicksHomepageButton() {SummaryPage.homepageButton().click();
    }
}
