package com.ceiba.dish.controlador;

import com.ceiba.dish.consulta.ManejadorListarDish;
import com.ceiba.dish.modelo.dto.DtoDish;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dish")
@Api(tags = {"Controlador consulta de platos"})
public class ConsultaControladorDish {

    private final ManejadorListarDish manejadorListarDish;

    public ConsultaControladorDish(ManejadorListarDish manejadorListarDish) {
        this.manejadorListarDish = manejadorListarDish;
    }

    @GetMapping
    @ApiOperation("Listar platos")
    public List<DtoDish> listar(){
        return this.manejadorListarDish.ejecutar();
    }
}
