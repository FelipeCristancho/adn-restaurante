package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

    @Override
    public DtoCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long dni = rs.getLong("dni");
        String nombre = rs.getString("name");
        String apellido = rs.getString("last_name");
        String telefono = rs.getString("telephone");
        return new DtoCliente(id,dni,nombre,apellido,telefono);
    }
}
