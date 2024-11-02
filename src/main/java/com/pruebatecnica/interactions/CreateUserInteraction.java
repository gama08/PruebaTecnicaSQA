package com.pruebatecnica.interactions;

import com.pruebatecnica.model.UserModel;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class CreateUserInteraction implements Interaction{

    private final UserModel user;
    private final String endpoint;

    public CreateUserInteraction(UserModel user, String endpoint) {
        this.user = user;
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("ENDPOINT INTERACCION: " + endpoint);
        SerenityRest.given()
            .contentType("application/json")
            .body(user)
            .post(endpoint);
    }

    public static CreateUserInteraction createUserWithDetails(UserModel user, String endpoint) {
        return new CreateUserInteraction(user, endpoint);
    }

}
