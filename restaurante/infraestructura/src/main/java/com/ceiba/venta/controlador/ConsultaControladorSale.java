package com.ceiba.venta.controlador;

import com.ceiba.venta.consulta.ManejadorListarVenta;
import com.ceiba.venta.modelo.dto.DtoVenta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@Api(tags = { "Controlador consulta inscripcion"})
public class ConsultaControladorSale {

    private final ManejadorListarVenta manejadorListarVenta;

    public ConsultaControladorSale(ManejadorListarVenta manejadorListarVenta) {
        this.manejadorListarVenta = manejadorListarVenta;
    }

    @GetMapping
    @ApiOperation("Listar todas las ventas")
    public List<DtoVenta> listar(){return this.manejadorListarVenta.ejecutar();}

    @GetMapping(value = "cliente/{cliente}")
    @ApiOperation("Listar ventas de un cliente en especifico")
    public List<DtoVenta> listByClient(@PathVariable Long cliente){
        return this.manejadorListarVenta.listarByClient(cliente);
    }
}
