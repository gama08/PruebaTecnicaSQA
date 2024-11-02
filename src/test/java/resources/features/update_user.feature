# src/test/resources/features/UpdateUser.feature
Feature: Actualizar un usuario existente en ReqRes
    Como usuario quiero poder actualizar un usuario a través de la API de ReqRes
    Para asegurarme de que el proceso de actualización de usuarios funciona correctamente
  Scenario: Actualizar un usuario existente
    Given que tengo un ID de usuario existente
    When realizo una solicitud PUT al endpoint "/api/users/" con id 2 con datos actualizados
    Then la respuesta debe indicar que el usuario fue actualizado exitosamente con un estado de 200
    And debe devolver los datos actualizados