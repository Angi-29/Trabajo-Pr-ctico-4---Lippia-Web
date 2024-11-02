package lippia.web.constants;

public class ModifyTimeTrakerConstans {

    public static String BULK_DESCRIPTION_CHECK = "css:label[for='desc-1']";
    public static String BULK_DESCRIPTION_TXT = "xpath://input[@type='text' and contains(@name, 'descriptionName')]";
    public static String BULK_PROJECT_CHECK = "css:label[for='proj-1']";
    public static String BULK_PROJECT_BUTTON = "xpath://button[@type='button' and contains(@data-cy, 'project-dropdown')]";
    public static String BULK_PROJECT_TEXT = "xpath://input[@type='text' and contains(@id, 'app-text-field-0')]";
    public static String BULK_TIME_CHECK = "css:label[for='time-1']";
    public static String BULK_TIME_START_TXT = "xpath://ngb-modal-window//input-time-ampm[1]/input";
    public static String BULK_TIME_END_TXT = "xpath://ngb-modal-window//input-time-ampm[2]/input";
    public static String BULK_DATE_CHECK = "css:label[for='date-1']";
    public static String BULK_DATE_TXT = "xpath:(//ngb-modal-window//time-entry-bulk-edit//single-date-picker2//input)[3]";
    public static String BULK_SAVE_BTN = "xpath://ngb-modal-window//time-entry-bulk-edit//app-button/button";
}
