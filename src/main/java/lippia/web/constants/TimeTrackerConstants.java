package lippia.web.constants;

public class TimeTrackerConstants {
    public static final String TIME_TRACKER_PAGE_TITLE = "xpath://*[@id=\"topbar-menu\"]/div/div[2]/div";
    public static final String LOGIN_PAGE_URL = "https://app.clockify.me/en/login";
    //routerlink="/tracker"
    public static final String BTN_MENU_TIME_TRACKER ="css:[routerlink='/tracker']";
    public static final String BTN_CALENDAR = "css:[data-cy='date-picker']";

    public static final String DATE_FIELD = "xpath://*[@class=\"today active start-date active end-date available\"]" ;
    public static final String START_TIME_FIELD = "xpath:(//input[@type='text'])[2]";
    public static final String END_TIME_FIELD = "xpath:(//input[@type='text'])[3]";
    public static final String ADD_MANUAL = "css:[data-cy='manual-mode']";
    public static final String ADD_BTN = "xpath:(//button[@type='button'])[2]";

    public static final String ADD_DESCRIPTION = "id:undefined";
    public static final String TXT_DESCRIPTION = "css:[data-cy='time-entry-description']";
    // public static final String BTN_ADD = "button.cl-btn.cl-btn-primary.cl-btn-sm.cl-d-block.cl-d-lg-custom-none";
}
