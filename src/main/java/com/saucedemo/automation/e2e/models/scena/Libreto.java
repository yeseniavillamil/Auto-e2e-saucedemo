package com.saucedemo.automation.e2e.models.scena;



import com.saucedemo.automation.e2e.models.params.PlantillaParams;
import com.saucedemo.automation.e2e.models.params.features.catalogo.producto.ProductoCatalogoParams;
import com.saucedemo.automation.e2e.models.params.features.catalogo.producto.ProductosCatalogoParams;
import com.saucedemo.automation.e2e.models.params.features.compra.comprador.CompradorParams;
import com.saucedemo.automation.e2e.models.params.features.cuenta.acceso.AccesoParams;
import lombok.Data;

@Data
public class Libreto {

    private PlantillaParams parametrosPlantilla;

    private AccesoParams parametrosAcceso;

    private ProductoCatalogoParams parametrosProductoCatalogo;

    private ProductosCatalogoParams parametrosProductosCatalogo;

    private CompradorParams parametrosComprador;




}

