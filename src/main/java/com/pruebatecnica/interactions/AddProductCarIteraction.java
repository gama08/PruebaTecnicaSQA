package com.pruebatecnica.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.interactions.Actions;

import com.pruebatecnica.userinterface.AddProductCarUi;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class AddProductCarIteraction implements Interaction{

    public AddProductCarIteraction(){

    }

    public static AddProductCarIteraction addProductCar(){
        return instrumented(AddProductCarIteraction.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions actions = new Actions(Serenity.getDriver());
        actions.moveToElement(AddProductCarUi.CARD.resolveFor(actor)).perform();
        actor.attemptsTo(
            Click.on(AddProductCarUi.ADD_CAR_PRODUCT)
        );
    }

}
