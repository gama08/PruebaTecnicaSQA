package com.pruebatecnica.questions;

import com.pruebatecnica.userinterface.AcknowledgmentsCategoryUi;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.questions.Text.of;

public class AcknowledgmentsQuestions {

        public static Question<String> pageTitle() {
        return new Question<String>() {
            @Override
            public String answeredBy(Actor actor) {
                return of(AcknowledgmentsCategoryUi.ACKNOWLEDGMENTS_PAGE_TITLE).answeredBy(actor);
            }
        };
    }

}
