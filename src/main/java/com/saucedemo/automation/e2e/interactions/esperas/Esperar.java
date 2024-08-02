package com.saucedemo.automation.e2e.interactions.esperas;

import com.saucedemo.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Esperar {
    private Target[] elementos;

    private static final long A_SEGUNDOS = 1000;
    private static final long A_MINUTOS = A_SEGUNDOS *60;
    private static final long A_MILISEGUNDOS = 1;

    private Esperar(Target[] elements)
    {
        this.elementos = elements;
    }

    public static Esperar hastaQue(Target ... elementos)
    {
        return new Esperar(elementos);
    }

    public EsperarHastaQue este(EstadoElemento... estados)
    {
        return new EsperarHastaQue(this.elementos, estados);
    }

    public class EsperarHastaQue
    {
        private Target[] elementos;

        private EstadoElemento[] estados;

        private EsperarHastaQue(Target[] elements, EstadoElemento[] states)
        {
            this.elementos = elements;
            this.estados = states;
        }

        public EsperarHastaQueSea porNoMasDe(long tiempo)
        {
            return new EsperarHastaQueSea(this.elementos, this.estados, tiempo);
        }

        public class EsperarHastaQueSea
        {
            private Target[] elementos;
            private EstadoElemento[] estados;
            private long tiempo;

            private EsperarHastaQueSea(Target[] elements, EstadoElemento[] estados, long tiempo)
            {
                this.elementos = elements;
                this.estados = estados;
                this.tiempo = tiempo;
            }

            public EsperarPor segundos()
            {
                this.tiempo = this.tiempo * Esperar.A_SEGUNDOS;
                return EsperarPor.situation(this.elementos, this.estados, this.tiempo);
            }

            public EsperarPor minutos()
            {
                this.tiempo = this.tiempo * Esperar.A_MINUTOS;
                return EsperarPor.situation(this.elementos, this.estados, this.tiempo);
            }

            public EsperarPor milisegundos()
            {
                this.tiempo = this.tiempo * Esperar.A_MILISEGUNDOS;
                return EsperarPor.situation(this.elementos, this.estados, this.tiempo);
            }
        }
    }
}

class EsperarPor /*extends Thread*/ implements Interaction
{
    private Target[] elementos;
    private EstadoElemento[] estados;
    private long milisegundos;

    public EsperarPor(Target[] elementos, EstadoElemento[] estados, long milisegundos)
    {
        this.elementos = elementos;
        this.estados = estados;
        this.milisegundos = milisegundos;
    }

    public class ThreadWait extends Thread
    {
        private long milliseconds;
        private boolean detener;

        public ThreadWait(long milliseconds)
        {
            this.milliseconds = milliseconds;
        }

        @Override
        public void run()
        {
            this.detener = false;
            //System.err.println(new SimpleDateFormat("hh:mm:ss").format(new Date()))
            try {
                Thread.sleep(this.milliseconds);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //System.err.println(new SimpleDateFormat("hh:mm:ss").format(new Date()))
            this.detener = true;
        }

        public boolean isStop(){
            return this.detener;
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        Target element;
        List<Target> lstElements = Arrays.asList(this.elementos);
        List<Target> lstFinalElements = new ArrayList<>(lstElements);

        //this.start()
        ThreadWait thread = new ThreadWait(this.milisegundos);
        thread.start();

        while ( !lstFinalElements.isEmpty() && !thread.isStop())
        {
            //System.err.println(Arrays.toString(lstFinalElements.toArray()))
            element = lstFinalElements.get(0);
            boolean checked = true;
            for (   EstadoElemento state : this.estados)
            {
                if  (   !state.esCuando(actor,element) )
                {
                    checked = false;
                    break;
                }
            }
            lstFinalElements.remove(element);
            if(!checked){
                lstFinalElements.add(element);
            }
        }
    }

    public static EsperarPor situation(Target[] elementos, EstadoElemento[] estados, long milisegundos){
        return Tasks.instrumented(EsperarPor.class,elementos, estados, milisegundos);
    }
}
