package starter.ui.login;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;


@DefaultUrl("page:login.page.url")
public class LoginPage extends PageObject {
    public static final Target USERNAME_INPUT =
            Target.the("Input username").locatedBy("//input[@id='username']");
    public static final Target PASSWORD_INPUT =
            Target.the("Input password").locatedBy("//input[@id='password']");
    public static final Target LOGIN_BUTTON =
            Target.the("Login button").locatedBy("//button[@class='btn btn-primary']");
}
