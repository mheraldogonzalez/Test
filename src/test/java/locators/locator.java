package locators;

import org.openqa.selenium.By;

public class locator {
   public class login{
        // Campos de login
       public static By linkOlvidaste = By.xpath("//*[@id='form-buttons']/a");

       // Mensaje de bienvenida
        public static final By WELCOME_MSG = By.id("welcome");
    }
    public class recuperarContrasena{
       public static By rutInput = By.id("rutRecover");
       public static By tipodeRecuperacionEmail = By.id("email");
       public static By tipodeRecuperacionMensaje = By.id("sms");
        // Usando XPath con comillas simples dentro del atributo
        public static By btnVolver = By.xpath("//*[@id='form-buttons']/a");
        public static By submitBtn = By.id("submit-button");
        public static By mensajeConfirmacion = By.id("mensajeConfirmacion");
    }

}
