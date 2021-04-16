package com.ceiba.sale.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.sale.modelo.entidad.Sale;
import com.ceiba.sale.puerto.repositorio.RepositorioSale;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSaleMysql implements RepositorioSale {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "sale", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "sale", value = "cantidadCompras")
    private static String sqlCantidadCompras;

    @SqlStatement(namespace = "sale", value = "cantidadGastada")
    private static String sqlCantidadGastadas;

    @SqlStatement(namespace = "sale", value = "precio")
    private static String sqlPrecio;

    public RepositorioSaleMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Sale sale) {
        return this.customNamedParameterJdbcTemplate.crear(sale,sqlCrear);
    }

    @Override
    public int retornarCantidadVentas(Long dni) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("client", dni);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadCompras,parameterSource, Integer.class);
    }

    @Override
    public float retornarCantidadGastada(Long dni) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("client", dni);
        if(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadGastadas,parameterSource, Float.class) != null)
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadGastadas,parameterSource, Float.class);
        return 0;
    }

    @Override
    public float retornarValorPlato(Long dish) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("dish", dish);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlPrecio,parameterSource, Float.class);
    }
}
