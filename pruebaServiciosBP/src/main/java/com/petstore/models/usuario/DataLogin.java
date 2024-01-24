package com.petstore.models.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataLogin {
    private String username;
    private String password;
}
