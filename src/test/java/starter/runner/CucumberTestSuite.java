package starter.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json", "junit:target/cucumber.xml"},
        features = {"src/test/resources/features"},
        glue = {"starter.stepdefinitions"},
        snippets     = CucumberOptions.SnippetType.CAMELCASE
)

public class CucumberTestSuite {
}
