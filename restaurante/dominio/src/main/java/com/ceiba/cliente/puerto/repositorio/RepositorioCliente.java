package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.plato.modelo.entidad.Plato;

public interface RepositorioCliente {

    Long crear(Cliente cliente);

    boolean existe(Long dni);

    Cliente buscarClientePorId(long dni);
}
