package com.ceiba.dish.consulta;

import com.ceiba.dish.modelo.dto.DtoDish;
import com.ceiba.dish.puerto.dao.DaoDish;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDish {

    private final DaoDish daoDish;

    public ManejadorListarDish(DaoDish daoDish) {
        this.daoDish = daoDish;
    }

    public List<DtoDish> ejecutar(){return this.daoDish.listar();}
}
