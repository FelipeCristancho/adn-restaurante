package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoMejorCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoMejorCliente implements RowMapper<DtoMejorCliente>, MapperResult {

    @Override
    public DtoMejorCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long dni = rs.getLong("dni");
        String nombre = rs.getString("name");
        String apellido = rs.getString("last_name");
        String telefono = rs.getString("telephone");
        Integer compras = rs.getInt("purchases");
        return new DtoMejorCliente(id,dni,nombre,apellido,telefono, compras);
    }
}
