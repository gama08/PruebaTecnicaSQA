Feature: Listar Usuarios
  Como usuario de API, quiero recuperar de la pagina 2 la lista de usuarios de ReqRes
  y el código de estado
  Scenario: Listar usuarios en la página 2
    Given que accedo al servicio de listar usuarios de ReqRes
    When realizo una solicitud GET al endpoint "api/users?page=2"
    Then la respuesta debe contener la lista de usuarios en la página 2
    And el estado de la respuesta debe ser 200
