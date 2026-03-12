package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {
                "pretty",
                // nombre fijo, luego lo renombramos en Hooks
                "html:target/evidencia/TestRunner.html",
                "json:target/evidencia/cucumber.json"
        },
        monochrome = true,
        tags = "@RecuperarContrasena"
)
public class TestRunner {
        // No necesitas lógica aquí, el renombrado lo hará Hooks
}
