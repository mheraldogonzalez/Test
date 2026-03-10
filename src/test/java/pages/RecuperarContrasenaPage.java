package pages;

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
    By mensajeConfirmacion = By.id("mensajeConfirmacion");

    public RecuperarContrasenaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarRut(String rut) {
        driver.findElement(rutInput).sendKeys(rut);
    }

    public void confirmarSolicitud() {
        driver.findElement(tipodeRecuperacionEmail).click();
        driver.findElement(tipodeRecuperacionMensaje).click();

    }

    public String obtenerMensaje() {
        driver.findElement(btnVolver).click();
        return driver.findElement(mensajeConfirmacion).getText();
    }
}
