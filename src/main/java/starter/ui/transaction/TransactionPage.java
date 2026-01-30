package starter.ui.transaction;

import net.serenitybdd.screenplay.targets.Target;

public class TransactionPage {
    public static final Target NEW_TRANSACTION_BUTTON =
            Target.the("New Transaction button").locatedBy("//button[contains(text(), 'Añadir transacción')]");

    public static final Target TRANSACTION_LIST =
            Target.the("Transaction list").locatedBy("//tbody[@id='transactions-list']");

    public static final Target DATE_INPUT =
            Target.the("Date input field").locatedBy("//input[@id='date']");

    public static final Target AMOUNT_INPUT =
            Target.the("Amount input field").locatedBy("//input[@id='amount']");

    public static final Target DESCRIPTION_INPUT =
            Target.the("Description input field").locatedBy("//input[@id='description']");

    public static final Target SAVE_BUTTON =
            Target.the("Save button").locatedBy("//button[contains(text(), 'Guardar')]");
}
