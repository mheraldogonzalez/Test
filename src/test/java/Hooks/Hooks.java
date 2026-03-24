package Hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    private static WebDriver driver;
    private static String currentStepName;

    @Before
    public void setUp() {
        // WebDriverManager se encarga de descargar el chromedriver correcto
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeStep
    public void beforeStep() {
        currentStepName = "Step ejecutado a las " + java.time.LocalTime.now();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getCurrentStepName() {
        return currentStepName;
    }
}
