package com.saucedemo.automation.e2e.stepdefinitions.general.navegador;

import com.saucedemo.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.saucedemo.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.automation.e2e.tasks.general.apps.EntrarAlPortal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

/**
 * For more information:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class NavegadorStepDefinition {

    @Managed
    static WebDriver hisBrowser;

    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Given("^que \"(.*)\" ingreso al navegador.*")
    public static void dadoQueIngresoAlNavegador(String actor)
    {
        Protagonista.haActuadoPreviamente(actor);
        Protagonista.entraEnEscena(actor)
            .whoCan(BrowseTheWeb.with(hisBrowser));
    }

    @When("^ingresa al portal.*")
    public static void cuandoIngresaAlPortal()
    {
        /**
         * For more information:
         * @see StepDefinitionsJavaDoc#LINKED_TASK
         */
        Protagonista.enEscena().attemptsTo(
            EntrarAlPortal.web()
        );
    }
}
