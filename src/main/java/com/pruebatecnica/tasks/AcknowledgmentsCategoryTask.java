package com.pruebatecnica.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebatecnica.interactions.AcknowledgmentsCategoryInteraction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AcknowledgmentsCategoryTask implements Task{

    public AcknowledgmentsCategoryTask (){
    
    }

    public static AcknowledgmentsCategoryTask accessAcknowledgments( ){
        return instrumented(AcknowledgmentsCategoryTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            AcknowledgmentsCategoryInteraction.accessAcknowledgments()
        );
    }

}
