package starter.ui.registration;

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
    public static final Target SEX_INPUT =
            Target.the("Select sex").locatedBy("//input[@value='{0}']");
    public static final Target EMAIL_INPUT =
            Target.the("Input email").locatedBy("//input[@id='email']");
    public static final Target DAY_RADIO =
            Target.the("Radio button day Monday").locatedBy("//input[@value='{0}']");
    public static final Target PICTURE_FILE_INPUT =
            Target.the("Input picture file").locatedBy("//input[@id='picture']");
    public static final Target SAVE_BTN =
            Target.the("Button save").locatedBy("//button[@id='save-btn']");
}
