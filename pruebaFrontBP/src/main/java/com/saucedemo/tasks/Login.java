package com.saucedemo.tasks;

import com.saucedemo.models.LoginUser;
import static com.saucedemo.userinterfaces.LoginUI.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {
    private LoginUser login;

    public Login(LoginUser login){
        this.login = login;
    }

    public static Login conCredencialesValidas(LoginUser login){
        return Tasks.instrumented(Login.class,login);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(login.getUsername()).into(TXT_USERNAME),
                Enter.theValue(login.getClave()).into(TXT_CLAVE),
                Click.on(BTN_LOGIN));
    }
}
