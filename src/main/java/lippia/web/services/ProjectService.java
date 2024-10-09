package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import org.openqa.selenium.WebDriver;

import static com.crowdar.core.actions.ActionManager.click;
import static lippia.web.constants.ProjectConstants.*;



public class ProjectService {
    private static WebDriver driver;



    public ProjectService() {
        ProjectService.driver = driver;
    }


    public static void performSuccessFulLogin(String email, String password, Object button) {
        click(LOG_IN_MANUALLY);
        WebActionManager.setInput(EMAIL_INPUT, email);
        WebActionManager.setInput(PASSWORD_INPUT, String.valueOf(password));
        click(LOG_IN_BUTTON, (String) button);
    }



}
