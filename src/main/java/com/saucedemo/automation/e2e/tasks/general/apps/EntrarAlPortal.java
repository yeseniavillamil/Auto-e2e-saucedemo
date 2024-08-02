package com.saucedemo.automation.e2e.tasks.general.apps;

import com.saucedemo.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.saucedemo.automation.e2e.constants.enums.configuracion.Esperas;
import com.saucedemo.automation.e2e.constants.enums.configuracion.serenity.SerenityConf;
import com.saucedemo.automation.e2e.interactions.navegador.Navegar;
import com.saucedemo.automation.e2e.interactions.esperas.Detener;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.commons.lang3.StringUtils;

/**
 * For more information:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class EntrarAlPortal implements Task {

    private String url;

    private String path;

    private long waitLoadPage;

    /**
     * For more information:
     * @see TasksJavaDoc#PERFORM_AS
     */
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        /**
         * For more information:
         * @see TasksJavaDoc#LINKED_ACTIONS
         */
        actor.attemptsTo(
                Navegar.a(this.url+path),

                Detener.por(this.waitLoadPage).milliseconds()
        );
    }

    /**
     * For more information:
     * @see TasksJavaDoc#ENLACE
     */
    public static EntrarAlPortal web()
    {
       return Tasks.instrumented(
               EntrarAlPortal.class,
               SerenityConf.URL_APP.getValue(),
               StringUtils.EMPTY,
               Esperas.LOAD_PAGE.getTiempo()
       );
    }

    /**
     * For more information:
     * @see TasksJavaDoc#ENLACE
     */
    public EntrarAlPortal page(String path)
    {
        this.path = path;
        return this;
    }
}
