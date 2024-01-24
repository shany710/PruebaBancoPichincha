Feature: Create users

  @createUser
  Scenario: Create a new user
    Given url 'https://petstore.swagger.io/v2/user/createWithList'
    And request [{ "id": 1, "username": "sharon123", "firstname": "sharon", "lastname": "rojas", "email": "rojas.00@gmail.com", "password": "sharin", "phone": "1232132321", "userStatus": 1 }]
    When method post
    Then status 200

  @createUserJson
  Scenario: Create new users from json file
    Given url 'https://petstore.swagger.io/v2/user/createWithList'
    And request read('classpath:files/usuarios.json')
    When method post
    Then status 200