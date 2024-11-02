package com.pruebatecnica.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebatecnica.userinterface.AcknowledgmentsCategoryUi;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class AcknowledgmentsCategoryInteraction implements Interaction{

    public AcknowledgmentsCategoryInteraction(){
       
    }

    public static AcknowledgmentsCategoryInteraction accessAcknowledgments(){
        return instrumented(AcknowledgmentsCategoryInteraction.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(AcknowledgmentsCategoryUi.ACKNOWLEDGMENTS)
        );
    }

}
