package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorListarCliente;
import com.ceiba.cliente.consulta.ManejadorMejorCliente;
import com.ceiba.cliente.modelo.dto.DtoMejorCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
@Api(tags = {"Controlador para consulta de usuario"})
public class ConsultaControladorClient {

    private final ManejadorListarCliente manejadorListClient;
    private final ManejadorMejorCliente manejadorMejorCliente;

    public ConsultaControladorClient(ManejadorListarCliente manejadorListClient, ManejadorMejorCliente manejadorMejorCliente) {
        this.manejadorListClient = manejadorListClient;
        this.manejadorMejorCliente = manejadorMejorCliente;
    }

    @GetMapping
    @ApiOperation("Listar clientes")
    public List<DtoCliente> listar(){
        return this.manejadorListClient.ejecutar();
    }

    @GetMapping(value = "/mejor")
    @ApiOperation("Muestra el cliente que mas ha comprado")
    public List<DtoMejorCliente> listarMejorCliente(){
        return this.manejadorMejorCliente.ejecutar();
    }
}
