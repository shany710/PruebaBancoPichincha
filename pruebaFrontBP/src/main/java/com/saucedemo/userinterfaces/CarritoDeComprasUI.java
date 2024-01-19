package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoDeComprasUI {
    public static final Target BTN_IR_AL_CARRITO = Target.the("botón para ingresar al carrito de compras").located(By.cssSelector("span[class*='shopping_cart']"));

    public static final Target BTN_CHECKOUT = Target.the("botón para hacer el checkout de la compra").located(By.id("checkout"));
}
