package com.pruebatecnica.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FetchUsersInteraction implements Interaction {

    private final String endpoint;

    public FetchUsersInteraction(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endpoint));
    }

    public static FetchUsersInteraction fromPage(String endpoint) {
        return instrumented(FetchUsersInteraction.class, endpoint);
    }

}
