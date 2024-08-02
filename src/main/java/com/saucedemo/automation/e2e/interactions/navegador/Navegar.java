package com.saucedemo.automation.e2e.interactions.navegador;

import com.saucedemo.automation.e2e.tasks.javadoc.TasksJavaDoc;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class Navegar implements Interaction
{
    private String url;

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#PERFORM_AS
     */
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        /**
         * Para mas informacion:
         * @see TasksJavaDoc#LINKED_ACTIONS
         */
        actor.attemptsTo(
            Open.url(this.url)
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static Navegar a(String url)
    {
       return Tasks.instrumented(
               Navegar.class,
               url
       );
    }
}
