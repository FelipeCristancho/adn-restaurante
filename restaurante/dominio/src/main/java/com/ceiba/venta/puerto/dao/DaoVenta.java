package com.ceiba.venta.puerto.dao;

import com.ceiba.venta.modelo.dto.DtoVenta;

import java.util.List;

public interface DaoVenta {

    List<DtoVenta> listar();
    List<DtoVenta> listarPorCliente(Long client);
}
