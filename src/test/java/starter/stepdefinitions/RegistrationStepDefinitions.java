package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.models.RegistrationModel;
import starter.tasks.registration.CheckNewAccountCreated;
import starter.tasks.registration.DoNotSendAllRequiredInformation;
import starter.tasks.registration.RegisterUser;
import starter.ui.registration.RegisterPage;
import starter.ui.registration.RegistrationUI;
import starter.utils.registration.DataTableRegistration;

import java.util.Map;

public class RegistrationStepDefinitions {

    String expectedNombres = "Jesus";
    String expectedApellidos = "Garcia";

    @Given("{actor} wants to sign up in the application")
    public void wantsToSignUpInTheApplication(Actor actor){
        actor.usingAbilityTo(BrowseTheWeb.class).getDriver().manage().window().maximize();
        actor.attemptsTo(Open.browserOn(new RegisterPage()));
    }

    @When("{actor} sends the required information to sign up")
    public void sendsTheRequiredInformationToSignUp(Actor actor, DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps().get(0);
        DataTableRegistration converter = new DataTableRegistration();
        RegistrationModel data = converter.mapToRegistrationModel(datos);
        actor.attemptsTo(RegisterUser.registerUser(data));

    }

    @Then("{actor} should have a new account created")
    public void shouldHaveANewAccountCreated(Actor actor, DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps().get(0);
        DataTableRegistration converter = new DataTableRegistration();
        RegistrationModel data = converter.mapToRegistrationModel(datos);
        actor.attemptsTo(CheckNewAccountCreated.checkUser(data));
    }

    @When("{actor} does not send the required information")
    public void doesNotSendTheRequiredInformation(Actor actor) {
        actor.attemptsTo(new DoNotSendAllRequiredInformation(expectedNombres, expectedApellidos)
        );
    }

    @Then("{actor} should be told all fields are required")
    public void shouldBeToldAllFieldsAreRequired(Actor actor) {
        actor.attemptsTo(
                Ensure.that(RegistrationUI.REGISTATION_ALERT).text().contains("Por favor")
        );
    }
}
