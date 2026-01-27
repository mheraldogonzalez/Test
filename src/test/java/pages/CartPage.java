package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Validar producto en el carrito
    public String getProductName() {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }

    // Proceder al checkout
    public void checkout() {
        driver.findElement(By.id("checkout")).click();
    }
}
