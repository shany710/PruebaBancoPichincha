Feature: Servicio eliminar usuario


  Scenario Outline: Eliminar usuario exitosamente
    Given el usuario hace una solicitud login
      | username   | password   |
      | <username> | <password> |
    When el usuario filtra por el username el usuario que desea eliminar
      | username   |
      | <username> |
    Then se obtiene código de respuesta exitoso
      | username   |
      | <username> |
    Examples:
      | username   | password   |
      | Stephany78 | Stephany10 |