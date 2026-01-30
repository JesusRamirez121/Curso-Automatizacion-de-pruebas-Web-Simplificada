package starter.ui.registration;

import net.serenitybdd.screenplay.targets.Target;

public class SummaryUi {
    private SummaryUi() {
        throw new IllegalStateException("Utility class");
    }
    public static final String SUMMARY_TITLE = "Summary";
    public static final Target SUMMARY_NOMBRE =
            Target.the("Summary NOMBRE").locatedBy("//strong[contains(text(), 'Nombre')]/parent::p");

    public static final Target SUMMARY_APELLIDO =
            Target.the("Summary APELLIDO").locatedBy("//strong[contains(text(), 'Apellido')]/parent::p");

    public static final Target SUMMARY_EDAD =
            Target.the("Summary EDAD").locatedBy("//strong[contains(text(), 'Edad')]/parent::p");

    public static final Target SUMMARY_PAIS =
            Target.the("Summary PAIS").locatedBy("//strong[contains(text(), 'País')]/parent::p");

    public static final Target SUMMARY_SEXO =
            Target.the("Summary SEXO").locatedBy("//strong[contains(text(), 'Sexo')]/parent::p");

    public static final Target SUMMARY_EMAIL =
            Target.the("Summary EMAIL").locatedBy("//strong[contains(text(), 'Email')]/parent::p");

    public static final Target SUMMARY_DIAS =
            Target.the("Summary DIAS").locatedBy("//strong[contains(text(), 'Días')]/parent::p");

}
