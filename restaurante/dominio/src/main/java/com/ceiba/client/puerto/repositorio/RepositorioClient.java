package com.ceiba.client.puerto.repositorio;

import com.ceiba.client.modelo.entidad.Client;

public interface RepositorioClient {

    Long crear(Client client);

    boolean existe(Long dni);
}
