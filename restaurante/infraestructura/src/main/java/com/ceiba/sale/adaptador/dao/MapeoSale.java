package com.ceiba.sale.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.sale.modelo.dto.DtoSale;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoSale implements RowMapper<DtoSale>, MapperResult {

    @Override
    public DtoSale mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        LocalDate saleDate = extraerLocalDate(rs,"sale_date");
        String client = rs.getString("client");
        String dish = rs.getString("dish");
        return new DtoSale(id,saleDate,dish,client);
    }
}
