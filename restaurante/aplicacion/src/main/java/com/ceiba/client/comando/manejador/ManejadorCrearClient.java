package com.ceiba.client.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.client.comando.ComandoClient;
import com.ceiba.client.comando.fabrica.FabricaClient;
import com.ceiba.client.modelo.entidad.Client;
import com.ceiba.client.servicio.ServicioCrearClient;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearClient {

    private final FabricaClient fabricaClient;
    private final ServicioCrearClient servicioCrearClient;

    public ManejadorCrearClient(FabricaClient fabricaClient, ServicioCrearClient servicioCrearClient) {
        this.fabricaClient = fabricaClient;
        this.servicioCrearClient = servicioCrearClient;
    }


    public ComandoRespuesta<Long> ejecutar(ComandoClient comando) {
        Client client = fabricaClient.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearClient.ejecutar(client));
    }
}
