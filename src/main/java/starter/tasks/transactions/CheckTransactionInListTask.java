package starter.tasks.transactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import starter.models.TransactionModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckTransactionInListTask implements Task {
    private final TransactionModel data;
    private final String date;
    public CheckTransactionInListTask(TransactionModel data) {
        this.data = data;
        DateTimeFormatter from = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date = LocalDate.parse(data.getDate().trim(), from).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }


    public static Performable checkTransactionInList(TransactionModel data) {
        return instrumented(CheckTransactionInListTask.class, data);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        var driver = BrowseTheWeb.as(actor).getDriver();
        String xpath = String.format("//tr[td[normalize-space()='%s'] and td[contains(normalize-space(),'%s')] and td[contains(normalize-space(),'%s')]]",
                date, data.getAmount(), data.getDescription());

        if (driver.findElements(By.xpath(xpath)).isEmpty()) {
            throw new AssertionError("No se encontró la transacción con fecha " + date +
                    ", monto " + data.getAmount() + " y descripción " + data.getDescription());
        }
    }
}
