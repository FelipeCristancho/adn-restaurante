package com.ceiba.plato.consulta;

import com.ceiba.plato.modelo.dto.DtoPlato;
import com.ceiba.plato.puerto.dao.DaoPlato;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPlato {

    private final DaoPlato daoPlato;

    public ManejadorListarPlato(DaoPlato daoPlato) {
        this.daoPlato = daoPlato;
    }

    public List<DtoPlato> ejecutar(){return this.daoPlato.listar();}
}
