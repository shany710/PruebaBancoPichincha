package com.petstore.tasks;

import com.petstore.interactions.Delete;
import com.petstore.models.usuario.DataLogin;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Eliminar implements Task {
    private DataLogin login;

    public Eliminar(DataLogin login) {
        this.login = login;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from("/" + login.getUsername()).with(
                        requestSpecification -> requestSpecification
                                .relaxedHTTPSValidation()
                                .contentType(ContentType.JSON)
                )
        );
    }

    public static Eliminar usuarioConUsername(DataLogin login) {
        return Tasks.instrumented(Eliminar.class, login);
    }
}
