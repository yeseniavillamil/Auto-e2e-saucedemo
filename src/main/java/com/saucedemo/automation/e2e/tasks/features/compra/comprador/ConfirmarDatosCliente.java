package com.saucedemo.automation.e2e.tasks.features.compra.comprador;

import com.saucedemo.automation.e2e.constants.enums.configuracion.Esperas;
import com.saucedemo.automation.e2e.interactions.esperas.Detener;
import com.saucedemo.automation.e2e.interactions.esperas.EsperarPagina;
import com.saucedemo.automation.e2e.models.params.features.compra.comprador.CompradorParams;
import com.saucedemo.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.saucedemo.automation.e2e.userinterfaces.features.compra.comprador.DatosCompradorUI;
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
public class ConfirmarDatosCliente implements Task
{

    private CompradorParams parametros;

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

            DiligenciarDatosCliente.deLaCompra(this.parametros),

            Click.on(DatosCompradorUI.BTN_CONTINUAR),

            EsperarPagina.cargue()
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static ConfirmarDatosCliente deLaCompra(CompradorParams parametros)
    {
       return Tasks.instrumented(
           ConfirmarDatosCliente.class,
           parametros
       );
    }
}
