package com.saucedemo.automation.e2e.interactions.esperas;


import com.saucedemo.automation.e2e.utils.tiempo.constants.enums.UnidadTiempo;
import com.saucedemo.automation.e2e.utils.tiempo.utils.EsperaUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Detener
{
    private long tiempo;

    private Detener(long tiempo)
    {
        this.tiempo = tiempo;
    }

    private class DetenerPor implements Interaction
    {
        private long milisegundos;
        private UnidadTiempo unidad;

        private DetenerPor(long milliseconds, UnidadTiempo unidad){
            this.milisegundos = milliseconds;
            this.unidad = unidad;
        }

        @Override
        public <T extends Actor> void performAs(T actor)
        {
            EsperaUtil.detenerPor(this.milisegundos,this.unidad);
        }
    }

    public static Detener por(long tiempo)
    {
        return new Detener(tiempo);
    }

    public DetenerPor seconds()
    {
        return new DetenerPor(this.tiempo, UnidadTiempo.SEGUNDOS);
    }

    public DetenerPor minutes()
    {
        return new DetenerPor(this.tiempo, UnidadTiempo.MINUTOS);
    }

    public DetenerPor milliseconds()
    {
        return new DetenerPor(this.tiempo, UnidadTiempo.MILISEGUNDOS);
    }

}
