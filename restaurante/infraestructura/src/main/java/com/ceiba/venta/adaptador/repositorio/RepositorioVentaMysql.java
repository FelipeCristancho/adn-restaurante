package com.ceiba.venta.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVentaMysql implements RepositorioVenta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "venta", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "venta", value = "cantidadCompras")
    private static String sqlCantidadCompras;

    @SqlStatement(namespace = "venta", value = "cantidadGastada")
    private static String sqlCantidadGastadas;

    @SqlStatement(namespace = "venta", value = "precio")
    private static String sqlPrecio;

    public RepositorioVentaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Venta venta) {
        return this.customNamedParameterJdbcTemplate.crear(venta,sqlCrear);
    }

    @Override
    public int retornarCantidadVentas(Long dni) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cliente", dni);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadCompras,parameterSource, Integer.class);
    }

    @Override
    public float retornarCantidadGastada(Long dni) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cliente", dni);
        if(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadGastadas,parameterSource, Float.class) != null)
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadGastadas,parameterSource, Float.class);
        return 0;
    }

    @Override
    public float retornarValorPlato(Long plato) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("plato", plato);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlPrecio,parameterSource, Float.class);
    }
}
