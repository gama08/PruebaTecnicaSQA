package com.pruebatecnica.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebatecnica.userinterface.CheckProductAddedCarUi;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class CheckProductAddedCarIteraction implements Interaction{

    public CheckProductAddedCarIteraction(){

    }

    public static CheckProductAddedCarIteraction clickBtnCar(){
        return instrumented(CheckProductAddedCarIteraction.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(CheckProductAddedCarUi.CAR_BUTTON)
        );
    }

}
