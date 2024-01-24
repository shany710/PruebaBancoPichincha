package com.petstore.models.usuario;

public class BodyActualizarUsuario {

    public static ModelUsuario getBodyActualizarUsuario(DataPersona nuevaData){
        ModelUsuario usuarioActualizado = new ModelUsuario();
        usuarioActualizado.setId(nuevaData.getId());
        usuarioActualizado.setUsername(nuevaData.getUsername());
        usuarioActualizado.setFirstname(nuevaData.getFirstname());
        usuarioActualizado.setLastname(nuevaData.getLastname());
        usuarioActualizado.setEmail(nuevaData.getEmail());
        usuarioActualizado.setPhone(nuevaData.getPhone());
        usuarioActualizado.setUserStatus(nuevaData.getUserStatus());
        return usuarioActualizado;
    }
}
