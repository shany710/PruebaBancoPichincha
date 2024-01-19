package com.saucedemo.tasks;

import static com.saucedemo.userinterfaces.CarritoDeComprasUI.*;
import static com.saucedemo.userinterfaces.CheckoutCompraUI.*;

import static com.saucedemo.utils.Constantes.TIEMPO_ESPERA;

import com.saucedemo.models.CarritoDeCompras;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.waits.WaitUntil;

public class IrAlCarritoDeCompras implements Task {
    private CarritoDeCompras infoComprador;

    public IrAlCarritoDeCompras(CarritoDeCompras infoComprador) {
        this.infoComprador = infoComprador;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MoveMouse.to(BTN_IR_AL_CARRITO),
                Click.on(BTN_IR_AL_CARRITO),
                WaitUntil.the(BTN_CHECKOUT, isClickable()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                MoveMouse.to(BTN_CHECKOUT),
                Click.on(BTN_CHECKOUT),
                Enter.theValue(infoComprador.getNombreComprador()).into(TXT_NOMBRE_COMPRADOR),
                Enter.theValue(infoComprador.getApellidoComprador()).into(TXT_APELLIDO_COMPRADOR),
                Enter.theValue("57").into(TXT_CODIGO_POSTAL),
                Click.on(BTN_CONFIRMAR_COMPRA),
                WaitUntil.the(BTN_FINALIZAR_COMPRA, isClickable()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                MoveMouse.to(BTN_FINALIZAR_COMPRA),
                Click.on(BTN_FINALIZAR_COMPRA),
                WaitUntil.the(BTN_VOLVER_AL_LISTADO,isClickable()).forNoMoreThan(TIEMPO_ESPERA).seconds()
        );
    }

    public static IrAlCarritoDeCompras paraFinalizarCompra(CarritoDeCompras infoComprador) {
        return Tasks.instrumented(IrAlCarritoDeCompras.class, infoComprador);
    }
}
