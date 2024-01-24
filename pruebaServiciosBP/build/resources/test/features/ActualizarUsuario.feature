Feature: Servicio actualizar usuario

  Scenario Outline: Actualizar información del usuario exitosamente
    Given el usuario hace una solicitud login
      | username   | password   |
      | <username> | <password> |
    When el usuario envia la información actualizada del usuario
      | id   | username   | firstname   | lastname   | email   | phone   | userStatus   |
      | <id> | <username> | <firstname> | <lastname> | <email> | <phone> | <userStatus> |
    Then se actualiza la información del usuario

    Examples:
      | id  | username   | password   | firstname | lastname | email                   | phone    | userStatus |
      | 121 | Stephany78 | Stephany10 | Danna     | Rojas    | dannarojas.90@gmail.com | 88947956 | 1          |