package com.saucedemo.automation.e2e.constants.enums.configuracion;

import lombok.Getter;

@Getter
public enum Esperas {

    GENERAL(20),

    //org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found in the current frame
    LOAD_PAGE(700),

    ;

    private final long tiempo;

    Esperas(long time){
        this.tiempo = time;
    }

}
