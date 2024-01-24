Feature: Delete user

  Background:
    * def archivo = read('classpath:files/loginUsuarios.json')
    Given url 'https://petstore.swagger.io/v2/user/login'
    And param username = archivo.username
    And param password = archivo.password
    And header Content-Type = 'application/json'
    When method get
    Then status 200

  @deleteUserJson
  Scenario: delete user
    Given url 'https://petstore.swagger.io/v2/user/'
    And path archivo.username
    And request read('classpath:files/borrarUsuario.json')
    And header Content-Type = 'application/json'
    When method delete
    Then status 200