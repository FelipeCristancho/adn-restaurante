package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoMejorCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorMejorCliente {

    private final DaoCliente daoCliente;

    public ManejadorMejorCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public List<DtoMejorCliente> ejecutar(){return this.daoCliente.MejorCliente();}
}
