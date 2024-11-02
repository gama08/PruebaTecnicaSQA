package com.pruebatecnica.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebatecnica.model.UserModel;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class UpdateUserInteraction implements Interaction{

    private final int userId;
    private final UserModel user;
    private final String endpoint;

    public UpdateUserInteraction(int userId, UserModel user, String endpoint){
        this.userId = userId;
        this.user = user;
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given().contentType("application/json").body(user).put(endpoint + userId);
    }

    public static UpdateUserInteraction updateUserWithDetails(int userId, UserModel user, String endpoint){
        return instrumented(UpdateUserInteraction.class, userId, user,endpoint);
    }


}
