package pages;
import locators.locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecuperarContrasenaPage {
    WebDriver driver;

    By rutInput = By.id("rutRecover");
    By tipodeRecuperacionEmail = By.id("email");
    By tipodeRecuperacionMensaje = By.id("sms");
    // Usando XPath con comillas simples dentro del atributo
    By btnVolver = By.xpath("//*[@id='form-buttons']/a");
    By submitBtn = By.id("submit-button");
   // By mensajeConfirmacion = By.id("mensajeConfirmacion");

    public RecuperarContrasenaPage(WebDriver driver) {

        this.driver = driver;
    }

    public void ingresarRut(String rut) {

        driver.findElement(locator.recuperarContrasena.rutInput).sendKeys(rut);
    }

    public void confirmarSolicitud() {
        driver.findElement(locator.recuperarContrasena.tipodeRecuperacionEmail).click();
        driver.findElement(locator.recuperarContrasena.tipodeRecuperacionMensaje).click();

    }

    public void regresarLogin() {
        driver.findElement(locator.recuperarContrasena.btnVolver).click();
        driver.findElement(locator.login.inputUsername);
    }
}
