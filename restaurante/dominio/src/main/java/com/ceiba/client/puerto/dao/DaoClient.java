package com.ceiba.client.puerto.dao;

import com.ceiba.client.modelo.dto.DtoClient;

import java.util.List;

public interface DaoClient {

    /*
     * Permite listar clientes
     * @return los clientes
     */
    List<DtoClient> listar();
}
