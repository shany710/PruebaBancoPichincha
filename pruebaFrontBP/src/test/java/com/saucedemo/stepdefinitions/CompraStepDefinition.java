package com.saucedemo.stepdefinitions;

import com.saucedemo.models.CarritoDeCompras;
import com.saucedemo.models.LoginUser;
import com.saucedemo.tasks.IrAlCarritoDeCompras;
import com.saucedemo.tasks.Login;
import com.saucedemo.tasks.SeleccionarProductos;
import static com.saucedemo.utils.Constantes.URL_SAUCEDEMO;

import static com.saucedemo.userinterfaces.CheckoutCompraUI.LBL_MENSAJE_COMPRA_EXITOSA;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.*;

import java.util.Map;

public class CompraStepDefinition {

    @Before
    public void setup(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @DataTableType
    public LoginUser loginUser(Map<String, String> dataUsers) {
        return new LoginUser(dataUsers.get("username"), dataUsers.get("clave"));
    }
    @DataTableType
    public CarritoDeCompras producto(Map<String, String> dataUsers) {
        return new CarritoDeCompras(dataUsers.get("listaProductos"),dataUsers.get("nombreComprador"), dataUsers.get("apellidoComprador"));
    }

    @Given("el usuario se autentica en la aplicación")
    public void elUsuarioSeAutenticaEnLaAplicacion(LoginUser login){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(URL_SAUCEDEMO),
                Login.conCredencialesValidas(login));
    }

    @When("el usuario realiza una compra exitosa")
    public void elUsuarioRealizaUnaCompraExitosa(CarritoDeCompras infoCarrito){
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarProductos.desdeLaListaDeProductos(infoCarrito),
                IrAlCarritoDeCompras.paraFinalizarCompra(infoCarrito)
        );
    }

    @Then("el usuario podrá visualizar un mensaje de compra exitosa")
    public void elUsuarioPodraVisualizarUnMensajeDeCompraExitosa(){
        OnStage.theActorInTheSpotlight().should(seeThat(the(LBL_MENSAJE_COMPRA_EXITOSA), containsText("Thank you for your order")));
    }
}
