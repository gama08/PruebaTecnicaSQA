package com.pruebatecnica.tasks;

import com.pruebatecnica.userinterface.FloristeriaMundoFlorUi;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenUpTask implements Task{

    private FloristeriaMundoFlorUi floristeriamundoflor;

    public static Performable thePage(){
        return Tasks.instrumented(OpenUpTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(Open.browserOn(floristeriamundoflor));
    }

}
