package com.ceiba.sale.controlador;

import com.ceiba.sale.consulta.ManejadorListarSale;
import com.ceiba.sale.modelo.dto.DtoSale;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
@Api(tags = { "Controlador consulta inscripcion"})
public class ConsultaControladorSale {

    private final ManejadorListarSale manejadorListarSale;

    public ConsultaControladorSale(ManejadorListarSale manejadorListarSale) {
        this.manejadorListarSale = manejadorListarSale;
    }

    @GetMapping
    @ApiOperation("Listar todas las ventas")
    public List<DtoSale> listar(){return this.manejadorListarSale.ejecutar();}

    @GetMapping(value = "client/{client}")
    @ApiOperation("Listar ventas de un cliente en especifico")
    public List<DtoSale> listByClient(@PathVariable Long client){
        return this.manejadorListarSale.listarByClient(client);
    }
}
