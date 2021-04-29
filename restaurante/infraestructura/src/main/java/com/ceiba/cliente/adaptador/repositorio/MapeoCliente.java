package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.plato.modelo.entidad.Plato;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements RowMapper<Cliente>, MapperResult {

    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        long dni = rs.getLong("dni");
        String nombre = rs.getString("name");
        String apellido = rs.getString("last_name");
        String telefono = rs.getString("telephone");
        return new Cliente(id,dni,nombre,apellido,telefono);
    }
}
