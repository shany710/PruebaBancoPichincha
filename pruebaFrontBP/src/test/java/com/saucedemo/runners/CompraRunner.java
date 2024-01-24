package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@UseTestDataFrom(value="datadriven/compra.csv")
@CucumberOptions(
        glue = "com.saucedemo.stepdefinitions",
        features = "src/test/resources/features/compra.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CompraRunner {
}
