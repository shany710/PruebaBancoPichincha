package com.saucedemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarritoDeCompras {
    private String listaProductos;
    private String nombreComprador;
    private String apellidoComprador;
}
