package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Completar formulario de compra
    public void fillInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        driver.findElement(By.id("continue")).click();
    }

    // Finalizar compra
    public void finishOrder() {
        driver.findElement(By.id("finish")).click();
    }

    // Obtener mensaje de confirmación
    public String getConfirmationMessage() {
        return driver.findElement(By.className("complete-header")).getText();
    }
}
