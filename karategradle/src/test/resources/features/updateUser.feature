Feature: Update user

  Background:
    * def archivo = read('classpath:files/loginUsuarios.json')
    Given url 'https://petstore.swagger.io/v2/user/login'
    And param username = archivo.username
    And param password = archivo.password
    And header Content-Type = 'application/json'
    When method get
    Then status 200

  @updateUserJson
  Scenario: update info user
    Given url 'https://petstore.swagger.io/v2/user/'
    And path archivo.username
    And request read('classpath:files/actualizarUsuario.json')
    And header Content-Type = 'application/json'
    When method put
    Then status 200