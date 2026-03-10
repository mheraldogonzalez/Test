package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.RecuperarContrasenaPage;

public class RecuperarContrasenaSteps {
    WebDriver driver;
    LoginPage loginPage;
    RecuperarContrasenaPage recuperarPage;

    @Given("que el usuario está en la página de login")
    public void abrirLogin() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        recuperarPage = new RecuperarContrasenaPage(driver);
        loginPage.abrirPortal();
    }

    @When("hace clic en {string}")
    public void clicEnOlvidaste(String linkText) {
        loginPage.clicOlvidaste();
    }

    @When("ingresa su correo electrónico válido")
    public void ingresarCorreo() {
        recuperarPage.ingresarCorreo("usuario@ejemplo.com");
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
