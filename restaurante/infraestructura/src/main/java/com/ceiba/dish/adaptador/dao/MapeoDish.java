package com.ceiba.dish.adaptador.dao;

import com.ceiba.dish.modelo.dto.DtoDish;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDish implements RowMapper<DtoDish>, MapperResult {

    @Override
    public DtoDish mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long dishId = rs.getLong("dish_Id");
        String name = rs.getString("dish_name");
        float price = rs.getFloat("price");
        return new DtoDish(dishId,name,price);
    }
}
