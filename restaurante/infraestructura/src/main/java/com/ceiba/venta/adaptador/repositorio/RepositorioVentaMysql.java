package com.ceiba.venta.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.venta.modelo.dto.DtoCrearVenta;
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
        DtoCrearVenta dtoCrearVenta = new DtoCrearVenta(venta.getId(), venta.getFecha(),venta.getPlato().getId(),venta.getCliente().getDni(),venta.isPromocion());
        return this.customNamedParameterJdbcTemplate.crear(dtoCrearVenta,sqlCrear);
    }

    @Override
    public int obtenerCantidadVentas(Long dni) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cliente", dni);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadCompras,parameterSource, Integer.class);
    }

    @Override
    public float obtenerCantidadGastada(Long dni) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cliente", dni);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadGastadas,parameterSource, Float.class);
    }

}
