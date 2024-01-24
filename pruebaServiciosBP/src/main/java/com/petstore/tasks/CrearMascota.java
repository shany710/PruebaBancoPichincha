package com.petstore.tasks;

import com.petstore.interactions.Post;
import com.petstore.models.mascota.BodyCrearMascota;
import com.petstore.models.mascota.DataMascota;
import com.petstore.models.usuario.DataPersona;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CrearMascota implements Task {

    private DataMascota mascota;

    public CrearMascota(DataMascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/pet").with(
                        requestSpecification -> requestSpecification
                                .relaxedHTTPSValidation()
                                .contentType(ContentType.JSON)
                                .body(BodyCrearMascota.getBodyAllFiellds(mascota))
                )
        );
    }

    public static CrearMascota conLosDatos(DataPersona dataPet) {
        return Tasks.instrumented(CrearMascota.class, dataPet);
    }
}
