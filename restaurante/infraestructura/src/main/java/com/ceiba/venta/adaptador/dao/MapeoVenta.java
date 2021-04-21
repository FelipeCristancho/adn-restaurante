package com.ceiba.venta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.venta.modelo.dto.DtoVenta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoVenta implements RowMapper<DtoVenta>, MapperResult {

    @Override
    public DtoVenta mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        LocalDate fecha = extraerLocalDate(rs,"sale_date");
        String cliente = rs.getString("client");
        String plato = rs.getString("dish");
        Float precio = rs.getFloat("price");
        boolean promocion = rs.getBoolean("promotion");
        return new DtoVenta(id,fecha,plato,precio,cliente, promocion);
    }
}
