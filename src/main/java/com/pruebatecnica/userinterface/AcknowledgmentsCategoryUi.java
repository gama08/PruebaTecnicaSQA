package com.pruebatecnica.userinterface;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class AcknowledgmentsCategoryUi {

    public static final Target ACKNOWLEDGMENTS = Target.the("Agradecimientos menu item")
    .located(By.cssSelector("li#menu-item-2794 a"));

    public static final Target ACKNOWLEDGMENTS_PAGE_TITLE = Target.the("titulo de la categoría")
    .located(By.className("page-title"));

}
