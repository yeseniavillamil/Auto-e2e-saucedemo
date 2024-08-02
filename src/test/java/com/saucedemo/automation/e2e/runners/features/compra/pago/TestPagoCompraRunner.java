
package com.saucedemo.automation.e2e.runners.features.compra.pago;

import com.saucedemo.automation.e2e.runners.RunnerConstants;
import com.saucedemo.automation.e2e.runners.javadoc.RunnersJavaDoc;
import com.saucedemo.automation.e2e.utils.GeneralUtil;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;


/**
 * Para mas informacion:
 * @see RunnersJavaDoc#CLASE
 */

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource(RunnerConstants.PACKAGE_FEATURES+ TestPagoCompraRunner.FEATURE_FILE+".feature")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = RunnerConstants.CAMELCASE)
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = RunnerConstants.PACKAGE_GLUE)
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = RunnerConstants.PRETTY
                +","+RunnerConstants.CUCUMBER_SERENITY_REPORTER_PARALLEL)
public class TestPagoCompraRunner
{
    static final String FEATURE_DIR = "/compra";
    static final String FEATURE_FILE = FEATURE_DIR+"/pago";

    /**
     * Para mas informacion:
     * @see RunnersJavaDoc#CONSTRUCTOR
     */
    private TestPagoCompraRunner()
    {
        GeneralUtil.noPermitaInstanciar();
    }
}