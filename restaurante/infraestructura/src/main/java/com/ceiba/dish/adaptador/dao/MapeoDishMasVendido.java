package com.ceiba.dish.adaptador.dao;

import com.ceiba.dish.modelo.dto.DtoDish;
import com.ceiba.dish.modelo.dto.DtoDishMasVendido;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDishMasVendido implements RowMapper<DtoDishMasVendido>, MapperResult {

    @Override
    public DtoDishMasVendido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long dishId = rs.getLong("dish_Id");
        String name = rs.getString("dish_name");
        float price = rs.getFloat("price");
        Integer sales = rs.getInt("sales");
        return new DtoDishMasVendido(dishId,name,price,sales);
    }
}
