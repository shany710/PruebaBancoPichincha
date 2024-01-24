package com.petstore.models.mascota;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoMascota {
    private String id;
    private Category categoria;
    private String nombre;
    private List<String> photosList;
    private String status;
}
