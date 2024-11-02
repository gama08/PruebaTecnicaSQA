package com.pruebatecnica.userinterface;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class AddProductCarUi {

    public static final Target ADD_CAR_PRODUCT = Target.the("identificador de botón agregar al carrito")
            .located(By.className("title-cart"));

    public static final Target CARD = Target.the("identificador de las tarjetas")
            .located(By.className("groups-button"));

    public static final Target TABLE_PRODUCT_ADD_CAR = Target
            .the("identificador de la tabla que almacena los productos agregados al carro")
            .located(By.className("product-details"));

}
