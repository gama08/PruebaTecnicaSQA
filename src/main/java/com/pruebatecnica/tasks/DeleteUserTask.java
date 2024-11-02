package com.pruebatecnica.tasks;

import com.pruebatecnica.interactions.DeleteUserInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class DeleteUserTask implements Task{

    private final int userId;
    private final String endpoint;

    public DeleteUserTask(int userId, String endpoint){
        this.userId = userId;
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
           Tasks.instrumented(DeleteUserInteraction.class, userId, endpoint)
        );
    }

    public static Performable deleteUserTask(int userId, String endpoint){
        return Tasks.instrumented(DeleteUserTask.class, userId, endpoint);
    }

}
