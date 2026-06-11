package locators;

import org.openqa.selenium.By;

public class locator {
   public class login{
        // Campos de login
       public static By linkOlvidaste = By.xpath("//*[@id='form-buttons']/a");
       public static By inputUsername = By.id("username");
       public static By inputPassword = By.id("password");
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
    public class homePortalClientes{
        public static By aviso1 = By.xpath("//*[@id='example']/div/div/div[5]/button");
        public static By aviso2 = By.xpath("//*[@id='alertModal']/div/div/div[1]/button");
        public static By aviso3 = By.xpath("//*[@id='confuturo-cl-widgets-prv-general-inicio']/div/div[1]/div/button");

    }

}