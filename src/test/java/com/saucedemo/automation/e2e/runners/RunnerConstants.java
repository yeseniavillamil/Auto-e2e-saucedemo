package com.saucedemo.automation.e2e.runners;

public class RunnerConstants {

    private RunnerConstants(){
        throw new UnsupportedOperationException();
    }

    private final static String BASE = "com.saucedemo.automation.e2e";
    private final static String URL = "src/test/resources";

    public final static String PACKAGE_STEP_DEFINITIONS = BASE+".stepdefinitions";
    public final static String PACKAGE_DATA_DEFINITIONS = BASE+".datadefinitions";
    public final static String PACKAGE_SETUPS = BASE+".setups";

    public final static String PACKAGE_GLUE = RunnerConstants.PACKAGE_STEP_DEFINITIONS+","+RunnerConstants.PACKAGE_SETUPS;

    public final static String PACKAGE_FEATURES = "/features";
    public final static String PACKAGE_FEATURES_URL = URL+PACKAGE_FEATURES;

    public final static String PRETTY = "pretty";
    public final static String CAMELCASE = "camelcase";
    public final static String CUCUMBER_SERENITY_REPORTER_PARALLEL = "io.cucumber.core.plugin.SerenityReporterParallel";

}