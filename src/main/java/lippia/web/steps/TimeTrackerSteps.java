package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.lippia.api.lowcode.variables.VariablesManager;
import lippia.web.constants.TimeTrackerConstants;
import lippia.web.services.LogInService;
import lippia.web.services.TimeTrackerService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import lippia.web.utils.AlphanumericGenerator;

import static lippia.web.constants.TimeTrackerConstants.LOGIN_PAGE_URL;

public class TimeTrackerSteps extends PageSteps {

    private String description;

    @Then("The client is on the time tracker page")
    public void theClientIsOnTheTimeTrackerPage() {
        LogInService.verifyClientIsOnTimeTrackerPage();
    }

    @Then("The client should see an error message {string}")
    public void theClientShouldSeeAnErrorMessage(String expectedMessage) {
        LogInService.verifyErrorMessage();
        String errorMessage = VariablesManager.getVariable("errorMessage").toString();
        Assert.assertEquals(errorMessage, expectedMessage);
    }


    @Then("The client should then be redirected to the login page {string}")
    public void theClientShouldThenBeRedirectedToTheLoginPage(String url) {
        Assert.assertEquals("https://app.clockify.me/en/login", LOGIN_PAGE_URL);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Cierra el navegador después del escenario
            System.out.println("Navegador cerrado después del escenario");
        }
    }

    @And("the user clicks Time Tracker")
    public void theUserClicksTimeTracker() {
        TimeTrackerService.clickTimeTracker();
    }

    @Given("the user clicks add manual")
    public void theUserClicksAddManual() {
        TimeTrackerService.theUserClicksAddManual();
    }

    @And("the user click on the calendar")
    public void theUserClicksOnTheCalendar() {
        TimeTrackerService.clickOnTheCalendar();
    }

    @And("The user enters the date {string}")
    public void theUserEntersTheDate(String date) {
        TimeTrackerService.enterDate(date);
    }

    @And("The user sets the start time to {string}")
    public void theUserSetsTheStartTimeTo(String starTime) {
        TimeTrackerService.setStartTime(starTime);
    }

    @And("The user sets the end time to {string}")
    public void theUserSetsTheEndTimeTo(String endTime) {
        TimeTrackerService.setEndTime(endTime);
    }

    @And("the user clicks the Add button")
    public void theUserClicksTheAddButton() {
        TimeTrackerService.clickAddButton();
    }

    @And("the user add description {string}")
    public void theUserAddDescription(String desc) {
        this.description = desc + "_" + AlphanumericGenerator.generateAlphanumeric(4);
        TimeTrackerService.addDescription(this.description);
    }


    @Then("the user sees the recorded time tracker")
    public void theUserSeesTheRecordedTimeTracker() {
        boolean flag = TimeTrackerService.searchDescription(this.description);
        System.out.println("");
    }
}












