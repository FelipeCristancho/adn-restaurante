package com.ceiba.sale.consulta;

import com.ceiba.sale.modelo.dto.DtoSale;
import com.ceiba.sale.puerto.dao.DaoSale;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSale {

    private final DaoSale daoSale;

    public ManejadorListarSale(DaoSale daoSale) {
        this.daoSale = daoSale;
    }

    public List<DtoSale> ejecutar(){
        return this.daoSale.listar();
    }

    public List<DtoSale> listarByClient(Long id){
        return this.daoSale.listarByClient(id);
    }
}
