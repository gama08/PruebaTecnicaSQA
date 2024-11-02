package com.pruebatecnica.userinterface;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class CheckProductAddedCarUi {

    public static final Target CAR_BUTTON = Target.the("identificador del botón carrito")
    .located(By.xpath("//*[@id=\"tbay-header\"]/div[2]/div/div/div[3]/div/div[1]"));

    public static final Target TEXT_PRODUCT_NOT_ADD = Target.the("identificador del texto cuando no hay productos en el carrito")
    .located(By.className("cart_empty"));

}
