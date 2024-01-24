package com.petstore.stepdefinitions;

import com.petstore.models.usuario.DataLogin;
import com.petstore.models.usuario.DataPersona;
import com.petstore.tasks.ActualizarUsuario;
import com.petstore.tasks.Login;
import com.petstore.utils.Constantes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class ActualizarUsuarioStepDefinition {

    @Given("el usuario hace una solicitud login")
    public void elUsuarioHaceUnaSolicitudLogin(DataLogin login){
        OnStage.theActorInTheSpotlight().can(CallAnApi.at(Constantes.URL_USER));
        OnStage.theActorInTheSpotlight().attemptsTo(Login.conCredencialesValidas(login));
    }

    @When("el usuario envia la información actualizada del usuario")
    public void elUsuarioEnviaLaInformacionActualizadaDelUsuario(DataPersona infoActualizada){
        OnStage.theActorInTheSpotlight().can(CallAnApi.at(Constantes.URL_USER));
        OnStage.theActorInTheSpotlight().attemptsTo(
                ActualizarUsuario.conNuevaInformacion(infoActualizada)
        );
    }

    @Then("se actualiza la información del usuario")
    public void seActualizaLaInformacionDelUsuario(){
        OnStage.theActorInTheSpotlight().should(
                ResponseConsequence.seeThatResponse("El servicio responde correctamente", actor -> actor.statusCode(200)));

    }
}
