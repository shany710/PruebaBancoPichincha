package com.petstore.stepdefinitions;

import com.petstore.models.usuario.DataPersona;
import com.petstore.tasks.CrearUsuario;
import com.petstore.utils.Constantes;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class CrearUsuarioStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("pruebaUser");
    }

    @Given("el usuario hace una solicitud para crear un nuevo usuario")
    public void elUsuarioHaceUnaSolicitudParaCrearUnNuevUsuario() {
        OnStage.theActorInTheSpotlight().can(CallAnApi.at(Constantes.URL_USER));
    }

    @When("el usuario envia la información del nuevo usuario")
    public void elUsuarioEnviaLaInformacionDelNuevoUsuario(DataPersona usuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearUsuario.conLosDatosDe(usuario)
        );
    }

    @Then("el usuario valida codigo de respuesta para creación de usuario exitoso")
    public void elUsuarioValidaCodigoDeRespuestaExitoso() {
        OnStage.theActorInTheSpotlight().should(
                ResponseConsequence.seeThatResponse("El servicio responde correctamente", actor -> actor.statusCode(200)));
    }
}
