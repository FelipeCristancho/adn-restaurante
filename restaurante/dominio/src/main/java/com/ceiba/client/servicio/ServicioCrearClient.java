package com.ceiba.client.servicio;

import com.ceiba.client.modelo.entidad.Client;
import com.ceiba.client.puerto.repositorio.RepositorioClient;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearClient {

    private static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema";
    private final RepositorioClient repositorioClient;

    public ServicioCrearClient(RepositorioClient repositorioClient) {
        this.repositorioClient = repositorioClient;
    }

    public Long ejecutar(Client client){
        validarExistenciaPrevia(client);
        return this.repositorioClient.crear(client);
    }

    private void validarExistenciaPrevia(Client client){
        boolean existe = this.repositorioClient.existe(client.getDni());
        if(existe){
            throw new ExcepcionDuplicidad(EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
