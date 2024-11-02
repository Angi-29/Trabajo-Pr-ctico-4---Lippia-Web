package lippia.web.constants;

public class TimeTrackerConstants {
    public static final String TIME_TRACKER_PAGE_TITLE = "xpath://*[@id=\"topbar-menu\"]/div/div[2]/div";
    public static final String LOGIN_PAGE_URL = "https://app.clockify.me/en/login";
    //routerlink="/tracker"
    public static final String BTN_MENU_TIME_TRACKER = "css:[routerlink='/tracker']";
    public static final String BTN_CALENDAR = "css:[data-cy='date-picker']";

    public static final String DATE_FIELD = "xpath:/html/body/app-root/default-layout/div[1]/main/div/tracker2/div/div/div/time-tracker-recorder/div/div/div/div[2]/div/single-date-picker2/div[2]/input-single-date/span/span/img";
    public static final String START_TIME_FIELD = "xpath:(//input[@type='text'])[2]";
    public static final String END_TIME_FIELD = "xpath:(//input[@type='text'])[3]";
    public static final String ADD_MANUAL = "css:[data-cy='manual-mode']";
    public static final String ADD_BTN = "xpath:(//button[@type='button'])[2]";

    public static final String ADD_DESCRIPTION = "id:undefined";
    public static final String TXT_DESCRIPTION = "css:[data-cy='time-entry-description']";
    public static final String DATE_FIELD_TEXT = "xpath:(//input[@type='text'])[4]";
    public static final String TAG_ENTRY_GROUP_HEADER = "xpath://entry-group-header";

    public static final String ADD_TIMER = "css:[data-cy='timer-mode']";
    public static final String ADD_NAME_DESCRIPTION = "id:undefined";
    public static final String BTN_START = "xpath:(//button[@type='button'])[2]";
    public static final String KEBAB_MENU = "xpath://*[@id=\"layout-main\"]/div/tracker2/div/div/div/time-tracker-recorder/div/div/div/div[2]/div/stopwatch/div[3]/div/div";
    public static final String DISCARD_OPTION = "xpath://*[@class=\"cl-dropdown-item cl-text-red\"]";
    public static final String BTN_DISCARD = "xpath://*[@class=\"cl-btn cl-btn-primary\"]";
    public static final String SELECTS_PROJECT = "xpath://*[@class=\"cl-component-divided-left cl-no-divider-border cl-pl-0 cl-dropdown-toggle cl-no-arrow cl-max-width-100\"]";

    public static final String SEARCH_PROJECT = "id:app-text-field-0";
    // public static final String MESSAGE_CANCELLED = ;
    // public static final String BTN_ADD = "button.cl-btn.cl-btn-primary.cl-btn-sm.cl-d-block.cl-d-lg-custom-none";
}
