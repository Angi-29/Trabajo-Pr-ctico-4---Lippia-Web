package lippia.web.services;

import TimeTrackerConstants.TimeTrackerConstants;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.LogInConstants;
import org.openqa.selenium.WebDriver;


public class LogInService {
    private WebDriver driver;

    public static void logInManually() {
        WebActionManager.click(LogInConstants.LOG_IN_MANUALLY);
    }
    public static void setEmail(String email) {
        WebActionManager.setInput(LogInConstants.EMAIL_INPUT, email);
    }
    public static void setPassword(String password) {
        WebActionManager.setInput(LogInConstants.PASSWORD_INPUT, password);
    }
    public static void clickLoginButton(String button) {
        WebActionManager.click(LogInConstants.LOG_IN_BUTTON, button);
    }


    public static void verifyClientIsOnTimeTrackerPage() {
        WebActionManager.waitVisibility(TimeTrackerConstants.TIME_TRACKER_PAGE_TITLE);
    }

    public static void verifyErrorMessage(String expectedMessage) {
        String actualMessage = WebActionManager.getText(LogInConstants.ERROR_MESSAGE);

    }

    public static void performSuccessFulLogin(String email, String password, String button) {
        WebActionManager.click(LogInConstants.LOG_IN_MANUALLY);
        WebActionManager.setInput(LogInConstants.EMAIL_INPUT, email);
        WebActionManager.setInput(LogInConstants.PASSWORD_INPUT, password);
        WebActionManager.click(LogInConstants.LOG_IN_BUTTON, button);
    }

    public static void clickProfileMenuButton(){
        WebActionManager.click(LogInConstants.PROFILE_MENU_BUTTON);
    }

    public static void clickSignOut() {
        WebActionManager.click(LogInConstants.SIGN_OUT_OPTION);
    }

    public boolean isRedirectedToLoginPage (){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.endsWith(TimeTrackerConstants.LOGIN_PAGE_URL);
    }

}
