package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecuperarContrasenaPage {
    WebDriver driver;

    By emailInput = By.id("email");
    By submitBtn = By.id("submit");
    By mensajeConfirmacion = By.id("mensajeConfirmacion");

    public RecuperarContrasenaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarCorreo(String correo) {
        driver.findElement(emailInput).sendKeys(correo);
    }

    public void confirmarSolicitud() {
        driver.findElement(submitBtn).click();
    }

    public String obtenerMensaje() {
        return driver.findElement(mensajeConfirmacion).getText();
    }
}
