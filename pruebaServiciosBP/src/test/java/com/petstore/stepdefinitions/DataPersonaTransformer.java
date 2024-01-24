package com.petstore.stepdefinitions;

import com.petstore.models.usuario.DataLogin;
import com.petstore.models.usuario.DataPersona;
import io.cucumber.datatable.TableEntryTransformer;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataPersonaTransformer implements TableEntryTransformer<DataPersona> {

    @Override
    @DataTableType
    public DataPersona transform(Map<String, String> usuario) {
        DataPersona nuevaPersona;
        if (usuario.containsKey("id")) {
            nuevaPersona=  new DataPersona(usuario.get("id"), usuario.get("username"),
                    usuario.get("firstname"), usuario.get("lastname"), usuario.get("email"),
                    usuario.get("password"), usuario.get("phone"), usuario.get("userStatus"));
        } else{
            nuevaPersona = new DataPersona(usuario.get("username"),
                    usuario.get("firstname"), usuario.get("lastname"), usuario.get("email"));
        } return nuevaPersona;
    }

    @DataTableType
    public DataLogin login(Map<String, String> login){
        return new DataLogin(login.get("username"),login.get("password"));
    }
}