package com.ceiba.plato.controlador;


import com.ceiba.plato.consulta.ManejadorListarPlato;
import com.ceiba.plato.consulta.ManejadorMasVendido;
import com.ceiba.plato.modelo.dto.DtoPlato;
import com.ceiba.plato.modelo.dto.DtoPlatoMasVendido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/platos")
@Api(tags = {"Controlador consulta de platos"})
public class ConsultaControladorDish {

    private final ManejadorListarPlato manejadorListarPlato;
    private final ManejadorMasVendido manejadorMasVendido;

    public ConsultaControladorDish(ManejadorListarPlato manejadorListarPlato, ManejadorMasVendido manejadorMasVendido) {
        this.manejadorListarPlato = manejadorListarPlato;
        this.manejadorMasVendido = manejadorMasVendido;
    }

    @GetMapping
    @ApiOperation("Listar platos")
    public List<DtoPlato> listar(){
        return this.manejadorListarPlato.ejecutar();
    }

    @GetMapping(value = "/mejor")
    @ApiOperation("Muestra el cliente que mas ha comprado")
    public List<DtoPlatoMasVendido> listarMejorPlato(){
        return this.manejadorMasVendido.ejecutar();
    }
}
