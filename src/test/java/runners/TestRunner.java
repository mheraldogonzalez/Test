package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // Ruta donde están los archivos .feature
        glue = {"steps"},                           // Paquete donde están los definiciones de pasos
        plugin = {
                "pretty",                           // Salida  en consola
                "html:target/cucumber-report.html", // Reporte HTML
                "json:target/cucumber-report.json"  // Reporte JSON (opcional, útil para integraciones)
        },
        monochrome = true,                          // Consola más limpia (sin caracteres raros)
        tags = "@Compra"                            //  filtrar escenarios etiquetas (opcional)
)
public class TestRunner {
}
