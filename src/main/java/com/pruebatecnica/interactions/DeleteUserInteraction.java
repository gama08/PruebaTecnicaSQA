package com.pruebatecnica.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserInteraction implements Interaction{

    private final int userId;
    private final String endpoint;

    public DeleteUserInteraction(int userId, String endpoint){
        this.userId = userId;
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.delete(endpoint + userId);
    }

    public static DeleteUserInteraction deleteUserForId(int userId, String endpoint){
        return instrumented(DeleteUserInteraction.class, userId,endpoint);
    }


}
