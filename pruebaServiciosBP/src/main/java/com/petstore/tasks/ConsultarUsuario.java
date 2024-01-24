package com.petstore.tasks;

import com.petstore.interactions.Get;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsultarUsuario implements Task {
    private String username;

    public ConsultarUsuario(String username) {
        this.username = username;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/"+username ).with(
                requestSpecification -> requestSpecification
                        .relaxedHTTPSValidation()
                        .contentType(ContentType.JSON)
        ));
    }

    public static ConsultarUsuario porElUsername(String username) {
        return Tasks.instrumented(ConsultarUsuario.class, username);
    }
}
