package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "Hooks", "reporting"},
        plugin = {
                "pretty",
                "html:target/evidencia/TestRunner.html",
                "json:target/evidencia/cucumber.json",
                "reporting.ReportConfig"   // <- aquí registramos tu listener
        },
        monochrome = true,
        tags = "@RecuperarContrasena"
)
public class TestRunner {
}
