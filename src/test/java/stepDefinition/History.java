//package stepDefinition;
//
//import cucumber.api.DataTable;
//import cucumber.api.PendingException;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Then;
//import org.junit.Assert;
//import pageObjects.login.HistoryPage;
//
//import java.util.List;
//import java.util.Map;
//
//public class History {
//    @And("^user click on icon menu$")
//    public void userClickOnIconMenu() {
//        HistoryPage.menuHistory().click();
//    }
//
//    @And("^user click on History button$")
//    public void userClickOnHistoryButton() {
//        HistoryPage.buttonHistory().click();
//    }
//
//    @Then("^user sees history appointment$")
//    public void userSeesHistoryAppointment(DataTable table) {
//        List<Map<String, String>> data = table.asMaps(String.class, String.class);
//        for (int i = 0; i < data.size(); i++) {
//            Assert.assertEquals(HistoryPage.facilityHistory().get(i).getText(), data.get(i).get("facility"));
//            Assert.assertEquals(HistoryPage.hospitalHistory().get(i).getText(), data.get(i).get("check"));
//            Assert.assertEquals(HistoryPage.programlHistory().get(i).getText(), data.get(i).get("healthcare_program"));
//            Assert.assertEquals(HistoryPage.dateHistory().get(i).getText(), data.get(i).get("visit_date"));
//            Assert.assertEquals(HistoryPage.commentHistory().get(i).getText(), data.get(i).get("comment"));
//        }
//    }
//}

