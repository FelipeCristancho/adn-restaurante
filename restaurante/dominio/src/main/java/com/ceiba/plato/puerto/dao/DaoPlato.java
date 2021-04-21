package com.ceiba.plato.puerto.dao;

import com.ceiba.plato.modelo.dto.DtoPlato;
import com.ceiba.plato.modelo.dto.DtoPlatoMasVendido;

import java.util.List;

public interface DaoPlato {

    /*
     * Permite listar todos los platos
     * @return todos los platos
     */
    List<DtoPlato> listar();
    List<DtoPlatoMasVendido> masVendido();
}
