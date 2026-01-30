package starter.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.models.LoginModel;
import starter.ui.login.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginUser implements Task {
    private final LoginModel data;
    public LoginUser(LoginModel data) {
        this.data = data;
    }
    public static Performable loginUser(LoginModel data) {
        return instrumented(LoginUser.class, data);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.USERNAME_INPUT, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(LoginPage.USERNAME_INPUT),
                Enter.theValue(data.getUsername()).into(LoginPage.USERNAME_INPUT),
                Enter.theValue(data.getPassword()).into(LoginPage.PASSWORD_INPUT),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
