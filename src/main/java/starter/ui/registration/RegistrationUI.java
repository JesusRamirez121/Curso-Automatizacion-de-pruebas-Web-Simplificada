package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

public class RegistrationUI  {
    public static final Target REGISTATION_ALERT =
            Target.the("Registration alert").locatedBy("//div[contains(text(), 'Por favor')]");
    public static final Target NAME_INPUT =
            Target.the("Input name").locatedBy("//input[@id='name']");
    public static final Target LAST_NAME_INPUT =
            Target.the("Input last name").locatedBy("//input[@id='last-name']");
    public static final Target AGE_INPUT =
            Target.the("Input age").locatedBy("//input[@id='age']");
    public static final Target COUNTRY_INPUT =
            Target.the("Select country").locatedBy("//select[@id='country']");
    public static final Target SEX_MALE_RADIO =
            Target.the("Radio button sex male").locatedBy("//input[@id='sex-m']");
    public static final Target SEX_FEMALE_RADIO =
            Target.the("Radio button sex female").locatedBy("//input[@id='sex-f']");
    public static final Target EMAIL_INPUT =
            Target.the("Input email").locatedBy("//input[@id='email']");
    public static final Target DAY_MON_RADIO =
            Target.the("Radio button day Monday").locatedBy("//input[@id='monday']");
    public static final Target DAY_TUE_RADIO =
            Target.the("Radio button day Tuesday").locatedBy("//input[@id='tuesday']");
    public static final Target DAY_WED_RADIO =
            Target.the("Radio button day Wednesday").locatedBy("//input[@id='wednesday']");
    public static final Target DAY_THU_RADIO =
            Target.the("Radio button day Thursday").locatedBy("//input[@id='thursday']");
    public static final Target DAY_FRI_RADIO =
            Target.the("Radio button day Friday").locatedBy("//input[@id='friday']");
    public static final Target PICTURE_FILE_INPUT =
            Target.the("Input picture file").locatedBy("//input[@id='picture']");
    public static final Target SAVE_BTN =
            Target.the("Button save").locatedBy("//button[@id='save-btn']");
}
