package com.pruebatecnica.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class UsersListResponseQuestions {
    public static Question<Integer> statusCode() {
        return actor -> SerenityRest.lastResponse().statusCode();
    }

    public static Question<Integer> currentPage() {
        return actor -> SerenityRest.lastResponse().jsonPath().getInt("page");
    }
}
