package com.petstore.stepdefinitions;

import com.petstore.models.usuario.DataLogin;
import com.petstore.tasks.Eliminar;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;

public class EliminarUsuarioStepDefinition {
    @When("el usuario filtra por el username el usuario que desea eliminar")
    public void elUsuarioFiltraPorElUsernameElUsuarioQueDeseaEliminar(DataLogin login){
        OnStage.theActorInTheSpotlight().attemptsTo(
            Eliminar.usuarioConUsername(login)
        );
    }
    @Then("se obtiene código de respuesta exitoso")
    public void seObtieneCodigoDeRespuestaExitoso(DataLogin login){
        OnStage.theActorInTheSpotlight().should(
                ResponseConsequence.seeThatResponse("El servicio responde correctamente", actor -> actor.statusCode(200)),
                ResponseConsequence.seeThatResponse("El campo 'message' en la respuesta es correcto",
                        response -> response.body("message", Matchers.equalTo(login.getUsername()))));
    }
}
