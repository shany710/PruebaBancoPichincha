package com.saucedemo.tasks;

import com.saucedemo.models.CarritoDeCompras;

import static com.saucedemo.userinterfaces.ListaProductosUI.*;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.ArrayList;
import java.util.List;

public class SeleccionarProductos implements Task {
    private CarritoDeCompras productos;

    public SeleccionarProductos(CarritoDeCompras infoProductos) {
        this.productos = infoProductos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> listaDeValores = new ArrayList<>();
        String[] lstProductos = productos.getListaProductos().split(",");
        for (String producto : lstProductos) {
            listaDeValores.add(producto.trim().toLowerCase());
        }
        List<WebElementFacade> listWebProducts = LBL_PRODUCTOS.resolveAllFor(actor);
        for (String producto : listaDeValores) {
            for (int i = 0; i < listWebProducts.size(); i++) {
                if (listWebProducts.get(i).getText().toLowerCase().contains(producto) ) {
                    actor.attemptsTo(
                            Scroll.to(BTN_AGREGAR_PRODUCTO),
                            MoveMouse.to(BTN_AGREGAR_PRODUCTO.resolveAllFor(actor).get(i)).then(Click.on(BTN_AGREGAR_PRODUCTO.resolveAllFor(actor).get(i))));
                    listWebProducts.remove(i);
                    break;
                }
            }
        }
    }

    public static SeleccionarProductos desdeLaListaDeProductos(CarritoDeCompras infoProducto) {
        return Tasks.instrumented(SeleccionarProductos.class, infoProducto);
    }
}
