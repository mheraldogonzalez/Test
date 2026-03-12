package pages;
import locators.locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

 //   By linkOlvidaste = By.xpath("//*[@id='form-buttons']/a");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPortal() {
        driver.get("https://portales.confuturo.cl/dev-clientes");
    }

    public void clicOlvidaste() {
        driver.findElement(locator.login.linkOlvidaste).click();
    }
}
