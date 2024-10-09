package lippia.web.constants;

import org.openqa.selenium.By;

public class WorkspaceConstants {
    public static final String LOGIN_PAGE_URL = "https://app.clockify.me/";
    public static final String LOG_IN_MANUALLY = "xpath://*[@data-test-id='login-manual']";
    public static final String EMAIL_INPUT = "id:email";
    public static final String PASSWORD_INPUT = "xpath://*[@class='cl-form-control']";
    public static final String LOG_IN_BUTTON = "xpath://*[@data-test-id='login-button']";

    public static final String MEATBALLS_MENU = "xpath://*[@class='cl-rotate-90 cl-topbar-options-toggler']";
    public static final String MANAGE_WORKSPACES_OPTION = "xpath://a[contains(text(), 'Manage workspaces')]";
    public static final String CREATE_NEW_WORKSPACE_BUTTON = "xpath://*[@class=\"cl-btn cl-btn-outline-primary cl-d-none-print\"]";
    public static final String WORKSPACE_NAME_INPUT = "xpath://*[@class=\"cl-form-control ng-pristine ng-invalid ng-touched\"]";
    public static final String CREATE_BUTTON = "xpath://*[@class=\"cl-btn cl-btn-primary\"]";

    public static final String WORKSPACE_CREATED_XPATH = "xpath://*[@id=\"cdk-drop-list-0\"]/li[2]/div/a/div/span[1]/img";
}
