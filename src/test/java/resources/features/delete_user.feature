Feature: Eliminar un usuario existente en ReqRes
    Como usuario quiero poder eliminar un usuario a través de la API de ReqRes
    Para asegurarme de que el proceso de eliminación de usuarios funciona correctamente
  Scenario: Eliminar un usuario existente
    Given que tengo el ID de usuario existente
    When realizo una solicitud DELETE al endpoint "/api/users/" con id 2
    Then la respuesta debe devolver un estado de 204, indicando que el usuario fue eliminado exitosamente