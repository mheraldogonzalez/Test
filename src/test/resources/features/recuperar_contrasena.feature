Feature: Recuperar contraseña
  Como usuario del portal de clientes
  Quiero poder recuperar mi contraseña
  Para acceder nuevamente a mi cuenta

  @RecuperarContrasena
  Scenario: Flujo exitoso de recuperación de contraseña
    Given que el usuario está en la página de login
    When hace clic en "¿Olvidaste tu contraseña?"
    And ingresa su rut válido
    And confirma Seleccion de metodos de recuperacion y Boton Back
    Then debería ver el Login del sitio
