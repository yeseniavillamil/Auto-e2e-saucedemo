package com.saucedemo.automation.e2e.tasks.features.compra.pago;

import com.saucedemo.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.saucedemo.automation.e2e.userinterfaces.features.compra.pago.PagoCompraUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class ConfirmarPago implements Task
{

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#PERFORM_AS
     */
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        /**
         * Para mas informacion:
         * @see TasksJavaDoc#ENLAZAR_ACCIONES
         */
        actor.attemptsTo(
            Click.on(PagoCompraUI.BTN_FINALIZAR)
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static ConfirmarPago deLaCompra()
    {
       return Tasks.instrumented(
               ConfirmarPago.class
       );
    }
}
