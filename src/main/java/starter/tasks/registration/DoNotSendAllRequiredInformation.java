package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.registration.RegistrationUI;
import starter.utils.EsperaUtil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DoNotSendAllRequiredInformation implements Task {
    private final String expectedNombres;
    private final String expectedApellidos;

    public DoNotSendAllRequiredInformation(String expectedNombres, String expectedApellidos) {
        this.expectedNombres = expectedNombres;
        this.expectedApellidos = expectedApellidos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(RegistrationUI.NAME_INPUT, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(expectedNombres).into(RegistrationUI.NAME_INPUT),
                Enter.theValue(expectedApellidos).into(RegistrationUI.LAST_NAME_INPUT),
                Click.on(RegistrationUI.SAVE_BTN)
        );
    }
}
