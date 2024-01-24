Feature: Servicio crear usuario

  Scenario Outline: Crear usuario exitosamente
    Given el usuario hace una solicitud para crear un nuevo usuario
    When el usuario envia la información del nuevo usuario
      | id   | username   | firstname   | lastname   | email   | password   | phone   | userStatus   |
      | <id> | <username> | <firstname> | <lastname> | <email> | <password> | <phone> | <userStatus> |
    Then el usuario valida codigo de respuesta para creación de usuario exitoso
    Examples:
      | id  | username   | password   | firstname | lastname | email                 | phone    | userStatus |
      | 121 | Stephany78 | Stephany10 | Stephany  | Rojas    | stephany.00@gmail.com | 88947950 | 1          |


