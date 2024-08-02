package com.saucedemo.automation.e2e.utils.tiempo.utils;

import com.saucedemo.automation.e2e.utils.javadoc.JavaDocUtil;
import com.saucedemo.automation.e2e.utils.tiempo.constants.enums.UnidadTiempo;
import com.saucedemo.automation.e2e.utils.GeneralUtil;

/**
 * {{Plantilla para la creacion de clases utilitarias}}
 */
public class EsperaUtil
{

    /**
     * Para mas informacion:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private EsperaUtil(){
        GeneralUtil.noPermitaInstanciar();
    }

    public static void detenerPor(long tiempo, UnidadTiempo unidad){

        tiempo = tiempo * unidad.getEscalaMilisegundos();

        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
