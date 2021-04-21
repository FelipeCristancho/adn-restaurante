package com.ceiba.plato.adaptador.dao;

import com.ceiba.plato.modelo.dto.DtoPlatoMasVendido;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPlatoMasVendido implements RowMapper<DtoPlatoMasVendido>, MapperResult {

    @Override
    public DtoPlatoMasVendido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("dish_Id");
        String nombre = rs.getString("dish_name");
        float precio = rs.getFloat("price");
        Integer ventas = rs.getInt("sales");
        return new DtoPlatoMasVendido(id,nombre,precio,ventas);
    }
}
