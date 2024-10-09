package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lippia.web.services.LandingPageWorkspaceService;
import lippia.web.services.WorkspaceService;
import org.openqa.selenium.WebDriver;

public class WorkspaceSteps extends PageSteps {
    private WebDriver driver;
    private WorkspaceService workspaceService;
    private Object button;
    private String option;

    public static void verifyWorkspaceCreated(String crowdarAcademyTests) {
    }


    @Given("The clients is on landing page")
    public void theClientsIsOnLandingPage() {
        LandingPageWorkspaceService.navegarWeb();
    }

    @And("The client clicks on {string}")
    public void theClientClicksOnLogIn() {
        LandingPageWorkspaceService.clickOnLogIn();
    }

    @Given("The client is logged in with email {string}, password {string} and click on button {string}")
    public void theClientIsLoggedInWithEmailCuentaparapruebasGmailComPasswordContrasenaAndClickOnButtonLogin(String email, String password, String button) {
        WorkspaceService.performSuccessFulLogin(email, password, button);
    }

    @When("The client clicks on the Meatballs menu and selects {string}")
    public void theClientClicksOnTheMeatballsMenuAndSelectsManageWorkspaces(String option) {
        if (option.equals("Manage Workspaces")) {
            WorkspaceService.navigateToManageWorkspaces();
        }
    }

    @And("the client clicks the {string} button")
    public void theClientClicksTheCreateNewWorkspaceButton(String buttonName) {
        if ("Create new workspace".equals(buttonName)) {
            WorkspaceService.clickCreateNewWorkspaceButton();
        }

    }

    @And("the client enters a valid name {string}")
    public void theClientEntersAValidNameCrowdarAcademyTests(String workspaceName) {

    }

    @And("the client clicks on the 'create' button")
    public void theClientClicksOnTheCreateButton() {
            WorkspaceService.clickCreateButton();
    }
}







