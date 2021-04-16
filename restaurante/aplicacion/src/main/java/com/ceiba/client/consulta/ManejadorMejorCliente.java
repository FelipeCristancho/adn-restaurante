package com.ceiba.client.consulta;

import com.ceiba.client.modelo.dto.DtoBestClient;
import com.ceiba.client.modelo.dto.DtoClient;
import com.ceiba.client.puerto.dao.DaoClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorMejorCliente {

    private final DaoClient daoClient;

    public ManejadorMejorCliente(DaoClient daoClient) {
        this.daoClient = daoClient;
    }

    public List<DtoBestClient> ejecutar(){return this.daoClient.MejorCliente();}
}
