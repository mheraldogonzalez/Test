package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Validar que estamos en la página de productos
    public String getTitle() {
        return driver.findElement(By.className("title")).getText();
    }

    // Agregar producto al carrito
    public void addProductToCart(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button")).click();
    }

    // Ir al carrito
    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
