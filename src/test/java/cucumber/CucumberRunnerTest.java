package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/gc.feature",
        glue = "",
        tags = "@1",
        snippets = SnippetType.CAMELCASE
)
public class CucumberRunnerTest {
}
