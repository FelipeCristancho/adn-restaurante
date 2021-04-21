package com.ceiba.plato.adaptador.dao;

import com.ceiba.plato.modelo.dto.DtoPlato;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPlato implements RowMapper<DtoPlato>, MapperResult {

    @Override
    public DtoPlato mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("dish_Id");
        String nombre = rs.getString("dish_name");
        float precio = rs.getFloat("price");
        return new DtoPlato(id,nombre,precio);
    }
}
