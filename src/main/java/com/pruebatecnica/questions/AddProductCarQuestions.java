package com.pruebatecnica.questions;

import com.pruebatecnica.userinterface.AddProductCarUi;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AddProductCarQuestions implements Question<Boolean>{

    @Override
    public Boolean answeredBy(Actor actor) {
        return AddProductCarUi.TABLE_PRODUCT_ADD_CAR.resolveFor(actor).isPresent();
    }

    public static AddProductCarQuestions isPresent() {
        return new AddProductCarQuestions();
    }

}
