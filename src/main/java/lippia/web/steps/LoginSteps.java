package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.LandingPageService;
import lippia.web.services.LogInService;

import static org.bouncycastle.cms.RecipientId.password;

public class LoginSteps extends PageSteps {


    @Given( "The client is on landing page" )
    public void theClientIsOnLandingPage() {
        LandingPageService.navegarWeb();
    }

    @And( "The client click on 'Log In'" )
    public void theClientClickOnLogIn() {
        LandingPageService.clickOnLogIn();
    }

    @And( "The client click on 'Log in manually'" )
    public void theClientClickOnLogInManually() {
        LogInService.logInManually();
    }

    @And( "The client set the email '(.*)'" )
    public void theClientSetTheEmailCuentaparapruebasGmailCom(String email) {
        LogInService.setEmail( email );
    }

    @And( "The client set the password {string}" )
    public void theClientSetThePasswordContrasena(String password) {
        LogInService.setPassword( password );

    }

    @And("The client click on button {string}")
    public void theClientClickOnLoginButton(String button) {
        LogInService.clickLoginButton(button);
    }
    @Given("The client is successfully logged in with email {string}, password {string}, and button {string}")
    public void theClientIsSuccessfullyLoggedInWithEmailCuentaparapruebasGmailComPasswordContrasenaAndButton(String email, String password, String button) {
        LogInService.performSuccessFulLogin(email, password, button);
    }

    @When("The client click the profile menu button")
    public void theClientClickTheProfileMenuButton() {
        LogInService.clickProfileMenuButton();

    }

    @And("The client click on 'Sign out'")
    public void theClientClickOnSignOut() {
        LogInService.clickSignOut();
        
    }


}







