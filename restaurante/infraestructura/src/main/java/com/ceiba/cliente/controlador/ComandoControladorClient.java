package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
@Api(tags = {"Controlador para consulta de usuario"})
public class ComandoControladorClient {

    private final ManejadorCrearCliente manejadorCrearCliente;

    @Autowired
    public ComandoControladorClient(ManejadorCrearCliente manejadorCrearCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
    }

    @PostMapping
    @ApiOperation("Crear un cliente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente){
        return manejadorCrearCliente.ejecutar(comandoCliente);
    }
}
