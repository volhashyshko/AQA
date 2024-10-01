import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        glue = "BDD",
        tags = "@BDD_test",
      //  dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class Runner {

}
