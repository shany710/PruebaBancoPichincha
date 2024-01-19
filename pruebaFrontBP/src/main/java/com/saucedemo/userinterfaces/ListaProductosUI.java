package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListaProductosUI {
    public static final Target LBL_PRODUCTOS = Target.the("Label con el nombre del producto").located(By.cssSelector("div[class*='item_name']"));
    public static final Target BTN_AGREGAR_PRODUCTO = Target.the("botón para añadir producto al carrito de compras").located(By.cssSelector("button[id*='add-to-cart']"));
}
