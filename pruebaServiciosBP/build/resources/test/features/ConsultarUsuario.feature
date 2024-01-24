Feature: Servicio consultar usuario

  Scenario Outline: Consultar usuario exitosamente
    Given el usuario hace una solicitud para consultar usuario
    When el usuario filtra por el username para encontrar el usuario
      | username   |
      | <username> |
    Then se obtiene información del usuario consultado
    Examples:
      | username   |
      | Stephany78 |