package com.ceiba.sale.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.sale.comando.ComandoSale;
import com.ceiba.sale.comando.manejador.ManejadorCrearSale;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
@Api(tags = { "Controlador comando inscripcion"})
public class ComandoControladorSale {

    private final ManejadorCrearSale manejadorCrearSale;

    public ComandoControladorSale(ManejadorCrearSale manejadorCrearSale) {
        this.manejadorCrearSale = manejadorCrearSale;
    }

    @PostMapping
    @ApiOperation("Crear venta")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSale comandoSale){
        return this.manejadorCrearSale.ejecutar(comandoSale);
    }
}
