package com.pruebatecnica.tasks;

import com.pruebatecnica.interactions.UpdateUserInteraction;
import com.pruebatecnica.model.UserModel;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class UpdateUserTask implements Task{

    private final int userId;
    private final UserModel user;
    private final String endpoint;

    public UpdateUserTask(int userId, UserModel user, String endpoint){
        this.userId = userId;
        this.user = user;
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
           Tasks.instrumented(UpdateUserInteraction.class, userId, user, endpoint)
        );
    }

    public static Performable updateUserTask(int userId, UserModel user, String endpoint){
        return Tasks.instrumented(UpdateUserTask.class, userId, user, endpoint);
    }

}
