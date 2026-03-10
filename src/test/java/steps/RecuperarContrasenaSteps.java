package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.RecuperarContrasenaPage;

public class RecuperarContrasenaSteps {
    // Declaramos driver como static para que Hooks pueda acceder
    public static WebDriver driver;
    LoginPage loginPage;
    RecuperarContrasenaPage recuperarPage;

    @Given("que el usuario está en la página de login")
    public void abrirLogin() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/mmauser/Documents/chromedriver/chromedriver-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        recuperarPage = new RecuperarContrasenaPage(driver);

        loginPage.abrirPortal();
    }

    @When("hace clic en {string}")
    public void clicEnOlvidaste(String linkText) {
        loginPage.clicOlvidaste();
    }

    @When("ingresa su rut válido")
    public void ingresarRut(){
        recuperarPage.ingresarRut("8559687-K");
    }

    @When("confirma la solicitud")
    public void confirmarSolicitud() {
        recuperarPage.confirmarSolicitud();
    }

    @Then("debería ver un mensaje de confirmación indicando que se envió el correo de recuperación")
    public void validarMensaje() {
        String mensaje = recuperarPage.obtenerMensaje();
        assert mensaje.contains("correo de recuperación");
        driver.quit();
    }
}
