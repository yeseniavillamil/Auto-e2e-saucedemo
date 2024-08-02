package com.saucedemo.automation.e2e.setups.datadefinitions;

import com.saucedemo.automation.e2e.models.scena.Libreto;
import com.saucedemo.automation.e2e.models.scena.screenplay.Protagonista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;

import java.util.HashMap;
import java.util.Map;

public class LibretoDataDefinition {

    @DataTableType()
    public Libreto noteBook(DataTable table)
    {
        for (Map<String, String> tblGherkinInput : table.entries())
        {
            Map<String, String> tblGherkin = new HashMap<>(tblGherkinInput);
            Protagonista.principal().ensayarLibreto(tblGherkin);
        }

        return Protagonista.principal().getLibreto();
    }

}
