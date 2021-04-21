package com.ceiba.venta.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.venta.comando.ComandoVenta;
import com.ceiba.venta.comando.manejador.ManejadorCrearSale;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
@Api(tags = { "Controlador comando inscripcion"})
public class ComandoControladorSale {

    private final ManejadorCrearSale manejadorCrearSale;

    public ComandoControladorSale(ManejadorCrearSale manejadorCrearSale) {
        this.manejadorCrearSale = manejadorCrearSale;
    }

    @PostMapping
    @ApiOperation("Crear venta")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoVenta comandoVenta){
        return this.manejadorCrearSale.ejecutar(comandoVenta);
    }
}
