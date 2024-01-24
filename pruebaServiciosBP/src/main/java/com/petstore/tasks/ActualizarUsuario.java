package com.petstore.tasks;

import com.petstore.interactions.Put;
import com.petstore.models.usuario.BodyActualizarUsuario;
import com.petstore.models.usuario.DataPersona;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ActualizarUsuario implements Task {
    private DataPersona usuarioActualizado;

    public ActualizarUsuario(DataPersona usuarioActualizado){
        this.usuarioActualizado= usuarioActualizado;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to("/"+usuarioActualizado.getUsername()).with(
                requestSpecification -> requestSpecification
                        .relaxedHTTPSValidation()
                        .contentType(ContentType.JSON)
                        .body(BodyActualizarUsuario.getBodyActualizarUsuario(usuarioActualizado)
                        )
        ));
    }
    public static ActualizarUsuario conNuevaInformacion(DataPersona usuarioActualizado){
        return Tasks.instrumented(ActualizarUsuario.class,usuarioActualizado);
    }
}
