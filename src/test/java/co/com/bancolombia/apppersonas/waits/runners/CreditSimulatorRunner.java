package co.com.bancolombia.apppersonas.waits.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = {"pretty"},
		features = "src/test/resources/features/credit_simulation.feature",
		glue = {"co.com.bancolombia.apppersonas.waits.stepdefinitions"},
		snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CreditSimulatorRunner {

}
