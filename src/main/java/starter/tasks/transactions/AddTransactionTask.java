package starter.tasks.transactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.models.TransactionModel;
import starter.ui.transaction.TransactionPage;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddTransactionTask {
    public static Performable transaction(TransactionModel data) {
        return Task.where("{0} adds a new transaction",
                WaitUntil.the(TransactionPage.NEW_TRANSACTION_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(TransactionPage.NEW_TRANSACTION_BUTTON),
                Enter.theValue(data.getDate()).into(TransactionPage.DATE_INPUT),
                Enter.theValue(data.getAmount()).into(TransactionPage.AMOUNT_INPUT),
                Enter.theValue(data.getDescription()).into(TransactionPage.DESCRIPTION_INPUT),
                Click.on(TransactionPage.SAVE_BUTTON)
        );
    }
}
