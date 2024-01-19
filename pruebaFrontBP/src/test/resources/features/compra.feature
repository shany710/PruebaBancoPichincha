Feature: Proceso de compra

  Scenario Outline: realizar una compra de forma exitosa
    Given el usuario se autentica en la aplicación
      | username   | clave   |
      | <username> | <clave> |
    When el usuario realiza una compra exitosa
      | listaProductos   | nombreComprador   | apellidoComprador   |
      | <listaProductos> | <nombreComprador> | <apellidoComprador> |
    Then el usuario podrá visualizar un mensaje de compra exitosa
    Examples:
      | username      | clave        | listaProductos        | nombreComprador | apellidoComprador |
      | standard_user | secret_sauce | Jacket,T-shirt,onesie | Lorena          | Rojas             |