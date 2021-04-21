package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    Long crear(Cliente cliente);

    boolean existe(Long dni);
}
