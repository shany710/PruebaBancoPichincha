package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {

    public static final Target TXT_USERNAME = Target.the("campo para ingresar el nombre de usuario en el login ").located(By.id("user-name"));

    public static final Target TXT_CLAVE = Target.the("campo para ingresar la clave del login ").located(By.id("password"));

    public static final Target BTN_LOGIN = Target.the("botón para completar el login").located(By.id("login-button"));
}
