Feature: Get user

  @getUserJson
  Scenario: get user filtering by username
    * def archivo = read('classpath:files/consultarUsuarios.json')
    * print 'Valor de archivo.username:', archivo.username
    Given url 'https://petstore.swagger.io/v2/user/'
    And path archivo.username
    And header Content-Type = 'application/json'
    When method get
    Then status 200