package com.petstore.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue="com.petstore.stepdefinitions",
        features = "src/test/resources/features/ActualizarUsuario.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ActualizarUsuarioRunner {
}
