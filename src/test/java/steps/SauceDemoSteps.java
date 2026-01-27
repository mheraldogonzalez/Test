package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

import static org.junit.Assert.assertEquals;

public class SauceDemoSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    // ---------------- BACKGROUND ----------------
    @Given("el navegador está abierto")


    public void abrirNavegador() {
        // Configuración para que SLF4J solo muestre errores
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "error");
        WebDriverManager.firefoxdriver().setup(); // Descarga y configura GeckoDriver automáticamente
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Inicializar la página
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }


    @Given("estoy en la página de inicio de sesión")
    public void abrirLogin() {
        loginPage.open();
    }

    // ---------------- LOGIN ----------------
    @When("ingreso el usuario {string} y la contraseña {string}")
    public void login(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("validar el ver la página de productos")
    public void verificarProductos() {
        assertEquals("Products", productsPage.getTitle());
    }

    // ---------------- PRODUCTO Y CARRITO ----------------
    @When("agrego el producto {string} al carrito")
    public void agregarProducto(String producto) {
        productsPage.addProductToCart(producto);
    }

    @When("navego al carrito de compras")
    public void irAlCarrito() {
        productsPage.goToCart();
    }

    @Then("validar el ver el producto {string} en el carrito")
    public void verificarProductoCarrito(String producto) {
        assertEquals(producto, cartPage.getProductName());
    }

    // ---------------- CHECKOUT ----------------
    @When("completo el checkout con nombre {string}, apellido {string}, código {string}")
    public void completarCheckout(String nombre, String apellido, String codigo) {
        cartPage.checkout();
        checkoutPage.fillInformation(nombre, apellido, codigo);
        checkoutPage.finishOrder();
    }

    @Then("validar el ver el mensaje {string}")
    public void verificarMensaje(String mensaje) {
        assertEquals(mensaje, checkoutPage.getConfirmationMessage());
    }

    // ---------------- CIERRE ----------------
    @And("cierro el navegador")
    public void cerrarNavegador() {
        driver.quit();
    }
}
