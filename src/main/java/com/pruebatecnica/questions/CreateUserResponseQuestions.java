package com.pruebatecnica.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class CreateUserResponseQuestions {
    public static Question<Integer> statusCode() {
        return actor -> SerenityRest.lastResponse().statusCode();
    }

    public static Question<Integer> userId() {
        return actor -> SerenityRest.lastResponse().jsonPath().getInt("id");
    }
}
