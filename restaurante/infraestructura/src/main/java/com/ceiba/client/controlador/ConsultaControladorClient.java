package com.ceiba.client.controlador;

import com.ceiba.client.consulta.ManejadorListarClients;
import com.ceiba.client.consulta.ManejadorMejorCliente;
import com.ceiba.client.modelo.dto.DtoBestClient;
import com.ceiba.client.modelo.dto.DtoClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
@Api(tags = {"Controlador para consulta de usuario"})
public class ConsultaControladorClient {

    private final ManejadorListarClients manejadorListClient;
    private final ManejadorMejorCliente manejadorMejorCliente;

    public ConsultaControladorClient(ManejadorListarClients manejadorListClient, ManejadorMejorCliente manejadorMejorCliente) {
        this.manejadorListClient = manejadorListClient;
        this.manejadorMejorCliente = manejadorMejorCliente;
    }

    @GetMapping
    @ApiOperation("Listar clientes")
    public List<DtoClient> listar(){
        return this.manejadorListClient.ejecutar();
    }

    @GetMapping(value = "/mejor")
    @ApiOperation("Muestra el cliente que mas ha comprado")
    public List<DtoBestClient> listarMejorCliente(){
        return this.manejadorMejorCliente.ejecutar();
    }
}
