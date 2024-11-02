package com.pruebatecnica.tasks;

import com.pruebatecnica.interactions.FetchUsersInteraction;

import net.serenitybdd.screenplay.Task;

public class ListUsersTask {

    public static Task fromPage(String endpoint) {
        return Task.where("{0} recupera lista de usuario de la pagina 2", FetchUsersInteraction.fromPage(endpoint));
    }

}
