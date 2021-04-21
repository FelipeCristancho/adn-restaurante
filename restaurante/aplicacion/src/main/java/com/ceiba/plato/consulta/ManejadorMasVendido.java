package com.ceiba.plato.consulta;

import com.ceiba.plato.modelo.dto.DtoPlatoMasVendido;
import com.ceiba.plato.puerto.dao.DaoPlato;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorMasVendido {

    private final DaoPlato daoPlato;

    public ManejadorMasVendido(DaoPlato daoPlato) {
        this.daoPlato = daoPlato;
    }

    public List<DtoPlatoMasVendido> ejecutar(){
        return this.daoPlato.masVendido();
    }
}
