package com.ceiba.client.adaptador.dao;

import com.ceiba.client.modelo.dto.DtoClient;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoClient implements RowMapper<DtoClient>, MapperResult {

    @Override
    public DtoClient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long dni = rs.getLong("dni");
        String name = rs.getString("name");
        String lastName = rs.getString("last_name");
        String telephone = rs.getString("telephone");
        return new DtoClient(id,dni,name, lastName, telephone);
    }
}
