package com.saucedemo.automation.e2e.constants.enums.configuracion.serenity;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public enum SerenityConf {

    URL_APP("webdriver.base.url.app"),
    ;

    private final String property;

    private static EnvironmentVariables properties = SystemEnvironmentVariables.createEnvironmentVariables();

    private static EnvironmentSpecificConfiguration setupFile = EnvironmentSpecificConfiguration.from(properties);

    SerenityConf(String property)
    {
        this.property = property;
    }

    public String getProperty()
    {
        return this.property;
    }

    public String getValue()
    {
        return setupFile.getProperty(this.getProperty());
    }
}
