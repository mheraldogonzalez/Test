Feature: Compra de un producto en SauceDemo
  Como usuario registrado
  Quiero poder realizar una compra completa
  Para validar el flujo de e-commerce en la aplicación

  Background:
    Given el navegador está abierto
    And estoy en la página de inicio de sesión

  @Compra
  Scenario: Compra de un producto en SauceDemo
    When ingreso el usuario "standard_user" y la contraseña "secret_sauce"
    Then validar el ver la página de productos

    When agrego el producto "Sauce Labs Backpack" al carrito
    And navego al carrito de compras
    Then validar el ver el producto "Sauce Labs Backpack" en el carrito

    When completo el checkout con nombre "John", apellido "Doe", código "12345"
    Then validar el ver el mensaje "Thank you for your order!"
    And cierro el navegador
