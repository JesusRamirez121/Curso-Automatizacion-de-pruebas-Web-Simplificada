package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.models.RegistrationModel;
import starter.ui.registration.RegistrationUI;
import starter.utils.EsperaUtil;

import java.net.URISyntaxException;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterUser implements Task {
    private final RegistrationModel data;
    public  RegisterUser(RegistrationModel data) {
        this.data = data;
    }

    public static Performable registerUser(RegistrationModel data) {
        return instrumented(RegisterUser.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(RegistrationUI.NAME_INPUT, isVisible()).forNoMoreThan(5).seconds(),
                    Enter.theValue(data.getNombres()).into(RegistrationUI.NAME_INPUT),
                    Enter.theValue(data.getApellidos()).into(RegistrationUI.LAST_NAME_INPUT),
                    Enter.theValue(data.getEdad()).into(RegistrationUI.AGE_INPUT),
                    SelectFromOptions.byVisibleText(data.getPais()).from(RegistrationUI.COUNTRY_INPUT),
                    Click.on(RegistrationUI.SEX_INPUT.of(data.getSexo())),
                    Enter.theValue(data.getEmail()).into(RegistrationUI.EMAIL_INPUT),
                    Click.on(RegistrationUI.DAY_RADIO.of(data.getDia())),
                    Upload.theClasspathResource(data.getFoto()).to(RegistrationUI.PICTURE_FILE_INPUT),
                    Click.on(RegistrationUI.SAVE_BTN)
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
