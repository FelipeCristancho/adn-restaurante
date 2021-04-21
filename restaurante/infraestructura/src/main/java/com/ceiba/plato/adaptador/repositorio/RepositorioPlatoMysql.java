package com.ceiba.plato.adaptador.repositorio;

import com.ceiba.plato.puerto.repositorio.RepositorioPlato;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPlatoMysql implements RepositorioPlato {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "plato", value = "precio")
    private static String sqlPrecio;

    public RepositorioPlatoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public float retornarPrecio(Long dish) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("dish", dish);
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlPrecio,parameterSource, Float.class);
    }
}