package com.pruebatecnica.questions;

import com.pruebatecnica.model.UserModel;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class UpdateUserResponseQuestions {

    public static Question<Integer> statusCode() {
        return actor -> SerenityRest.lastResponse().statusCode();
    }

    public static Question<UserModel> updatedUserDetails() {
        return actor -> SerenityRest.lastResponse().as(UserModel.class);
    }

}
