package com.petstore.tasks;

import com.petstore.interactions.Post;
import com.petstore.models.usuario.BodyCrearUsuario;
import com.petstore.models.usuario.DataPersona;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CrearUsuario implements Task {
    private DataPersona usuario;

    public CrearUsuario(DataPersona usuario) {
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/createWithList").with(
                        requestSpecification -> requestSpecification
                                .relaxedHTTPSValidation()
                                .contentType(ContentType.JSON)
                                .body(BodyCrearUsuario.getBodyAllFields(usuario)
                )
        ));
    }

    public static CrearUsuario conLosDatosDe(DataPersona usuario) {
        return Tasks.instrumented(CrearUsuario.class, usuario);
    }
}
