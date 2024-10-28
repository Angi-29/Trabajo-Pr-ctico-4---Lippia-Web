package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.lippia.api.lowcode.variables.VariablesManager;
import lippia.web.services.LogInService;
import org.testng.Assert;

import static lippia.web.constants.TimeTrackerConstants.LOGIN_PAGE_URL;

public class TimeTrackerSteps extends PageSteps {


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

}







