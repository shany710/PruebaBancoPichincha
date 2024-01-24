package com.petstore.stepdefinitions;

import com.petstore.models.mascota.DataMascota;
import com.petstore.models.usuario.DataPersona;
import com.petstore.tasks.CrearMascota;
import com.petstore.utils.Constantes;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;

import java.util.Map;

public class CrearMascotaStepDefinition {

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("prueba");
    }

    @DataTableType
    public DataMascota getPet(Map<String, String> pet){
        return new DataMascota(pet.get("nombre"), pet.get("categoria"));
    }
    @Given("el usuario hace una solicitud para crear una nueva mascota")
    public void elUsuarioHaceUnaSolicitudParaCrearUnaNuevaMascota(){
        OnStage.theActorInTheSpotlight().can(CallAnApi.at(Constantes.URL_PET_STORE));
    }
    @When("el usuario envia la información de la nueva mascota")
    public void elUsuarioEnviaLaInformacionDelaNuevaMascota(DataPersona mascota){
        OnStage.theActorInTheSpotlight().attemptsTo(CrearMascota.conLosDatos(mascota));

    }
    @Then("el usuario valida codigo de respuesta exitoso")
    public void elUsuarioValidaCodigoDeRespuestaExitoso(){
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse("El servicio responde correctamente", actor-> actor.statusCode(200)),
        ResponseConsequence.seeThatResponse("El campo 'id' en la respuesta es correcto",
                response -> response.body("id", Matchers.equalTo(111))));
    }
}
