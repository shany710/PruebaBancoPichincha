package com.petstore.models.mascota;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataMascota {
    private String nombre;
    private String categoria;
}
