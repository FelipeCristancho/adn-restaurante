package com.ceiba.dish.consulta;

import com.ceiba.dish.modelo.dto.DtoDishMasVendido;
import com.ceiba.dish.puerto.dao.DaoDish;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorMasVendido {

    private final DaoDish daoDish;

    public ManejadorMasVendido(DaoDish daoDish) {
        this.daoDish = daoDish;
    }

    public List<DtoDishMasVendido> ejecutar(){
        return this.daoDish.masVendido();
    }
}
