package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.awt.Desktop;

import Hooks.Hooks;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.PickleStepTestStep;

public class ReportConfig implements ConcurrentEventListener {
    private static ExtentReports extent;
    public static ExtentTest test;

    @BeforeAll
    public static void setupReport() {
        String reportDir = "C:/Users/mmauser/IdeaProjects/Test/target/evidencia";
        String reportPath = reportDir + "/Informe_Evidencias_QA.html";

        File dir = new File(reportDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Informe Evidencias QA", "");
        extent.setSystemInfo("Producto", "BUC");
        extent.setSystemInfo("Área", "QA");
        extent.setSystemInfo("Versión", "1.0");
        extent.setSystemInfo("SAR / Invgate", "2979");
        extent.setSystemInfo("Fecha de Entrega", "13/03/2026");
        extent.setSystemInfo("Ambiente", "QA");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        test = extent.createTest("Caso: " + scenario.getName());
        test.info("OBJETIVOS: Validar funcionalidad según requerimiento");
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, this::handleStepFinished);
    }

    private void handleStepFinished(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            String stepText = ((PickleStepTestStep) event.getTestStep()).getStep().getText();

            WebDriver driver = Hooks.getDriver();
            if (driver != null) {
                String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

                switch (event.getResult().getStatus()) {
                    case PASSED:
                        test.pass("Éxito en step: " + stepText)
                                .addScreenCaptureFromBase64String(base64Screenshot, "Captura del paso exitoso");
                        break;
                    case FAILED:
                        test.fail("Fallo en step: " + stepText)
                                .addScreenCaptureFromBase64String(base64Screenshot, "Captura del paso fallido");
                        break;
                    default:
                        test.info("Step: " + stepText);
                        break;
                }
            }
        }
    }

    @After
    public void afterScenario() {
        extent.flush();
    }

    @AfterAll
    public static void tearDownReport() {
        extent.flush();

        try {
            File reportFile = new File("C:/Users/mmauser/IdeaProjects/Test/target/evidencia/Informe_Evidencias_QA.html");
            if (reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            } else {
                System.out.println("No se encontró el reporte en: " + reportFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
