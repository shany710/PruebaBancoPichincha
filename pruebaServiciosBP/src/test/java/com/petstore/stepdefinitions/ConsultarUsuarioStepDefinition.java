package com.petstore.stepdefinitions;

import com.petstore.models.usuario.DataPersona;
import com.petstore.tasks.ConsultarUsuario;
import com.petstore.utils.Constantes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class ConsultarUsuarioStepDefinition {
    @Given("el usuario hace una solicitud para consultar usuario")
    public void elUsuarioHaceUnaSolicitudParaConsultarUsuario(){
        OnStage.theActorInTheSpotlight().can(CallAnApi.at(Constantes.URL_USER));
    }

    @When("el usuario filtra por el username para encontrar el usuario")
    public void elUsuarioFiltraPorElUsernameParaEncontrarElUsuario(DataPersona persona){
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultarUsuario.porElUsername(persona.getUsername()));
    }

    @Then("se obtiene información del usuario consultado")
    public void seObtieneInformacionDelUsuarioConsultado(){
        OnStage.theActorInTheSpotlight().should(
                ResponseConsequence.seeThatResponse("El servicio responde correctamente", actor -> actor.statusCode(200)));
    }
}
