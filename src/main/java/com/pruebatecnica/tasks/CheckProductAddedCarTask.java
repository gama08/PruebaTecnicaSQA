package com.pruebatecnica.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebatecnica.interactions.CheckProductAddedCarIteraction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CheckProductAddedCarTask implements Task{

    public CheckProductAddedCarTask(){

    }

    public static CheckProductAddedCarTask clickBtnCar(){
        return instrumented(CheckProductAddedCarTask.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            CheckProductAddedCarIteraction.clickBtnCar()
        );
    }

}
