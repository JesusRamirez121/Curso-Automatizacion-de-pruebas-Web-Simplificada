package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import starter.models.TransactionModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GetTransactionInfo {
    public static Question<String> getDescription(TransactionModel data){
        return Question.about("transaction description").answeredBy(actor -> {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();

            DateTimeFormatter from = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = LocalDate.parse(data.getDate().trim(), from)
                    .format(DateTimeFormatter.ISO_LOCAL_DATE);

            String xpathRow = String.format("//tr[td[normalize-space()='%s'] and td[contains(normalize-space(),'%s')] and td[contains(normalize-space(),'%s')]]",
                    date, data.getAmount(), data.getDescription());

            List<WebElement> rows = driver.findElements(By.xpath(xpathRow));
            if (rows.isEmpty()) {
                throw new AssertionError("No se encontró la transacción con fecha " + date +
                        ", monto " + data.getAmount() + " y descripción " + data.getDescription());
            }

            // Obtener la celda de descripción (tercera columna) de la primera fila encontrada
            WebElement descriptionCell = rows.get(0).findElement(By.xpath("./td[3]"));
            return descriptionCell.getText().trim();
        });
    }
}
