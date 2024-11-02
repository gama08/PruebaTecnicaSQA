package com.pruebatecnica.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebatecnica.interactions.AddProductCarIteraction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AddProductCarTask implements Task{

    public AddProductCarTask(){

    }

    public static AddProductCarTask addProductCardTask(){
        return instrumented(AddProductCarTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            AddProductCarIteraction.addProductCar()
        );
    }

}
