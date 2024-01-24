package com.petstore.tasks;

import com.petstore.interactions.Get;
import com.petstore.models.usuario.DataLogin;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Login implements Task {
    private DataLogin login;
    public Login(DataLogin login){
        this.login= login;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/login" ).with(
                requestSpecification -> requestSpecification
                        .relaxedHTTPSValidation()
                        .contentType(ContentType.JSON)
                        .queryParam("username",login.getUsername())
                        .queryParam("password", login.getPassword())
        ));
    }

    public static Login conCredencialesValidas(DataLogin login){
        return Tasks.instrumented(Login.class, login);
    }
}
