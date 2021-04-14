package com.ceiba.client.consulta;

import com.ceiba.client.modelo.dto.DtoClient;
import com.ceiba.client.puerto.dao.DaoClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarClients {

    private final DaoClient daoClient;

    public ManejadorListarClients(DaoClient daoClient) {
        this.daoClient = daoClient;
    }

    public List<DtoClient> ejecutar(){return this.daoClient.listar();}
}
