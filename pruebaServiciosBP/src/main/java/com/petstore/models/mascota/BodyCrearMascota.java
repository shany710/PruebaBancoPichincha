package com.petstore.models.mascota;


import java.util.ArrayList;
import java.util.List;

public class BodyCrearMascota {

    public static Category getCategory(String categoria){
        Category category= new Category();
        category.setName(categoria);
        return category;
    }
    public static List<String> getPhotosList(){
        List<String> list = new ArrayList<>();
        list.add("foto11");
        list.add("foto12");
        return list;
    }

    public static InfoMascota getBodyAllFiellds(DataMascota mascota){
        InfoMascota infoMascota = new InfoMascota();
        infoMascota.setId("111");
        infoMascota.setNombre(mascota.getNombre());
        infoMascota.setStatus("disponible");
        infoMascota.setCategoria(getCategory(mascota.getCategoria()));
        infoMascota.setPhotosList(getPhotosList());
        return infoMascota;
    }
}
