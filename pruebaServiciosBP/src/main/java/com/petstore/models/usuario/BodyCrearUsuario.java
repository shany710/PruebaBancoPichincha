package com.petstore.models.usuario;

import java.util.ArrayList;
import java.util.List;

public class BodyCrearUsuario {

    public static List<ModelUsuario> getBodyAllFields(DataPersona nuevaPersona) {
        List<ModelUsuario> listUsers= new ArrayList<>();
        ModelUsuario persona = new ModelUsuario();
        persona.setId(nuevaPersona.getId());
        persona.setUsername(nuevaPersona.getUsername());
        persona.setFirstname(nuevaPersona.getFirstname());
        persona.setLastname(nuevaPersona.getLastname());
        persona.setEmail(nuevaPersona.getEmail());
        persona.setPassword(nuevaPersona.getPassword());
        persona.setPhone(nuevaPersona.getPhone());
        persona.setUserStatus(nuevaPersona.getUserStatus());
        listUsers.add(persona);
        return listUsers;
    }
}
