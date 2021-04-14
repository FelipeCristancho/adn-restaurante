package com.ceiba.sale.puerto.dao;

import com.ceiba.sale.modelo.dto.DtoSale;

import java.util.List;

public interface DaoSale {

    List<DtoSale> listar();
    List<DtoSale> listarByClient(Long client);
}
