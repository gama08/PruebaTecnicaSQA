package com.pruebatecnica.tasks;

import com.pruebatecnica.interactions.CreateUserInteraction;
import com.pruebatecnica.model.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CreateUserTask implements Task{

    private final UserModel user;
    private final String endpoint;

    public CreateUserTask (UserModel user, String endpoint){
        this.user = user;
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Tasks.instrumented(CreateUserInteraction.class, user, endpoint)
        );
    }

    public static Performable createUserTask(UserModel user, String endpoint) {
        return Tasks.instrumented(CreateUserTask.class, user, endpoint);
    }


}
