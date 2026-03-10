package steps;

import io.cucumber.java.AfterStep;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

public class Hooks {

    // Captura screenshot después de cada step y la adjunta en el reporte
    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (RecuperarContrasenaSteps.driver != null) {
            final byte[] screenshot = ((TakesScreenshot) RecuperarContrasenaSteps.driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Evidencia paso");
        }
    }

    // Al terminar toda la ejecución, renombra el archivo HTML con fecha/hora
    @AfterAll
    public static void renameReport() {
        String runnerName = "TestRunner"; // puedes cambiarlo si usas otro runner
        String fecha = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date());

        File oldFile = new File("target/evidencia/TestRunner.html");
        File newFile = new File("target/evidencia/" + runnerName + "_" + fecha + ".html");

        if (oldFile.exists()) {
            boolean renamed = oldFile.renameTo(newFile);
            if (!renamed) {
                System.out.println("No se pudo renombrar el reporte de evidencia.");
            }
        } else {
            System.out.println("No se encontró el archivo de reporte para renombrar.");
        }
    }
}
