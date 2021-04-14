package com.ceiba.dish.puerto.dao;

import com.ceiba.dish.modelo.dto.DtoDish;

import java.util.List;

public interface DaoDish {

    /*
     * Permite listar todos los platos
     * @return todos los platos
     */
    List<DtoDish> listar();
}
