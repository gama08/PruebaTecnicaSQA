Feature: Crear un nuevo usuario en ReqRes
    Como usuario quiero poder crear un nuevo usuario a través de la API de ReqRes
    Para asegurarme de que el proceso de registro de usuarios funciona correctamente y puedo manejar los datos de usuario
    Scenario: Crear un nuevo usuario
        Given que tengo los datos para crear un nuevo usuario
        When realizo una solicitud POST al endpoint "/api/users" con los datos del usuario
        Then la respuesta debe indicar que el usuario fue creado exitosamente con un estado de 201
        And debe devolver el ID del usuario creado
