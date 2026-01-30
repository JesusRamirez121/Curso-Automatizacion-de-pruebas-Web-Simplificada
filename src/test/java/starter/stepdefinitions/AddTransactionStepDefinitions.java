package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import starter.models.LoginModel;
import starter.models.TransactionModel;
import starter.tasks.login.LoginUser;
import starter.tasks.transactions.CheckTransactionInListTask;
import starter.tasks.transactions.AddTransactionTask;
import starter.ui.login.LoginPage;
import starter.utils.login.DataTableLogin;
import starter.utils.transaction.DataTableTransaction;

import java.util.Map;

public class AddTransactionStepDefinitions {
    @Given("{actor} is logged into the application")
    public void isLoggedIntoTheApplication(Actor actor, DataTable dataTable) {
        actor.usingAbilityTo(BrowseTheWeb.class).getDriver().manage().window().maximize();
        actor.attemptsTo(Open.browserOn(new LoginPage()));
        Map<String, String> datos = dataTable.asMaps().get(0);
        DataTableLogin converter = new DataTableLogin();
        LoginModel data = converter.mapToLoginModel(datos);
        actor.attemptsTo(LoginUser.loginUser(data));

    }

    @When("{actor} enters the required information for the new transaction")
    public void entersTheRequiredInformationForTheNewTransaction(Actor actor, DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps().get(0);
        DataTableTransaction converter = new DataTableTransaction();
        TransactionModel data = converter.mapToTransactionModel(datos);
        actor.attemptsTo(AddTransactionTask.transaction(data));
    }

    @Then("{actor} should see a new transaction in the transaction list with correct details")
    public void shouldSeeANewTransactionInTheTransactionListWithCorrectDetails(Actor actor, DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps().get(0);
        DataTableTransaction converter = new DataTableTransaction();
        TransactionModel data = converter.mapToTransactionModel(datos);
        actor.attemptsTo(CheckTransactionInListTask.checkTransactionInList(data));

    }
}
