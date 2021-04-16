package com.ceiba.dish.adaptador.repositorio;

import com.ceiba.dish.puerto.repositorio.RepositorioDish;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDishMysql implements RepositorioDish {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "dish", value = "precio")
    private static String sqlPrecio;

    public RepositorioDishMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public float retornarPrecio(Long dish) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("dish", dish);
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlPrecio,parameterSource, Float.class);
    }
}
