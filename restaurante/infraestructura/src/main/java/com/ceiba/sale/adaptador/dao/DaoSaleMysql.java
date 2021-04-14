package com.ceiba.sale.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.sale.modelo.dto.DtoSale;
import com.ceiba.sale.puerto.dao.DaoSale;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoSaleMysql implements DaoSale {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "sale", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "sale", value = "listarByClient")
    private static String sqlListarByClient;

    public DaoSaleMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoSale> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoSale());
    }

    @Override
    public List<DtoSale> listarByClient(Long client) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("client", client);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarByClient, parameterSource, new MapeoSale());
    }
}
