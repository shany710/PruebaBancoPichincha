package com.petstore.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

/**
 * Put something to a REST resource.
 * This is a simple interaction class suitable for simple queries.
 */
public class Put extends RestInteraction {

    private final String resource;

    public Put(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a PUT on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().put(as(actor).resolve(resource)).then().log().all();
    }

    public static Put to(String resource) {
        return instrumented(Put.class, resource);
    }

}
