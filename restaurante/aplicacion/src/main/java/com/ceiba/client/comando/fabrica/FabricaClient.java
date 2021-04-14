package com.ceiba.client.comando.fabrica;

import com.ceiba.client.comando.ComandoClient;
import com.ceiba.client.modelo.entidad.Client;
import org.springframework.stereotype.Component;

@Component
public class FabricaClient {
    public Client crear(ComandoClient comandoClient){
        return new Client(
                comandoClient.getId(),
                comandoClient.getDni(),
                comandoClient.getName(),
                comandoClient.getLast_name(),
                comandoClient.getTelephone()
        );
    }
}
