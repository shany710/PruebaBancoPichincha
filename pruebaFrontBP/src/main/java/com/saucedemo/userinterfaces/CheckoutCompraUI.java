package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutCompraUI {
    public static final Target TXT_NOMBRE_COMPRADOR = Target.the("campo para ingresar el nombre del usuario que realiza la compra").located(By.id("first-name"));
    public static final Target TXT_APELLIDO_COMPRADOR = Target.the("campo para ingresar el apellido del usuario que realiza la compra").located(By.id("last-name"));
    public static final Target TXT_CODIGO_POSTAL = Target.the("campo para ingresar el código postal de la compra").located(By.id("postal-code"));
    public static final Target BTN_CONFIRMAR_COMPRA = Target.the("botón para confirmar la compra").located(By.id("continue"));
    public static final Target BTN_FINALIZAR_COMPRA = Target.the("botón para finalizar la compra").located(By.id("finish"));
    public static final Target LBL_MENSAJE_COMPRA_EXITOSA = Target.the("label con mensaje exitoso de compra").located(By.cssSelector("h2.complete-header"));
    public static final Target BTN_VOLVER_AL_LISTADO = Target.the("botón para regresar al listado de productos").located(By.id("back-to-products"));
}
