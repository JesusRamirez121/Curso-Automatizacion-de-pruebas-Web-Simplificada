package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.models.RegistrationModel;
import starter.ui.registration.SummaryUi;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckNewAccountCreated implements Task {

    private final RegistrationModel data;
    public  CheckNewAccountCreated(RegistrationModel data) {
        this.data = data;
    }

    public static Performable checkUser(RegistrationModel data) {
        return instrumented(CheckNewAccountCreated.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toWindowTitled(SummaryUi.SUMMARY_TITLE),
                Ensure.that(SummaryUi.SUMMARY_NOMBRE).text().contains(data.getNombres()),
                Ensure.that(SummaryUi.SUMMARY_APELLIDO).text().contains(data.getApellidos()),
                Ensure.that(SummaryUi.SUMMARY_EDAD).text().contains(data.getEdad()),
                Ensure.that(SummaryUi.SUMMARY_PAIS).text().contains(data.getPais()),
                Ensure.that(SummaryUi.SUMMARY_SEXO).text().contains(data.getSexo()),
                Ensure.that(SummaryUi.SUMMARY_EMAIL).text().contains(data.getEmail()),
                Ensure.that(SummaryUi.SUMMARY_DIAS).text().contains(data.getDia())
        );
    }
}
