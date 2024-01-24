package com.petstore.models.usuario;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataPersona {
    private String id;

    private String username;
    private String firstname;
    private String lastname;
    private String email;

    private String password;

    private String phone;

    private String userStatus;

    public DataPersona(String username, String firstname, String lastname, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;

    }
}
