package com.ceiba.plato.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.plato.modelo.dto.DtoPlato;
import com.ceiba.plato.modelo.entidad.Plato;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPlato implements RowMapper<Plato>, MapperResult {

    @Override
    public Plato mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("dish_Id");
        String nombre = rs.getString("dish_name");
        float precio = rs.getFloat("price");
        return new Plato(id,nombre,precio);
    }
}
