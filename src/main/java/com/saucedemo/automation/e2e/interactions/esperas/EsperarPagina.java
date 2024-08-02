package com.saucedemo.automation.e2e.interactions.esperas;


import com.saucedemo.automation.e2e.constants.enums.configuracion.Esperas;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

@Builder
public class EsperarPagina implements Interaction
{

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo(
                Detener.por(Esperas.LOAD_PAGE.getTiempo())
                        .milliseconds()
        );
    }

    public static EsperarPagina cargue()
    {
        return EsperarPagina.builder().build();
    }

}
