package com.ceiba.plato.puerto.repositorio;

import com.ceiba.plato.modelo.entidad.Plato;

public interface RepositorioPlato {

    /*
     *retorna el precio de un plato específico
     */
    float obtenerPrecio(Long id);

    Plato buscarPlatoPorId(long id);
}
