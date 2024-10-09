package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.LandingPageConstants;
import lippia.web.constants.LandingPageWorkspaceConstants;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class LandingPageWorkspaceService {

    public static void navegarWeb(){
        navigateTo( PropertyManager.getProperty("web.base.url"));

    }

    public static void clickOnLogIn() {
        WebActionManager.click(LandingPageWorkspaceConstants.BUTTON_LOG_IN);
    }
}

