package com.ceiba.client.adaptador.dao;

import com.ceiba.client.modelo.dto.DtoBestClient;
import com.ceiba.client.modelo.dto.DtoClient;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoMejorCliente implements RowMapper<DtoBestClient>, MapperResult {

    @Override
    public DtoBestClient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long dni = rs.getLong("dni");
        String name = rs.getString("name");
        String lastName = rs.getString("last_name");
        String telephone = rs.getString("telephone");
        Integer compras = rs.getInt("purchases");
        return new DtoBestClient(id,dni,name, lastName, telephone, compras);
    }
}
