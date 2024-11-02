package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/features/list_user.feature",
                 glue = "stepdefinitions",
                 snippets = SnippetType.CAMELCASE)
public class ListUserTest {

}
