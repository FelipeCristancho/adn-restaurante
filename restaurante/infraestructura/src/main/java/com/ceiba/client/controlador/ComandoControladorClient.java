package com.ceiba.client.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.client.comando.ComandoClient;
import com.ceiba.client.comando.manejador.ManejadorCrearClient;
import com.ceiba.client.modelo.dto.DtoClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
@Api(tags = {"Controlador para consulta de usuario"})
public class ComandoControladorClient {

    private final ManejadorCrearClient manejadorCrearClient;

    @Autowired
    public ComandoControladorClient(ManejadorCrearClient manejadorCrearClient) {
        this.manejadorCrearClient = manejadorCrearClient;
    }

    @PostMapping
    @ApiOperation("Crear un cliente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoClient comandoClient){
        return manejadorCrearClient.ejecutar(comandoClient);
    }
}
