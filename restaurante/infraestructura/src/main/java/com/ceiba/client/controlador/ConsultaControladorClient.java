package com.ceiba.client.controlador;

import com.ceiba.client.consulta.ManejadorListarClients;
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

    public ConsultaControladorClient(ManejadorListarClients manejadorListClient) {
        this.manejadorListClient = manejadorListClient;
    }

    @GetMapping
    @ApiOperation("Listar clientes")
    public List<DtoClient> listar(){
        return this.manejadorListClient.ejecutar();
    }
}
