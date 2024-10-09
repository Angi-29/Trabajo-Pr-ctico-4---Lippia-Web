package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.LandingPageProjectConstants;
import lippia.web.constants.LandingPageWorkspaceConstants;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class LandingPageProjectService {

    public static void navegarWeb(){
        navigateTo( PropertyManager.getProperty("web.base.url"));

    }

    public static void clickOnLogIn() {
        WebActionManager.click(LandingPageProjectConstants.BUTTON_LOG_IN);
    }

    public static void performSuccessFulLogin(String email, String password, String button) {
    }
}

